package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class provincia_impl extends GXWebComponent
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            nDynComponent = (byte)(1) ;
            sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
            sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
            Gx_mode = httpContext.GetPar( "Mode") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
            AV7PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7PaiCod), 4, 0));
            AV8ProvCod = (short)(GXutil.lval( httpContext.GetPar( "ProvCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8ProvCod), 4, 0));
            setjustcreated();
            componentprepare(new Object[] {sCompPrefix,sSFPrefix,Gx_mode,Short.valueOf(AV7PaiCod),Short.valueOf(AV8ProvCod)});
            componentstart();
            httpContext.ajax_rspStartCmp(sPrefix);
            componentdraw();
            httpContext.ajax_rspEndCmp();
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_8") == 0 )
         {
            A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_8( A46PaiCod) ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            Gx_mode = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV7PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7PaiCod), 4, 0));
               AV8ProvCod = (short)(GXutil.lval( httpContext.GetPar( "ProvCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8ProvCod), 4, 0));
            }
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_web_controls( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
            }
            Form.getMeta().addItem("description", httpContext.getMessage( "Provincia", ""), (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtProvCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public provincia_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public provincia_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( provincia_impl.class ));
   }

   public provincia_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         userMain( ) ;
         if ( ! isFullAjaxMode( ) && ( nDynComponent == 0 ) )
         {
            draw( ) ;
         }
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
      cleanup();
   }

   public void fix_multi_value_controls( )
   {
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
         renderHtmlCloseForm1942( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         renderHtmlHeaders( ) ;
      }
      renderHtmlOpenForm( ) ;
      if ( GXutil.len( sPrefix) != 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.provincia");
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      }
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, sPrefix+"DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProvCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtProvCod_Internalname, httpContext.getMessage( "Cod. Prov.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'" + sPrefix + "',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtProvCod_Internalname, GXutil.ltrim( localUtil.ntoc( A47ProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A47ProvCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProvCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProvCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Provincia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProvNom_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtProvNom_Internalname, httpContext.getMessage( "Nom. Prov.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A322ProvNom", A322ProvNom);
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtProvNom_Internalname, A322ProvNom, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtProvNom_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_Provincia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Provincia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Provincia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Provincia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'" + sPrefix + "',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,43);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiCod_Visible, edtPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Provincia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            standaloneStartupServer( ) ;
         }
      }
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11192 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      nDoneStart = (byte)(1) ;
      if ( AnyError == 0 )
      {
         sXEvt = httpContext.cgiGet( "_EventName") ;
         if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z47ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z47ProvCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z322ProvNom = httpContext.cgiGet( sPrefix+"Z322ProvNom") ;
            Z554ProvSiradig = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z554ProvSiradig"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            wcpOGx_mode = httpContext.cgiGet( sPrefix+"wcpOGx_mode") ;
            wcpOAV7PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV7PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            wcpOAV8ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8ProvCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A554ProvSiradig = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z554ProvSiradig"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( sPrefix+"Mode") ;
            AV7PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vPROVCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A554ProvSiradig = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"PROVSIRADIG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A312PaiNom = httpContext.cgiGet( sPrefix+"PAINOM") ;
            AV14Pgmname = httpContext.cgiGet( sPrefix+"vPGMNAME") ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PROVCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtProvCod_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A47ProvCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
            }
            else
            {
               A47ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( edtProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
            }
            A322ProvNom = httpContext.cgiGet( edtProvNom_Internalname) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A322ProvNom", A322ProvNom);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A46PaiCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            else
            {
               A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"Provincia");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ProvSiradig", localUtil.format( DecimalUtil.doubleToDec(A554ProvSiradig), "ZZZ9"));
            hsh = httpContext.cgiGet( sPrefix+"hsh") ;
            if ( ( ! ( ( A46PaiCod != Z46PaiCod ) || ( A47ProvCod != Z47ProvCod ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("provincia:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
               A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A47ProvCod = (short)(GXutil.lval( httpContext.GetPar( "ProvCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode42 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode42 ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound42 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_190( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "PAICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPaiCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read Transaction buttons. */
         if ( httpContext.wbHandled == 0 )
         {
            if ( GXutil.len( sPrefix) == 0 )
            {
               sEvt = httpContext.cgiGet( "_EventName") ;
               EvtGridId = httpContext.cgiGet( "_EventGridId") ;
               EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            }
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              dynload_actions( ) ;
                              /* Execute user event: Start */
                              e11192 ();
                           }
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              dynload_actions( ) ;
                              /* Execute user event: After Trn */
                              e12192 ();
                           }
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              if ( ! isDsp( ) )
                              {
                                 btn_enter( ) ;
                              }
                           }
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                  }
                  else
                  {
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e12192 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1942( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes1942( ) ;
      }
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtProvNom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvNom_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_190( )
   {
      beforeValidate1942( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1942( ) ;
         }
         else
         {
            checkExtendedTable1942( ) ;
            closeExtendedTableCursors1942( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption190( )
   {
   }

   public void e11192( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      AV10IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10IsAuthorized", AV10IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWProvincia_Insert", GXv_boolean3) ;
         provincia_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWProvincia_Update", GXv_boolean3) ;
         provincia_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWProvincia_Delete", GXv_boolean3) ;
         provincia_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV14Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      edtPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Visible), 5, 0), true);
   }

   public void e12192( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm1942( int GX_JID )
   {
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z322ProvNom = T00193_A322ProvNom[0] ;
            Z554ProvSiradig = T00193_A554ProvSiradig[0] ;
         }
         else
         {
            Z322ProvNom = A322ProvNom ;
            Z554ProvSiradig = A554ProvSiradig ;
         }
      }
      if ( GX_JID == -7 )
      {
         Z47ProvCod = A47ProvCod ;
         Z322ProvNom = A322ProvNom ;
         Z554ProvSiradig = A554ProvSiradig ;
         Z46PaiCod = A46PaiCod ;
         Z312PaiNom = A312PaiNom ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7PaiCod) )
      {
         A46PaiCod = AV7PaiCod ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      if ( ! (0==AV7PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      else
      {
         edtPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8ProvCod) )
      {
         A47ProvCod = AV8ProvCod ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
      }
      if ( ! (0==AV8ProvCod) )
      {
         edtProvCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvCod_Enabled), 5, 0), true);
      }
      else
      {
         edtProvCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8ProvCod) )
      {
         edtProvCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvCod_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         /* Using cursor T00194 */
         pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod)});
         A312PaiNom = T00194_A312PaiNom[0] ;
         pr_default.close(2);
         AV14Pgmname = "Provincia" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14Pgmname", AV14Pgmname);
      }
   }

   public void load1942( )
   {
      /* Using cursor T00195 */
      pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound42 = (short)(1) ;
         A312PaiNom = T00195_A312PaiNom[0] ;
         A322ProvNom = T00195_A322ProvNom[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A322ProvNom", A322ProvNom);
         A554ProvSiradig = T00195_A554ProvSiradig[0] ;
         zm1942( -7) ;
      }
      pr_default.close(3);
      onLoadActions1942( ) ;
   }

   public void onLoadActions1942( )
   {
      AV14Pgmname = "Provincia" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14Pgmname", AV14Pgmname);
   }

   public void checkExtendedTable1942( )
   {
      nIsDirty_42 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV14Pgmname = "Provincia" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14Pgmname", AV14Pgmname);
      /* Using cursor T00194 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      A312PaiNom = T00194_A312PaiNom[0] ;
      pr_default.close(2);
   }

   public void closeExtendedTableCursors1942( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_8( short A46PaiCod )
   {
      /* Using cursor T00196 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      A312PaiNom = T00196_A312PaiNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A312PaiNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey1942( )
   {
      /* Using cursor T00197 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound42 = (short)(1) ;
      }
      else
      {
         RcdFound42 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00193 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1942( 7) ;
         RcdFound42 = (short)(1) ;
         A47ProvCod = T00193_A47ProvCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
         A322ProvNom = T00193_A322ProvNom[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A322ProvNom", A322ProvNom);
         A554ProvSiradig = T00193_A554ProvSiradig[0] ;
         A46PaiCod = T00193_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         Z46PaiCod = A46PaiCod ;
         Z47ProvCod = A47ProvCod ;
         sMode42 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
         load1942( ) ;
         if ( AnyError == 1 )
         {
            RcdFound42 = (short)(0) ;
            initializeNonKey1942( ) ;
         }
         Gx_mode = sMode42 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound42 = (short)(0) ;
         initializeNonKey1942( ) ;
         sMode42 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode42 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1942( ) ;
      if ( RcdFound42 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound42 = (short)(0) ;
      /* Using cursor T00198 */
      pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00198_A46PaiCod[0] < A46PaiCod ) || ( T00198_A46PaiCod[0] == A46PaiCod ) && ( T00198_A47ProvCod[0] < A47ProvCod ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00198_A46PaiCod[0] > A46PaiCod ) || ( T00198_A46PaiCod[0] == A46PaiCod ) && ( T00198_A47ProvCod[0] > A47ProvCod ) ) )
         {
            A46PaiCod = T00198_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A47ProvCod = T00198_A47ProvCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
            RcdFound42 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound42 = (short)(0) ;
      /* Using cursor T00199 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00199_A46PaiCod[0] > A46PaiCod ) || ( T00199_A46PaiCod[0] == A46PaiCod ) && ( T00199_A47ProvCod[0] > A47ProvCod ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00199_A46PaiCod[0] < A46PaiCod ) || ( T00199_A46PaiCod[0] == A46PaiCod ) && ( T00199_A47ProvCod[0] < A47ProvCod ) ) )
         {
            A46PaiCod = T00199_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A47ProvCod = T00199_A47ProvCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
            RcdFound42 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1942( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtProvCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         insert1942( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound42 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( A47ProvCod != Z47ProvCod ) )
            {
               A46PaiCod = Z46PaiCod ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A47ProvCod = Z47ProvCod ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtProvCod_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1942( ) ;
               GX_FocusControl = edtProvCod_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( A47ProvCod != Z47ProvCod ) )
            {
               /* Insert record */
               GX_FocusControl = edtProvCod_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               insert1942( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PAICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtProvCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                  insert1942( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( ( AnyError == 0 ) && ( GXutil.len( sPrefix) == 0 ) )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( ( A46PaiCod != Z46PaiCod ) || ( A47ProvCod != Z47ProvCod ) )
      {
         A46PaiCod = Z46PaiCod ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A47ProvCod = Z47ProvCod ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtProvCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1942( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00192 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Provincia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z322ProvNom, T00192_A322ProvNom[0]) != 0 ) || ( Z554ProvSiradig != T00192_A554ProvSiradig[0] ) )
         {
            if ( GXutil.strcmp(Z322ProvNom, T00192_A322ProvNom[0]) != 0 )
            {
               GXutil.writeLogln("provincia:[seudo value changed for attri]"+"ProvNom");
               GXutil.writeLogRaw("Old: ",Z322ProvNom);
               GXutil.writeLogRaw("Current: ",T00192_A322ProvNom[0]);
            }
            if ( Z554ProvSiradig != T00192_A554ProvSiradig[0] )
            {
               GXutil.writeLogln("provincia:[seudo value changed for attri]"+"ProvSiradig");
               GXutil.writeLogRaw("Old: ",Z554ProvSiradig);
               GXutil.writeLogRaw("Current: ",T00192_A554ProvSiradig[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Provincia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1942( )
   {
      beforeValidate1942( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1942( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1942( 0) ;
         checkOptimisticConcurrency1942( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1942( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1942( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001910 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A47ProvCod), A322ProvNom, Short.valueOf(A554ProvSiradig), Short.valueOf(A46PaiCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Provincia");
                  if ( (pr_default.getStatus(8) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption190( ) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load1942( ) ;
         }
         endLevel1942( ) ;
      }
      closeExtendedTableCursors1942( ) ;
   }

   public void update1942( )
   {
      beforeValidate1942( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1942( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1942( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1942( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1942( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001911 */
                  pr_default.execute(9, new Object[] {A322ProvNom, Short.valueOf(A554ProvSiradig), Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Provincia");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Provincia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1942( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( ( AnyError == 0 ) && ( GXutil.len( sPrefix) == 0 ) )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel1942( ) ;
      }
      closeExtendedTableCursors1942( ) ;
   }

   public void deferredUpdate1942( )
   {
   }

   public void delete( )
   {
      beforeValidate1942( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1942( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1942( ) ;
         afterConfirm1942( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1942( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001912 */
               pr_default.execute(10, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Provincia");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     if ( isUpd( ) || isDlt( ) )
                     {
                        if ( ( AnyError == 0 ) && ( GXutil.len( sPrefix) == 0 ) )
                        {
                           httpContext.nUserReturn = (byte)(1) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode42 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      endLevel1942( ) ;
      Gx_mode = sMode42 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1942( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV14Pgmname = "Provincia" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14Pgmname", AV14Pgmname);
         /* Using cursor T001913 */
         pr_default.execute(11, new Object[] {Short.valueOf(A46PaiCod)});
         A312PaiNom = T001913_A312PaiNom[0] ;
         pr_default.close(11);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001914 */
         pr_default.execute(12, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "CategoriaProvincias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
         /* Using cursor T001915 */
         pr_default.execute(13, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Localidad", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor T001916 */
         pr_default.execute(14, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
   }

   public void endLevel1942( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1942( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "provincia");
         if ( AnyError == 0 )
         {
            confirmValues190( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "provincia");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1942( )
   {
      /* Scan By routine */
      /* Using cursor T001917 */
      pr_default.execute(15);
      RcdFound42 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound42 = (short)(1) ;
         A46PaiCod = T001917_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A47ProvCod = T001917_A47ProvCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1942( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound42 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound42 = (short)(1) ;
         A46PaiCod = T001917_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A47ProvCod = T001917_A47ProvCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
      }
   }

   public void scanEnd1942( )
   {
      pr_default.close(15);
   }

   public void afterConfirm1942( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1942( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1942( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1942( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1942( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1942( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1942( )
   {
      edtProvCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvCod_Enabled), 5, 0), true);
      edtProvNom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtProvNom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvNom_Enabled), 5, 0), true);
      edtPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1942( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues190( )
   {
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( httpContext.getMessage( "Provincia", "")) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.provincia", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8ProvCod,4,0))}, new String[] {"Gx_mode","PaiCod","ProvCod"}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"Provincia");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ProvSiradig", localUtil.format( DecimalUtil.doubleToDec(A554ProvSiradig), "ZZZ9"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("provincia:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z47ProvCod", GXutil.ltrim( localUtil.ntoc( Z47ProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z322ProvNom", Z322ProvNom);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z554ProvSiradig", GXutil.ltrim( localUtil.ntoc( Z554ProvSiradig, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOGx_mode", GXutil.rtrim( wcpOGx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV7PaiCod", GXutil.ltrim( localUtil.ntoc( wcpOAV7PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8ProvCod", GXutil.ltrim( localUtil.ntoc( wcpOAV8ProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPAICOD", GXutil.ltrim( localUtil.ntoc( AV7PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPROVCOD", GXutil.ltrim( localUtil.ntoc( AV8ProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROVSIRADIG", GXutil.ltrim( localUtil.ntoc( A554ProvSiradig, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PAINOM", A312PaiNom);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV14Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
   }

   public void renderHtmlCloseForm1942( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
         httpContext.SendComponentObjects();
         httpContext.SendServerCommands();
         httpContext.SendState();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         httpContext.writeTextNL( "</form>") ;
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
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "Provincia" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Provincia", "") ;
   }

   public void initializeNonKey1942( )
   {
      A312PaiNom = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A312PaiNom", A312PaiNom);
      A322ProvNom = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A322ProvNom", A322ProvNom);
      A554ProvSiradig = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A554ProvSiradig", GXutil.ltrimstr( DecimalUtil.doubleToDec(A554ProvSiradig), 4, 0));
      Z322ProvNom = "" ;
      Z554ProvSiradig = (short)(0) ;
   }

   public void initAll1942( )
   {
      A46PaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A47ProvCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
      initializeNonKey1942( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlGx_mode = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV7PaiCod = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV8ProvCod = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      if ( GXutil.len( sPrefix) != 0 )
      {
         initialize_properties( ) ;
      }
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      if ( nDoneStart == 0 )
      {
      }
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "provincia", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initenv( ) ;
         inittrn( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         Gx_mode = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
         AV7PaiCod = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7PaiCod), 4, 0));
         AV8ProvCod = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8ProvCod), 4, 0));
      }
      wcpOGx_mode = httpContext.cgiGet( sPrefix+"wcpOGx_mode") ;
      wcpOAV7PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV7PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV8ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8ProvCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(Gx_mode, wcpOGx_mode) != 0 ) || ( AV7PaiCod != wcpOAV7PaiCod ) || ( AV8ProvCod != wcpOAV8ProvCod ) ) )
      {
         setjustcreated();
      }
      wcpOGx_mode = Gx_mode ;
      wcpOAV7PaiCod = AV7PaiCod ;
      wcpOAV8ProvCod = AV8ProvCod ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlGx_mode = httpContext.cgiGet( sPrefix+"Gx_mode_CTRL") ;
      if ( GXutil.len( sCtrlGx_mode) > 0 )
      {
         Gx_mode = httpContext.cgiGet( sCtrlGx_mode) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      else
      {
         Gx_mode = httpContext.cgiGet( sPrefix+"Gx_mode_PARM") ;
      }
      sCtrlAV7PaiCod = httpContext.cgiGet( sPrefix+"AV7PaiCod_CTRL") ;
      if ( GXutil.len( sCtrlAV7PaiCod) > 0 )
      {
         AV7PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV7PaiCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7PaiCod), 4, 0));
      }
      else
      {
         AV7PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV7PaiCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV8ProvCod = httpContext.cgiGet( sPrefix+"AV8ProvCod_CTRL") ;
      if ( GXutil.len( sCtrlAV8ProvCod) > 0 )
      {
         AV8ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV8ProvCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8ProvCod), 4, 0));
      }
      else
      {
         AV8ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV8ProvCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initenv( ) ;
      inittrn( ) ;
      nDraw = (byte)(0) ;
      sEvt = sCompEvt ;
      if ( isFullAjaxMode( ) )
      {
         userMain( ) ;
      }
      else
      {
         wcparametersget( ) ;
      }
      process( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      userMain( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gx_mode_PARM", GXutil.rtrim( Gx_mode));
      if ( GXutil.len( GXutil.rtrim( sCtrlGx_mode)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gx_mode_CTRL", GXutil.rtrim( sCtrlGx_mode));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7PaiCod_PARM", GXutil.ltrim( localUtil.ntoc( AV7PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV7PaiCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7PaiCod_CTRL", GXutil.rtrim( sCtrlAV7PaiCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8ProvCod_PARM", GXutil.ltrim( localUtil.ntoc( AV8ProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV8ProvCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8ProvCod_CTRL", GXutil.rtrim( sCtrlAV8ProvCod));
      }
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      draw( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713575864", true, true);
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
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("provincia.js", "?20251713575864", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtProvCod_Internalname = sPrefix+"PROVCOD" ;
      edtProvNom_Internalname = sPrefix+"PROVNOM" ;
      divTableattributes_Internalname = sPrefix+"TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = sPrefix+"DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = sPrefix+"TABLECONTENT" ;
      bttBtntrn_enter_Internalname = sPrefix+"BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = sPrefix+"BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = sPrefix+"BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = sPrefix+"TABLEMAINFIX" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      edtPaiCod_Internalname = sPrefix+"PAICOD" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 1 ;
      edtPaiCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtProvNom_Enabled = 1 ;
      edtProvCod_Jsonclick = "" ;
      edtProvCod_Enabled = 1 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      divLayoutmaintable_Class = "Table" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Paicod( )
   {
      /* Using cursor T001913 */
      pr_default.execute(11, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
      }
      A312PaiNom = T001913_A312PaiNom[0] ;
      pr_default.close(11);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A312PaiNom", A312PaiNom);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'componentprocess',iparms:[{postForm:true},{sPrefix:true},{sSFPrefix:true},{sCompEvt:true},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV8ProvCod',fld:'vPROVCOD',pic:'ZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A554ProvSiradig',fld:'PROVSIRADIG',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12192',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_PROVCOD","{handler:'valid_Provcod',iparms:[]");
      setEventMetadata("VALID_PROVCOD",",oparms:[]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A312PaiNom',fld:'PAINOM',pic:'@!'}]");
      setEventMetadata("VALID_PAICOD",",oparms:[{av:'A312PaiNom',fld:'PAINOM',pic:'@!'}]}");
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
      return "provincia_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
      pr_default.close(11);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z322ProvNom = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sXEvt = "" ;
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A322ProvNom = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A312PaiNom = "" ;
      AV14Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode42 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      Z312PaiNom = "" ;
      T00194_A312PaiNom = new String[] {""} ;
      T00195_A47ProvCod = new short[1] ;
      T00195_A312PaiNom = new String[] {""} ;
      T00195_A322ProvNom = new String[] {""} ;
      T00195_A554ProvSiradig = new short[1] ;
      T00195_A46PaiCod = new short[1] ;
      T00196_A312PaiNom = new String[] {""} ;
      T00197_A46PaiCod = new short[1] ;
      T00197_A47ProvCod = new short[1] ;
      T00193_A47ProvCod = new short[1] ;
      T00193_A322ProvNom = new String[] {""} ;
      T00193_A554ProvSiradig = new short[1] ;
      T00193_A46PaiCod = new short[1] ;
      T00198_A46PaiCod = new short[1] ;
      T00198_A47ProvCod = new short[1] ;
      T00199_A46PaiCod = new short[1] ;
      T00199_A47ProvCod = new short[1] ;
      T00192_A47ProvCod = new short[1] ;
      T00192_A322ProvNom = new String[] {""} ;
      T00192_A554ProvSiradig = new short[1] ;
      T00192_A46PaiCod = new short[1] ;
      T001913_A312PaiNom = new String[] {""} ;
      T001914_A3CliCod = new int[1] ;
      T001914_A1564CliPaiConve = new short[1] ;
      T001914_A1565CliConvenio = new String[] {""} ;
      T001914_A8CatCodigo = new String[] {""} ;
      T001914_A2200CatPaiCod = new short[1] ;
      T001914_A2201CatProvCod = new short[1] ;
      T001915_A46PaiCod = new short[1] ;
      T001915_A47ProvCod = new short[1] ;
      T001915_A48LocCod = new short[1] ;
      T001916_A3CliCod = new int[1] ;
      T001916_A1EmpCod = new short[1] ;
      T001916_A6LegNumero = new int[1] ;
      T001917_A46PaiCod = new short[1] ;
      T001917_A47ProvCod = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      sCtrlGx_mode = "" ;
      sCtrlAV7PaiCod = "" ;
      sCtrlAV8ProvCod = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.provincia__default(),
         new Object[] {
             new Object[] {
            T00192_A47ProvCod, T00192_A322ProvNom, T00192_A554ProvSiradig, T00192_A46PaiCod
            }
            , new Object[] {
            T00193_A47ProvCod, T00193_A322ProvNom, T00193_A554ProvSiradig, T00193_A46PaiCod
            }
            , new Object[] {
            T00194_A312PaiNom
            }
            , new Object[] {
            T00195_A47ProvCod, T00195_A312PaiNom, T00195_A322ProvNom, T00195_A554ProvSiradig, T00195_A46PaiCod
            }
            , new Object[] {
            T00196_A312PaiNom
            }
            , new Object[] {
            T00197_A46PaiCod, T00197_A47ProvCod
            }
            , new Object[] {
            T00198_A46PaiCod, T00198_A47ProvCod
            }
            , new Object[] {
            T00199_A46PaiCod, T00199_A47ProvCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001913_A312PaiNom
            }
            , new Object[] {
            T001914_A3CliCod, T001914_A1564CliPaiConve, T001914_A1565CliConvenio, T001914_A8CatCodigo, T001914_A2200CatPaiCod, T001914_A2201CatProvCod
            }
            , new Object[] {
            T001915_A46PaiCod, T001915_A47ProvCod, T001915_A48LocCod
            }
            , new Object[] {
            T001916_A3CliCod, T001916_A1EmpCod, T001916_A6LegNumero
            }
            , new Object[] {
            T001917_A46PaiCod, T001917_A47ProvCod
            }
         }
      );
      AV14Pgmname = "Provincia" ;
   }

   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nKeyPressed ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte Gx_BScreen ;
   private short wcpOAV7PaiCod ;
   private short wcpOAV8ProvCod ;
   private short Z46PaiCod ;
   private short Z47ProvCod ;
   private short Z554ProvSiradig ;
   private short AV7PaiCod ;
   private short AV8ProvCod ;
   private short A46PaiCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A47ProvCod ;
   private short A554ProvSiradig ;
   private short RcdFound42 ;
   private short nIsDirty_42 ;
   private int trnEnded ;
   private int edtProvCod_Enabled ;
   private int edtProvNom_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtPaiCod_Visible ;
   private int edtPaiCod_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String sXEvt ;
   private String GX_FocusControl ;
   private String edtProvCod_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String edtProvCod_Jsonclick ;
   private String edtProvNom_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtPaiCod_Internalname ;
   private String edtPaiCod_Jsonclick ;
   private String AV14Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode42 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String sCtrlGx_mode ;
   private String sCtrlAV7PaiCod ;
   private String sCtrlAV8ProvCod ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String Z322ProvNom ;
   private String A322ProvNom ;
   private String A312PaiNom ;
   private String Z312PaiNom ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T00194_A312PaiNom ;
   private short[] T00195_A47ProvCod ;
   private String[] T00195_A312PaiNom ;
   private String[] T00195_A322ProvNom ;
   private short[] T00195_A554ProvSiradig ;
   private short[] T00195_A46PaiCod ;
   private String[] T00196_A312PaiNom ;
   private short[] T00197_A46PaiCod ;
   private short[] T00197_A47ProvCod ;
   private short[] T00193_A47ProvCod ;
   private String[] T00193_A322ProvNom ;
   private short[] T00193_A554ProvSiradig ;
   private short[] T00193_A46PaiCod ;
   private short[] T00198_A46PaiCod ;
   private short[] T00198_A47ProvCod ;
   private short[] T00199_A46PaiCod ;
   private short[] T00199_A47ProvCod ;
   private short[] T00192_A47ProvCod ;
   private String[] T00192_A322ProvNom ;
   private short[] T00192_A554ProvSiradig ;
   private short[] T00192_A46PaiCod ;
   private String[] T001913_A312PaiNom ;
   private int[] T001914_A3CliCod ;
   private short[] T001914_A1564CliPaiConve ;
   private String[] T001914_A1565CliConvenio ;
   private String[] T001914_A8CatCodigo ;
   private short[] T001914_A2200CatPaiCod ;
   private short[] T001914_A2201CatProvCod ;
   private short[] T001915_A46PaiCod ;
   private short[] T001915_A47ProvCod ;
   private short[] T001915_A48LocCod ;
   private int[] T001916_A3CliCod ;
   private short[] T001916_A1EmpCod ;
   private int[] T001916_A6LegNumero ;
   private short[] T001917_A46PaiCod ;
   private short[] T001917_A47ProvCod ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
}

final  class provincia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00192", "SELECT ProvCod, ProvNom, ProvSiradig, PaiCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ?  FOR UPDATE OF Provincia NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00193", "SELECT ProvCod, ProvNom, ProvSiradig, PaiCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00194", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00195", "SELECT TM1.ProvCod, T2.PaiNom, TM1.ProvNom, TM1.ProvSiradig, TM1.PaiCod FROM (Provincia TM1 INNER JOIN Pais T2 ON T2.PaiCod = TM1.PaiCod) WHERE TM1.PaiCod = ? and TM1.ProvCod = ? ORDER BY TM1.PaiCod, TM1.ProvCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00196", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00197", "SELECT PaiCod, ProvCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00198", "SELECT PaiCod, ProvCod FROM Provincia WHERE ( PaiCod > ? or PaiCod = ? and ProvCod > ?) ORDER BY PaiCod, ProvCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00199", "SELECT PaiCod, ProvCod FROM Provincia WHERE ( PaiCod < ? or PaiCod = ? and ProvCod < ?) ORDER BY PaiCod DESC, ProvCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001910", "SAVEPOINT gxupdate;INSERT INTO Provincia(ProvCod, ProvNom, ProvSiradig, PaiCod) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001911", "SAVEPOINT gxupdate;UPDATE Provincia SET ProvNom=?, ProvSiradig=?  WHERE PaiCod = ? AND ProvCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001912", "SAVEPOINT gxupdate;DELETE FROM Provincia  WHERE PaiCod = ? AND ProvCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001913", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001914", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod FROM CategoriaProvincias WHERE CatPaiCod = ? AND CatProvCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001915", "SELECT PaiCod, ProvCod, LocCod FROM Localidad WHERE PaiCod = ? AND ProvCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001916", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE LegPaiCod = ? AND LegProvCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001917", "SELECT PaiCod, ProvCod FROM Provincia ORDER BY PaiCod, ProvCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

