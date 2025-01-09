package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class convenio_adicional_importes_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action19") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A1899ConveAdiImpRelSec = (int)(GXutil.lval( httpContext.GetPar( "ConveAdiImpRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1899ConveAdiImpRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1899ConveAdiImpRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_19_4R208( Gx_mode, AV7CliCod, A1899ConveAdiImpRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONVEADIIMPRELSEC") == 0 )
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
         gxdlaconveadiimprelsec4R208( AV7CliCod) ;
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
         gx1asaclicod4R208( AV7CliCod) ;
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
         A996ConveAdicod = httpContext.GetPar( "ConveAdicod") ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_22( A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
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
            AV10ConveAdicod = httpContext.GetPar( "ConveAdicod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10ConveAdicod", AV10ConveAdicod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEADICOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10ConveAdicod, ""))));
            AV11ConveAdiVig = localUtil.parseDateParm( httpContext.GetPar( "ConveAdiVig")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11ConveAdiVig", localUtil.format(AV11ConveAdiVig, "99/99/99"));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEADIVIG", getSecureSignedToken( "", AV11ConveAdiVig));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Convenio_Adicional_Importes", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtConveAdicod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public convenio_adicional_importes_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public convenio_adicional_importes_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicional_importes_impl.class ));
   }

   public convenio_adicional_importes_impl( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynConveAdiImpRelSec = new HTMLChoice();
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
      if ( dynConveAdiImpRelSec.getItemCount() > 0 )
      {
         A1899ConveAdiImpRelSec = (int)(GXutil.lval( dynConveAdiImpRelSec.getValidValue(GXutil.trim( GXutil.str( A1899ConveAdiImpRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1899ConveAdiImpRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1899ConveAdiImpRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConveAdiImpRelSec.setValue( GXutil.trim( GXutil.str( A1899ConveAdiImpRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynConveAdiImpRelSec.getInternalname(), "Values", dynConveAdiImpRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedconveadicod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockconveadicod_Internalname, httpContext.getMessage( "Adicional", ""), "", "", lblTextblockconveadicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_Adicional_Importes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_conveadicod.setProperty("Caption", Combo_conveadicod_Caption);
      ucCombo_conveadicod.setProperty("Cls", Combo_conveadicod_Cls);
      ucCombo_conveadicod.setProperty("DataListProc", Combo_conveadicod_Datalistproc);
      ucCombo_conveadicod.setProperty("EmptyItem", Combo_conveadicod_Emptyitem);
      ucCombo_conveadicod.setProperty("DropDownOptionsTitleSettingsIcons", AV18DDO_TitleSettingsIcons);
      ucCombo_conveadicod.setProperty("DropDownOptionsData", AV17ConveAdicod_Data);
      ucCombo_conveadicod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_conveadicod_Internalname, "COMBO_CONVEADICODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveAdicod_Internalname, httpContext.getMessage( "Adicional", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveAdicod_Internalname, GXutil.rtrim( A996ConveAdicod), GXutil.rtrim( localUtil.format( A996ConveAdicod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveAdicod_Jsonclick, 0, "Attribute", "", "", "", "", edtConveAdicod_Visible, edtConveAdicod_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Convenio_Adicional_Importes.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveAdiVig_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveAdiVig_Internalname, httpContext.getMessage( "Fecha de vigencia", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtConveAdiVig_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveAdiVig_Internalname, localUtil.format(A999ConveAdiVig, "99/99/99"), localUtil.format( A999ConveAdiVig, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveAdiVig_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtConveAdiVig_Enabled, 1, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_Adicional_Importes.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtConveAdiVig_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtConveAdiVig_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Convenio_Adicional_Importes.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveAdiImporte_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveAdiImporte_Internalname, httpContext.getMessage( "Importe", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveAdiImporte_Internalname, GXutil.ltrim( localUtil.ntoc( A1000ConveAdiImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveAdiImporte_Enabled!=0) ? localUtil.format( A1000ConveAdiImporte, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1000ConveAdiImporte, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveAdiImporte_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveAdiImporte_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Convenio_Adicional_Importes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConveadiimprelsec_cell_Internalname, 1, 0, "px", 0, "px", divConveadiimprelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynConveAdiImpRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynConveAdiImpRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynConveAdiImpRelSec, dynConveAdiImpRelSec.getInternalname(), GXutil.trim( GXutil.str( A1899ConveAdiImpRelSec, 6, 0)), 1, dynConveAdiImpRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynConveAdiImpRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "", true, (byte)(0), "HLP_Convenio_Adicional_Importes.htm");
      dynConveAdiImpRelSec.setValue( GXutil.trim( GXutil.str( A1899ConveAdiImpRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynConveAdiImpRelSec.getInternalname(), "Values", dynConveAdiImpRelSec.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Convenio_Adicional_Importes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Convenio_Adicional_Importes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Convenio_Adicional_Importes.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_conveadicod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboconveadicod_Internalname, GXutil.rtrim( AV22ComboConveAdicod), GXutil.rtrim( localUtil.format( AV22ComboConveAdicod, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboconveadicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboconveadicod_Visible, edtavComboconveadicod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Convenio_Adicional_Importes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,61);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_Adicional_Importes.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,62);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, edtCliPaiConve_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Convenio_Adicional_Importes.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConvenio_Visible, edtCliConvenio_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Convenio_Adicional_Importes.htm");
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
      e114R2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV18DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCONVEADICOD_DATA"), AV17ConveAdicod_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "Z1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1565CliConvenio = httpContext.cgiGet( "Z1565CliConvenio") ;
            Z996ConveAdicod = httpContext.cgiGet( "Z996ConveAdicod") ;
            Z999ConveAdiVig = localUtil.ctod( httpContext.cgiGet( "Z999ConveAdiVig"), 0) ;
            Z1000ConveAdiImporte = localUtil.ctond( httpContext.cgiGet( "Z1000ConveAdiImporte")) ;
            Z1899ConveAdiImpRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1899ConveAdiImpRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2059ConveAdiImpRelRef = httpContext.cgiGet( "Z2059ConveAdiImpRelRef") ;
            A2059ConveAdiImpRelRef = httpContext.cgiGet( "Z2059ConveAdiImpRelRef") ;
            O1000ConveAdiImporte = localUtil.ctond( httpContext.cgiGet( "O1000ConveAdiImporte")) ;
            O999ConveAdiVig = localUtil.ctod( httpContext.cgiGet( "O999ConveAdiVig"), 0) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV10ConveAdicod = httpContext.cgiGet( "vCONVEADICOD") ;
            AV11ConveAdiVig = localUtil.ctod( httpContext.cgiGet( "vCONVEADIVIG"), 0) ;
            AV23aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2059ConveAdiImpRelRef = httpContext.cgiGet( "CONVEADIIMPRELREF") ;
            A2049ConveAdiImpOld = httpContext.cgiGet( "CONVEADIIMPOLD") ;
            AV24Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_conveadicod_Objectcall = httpContext.cgiGet( "COMBO_CONVEADICOD_Objectcall") ;
            Combo_conveadicod_Class = httpContext.cgiGet( "COMBO_CONVEADICOD_Class") ;
            Combo_conveadicod_Icontype = httpContext.cgiGet( "COMBO_CONVEADICOD_Icontype") ;
            Combo_conveadicod_Icon = httpContext.cgiGet( "COMBO_CONVEADICOD_Icon") ;
            Combo_conveadicod_Caption = httpContext.cgiGet( "COMBO_CONVEADICOD_Caption") ;
            Combo_conveadicod_Tooltip = httpContext.cgiGet( "COMBO_CONVEADICOD_Tooltip") ;
            Combo_conveadicod_Cls = httpContext.cgiGet( "COMBO_CONVEADICOD_Cls") ;
            Combo_conveadicod_Selectedvalue_set = httpContext.cgiGet( "COMBO_CONVEADICOD_Selectedvalue_set") ;
            Combo_conveadicod_Selectedvalue_get = httpContext.cgiGet( "COMBO_CONVEADICOD_Selectedvalue_get") ;
            Combo_conveadicod_Selectedtext_set = httpContext.cgiGet( "COMBO_CONVEADICOD_Selectedtext_set") ;
            Combo_conveadicod_Selectedtext_get = httpContext.cgiGet( "COMBO_CONVEADICOD_Selectedtext_get") ;
            Combo_conveadicod_Gamoauthtoken = httpContext.cgiGet( "COMBO_CONVEADICOD_Gamoauthtoken") ;
            Combo_conveadicod_Ddointernalname = httpContext.cgiGet( "COMBO_CONVEADICOD_Ddointernalname") ;
            Combo_conveadicod_Titlecontrolalign = httpContext.cgiGet( "COMBO_CONVEADICOD_Titlecontrolalign") ;
            Combo_conveadicod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CONVEADICOD_Dropdownoptionstype") ;
            Combo_conveadicod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADICOD_Enabled")) ;
            Combo_conveadicod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADICOD_Visible")) ;
            Combo_conveadicod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CONVEADICOD_Titlecontrolidtoreplace") ;
            Combo_conveadicod_Datalisttype = httpContext.cgiGet( "COMBO_CONVEADICOD_Datalisttype") ;
            Combo_conveadicod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADICOD_Allowmultipleselection")) ;
            Combo_conveadicod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CONVEADICOD_Datalistfixedvalues") ;
            Combo_conveadicod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADICOD_Isgriditem")) ;
            Combo_conveadicod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADICOD_Hasdescription")) ;
            Combo_conveadicod_Datalistproc = httpContext.cgiGet( "COMBO_CONVEADICOD_Datalistproc") ;
            Combo_conveadicod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CONVEADICOD_Datalistprocparametersprefix") ;
            Combo_conveadicod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CONVEADICOD_Remoteservicesparameters") ;
            Combo_conveadicod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONVEADICOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_conveadicod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADICOD_Includeonlyselectedoption")) ;
            Combo_conveadicod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADICOD_Includeselectalloption")) ;
            Combo_conveadicod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADICOD_Emptyitem")) ;
            Combo_conveadicod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADICOD_Includeaddnewoption")) ;
            Combo_conveadicod_Htmltemplate = httpContext.cgiGet( "COMBO_CONVEADICOD_Htmltemplate") ;
            Combo_conveadicod_Multiplevaluestype = httpContext.cgiGet( "COMBO_CONVEADICOD_Multiplevaluestype") ;
            Combo_conveadicod_Loadingdata = httpContext.cgiGet( "COMBO_CONVEADICOD_Loadingdata") ;
            Combo_conveadicod_Noresultsfound = httpContext.cgiGet( "COMBO_CONVEADICOD_Noresultsfound") ;
            Combo_conveadicod_Emptyitemtext = httpContext.cgiGet( "COMBO_CONVEADICOD_Emptyitemtext") ;
            Combo_conveadicod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CONVEADICOD_Onlyselectedvalues") ;
            Combo_conveadicod_Selectalltext = httpContext.cgiGet( "COMBO_CONVEADICOD_Selectalltext") ;
            Combo_conveadicod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CONVEADICOD_Multiplevaluesseparator") ;
            Combo_conveadicod_Addnewoptiontext = httpContext.cgiGet( "COMBO_CONVEADICOD_Addnewoptiontext") ;
            Combo_conveadicod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONVEADICOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A996ConveAdicod = httpContext.cgiGet( edtConveAdicod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
            if ( localUtil.vcdate( httpContext.cgiGet( edtConveAdiVig_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "CONVEADIVIG");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveAdiVig_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A999ConveAdiVig = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A999ConveAdiVig", localUtil.format(A999ConveAdiVig, "99/99/99"));
            }
            else
            {
               A999ConveAdiVig = localUtil.ctod( httpContext.cgiGet( edtConveAdiVig_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A999ConveAdiVig", localUtil.format(A999ConveAdiVig, "99/99/99"));
            }
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveAdiImporte_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveAdiImporte_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEADIIMPORTE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveAdiImporte_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1000ConveAdiImporte = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1000ConveAdiImporte", GXutil.ltrimstr( A1000ConveAdiImporte, 14, 2));
            }
            else
            {
               A1000ConveAdiImporte = localUtil.ctond( httpContext.cgiGet( edtConveAdiImporte_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1000ConveAdiImporte", GXutil.ltrimstr( A1000ConveAdiImporte, 14, 2));
            }
            dynConveAdiImpRelSec.setValue( httpContext.cgiGet( dynConveAdiImpRelSec.getInternalname()) );
            A1899ConveAdiImpRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynConveAdiImpRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1899ConveAdiImpRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1899ConveAdiImpRelSec), 6, 0));
            AV22ComboConveAdicod = httpContext.cgiGet( edtavComboconveadicod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22ComboConveAdicod", AV22ComboConveAdicod);
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
            A1565CliConvenio = httpContext.cgiGet( edtCliConvenio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Convenio_Adicional_Importes");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ConveAdiImpRelRef", GXutil.rtrim( localUtil.format( A2059ConveAdiImpRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A999ConveAdiVig), GXutil.resetTime(Z999ConveAdiVig)) ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("convenio_adicional_importes:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A996ConveAdicod = httpContext.GetPar( "ConveAdicod") ;
               httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
               A999ConveAdiVig = localUtil.parseDateParm( httpContext.GetPar( "ConveAdiVig")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A999ConveAdiVig", localUtil.format(A999ConveAdiVig, "99/99/99"));
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
                  sMode208 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode208 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound208 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_4R0( ) ;
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
                        e114R2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e124R2 ();
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
         e124R2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll4R208( ) ;
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
         disableAttributes4R208( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconveadicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconveadicod_Enabled), 5, 0), true);
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

   public void confirm_4R0( )
   {
      beforeValidate4R208( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4R208( ) ;
         }
         else
         {
            checkExtendedTable4R208( ) ;
            closeExtendedTableCursors4R208( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption4R0( )
   {
   }

   public void e114R2( )
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
      edtConveAdicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdicod_Visible), 5, 0), true);
      AV22ComboConveAdicod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboConveAdicod", AV22ComboConveAdicod);
      edtavComboconveadicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconveadicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconveadicod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCONVEADICOD' */
      S112 ();
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_Adicional_Importes_Insert", GXv_boolean5) ;
         convenio_adicional_importes_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_Adicional_Importes_Update", GXv_boolean5) ;
         convenio_adicional_importes_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_Adicional_Importes_Delete", GXv_boolean5) ;
         convenio_adicional_importes_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV24Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
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
      edtCliConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Visible), 5, 0), true);
   }

   public void e124R2( )
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

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      divConveadiimprelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divConveadiimprelsec_cell_Internalname, "Class", divConveadiimprelsec_cell_Class, true);
   }

   public void S112( )
   {
      /* 'LOADCOMBOCONVEADICOD' Routine */
      returnInSub = false ;
      Combo_conveadicod_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"ConveAdicod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliPaiConve\": 0, \"CliConvenio\": \"\", \"ConveAdicod\": \"\", \"ConveAdiVig\": \"\", \"Cond_CliCod\": \"#%1#\", \"Cond_CliPaiConve\": \"#%2#\", \"Cond_CliConvenio\": \"#%3#\"", edtCliCod_Internalname, edtCliPaiConve_Internalname, edtCliConvenio_Internalname, "", "", "", "", "", "") ;
      ucCombo_conveadicod.sendProperty(context, "", false, Combo_conveadicod_Internalname, "DataListProcParametersPrefix", Combo_conveadicod_Datalistprocparametersprefix);
      GXt_char6 = AV21Combo_DataJson ;
      GXv_char7[0] = AV19ComboSelectedValue ;
      GXv_char8[0] = AV20ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new web.convenio_adicional_importesloaddvcombo(remoteHandle, context).execute( "ConveAdicod", Gx_mode, false, AV7CliCod, AV8CliPaiConve, AV9CliConvenio, AV10ConveAdicod, AV11ConveAdiVig, A3CliCod, A1564CliPaiConve, A1565CliConvenio, "", GXv_char7, GXv_char8, GXv_char9) ;
      convenio_adicional_importes_impl.this.AV19ComboSelectedValue = GXv_char7[0] ;
      convenio_adicional_importes_impl.this.AV20ComboSelectedText = GXv_char8[0] ;
      convenio_adicional_importes_impl.this.GXt_char6 = GXv_char9[0] ;
      AV21Combo_DataJson = GXt_char6 ;
      Combo_conveadicod_Selectedvalue_set = AV19ComboSelectedValue ;
      ucCombo_conveadicod.sendProperty(context, "", false, Combo_conveadicod_Internalname, "SelectedValue_set", Combo_conveadicod_Selectedvalue_set);
      Combo_conveadicod_Selectedtext_set = AV20ComboSelectedText ;
      ucCombo_conveadicod.sendProperty(context, "", false, Combo_conveadicod_Internalname, "SelectedText_set", Combo_conveadicod_Selectedtext_set);
      AV22ComboConveAdicod = AV19ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboConveAdicod", AV22ComboConveAdicod);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV10ConveAdicod)==0) )
      {
         Combo_conveadicod_Enabled = false ;
         ucCombo_conveadicod.sendProperty(context, "", false, Combo_conveadicod_Internalname, "Enabled", GXutil.booltostr( Combo_conveadicod_Enabled));
      }
   }

   public void zm4R208( int GX_JID )
   {
      if ( ( GX_JID == 21 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1000ConveAdiImporte = T004R3_A1000ConveAdiImporte[0] ;
            Z1899ConveAdiImpRelSec = T004R3_A1899ConveAdiImpRelSec[0] ;
            Z2059ConveAdiImpRelRef = T004R3_A2059ConveAdiImpRelRef[0] ;
         }
         else
         {
            Z1000ConveAdiImporte = A1000ConveAdiImporte ;
            Z1899ConveAdiImpRelSec = A1899ConveAdiImpRelSec ;
            Z2059ConveAdiImpRelRef = A2059ConveAdiImpRelRef ;
         }
      }
      if ( GX_JID == -21 )
      {
         Z999ConveAdiVig = A999ConveAdiVig ;
         Z1000ConveAdiImporte = A1000ConveAdiImporte ;
         Z1899ConveAdiImpRelSec = A1899ConveAdiImpRelSec ;
         Z2059ConveAdiImpRelRef = A2059ConveAdiImpRelRef ;
         Z2049ConveAdiImpOld = A2049ConveAdiImpOld ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaconveadiimprelsec_html4R208( AV7CliCod) ;
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
            convenio_adicional_importes_impl.this.GXt_int10 = GXv_int11[0] ;
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
         A1565CliConvenio = AV9CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
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
      if ( ! (GXutil.strcmp("", AV10ConveAdicod)==0) )
      {
         edtConveAdicod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdicod_Enabled), 5, 0), true);
      }
      else
      {
         edtConveAdicod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdicod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV10ConveAdicod)==0) )
      {
         edtConveAdicod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdicod_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11ConveAdiVig)) )
      {
         A999ConveAdiVig = AV11ConveAdiVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A999ConveAdiVig", localUtil.format(A999ConveAdiVig, "99/99/99"));
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11ConveAdiVig)) )
      {
         edtConveAdiVig_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdiVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiVig_Enabled), 5, 0), true);
      }
      else
      {
         edtConveAdiVig_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdiVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiVig_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11ConveAdiVig)) )
      {
         edtConveAdiVig_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdiVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiVig_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV10ConveAdicod)==0) )
      {
         A996ConveAdicod = AV10ConveAdicod ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
      }
      else
      {
         A996ConveAdicod = AV22ComboConveAdicod ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
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
         AV24Pgmname = "Convenio_Adicional_Importes" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      }
   }

   public void load4R208( )
   {
      /* Using cursor T004R5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound208 = (short)(1) ;
         A1000ConveAdiImporte = T004R5_A1000ConveAdiImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1000ConveAdiImporte", GXutil.ltrimstr( A1000ConveAdiImporte, 14, 2));
         A1899ConveAdiImpRelSec = T004R5_A1899ConveAdiImpRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1899ConveAdiImpRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1899ConveAdiImpRelSec), 6, 0));
         A2059ConveAdiImpRelRef = T004R5_A2059ConveAdiImpRelRef[0] ;
         A2049ConveAdiImpOld = T004R5_A2049ConveAdiImpOld[0] ;
         zm4R208( -21) ;
      }
      pr_default.close(3);
      onLoadActions4R208( ) ;
   }

   public void onLoadActions4R208( )
   {
      AV24Pgmname = "Convenio_Adicional_Importes" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      if ( ! ( !( GXutil.dateCompare(GXutil.resetTime(A999ConveAdiVig), GXutil.resetTime(O999ConveAdiVig)) ) || ( DecimalUtil.compareTo(A1000ConveAdiImporte, O1000ConveAdiImporte) != 0 ) ) )
      {
         divConveadiimprelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConveadiimprelsec_cell_Internalname, "Class", divConveadiimprelsec_cell_Class, true);
      }
      else
      {
         if ( !( GXutil.dateCompare(GXutil.resetTime(A999ConveAdiVig), GXutil.resetTime(O999ConveAdiVig)) ) || ( DecimalUtil.compareTo(A1000ConveAdiImporte, O1000ConveAdiImporte) != 0 ) )
         {
            divConveadiimprelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConveadiimprelsec_cell_Internalname, "Class", divConveadiimprelsec_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable4R208( )
   {
      nIsDirty_208 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV24Pgmname = "Convenio_Adicional_Importes" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV23aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1899ConveAdiImpRelSec, GXv_boolean5) ;
         convenio_adicional_importes_impl.this.AV23aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
      }
      /* Using cursor T004R4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "convenio_adicional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVEADICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( !( GXutil.dateCompare(GXutil.resetTime(A999ConveAdiVig), GXutil.resetTime(O999ConveAdiVig)) ) || ( DecimalUtil.compareTo(A1000ConveAdiImporte, O1000ConveAdiImporte) != 0 ) ) )
      {
         divConveadiimprelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConveadiimprelsec_cell_Internalname, "Class", divConveadiimprelsec_cell_Class, true);
      }
      else
      {
         if ( !( GXutil.dateCompare(GXutil.resetTime(A999ConveAdiVig), GXutil.resetTime(O999ConveAdiVig)) ) || ( DecimalUtil.compareTo(A1000ConveAdiImporte, O1000ConveAdiImporte) != 0 ) )
         {
            divConveadiimprelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConveadiimprelsec_cell_Internalname, "Class", divConveadiimprelsec_cell_Class, true);
         }
      }
      if ( ( !( GXutil.dateCompare(GXutil.resetTime(A999ConveAdiVig), GXutil.resetTime(O999ConveAdiVig)) ) || ( DecimalUtil.compareTo(A1000ConveAdiImporte, O1000ConveAdiImporte) != 0 ) ) && (0==A1899ConveAdiImpRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CONVEADIVIG");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiVig_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors4R208( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_22( int A3CliCod ,
                          short A1564CliPaiConve ,
                          String A1565CliConvenio ,
                          String A996ConveAdicod )
   {
      /* Using cursor T004R6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "convenio_adicional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVEADICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey4R208( )
   {
      /* Using cursor T004R7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound208 = (short)(1) ;
      }
      else
      {
         RcdFound208 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T004R3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm4R208( 21) ;
         RcdFound208 = (short)(1) ;
         A999ConveAdiVig = T004R3_A999ConveAdiVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A999ConveAdiVig", localUtil.format(A999ConveAdiVig, "99/99/99"));
         A1000ConveAdiImporte = T004R3_A1000ConveAdiImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1000ConveAdiImporte", GXutil.ltrimstr( A1000ConveAdiImporte, 14, 2));
         A1899ConveAdiImpRelSec = T004R3_A1899ConveAdiImpRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1899ConveAdiImpRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1899ConveAdiImpRelSec), 6, 0));
         A2059ConveAdiImpRelRef = T004R3_A2059ConveAdiImpRelRef[0] ;
         A2049ConveAdiImpOld = T004R3_A2049ConveAdiImpOld[0] ;
         A3CliCod = T004R3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004R3_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004R3_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A996ConveAdicod = T004R3_A996ConveAdicod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
         O1000ConveAdiImporte = A1000ConveAdiImporte ;
         httpContext.ajax_rsp_assign_attri("", false, "A1000ConveAdiImporte", GXutil.ltrimstr( A1000ConveAdiImporte, 14, 2));
         O999ConveAdiVig = A999ConveAdiVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A999ConveAdiVig", localUtil.format(A999ConveAdiVig, "99/99/99"));
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z999ConveAdiVig = A999ConveAdiVig ;
         sMode208 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load4R208( ) ;
         if ( AnyError == 1 )
         {
            RcdFound208 = (short)(0) ;
            initializeNonKey4R208( ) ;
         }
         Gx_mode = sMode208 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound208 = (short)(0) ;
         initializeNonKey4R208( ) ;
         sMode208 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode208 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey4R208( ) ;
      if ( RcdFound208 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound208 = (short)(0) ;
      /* Using cursor T004R8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A996ConveAdicod, A996ConveAdicod, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A999ConveAdiVig});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T004R8_A3CliCod[0] < A3CliCod ) || ( T004R8_A3CliCod[0] == A3CliCod ) && ( T004R8_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T004R8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004R8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004R8_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T004R8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004R8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004R8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004R8_A996ConveAdicod[0], A996ConveAdicod) < 0 ) || ( GXutil.strcmp(T004R8_A996ConveAdicod[0], A996ConveAdicod) == 0 ) && ( GXutil.strcmp(T004R8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004R8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004R8_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004R8_A999ConveAdiVig[0]).before( GXutil.resetTime( A999ConveAdiVig )) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T004R8_A3CliCod[0] > A3CliCod ) || ( T004R8_A3CliCod[0] == A3CliCod ) && ( T004R8_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T004R8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004R8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004R8_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T004R8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004R8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004R8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004R8_A996ConveAdicod[0], A996ConveAdicod) > 0 ) || ( GXutil.strcmp(T004R8_A996ConveAdicod[0], A996ConveAdicod) == 0 ) && ( GXutil.strcmp(T004R8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004R8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004R8_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004R8_A999ConveAdiVig[0]).after( GXutil.resetTime( A999ConveAdiVig )) ) )
         {
            A3CliCod = T004R8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T004R8_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T004R8_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A996ConveAdicod = T004R8_A996ConveAdicod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
            A999ConveAdiVig = T004R8_A999ConveAdiVig[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A999ConveAdiVig", localUtil.format(A999ConveAdiVig, "99/99/99"));
            RcdFound208 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound208 = (short)(0) ;
      /* Using cursor T004R9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A996ConveAdicod, A996ConveAdicod, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A999ConveAdiVig});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T004R9_A3CliCod[0] > A3CliCod ) || ( T004R9_A3CliCod[0] == A3CliCod ) && ( T004R9_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T004R9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004R9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004R9_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T004R9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004R9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004R9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004R9_A996ConveAdicod[0], A996ConveAdicod) > 0 ) || ( GXutil.strcmp(T004R9_A996ConveAdicod[0], A996ConveAdicod) == 0 ) && ( GXutil.strcmp(T004R9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004R9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004R9_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004R9_A999ConveAdiVig[0]).after( GXutil.resetTime( A999ConveAdiVig )) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T004R9_A3CliCod[0] < A3CliCod ) || ( T004R9_A3CliCod[0] == A3CliCod ) && ( T004R9_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T004R9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004R9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004R9_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T004R9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004R9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004R9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004R9_A996ConveAdicod[0], A996ConveAdicod) < 0 ) || ( GXutil.strcmp(T004R9_A996ConveAdicod[0], A996ConveAdicod) == 0 ) && ( GXutil.strcmp(T004R9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004R9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004R9_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004R9_A999ConveAdiVig[0]).before( GXutil.resetTime( A999ConveAdiVig )) ) )
         {
            A3CliCod = T004R9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T004R9_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T004R9_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A996ConveAdicod = T004R9_A996ConveAdicod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
            A999ConveAdiVig = T004R9_A999ConveAdiVig[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A999ConveAdiVig", localUtil.format(A999ConveAdiVig, "99/99/99"));
            RcdFound208 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4R208( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtConveAdicod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert4R208( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound208 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A999ConveAdiVig), GXutil.resetTime(Z999ConveAdiVig)) ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A996ConveAdicod = Z996ConveAdicod ;
               httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
               A999ConveAdiVig = Z999ConveAdiVig ;
               httpContext.ajax_rsp_assign_attri("", false, "A999ConveAdiVig", localUtil.format(A999ConveAdiVig, "99/99/99"));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtConveAdicod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update4R208( ) ;
               GX_FocusControl = edtConveAdicod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A999ConveAdiVig), GXutil.resetTime(Z999ConveAdiVig)) ) )
            {
               /* Insert record */
               GX_FocusControl = edtConveAdicod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert4R208( ) ;
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
                  GX_FocusControl = edtConveAdicod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert4R208( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A999ConveAdiVig), GXutil.resetTime(Z999ConveAdiVig)) ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A996ConveAdicod = Z996ConveAdicod ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
         A999ConveAdiVig = Z999ConveAdiVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A999ConveAdiVig", localUtil.format(A999ConveAdiVig, "99/99/99"));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtConveAdicod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency4R208( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T004R2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalimportes"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z1000ConveAdiImporte, T004R2_A1000ConveAdiImporte[0]) != 0 ) || ( Z1899ConveAdiImpRelSec != T004R2_A1899ConveAdiImpRelSec[0] ) || ( GXutil.strcmp(Z2059ConveAdiImpRelRef, T004R2_A2059ConveAdiImpRelRef[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z1000ConveAdiImporte, T004R2_A1000ConveAdiImporte[0]) != 0 )
            {
               GXutil.writeLogln("convenio_adicional_importes:[seudo value changed for attri]"+"ConveAdiImporte");
               GXutil.writeLogRaw("Old: ",Z1000ConveAdiImporte);
               GXutil.writeLogRaw("Current: ",T004R2_A1000ConveAdiImporte[0]);
            }
            if ( Z1899ConveAdiImpRelSec != T004R2_A1899ConveAdiImpRelSec[0] )
            {
               GXutil.writeLogln("convenio_adicional_importes:[seudo value changed for attri]"+"ConveAdiImpRelSec");
               GXutil.writeLogRaw("Old: ",Z1899ConveAdiImpRelSec);
               GXutil.writeLogRaw("Current: ",T004R2_A1899ConveAdiImpRelSec[0]);
            }
            if ( GXutil.strcmp(Z2059ConveAdiImpRelRef, T004R2_A2059ConveAdiImpRelRef[0]) != 0 )
            {
               GXutil.writeLogln("convenio_adicional_importes:[seudo value changed for attri]"+"ConveAdiImpRelRef");
               GXutil.writeLogRaw("Old: ",Z2059ConveAdiImpRelRef);
               GXutil.writeLogRaw("Current: ",T004R2_A2059ConveAdiImpRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"convenio_adicionalimportes"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4R208( )
   {
      beforeValidate4R208( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4R208( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4R208( 0) ;
         checkOptimisticConcurrency4R208( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4R208( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4R208( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004R10 */
                  pr_default.execute(8, new Object[] {A999ConveAdiVig, A1000ConveAdiImporte, Integer.valueOf(A1899ConveAdiImpRelSec), A2059ConveAdiImpRelRef, A2049ConveAdiImpOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalimportes");
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
                        resetCaption4R0( ) ;
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
            load4R208( ) ;
         }
         endLevel4R208( ) ;
      }
      closeExtendedTableCursors4R208( ) ;
   }

   public void update4R208( )
   {
      beforeValidate4R208( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4R208( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4R208( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4R208( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4R208( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004R11 */
                  pr_default.execute(9, new Object[] {A1000ConveAdiImporte, Integer.valueOf(A1899ConveAdiImpRelSec), A2059ConveAdiImpRelRef, A2049ConveAdiImpOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalimportes");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalimportes"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4R208( ) ;
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
         endLevel4R208( ) ;
      }
      closeExtendedTableCursors4R208( ) ;
   }

   public void deferredUpdate4R208( )
   {
   }

   public void delete( )
   {
      beforeValidate4R208( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4R208( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4R208( ) ;
         afterConfirm4R208( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4R208( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T004R12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalimportes");
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
      sMode208 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel4R208( ) ;
      Gx_mode = sMode208 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls4R208( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV23aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1899ConveAdiImpRelSec, GXv_boolean5) ;
            convenio_adicional_importes_impl.this.AV23aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
         }
         AV24Pgmname = "Convenio_Adicional_Importes" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
         if ( ! ( !( GXutil.dateCompare(GXutil.resetTime(A999ConveAdiVig), GXutil.resetTime(O999ConveAdiVig)) ) || ( DecimalUtil.compareTo(A1000ConveAdiImporte, O1000ConveAdiImporte) != 0 ) ) )
         {
            divConveadiimprelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConveadiimprelsec_cell_Internalname, "Class", divConveadiimprelsec_cell_Class, true);
         }
         else
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(A999ConveAdiVig), GXutil.resetTime(O999ConveAdiVig)) ) || ( DecimalUtil.compareTo(A1000ConveAdiImporte, O1000ConveAdiImporte) != 0 ) )
            {
               divConveadiimprelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divConveadiimprelsec_cell_Internalname, "Class", divConveadiimprelsec_cell_Class, true);
            }
         }
      }
   }

   public void endLevel4R208( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4R208( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "convenio_adicional_importes");
         if ( AnyError == 0 )
         {
            confirmValues4R0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "convenio_adicional_importes");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart4R208( )
   {
      /* Scan By routine */
      /* Using cursor T004R13 */
      pr_default.execute(11);
      RcdFound208 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound208 = (short)(1) ;
         A3CliCod = T004R13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004R13_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004R13_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A996ConveAdicod = T004R13_A996ConveAdicod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
         A999ConveAdiVig = T004R13_A999ConveAdiVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A999ConveAdiVig", localUtil.format(A999ConveAdiVig, "99/99/99"));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext4R208( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound208 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound208 = (short)(1) ;
         A3CliCod = T004R13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004R13_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004R13_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A996ConveAdicod = T004R13_A996ConveAdicod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
         A999ConveAdiVig = T004R13_A999ConveAdiVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A999ConveAdiVig", localUtil.format(A999ConveAdiVig, "99/99/99"));
      }
   }

   public void scanEnd4R208( )
   {
      pr_default.close(11);
   }

   public void afterConfirm4R208( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV23aplicadoHay ) && ! (0==A1899ConveAdiImpRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "ConveAdiImpRelSec", 1, "CONVEADIIMPRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveAdiImpRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert4R208( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4R208( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4R208( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4R208( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4R208( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4R208( )
   {
      edtConveAdicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdicod_Enabled), 5, 0), true);
      edtConveAdiVig_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiVig_Enabled), 5, 0), true);
      edtConveAdiImporte_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiImporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiImporte_Enabled), 5, 0), true);
      dynConveAdiImpRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynConveAdiImpRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveAdiImpRelSec.getEnabled(), 5, 0), true);
      edtavComboconveadicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconveadicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconveadicod_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliPaiConve_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      edtCliConvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes4R208( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues4R0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.convenio_adicional_importes", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV10ConveAdicod)),GXutil.URLEncode(GXutil.formatDateParm(AV11ConveAdiVig))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","ConveAdicod","ConveAdiVig"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Convenio_Adicional_Importes");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ConveAdiImpRelRef", GXutil.rtrim( localUtil.format( A2059ConveAdiImpRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("convenio_adicional_importes:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1564CliPaiConve", GXutil.ltrim( localUtil.ntoc( Z1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1565CliConvenio", GXutil.rtrim( Z1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z996ConveAdicod", GXutil.rtrim( Z996ConveAdicod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z999ConveAdiVig", localUtil.dtoc( Z999ConveAdiVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1000ConveAdiImporte", GXutil.ltrim( localUtil.ntoc( Z1000ConveAdiImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1899ConveAdiImpRelSec", GXutil.ltrim( localUtil.ntoc( Z1899ConveAdiImpRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2059ConveAdiImpRelRef", Z2059ConveAdiImpRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "O1000ConveAdiImporte", GXutil.ltrim( localUtil.ntoc( O1000ConveAdiImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O999ConveAdiVig", localUtil.dtoc( O999ConveAdiVig, 0, "/"));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCONVEADICOD_DATA", AV17ConveAdicod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCONVEADICOD_DATA", AV17ConveAdicod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV8CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV9CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVEADICOD", GXutil.rtrim( AV10ConveAdicod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEADICOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10ConveAdicod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVEADIVIG", localUtil.dtoc( AV11ConveAdiVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEADIVIG", getSecureSignedToken( "", AV11ConveAdiVig));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV23aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADIIMPRELREF", A2059ConveAdiImpRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADIIMPOLD", A2049ConveAdiImpOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV24Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADICOD_Objectcall", GXutil.rtrim( Combo_conveadicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADICOD_Cls", GXutil.rtrim( Combo_conveadicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADICOD_Selectedvalue_set", GXutil.rtrim( Combo_conveadicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADICOD_Selectedtext_set", GXutil.rtrim( Combo_conveadicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADICOD_Enabled", GXutil.booltostr( Combo_conveadicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADICOD_Datalistproc", GXutil.rtrim( Combo_conveadicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_conveadicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADICOD_Emptyitem", GXutil.booltostr( Combo_conveadicod_Emptyitem));
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
      return formatLink("web.convenio_adicional_importes", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV10ConveAdicod)),GXutil.URLEncode(GXutil.formatDateParm(AV11ConveAdiVig))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","ConveAdicod","ConveAdiVig"})  ;
   }

   public String getPgmname( )
   {
      return "Convenio_Adicional_Importes" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Convenio_Adicional_Importes", "") ;
   }

   public void initializeNonKey4R208( )
   {
      AV23aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
      A1000ConveAdiImporte = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1000ConveAdiImporte", GXutil.ltrimstr( A1000ConveAdiImporte, 14, 2));
      A1899ConveAdiImpRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1899ConveAdiImpRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1899ConveAdiImpRelSec), 6, 0));
      A2059ConveAdiImpRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2059ConveAdiImpRelRef", A2059ConveAdiImpRelRef);
      A2049ConveAdiImpOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2049ConveAdiImpOld", A2049ConveAdiImpOld);
      O1000ConveAdiImporte = A1000ConveAdiImporte ;
      httpContext.ajax_rsp_assign_attri("", false, "A1000ConveAdiImporte", GXutil.ltrimstr( A1000ConveAdiImporte, 14, 2));
      Z1000ConveAdiImporte = DecimalUtil.ZERO ;
      Z1899ConveAdiImpRelSec = 0 ;
      Z2059ConveAdiImpRelRef = "" ;
   }

   public void initAll4R208( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      A996ConveAdicod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
      A999ConveAdiVig = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A999ConveAdiVig", localUtil.format(A999ConveAdiVig, "99/99/99"));
      initializeNonKey4R208( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171333434", true, true);
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
      httpContext.AddJavascriptSource("convenio_adicional_importes.js", "?2025171333434", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblockconveadicod_Internalname = "TEXTBLOCKCONVEADICOD" ;
      Combo_conveadicod_Internalname = "COMBO_CONVEADICOD" ;
      edtConveAdicod_Internalname = "CONVEADICOD" ;
      divTablesplittedconveadicod_Internalname = "TABLESPLITTEDCONVEADICOD" ;
      edtConveAdiVig_Internalname = "CONVEADIVIG" ;
      edtConveAdiImporte_Internalname = "CONVEADIIMPORTE" ;
      dynConveAdiImpRelSec.setInternalname( "CONVEADIIMPRELSEC" );
      divConveadiimprelsec_cell_Internalname = "CONVEADIIMPRELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboconveadicod_Internalname = "vCOMBOCONVEADICOD" ;
      divSectionattribute_conveadicod_Internalname = "SECTIONATTRIBUTE_CONVEADICOD" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtCliPaiConve_Internalname = "CLIPAICONVE" ;
      edtCliConvenio_Internalname = "CLICONVENIO" ;
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
      Form.setCaption( httpContext.getMessage( "Convenio_Adicional_Importes", "") );
      Combo_conveadicod_Datalistprocparametersprefix = "" ;
      edtCliConvenio_Jsonclick = "" ;
      edtCliConvenio_Enabled = 1 ;
      edtCliConvenio_Visible = 1 ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Enabled = 1 ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavComboconveadicod_Jsonclick = "" ;
      edtavComboconveadicod_Enabled = 0 ;
      edtavComboconveadicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynConveAdiImpRelSec.setJsonclick( "" );
      dynConveAdiImpRelSec.setEnabled( 1 );
      divConveadiimprelsec_cell_Class = "col-xs-12" ;
      edtConveAdiImporte_Jsonclick = "" ;
      edtConveAdiImporte_Enabled = 1 ;
      edtConveAdiVig_Jsonclick = "" ;
      edtConveAdiVig_Enabled = 1 ;
      edtConveAdicod_Jsonclick = "" ;
      edtConveAdicod_Enabled = 1 ;
      edtConveAdicod_Visible = 1 ;
      Combo_conveadicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_conveadicod_Datalistproc = "Convenio_Adicional_ImportesLoadDVCombo" ;
      Combo_conveadicod_Cls = "ExtendedCombo Attribute" ;
      Combo_conveadicod_Caption = "" ;
      Combo_conveadicod_Enabled = GXutil.toBoolean( -1) ;
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

   public void gxdlaconveadiimprelsec4R208( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconveadiimprelsec_data4R208( AV7CliCod) ;
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

   public void gxaconveadiimprelsec_html4R208( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlaconveadiimprelsec_data4R208( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConveAdiImpRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynConveAdiImpRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaconveadiimprelsec_data4R208( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T004R14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(12) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T004R14_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T004R14_A1880CliReDTChar[0]);
         pr_default.readNext(12);
      }
      pr_default.close(12);
   }

   public void gx1asaclicod4R208( int AV7CliCod )
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
            convenio_adicional_importes_impl.this.GXt_int10 = GXv_int11[0] ;
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

   public void xc_19_4R208( String Gx_mode ,
                            int AV7CliCod ,
                            int A1899ConveAdiImpRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV23aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1899ConveAdiImpRelSec, GXv_boolean5) ;
         AV23aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV23aplicadoHay))+"\"") ;
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
      dynConveAdiImpRelSec.setName( "CONVEADIIMPRELSEC" );
      dynConveAdiImpRelSec.setWebtags( "" );
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

   public void valid_Cliconvenio( )
   {
      A1899ConveAdiImpRelSec = (int)(GXutil.lval( dynConveAdiImpRelSec.getValue())) ;
      /* Using cursor T004R15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "convenio_adicional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVEADICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Conveadiimprelsec( )
   {
      A1899ConveAdiImpRelSec = (int)(GXutil.lval( dynConveAdiImpRelSec.getValue())) ;
      if ( ( !( GXutil.dateCompare(GXutil.resetTime(A999ConveAdiVig), GXutil.resetTime(O999ConveAdiVig)) ) || ( DecimalUtil.compareTo(A1000ConveAdiImporte, O1000ConveAdiImporte) != 0 ) ) && (0==A1899ConveAdiImpRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CONVEADIIMPRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveAdiImpRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV23aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1899ConveAdiImpRelSec, GXv_boolean5) ;
         convenio_adicional_importes_impl.this.AV23aplicadoHay = GXv_boolean5[0] ;
         AV23aplicadoHay = this.AV23aplicadoHay ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10ConveAdicod',fld:'vCONVEADICOD',pic:'',hsh:true},{av:'AV11ConveAdiVig',fld:'vCONVEADIVIG',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10ConveAdicod',fld:'vCONVEADICOD',pic:'',hsh:true},{av:'AV11ConveAdiVig',fld:'vCONVEADIVIG',pic:'',hsh:true},{av:'A2059ConveAdiImpRelRef',fld:'CONVEADIIMPRELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("AFTER TRN","{handler:'e124R2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CONVEADICOD","{handler:'valid_Conveadicod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CONVEADICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CONVEADIVIG","{handler:'valid_Conveadivig',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CONVEADIVIG",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CONVEADIIMPORTE","{handler:'valid_Conveadiimporte',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CONVEADIIMPORTE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CONVEADIIMPRELSEC","{handler:'valid_Conveadiimprelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1000ConveAdiImporte'},{av:'O999ConveAdiVig'},{av:'A999ConveAdiVig',fld:'CONVEADIVIG',pic:''},{av:'A1000ConveAdiImporte',fld:'CONVEADIIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV23aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CONVEADIIMPRELSEC",",oparms:[{av:'AV23aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALIDV_COMBOCONVEADICOD","{handler:'validv_Comboconveadicod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALIDV_COMBOCONVEADICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiImpRelSec'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'}]}");
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
      pr_default.close(13);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV9CliConvenio = "" ;
      wcpOAV10ConveAdicod = "" ;
      wcpOAV11ConveAdiVig = GXutil.nullDate() ;
      Z1565CliConvenio = "" ;
      Z996ConveAdicod = "" ;
      Z999ConveAdiVig = GXutil.nullDate() ;
      Z1000ConveAdiImporte = DecimalUtil.ZERO ;
      Z2059ConveAdiImpRelRef = "" ;
      O1000ConveAdiImporte = DecimalUtil.ZERO ;
      O999ConveAdiVig = GXutil.nullDate() ;
      Combo_conveadicod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      AV9CliConvenio = "" ;
      AV10ConveAdicod = "" ;
      AV11ConveAdiVig = GXutil.nullDate() ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockconveadicod_Jsonclick = "" ;
      ucCombo_conveadicod = new com.genexus.webpanels.GXUserControl();
      AV18DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV17ConveAdicod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A999ConveAdiVig = GXutil.nullDate() ;
      A1000ConveAdiImporte = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV22ComboConveAdicod = "" ;
      A2059ConveAdiImpRelRef = "" ;
      A2049ConveAdiImpOld = "" ;
      AV24Pgmname = "" ;
      Combo_conveadicod_Objectcall = "" ;
      Combo_conveadicod_Class = "" ;
      Combo_conveadicod_Icontype = "" ;
      Combo_conveadicod_Icon = "" ;
      Combo_conveadicod_Tooltip = "" ;
      Combo_conveadicod_Selectedvalue_set = "" ;
      Combo_conveadicod_Selectedtext_set = "" ;
      Combo_conveadicod_Selectedtext_get = "" ;
      Combo_conveadicod_Gamoauthtoken = "" ;
      Combo_conveadicod_Ddointernalname = "" ;
      Combo_conveadicod_Titlecontrolalign = "" ;
      Combo_conveadicod_Dropdownoptionstype = "" ;
      Combo_conveadicod_Titlecontrolidtoreplace = "" ;
      Combo_conveadicod_Datalisttype = "" ;
      Combo_conveadicod_Datalistfixedvalues = "" ;
      Combo_conveadicod_Remoteservicesparameters = "" ;
      Combo_conveadicod_Htmltemplate = "" ;
      Combo_conveadicod_Multiplevaluestype = "" ;
      Combo_conveadicod_Loadingdata = "" ;
      Combo_conveadicod_Noresultsfound = "" ;
      Combo_conveadicod_Emptyitemtext = "" ;
      Combo_conveadicod_Onlyselectedvalues = "" ;
      Combo_conveadicod_Selectalltext = "" ;
      Combo_conveadicod_Multiplevaluesseparator = "" ;
      Combo_conveadicod_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode208 = "" ;
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
      AV15TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV16WebSession = httpContext.getWebSession();
      AV21Combo_DataJson = "" ;
      GXt_char6 = "" ;
      AV19ComboSelectedValue = "" ;
      GXv_char7 = new String[1] ;
      AV20ComboSelectedText = "" ;
      GXv_char8 = new String[1] ;
      GXv_char9 = new String[1] ;
      Z2049ConveAdiImpOld = "" ;
      T004R5_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004R5_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004R5_A1899ConveAdiImpRelSec = new int[1] ;
      T004R5_A2059ConveAdiImpRelRef = new String[] {""} ;
      T004R5_A2049ConveAdiImpOld = new String[] {""} ;
      T004R5_A3CliCod = new int[1] ;
      T004R5_A1564CliPaiConve = new short[1] ;
      T004R5_A1565CliConvenio = new String[] {""} ;
      T004R5_A996ConveAdicod = new String[] {""} ;
      T004R4_A3CliCod = new int[1] ;
      T004R6_A3CliCod = new int[1] ;
      T004R7_A3CliCod = new int[1] ;
      T004R7_A1564CliPaiConve = new short[1] ;
      T004R7_A1565CliConvenio = new String[] {""} ;
      T004R7_A996ConveAdicod = new String[] {""} ;
      T004R7_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004R3_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004R3_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004R3_A1899ConveAdiImpRelSec = new int[1] ;
      T004R3_A2059ConveAdiImpRelRef = new String[] {""} ;
      T004R3_A2049ConveAdiImpOld = new String[] {""} ;
      T004R3_A3CliCod = new int[1] ;
      T004R3_A1564CliPaiConve = new short[1] ;
      T004R3_A1565CliConvenio = new String[] {""} ;
      T004R3_A996ConveAdicod = new String[] {""} ;
      T004R8_A3CliCod = new int[1] ;
      T004R8_A1564CliPaiConve = new short[1] ;
      T004R8_A1565CliConvenio = new String[] {""} ;
      T004R8_A996ConveAdicod = new String[] {""} ;
      T004R8_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004R9_A3CliCod = new int[1] ;
      T004R9_A1564CliPaiConve = new short[1] ;
      T004R9_A1565CliConvenio = new String[] {""} ;
      T004R9_A996ConveAdicod = new String[] {""} ;
      T004R9_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004R2_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004R2_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004R2_A1899ConveAdiImpRelSec = new int[1] ;
      T004R2_A2059ConveAdiImpRelRef = new String[] {""} ;
      T004R2_A2049ConveAdiImpOld = new String[] {""} ;
      T004R2_A3CliCod = new int[1] ;
      T004R2_A1564CliPaiConve = new short[1] ;
      T004R2_A1565CliConvenio = new String[] {""} ;
      T004R2_A996ConveAdicod = new String[] {""} ;
      T004R13_A3CliCod = new int[1] ;
      T004R13_A1564CliPaiConve = new short[1] ;
      T004R13_A1565CliConvenio = new String[] {""} ;
      T004R13_A996ConveAdicod = new String[] {""} ;
      T004R13_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T004R14_A3CliCod = new int[1] ;
      T004R14_A1885CliRelSec = new int[1] ;
      T004R14_A1880CliReDTChar = new String[] {""} ;
      GXv_int11 = new int[1] ;
      T004R15_A3CliCod = new int[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicional_importes__default(),
         new Object[] {
             new Object[] {
            T004R2_A999ConveAdiVig, T004R2_A1000ConveAdiImporte, T004R2_A1899ConveAdiImpRelSec, T004R2_A2059ConveAdiImpRelRef, T004R2_A2049ConveAdiImpOld, T004R2_A3CliCod, T004R2_A1564CliPaiConve, T004R2_A1565CliConvenio, T004R2_A996ConveAdicod
            }
            , new Object[] {
            T004R3_A999ConveAdiVig, T004R3_A1000ConveAdiImporte, T004R3_A1899ConveAdiImpRelSec, T004R3_A2059ConveAdiImpRelRef, T004R3_A2049ConveAdiImpOld, T004R3_A3CliCod, T004R3_A1564CliPaiConve, T004R3_A1565CliConvenio, T004R3_A996ConveAdicod
            }
            , new Object[] {
            T004R4_A3CliCod
            }
            , new Object[] {
            T004R5_A999ConveAdiVig, T004R5_A1000ConveAdiImporte, T004R5_A1899ConveAdiImpRelSec, T004R5_A2059ConveAdiImpRelRef, T004R5_A2049ConveAdiImpOld, T004R5_A3CliCod, T004R5_A1564CliPaiConve, T004R5_A1565CliConvenio, T004R5_A996ConveAdicod
            }
            , new Object[] {
            T004R6_A3CliCod
            }
            , new Object[] {
            T004R7_A3CliCod, T004R7_A1564CliPaiConve, T004R7_A1565CliConvenio, T004R7_A996ConveAdicod, T004R7_A999ConveAdiVig
            }
            , new Object[] {
            T004R8_A3CliCod, T004R8_A1564CliPaiConve, T004R8_A1565CliConvenio, T004R8_A996ConveAdicod, T004R8_A999ConveAdiVig
            }
            , new Object[] {
            T004R9_A3CliCod, T004R9_A1564CliPaiConve, T004R9_A1565CliConvenio, T004R9_A996ConveAdicod, T004R9_A999ConveAdiVig
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004R13_A3CliCod, T004R13_A1564CliPaiConve, T004R13_A1565CliConvenio, T004R13_A996ConveAdicod, T004R13_A999ConveAdiVig
            }
            , new Object[] {
            T004R14_A3CliCod, T004R14_A1885CliRelSec, T004R14_A1880CliReDTChar
            }
            , new Object[] {
            T004R15_A3CliCod
            }
         }
      );
      AV24Pgmname = "Convenio_Adicional_Importes" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8CliPaiConve ;
   private short Z1564CliPaiConve ;
   private short A1564CliPaiConve ;
   private short AV8CliPaiConve ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound208 ;
   private short nIsDirty_208 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z1899ConveAdiImpRelSec ;
   private int AV7CliCod ;
   private int A1899ConveAdiImpRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtConveAdicod_Visible ;
   private int edtConveAdicod_Enabled ;
   private int edtConveAdiVig_Enabled ;
   private int edtConveAdiImporte_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboconveadicod_Visible ;
   private int edtavComboconveadicod_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtCliPaiConve_Visible ;
   private int edtCliPaiConve_Enabled ;
   private int edtCliConvenio_Visible ;
   private int edtCliConvenio_Enabled ;
   private int Combo_conveadicod_Datalistupdateminimumcharacters ;
   private int Combo_conveadicod_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int10 ;
   private int GXv_int11[] ;
   private java.math.BigDecimal Z1000ConveAdiImporte ;
   private java.math.BigDecimal O1000ConveAdiImporte ;
   private java.math.BigDecimal A1000ConveAdiImporte ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9CliConvenio ;
   private String wcpOAV10ConveAdicod ;
   private String Z1565CliConvenio ;
   private String Z996ConveAdicod ;
   private String Combo_conveadicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String AV9CliConvenio ;
   private String AV10ConveAdicod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtConveAdicod_Internalname ;
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
   private String divTablesplittedconveadicod_Internalname ;
   private String lblTextblockconveadicod_Internalname ;
   private String lblTextblockconveadicod_Jsonclick ;
   private String Combo_conveadicod_Caption ;
   private String Combo_conveadicod_Cls ;
   private String Combo_conveadicod_Datalistproc ;
   private String Combo_conveadicod_Internalname ;
   private String TempTags ;
   private String edtConveAdicod_Jsonclick ;
   private String edtConveAdiVig_Internalname ;
   private String edtConveAdiVig_Jsonclick ;
   private String edtConveAdiImporte_Internalname ;
   private String edtConveAdiImporte_Jsonclick ;
   private String divConveadiimprelsec_cell_Internalname ;
   private String divConveadiimprelsec_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_conveadicod_Internalname ;
   private String edtavComboconveadicod_Internalname ;
   private String AV22ComboConveAdicod ;
   private String edtavComboconveadicod_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String edtCliConvenio_Internalname ;
   private String edtCliConvenio_Jsonclick ;
   private String AV24Pgmname ;
   private String Combo_conveadicod_Objectcall ;
   private String Combo_conveadicod_Class ;
   private String Combo_conveadicod_Icontype ;
   private String Combo_conveadicod_Icon ;
   private String Combo_conveadicod_Tooltip ;
   private String Combo_conveadicod_Selectedvalue_set ;
   private String Combo_conveadicod_Selectedtext_set ;
   private String Combo_conveadicod_Selectedtext_get ;
   private String Combo_conveadicod_Gamoauthtoken ;
   private String Combo_conveadicod_Ddointernalname ;
   private String Combo_conveadicod_Titlecontrolalign ;
   private String Combo_conveadicod_Dropdownoptionstype ;
   private String Combo_conveadicod_Titlecontrolidtoreplace ;
   private String Combo_conveadicod_Datalisttype ;
   private String Combo_conveadicod_Datalistfixedvalues ;
   private String Combo_conveadicod_Datalistprocparametersprefix ;
   private String Combo_conveadicod_Remoteservicesparameters ;
   private String Combo_conveadicod_Htmltemplate ;
   private String Combo_conveadicod_Multiplevaluestype ;
   private String Combo_conveadicod_Loadingdata ;
   private String Combo_conveadicod_Noresultsfound ;
   private String Combo_conveadicod_Emptyitemtext ;
   private String Combo_conveadicod_Onlyselectedvalues ;
   private String Combo_conveadicod_Selectalltext ;
   private String Combo_conveadicod_Multiplevaluesseparator ;
   private String Combo_conveadicod_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode208 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String GXv_char8[] ;
   private String GXv_char9[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private java.util.Date wcpOAV11ConveAdiVig ;
   private java.util.Date Z999ConveAdiVig ;
   private java.util.Date O999ConveAdiVig ;
   private java.util.Date AV11ConveAdiVig ;
   private java.util.Date A999ConveAdiVig ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_conveadicod_Emptyitem ;
   private boolean AV23aplicadoHay ;
   private boolean Combo_conveadicod_Enabled ;
   private boolean Combo_conveadicod_Visible ;
   private boolean Combo_conveadicod_Allowmultipleselection ;
   private boolean Combo_conveadicod_Isgriditem ;
   private boolean Combo_conveadicod_Hasdescription ;
   private boolean Combo_conveadicod_Includeonlyselectedoption ;
   private boolean Combo_conveadicod_Includeselectalloption ;
   private boolean Combo_conveadicod_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXv_boolean5[] ;
   private boolean ZV23aplicadoHay ;
   private String A2049ConveAdiImpOld ;
   private String AV21Combo_DataJson ;
   private String Z2049ConveAdiImpOld ;
   private String Z2059ConveAdiImpRelRef ;
   private String A2059ConveAdiImpRelRef ;
   private String AV19ComboSelectedValue ;
   private String AV20ComboSelectedText ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV16WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_conveadicod ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynConveAdiImpRelSec ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] T004R5_A999ConveAdiVig ;
   private java.math.BigDecimal[] T004R5_A1000ConveAdiImporte ;
   private int[] T004R5_A1899ConveAdiImpRelSec ;
   private String[] T004R5_A2059ConveAdiImpRelRef ;
   private String[] T004R5_A2049ConveAdiImpOld ;
   private int[] T004R5_A3CliCod ;
   private short[] T004R5_A1564CliPaiConve ;
   private String[] T004R5_A1565CliConvenio ;
   private String[] T004R5_A996ConveAdicod ;
   private int[] T004R4_A3CliCod ;
   private int[] T004R6_A3CliCod ;
   private int[] T004R7_A3CliCod ;
   private short[] T004R7_A1564CliPaiConve ;
   private String[] T004R7_A1565CliConvenio ;
   private String[] T004R7_A996ConveAdicod ;
   private java.util.Date[] T004R7_A999ConveAdiVig ;
   private java.util.Date[] T004R3_A999ConveAdiVig ;
   private java.math.BigDecimal[] T004R3_A1000ConveAdiImporte ;
   private int[] T004R3_A1899ConveAdiImpRelSec ;
   private String[] T004R3_A2059ConveAdiImpRelRef ;
   private String[] T004R3_A2049ConveAdiImpOld ;
   private int[] T004R3_A3CliCod ;
   private short[] T004R3_A1564CliPaiConve ;
   private String[] T004R3_A1565CliConvenio ;
   private String[] T004R3_A996ConveAdicod ;
   private int[] T004R8_A3CliCod ;
   private short[] T004R8_A1564CliPaiConve ;
   private String[] T004R8_A1565CliConvenio ;
   private String[] T004R8_A996ConveAdicod ;
   private java.util.Date[] T004R8_A999ConveAdiVig ;
   private int[] T004R9_A3CliCod ;
   private short[] T004R9_A1564CliPaiConve ;
   private String[] T004R9_A1565CliConvenio ;
   private String[] T004R9_A996ConveAdicod ;
   private java.util.Date[] T004R9_A999ConveAdiVig ;
   private java.util.Date[] T004R2_A999ConveAdiVig ;
   private java.math.BigDecimal[] T004R2_A1000ConveAdiImporte ;
   private int[] T004R2_A1899ConveAdiImpRelSec ;
   private String[] T004R2_A2059ConveAdiImpRelRef ;
   private String[] T004R2_A2049ConveAdiImpOld ;
   private int[] T004R2_A3CliCod ;
   private short[] T004R2_A1564CliPaiConve ;
   private String[] T004R2_A1565CliConvenio ;
   private String[] T004R2_A996ConveAdicod ;
   private int[] T004R13_A3CliCod ;
   private short[] T004R13_A1564CliPaiConve ;
   private String[] T004R13_A1565CliConvenio ;
   private String[] T004R13_A996ConveAdicod ;
   private java.util.Date[] T004R13_A999ConveAdiVig ;
   private int[] T004R14_A3CliCod ;
   private int[] T004R14_A1885CliRelSec ;
   private String[] T004R14_A1880CliReDTChar ;
   private int[] T004R15_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV17ConveAdicod_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV12WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV15TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV18DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class convenio_adicional_importes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T004R2", "SELECT ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, ConveAdiImpRelRef, ConveAdiImpOld, CliCod, CliPaiConve, CliConvenio, ConveAdicod FROM convenio_adicionalimportes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ?  FOR UPDATE OF convenio_adicionalimportes NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004R3", "SELECT ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, ConveAdiImpRelRef, ConveAdiImpOld, CliCod, CliPaiConve, CliConvenio, ConveAdicod FROM convenio_adicionalimportes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004R4", "SELECT CliCod FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004R5", "SELECT TM1.ConveAdiVig, TM1.ConveAdiImporte, TM1.ConveAdiImpRelSec, TM1.ConveAdiImpRelRef, TM1.ConveAdiImpOld, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.ConveAdicod FROM convenio_adicionalimportes TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.ConveAdicod = ( ?) and TM1.ConveAdiVig = ? ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.ConveAdicod, TM1.ConveAdiVig ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004R6", "SELECT CliCod FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004R7", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig FROM convenio_adicionalimportes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004R8", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig FROM convenio_adicionalimportes WHERE ( CliCod > ? or CliCod = ? and CliPaiConve > ? or CliPaiConve = ? and CliCod = ? and CliConvenio > ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveAdicod > ( ?) or ConveAdicod = ( ?) and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveAdiVig > ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004R9", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig FROM convenio_adicionalimportes WHERE ( CliCod < ? or CliCod = ? and CliPaiConve < ? or CliPaiConve = ? and CliCod = ? and CliConvenio < ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveAdicod < ( ?) or ConveAdicod = ( ?) and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveAdiVig < ?) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, ConveAdicod DESC, ConveAdiVig DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T004R10", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalimportes(ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, ConveAdiImpRelRef, ConveAdiImpOld, CliCod, CliPaiConve, CliConvenio, ConveAdicod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004R11", "SAVEPOINT gxupdate;UPDATE convenio_adicionalimportes SET ConveAdiImporte=?, ConveAdiImpRelSec=?, ConveAdiImpRelRef=?, ConveAdiImpOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004R12", "SAVEPOINT gxupdate;DELETE FROM convenio_adicionalimportes  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004R13", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig FROM convenio_adicionalimportes ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004R14", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004R15", "SELECT CliCod FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 13 :
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
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 20);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setDate(15, (java.util.Date)parms[14]);
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
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 20);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setDate(15, (java.util.Date)parms[14]);
               return;
            case 8 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setNLongVarchar(5, (String)parms[4], false);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 20);
               stmt.setString(9, (String)parms[8], 20);
               return;
            case 9 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 20);
               stmt.setDate(9, (java.util.Date)parms[8]);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

