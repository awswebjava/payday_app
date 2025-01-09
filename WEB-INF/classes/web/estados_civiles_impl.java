package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class estados_civiles_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_10") == 0 )
      {
         A1747EstaCivilPais = (short)(GXutil.lval( httpContext.GetPar( "EstaCivilPais"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1747EstaCivilPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1747EstaCivilPais), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_10( A1747EstaCivilPais) ;
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
            AV7EstaCivilCod = (short)(GXutil.lval( httpContext.GetPar( "EstaCivilCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7EstaCivilCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EstaCivilCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESTACIVILCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EstaCivilCod), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Estados_civiles", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtEstaCivilPais_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public estados_civiles_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public estados_civiles_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( estados_civiles_impl.class ));
   }

   public estados_civiles_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkEstaCivilCasadoEs = UIFactory.getCheckbox(this);
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
      A2272EstaCivilCasadoEs = GXutil.strtobool( GXutil.booltostr( A2272EstaCivilCasadoEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2272EstaCivilCasadoEs", A2272EstaCivilCasadoEs);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEstaCivilCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEstaCivilCod_Internalname, httpContext.getMessage( "Id.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtEstaCivilCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1748EstaCivilCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEstaCivilCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1748EstaCivilCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1748EstaCivilCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEstaCivilCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEstaCivilCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Estados_civiles.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedestacivilpais_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockestacivilpais_Internalname, httpContext.getMessage( "Paìs", ""), "", "", lblTextblockestacivilpais_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Estados_civiles.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_estacivilpais.setProperty("Caption", Combo_estacivilpais_Caption);
      ucCombo_estacivilpais.setProperty("Cls", Combo_estacivilpais_Cls);
      ucCombo_estacivilpais.setProperty("DataListProc", Combo_estacivilpais_Datalistproc);
      ucCombo_estacivilpais.setProperty("DataListProcParametersPrefix", Combo_estacivilpais_Datalistprocparametersprefix);
      ucCombo_estacivilpais.setProperty("EmptyItem", Combo_estacivilpais_Emptyitem);
      ucCombo_estacivilpais.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_estacivilpais.setProperty("DropDownOptionsData", AV15EstaCivilPais_Data);
      ucCombo_estacivilpais.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_estacivilpais_Internalname, "COMBO_ESTACIVILPAISContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEstaCivilPais_Internalname, httpContext.getMessage( "Paìs", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEstaCivilPais_Internalname, GXutil.ltrim( localUtil.ntoc( A1747EstaCivilPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1747EstaCivilPais), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEstaCivilPais_Jsonclick, 0, "Attribute", "", "", "", "", edtEstaCivilPais_Visible, edtEstaCivilPais_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Estados_civiles.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEstaCivilDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEstaCivilDescrip_Internalname, httpContext.getMessage( "Descripciòn masculina", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEstaCivilDescrip_Internalname, A1749EstaCivilDescrip, GXutil.rtrim( localUtil.format( A1749EstaCivilDescrip, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEstaCivilDescrip_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEstaCivilDescrip_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_Estados_civiles.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEstaCivilDescripFem_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEstaCivilDescripFem_Internalname, httpContext.getMessage( "Descripciòn femenina", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEstaCivilDescripFem_Internalname, A1751EstaCivilDescripFem, GXutil.rtrim( localUtil.format( A1751EstaCivilDescripFem, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEstaCivilDescripFem_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEstaCivilDescripFem_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_Estados_civiles.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEstaCivilCodFor_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEstaCivilCodFor_Internalname, httpContext.getMessage( "Código en parámetros de fórmulas", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEstaCivilCodFor_Internalname, GXutil.rtrim( A2093EstaCivilCodFor), GXutil.rtrim( localUtil.format( A2093EstaCivilCodFor, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEstaCivilCodFor_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEstaCivilCodFor_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "palabra", "left", true, "", "HLP_Estados_civiles.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEstaCivilCasadoEs.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkEstaCivilCasadoEs.getInternalname(), httpContext.getMessage( "Deduce impuesto a las ganancias", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEstaCivilCasadoEs.getInternalname(), GXutil.booltostr( A2272EstaCivilCasadoEs), "", httpContext.getMessage( "Deduce impuesto a las ganancias", ""), 1, chkEstaCivilCasadoEs.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(53, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,53);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Estados_civiles.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Estados_civiles.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Estados_civiles.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_estacivilpais_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboestacivilpais_Internalname, GXutil.ltrim( localUtil.ntoc( AV20ComboEstaCivilPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboestacivilpais_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20ComboEstaCivilPais), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20ComboEstaCivilPais), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboestacivilpais_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboestacivilpais_Visible, edtavComboestacivilpais_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Estados_civiles.htm");
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
      e11542 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vESTACIVILPAIS_DATA"), AV15EstaCivilPais_Data);
            /* Read saved values. */
            Z1748EstaCivilCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1748EstaCivilCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1749EstaCivilDescrip = httpContext.cgiGet( "Z1749EstaCivilDescrip") ;
            Z1751EstaCivilDescripFem = httpContext.cgiGet( "Z1751EstaCivilDescripFem") ;
            Z2093EstaCivilCodFor = httpContext.cgiGet( "Z2093EstaCivilCodFor") ;
            Z2272EstaCivilCasadoEs = GXutil.strtobool( httpContext.cgiGet( "Z2272EstaCivilCasadoEs")) ;
            Z1747EstaCivilPais = (short)(localUtil.ctol( httpContext.cgiGet( "Z1747EstaCivilPais"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1747EstaCivilPais = (short)(localUtil.ctol( httpContext.cgiGet( "N1747EstaCivilPais"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7EstaCivilCod = (short)(localUtil.ctol( httpContext.cgiGet( "vESTACIVILCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV13Insert_EstaCivilPais = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_ESTACIVILPAIS"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV22Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_estacivilpais_Objectcall = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Objectcall") ;
            Combo_estacivilpais_Class = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Class") ;
            Combo_estacivilpais_Icontype = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Icontype") ;
            Combo_estacivilpais_Icon = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Icon") ;
            Combo_estacivilpais_Caption = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Caption") ;
            Combo_estacivilpais_Tooltip = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Tooltip") ;
            Combo_estacivilpais_Cls = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Cls") ;
            Combo_estacivilpais_Selectedvalue_set = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Selectedvalue_set") ;
            Combo_estacivilpais_Selectedvalue_get = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Selectedvalue_get") ;
            Combo_estacivilpais_Selectedtext_set = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Selectedtext_set") ;
            Combo_estacivilpais_Selectedtext_get = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Selectedtext_get") ;
            Combo_estacivilpais_Gamoauthtoken = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Gamoauthtoken") ;
            Combo_estacivilpais_Ddointernalname = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Ddointernalname") ;
            Combo_estacivilpais_Titlecontrolalign = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Titlecontrolalign") ;
            Combo_estacivilpais_Dropdownoptionstype = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Dropdownoptionstype") ;
            Combo_estacivilpais_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Enabled")) ;
            Combo_estacivilpais_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Visible")) ;
            Combo_estacivilpais_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Titlecontrolidtoreplace") ;
            Combo_estacivilpais_Datalisttype = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Datalisttype") ;
            Combo_estacivilpais_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Allowmultipleselection")) ;
            Combo_estacivilpais_Datalistfixedvalues = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Datalistfixedvalues") ;
            Combo_estacivilpais_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Isgriditem")) ;
            Combo_estacivilpais_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Hasdescription")) ;
            Combo_estacivilpais_Datalistproc = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Datalistproc") ;
            Combo_estacivilpais_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Datalistprocparametersprefix") ;
            Combo_estacivilpais_Remoteservicesparameters = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Remoteservicesparameters") ;
            Combo_estacivilpais_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_estacivilpais_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Includeonlyselectedoption")) ;
            Combo_estacivilpais_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Includeselectalloption")) ;
            Combo_estacivilpais_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Emptyitem")) ;
            Combo_estacivilpais_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Includeaddnewoption")) ;
            Combo_estacivilpais_Htmltemplate = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Htmltemplate") ;
            Combo_estacivilpais_Multiplevaluestype = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Multiplevaluestype") ;
            Combo_estacivilpais_Loadingdata = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Loadingdata") ;
            Combo_estacivilpais_Noresultsfound = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Noresultsfound") ;
            Combo_estacivilpais_Emptyitemtext = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Emptyitemtext") ;
            Combo_estacivilpais_Onlyselectedvalues = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Onlyselectedvalues") ;
            Combo_estacivilpais_Selectalltext = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Selectalltext") ;
            Combo_estacivilpais_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Multiplevaluesseparator") ;
            Combo_estacivilpais_Addnewoptiontext = httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Addnewoptiontext") ;
            Combo_estacivilpais_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_ESTACIVILPAIS_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A1748EstaCivilCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEstaCivilCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1748EstaCivilCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1748EstaCivilCod), 4, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEstaCivilPais_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEstaCivilPais_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ESTACIVILPAIS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEstaCivilPais_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1747EstaCivilPais = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1747EstaCivilPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1747EstaCivilPais), 4, 0));
            }
            else
            {
               A1747EstaCivilPais = (short)(localUtil.ctol( httpContext.cgiGet( edtEstaCivilPais_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1747EstaCivilPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1747EstaCivilPais), 4, 0));
            }
            A1749EstaCivilDescrip = GXutil.upper( httpContext.cgiGet( edtEstaCivilDescrip_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1749EstaCivilDescrip", A1749EstaCivilDescrip);
            A1751EstaCivilDescripFem = GXutil.upper( httpContext.cgiGet( edtEstaCivilDescripFem_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1751EstaCivilDescripFem", A1751EstaCivilDescripFem);
            A2093EstaCivilCodFor = httpContext.cgiGet( edtEstaCivilCodFor_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2093EstaCivilCodFor", A2093EstaCivilCodFor);
            A2272EstaCivilCasadoEs = GXutil.strtobool( httpContext.cgiGet( chkEstaCivilCasadoEs.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2272EstaCivilCasadoEs", A2272EstaCivilCasadoEs);
            AV20ComboEstaCivilPais = (short)(localUtil.ctol( httpContext.cgiGet( edtavComboestacivilpais_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboEstaCivilPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboEstaCivilPais), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Estados_civiles");
            A1748EstaCivilCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEstaCivilCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1748EstaCivilCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1748EstaCivilCod), 4, 0));
            forbiddenHiddens.add("EstaCivilCod", localUtil.format( DecimalUtil.doubleToDec(A1748EstaCivilCod), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A1748EstaCivilCod != Z1748EstaCivilCod ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("estados_civiles:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1748EstaCivilCod = (short)(GXutil.lval( httpContext.GetPar( "EstaCivilCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1748EstaCivilCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1748EstaCivilCod), 4, 0));
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
                  sMode236 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode236 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound236 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_540( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "ESTACIVILCOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtEstaCivilCod_Internalname ;
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
                        e11542 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12542 ();
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
         e12542 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll54236( ) ;
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
         disableAttributes54236( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboestacivilpais_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboestacivilpais_Enabled), 5, 0), true);
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

   public void confirm_540( )
   {
      beforeValidate54236( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls54236( ) ;
         }
         else
         {
            checkExtendedTable54236( ) ;
            closeExtendedTableCursors54236( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption540( )
   {
   }

   public void e11542( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV16DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV16DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtEstaCivilPais_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEstaCivilPais_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstaCivilPais_Visible), 5, 0), true);
      AV20ComboEstaCivilPais = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboEstaCivilPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboEstaCivilPais), 4, 0));
      edtavComboestacivilpais_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboestacivilpais_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboestacivilpais_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOESTACIVILPAIS' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV9IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEstados_civiles_Insert", GXv_boolean5) ;
         estados_civiles_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEstados_civiles_Update", GXv_boolean5) ;
         estados_civiles_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEstados_civiles_Delete", GXv_boolean5) ;
         estados_civiles_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV22Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV22Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV23GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         while ( AV23GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV23GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EstaCivilPais") == 0 )
            {
               AV13Insert_EstaCivilPais = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_EstaCivilPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_EstaCivilPais), 4, 0));
               if ( ! (0==AV13Insert_EstaCivilPais) )
               {
                  AV20ComboEstaCivilPais = AV13Insert_EstaCivilPais ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboEstaCivilPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboEstaCivilPais), 4, 0));
                  Combo_estacivilpais_Selectedvalue_set = GXutil.trim( GXutil.str( AV20ComboEstaCivilPais, 4, 0)) ;
                  ucCombo_estacivilpais.sendProperty(context, "", false, Combo_estacivilpais_Internalname, "SelectedValue_set", Combo_estacivilpais_Selectedvalue_set);
                  GXt_char6 = AV19Combo_DataJson ;
                  GXv_char7[0] = AV17ComboSelectedValue ;
                  GXv_char8[0] = AV18ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.estados_civilesloaddvcombo(remoteHandle, context).execute( "EstaCivilPais", "GET", false, AV7EstaCivilCod, AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  estados_civiles_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
                  estados_civiles_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
                  estados_civiles_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
                  AV19Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
                  Combo_estacivilpais_Selectedtext_set = AV18ComboSelectedText ;
                  ucCombo_estacivilpais.sendProperty(context, "", false, Combo_estacivilpais_Internalname, "SelectedText_set", Combo_estacivilpais_Selectedtext_set);
                  Combo_estacivilpais_Enabled = false ;
                  ucCombo_estacivilpais.sendProperty(context, "", false, Combo_estacivilpais_Internalname, "Enabled", GXutil.booltostr( Combo_estacivilpais_Enabled));
               }
            }
            AV23GXV1 = (int)(AV23GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         }
      }
   }

   public void e12542( )
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

   public void S112( )
   {
      /* 'LOADCOMBOESTACIVILPAIS' Routine */
      returnInSub = false ;
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char9[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.estados_civilesloaddvcombo(remoteHandle, context).execute( "EstaCivilPais", Gx_mode, false, AV7EstaCivilCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      estados_civiles_impl.this.AV17ComboSelectedValue = GXv_char9[0] ;
      estados_civiles_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      estados_civiles_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
      AV19Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
      Combo_estacivilpais_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_estacivilpais.sendProperty(context, "", false, Combo_estacivilpais_Internalname, "SelectedValue_set", Combo_estacivilpais_Selectedvalue_set);
      Combo_estacivilpais_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_estacivilpais.sendProperty(context, "", false, Combo_estacivilpais_Internalname, "SelectedText_set", Combo_estacivilpais_Selectedtext_set);
      AV20ComboEstaCivilPais = (short)(GXutil.lval( AV17ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboEstaCivilPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboEstaCivilPais), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_estacivilpais_Enabled = false ;
         ucCombo_estacivilpais.sendProperty(context, "", false, Combo_estacivilpais_Internalname, "Enabled", GXutil.booltostr( Combo_estacivilpais_Enabled));
      }
   }

   public void zm54236( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1749EstaCivilDescrip = T00543_A1749EstaCivilDescrip[0] ;
            Z1751EstaCivilDescripFem = T00543_A1751EstaCivilDescripFem[0] ;
            Z2093EstaCivilCodFor = T00543_A2093EstaCivilCodFor[0] ;
            Z2272EstaCivilCasadoEs = T00543_A2272EstaCivilCasadoEs[0] ;
            Z1747EstaCivilPais = T00543_A1747EstaCivilPais[0] ;
         }
         else
         {
            Z1749EstaCivilDescrip = A1749EstaCivilDescrip ;
            Z1751EstaCivilDescripFem = A1751EstaCivilDescripFem ;
            Z2093EstaCivilCodFor = A2093EstaCivilCodFor ;
            Z2272EstaCivilCasadoEs = A2272EstaCivilCasadoEs ;
            Z1747EstaCivilPais = A1747EstaCivilPais ;
         }
      }
      if ( GX_JID == -8 )
      {
         Z1748EstaCivilCod = A1748EstaCivilCod ;
         Z1749EstaCivilDescrip = A1749EstaCivilDescrip ;
         Z1751EstaCivilDescripFem = A1751EstaCivilDescripFem ;
         Z2093EstaCivilCodFor = A2093EstaCivilCodFor ;
         Z2272EstaCivilCasadoEs = A2272EstaCivilCasadoEs ;
         Z1747EstaCivilPais = A1747EstaCivilPais ;
      }
   }

   public void standaloneNotModal( )
   {
      edtEstaCivilCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEstaCivilCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstaCivilCod_Enabled), 5, 0), true);
      edtEstaCivilCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEstaCivilCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstaCivilCod_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7EstaCivilCod) )
      {
         A1748EstaCivilCod = AV7EstaCivilCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1748EstaCivilCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1748EstaCivilCod), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_EstaCivilPais) )
      {
         edtEstaCivilPais_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEstaCivilPais_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstaCivilPais_Enabled), 5, 0), true);
      }
      else
      {
         edtEstaCivilPais_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEstaCivilPais_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstaCivilPais_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_EstaCivilPais) )
      {
         A1747EstaCivilPais = AV13Insert_EstaCivilPais ;
         httpContext.ajax_rsp_assign_attri("", false, "A1747EstaCivilPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1747EstaCivilPais), 4, 0));
      }
      else
      {
         A1747EstaCivilPais = AV20ComboEstaCivilPais ;
         httpContext.ajax_rsp_assign_attri("", false, "A1747EstaCivilPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1747EstaCivilPais), 4, 0));
      }
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
         AV22Pgmname = "Estados_civiles" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
   }

   public void load54236( )
   {
      /* Using cursor T00545 */
      pr_default.execute(3, new Object[] {Short.valueOf(A1748EstaCivilCod)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound236 = (short)(1) ;
         A1749EstaCivilDescrip = T00545_A1749EstaCivilDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1749EstaCivilDescrip", A1749EstaCivilDescrip);
         A1751EstaCivilDescripFem = T00545_A1751EstaCivilDescripFem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1751EstaCivilDescripFem", A1751EstaCivilDescripFem);
         A2093EstaCivilCodFor = T00545_A2093EstaCivilCodFor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2093EstaCivilCodFor", A2093EstaCivilCodFor);
         A2272EstaCivilCasadoEs = T00545_A2272EstaCivilCasadoEs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2272EstaCivilCasadoEs", A2272EstaCivilCasadoEs);
         A1747EstaCivilPais = T00545_A1747EstaCivilPais[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1747EstaCivilPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1747EstaCivilPais), 4, 0));
         zm54236( -8) ;
      }
      pr_default.close(3);
      onLoadActions54236( ) ;
   }

   public void onLoadActions54236( )
   {
      AV22Pgmname = "Estados_civiles" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
   }

   public void checkExtendedTable54236( )
   {
      nIsDirty_236 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV22Pgmname = "Estados_civiles" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      /* Using cursor T00546 */
      pr_default.execute(4, new Object[] {Short.valueOf(A1747EstaCivilPais), A2093EstaCivilCodFor, Short.valueOf(A1748EstaCivilCod)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Paìs", "")+","+httpContext.getMessage( "Código en parámetros de fórmulas", "")}), 1, "ESTACIVILPAIS");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEstaCivilPais_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      /* Using cursor T00544 */
      pr_default.execute(2, new Object[] {Short.valueOf(A1747EstaCivilPais)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Estado Civil_Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ESTACIVILPAIS");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEstaCivilPais_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors54236( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_10( short A1747EstaCivilPais )
   {
      /* Using cursor T00547 */
      pr_default.execute(5, new Object[] {Short.valueOf(A1747EstaCivilPais)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Estado Civil_Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ESTACIVILPAIS");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEstaCivilPais_Internalname ;
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

   public void getKey54236( )
   {
      /* Using cursor T00548 */
      pr_default.execute(6, new Object[] {Short.valueOf(A1748EstaCivilCod)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound236 = (short)(1) ;
      }
      else
      {
         RcdFound236 = (short)(0) ;
      }
      pr_default.close(6);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00543 */
      pr_default.execute(1, new Object[] {Short.valueOf(A1748EstaCivilCod)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm54236( 8) ;
         RcdFound236 = (short)(1) ;
         A1748EstaCivilCod = T00543_A1748EstaCivilCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1748EstaCivilCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1748EstaCivilCod), 4, 0));
         A1749EstaCivilDescrip = T00543_A1749EstaCivilDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1749EstaCivilDescrip", A1749EstaCivilDescrip);
         A1751EstaCivilDescripFem = T00543_A1751EstaCivilDescripFem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1751EstaCivilDescripFem", A1751EstaCivilDescripFem);
         A2093EstaCivilCodFor = T00543_A2093EstaCivilCodFor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2093EstaCivilCodFor", A2093EstaCivilCodFor);
         A2272EstaCivilCasadoEs = T00543_A2272EstaCivilCasadoEs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2272EstaCivilCasadoEs", A2272EstaCivilCasadoEs);
         A1747EstaCivilPais = T00543_A1747EstaCivilPais[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1747EstaCivilPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1747EstaCivilPais), 4, 0));
         Z1748EstaCivilCod = A1748EstaCivilCod ;
         sMode236 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load54236( ) ;
         if ( AnyError == 1 )
         {
            RcdFound236 = (short)(0) ;
            initializeNonKey54236( ) ;
         }
         Gx_mode = sMode236 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound236 = (short)(0) ;
         initializeNonKey54236( ) ;
         sMode236 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode236 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey54236( ) ;
      if ( RcdFound236 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound236 = (short)(0) ;
      /* Using cursor T00549 */
      pr_default.execute(7, new Object[] {Short.valueOf(A1748EstaCivilCod)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00549_A1748EstaCivilCod[0] < A1748EstaCivilCod ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00549_A1748EstaCivilCod[0] > A1748EstaCivilCod ) ) )
         {
            A1748EstaCivilCod = T00549_A1748EstaCivilCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1748EstaCivilCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1748EstaCivilCod), 4, 0));
            RcdFound236 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void move_previous( )
   {
      RcdFound236 = (short)(0) ;
      /* Using cursor T005410 */
      pr_default.execute(8, new Object[] {Short.valueOf(A1748EstaCivilCod)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T005410_A1748EstaCivilCod[0] > A1748EstaCivilCod ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T005410_A1748EstaCivilCod[0] < A1748EstaCivilCod ) ) )
         {
            A1748EstaCivilCod = T005410_A1748EstaCivilCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1748EstaCivilCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1748EstaCivilCod), 4, 0));
            RcdFound236 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey54236( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtEstaCivilPais_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert54236( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound236 == 1 )
         {
            if ( A1748EstaCivilCod != Z1748EstaCivilCod )
            {
               A1748EstaCivilCod = Z1748EstaCivilCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1748EstaCivilCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1748EstaCivilCod), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "ESTACIVILCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEstaCivilCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtEstaCivilPais_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update54236( ) ;
               GX_FocusControl = edtEstaCivilPais_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A1748EstaCivilCod != Z1748EstaCivilCod )
            {
               /* Insert record */
               GX_FocusControl = edtEstaCivilPais_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert54236( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "ESTACIVILCOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtEstaCivilCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtEstaCivilPais_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert54236( ) ;
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
      if ( A1748EstaCivilCod != Z1748EstaCivilCod )
      {
         A1748EstaCivilCod = Z1748EstaCivilCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1748EstaCivilCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1748EstaCivilCod), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "ESTACIVILCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEstaCivilCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtEstaCivilPais_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency54236( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00542 */
         pr_default.execute(0, new Object[] {Short.valueOf(A1748EstaCivilCod)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Estados_civiles"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1749EstaCivilDescrip, T00542_A1749EstaCivilDescrip[0]) != 0 ) || ( GXutil.strcmp(Z1751EstaCivilDescripFem, T00542_A1751EstaCivilDescripFem[0]) != 0 ) || ( GXutil.strcmp(Z2093EstaCivilCodFor, T00542_A2093EstaCivilCodFor[0]) != 0 ) || ( Z2272EstaCivilCasadoEs != T00542_A2272EstaCivilCasadoEs[0] ) || ( Z1747EstaCivilPais != T00542_A1747EstaCivilPais[0] ) )
         {
            if ( GXutil.strcmp(Z1749EstaCivilDescrip, T00542_A1749EstaCivilDescrip[0]) != 0 )
            {
               GXutil.writeLogln("estados_civiles:[seudo value changed for attri]"+"EstaCivilDescrip");
               GXutil.writeLogRaw("Old: ",Z1749EstaCivilDescrip);
               GXutil.writeLogRaw("Current: ",T00542_A1749EstaCivilDescrip[0]);
            }
            if ( GXutil.strcmp(Z1751EstaCivilDescripFem, T00542_A1751EstaCivilDescripFem[0]) != 0 )
            {
               GXutil.writeLogln("estados_civiles:[seudo value changed for attri]"+"EstaCivilDescripFem");
               GXutil.writeLogRaw("Old: ",Z1751EstaCivilDescripFem);
               GXutil.writeLogRaw("Current: ",T00542_A1751EstaCivilDescripFem[0]);
            }
            if ( GXutil.strcmp(Z2093EstaCivilCodFor, T00542_A2093EstaCivilCodFor[0]) != 0 )
            {
               GXutil.writeLogln("estados_civiles:[seudo value changed for attri]"+"EstaCivilCodFor");
               GXutil.writeLogRaw("Old: ",Z2093EstaCivilCodFor);
               GXutil.writeLogRaw("Current: ",T00542_A2093EstaCivilCodFor[0]);
            }
            if ( Z2272EstaCivilCasadoEs != T00542_A2272EstaCivilCasadoEs[0] )
            {
               GXutil.writeLogln("estados_civiles:[seudo value changed for attri]"+"EstaCivilCasadoEs");
               GXutil.writeLogRaw("Old: ",Z2272EstaCivilCasadoEs);
               GXutil.writeLogRaw("Current: ",T00542_A2272EstaCivilCasadoEs[0]);
            }
            if ( Z1747EstaCivilPais != T00542_A1747EstaCivilPais[0] )
            {
               GXutil.writeLogln("estados_civiles:[seudo value changed for attri]"+"EstaCivilPais");
               GXutil.writeLogRaw("Old: ",Z1747EstaCivilPais);
               GXutil.writeLogRaw("Current: ",T00542_A1747EstaCivilPais[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Estados_civiles"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert54236( )
   {
      beforeValidate54236( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable54236( ) ;
      }
      if ( AnyError == 0 )
      {
         zm54236( 0) ;
         checkOptimisticConcurrency54236( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm54236( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert54236( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005411 */
                  pr_default.execute(9, new Object[] {A1749EstaCivilDescrip, A1751EstaCivilDescripFem, A2093EstaCivilCodFor, Boolean.valueOf(A2272EstaCivilCasadoEs), Short.valueOf(A1747EstaCivilPais)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T005412 */
                  pr_default.execute(10);
                  A1748EstaCivilCod = T005412_A1748EstaCivilCod[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1748EstaCivilCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1748EstaCivilCod), 4, 0));
                  pr_default.close(10);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Estados_civiles");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption540( ) ;
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
            load54236( ) ;
         }
         endLevel54236( ) ;
      }
      closeExtendedTableCursors54236( ) ;
   }

   public void update54236( )
   {
      beforeValidate54236( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable54236( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency54236( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm54236( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate54236( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005413 */
                  pr_default.execute(11, new Object[] {A1749EstaCivilDescrip, A1751EstaCivilDescripFem, A2093EstaCivilCodFor, Boolean.valueOf(A2272EstaCivilCasadoEs), Short.valueOf(A1747EstaCivilPais), Short.valueOf(A1748EstaCivilCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Estados_civiles");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Estados_civiles"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate54236( ) ;
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
         endLevel54236( ) ;
      }
      closeExtendedTableCursors54236( ) ;
   }

   public void deferredUpdate54236( )
   {
   }

   public void delete( )
   {
      beforeValidate54236( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency54236( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls54236( ) ;
         afterConfirm54236( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete54236( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005414 */
               pr_default.execute(12, new Object[] {Short.valueOf(A1748EstaCivilCod)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Estados_civiles");
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
      sMode236 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel54236( ) ;
      Gx_mode = sMode236 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls54236( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV22Pgmname = "Estados_civiles" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T005415 */
         pr_default.execute(13, new Object[] {Short.valueOf(A1748EstaCivilCod)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void endLevel54236( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete54236( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "estados_civiles");
         if ( AnyError == 0 )
         {
            confirmValues540( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "estados_civiles");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart54236( )
   {
      /* Scan By routine */
      /* Using cursor T005416 */
      pr_default.execute(14);
      RcdFound236 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound236 = (short)(1) ;
         A1748EstaCivilCod = T005416_A1748EstaCivilCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1748EstaCivilCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1748EstaCivilCod), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext54236( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound236 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound236 = (short)(1) ;
         A1748EstaCivilCod = T005416_A1748EstaCivilCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1748EstaCivilCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1748EstaCivilCod), 4, 0));
      }
   }

   public void scanEnd54236( )
   {
      pr_default.close(14);
   }

   public void afterConfirm54236( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert54236( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate54236( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete54236( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete54236( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate54236( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes54236( )
   {
      edtEstaCivilCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEstaCivilCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstaCivilCod_Enabled), 5, 0), true);
      edtEstaCivilPais_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEstaCivilPais_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstaCivilPais_Enabled), 5, 0), true);
      edtEstaCivilDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEstaCivilDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstaCivilDescrip_Enabled), 5, 0), true);
      edtEstaCivilDescripFem_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEstaCivilDescripFem_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstaCivilDescripFem_Enabled), 5, 0), true);
      edtEstaCivilCodFor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEstaCivilCodFor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEstaCivilCodFor_Enabled), 5, 0), true);
      chkEstaCivilCasadoEs.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkEstaCivilCasadoEs.getInternalname(), "Enabled", GXutil.ltrimstr( chkEstaCivilCasadoEs.getEnabled(), 5, 0), true);
      edtavComboestacivilpais_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboestacivilpais_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboestacivilpais_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes54236( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues540( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.estados_civiles", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7EstaCivilCod,4,0))}, new String[] {"Gx_mode","EstaCivilCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Estados_civiles");
      forbiddenHiddens.add("EstaCivilCod", localUtil.format( DecimalUtil.doubleToDec(A1748EstaCivilCod), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("estados_civiles:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z1748EstaCivilCod", GXutil.ltrim( localUtil.ntoc( Z1748EstaCivilCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1749EstaCivilDescrip", Z1749EstaCivilDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1751EstaCivilDescripFem", Z1751EstaCivilDescripFem);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2093EstaCivilCodFor", GXutil.rtrim( Z2093EstaCivilCodFor));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2272EstaCivilCasadoEs", Z2272EstaCivilCasadoEs);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1747EstaCivilPais", GXutil.ltrim( localUtil.ntoc( Z1747EstaCivilPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1747EstaCivilPais", GXutil.ltrim( localUtil.ntoc( A1747EstaCivilPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vESTACIVILPAIS_DATA", AV15EstaCivilPais_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vESTACIVILPAIS_DATA", AV15EstaCivilPais_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vESTACIVILCOD", GXutil.ltrim( localUtil.ntoc( AV7EstaCivilCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESTACIVILCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EstaCivilCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_ESTACIVILPAIS", GXutil.ltrim( localUtil.ntoc( AV13Insert_EstaCivilPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV22Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTACIVILPAIS_Objectcall", GXutil.rtrim( Combo_estacivilpais_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTACIVILPAIS_Cls", GXutil.rtrim( Combo_estacivilpais_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTACIVILPAIS_Selectedvalue_set", GXutil.rtrim( Combo_estacivilpais_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTACIVILPAIS_Selectedtext_set", GXutil.rtrim( Combo_estacivilpais_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTACIVILPAIS_Enabled", GXutil.booltostr( Combo_estacivilpais_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTACIVILPAIS_Datalistproc", GXutil.rtrim( Combo_estacivilpais_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTACIVILPAIS_Datalistprocparametersprefix", GXutil.rtrim( Combo_estacivilpais_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESTACIVILPAIS_Emptyitem", GXutil.booltostr( Combo_estacivilpais_Emptyitem));
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
      return formatLink("web.estados_civiles", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7EstaCivilCod,4,0))}, new String[] {"Gx_mode","EstaCivilCod"})  ;
   }

   public String getPgmname( )
   {
      return "Estados_civiles" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Estados_civiles", "") ;
   }

   public void initializeNonKey54236( )
   {
      A1747EstaCivilPais = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1747EstaCivilPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1747EstaCivilPais), 4, 0));
      A1749EstaCivilDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1749EstaCivilDescrip", A1749EstaCivilDescrip);
      A1751EstaCivilDescripFem = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1751EstaCivilDescripFem", A1751EstaCivilDescripFem);
      A2093EstaCivilCodFor = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2093EstaCivilCodFor", A2093EstaCivilCodFor);
      A2272EstaCivilCasadoEs = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2272EstaCivilCasadoEs", A2272EstaCivilCasadoEs);
      Z1749EstaCivilDescrip = "" ;
      Z1751EstaCivilDescripFem = "" ;
      Z2093EstaCivilCodFor = "" ;
      Z2272EstaCivilCasadoEs = false ;
      Z1747EstaCivilPais = (short)(0) ;
   }

   public void initAll54236( )
   {
      A1748EstaCivilCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1748EstaCivilCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1748EstaCivilCod), 4, 0));
      initializeNonKey54236( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713382937", true, true);
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
      httpContext.AddJavascriptSource("estados_civiles.js", "?20251713382938", false, true);
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
      edtEstaCivilCod_Internalname = "ESTACIVILCOD" ;
      lblTextblockestacivilpais_Internalname = "TEXTBLOCKESTACIVILPAIS" ;
      Combo_estacivilpais_Internalname = "COMBO_ESTACIVILPAIS" ;
      edtEstaCivilPais_Internalname = "ESTACIVILPAIS" ;
      divTablesplittedestacivilpais_Internalname = "TABLESPLITTEDESTACIVILPAIS" ;
      edtEstaCivilDescrip_Internalname = "ESTACIVILDESCRIP" ;
      edtEstaCivilDescripFem_Internalname = "ESTACIVILDESCRIPFEM" ;
      edtEstaCivilCodFor_Internalname = "ESTACIVILCODFOR" ;
      chkEstaCivilCasadoEs.setInternalname( "ESTACIVILCASADOES" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboestacivilpais_Internalname = "vCOMBOESTACIVILPAIS" ;
      divSectionattribute_estacivilpais_Internalname = "SECTIONATTRIBUTE_ESTACIVILPAIS" ;
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
      Form.setCaption( httpContext.getMessage( "Estados_civiles", "") );
      edtavComboestacivilpais_Jsonclick = "" ;
      edtavComboestacivilpais_Enabled = 0 ;
      edtavComboestacivilpais_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkEstaCivilCasadoEs.setEnabled( 1 );
      edtEstaCivilCodFor_Jsonclick = "" ;
      edtEstaCivilCodFor_Enabled = 1 ;
      edtEstaCivilDescripFem_Jsonclick = "" ;
      edtEstaCivilDescripFem_Enabled = 1 ;
      edtEstaCivilDescrip_Jsonclick = "" ;
      edtEstaCivilDescrip_Enabled = 1 ;
      edtEstaCivilPais_Jsonclick = "" ;
      edtEstaCivilPais_Enabled = 1 ;
      edtEstaCivilPais_Visible = 1 ;
      Combo_estacivilpais_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_estacivilpais_Datalistprocparametersprefix = " \"ComboName\": \"EstaCivilPais\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"EstaCivilCod\": 0" ;
      Combo_estacivilpais_Datalistproc = "Estados_civilesLoadDVCombo" ;
      Combo_estacivilpais_Cls = "ExtendedCombo Attribute" ;
      Combo_estacivilpais_Caption = "" ;
      Combo_estacivilpais_Enabled = GXutil.toBoolean( -1) ;
      edtEstaCivilCod_Jsonclick = "" ;
      edtEstaCivilCod_Enabled = 0 ;
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
      chkEstaCivilCasadoEs.setName( "ESTACIVILCASADOES" );
      chkEstaCivilCasadoEs.setWebtags( "" );
      chkEstaCivilCasadoEs.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkEstaCivilCasadoEs.getInternalname(), "TitleCaption", chkEstaCivilCasadoEs.getCaption(), true);
      chkEstaCivilCasadoEs.setCheckedValue( "false" );
      A2272EstaCivilCasadoEs = GXutil.strtobool( GXutil.booltostr( A2272EstaCivilCasadoEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2272EstaCivilCasadoEs", A2272EstaCivilCasadoEs);
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

   public void valid_Estacivilpais( )
   {
      /* Using cursor T005417 */
      pr_default.execute(15, new Object[] {Short.valueOf(A1747EstaCivilPais)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Estado Civil_Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ESTACIVILPAIS");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEstaCivilPais_Internalname ;
      }
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Estacivilcodfor( )
   {
      /* Using cursor T005418 */
      pr_default.execute(16, new Object[] {Short.valueOf(A1747EstaCivilPais), A2093EstaCivilCodFor, Short.valueOf(A1748EstaCivilCod)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Paìs", "")+","+httpContext.getMessage( "Código en parámetros de fórmulas", "")}), 1, "ESTACIVILPAIS");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEstaCivilPais_Internalname ;
      }
      pr_default.close(16);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7EstaCivilCod',fld:'vESTACIVILCOD',pic:'ZZZ9',hsh:true},{av:'A2272EstaCivilCasadoEs',fld:'ESTACIVILCASADOES',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A2272EstaCivilCasadoEs',fld:'ESTACIVILCASADOES',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7EstaCivilCod',fld:'vESTACIVILCOD',pic:'ZZZ9',hsh:true},{av:'A1748EstaCivilCod',fld:'ESTACIVILCOD',pic:'ZZZ9'},{av:'A2272EstaCivilCasadoEs',fld:'ESTACIVILCASADOES',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A2272EstaCivilCasadoEs',fld:'ESTACIVILCASADOES',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e12542',iparms:[{av:'A2272EstaCivilCasadoEs',fld:'ESTACIVILCASADOES',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A2272EstaCivilCasadoEs',fld:'ESTACIVILCASADOES',pic:''}]}");
      setEventMetadata("VALID_ESTACIVILCOD","{handler:'valid_Estacivilcod',iparms:[{av:'A2272EstaCivilCasadoEs',fld:'ESTACIVILCASADOES',pic:''}]");
      setEventMetadata("VALID_ESTACIVILCOD",",oparms:[{av:'A2272EstaCivilCasadoEs',fld:'ESTACIVILCASADOES',pic:''}]}");
      setEventMetadata("VALID_ESTACIVILPAIS","{handler:'valid_Estacivilpais',iparms:[{av:'A1747EstaCivilPais',fld:'ESTACIVILPAIS',pic:'ZZZ9'},{av:'A2272EstaCivilCasadoEs',fld:'ESTACIVILCASADOES',pic:''}]");
      setEventMetadata("VALID_ESTACIVILPAIS",",oparms:[{av:'A2272EstaCivilCasadoEs',fld:'ESTACIVILCASADOES',pic:''}]}");
      setEventMetadata("VALID_ESTACIVILCODFOR","{handler:'valid_Estacivilcodfor',iparms:[{av:'A1747EstaCivilPais',fld:'ESTACIVILPAIS',pic:'ZZZ9'},{av:'A2093EstaCivilCodFor',fld:'ESTACIVILCODFOR',pic:''},{av:'A1748EstaCivilCod',fld:'ESTACIVILCOD',pic:'ZZZ9'},{av:'A2272EstaCivilCasadoEs',fld:'ESTACIVILCASADOES',pic:''}]");
      setEventMetadata("VALID_ESTACIVILCODFOR",",oparms:[{av:'A2272EstaCivilCasadoEs',fld:'ESTACIVILCASADOES',pic:''}]}");
      setEventMetadata("VALIDV_COMBOESTACIVILPAIS","{handler:'validv_Comboestacivilpais',iparms:[{av:'A2272EstaCivilCasadoEs',fld:'ESTACIVILCASADOES',pic:''}]");
      setEventMetadata("VALIDV_COMBOESTACIVILPAIS",",oparms:[{av:'A2272EstaCivilCasadoEs',fld:'ESTACIVILCASADOES',pic:''}]}");
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
      pr_default.close(15);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z1749EstaCivilDescrip = "" ;
      Z1751EstaCivilDescripFem = "" ;
      Z2093EstaCivilCodFor = "" ;
      Combo_estacivilpais_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockestacivilpais_Jsonclick = "" ;
      ucCombo_estacivilpais = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15EstaCivilPais_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A1749EstaCivilDescrip = "" ;
      A1751EstaCivilDescripFem = "" ;
      A2093EstaCivilCodFor = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV22Pgmname = "" ;
      Combo_estacivilpais_Objectcall = "" ;
      Combo_estacivilpais_Class = "" ;
      Combo_estacivilpais_Icontype = "" ;
      Combo_estacivilpais_Icon = "" ;
      Combo_estacivilpais_Tooltip = "" ;
      Combo_estacivilpais_Selectedvalue_set = "" ;
      Combo_estacivilpais_Selectedtext_set = "" ;
      Combo_estacivilpais_Selectedtext_get = "" ;
      Combo_estacivilpais_Gamoauthtoken = "" ;
      Combo_estacivilpais_Ddointernalname = "" ;
      Combo_estacivilpais_Titlecontrolalign = "" ;
      Combo_estacivilpais_Dropdownoptionstype = "" ;
      Combo_estacivilpais_Titlecontrolidtoreplace = "" ;
      Combo_estacivilpais_Datalisttype = "" ;
      Combo_estacivilpais_Datalistfixedvalues = "" ;
      Combo_estacivilpais_Remoteservicesparameters = "" ;
      Combo_estacivilpais_Htmltemplate = "" ;
      Combo_estacivilpais_Multiplevaluestype = "" ;
      Combo_estacivilpais_Loadingdata = "" ;
      Combo_estacivilpais_Noresultsfound = "" ;
      Combo_estacivilpais_Emptyitemtext = "" ;
      Combo_estacivilpais_Onlyselectedvalues = "" ;
      Combo_estacivilpais_Selectalltext = "" ;
      Combo_estacivilpais_Multiplevaluesseparator = "" ;
      Combo_estacivilpais_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode236 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV19Combo_DataJson = "" ;
      AV17ComboSelectedValue = "" ;
      AV18ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      T00545_A1748EstaCivilCod = new short[1] ;
      T00545_A1749EstaCivilDescrip = new String[] {""} ;
      T00545_A1751EstaCivilDescripFem = new String[] {""} ;
      T00545_A2093EstaCivilCodFor = new String[] {""} ;
      T00545_A2272EstaCivilCasadoEs = new boolean[] {false} ;
      T00545_A1747EstaCivilPais = new short[1] ;
      T00546_A1747EstaCivilPais = new short[1] ;
      T00544_A1747EstaCivilPais = new short[1] ;
      T00547_A1747EstaCivilPais = new short[1] ;
      T00548_A1748EstaCivilCod = new short[1] ;
      T00543_A1748EstaCivilCod = new short[1] ;
      T00543_A1749EstaCivilDescrip = new String[] {""} ;
      T00543_A1751EstaCivilDescripFem = new String[] {""} ;
      T00543_A2093EstaCivilCodFor = new String[] {""} ;
      T00543_A2272EstaCivilCasadoEs = new boolean[] {false} ;
      T00543_A1747EstaCivilPais = new short[1] ;
      T00549_A1748EstaCivilCod = new short[1] ;
      T005410_A1748EstaCivilCod = new short[1] ;
      T00542_A1748EstaCivilCod = new short[1] ;
      T00542_A1749EstaCivilDescrip = new String[] {""} ;
      T00542_A1751EstaCivilDescripFem = new String[] {""} ;
      T00542_A2093EstaCivilCodFor = new String[] {""} ;
      T00542_A2272EstaCivilCasadoEs = new boolean[] {false} ;
      T00542_A1747EstaCivilPais = new short[1] ;
      T005412_A1748EstaCivilCod = new short[1] ;
      T005415_A3CliCod = new int[1] ;
      T005415_A1EmpCod = new short[1] ;
      T005415_A6LegNumero = new int[1] ;
      T005416_A1748EstaCivilCod = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T005417_A1747EstaCivilPais = new short[1] ;
      T005418_A1747EstaCivilPais = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.estados_civiles__default(),
         new Object[] {
             new Object[] {
            T00542_A1748EstaCivilCod, T00542_A1749EstaCivilDescrip, T00542_A1751EstaCivilDescripFem, T00542_A2093EstaCivilCodFor, T00542_A2272EstaCivilCasadoEs, T00542_A1747EstaCivilPais
            }
            , new Object[] {
            T00543_A1748EstaCivilCod, T00543_A1749EstaCivilDescrip, T00543_A1751EstaCivilDescripFem, T00543_A2093EstaCivilCodFor, T00543_A2272EstaCivilCasadoEs, T00543_A1747EstaCivilPais
            }
            , new Object[] {
            T00544_A1747EstaCivilPais
            }
            , new Object[] {
            T00545_A1748EstaCivilCod, T00545_A1749EstaCivilDescrip, T00545_A1751EstaCivilDescripFem, T00545_A2093EstaCivilCodFor, T00545_A2272EstaCivilCasadoEs, T00545_A1747EstaCivilPais
            }
            , new Object[] {
            T00546_A1747EstaCivilPais
            }
            , new Object[] {
            T00547_A1747EstaCivilPais
            }
            , new Object[] {
            T00548_A1748EstaCivilCod
            }
            , new Object[] {
            T00549_A1748EstaCivilCod
            }
            , new Object[] {
            T005410_A1748EstaCivilCod
            }
            , new Object[] {
            }
            , new Object[] {
            T005412_A1748EstaCivilCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005415_A3CliCod, T005415_A1EmpCod, T005415_A6LegNumero
            }
            , new Object[] {
            T005416_A1748EstaCivilCod
            }
            , new Object[] {
            T005417_A1747EstaCivilPais
            }
            , new Object[] {
            T005418_A1747EstaCivilPais
            }
         }
      );
      AV22Pgmname = "Estados_civiles" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7EstaCivilCod ;
   private short Z1748EstaCivilCod ;
   private short Z1747EstaCivilPais ;
   private short N1747EstaCivilPais ;
   private short A1747EstaCivilPais ;
   private short AV7EstaCivilCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1748EstaCivilCod ;
   private short AV20ComboEstaCivilPais ;
   private short AV13Insert_EstaCivilPais ;
   private short RcdFound236 ;
   private short nIsDirty_236 ;
   private int trnEnded ;
   private int edtEstaCivilCod_Enabled ;
   private int edtEstaCivilPais_Visible ;
   private int edtEstaCivilPais_Enabled ;
   private int edtEstaCivilDescrip_Enabled ;
   private int edtEstaCivilDescripFem_Enabled ;
   private int edtEstaCivilCodFor_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboestacivilpais_Enabled ;
   private int edtavComboestacivilpais_Visible ;
   private int Combo_estacivilpais_Datalistupdateminimumcharacters ;
   private int Combo_estacivilpais_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV23GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z2093EstaCivilCodFor ;
   private String Combo_estacivilpais_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtEstaCivilPais_Internalname ;
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
   private String edtEstaCivilCod_Internalname ;
   private String edtEstaCivilCod_Jsonclick ;
   private String divTablesplittedestacivilpais_Internalname ;
   private String lblTextblockestacivilpais_Internalname ;
   private String lblTextblockestacivilpais_Jsonclick ;
   private String Combo_estacivilpais_Caption ;
   private String Combo_estacivilpais_Cls ;
   private String Combo_estacivilpais_Datalistproc ;
   private String Combo_estacivilpais_Datalistprocparametersprefix ;
   private String Combo_estacivilpais_Internalname ;
   private String TempTags ;
   private String edtEstaCivilPais_Jsonclick ;
   private String edtEstaCivilDescrip_Internalname ;
   private String edtEstaCivilDescrip_Jsonclick ;
   private String edtEstaCivilDescripFem_Internalname ;
   private String edtEstaCivilDescripFem_Jsonclick ;
   private String edtEstaCivilCodFor_Internalname ;
   private String A2093EstaCivilCodFor ;
   private String edtEstaCivilCodFor_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_estacivilpais_Internalname ;
   private String edtavComboestacivilpais_Internalname ;
   private String edtavComboestacivilpais_Jsonclick ;
   private String AV22Pgmname ;
   private String Combo_estacivilpais_Objectcall ;
   private String Combo_estacivilpais_Class ;
   private String Combo_estacivilpais_Icontype ;
   private String Combo_estacivilpais_Icon ;
   private String Combo_estacivilpais_Tooltip ;
   private String Combo_estacivilpais_Selectedvalue_set ;
   private String Combo_estacivilpais_Selectedtext_set ;
   private String Combo_estacivilpais_Selectedtext_get ;
   private String Combo_estacivilpais_Gamoauthtoken ;
   private String Combo_estacivilpais_Ddointernalname ;
   private String Combo_estacivilpais_Titlecontrolalign ;
   private String Combo_estacivilpais_Dropdownoptionstype ;
   private String Combo_estacivilpais_Titlecontrolidtoreplace ;
   private String Combo_estacivilpais_Datalisttype ;
   private String Combo_estacivilpais_Datalistfixedvalues ;
   private String Combo_estacivilpais_Remoteservicesparameters ;
   private String Combo_estacivilpais_Htmltemplate ;
   private String Combo_estacivilpais_Multiplevaluestype ;
   private String Combo_estacivilpais_Loadingdata ;
   private String Combo_estacivilpais_Noresultsfound ;
   private String Combo_estacivilpais_Emptyitemtext ;
   private String Combo_estacivilpais_Onlyselectedvalues ;
   private String Combo_estacivilpais_Selectalltext ;
   private String Combo_estacivilpais_Multiplevaluesseparator ;
   private String Combo_estacivilpais_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode236 ;
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
   private boolean Z2272EstaCivilCasadoEs ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A2272EstaCivilCasadoEs ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_estacivilpais_Emptyitem ;
   private boolean Combo_estacivilpais_Enabled ;
   private boolean Combo_estacivilpais_Visible ;
   private boolean Combo_estacivilpais_Allowmultipleselection ;
   private boolean Combo_estacivilpais_Isgriditem ;
   private boolean Combo_estacivilpais_Hasdescription ;
   private boolean Combo_estacivilpais_Includeonlyselectedoption ;
   private boolean Combo_estacivilpais_Includeselectalloption ;
   private boolean Combo_estacivilpais_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String AV19Combo_DataJson ;
   private String Z1749EstaCivilDescrip ;
   private String Z1751EstaCivilDescripFem ;
   private String A1749EstaCivilDescrip ;
   private String A1751EstaCivilDescripFem ;
   private String AV17ComboSelectedValue ;
   private String AV18ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_estacivilpais ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkEstaCivilCasadoEs ;
   private IDataStoreProvider pr_default ;
   private short[] T00545_A1748EstaCivilCod ;
   private String[] T00545_A1749EstaCivilDescrip ;
   private String[] T00545_A1751EstaCivilDescripFem ;
   private String[] T00545_A2093EstaCivilCodFor ;
   private boolean[] T00545_A2272EstaCivilCasadoEs ;
   private short[] T00545_A1747EstaCivilPais ;
   private short[] T00546_A1747EstaCivilPais ;
   private short[] T00544_A1747EstaCivilPais ;
   private short[] T00547_A1747EstaCivilPais ;
   private short[] T00548_A1748EstaCivilCod ;
   private short[] T00543_A1748EstaCivilCod ;
   private String[] T00543_A1749EstaCivilDescrip ;
   private String[] T00543_A1751EstaCivilDescripFem ;
   private String[] T00543_A2093EstaCivilCodFor ;
   private boolean[] T00543_A2272EstaCivilCasadoEs ;
   private short[] T00543_A1747EstaCivilPais ;
   private short[] T00549_A1748EstaCivilCod ;
   private short[] T005410_A1748EstaCivilCod ;
   private short[] T00542_A1748EstaCivilCod ;
   private String[] T00542_A1749EstaCivilDescrip ;
   private String[] T00542_A1751EstaCivilDescripFem ;
   private String[] T00542_A2093EstaCivilCodFor ;
   private boolean[] T00542_A2272EstaCivilCasadoEs ;
   private short[] T00542_A1747EstaCivilPais ;
   private short[] T005412_A1748EstaCivilCod ;
   private int[] T005415_A3CliCod ;
   private short[] T005415_A1EmpCod ;
   private int[] T005415_A6LegNumero ;
   private short[] T005416_A1748EstaCivilCod ;
   private short[] T005417_A1747EstaCivilPais ;
   private short[] T005418_A1747EstaCivilPais ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15EstaCivilPais_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class estados_civiles__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00542", "SELECT EstaCivilCod, EstaCivilDescrip, EstaCivilDescripFem, EstaCivilCodFor, EstaCivilCasadoEs, EstaCivilPais FROM Estados_civiles WHERE EstaCivilCod = ?  FOR UPDATE OF Estados_civiles NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00543", "SELECT EstaCivilCod, EstaCivilDescrip, EstaCivilDescripFem, EstaCivilCodFor, EstaCivilCasadoEs, EstaCivilPais FROM Estados_civiles WHERE EstaCivilCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00544", "SELECT PaiCod AS EstaCivilPais FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00545", "SELECT TM1.EstaCivilCod, TM1.EstaCivilDescrip, TM1.EstaCivilDescripFem, TM1.EstaCivilCodFor, TM1.EstaCivilCasadoEs, TM1.EstaCivilPais AS EstaCivilPais FROM Estados_civiles TM1 WHERE TM1.EstaCivilCod = ? ORDER BY TM1.EstaCivilCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00546", "SELECT EstaCivilPais FROM Estados_civiles WHERE (EstaCivilPais = ? AND EstaCivilCodFor = ?) AND (Not ( EstaCivilCod = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00547", "SELECT PaiCod AS EstaCivilPais FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00548", "SELECT EstaCivilCod FROM Estados_civiles WHERE EstaCivilCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00549", "SELECT EstaCivilCod FROM Estados_civiles WHERE ( EstaCivilCod > ?) ORDER BY EstaCivilCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005410", "SELECT EstaCivilCod FROM Estados_civiles WHERE ( EstaCivilCod < ?) ORDER BY EstaCivilCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005411", "SAVEPOINT gxupdate;INSERT INTO Estados_civiles(EstaCivilDescrip, EstaCivilDescripFem, EstaCivilCodFor, EstaCivilCasadoEs, EstaCivilPais) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005412", "SELECT currval('EstaCivilCod') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T005413", "SAVEPOINT gxupdate;UPDATE Estados_civiles SET EstaCivilDescrip=?, EstaCivilDescripFem=?, EstaCivilCodFor=?, EstaCivilCasadoEs=?, EstaCivilPais=?  WHERE EstaCivilCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005414", "SAVEPOINT gxupdate;DELETE FROM Estados_civiles  WHERE EstaCivilCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005415", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE LegEstadoCivil = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005416", "SELECT EstaCivilCod FROM Estados_civiles ORDER BY EstaCivilCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005417", "SELECT PaiCod AS EstaCivilPais FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005418", "SELECT EstaCivilPais FROM Estados_civiles WHERE (EstaCivilPais = ? AND EstaCivilCodFor = ?) AND (Not ( EstaCivilCod = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 16 :
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

