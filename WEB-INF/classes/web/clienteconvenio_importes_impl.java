package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clienteconvenio_importes_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action20") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A1896CliConveImpRelSec = (int)(GXutil.lval( httpContext.GetPar( "CliConveImpRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1896CliConveImpRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1896CliConveImpRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_20_4N218( Gx_mode, AV7CliCod, A1896CliConveImpRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CLICONVEIMPRELSEC") == 0 )
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
         gxdlacliconveimprelsec4N218( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel2"+"_"+"CLICOD") == 0 )
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
         gx2asaclicod4N218( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_23") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_23( A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
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
            AV10CliConveImpVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveImpVig")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CliConveImpVig", localUtil.format(AV10CliConveImpVig, "99/99/99"));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEIMPVIG", getSecureSignedToken( "", AV10CliConveImpVig));
            AV11CliConveImpTipo = httpContext.GetPar( "CliConveImpTipo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11CliConveImpTipo", AV11CliConveImpTipo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEIMPTIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11CliConveImpTipo, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "cliente Convenio_importes", ""), (short)(0)) ;
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

   public clienteconvenio_importes_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public clienteconvenio_importes_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clienteconvenio_importes_impl.class ));
   }

   public clienteconvenio_importes_impl( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbCliConveImpTipo = new HTMLChoice();
      dynCliConveImpRelSec = new HTMLChoice();
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
      if ( cmbCliConveImpTipo.getItemCount() > 0 )
      {
         A1588CliConveImpTipo = cmbCliConveImpTipo.getValidValue(A1588CliConveImpTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1588CliConveImpTipo", A1588CliConveImpTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCliConveImpTipo.setValue( GXutil.rtrim( A1588CliConveImpTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCliConveImpTipo.getInternalname(), "Values", cmbCliConveImpTipo.ToJavascriptSource(), true);
      }
      if ( dynCliConveImpRelSec.getItemCount() > 0 )
      {
         A1896CliConveImpRelSec = (int)(GXutil.lval( dynCliConveImpRelSec.getValidValue(GXutil.trim( GXutil.str( A1896CliConveImpRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1896CliConveImpRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1896CliConveImpRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConveImpRelSec.setValue( GXutil.trim( GXutil.str( A1896CliConveImpRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynCliConveImpRelSec.getInternalname(), "Values", dynCliConveImpRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcliconvenio_Internalname, httpContext.getMessage( "Convenio", ""), "", "", lblTextblockcliconvenio_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_clienteConvenio_importes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_cliconvenio.setProperty("Caption", Combo_cliconvenio_Caption);
      ucCombo_cliconvenio.setProperty("Cls", Combo_cliconvenio_Cls);
      ucCombo_cliconvenio.setProperty("DataListProc", Combo_cliconvenio_Datalistproc);
      ucCombo_cliconvenio.setProperty("EmptyItem", Combo_cliconvenio_Emptyitem);
      ucCombo_cliconvenio.setProperty("DropDownOptionsTitleSettingsIcons", AV20DDO_TitleSettingsIcons);
      ucCombo_cliconvenio.setProperty("DropDownOptionsData", AV19CliConvenio_Data);
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConvenio_Visible, edtCliConvenio_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_clienteConvenio_importes.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConveImpVig_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliConveImpVig_Internalname, httpContext.getMessage( "Vigencia", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtCliConveImpVig_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveImpVig_Internalname, localUtil.format(A1587CliConveImpVig, "99/99/99"), localUtil.format( A1587CliConveImpVig, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveImpVig_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtCliConveImpVig_Enabled, 1, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_clienteConvenio_importes.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtCliConveImpVig_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtCliConveImpVig_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_clienteConvenio_importes.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbCliConveImpTipo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbCliConveImpTipo.getInternalname(), httpContext.getMessage( "Tipo importe", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCliConveImpTipo, cmbCliConveImpTipo.getInternalname(), GXutil.rtrim( A1588CliConveImpTipo), 1, cmbCliConveImpTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbCliConveImpTipo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "", true, (byte)(0), "HLP_clienteConvenio_importes.htm");
      cmbCliConveImpTipo.setValue( GXutil.rtrim( A1588CliConveImpTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCliConveImpTipo.getInternalname(), "Values", cmbCliConveImpTipo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConveImporte_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliConveImporte_Internalname, httpContext.getMessage( "Importe", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveImporte_Internalname, GXutil.ltrim( localUtil.ntoc( A1589CliConveImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliConveImporte_Enabled!=0) ? localUtil.format( A1589CliConveImporte, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1589CliConveImporte, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveImporte_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliConveImporte_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_clienteConvenio_importes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divCliconveimprelsec_cell_Internalname, 1, 0, "px", 0, "px", divCliconveimprelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynCliConveImpRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynCliConveImpRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynCliConveImpRelSec, dynCliConveImpRelSec.getInternalname(), GXutil.trim( GXutil.str( A1896CliConveImpRelSec, 6, 0)), 1, dynCliConveImpRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynCliConveImpRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "", true, (byte)(0), "HLP_clienteConvenio_importes.htm");
      dynCliConveImpRelSec.setValue( GXutil.trim( GXutil.str( A1896CliConveImpRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynCliConveImpRelSec.getInternalname(), "Values", dynCliConveImpRelSec.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_clienteConvenio_importes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_clienteConvenio_importes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_clienteConvenio_importes.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombocliconvenio_Internalname, GXutil.rtrim( AV24ComboCliConvenio), GXutil.rtrim( localUtil.format( AV24ComboCliConvenio, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombocliconvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombocliconvenio_Visible, edtavCombocliconvenio_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_clienteConvenio_importes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,66);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_clienteConvenio_importes.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, edtCliPaiConve_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_clienteConvenio_importes.htm");
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
      e114N2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV20DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLICONVENIO_DATA"), AV19CliConvenio_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "Z1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1565CliConvenio = httpContext.cgiGet( "Z1565CliConvenio") ;
            Z1587CliConveImpVig = localUtil.ctod( httpContext.cgiGet( "Z1587CliConveImpVig"), 0) ;
            Z1588CliConveImpTipo = httpContext.cgiGet( "Z1588CliConveImpTipo") ;
            Z1589CliConveImporte = localUtil.ctond( httpContext.cgiGet( "Z1589CliConveImporte")) ;
            Z1896CliConveImpRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1896CliConveImpRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2044CliConveImpRelRef = httpContext.cgiGet( "Z2044CliConveImpRelRef") ;
            A2044CliConveImpRelRef = httpContext.cgiGet( "Z2044CliConveImpRelRef") ;
            O1589CliConveImporte = localUtil.ctond( httpContext.cgiGet( "O1589CliConveImporte")) ;
            O1588CliConveImpTipo = httpContext.cgiGet( "O1588CliConveImpTipo") ;
            O1587CliConveImpVig = localUtil.ctod( httpContext.cgiGet( "O1587CliConveImpVig"), 0) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV10CliConveImpVig = localUtil.ctod( httpContext.cgiGet( "vCLICONVEIMPVIG"), 0) ;
            AV11CliConveImpTipo = httpContext.cgiGet( "vCLICONVEIMPTIPO") ;
            AV17aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2044CliConveImpRelRef = httpContext.cgiGet( "CLICONVEIMPRELREF") ;
            A2045CliConveImpOld = httpContext.cgiGet( "CLICONVEIMPOLD") ;
            AV25Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            if ( localUtil.vcdate( httpContext.cgiGet( edtCliConveImpVig_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "CLICONVEIMPVIG");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliConveImpVig_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1587CliConveImpVig = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A1587CliConveImpVig", localUtil.format(A1587CliConveImpVig, "99/99/99"));
            }
            else
            {
               A1587CliConveImpVig = localUtil.ctod( httpContext.cgiGet( edtCliConveImpVig_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1587CliConveImpVig", localUtil.format(A1587CliConveImpVig, "99/99/99"));
            }
            cmbCliConveImpTipo.setValue( httpContext.cgiGet( cmbCliConveImpTipo.getInternalname()) );
            A1588CliConveImpTipo = httpContext.cgiGet( cmbCliConveImpTipo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1588CliConveImpTipo", A1588CliConveImpTipo);
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtCliConveImporte_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtCliConveImporte_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICONVEIMPORTE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliConveImporte_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1589CliConveImporte = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1589CliConveImporte", GXutil.ltrimstr( A1589CliConveImporte, 14, 2));
            }
            else
            {
               A1589CliConveImporte = localUtil.ctond( httpContext.cgiGet( edtCliConveImporte_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1589CliConveImporte", GXutil.ltrimstr( A1589CliConveImporte, 14, 2));
            }
            dynCliConveImpRelSec.setValue( httpContext.cgiGet( dynCliConveImpRelSec.getInternalname()) );
            A1896CliConveImpRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynCliConveImpRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1896CliConveImpRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1896CliConveImpRelSec), 6, 0));
            AV24ComboCliConvenio = httpContext.cgiGet( edtavCombocliconvenio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24ComboCliConvenio", AV24ComboCliConvenio);
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
            forbiddenHiddens.add("hshsalt", "hsh"+"clienteConvenio_importes");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("CliConveImpRelRef", GXutil.rtrim( localUtil.format( A2044CliConveImpRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1587CliConveImpVig), GXutil.resetTime(Z1587CliConveImpVig)) ) || ( GXutil.strcmp(A1588CliConveImpTipo, Z1588CliConveImpTipo) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("clienteconvenio_importes:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1587CliConveImpVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveImpVig")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1587CliConveImpVig", localUtil.format(A1587CliConveImpVig, "99/99/99"));
               A1588CliConveImpTipo = httpContext.GetPar( "CliConveImpTipo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1588CliConveImpTipo", A1588CliConveImpTipo);
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
                  sMode218 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode218 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound218 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_4N0( ) ;
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
                        e114N2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e124N2 ();
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
         e124N2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll4N218( ) ;
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
         disableAttributes4N218( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliconvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliconvenio_Enabled), 5, 0), true);
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

   public void confirm_4N0( )
   {
      beforeValidate4N218( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4N218( ) ;
         }
         else
         {
            checkExtendedTable4N218( ) ;
            closeExtendedTableCursors4N218( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption4N0( )
   {
   }

   public void e114N2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV12WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV12WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV20DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV20DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtCliConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Visible), 5, 0), true);
      AV24ComboCliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboCliConvenio", AV24ComboCliConvenio);
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
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWclienteConvenio_importes_Insert", GXv_boolean5) ;
         clienteconvenio_importes_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWclienteConvenio_importes_Update", GXv_boolean5) ;
         clienteconvenio_importes_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWclienteConvenio_importes_Delete", GXv_boolean5) ;
         clienteconvenio_importes_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV25Pgmname))}, new String[] {"GxObject"}) );
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
      GXt_boolean4 = AV26Essistemaconceptosdefault ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean5) ;
      clienteconvenio_importes_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV26Essistemaconceptosdefault = GXt_boolean4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Essistemaconceptosdefault", AV26Essistemaconceptosdefault);
      GXv_boolean5[0] = AV18ClienteConveniador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      clienteconvenio_importes_impl.this.AV18ClienteConveniador = GXv_boolean5[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ClienteConveniador", AV18ClienteConveniador);
   }

   public void e124N2( )
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
      divCliconveimprelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divCliconveimprelsec_cell_Internalname, "Class", divCliconveimprelsec_cell_Class, true);
   }

   public void S112( )
   {
      /* 'LOADCOMBOCLICONVENIO' Routine */
      returnInSub = false ;
      Combo_cliconvenio_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"CliConvenio\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliPaiConve\": 0, \"CliConvenio\": \"\", \"CliConveImpVig\": \"\", \"CliConveImpTipo\": \"\", \"Cond_CliCod\": \"#%1#\", \"Cond_CliPaiConve\": \"#%2#\"", edtCliCod_Internalname, edtCliPaiConve_Internalname, "", "", "", "", "", "", "") ;
      ucCombo_cliconvenio.sendProperty(context, "", false, Combo_cliconvenio_Internalname, "DataListProcParametersPrefix", Combo_cliconvenio_Datalistprocparametersprefix);
      GXt_char6 = AV23Combo_DataJson ;
      GXv_char7[0] = AV21ComboSelectedValue ;
      GXv_char8[0] = AV22ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new web.clienteconvenio_importesloaddvcombo(remoteHandle, context).execute( "CliConvenio", Gx_mode, false, AV7CliCod, AV8CliPaiConve, AV9CliConvenio, AV10CliConveImpVig, AV11CliConveImpTipo, A3CliCod, A1564CliPaiConve, "", GXv_char7, GXv_char8, GXv_char9) ;
      clienteconvenio_importes_impl.this.AV21ComboSelectedValue = GXv_char7[0] ;
      clienteconvenio_importes_impl.this.AV22ComboSelectedText = GXv_char8[0] ;
      clienteconvenio_importes_impl.this.GXt_char6 = GXv_char9[0] ;
      AV23Combo_DataJson = GXt_char6 ;
      Combo_cliconvenio_Selectedvalue_set = AV21ComboSelectedValue ;
      ucCombo_cliconvenio.sendProperty(context, "", false, Combo_cliconvenio_Internalname, "SelectedValue_set", Combo_cliconvenio_Selectedvalue_set);
      Combo_cliconvenio_Selectedtext_set = AV22ComboSelectedText ;
      ucCombo_cliconvenio.sendProperty(context, "", false, Combo_cliconvenio_Internalname, "SelectedText_set", Combo_cliconvenio_Selectedtext_set);
      AV24ComboCliConvenio = AV21ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboCliConvenio", AV24ComboCliConvenio);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         Combo_cliconvenio_Enabled = false ;
         ucCombo_cliconvenio.sendProperty(context, "", false, Combo_cliconvenio_Internalname, "Enabled", GXutil.booltostr( Combo_cliconvenio_Enabled));
      }
   }

   public void zm4N218( int GX_JID )
   {
      if ( ( GX_JID == 22 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1589CliConveImporte = T004N3_A1589CliConveImporte[0] ;
            Z1896CliConveImpRelSec = T004N3_A1896CliConveImpRelSec[0] ;
            Z2044CliConveImpRelRef = T004N3_A2044CliConveImpRelRef[0] ;
         }
         else
         {
            Z1589CliConveImporte = A1589CliConveImporte ;
            Z1896CliConveImpRelSec = A1896CliConveImpRelSec ;
            Z2044CliConveImpRelRef = A2044CliConveImpRelRef ;
         }
      }
      if ( GX_JID == -22 )
      {
         Z1587CliConveImpVig = A1587CliConveImpVig ;
         Z1588CliConveImpTipo = A1588CliConveImpTipo ;
         Z1589CliConveImporte = A1589CliConveImporte ;
         Z1896CliConveImpRelSec = A1896CliConveImpRelSec ;
         Z2044CliConveImpRelRef = A2044CliConveImpRelRef ;
         Z2045CliConveImpOld = A2045CliConveImpOld ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxacliconveimprelsec_html4N218( AV7CliCod) ;
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
            clienteconvenio_importes_impl.this.GXt_int10 = GXv_int11[0] ;
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
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10CliConveImpVig)) )
      {
         A1587CliConveImpVig = AV10CliConveImpVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1587CliConveImpVig", localUtil.format(A1587CliConveImpVig, "99/99/99"));
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10CliConveImpVig)) )
      {
         edtCliConveImpVig_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveImpVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveImpVig_Enabled), 5, 0), true);
      }
      else
      {
         edtCliConveImpVig_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveImpVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveImpVig_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10CliConveImpVig)) )
      {
         edtCliConveImpVig_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveImpVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveImpVig_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV11CliConveImpTipo)==0) )
      {
         A1588CliConveImpTipo = AV11CliConveImpTipo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1588CliConveImpTipo", A1588CliConveImpTipo);
      }
      if ( ! (GXutil.strcmp("", AV11CliConveImpTipo)==0) )
      {
         cmbCliConveImpTipo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbCliConveImpTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCliConveImpTipo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbCliConveImpTipo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbCliConveImpTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCliConveImpTipo.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV11CliConveImpTipo)==0) )
      {
         cmbCliConveImpTipo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbCliConveImpTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCliConveImpTipo.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         A1565CliConvenio = AV9CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      else
      {
         A1565CliConvenio = AV24ComboCliConvenio ;
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
         AV25Pgmname = "clienteConvenio_importes" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
      }
   }

   public void load4N218( )
   {
      /* Using cursor T004N5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound218 = (short)(1) ;
         A1589CliConveImporte = T004N5_A1589CliConveImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1589CliConveImporte", GXutil.ltrimstr( A1589CliConveImporte, 14, 2));
         A1896CliConveImpRelSec = T004N5_A1896CliConveImpRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1896CliConveImpRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1896CliConveImpRelSec), 6, 0));
         A2044CliConveImpRelRef = T004N5_A2044CliConveImpRelRef[0] ;
         A2045CliConveImpOld = T004N5_A2045CliConveImpOld[0] ;
         zm4N218( -22) ;
      }
      pr_default.close(3);
      onLoadActions4N218( ) ;
   }

   public void onLoadActions4N218( )
   {
      AV25Pgmname = "clienteConvenio_importes" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
      if ( ! ( !( GXutil.dateCompare(GXutil.resetTime(A1587CliConveImpVig), GXutil.resetTime(O1587CliConveImpVig)) ) || ( GXutil.strcmp(A1588CliConveImpTipo, O1588CliConveImpTipo) != 0 ) || ( DecimalUtil.compareTo(A1589CliConveImporte, O1589CliConveImporte) != 0 ) ) )
      {
         divCliconveimprelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divCliconveimprelsec_cell_Internalname, "Class", divCliconveimprelsec_cell_Class, true);
      }
      else
      {
         if ( !( GXutil.dateCompare(GXutil.resetTime(A1587CliConveImpVig), GXutil.resetTime(O1587CliConveImpVig)) ) || ( GXutil.strcmp(A1588CliConveImpTipo, O1588CliConveImpTipo) != 0 ) || ( DecimalUtil.compareTo(A1589CliConveImporte, O1589CliConveImporte) != 0 ) )
         {
            divCliconveimprelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCliconveimprelsec_cell_Internalname, "Class", divCliconveimprelsec_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable4N218( )
   {
      nIsDirty_218 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV25Pgmname = "clienteConvenio_importes" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV17aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1896CliConveImpRelSec, GXv_boolean5) ;
         clienteconvenio_importes_impl.this.AV17aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17aplicadoHay", AV17aplicadoHay);
      }
      /* Using cursor T004N4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A1588CliConveImpTipo, "TopeIndem") == 0 ) || ( GXutil.strcmp(A1588CliConveImpTipo, "Guarderia") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo importe", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CLICONVEIMPTIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbCliConveImpTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( !( GXutil.dateCompare(GXutil.resetTime(A1587CliConveImpVig), GXutil.resetTime(O1587CliConveImpVig)) ) || ( GXutil.strcmp(A1588CliConveImpTipo, O1588CliConveImpTipo) != 0 ) || ( DecimalUtil.compareTo(A1589CliConveImporte, O1589CliConveImporte) != 0 ) ) )
      {
         divCliconveimprelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divCliconveimprelsec_cell_Internalname, "Class", divCliconveimprelsec_cell_Class, true);
      }
      else
      {
         if ( !( GXutil.dateCompare(GXutil.resetTime(A1587CliConveImpVig), GXutil.resetTime(O1587CliConveImpVig)) ) || ( GXutil.strcmp(A1588CliConveImpTipo, O1588CliConveImpTipo) != 0 ) || ( DecimalUtil.compareTo(A1589CliConveImporte, O1589CliConveImporte) != 0 ) )
         {
            divCliconveimprelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCliconveimprelsec_cell_Internalname, "Class", divCliconveimprelsec_cell_Class, true);
         }
      }
      if ( ( !( GXutil.dateCompare(GXutil.resetTime(A1587CliConveImpVig), GXutil.resetTime(O1587CliConveImpVig)) ) || ( GXutil.strcmp(A1588CliConveImpTipo, O1588CliConveImpTipo) != 0 ) || ( DecimalUtil.compareTo(A1589CliConveImporte, O1589CliConveImporte) != 0 ) ) && (0==A1896CliConveImpRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CLICONVEIMPVIG");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliConveImpVig_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors4N218( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_23( int A3CliCod ,
                          short A1564CliPaiConve ,
                          String A1565CliConvenio )
   {
      /* Using cursor T004N6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
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

   public void getKey4N218( )
   {
      /* Using cursor T004N7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound218 = (short)(1) ;
      }
      else
      {
         RcdFound218 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T004N3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm4N218( 22) ;
         RcdFound218 = (short)(1) ;
         A1587CliConveImpVig = T004N3_A1587CliConveImpVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1587CliConveImpVig", localUtil.format(A1587CliConveImpVig, "99/99/99"));
         A1588CliConveImpTipo = T004N3_A1588CliConveImpTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1588CliConveImpTipo", A1588CliConveImpTipo);
         A1589CliConveImporte = T004N3_A1589CliConveImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1589CliConveImporte", GXutil.ltrimstr( A1589CliConveImporte, 14, 2));
         A1896CliConveImpRelSec = T004N3_A1896CliConveImpRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1896CliConveImpRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1896CliConveImpRelSec), 6, 0));
         A2044CliConveImpRelRef = T004N3_A2044CliConveImpRelRef[0] ;
         A2045CliConveImpOld = T004N3_A2045CliConveImpOld[0] ;
         A3CliCod = T004N3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004N3_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004N3_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         O1589CliConveImporte = A1589CliConveImporte ;
         httpContext.ajax_rsp_assign_attri("", false, "A1589CliConveImporte", GXutil.ltrimstr( A1589CliConveImporte, 14, 2));
         O1588CliConveImpTipo = A1588CliConveImpTipo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1588CliConveImpTipo", A1588CliConveImpTipo);
         O1587CliConveImpVig = A1587CliConveImpVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1587CliConveImpVig", localUtil.format(A1587CliConveImpVig, "99/99/99"));
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1587CliConveImpVig = A1587CliConveImpVig ;
         Z1588CliConveImpTipo = A1588CliConveImpTipo ;
         sMode218 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load4N218( ) ;
         if ( AnyError == 1 )
         {
            RcdFound218 = (short)(0) ;
            initializeNonKey4N218( ) ;
         }
         Gx_mode = sMode218 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound218 = (short)(0) ;
         initializeNonKey4N218( ) ;
         sMode218 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode218 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey4N218( ) ;
      if ( RcdFound218 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound218 = (short)(0) ;
      /* Using cursor T004N8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1587CliConveImpVig, A1587CliConveImpVig, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1588CliConveImpTipo});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T004N8_A3CliCod[0] < A3CliCod ) || ( T004N8_A3CliCod[0] == A3CliCod ) && ( T004N8_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T004N8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004N8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004N8_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T004N8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004N8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004N8_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004N8_A1587CliConveImpVig[0]).before( GXutil.resetTime( A1587CliConveImpVig )) || GXutil.dateCompare(GXutil.resetTime(T004N8_A1587CliConveImpVig[0]), GXutil.resetTime(A1587CliConveImpVig)) && ( GXutil.strcmp(T004N8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004N8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004N8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004N8_A1588CliConveImpTipo[0], A1588CliConveImpTipo) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T004N8_A3CliCod[0] > A3CliCod ) || ( T004N8_A3CliCod[0] == A3CliCod ) && ( T004N8_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T004N8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004N8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004N8_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T004N8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004N8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004N8_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004N8_A1587CliConveImpVig[0]).after( GXutil.resetTime( A1587CliConveImpVig )) || GXutil.dateCompare(GXutil.resetTime(T004N8_A1587CliConveImpVig[0]), GXutil.resetTime(A1587CliConveImpVig)) && ( GXutil.strcmp(T004N8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004N8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004N8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004N8_A1588CliConveImpTipo[0], A1588CliConveImpTipo) > 0 ) ) )
         {
            A3CliCod = T004N8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T004N8_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T004N8_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A1587CliConveImpVig = T004N8_A1587CliConveImpVig[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1587CliConveImpVig", localUtil.format(A1587CliConveImpVig, "99/99/99"));
            A1588CliConveImpTipo = T004N8_A1588CliConveImpTipo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1588CliConveImpTipo", A1588CliConveImpTipo);
            RcdFound218 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound218 = (short)(0) ;
      /* Using cursor T004N9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1587CliConveImpVig, A1587CliConveImpVig, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1588CliConveImpTipo});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T004N9_A3CliCod[0] > A3CliCod ) || ( T004N9_A3CliCod[0] == A3CliCod ) && ( T004N9_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T004N9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004N9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004N9_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T004N9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004N9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004N9_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004N9_A1587CliConveImpVig[0]).after( GXutil.resetTime( A1587CliConveImpVig )) || GXutil.dateCompare(GXutil.resetTime(T004N9_A1587CliConveImpVig[0]), GXutil.resetTime(A1587CliConveImpVig)) && ( GXutil.strcmp(T004N9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004N9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004N9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004N9_A1588CliConveImpTipo[0], A1588CliConveImpTipo) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T004N9_A3CliCod[0] < A3CliCod ) || ( T004N9_A3CliCod[0] == A3CliCod ) && ( T004N9_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T004N9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004N9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004N9_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T004N9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004N9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004N9_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004N9_A1587CliConveImpVig[0]).before( GXutil.resetTime( A1587CliConveImpVig )) || GXutil.dateCompare(GXutil.resetTime(T004N9_A1587CliConveImpVig[0]), GXutil.resetTime(A1587CliConveImpVig)) && ( GXutil.strcmp(T004N9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004N9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004N9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004N9_A1588CliConveImpTipo[0], A1588CliConveImpTipo) < 0 ) ) )
         {
            A3CliCod = T004N9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T004N9_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T004N9_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A1587CliConveImpVig = T004N9_A1587CliConveImpVig[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1587CliConveImpVig", localUtil.format(A1587CliConveImpVig, "99/99/99"));
            A1588CliConveImpTipo = T004N9_A1588CliConveImpTipo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1588CliConveImpTipo", A1588CliConveImpTipo);
            RcdFound218 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4N218( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliConvenio_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert4N218( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound218 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1587CliConveImpVig), GXutil.resetTime(Z1587CliConveImpVig)) ) || ( GXutil.strcmp(A1588CliConveImpTipo, Z1588CliConveImpTipo) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A1587CliConveImpVig = Z1587CliConveImpVig ;
               httpContext.ajax_rsp_assign_attri("", false, "A1587CliConveImpVig", localUtil.format(A1587CliConveImpVig, "99/99/99"));
               A1588CliConveImpTipo = Z1588CliConveImpTipo ;
               httpContext.ajax_rsp_assign_attri("", false, "A1588CliConveImpTipo", A1588CliConveImpTipo);
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
               update4N218( ) ;
               GX_FocusControl = edtCliConvenio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1587CliConveImpVig), GXutil.resetTime(Z1587CliConveImpVig)) ) || ( GXutil.strcmp(A1588CliConveImpTipo, Z1588CliConveImpTipo) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtCliConvenio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert4N218( ) ;
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
                  insert4N218( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1587CliConveImpVig), GXutil.resetTime(Z1587CliConveImpVig)) ) || ( GXutil.strcmp(A1588CliConveImpTipo, Z1588CliConveImpTipo) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1587CliConveImpVig = Z1587CliConveImpVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1587CliConveImpVig", localUtil.format(A1587CliConveImpVig, "99/99/99"));
         A1588CliConveImpTipo = Z1588CliConveImpTipo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1588CliConveImpTipo", A1588CliConveImpTipo);
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

   public void checkOptimisticConcurrency4N218( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T004N2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"clienteConvenio_importes"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z1589CliConveImporte, T004N2_A1589CliConveImporte[0]) != 0 ) || ( Z1896CliConveImpRelSec != T004N2_A1896CliConveImpRelSec[0] ) || ( GXutil.strcmp(Z2044CliConveImpRelRef, T004N2_A2044CliConveImpRelRef[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z1589CliConveImporte, T004N2_A1589CliConveImporte[0]) != 0 )
            {
               GXutil.writeLogln("clienteconvenio_importes:[seudo value changed for attri]"+"CliConveImporte");
               GXutil.writeLogRaw("Old: ",Z1589CliConveImporte);
               GXutil.writeLogRaw("Current: ",T004N2_A1589CliConveImporte[0]);
            }
            if ( Z1896CliConveImpRelSec != T004N2_A1896CliConveImpRelSec[0] )
            {
               GXutil.writeLogln("clienteconvenio_importes:[seudo value changed for attri]"+"CliConveImpRelSec");
               GXutil.writeLogRaw("Old: ",Z1896CliConveImpRelSec);
               GXutil.writeLogRaw("Current: ",T004N2_A1896CliConveImpRelSec[0]);
            }
            if ( GXutil.strcmp(Z2044CliConveImpRelRef, T004N2_A2044CliConveImpRelRef[0]) != 0 )
            {
               GXutil.writeLogln("clienteconvenio_importes:[seudo value changed for attri]"+"CliConveImpRelRef");
               GXutil.writeLogRaw("Old: ",Z2044CliConveImpRelRef);
               GXutil.writeLogRaw("Current: ",T004N2_A2044CliConveImpRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"clienteConvenio_importes"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4N218( )
   {
      beforeValidate4N218( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4N218( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4N218( 0) ;
         checkOptimisticConcurrency4N218( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4N218( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4N218( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004N10 */
                  pr_default.execute(8, new Object[] {A1587CliConveImpVig, A1588CliConveImpTipo, A1589CliConveImporte, Integer.valueOf(A1896CliConveImpRelSec), A2044CliConveImpRelRef, A2045CliConveImpOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("clienteConvenio_importes");
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
                        resetCaption4N0( ) ;
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
            load4N218( ) ;
         }
         endLevel4N218( ) ;
      }
      closeExtendedTableCursors4N218( ) ;
   }

   public void update4N218( )
   {
      beforeValidate4N218( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4N218( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4N218( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4N218( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4N218( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004N11 */
                  pr_default.execute(9, new Object[] {A1589CliConveImporte, Integer.valueOf(A1896CliConveImpRelSec), A2044CliConveImpRelRef, A2045CliConveImpOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("clienteConvenio_importes");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"clienteConvenio_importes"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4N218( ) ;
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
         endLevel4N218( ) ;
      }
      closeExtendedTableCursors4N218( ) ;
   }

   public void deferredUpdate4N218( )
   {
   }

   public void delete( )
   {
      beforeValidate4N218( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4N218( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4N218( ) ;
         afterConfirm4N218( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4N218( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T004N12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("clienteConvenio_importes");
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
      sMode218 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel4N218( ) ;
      Gx_mode = sMode218 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls4N218( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV17aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1896CliConveImpRelSec, GXv_boolean5) ;
            clienteconvenio_importes_impl.this.AV17aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17aplicadoHay", AV17aplicadoHay);
         }
         AV25Pgmname = "clienteConvenio_importes" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
         if ( ! ( !( GXutil.dateCompare(GXutil.resetTime(A1587CliConveImpVig), GXutil.resetTime(O1587CliConveImpVig)) ) || ( GXutil.strcmp(A1588CliConveImpTipo, O1588CliConveImpTipo) != 0 ) || ( DecimalUtil.compareTo(A1589CliConveImporte, O1589CliConveImporte) != 0 ) ) )
         {
            divCliconveimprelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCliconveimprelsec_cell_Internalname, "Class", divCliconveimprelsec_cell_Class, true);
         }
         else
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(A1587CliConveImpVig), GXutil.resetTime(O1587CliConveImpVig)) ) || ( GXutil.strcmp(A1588CliConveImpTipo, O1588CliConveImpTipo) != 0 ) || ( DecimalUtil.compareTo(A1589CliConveImporte, O1589CliConveImporte) != 0 ) )
            {
               divCliconveimprelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divCliconveimprelsec_cell_Internalname, "Class", divCliconveimprelsec_cell_Class, true);
            }
         }
      }
   }

   public void endLevel4N218( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4N218( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "clienteconvenio_importes");
         if ( AnyError == 0 )
         {
            confirmValues4N0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "clienteconvenio_importes");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart4N218( )
   {
      /* Scan By routine */
      /* Using cursor T004N13 */
      pr_default.execute(11);
      RcdFound218 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound218 = (short)(1) ;
         A3CliCod = T004N13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004N13_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004N13_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1587CliConveImpVig = T004N13_A1587CliConveImpVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1587CliConveImpVig", localUtil.format(A1587CliConveImpVig, "99/99/99"));
         A1588CliConveImpTipo = T004N13_A1588CliConveImpTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1588CliConveImpTipo", A1588CliConveImpTipo);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext4N218( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound218 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound218 = (short)(1) ;
         A3CliCod = T004N13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004N13_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004N13_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1587CliConveImpVig = T004N13_A1587CliConveImpVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1587CliConveImpVig", localUtil.format(A1587CliConveImpVig, "99/99/99"));
         A1588CliConveImpTipo = T004N13_A1588CliConveImpTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1588CliConveImpTipo", A1588CliConveImpTipo);
      }
   }

   public void scanEnd4N218( )
   {
      pr_default.close(11);
   }

   public void afterConfirm4N218( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV17aplicadoHay ) && ! (0==A1896CliConveImpRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "CliConveImpRelSec", 1, "CLICONVEIMPRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynCliConveImpRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert4N218( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4N218( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4N218( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4N218( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4N218( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4N218( )
   {
      edtCliConvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      edtCliConveImpVig_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveImpVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveImpVig_Enabled), 5, 0), true);
      cmbCliConveImpTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbCliConveImpTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCliConveImpTipo.getEnabled(), 5, 0), true);
      edtCliConveImporte_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveImporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveImporte_Enabled), 5, 0), true);
      dynCliConveImpRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynCliConveImpRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConveImpRelSec.getEnabled(), 5, 0), true);
      edtavCombocliconvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocliconvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocliconvenio_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliPaiConve_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes4N218( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues4N0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.clienteconvenio_importes", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(AV10CliConveImpVig)),GXutil.URLEncode(GXutil.rtrim(AV11CliConveImpTipo))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CliConveImpVig","CliConveImpTipo"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"clienteConvenio_importes");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("CliConveImpRelRef", GXutil.rtrim( localUtil.format( A2044CliConveImpRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("clienteconvenio_importes:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1564CliPaiConve", GXutil.ltrim( localUtil.ntoc( Z1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1565CliConvenio", GXutil.rtrim( Z1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1587CliConveImpVig", localUtil.dtoc( Z1587CliConveImpVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1588CliConveImpTipo", GXutil.rtrim( Z1588CliConveImpTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1589CliConveImporte", GXutil.ltrim( localUtil.ntoc( Z1589CliConveImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1896CliConveImpRelSec", GXutil.ltrim( localUtil.ntoc( Z1896CliConveImpRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2044CliConveImpRelRef", Z2044CliConveImpRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "O1589CliConveImporte", GXutil.ltrim( localUtil.ntoc( O1589CliConveImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1588CliConveImpTipo", GXutil.rtrim( O1588CliConveImpTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "O1587CliConveImpVig", localUtil.dtoc( O1587CliConveImpVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV20DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV20DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLICONVENIO_DATA", AV19CliConvenio_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLICONVENIO_DATA", AV19CliConvenio_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV8CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV9CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVEIMPVIG", localUtil.dtoc( AV10CliConveImpVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEIMPVIG", getSecureSignedToken( "", AV10CliConveImpVig));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVEIMPTIPO", GXutil.rtrim( AV11CliConveImpTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEIMPTIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11CliConveImpTipo, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV17aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVEIMPRELREF", A2044CliConveImpRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVEIMPOLD", A2045CliConveImpOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV25Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Objectcall", GXutil.rtrim( Combo_cliconvenio_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Cls", GXutil.rtrim( Combo_cliconvenio_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Selectedvalue_set", GXutil.rtrim( Combo_cliconvenio_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Selectedtext_set", GXutil.rtrim( Combo_cliconvenio_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Enabled", GXutil.booltostr( Combo_cliconvenio_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Datalistproc", GXutil.rtrim( Combo_cliconvenio_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Datalistprocparametersprefix", GXutil.rtrim( Combo_cliconvenio_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICONVENIO_Emptyitem", GXutil.booltostr( Combo_cliconvenio_Emptyitem));
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
      return formatLink("web.clienteconvenio_importes", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(AV10CliConveImpVig)),GXutil.URLEncode(GXutil.rtrim(AV11CliConveImpTipo))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CliConveImpVig","CliConveImpTipo"})  ;
   }

   public String getPgmname( )
   {
      return "clienteConvenio_importes" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "cliente Convenio_importes", "") ;
   }

   public void initializeNonKey4N218( )
   {
      AV17aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17aplicadoHay", AV17aplicadoHay);
      A1589CliConveImporte = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1589CliConveImporte", GXutil.ltrimstr( A1589CliConveImporte, 14, 2));
      A1896CliConveImpRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1896CliConveImpRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1896CliConveImpRelSec), 6, 0));
      A2044CliConveImpRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2044CliConveImpRelRef", A2044CliConveImpRelRef);
      A2045CliConveImpOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2045CliConveImpOld", A2045CliConveImpOld);
      O1589CliConveImporte = A1589CliConveImporte ;
      httpContext.ajax_rsp_assign_attri("", false, "A1589CliConveImporte", GXutil.ltrimstr( A1589CliConveImporte, 14, 2));
      Z1589CliConveImporte = DecimalUtil.ZERO ;
      Z1896CliConveImpRelSec = 0 ;
      Z2044CliConveImpRelRef = "" ;
   }

   public void initAll4N218( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      A1587CliConveImpVig = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1587CliConveImpVig", localUtil.format(A1587CliConveImpVig, "99/99/99"));
      A1588CliConveImpTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1588CliConveImpTipo", A1588CliConveImpTipo);
      initializeNonKey4N218( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171327121", true, true);
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
      httpContext.AddJavascriptSource("clienteconvenio_importes.js", "?2025171327122", false, true);
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
      lblTextblockcliconvenio_Internalname = "TEXTBLOCKCLICONVENIO" ;
      Combo_cliconvenio_Internalname = "COMBO_CLICONVENIO" ;
      edtCliConvenio_Internalname = "CLICONVENIO" ;
      divTablesplittedcliconvenio_Internalname = "TABLESPLITTEDCLICONVENIO" ;
      edtCliConveImpVig_Internalname = "CLICONVEIMPVIG" ;
      cmbCliConveImpTipo.setInternalname( "CLICONVEIMPTIPO" );
      edtCliConveImporte_Internalname = "CLICONVEIMPORTE" ;
      dynCliConveImpRelSec.setInternalname( "CLICONVEIMPRELSEC" );
      divCliconveimprelsec_cell_Internalname = "CLICONVEIMPRELSEC_CELL" ;
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
      Form.setCaption( httpContext.getMessage( "cliente Convenio_importes", "") );
      Combo_cliconvenio_Datalistprocparametersprefix = "" ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Enabled = 1 ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavCombocliconvenio_Jsonclick = "" ;
      edtavCombocliconvenio_Enabled = 0 ;
      edtavCombocliconvenio_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynCliConveImpRelSec.setJsonclick( "" );
      dynCliConveImpRelSec.setEnabled( 1 );
      divCliconveimprelsec_cell_Class = "col-xs-12" ;
      edtCliConveImporte_Jsonclick = "" ;
      edtCliConveImporte_Enabled = 1 ;
      cmbCliConveImpTipo.setJsonclick( "" );
      cmbCliConveImpTipo.setEnabled( 1 );
      edtCliConveImpVig_Jsonclick = "" ;
      edtCliConveImpVig_Enabled = 1 ;
      edtCliConvenio_Jsonclick = "" ;
      edtCliConvenio_Enabled = 1 ;
      edtCliConvenio_Visible = 1 ;
      Combo_cliconvenio_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_cliconvenio_Datalistproc = "clienteConvenio_importesLoadDVCombo" ;
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

   public void gxdlacliconveimprelsec4N218( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacliconveimprelsec_data4N218( AV7CliCod) ;
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

   public void gxacliconveimprelsec_html4N218( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlacliconveimprelsec_data4N218( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynCliConveImpRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynCliConveImpRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlacliconveimprelsec_data4N218( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T004N14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(12) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T004N14_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T004N14_A1880CliReDTChar[0]);
         pr_default.readNext(12);
      }
      pr_default.close(12);
   }

   public void gx2asaclicod4N218( int AV7CliCod )
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
            clienteconvenio_importes_impl.this.GXt_int10 = GXv_int11[0] ;
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

   public void xc_20_4N218( String Gx_mode ,
                            int AV7CliCod ,
                            int A1896CliConveImpRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV17aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1896CliConveImpRelSec, GXv_boolean5) ;
         AV17aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17aplicadoHay", AV17aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV17aplicadoHay))+"\"") ;
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
      cmbCliConveImpTipo.setName( "CLICONVEIMPTIPO" );
      cmbCliConveImpTipo.setWebtags( "" );
      cmbCliConveImpTipo.addItem("TopeIndem", httpContext.getMessage( "Tope indemnizatorio", ""), (short)(0));
      cmbCliConveImpTipo.addItem("Guarderia", httpContext.getMessage( "Importe fijo para compensación por gastos de guardería", ""), (short)(0));
      if ( cmbCliConveImpTipo.getItemCount() > 0 )
      {
         A1588CliConveImpTipo = cmbCliConveImpTipo.getValidValue(A1588CliConveImpTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1588CliConveImpTipo", A1588CliConveImpTipo);
      }
      dynCliConveImpRelSec.setName( "CLICONVEIMPRELSEC" );
      dynCliConveImpRelSec.setWebtags( "" );
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
      A1896CliConveImpRelSec = (int)(GXutil.lval( dynCliConveImpRelSec.getValue())) ;
      /* Using cursor T004N15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(13);
      dynload_actions( ) ;
      if ( cmbCliConveImpTipo.getItemCount() > 0 )
      {
         A1588CliConveImpTipo = cmbCliConveImpTipo.getValidValue(A1588CliConveImpTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCliConveImpTipo.setValue( GXutil.rtrim( A1588CliConveImpTipo) );
      }
      /*  Sending validation outputs */
   }

   public void valid_Cliconveimprelsec( )
   {
      A1588CliConveImpTipo = cmbCliConveImpTipo.getValue() ;
      A1896CliConveImpRelSec = (int)(GXutil.lval( dynCliConveImpRelSec.getValue())) ;
      if ( ( !( GXutil.dateCompare(GXutil.resetTime(A1587CliConveImpVig), GXutil.resetTime(O1587CliConveImpVig)) ) || ( GXutil.strcmp(A1588CliConveImpTipo, O1588CliConveImpTipo) != 0 ) || ( DecimalUtil.compareTo(A1589CliConveImporte, O1589CliConveImporte) != 0 ) ) && (0==A1896CliConveImpRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CLICONVEIMPRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynCliConveImpRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV17aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1896CliConveImpRelSec, GXv_boolean5) ;
         clienteconvenio_importes_impl.this.AV17aplicadoHay = GXv_boolean5[0] ;
         AV17aplicadoHay = this.AV17aplicadoHay ;
      }
      dynload_actions( ) ;
      if ( cmbCliConveImpTipo.getItemCount() > 0 )
      {
         A1588CliConveImpTipo = cmbCliConveImpTipo.getValidValue(A1588CliConveImpTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCliConveImpTipo.setValue( GXutil.rtrim( A1588CliConveImpTipo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV17aplicadoHay", AV17aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10CliConveImpVig',fld:'vCLICONVEIMPVIG',pic:'',hsh:true},{av:'AV11CliConveImpTipo',fld:'vCLICONVEIMPTIPO',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10CliConveImpVig',fld:'vCLICONVEIMPVIG',pic:'',hsh:true},{av:'AV11CliConveImpTipo',fld:'vCLICONVEIMPTIPO',pic:'',hsh:true},{av:'A2044CliConveImpRelRef',fld:'CLICONVEIMPRELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("AFTER TRN","{handler:'e124N2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICONVEIMPVIG","{handler:'valid_Cliconveimpvig',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICONVEIMPVIG",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICONVEIMPTIPO","{handler:'valid_Cliconveimptipo',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICONVEIMPTIPO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICONVEIMPORTE","{handler:'valid_Cliconveimporte',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICONVEIMPORTE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICONVEIMPRELSEC","{handler:'valid_Cliconveimprelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1589CliConveImporte'},{av:'O1588CliConveImpTipo'},{av:'O1587CliConveImpVig'},{av:'A1587CliConveImpVig',fld:'CLICONVEIMPVIG',pic:''},{av:'cmbCliConveImpTipo'},{av:'A1588CliConveImpTipo',fld:'CLICONVEIMPTIPO',pic:''},{av:'A1589CliConveImporte',fld:'CLICONVEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV17aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICONVEIMPRELSEC",",oparms:[{av:'AV17aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALIDV_COMBOCLICONVENIO","{handler:'validv_Combocliconvenio',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALIDV_COMBOCLICONVENIO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCliConveImpRelSec'},{av:'A1896CliConveImpRelSec',fld:'CLICONVEIMPRELSEC',pic:'ZZZZZ9'}]}");
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
      wcpOAV10CliConveImpVig = GXutil.nullDate() ;
      wcpOAV11CliConveImpTipo = "" ;
      Z1565CliConvenio = "" ;
      Z1587CliConveImpVig = GXutil.nullDate() ;
      Z1588CliConveImpTipo = "" ;
      Z1589CliConveImporte = DecimalUtil.ZERO ;
      Z2044CliConveImpRelRef = "" ;
      O1589CliConveImporte = DecimalUtil.ZERO ;
      O1588CliConveImpTipo = "" ;
      O1587CliConveImpVig = GXutil.nullDate() ;
      Combo_cliconvenio_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A1565CliConvenio = "" ;
      AV9CliConvenio = "" ;
      AV10CliConveImpVig = GXutil.nullDate() ;
      AV11CliConveImpTipo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1588CliConveImpTipo = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockcliconvenio_Jsonclick = "" ;
      ucCombo_cliconvenio = new com.genexus.webpanels.GXUserControl();
      AV20DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV19CliConvenio_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A1587CliConveImpVig = GXutil.nullDate() ;
      A1589CliConveImporte = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV24ComboCliConvenio = "" ;
      A2044CliConveImpRelRef = "" ;
      A2045CliConveImpOld = "" ;
      AV25Pgmname = "" ;
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
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode218 = "" ;
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
      AV23Combo_DataJson = "" ;
      GXt_char6 = "" ;
      AV21ComboSelectedValue = "" ;
      GXv_char7 = new String[1] ;
      AV22ComboSelectedText = "" ;
      GXv_char8 = new String[1] ;
      GXv_char9 = new String[1] ;
      Z2045CliConveImpOld = "" ;
      T004N5_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004N5_A1588CliConveImpTipo = new String[] {""} ;
      T004N5_A1589CliConveImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004N5_A1896CliConveImpRelSec = new int[1] ;
      T004N5_A2044CliConveImpRelRef = new String[] {""} ;
      T004N5_A2045CliConveImpOld = new String[] {""} ;
      T004N5_A3CliCod = new int[1] ;
      T004N5_A1564CliPaiConve = new short[1] ;
      T004N5_A1565CliConvenio = new String[] {""} ;
      T004N4_A3CliCod = new int[1] ;
      T004N6_A3CliCod = new int[1] ;
      T004N7_A3CliCod = new int[1] ;
      T004N7_A1564CliPaiConve = new short[1] ;
      T004N7_A1565CliConvenio = new String[] {""} ;
      T004N7_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004N7_A1588CliConveImpTipo = new String[] {""} ;
      T004N3_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004N3_A1588CliConveImpTipo = new String[] {""} ;
      T004N3_A1589CliConveImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004N3_A1896CliConveImpRelSec = new int[1] ;
      T004N3_A2044CliConveImpRelRef = new String[] {""} ;
      T004N3_A2045CliConveImpOld = new String[] {""} ;
      T004N3_A3CliCod = new int[1] ;
      T004N3_A1564CliPaiConve = new short[1] ;
      T004N3_A1565CliConvenio = new String[] {""} ;
      T004N8_A3CliCod = new int[1] ;
      T004N8_A1564CliPaiConve = new short[1] ;
      T004N8_A1565CliConvenio = new String[] {""} ;
      T004N8_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004N8_A1588CliConveImpTipo = new String[] {""} ;
      T004N9_A3CliCod = new int[1] ;
      T004N9_A1564CliPaiConve = new short[1] ;
      T004N9_A1565CliConvenio = new String[] {""} ;
      T004N9_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004N9_A1588CliConveImpTipo = new String[] {""} ;
      T004N2_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004N2_A1588CliConveImpTipo = new String[] {""} ;
      T004N2_A1589CliConveImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004N2_A1896CliConveImpRelSec = new int[1] ;
      T004N2_A2044CliConveImpRelRef = new String[] {""} ;
      T004N2_A2045CliConveImpOld = new String[] {""} ;
      T004N2_A3CliCod = new int[1] ;
      T004N2_A1564CliPaiConve = new short[1] ;
      T004N2_A1565CliConvenio = new String[] {""} ;
      T004N13_A3CliCod = new int[1] ;
      T004N13_A1564CliPaiConve = new short[1] ;
      T004N13_A1565CliConvenio = new String[] {""} ;
      T004N13_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      T004N13_A1588CliConveImpTipo = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T004N14_A3CliCod = new int[1] ;
      T004N14_A1885CliRelSec = new int[1] ;
      T004N14_A1880CliReDTChar = new String[] {""} ;
      GXv_int11 = new int[1] ;
      T004N15_A3CliCod = new int[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clienteconvenio_importes__default(),
         new Object[] {
             new Object[] {
            T004N2_A1587CliConveImpVig, T004N2_A1588CliConveImpTipo, T004N2_A1589CliConveImporte, T004N2_A1896CliConveImpRelSec, T004N2_A2044CliConveImpRelRef, T004N2_A2045CliConveImpOld, T004N2_A3CliCod, T004N2_A1564CliPaiConve, T004N2_A1565CliConvenio
            }
            , new Object[] {
            T004N3_A1587CliConveImpVig, T004N3_A1588CliConveImpTipo, T004N3_A1589CliConveImporte, T004N3_A1896CliConveImpRelSec, T004N3_A2044CliConveImpRelRef, T004N3_A2045CliConveImpOld, T004N3_A3CliCod, T004N3_A1564CliPaiConve, T004N3_A1565CliConvenio
            }
            , new Object[] {
            T004N4_A3CliCod
            }
            , new Object[] {
            T004N5_A1587CliConveImpVig, T004N5_A1588CliConveImpTipo, T004N5_A1589CliConveImporte, T004N5_A1896CliConveImpRelSec, T004N5_A2044CliConveImpRelRef, T004N5_A2045CliConveImpOld, T004N5_A3CliCod, T004N5_A1564CliPaiConve, T004N5_A1565CliConvenio
            }
            , new Object[] {
            T004N6_A3CliCod
            }
            , new Object[] {
            T004N7_A3CliCod, T004N7_A1564CliPaiConve, T004N7_A1565CliConvenio, T004N7_A1587CliConveImpVig, T004N7_A1588CliConveImpTipo
            }
            , new Object[] {
            T004N8_A3CliCod, T004N8_A1564CliPaiConve, T004N8_A1565CliConvenio, T004N8_A1587CliConveImpVig, T004N8_A1588CliConveImpTipo
            }
            , new Object[] {
            T004N9_A3CliCod, T004N9_A1564CliPaiConve, T004N9_A1565CliConvenio, T004N9_A1587CliConveImpVig, T004N9_A1588CliConveImpTipo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004N13_A3CliCod, T004N13_A1564CliPaiConve, T004N13_A1565CliConvenio, T004N13_A1587CliConveImpVig, T004N13_A1588CliConveImpTipo
            }
            , new Object[] {
            T004N14_A3CliCod, T004N14_A1885CliRelSec, T004N14_A1880CliReDTChar
            }
            , new Object[] {
            T004N15_A3CliCod
            }
         }
      );
      AV25Pgmname = "clienteConvenio_importes" ;
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
   private short RcdFound218 ;
   private short nIsDirty_218 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z1896CliConveImpRelSec ;
   private int AV7CliCod ;
   private int A1896CliConveImpRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtCliConvenio_Visible ;
   private int edtCliConvenio_Enabled ;
   private int edtCliConveImpVig_Enabled ;
   private int edtCliConveImporte_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombocliconvenio_Visible ;
   private int edtavCombocliconvenio_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtCliPaiConve_Visible ;
   private int edtCliPaiConve_Enabled ;
   private int Combo_cliconvenio_Datalistupdateminimumcharacters ;
   private int Combo_cliconvenio_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int10 ;
   private int GXv_int11[] ;
   private java.math.BigDecimal Z1589CliConveImporte ;
   private java.math.BigDecimal O1589CliConveImporte ;
   private java.math.BigDecimal A1589CliConveImporte ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9CliConvenio ;
   private String wcpOAV11CliConveImpTipo ;
   private String Z1565CliConvenio ;
   private String Z1588CliConveImpTipo ;
   private String O1588CliConveImpTipo ;
   private String Combo_cliconvenio_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A1565CliConvenio ;
   private String AV9CliConvenio ;
   private String AV11CliConveImpTipo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliConvenio_Internalname ;
   private String A1588CliConveImpTipo ;
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
   private String edtCliConveImpVig_Internalname ;
   private String edtCliConveImpVig_Jsonclick ;
   private String edtCliConveImporte_Internalname ;
   private String edtCliConveImporte_Jsonclick ;
   private String divCliconveimprelsec_cell_Internalname ;
   private String divCliconveimprelsec_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_cliconvenio_Internalname ;
   private String edtavCombocliconvenio_Internalname ;
   private String AV24ComboCliConvenio ;
   private String edtavCombocliconvenio_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String AV25Pgmname ;
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
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode218 ;
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
   private java.util.Date wcpOAV10CliConveImpVig ;
   private java.util.Date Z1587CliConveImpVig ;
   private java.util.Date O1587CliConveImpVig ;
   private java.util.Date AV10CliConveImpVig ;
   private java.util.Date A1587CliConveImpVig ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_cliconvenio_Emptyitem ;
   private boolean AV17aplicadoHay ;
   private boolean Combo_cliconvenio_Enabled ;
   private boolean Combo_cliconvenio_Visible ;
   private boolean Combo_cliconvenio_Allowmultipleselection ;
   private boolean Combo_cliconvenio_Isgriditem ;
   private boolean Combo_cliconvenio_Hasdescription ;
   private boolean Combo_cliconvenio_Includeonlyselectedoption ;
   private boolean Combo_cliconvenio_Includeselectalloption ;
   private boolean Combo_cliconvenio_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean AV26Essistemaconceptosdefault ;
   private boolean GXt_boolean4 ;
   private boolean AV18ClienteConveniador ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXv_boolean5[] ;
   private boolean ZV17aplicadoHay ;
   private String A2045CliConveImpOld ;
   private String AV23Combo_DataJson ;
   private String Z2045CliConveImpOld ;
   private String Z2044CliConveImpRelRef ;
   private String A2044CliConveImpRelRef ;
   private String AV21ComboSelectedValue ;
   private String AV22ComboSelectedText ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV16WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_cliconvenio ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbCliConveImpTipo ;
   private HTMLChoice dynCliConveImpRelSec ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] T004N5_A1587CliConveImpVig ;
   private String[] T004N5_A1588CliConveImpTipo ;
   private java.math.BigDecimal[] T004N5_A1589CliConveImporte ;
   private int[] T004N5_A1896CliConveImpRelSec ;
   private String[] T004N5_A2044CliConveImpRelRef ;
   private String[] T004N5_A2045CliConveImpOld ;
   private int[] T004N5_A3CliCod ;
   private short[] T004N5_A1564CliPaiConve ;
   private String[] T004N5_A1565CliConvenio ;
   private int[] T004N4_A3CliCod ;
   private int[] T004N6_A3CliCod ;
   private int[] T004N7_A3CliCod ;
   private short[] T004N7_A1564CliPaiConve ;
   private String[] T004N7_A1565CliConvenio ;
   private java.util.Date[] T004N7_A1587CliConveImpVig ;
   private String[] T004N7_A1588CliConveImpTipo ;
   private java.util.Date[] T004N3_A1587CliConveImpVig ;
   private String[] T004N3_A1588CliConveImpTipo ;
   private java.math.BigDecimal[] T004N3_A1589CliConveImporte ;
   private int[] T004N3_A1896CliConveImpRelSec ;
   private String[] T004N3_A2044CliConveImpRelRef ;
   private String[] T004N3_A2045CliConveImpOld ;
   private int[] T004N3_A3CliCod ;
   private short[] T004N3_A1564CliPaiConve ;
   private String[] T004N3_A1565CliConvenio ;
   private int[] T004N8_A3CliCod ;
   private short[] T004N8_A1564CliPaiConve ;
   private String[] T004N8_A1565CliConvenio ;
   private java.util.Date[] T004N8_A1587CliConveImpVig ;
   private String[] T004N8_A1588CliConveImpTipo ;
   private int[] T004N9_A3CliCod ;
   private short[] T004N9_A1564CliPaiConve ;
   private String[] T004N9_A1565CliConvenio ;
   private java.util.Date[] T004N9_A1587CliConveImpVig ;
   private String[] T004N9_A1588CliConveImpTipo ;
   private java.util.Date[] T004N2_A1587CliConveImpVig ;
   private String[] T004N2_A1588CliConveImpTipo ;
   private java.math.BigDecimal[] T004N2_A1589CliConveImporte ;
   private int[] T004N2_A1896CliConveImpRelSec ;
   private String[] T004N2_A2044CliConveImpRelRef ;
   private String[] T004N2_A2045CliConveImpOld ;
   private int[] T004N2_A3CliCod ;
   private short[] T004N2_A1564CliPaiConve ;
   private String[] T004N2_A1565CliConvenio ;
   private int[] T004N13_A3CliCod ;
   private short[] T004N13_A1564CliPaiConve ;
   private String[] T004N13_A1565CliConvenio ;
   private java.util.Date[] T004N13_A1587CliConveImpVig ;
   private String[] T004N13_A1588CliConveImpTipo ;
   private int[] T004N14_A3CliCod ;
   private int[] T004N14_A1885CliRelSec ;
   private String[] T004N14_A1880CliReDTChar ;
   private int[] T004N15_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV19CliConvenio_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV12WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV15TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV20DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class clienteconvenio_importes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T004N2", "SELECT CliConveImpVig, CliConveImpTipo, CliConveImporte, CliConveImpRelSec, CliConveImpRelRef, CliConveImpOld, CliCod, CliPaiConve, CliConvenio FROM clienteConvenio_importes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveImpVig = ? AND CliConveImpTipo = ?  FOR UPDATE OF clienteConvenio_importes NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004N3", "SELECT CliConveImpVig, CliConveImpTipo, CliConveImporte, CliConveImpRelSec, CliConveImpRelRef, CliConveImpOld, CliCod, CliPaiConve, CliConvenio FROM clienteConvenio_importes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveImpVig = ? AND CliConveImpTipo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004N4", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004N5", "SELECT TM1.CliConveImpVig, TM1.CliConveImpTipo, TM1.CliConveImporte, TM1.CliConveImpRelSec, TM1.CliConveImpRelRef, TM1.CliConveImpOld, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio FROM clienteConvenio_importes TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.CliConveImpVig = ? and TM1.CliConveImpTipo = ( ?) ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.CliConveImpVig, TM1.CliConveImpTipo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004N6", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004N7", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveImpVig, CliConveImpTipo FROM clienteConvenio_importes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveImpVig = ? AND CliConveImpTipo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004N8", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveImpVig, CliConveImpTipo FROM clienteConvenio_importes WHERE ( CliCod > ? or CliCod = ? and CliPaiConve > ? or CliPaiConve = ? and CliCod = ? and CliConvenio > ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CliConveImpVig > ? or CliConveImpVig = ? and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CliConveImpTipo > ( ?)) ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveImpVig, CliConveImpTipo  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004N9", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveImpVig, CliConveImpTipo FROM clienteConvenio_importes WHERE ( CliCod < ? or CliCod = ? and CliPaiConve < ? or CliPaiConve = ? and CliCod = ? and CliConvenio < ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CliConveImpVig < ? or CliConveImpVig = ? and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CliConveImpTipo < ( ?)) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, CliConveImpVig DESC, CliConveImpTipo DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T004N10", "SAVEPOINT gxupdate;INSERT INTO clienteConvenio_importes(CliConveImpVig, CliConveImpTipo, CliConveImporte, CliConveImpRelSec, CliConveImpRelRef, CliConveImpOld, CliCod, CliPaiConve, CliConvenio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004N11", "SAVEPOINT gxupdate;UPDATE clienteConvenio_importes SET CliConveImporte=?, CliConveImpRelSec=?, CliConveImpRelRef=?, CliConveImpOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveImpVig = ? AND CliConveImpTipo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004N12", "SAVEPOINT gxupdate;DELETE FROM clienteConvenio_importes  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveImpVig = ? AND CliConveImpTipo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004N13", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveImpVig, CliConveImpTipo FROM clienteConvenio_importes ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveImpVig, CliConveImpTipo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004N14", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004N15", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
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
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 20);
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
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setDate(11, (java.util.Date)parms[10]);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setString(15, (String)parms[14], 20);
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
               stmt.setString(15, (String)parms[14], 20);
               return;
            case 8 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setNLongVarchar(6, (String)parms[5], false);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
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
               stmt.setDate(8, (java.util.Date)parms[7]);
               stmt.setString(9, (String)parms[8], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

