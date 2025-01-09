package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clientecct_fondocese_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CLICONVEFONDORELSEC") == 0 )
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
         gxdlacliconvefondorelsec68271( AV7CliCod) ;
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
         gx1asaclicod68271( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_22") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1575CliConveVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveVig")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_22( A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1575CliConveVig) ;
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
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
            AV8CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliPaiConve), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
            AV9CliConvenio = httpContext.GetPar( "CliConvenio") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9CliConvenio", AV9CliConvenio);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
            AV10CliConveVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveVig")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CliConveVig", localUtil.format(AV10CliConveVig, "99/99/99"));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEVIG", getSecureSignedToken( "", AV10CliConveVig));
            AV11CliConveFondoSec = (short)(GXutil.lval( httpContext.GetPar( "CliConveFondoSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliConveFondoSec), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEFONDOSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliConveFondoSec), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Convenio Fondo de cese laboral", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCliConvenio_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public clientecct_fondocese_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public clientecct_fondocese_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clientecct_fondocese_impl.class ));
   }

   public clientecct_fondocese_impl( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkCliConveFondoRem = UIFactory.getCheckbox(this);
      chkCliConveFondoNre = UIFactory.getCheckbox(this);
      chkCliConveFondoDes = UIFactory.getCheckbox(this);
      dynCliConveFondoRelSec = new HTMLChoice();
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
      A2151CliConveFondoRem = GXutil.strtobool( GXutil.booltostr( A2151CliConveFondoRem)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2151CliConveFondoRem", A2151CliConveFondoRem);
      A2152CliConveFondoNre = GXutil.strtobool( GXutil.booltostr( A2152CliConveFondoNre)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2152CliConveFondoNre", A2152CliConveFondoNre);
      A2153CliConveFondoDes = GXutil.strtobool( GXutil.booltostr( A2153CliConveFondoDes)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2153CliConveFondoDes", A2153CliConveFondoDes);
      if ( dynCliConveFondoRelSec.getItemCount() > 0 )
      {
         A2154CliConveFondoRelSec = (int)(GXutil.lval( dynCliConveFondoRelSec.getValidValue(GXutil.trim( GXutil.str( A2154CliConveFondoRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2154CliConveFondoRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2154CliConveFondoRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConveFondoRelSec.setValue( GXutil.trim( GXutil.str( A2154CliConveFondoRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynCliConveFondoRelSec.getInternalname(), "Values", dynCliConveFondoRelSec.ToJavascriptSource(), true);
      }
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedcliconvenio_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcliconvenio_Internalname, httpContext.getMessage( "Convenio", ""), "", "", lblTextblockcliconvenio_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Clientecct_fondocese.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_cliconvenio.setProperty("Caption", Combo_cliconvenio_Caption);
      ucCombo_cliconvenio.setProperty("Cls", Combo_cliconvenio_Cls);
      ucCombo_cliconvenio.setProperty("DataListProc", Combo_cliconvenio_Datalistproc);
      ucCombo_cliconvenio.setProperty("EmptyItem", Combo_cliconvenio_Emptyitem);
      ucCombo_cliconvenio.setProperty("DropDownOptionsTitleSettingsIcons", AV18DDO_TitleSettingsIcons);
      ucCombo_cliconvenio.setProperty("DropDownOptionsData", AV17CliConvenio_Data);
      ucCombo_cliconvenio.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_cliconvenio_Internalname, "COMBO_CLICONVENIOContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliConvenio_Internalname, httpContext.getMessage( "Convenio", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConvenio_Visible, edtCliConvenio_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Clientecct_fondocese.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedcliconvevig_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcliconvevig_Internalname, httpContext.getMessage( "Fecha de vigencia", ""), "", "", lblTextblockcliconvevig_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Clientecct_fondocese.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_cliconvevig.setProperty("Caption", Combo_cliconvevig_Caption);
      ucCombo_cliconvevig.setProperty("Cls", Combo_cliconvevig_Cls);
      ucCombo_cliconvevig.setProperty("DataListProc", Combo_cliconvevig_Datalistproc);
      ucCombo_cliconvevig.setProperty("EmptyItem", Combo_cliconvevig_Emptyitem);
      ucCombo_cliconvevig.setProperty("DropDownOptionsTitleSettingsIcons", AV18DDO_TitleSettingsIcons);
      ucCombo_cliconvevig.setProperty("DropDownOptionsData", AV23CliConveVig_Data);
      ucCombo_cliconvevig.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_cliconvevig_Internalname, "COMBO_CLICONVEVIGContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliConveVig_Internalname, httpContext.getMessage( "Fecha de vigencia", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtCliConveVig_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveVig_Internalname, localUtil.format(A1575CliConveVig, "99/99/99"), localUtil.format( A1575CliConveVig, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveVig_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConveVig_Visible, edtCliConveVig_Enabled, 1, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Clientecct_fondocese.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtCliConveVig_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtCliConveVig_Visible==0)||(edtCliConveVig_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Clientecct_fondocese.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConveFondoSec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliConveFondoSec_Internalname, httpContext.getMessage( "Fondo Sec", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveFondoSec_Internalname, GXutil.ltrim( localUtil.ntoc( A2147CliConveFondoSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2147CliConveFondoSec), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveFondoSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliConveFondoSec_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Clientecct_fondocese.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConveFondoMeses_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliConveFondoMeses_Internalname, httpContext.getMessage( "Meses desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveFondoMeses_Internalname, GXutil.ltrim( localUtil.ntoc( A2148CliConveFondoMeses, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliConveFondoMeses_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2148CliConveFondoMeses), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2148CliConveFondoMeses), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveFondoMeses_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliConveFondoMeses_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Clientecct_fondocese.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConveFondoPrc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliConveFondoPrc_Internalname, httpContext.getMessage( "Porcentaje", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveFondoPrc_Internalname, GXutil.ltrim( localUtil.ntoc( A2150CliConveFondoPrc, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliConveFondoPrc_Enabled!=0) ? localUtil.format( A2150CliConveFondoPrc, "9.9999") : localUtil.format( A2150CliConveFondoPrc, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveFondoPrc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliConveFondoPrc_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Clientecct_fondocese.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCliConveFondoRem.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkCliConveFondoRem.getInternalname(), httpContext.getMessage( "Contemplar remunerativos", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCliConveFondoRem.getInternalname(), GXutil.booltostr( A2151CliConveFondoRem), "", httpContext.getMessage( "Contemplar remunerativos", ""), 1, chkCliConveFondoRem.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(59, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,59);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCliConveFondoNre.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkCliConveFondoNre.getInternalname(), httpContext.getMessage( "Contemplar no remunerativos", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCliConveFondoNre.getInternalname(), GXutil.booltostr( A2152CliConveFondoNre), "", httpContext.getMessage( "Contemplar no remunerativos", ""), 1, chkCliConveFondoNre.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(64, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,64);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCliConveFondoDes.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkCliConveFondoDes.getInternalname(), httpContext.getMessage( "Contemplar descuentos", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCliConveFondoDes.getInternalname(), GXutil.booltostr( A2153CliConveFondoDes), "", httpContext.getMessage( "Contemplar descuentos", ""), 1, chkCliConveFondoDes.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(69, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,69);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divCliconvefondorelsec_cell_Internalname, 1, 0, "px", 0, "px", divCliconvefondorelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynCliConveFondoRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynCliConveFondoRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynCliConveFondoRelSec, dynCliConveFondoRelSec.getInternalname(), GXutil.trim( GXutil.str( A2154CliConveFondoRelSec, 6, 0)), 1, dynCliConveFondoRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynCliConveFondoRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", "", true, (byte)(0), "HLP_Clientecct_fondocese.htm");
      dynCliConveFondoRelSec.setValue( GXutil.trim( GXutil.str( A2154CliConveFondoRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynCliConveFondoRelSec.getInternalname(), "Values", dynCliConveFondoRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Clientecct_fondocese.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Clientecct_fondocese.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 86,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Clientecct_fondocese.htm");
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
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_cliconvenio_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombocliconvenio_Internalname, GXutil.rtrim( AV22ComboCliConvenio), GXutil.rtrim( localUtil.format( AV22ComboCliConvenio, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombocliconvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombocliconvenio_Visible, edtavCombocliconvenio_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Clientecct_fondocese.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_cliconvevig_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.writeText( "<div id=\""+edtavCombocliconvevig_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombocliconvevig_Internalname, localUtil.format(AV24ComboCliConveVig, "99/99/99"), localUtil.format( AV24ComboCliConveVig, "99/99/99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombocliconvevig_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombocliconvevig_Visible, edtavCombocliconvevig_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Clientecct_fondocese.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtavCombocliconvevig_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavCombocliconvevig_Visible==0)||(edtavCombocliconvevig_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Clientecct_fondocese.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,94);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Clientecct_fondocese.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 95,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,95);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, edtCliPaiConve_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Clientecct_fondocese.htm");
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
      e11682 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV18DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLICONVENIO_DATA"), AV17CliConvenio_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLICONVEVIG_DATA"), AV23CliConveVig_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "Z1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1565CliConvenio = httpContext.cgiGet( "Z1565CliConvenio") ;
            Z1575CliConveVig = localUtil.ctod( httpContext.cgiGet( "Z1575CliConveVig"), 0) ;
            Z2147CliConveFondoSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z2147CliConveFondoSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2148CliConveFondoMeses = (short)(localUtil.ctol( httpContext.cgiGet( "Z2148CliConveFondoMeses"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2150CliConveFondoPrc = localUtil.ctond( httpContext.cgiGet( "Z2150CliConveFondoPrc")) ;
            Z2151CliConveFondoRem = GXutil.strtobool( httpContext.cgiGet( "Z2151CliConveFondoRem")) ;
            Z2152CliConveFondoNre = GXutil.strtobool( httpContext.cgiGet( "Z2152CliConveFondoNre")) ;
            Z2153CliConveFondoDes = GXutil.strtobool( httpContext.cgiGet( "Z2153CliConveFondoDes")) ;
            Z2154CliConveFondoRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z2154CliConveFondoRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2155CliConveFondoRelRef = httpContext.cgiGet( "Z2155CliConveFondoRelRef") ;
            A2155CliConveFondoRelRef = httpContext.cgiGet( "Z2155CliConveFondoRelRef") ;
            O2153CliConveFondoDes = GXutil.strtobool( httpContext.cgiGet( "O2153CliConveFondoDes")) ;
            O2152CliConveFondoNre = GXutil.strtobool( httpContext.cgiGet( "O2152CliConveFondoNre")) ;
            O2151CliConveFondoRem = GXutil.strtobool( httpContext.cgiGet( "O2151CliConveFondoRem")) ;
            O2150CliConveFondoPrc = localUtil.ctond( httpContext.cgiGet( "O2150CliConveFondoPrc")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV25Cond_CliConvenio = httpContext.cgiGet( "vCOND_CLICONVENIO") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV10CliConveVig = localUtil.ctod( httpContext.cgiGet( "vCLICONVEVIG"), 0) ;
            AV11CliConveFondoSec = (short)(localUtil.ctol( httpContext.cgiGet( "vCLICONVEFONDOSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2155CliConveFondoRelRef = httpContext.cgiGet( "CLICONVEFONDORELREF") ;
            A2156CliConveFondoOld = httpContext.cgiGet( "CLICONVEFONDOOLD") ;
            AV26Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_cliconvenio_Objectcall = httpContext.cgiGet( "COMBO_CLICONVENIO_Objectcall") ;
            Combo_cliconvenio_Class = httpContext.cgiGet( "COMBO_CLICONVENIO_Class") ;
            Combo_cliconvenio_Icontype = httpContext.cgiGet( "COMBO_CLICONVENIO_Icontype") ;
            Combo_cliconvenio_Icon = httpContext.cgiGet( "COMBO_CLICONVENIO_Icon") ;
            Combo_cliconvenio_Caption = httpContext.cgiGet( "COMBO_CLICONVENIO_Caption") ;
            Combo_cliconvenio_Tooltip = httpContext.cgiGet( "COMBO_CLICONVENIO_Tooltip") ;
            Combo_cliconvenio_Cls = httpContext.cgiGet( "COMBO_CLICONVENIO_Cls") ;
            Combo_cliconvenio_Selectedvalue_set = httpContext.cgiGet( "COMBO_CLICONVENIO_Selectedvalue_set") ;
            Combo_cliconvenio_Selectedvalue_get = httpContext.cgiGet( "COMBO_CLICONVENIO_Selectedvalue_get") ;
            Combo_cliconvenio_Selectedtext_set = httpContext.cgiGet( "COMBO_CLICONVENIO_Selectedtext_set") ;
            Combo_cliconvenio_Selectedtext_get = httpContext.cgiGet( "COMBO_CLICONVENIO_Selectedtext_get") ;
            Combo_cliconvenio_Gamoauthtoken = httpContext.cgiGet( "COMBO_CLICONVENIO_Gamoauthtoken") ;
            Combo_cliconvenio_Ddointernalname = httpContext.cgiGet( "COMBO_CLICONVENIO_Ddointernalname") ;
            Combo_cliconvenio_Titlecontrolalign = httpContext.cgiGet( "COMBO_CLICONVENIO_Titlecontrolalign") ;
            Combo_cliconvenio_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CLICONVENIO_Dropdownoptionstype") ;
            Combo_cliconvenio_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Enabled")) ;
            Combo_cliconvenio_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Visible")) ;
            Combo_cliconvenio_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CLICONVENIO_Titlecontrolidtoreplace") ;
            Combo_cliconvenio_Datalisttype = httpContext.cgiGet( "COMBO_CLICONVENIO_Datalisttype") ;
            Combo_cliconvenio_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Allowmultipleselection")) ;
            Combo_cliconvenio_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CLICONVENIO_Datalistfixedvalues") ;
            Combo_cliconvenio_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Isgriditem")) ;
            Combo_cliconvenio_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Hasdescription")) ;
            Combo_cliconvenio_Datalistproc = httpContext.cgiGet( "COMBO_CLICONVENIO_Datalistproc") ;
            Combo_cliconvenio_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CLICONVENIO_Datalistprocparametersprefix") ;
            Combo_cliconvenio_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CLICONVENIO_Remoteservicesparameters") ;
            Combo_cliconvenio_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLICONVENIO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_cliconvenio_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Includeonlyselectedoption")) ;
            Combo_cliconvenio_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Includeselectalloption")) ;
            Combo_cliconvenio_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Emptyitem")) ;
            Combo_cliconvenio_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVENIO_Includeaddnewoption")) ;
            Combo_cliconvenio_Htmltemplate = httpContext.cgiGet( "COMBO_CLICONVENIO_Htmltemplate") ;
            Combo_cliconvenio_Multiplevaluestype = httpContext.cgiGet( "COMBO_CLICONVENIO_Multiplevaluestype") ;
            Combo_cliconvenio_Loadingdata = httpContext.cgiGet( "COMBO_CLICONVENIO_Loadingdata") ;
            Combo_cliconvenio_Noresultsfound = httpContext.cgiGet( "COMBO_CLICONVENIO_Noresultsfound") ;
            Combo_cliconvenio_Emptyitemtext = httpContext.cgiGet( "COMBO_CLICONVENIO_Emptyitemtext") ;
            Combo_cliconvenio_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CLICONVENIO_Onlyselectedvalues") ;
            Combo_cliconvenio_Selectalltext = httpContext.cgiGet( "COMBO_CLICONVENIO_Selectalltext") ;
            Combo_cliconvenio_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CLICONVENIO_Multiplevaluesseparator") ;
            Combo_cliconvenio_Addnewoptiontext = httpContext.cgiGet( "COMBO_CLICONVENIO_Addnewoptiontext") ;
            Combo_cliconvenio_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLICONVENIO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_cliconvevig_Objectcall = httpContext.cgiGet( "COMBO_CLICONVEVIG_Objectcall") ;
            Combo_cliconvevig_Class = httpContext.cgiGet( "COMBO_CLICONVEVIG_Class") ;
            Combo_cliconvevig_Icontype = httpContext.cgiGet( "COMBO_CLICONVEVIG_Icontype") ;
            Combo_cliconvevig_Icon = httpContext.cgiGet( "COMBO_CLICONVEVIG_Icon") ;
            Combo_cliconvevig_Caption = httpContext.cgiGet( "COMBO_CLICONVEVIG_Caption") ;
            Combo_cliconvevig_Tooltip = httpContext.cgiGet( "COMBO_CLICONVEVIG_Tooltip") ;
            Combo_cliconvevig_Cls = httpContext.cgiGet( "COMBO_CLICONVEVIG_Cls") ;
            Combo_cliconvevig_Selectedvalue_set = httpContext.cgiGet( "COMBO_CLICONVEVIG_Selectedvalue_set") ;
            Combo_cliconvevig_Selectedvalue_get = httpContext.cgiGet( "COMBO_CLICONVEVIG_Selectedvalue_get") ;
            Combo_cliconvevig_Selectedtext_set = httpContext.cgiGet( "COMBO_CLICONVEVIG_Selectedtext_set") ;
            Combo_cliconvevig_Selectedtext_get = httpContext.cgiGet( "COMBO_CLICONVEVIG_Selectedtext_get") ;
            Combo_cliconvevig_Gamoauthtoken = httpContext.cgiGet( "COMBO_CLICONVEVIG_Gamoauthtoken") ;
            Combo_cliconvevig_Ddointernalname = httpContext.cgiGet( "COMBO_CLICONVEVIG_Ddointernalname") ;
            Combo_cliconvevig_Titlecontrolalign = httpContext.cgiGet( "COMBO_CLICONVEVIG_Titlecontrolalign") ;
            Combo_cliconvevig_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CLICONVEVIG_Dropdownoptionstype") ;
            Combo_cliconvevig_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVEVIG_Enabled")) ;
            Combo_cliconvevig_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVEVIG_Visible")) ;
            Combo_cliconvevig_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CLICONVEVIG_Titlecontrolidtoreplace") ;
            Combo_cliconvevig_Datalisttype = httpContext.cgiGet( "COMBO_CLICONVEVIG_Datalisttype") ;
            Combo_cliconvevig_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVEVIG_Allowmultipleselection")) ;
            Combo_cliconvevig_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CLICONVEVIG_Datalistfixedvalues") ;
            Combo_cliconvevig_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVEVIG_Isgriditem")) ;
            Combo_cliconvevig_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVEVIG_Hasdescription")) ;
            Combo_cliconvevig_Datalistproc = httpContext.cgiGet( "COMBO_CLICONVEVIG_Datalistproc") ;
            Combo_cliconvevig_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CLICONVEVIG_Datalistprocparametersprefix") ;
            Combo_cliconvevig_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CLICONVEVIG_Remoteservicesparameters") ;
            Combo_cliconvevig_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLICONVEVIG_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_cliconvevig_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVEVIG_Includeonlyselectedoption")) ;
            Combo_cliconvevig_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVEVIG_Includeselectalloption")) ;
            Combo_cliconvevig_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVEVIG_Emptyitem")) ;
            Combo_cliconvevig_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICONVEVIG_Includeaddnewoption")) ;
            Combo_cliconvevig_Htmltemplate = httpContext.cgiGet( "COMBO_CLICONVEVIG_Htmltemplate") ;
            Combo_cliconvevig_Multiplevaluestype = httpContext.cgiGet( "COMBO_CLICONVEVIG_Multiplevaluestype") ;
            Combo_cliconvevig_Loadingdata = httpContext.cgiGet( "COMBO_CLICONVEVIG_Loadingdata") ;
            Combo_cliconvevig_Noresultsfound = httpContext.cgiGet( "COMBO_CLICONVEVIG_Noresultsfound") ;
            Combo_cliconvevig_Emptyitemtext = httpContext.cgiGet( "COMBO_CLICONVEVIG_Emptyitemtext") ;
            Combo_cliconvevig_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CLICONVEVIG_Onlyselectedvalues") ;
            Combo_cliconvevig_Selectalltext = httpContext.cgiGet( "COMBO_CLICONVEVIG_Selectalltext") ;
            Combo_cliconvevig_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CLICONVEVIG_Multiplevaluesseparator") ;
            Combo_cliconvevig_Addnewoptiontext = httpContext.cgiGet( "COMBO_CLICONVEVIG_Addnewoptiontext") ;
            Combo_cliconvevig_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLICONVEVIG_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A1565CliConvenio = httpContext.cgiGet( edtCliConvenio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            if ( localUtil.vcdate( httpContext.cgiGet( edtCliConveVig_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "CLICONVEVIG");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliConveVig_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1575CliConveVig = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
            }
            else
            {
               A1575CliConveVig = localUtil.ctod( httpContext.cgiGet( edtCliConveVig_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveFondoSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveFondoSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICONVEFONDOSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliConveFondoSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2147CliConveFondoSec = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
            }
            else
            {
               A2147CliConveFondoSec = (short)(localUtil.ctol( httpContext.cgiGet( edtCliConveFondoSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveFondoMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveFondoMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICONVEFONDOMESES");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliConveFondoMeses_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2148CliConveFondoMeses = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2148CliConveFondoMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2148CliConveFondoMeses), 4, 0));
            }
            else
            {
               A2148CliConveFondoMeses = (short)(localUtil.ctol( httpContext.cgiGet( edtCliConveFondoMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2148CliConveFondoMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2148CliConveFondoMeses), 4, 0));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtCliConveFondoPrc_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtCliConveFondoPrc_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICONVEFONDOPRC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliConveFondoPrc_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2150CliConveFondoPrc = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A2150CliConveFondoPrc", GXutil.ltrimstr( A2150CliConveFondoPrc, 6, 4));
            }
            else
            {
               A2150CliConveFondoPrc = localUtil.ctond( httpContext.cgiGet( edtCliConveFondoPrc_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2150CliConveFondoPrc", GXutil.ltrimstr( A2150CliConveFondoPrc, 6, 4));
            }
            A2151CliConveFondoRem = GXutil.strtobool( httpContext.cgiGet( chkCliConveFondoRem.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2151CliConveFondoRem", A2151CliConveFondoRem);
            A2152CliConveFondoNre = GXutil.strtobool( httpContext.cgiGet( chkCliConveFondoNre.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2152CliConveFondoNre", A2152CliConveFondoNre);
            A2153CliConveFondoDes = GXutil.strtobool( httpContext.cgiGet( chkCliConveFondoDes.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2153CliConveFondoDes", A2153CliConveFondoDes);
            dynCliConveFondoRelSec.setValue( httpContext.cgiGet( dynCliConveFondoRelSec.getInternalname()) );
            A2154CliConveFondoRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynCliConveFondoRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2154CliConveFondoRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2154CliConveFondoRelSec), 6, 0));
            AV22ComboCliConvenio = httpContext.cgiGet( edtavCombocliconvenio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22ComboCliConvenio", AV22ComboCliConvenio);
            AV24ComboCliConveVig = localUtil.ctod( httpContext.cgiGet( edtavCombocliconvevig_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24ComboCliConveVig", localUtil.format(AV24ComboCliConveVig, "99/99/99"));
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIPAICONVE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliPaiConve_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1564CliPaiConve = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            }
            else
            {
               A1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Clientecct_fondocese");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("CliConveFondoRelRef", GXutil.rtrim( localUtil.format( A2155CliConveFondoRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) || ( A2147CliConveFondoSec != Z2147CliConveFondoSec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("clientecct_fondocese:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A1575CliConveVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveVig")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
               A2147CliConveFondoSec = (short)(GXutil.lval( httpContext.GetPar( "CliConveFondoSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
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
                  sMode271 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode271 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound271 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_680( ) ;
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
                        e11682 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12682 ();
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
         e12682 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll68271( ) ;
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
         disableAttributes68271( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliconvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliconvenio_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliconvevig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliconvevig_Enabled), 5, 0), true);
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

   public void confirm_680( )
   {
      beforeValidate68271( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls68271( ) ;
         }
         else
         {
            checkExtendedTable68271( ) ;
            closeExtendedTableCursors68271( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption680( )
   {
   }

   public void e11682( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV12WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV12WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV18DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV18DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtCliConveVig_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVig_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVig_Visible), 5, 0), true);
      AV24ComboCliConveVig = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboCliConveVig", localUtil.format(AV24ComboCliConveVig, "99/99/99"));
      edtavCombocliconvevig_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliconvevig_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliconvevig_Visible), 5, 0), true);
      edtCliConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Visible), 5, 0), true);
      AV22ComboCliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboCliConvenio", AV22ComboCliConvenio);
      edtavCombocliconvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliconvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliconvenio_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCLICONVENIO' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOCLICONVEVIG' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClientecct_fondocese_Insert", GXv_boolean5) ;
         clientecct_fondocese_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClientecct_fondocese_Update", GXv_boolean5) ;
         clientecct_fondocese_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClientecct_fondocese_Delete", GXv_boolean5) ;
         clientecct_fondocese_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV26Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV15TrnContext.fromxml(AV16WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
   }

   public void e12682( )
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

   public void S132( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      divCliconvefondorelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divCliconvefondorelsec_cell_Internalname, "Class", divCliconvefondorelsec_cell_Class, true);
   }

   public void S122( )
   {
      /* 'LOADCOMBOCLICONVEVIG' Routine */
      returnInSub = false ;
      Combo_cliconvevig_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"CliConveVig\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliPaiConve\": 0, \"CliConvenio\": \"\", \"CliConveVig\": \"\", \"CliConveFondoSec\": 0, \"Cond_CliCod\": \"#%1#\", \"Cond_CliPaiConve\": \"#%2#\", \"Cond_CliConvenio\": \"#%3#\"", edtCliCod_Internalname, edtCliPaiConve_Internalname, edtCliConvenio_Internalname, "", "", "", "", "", "") ;
      ucCombo_cliconvevig.sendProperty(context, "", false, Combo_cliconvevig_Internalname, "DataListProcParametersPrefix", Combo_cliconvevig_Datalistprocparametersprefix);
      GXt_char6 = AV21Combo_DataJson ;
      GXv_char7[0] = AV19ComboSelectedValue ;
      GXv_char8[0] = AV20ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new web.clientecct_fondoceseloaddvcombo(remoteHandle, context).execute( "CliConveVig", Gx_mode, false, AV7CliCod, AV8CliPaiConve, AV9CliConvenio, AV10CliConveVig, AV11CliConveFondoSec, A3CliCod, A1564CliPaiConve, A1565CliConvenio, "", GXv_char7, GXv_char8, GXv_char9) ;
      clientecct_fondocese_impl.this.AV19ComboSelectedValue = GXv_char7[0] ;
      clientecct_fondocese_impl.this.AV20ComboSelectedText = GXv_char8[0] ;
      clientecct_fondocese_impl.this.GXt_char6 = GXv_char9[0] ;
      AV21Combo_DataJson = GXt_char6 ;
      Combo_cliconvevig_Selectedvalue_set = AV19ComboSelectedValue ;
      ucCombo_cliconvevig.sendProperty(context, "", false, Combo_cliconvevig_Internalname, "SelectedValue_set", Combo_cliconvevig_Selectedvalue_set);
      Combo_cliconvevig_Selectedtext_set = AV20ComboSelectedText ;
      ucCombo_cliconvevig.sendProperty(context, "", false, Combo_cliconvevig_Internalname, "SelectedText_set", Combo_cliconvevig_Selectedtext_set);
      AV24ComboCliConveVig = localUtil.ctod( AV19ComboSelectedValue, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboCliConveVig", localUtil.format(AV24ComboCliConveVig, "99/99/99"));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10CliConveVig)) )
      {
         Combo_cliconvevig_Enabled = false ;
         ucCombo_cliconvevig.sendProperty(context, "", false, Combo_cliconvevig_Internalname, "Enabled", GXutil.booltostr( Combo_cliconvevig_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOCLICONVENIO' Routine */
      returnInSub = false ;
      Combo_cliconvenio_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"CliConvenio\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliPaiConve\": 0, \"CliConvenio\": \"\", \"CliConveVig\": \"\", \"CliConveFondoSec\": 0, \"Cond_CliCod\": \"#%1#\", \"Cond_CliPaiConve\": \"#%2#\", \"Cond_CliConvenio\": \"#%3#\"", edtCliCod_Internalname, edtCliPaiConve_Internalname, edtCliConvenio_Internalname, "", "", "", "", "", "") ;
      ucCombo_cliconvenio.sendProperty(context, "", false, Combo_cliconvenio_Internalname, "DataListProcParametersPrefix", Combo_cliconvenio_Datalistprocparametersprefix);
      GXt_char6 = AV21Combo_DataJson ;
      GXv_char9[0] = AV19ComboSelectedValue ;
      GXv_char8[0] = AV20ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.clientecct_fondoceseloaddvcombo(remoteHandle, context).execute( "CliConvenio", Gx_mode, false, AV7CliCod, AV8CliPaiConve, AV9CliConvenio, AV10CliConveVig, AV11CliConveFondoSec, A3CliCod, A1564CliPaiConve, A1565CliConvenio, "", GXv_char9, GXv_char8, GXv_char7) ;
      clientecct_fondocese_impl.this.AV19ComboSelectedValue = GXv_char9[0] ;
      clientecct_fondocese_impl.this.AV20ComboSelectedText = GXv_char8[0] ;
      clientecct_fondocese_impl.this.GXt_char6 = GXv_char7[0] ;
      AV21Combo_DataJson = GXt_char6 ;
      Combo_cliconvenio_Selectedvalue_set = AV19ComboSelectedValue ;
      ucCombo_cliconvenio.sendProperty(context, "", false, Combo_cliconvenio_Internalname, "SelectedValue_set", Combo_cliconvenio_Selectedvalue_set);
      Combo_cliconvenio_Selectedtext_set = AV20ComboSelectedText ;
      ucCombo_cliconvenio.sendProperty(context, "", false, Combo_cliconvenio_Internalname, "SelectedText_set", Combo_cliconvenio_Selectedtext_set);
      AV22ComboCliConvenio = AV19ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboCliConvenio", AV22ComboCliConvenio);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         Combo_cliconvenio_Enabled = false ;
         ucCombo_cliconvenio.sendProperty(context, "", false, Combo_cliconvenio_Internalname, "Enabled", GXutil.booltostr( Combo_cliconvenio_Enabled));
      }
   }

   public void zm68271( int GX_JID )
   {
      if ( ( GX_JID == 20 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2148CliConveFondoMeses = T00683_A2148CliConveFondoMeses[0] ;
            Z2150CliConveFondoPrc = T00683_A2150CliConveFondoPrc[0] ;
            Z2151CliConveFondoRem = T00683_A2151CliConveFondoRem[0] ;
            Z2152CliConveFondoNre = T00683_A2152CliConveFondoNre[0] ;
            Z2153CliConveFondoDes = T00683_A2153CliConveFondoDes[0] ;
            Z2154CliConveFondoRelSec = T00683_A2154CliConveFondoRelSec[0] ;
            Z2155CliConveFondoRelRef = T00683_A2155CliConveFondoRelRef[0] ;
         }
         else
         {
            Z2148CliConveFondoMeses = A2148CliConveFondoMeses ;
            Z2150CliConveFondoPrc = A2150CliConveFondoPrc ;
            Z2151CliConveFondoRem = A2151CliConveFondoRem ;
            Z2152CliConveFondoNre = A2152CliConveFondoNre ;
            Z2153CliConveFondoDes = A2153CliConveFondoDes ;
            Z2154CliConveFondoRelSec = A2154CliConveFondoRelSec ;
            Z2155CliConveFondoRelRef = A2155CliConveFondoRelRef ;
         }
      }
      if ( GX_JID == -20 )
      {
         Z2147CliConveFondoSec = A2147CliConveFondoSec ;
         Z2148CliConveFondoMeses = A2148CliConveFondoMeses ;
         Z2150CliConveFondoPrc = A2150CliConveFondoPrc ;
         Z2151CliConveFondoRem = A2151CliConveFondoRem ;
         Z2152CliConveFondoNre = A2152CliConveFondoNre ;
         Z2153CliConveFondoDes = A2153CliConveFondoDes ;
         Z2154CliConveFondoRelSec = A2154CliConveFondoRelSec ;
         Z2155CliConveFondoRelRef = A2155CliConveFondoRelRef ;
         Z2156CliConveFondoOld = A2156CliConveFondoOld ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1575CliConveVig = A1575CliConveVig ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxacliconvefondorelsec_html68271( AV7CliCod) ;
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int10 = A3CliCod ;
            GXv_int11[0] = GXt_int10 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int11) ;
            clientecct_fondocese_impl.this.GXt_int10 = GXv_int11[0] ;
            A3CliCod = GXt_int10 ;
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
      if ( ! (0==AV8CliPaiConve) )
      {
         A1564CliPaiConve = AV8CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         edtCliPaiConve_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      else
      {
         edtCliPaiConve_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         edtCliPaiConve_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         edtCliConvenio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      else
      {
         edtCliConvenio_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         edtCliConvenio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10CliConveVig)) )
      {
         edtCliConveVig_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVig_Enabled), 5, 0), true);
      }
      else
      {
         edtCliConveVig_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVig_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10CliConveVig)) )
      {
         edtCliConveVig_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVig_Enabled), 5, 0), true);
      }
      if ( ! (0==AV11CliConveFondoSec) )
      {
         A2147CliConveFondoSec = AV11CliConveFondoSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
      }
      if ( ! (0==AV11CliConveFondoSec) )
      {
         edtCliConveFondoSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveFondoSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveFondoSec_Enabled), 5, 0), true);
      }
      else
      {
         edtCliConveFondoSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveFondoSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveFondoSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV11CliConveFondoSec) )
      {
         edtCliConveFondoSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveFondoSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveFondoSec_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10CliConveVig)) )
      {
         A1575CliConveVig = AV10CliConveVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
      }
      else
      {
         A1575CliConveVig = AV24ComboCliConveVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         A1565CliConvenio = AV9CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      else
      {
         A1565CliConvenio = AV22ComboCliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
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
         AV26Pgmname = "Clientecct_fondocese" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      }
   }

   public void load68271( )
   {
      /* Using cursor T00685 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Short.valueOf(A2147CliConveFondoSec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound271 = (short)(1) ;
         A2148CliConveFondoMeses = T00685_A2148CliConveFondoMeses[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2148CliConveFondoMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2148CliConveFondoMeses), 4, 0));
         A2150CliConveFondoPrc = T00685_A2150CliConveFondoPrc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2150CliConveFondoPrc", GXutil.ltrimstr( A2150CliConveFondoPrc, 6, 4));
         A2151CliConveFondoRem = T00685_A2151CliConveFondoRem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2151CliConveFondoRem", A2151CliConveFondoRem);
         A2152CliConveFondoNre = T00685_A2152CliConveFondoNre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2152CliConveFondoNre", A2152CliConveFondoNre);
         A2153CliConveFondoDes = T00685_A2153CliConveFondoDes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2153CliConveFondoDes", A2153CliConveFondoDes);
         A2154CliConveFondoRelSec = T00685_A2154CliConveFondoRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2154CliConveFondoRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2154CliConveFondoRelSec), 6, 0));
         A2155CliConveFondoRelRef = T00685_A2155CliConveFondoRelRef[0] ;
         A2156CliConveFondoOld = T00685_A2156CliConveFondoOld[0] ;
         zm68271( -20) ;
      }
      pr_default.close(3);
      onLoadActions68271( ) ;
   }

   public void onLoadActions68271( )
   {
      AV26Pgmname = "Clientecct_fondocese" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      if ( ! ( ( DecimalUtil.compareTo(A2150CliConveFondoPrc, O2150CliConveFondoPrc) != 0 ) || ( A2151CliConveFondoRem != O2151CliConveFondoRem ) || ( A2152CliConveFondoNre != O2152CliConveFondoNre ) || ( A2153CliConveFondoDes != O2153CliConveFondoDes ) ) )
      {
         divCliconvefondorelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divCliconvefondorelsec_cell_Internalname, "Class", divCliconvefondorelsec_cell_Class, true);
      }
      else
      {
         if ( ( DecimalUtil.compareTo(A2150CliConveFondoPrc, O2150CliConveFondoPrc) != 0 ) || ( A2151CliConveFondoRem != O2151CliConveFondoRem ) || ( A2152CliConveFondoNre != O2152CliConveFondoNre ) || ( A2153CliConveFondoDes != O2153CliConveFondoDes ) )
         {
            divCliconvefondorelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCliconvefondorelsec_cell_Internalname, "Class", divCliconvefondorelsec_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable68271( )
   {
      nIsDirty_271 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV26Pgmname = "Clientecct_fondocese" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      /* Using cursor T00684 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenio_Particularidades", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVEVIG");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T00686 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Short.valueOf(A2148CliConveFondoMeses), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Short.valueOf(A2147CliConveFondoSec)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Cli Cod", "")+","+httpContext.getMessage( "Cli Pai Conve", "")+","+httpContext.getMessage( "Convenio", "")+","+httpContext.getMessage( "Fecha de vigencia", "")+","+httpContext.getMessage( "Meses desde", "")}), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      if ( ! ( ( DecimalUtil.compareTo(A2150CliConveFondoPrc, O2150CliConveFondoPrc) != 0 ) || ( A2151CliConveFondoRem != O2151CliConveFondoRem ) || ( A2152CliConveFondoNre != O2152CliConveFondoNre ) || ( A2153CliConveFondoDes != O2153CliConveFondoDes ) ) )
      {
         divCliconvefondorelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divCliconvefondorelsec_cell_Internalname, "Class", divCliconvefondorelsec_cell_Class, true);
      }
      else
      {
         if ( ( DecimalUtil.compareTo(A2150CliConveFondoPrc, O2150CliConveFondoPrc) != 0 ) || ( A2151CliConveFondoRem != O2151CliConveFondoRem ) || ( A2152CliConveFondoNre != O2152CliConveFondoNre ) || ( A2153CliConveFondoDes != O2153CliConveFondoDes ) )
         {
            divCliconvefondorelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCliconvefondorelsec_cell_Internalname, "Class", divCliconvefondorelsec_cell_Class, true);
         }
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A2150CliConveFondoPrc)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Porcentaje", ""), "", "", "", "", "", "", "", ""), 1, "CLICONVEFONDOPRC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliConveFondoPrc_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ( ( DecimalUtil.compareTo(A2150CliConveFondoPrc, O2150CliConveFondoPrc) != 0 ) || ( A2151CliConveFondoRem != O2151CliConveFondoRem ) || ( A2152CliConveFondoNre != O2152CliConveFondoNre ) || ( A2153CliConveFondoDes != O2153CliConveFondoDes ) ) && (0==A2154CliConveFondoRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CLICONVEFONDOPRC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliConveFondoPrc_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors68271( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_22( int A3CliCod ,
                          short A1564CliPaiConve ,
                          String A1565CliConvenio ,
                          java.util.Date A1575CliConveVig )
   {
      /* Using cursor T00687 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenio_Particularidades", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVEVIG");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void getKey68271( )
   {
      /* Using cursor T00688 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Short.valueOf(A2147CliConveFondoSec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound271 = (short)(1) ;
      }
      else
      {
         RcdFound271 = (short)(0) ;
      }
      pr_default.close(6);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00683 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Short.valueOf(A2147CliConveFondoSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm68271( 20) ;
         RcdFound271 = (short)(1) ;
         A2147CliConveFondoSec = T00683_A2147CliConveFondoSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
         A2148CliConveFondoMeses = T00683_A2148CliConveFondoMeses[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2148CliConveFondoMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2148CliConveFondoMeses), 4, 0));
         A2150CliConveFondoPrc = T00683_A2150CliConveFondoPrc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2150CliConveFondoPrc", GXutil.ltrimstr( A2150CliConveFondoPrc, 6, 4));
         A2151CliConveFondoRem = T00683_A2151CliConveFondoRem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2151CliConveFondoRem", A2151CliConveFondoRem);
         A2152CliConveFondoNre = T00683_A2152CliConveFondoNre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2152CliConveFondoNre", A2152CliConveFondoNre);
         A2153CliConveFondoDes = T00683_A2153CliConveFondoDes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2153CliConveFondoDes", A2153CliConveFondoDes);
         A2154CliConveFondoRelSec = T00683_A2154CliConveFondoRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2154CliConveFondoRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2154CliConveFondoRelSec), 6, 0));
         A2155CliConveFondoRelRef = T00683_A2155CliConveFondoRelRef[0] ;
         A2156CliConveFondoOld = T00683_A2156CliConveFondoOld[0] ;
         A3CliCod = T00683_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T00683_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T00683_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1575CliConveVig = T00683_A1575CliConveVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         O2153CliConveFondoDes = A2153CliConveFondoDes ;
         httpContext.ajax_rsp_assign_attri("", false, "A2153CliConveFondoDes", A2153CliConveFondoDes);
         O2152CliConveFondoNre = A2152CliConveFondoNre ;
         httpContext.ajax_rsp_assign_attri("", false, "A2152CliConveFondoNre", A2152CliConveFondoNre);
         O2151CliConveFondoRem = A2151CliConveFondoRem ;
         httpContext.ajax_rsp_assign_attri("", false, "A2151CliConveFondoRem", A2151CliConveFondoRem);
         O2150CliConveFondoPrc = A2150CliConveFondoPrc ;
         httpContext.ajax_rsp_assign_attri("", false, "A2150CliConveFondoPrc", GXutil.ltrimstr( A2150CliConveFondoPrc, 6, 4));
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1575CliConveVig = A1575CliConveVig ;
         Z2147CliConveFondoSec = A2147CliConveFondoSec ;
         sMode271 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load68271( ) ;
         if ( AnyError == 1 )
         {
            RcdFound271 = (short)(0) ;
            initializeNonKey68271( ) ;
         }
         Gx_mode = sMode271 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound271 = (short)(0) ;
         initializeNonKey68271( ) ;
         sMode271 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode271 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey68271( ) ;
      if ( RcdFound271 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound271 = (short)(0) ;
      /* Using cursor T00689 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1575CliConveVig, A1575CliConveVig, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), Short.valueOf(A2147CliConveFondoSec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00689_A3CliCod[0] < A3CliCod ) || ( T00689_A3CliCod[0] == A3CliCod ) && ( T00689_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T00689_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00689_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00689_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T00689_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00689_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00689_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T00689_A1575CliConveVig[0]).before( GXutil.resetTime( A1575CliConveVig )) || GXutil.dateCompare(GXutil.resetTime(T00689_A1575CliConveVig[0]), GXutil.resetTime(A1575CliConveVig)) && ( GXutil.strcmp(T00689_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00689_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00689_A3CliCod[0] == A3CliCod ) && ( T00689_A2147CliConveFondoSec[0] < A2147CliConveFondoSec ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00689_A3CliCod[0] > A3CliCod ) || ( T00689_A3CliCod[0] == A3CliCod ) && ( T00689_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T00689_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00689_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00689_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T00689_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00689_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00689_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T00689_A1575CliConveVig[0]).after( GXutil.resetTime( A1575CliConveVig )) || GXutil.dateCompare(GXutil.resetTime(T00689_A1575CliConveVig[0]), GXutil.resetTime(A1575CliConveVig)) && ( GXutil.strcmp(T00689_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00689_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00689_A3CliCod[0] == A3CliCod ) && ( T00689_A2147CliConveFondoSec[0] > A2147CliConveFondoSec ) ) )
         {
            A3CliCod = T00689_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T00689_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T00689_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A1575CliConveVig = T00689_A1575CliConveVig[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
            A2147CliConveFondoSec = T00689_A2147CliConveFondoSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
            RcdFound271 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void move_previous( )
   {
      RcdFound271 = (short)(0) ;
      /* Using cursor T006810 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1575CliConveVig, A1575CliConveVig, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), Short.valueOf(A2147CliConveFondoSec)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T006810_A3CliCod[0] > A3CliCod ) || ( T006810_A3CliCod[0] == A3CliCod ) && ( T006810_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T006810_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006810_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006810_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T006810_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T006810_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006810_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T006810_A1575CliConveVig[0]).after( GXutil.resetTime( A1575CliConveVig )) || GXutil.dateCompare(GXutil.resetTime(T006810_A1575CliConveVig[0]), GXutil.resetTime(A1575CliConveVig)) && ( GXutil.strcmp(T006810_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T006810_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006810_A3CliCod[0] == A3CliCod ) && ( T006810_A2147CliConveFondoSec[0] > A2147CliConveFondoSec ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T006810_A3CliCod[0] < A3CliCod ) || ( T006810_A3CliCod[0] == A3CliCod ) && ( T006810_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T006810_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006810_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006810_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T006810_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T006810_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006810_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T006810_A1575CliConveVig[0]).before( GXutil.resetTime( A1575CliConveVig )) || GXutil.dateCompare(GXutil.resetTime(T006810_A1575CliConveVig[0]), GXutil.resetTime(A1575CliConveVig)) && ( GXutil.strcmp(T006810_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T006810_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006810_A3CliCod[0] == A3CliCod ) && ( T006810_A2147CliConveFondoSec[0] < A2147CliConveFondoSec ) ) )
         {
            A3CliCod = T006810_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T006810_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T006810_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A1575CliConveVig = T006810_A1575CliConveVig[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
            A2147CliConveFondoSec = T006810_A2147CliConveFondoSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
            RcdFound271 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey68271( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliConvenio_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert68271( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound271 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) || ( A2147CliConveFondoSec != Z2147CliConveFondoSec ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A1575CliConveVig = Z1575CliConveVig ;
               httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
               A2147CliConveFondoSec = Z2147CliConveFondoSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCliConvenio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update68271( ) ;
               GX_FocusControl = edtCliConvenio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) || ( A2147CliConveFondoSec != Z2147CliConveFondoSec ) )
            {
               /* Insert record */
               GX_FocusControl = edtCliConvenio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert68271( ) ;
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
                  GX_FocusControl = edtCliConvenio_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert68271( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) || ( A2147CliConveFondoSec != Z2147CliConveFondoSec ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1575CliConveVig = Z1575CliConveVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         A2147CliConveFondoSec = Z2147CliConveFondoSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCliConvenio_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency68271( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00682 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Short.valueOf(A2147CliConveFondoSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Clientecct_fondocese"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z2148CliConveFondoMeses != T00682_A2148CliConveFondoMeses[0] ) || ( DecimalUtil.compareTo(Z2150CliConveFondoPrc, T00682_A2150CliConveFondoPrc[0]) != 0 ) || ( Z2151CliConveFondoRem != T00682_A2151CliConveFondoRem[0] ) || ( Z2152CliConveFondoNre != T00682_A2152CliConveFondoNre[0] ) || ( Z2153CliConveFondoDes != T00682_A2153CliConveFondoDes[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2154CliConveFondoRelSec != T00682_A2154CliConveFondoRelSec[0] ) || ( GXutil.strcmp(Z2155CliConveFondoRelRef, T00682_A2155CliConveFondoRelRef[0]) != 0 ) )
         {
            if ( Z2148CliConveFondoMeses != T00682_A2148CliConveFondoMeses[0] )
            {
               GXutil.writeLogln("clientecct_fondocese:[seudo value changed for attri]"+"CliConveFondoMeses");
               GXutil.writeLogRaw("Old: ",Z2148CliConveFondoMeses);
               GXutil.writeLogRaw("Current: ",T00682_A2148CliConveFondoMeses[0]);
            }
            if ( DecimalUtil.compareTo(Z2150CliConveFondoPrc, T00682_A2150CliConveFondoPrc[0]) != 0 )
            {
               GXutil.writeLogln("clientecct_fondocese:[seudo value changed for attri]"+"CliConveFondoPrc");
               GXutil.writeLogRaw("Old: ",Z2150CliConveFondoPrc);
               GXutil.writeLogRaw("Current: ",T00682_A2150CliConveFondoPrc[0]);
            }
            if ( Z2151CliConveFondoRem != T00682_A2151CliConveFondoRem[0] )
            {
               GXutil.writeLogln("clientecct_fondocese:[seudo value changed for attri]"+"CliConveFondoRem");
               GXutil.writeLogRaw("Old: ",Z2151CliConveFondoRem);
               GXutil.writeLogRaw("Current: ",T00682_A2151CliConveFondoRem[0]);
            }
            if ( Z2152CliConveFondoNre != T00682_A2152CliConveFondoNre[0] )
            {
               GXutil.writeLogln("clientecct_fondocese:[seudo value changed for attri]"+"CliConveFondoNre");
               GXutil.writeLogRaw("Old: ",Z2152CliConveFondoNre);
               GXutil.writeLogRaw("Current: ",T00682_A2152CliConveFondoNre[0]);
            }
            if ( Z2153CliConveFondoDes != T00682_A2153CliConveFondoDes[0] )
            {
               GXutil.writeLogln("clientecct_fondocese:[seudo value changed for attri]"+"CliConveFondoDes");
               GXutil.writeLogRaw("Old: ",Z2153CliConveFondoDes);
               GXutil.writeLogRaw("Current: ",T00682_A2153CliConveFondoDes[0]);
            }
            if ( Z2154CliConveFondoRelSec != T00682_A2154CliConveFondoRelSec[0] )
            {
               GXutil.writeLogln("clientecct_fondocese:[seudo value changed for attri]"+"CliConveFondoRelSec");
               GXutil.writeLogRaw("Old: ",Z2154CliConveFondoRelSec);
               GXutil.writeLogRaw("Current: ",T00682_A2154CliConveFondoRelSec[0]);
            }
            if ( GXutil.strcmp(Z2155CliConveFondoRelRef, T00682_A2155CliConveFondoRelRef[0]) != 0 )
            {
               GXutil.writeLogln("clientecct_fondocese:[seudo value changed for attri]"+"CliConveFondoRelRef");
               GXutil.writeLogRaw("Old: ",Z2155CliConveFondoRelRef);
               GXutil.writeLogRaw("Current: ",T00682_A2155CliConveFondoRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Clientecct_fondocese"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert68271( )
   {
      beforeValidate68271( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable68271( ) ;
      }
      if ( AnyError == 0 )
      {
         zm68271( 0) ;
         checkOptimisticConcurrency68271( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm68271( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert68271( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006811 */
                  pr_default.execute(9, new Object[] {Short.valueOf(A2147CliConveFondoSec), Short.valueOf(A2148CliConveFondoMeses), A2150CliConveFondoPrc, Boolean.valueOf(A2151CliConveFondoRem), Boolean.valueOf(A2152CliConveFondoNre), Boolean.valueOf(A2153CliConveFondoDes), Integer.valueOf(A2154CliConveFondoRelSec), A2155CliConveFondoRelRef, A2156CliConveFondoOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Clientecct_fondocese");
                  if ( (pr_default.getStatus(9) == 1) )
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
                        resetCaption680( ) ;
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
            load68271( ) ;
         }
         endLevel68271( ) ;
      }
      closeExtendedTableCursors68271( ) ;
   }

   public void update68271( )
   {
      beforeValidate68271( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable68271( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency68271( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm68271( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate68271( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006812 */
                  pr_default.execute(10, new Object[] {Short.valueOf(A2148CliConveFondoMeses), A2150CliConveFondoPrc, Boolean.valueOf(A2151CliConveFondoRem), Boolean.valueOf(A2152CliConveFondoNre), Boolean.valueOf(A2153CliConveFondoDes), Integer.valueOf(A2154CliConveFondoRelSec), A2155CliConveFondoRelRef, A2156CliConveFondoOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Short.valueOf(A2147CliConveFondoSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Clientecct_fondocese");
                  if ( (pr_default.getStatus(10) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Clientecct_fondocese"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate68271( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
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
         endLevel68271( ) ;
      }
      closeExtendedTableCursors68271( ) ;
   }

   public void deferredUpdate68271( )
   {
   }

   public void delete( )
   {
      beforeValidate68271( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency68271( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls68271( ) ;
         afterConfirm68271( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete68271( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T006813 */
               pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Short.valueOf(A2147CliConveFondoSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Clientecct_fondocese");
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
      sMode271 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel68271( ) ;
      Gx_mode = sMode271 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls68271( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV26Pgmname = "Clientecct_fondocese" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
         if ( ! ( ( DecimalUtil.compareTo(A2150CliConveFondoPrc, O2150CliConveFondoPrc) != 0 ) || ( A2151CliConveFondoRem != O2151CliConveFondoRem ) || ( A2152CliConveFondoNre != O2152CliConveFondoNre ) || ( A2153CliConveFondoDes != O2153CliConveFondoDes ) ) )
         {
            divCliconvefondorelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCliconvefondorelsec_cell_Internalname, "Class", divCliconvefondorelsec_cell_Class, true);
         }
         else
         {
            if ( ( DecimalUtil.compareTo(A2150CliConveFondoPrc, O2150CliConveFondoPrc) != 0 ) || ( A2151CliConveFondoRem != O2151CliConveFondoRem ) || ( A2152CliConveFondoNre != O2152CliConveFondoNre ) || ( A2153CliConveFondoDes != O2153CliConveFondoDes ) )
            {
               divCliconvefondorelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divCliconvefondorelsec_cell_Internalname, "Class", divCliconvefondorelsec_cell_Class, true);
            }
         }
      }
   }

   public void endLevel68271( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete68271( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "clientecct_fondocese");
         if ( AnyError == 0 )
         {
            confirmValues680( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "clientecct_fondocese");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart68271( )
   {
      /* Scan By routine */
      /* Using cursor T006814 */
      pr_default.execute(12);
      RcdFound271 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound271 = (short)(1) ;
         A3CliCod = T006814_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T006814_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T006814_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1575CliConveVig = T006814_A1575CliConveVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         A2147CliConveFondoSec = T006814_A2147CliConveFondoSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext68271( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound271 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound271 = (short)(1) ;
         A3CliCod = T006814_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T006814_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T006814_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1575CliConveVig = T006814_A1575CliConveVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         A2147CliConveFondoSec = T006814_A2147CliConveFondoSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
      }
   }

   public void scanEnd68271( )
   {
      pr_default.close(12);
   }

   public void afterConfirm68271( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert68271( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate68271( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete68271( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete68271( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate68271( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes68271( )
   {
      edtCliConvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      edtCliConveVig_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVig_Enabled), 5, 0), true);
      edtCliConveFondoSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveFondoSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveFondoSec_Enabled), 5, 0), true);
      edtCliConveFondoMeses_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveFondoMeses_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveFondoMeses_Enabled), 5, 0), true);
      edtCliConveFondoPrc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveFondoPrc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveFondoPrc_Enabled), 5, 0), true);
      chkCliConveFondoRem.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoRem.getInternalname(), "Enabled", GXutil.ltrimstr( chkCliConveFondoRem.getEnabled(), 5, 0), true);
      chkCliConveFondoNre.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoNre.getInternalname(), "Enabled", GXutil.ltrimstr( chkCliConveFondoNre.getEnabled(), 5, 0), true);
      chkCliConveFondoDes.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoDes.getInternalname(), "Enabled", GXutil.ltrimstr( chkCliConveFondoDes.getEnabled(), 5, 0), true);
      dynCliConveFondoRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynCliConveFondoRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConveFondoRelSec.getEnabled(), 5, 0), true);
      edtavCombocliconvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliconvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliconvenio_Enabled), 5, 0), true);
      edtavCombocliconvevig_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliconvevig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliconvevig_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliPaiConve_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes68271( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues680( )
   {
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.clientecct_fondocese", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(AV10CliConveVig)),GXutil.URLEncode(GXutil.ltrimstr(AV11CliConveFondoSec,4,0))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CliConveVig","CliConveFondoSec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Clientecct_fondocese");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("CliConveFondoRelRef", GXutil.rtrim( localUtil.format( A2155CliConveFondoRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("clientecct_fondocese:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1564CliPaiConve", GXutil.ltrim( localUtil.ntoc( Z1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1565CliConvenio", GXutil.rtrim( Z1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1575CliConveVig", localUtil.dtoc( Z1575CliConveVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2147CliConveFondoSec", GXutil.ltrim( localUtil.ntoc( Z2147CliConveFondoSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2148CliConveFondoMeses", GXutil.ltrim( localUtil.ntoc( Z2148CliConveFondoMeses, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2150CliConveFondoPrc", GXutil.ltrim( localUtil.ntoc( Z2150CliConveFondoPrc, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2151CliConveFondoRem", Z2151CliConveFondoRem);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2152CliConveFondoNre", Z2152CliConveFondoNre);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2153CliConveFondoDes", Z2153CliConveFondoDes);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2154CliConveFondoRelSec", GXutil.ltrim( localUtil.ntoc( Z2154CliConveFondoRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2155CliConveFondoRelRef", Z2155CliConveFondoRelRef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O2153CliConveFondoDes", O2153CliConveFondoDes);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O2152CliConveFondoNre", O2152CliConveFondoNre);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O2151CliConveFondoRem", O2151CliConveFondoRem);
      web.GxWebStd.gx_hidden_field( httpContext, "O2150CliConveFondoPrc", GXutil.ltrim( localUtil.ntoc( O2150CliConveFondoPrc, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLICONVENIO_DATA", AV17CliConvenio_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLICONVENIO_DATA", AV17CliConvenio_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLICONVEVIG_DATA", AV23CliConveVig_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLICONVEVIG_DATA", AV23CliConveVig_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCOND_CLICONVENIO", GXutil.rtrim( AV25Cond_CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV8CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV9CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVEVIG", localUtil.dtoc( AV10CliConveVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEVIG", getSecureSignedToken( "", AV10CliConveVig));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVEFONDOSEC", GXutil.ltrim( localUtil.ntoc( AV11CliConveFondoSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEFONDOSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliConveFondoSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVEFONDORELREF", A2155CliConveFondoRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVEFONDOOLD", A2156CliConveFondoOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV26Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Objectcall", GXutil.rtrim( Combo_cliconvenio_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Cls", GXutil.rtrim( Combo_cliconvenio_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Selectedvalue_set", GXutil.rtrim( Combo_cliconvenio_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Selectedtext_set", GXutil.rtrim( Combo_cliconvenio_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Enabled", GXutil.booltostr( Combo_cliconvenio_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Datalistproc", GXutil.rtrim( Combo_cliconvenio_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Datalistprocparametersprefix", GXutil.rtrim( Combo_cliconvenio_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Emptyitem", GXutil.booltostr( Combo_cliconvenio_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVEVIG_Objectcall", GXutil.rtrim( Combo_cliconvevig_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVEVIG_Cls", GXutil.rtrim( Combo_cliconvevig_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVEVIG_Selectedvalue_set", GXutil.rtrim( Combo_cliconvevig_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVEVIG_Selectedtext_set", GXutil.rtrim( Combo_cliconvevig_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVEVIG_Enabled", GXutil.booltostr( Combo_cliconvevig_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVEVIG_Datalistproc", GXutil.rtrim( Combo_cliconvevig_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVEVIG_Datalistprocparametersprefix", GXutil.rtrim( Combo_cliconvevig_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVEVIG_Emptyitem", GXutil.booltostr( Combo_cliconvevig_Emptyitem));
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
      return formatLink("web.clientecct_fondocese", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(AV10CliConveVig)),GXutil.URLEncode(GXutil.ltrimstr(AV11CliConveFondoSec,4,0))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CliConveVig","CliConveFondoSec"})  ;
   }

   public String getPgmname( )
   {
      return "Clientecct_fondocese" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Convenio Fondo de cese laboral", "") ;
   }

   public void initializeNonKey68271( )
   {
      A2148CliConveFondoMeses = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2148CliConveFondoMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2148CliConveFondoMeses), 4, 0));
      A2150CliConveFondoPrc = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A2150CliConveFondoPrc", GXutil.ltrimstr( A2150CliConveFondoPrc, 6, 4));
      A2151CliConveFondoRem = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2151CliConveFondoRem", A2151CliConveFondoRem);
      A2152CliConveFondoNre = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2152CliConveFondoNre", A2152CliConveFondoNre);
      A2153CliConveFondoDes = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2153CliConveFondoDes", A2153CliConveFondoDes);
      A2154CliConveFondoRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2154CliConveFondoRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2154CliConveFondoRelSec), 6, 0));
      A2155CliConveFondoRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2155CliConveFondoRelRef", A2155CliConveFondoRelRef);
      A2156CliConveFondoOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2156CliConveFondoOld", A2156CliConveFondoOld);
      O2153CliConveFondoDes = A2153CliConveFondoDes ;
      httpContext.ajax_rsp_assign_attri("", false, "A2153CliConveFondoDes", A2153CliConveFondoDes);
      O2152CliConveFondoNre = A2152CliConveFondoNre ;
      httpContext.ajax_rsp_assign_attri("", false, "A2152CliConveFondoNre", A2152CliConveFondoNre);
      O2151CliConveFondoRem = A2151CliConveFondoRem ;
      httpContext.ajax_rsp_assign_attri("", false, "A2151CliConveFondoRem", A2151CliConveFondoRem);
      O2150CliConveFondoPrc = A2150CliConveFondoPrc ;
      httpContext.ajax_rsp_assign_attri("", false, "A2150CliConveFondoPrc", GXutil.ltrimstr( A2150CliConveFondoPrc, 6, 4));
      Z2148CliConveFondoMeses = (short)(0) ;
      Z2150CliConveFondoPrc = DecimalUtil.ZERO ;
      Z2151CliConveFondoRem = false ;
      Z2152CliConveFondoNre = false ;
      Z2153CliConveFondoDes = false ;
      Z2154CliConveFondoRelSec = 0 ;
      Z2155CliConveFondoRelRef = "" ;
   }

   public void initAll68271( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      A1575CliConveVig = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
      A2147CliConveFondoSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2147CliConveFondoSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2147CliConveFondoSec), 4, 0));
      initializeNonKey68271( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713262227", true, true);
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
      httpContext.AddJavascriptSource("clientecct_fondocese.js", "?20251713262227", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblockcliconvenio_Internalname = "TEXTBLOCKCLICONVENIO" ;
      Combo_cliconvenio_Internalname = "COMBO_CLICONVENIO" ;
      edtCliConvenio_Internalname = "CLICONVENIO" ;
      divTablesplittedcliconvenio_Internalname = "TABLESPLITTEDCLICONVENIO" ;
      lblTextblockcliconvevig_Internalname = "TEXTBLOCKCLICONVEVIG" ;
      Combo_cliconvevig_Internalname = "COMBO_CLICONVEVIG" ;
      edtCliConveVig_Internalname = "CLICONVEVIG" ;
      divTablesplittedcliconvevig_Internalname = "TABLESPLITTEDCLICONVEVIG" ;
      edtCliConveFondoSec_Internalname = "CLICONVEFONDOSEC" ;
      edtCliConveFondoMeses_Internalname = "CLICONVEFONDOMESES" ;
      edtCliConveFondoPrc_Internalname = "CLICONVEFONDOPRC" ;
      chkCliConveFondoRem.setInternalname( "CLICONVEFONDOREM" );
      chkCliConveFondoNre.setInternalname( "CLICONVEFONDONRE" );
      chkCliConveFondoDes.setInternalname( "CLICONVEFONDODES" );
      dynCliConveFondoRelSec.setInternalname( "CLICONVEFONDORELSEC" );
      divCliconvefondorelsec_cell_Internalname = "CLICONVEFONDORELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombocliconvenio_Internalname = "vCOMBOCLICONVENIO" ;
      divSectionattribute_cliconvenio_Internalname = "SECTIONATTRIBUTE_CLICONVENIO" ;
      edtavCombocliconvevig_Internalname = "vCOMBOCLICONVEVIG" ;
      divSectionattribute_cliconvevig_Internalname = "SECTIONATTRIBUTE_CLICONVEVIG" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtCliPaiConve_Internalname = "CLIPAICONVE" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Convenio Fondo de cese laboral", "") );
      Combo_cliconvenio_Datalistprocparametersprefix = "" ;
      Combo_cliconvevig_Datalistprocparametersprefix = "" ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Enabled = 1 ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavCombocliconvevig_Jsonclick = "" ;
      edtavCombocliconvevig_Enabled = 0 ;
      edtavCombocliconvevig_Visible = 1 ;
      edtavCombocliconvenio_Jsonclick = "" ;
      edtavCombocliconvenio_Enabled = 0 ;
      edtavCombocliconvenio_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynCliConveFondoRelSec.setJsonclick( "" );
      dynCliConveFondoRelSec.setEnabled( 1 );
      divCliconvefondorelsec_cell_Class = "col-xs-12" ;
      chkCliConveFondoDes.setEnabled( 1 );
      chkCliConveFondoNre.setEnabled( 1 );
      chkCliConveFondoRem.setEnabled( 1 );
      edtCliConveFondoPrc_Jsonclick = "" ;
      edtCliConveFondoPrc_Enabled = 1 ;
      edtCliConveFondoMeses_Jsonclick = "" ;
      edtCliConveFondoMeses_Enabled = 1 ;
      edtCliConveFondoSec_Jsonclick = "" ;
      edtCliConveFondoSec_Enabled = 1 ;
      edtCliConveVig_Jsonclick = "" ;
      edtCliConveVig_Enabled = 1 ;
      edtCliConveVig_Visible = 1 ;
      Combo_cliconvevig_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_cliconvevig_Datalistproc = "Clientecct_fondoceseLoadDVCombo" ;
      Combo_cliconvevig_Cls = "ExtendedCombo AttributeDate" ;
      Combo_cliconvevig_Caption = "" ;
      Combo_cliconvevig_Enabled = GXutil.toBoolean( -1) ;
      edtCliConvenio_Jsonclick = "" ;
      edtCliConvenio_Enabled = 1 ;
      edtCliConvenio_Visible = 1 ;
      Combo_cliconvenio_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_cliconvenio_Datalistproc = "Clientecct_fondoceseLoadDVCombo" ;
      Combo_cliconvenio_Cls = "ExtendedCombo Attribute" ;
      Combo_cliconvenio_Caption = "" ;
      Combo_cliconvenio_Enabled = GXutil.toBoolean( -1) ;
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

   public void gxdlacliconvefondorelsec68271( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacliconvefondorelsec_data68271( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxacliconvefondorelsec_html68271( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlacliconvefondorelsec_data68271( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynCliConveFondoRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynCliConveFondoRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlacliconvefondorelsec_data68271( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T006815 */
      pr_default.execute(13, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(13) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T006815_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T006815_A1880CliReDTChar[0]);
         pr_default.readNext(13);
      }
      pr_default.close(13);
   }

   public void gx1asaclicod68271( int AV7CliCod )
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
            GXt_int10 = A3CliCod ;
            GXv_int11[0] = GXt_int10 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int11) ;
            clientecct_fondocese_impl.this.GXt_int10 = GXv_int11[0] ;
            A3CliCod = GXt_int10 ;
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

   public void init_web_controls( )
   {
      chkCliConveFondoRem.setName( "CLICONVEFONDOREM" );
      chkCliConveFondoRem.setWebtags( "" );
      chkCliConveFondoRem.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoRem.getInternalname(), "TitleCaption", chkCliConveFondoRem.getCaption(), true);
      chkCliConveFondoRem.setCheckedValue( "false" );
      A2151CliConveFondoRem = GXutil.strtobool( GXutil.booltostr( A2151CliConveFondoRem)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2151CliConveFondoRem", A2151CliConveFondoRem);
      chkCliConveFondoNre.setName( "CLICONVEFONDONRE" );
      chkCliConveFondoNre.setWebtags( "" );
      chkCliConveFondoNre.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoNre.getInternalname(), "TitleCaption", chkCliConveFondoNre.getCaption(), true);
      chkCliConveFondoNre.setCheckedValue( "false" );
      A2152CliConveFondoNre = GXutil.strtobool( GXutil.booltostr( A2152CliConveFondoNre)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2152CliConveFondoNre", A2152CliConveFondoNre);
      chkCliConveFondoDes.setName( "CLICONVEFONDODES" );
      chkCliConveFondoDes.setWebtags( "" );
      chkCliConveFondoDes.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCliConveFondoDes.getInternalname(), "TitleCaption", chkCliConveFondoDes.getCaption(), true);
      chkCliConveFondoDes.setCheckedValue( "false" );
      A2153CliConveFondoDes = GXutil.strtobool( GXutil.booltostr( A2153CliConveFondoDes)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2153CliConveFondoDes", A2153CliConveFondoDes);
      dynCliConveFondoRelSec.setName( "CLICONVEFONDORELSEC" );
      dynCliConveFondoRelSec.setWebtags( "" );
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

   public void valid_Clipaiconve( )
   {
      A2154CliConveFondoRelSec = (int)(GXutil.lval( dynCliConveFondoRelSec.getValue())) ;
      /* Using cursor T006816 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenio_Particularidades", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVEVIG");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Cliconvefondomeses( )
   {
      A2154CliConveFondoRelSec = (int)(GXutil.lval( dynCliConveFondoRelSec.getValue())) ;
      /* Using cursor T006817 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Short.valueOf(A2148CliConveFondoMeses), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Short.valueOf(A2147CliConveFondoSec)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Cli Cod", "")+","+httpContext.getMessage( "Cli Pai Conve", "")+","+httpContext.getMessage( "Convenio", "")+","+httpContext.getMessage( "Fecha de vigencia", "")+","+httpContext.getMessage( "Meses desde", "")}), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10CliConveVig',fld:'vCLICONVEVIG',pic:'',hsh:true},{av:'AV11CliConveFondoSec',fld:'vCLICONVEFONDOSEC',pic:'ZZZ9',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10CliConveVig',fld:'vCLICONVEVIG',pic:'',hsh:true},{av:'AV11CliConveFondoSec',fld:'vCLICONVEFONDOSEC',pic:'ZZZ9',hsh:true},{av:'A2155CliConveFondoRelRef',fld:'CLICONVEFONDORELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e12682',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("VALID_CLICONVEVIG","{handler:'valid_Cliconvevig',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("VALID_CLICONVEVIG",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("VALID_CLICONVEFONDOSEC","{handler:'valid_Cliconvefondosec',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("VALID_CLICONVEFONDOSEC",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("VALID_CLICONVEFONDOMESES","{handler:'valid_Cliconvefondomeses',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''},{av:'A2148CliConveFondoMeses',fld:'CLICONVEFONDOMESES',pic:'ZZZ9'},{av:'A2147CliConveFondoSec',fld:'CLICONVEFONDOSEC',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("VALID_CLICONVEFONDOMESES",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("VALID_CLICONVEFONDOPRC","{handler:'valid_Cliconvefondoprc',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("VALID_CLICONVEFONDOPRC",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("VALID_CLICONVEFONDOREM","{handler:'valid_Cliconvefondorem',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("VALID_CLICONVEFONDOREM",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("VALID_CLICONVEFONDONRE","{handler:'valid_Cliconvefondonre',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("VALID_CLICONVEFONDONRE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("VALID_CLICONVEFONDODES","{handler:'valid_Cliconvefondodes',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("VALID_CLICONVEFONDODES",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("VALID_CLICONVEFONDORELSEC","{handler:'valid_Cliconvefondorelsec',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("VALID_CLICONVEFONDORELSEC",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCLICONVENIO","{handler:'validv_Combocliconvenio',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("VALIDV_COMBOCLICONVENIO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCLICONVEVIG","{handler:'validv_Combocliconvevig',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("VALIDV_COMBOCLICONVEVIG",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveFondoRelSec'},{av:'A2154CliConveFondoRelSec',fld:'CLICONVEFONDORELSEC',pic:'ZZZZZ9'},{av:'A2151CliConveFondoRem',fld:'CLICONVEFONDOREM',pic:''},{av:'A2152CliConveFondoNre',fld:'CLICONVEFONDONRE',pic:''},{av:'A2153CliConveFondoDes',fld:'CLICONVEFONDODES',pic:''}]}");
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
      pr_default.close(14);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV9CliConvenio = "" ;
      wcpOAV10CliConveVig = GXutil.nullDate() ;
      Z1565CliConvenio = "" ;
      Z1575CliConveVig = GXutil.nullDate() ;
      Z2150CliConveFondoPrc = DecimalUtil.ZERO ;
      Z2155CliConveFondoRelRef = "" ;
      O2150CliConveFondoPrc = DecimalUtil.ZERO ;
      Combo_cliconvevig_Selectedvalue_get = "" ;
      Combo_cliconvenio_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      Gx_mode = "" ;
      AV9CliConvenio = "" ;
      AV10CliConveVig = GXutil.nullDate() ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockcliconvenio_Jsonclick = "" ;
      ucCombo_cliconvenio = new com.genexus.webpanels.GXUserControl();
      AV18DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV17CliConvenio_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      lblTextblockcliconvevig_Jsonclick = "" ;
      ucCombo_cliconvevig = new com.genexus.webpanels.GXUserControl();
      AV23CliConveVig_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A2150CliConveFondoPrc = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV22ComboCliConvenio = "" ;
      AV24ComboCliConveVig = GXutil.nullDate() ;
      A2155CliConveFondoRelRef = "" ;
      AV25Cond_CliConvenio = "" ;
      A2156CliConveFondoOld = "" ;
      AV26Pgmname = "" ;
      Combo_cliconvenio_Objectcall = "" ;
      Combo_cliconvenio_Class = "" ;
      Combo_cliconvenio_Icontype = "" ;
      Combo_cliconvenio_Icon = "" ;
      Combo_cliconvenio_Tooltip = "" ;
      Combo_cliconvenio_Selectedvalue_set = "" ;
      Combo_cliconvenio_Selectedtext_set = "" ;
      Combo_cliconvenio_Selectedtext_get = "" ;
      Combo_cliconvenio_Gamoauthtoken = "" ;
      Combo_cliconvenio_Ddointernalname = "" ;
      Combo_cliconvenio_Titlecontrolalign = "" ;
      Combo_cliconvenio_Dropdownoptionstype = "" ;
      Combo_cliconvenio_Titlecontrolidtoreplace = "" ;
      Combo_cliconvenio_Datalisttype = "" ;
      Combo_cliconvenio_Datalistfixedvalues = "" ;
      Combo_cliconvenio_Remoteservicesparameters = "" ;
      Combo_cliconvenio_Htmltemplate = "" ;
      Combo_cliconvenio_Multiplevaluestype = "" ;
      Combo_cliconvenio_Loadingdata = "" ;
      Combo_cliconvenio_Noresultsfound = "" ;
      Combo_cliconvenio_Emptyitemtext = "" ;
      Combo_cliconvenio_Onlyselectedvalues = "" ;
      Combo_cliconvenio_Selectalltext = "" ;
      Combo_cliconvenio_Multiplevaluesseparator = "" ;
      Combo_cliconvenio_Addnewoptiontext = "" ;
      Combo_cliconvevig_Objectcall = "" ;
      Combo_cliconvevig_Class = "" ;
      Combo_cliconvevig_Icontype = "" ;
      Combo_cliconvevig_Icon = "" ;
      Combo_cliconvevig_Tooltip = "" ;
      Combo_cliconvevig_Selectedvalue_set = "" ;
      Combo_cliconvevig_Selectedtext_set = "" ;
      Combo_cliconvevig_Selectedtext_get = "" ;
      Combo_cliconvevig_Gamoauthtoken = "" ;
      Combo_cliconvevig_Ddointernalname = "" ;
      Combo_cliconvevig_Titlecontrolalign = "" ;
      Combo_cliconvevig_Dropdownoptionstype = "" ;
      Combo_cliconvevig_Titlecontrolidtoreplace = "" ;
      Combo_cliconvevig_Datalisttype = "" ;
      Combo_cliconvevig_Datalistfixedvalues = "" ;
      Combo_cliconvevig_Remoteservicesparameters = "" ;
      Combo_cliconvevig_Htmltemplate = "" ;
      Combo_cliconvevig_Multiplevaluestype = "" ;
      Combo_cliconvevig_Loadingdata = "" ;
      Combo_cliconvevig_Noresultsfound = "" ;
      Combo_cliconvevig_Emptyitemtext = "" ;
      Combo_cliconvevig_Onlyselectedvalues = "" ;
      Combo_cliconvevig_Selectalltext = "" ;
      Combo_cliconvevig_Multiplevaluesseparator = "" ;
      Combo_cliconvevig_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode271 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV12WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV15TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV16WebSession = httpContext.getWebSession();
      AV21Combo_DataJson = "" ;
      AV19ComboSelectedValue = "" ;
      AV20ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z2156CliConveFondoOld = "" ;
      T00685_A2147CliConveFondoSec = new short[1] ;
      T00685_A2148CliConveFondoMeses = new short[1] ;
      T00685_A2150CliConveFondoPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00685_A2151CliConveFondoRem = new boolean[] {false} ;
      T00685_A2152CliConveFondoNre = new boolean[] {false} ;
      T00685_A2153CliConveFondoDes = new boolean[] {false} ;
      T00685_A2154CliConveFondoRelSec = new int[1] ;
      T00685_A2155CliConveFondoRelRef = new String[] {""} ;
      T00685_A2156CliConveFondoOld = new String[] {""} ;
      T00685_A3CliCod = new int[1] ;
      T00685_A1564CliPaiConve = new short[1] ;
      T00685_A1565CliConvenio = new String[] {""} ;
      T00685_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T00684_A3CliCod = new int[1] ;
      T00686_A3CliCod = new int[1] ;
      T00687_A3CliCod = new int[1] ;
      T00688_A3CliCod = new int[1] ;
      T00688_A1564CliPaiConve = new short[1] ;
      T00688_A1565CliConvenio = new String[] {""} ;
      T00688_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T00688_A2147CliConveFondoSec = new short[1] ;
      T00683_A2147CliConveFondoSec = new short[1] ;
      T00683_A2148CliConveFondoMeses = new short[1] ;
      T00683_A2150CliConveFondoPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00683_A2151CliConveFondoRem = new boolean[] {false} ;
      T00683_A2152CliConveFondoNre = new boolean[] {false} ;
      T00683_A2153CliConveFondoDes = new boolean[] {false} ;
      T00683_A2154CliConveFondoRelSec = new int[1] ;
      T00683_A2155CliConveFondoRelRef = new String[] {""} ;
      T00683_A2156CliConveFondoOld = new String[] {""} ;
      T00683_A3CliCod = new int[1] ;
      T00683_A1564CliPaiConve = new short[1] ;
      T00683_A1565CliConvenio = new String[] {""} ;
      T00683_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T00689_A3CliCod = new int[1] ;
      T00689_A1564CliPaiConve = new short[1] ;
      T00689_A1565CliConvenio = new String[] {""} ;
      T00689_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T00689_A2147CliConveFondoSec = new short[1] ;
      T006810_A3CliCod = new int[1] ;
      T006810_A1564CliPaiConve = new short[1] ;
      T006810_A1565CliConvenio = new String[] {""} ;
      T006810_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T006810_A2147CliConveFondoSec = new short[1] ;
      T00682_A2147CliConveFondoSec = new short[1] ;
      T00682_A2148CliConveFondoMeses = new short[1] ;
      T00682_A2150CliConveFondoPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00682_A2151CliConveFondoRem = new boolean[] {false} ;
      T00682_A2152CliConveFondoNre = new boolean[] {false} ;
      T00682_A2153CliConveFondoDes = new boolean[] {false} ;
      T00682_A2154CliConveFondoRelSec = new int[1] ;
      T00682_A2155CliConveFondoRelRef = new String[] {""} ;
      T00682_A2156CliConveFondoOld = new String[] {""} ;
      T00682_A3CliCod = new int[1] ;
      T00682_A1564CliPaiConve = new short[1] ;
      T00682_A1565CliConvenio = new String[] {""} ;
      T00682_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T006814_A3CliCod = new int[1] ;
      T006814_A1564CliPaiConve = new short[1] ;
      T006814_A1565CliConvenio = new String[] {""} ;
      T006814_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T006814_A2147CliConveFondoSec = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T006815_A3CliCod = new int[1] ;
      T006815_A1885CliRelSec = new int[1] ;
      T006815_A1880CliReDTChar = new String[] {""} ;
      GXv_int11 = new int[1] ;
      T006816_A3CliCod = new int[1] ;
      T006817_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clientecct_fondocese__default(),
         new Object[] {
             new Object[] {
            T00682_A2147CliConveFondoSec, T00682_A2148CliConveFondoMeses, T00682_A2150CliConveFondoPrc, T00682_A2151CliConveFondoRem, T00682_A2152CliConveFondoNre, T00682_A2153CliConveFondoDes, T00682_A2154CliConveFondoRelSec, T00682_A2155CliConveFondoRelRef, T00682_A2156CliConveFondoOld, T00682_A3CliCod,
            T00682_A1564CliPaiConve, T00682_A1565CliConvenio, T00682_A1575CliConveVig
            }
            , new Object[] {
            T00683_A2147CliConveFondoSec, T00683_A2148CliConveFondoMeses, T00683_A2150CliConveFondoPrc, T00683_A2151CliConveFondoRem, T00683_A2152CliConveFondoNre, T00683_A2153CliConveFondoDes, T00683_A2154CliConveFondoRelSec, T00683_A2155CliConveFondoRelRef, T00683_A2156CliConveFondoOld, T00683_A3CliCod,
            T00683_A1564CliPaiConve, T00683_A1565CliConvenio, T00683_A1575CliConveVig
            }
            , new Object[] {
            T00684_A3CliCod
            }
            , new Object[] {
            T00685_A2147CliConveFondoSec, T00685_A2148CliConveFondoMeses, T00685_A2150CliConveFondoPrc, T00685_A2151CliConveFondoRem, T00685_A2152CliConveFondoNre, T00685_A2153CliConveFondoDes, T00685_A2154CliConveFondoRelSec, T00685_A2155CliConveFondoRelRef, T00685_A2156CliConveFondoOld, T00685_A3CliCod,
            T00685_A1564CliPaiConve, T00685_A1565CliConvenio, T00685_A1575CliConveVig
            }
            , new Object[] {
            T00686_A3CliCod
            }
            , new Object[] {
            T00687_A3CliCod
            }
            , new Object[] {
            T00688_A3CliCod, T00688_A1564CliPaiConve, T00688_A1565CliConvenio, T00688_A1575CliConveVig, T00688_A2147CliConveFondoSec
            }
            , new Object[] {
            T00689_A3CliCod, T00689_A1564CliPaiConve, T00689_A1565CliConvenio, T00689_A1575CliConveVig, T00689_A2147CliConveFondoSec
            }
            , new Object[] {
            T006810_A3CliCod, T006810_A1564CliPaiConve, T006810_A1565CliConvenio, T006810_A1575CliConveVig, T006810_A2147CliConveFondoSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006814_A3CliCod, T006814_A1564CliPaiConve, T006814_A1565CliConvenio, T006814_A1575CliConveVig, T006814_A2147CliConveFondoSec
            }
            , new Object[] {
            T006815_A3CliCod, T006815_A1885CliRelSec, T006815_A1880CliReDTChar
            }
            , new Object[] {
            T006816_A3CliCod
            }
            , new Object[] {
            T006817_A3CliCod
            }
         }
      );
      AV26Pgmname = "Clientecct_fondocese" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8CliPaiConve ;
   private short wcpOAV11CliConveFondoSec ;
   private short Z1564CliPaiConve ;
   private short Z2147CliConveFondoSec ;
   private short Z2148CliConveFondoMeses ;
   private short A1564CliPaiConve ;
   private short AV8CliPaiConve ;
   private short AV11CliConveFondoSec ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A2147CliConveFondoSec ;
   private short A2148CliConveFondoMeses ;
   private short RcdFound271 ;
   private short nIsDirty_271 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z2154CliConveFondoRelSec ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int A2154CliConveFondoRelSec ;
   private int edtCliConvenio_Visible ;
   private int edtCliConvenio_Enabled ;
   private int edtCliConveVig_Visible ;
   private int edtCliConveVig_Enabled ;
   private int edtCliConveFondoSec_Enabled ;
   private int edtCliConveFondoMeses_Enabled ;
   private int edtCliConveFondoPrc_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombocliconvenio_Visible ;
   private int edtavCombocliconvenio_Enabled ;
   private int edtavCombocliconvevig_Visible ;
   private int edtavCombocliconvevig_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtCliPaiConve_Visible ;
   private int edtCliPaiConve_Enabled ;
   private int Combo_cliconvenio_Datalistupdateminimumcharacters ;
   private int Combo_cliconvenio_Gxcontroltype ;
   private int Combo_cliconvevig_Datalistupdateminimumcharacters ;
   private int Combo_cliconvevig_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int10 ;
   private int GXv_int11[] ;
   private java.math.BigDecimal Z2150CliConveFondoPrc ;
   private java.math.BigDecimal O2150CliConveFondoPrc ;
   private java.math.BigDecimal A2150CliConveFondoPrc ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9CliConvenio ;
   private String Z1565CliConvenio ;
   private String Combo_cliconvevig_Selectedvalue_get ;
   private String Combo_cliconvenio_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1565CliConvenio ;
   private String Gx_mode ;
   private String AV9CliConvenio ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliConvenio_Internalname ;
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
   private String divTablesplittedcliconvenio_Internalname ;
   private String lblTextblockcliconvenio_Internalname ;
   private String lblTextblockcliconvenio_Jsonclick ;
   private String Combo_cliconvenio_Caption ;
   private String Combo_cliconvenio_Cls ;
   private String Combo_cliconvenio_Datalistproc ;
   private String Combo_cliconvenio_Internalname ;
   private String TempTags ;
   private String edtCliConvenio_Jsonclick ;
   private String divTablesplittedcliconvevig_Internalname ;
   private String lblTextblockcliconvevig_Internalname ;
   private String lblTextblockcliconvevig_Jsonclick ;
   private String Combo_cliconvevig_Caption ;
   private String Combo_cliconvevig_Cls ;
   private String Combo_cliconvevig_Datalistproc ;
   private String Combo_cliconvevig_Internalname ;
   private String edtCliConveVig_Internalname ;
   private String edtCliConveVig_Jsonclick ;
   private String edtCliConveFondoSec_Internalname ;
   private String edtCliConveFondoSec_Jsonclick ;
   private String edtCliConveFondoMeses_Internalname ;
   private String edtCliConveFondoMeses_Jsonclick ;
   private String edtCliConveFondoPrc_Internalname ;
   private String edtCliConveFondoPrc_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divCliconvefondorelsec_cell_Internalname ;
   private String divCliconvefondorelsec_cell_Class ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_cliconvenio_Internalname ;
   private String edtavCombocliconvenio_Internalname ;
   private String AV22ComboCliConvenio ;
   private String edtavCombocliconvenio_Jsonclick ;
   private String divSectionattribute_cliconvevig_Internalname ;
   private String edtavCombocliconvevig_Internalname ;
   private String edtavCombocliconvevig_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String AV25Cond_CliConvenio ;
   private String AV26Pgmname ;
   private String Combo_cliconvenio_Objectcall ;
   private String Combo_cliconvenio_Class ;
   private String Combo_cliconvenio_Icontype ;
   private String Combo_cliconvenio_Icon ;
   private String Combo_cliconvenio_Tooltip ;
   private String Combo_cliconvenio_Selectedvalue_set ;
   private String Combo_cliconvenio_Selectedtext_set ;
   private String Combo_cliconvenio_Selectedtext_get ;
   private String Combo_cliconvenio_Gamoauthtoken ;
   private String Combo_cliconvenio_Ddointernalname ;
   private String Combo_cliconvenio_Titlecontrolalign ;
   private String Combo_cliconvenio_Dropdownoptionstype ;
   private String Combo_cliconvenio_Titlecontrolidtoreplace ;
   private String Combo_cliconvenio_Datalisttype ;
   private String Combo_cliconvenio_Datalistfixedvalues ;
   private String Combo_cliconvenio_Datalistprocparametersprefix ;
   private String Combo_cliconvenio_Remoteservicesparameters ;
   private String Combo_cliconvenio_Htmltemplate ;
   private String Combo_cliconvenio_Multiplevaluestype ;
   private String Combo_cliconvenio_Loadingdata ;
   private String Combo_cliconvenio_Noresultsfound ;
   private String Combo_cliconvenio_Emptyitemtext ;
   private String Combo_cliconvenio_Onlyselectedvalues ;
   private String Combo_cliconvenio_Selectalltext ;
   private String Combo_cliconvenio_Multiplevaluesseparator ;
   private String Combo_cliconvenio_Addnewoptiontext ;
   private String Combo_cliconvevig_Objectcall ;
   private String Combo_cliconvevig_Class ;
   private String Combo_cliconvevig_Icontype ;
   private String Combo_cliconvevig_Icon ;
   private String Combo_cliconvevig_Tooltip ;
   private String Combo_cliconvevig_Selectedvalue_set ;
   private String Combo_cliconvevig_Selectedtext_set ;
   private String Combo_cliconvevig_Selectedtext_get ;
   private String Combo_cliconvevig_Gamoauthtoken ;
   private String Combo_cliconvevig_Ddointernalname ;
   private String Combo_cliconvevig_Titlecontrolalign ;
   private String Combo_cliconvevig_Dropdownoptionstype ;
   private String Combo_cliconvevig_Titlecontrolidtoreplace ;
   private String Combo_cliconvevig_Datalisttype ;
   private String Combo_cliconvevig_Datalistfixedvalues ;
   private String Combo_cliconvevig_Datalistprocparametersprefix ;
   private String Combo_cliconvevig_Remoteservicesparameters ;
   private String Combo_cliconvevig_Htmltemplate ;
   private String Combo_cliconvevig_Multiplevaluestype ;
   private String Combo_cliconvevig_Loadingdata ;
   private String Combo_cliconvevig_Noresultsfound ;
   private String Combo_cliconvevig_Emptyitemtext ;
   private String Combo_cliconvevig_Onlyselectedvalues ;
   private String Combo_cliconvevig_Selectalltext ;
   private String Combo_cliconvevig_Multiplevaluesseparator ;
   private String Combo_cliconvevig_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode271 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private java.util.Date wcpOAV10CliConveVig ;
   private java.util.Date Z1575CliConveVig ;
   private java.util.Date A1575CliConveVig ;
   private java.util.Date AV10CliConveVig ;
   private java.util.Date AV24ComboCliConveVig ;
   private boolean Z2151CliConveFondoRem ;
   private boolean Z2152CliConveFondoNre ;
   private boolean Z2153CliConveFondoDes ;
   private boolean O2153CliConveFondoDes ;
   private boolean O2152CliConveFondoNre ;
   private boolean O2151CliConveFondoRem ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A2151CliConveFondoRem ;
   private boolean A2152CliConveFondoNre ;
   private boolean A2153CliConveFondoDes ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_cliconvenio_Emptyitem ;
   private boolean Combo_cliconvevig_Emptyitem ;
   private boolean Combo_cliconvenio_Enabled ;
   private boolean Combo_cliconvenio_Visible ;
   private boolean Combo_cliconvenio_Allowmultipleselection ;
   private boolean Combo_cliconvenio_Isgriditem ;
   private boolean Combo_cliconvenio_Hasdescription ;
   private boolean Combo_cliconvenio_Includeonlyselectedoption ;
   private boolean Combo_cliconvenio_Includeselectalloption ;
   private boolean Combo_cliconvenio_Includeaddnewoption ;
   private boolean Combo_cliconvevig_Enabled ;
   private boolean Combo_cliconvevig_Visible ;
   private boolean Combo_cliconvevig_Allowmultipleselection ;
   private boolean Combo_cliconvevig_Isgriditem ;
   private boolean Combo_cliconvevig_Hasdescription ;
   private boolean Combo_cliconvevig_Includeonlyselectedoption ;
   private boolean Combo_cliconvevig_Includeselectalloption ;
   private boolean Combo_cliconvevig_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private String A2156CliConveFondoOld ;
   private String AV21Combo_DataJson ;
   private String Z2156CliConveFondoOld ;
   private String Z2155CliConveFondoRelRef ;
   private String A2155CliConveFondoRelRef ;
   private String AV19ComboSelectedValue ;
   private String AV20ComboSelectedText ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV16WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_cliconvenio ;
   private com.genexus.webpanels.GXUserControl ucCombo_cliconvevig ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkCliConveFondoRem ;
   private ICheckbox chkCliConveFondoNre ;
   private ICheckbox chkCliConveFondoDes ;
   private HTMLChoice dynCliConveFondoRelSec ;
   private IDataStoreProvider pr_default ;
   private short[] T00685_A2147CliConveFondoSec ;
   private short[] T00685_A2148CliConveFondoMeses ;
   private java.math.BigDecimal[] T00685_A2150CliConveFondoPrc ;
   private boolean[] T00685_A2151CliConveFondoRem ;
   private boolean[] T00685_A2152CliConveFondoNre ;
   private boolean[] T00685_A2153CliConveFondoDes ;
   private int[] T00685_A2154CliConveFondoRelSec ;
   private String[] T00685_A2155CliConveFondoRelRef ;
   private String[] T00685_A2156CliConveFondoOld ;
   private int[] T00685_A3CliCod ;
   private short[] T00685_A1564CliPaiConve ;
   private String[] T00685_A1565CliConvenio ;
   private java.util.Date[] T00685_A1575CliConveVig ;
   private int[] T00684_A3CliCod ;
   private int[] T00686_A3CliCod ;
   private int[] T00687_A3CliCod ;
   private int[] T00688_A3CliCod ;
   private short[] T00688_A1564CliPaiConve ;
   private String[] T00688_A1565CliConvenio ;
   private java.util.Date[] T00688_A1575CliConveVig ;
   private short[] T00688_A2147CliConveFondoSec ;
   private short[] T00683_A2147CliConveFondoSec ;
   private short[] T00683_A2148CliConveFondoMeses ;
   private java.math.BigDecimal[] T00683_A2150CliConveFondoPrc ;
   private boolean[] T00683_A2151CliConveFondoRem ;
   private boolean[] T00683_A2152CliConveFondoNre ;
   private boolean[] T00683_A2153CliConveFondoDes ;
   private int[] T00683_A2154CliConveFondoRelSec ;
   private String[] T00683_A2155CliConveFondoRelRef ;
   private String[] T00683_A2156CliConveFondoOld ;
   private int[] T00683_A3CliCod ;
   private short[] T00683_A1564CliPaiConve ;
   private String[] T00683_A1565CliConvenio ;
   private java.util.Date[] T00683_A1575CliConveVig ;
   private int[] T00689_A3CliCod ;
   private short[] T00689_A1564CliPaiConve ;
   private String[] T00689_A1565CliConvenio ;
   private java.util.Date[] T00689_A1575CliConveVig ;
   private short[] T00689_A2147CliConveFondoSec ;
   private int[] T006810_A3CliCod ;
   private short[] T006810_A1564CliPaiConve ;
   private String[] T006810_A1565CliConvenio ;
   private java.util.Date[] T006810_A1575CliConveVig ;
   private short[] T006810_A2147CliConveFondoSec ;
   private short[] T00682_A2147CliConveFondoSec ;
   private short[] T00682_A2148CliConveFondoMeses ;
   private java.math.BigDecimal[] T00682_A2150CliConveFondoPrc ;
   private boolean[] T00682_A2151CliConveFondoRem ;
   private boolean[] T00682_A2152CliConveFondoNre ;
   private boolean[] T00682_A2153CliConveFondoDes ;
   private int[] T00682_A2154CliConveFondoRelSec ;
   private String[] T00682_A2155CliConveFondoRelRef ;
   private String[] T00682_A2156CliConveFondoOld ;
   private int[] T00682_A3CliCod ;
   private short[] T00682_A1564CliPaiConve ;
   private String[] T00682_A1565CliConvenio ;
   private java.util.Date[] T00682_A1575CliConveVig ;
   private int[] T006814_A3CliCod ;
   private short[] T006814_A1564CliPaiConve ;
   private String[] T006814_A1565CliConvenio ;
   private java.util.Date[] T006814_A1575CliConveVig ;
   private short[] T006814_A2147CliConveFondoSec ;
   private int[] T006815_A3CliCod ;
   private int[] T006815_A1885CliRelSec ;
   private String[] T006815_A1880CliReDTChar ;
   private int[] T006816_A3CliCod ;
   private int[] T006817_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV17CliConvenio_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV23CliConveVig_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV12WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV15TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV18DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class clientecct_fondocese__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00682", "SELECT CliConveFondoSec, CliConveFondoMeses, CliConveFondoPrc, CliConveFondoRem, CliConveFondoNre, CliConveFondoDes, CliConveFondoRelSec, CliConveFondoRelRef, CliConveFondoOld, CliCod, CliPaiConve, CliConvenio, CliConveVig FROM Clientecct_fondocese WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveFondoSec = ?  FOR UPDATE OF Clientecct_fondocese NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00683", "SELECT CliConveFondoSec, CliConveFondoMeses, CliConveFondoPrc, CliConveFondoRem, CliConveFondoNre, CliConveFondoDes, CliConveFondoRelSec, CliConveFondoRelRef, CliConveFondoOld, CliCod, CliPaiConve, CliConvenio, CliConveVig FROM Clientecct_fondocese WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveFondoSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00684", "SELECT CliCod FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00685", "SELECT TM1.CliConveFondoSec, TM1.CliConveFondoMeses, TM1.CliConveFondoPrc, TM1.CliConveFondoRem, TM1.CliConveFondoNre, TM1.CliConveFondoDes, TM1.CliConveFondoRelSec, TM1.CliConveFondoRelRef, TM1.CliConveFondoOld, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.CliConveVig FROM Clientecct_fondocese TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.CliConveVig = ? and TM1.CliConveFondoSec = ? ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.CliConveVig, TM1.CliConveFondoSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00686", "SELECT CliCod FROM Clientecct_fondocese WHERE (CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveFondoMeses = ?) AND (Not ( CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig = ? and CliConveFondoSec = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00687", "SELECT CliCod FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00688", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec FROM Clientecct_fondocese WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveFondoSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00689", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec FROM Clientecct_fondocese WHERE ( CliCod > ? or CliCod = ? and CliPaiConve > ? or CliPaiConve = ? and CliCod = ? and CliConvenio > ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CliConveVig > ? or CliConveVig = ? and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CliConveFondoSec > ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T006810", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec FROM Clientecct_fondocese WHERE ( CliCod < ? or CliCod = ? and CliPaiConve < ? or CliPaiConve = ? and CliCod = ? and CliConvenio < ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CliConveVig < ? or CliConveVig = ? and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CliConveFondoSec < ?) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, CliConveVig DESC, CliConveFondoSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T006811", "SAVEPOINT gxupdate;INSERT INTO Clientecct_fondocese(CliConveFondoSec, CliConveFondoMeses, CliConveFondoPrc, CliConveFondoRem, CliConveFondoNre, CliConveFondoDes, CliConveFondoRelSec, CliConveFondoRelRef, CliConveFondoOld, CliCod, CliPaiConve, CliConvenio, CliConveVig) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006812", "SAVEPOINT gxupdate;UPDATE Clientecct_fondocese SET CliConveFondoMeses=?, CliConveFondoPrc=?, CliConveFondoRem=?, CliConveFondoNre=?, CliConveFondoDes=?, CliConveFondoRelSec=?, CliConveFondoRelRef=?, CliConveFondoOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveFondoSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006813", "SAVEPOINT gxupdate;DELETE FROM Clientecct_fondocese  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveFondoSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006814", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec FROM Clientecct_fondocese ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveFondoSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006815", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006816", "SELECT CliCod FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006817", "SELECT CliCod FROM Clientecct_fondocese WHERE (CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveFondoMeses = ?) AND (Not ( CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig = ? and CliConveFondoSec = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 15 :
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 20);
               stmt.setDate(9, (java.util.Date)parms[8]);
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setDate(11, (java.util.Date)parms[10]);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setDate(11, (java.util.Date)parms[10]);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setString(12, (String)parms[11], 20);
               stmt.setDate(13, (java.util.Date)parms[12]);
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 4);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setString(11, (String)parms[10], 20);
               stmt.setDate(12, (java.util.Date)parms[11]);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 20);
               stmt.setDate(9, (java.util.Date)parms[8]);
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
      }
   }

}

