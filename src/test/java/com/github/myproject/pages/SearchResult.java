/*
 * Copyright 2018 Sergey Mishanin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.myproject.pages;

import com.github.mishaninss.html.containers.IndexedContainer;
import com.github.mishaninss.html.containers.annotations.Container;
import com.github.mishaninss.html.containers.annotations.ContextualContainer;
import com.github.mishaninss.html.containers.annotations.ContextualElement;
import com.github.mishaninss.html.containers.annotations.Element;
import com.github.mishaninss.html.elements.*;

@ContextualContainer({
        @Container("//div[@data-hotelid]"),
        @Container(byClass = "hotel-newlist__wrapper", val = "tablet")
})
public class SearchResult extends IndexedContainer<SearchResult>{

    @Element(".//img[@class='hotel_image']")
    public Image hotelImage;

    @ContextualElement({
            @Element(".//span[contains(@class,'sr-hotel__name')]"),
            @Element(byXpath = ".//div[contains(@class, 'card_body')]//a[contains(@class, 'hotel_name_link')]", val = "tablet")
    })
    public Link hotelName;

    @Element(".//div[@class='hotel_desc']")
    public Select hotelDescription;

}
