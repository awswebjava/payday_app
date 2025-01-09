package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class rest_location_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"CLICOD") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx1asaclicod6A273( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_8") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_8( A3CliCod) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel1") == 0 )
      {
         gxnrgridlevel1_newrow_invoke( ) ;
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
      if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
      {
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
            AV8RestLocId = httpContext.GetPar( "RestLocId") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8RestLocId", AV8RestLocId);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vRESTLOCID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8RestLocId, ""))));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
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
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "rest_location", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtRestLocId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel1_newrow_invoke( )
   {
      nRC_GXsfl_64 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_64"))) ;
      nGXsfl_64_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_64_idx"))) ;
      sGXsfl_64_idx = httpContext.GetPar( "sGXsfl_64_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel1_newrow( ) ;
      /* End function gxnrGridlevel1_newrow_invoke */
   }

   public rest_location_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public rest_location_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( rest_location_impl.class ));
   }

   public rest_location_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkRestLocHab = UIFactory.getCheckbox(this);
      chkRestLocRHab = UIFactory.getCheckbox(this);
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
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

   public void fix_multi_value_controls( )
   {
      A2172RestLocHab = GXutil.strtobool( GXutil.booltostr( A2172RestLocHab)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2172RestLocHab", A2172RestLocHab);
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
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
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
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRestLocId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtRestLocId_Internalname, httpContext.getMessage( "Loc Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtRestLocId_Internalname, GXutil.rtrim( A2171RestLocId), GXutil.rtrim( localUtil.format( A2171RestLocId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRestLocId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRestLocId_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_rest_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkRestLocHab.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkRestLocHab.getInternalname(), httpContext.getMessage( "Loc Hab", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkRestLocHab.getInternalname(), GXutil.booltostr( A2172RestLocHab), "", httpContext.getMessage( "Loc Hab", ""), 1, chkRestLocHab.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(27, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,27);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRestLocBaseUrl_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtRestLocBaseUrl_Internalname, httpContext.getMessage( "Base Url", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtRestLocBaseUrl_Internalname, A2173RestLocBaseUrl, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", (short)(0), 1, edtRestLocBaseUrl_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "1000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_rest_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRestLocCancelOnError_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtRestLocCancelOnError_Internalname, httpContext.getMessage( "On Error", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtRestLocCancelOnError_Internalname, GXutil.ltrim( localUtil.ntoc( A2174RestLocCancelOnError, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtRestLocCancelOnError_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2174RestLocCancelOnError), "9") : localUtil.format( DecimalUtil.doubleToDec(A2174RestLocCancelOnError), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRestLocCancelOnError_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRestLocCancelOnError_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_rest_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRestLocHost_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtRestLocHost_Internalname, httpContext.getMessage( "Loc Host", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtRestLocHost_Internalname, A2175RestLocHost, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", (short)(0), 1, edtRestLocHost_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_rest_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRestLocPort_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtRestLocPort_Internalname, httpContext.getMessage( "Loc Port", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtRestLocPort_Internalname, GXutil.ltrim( localUtil.ntoc( A2176RestLocPort, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtRestLocPort_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2176RestLocPort), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2176RestLocPort), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRestLocPort_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRestLocPort_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_rest_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRestLocTimeout_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtRestLocTimeout_Internalname, httpContext.getMessage( "Loc Timeout", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtRestLocTimeout_Internalname, GXutil.ltrim( localUtil.ntoc( A2177RestLocTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtRestLocTimeout_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2177RestLocTimeout), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2177RestLocTimeout), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRestLocTimeout_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRestLocTimeout_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_rest_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRestLocSecure_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtRestLocSecure_Internalname, httpContext.getMessage( "Loc Secure", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtRestLocSecure_Internalname, GXutil.ltrim( localUtil.ntoc( A2178RestLocSecure, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtRestLocSecure_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2178RestLocSecure), "9") : localUtil.format( DecimalUtil.doubleToDec(A2178RestLocSecure), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,57);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRestLocSecure_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRestLocSecure_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_rest_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Control Group */
      web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup2_Internalname, httpContext.getMessage( "Replicas", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_rest_location.htm");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /*  Grid Control  */
      startgridcontrol64( ) ;
      nGXsfl_64_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount293 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_293 = (short)(1) ;
            scanStart6A293( ) ;
            while ( RcdFound293 != 0 )
            {
               init_level_properties293( ) ;
               getByPrimaryKey6A293( ) ;
               addRow6A293( ) ;
               scanNext6A293( ) ;
            }
            scanEnd6A293( ) ;
            nBlankRcdCount293 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal6A293( ) ;
         standaloneModal6A293( ) ;
         sMode293 = Gx_mode ;
         while ( nGXsfl_64_idx < nRC_GXsfl_64 )
         {
            bGXsfl_64_Refreshing = true ;
            readRow6A293( ) ;
            edtRestLocRNro_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRNRO_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtRestLocRNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRNro_Enabled), 5, 0), !bGXsfl_64_Refreshing);
            chkRestLocRHab.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRHAB_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, chkRestLocRHab.getInternalname(), "Enabled", GXutil.ltrimstr( chkRestLocRHab.getEnabled(), 5, 0), !bGXsfl_64_Refreshing);
            edtRestLocRBaseUrl_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRBASEURL_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtRestLocRBaseUrl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRBaseUrl_Enabled), 5, 0), !bGXsfl_64_Refreshing);
            edtRestLocRCancel_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRCANCEL_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtRestLocRCancel_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRCancel_Enabled), 5, 0), !bGXsfl_64_Refreshing);
            edtRestLocRHost_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRHOST_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtRestLocRHost_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRHost_Enabled), 5, 0), !bGXsfl_64_Refreshing);
            edtRestLocRPort_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRPORT_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtRestLocRPort_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRPort_Enabled), 5, 0), !bGXsfl_64_Refreshing);
            edtRestLocRSecure_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRSECURE_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtRestLocRSecure_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRSecure_Enabled), 5, 0), !bGXsfl_64_Refreshing);
            edtRestLocRTimeout_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRTIMEOUT_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtRestLocRTimeout_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRTimeout_Enabled), 5, 0), !bGXsfl_64_Refreshing);
            if ( ( nRcdExists_293 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal6A293( ) ;
            }
            sendRow6A293( ) ;
            bGXsfl_64_Refreshing = false ;
         }
         Gx_mode = sMode293 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount293 = (short)(5) ;
         nRcdExists_293 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart6A293( ) ;
            while ( RcdFound293 != 0 )
            {
               sGXsfl_64_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_64_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_64293( ) ;
               init_level_properties293( ) ;
               standaloneNotModal6A293( ) ;
               getByPrimaryKey6A293( ) ;
               standaloneModal6A293( ) ;
               addRow6A293( ) ;
               scanNext6A293( ) ;
            }
            scanEnd6A293( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode293 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_64_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_64_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_64293( ) ;
         initAll6A293( ) ;
         init_level_properties293( ) ;
         nRcdExists_293 = (short)(0) ;
         nIsMod_293 = (short)(0) ;
         nRcdDeleted_293 = (short)(0) ;
         nBlankRcdCount293 = (short)(nBlankRcdUsr293+nBlankRcdCount293) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount293 > 0 )
         {
            standaloneNotModal6A293( ) ;
            standaloneModal6A293( ) ;
            addRow6A293( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtRestLocRNro_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount293 = (short)(nBlankRcdCount293-1) ;
         }
         Gx_mode = sMode293 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel1Container"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel1", Gridlevel1Container, subGridlevel1_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel1ContainerData", Gridlevel1Container.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel1ContainerData"+"V", Gridlevel1Container.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel1ContainerData"+"V"+"\" value='"+Gridlevel1Container.GridValuesHidden()+"'/>") ;
      }
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
      httpContext.writeText( "</fieldset>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 80,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_rest_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_rest_location.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_rest_location.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,88);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_rest_location.htm");
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
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e116A2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2171RestLocId = httpContext.cgiGet( "Z2171RestLocId") ;
            Z2172RestLocHab = GXutil.strtobool( httpContext.cgiGet( "Z2172RestLocHab")) ;
            Z2173RestLocBaseUrl = httpContext.cgiGet( "Z2173RestLocBaseUrl") ;
            Z2174RestLocCancelOnError = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2174RestLocCancelOnError"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2175RestLocHost = httpContext.cgiGet( "Z2175RestLocHost") ;
            Z2176RestLocPort = (int)(localUtil.ctol( httpContext.cgiGet( "Z2176RestLocPort"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2177RestLocTimeout = (short)(localUtil.ctol( httpContext.cgiGet( "Z2177RestLocTimeout"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2178RestLocSecure = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2178RestLocSecure"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_64 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_64"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8RestLocId = httpContext.cgiGet( "vRESTLOCID") ;
            AV20Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            A2171RestLocId = httpContext.cgiGet( edtRestLocId_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2171RestLocId", A2171RestLocId);
            A2172RestLocHab = GXutil.strtobool( httpContext.cgiGet( chkRestLocHab.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2172RestLocHab", A2172RestLocHab);
            A2173RestLocBaseUrl = httpContext.cgiGet( edtRestLocBaseUrl_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2173RestLocBaseUrl", A2173RestLocBaseUrl);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocCancelOnError_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocCancelOnError_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "RESTLOCCANCELONERROR");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRestLocCancelOnError_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2174RestLocCancelOnError = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2174RestLocCancelOnError", GXutil.str( A2174RestLocCancelOnError, 1, 0));
            }
            else
            {
               A2174RestLocCancelOnError = (byte)(localUtil.ctol( httpContext.cgiGet( edtRestLocCancelOnError_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2174RestLocCancelOnError", GXutil.str( A2174RestLocCancelOnError, 1, 0));
            }
            A2175RestLocHost = httpContext.cgiGet( edtRestLocHost_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2175RestLocHost", A2175RestLocHost);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocPort_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocPort_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "RESTLOCPORT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRestLocPort_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2176RestLocPort = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A2176RestLocPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2176RestLocPort), 8, 0));
            }
            else
            {
               A2176RestLocPort = (int)(localUtil.ctol( httpContext.cgiGet( edtRestLocPort_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2176RestLocPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2176RestLocPort), 8, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocTimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocTimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "RESTLOCTIMEOUT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRestLocTimeout_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2177RestLocTimeout = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2177RestLocTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2177RestLocTimeout), 4, 0));
            }
            else
            {
               A2177RestLocTimeout = (short)(localUtil.ctol( httpContext.cgiGet( edtRestLocTimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2177RestLocTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2177RestLocTimeout), 4, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocSecure_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocSecure_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "RESTLOCSECURE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRestLocSecure_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2178RestLocSecure = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2178RestLocSecure", GXutil.str( A2178RestLocSecure, 1, 0));
            }
            else
            {
               A2178RestLocSecure = (byte)(localUtil.ctol( httpContext.cgiGet( edtRestLocSecure_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2178RestLocSecure", GXutil.str( A2178RestLocSecure, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A3CliCod = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            else
            {
               A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"rest_location");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A2171RestLocId, Z2171RestLocId) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("rest_location:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A2171RestLocId = httpContext.GetPar( "RestLocId") ;
               httpContext.ajax_rsp_assign_attri("", false, "A2171RestLocId", A2171RestLocId);
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode273 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode273 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound273 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_6A0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
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
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e116A2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e126A2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                  }
                  else
                  {
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
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
         e126A2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll6A273( ) ;
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
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes6A273( ) ;
      }
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

   public void confirm_6A0( )
   {
      beforeValidate6A273( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls6A273( ) ;
         }
         else
         {
            checkExtendedTable6A273( ) ;
            closeExtendedTableCursors6A273( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode273 = Gx_mode ;
         confirm_6A293( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode273 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode273 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_6A293( )
   {
      nGXsfl_64_idx = 0 ;
      while ( nGXsfl_64_idx < nRC_GXsfl_64 )
      {
         readRow6A293( ) ;
         if ( ( nRcdExists_293 != 0 ) || ( nIsMod_293 != 0 ) )
         {
            getKey6A293( ) ;
            if ( ( nRcdExists_293 == 0 ) && ( nRcdDeleted_293 == 0 ) )
            {
               if ( RcdFound293 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate6A293( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable6A293( ) ;
                     closeExtendedTableCursors6A293( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "RESTLOCRNRO_" + sGXsfl_64_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtRestLocRNro_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound293 != 0 )
               {
                  if ( nRcdDeleted_293 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey6A293( ) ;
                     load6A293( ) ;
                     beforeValidate6A293( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls6A293( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_293 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate6A293( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable6A293( ) ;
                           closeExtendedTableCursors6A293( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_293 == 0 )
                  {
                     GXCCtl = "RESTLOCRNRO_" + sGXsfl_64_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtRestLocRNro_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtRestLocRNro_Internalname, GXutil.ltrim( localUtil.ntoc( A2333RestLocRNro, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( chkRestLocRHab.getInternalname(), GXutil.booltostr( A2334RestLocRHab)) ;
         httpContext.changePostValue( edtRestLocRBaseUrl_Internalname, A2335RestLocRBaseUrl) ;
         httpContext.changePostValue( edtRestLocRCancel_Internalname, GXutil.ltrim( localUtil.ntoc( A2336RestLocRCancel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtRestLocRHost_Internalname, A2337RestLocRHost) ;
         httpContext.changePostValue( edtRestLocRPort_Internalname, GXutil.ltrim( localUtil.ntoc( A2338RestLocRPort, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtRestLocRSecure_Internalname, GXutil.ltrim( localUtil.ntoc( A2340RestLocRSecure, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtRestLocRTimeout_Internalname, GXutil.ltrim( localUtil.ntoc( A2339RestLocRTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2333RestLocRNro_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( Z2333RestLocRNro, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2334RestLocRHab_"+sGXsfl_64_idx, GXutil.booltostr( Z2334RestLocRHab)) ;
         httpContext.changePostValue( "ZT_"+"Z2335RestLocRBaseUrl_"+sGXsfl_64_idx, Z2335RestLocRBaseUrl) ;
         httpContext.changePostValue( "ZT_"+"Z2336RestLocRCancel_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( Z2336RestLocRCancel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2337RestLocRHost_"+sGXsfl_64_idx, Z2337RestLocRHost) ;
         httpContext.changePostValue( "ZT_"+"Z2338RestLocRPort_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( Z2338RestLocRPort, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2339RestLocRTimeout_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( Z2339RestLocRTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2340RestLocRSecure_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( Z2340RestLocRSecure, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_293_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_293, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_293_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_293, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_293_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_293, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_293 != 0 )
         {
            httpContext.changePostValue( "RESTLOCRNRO_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRNro_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "RESTLOCRHAB_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkRestLocRHab.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "RESTLOCRBASEURL_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRBaseUrl_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "RESTLOCRCANCEL_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRCancel_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "RESTLOCRHOST_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRHost_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "RESTLOCRPORT_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRPort_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "RESTLOCRSECURE_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRSecure_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "RESTLOCRTIMEOUT_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRTimeout_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption6A0( )
   {
   }

   public void e116A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      AV10IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWrest_location_Insert", GXv_boolean3) ;
         rest_location_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWrest_location_Update", GXv_boolean3) ;
         rest_location_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWrest_location_Delete", GXv_boolean3) ;
         rest_location_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV20Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
   }

   public void e126A2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm6A273( int GX_JID )
   {
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2172RestLocHab = T006A5_A2172RestLocHab[0] ;
            Z2173RestLocBaseUrl = T006A5_A2173RestLocBaseUrl[0] ;
            Z2174RestLocCancelOnError = T006A5_A2174RestLocCancelOnError[0] ;
            Z2175RestLocHost = T006A5_A2175RestLocHost[0] ;
            Z2176RestLocPort = T006A5_A2176RestLocPort[0] ;
            Z2177RestLocTimeout = T006A5_A2177RestLocTimeout[0] ;
            Z2178RestLocSecure = T006A5_A2178RestLocSecure[0] ;
         }
         else
         {
            Z2172RestLocHab = A2172RestLocHab ;
            Z2173RestLocBaseUrl = A2173RestLocBaseUrl ;
            Z2174RestLocCancelOnError = A2174RestLocCancelOnError ;
            Z2175RestLocHost = A2175RestLocHost ;
            Z2176RestLocPort = A2176RestLocPort ;
            Z2177RestLocTimeout = A2177RestLocTimeout ;
            Z2178RestLocSecure = A2178RestLocSecure ;
         }
      }
      if ( GX_JID == -7 )
      {
         Z2171RestLocId = A2171RestLocId ;
         Z2172RestLocHab = A2172RestLocHab ;
         Z2173RestLocBaseUrl = A2173RestLocBaseUrl ;
         Z2174RestLocCancelOnError = A2174RestLocCancelOnError ;
         Z2175RestLocHost = A2175RestLocHost ;
         Z2176RestLocPort = A2176RestLocPort ;
         Z2177RestLocTimeout = A2177RestLocTimeout ;
         Z2178RestLocSecure = A2178RestLocSecure ;
         Z3CliCod = A3CliCod ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            rest_location_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8RestLocId)==0) )
      {
         A2171RestLocId = AV8RestLocId ;
         httpContext.ajax_rsp_assign_attri("", false, "A2171RestLocId", A2171RestLocId);
      }
      if ( ! (GXutil.strcmp("", AV8RestLocId)==0) )
      {
         edtRestLocId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtRestLocId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocId_Enabled), 5, 0), true);
      }
      else
      {
         edtRestLocId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtRestLocId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocId_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8RestLocId)==0) )
      {
         edtRestLocId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtRestLocId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV20Pgmname = "rest_location" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      }
   }

   public void load6A273( )
   {
      /* Using cursor T006A7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound273 = (short)(1) ;
         A2172RestLocHab = T006A7_A2172RestLocHab[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2172RestLocHab", A2172RestLocHab);
         A2173RestLocBaseUrl = T006A7_A2173RestLocBaseUrl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2173RestLocBaseUrl", A2173RestLocBaseUrl);
         A2174RestLocCancelOnError = T006A7_A2174RestLocCancelOnError[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2174RestLocCancelOnError", GXutil.str( A2174RestLocCancelOnError, 1, 0));
         A2175RestLocHost = T006A7_A2175RestLocHost[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2175RestLocHost", A2175RestLocHost);
         A2176RestLocPort = T006A7_A2176RestLocPort[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2176RestLocPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2176RestLocPort), 8, 0));
         A2177RestLocTimeout = T006A7_A2177RestLocTimeout[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2177RestLocTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2177RestLocTimeout), 4, 0));
         A2178RestLocSecure = T006A7_A2178RestLocSecure[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2178RestLocSecure", GXutil.str( A2178RestLocSecure, 1, 0));
         zm6A273( -7) ;
      }
      pr_default.close(5);
      onLoadActions6A273( ) ;
   }

   public void onLoadActions6A273( )
   {
      AV20Pgmname = "rest_location" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
   }

   public void checkExtendedTable6A273( )
   {
      nIsDirty_273 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV20Pgmname = "rest_location" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      /* Using cursor T006A6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
   }

   public void closeExtendedTableCursors6A273( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_8( int A3CliCod )
   {
      /* Using cursor T006A8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey6A273( )
   {
      /* Using cursor T006A9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound273 = (short)(1) ;
      }
      else
      {
         RcdFound273 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T006A5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm6A273( 7) ;
         RcdFound273 = (short)(1) ;
         A2171RestLocId = T006A5_A2171RestLocId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2171RestLocId", A2171RestLocId);
         A2172RestLocHab = T006A5_A2172RestLocHab[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2172RestLocHab", A2172RestLocHab);
         A2173RestLocBaseUrl = T006A5_A2173RestLocBaseUrl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2173RestLocBaseUrl", A2173RestLocBaseUrl);
         A2174RestLocCancelOnError = T006A5_A2174RestLocCancelOnError[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2174RestLocCancelOnError", GXutil.str( A2174RestLocCancelOnError, 1, 0));
         A2175RestLocHost = T006A5_A2175RestLocHost[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2175RestLocHost", A2175RestLocHost);
         A2176RestLocPort = T006A5_A2176RestLocPort[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2176RestLocPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2176RestLocPort), 8, 0));
         A2177RestLocTimeout = T006A5_A2177RestLocTimeout[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2177RestLocTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2177RestLocTimeout), 4, 0));
         A2178RestLocSecure = T006A5_A2178RestLocSecure[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2178RestLocSecure", GXutil.str( A2178RestLocSecure, 1, 0));
         A3CliCod = T006A5_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         Z3CliCod = A3CliCod ;
         Z2171RestLocId = A2171RestLocId ;
         sMode273 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load6A273( ) ;
         if ( AnyError == 1 )
         {
            RcdFound273 = (short)(0) ;
            initializeNonKey6A273( ) ;
         }
         Gx_mode = sMode273 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound273 = (short)(0) ;
         initializeNonKey6A273( ) ;
         sMode273 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode273 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey6A273( ) ;
      if ( RcdFound273 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound273 = (short)(0) ;
      /* Using cursor T006A10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A2171RestLocId});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T006A10_A3CliCod[0] < A3CliCod ) || ( T006A10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006A10_A2171RestLocId[0], A2171RestLocId) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T006A10_A3CliCod[0] > A3CliCod ) || ( T006A10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006A10_A2171RestLocId[0], A2171RestLocId) > 0 ) ) )
         {
            A3CliCod = T006A10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A2171RestLocId = T006A10_A2171RestLocId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2171RestLocId", A2171RestLocId);
            RcdFound273 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound273 = (short)(0) ;
      /* Using cursor T006A11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A2171RestLocId});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T006A11_A3CliCod[0] > A3CliCod ) || ( T006A11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006A11_A2171RestLocId[0], A2171RestLocId) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T006A11_A3CliCod[0] < A3CliCod ) || ( T006A11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006A11_A2171RestLocId[0], A2171RestLocId) < 0 ) ) )
         {
            A3CliCod = T006A11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A2171RestLocId = T006A11_A2171RestLocId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2171RestLocId", A2171RestLocId);
            RcdFound273 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey6A273( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtRestLocId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert6A273( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound273 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A2171RestLocId, Z2171RestLocId) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A2171RestLocId = Z2171RestLocId ;
               httpContext.ajax_rsp_assign_attri("", false, "A2171RestLocId", A2171RestLocId);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtRestLocId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update6A273( ) ;
               GX_FocusControl = edtRestLocId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A2171RestLocId, Z2171RestLocId) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtRestLocId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert6A273( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtRestLocId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert6A273( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A2171RestLocId, Z2171RestLocId) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A2171RestLocId = Z2171RestLocId ;
         httpContext.ajax_rsp_assign_attri("", false, "A2171RestLocId", A2171RestLocId);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtRestLocId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency6A273( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T006A4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"rest_location"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(2) == 101) || ( Z2172RestLocHab != T006A4_A2172RestLocHab[0] ) || ( GXutil.strcmp(Z2173RestLocBaseUrl, T006A4_A2173RestLocBaseUrl[0]) != 0 ) || ( Z2174RestLocCancelOnError != T006A4_A2174RestLocCancelOnError[0] ) || ( GXutil.strcmp(Z2175RestLocHost, T006A4_A2175RestLocHost[0]) != 0 ) || ( Z2176RestLocPort != T006A4_A2176RestLocPort[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2177RestLocTimeout != T006A4_A2177RestLocTimeout[0] ) || ( Z2178RestLocSecure != T006A4_A2178RestLocSecure[0] ) )
         {
            if ( Z2172RestLocHab != T006A4_A2172RestLocHab[0] )
            {
               GXutil.writeLogln("rest_location:[seudo value changed for attri]"+"RestLocHab");
               GXutil.writeLogRaw("Old: ",Z2172RestLocHab);
               GXutil.writeLogRaw("Current: ",T006A4_A2172RestLocHab[0]);
            }
            if ( GXutil.strcmp(Z2173RestLocBaseUrl, T006A4_A2173RestLocBaseUrl[0]) != 0 )
            {
               GXutil.writeLogln("rest_location:[seudo value changed for attri]"+"RestLocBaseUrl");
               GXutil.writeLogRaw("Old: ",Z2173RestLocBaseUrl);
               GXutil.writeLogRaw("Current: ",T006A4_A2173RestLocBaseUrl[0]);
            }
            if ( Z2174RestLocCancelOnError != T006A4_A2174RestLocCancelOnError[0] )
            {
               GXutil.writeLogln("rest_location:[seudo value changed for attri]"+"RestLocCancelOnError");
               GXutil.writeLogRaw("Old: ",Z2174RestLocCancelOnError);
               GXutil.writeLogRaw("Current: ",T006A4_A2174RestLocCancelOnError[0]);
            }
            if ( GXutil.strcmp(Z2175RestLocHost, T006A4_A2175RestLocHost[0]) != 0 )
            {
               GXutil.writeLogln("rest_location:[seudo value changed for attri]"+"RestLocHost");
               GXutil.writeLogRaw("Old: ",Z2175RestLocHost);
               GXutil.writeLogRaw("Current: ",T006A4_A2175RestLocHost[0]);
            }
            if ( Z2176RestLocPort != T006A4_A2176RestLocPort[0] )
            {
               GXutil.writeLogln("rest_location:[seudo value changed for attri]"+"RestLocPort");
               GXutil.writeLogRaw("Old: ",Z2176RestLocPort);
               GXutil.writeLogRaw("Current: ",T006A4_A2176RestLocPort[0]);
            }
            if ( Z2177RestLocTimeout != T006A4_A2177RestLocTimeout[0] )
            {
               GXutil.writeLogln("rest_location:[seudo value changed for attri]"+"RestLocTimeout");
               GXutil.writeLogRaw("Old: ",Z2177RestLocTimeout);
               GXutil.writeLogRaw("Current: ",T006A4_A2177RestLocTimeout[0]);
            }
            if ( Z2178RestLocSecure != T006A4_A2178RestLocSecure[0] )
            {
               GXutil.writeLogln("rest_location:[seudo value changed for attri]"+"RestLocSecure");
               GXutil.writeLogRaw("Old: ",Z2178RestLocSecure);
               GXutil.writeLogRaw("Current: ",T006A4_A2178RestLocSecure[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"rest_location"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert6A273( )
   {
      beforeValidate6A273( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6A273( ) ;
      }
      if ( AnyError == 0 )
      {
         zm6A273( 0) ;
         checkOptimisticConcurrency6A273( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6A273( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert6A273( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006A12 */
                  pr_default.execute(10, new Object[] {A2171RestLocId, Boolean.valueOf(A2172RestLocHab), A2173RestLocBaseUrl, Byte.valueOf(A2174RestLocCancelOnError), A2175RestLocHost, Integer.valueOf(A2176RestLocPort), Short.valueOf(A2177RestLocTimeout), Byte.valueOf(A2178RestLocSecure), Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("rest_location");
                  if ( (pr_default.getStatus(10) == 1) )
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
                        processLevel6A273( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption6A0( ) ;
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
         else
         {
            load6A273( ) ;
         }
         endLevel6A273( ) ;
      }
      closeExtendedTableCursors6A273( ) ;
   }

   public void update6A273( )
   {
      beforeValidate6A273( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6A273( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6A273( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6A273( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate6A273( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006A13 */
                  pr_default.execute(11, new Object[] {Boolean.valueOf(A2172RestLocHab), A2173RestLocBaseUrl, Byte.valueOf(A2174RestLocCancelOnError), A2175RestLocHost, Integer.valueOf(A2176RestLocPort), Short.valueOf(A2177RestLocTimeout), Byte.valueOf(A2178RestLocSecure), Integer.valueOf(A3CliCod), A2171RestLocId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("rest_location");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"rest_location"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate6A273( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel6A273( ) ;
                        if ( AnyError == 0 )
                        {
                           if ( isUpd( ) || isDlt( ) )
                           {
                              if ( AnyError == 0 )
                              {
                                 httpContext.nUserReturn = (byte)(1) ;
                              }
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
         endLevel6A273( ) ;
      }
      closeExtendedTableCursors6A273( ) ;
   }

   public void deferredUpdate6A273( )
   {
   }

   public void delete( )
   {
      beforeValidate6A273( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6A273( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls6A273( ) ;
         afterConfirm6A273( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete6A273( ) ;
            if ( AnyError == 0 )
            {
               scanStart6A293( ) ;
               while ( RcdFound293 != 0 )
               {
                  getByPrimaryKey6A293( ) ;
                  delete6A293( ) ;
                  scanNext6A293( ) ;
               }
               scanEnd6A293( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006A14 */
                  pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("rest_location");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
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
      }
      sMode273 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel6A273( ) ;
      Gx_mode = sMode273 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls6A273( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV20Pgmname = "rest_location" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      }
   }

   public void processNestedLevel6A293( )
   {
      nGXsfl_64_idx = 0 ;
      while ( nGXsfl_64_idx < nRC_GXsfl_64 )
      {
         readRow6A293( ) ;
         if ( ( nRcdExists_293 != 0 ) || ( nIsMod_293 != 0 ) )
         {
            standaloneNotModal6A293( ) ;
            getKey6A293( ) ;
            if ( ( nRcdExists_293 == 0 ) && ( nRcdDeleted_293 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert6A293( ) ;
            }
            else
            {
               if ( RcdFound293 != 0 )
               {
                  if ( ( nRcdDeleted_293 != 0 ) && ( nRcdExists_293 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete6A293( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_293 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update6A293( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_293 == 0 )
                  {
                     GXCCtl = "RESTLOCRNRO_" + sGXsfl_64_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtRestLocRNro_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtRestLocRNro_Internalname, GXutil.ltrim( localUtil.ntoc( A2333RestLocRNro, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( chkRestLocRHab.getInternalname(), GXutil.booltostr( A2334RestLocRHab)) ;
         httpContext.changePostValue( edtRestLocRBaseUrl_Internalname, A2335RestLocRBaseUrl) ;
         httpContext.changePostValue( edtRestLocRCancel_Internalname, GXutil.ltrim( localUtil.ntoc( A2336RestLocRCancel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtRestLocRHost_Internalname, A2337RestLocRHost) ;
         httpContext.changePostValue( edtRestLocRPort_Internalname, GXutil.ltrim( localUtil.ntoc( A2338RestLocRPort, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtRestLocRSecure_Internalname, GXutil.ltrim( localUtil.ntoc( A2340RestLocRSecure, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtRestLocRTimeout_Internalname, GXutil.ltrim( localUtil.ntoc( A2339RestLocRTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2333RestLocRNro_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( Z2333RestLocRNro, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2334RestLocRHab_"+sGXsfl_64_idx, GXutil.booltostr( Z2334RestLocRHab)) ;
         httpContext.changePostValue( "ZT_"+"Z2335RestLocRBaseUrl_"+sGXsfl_64_idx, Z2335RestLocRBaseUrl) ;
         httpContext.changePostValue( "ZT_"+"Z2336RestLocRCancel_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( Z2336RestLocRCancel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2337RestLocRHost_"+sGXsfl_64_idx, Z2337RestLocRHost) ;
         httpContext.changePostValue( "ZT_"+"Z2338RestLocRPort_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( Z2338RestLocRPort, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2339RestLocRTimeout_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( Z2339RestLocRTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2340RestLocRSecure_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( Z2340RestLocRSecure, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_293_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_293, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_293_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_293, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_293_"+sGXsfl_64_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_293, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_293 != 0 )
         {
            httpContext.changePostValue( "RESTLOCRNRO_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRNro_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "RESTLOCRHAB_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkRestLocRHab.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "RESTLOCRBASEURL_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRBaseUrl_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "RESTLOCRCANCEL_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRCancel_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "RESTLOCRHOST_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRHost_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "RESTLOCRPORT_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRPort_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "RESTLOCRSECURE_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRSecure_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "RESTLOCRTIMEOUT_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRTimeout_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll6A293( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_293 = (short)(0) ;
      nIsMod_293 = (short)(0) ;
      nRcdDeleted_293 = (short)(0) ;
   }

   public void processLevel6A273( )
   {
      /* Save parent mode. */
      sMode273 = Gx_mode ;
      processNestedLevel6A293( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode273 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel6A273( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete6A273( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "rest_location");
         if ( AnyError == 0 )
         {
            confirmValues6A0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "rest_location");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart6A273( )
   {
      /* Scan By routine */
      /* Using cursor T006A15 */
      pr_default.execute(13);
      RcdFound273 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound273 = (short)(1) ;
         A3CliCod = T006A15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A2171RestLocId = T006A15_A2171RestLocId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2171RestLocId", A2171RestLocId);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext6A273( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound273 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound273 = (short)(1) ;
         A3CliCod = T006A15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A2171RestLocId = T006A15_A2171RestLocId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2171RestLocId", A2171RestLocId);
      }
   }

   public void scanEnd6A273( )
   {
      pr_default.close(13);
   }

   public void afterConfirm6A273( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert6A273( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate6A273( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete6A273( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete6A273( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate6A273( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes6A273( )
   {
      edtRestLocId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocId_Enabled), 5, 0), true);
      chkRestLocHab.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkRestLocHab.getInternalname(), "Enabled", GXutil.ltrimstr( chkRestLocHab.getEnabled(), 5, 0), true);
      edtRestLocBaseUrl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocBaseUrl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocBaseUrl_Enabled), 5, 0), true);
      edtRestLocCancelOnError_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocCancelOnError_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocCancelOnError_Enabled), 5, 0), true);
      edtRestLocHost_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocHost_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocHost_Enabled), 5, 0), true);
      edtRestLocPort_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocPort_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocPort_Enabled), 5, 0), true);
      edtRestLocTimeout_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocTimeout_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocTimeout_Enabled), 5, 0), true);
      edtRestLocSecure_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocSecure_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocSecure_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void zm6A293( int GX_JID )
   {
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2334RestLocRHab = T006A3_A2334RestLocRHab[0] ;
            Z2335RestLocRBaseUrl = T006A3_A2335RestLocRBaseUrl[0] ;
            Z2336RestLocRCancel = T006A3_A2336RestLocRCancel[0] ;
            Z2337RestLocRHost = T006A3_A2337RestLocRHost[0] ;
            Z2338RestLocRPort = T006A3_A2338RestLocRPort[0] ;
            Z2339RestLocRTimeout = T006A3_A2339RestLocRTimeout[0] ;
            Z2340RestLocRSecure = T006A3_A2340RestLocRSecure[0] ;
         }
         else
         {
            Z2334RestLocRHab = A2334RestLocRHab ;
            Z2335RestLocRBaseUrl = A2335RestLocRBaseUrl ;
            Z2336RestLocRCancel = A2336RestLocRCancel ;
            Z2337RestLocRHost = A2337RestLocRHost ;
            Z2338RestLocRPort = A2338RestLocRPort ;
            Z2339RestLocRTimeout = A2339RestLocRTimeout ;
            Z2340RestLocRSecure = A2340RestLocRSecure ;
         }
      }
      if ( GX_JID == -9 )
      {
         Z3CliCod = A3CliCod ;
         Z2171RestLocId = A2171RestLocId ;
         Z2333RestLocRNro = A2333RestLocRNro ;
         Z2334RestLocRHab = A2334RestLocRHab ;
         Z2335RestLocRBaseUrl = A2335RestLocRBaseUrl ;
         Z2336RestLocRCancel = A2336RestLocRCancel ;
         Z2337RestLocRHost = A2337RestLocRHost ;
         Z2338RestLocRPort = A2338RestLocRPort ;
         Z2339RestLocRTimeout = A2339RestLocRTimeout ;
         Z2340RestLocRSecure = A2340RestLocRSecure ;
      }
   }

   public void standaloneNotModal6A293( )
   {
   }

   public void standaloneModal6A293( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtRestLocRNro_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtRestLocRNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRNro_Enabled), 5, 0), !bGXsfl_64_Refreshing);
      }
      else
      {
         edtRestLocRNro_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtRestLocRNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRNro_Enabled), 5, 0), !bGXsfl_64_Refreshing);
      }
   }

   public void load6A293( )
   {
      /* Using cursor T006A16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId, Short.valueOf(A2333RestLocRNro)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound293 = (short)(1) ;
         A2334RestLocRHab = T006A16_A2334RestLocRHab[0] ;
         A2335RestLocRBaseUrl = T006A16_A2335RestLocRBaseUrl[0] ;
         A2336RestLocRCancel = T006A16_A2336RestLocRCancel[0] ;
         A2337RestLocRHost = T006A16_A2337RestLocRHost[0] ;
         A2338RestLocRPort = T006A16_A2338RestLocRPort[0] ;
         A2339RestLocRTimeout = T006A16_A2339RestLocRTimeout[0] ;
         A2340RestLocRSecure = T006A16_A2340RestLocRSecure[0] ;
         zm6A293( -9) ;
      }
      pr_default.close(14);
      onLoadActions6A293( ) ;
   }

   public void onLoadActions6A293( )
   {
   }

   public void checkExtendedTable6A293( )
   {
      nIsDirty_293 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal6A293( ) ;
   }

   public void closeExtendedTableCursors6A293( )
   {
   }

   public void enableDisable6A293( )
   {
   }

   public void getKey6A293( )
   {
      /* Using cursor T006A17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId, Short.valueOf(A2333RestLocRNro)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound293 = (short)(1) ;
      }
      else
      {
         RcdFound293 = (short)(0) ;
      }
      pr_default.close(15);
   }

   public void getByPrimaryKey6A293( )
   {
      /* Using cursor T006A3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId, Short.valueOf(A2333RestLocRNro)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm6A293( 9) ;
         RcdFound293 = (short)(1) ;
         initializeNonKey6A293( ) ;
         A2333RestLocRNro = T006A3_A2333RestLocRNro[0] ;
         A2334RestLocRHab = T006A3_A2334RestLocRHab[0] ;
         A2335RestLocRBaseUrl = T006A3_A2335RestLocRBaseUrl[0] ;
         A2336RestLocRCancel = T006A3_A2336RestLocRCancel[0] ;
         A2337RestLocRHost = T006A3_A2337RestLocRHost[0] ;
         A2338RestLocRPort = T006A3_A2338RestLocRPort[0] ;
         A2339RestLocRTimeout = T006A3_A2339RestLocRTimeout[0] ;
         A2340RestLocRSecure = T006A3_A2340RestLocRSecure[0] ;
         Z3CliCod = A3CliCod ;
         Z2171RestLocId = A2171RestLocId ;
         Z2333RestLocRNro = A2333RestLocRNro ;
         sMode293 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load6A293( ) ;
         Gx_mode = sMode293 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound293 = (short)(0) ;
         initializeNonKey6A293( ) ;
         sMode293 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal6A293( ) ;
         Gx_mode = sMode293 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes6A293( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency6A293( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T006A2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId, Short.valueOf(A2333RestLocRNro)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"rest_locationreplicas"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z2334RestLocRHab != T006A2_A2334RestLocRHab[0] ) || ( GXutil.strcmp(Z2335RestLocRBaseUrl, T006A2_A2335RestLocRBaseUrl[0]) != 0 ) || ( Z2336RestLocRCancel != T006A2_A2336RestLocRCancel[0] ) || ( GXutil.strcmp(Z2337RestLocRHost, T006A2_A2337RestLocRHost[0]) != 0 ) || ( Z2338RestLocRPort != T006A2_A2338RestLocRPort[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2339RestLocRTimeout != T006A2_A2339RestLocRTimeout[0] ) || ( Z2340RestLocRSecure != T006A2_A2340RestLocRSecure[0] ) )
         {
            if ( Z2334RestLocRHab != T006A2_A2334RestLocRHab[0] )
            {
               GXutil.writeLogln("rest_location:[seudo value changed for attri]"+"RestLocRHab");
               GXutil.writeLogRaw("Old: ",Z2334RestLocRHab);
               GXutil.writeLogRaw("Current: ",T006A2_A2334RestLocRHab[0]);
            }
            if ( GXutil.strcmp(Z2335RestLocRBaseUrl, T006A2_A2335RestLocRBaseUrl[0]) != 0 )
            {
               GXutil.writeLogln("rest_location:[seudo value changed for attri]"+"RestLocRBaseUrl");
               GXutil.writeLogRaw("Old: ",Z2335RestLocRBaseUrl);
               GXutil.writeLogRaw("Current: ",T006A2_A2335RestLocRBaseUrl[0]);
            }
            if ( Z2336RestLocRCancel != T006A2_A2336RestLocRCancel[0] )
            {
               GXutil.writeLogln("rest_location:[seudo value changed for attri]"+"RestLocRCancel");
               GXutil.writeLogRaw("Old: ",Z2336RestLocRCancel);
               GXutil.writeLogRaw("Current: ",T006A2_A2336RestLocRCancel[0]);
            }
            if ( GXutil.strcmp(Z2337RestLocRHost, T006A2_A2337RestLocRHost[0]) != 0 )
            {
               GXutil.writeLogln("rest_location:[seudo value changed for attri]"+"RestLocRHost");
               GXutil.writeLogRaw("Old: ",Z2337RestLocRHost);
               GXutil.writeLogRaw("Current: ",T006A2_A2337RestLocRHost[0]);
            }
            if ( Z2338RestLocRPort != T006A2_A2338RestLocRPort[0] )
            {
               GXutil.writeLogln("rest_location:[seudo value changed for attri]"+"RestLocRPort");
               GXutil.writeLogRaw("Old: ",Z2338RestLocRPort);
               GXutil.writeLogRaw("Current: ",T006A2_A2338RestLocRPort[0]);
            }
            if ( Z2339RestLocRTimeout != T006A2_A2339RestLocRTimeout[0] )
            {
               GXutil.writeLogln("rest_location:[seudo value changed for attri]"+"RestLocRTimeout");
               GXutil.writeLogRaw("Old: ",Z2339RestLocRTimeout);
               GXutil.writeLogRaw("Current: ",T006A2_A2339RestLocRTimeout[0]);
            }
            if ( Z2340RestLocRSecure != T006A2_A2340RestLocRSecure[0] )
            {
               GXutil.writeLogln("rest_location:[seudo value changed for attri]"+"RestLocRSecure");
               GXutil.writeLogRaw("Old: ",Z2340RestLocRSecure);
               GXutil.writeLogRaw("Current: ",T006A2_A2340RestLocRSecure[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"rest_locationreplicas"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert6A293( )
   {
      beforeValidate6A293( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6A293( ) ;
      }
      if ( AnyError == 0 )
      {
         zm6A293( 0) ;
         checkOptimisticConcurrency6A293( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6A293( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert6A293( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006A18 */
                  pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId, Short.valueOf(A2333RestLocRNro), Boolean.valueOf(A2334RestLocRHab), A2335RestLocRBaseUrl, Byte.valueOf(A2336RestLocRCancel), A2337RestLocRHost, Integer.valueOf(A2338RestLocRPort), Short.valueOf(A2339RestLocRTimeout), Byte.valueOf(A2340RestLocRSecure)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("rest_locationreplicas");
                  if ( (pr_default.getStatus(16) == 1) )
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
            load6A293( ) ;
         }
         endLevel6A293( ) ;
      }
      closeExtendedTableCursors6A293( ) ;
   }

   public void update6A293( )
   {
      beforeValidate6A293( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6A293( ) ;
      }
      if ( ( nIsMod_293 != 0 ) || ( nIsDirty_293 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency6A293( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm6A293( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate6A293( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T006A19 */
                     pr_default.execute(17, new Object[] {Boolean.valueOf(A2334RestLocRHab), A2335RestLocRBaseUrl, Byte.valueOf(A2336RestLocRCancel), A2337RestLocRHost, Integer.valueOf(A2338RestLocRPort), Short.valueOf(A2339RestLocRTimeout), Byte.valueOf(A2340RestLocRSecure), Integer.valueOf(A3CliCod), A2171RestLocId, Short.valueOf(A2333RestLocRNro)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("rest_locationreplicas");
                     if ( (pr_default.getStatus(17) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"rest_locationreplicas"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate6A293( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey6A293( ) ;
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
            endLevel6A293( ) ;
         }
      }
      closeExtendedTableCursors6A293( ) ;
   }

   public void deferredUpdate6A293( )
   {
   }

   public void delete6A293( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate6A293( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6A293( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls6A293( ) ;
         afterConfirm6A293( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete6A293( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T006A20 */
               pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId, Short.valueOf(A2333RestLocRNro)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("rest_locationreplicas");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode293 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel6A293( ) ;
      Gx_mode = sMode293 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls6A293( )
   {
      standaloneModal6A293( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel6A293( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart6A293( )
   {
      /* Scan By routine */
      /* Using cursor T006A21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), A2171RestLocId});
      RcdFound293 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound293 = (short)(1) ;
         A2333RestLocRNro = T006A21_A2333RestLocRNro[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext6A293( )
   {
      /* Scan next routine */
      pr_default.readNext(19);
      RcdFound293 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound293 = (short)(1) ;
         A2333RestLocRNro = T006A21_A2333RestLocRNro[0] ;
      }
   }

   public void scanEnd6A293( )
   {
      pr_default.close(19);
   }

   public void afterConfirm6A293( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert6A293( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate6A293( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete6A293( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete6A293( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate6A293( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes6A293( )
   {
      edtRestLocRNro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocRNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRNro_Enabled), 5, 0), !bGXsfl_64_Refreshing);
      chkRestLocRHab.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkRestLocRHab.getInternalname(), "Enabled", GXutil.ltrimstr( chkRestLocRHab.getEnabled(), 5, 0), !bGXsfl_64_Refreshing);
      edtRestLocRBaseUrl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocRBaseUrl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRBaseUrl_Enabled), 5, 0), !bGXsfl_64_Refreshing);
      edtRestLocRCancel_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocRCancel_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRCancel_Enabled), 5, 0), !bGXsfl_64_Refreshing);
      edtRestLocRHost_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocRHost_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRHost_Enabled), 5, 0), !bGXsfl_64_Refreshing);
      edtRestLocRPort_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocRPort_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRPort_Enabled), 5, 0), !bGXsfl_64_Refreshing);
      edtRestLocRSecure_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocRSecure_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRSecure_Enabled), 5, 0), !bGXsfl_64_Refreshing);
      edtRestLocRTimeout_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocRTimeout_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRTimeout_Enabled), 5, 0), !bGXsfl_64_Refreshing);
   }

   public void send_integrity_lvl_hashes6A293( )
   {
   }

   public void send_integrity_lvl_hashes6A273( )
   {
   }

   public void subsflControlProps_64293( )
   {
      edtRestLocRNro_Internalname = "RESTLOCRNRO_"+sGXsfl_64_idx ;
      chkRestLocRHab.setInternalname( "RESTLOCRHAB_"+sGXsfl_64_idx );
      edtRestLocRBaseUrl_Internalname = "RESTLOCRBASEURL_"+sGXsfl_64_idx ;
      edtRestLocRCancel_Internalname = "RESTLOCRCANCEL_"+sGXsfl_64_idx ;
      edtRestLocRHost_Internalname = "RESTLOCRHOST_"+sGXsfl_64_idx ;
      edtRestLocRPort_Internalname = "RESTLOCRPORT_"+sGXsfl_64_idx ;
      edtRestLocRSecure_Internalname = "RESTLOCRSECURE_"+sGXsfl_64_idx ;
      edtRestLocRTimeout_Internalname = "RESTLOCRTIMEOUT_"+sGXsfl_64_idx ;
   }

   public void subsflControlProps_fel_64293( )
   {
      edtRestLocRNro_Internalname = "RESTLOCRNRO_"+sGXsfl_64_fel_idx ;
      chkRestLocRHab.setInternalname( "RESTLOCRHAB_"+sGXsfl_64_fel_idx );
      edtRestLocRBaseUrl_Internalname = "RESTLOCRBASEURL_"+sGXsfl_64_fel_idx ;
      edtRestLocRCancel_Internalname = "RESTLOCRCANCEL_"+sGXsfl_64_fel_idx ;
      edtRestLocRHost_Internalname = "RESTLOCRHOST_"+sGXsfl_64_fel_idx ;
      edtRestLocRPort_Internalname = "RESTLOCRPORT_"+sGXsfl_64_fel_idx ;
      edtRestLocRSecure_Internalname = "RESTLOCRSECURE_"+sGXsfl_64_fel_idx ;
      edtRestLocRTimeout_Internalname = "RESTLOCRTIMEOUT_"+sGXsfl_64_fel_idx ;
   }

   public void addRow6A293( )
   {
      nGXsfl_64_idx = (int)(nGXsfl_64_idx+1) ;
      sGXsfl_64_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_64_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_64293( ) ;
      sendRow6A293( ) ;
   }

   public void sendRow6A293( )
   {
      Gridlevel1Row = GXWebRow.GetNew(context) ;
      if ( subGridlevel1_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
         }
      }
      else if ( subGridlevel1_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(0) ;
         subGridlevel1_Backcolor = subGridlevel1_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel1_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
         }
         subGridlevel1_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel1_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_64_idx) % (2))) == 0 )
         {
            subGridlevel1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
            {
               subGridlevel1_Linesclass = subGridlevel1_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
            {
               subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_293_" + sGXsfl_64_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 65,'',false,'" + sGXsfl_64_idx + "',64)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRestLocRNro_Internalname,GXutil.ltrim( localUtil.ntoc( A2333RestLocRNro, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2333RestLocRNro), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,65);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRestLocRNro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtRestLocRNro_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(64),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Check box */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_293_" + sGXsfl_64_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 66,'',false,'" + sGXsfl_64_idx + "',64)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      GXCCtl = "RESTLOCRHAB_" + sGXsfl_64_idx ;
      chkRestLocRHab.setName( GXCCtl );
      chkRestLocRHab.setWebtags( "" );
      chkRestLocRHab.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkRestLocRHab.getInternalname(), "TitleCaption", chkRestLocRHab.getCaption(), !bGXsfl_64_Refreshing);
      chkRestLocRHab.setCheckedValue( "false" );
      A2334RestLocRHab = GXutil.strtobool( GXutil.booltostr( A2334RestLocRHab)) ;
      Gridlevel1Row.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkRestLocRHab.getInternalname(),GXutil.booltostr( A2334RestLocRHab),"","",Integer.valueOf(-1),Integer.valueOf(chkRestLocRHab.getEnabled()),"true","",StyleString,ClassString,"TrnColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(66, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,66);\""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_293_" + sGXsfl_64_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 67,'',false,'" + sGXsfl_64_idx + "',64)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRestLocRBaseUrl_Internalname,A2335RestLocRBaseUrl,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,67);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRestLocRBaseUrl_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtRestLocRBaseUrl_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(64),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_293_" + sGXsfl_64_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 68,'',false,'" + sGXsfl_64_idx + "',64)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRestLocRCancel_Internalname,GXutil.ltrim( localUtil.ntoc( A2336RestLocRCancel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtRestLocRCancel_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2336RestLocRCancel), "9") : localUtil.format( DecimalUtil.doubleToDec(A2336RestLocRCancel), "9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,68);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRestLocRCancel_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtRestLocRCancel_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(64),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_293_" + sGXsfl_64_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 69,'',false,'" + sGXsfl_64_idx + "',64)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRestLocRHost_Internalname,A2337RestLocRHost,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRestLocRHost_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtRestLocRHost_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(64),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_293_" + sGXsfl_64_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 70,'',false,'" + sGXsfl_64_idx + "',64)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRestLocRPort_Internalname,GXutil.ltrim( localUtil.ntoc( A2338RestLocRPort, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtRestLocRPort_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2338RestLocRPort), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2338RestLocRPort), "ZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,70);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRestLocRPort_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtRestLocRPort_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(64),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_293_" + sGXsfl_64_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 71,'',false,'" + sGXsfl_64_idx + "',64)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRestLocRSecure_Internalname,GXutil.ltrim( localUtil.ntoc( A2340RestLocRSecure, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtRestLocRSecure_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2340RestLocRSecure), "9") : localUtil.format( DecimalUtil.doubleToDec(A2340RestLocRSecure), "9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,71);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRestLocRSecure_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtRestLocRSecure_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(64),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_293_" + sGXsfl_64_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 72,'',false,'" + sGXsfl_64_idx + "',64)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtRestLocRTimeout_Internalname,GXutil.ltrim( localUtil.ntoc( A2339RestLocRTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtRestLocRTimeout_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2339RestLocRTimeout), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2339RestLocRTimeout), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,72);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtRestLocRTimeout_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtRestLocRTimeout_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(64),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel1Row);
      send_integrity_lvl_hashes6A293( ) ;
      GXCCtl = "Z2333RestLocRNro_" + sGXsfl_64_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2333RestLocRNro, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2334RestLocRHab_" + sGXsfl_64_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, Z2334RestLocRHab);
      GXCCtl = "Z2335RestLocRBaseUrl_" + sGXsfl_64_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z2335RestLocRBaseUrl);
      GXCCtl = "Z2336RestLocRCancel_" + sGXsfl_64_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2336RestLocRCancel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2337RestLocRHost_" + sGXsfl_64_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z2337RestLocRHost);
      GXCCtl = "Z2338RestLocRPort_" + sGXsfl_64_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2338RestLocRPort, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2339RestLocRTimeout_" + sGXsfl_64_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2339RestLocRTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2340RestLocRSecure_" + sGXsfl_64_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2340RestLocRSecure, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_293_" + sGXsfl_64_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_293, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_293_" + sGXsfl_64_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_293, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_293_" + sGXsfl_64_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_293, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_64_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_64_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vRESTLOCID_" + sGXsfl_64_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV8RestLocId));
      web.GxWebStd.gx_hidden_field( httpContext, "RESTLOCRNRO_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRNro_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "RESTLOCRHAB_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkRestLocRHab.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "RESTLOCRBASEURL_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRBaseUrl_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "RESTLOCRCANCEL_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRCancel_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "RESTLOCRHOST_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRHost_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "RESTLOCRPORT_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRPort_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "RESTLOCRSECURE_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRSecure_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "RESTLOCRTIMEOUT_"+sGXsfl_64_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRTimeout_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel1Container.AddRow(Gridlevel1Row);
   }

   public void readRow6A293( )
   {
      nGXsfl_64_idx = (int)(nGXsfl_64_idx+1) ;
      sGXsfl_64_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_64_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_64293( ) ;
      edtRestLocRNro_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRNRO_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      chkRestLocRHab.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRHAB_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      edtRestLocRBaseUrl_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRBASEURL_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtRestLocRCancel_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRCANCEL_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtRestLocRHost_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRHOST_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtRestLocRPort_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRPORT_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtRestLocRSecure_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRSECURE_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtRestLocRTimeout_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "RESTLOCRTIMEOUT_"+sGXsfl_64_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocRNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocRNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "RESTLOCRNRO_" + sGXsfl_64_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtRestLocRNro_Internalname ;
         wbErr = true ;
         A2333RestLocRNro = (short)(0) ;
      }
      else
      {
         A2333RestLocRNro = (short)(localUtil.ctol( httpContext.cgiGet( edtRestLocRNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      A2334RestLocRHab = GXutil.strtobool( httpContext.cgiGet( chkRestLocRHab.getInternalname())) ;
      A2335RestLocRBaseUrl = httpContext.cgiGet( edtRestLocRBaseUrl_Internalname) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocRCancel_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocRCancel_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
      {
         GXCCtl = "RESTLOCRCANCEL_" + sGXsfl_64_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtRestLocRCancel_Internalname ;
         wbErr = true ;
         A2336RestLocRCancel = (byte)(0) ;
      }
      else
      {
         A2336RestLocRCancel = (byte)(localUtil.ctol( httpContext.cgiGet( edtRestLocRCancel_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      A2337RestLocRHost = httpContext.cgiGet( edtRestLocRHost_Internalname) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocRPort_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocRPort_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
      {
         GXCCtl = "RESTLOCRPORT_" + sGXsfl_64_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtRestLocRPort_Internalname ;
         wbErr = true ;
         A2338RestLocRPort = 0 ;
      }
      else
      {
         A2338RestLocRPort = (int)(localUtil.ctol( httpContext.cgiGet( edtRestLocRPort_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocRSecure_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocRSecure_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
      {
         GXCCtl = "RESTLOCRSECURE_" + sGXsfl_64_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtRestLocRSecure_Internalname ;
         wbErr = true ;
         A2340RestLocRSecure = (byte)(0) ;
      }
      else
      {
         A2340RestLocRSecure = (byte)(localUtil.ctol( httpContext.cgiGet( edtRestLocRSecure_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocRTimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRestLocRTimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "RESTLOCRTIMEOUT_" + sGXsfl_64_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtRestLocRTimeout_Internalname ;
         wbErr = true ;
         A2339RestLocRTimeout = (short)(0) ;
      }
      else
      {
         A2339RestLocRTimeout = (short)(localUtil.ctol( httpContext.cgiGet( edtRestLocRTimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      GXCCtl = "Z2333RestLocRNro_" + sGXsfl_64_idx ;
      Z2333RestLocRNro = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2334RestLocRHab_" + sGXsfl_64_idx ;
      Z2334RestLocRHab = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z2335RestLocRBaseUrl_" + sGXsfl_64_idx ;
      Z2335RestLocRBaseUrl = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2336RestLocRCancel_" + sGXsfl_64_idx ;
      Z2336RestLocRCancel = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2337RestLocRHost_" + sGXsfl_64_idx ;
      Z2337RestLocRHost = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2338RestLocRPort_" + sGXsfl_64_idx ;
      Z2338RestLocRPort = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2339RestLocRTimeout_" + sGXsfl_64_idx ;
      Z2339RestLocRTimeout = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2340RestLocRSecure_" + sGXsfl_64_idx ;
      Z2340RestLocRSecure = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdDeleted_293_" + sGXsfl_64_idx ;
      nRcdDeleted_293 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_293_" + sGXsfl_64_idx ;
      nRcdExists_293 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_293_" + sGXsfl_64_idx ;
      nIsMod_293 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtRestLocRNro_Enabled = edtRestLocRNro_Enabled ;
   }

   public void confirmValues6A0( )
   {
      nGXsfl_64_idx = 0 ;
      sGXsfl_64_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_64_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_64293( ) ;
      while ( nGXsfl_64_idx < nRC_GXsfl_64 )
      {
         nGXsfl_64_idx = (int)(nGXsfl_64_idx+1) ;
         sGXsfl_64_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_64_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_64293( ) ;
         httpContext.changePostValue( "Z2333RestLocRNro_"+sGXsfl_64_idx, httpContext.cgiGet( "ZT_"+"Z2333RestLocRNro_"+sGXsfl_64_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2333RestLocRNro_"+sGXsfl_64_idx) ;
         httpContext.changePostValue( "Z2334RestLocRHab_"+sGXsfl_64_idx, httpContext.cgiGet( "ZT_"+"Z2334RestLocRHab_"+sGXsfl_64_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2334RestLocRHab_"+sGXsfl_64_idx) ;
         httpContext.changePostValue( "Z2335RestLocRBaseUrl_"+sGXsfl_64_idx, httpContext.cgiGet( "ZT_"+"Z2335RestLocRBaseUrl_"+sGXsfl_64_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2335RestLocRBaseUrl_"+sGXsfl_64_idx) ;
         httpContext.changePostValue( "Z2336RestLocRCancel_"+sGXsfl_64_idx, httpContext.cgiGet( "ZT_"+"Z2336RestLocRCancel_"+sGXsfl_64_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2336RestLocRCancel_"+sGXsfl_64_idx) ;
         httpContext.changePostValue( "Z2337RestLocRHost_"+sGXsfl_64_idx, httpContext.cgiGet( "ZT_"+"Z2337RestLocRHost_"+sGXsfl_64_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2337RestLocRHost_"+sGXsfl_64_idx) ;
         httpContext.changePostValue( "Z2338RestLocRPort_"+sGXsfl_64_idx, httpContext.cgiGet( "ZT_"+"Z2338RestLocRPort_"+sGXsfl_64_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2338RestLocRPort_"+sGXsfl_64_idx) ;
         httpContext.changePostValue( "Z2339RestLocRTimeout_"+sGXsfl_64_idx, httpContext.cgiGet( "ZT_"+"Z2339RestLocRTimeout_"+sGXsfl_64_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2339RestLocRTimeout_"+sGXsfl_64_idx) ;
         httpContext.changePostValue( "Z2340RestLocRSecure_"+sGXsfl_64_idx, httpContext.cgiGet( "ZT_"+"Z2340RestLocRSecure_"+sGXsfl_64_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2340RestLocRSecure_"+sGXsfl_64_idx) ;
      }
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
      MasterPageObj.master_styles();
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
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.rest_location", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8RestLocId))}, new String[] {"Gx_mode","CliCod","RestLocId"}) +"\">") ;
      web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"rest_location");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("rest_location:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2171RestLocId", GXutil.rtrim( Z2171RestLocId));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2172RestLocHab", Z2172RestLocHab);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2173RestLocBaseUrl", Z2173RestLocBaseUrl);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2174RestLocCancelOnError", GXutil.ltrim( localUtil.ntoc( Z2174RestLocCancelOnError, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2175RestLocHost", Z2175RestLocHost);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2176RestLocPort", GXutil.ltrim( localUtil.ntoc( Z2176RestLocPort, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2177RestLocTimeout", GXutil.ltrim( localUtil.ntoc( Z2177RestLocTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2178RestLocSecure", GXutil.ltrim( localUtil.ntoc( Z2178RestLocSecure, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_64", GXutil.ltrim( localUtil.ntoc( nGXsfl_64_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vRESTLOCID", GXutil.rtrim( AV8RestLocId));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vRESTLOCID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8RestLocId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV20Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
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
   }

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.rest_location", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8RestLocId))}, new String[] {"Gx_mode","CliCod","RestLocId"})  ;
   }

   public String getPgmname( )
   {
      return "rest_location" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "rest_location", "") ;
   }

   public void initializeNonKey6A273( )
   {
      A2172RestLocHab = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2172RestLocHab", A2172RestLocHab);
      A2173RestLocBaseUrl = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2173RestLocBaseUrl", A2173RestLocBaseUrl);
      A2174RestLocCancelOnError = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2174RestLocCancelOnError", GXutil.str( A2174RestLocCancelOnError, 1, 0));
      A2175RestLocHost = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2175RestLocHost", A2175RestLocHost);
      A2176RestLocPort = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2176RestLocPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2176RestLocPort), 8, 0));
      A2177RestLocTimeout = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2177RestLocTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2177RestLocTimeout), 4, 0));
      A2178RestLocSecure = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2178RestLocSecure", GXutil.str( A2178RestLocSecure, 1, 0));
      Z2172RestLocHab = false ;
      Z2173RestLocBaseUrl = "" ;
      Z2174RestLocCancelOnError = (byte)(0) ;
      Z2175RestLocHost = "" ;
      Z2176RestLocPort = 0 ;
      Z2177RestLocTimeout = (short)(0) ;
      Z2178RestLocSecure = (byte)(0) ;
   }

   public void initAll6A273( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A2171RestLocId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2171RestLocId", A2171RestLocId);
      initializeNonKey6A273( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey6A293( )
   {
      A2334RestLocRHab = false ;
      A2335RestLocRBaseUrl = "" ;
      A2336RestLocRCancel = (byte)(0) ;
      A2337RestLocRHost = "" ;
      A2338RestLocRPort = 0 ;
      A2339RestLocRTimeout = (short)(0) ;
      A2340RestLocRSecure = (byte)(0) ;
      Z2334RestLocRHab = false ;
      Z2335RestLocRBaseUrl = "" ;
      Z2336RestLocRCancel = (byte)(0) ;
      Z2337RestLocRHost = "" ;
      Z2338RestLocRPort = 0 ;
      Z2339RestLocRTimeout = (short)(0) ;
      Z2340RestLocRSecure = (byte)(0) ;
   }

   public void initAll6A293( )
   {
      A2333RestLocRNro = (short)(0) ;
      initializeNonKey6A293( ) ;
   }

   public void standaloneModalInsert6A293( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020383663", true, true);
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
      httpContext.AddJavascriptSource("rest_location.js", "?2024122020383663", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties293( )
   {
      edtRestLocRNro_Enabled = defedtRestLocRNro_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtRestLocRNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRestLocRNro_Enabled), 5, 0), !bGXsfl_64_Refreshing);
   }

   public void startgridcontrol64( )
   {
      Gridlevel1Container.AddObjectProperty("GridName", "Gridlevel1");
      Gridlevel1Container.AddObjectProperty("Header", subGridlevel1_Header);
      Gridlevel1Container.AddObjectProperty("Class", "WorkWith");
      Gridlevel1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("CmpContext", "");
      Gridlevel1Container.AddObjectProperty("InMasterPage", "false");
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2333RestLocRNro, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRNro_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.booltostr( A2334RestLocRHab));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkRestLocRHab.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", A2335RestLocRBaseUrl);
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRBaseUrl_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2336RestLocRCancel, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRCancel_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", A2337RestLocRHost);
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRHost_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2338RestLocRPort, (byte)(8), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRPort_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2340RestLocRSecure, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRSecure_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2339RestLocRTimeout, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtRestLocRTimeout_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      edtRestLocId_Internalname = "RESTLOCID" ;
      chkRestLocHab.setInternalname( "RESTLOCHAB" );
      edtRestLocBaseUrl_Internalname = "RESTLOCBASEURL" ;
      edtRestLocCancelOnError_Internalname = "RESTLOCCANCELONERROR" ;
      edtRestLocHost_Internalname = "RESTLOCHOST" ;
      edtRestLocPort_Internalname = "RESTLOCPORT" ;
      edtRestLocTimeout_Internalname = "RESTLOCTIMEOUT" ;
      edtRestLocSecure_Internalname = "RESTLOCSECURE" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      edtRestLocRNro_Internalname = "RESTLOCRNRO" ;
      chkRestLocRHab.setInternalname( "RESTLOCRHAB" );
      edtRestLocRBaseUrl_Internalname = "RESTLOCRBASEURL" ;
      edtRestLocRCancel_Internalname = "RESTLOCRCANCEL" ;
      edtRestLocRHost_Internalname = "RESTLOCRHOST" ;
      edtRestLocRPort_Internalname = "RESTLOCRPORT" ;
      edtRestLocRSecure_Internalname = "RESTLOCRSECURE" ;
      edtRestLocRTimeout_Internalname = "RESTLOCRTIMEOUT" ;
      tblUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      grpUnnamedgroup2_Internalname = "UNNAMEDGROUP2" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel1_Internalname = "GRIDLEVEL1" ;
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
      subGridlevel1_Allowcollapsing = (byte)(0) ;
      subGridlevel1_Allowselection = (byte)(0) ;
      subGridlevel1_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "rest_location", "") );
      edtRestLocRTimeout_Jsonclick = "" ;
      edtRestLocRSecure_Jsonclick = "" ;
      edtRestLocRPort_Jsonclick = "" ;
      edtRestLocRHost_Jsonclick = "" ;
      edtRestLocRCancel_Jsonclick = "" ;
      edtRestLocRBaseUrl_Jsonclick = "" ;
      chkRestLocRHab.setCaption( "" );
      edtRestLocRNro_Jsonclick = "" ;
      subGridlevel1_Class = "WorkWith" ;
      subGridlevel1_Backcolorstyle = (byte)(0) ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtRestLocRTimeout_Enabled = 1 ;
      edtRestLocRSecure_Enabled = 1 ;
      edtRestLocRPort_Enabled = 1 ;
      edtRestLocRHost_Enabled = 1 ;
      edtRestLocRCancel_Enabled = 1 ;
      edtRestLocRBaseUrl_Enabled = 1 ;
      chkRestLocRHab.setEnabled( 1 );
      edtRestLocRNro_Enabled = 1 ;
      edtRestLocSecure_Jsonclick = "" ;
      edtRestLocSecure_Enabled = 1 ;
      edtRestLocTimeout_Jsonclick = "" ;
      edtRestLocTimeout_Enabled = 1 ;
      edtRestLocPort_Jsonclick = "" ;
      edtRestLocPort_Enabled = 1 ;
      edtRestLocHost_Enabled = 1 ;
      edtRestLocCancelOnError_Jsonclick = "" ;
      edtRestLocCancelOnError_Enabled = 1 ;
      edtRestLocBaseUrl_Enabled = 1 ;
      chkRestLocHab.setEnabled( 1 );
      edtRestLocId_Jsonclick = "" ;
      edtRestLocId_Enabled = 1 ;
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
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gx1asaclicod6A273( int AV7CliCod )
   {
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            rest_location_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel1_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_64293( ) ;
      while ( nGXsfl_64_idx <= nRC_GXsfl_64 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal6A293( ) ;
         standaloneModal6A293( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow6A293( ) ;
         nGXsfl_64_idx = (int)(nGXsfl_64_idx+1) ;
         sGXsfl_64_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_64_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_64293( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel1Container)) ;
      /* End function gxnrGridlevel1_newrow */
   }

   public void init_web_controls( )
   {
      chkRestLocHab.setName( "RESTLOCHAB" );
      chkRestLocHab.setWebtags( "" );
      chkRestLocHab.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkRestLocHab.getInternalname(), "TitleCaption", chkRestLocHab.getCaption(), true);
      chkRestLocHab.setCheckedValue( "false" );
      A2172RestLocHab = GXutil.strtobool( GXutil.booltostr( A2172RestLocHab)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2172RestLocHab", A2172RestLocHab);
      GXCCtl = "RESTLOCRHAB_" + sGXsfl_64_idx ;
      chkRestLocRHab.setName( GXCCtl );
      chkRestLocRHab.setWebtags( "" );
      chkRestLocRHab.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkRestLocRHab.getInternalname(), "TitleCaption", chkRestLocRHab.getCaption(), !bGXsfl_64_Refreshing);
      chkRestLocRHab.setCheckedValue( "false" );
      A2334RestLocRHab = GXutil.strtobool( GXutil.booltostr( A2334RestLocRHab)) ;
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

   public void valid_Clicod( )
   {
      /* Using cursor T006A22 */
      pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(20) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(20);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8RestLocId',fld:'vRESTLOCID',pic:'',hsh:true},{av:'A2172RestLocHab',fld:'RESTLOCHAB',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A2172RestLocHab',fld:'RESTLOCHAB',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8RestLocId',fld:'vRESTLOCID',pic:'',hsh:true},{av:'A2172RestLocHab',fld:'RESTLOCHAB',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A2172RestLocHab',fld:'RESTLOCHAB',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e126A2',iparms:[{av:'A2172RestLocHab',fld:'RESTLOCHAB',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A2172RestLocHab',fld:'RESTLOCHAB',pic:''}]}");
      setEventMetadata("VALID_RESTLOCID","{handler:'valid_Restlocid',iparms:[{av:'A2172RestLocHab',fld:'RESTLOCHAB',pic:''}]");
      setEventMetadata("VALID_RESTLOCID",",oparms:[{av:'A2172RestLocHab',fld:'RESTLOCHAB',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A2172RestLocHab',fld:'RESTLOCHAB',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A2172RestLocHab',fld:'RESTLOCHAB',pic:''}]}");
      setEventMetadata("VALID_RESTLOCRNRO","{handler:'valid_Restlocrnro',iparms:[{av:'A2172RestLocHab',fld:'RESTLOCHAB',pic:''}]");
      setEventMetadata("VALID_RESTLOCRNRO",",oparms:[{av:'A2172RestLocHab',fld:'RESTLOCHAB',pic:''}]}");
      setEventMetadata("NULL","{handler:'valid_Restlocrtimeout',iparms:[{av:'A2172RestLocHab',fld:'RESTLOCHAB',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'A2172RestLocHab',fld:'RESTLOCHAB',pic:''}]}");
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
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
      pr_default.close(20);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8RestLocId = "" ;
      Z2171RestLocId = "" ;
      Z2173RestLocBaseUrl = "" ;
      Z2175RestLocHost = "" ;
      Z2335RestLocRBaseUrl = "" ;
      Z2337RestLocRHost = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV8RestLocId = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A2171RestLocId = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A2173RestLocBaseUrl = "" ;
      A2175RestLocHost = "" ;
      Gridlevel1Container = new com.genexus.webpanels.GXWebGrid(context);
      sMode293 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV20Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode273 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A2335RestLocRBaseUrl = "" ;
      A2337RestLocRHost = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      T006A7_A2171RestLocId = new String[] {""} ;
      T006A7_A2172RestLocHab = new boolean[] {false} ;
      T006A7_A2173RestLocBaseUrl = new String[] {""} ;
      T006A7_A2174RestLocCancelOnError = new byte[1] ;
      T006A7_A2175RestLocHost = new String[] {""} ;
      T006A7_A2176RestLocPort = new int[1] ;
      T006A7_A2177RestLocTimeout = new short[1] ;
      T006A7_A2178RestLocSecure = new byte[1] ;
      T006A7_A3CliCod = new int[1] ;
      T006A6_A3CliCod = new int[1] ;
      T006A8_A3CliCod = new int[1] ;
      T006A9_A3CliCod = new int[1] ;
      T006A9_A2171RestLocId = new String[] {""} ;
      T006A5_A2171RestLocId = new String[] {""} ;
      T006A5_A2172RestLocHab = new boolean[] {false} ;
      T006A5_A2173RestLocBaseUrl = new String[] {""} ;
      T006A5_A2174RestLocCancelOnError = new byte[1] ;
      T006A5_A2175RestLocHost = new String[] {""} ;
      T006A5_A2176RestLocPort = new int[1] ;
      T006A5_A2177RestLocTimeout = new short[1] ;
      T006A5_A2178RestLocSecure = new byte[1] ;
      T006A5_A3CliCod = new int[1] ;
      T006A10_A3CliCod = new int[1] ;
      T006A10_A2171RestLocId = new String[] {""} ;
      T006A11_A3CliCod = new int[1] ;
      T006A11_A2171RestLocId = new String[] {""} ;
      T006A4_A2171RestLocId = new String[] {""} ;
      T006A4_A2172RestLocHab = new boolean[] {false} ;
      T006A4_A2173RestLocBaseUrl = new String[] {""} ;
      T006A4_A2174RestLocCancelOnError = new byte[1] ;
      T006A4_A2175RestLocHost = new String[] {""} ;
      T006A4_A2176RestLocPort = new int[1] ;
      T006A4_A2177RestLocTimeout = new short[1] ;
      T006A4_A2178RestLocSecure = new byte[1] ;
      T006A4_A3CliCod = new int[1] ;
      T006A15_A3CliCod = new int[1] ;
      T006A15_A2171RestLocId = new String[] {""} ;
      T006A16_A3CliCod = new int[1] ;
      T006A16_A2171RestLocId = new String[] {""} ;
      T006A16_A2333RestLocRNro = new short[1] ;
      T006A16_A2334RestLocRHab = new boolean[] {false} ;
      T006A16_A2335RestLocRBaseUrl = new String[] {""} ;
      T006A16_A2336RestLocRCancel = new byte[1] ;
      T006A16_A2337RestLocRHost = new String[] {""} ;
      T006A16_A2338RestLocRPort = new int[1] ;
      T006A16_A2339RestLocRTimeout = new short[1] ;
      T006A16_A2340RestLocRSecure = new byte[1] ;
      T006A17_A3CliCod = new int[1] ;
      T006A17_A2171RestLocId = new String[] {""} ;
      T006A17_A2333RestLocRNro = new short[1] ;
      T006A3_A3CliCod = new int[1] ;
      T006A3_A2171RestLocId = new String[] {""} ;
      T006A3_A2333RestLocRNro = new short[1] ;
      T006A3_A2334RestLocRHab = new boolean[] {false} ;
      T006A3_A2335RestLocRBaseUrl = new String[] {""} ;
      T006A3_A2336RestLocRCancel = new byte[1] ;
      T006A3_A2337RestLocRHost = new String[] {""} ;
      T006A3_A2338RestLocRPort = new int[1] ;
      T006A3_A2339RestLocRTimeout = new short[1] ;
      T006A3_A2340RestLocRSecure = new byte[1] ;
      T006A2_A3CliCod = new int[1] ;
      T006A2_A2171RestLocId = new String[] {""} ;
      T006A2_A2333RestLocRNro = new short[1] ;
      T006A2_A2334RestLocRHab = new boolean[] {false} ;
      T006A2_A2335RestLocRBaseUrl = new String[] {""} ;
      T006A2_A2336RestLocRCancel = new byte[1] ;
      T006A2_A2337RestLocRHost = new String[] {""} ;
      T006A2_A2338RestLocRPort = new int[1] ;
      T006A2_A2339RestLocRTimeout = new short[1] ;
      T006A2_A2340RestLocRSecure = new byte[1] ;
      T006A21_A3CliCod = new int[1] ;
      T006A21_A2171RestLocId = new String[] {""} ;
      T006A21_A2333RestLocRNro = new short[1] ;
      Gridlevel1Row = new com.genexus.webpanels.GXWebRow();
      subGridlevel1_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel1Column = new com.genexus.webpanels.GXWebColumn();
      GXv_int5 = new int[1] ;
      T006A22_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.rest_location__default(),
         new Object[] {
             new Object[] {
            T006A2_A3CliCod, T006A2_A2171RestLocId, T006A2_A2333RestLocRNro, T006A2_A2334RestLocRHab, T006A2_A2335RestLocRBaseUrl, T006A2_A2336RestLocRCancel, T006A2_A2337RestLocRHost, T006A2_A2338RestLocRPort, T006A2_A2339RestLocRTimeout, T006A2_A2340RestLocRSecure
            }
            , new Object[] {
            T006A3_A3CliCod, T006A3_A2171RestLocId, T006A3_A2333RestLocRNro, T006A3_A2334RestLocRHab, T006A3_A2335RestLocRBaseUrl, T006A3_A2336RestLocRCancel, T006A3_A2337RestLocRHost, T006A3_A2338RestLocRPort, T006A3_A2339RestLocRTimeout, T006A3_A2340RestLocRSecure
            }
            , new Object[] {
            T006A4_A2171RestLocId, T006A4_A2172RestLocHab, T006A4_A2173RestLocBaseUrl, T006A4_A2174RestLocCancelOnError, T006A4_A2175RestLocHost, T006A4_A2176RestLocPort, T006A4_A2177RestLocTimeout, T006A4_A2178RestLocSecure, T006A4_A3CliCod
            }
            , new Object[] {
            T006A5_A2171RestLocId, T006A5_A2172RestLocHab, T006A5_A2173RestLocBaseUrl, T006A5_A2174RestLocCancelOnError, T006A5_A2175RestLocHost, T006A5_A2176RestLocPort, T006A5_A2177RestLocTimeout, T006A5_A2178RestLocSecure, T006A5_A3CliCod
            }
            , new Object[] {
            T006A6_A3CliCod
            }
            , new Object[] {
            T006A7_A2171RestLocId, T006A7_A2172RestLocHab, T006A7_A2173RestLocBaseUrl, T006A7_A2174RestLocCancelOnError, T006A7_A2175RestLocHost, T006A7_A2176RestLocPort, T006A7_A2177RestLocTimeout, T006A7_A2178RestLocSecure, T006A7_A3CliCod
            }
            , new Object[] {
            T006A8_A3CliCod
            }
            , new Object[] {
            T006A9_A3CliCod, T006A9_A2171RestLocId
            }
            , new Object[] {
            T006A10_A3CliCod, T006A10_A2171RestLocId
            }
            , new Object[] {
            T006A11_A3CliCod, T006A11_A2171RestLocId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006A15_A3CliCod, T006A15_A2171RestLocId
            }
            , new Object[] {
            T006A16_A3CliCod, T006A16_A2171RestLocId, T006A16_A2333RestLocRNro, T006A16_A2334RestLocRHab, T006A16_A2335RestLocRBaseUrl, T006A16_A2336RestLocRCancel, T006A16_A2337RestLocRHost, T006A16_A2338RestLocRPort, T006A16_A2339RestLocRTimeout, T006A16_A2340RestLocRSecure
            }
            , new Object[] {
            T006A17_A3CliCod, T006A17_A2171RestLocId, T006A17_A2333RestLocRNro
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006A21_A3CliCod, T006A21_A2171RestLocId, T006A21_A2333RestLocRNro
            }
            , new Object[] {
            T006A22_A3CliCod
            }
         }
      );
      AV20Pgmname = "rest_location" ;
   }

   private byte Z2174RestLocCancelOnError ;
   private byte Z2178RestLocSecure ;
   private byte Z2336RestLocRCancel ;
   private byte Z2340RestLocRSecure ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A2174RestLocCancelOnError ;
   private byte A2178RestLocSecure ;
   private byte A2336RestLocRCancel ;
   private byte A2340RestLocRSecure ;
   private byte Gx_BScreen ;
   private byte subGridlevel1_Backcolorstyle ;
   private byte subGridlevel1_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel1_Allowselection ;
   private byte subGridlevel1_Allowhovering ;
   private byte subGridlevel1_Allowcollapsing ;
   private byte subGridlevel1_Collapsed ;
   private short Z2177RestLocTimeout ;
   private short Z2333RestLocRNro ;
   private short Z2339RestLocRTimeout ;
   private short nRcdDeleted_293 ;
   private short nRcdExists_293 ;
   private short nIsMod_293 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A2177RestLocTimeout ;
   private short nBlankRcdCount293 ;
   private short RcdFound293 ;
   private short nBlankRcdUsr293 ;
   private short RcdFound273 ;
   private short A2333RestLocRNro ;
   private short A2339RestLocRTimeout ;
   private short nIsDirty_273 ;
   private short nIsDirty_293 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z2176RestLocPort ;
   private int nRC_GXsfl_64 ;
   private int nGXsfl_64_idx=1 ;
   private int Z2338RestLocRPort ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtRestLocId_Enabled ;
   private int edtRestLocBaseUrl_Enabled ;
   private int edtRestLocCancelOnError_Enabled ;
   private int edtRestLocHost_Enabled ;
   private int A2176RestLocPort ;
   private int edtRestLocPort_Enabled ;
   private int edtRestLocTimeout_Enabled ;
   private int edtRestLocSecure_Enabled ;
   private int edtRestLocRNro_Enabled ;
   private int edtRestLocRBaseUrl_Enabled ;
   private int edtRestLocRCancel_Enabled ;
   private int edtRestLocRHost_Enabled ;
   private int edtRestLocRPort_Enabled ;
   private int edtRestLocRSecure_Enabled ;
   private int edtRestLocRTimeout_Enabled ;
   private int fRowAdded ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int A2338RestLocRPort ;
   private int GX_JID ;
   private int subGridlevel1_Backcolor ;
   private int subGridlevel1_Allbackcolor ;
   private int defedtRestLocRNro_Enabled ;
   private int idxLst ;
   private int subGridlevel1_Selectedindex ;
   private int subGridlevel1_Selectioncolor ;
   private int subGridlevel1_Hoveringcolor ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private long GRIDLEVEL1_nFirstRecordOnPage ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8RestLocId ;
   private String Z2171RestLocId ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV8RestLocId ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtRestLocId_Internalname ;
   private String sGXsfl_64_idx="0001" ;
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
   private String A2171RestLocId ;
   private String edtRestLocId_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String edtRestLocBaseUrl_Internalname ;
   private String edtRestLocCancelOnError_Internalname ;
   private String edtRestLocCancelOnError_Jsonclick ;
   private String edtRestLocHost_Internalname ;
   private String edtRestLocPort_Internalname ;
   private String edtRestLocPort_Jsonclick ;
   private String edtRestLocTimeout_Internalname ;
   private String edtRestLocTimeout_Jsonclick ;
   private String edtRestLocSecure_Internalname ;
   private String edtRestLocSecure_Jsonclick ;
   private String grpUnnamedgroup2_Internalname ;
   private String tblUnnamedtable1_Internalname ;
   private String sMode293 ;
   private String edtRestLocRNro_Internalname ;
   private String edtRestLocRBaseUrl_Internalname ;
   private String edtRestLocRCancel_Internalname ;
   private String edtRestLocRHost_Internalname ;
   private String edtRestLocRPort_Internalname ;
   private String edtRestLocRSecure_Internalname ;
   private String edtRestLocRTimeout_Internalname ;
   private String subGridlevel1_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String AV20Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode273 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sGXsfl_64_fel_idx="0001" ;
   private String subGridlevel1_Class ;
   private String subGridlevel1_Linesclass ;
   private String ROClassString ;
   private String edtRestLocRNro_Jsonclick ;
   private String edtRestLocRBaseUrl_Jsonclick ;
   private String edtRestLocRCancel_Jsonclick ;
   private String edtRestLocRHost_Jsonclick ;
   private String edtRestLocRPort_Jsonclick ;
   private String edtRestLocRSecure_Jsonclick ;
   private String edtRestLocRTimeout_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel1_Header ;
   private boolean Z2172RestLocHab ;
   private boolean Z2334RestLocRHab ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A2172RestLocHab ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean bGXsfl_64_Refreshing=false ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean A2334RestLocRHab ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private String Z2173RestLocBaseUrl ;
   private String Z2175RestLocHost ;
   private String Z2335RestLocRBaseUrl ;
   private String Z2337RestLocRHost ;
   private String A2173RestLocBaseUrl ;
   private String A2175RestLocHost ;
   private String A2335RestLocRBaseUrl ;
   private String A2337RestLocRHost ;
   private com.genexus.webpanels.GXWebGrid Gridlevel1Container ;
   private com.genexus.webpanels.GXWebRow Gridlevel1Row ;
   private com.genexus.webpanels.GXWebColumn Gridlevel1Column ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkRestLocHab ;
   private ICheckbox chkRestLocRHab ;
   private IDataStoreProvider pr_default ;
   private String[] T006A7_A2171RestLocId ;
   private boolean[] T006A7_A2172RestLocHab ;
   private String[] T006A7_A2173RestLocBaseUrl ;
   private byte[] T006A7_A2174RestLocCancelOnError ;
   private String[] T006A7_A2175RestLocHost ;
   private int[] T006A7_A2176RestLocPort ;
   private short[] T006A7_A2177RestLocTimeout ;
   private byte[] T006A7_A2178RestLocSecure ;
   private int[] T006A7_A3CliCod ;
   private int[] T006A6_A3CliCod ;
   private int[] T006A8_A3CliCod ;
   private int[] T006A9_A3CliCod ;
   private String[] T006A9_A2171RestLocId ;
   private String[] T006A5_A2171RestLocId ;
   private boolean[] T006A5_A2172RestLocHab ;
   private String[] T006A5_A2173RestLocBaseUrl ;
   private byte[] T006A5_A2174RestLocCancelOnError ;
   private String[] T006A5_A2175RestLocHost ;
   private int[] T006A5_A2176RestLocPort ;
   private short[] T006A5_A2177RestLocTimeout ;
   private byte[] T006A5_A2178RestLocSecure ;
   private int[] T006A5_A3CliCod ;
   private int[] T006A10_A3CliCod ;
   private String[] T006A10_A2171RestLocId ;
   private int[] T006A11_A3CliCod ;
   private String[] T006A11_A2171RestLocId ;
   private String[] T006A4_A2171RestLocId ;
   private boolean[] T006A4_A2172RestLocHab ;
   private String[] T006A4_A2173RestLocBaseUrl ;
   private byte[] T006A4_A2174RestLocCancelOnError ;
   private String[] T006A4_A2175RestLocHost ;
   private int[] T006A4_A2176RestLocPort ;
   private short[] T006A4_A2177RestLocTimeout ;
   private byte[] T006A4_A2178RestLocSecure ;
   private int[] T006A4_A3CliCod ;
   private int[] T006A15_A3CliCod ;
   private String[] T006A15_A2171RestLocId ;
   private int[] T006A16_A3CliCod ;
   private String[] T006A16_A2171RestLocId ;
   private short[] T006A16_A2333RestLocRNro ;
   private boolean[] T006A16_A2334RestLocRHab ;
   private String[] T006A16_A2335RestLocRBaseUrl ;
   private byte[] T006A16_A2336RestLocRCancel ;
   private String[] T006A16_A2337RestLocRHost ;
   private int[] T006A16_A2338RestLocRPort ;
   private short[] T006A16_A2339RestLocRTimeout ;
   private byte[] T006A16_A2340RestLocRSecure ;
   private int[] T006A17_A3CliCod ;
   private String[] T006A17_A2171RestLocId ;
   private short[] T006A17_A2333RestLocRNro ;
   private int[] T006A3_A3CliCod ;
   private String[] T006A3_A2171RestLocId ;
   private short[] T006A3_A2333RestLocRNro ;
   private boolean[] T006A3_A2334RestLocRHab ;
   private String[] T006A3_A2335RestLocRBaseUrl ;
   private byte[] T006A3_A2336RestLocRCancel ;
   private String[] T006A3_A2337RestLocRHost ;
   private int[] T006A3_A2338RestLocRPort ;
   private short[] T006A3_A2339RestLocRTimeout ;
   private byte[] T006A3_A2340RestLocRSecure ;
   private int[] T006A2_A3CliCod ;
   private String[] T006A2_A2171RestLocId ;
   private short[] T006A2_A2333RestLocRNro ;
   private boolean[] T006A2_A2334RestLocRHab ;
   private String[] T006A2_A2335RestLocRBaseUrl ;
   private byte[] T006A2_A2336RestLocRCancel ;
   private String[] T006A2_A2337RestLocRHost ;
   private int[] T006A2_A2338RestLocRPort ;
   private short[] T006A2_A2339RestLocRTimeout ;
   private byte[] T006A2_A2340RestLocRSecure ;
   private int[] T006A21_A3CliCod ;
   private String[] T006A21_A2171RestLocId ;
   private short[] T006A21_A2333RestLocRNro ;
   private int[] T006A22_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
}

final  class rest_location__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T006A2", "SELECT CliCod, RestLocId, RestLocRNro, RestLocRHab, RestLocRBaseUrl, RestLocRCancel, RestLocRHost, RestLocRPort, RestLocRTimeout, RestLocRSecure FROM rest_locationreplicas WHERE CliCod = ? AND RestLocId = ? AND RestLocRNro = ?  FOR UPDATE OF rest_locationreplicas NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006A3", "SELECT CliCod, RestLocId, RestLocRNro, RestLocRHab, RestLocRBaseUrl, RestLocRCancel, RestLocRHost, RestLocRPort, RestLocRTimeout, RestLocRSecure FROM rest_locationreplicas WHERE CliCod = ? AND RestLocId = ? AND RestLocRNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006A4", "SELECT RestLocId, RestLocHab, RestLocBaseUrl, RestLocCancelOnError, RestLocHost, RestLocPort, RestLocTimeout, RestLocSecure, CliCod FROM rest_location WHERE CliCod = ? AND RestLocId = ?  FOR UPDATE OF rest_location NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006A5", "SELECT RestLocId, RestLocHab, RestLocBaseUrl, RestLocCancelOnError, RestLocHost, RestLocPort, RestLocTimeout, RestLocSecure, CliCod FROM rest_location WHERE CliCod = ? AND RestLocId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006A6", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006A7", "SELECT TM1.RestLocId, TM1.RestLocHab, TM1.RestLocBaseUrl, TM1.RestLocCancelOnError, TM1.RestLocHost, TM1.RestLocPort, TM1.RestLocTimeout, TM1.RestLocSecure, TM1.CliCod FROM rest_location TM1 WHERE TM1.CliCod = ? and TM1.RestLocId = ( ?) ORDER BY TM1.CliCod, TM1.RestLocId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006A8", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006A9", "SELECT CliCod, RestLocId FROM rest_location WHERE CliCod = ? AND RestLocId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006A10", "SELECT CliCod, RestLocId FROM rest_location WHERE ( CliCod > ? or CliCod = ? and RestLocId > ( ?)) ORDER BY CliCod, RestLocId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T006A11", "SELECT CliCod, RestLocId FROM rest_location WHERE ( CliCod < ? or CliCod = ? and RestLocId < ( ?)) ORDER BY CliCod DESC, RestLocId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T006A12", "SAVEPOINT gxupdate;INSERT INTO rest_location(RestLocId, RestLocHab, RestLocBaseUrl, RestLocCancelOnError, RestLocHost, RestLocPort, RestLocTimeout, RestLocSecure, CliCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006A13", "SAVEPOINT gxupdate;UPDATE rest_location SET RestLocHab=?, RestLocBaseUrl=?, RestLocCancelOnError=?, RestLocHost=?, RestLocPort=?, RestLocTimeout=?, RestLocSecure=?  WHERE CliCod = ? AND RestLocId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006A14", "SAVEPOINT gxupdate;DELETE FROM rest_location  WHERE CliCod = ? AND RestLocId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006A15", "SELECT CliCod, RestLocId FROM rest_location ORDER BY CliCod, RestLocId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006A16", "SELECT CliCod, RestLocId, RestLocRNro, RestLocRHab, RestLocRBaseUrl, RestLocRCancel, RestLocRHost, RestLocRPort, RestLocRTimeout, RestLocRSecure FROM rest_locationreplicas WHERE CliCod = ? and RestLocId = ( ?) and RestLocRNro = ? ORDER BY CliCod, RestLocId, RestLocRNro ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006A17", "SELECT CliCod, RestLocId, RestLocRNro FROM rest_locationreplicas WHERE CliCod = ? AND RestLocId = ? AND RestLocRNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T006A18", "SAVEPOINT gxupdate;INSERT INTO rest_locationreplicas(CliCod, RestLocId, RestLocRNro, RestLocRHab, RestLocRBaseUrl, RestLocRCancel, RestLocRHost, RestLocRPort, RestLocRTimeout, RestLocRSecure) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006A19", "SAVEPOINT gxupdate;UPDATE rest_locationreplicas SET RestLocRHab=?, RestLocRBaseUrl=?, RestLocRCancel=?, RestLocRHost=?, RestLocRPort=?, RestLocRTimeout=?, RestLocRSecure=?  WHERE CliCod = ? AND RestLocId = ? AND RestLocRNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006A20", "SAVEPOINT gxupdate;DELETE FROM rest_locationreplicas  WHERE CliCod = ? AND RestLocId = ? AND RestLocRNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006A21", "SELECT CliCod, RestLocId, RestLocRNro FROM rest_locationreplicas WHERE CliCod = ? and RestLocId = ( ?) ORDER BY CliCod, RestLocId, RestLocRNro ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006A22", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setVarchar(3, (String)parms[2], 1000, false);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setVarchar(5, (String)parms[4], 200, false);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               return;
            case 11 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setVarchar(2, (String)parms[1], 1000, false);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setVarchar(4, (String)parms[3], 200, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 40);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(5, (String)parms[4], 1000, false);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               return;
            case 17 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setVarchar(2, (String)parms[1], 1000, false);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 40);
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

