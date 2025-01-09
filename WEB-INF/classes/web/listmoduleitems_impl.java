package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class listmoduleitems_impl extends GXDataArea
{
   public listmoduleitems_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public listmoduleitems_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( listmoduleitems_impl.class ));
   }

   public listmoduleitems_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      try
      {
         AV10ModuleDescription = (String) args[0];
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      nGotPars = 1 ;
      webExecute();
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "ModuleDescription") ;
         gxfirstwebparm_bkp = gxfirstwebparm ;
         gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            dyncall( httpContext.GetNextPar( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "ModuleDescription") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "ModuleDescription") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridmenuitems") == 0 )
         {
            gxnrgridmenuitems_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridmenuitems") == 0 )
         {
            gxgrgridmenuitems_refresh_invoke( ) ;
            return  ;
         }
         else
         {
            if ( ! httpContext.IsValidAjaxCall( false) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = gxfirstwebparm_bkp ;
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridmenuitems_newrow_invoke( )
   {
      nRC_GXsfl_9 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_9"))) ;
      nGXsfl_9_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_9_idx"))) ;
      sGXsfl_9_idx = httpContext.GetPar( "sGXsfl_9_idx") ;
      edtavMenuitemsdescription_Class = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMenuitemsdescription_Internalname, "Class", edtavMenuitemsdescription_Class, !bGXsfl_9_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridmenuitems_newrow( ) ;
      /* End function gxnrGridmenuitems_newrow_invoke */
   }

   public void gxgrgridmenuitems_refresh_invoke( )
   {
      edtavMenuitemsdescription_Class = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMenuitemsdescription_Internalname, "Class", edtavMenuitemsdescription_Class, !bGXsfl_9_Refreshing);
      AV19Pgmname = httpContext.GetPar( "Pgmname") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV8MenuItems);
      AV10ModuleDescription = httpContext.GetPar( "ModuleDescription") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridmenuitems_refresh( AV19Pgmname, AV8MenuItems, AV10ModuleDescription) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridmenuitems_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public byte executeStartEvent( )
   {
      pa0X2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start0X2( ) ;
      }
      return gxajaxcallmode ;
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      if ( nGXWrapped != 1 )
      {
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         GXEncryptionTmp = "web.listmoduleitems"+GXutil.URLEncode(GXutil.rtrim(AV10ModuleDescription)) ;
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.listmoduleitems") + "?" + com.genexus.util.Encryption.uriencrypt64( GXEncryptionTmp+com.genexus.util.Encryption.checksum( GXEncryptionTmp, 6), GXKey)+"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV19Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUITEMS", getSecureSignedToken( "", AV8MenuItems));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODULEDESCRIPTION", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10ModuleDescription, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_9", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_9, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV19Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV19Pgmname, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMENUITEMS", AV8MenuItems);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMENUITEMS", AV8MenuItems);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUITEMS", getSecureSignedToken( "", AV8MenuItems));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODULEDESCRIPTION", GXutil.rtrim( AV10ModuleDescription));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODULEDESCRIPTION", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10ModuleDescription, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUITEMSDESCRIPTION_Class", GXutil.rtrim( edtavMenuitemsdescription_Class));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we0X2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt0X2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      GXEncryptionTmp = "web.listmoduleitems"+GXutil.URLEncode(GXutil.rtrim(AV10ModuleDescription)) ;
      return formatLink("web.listmoduleitems") + "?" + com.genexus.util.Encryption.uriencrypt64( GXEncryptionTmp+com.genexus.util.Encryption.checksum( GXEncryptionTmp, 6), GXKey) ;
   }

   public String getPgmname( )
   {
      return "ListModuleItems" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "List Module Items", "") ;
   }

   public void wb0X0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, lblTextblock1_Caption, "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP ML10", 0, "", lblTextblock1_Visible, 1, 0, (short)(0), "HLP_ListModuleItems.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridmenuitemsContainer.SetIsFreestyle(true);
         GridmenuitemsContainer.SetWrapped(nGXWrapped);
         startgridcontrol9( ) ;
      }
      if ( wbEnd == 9 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_9 = (int)(nGXsfl_9_idx-1) ;
         if ( GridmenuitemsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridmenuitemsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridmenuitems", GridmenuitemsContainer, subGridmenuitems_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridmenuitemsContainerData", GridmenuitemsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridmenuitemsContainerData"+"V", GridmenuitemsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridmenuitemsContainerData"+"V"+"\" value='"+GridmenuitemsContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 9 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridmenuitemsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridmenuitemsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridmenuitems", GridmenuitemsContainer, subGridmenuitems_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridmenuitemsContainerData", GridmenuitemsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridmenuitemsContainerData"+"V", GridmenuitemsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridmenuitemsContainerData"+"V"+"\" value='"+GridmenuitemsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start0X2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "List Module Items", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0X0( ) ;
   }

   public void ws0X2( )
   {
      start0X2( ) ;
      evt0X2( ) ;
   }

   public void evt0X2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "M") != 0 )
               {
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 18), "GRIDMENUITEMS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_9_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_92( ) ;
                           AV5ImageMenuItemIcon = httpContext.cgiGet( edtavImagemenuitemicon_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavImagemenuitemicon_Internalname, "Bitmap", ((GXutil.strcmp("", AV5ImageMenuItemIcon)==0) ? AV24Imagemenuitemicon_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV5ImageMenuItemIcon))), !bGXsfl_9_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavImagemenuitemicon_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV5ImageMenuItemIcon), true);
                           AV9MenuItemsDescription = httpContext.cgiGet( edtavMenuitemsdescription_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavMenuitemsdescription_Internalname, AV9MenuItemsDescription);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e110X2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDMENUITEMS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e120X2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we0X2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa0X2( )
   {
      if ( nDonePA == 0 )
      {
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
         }
         if ( ( GXutil.strcmp(httpContext.getQueryString( ), "") != 0 ) && ( GxWebError == 0 ) && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            GXDecQS = com.genexus.util.Encryption.uridecrypt64( httpContext.getQueryString( ), GXKey) ;
            if ( ( GXutil.strcmp(GXutil.right( GXDecQS, 6), com.genexus.util.Encryption.checksum( GXutil.left( GXDecQS, GXutil.len( GXDecQS)-6), 6)) == 0 ) && ( GXutil.strcmp(GXutil.substring( GXDecQS, 1, GXutil.len( "web.listmoduleitems")), "web.listmoduleitems") == 0 ) )
            {
               httpContext.setQueryString( GXutil.right( GXutil.left( GXDecQS, GXutil.len( GXDecQS)-6), GXutil.len( GXutil.left( GXDecQS, GXutil.len( GXDecQS)-6))-GXutil.len( "web.listmoduleitems"))) ;
            }
            else
            {
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
            }
         }
         if ( ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            if ( nGotPars == 0 )
            {
               entryPointCalled = false ;
               gxfirstwebparm = httpContext.GetFirstPar( "ModuleDescription") ;
               toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.disableJsOutput();
               }
               if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
               {
                  AV10ModuleDescription = gxfirstwebparm ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV10ModuleDescription", AV10ModuleDescription);
                  web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODULEDESCRIPTION", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10ModuleDescription, ""))));
               }
               if ( toggleJsOutput )
               {
                  if ( httpContext.isSpaRequest( ) )
                  {
                     httpContext.enableJsOutput();
                  }
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridmenuitems_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_92( ) ;
      while ( nGXsfl_9_idx <= nRC_GXsfl_9 )
      {
         sendrow_92( ) ;
         nGXsfl_9_idx = ((subGridmenuitems_Islastpage==1)&&(nGXsfl_9_idx+1>subgridmenuitems_fnc_recordsperpage( )) ? 1 : nGXsfl_9_idx+1) ;
         sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_92( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridmenuitemsContainer)) ;
      /* End function gxnrGridmenuitems_newrow */
   }

   public void gxgrgridmenuitems_refresh( String AV19Pgmname ,
                                          GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem> AV8MenuItems ,
                                          String AV10ModuleDescription )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDMENUITEMS_nCurrentRecord = 0 ;
      rf0X2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridmenuitems_refresh */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf0X2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV19Pgmname = "ListModuleItems" ;
      Gx_err = (short)(0) ;
   }

   public void rf0X2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridmenuitemsContainer.ClearRows();
      }
      wbStart = (short)(9) ;
      nGXsfl_9_idx = 1 ;
      sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_92( ) ;
      bGXsfl_9_Refreshing = true ;
      GridmenuitemsContainer.AddObjectProperty("GridName", "Gridmenuitems");
      GridmenuitemsContainer.AddObjectProperty("CmpContext", "");
      GridmenuitemsContainer.AddObjectProperty("InMasterPage", "false");
      GridmenuitemsContainer.AddObjectProperty("Class", GXutil.rtrim( "MT25"));
      GridmenuitemsContainer.AddObjectProperty("Class", "MT25");
      GridmenuitemsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridmenuitemsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridmenuitemsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridmenuitems_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridmenuitemsContainer.setPageSize( subgridmenuitems_fnc_recordsperpage( ) );
      if ( subGridmenuitems_Islastpage != 0 )
      {
         GRIDMENUITEMS_nFirstRecordOnPage = (long)(subgridmenuitems_fnc_recordcount( )-subgridmenuitems_fnc_recordsperpage( )) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRIDMENUITEMS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDMENUITEMS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         GridmenuitemsContainer.AddObjectProperty("GRIDMENUITEMS_nFirstRecordOnPage", GRIDMENUITEMS_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_92( ) ;
         e120X2 ();
         wbEnd = (short)(9) ;
         wb0X0( ) ;
      }
      bGXsfl_9_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes0X2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV19Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV19Pgmname, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMENUITEMS", AV8MenuItems);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMENUITEMS", AV8MenuItems);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUITEMS", getSecureSignedToken( "", AV8MenuItems));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODULEDESCRIPTION", GXutil.rtrim( AV10ModuleDescription));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODULEDESCRIPTION", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10ModuleDescription, ""))));
   }

   public int subgridmenuitems_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridmenuitems_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridmenuitems_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridmenuitems_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      AV19Pgmname = "ListModuleItems" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup0X0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110X2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_9 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_9"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e110X2 ();
      if (returnInSub) return;
   }

   public void e110X2( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( (GXutil.strcmp("", AV10ModuleDescription)==0) )
      {
         AV11ModuleDescriptionAux = GXutil.trim( AV14websession.getValue(httpContext.getMessage( "ModuleDescription", ""))) ;
      }
      else
      {
         AV11ModuleDescriptionAux = GXutil.trim( AV10ModuleDescription) ;
      }
      if ( (GXutil.strcmp("", AV11ModuleDescriptionAux)==0) )
      {
         AV11ModuleDescriptionAux = httpContext.getMessage( "Home", "") ;
      }
      if ( GXutil.strcmp(GXutil.trim( AV11ModuleDescriptionAux), httpContext.getMessage( "Home", "")) != 0 )
      {
         Form.setCaption( GXutil.trim( AV11ModuleDescriptionAux) );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         lblTextblock1_Caption = GXutil.trim( AV11ModuleDescriptionAux) ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblock1_Internalname, "Caption", lblTextblock1_Caption, true);
         lblTextblock1_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblock1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTextblock1_Visible), 5, 0), true);
      }
      else
      {
         Form.setCaption( httpContext.getMessage( "Inicio", "") );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         lblTextblock1_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblock1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTextblock1_Visible), 5, 0), true);
      }
      AV14websession.setValue(httpContext.getMessage( "ModuleDescription", ""), AV11ModuleDescriptionAux);
      GXv_objcol_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem1[0] = AV8MenuItems ;
      new web.menuload2(remoteHandle, context).execute( new web.getempcod(remoteHandle, context).executeUdp( ), GXv_objcol_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem1) ;
      AV8MenuItems = GXv_objcol_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem1[0] ;
      tblTablecenter_Class = httpContext.getMessage( "Table MT35", "") ;
      httpContext.ajax_rsp_assign_prop("", false, tblTablecenter_Internalname, "Class", tblTablecenter_Class, !bGXsfl_9_Refreshing);
      divGridcontenttable_Class = httpContext.getMessage( "TableMenuItemCard", "") ;
      httpContext.ajax_rsp_assign_prop("", false, divGridcontenttable_Internalname, "Class", divGridcontenttable_Class, !bGXsfl_9_Refreshing);
      edtavMenuitemsdescription_Class = httpContext.getMessage( "AttributeMenuItem", "") ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMenuitemsdescription_Internalname, "Class", edtavMenuitemsdescription_Class, !bGXsfl_9_Refreshing);
   }

   private void e120X2( )
   {
      /* Gridmenuitems_Load Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&MenuItems ", "")+GXutil.trim( GXutil.str( AV8MenuItems.size(), 9, 0))) ;
      AV20GXV1 = 1 ;
      while ( AV20GXV1 <= AV8MenuItems.size() )
      {
         AV15item = (web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem)((web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem)AV8MenuItems.elementAt(-1+AV20GXV1));
         new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( " &item.Title.Trim().ToUpper() ", "")+GXutil.upper( GXutil.trim( AV15item.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title()))+httpContext.getMessage( " &ModuleDescription.Trim().ToUpper() ", "")+GXutil.upper( GXutil.trim( AV10ModuleDescription))) ;
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15item.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title())), GXutil.upper( GXutil.trim( AV10ModuleDescription))) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&item.Items.Count ", "")+GXutil.str( AV15item.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items().size(), 9, 0)) ;
            if ( AV15item.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items().size() > 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&item.Items ", "")+GXutil.trim( GXutil.str( AV15item.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items().size(), 9, 0))) ;
               AV21GXV2 = 1 ;
               while ( AV21GXV2 <= AV15item.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items().size() )
               {
                  AV6item2 = (web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem)((web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem)AV15item.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items().elementAt(-1+AV21GXV2));
                  new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&item2.Items.Count ", "")+GXutil.trim( GXutil.str( AV6item2.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items().size(), 9, 0))) ;
                  if ( AV6item2.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items().size() > 0 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "asf1)", "")) ;
                     AV22GXV3 = 1 ;
                     while ( AV22GXV3 <= AV6item2.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items().size() )
                     {
                        AV7item3 = (web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem)((web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem)AV6item2.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items().elementAt(-1+AV22GXV3));
                        new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( " &item3.Items.Coun ", "")+GXutil.str( AV7item3.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items().size(), 9, 0)) ;
                        if ( AV7item3.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items().size() > 0 )
                        {
                           new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "asdf5", "")) ;
                           AV23GXV4 = 1 ;
                           while ( AV23GXV4 <= AV7item3.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items().size() )
                           {
                              AV16item4 = (web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem)((web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem)AV7item3.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Items().elementAt(-1+AV23GXV4));
                              AV5ImageMenuItemIcon = AV16item4.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl() ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavImagemenuitemicon_Internalname, AV5ImageMenuItemIcon);
                              AV24Imagemenuitemicon_GXI = GXDbFile.pathToUrl( AV16item4.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl(), context.getHttpContext()) ;
                              edtavImagemenuitemicon_Link = GXutil.trim( AV16item4.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link()) ;
                              edtavMenuitemsdescription_Link = GXutil.trim( AV16item4.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link()) ;
                              AV9MenuItemsDescription = GXutil.trim( AV16item4.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title()) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavMenuitemsdescription_Internalname, AV9MenuItemsDescription);
                              /* Load Method */
                              if ( wbStart != -1 )
                              {
                                 wbStart = (short)(9) ;
                              }
                              sendrow_92( ) ;
                              if ( isFullAjaxMode( ) && ! bGXsfl_9_Refreshing )
                              {
                                 httpContext.doAjaxLoad(9, GridmenuitemsRow);
                              }
                              AV23GXV4 = (int)(AV23GXV4+1) ;
                           }
                        }
                        else
                        {
                           new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "asdf6", "")) ;
                           AV5ImageMenuItemIcon = AV7item3.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl() ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavImagemenuitemicon_Internalname, AV5ImageMenuItemIcon);
                           AV24Imagemenuitemicon_GXI = GXDbFile.pathToUrl( AV7item3.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl(), context.getHttpContext()) ;
                           edtavImagemenuitemicon_Link = GXutil.trim( AV7item3.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link()) ;
                           edtavMenuitemsdescription_Link = GXutil.trim( AV7item3.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link()) ;
                           AV9MenuItemsDescription = GXutil.trim( AV7item3.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title()) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavMenuitemsdescription_Internalname, AV9MenuItemsDescription);
                           /* Load Method */
                           if ( wbStart != -1 )
                           {
                              wbStart = (short)(9) ;
                           }
                           sendrow_92( ) ;
                           if ( isFullAjaxMode( ) && ! bGXsfl_9_Refreshing )
                           {
                              httpContext.doAjaxLoad(9, GridmenuitemsRow);
                           }
                        }
                        AV22GXV3 = (int)(AV22GXV3+1) ;
                     }
                  }
                  else
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "asf2)", "")) ;
                     AV5ImageMenuItemIcon = AV6item2.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl() ;
                     httpContext.ajax_rsp_assign_attri("", false, edtavImagemenuitemicon_Internalname, AV5ImageMenuItemIcon);
                     AV24Imagemenuitemicon_GXI = GXDbFile.pathToUrl( AV6item2.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl(), context.getHttpContext()) ;
                     edtavImagemenuitemicon_Link = GXutil.trim( AV6item2.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link()) ;
                     edtavMenuitemsdescription_Link = GXutil.trim( AV6item2.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link()) ;
                     AV9MenuItemsDescription = GXutil.trim( AV6item2.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title()) ;
                     httpContext.ajax_rsp_assign_attri("", false, edtavMenuitemsdescription_Internalname, AV9MenuItemsDescription);
                     /* Load Method */
                     if ( wbStart != -1 )
                     {
                        wbStart = (short)(9) ;
                     }
                     sendrow_92( ) ;
                     if ( isFullAjaxMode( ) && ! bGXsfl_9_Refreshing )
                     {
                        httpContext.doAjaxLoad(9, GridmenuitemsRow);
                     }
                  }
                  AV21GXV2 = (int)(AV21GXV2+1) ;
               }
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "asf3)", "")) ;
               AV5ImageMenuItemIcon = AV15item.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl() ;
               httpContext.ajax_rsp_assign_attri("", false, edtavImagemenuitemicon_Internalname, AV5ImageMenuItemIcon);
               AV24Imagemenuitemicon_GXI = GXDbFile.pathToUrl( AV15item.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Imageurl(), context.getHttpContext()) ;
               edtavImagemenuitemicon_Link = GXutil.trim( AV15item.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link()) ;
               edtavMenuitemsdescription_Link = GXutil.trim( AV15item.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Link()) ;
               AV9MenuItemsDescription = GXutil.trim( AV15item.getgxTv_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem_Title()) ;
               httpContext.ajax_rsp_assign_attri("", false, edtavMenuitemsdescription_Internalname, AV9MenuItemsDescription);
               /* Load Method */
               if ( wbStart != -1 )
               {
                  wbStart = (short)(9) ;
               }
               sendrow_92( ) ;
               if ( isFullAjaxMode( ) && ! bGXsfl_9_Refreshing )
               {
                  httpContext.doAjaxLoad(9, GridmenuitemsRow);
               }
            }
         }
         AV20GXV1 = (int)(AV20GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV10ModuleDescription = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10ModuleDescription", AV10ModuleDescription);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODULEDESCRIPTION", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10ModuleDescription, ""))));
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa0X2( ) ;
      ws0X2( ) ;
      we0X2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020253327", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("listmoduleitems.js", "?2024122020253327", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_92( )
   {
      edtavImagemenuitemicon_Internalname = "vIMAGEMENUITEMICON_"+sGXsfl_9_idx ;
      edtavMenuitemsdescription_Internalname = "vMENUITEMSDESCRIPTION_"+sGXsfl_9_idx ;
   }

   public void subsflControlProps_fel_92( )
   {
      edtavImagemenuitemicon_Internalname = "vIMAGEMENUITEMICON_"+sGXsfl_9_fel_idx ;
      edtavMenuitemsdescription_Internalname = "vMENUITEMSDESCRIPTION_"+sGXsfl_9_fel_idx ;
   }

   public void sendrow_92( )
   {
      subsflControlProps_92( ) ;
      wb0X0( ) ;
      GridmenuitemsRow = GXWebRow.GetNew(context,GridmenuitemsContainer) ;
      if ( subGridmenuitems_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridmenuitems_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridmenuitems_Class, "") != 0 )
         {
            subGridmenuitems_Linesclass = subGridmenuitems_Class+"Odd" ;
         }
      }
      else if ( subGridmenuitems_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridmenuitems_Backstyle = (byte)(0) ;
         subGridmenuitems_Backcolor = subGridmenuitems_Allbackcolor ;
         if ( GXutil.strcmp(subGridmenuitems_Class, "") != 0 )
         {
            subGridmenuitems_Linesclass = subGridmenuitems_Class+"Uniform" ;
         }
      }
      else if ( subGridmenuitems_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridmenuitems_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridmenuitems_Class, "") != 0 )
         {
            subGridmenuitems_Linesclass = subGridmenuitems_Class+"Odd" ;
         }
         subGridmenuitems_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridmenuitems_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridmenuitems_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_9_idx) % (2))) == 0 )
         {
            subGridmenuitems_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridmenuitems_Class, "") != 0 )
            {
               subGridmenuitems_Linesclass = subGridmenuitems_Class+"Even" ;
            }
         }
         else
         {
            subGridmenuitems_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGridmenuitems_Class, "") != 0 )
            {
               subGridmenuitems_Linesclass = subGridmenuitems_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GridmenuitemsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGridmenuitems_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_9_idx+"\">") ;
      }
      /* Div Control */
      GridmenuitemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGridcontenttable_Internalname+"_"+sGXsfl_9_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",divGridcontenttable_Class,"left","top","","","div"});
      /* Div Control */
      GridmenuitemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridmenuitemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","Center","Middle","","","div"});
      /* Table start */
      GridmenuitemsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTablecenter_Internalname+"_"+sGXsfl_9_idx,Integer.valueOf(1),tblTablecenter_Class,"","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      GridmenuitemsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridmenuitemsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Table start */
      GridmenuitemsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTable1_Internalname+"_"+sGXsfl_9_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      GridmenuitemsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridmenuitemsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      GridmenuitemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridmenuitemsRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "imagen menu", ""),"gx-form-item ImageLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Static Bitmap Variable */
      ClassString = "Image" + " " + ((GXutil.strcmp(edtavImagemenuitemicon_gximage, "")==0) ? "" : "GX_Image_"+edtavImagemenuitemicon_gximage+"_Class") ;
      StyleString = "" ;
      AV5ImageMenuItemIcon_IsBlob = (boolean)(((GXutil.strcmp("", AV5ImageMenuItemIcon)==0)&&(GXutil.strcmp("", AV24Imagemenuitemicon_GXI)==0))||!(GXutil.strcmp("", AV5ImageMenuItemIcon)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV5ImageMenuItemIcon)==0) ? AV24Imagemenuitemicon_GXI : httpContext.getResourceRelative(AV5ImageMenuItemIcon)) ;
      GridmenuitemsRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavImagemenuitemicon_Internalname,sImgUrl,edtavImagemenuitemicon_Link,"","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(1),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV5ImageMenuItemIcon_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      GridmenuitemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( GridmenuitemsContainer.GetWrapped() == 1 )
      {
         GridmenuitemsContainer.CloseTag("cell");
      }
      if ( GridmenuitemsContainer.GetWrapped() == 1 )
      {
         GridmenuitemsContainer.CloseTag("row");
      }
      if ( GridmenuitemsContainer.GetWrapped() == 1 )
      {
         GridmenuitemsContainer.CloseTag("table");
      }
      /* End of table */
      if ( GridmenuitemsContainer.GetWrapped() == 1 )
      {
         GridmenuitemsContainer.CloseTag("cell");
      }
      if ( GridmenuitemsContainer.GetWrapped() == 1 )
      {
         GridmenuitemsContainer.CloseTag("row");
      }
      GridmenuitemsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridmenuitemsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Table start */
      GridmenuitemsRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblTabletituloitem_Internalname+"_"+sGXsfl_9_idx,Integer.valueOf(1),"Table MT5","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      GridmenuitemsRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridmenuitemsRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      GridmenuitemsRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = edtavMenuitemsdescription_Class ;
      GridmenuitemsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavMenuitemsdescription_Internalname,GXutil.rtrim( AV9MenuItemsDescription),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavMenuitemsdescription_Link,"","","",edtavMenuitemsdescription_Jsonclick,Integer.valueOf(0),edtavMenuitemsdescription_Class,"",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
      GridmenuitemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( GridmenuitemsContainer.GetWrapped() == 1 )
      {
         GridmenuitemsContainer.CloseTag("cell");
      }
      if ( GridmenuitemsContainer.GetWrapped() == 1 )
      {
         GridmenuitemsContainer.CloseTag("row");
      }
      if ( GridmenuitemsContainer.GetWrapped() == 1 )
      {
         GridmenuitemsContainer.CloseTag("table");
      }
      /* End of table */
      if ( GridmenuitemsContainer.GetWrapped() == 1 )
      {
         GridmenuitemsContainer.CloseTag("cell");
      }
      if ( GridmenuitemsContainer.GetWrapped() == 1 )
      {
         GridmenuitemsContainer.CloseTag("row");
      }
      if ( GridmenuitemsContainer.GetWrapped() == 1 )
      {
         GridmenuitemsContainer.CloseTag("table");
      }
      /* End of table */
      GridmenuitemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"Center","Middle","div"});
      GridmenuitemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridmenuitemsRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes0X2( ) ;
      /* End of Columns property logic. */
      GridmenuitemsContainer.AddRow(GridmenuitemsRow);
      nGXsfl_9_idx = ((subGridmenuitems_Islastpage==1)&&(nGXsfl_9_idx+1>subgridmenuitems_fnc_recordsperpage( )) ? 1 : nGXsfl_9_idx+1) ;
      sGXsfl_9_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_9_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_92( ) ;
      /* End function sendrow_92 */
   }

   public void startgridcontrol9( )
   {
      if ( GridmenuitemsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridmenuitemsContainer"+"DivS\" data-gxgridid=\"9\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridmenuitems_Internalname, subGridmenuitems_Internalname, "", "MT25", 0, "", "", 1, 2, sStyleString, "", "", 0);
         GridmenuitemsContainer.AddObjectProperty("GridName", "Gridmenuitems");
      }
      else
      {
         GridmenuitemsContainer.AddObjectProperty("GridName", "Gridmenuitems");
         GridmenuitemsContainer.AddObjectProperty("Header", subGridmenuitems_Header);
         GridmenuitemsContainer.AddObjectProperty("Class", GXutil.rtrim( "MT25"));
         GridmenuitemsContainer.AddObjectProperty("Class", "MT25");
         GridmenuitemsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridmenuitemsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridmenuitemsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridmenuitems_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridmenuitemsContainer.AddObjectProperty("CmpContext", "");
         GridmenuitemsContainer.AddObjectProperty("InMasterPage", "false");
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsColumn.AddObjectProperty("Value", httpContext.convertURL( AV5ImageMenuItemIcon));
         GridmenuitemsColumn.AddObjectProperty("Link", GXutil.rtrim( edtavImagemenuitemicon_Link));
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridmenuitemsColumn.AddObjectProperty("Value", GXutil.rtrim( AV9MenuItemsDescription));
         GridmenuitemsColumn.AddObjectProperty("Class", GXutil.rtrim( edtavMenuitemsdescription_Class));
         GridmenuitemsColumn.AddObjectProperty("Link", GXutil.rtrim( edtavMenuitemsdescription_Link));
         GridmenuitemsContainer.AddColumnProperties(GridmenuitemsColumn);
         GridmenuitemsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridmenuitems_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridmenuitemsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridmenuitems_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridmenuitemsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridmenuitems_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridmenuitemsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridmenuitems_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridmenuitemsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridmenuitems_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridmenuitemsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridmenuitems_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridmenuitemsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridmenuitems_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblTextblock1_Internalname = "TEXTBLOCK1" ;
      edtavImagemenuitemicon_Internalname = "vIMAGEMENUITEMICON" ;
      tblTable1_Internalname = "TABLE1" ;
      edtavMenuitemsdescription_Internalname = "vMENUITEMSDESCRIPTION" ;
      tblTabletituloitem_Internalname = "TABLETITULOITEM" ;
      tblTablecenter_Internalname = "TABLECENTER" ;
      divGridcontenttable_Internalname = "GRIDCONTENTTABLE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridmenuitems_Internalname = "GRIDMENUITEMS" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      subGridmenuitems_Allowcollapsing = (byte)(0) ;
      edtavMenuitemsdescription_Jsonclick = "" ;
      edtavMenuitemsdescription_Link = "" ;
      edtavImagemenuitemicon_gximage = "" ;
      edtavImagemenuitemicon_Link = "" ;
      subGridmenuitems_Class = "MT25" ;
      divGridcontenttable_Class = "Table" ;
      tblTablecenter_Class = "" ;
      subGridmenuitems_Backcolorstyle = (byte)(0) ;
      lblTextblock1_Caption = httpContext.getMessage( "Text Block", "") ;
      lblTextblock1_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "List Module Items", "") );
      edtavMenuitemsdescription_Class = "Attribute" ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDMENUITEMS_nFirstRecordOnPage'},{av:'GRIDMENUITEMS_nEOF'},{av:'edtavMenuitemsdescription_Class',ctrl:'vMENUITEMSDESCRIPTION',prop:'Class'},{av:'AV19Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV8MenuItems',fld:'vMENUITEMS',pic:'',hsh:true},{av:'AV10ModuleDescription',fld:'vMODULEDESCRIPTION',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRIDMENUITEMS.LOAD","{handler:'e120X2',iparms:[{av:'AV19Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV8MenuItems',fld:'vMENUITEMS',pic:'',hsh:true},{av:'AV10ModuleDescription',fld:'vMODULEDESCRIPTION',pic:'',hsh:true}]");
      setEventMetadata("GRIDMENUITEMS.LOAD",",oparms:[{av:'AV5ImageMenuItemIcon',fld:'vIMAGEMENUITEMICON',pic:''},{av:'edtavImagemenuitemicon_Link',ctrl:'vIMAGEMENUITEMICON',prop:'Link'},{av:'edtavMenuitemsdescription_Link',ctrl:'vMENUITEMSDESCRIPTION',prop:'Link'},{av:'AV9MenuItemsDescription',fld:'vMENUITEMSDESCRIPTION',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Menuitemsdescription',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "SESSION";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      wcpOAV10ModuleDescription = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV19Pgmname = "" ;
      AV8MenuItems = new GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem>(web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem.class, "K2BMultiLevelMenuItem", "PayDay", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GXEncryptionTmp = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTextblock1_Jsonclick = "" ;
      GridmenuitemsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV5ImageMenuItemIcon = "" ;
      AV24Imagemenuitemicon_GXI = "" ;
      AV9MenuItemsDescription = "" ;
      GXDecQS = "" ;
      AV11ModuleDescriptionAux = "" ;
      AV14websession = httpContext.getWebSession();
      GXv_objcol_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem1 = new GXBaseCollection[1] ;
      AV15item = new web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem(remoteHandle, context);
      AV6item2 = new web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem(remoteHandle, context);
      AV7item3 = new web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem(remoteHandle, context);
      AV16item4 = new web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem(remoteHandle, context);
      GridmenuitemsRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridmenuitems_Linesclass = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      ROClassString = "" ;
      subGridmenuitems_Header = "" ;
      GridmenuitemsColumn = new com.genexus.webpanels.GXWebColumn();
      AV19Pgmname = "ListModuleItems" ;
      /* GeneXus formulas. */
      AV19Pgmname = "ListModuleItems" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private byte subGridmenuitems_Backcolorstyle ;
   private byte subGridmenuitems_Backstyle ;
   private byte subGridmenuitems_Allowselection ;
   private byte subGridmenuitems_Allowhovering ;
   private byte subGridmenuitems_Allowcollapsing ;
   private byte subGridmenuitems_Collapsed ;
   private byte GRIDMENUITEMS_nEOF ;
   private short wbEnd ;
   private short wbStart ;
   private short Gx_err ;
   private int nRC_GXsfl_9 ;
   private int nGXsfl_9_idx=1 ;
   private int lblTextblock1_Visible ;
   private int subGridmenuitems_Islastpage ;
   private int AV20GXV1 ;
   private int AV21GXV2 ;
   private int AV22GXV3 ;
   private int AV23GXV4 ;
   private int idxLst ;
   private int subGridmenuitems_Backcolor ;
   private int subGridmenuitems_Allbackcolor ;
   private int subGridmenuitems_Selectedindex ;
   private int subGridmenuitems_Selectioncolor ;
   private int subGridmenuitems_Hoveringcolor ;
   private long GRIDMENUITEMS_nCurrentRecord ;
   private long GRIDMENUITEMS_nFirstRecordOnPage ;
   private String wcpOAV10ModuleDescription ;
   private String edtavMenuitemsdescription_Class ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_9_idx="0001" ;
   private String edtavMenuitemsdescription_Internalname ;
   private String AV19Pgmname ;
   private String AV10ModuleDescription ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GXEncryptionTmp ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Caption ;
   private String lblTextblock1_Jsonclick ;
   private String sStyleString ;
   private String subGridmenuitems_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavImagemenuitemicon_Internalname ;
   private String AV9MenuItemsDescription ;
   private String GXDecQS ;
   private String AV11ModuleDescriptionAux ;
   private String tblTablecenter_Class ;
   private String tblTablecenter_Internalname ;
   private String divGridcontenttable_Class ;
   private String divGridcontenttable_Internalname ;
   private String edtavImagemenuitemicon_Link ;
   private String edtavMenuitemsdescription_Link ;
   private String sGXsfl_9_fel_idx="0001" ;
   private String subGridmenuitems_Class ;
   private String subGridmenuitems_Linesclass ;
   private String tblTable1_Internalname ;
   private String ClassString ;
   private String edtavImagemenuitemicon_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String tblTabletituloitem_Internalname ;
   private String ROClassString ;
   private String edtavMenuitemsdescription_Jsonclick ;
   private String subGridmenuitems_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_9_Refreshing=false ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV5ImageMenuItemIcon_IsBlob ;
   private String AV24Imagemenuitemicon_GXI ;
   private String AV5ImageMenuItemIcon ;
   private com.genexus.webpanels.GXWebGrid GridmenuitemsContainer ;
   private com.genexus.webpanels.GXWebRow GridmenuitemsRow ;
   private com.genexus.webpanels.GXWebColumn GridmenuitemsColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV14websession ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem> AV8MenuItems ;
   private GXBaseCollection<web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem> GXv_objcol_SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem1[] ;
   private web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem AV15item ;
   private web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem AV6item2 ;
   private web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem AV7item3 ;
   private web.SdtK2BMultiLevelMenu_K2BMultiLevelMenuItem AV16item4 ;
}

