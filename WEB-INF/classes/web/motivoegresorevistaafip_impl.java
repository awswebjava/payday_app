package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class motivoegresorevistaafip_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_11") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A11MegCodigo = httpContext.GetPar( "MegCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_11( A3CliCod, A11MegCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A1601MegSitRevista = (short)(GXutil.lval( httpContext.GetPar( "MegSitRevista"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A1601MegSitRevista) ;
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
            AV8MegCodigo = httpContext.GetPar( "MegCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8MegCodigo", AV8MegCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMEGCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8MegCodigo, ""))));
            AV9MegSitRevista = (short)(GXutil.lval( httpContext.GetPar( "MegSitRevista"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9MegSitRevista), 3, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMEGSITREVISTA", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9MegSitRevista), "ZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Motivo Egreso Revista Afip", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public motivoegresorevistaafip_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public motivoegresorevistaafip_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( motivoegresorevistaafip_impl.class ));
   }

   public motivoegresorevistaafip_impl( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkMegSitRevDef = UIFactory.getCheckbox(this);
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
      A1606MegSitRevDef = GXutil.strtobool( GXutil.booltostr( A1606MegSitRevDef)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1606MegSitRevDef", A1606MegSitRevDef);
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedclicod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockclicod_Internalname, httpContext.getMessage( "Cliente", ""), "", "", lblTextblockclicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MotivoEgresoRevistaAfip.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_clicod.setProperty("Caption", Combo_clicod_Caption);
      ucCombo_clicod.setProperty("Cls", Combo_clicod_Cls);
      ucCombo_clicod.setProperty("DataListProc", Combo_clicod_Datalistproc);
      ucCombo_clicod.setProperty("DataListProcParametersPrefix", Combo_clicod_Datalistprocparametersprefix);
      ucCombo_clicod.setProperty("EmptyItem", Combo_clicod_Emptyitem);
      ucCombo_clicod.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_clicod.setProperty("DropDownOptionsData", AV15CliCod_Data);
      ucCombo_clicod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_clicod_Internalname, "COMBO_CLICODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliCod_Internalname, httpContext.getMessage( "Cli Cod", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_MotivoEgresoRevistaAfip.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmegcodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmegcodigo_Internalname, httpContext.getMessage( "Motivo Egreso", ""), "", "", lblTextblockmegcodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MotivoEgresoRevistaAfip.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_megcodigo.setProperty("Caption", Combo_megcodigo_Caption);
      ucCombo_megcodigo.setProperty("Cls", Combo_megcodigo_Cls);
      ucCombo_megcodigo.setProperty("DataListProc", Combo_megcodigo_Datalistproc);
      ucCombo_megcodigo.setProperty("EmptyItem", Combo_megcodigo_Emptyitem);
      ucCombo_megcodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_megcodigo.setProperty("DropDownOptionsData", AV21MegCodigo_Data);
      ucCombo_megcodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_megcodigo_Internalname, "COMBO_MEGCODIGOContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMegCodigo_Internalname, httpContext.getMessage( "Motivo Egreso", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMegCodigo_Internalname, GXutil.rtrim( A11MegCodigo), GXutil.rtrim( localUtil.format( A11MegCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMegCodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtMegCodigo_Visible, edtMegCodigo_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoCaracter", "left", true, "", "HLP_MotivoEgresoRevistaAfip.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmegsitrevista_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmegsitrevista_Internalname, httpContext.getMessage( "Situación de revista", ""), "", "", lblTextblockmegsitrevista_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_MotivoEgresoRevistaAfip.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_megsitrevista.setProperty("Caption", Combo_megsitrevista_Caption);
      ucCombo_megsitrevista.setProperty("Cls", Combo_megsitrevista_Cls);
      ucCombo_megsitrevista.setProperty("DataListProc", Combo_megsitrevista_Datalistproc);
      ucCombo_megsitrevista.setProperty("DataListProcParametersPrefix", Combo_megsitrevista_Datalistprocparametersprefix);
      ucCombo_megsitrevista.setProperty("EmptyItem", Combo_megsitrevista_Emptyitem);
      ucCombo_megsitrevista.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_megsitrevista.setProperty("DropDownOptionsData", AV24MegSitRevista_Data);
      ucCombo_megsitrevista.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_megsitrevista_Internalname, "COMBO_MEGSITREVISTAContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMegSitRevista_Internalname, httpContext.getMessage( "Situación de revista", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMegSitRevista_Internalname, GXutil.ltrim( localUtil.ntoc( A1601MegSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1601MegSitRevista), "ZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,50);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMegSitRevista_Jsonclick, 0, "Attribute", "", "", "", "", edtMegSitRevista_Visible, edtMegSitRevista_Enabled, 1, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_MotivoEgresoRevistaAfip.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkMegSitRevDef.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkMegSitRevDef.getInternalname(), httpContext.getMessage( "Default", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkMegSitRevDef.getInternalname(), GXutil.booltostr( A1606MegSitRevDef), "", httpContext.getMessage( "Default", ""), 1, chkMegSitRevDef.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(55, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,55);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MotivoEgresoRevistaAfip.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MotivoEgresoRevistaAfip.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MotivoEgresoRevistaAfip.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_clicod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboclicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV20ComboCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboclicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20ComboCliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20ComboCliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboclicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboclicod_Visible, edtavComboclicod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_MotivoEgresoRevistaAfip.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_megcodigo_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombomegcodigo_Internalname, GXutil.rtrim( AV22ComboMegCodigo), GXutil.rtrim( localUtil.format( AV22ComboMegCodigo, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombomegcodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombomegcodigo_Visible, edtavCombomegcodigo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_MotivoEgresoRevistaAfip.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_megsitrevista_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombomegsitrevista_Internalname, GXutil.ltrim( localUtil.ntoc( AV25ComboMegSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCombomegsitrevista_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV25ComboMegSitRevista), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV25ComboMegSitRevista), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombomegsitrevista_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombomegsitrevista_Visible, edtavCombomegsitrevista_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_MotivoEgresoRevistaAfip.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      e11522 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLICOD_DATA"), AV15CliCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMEGCODIGO_DATA"), AV21MegCodigo_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMEGSITREVISTA_DATA"), AV24MegSitRevista_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z11MegCodigo = httpContext.cgiGet( "Z11MegCodigo") ;
            Z1601MegSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( "Z1601MegSitRevista"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1606MegSitRevDef = GXutil.strtobool( httpContext.cgiGet( "Z1606MegSitRevDef")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV23Cond_CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCOND_CLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8MegCodigo = httpContext.cgiGet( "vMEGCODIGO") ;
            AV9MegSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( "vMEGSITREVISTA"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A300MegDescrip = httpContext.cgiGet( "MEGDESCRIP") ;
            AV27Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_clicod_Objectcall = httpContext.cgiGet( "COMBO_CLICOD_Objectcall") ;
            Combo_clicod_Class = httpContext.cgiGet( "COMBO_CLICOD_Class") ;
            Combo_clicod_Icontype = httpContext.cgiGet( "COMBO_CLICOD_Icontype") ;
            Combo_clicod_Icon = httpContext.cgiGet( "COMBO_CLICOD_Icon") ;
            Combo_clicod_Caption = httpContext.cgiGet( "COMBO_CLICOD_Caption") ;
            Combo_clicod_Tooltip = httpContext.cgiGet( "COMBO_CLICOD_Tooltip") ;
            Combo_clicod_Cls = httpContext.cgiGet( "COMBO_CLICOD_Cls") ;
            Combo_clicod_Selectedvalue_set = httpContext.cgiGet( "COMBO_CLICOD_Selectedvalue_set") ;
            Combo_clicod_Selectedvalue_get = httpContext.cgiGet( "COMBO_CLICOD_Selectedvalue_get") ;
            Combo_clicod_Selectedtext_set = httpContext.cgiGet( "COMBO_CLICOD_Selectedtext_set") ;
            Combo_clicod_Selectedtext_get = httpContext.cgiGet( "COMBO_CLICOD_Selectedtext_get") ;
            Combo_clicod_Gamoauthtoken = httpContext.cgiGet( "COMBO_CLICOD_Gamoauthtoken") ;
            Combo_clicod_Ddointernalname = httpContext.cgiGet( "COMBO_CLICOD_Ddointernalname") ;
            Combo_clicod_Titlecontrolalign = httpContext.cgiGet( "COMBO_CLICOD_Titlecontrolalign") ;
            Combo_clicod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CLICOD_Dropdownoptionstype") ;
            Combo_clicod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Enabled")) ;
            Combo_clicod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Visible")) ;
            Combo_clicod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CLICOD_Titlecontrolidtoreplace") ;
            Combo_clicod_Datalisttype = httpContext.cgiGet( "COMBO_CLICOD_Datalisttype") ;
            Combo_clicod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Allowmultipleselection")) ;
            Combo_clicod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CLICOD_Datalistfixedvalues") ;
            Combo_clicod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Isgriditem")) ;
            Combo_clicod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Hasdescription")) ;
            Combo_clicod_Datalistproc = httpContext.cgiGet( "COMBO_CLICOD_Datalistproc") ;
            Combo_clicod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CLICOD_Datalistprocparametersprefix") ;
            Combo_clicod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CLICOD_Remoteservicesparameters") ;
            Combo_clicod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLICOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_clicod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Includeonlyselectedoption")) ;
            Combo_clicod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Includeselectalloption")) ;
            Combo_clicod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Emptyitem")) ;
            Combo_clicod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Includeaddnewoption")) ;
            Combo_clicod_Htmltemplate = httpContext.cgiGet( "COMBO_CLICOD_Htmltemplate") ;
            Combo_clicod_Multiplevaluestype = httpContext.cgiGet( "COMBO_CLICOD_Multiplevaluestype") ;
            Combo_clicod_Loadingdata = httpContext.cgiGet( "COMBO_CLICOD_Loadingdata") ;
            Combo_clicod_Noresultsfound = httpContext.cgiGet( "COMBO_CLICOD_Noresultsfound") ;
            Combo_clicod_Emptyitemtext = httpContext.cgiGet( "COMBO_CLICOD_Emptyitemtext") ;
            Combo_clicod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CLICOD_Onlyselectedvalues") ;
            Combo_clicod_Selectalltext = httpContext.cgiGet( "COMBO_CLICOD_Selectalltext") ;
            Combo_clicod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CLICOD_Multiplevaluesseparator") ;
            Combo_clicod_Addnewoptiontext = httpContext.cgiGet( "COMBO_CLICOD_Addnewoptiontext") ;
            Combo_megcodigo_Objectcall = httpContext.cgiGet( "COMBO_MEGCODIGO_Objectcall") ;
            Combo_megcodigo_Class = httpContext.cgiGet( "COMBO_MEGCODIGO_Class") ;
            Combo_megcodigo_Icontype = httpContext.cgiGet( "COMBO_MEGCODIGO_Icontype") ;
            Combo_megcodigo_Icon = httpContext.cgiGet( "COMBO_MEGCODIGO_Icon") ;
            Combo_megcodigo_Caption = httpContext.cgiGet( "COMBO_MEGCODIGO_Caption") ;
            Combo_megcodigo_Tooltip = httpContext.cgiGet( "COMBO_MEGCODIGO_Tooltip") ;
            Combo_megcodigo_Cls = httpContext.cgiGet( "COMBO_MEGCODIGO_Cls") ;
            Combo_megcodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectedvalue_set") ;
            Combo_megcodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectedvalue_get") ;
            Combo_megcodigo_Selectedtext_set = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectedtext_set") ;
            Combo_megcodigo_Selectedtext_get = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectedtext_get") ;
            Combo_megcodigo_Gamoauthtoken = httpContext.cgiGet( "COMBO_MEGCODIGO_Gamoauthtoken") ;
            Combo_megcodigo_Ddointernalname = httpContext.cgiGet( "COMBO_MEGCODIGO_Ddointernalname") ;
            Combo_megcodigo_Titlecontrolalign = httpContext.cgiGet( "COMBO_MEGCODIGO_Titlecontrolalign") ;
            Combo_megcodigo_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MEGCODIGO_Dropdownoptionstype") ;
            Combo_megcodigo_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Enabled")) ;
            Combo_megcodigo_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Visible")) ;
            Combo_megcodigo_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MEGCODIGO_Titlecontrolidtoreplace") ;
            Combo_megcodigo_Datalisttype = httpContext.cgiGet( "COMBO_MEGCODIGO_Datalisttype") ;
            Combo_megcodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Allowmultipleselection")) ;
            Combo_megcodigo_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MEGCODIGO_Datalistfixedvalues") ;
            Combo_megcodigo_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Isgriditem")) ;
            Combo_megcodigo_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Hasdescription")) ;
            Combo_megcodigo_Datalistproc = httpContext.cgiGet( "COMBO_MEGCODIGO_Datalistproc") ;
            Combo_megcodigo_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MEGCODIGO_Datalistprocparametersprefix") ;
            Combo_megcodigo_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MEGCODIGO_Remoteservicesparameters") ;
            Combo_megcodigo_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MEGCODIGO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_megcodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Includeonlyselectedoption")) ;
            Combo_megcodigo_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Includeselectalloption")) ;
            Combo_megcodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Emptyitem")) ;
            Combo_megcodigo_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGCODIGO_Includeaddnewoption")) ;
            Combo_megcodigo_Htmltemplate = httpContext.cgiGet( "COMBO_MEGCODIGO_Htmltemplate") ;
            Combo_megcodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_MEGCODIGO_Multiplevaluestype") ;
            Combo_megcodigo_Loadingdata = httpContext.cgiGet( "COMBO_MEGCODIGO_Loadingdata") ;
            Combo_megcodigo_Noresultsfound = httpContext.cgiGet( "COMBO_MEGCODIGO_Noresultsfound") ;
            Combo_megcodigo_Emptyitemtext = httpContext.cgiGet( "COMBO_MEGCODIGO_Emptyitemtext") ;
            Combo_megcodigo_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MEGCODIGO_Onlyselectedvalues") ;
            Combo_megcodigo_Selectalltext = httpContext.cgiGet( "COMBO_MEGCODIGO_Selectalltext") ;
            Combo_megcodigo_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MEGCODIGO_Multiplevaluesseparator") ;
            Combo_megcodigo_Addnewoptiontext = httpContext.cgiGet( "COMBO_MEGCODIGO_Addnewoptiontext") ;
            Combo_megsitrevista_Objectcall = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Objectcall") ;
            Combo_megsitrevista_Class = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Class") ;
            Combo_megsitrevista_Icontype = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Icontype") ;
            Combo_megsitrevista_Icon = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Icon") ;
            Combo_megsitrevista_Caption = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Caption") ;
            Combo_megsitrevista_Tooltip = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Tooltip") ;
            Combo_megsitrevista_Cls = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Cls") ;
            Combo_megsitrevista_Selectedvalue_set = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Selectedvalue_set") ;
            Combo_megsitrevista_Selectedvalue_get = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Selectedvalue_get") ;
            Combo_megsitrevista_Selectedtext_set = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Selectedtext_set") ;
            Combo_megsitrevista_Selectedtext_get = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Selectedtext_get") ;
            Combo_megsitrevista_Gamoauthtoken = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Gamoauthtoken") ;
            Combo_megsitrevista_Ddointernalname = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Ddointernalname") ;
            Combo_megsitrevista_Titlecontrolalign = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Titlecontrolalign") ;
            Combo_megsitrevista_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Dropdownoptionstype") ;
            Combo_megsitrevista_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGSITREVISTA_Enabled")) ;
            Combo_megsitrevista_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGSITREVISTA_Visible")) ;
            Combo_megsitrevista_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Titlecontrolidtoreplace") ;
            Combo_megsitrevista_Datalisttype = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Datalisttype") ;
            Combo_megsitrevista_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGSITREVISTA_Allowmultipleselection")) ;
            Combo_megsitrevista_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Datalistfixedvalues") ;
            Combo_megsitrevista_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGSITREVISTA_Isgriditem")) ;
            Combo_megsitrevista_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGSITREVISTA_Hasdescription")) ;
            Combo_megsitrevista_Datalistproc = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Datalistproc") ;
            Combo_megsitrevista_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Datalistprocparametersprefix") ;
            Combo_megsitrevista_Remoteservicesparameters = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Remoteservicesparameters") ;
            Combo_megsitrevista_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MEGSITREVISTA_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_megsitrevista_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGSITREVISTA_Includeonlyselectedoption")) ;
            Combo_megsitrevista_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGSITREVISTA_Includeselectalloption")) ;
            Combo_megsitrevista_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGSITREVISTA_Emptyitem")) ;
            Combo_megsitrevista_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEGSITREVISTA_Includeaddnewoption")) ;
            Combo_megsitrevista_Htmltemplate = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Htmltemplate") ;
            Combo_megsitrevista_Multiplevaluestype = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Multiplevaluestype") ;
            Combo_megsitrevista_Loadingdata = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Loadingdata") ;
            Combo_megsitrevista_Noresultsfound = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Noresultsfound") ;
            Combo_megsitrevista_Emptyitemtext = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Emptyitemtext") ;
            Combo_megsitrevista_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Onlyselectedvalues") ;
            Combo_megsitrevista_Selectalltext = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Selectalltext") ;
            Combo_megsitrevista_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Multiplevaluesseparator") ;
            Combo_megsitrevista_Addnewoptiontext = httpContext.cgiGet( "COMBO_MEGSITREVISTA_Addnewoptiontext") ;
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
            A11MegCodigo = httpContext.cgiGet( edtMegCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtMegSitRevista_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtMegSitRevista_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MEGSITREVISTA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMegSitRevista_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1601MegSitRevista = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
            }
            else
            {
               A1601MegSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( edtMegSitRevista_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
            }
            A1606MegSitRevDef = GXutil.strtobool( httpContext.cgiGet( chkMegSitRevDef.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1606MegSitRevDef", A1606MegSitRevDef);
            AV20ComboCliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtavComboclicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCliCod), 6, 0));
            AV22ComboMegCodigo = httpContext.cgiGet( edtavCombomegcodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22ComboMegCodigo", AV22ComboMegCodigo);
            AV25ComboMegSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombomegsitrevista_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25ComboMegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboMegSitRevista), 3, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"MotivoEgresoRevistaAfip");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) || ( A1601MegSitRevista != Z1601MegSitRevista ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("motivoegresorevistaafip:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A11MegCodigo = httpContext.GetPar( "MegCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
               A1601MegSitRevista = (short)(GXutil.lval( httpContext.GetPar( "MegSitRevista"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
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
                  sMode220 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode220 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound220 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_520( ) ;
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
                        e11522 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12522 ();
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
         e12522 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll52220( ) ;
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
         disableAttributes52220( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomegcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomegcodigo_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomegsitrevista_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomegsitrevista_Enabled), 5, 0), true);
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

   public void confirm_520( )
   {
      beforeValidate52220( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls52220( ) ;
         }
         else
         {
            checkExtendedTable52220( ) ;
            closeExtendedTableCursors52220( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption520( )
   {
   }

   public void e11522( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV16DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV16DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtMegSitRevista_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMegSitRevista_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegSitRevista_Visible), 5, 0), true);
      AV25ComboMegSitRevista = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboMegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboMegSitRevista), 3, 0));
      edtavCombomegsitrevista_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomegsitrevista_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomegsitrevista_Visible), 5, 0), true);
      edtMegCodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Visible), 5, 0), true);
      AV22ComboMegCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboMegCodigo", AV22ComboMegCodigo);
      edtavCombomegcodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomegcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomegcodigo_Visible), 5, 0), true);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      AV20ComboCliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCliCod), 6, 0));
      edtavComboclicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCLICOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMEGCODIGO' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMEGSITREVISTA' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV11IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgresoRevistaAfip_Insert", GXv_boolean5) ;
         motivoegresorevistaafip_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgresoRevistaAfip_Update", GXv_boolean5) ;
         motivoegresorevistaafip_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgresoRevistaAfip_Delete", GXv_boolean5) ;
         motivoegresorevistaafip_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV27Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
   }

   public void e12522( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S132( )
   {
      /* 'LOADCOMBOMEGSITREVISTA' Routine */
      returnInSub = false ;
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char7[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new web.motivoegresorevistaafiploaddvcombo(remoteHandle, context).execute( "MegSitRevista", Gx_mode, false, AV7CliCod, AV8MegCodigo, AV9MegSitRevista, A3CliCod, "", GXv_char7, GXv_char8, GXv_char9) ;
      motivoegresorevistaafip_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
      motivoegresorevistaafip_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      motivoegresorevistaafip_impl.this.GXt_char6 = GXv_char9[0] ;
      AV19Combo_DataJson = GXt_char6 ;
      Combo_megsitrevista_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_megsitrevista.sendProperty(context, "", false, Combo_megsitrevista_Internalname, "SelectedValue_set", Combo_megsitrevista_Selectedvalue_set);
      Combo_megsitrevista_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_megsitrevista.sendProperty(context, "", false, Combo_megsitrevista_Internalname, "SelectedText_set", Combo_megsitrevista_Selectedtext_set);
      AV25ComboMegSitRevista = (short)(GXutil.lval( AV17ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboMegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboMegSitRevista), 3, 0));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (0==AV9MegSitRevista) )
      {
         Combo_megsitrevista_Enabled = false ;
         ucCombo_megsitrevista.sendProperty(context, "", false, Combo_megsitrevista_Internalname, "Enabled", GXutil.booltostr( Combo_megsitrevista_Enabled));
      }
   }

   public void S122( )
   {
      /* 'LOADCOMBOMEGCODIGO' Routine */
      returnInSub = false ;
      Combo_megcodigo_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"MegCodigo\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"MegCodigo\": \"\", \"MegSitRevista\": 0, \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_megcodigo.sendProperty(context, "", false, Combo_megcodigo_Internalname, "DataListProcParametersPrefix", Combo_megcodigo_Datalistprocparametersprefix);
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char9[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.motivoegresorevistaafiploaddvcombo(remoteHandle, context).execute( "MegCodigo", Gx_mode, false, AV7CliCod, AV8MegCodigo, AV9MegSitRevista, A3CliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      motivoegresorevistaafip_impl.this.AV17ComboSelectedValue = GXv_char9[0] ;
      motivoegresorevistaafip_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      motivoegresorevistaafip_impl.this.GXt_char6 = GXv_char7[0] ;
      AV19Combo_DataJson = GXt_char6 ;
      Combo_megcodigo_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_megcodigo.sendProperty(context, "", false, Combo_megcodigo_Internalname, "SelectedValue_set", Combo_megcodigo_Selectedvalue_set);
      Combo_megcodigo_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_megcodigo.sendProperty(context, "", false, Combo_megcodigo_Internalname, "SelectedText_set", Combo_megcodigo_Selectedtext_set);
      AV22ComboMegCodigo = AV17ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboMegCodigo", AV22ComboMegCodigo);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV8MegCodigo)==0) )
      {
         Combo_megcodigo_Enabled = false ;
         ucCombo_megcodigo.sendProperty(context, "", false, Combo_megcodigo_Internalname, "Enabled", GXutil.booltostr( Combo_megcodigo_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOCLICOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char9[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.motivoegresorevistaafiploaddvcombo(remoteHandle, context).execute( "CliCod", Gx_mode, false, AV7CliCod, AV8MegCodigo, AV9MegSitRevista, A3CliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      motivoegresorevistaafip_impl.this.AV17ComboSelectedValue = GXv_char9[0] ;
      motivoegresorevistaafip_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      motivoegresorevistaafip_impl.this.GXt_char6 = GXv_char7[0] ;
      AV19Combo_DataJson = GXt_char6 ;
      Combo_clicod_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "SelectedValue_set", Combo_clicod_Selectedvalue_set);
      Combo_clicod_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "SelectedText_set", Combo_clicod_Selectedtext_set);
      AV20ComboCliCod = (int)(GXutil.lval( AV17ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCliCod), 6, 0));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (0==AV7CliCod) )
      {
         Combo_clicod_Enabled = false ;
         ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "Enabled", GXutil.booltostr( Combo_clicod_Enabled));
      }
   }

   public void zm52220( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1606MegSitRevDef = T00523_A1606MegSitRevDef[0] ;
         }
         else
         {
            Z1606MegSitRevDef = A1606MegSitRevDef ;
         }
      }
      if ( GX_JID == -10 )
      {
         Z1606MegSitRevDef = A1606MegSitRevDef ;
         Z3CliCod = A3CliCod ;
         Z11MegCodigo = A11MegCodigo ;
         Z1601MegSitRevista = A1601MegSitRevista ;
         Z300MegDescrip = A300MegDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
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
      if ( ! (GXutil.strcmp("", AV8MegCodigo)==0) )
      {
         edtMegCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtMegCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8MegCodigo)==0) )
      {
         edtMegCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9MegSitRevista) )
      {
         edtMegSitRevista_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMegSitRevista_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegSitRevista_Enabled), 5, 0), true);
      }
      else
      {
         edtMegSitRevista_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMegSitRevista_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegSitRevista_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9MegSitRevista) )
      {
         edtMegSitRevista_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMegSitRevista_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegSitRevista_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9MegSitRevista) )
      {
         A1601MegSitRevista = AV9MegSitRevista ;
         httpContext.ajax_rsp_assign_attri("", false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
      }
      else
      {
         A1601MegSitRevista = AV25ComboMegSitRevista ;
         httpContext.ajax_rsp_assign_attri("", false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
      }
      if ( ! (GXutil.strcmp("", AV8MegCodigo)==0) )
      {
         A11MegCodigo = AV8MegCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
      }
      else
      {
         A11MegCodigo = AV22ComboMegCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
      }
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         A3CliCod = AV20ComboCliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
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
         AV27Pgmname = "MotivoEgresoRevistaAfip" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
         /* Using cursor T00524 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
         A300MegDescrip = T00524_A300MegDescrip[0] ;
         pr_default.close(2);
      }
   }

   public void load52220( )
   {
      /* Using cursor T00526 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound220 = (short)(1) ;
         A1606MegSitRevDef = T00526_A1606MegSitRevDef[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1606MegSitRevDef", A1606MegSitRevDef);
         A300MegDescrip = T00526_A300MegDescrip[0] ;
         zm52220( -10) ;
      }
      pr_default.close(4);
      onLoadActions52220( ) ;
   }

   public void onLoadActions52220( )
   {
      AV27Pgmname = "MotivoEgresoRevistaAfip" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
   }

   public void checkExtendedTable52220( )
   {
      nIsDirty_220 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV27Pgmname = "MotivoEgresoRevistaAfip" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
      /* Using cursor T00524 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MEGCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A300MegDescrip = T00524_A300MegDescrip[0] ;
      pr_default.close(2);
      /* Using cursor T00525 */
      pr_default.execute(3, new Object[] {Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso Revista Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MEGSITREVISTA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMegSitRevista_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
   }

   public void closeExtendedTableCursors52220( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_11( int A3CliCod ,
                          String A11MegCodigo )
   {
      /* Using cursor T00527 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MEGCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A300MegDescrip = T00527_A300MegDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A300MegDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_12( short A1601MegSitRevista )
   {
      /* Using cursor T00528 */
      pr_default.execute(6, new Object[] {Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso Revista Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MEGSITREVISTA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMegSitRevista_Internalname ;
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

   public void getKey52220( )
   {
      /* Using cursor T00529 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound220 = (short)(1) ;
      }
      else
      {
         RcdFound220 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00523 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm52220( 10) ;
         RcdFound220 = (short)(1) ;
         A1606MegSitRevDef = T00523_A1606MegSitRevDef[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1606MegSitRevDef", A1606MegSitRevDef);
         A3CliCod = T00523_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A11MegCodigo = T00523_A11MegCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         A1601MegSitRevista = T00523_A1601MegSitRevista[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
         Z3CliCod = A3CliCod ;
         Z11MegCodigo = A11MegCodigo ;
         Z1601MegSitRevista = A1601MegSitRevista ;
         sMode220 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load52220( ) ;
         if ( AnyError == 1 )
         {
            RcdFound220 = (short)(0) ;
            initializeNonKey52220( ) ;
         }
         Gx_mode = sMode220 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound220 = (short)(0) ;
         initializeNonKey52220( ) ;
         sMode220 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode220 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey52220( ) ;
      if ( RcdFound220 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound220 = (short)(0) ;
      /* Using cursor T005210 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A11MegCodigo, A11MegCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T005210_A3CliCod[0] < A3CliCod ) || ( T005210_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005210_A11MegCodigo[0], A11MegCodigo) < 0 ) || ( GXutil.strcmp(T005210_A11MegCodigo[0], A11MegCodigo) == 0 ) && ( T005210_A3CliCod[0] == A3CliCod ) && ( T005210_A1601MegSitRevista[0] < A1601MegSitRevista ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T005210_A3CliCod[0] > A3CliCod ) || ( T005210_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005210_A11MegCodigo[0], A11MegCodigo) > 0 ) || ( GXutil.strcmp(T005210_A11MegCodigo[0], A11MegCodigo) == 0 ) && ( T005210_A3CliCod[0] == A3CliCod ) && ( T005210_A1601MegSitRevista[0] > A1601MegSitRevista ) ) )
         {
            A3CliCod = T005210_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A11MegCodigo = T005210_A11MegCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
            A1601MegSitRevista = T005210_A1601MegSitRevista[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
            RcdFound220 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound220 = (short)(0) ;
      /* Using cursor T005211 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A11MegCodigo, A11MegCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T005211_A3CliCod[0] > A3CliCod ) || ( T005211_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005211_A11MegCodigo[0], A11MegCodigo) > 0 ) || ( GXutil.strcmp(T005211_A11MegCodigo[0], A11MegCodigo) == 0 ) && ( T005211_A3CliCod[0] == A3CliCod ) && ( T005211_A1601MegSitRevista[0] > A1601MegSitRevista ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T005211_A3CliCod[0] < A3CliCod ) || ( T005211_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005211_A11MegCodigo[0], A11MegCodigo) < 0 ) || ( GXutil.strcmp(T005211_A11MegCodigo[0], A11MegCodigo) == 0 ) && ( T005211_A3CliCod[0] == A3CliCod ) && ( T005211_A1601MegSitRevista[0] < A1601MegSitRevista ) ) )
         {
            A3CliCod = T005211_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A11MegCodigo = T005211_A11MegCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
            A1601MegSitRevista = T005211_A1601MegSitRevista[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
            RcdFound220 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey52220( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert52220( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound220 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) || ( A1601MegSitRevista != Z1601MegSitRevista ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A11MegCodigo = Z11MegCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
               A1601MegSitRevista = Z1601MegSitRevista ;
               httpContext.ajax_rsp_assign_attri("", false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update52220( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) || ( A1601MegSitRevista != Z1601MegSitRevista ) )
            {
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert52220( ) ;
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
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert52220( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) || ( A1601MegSitRevista != Z1601MegSitRevista ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A11MegCodigo = Z11MegCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         A1601MegSitRevista = Z1601MegSitRevista ;
         httpContext.ajax_rsp_assign_attri("", false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency52220( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00522 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MotivoEgresoRevistaAfip"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z1606MegSitRevDef != T00522_A1606MegSitRevDef[0] ) )
         {
            if ( Z1606MegSitRevDef != T00522_A1606MegSitRevDef[0] )
            {
               GXutil.writeLogln("motivoegresorevistaafip:[seudo value changed for attri]"+"MegSitRevDef");
               GXutil.writeLogRaw("Old: ",Z1606MegSitRevDef);
               GXutil.writeLogRaw("Current: ",T00522_A1606MegSitRevDef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"MotivoEgresoRevistaAfip"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert52220( )
   {
      beforeValidate52220( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable52220( ) ;
      }
      if ( AnyError == 0 )
      {
         zm52220( 0) ;
         checkOptimisticConcurrency52220( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm52220( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert52220( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005212 */
                  pr_default.execute(10, new Object[] {Boolean.valueOf(A1606MegSitRevDef), Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgresoRevistaAfip");
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
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption520( ) ;
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
            load52220( ) ;
         }
         endLevel52220( ) ;
      }
      closeExtendedTableCursors52220( ) ;
   }

   public void update52220( )
   {
      beforeValidate52220( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable52220( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency52220( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm52220( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate52220( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005213 */
                  pr_default.execute(11, new Object[] {Boolean.valueOf(A1606MegSitRevDef), Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgresoRevistaAfip");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MotivoEgresoRevistaAfip"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate52220( ) ;
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
         endLevel52220( ) ;
      }
      closeExtendedTableCursors52220( ) ;
   }

   public void deferredUpdate52220( )
   {
   }

   public void delete( )
   {
      beforeValidate52220( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency52220( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls52220( ) ;
         afterConfirm52220( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete52220( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005214 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgresoRevistaAfip");
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
      sMode220 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel52220( ) ;
      Gx_mode = sMode220 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls52220( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV27Pgmname = "MotivoEgresoRevistaAfip" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
         /* Using cursor T005215 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
         A300MegDescrip = T005215_A300MegDescrip[0] ;
         pr_default.close(13);
      }
   }

   public void endLevel52220( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete52220( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "motivoegresorevistaafip");
         if ( AnyError == 0 )
         {
            confirmValues520( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "motivoegresorevistaafip");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart52220( )
   {
      /* Scan By routine */
      /* Using cursor T005216 */
      pr_default.execute(14);
      RcdFound220 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound220 = (short)(1) ;
         A3CliCod = T005216_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A11MegCodigo = T005216_A11MegCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         A1601MegSitRevista = T005216_A1601MegSitRevista[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext52220( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound220 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound220 = (short)(1) ;
         A3CliCod = T005216_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A11MegCodigo = T005216_A11MegCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         A1601MegSitRevista = T005216_A1601MegSitRevista[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
      }
   }

   public void scanEnd52220( )
   {
      pr_default.close(14);
   }

   public void afterConfirm52220( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert52220( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate52220( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete52220( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete52220( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate52220( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes52220( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtMegCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), true);
      edtMegSitRevista_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMegSitRevista_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegSitRevista_Enabled), 5, 0), true);
      chkMegSitRevDef.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMegSitRevDef.getInternalname(), "Enabled", GXutil.ltrimstr( chkMegSitRevDef.getEnabled(), 5, 0), true);
      edtavComboclicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Enabled), 5, 0), true);
      edtavCombomegcodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomegcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomegcodigo_Enabled), 5, 0), true);
      edtavCombomegsitrevista_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomegsitrevista_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomegsitrevista_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes52220( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues520( )
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.motivoegresorevistaafip", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8MegCodigo)),GXutil.URLEncode(GXutil.ltrimstr(AV9MegSitRevista,3,0))}, new String[] {"Gx_mode","CliCod","MegCodigo","MegSitRevista"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"MotivoEgresoRevistaAfip");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("motivoegresorevistaafip:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z11MegCodigo", GXutil.rtrim( Z11MegCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1601MegSitRevista", GXutil.ltrim( localUtil.ntoc( Z1601MegSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1606MegSitRevDef", Z1606MegSitRevDef);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLICOD_DATA", AV15CliCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLICOD_DATA", AV15CliCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMEGCODIGO_DATA", AV21MegCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMEGCODIGO_DATA", AV21MegCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMEGSITREVISTA_DATA", AV24MegSitRevista_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMEGSITREVISTA_DATA", AV24MegSitRevista_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCOND_CLICOD", GXutil.ltrim( localUtil.ntoc( AV23Cond_CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMEGCODIGO", GXutil.rtrim( AV8MegCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMEGCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8MegCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMEGSITREVISTA", GXutil.ltrim( localUtil.ntoc( AV9MegSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMEGSITREVISTA", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9MegSitRevista), "ZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "MEGDESCRIP", A300MegDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV27Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Objectcall", GXutil.rtrim( Combo_clicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Cls", GXutil.rtrim( Combo_clicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Selectedvalue_set", GXutil.rtrim( Combo_clicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Selectedtext_set", GXutil.rtrim( Combo_clicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Enabled", GXutil.booltostr( Combo_clicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Datalistproc", GXutil.rtrim( Combo_clicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_clicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Emptyitem", GXutil.booltostr( Combo_clicod_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Objectcall", GXutil.rtrim( Combo_megcodigo_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Cls", GXutil.rtrim( Combo_megcodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_megcodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Selectedtext_set", GXutil.rtrim( Combo_megcodigo_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Enabled", GXutil.booltostr( Combo_megcodigo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Datalistproc", GXutil.rtrim( Combo_megcodigo_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Datalistprocparametersprefix", GXutil.rtrim( Combo_megcodigo_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGCODIGO_Emptyitem", GXutil.booltostr( Combo_megcodigo_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGSITREVISTA_Objectcall", GXutil.rtrim( Combo_megsitrevista_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGSITREVISTA_Cls", GXutil.rtrim( Combo_megsitrevista_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGSITREVISTA_Selectedvalue_set", GXutil.rtrim( Combo_megsitrevista_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGSITREVISTA_Selectedtext_set", GXutil.rtrim( Combo_megsitrevista_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGSITREVISTA_Enabled", GXutil.booltostr( Combo_megsitrevista_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGSITREVISTA_Datalistproc", GXutil.rtrim( Combo_megsitrevista_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGSITREVISTA_Datalistprocparametersprefix", GXutil.rtrim( Combo_megsitrevista_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEGSITREVISTA_Emptyitem", GXutil.booltostr( Combo_megsitrevista_Emptyitem));
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
      return formatLink("web.motivoegresorevistaafip", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8MegCodigo)),GXutil.URLEncode(GXutil.ltrimstr(AV9MegSitRevista,3,0))}, new String[] {"Gx_mode","CliCod","MegCodigo","MegSitRevista"})  ;
   }

   public String getPgmname( )
   {
      return "MotivoEgresoRevistaAfip" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Motivo Egreso Revista Afip", "") ;
   }

   public void initializeNonKey52220( )
   {
      A1606MegSitRevDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1606MegSitRevDef", A1606MegSitRevDef);
      A300MegDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A300MegDescrip", A300MegDescrip);
      Z1606MegSitRevDef = false ;
   }

   public void initAll52220( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A11MegCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
      A1601MegSitRevista = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1601MegSitRevista", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1601MegSitRevista), 3, 0));
      initializeNonKey52220( ) ;
   }

   public void standaloneModalInsert( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020294056", true, true);
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
      httpContext.AddJavascriptSource("motivoegresorevistaafip.js", "?2024122020294056", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      lblTextblockclicod_Internalname = "TEXTBLOCKCLICOD" ;
      Combo_clicod_Internalname = "COMBO_CLICOD" ;
      edtCliCod_Internalname = "CLICOD" ;
      divTablesplittedclicod_Internalname = "TABLESPLITTEDCLICOD" ;
      lblTextblockmegcodigo_Internalname = "TEXTBLOCKMEGCODIGO" ;
      Combo_megcodigo_Internalname = "COMBO_MEGCODIGO" ;
      edtMegCodigo_Internalname = "MEGCODIGO" ;
      divTablesplittedmegcodigo_Internalname = "TABLESPLITTEDMEGCODIGO" ;
      lblTextblockmegsitrevista_Internalname = "TEXTBLOCKMEGSITREVISTA" ;
      Combo_megsitrevista_Internalname = "COMBO_MEGSITREVISTA" ;
      edtMegSitRevista_Internalname = "MEGSITREVISTA" ;
      divTablesplittedmegsitrevista_Internalname = "TABLESPLITTEDMEGSITREVISTA" ;
      chkMegSitRevDef.setInternalname( "MEGSITREVDEF" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboclicod_Internalname = "vCOMBOCLICOD" ;
      divSectionattribute_clicod_Internalname = "SECTIONATTRIBUTE_CLICOD" ;
      edtavCombomegcodigo_Internalname = "vCOMBOMEGCODIGO" ;
      divSectionattribute_megcodigo_Internalname = "SECTIONATTRIBUTE_MEGCODIGO" ;
      edtavCombomegsitrevista_Internalname = "vCOMBOMEGSITREVISTA" ;
      divSectionattribute_megsitrevista_Internalname = "SECTIONATTRIBUTE_MEGSITREVISTA" ;
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
      Form.setCaption( httpContext.getMessage( "Motivo Egreso Revista Afip", "") );
      Combo_megcodigo_Datalistprocparametersprefix = "" ;
      edtavCombomegsitrevista_Jsonclick = "" ;
      edtavCombomegsitrevista_Enabled = 0 ;
      edtavCombomegsitrevista_Visible = 1 ;
      edtavCombomegcodigo_Jsonclick = "" ;
      edtavCombomegcodigo_Enabled = 0 ;
      edtavCombomegcodigo_Visible = 1 ;
      edtavComboclicod_Jsonclick = "" ;
      edtavComboclicod_Enabled = 0 ;
      edtavComboclicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkMegSitRevDef.setEnabled( 1 );
      edtMegSitRevista_Jsonclick = "" ;
      edtMegSitRevista_Enabled = 1 ;
      edtMegSitRevista_Visible = 1 ;
      Combo_megsitrevista_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_megsitrevista_Datalistprocparametersprefix = " \"ComboName\": \"MegSitRevista\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"MegCodigo\": \"\", \"MegSitRevista\": 0" ;
      Combo_megsitrevista_Datalistproc = "MotivoEgresoRevistaAfipLoadDVCombo" ;
      Combo_megsitrevista_Cls = "ExtendedCombo Attribute" ;
      Combo_megsitrevista_Caption = "" ;
      Combo_megsitrevista_Enabled = GXutil.toBoolean( -1) ;
      edtMegCodigo_Jsonclick = "" ;
      edtMegCodigo_Enabled = 1 ;
      edtMegCodigo_Visible = 1 ;
      Combo_megcodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_megcodigo_Datalistproc = "MotivoEgresoRevistaAfipLoadDVCombo" ;
      Combo_megcodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_megcodigo_Caption = "" ;
      Combo_megcodigo_Enabled = GXutil.toBoolean( -1) ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      Combo_clicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_clicod_Datalistprocparametersprefix = " \"ComboName\": \"CliCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"MegCodigo\": \"\", \"MegSitRevista\": 0" ;
      Combo_clicod_Datalistproc = "MotivoEgresoRevistaAfipLoadDVCombo" ;
      Combo_clicod_Cls = "ExtendedCombo Attribute" ;
      Combo_clicod_Caption = "" ;
      Combo_clicod_Enabled = GXutil.toBoolean( -1) ;
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

   public void init_web_controls( )
   {
      chkMegSitRevDef.setName( "MEGSITREVDEF" );
      chkMegSitRevDef.setWebtags( "" );
      chkMegSitRevDef.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMegSitRevDef.getInternalname(), "TitleCaption", chkMegSitRevDef.getCaption(), true);
      chkMegSitRevDef.setCheckedValue( "false" );
      A1606MegSitRevDef = GXutil.strtobool( GXutil.booltostr( A1606MegSitRevDef)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1606MegSitRevDef", A1606MegSitRevDef);
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

   public void valid_Megcodigo( )
   {
      /* Using cursor T005215 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MEGCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A300MegDescrip = T005215_A300MegDescrip[0] ;
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A300MegDescrip", A300MegDescrip);
   }

   public void valid_Megsitrevista( )
   {
      /* Using cursor T005217 */
      pr_default.execute(15, new Object[] {Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso Revista Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MEGSITREVISTA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMegSitRevista_Internalname ;
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8MegCodigo',fld:'vMEGCODIGO',pic:'',hsh:true},{av:'AV9MegSitRevista',fld:'vMEGSITREVISTA',pic:'ZZ9',hsh:true},{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8MegCodigo',fld:'vMEGCODIGO',pic:'',hsh:true},{av:'AV9MegSitRevista',fld:'vMEGSITREVISTA',pic:'ZZ9',hsh:true},{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e12522',iparms:[{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]}");
      setEventMetadata("VALID_MEGCODIGO","{handler:'valid_Megcodigo',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A11MegCodigo',fld:'MEGCODIGO',pic:''},{av:'A300MegDescrip',fld:'MEGDESCRIP',pic:''},{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]");
      setEventMetadata("VALID_MEGCODIGO",",oparms:[{av:'A300MegDescrip',fld:'MEGDESCRIP',pic:''},{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]}");
      setEventMetadata("VALID_MEGSITREVISTA","{handler:'valid_Megsitrevista',iparms:[{av:'A1601MegSitRevista',fld:'MEGSITREVISTA',pic:'ZZ9'},{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]");
      setEventMetadata("VALID_MEGSITREVISTA",",oparms:[{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCLICOD","{handler:'validv_Comboclicod',iparms:[{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]");
      setEventMetadata("VALIDV_COMBOCLICOD",",oparms:[{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]}");
      setEventMetadata("VALIDV_COMBOMEGCODIGO","{handler:'validv_Combomegcodigo',iparms:[{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]");
      setEventMetadata("VALIDV_COMBOMEGCODIGO",",oparms:[{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]}");
      setEventMetadata("VALIDV_COMBOMEGSITREVISTA","{handler:'validv_Combomegsitrevista',iparms:[{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]");
      setEventMetadata("VALIDV_COMBOMEGSITREVISTA",",oparms:[{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''}]}");
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
      pr_default.close(15);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8MegCodigo = "" ;
      Z11MegCodigo = "" ;
      Combo_megsitrevista_Selectedvalue_get = "" ;
      Combo_megcodigo_Selectedvalue_get = "" ;
      Combo_clicod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A11MegCodigo = "" ;
      Gx_mode = "" ;
      AV8MegCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockclicod_Jsonclick = "" ;
      ucCombo_clicod = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15CliCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      lblTextblockmegcodigo_Jsonclick = "" ;
      ucCombo_megcodigo = new com.genexus.webpanels.GXUserControl();
      AV21MegCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockmegsitrevista_Jsonclick = "" ;
      ucCombo_megsitrevista = new com.genexus.webpanels.GXUserControl();
      AV24MegSitRevista_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV22ComboMegCodigo = "" ;
      A300MegDescrip = "" ;
      AV27Pgmname = "" ;
      Combo_clicod_Objectcall = "" ;
      Combo_clicod_Class = "" ;
      Combo_clicod_Icontype = "" ;
      Combo_clicod_Icon = "" ;
      Combo_clicod_Tooltip = "" ;
      Combo_clicod_Selectedvalue_set = "" ;
      Combo_clicod_Selectedtext_set = "" ;
      Combo_clicod_Selectedtext_get = "" ;
      Combo_clicod_Gamoauthtoken = "" ;
      Combo_clicod_Ddointernalname = "" ;
      Combo_clicod_Titlecontrolalign = "" ;
      Combo_clicod_Dropdownoptionstype = "" ;
      Combo_clicod_Titlecontrolidtoreplace = "" ;
      Combo_clicod_Datalisttype = "" ;
      Combo_clicod_Datalistfixedvalues = "" ;
      Combo_clicod_Remoteservicesparameters = "" ;
      Combo_clicod_Htmltemplate = "" ;
      Combo_clicod_Multiplevaluestype = "" ;
      Combo_clicod_Loadingdata = "" ;
      Combo_clicod_Noresultsfound = "" ;
      Combo_clicod_Emptyitemtext = "" ;
      Combo_clicod_Onlyselectedvalues = "" ;
      Combo_clicod_Selectalltext = "" ;
      Combo_clicod_Multiplevaluesseparator = "" ;
      Combo_clicod_Addnewoptiontext = "" ;
      Combo_megcodigo_Objectcall = "" ;
      Combo_megcodigo_Class = "" ;
      Combo_megcodigo_Icontype = "" ;
      Combo_megcodigo_Icon = "" ;
      Combo_megcodigo_Tooltip = "" ;
      Combo_megcodigo_Selectedvalue_set = "" ;
      Combo_megcodigo_Selectedtext_set = "" ;
      Combo_megcodigo_Selectedtext_get = "" ;
      Combo_megcodigo_Gamoauthtoken = "" ;
      Combo_megcodigo_Ddointernalname = "" ;
      Combo_megcodigo_Titlecontrolalign = "" ;
      Combo_megcodigo_Dropdownoptionstype = "" ;
      Combo_megcodigo_Titlecontrolidtoreplace = "" ;
      Combo_megcodigo_Datalisttype = "" ;
      Combo_megcodigo_Datalistfixedvalues = "" ;
      Combo_megcodigo_Remoteservicesparameters = "" ;
      Combo_megcodigo_Htmltemplate = "" ;
      Combo_megcodigo_Multiplevaluestype = "" ;
      Combo_megcodigo_Loadingdata = "" ;
      Combo_megcodigo_Noresultsfound = "" ;
      Combo_megcodigo_Emptyitemtext = "" ;
      Combo_megcodigo_Onlyselectedvalues = "" ;
      Combo_megcodigo_Selectalltext = "" ;
      Combo_megcodigo_Multiplevaluesseparator = "" ;
      Combo_megcodigo_Addnewoptiontext = "" ;
      Combo_megsitrevista_Objectcall = "" ;
      Combo_megsitrevista_Class = "" ;
      Combo_megsitrevista_Icontype = "" ;
      Combo_megsitrevista_Icon = "" ;
      Combo_megsitrevista_Tooltip = "" ;
      Combo_megsitrevista_Selectedvalue_set = "" ;
      Combo_megsitrevista_Selectedtext_set = "" ;
      Combo_megsitrevista_Selectedtext_get = "" ;
      Combo_megsitrevista_Gamoauthtoken = "" ;
      Combo_megsitrevista_Ddointernalname = "" ;
      Combo_megsitrevista_Titlecontrolalign = "" ;
      Combo_megsitrevista_Dropdownoptionstype = "" ;
      Combo_megsitrevista_Titlecontrolidtoreplace = "" ;
      Combo_megsitrevista_Datalisttype = "" ;
      Combo_megsitrevista_Datalistfixedvalues = "" ;
      Combo_megsitrevista_Remoteservicesparameters = "" ;
      Combo_megsitrevista_Htmltemplate = "" ;
      Combo_megsitrevista_Multiplevaluestype = "" ;
      Combo_megsitrevista_Loadingdata = "" ;
      Combo_megsitrevista_Noresultsfound = "" ;
      Combo_megsitrevista_Emptyitemtext = "" ;
      Combo_megsitrevista_Onlyselectedvalues = "" ;
      Combo_megsitrevista_Selectalltext = "" ;
      Combo_megsitrevista_Multiplevaluesseparator = "" ;
      Combo_megsitrevista_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode220 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      AV19Combo_DataJson = "" ;
      AV17ComboSelectedValue = "" ;
      AV18ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z300MegDescrip = "" ;
      T00524_A300MegDescrip = new String[] {""} ;
      T00526_A1606MegSitRevDef = new boolean[] {false} ;
      T00526_A300MegDescrip = new String[] {""} ;
      T00526_A3CliCod = new int[1] ;
      T00526_A11MegCodigo = new String[] {""} ;
      T00526_A1601MegSitRevista = new short[1] ;
      T00525_A1601MegSitRevista = new short[1] ;
      T00527_A300MegDescrip = new String[] {""} ;
      T00528_A1601MegSitRevista = new short[1] ;
      T00529_A3CliCod = new int[1] ;
      T00529_A11MegCodigo = new String[] {""} ;
      T00529_A1601MegSitRevista = new short[1] ;
      T00523_A1606MegSitRevDef = new boolean[] {false} ;
      T00523_A3CliCod = new int[1] ;
      T00523_A11MegCodigo = new String[] {""} ;
      T00523_A1601MegSitRevista = new short[1] ;
      T005210_A3CliCod = new int[1] ;
      T005210_A11MegCodigo = new String[] {""} ;
      T005210_A1601MegSitRevista = new short[1] ;
      T005211_A3CliCod = new int[1] ;
      T005211_A11MegCodigo = new String[] {""} ;
      T005211_A1601MegSitRevista = new short[1] ;
      T00522_A1606MegSitRevDef = new boolean[] {false} ;
      T00522_A3CliCod = new int[1] ;
      T00522_A11MegCodigo = new String[] {""} ;
      T00522_A1601MegSitRevista = new short[1] ;
      T005215_A300MegDescrip = new String[] {""} ;
      T005216_A3CliCod = new int[1] ;
      T005216_A11MegCodigo = new String[] {""} ;
      T005216_A1601MegSitRevista = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T005217_A1601MegSitRevista = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.motivoegresorevistaafip__default(),
         new Object[] {
             new Object[] {
            T00522_A1606MegSitRevDef, T00522_A3CliCod, T00522_A11MegCodigo, T00522_A1601MegSitRevista
            }
            , new Object[] {
            T00523_A1606MegSitRevDef, T00523_A3CliCod, T00523_A11MegCodigo, T00523_A1601MegSitRevista
            }
            , new Object[] {
            T00524_A300MegDescrip
            }
            , new Object[] {
            T00525_A1601MegSitRevista
            }
            , new Object[] {
            T00526_A1606MegSitRevDef, T00526_A300MegDescrip, T00526_A3CliCod, T00526_A11MegCodigo, T00526_A1601MegSitRevista
            }
            , new Object[] {
            T00527_A300MegDescrip
            }
            , new Object[] {
            T00528_A1601MegSitRevista
            }
            , new Object[] {
            T00529_A3CliCod, T00529_A11MegCodigo, T00529_A1601MegSitRevista
            }
            , new Object[] {
            T005210_A3CliCod, T005210_A11MegCodigo, T005210_A1601MegSitRevista
            }
            , new Object[] {
            T005211_A3CliCod, T005211_A11MegCodigo, T005211_A1601MegSitRevista
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005215_A300MegDescrip
            }
            , new Object[] {
            T005216_A3CliCod, T005216_A11MegCodigo, T005216_A1601MegSitRevista
            }
            , new Object[] {
            T005217_A1601MegSitRevista
            }
         }
      );
      AV27Pgmname = "MotivoEgresoRevistaAfip" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV9MegSitRevista ;
   private short Z1601MegSitRevista ;
   private short A1601MegSitRevista ;
   private short AV9MegSitRevista ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV25ComboMegSitRevista ;
   private short RcdFound220 ;
   private short nIsDirty_220 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int AV7CliCod ;
   private int trnEnded ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtMegCodigo_Visible ;
   private int edtMegCodigo_Enabled ;
   private int edtMegSitRevista_Visible ;
   private int edtMegSitRevista_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int AV20ComboCliCod ;
   private int edtavComboclicod_Enabled ;
   private int edtavComboclicod_Visible ;
   private int edtavCombomegcodigo_Visible ;
   private int edtavCombomegcodigo_Enabled ;
   private int edtavCombomegsitrevista_Enabled ;
   private int edtavCombomegsitrevista_Visible ;
   private int AV23Cond_CliCod ;
   private int Combo_clicod_Datalistupdateminimumcharacters ;
   private int Combo_megcodigo_Datalistupdateminimumcharacters ;
   private int Combo_megsitrevista_Datalistupdateminimumcharacters ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8MegCodigo ;
   private String Z11MegCodigo ;
   private String Combo_megsitrevista_Selectedvalue_get ;
   private String Combo_megcodigo_Selectedvalue_get ;
   private String Combo_clicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A11MegCodigo ;
   private String Gx_mode ;
   private String AV8MegCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliCod_Internalname ;
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
   private String divTablesplittedclicod_Internalname ;
   private String lblTextblockclicod_Internalname ;
   private String lblTextblockclicod_Jsonclick ;
   private String Combo_clicod_Caption ;
   private String Combo_clicod_Cls ;
   private String Combo_clicod_Datalistproc ;
   private String Combo_clicod_Datalistprocparametersprefix ;
   private String Combo_clicod_Internalname ;
   private String TempTags ;
   private String edtCliCod_Jsonclick ;
   private String divTablesplittedmegcodigo_Internalname ;
   private String lblTextblockmegcodigo_Internalname ;
   private String lblTextblockmegcodigo_Jsonclick ;
   private String Combo_megcodigo_Caption ;
   private String Combo_megcodigo_Cls ;
   private String Combo_megcodigo_Datalistproc ;
   private String Combo_megcodigo_Internalname ;
   private String edtMegCodigo_Internalname ;
   private String edtMegCodigo_Jsonclick ;
   private String divTablesplittedmegsitrevista_Internalname ;
   private String lblTextblockmegsitrevista_Internalname ;
   private String lblTextblockmegsitrevista_Jsonclick ;
   private String Combo_megsitrevista_Caption ;
   private String Combo_megsitrevista_Cls ;
   private String Combo_megsitrevista_Datalistproc ;
   private String Combo_megsitrevista_Datalistprocparametersprefix ;
   private String Combo_megsitrevista_Internalname ;
   private String edtMegSitRevista_Internalname ;
   private String edtMegSitRevista_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_clicod_Internalname ;
   private String edtavComboclicod_Internalname ;
   private String edtavComboclicod_Jsonclick ;
   private String divSectionattribute_megcodigo_Internalname ;
   private String edtavCombomegcodigo_Internalname ;
   private String AV22ComboMegCodigo ;
   private String edtavCombomegcodigo_Jsonclick ;
   private String divSectionattribute_megsitrevista_Internalname ;
   private String edtavCombomegsitrevista_Internalname ;
   private String edtavCombomegsitrevista_Jsonclick ;
   private String AV27Pgmname ;
   private String Combo_clicod_Objectcall ;
   private String Combo_clicod_Class ;
   private String Combo_clicod_Icontype ;
   private String Combo_clicod_Icon ;
   private String Combo_clicod_Tooltip ;
   private String Combo_clicod_Selectedvalue_set ;
   private String Combo_clicod_Selectedtext_set ;
   private String Combo_clicod_Selectedtext_get ;
   private String Combo_clicod_Gamoauthtoken ;
   private String Combo_clicod_Ddointernalname ;
   private String Combo_clicod_Titlecontrolalign ;
   private String Combo_clicod_Dropdownoptionstype ;
   private String Combo_clicod_Titlecontrolidtoreplace ;
   private String Combo_clicod_Datalisttype ;
   private String Combo_clicod_Datalistfixedvalues ;
   private String Combo_clicod_Remoteservicesparameters ;
   private String Combo_clicod_Htmltemplate ;
   private String Combo_clicod_Multiplevaluestype ;
   private String Combo_clicod_Loadingdata ;
   private String Combo_clicod_Noresultsfound ;
   private String Combo_clicod_Emptyitemtext ;
   private String Combo_clicod_Onlyselectedvalues ;
   private String Combo_clicod_Selectalltext ;
   private String Combo_clicod_Multiplevaluesseparator ;
   private String Combo_clicod_Addnewoptiontext ;
   private String Combo_megcodigo_Objectcall ;
   private String Combo_megcodigo_Class ;
   private String Combo_megcodigo_Icontype ;
   private String Combo_megcodigo_Icon ;
   private String Combo_megcodigo_Tooltip ;
   private String Combo_megcodigo_Selectedvalue_set ;
   private String Combo_megcodigo_Selectedtext_set ;
   private String Combo_megcodigo_Selectedtext_get ;
   private String Combo_megcodigo_Gamoauthtoken ;
   private String Combo_megcodigo_Ddointernalname ;
   private String Combo_megcodigo_Titlecontrolalign ;
   private String Combo_megcodigo_Dropdownoptionstype ;
   private String Combo_megcodigo_Titlecontrolidtoreplace ;
   private String Combo_megcodigo_Datalisttype ;
   private String Combo_megcodigo_Datalistfixedvalues ;
   private String Combo_megcodigo_Datalistprocparametersprefix ;
   private String Combo_megcodigo_Remoteservicesparameters ;
   private String Combo_megcodigo_Htmltemplate ;
   private String Combo_megcodigo_Multiplevaluestype ;
   private String Combo_megcodigo_Loadingdata ;
   private String Combo_megcodigo_Noresultsfound ;
   private String Combo_megcodigo_Emptyitemtext ;
   private String Combo_megcodigo_Onlyselectedvalues ;
   private String Combo_megcodigo_Selectalltext ;
   private String Combo_megcodigo_Multiplevaluesseparator ;
   private String Combo_megcodigo_Addnewoptiontext ;
   private String Combo_megsitrevista_Objectcall ;
   private String Combo_megsitrevista_Class ;
   private String Combo_megsitrevista_Icontype ;
   private String Combo_megsitrevista_Icon ;
   private String Combo_megsitrevista_Tooltip ;
   private String Combo_megsitrevista_Selectedvalue_set ;
   private String Combo_megsitrevista_Selectedtext_set ;
   private String Combo_megsitrevista_Selectedtext_get ;
   private String Combo_megsitrevista_Gamoauthtoken ;
   private String Combo_megsitrevista_Ddointernalname ;
   private String Combo_megsitrevista_Titlecontrolalign ;
   private String Combo_megsitrevista_Dropdownoptionstype ;
   private String Combo_megsitrevista_Titlecontrolidtoreplace ;
   private String Combo_megsitrevista_Datalisttype ;
   private String Combo_megsitrevista_Datalistfixedvalues ;
   private String Combo_megsitrevista_Remoteservicesparameters ;
   private String Combo_megsitrevista_Htmltemplate ;
   private String Combo_megsitrevista_Multiplevaluestype ;
   private String Combo_megsitrevista_Loadingdata ;
   private String Combo_megsitrevista_Noresultsfound ;
   private String Combo_megsitrevista_Emptyitemtext ;
   private String Combo_megsitrevista_Onlyselectedvalues ;
   private String Combo_megsitrevista_Selectalltext ;
   private String Combo_megsitrevista_Multiplevaluesseparator ;
   private String Combo_megsitrevista_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode220 ;
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
   private boolean Z1606MegSitRevDef ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A1606MegSitRevDef ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_clicod_Emptyitem ;
   private boolean Combo_megcodigo_Emptyitem ;
   private boolean Combo_megsitrevista_Emptyitem ;
   private boolean Combo_clicod_Enabled ;
   private boolean Combo_clicod_Visible ;
   private boolean Combo_clicod_Allowmultipleselection ;
   private boolean Combo_clicod_Isgriditem ;
   private boolean Combo_clicod_Hasdescription ;
   private boolean Combo_clicod_Includeonlyselectedoption ;
   private boolean Combo_clicod_Includeselectalloption ;
   private boolean Combo_clicod_Includeaddnewoption ;
   private boolean Combo_megcodigo_Enabled ;
   private boolean Combo_megcodigo_Visible ;
   private boolean Combo_megcodigo_Allowmultipleselection ;
   private boolean Combo_megcodigo_Isgriditem ;
   private boolean Combo_megcodigo_Hasdescription ;
   private boolean Combo_megcodigo_Includeonlyselectedoption ;
   private boolean Combo_megcodigo_Includeselectalloption ;
   private boolean Combo_megcodigo_Includeaddnewoption ;
   private boolean Combo_megsitrevista_Enabled ;
   private boolean Combo_megsitrevista_Visible ;
   private boolean Combo_megsitrevista_Allowmultipleselection ;
   private boolean Combo_megsitrevista_Isgriditem ;
   private boolean Combo_megsitrevista_Hasdescription ;
   private boolean Combo_megsitrevista_Includeonlyselectedoption ;
   private boolean Combo_megsitrevista_Includeselectalloption ;
   private boolean Combo_megsitrevista_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String AV19Combo_DataJson ;
   private String A300MegDescrip ;
   private String AV17ComboSelectedValue ;
   private String AV18ComboSelectedText ;
   private String Z300MegDescrip ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_clicod ;
   private com.genexus.webpanels.GXUserControl ucCombo_megcodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_megsitrevista ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkMegSitRevDef ;
   private IDataStoreProvider pr_default ;
   private String[] T00524_A300MegDescrip ;
   private boolean[] T00526_A1606MegSitRevDef ;
   private String[] T00526_A300MegDescrip ;
   private int[] T00526_A3CliCod ;
   private String[] T00526_A11MegCodigo ;
   private short[] T00526_A1601MegSitRevista ;
   private short[] T00525_A1601MegSitRevista ;
   private String[] T00527_A300MegDescrip ;
   private short[] T00528_A1601MegSitRevista ;
   private int[] T00529_A3CliCod ;
   private String[] T00529_A11MegCodigo ;
   private short[] T00529_A1601MegSitRevista ;
   private boolean[] T00523_A1606MegSitRevDef ;
   private int[] T00523_A3CliCod ;
   private String[] T00523_A11MegCodigo ;
   private short[] T00523_A1601MegSitRevista ;
   private int[] T005210_A3CliCod ;
   private String[] T005210_A11MegCodigo ;
   private short[] T005210_A1601MegSitRevista ;
   private int[] T005211_A3CliCod ;
   private String[] T005211_A11MegCodigo ;
   private short[] T005211_A1601MegSitRevista ;
   private boolean[] T00522_A1606MegSitRevDef ;
   private int[] T00522_A3CliCod ;
   private String[] T00522_A11MegCodigo ;
   private short[] T00522_A1601MegSitRevista ;
   private String[] T005215_A300MegDescrip ;
   private int[] T005216_A3CliCod ;
   private String[] T005216_A11MegCodigo ;
   private short[] T005216_A1601MegSitRevista ;
   private short[] T005217_A1601MegSitRevista ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15CliCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV21MegCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV24MegSitRevista_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class motivoegresorevistaafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00522", "SELECT MegSitRevDef, CliCod, MegCodigo, MegSitRevista FROM MotivoEgresoRevistaAfip WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ?  FOR UPDATE OF MotivoEgresoRevistaAfip NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00523", "SELECT MegSitRevDef, CliCod, MegCodigo, MegSitRevista FROM MotivoEgresoRevistaAfip WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00524", "SELECT MegDescrip FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00525", "SELECT SitRevCodigo AS MegSitRevista FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00526", "SELECT TM1.MegSitRevDef, T2.MegDescrip, TM1.CliCod, TM1.MegCodigo, TM1.MegSitRevista AS MegSitRevista FROM (MotivoEgresoRevistaAfip TM1 INNER JOIN MotivoEgreso T2 ON T2.CliCod = TM1.CliCod AND T2.MegCodigo = TM1.MegCodigo) WHERE TM1.CliCod = ? and TM1.MegCodigo = ( ?) and TM1.MegSitRevista = ? ORDER BY TM1.CliCod, TM1.MegCodigo, TM1.MegSitRevista ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00527", "SELECT MegDescrip FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00528", "SELECT SitRevCodigo AS MegSitRevista FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00529", "SELECT CliCod, MegCodigo, MegSitRevista FROM MotivoEgresoRevistaAfip WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005210", "SELECT CliCod, MegCodigo, MegSitRevista FROM MotivoEgresoRevistaAfip WHERE ( CliCod > ? or CliCod = ? and MegCodigo > ( ?) or MegCodigo = ( ?) and CliCod = ? and MegSitRevista > ?) ORDER BY CliCod, MegCodigo, MegSitRevista  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005211", "SELECT CliCod, MegCodigo, MegSitRevista FROM MotivoEgresoRevistaAfip WHERE ( CliCod < ? or CliCod = ? and MegCodigo < ( ?) or MegCodigo = ( ?) and CliCod = ? and MegSitRevista < ?) ORDER BY CliCod DESC, MegCodigo DESC, MegSitRevista DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005212", "SAVEPOINT gxupdate;INSERT INTO MotivoEgresoRevistaAfip(MegSitRevDef, CliCod, MegCodigo, MegSitRevista, MegSitRelSec, MegSitRelSecCli, MegSitPadre, MegSitRelRef, MegSitOld) VALUES(?, ?, ?, ?, 0, 0, 0, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005213", "SAVEPOINT gxupdate;UPDATE MotivoEgresoRevistaAfip SET MegSitRevDef=?  WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005214", "SAVEPOINT gxupdate;DELETE FROM MotivoEgresoRevistaAfip  WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005215", "SELECT MegDescrip FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005216", "SELECT CliCod, MegCodigo, MegSitRevista FROM MotivoEgresoRevistaAfip ORDER BY CliCod, MegCodigo, MegSitRevista ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005217", "SELECT SitRevCodigo AS MegSitRevista FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 1 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 10 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 11 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

