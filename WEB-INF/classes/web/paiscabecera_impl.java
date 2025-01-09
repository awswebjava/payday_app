package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class paiscabecera_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_13") == 0 )
      {
         A1252PaiReligDefault = httpContext.GetPar( "PaiReligDefault") ;
         n1252PaiReligDefault = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1252PaiReligDefault", A1252PaiReligDefault);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_13( A1252PaiReligDefault) ;
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
            AV7PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7PaiCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Pais Cabecera", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public paiscabecera_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public paiscabecera_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paiscabecera_impl.class ));
   }

   public paiscabecera_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbPaiDiaHsPExt = new HTMLChoice();
      cmbPaiPerVacDes = new HTMLChoice();
      cmbPaiPerVacHas = new HTMLChoice();
      chkPaiExcVizzoti = UIFactory.getCheckbox(this);
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
      if ( cmbPaiDiaHsPExt.getItemCount() > 0 )
      {
         A1272PaiDiaHsPExt = cmbPaiDiaHsPExt.getValidValue(A1272PaiDiaHsPExt) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1272PaiDiaHsPExt", A1272PaiDiaHsPExt);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiDiaHsPExt.setValue( GXutil.rtrim( A1272PaiDiaHsPExt) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiDiaHsPExt.getInternalname(), "Values", cmbPaiDiaHsPExt.ToJavascriptSource(), true);
      }
      if ( cmbPaiPerVacDes.getItemCount() > 0 )
      {
         A1521PaiPerVacDes = (byte)(GXutil.lval( cmbPaiPerVacDes.getValidValue(GXutil.trim( GXutil.str( A1521PaiPerVacDes, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1521PaiPerVacDes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1521PaiPerVacDes), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiPerVacDes.setValue( GXutil.trim( GXutil.str( A1521PaiPerVacDes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiPerVacDes.getInternalname(), "Values", cmbPaiPerVacDes.ToJavascriptSource(), true);
      }
      if ( cmbPaiPerVacHas.getItemCount() > 0 )
      {
         A1522PaiPerVacHas = (byte)(GXutil.lval( cmbPaiPerVacHas.getValidValue(GXutil.trim( GXutil.str( A1522PaiPerVacHas, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1522PaiPerVacHas", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1522PaiPerVacHas), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiPerVacHas.setValue( GXutil.trim( GXutil.str( A1522PaiPerVacHas, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiPerVacHas.getInternalname(), "Values", cmbPaiPerVacHas.ToJavascriptSource(), true);
      }
      A1736PaiExcVizzoti = GXutil.strtobool( GXutil.booltostr( A1736PaiExcVizzoti)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1736PaiExcVizzoti", A1736PaiExcVizzoti);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiCod_Internalname, httpContext.getMessage( "Cod. Pais", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_PaisCabecera.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiNom_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiNom_Internalname, httpContext.getMessage( "Nom. Pais", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiNom_Internalname, A312PaiNom, GXutil.rtrim( localUtil.format( A312PaiNom, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiNom_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiNom_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_PaisCabecera.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedpaireligdefault_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockpaireligdefault_Internalname, httpContext.getMessage( "Relig Default", ""), "", "", lblTextblockpaireligdefault_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_PaisCabecera.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_paireligdefault.setProperty("Caption", Combo_paireligdefault_Caption);
      ucCombo_paireligdefault.setProperty("Cls", Combo_paireligdefault_Cls);
      ucCombo_paireligdefault.setProperty("DataListProc", Combo_paireligdefault_Datalistproc);
      ucCombo_paireligdefault.setProperty("DataListProcParametersPrefix", Combo_paireligdefault_Datalistprocparametersprefix);
      ucCombo_paireligdefault.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_paireligdefault.setProperty("DropDownOptionsData", AV15PaiReligDefault_Data);
      ucCombo_paireligdefault.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_paireligdefault_Internalname, "COMBO_PAIRELIGDEFAULTContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiReligDefault_Internalname, httpContext.getMessage( "Pai Relig Default", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiReligDefault_Internalname, GXutil.rtrim( A1252PaiReligDefault), GXutil.rtrim( localUtil.format( A1252PaiReligDefault, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiReligDefault_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiReligDefault_Visible, edtPaiReligDefault_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PaisCabecera.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiMesHsPExt_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiMesHsPExt_Internalname, httpContext.getMessage( "Cantidad de horas del mes para cálculo 1 hora de trabajo para empleados de clase mensual", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiMesHsPExt_Internalname, GXutil.ltrim( localUtil.ntoc( A1271PaiMesHsPExt, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiMesHsPExt_Enabled!=0) ? localUtil.format( A1271PaiMesHsPExt, "ZZ9.9") : localUtil.format( A1271PaiMesHsPExt, "ZZ9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiMesHsPExt_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiMesHsPExt_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisCabecera.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiDiaHsPExt.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbPaiDiaHsPExt.getInternalname(), httpContext.getMessage( "Días habiles del mes para obtener cantidad de horas del mes para cálculo de 1 hora de trabajo para empleados de clase mensual", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiDiaHsPExt, cmbPaiDiaHsPExt.getInternalname(), GXutil.rtrim( A1272PaiDiaHsPExt), 1, cmbPaiDiaHsPExt.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPaiDiaHsPExt.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "", true, (byte)(0), "HLP_PaisCabecera.htm");
      cmbPaiDiaHsPExt.setValue( GXutil.rtrim( A1272PaiDiaHsPExt) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiDiaHsPExt.getInternalname(), "Values", cmbPaiDiaHsPExt.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiMaxHorNor_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiMaxHorNor_Internalname, httpContext.getMessage( "Máximo de horas normales por día", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiMaxHorNor_Internalname, GXutil.ltrim( localUtil.ntoc( A1405PaiMaxHorNor, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiMaxHorNor_Enabled!=0) ? localUtil.format( A1405PaiMaxHorNor, "Z9.9") : localUtil.format( A1405PaiMaxHorNor, "Z9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiMaxHorNor_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiMaxHorNor_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisCabecera.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiPerVacDes.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbPaiPerVacDes.getInternalname(), httpContext.getMessage( "Periodo de vacaciones desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiPerVacDes, cmbPaiPerVacDes.getInternalname(), GXutil.trim( GXutil.str( A1521PaiPerVacDes, 2, 0)), 1, cmbPaiPerVacDes.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbPaiPerVacDes.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", "", true, (byte)(0), "HLP_PaisCabecera.htm");
      cmbPaiPerVacDes.setValue( GXutil.trim( GXutil.str( A1521PaiPerVacDes, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiPerVacDes.getInternalname(), "Values", cmbPaiPerVacDes.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiPerVacHas.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbPaiPerVacHas.getInternalname(), httpContext.getMessage( "Periodo de vacaciones hasta", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiPerVacHas, cmbPaiPerVacHas.getInternalname(), GXutil.trim( GXutil.str( A1522PaiPerVacHas, 2, 0)), 1, cmbPaiPerVacHas.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbPaiPerVacHas.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "", true, (byte)(0), "HLP_PaisCabecera.htm");
      cmbPaiPerVacHas.setValue( GXutil.trim( GXutil.str( A1522PaiPerVacHas, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiPerVacHas.getInternalname(), "Values", cmbPaiPerVacHas.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiGuarEdadMin_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiGuarEdadMin_Internalname, httpContext.getMessage( "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiGuarEdadMin_Internalname, GXutil.ltrim( localUtil.ntoc( A1625PaiGuarEdadMin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiGuarEdadMin_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1625PaiGuarEdadMin), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1625PaiGuarEdadMin), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiGuarEdadMin_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiGuarEdadMin_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisCabecera.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiGuarEdadMax_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiGuarEdadMax_Internalname, httpContext.getMessage( "Edad máxima del hijo/hija hasta la que puede gozar el beneficio de guardería", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiGuarEdadMax_Internalname, GXutil.ltrim( localUtil.ntoc( A1626PaiGuarEdadMax, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiGuarEdadMax_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1626PaiGuarEdadMax), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1626PaiGuarEdadMax), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,73);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiGuarEdadMax_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiGuarEdadMax_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisCabecera.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiExcVizzoti.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkPaiExcVizzoti.getInternalname(), httpContext.getMessage( "Considerar excepción a uso de tope (fallo Vizzoti)", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiExcVizzoti.getInternalname(), GXutil.booltostr( A1736PaiExcVizzoti), "", httpContext.getMessage( "Considerar excepción a uso de tope (fallo Vizzoti)", ""), 1, chkPaiExcVizzoti.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(78, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,78);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiVizzoti_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiVizzoti_Internalname, httpContext.getMessage( "Proporción de sueldo para evaluar tope (fallo Vizzoti)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiVizzoti_Internalname, GXutil.ltrim( localUtil.ntoc( A1737PaiVizzoti, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiVizzoti_Enabled!=0) ? localUtil.format( A1737PaiVizzoti, "9.9999") : localUtil.format( A1737PaiVizzoti, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,83);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiVizzoti_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiVizzoti_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_PaisCabecera.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 91,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisCabecera.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisCabecera.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 95,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisCabecera.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_paireligdefault_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombopaireligdefault_Internalname, GXutil.rtrim( AV20ComboPaiReligDefault), GXutil.rtrim( localUtil.format( AV20ComboPaiReligDefault, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombopaireligdefault_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombopaireligdefault_Visible, edtavCombopaireligdefault_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PaisCabecera.htm");
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
      e114S2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPAIRELIGDEFAULT_DATA"), AV15PaiReligDefault_Data);
            /* Read saved values. */
            Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z312PaiNom = httpContext.cgiGet( "Z312PaiNom") ;
            Z1271PaiMesHsPExt = localUtil.ctond( httpContext.cgiGet( "Z1271PaiMesHsPExt")) ;
            Z1272PaiDiaHsPExt = httpContext.cgiGet( "Z1272PaiDiaHsPExt") ;
            Z1405PaiMaxHorNor = localUtil.ctond( httpContext.cgiGet( "Z1405PaiMaxHorNor")) ;
            Z1521PaiPerVacDes = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1521PaiPerVacDes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1522PaiPerVacHas = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1522PaiPerVacHas"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1625PaiGuarEdadMin = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1625PaiGuarEdadMin"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1626PaiGuarEdadMax = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1626PaiGuarEdadMax"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1736PaiExcVizzoti = GXutil.strtobool( httpContext.cgiGet( "Z1736PaiExcVizzoti")) ;
            Z1737PaiVizzoti = localUtil.ctond( httpContext.cgiGet( "Z1737PaiVizzoti")) ;
            Z1252PaiReligDefault = httpContext.cgiGet( "Z1252PaiReligDefault") ;
            n1252PaiReligDefault = ((GXutil.strcmp("", A1252PaiReligDefault)==0) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1252PaiReligDefault = httpContext.cgiGet( "N1252PaiReligDefault") ;
            n1252PaiReligDefault = ((GXutil.strcmp("", A1252PaiReligDefault)==0) ? true : false) ;
            AV7PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV13Insert_PaiReligDefault = httpContext.cgiGet( "vINSERT_PAIRELIGDEFAULT") ;
            AV22Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_paireligdefault_Objectcall = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Objectcall") ;
            Combo_paireligdefault_Class = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Class") ;
            Combo_paireligdefault_Icontype = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Icontype") ;
            Combo_paireligdefault_Icon = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Icon") ;
            Combo_paireligdefault_Caption = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Caption") ;
            Combo_paireligdefault_Tooltip = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Tooltip") ;
            Combo_paireligdefault_Cls = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Cls") ;
            Combo_paireligdefault_Selectedvalue_set = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Selectedvalue_set") ;
            Combo_paireligdefault_Selectedvalue_get = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Selectedvalue_get") ;
            Combo_paireligdefault_Selectedtext_set = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Selectedtext_set") ;
            Combo_paireligdefault_Selectedtext_get = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Selectedtext_get") ;
            Combo_paireligdefault_Gamoauthtoken = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Gamoauthtoken") ;
            Combo_paireligdefault_Ddointernalname = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Ddointernalname") ;
            Combo_paireligdefault_Titlecontrolalign = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Titlecontrolalign") ;
            Combo_paireligdefault_Dropdownoptionstype = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Dropdownoptionstype") ;
            Combo_paireligdefault_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Enabled")) ;
            Combo_paireligdefault_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Visible")) ;
            Combo_paireligdefault_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Titlecontrolidtoreplace") ;
            Combo_paireligdefault_Datalisttype = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Datalisttype") ;
            Combo_paireligdefault_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Allowmultipleselection")) ;
            Combo_paireligdefault_Datalistfixedvalues = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Datalistfixedvalues") ;
            Combo_paireligdefault_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Isgriditem")) ;
            Combo_paireligdefault_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Hasdescription")) ;
            Combo_paireligdefault_Datalistproc = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Datalistproc") ;
            Combo_paireligdefault_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Datalistprocparametersprefix") ;
            Combo_paireligdefault_Remoteservicesparameters = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Remoteservicesparameters") ;
            Combo_paireligdefault_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_paireligdefault_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Includeonlyselectedoption")) ;
            Combo_paireligdefault_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Includeselectalloption")) ;
            Combo_paireligdefault_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Emptyitem")) ;
            Combo_paireligdefault_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Includeaddnewoption")) ;
            Combo_paireligdefault_Htmltemplate = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Htmltemplate") ;
            Combo_paireligdefault_Multiplevaluestype = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Multiplevaluestype") ;
            Combo_paireligdefault_Loadingdata = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Loadingdata") ;
            Combo_paireligdefault_Noresultsfound = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Noresultsfound") ;
            Combo_paireligdefault_Emptyitemtext = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Emptyitemtext") ;
            Combo_paireligdefault_Onlyselectedvalues = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Onlyselectedvalues") ;
            Combo_paireligdefault_Selectalltext = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Selectalltext") ;
            Combo_paireligdefault_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Multiplevaluesseparator") ;
            Combo_paireligdefault_Addnewoptiontext = httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Addnewoptiontext") ;
            Combo_paireligdefault_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PAIRELIGDEFAULT_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A46PaiCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            else
            {
               A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            A312PaiNom = GXutil.upper( httpContext.cgiGet( edtPaiNom_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A312PaiNom", A312PaiNom);
            A1252PaiReligDefault = httpContext.cgiGet( edtPaiReligDefault_Internalname) ;
            n1252PaiReligDefault = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1252PaiReligDefault", A1252PaiReligDefault);
            n1252PaiReligDefault = ((GXutil.strcmp("", A1252PaiReligDefault)==0) ? true : false) ;
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPaiMesHsPExt_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPaiMesHsPExt_Internalname)), DecimalUtil.stringToDec("999.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAIMESHSPEXT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiMesHsPExt_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1271PaiMesHsPExt = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1271PaiMesHsPExt", GXutil.ltrimstr( A1271PaiMesHsPExt, 5, 1));
            }
            else
            {
               A1271PaiMesHsPExt = localUtil.ctond( httpContext.cgiGet( edtPaiMesHsPExt_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1271PaiMesHsPExt", GXutil.ltrimstr( A1271PaiMesHsPExt, 5, 1));
            }
            cmbPaiDiaHsPExt.setValue( httpContext.cgiGet( cmbPaiDiaHsPExt.getInternalname()) );
            A1272PaiDiaHsPExt = httpContext.cgiGet( cmbPaiDiaHsPExt.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1272PaiDiaHsPExt", A1272PaiDiaHsPExt);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPaiMaxHorNor_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPaiMaxHorNor_Internalname)), DecimalUtil.stringToDec("99.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAIMAXHORNOR");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiMaxHorNor_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1405PaiMaxHorNor = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1405PaiMaxHorNor", GXutil.ltrimstr( A1405PaiMaxHorNor, 4, 1));
            }
            else
            {
               A1405PaiMaxHorNor = localUtil.ctond( httpContext.cgiGet( edtPaiMaxHorNor_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1405PaiMaxHorNor", GXutil.ltrimstr( A1405PaiMaxHorNor, 4, 1));
            }
            cmbPaiPerVacDes.setValue( httpContext.cgiGet( cmbPaiPerVacDes.getInternalname()) );
            A1521PaiPerVacDes = (byte)(GXutil.lval( httpContext.cgiGet( cmbPaiPerVacDes.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1521PaiPerVacDes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1521PaiPerVacDes), 2, 0));
            cmbPaiPerVacHas.setValue( httpContext.cgiGet( cmbPaiPerVacHas.getInternalname()) );
            A1522PaiPerVacHas = (byte)(GXutil.lval( httpContext.cgiGet( cmbPaiPerVacHas.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1522PaiPerVacHas", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1522PaiPerVacHas), 2, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiGuarEdadMin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiGuarEdadMin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAIGUAREDADMIN");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiGuarEdadMin_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1625PaiGuarEdadMin = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1625PaiGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1625PaiGuarEdadMin), 2, 0));
            }
            else
            {
               A1625PaiGuarEdadMin = (byte)(localUtil.ctol( httpContext.cgiGet( edtPaiGuarEdadMin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1625PaiGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1625PaiGuarEdadMin), 2, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiGuarEdadMax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiGuarEdadMax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAIGUAREDADMAX");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiGuarEdadMax_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1626PaiGuarEdadMax = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1626PaiGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1626PaiGuarEdadMax), 2, 0));
            }
            else
            {
               A1626PaiGuarEdadMax = (byte)(localUtil.ctol( httpContext.cgiGet( edtPaiGuarEdadMax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1626PaiGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1626PaiGuarEdadMax), 2, 0));
            }
            A1736PaiExcVizzoti = GXutil.strtobool( httpContext.cgiGet( chkPaiExcVizzoti.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1736PaiExcVizzoti", A1736PaiExcVizzoti);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPaiVizzoti_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPaiVizzoti_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAIVIZZOTI");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiVizzoti_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1737PaiVizzoti = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1737PaiVizzoti", GXutil.ltrimstr( A1737PaiVizzoti, 6, 4));
            }
            else
            {
               A1737PaiVizzoti = localUtil.ctond( httpContext.cgiGet( edtPaiVizzoti_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1737PaiVizzoti", GXutil.ltrimstr( A1737PaiVizzoti, 6, 4));
            }
            AV20ComboPaiReligDefault = httpContext.cgiGet( edtavCombopaireligdefault_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboPaiReligDefault", AV20ComboPaiReligDefault);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"PaisCabecera");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A46PaiCod != Z46PaiCod ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("paiscabecera:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
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
                  sMode38 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode38 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound38 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_4S0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "PAICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPaiCod_Internalname ;
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
                        e114S2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e124S2 ();
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
         e124S2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll4S38( ) ;
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
         disableAttributes4S38( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopaireligdefault_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopaireligdefault_Enabled), 5, 0), true);
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

   public void confirm_4S0( )
   {
      beforeValidate4S38( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4S38( ) ;
         }
         else
         {
            checkExtendedTable4S38( ) ;
            closeExtendedTableCursors4S38( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption4S0( )
   {
   }

   public void e114S2( )
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
      edtPaiReligDefault_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiReligDefault_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiReligDefault_Visible), 5, 0), true);
      AV20ComboPaiReligDefault = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboPaiReligDefault", AV20ComboPaiReligDefault);
      edtavCombopaireligdefault_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopaireligdefault_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopaireligdefault_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOPAIRELIGDEFAULT' */
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisCabecera_Insert", GXv_boolean5) ;
         paiscabecera_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisCabecera_Update", GXv_boolean5) ;
         paiscabecera_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisCabecera_Delete", GXv_boolean5) ;
         paiscabecera_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PaiReligDefault") == 0 )
            {
               AV13Insert_PaiReligDefault = AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_PaiReligDefault", AV13Insert_PaiReligDefault);
               if ( ! (GXutil.strcmp("", AV13Insert_PaiReligDefault)==0) )
               {
                  AV20ComboPaiReligDefault = AV13Insert_PaiReligDefault ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboPaiReligDefault", AV20ComboPaiReligDefault);
                  Combo_paireligdefault_Selectedvalue_set = AV20ComboPaiReligDefault ;
                  ucCombo_paireligdefault.sendProperty(context, "", false, Combo_paireligdefault_Internalname, "SelectedValue_set", Combo_paireligdefault_Selectedvalue_set);
                  GXt_char6 = AV19Combo_DataJson ;
                  GXv_char7[0] = AV17ComboSelectedValue ;
                  GXv_char8[0] = AV18ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.paiscabeceraloaddvcombo(remoteHandle, context).execute( "PaiReligDefault", "GET", false, AV7PaiCod, AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  paiscabecera_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
                  paiscabecera_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
                  paiscabecera_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
                  AV19Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
                  Combo_paireligdefault_Selectedtext_set = AV18ComboSelectedText ;
                  ucCombo_paireligdefault.sendProperty(context, "", false, Combo_paireligdefault_Internalname, "SelectedText_set", Combo_paireligdefault_Selectedtext_set);
                  Combo_paireligdefault_Enabled = false ;
                  ucCombo_paireligdefault.sendProperty(context, "", false, Combo_paireligdefault_Internalname, "Enabled", GXutil.booltostr( Combo_paireligdefault_Enabled));
               }
            }
            AV23GXV1 = (int)(AV23GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         }
      }
   }

   public void e124S2( )
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
      /* 'LOADCOMBOPAIRELIGDEFAULT' Routine */
      returnInSub = false ;
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char9[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.paiscabeceraloaddvcombo(remoteHandle, context).execute( "PaiReligDefault", Gx_mode, false, AV7PaiCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      paiscabecera_impl.this.AV17ComboSelectedValue = GXv_char9[0] ;
      paiscabecera_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      paiscabecera_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
      AV19Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
      Combo_paireligdefault_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_paireligdefault.sendProperty(context, "", false, Combo_paireligdefault_Internalname, "SelectedValue_set", Combo_paireligdefault_Selectedvalue_set);
      Combo_paireligdefault_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_paireligdefault.sendProperty(context, "", false, Combo_paireligdefault_Internalname, "SelectedText_set", Combo_paireligdefault_Selectedtext_set);
      AV20ComboPaiReligDefault = AV17ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboPaiReligDefault", AV20ComboPaiReligDefault);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_paireligdefault_Enabled = false ;
         ucCombo_paireligdefault.sendProperty(context, "", false, Combo_paireligdefault_Internalname, "Enabled", GXutil.booltostr( Combo_paireligdefault_Enabled));
      }
   }

   public void zm4S38( int GX_JID )
   {
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z312PaiNom = T004S3_A312PaiNom[0] ;
            Z1271PaiMesHsPExt = T004S3_A1271PaiMesHsPExt[0] ;
            Z1272PaiDiaHsPExt = T004S3_A1272PaiDiaHsPExt[0] ;
            Z1405PaiMaxHorNor = T004S3_A1405PaiMaxHorNor[0] ;
            Z1521PaiPerVacDes = T004S3_A1521PaiPerVacDes[0] ;
            Z1522PaiPerVacHas = T004S3_A1522PaiPerVacHas[0] ;
            Z1625PaiGuarEdadMin = T004S3_A1625PaiGuarEdadMin[0] ;
            Z1626PaiGuarEdadMax = T004S3_A1626PaiGuarEdadMax[0] ;
            Z1736PaiExcVizzoti = T004S3_A1736PaiExcVizzoti[0] ;
            Z1737PaiVizzoti = T004S3_A1737PaiVizzoti[0] ;
            Z1252PaiReligDefault = T004S3_A1252PaiReligDefault[0] ;
         }
         else
         {
            Z312PaiNom = A312PaiNom ;
            Z1271PaiMesHsPExt = A1271PaiMesHsPExt ;
            Z1272PaiDiaHsPExt = A1272PaiDiaHsPExt ;
            Z1405PaiMaxHorNor = A1405PaiMaxHorNor ;
            Z1521PaiPerVacDes = A1521PaiPerVacDes ;
            Z1522PaiPerVacHas = A1522PaiPerVacHas ;
            Z1625PaiGuarEdadMin = A1625PaiGuarEdadMin ;
            Z1626PaiGuarEdadMax = A1626PaiGuarEdadMax ;
            Z1736PaiExcVizzoti = A1736PaiExcVizzoti ;
            Z1737PaiVizzoti = A1737PaiVizzoti ;
            Z1252PaiReligDefault = A1252PaiReligDefault ;
         }
      }
      if ( GX_JID == -12 )
      {
         Z46PaiCod = A46PaiCod ;
         Z312PaiNom = A312PaiNom ;
         Z1271PaiMesHsPExt = A1271PaiMesHsPExt ;
         Z1272PaiDiaHsPExt = A1272PaiDiaHsPExt ;
         Z1405PaiMaxHorNor = A1405PaiMaxHorNor ;
         Z1521PaiPerVacDes = A1521PaiPerVacDes ;
         Z1522PaiPerVacHas = A1522PaiPerVacHas ;
         Z1625PaiGuarEdadMin = A1625PaiGuarEdadMin ;
         Z1626PaiGuarEdadMax = A1626PaiGuarEdadMax ;
         Z1736PaiExcVizzoti = A1736PaiExcVizzoti ;
         Z1737PaiVizzoti = A1737PaiVizzoti ;
         Z1252PaiReligDefault = A1252PaiReligDefault ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7PaiCod) )
      {
         A46PaiCod = AV7PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      if ( ! (0==AV7PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      else
      {
         edtPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV13Insert_PaiReligDefault)==0) )
      {
         edtPaiReligDefault_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiReligDefault_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiReligDefault_Enabled), 5, 0), true);
      }
      else
      {
         edtPaiReligDefault_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiReligDefault_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiReligDefault_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV13Insert_PaiReligDefault)==0) )
      {
         A1252PaiReligDefault = AV13Insert_PaiReligDefault ;
         n1252PaiReligDefault = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1252PaiReligDefault", A1252PaiReligDefault);
      }
      else
      {
         if ( (GXutil.strcmp("", AV20ComboPaiReligDefault)==0) )
         {
            A1252PaiReligDefault = "" ;
            n1252PaiReligDefault = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1252PaiReligDefault", A1252PaiReligDefault);
            n1252PaiReligDefault = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A1252PaiReligDefault", A1252PaiReligDefault);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV20ComboPaiReligDefault)==0) )
            {
               A1252PaiReligDefault = AV20ComboPaiReligDefault ;
               n1252PaiReligDefault = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1252PaiReligDefault", A1252PaiReligDefault);
            }
         }
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
         AV22Pgmname = "PaisCabecera" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
   }

   public void load4S38( )
   {
      /* Using cursor T004S5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A312PaiNom = T004S5_A312PaiNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A312PaiNom", A312PaiNom);
         A1271PaiMesHsPExt = T004S5_A1271PaiMesHsPExt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1271PaiMesHsPExt", GXutil.ltrimstr( A1271PaiMesHsPExt, 5, 1));
         A1272PaiDiaHsPExt = T004S5_A1272PaiDiaHsPExt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1272PaiDiaHsPExt", A1272PaiDiaHsPExt);
         A1405PaiMaxHorNor = T004S5_A1405PaiMaxHorNor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1405PaiMaxHorNor", GXutil.ltrimstr( A1405PaiMaxHorNor, 4, 1));
         A1521PaiPerVacDes = T004S5_A1521PaiPerVacDes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1521PaiPerVacDes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1521PaiPerVacDes), 2, 0));
         A1522PaiPerVacHas = T004S5_A1522PaiPerVacHas[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1522PaiPerVacHas", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1522PaiPerVacHas), 2, 0));
         A1625PaiGuarEdadMin = T004S5_A1625PaiGuarEdadMin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1625PaiGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1625PaiGuarEdadMin), 2, 0));
         A1626PaiGuarEdadMax = T004S5_A1626PaiGuarEdadMax[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1626PaiGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1626PaiGuarEdadMax), 2, 0));
         A1736PaiExcVizzoti = T004S5_A1736PaiExcVizzoti[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1736PaiExcVizzoti", A1736PaiExcVizzoti);
         A1737PaiVizzoti = T004S5_A1737PaiVizzoti[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1737PaiVizzoti", GXutil.ltrimstr( A1737PaiVizzoti, 6, 4));
         A1252PaiReligDefault = T004S5_A1252PaiReligDefault[0] ;
         n1252PaiReligDefault = T004S5_n1252PaiReligDefault[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1252PaiReligDefault", A1252PaiReligDefault);
         zm4S38( -12) ;
      }
      pr_default.close(3);
      onLoadActions4S38( ) ;
   }

   public void onLoadActions4S38( )
   {
      AV22Pgmname = "PaisCabecera" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
   }

   public void checkExtendedTable4S38( )
   {
      nIsDirty_38 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV22Pgmname = "PaisCabecera" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      /* Using cursor T004S4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n1252PaiReligDefault), A1252PaiReligDefault});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A1252PaiReligDefault)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais Religion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAIRELIGDEFAULT");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiReligDefault_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A1272PaiDiaHsPExt, "Promedio") == 0 ) || ( GXutil.strcmp(A1272PaiDiaHsPExt, "diasSemanaX4") == 0 ) || ( GXutil.strcmp(A1272PaiDiaHsPExt, "diasSemanaMes") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Días habiles del mes para obtener cantidad de horas del mes para cálculo de 1 hora de trabajo para empleados de clase mensual", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAIDIAHSPEXT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiDiaHsPExt.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A1521PaiPerVacDes == 1 ) || ( A1521PaiPerVacDes == 2 ) || ( A1521PaiPerVacDes == 3 ) || ( A1521PaiPerVacDes == 4 ) || ( A1521PaiPerVacDes == 5 ) || ( A1521PaiPerVacDes == 6 ) || ( A1521PaiPerVacDes == 7 ) || ( A1521PaiPerVacDes == 8 ) || ( A1521PaiPerVacDes == 9 ) || ( A1521PaiPerVacDes == 10 ) || ( A1521PaiPerVacDes == 11 ) || ( A1521PaiPerVacDes == 12 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Periodo de vacaciones desde", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAIPERVACDES");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiPerVacDes.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A1522PaiPerVacHas == 1 ) || ( A1522PaiPerVacHas == 2 ) || ( A1522PaiPerVacHas == 3 ) || ( A1522PaiPerVacHas == 4 ) || ( A1522PaiPerVacHas == 5 ) || ( A1522PaiPerVacHas == 6 ) || ( A1522PaiPerVacHas == 7 ) || ( A1522PaiPerVacHas == 8 ) || ( A1522PaiPerVacHas == 9 ) || ( A1522PaiPerVacHas == 10 ) || ( A1522PaiPerVacHas == 11 ) || ( A1522PaiPerVacHas == 12 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Periodo de vacaciones hasta", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAIPERVACHAS");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiPerVacHas.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors4S38( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_13( String A1252PaiReligDefault )
   {
      /* Using cursor T004S6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n1252PaiReligDefault), A1252PaiReligDefault});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A1252PaiReligDefault)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais Religion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAIRELIGDEFAULT");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiReligDefault_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
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

   public void getKey4S38( )
   {
      /* Using cursor T004S7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound38 = (short)(1) ;
      }
      else
      {
         RcdFound38 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T004S3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm4S38( 12) ;
         RcdFound38 = (short)(1) ;
         A46PaiCod = T004S3_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A312PaiNom = T004S3_A312PaiNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A312PaiNom", A312PaiNom);
         A1271PaiMesHsPExt = T004S3_A1271PaiMesHsPExt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1271PaiMesHsPExt", GXutil.ltrimstr( A1271PaiMesHsPExt, 5, 1));
         A1272PaiDiaHsPExt = T004S3_A1272PaiDiaHsPExt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1272PaiDiaHsPExt", A1272PaiDiaHsPExt);
         A1405PaiMaxHorNor = T004S3_A1405PaiMaxHorNor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1405PaiMaxHorNor", GXutil.ltrimstr( A1405PaiMaxHorNor, 4, 1));
         A1521PaiPerVacDes = T004S3_A1521PaiPerVacDes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1521PaiPerVacDes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1521PaiPerVacDes), 2, 0));
         A1522PaiPerVacHas = T004S3_A1522PaiPerVacHas[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1522PaiPerVacHas", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1522PaiPerVacHas), 2, 0));
         A1625PaiGuarEdadMin = T004S3_A1625PaiGuarEdadMin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1625PaiGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1625PaiGuarEdadMin), 2, 0));
         A1626PaiGuarEdadMax = T004S3_A1626PaiGuarEdadMax[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1626PaiGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1626PaiGuarEdadMax), 2, 0));
         A1736PaiExcVizzoti = T004S3_A1736PaiExcVizzoti[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1736PaiExcVizzoti", A1736PaiExcVizzoti);
         A1737PaiVizzoti = T004S3_A1737PaiVizzoti[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1737PaiVizzoti", GXutil.ltrimstr( A1737PaiVizzoti, 6, 4));
         A1252PaiReligDefault = T004S3_A1252PaiReligDefault[0] ;
         n1252PaiReligDefault = T004S3_n1252PaiReligDefault[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1252PaiReligDefault", A1252PaiReligDefault);
         Z46PaiCod = A46PaiCod ;
         sMode38 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load4S38( ) ;
         if ( AnyError == 1 )
         {
            RcdFound38 = (short)(0) ;
            initializeNonKey4S38( ) ;
         }
         Gx_mode = sMode38 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound38 = (short)(0) ;
         initializeNonKey4S38( ) ;
         sMode38 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode38 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey4S38( ) ;
      if ( RcdFound38 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound38 = (short)(0) ;
      /* Using cursor T004S8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T004S8_A46PaiCod[0] < A46PaiCod ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T004S8_A46PaiCod[0] > A46PaiCod ) ) )
         {
            A46PaiCod = T004S8_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            RcdFound38 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound38 = (short)(0) ;
      /* Using cursor T004S9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T004S9_A46PaiCod[0] > A46PaiCod ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T004S9_A46PaiCod[0] < A46PaiCod ) ) )
         {
            A46PaiCod = T004S9_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            RcdFound38 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4S38( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert4S38( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound38 == 1 )
         {
            if ( A46PaiCod != Z46PaiCod )
            {
               A46PaiCod = Z46PaiCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update4S38( ) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A46PaiCod != Z46PaiCod )
            {
               /* Insert record */
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert4S38( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PAICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert4S38( ) ;
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
      if ( A46PaiCod != Z46PaiCod )
      {
         A46PaiCod = Z46PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency4S38( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T004S2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pais"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z312PaiNom, T004S2_A312PaiNom[0]) != 0 ) || ( DecimalUtil.compareTo(Z1271PaiMesHsPExt, T004S2_A1271PaiMesHsPExt[0]) != 0 ) || ( GXutil.strcmp(Z1272PaiDiaHsPExt, T004S2_A1272PaiDiaHsPExt[0]) != 0 ) || ( DecimalUtil.compareTo(Z1405PaiMaxHorNor, T004S2_A1405PaiMaxHorNor[0]) != 0 ) || ( Z1521PaiPerVacDes != T004S2_A1521PaiPerVacDes[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1522PaiPerVacHas != T004S2_A1522PaiPerVacHas[0] ) || ( Z1625PaiGuarEdadMin != T004S2_A1625PaiGuarEdadMin[0] ) || ( Z1626PaiGuarEdadMax != T004S2_A1626PaiGuarEdadMax[0] ) || ( Z1736PaiExcVizzoti != T004S2_A1736PaiExcVizzoti[0] ) || ( DecimalUtil.compareTo(Z1737PaiVizzoti, T004S2_A1737PaiVizzoti[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1252PaiReligDefault, T004S2_A1252PaiReligDefault[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z312PaiNom, T004S2_A312PaiNom[0]) != 0 )
            {
               GXutil.writeLogln("paiscabecera:[seudo value changed for attri]"+"PaiNom");
               GXutil.writeLogRaw("Old: ",Z312PaiNom);
               GXutil.writeLogRaw("Current: ",T004S2_A312PaiNom[0]);
            }
            if ( DecimalUtil.compareTo(Z1271PaiMesHsPExt, T004S2_A1271PaiMesHsPExt[0]) != 0 )
            {
               GXutil.writeLogln("paiscabecera:[seudo value changed for attri]"+"PaiMesHsPExt");
               GXutil.writeLogRaw("Old: ",Z1271PaiMesHsPExt);
               GXutil.writeLogRaw("Current: ",T004S2_A1271PaiMesHsPExt[0]);
            }
            if ( GXutil.strcmp(Z1272PaiDiaHsPExt, T004S2_A1272PaiDiaHsPExt[0]) != 0 )
            {
               GXutil.writeLogln("paiscabecera:[seudo value changed for attri]"+"PaiDiaHsPExt");
               GXutil.writeLogRaw("Old: ",Z1272PaiDiaHsPExt);
               GXutil.writeLogRaw("Current: ",T004S2_A1272PaiDiaHsPExt[0]);
            }
            if ( DecimalUtil.compareTo(Z1405PaiMaxHorNor, T004S2_A1405PaiMaxHorNor[0]) != 0 )
            {
               GXutil.writeLogln("paiscabecera:[seudo value changed for attri]"+"PaiMaxHorNor");
               GXutil.writeLogRaw("Old: ",Z1405PaiMaxHorNor);
               GXutil.writeLogRaw("Current: ",T004S2_A1405PaiMaxHorNor[0]);
            }
            if ( Z1521PaiPerVacDes != T004S2_A1521PaiPerVacDes[0] )
            {
               GXutil.writeLogln("paiscabecera:[seudo value changed for attri]"+"PaiPerVacDes");
               GXutil.writeLogRaw("Old: ",Z1521PaiPerVacDes);
               GXutil.writeLogRaw("Current: ",T004S2_A1521PaiPerVacDes[0]);
            }
            if ( Z1522PaiPerVacHas != T004S2_A1522PaiPerVacHas[0] )
            {
               GXutil.writeLogln("paiscabecera:[seudo value changed for attri]"+"PaiPerVacHas");
               GXutil.writeLogRaw("Old: ",Z1522PaiPerVacHas);
               GXutil.writeLogRaw("Current: ",T004S2_A1522PaiPerVacHas[0]);
            }
            if ( Z1625PaiGuarEdadMin != T004S2_A1625PaiGuarEdadMin[0] )
            {
               GXutil.writeLogln("paiscabecera:[seudo value changed for attri]"+"PaiGuarEdadMin");
               GXutil.writeLogRaw("Old: ",Z1625PaiGuarEdadMin);
               GXutil.writeLogRaw("Current: ",T004S2_A1625PaiGuarEdadMin[0]);
            }
            if ( Z1626PaiGuarEdadMax != T004S2_A1626PaiGuarEdadMax[0] )
            {
               GXutil.writeLogln("paiscabecera:[seudo value changed for attri]"+"PaiGuarEdadMax");
               GXutil.writeLogRaw("Old: ",Z1626PaiGuarEdadMax);
               GXutil.writeLogRaw("Current: ",T004S2_A1626PaiGuarEdadMax[0]);
            }
            if ( Z1736PaiExcVizzoti != T004S2_A1736PaiExcVizzoti[0] )
            {
               GXutil.writeLogln("paiscabecera:[seudo value changed for attri]"+"PaiExcVizzoti");
               GXutil.writeLogRaw("Old: ",Z1736PaiExcVizzoti);
               GXutil.writeLogRaw("Current: ",T004S2_A1736PaiExcVizzoti[0]);
            }
            if ( DecimalUtil.compareTo(Z1737PaiVizzoti, T004S2_A1737PaiVizzoti[0]) != 0 )
            {
               GXutil.writeLogln("paiscabecera:[seudo value changed for attri]"+"PaiVizzoti");
               GXutil.writeLogRaw("Old: ",Z1737PaiVizzoti);
               GXutil.writeLogRaw("Current: ",T004S2_A1737PaiVizzoti[0]);
            }
            if ( GXutil.strcmp(Z1252PaiReligDefault, T004S2_A1252PaiReligDefault[0]) != 0 )
            {
               GXutil.writeLogln("paiscabecera:[seudo value changed for attri]"+"PaiReligDefault");
               GXutil.writeLogRaw("Old: ",Z1252PaiReligDefault);
               GXutil.writeLogRaw("Current: ",T004S2_A1252PaiReligDefault[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Pais"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4S38( )
   {
      beforeValidate4S38( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4S38( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4S38( 0) ;
         checkOptimisticConcurrency4S38( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4S38( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4S38( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004S10 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A46PaiCod), A312PaiNom, A1271PaiMesHsPExt, A1272PaiDiaHsPExt, A1405PaiMaxHorNor, Byte.valueOf(A1521PaiPerVacDes), Byte.valueOf(A1522PaiPerVacHas), Byte.valueOf(A1625PaiGuarEdadMin), Byte.valueOf(A1626PaiGuarEdadMax), Boolean.valueOf(A1736PaiExcVizzoti), A1737PaiVizzoti, Boolean.valueOf(n1252PaiReligDefault), A1252PaiReligDefault});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
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
                        resetCaption4S0( ) ;
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
            load4S38( ) ;
         }
         endLevel4S38( ) ;
      }
      closeExtendedTableCursors4S38( ) ;
   }

   public void update4S38( )
   {
      beforeValidate4S38( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4S38( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4S38( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4S38( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4S38( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004S11 */
                  pr_default.execute(9, new Object[] {A312PaiNom, A1271PaiMesHsPExt, A1272PaiDiaHsPExt, A1405PaiMaxHorNor, Byte.valueOf(A1521PaiPerVacDes), Byte.valueOf(A1522PaiPerVacHas), Byte.valueOf(A1625PaiGuarEdadMin), Byte.valueOf(A1626PaiGuarEdadMax), Boolean.valueOf(A1736PaiExcVizzoti), A1737PaiVizzoti, Boolean.valueOf(n1252PaiReligDefault), A1252PaiReligDefault, Short.valueOf(A46PaiCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pais"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4S38( ) ;
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
         endLevel4S38( ) ;
      }
      closeExtendedTableCursors4S38( ) ;
   }

   public void deferredUpdate4S38( )
   {
   }

   public void delete( )
   {
      beforeValidate4S38( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4S38( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4S38( ) ;
         afterConfirm4S38( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4S38( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T004S12 */
               pr_default.execute(10, new Object[] {Short.valueOf(A46PaiCod)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Pais");
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
      sMode38 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel4S38( ) ;
      Gx_mode = sMode38 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls4S38( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV22Pgmname = "PaisCabecera" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T004S13 */
         pr_default.execute(11, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Tipo De Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
         /* Using cursor T004S14 */
         pr_default.execute(12, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "MenuVersiones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
         /* Using cursor T004S15 */
         pr_default.execute(13, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Condiciones_concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor T004S16 */
         pr_default.execute(14, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
         /* Using cursor T004S17 */
         pr_default.execute(15, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor T004S18 */
         pr_default.execute(16, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
         /* Using cursor T004S19 */
         pr_default.execute(17, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Estado", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
         /* Using cursor T004S20 */
         pr_default.execute(18, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(18) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "CategoriaProvincias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
         /* Using cursor T004S21 */
         pr_default.execute(19, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(19) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(19);
         /* Using cursor T004S22 */
         pr_default.execute(20, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(20) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(20);
         /* Using cursor T004S23 */
         pr_default.execute(21, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(21) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "embargabilidad", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(21);
         /* Using cursor T004S24 */
         pr_default.execute(22, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo_obligacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
         /* Using cursor T004S25 */
         pr_default.execute(23, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(23) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "ART", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
         /* Using cursor T004S26 */
         pr_default.execute(24, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(24) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "adicional_actividad", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(24);
         /* Using cursor T004S27 */
         pr_default.execute(25, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(25) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "User", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
         /* Using cursor T004S28 */
         pr_default.execute(26, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "ActividadLaboralClasificada", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
         /* Using cursor T004S29 */
         pr_default.execute(27, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(27) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Vacaciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(27);
         /* Using cursor T004S30 */
         pr_default.execute(28, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(28) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "preaviso", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(28);
         /* Using cursor T004S31 */
         pr_default.execute(29, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(29) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Bases de cálculo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(29);
         /* Using cursor T004S32 */
         pr_default.execute(30, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(30) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Rango Etario", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(30);
         /* Using cursor T004S33 */
         pr_default.execute(31, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Promedio para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor T004S34 */
         pr_default.execute(32, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "conceptos_horanormal_jornalizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor T004S35 */
         pr_default.execute(33, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "conceptos_horanormal_mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor T004S36 */
         pr_default.execute(34, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "horasextras_pordia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor T004S37 */
         pr_default.execute(35, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Pais Tipo Trabajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
         /* Using cursor T004S38 */
         pr_default.execute(36, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(36) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Pais Origen", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
         /* Using cursor T004S39 */
         pr_default.execute(37, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(37) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Pais Religion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(37);
         /* Using cursor T004S40 */
         pr_default.execute(38, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(38) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "feriado", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(38);
         /* Using cursor T004S41 */
         pr_default.execute(39, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(39) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo_feriado", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(39);
         /* Using cursor T004S42 */
         pr_default.execute(40, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(40) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Adicional", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(40);
         /* Using cursor T004S43 */
         pr_default.execute(41, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(41) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Sindicato", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(41);
         /* Using cursor T004S44 */
         pr_default.execute(42, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(42) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Convenio", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(42);
         /* Using cursor T004S45 */
         pr_default.execute(43, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(43) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "calculo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(43);
         /* Using cursor T004S46 */
         pr_default.execute(44, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(44) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Provincia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(44);
         /* Using cursor T004S47 */
         pr_default.execute(45, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(45) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")+" ("+httpContext.getMessage( "Legajo Domicilio", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(45);
         /* Using cursor T004S48 */
         pr_default.execute(46, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(46) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")+" ("+httpContext.getMessage( "Legajo Nacionalidad", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(46);
         /* Using cursor T004S49 */
         pr_default.execute(47, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(47) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(47);
      }
   }

   public void endLevel4S38( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4S38( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "paiscabecera");
         if ( AnyError == 0 )
         {
            confirmValues4S0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "paiscabecera");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart4S38( )
   {
      /* Scan By routine */
      /* Using cursor T004S50 */
      pr_default.execute(48);
      RcdFound38 = (short)(0) ;
      if ( (pr_default.getStatus(48) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A46PaiCod = T004S50_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext4S38( )
   {
      /* Scan next routine */
      pr_default.readNext(48);
      RcdFound38 = (short)(0) ;
      if ( (pr_default.getStatus(48) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A46PaiCod = T004S50_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
   }

   public void scanEnd4S38( )
   {
      pr_default.close(48);
   }

   public void afterConfirm4S38( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert4S38( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4S38( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4S38( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4S38( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4S38( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4S38( )
   {
      edtPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      edtPaiNom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiNom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiNom_Enabled), 5, 0), true);
      edtPaiReligDefault_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiReligDefault_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiReligDefault_Enabled), 5, 0), true);
      edtPaiMesHsPExt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiMesHsPExt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiMesHsPExt_Enabled), 5, 0), true);
      cmbPaiDiaHsPExt.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiDiaHsPExt.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiDiaHsPExt.getEnabled(), 5, 0), true);
      edtPaiMaxHorNor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiMaxHorNor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiMaxHorNor_Enabled), 5, 0), true);
      cmbPaiPerVacDes.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiPerVacDes.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiPerVacDes.getEnabled(), 5, 0), true);
      cmbPaiPerVacHas.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiPerVacHas.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiPerVacHas.getEnabled(), 5, 0), true);
      edtPaiGuarEdadMin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiGuarEdadMin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiGuarEdadMin_Enabled), 5, 0), true);
      edtPaiGuarEdadMax_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiGuarEdadMax_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiGuarEdadMax_Enabled), 5, 0), true);
      chkPaiExcVizzoti.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiExcVizzoti.getInternalname(), "Enabled", GXutil.ltrimstr( chkPaiExcVizzoti.getEnabled(), 5, 0), true);
      edtPaiVizzoti_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiVizzoti_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiVizzoti_Enabled), 5, 0), true);
      edtavCombopaireligdefault_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopaireligdefault_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopaireligdefault_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes4S38( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues4S0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.paiscabecera", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0))}, new String[] {"Gx_mode","PaiCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"PaisCabecera");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("paiscabecera:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z312PaiNom", Z312PaiNom);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1271PaiMesHsPExt", GXutil.ltrim( localUtil.ntoc( Z1271PaiMesHsPExt, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1272PaiDiaHsPExt", GXutil.rtrim( Z1272PaiDiaHsPExt));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1405PaiMaxHorNor", GXutil.ltrim( localUtil.ntoc( Z1405PaiMaxHorNor, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1521PaiPerVacDes", GXutil.ltrim( localUtil.ntoc( Z1521PaiPerVacDes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1522PaiPerVacHas", GXutil.ltrim( localUtil.ntoc( Z1522PaiPerVacHas, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1625PaiGuarEdadMin", GXutil.ltrim( localUtil.ntoc( Z1625PaiGuarEdadMin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1626PaiGuarEdadMax", GXutil.ltrim( localUtil.ntoc( Z1626PaiGuarEdadMax, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1736PaiExcVizzoti", Z1736PaiExcVizzoti);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1737PaiVizzoti", GXutil.ltrim( localUtil.ntoc( Z1737PaiVizzoti, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1252PaiReligDefault", GXutil.rtrim( Z1252PaiReligDefault));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1252PaiReligDefault", GXutil.rtrim( A1252PaiReligDefault));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPAIRELIGDEFAULT_DATA", AV15PaiReligDefault_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPAIRELIGDEFAULT_DATA", AV15PaiReligDefault_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV7PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PAIRELIGDEFAULT", GXutil.rtrim( AV13Insert_PaiReligDefault));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV22Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAIRELIGDEFAULT_Objectcall", GXutil.rtrim( Combo_paireligdefault_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAIRELIGDEFAULT_Cls", GXutil.rtrim( Combo_paireligdefault_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAIRELIGDEFAULT_Selectedvalue_set", GXutil.rtrim( Combo_paireligdefault_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAIRELIGDEFAULT_Selectedtext_set", GXutil.rtrim( Combo_paireligdefault_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAIRELIGDEFAULT_Enabled", GXutil.booltostr( Combo_paireligdefault_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAIRELIGDEFAULT_Datalistproc", GXutil.rtrim( Combo_paireligdefault_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAIRELIGDEFAULT_Datalistprocparametersprefix", GXutil.rtrim( Combo_paireligdefault_Datalistprocparametersprefix));
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
      return formatLink("web.paiscabecera", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0))}, new String[] {"Gx_mode","PaiCod"})  ;
   }

   public String getPgmname( )
   {
      return "PaisCabecera" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Pais Cabecera", "") ;
   }

   public void initializeNonKey4S38( )
   {
      A1252PaiReligDefault = "" ;
      n1252PaiReligDefault = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1252PaiReligDefault", A1252PaiReligDefault);
      n1252PaiReligDefault = ((GXutil.strcmp("", A1252PaiReligDefault)==0) ? true : false) ;
      A312PaiNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A312PaiNom", A312PaiNom);
      A1271PaiMesHsPExt = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1271PaiMesHsPExt", GXutil.ltrimstr( A1271PaiMesHsPExt, 5, 1));
      A1272PaiDiaHsPExt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1272PaiDiaHsPExt", A1272PaiDiaHsPExt);
      A1405PaiMaxHorNor = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1405PaiMaxHorNor", GXutil.ltrimstr( A1405PaiMaxHorNor, 4, 1));
      A1521PaiPerVacDes = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1521PaiPerVacDes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1521PaiPerVacDes), 2, 0));
      A1522PaiPerVacHas = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1522PaiPerVacHas", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1522PaiPerVacHas), 2, 0));
      A1625PaiGuarEdadMin = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1625PaiGuarEdadMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1625PaiGuarEdadMin), 2, 0));
      A1626PaiGuarEdadMax = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1626PaiGuarEdadMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1626PaiGuarEdadMax), 2, 0));
      A1736PaiExcVizzoti = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1736PaiExcVizzoti", A1736PaiExcVizzoti);
      A1737PaiVizzoti = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1737PaiVizzoti", GXutil.ltrimstr( A1737PaiVizzoti, 6, 4));
      Z312PaiNom = "" ;
      Z1271PaiMesHsPExt = DecimalUtil.ZERO ;
      Z1272PaiDiaHsPExt = "" ;
      Z1405PaiMaxHorNor = DecimalUtil.ZERO ;
      Z1521PaiPerVacDes = (byte)(0) ;
      Z1522PaiPerVacHas = (byte)(0) ;
      Z1625PaiGuarEdadMin = (byte)(0) ;
      Z1626PaiGuarEdadMax = (byte)(0) ;
      Z1736PaiExcVizzoti = false ;
      Z1737PaiVizzoti = DecimalUtil.ZERO ;
      Z1252PaiReligDefault = "" ;
   }

   public void initAll4S38( )
   {
      A46PaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      initializeNonKey4S38( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251817533749", true, true);
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
      httpContext.AddJavascriptSource("paiscabecera.js", "?20251817533749", false, true);
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
      edtPaiCod_Internalname = "PAICOD" ;
      edtPaiNom_Internalname = "PAINOM" ;
      lblTextblockpaireligdefault_Internalname = "TEXTBLOCKPAIRELIGDEFAULT" ;
      Combo_paireligdefault_Internalname = "COMBO_PAIRELIGDEFAULT" ;
      edtPaiReligDefault_Internalname = "PAIRELIGDEFAULT" ;
      divTablesplittedpaireligdefault_Internalname = "TABLESPLITTEDPAIRELIGDEFAULT" ;
      edtPaiMesHsPExt_Internalname = "PAIMESHSPEXT" ;
      cmbPaiDiaHsPExt.setInternalname( "PAIDIAHSPEXT" );
      edtPaiMaxHorNor_Internalname = "PAIMAXHORNOR" ;
      cmbPaiPerVacDes.setInternalname( "PAIPERVACDES" );
      cmbPaiPerVacHas.setInternalname( "PAIPERVACHAS" );
      edtPaiGuarEdadMin_Internalname = "PAIGUAREDADMIN" ;
      edtPaiGuarEdadMax_Internalname = "PAIGUAREDADMAX" ;
      chkPaiExcVizzoti.setInternalname( "PAIEXCVIZZOTI" );
      edtPaiVizzoti_Internalname = "PAIVIZZOTI" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombopaireligdefault_Internalname = "vCOMBOPAIRELIGDEFAULT" ;
      divSectionattribute_paireligdefault_Internalname = "SECTIONATTRIBUTE_PAIRELIGDEFAULT" ;
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
      Form.setCaption( httpContext.getMessage( "Pais Cabecera", "") );
      edtavCombopaireligdefault_Jsonclick = "" ;
      edtavCombopaireligdefault_Enabled = 0 ;
      edtavCombopaireligdefault_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtPaiVizzoti_Jsonclick = "" ;
      edtPaiVizzoti_Enabled = 1 ;
      chkPaiExcVizzoti.setEnabled( 1 );
      edtPaiGuarEdadMax_Jsonclick = "" ;
      edtPaiGuarEdadMax_Enabled = 1 ;
      edtPaiGuarEdadMin_Jsonclick = "" ;
      edtPaiGuarEdadMin_Enabled = 1 ;
      cmbPaiPerVacHas.setJsonclick( "" );
      cmbPaiPerVacHas.setEnabled( 1 );
      cmbPaiPerVacDes.setJsonclick( "" );
      cmbPaiPerVacDes.setEnabled( 1 );
      edtPaiMaxHorNor_Jsonclick = "" ;
      edtPaiMaxHorNor_Enabled = 1 ;
      cmbPaiDiaHsPExt.setJsonclick( "" );
      cmbPaiDiaHsPExt.setEnabled( 1 );
      edtPaiMesHsPExt_Jsonclick = "" ;
      edtPaiMesHsPExt_Enabled = 1 ;
      edtPaiReligDefault_Jsonclick = "" ;
      edtPaiReligDefault_Enabled = 1 ;
      edtPaiReligDefault_Visible = 1 ;
      Combo_paireligdefault_Datalistprocparametersprefix = " \"ComboName\": \"PaiReligDefault\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PaiCod\": 0" ;
      Combo_paireligdefault_Datalistproc = "PaisCabeceraLoadDVCombo" ;
      Combo_paireligdefault_Cls = "ExtendedCombo Attribute" ;
      Combo_paireligdefault_Caption = "" ;
      Combo_paireligdefault_Enabled = GXutil.toBoolean( -1) ;
      edtPaiNom_Jsonclick = "" ;
      edtPaiNom_Enabled = 1 ;
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 1 ;
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
      cmbPaiDiaHsPExt.setName( "PAIDIAHSPEXT" );
      cmbPaiDiaHsPExt.setWebtags( "" );
      cmbPaiDiaHsPExt.addItem("", httpContext.getMessage( "(Default)", ""), (short)(0));
      cmbPaiDiaHsPExt.addItem("Promedio", httpContext.getMessage( "Promedio anual de días hábiles semanales por mes del empleado", ""), (short)(0));
      cmbPaiDiaHsPExt.addItem("diasSemanaX4", httpContext.getMessage( "Cantidad de días hábiles semanales del empleado multiplicados por 4", ""), (short)(0));
      cmbPaiDiaHsPExt.addItem("diasSemanaMes", httpContext.getMessage( "Cantidad de días hábiles del empleado en el mes específico de la liquidación", ""), (short)(0));
      if ( cmbPaiDiaHsPExt.getItemCount() > 0 )
      {
         A1272PaiDiaHsPExt = cmbPaiDiaHsPExt.getValidValue(A1272PaiDiaHsPExt) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1272PaiDiaHsPExt", A1272PaiDiaHsPExt);
      }
      cmbPaiPerVacDes.setName( "PAIPERVACDES" );
      cmbPaiPerVacDes.setWebtags( "" );
      cmbPaiPerVacDes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbPaiPerVacDes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbPaiPerVacDes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbPaiPerVacDes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbPaiPerVacDes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbPaiPerVacDes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbPaiPerVacDes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbPaiPerVacDes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbPaiPerVacDes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbPaiPerVacDes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbPaiPerVacDes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbPaiPerVacDes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbPaiPerVacDes.getItemCount() > 0 )
      {
         A1521PaiPerVacDes = (byte)(GXutil.lval( cmbPaiPerVacDes.getValidValue(GXutil.trim( GXutil.str( A1521PaiPerVacDes, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1521PaiPerVacDes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1521PaiPerVacDes), 2, 0));
      }
      cmbPaiPerVacHas.setName( "PAIPERVACHAS" );
      cmbPaiPerVacHas.setWebtags( "" );
      cmbPaiPerVacHas.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbPaiPerVacHas.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbPaiPerVacHas.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbPaiPerVacHas.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbPaiPerVacHas.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbPaiPerVacHas.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbPaiPerVacHas.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbPaiPerVacHas.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbPaiPerVacHas.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbPaiPerVacHas.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbPaiPerVacHas.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbPaiPerVacHas.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbPaiPerVacHas.getItemCount() > 0 )
      {
         A1522PaiPerVacHas = (byte)(GXutil.lval( cmbPaiPerVacHas.getValidValue(GXutil.trim( GXutil.str( A1522PaiPerVacHas, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1522PaiPerVacHas", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1522PaiPerVacHas), 2, 0));
      }
      chkPaiExcVizzoti.setName( "PAIEXCVIZZOTI" );
      chkPaiExcVizzoti.setWebtags( "" );
      chkPaiExcVizzoti.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiExcVizzoti.getInternalname(), "TitleCaption", chkPaiExcVizzoti.getCaption(), true);
      chkPaiExcVizzoti.setCheckedValue( "false" );
      A1736PaiExcVizzoti = GXutil.strtobool( GXutil.booltostr( A1736PaiExcVizzoti)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1736PaiExcVizzoti", A1736PaiExcVizzoti);
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

   public void valid_Paireligdefault( )
   {
      n1252PaiReligDefault = false ;
      /* Using cursor T004S51 */
      pr_default.execute(49, new Object[] {Boolean.valueOf(n1252PaiReligDefault), A1252PaiReligDefault});
      if ( (pr_default.getStatus(49) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A1252PaiReligDefault)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais Religion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAIRELIGDEFAULT");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiReligDefault_Internalname ;
         }
      }
      pr_default.close(49);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e124S2',iparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]");
      setEventMetadata("VALID_PAICOD",",oparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]}");
      setEventMetadata("VALID_PAIRELIGDEFAULT","{handler:'valid_Paireligdefault',iparms:[{av:'A1252PaiReligDefault',fld:'PAIRELIGDEFAULT',pic:''},{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]");
      setEventMetadata("VALID_PAIRELIGDEFAULT",",oparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]}");
      setEventMetadata("VALID_PAIDIAHSPEXT","{handler:'valid_Paidiahspext',iparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]");
      setEventMetadata("VALID_PAIDIAHSPEXT",",oparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]}");
      setEventMetadata("VALID_PAIPERVACDES","{handler:'valid_Paipervacdes',iparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]");
      setEventMetadata("VALID_PAIPERVACDES",",oparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]}");
      setEventMetadata("VALID_PAIPERVACHAS","{handler:'valid_Paipervachas',iparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]");
      setEventMetadata("VALID_PAIPERVACHAS",",oparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]}");
      setEventMetadata("VALIDV_COMBOPAIRELIGDEFAULT","{handler:'validv_Combopaireligdefault',iparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]");
      setEventMetadata("VALIDV_COMBOPAIRELIGDEFAULT",",oparms:[{av:'A1736PaiExcVizzoti',fld:'PAIEXCVIZZOTI',pic:''}]}");
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
      pr_default.close(49);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z312PaiNom = "" ;
      Z1271PaiMesHsPExt = DecimalUtil.ZERO ;
      Z1272PaiDiaHsPExt = "" ;
      Z1405PaiMaxHorNor = DecimalUtil.ZERO ;
      Z1737PaiVizzoti = DecimalUtil.ZERO ;
      Z1252PaiReligDefault = "" ;
      N1252PaiReligDefault = "" ;
      Combo_paireligdefault_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1252PaiReligDefault = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1272PaiDiaHsPExt = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A312PaiNom = "" ;
      lblTextblockpaireligdefault_Jsonclick = "" ;
      ucCombo_paireligdefault = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15PaiReligDefault_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A1271PaiMesHsPExt = DecimalUtil.ZERO ;
      A1405PaiMaxHorNor = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      A1737PaiVizzoti = DecimalUtil.ZERO ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV20ComboPaiReligDefault = "" ;
      AV13Insert_PaiReligDefault = "" ;
      AV22Pgmname = "" ;
      Combo_paireligdefault_Objectcall = "" ;
      Combo_paireligdefault_Class = "" ;
      Combo_paireligdefault_Icontype = "" ;
      Combo_paireligdefault_Icon = "" ;
      Combo_paireligdefault_Tooltip = "" ;
      Combo_paireligdefault_Selectedvalue_set = "" ;
      Combo_paireligdefault_Selectedtext_set = "" ;
      Combo_paireligdefault_Selectedtext_get = "" ;
      Combo_paireligdefault_Gamoauthtoken = "" ;
      Combo_paireligdefault_Ddointernalname = "" ;
      Combo_paireligdefault_Titlecontrolalign = "" ;
      Combo_paireligdefault_Dropdownoptionstype = "" ;
      Combo_paireligdefault_Titlecontrolidtoreplace = "" ;
      Combo_paireligdefault_Datalisttype = "" ;
      Combo_paireligdefault_Datalistfixedvalues = "" ;
      Combo_paireligdefault_Remoteservicesparameters = "" ;
      Combo_paireligdefault_Htmltemplate = "" ;
      Combo_paireligdefault_Multiplevaluestype = "" ;
      Combo_paireligdefault_Loadingdata = "" ;
      Combo_paireligdefault_Noresultsfound = "" ;
      Combo_paireligdefault_Emptyitemtext = "" ;
      Combo_paireligdefault_Onlyselectedvalues = "" ;
      Combo_paireligdefault_Selectalltext = "" ;
      Combo_paireligdefault_Multiplevaluesseparator = "" ;
      Combo_paireligdefault_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode38 = "" ;
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
      T004S5_A46PaiCod = new short[1] ;
      T004S5_A312PaiNom = new String[] {""} ;
      T004S5_A1271PaiMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004S5_A1272PaiDiaHsPExt = new String[] {""} ;
      T004S5_A1405PaiMaxHorNor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004S5_A1521PaiPerVacDes = new byte[1] ;
      T004S5_A1522PaiPerVacHas = new byte[1] ;
      T004S5_A1625PaiGuarEdadMin = new byte[1] ;
      T004S5_A1626PaiGuarEdadMax = new byte[1] ;
      T004S5_A1736PaiExcVizzoti = new boolean[] {false} ;
      T004S5_A1737PaiVizzoti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004S5_A1252PaiReligDefault = new String[] {""} ;
      T004S5_n1252PaiReligDefault = new boolean[] {false} ;
      T004S4_A1252PaiReligDefault = new String[] {""} ;
      T004S4_n1252PaiReligDefault = new boolean[] {false} ;
      T004S6_A1252PaiReligDefault = new String[] {""} ;
      T004S6_n1252PaiReligDefault = new boolean[] {false} ;
      T004S7_A46PaiCod = new short[1] ;
      T004S3_A46PaiCod = new short[1] ;
      T004S3_A312PaiNom = new String[] {""} ;
      T004S3_A1271PaiMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004S3_A1272PaiDiaHsPExt = new String[] {""} ;
      T004S3_A1405PaiMaxHorNor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004S3_A1521PaiPerVacDes = new byte[1] ;
      T004S3_A1522PaiPerVacHas = new byte[1] ;
      T004S3_A1625PaiGuarEdadMin = new byte[1] ;
      T004S3_A1626PaiGuarEdadMax = new byte[1] ;
      T004S3_A1736PaiExcVizzoti = new boolean[] {false} ;
      T004S3_A1737PaiVizzoti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004S3_A1252PaiReligDefault = new String[] {""} ;
      T004S3_n1252PaiReligDefault = new boolean[] {false} ;
      T004S8_A46PaiCod = new short[1] ;
      T004S9_A46PaiCod = new short[1] ;
      T004S2_A46PaiCod = new short[1] ;
      T004S2_A312PaiNom = new String[] {""} ;
      T004S2_A1271PaiMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004S2_A1272PaiDiaHsPExt = new String[] {""} ;
      T004S2_A1405PaiMaxHorNor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004S2_A1521PaiPerVacDes = new byte[1] ;
      T004S2_A1522PaiPerVacHas = new byte[1] ;
      T004S2_A1625PaiGuarEdadMin = new byte[1] ;
      T004S2_A1626PaiGuarEdadMax = new byte[1] ;
      T004S2_A1736PaiExcVizzoti = new boolean[] {false} ;
      T004S2_A1737PaiVizzoti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004S2_A1252PaiReligDefault = new String[] {""} ;
      T004S2_n1252PaiReligDefault = new boolean[] {false} ;
      T004S13_A37TipoConCod = new String[] {""} ;
      T004S14_A1923RolId = new byte[1] ;
      T004S14_A1925PerfilId = new byte[1] ;
      T004S14_A1928MenuVerId = new long[1] ;
      T004S15_A953ConCondicion = new String[] {""} ;
      T004S16_A1748EstaCivilCod = new short[1] ;
      T004S17_A1743SexoId = new byte[1] ;
      T004S18_A3CliCod = new int[1] ;
      T004S18_A26ConCodigo = new String[] {""} ;
      T004S19_A16SitCodigo = new String[] {""} ;
      T004S20_A3CliCod = new int[1] ;
      T004S20_A1564CliPaiConve = new short[1] ;
      T004S20_A1565CliConvenio = new String[] {""} ;
      T004S20_A8CatCodigo = new String[] {""} ;
      T004S20_A2200CatPaiCod = new short[1] ;
      T004S20_A2201CatProvCod = new short[1] ;
      T004S21_A3CliCod = new int[1] ;
      T004S21_A1564CliPaiConve = new short[1] ;
      T004S21_A1565CliConvenio = new String[] {""} ;
      T004S22_A3CliCod = new int[1] ;
      T004S22_A1EmpCod = new short[1] ;
      T004S22_A1562EmpConvePai = new short[1] ;
      T004S22_A1561EmpConveCod = new String[] {""} ;
      T004S23_A1161EmbargaSec = new short[1] ;
      T004S24_A1163TipoOblSec = new short[1] ;
      T004S25_A1151ARTSec = new short[1] ;
      T004S26_A903ActComCodigo = new String[] {""} ;
      T004S26_A993ActComAdiPai = new short[1] ;
      T004S26_A994ActComAdiCod = new String[] {""} ;
      T004S27_A67SecUserId = new short[1] ;
      T004S28_A46PaiCod = new short[1] ;
      T004S28_A2217ActLabNro = new int[1] ;
      T004S29_A46PaiCod = new short[1] ;
      T004S29_A1766PaiVacDesAnt = new byte[1] ;
      T004S30_A46PaiCod = new short[1] ;
      T004S30_A1535PaiAntMayCant = new byte[1] ;
      T004S30_A1536PaiAntMayDur = new String[] {""} ;
      T004S31_A46PaiCod = new short[1] ;
      T004S31_A1440PaiBaseClaseLeg = new byte[1] ;
      T004S31_A1441PaiBaseTipo = new String[] {""} ;
      T004S31_A1442PaiBaseCod1 = new String[] {""} ;
      T004S31_A1443PaiBaseCod2 = new String[] {""} ;
      T004S32_A46PaiCod = new short[1] ;
      T004S32_A1395PaiRanEtDesde = new short[1] ;
      T004S33_A46PaiCod = new short[1] ;
      T004S33_A37TipoConCod = new String[] {""} ;
      T004S33_A1361PaiPromFijVar = new String[] {""} ;
      T004S34_A46PaiCod = new short[1] ;
      T004S34_A1354PaiJorCliCod = new int[1] ;
      T004S34_A1355PaiJorConCodigo = new String[] {""} ;
      T004S35_A46PaiCod = new short[1] ;
      T004S35_A1356PaiMenCliCod = new int[1] ;
      T004S35_A1358PaiMesConCodigo = new String[] {""} ;
      T004S36_A46PaiCod = new short[1] ;
      T004S36_A1332PaiHsExSec = new short[1] ;
      T004S37_A46PaiCod = new short[1] ;
      T004S37_A1294PaiTipoTraId = new String[] {""} ;
      T004S38_A46PaiCod = new short[1] ;
      T004S38_A1282PaiOrigen = new String[] {""} ;
      T004S39_A46PaiCod = new short[1] ;
      T004S39_A1253PaiReligion = new String[] {""} ;
      T004S40_A46PaiCod = new short[1] ;
      T004S40_A1223FerId = new String[] {""} ;
      T004S41_A46PaiCod = new short[1] ;
      T004S41_A1221FerTipo = new String[] {""} ;
      T004S42_A46PaiCod = new short[1] ;
      T004S42_A988AdicionalCod = new String[] {""} ;
      T004S43_A46PaiCod = new short[1] ;
      T004S43_A14SinCod = new String[] {""} ;
      T004S44_A46PaiCod = new short[1] ;
      T004S44_A9ConveCodigo = new String[] {""} ;
      T004S45_A46PaiCod = new short[1] ;
      T004S45_A74idOperando = new String[] {""} ;
      T004S46_A46PaiCod = new short[1] ;
      T004S46_A47ProvCod = new short[1] ;
      T004S47_A3CliCod = new int[1] ;
      T004S47_A1EmpCod = new short[1] ;
      T004S47_A6LegNumero = new int[1] ;
      T004S48_A3CliCod = new int[1] ;
      T004S48_A1EmpCod = new short[1] ;
      T004S48_A6LegNumero = new int[1] ;
      T004S49_A3CliCod = new int[1] ;
      T004S50_A46PaiCod = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T004S51_A1252PaiReligDefault = new String[] {""} ;
      T004S51_n1252PaiReligDefault = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paiscabecera__default(),
         new Object[] {
             new Object[] {
            T004S2_A46PaiCod, T004S2_A312PaiNom, T004S2_A1271PaiMesHsPExt, T004S2_A1272PaiDiaHsPExt, T004S2_A1405PaiMaxHorNor, T004S2_A1521PaiPerVacDes, T004S2_A1522PaiPerVacHas, T004S2_A1625PaiGuarEdadMin, T004S2_A1626PaiGuarEdadMax, T004S2_A1736PaiExcVizzoti,
            T004S2_A1737PaiVizzoti, T004S2_A1252PaiReligDefault, T004S2_n1252PaiReligDefault
            }
            , new Object[] {
            T004S3_A46PaiCod, T004S3_A312PaiNom, T004S3_A1271PaiMesHsPExt, T004S3_A1272PaiDiaHsPExt, T004S3_A1405PaiMaxHorNor, T004S3_A1521PaiPerVacDes, T004S3_A1522PaiPerVacHas, T004S3_A1625PaiGuarEdadMin, T004S3_A1626PaiGuarEdadMax, T004S3_A1736PaiExcVizzoti,
            T004S3_A1737PaiVizzoti, T004S3_A1252PaiReligDefault, T004S3_n1252PaiReligDefault
            }
            , new Object[] {
            T004S4_A1252PaiReligDefault
            }
            , new Object[] {
            T004S5_A46PaiCod, T004S5_A312PaiNom, T004S5_A1271PaiMesHsPExt, T004S5_A1272PaiDiaHsPExt, T004S5_A1405PaiMaxHorNor, T004S5_A1521PaiPerVacDes, T004S5_A1522PaiPerVacHas, T004S5_A1625PaiGuarEdadMin, T004S5_A1626PaiGuarEdadMax, T004S5_A1736PaiExcVizzoti,
            T004S5_A1737PaiVizzoti, T004S5_A1252PaiReligDefault, T004S5_n1252PaiReligDefault
            }
            , new Object[] {
            T004S6_A1252PaiReligDefault
            }
            , new Object[] {
            T004S7_A46PaiCod
            }
            , new Object[] {
            T004S8_A46PaiCod
            }
            , new Object[] {
            T004S9_A46PaiCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004S13_A37TipoConCod
            }
            , new Object[] {
            T004S14_A1923RolId, T004S14_A1925PerfilId, T004S14_A1928MenuVerId
            }
            , new Object[] {
            T004S15_A953ConCondicion
            }
            , new Object[] {
            T004S16_A1748EstaCivilCod
            }
            , new Object[] {
            T004S17_A1743SexoId
            }
            , new Object[] {
            T004S18_A3CliCod, T004S18_A26ConCodigo
            }
            , new Object[] {
            T004S19_A16SitCodigo
            }
            , new Object[] {
            T004S20_A3CliCod, T004S20_A1564CliPaiConve, T004S20_A1565CliConvenio, T004S20_A8CatCodigo, T004S20_A2200CatPaiCod, T004S20_A2201CatProvCod
            }
            , new Object[] {
            T004S21_A3CliCod, T004S21_A1564CliPaiConve, T004S21_A1565CliConvenio
            }
            , new Object[] {
            T004S22_A3CliCod, T004S22_A1EmpCod, T004S22_A1562EmpConvePai, T004S22_A1561EmpConveCod
            }
            , new Object[] {
            T004S23_A1161EmbargaSec
            }
            , new Object[] {
            T004S24_A1163TipoOblSec
            }
            , new Object[] {
            T004S25_A1151ARTSec
            }
            , new Object[] {
            T004S26_A903ActComCodigo, T004S26_A993ActComAdiPai, T004S26_A994ActComAdiCod
            }
            , new Object[] {
            T004S27_A67SecUserId
            }
            , new Object[] {
            T004S28_A46PaiCod, T004S28_A2217ActLabNro
            }
            , new Object[] {
            T004S29_A46PaiCod, T004S29_A1766PaiVacDesAnt
            }
            , new Object[] {
            T004S30_A46PaiCod, T004S30_A1535PaiAntMayCant, T004S30_A1536PaiAntMayDur
            }
            , new Object[] {
            T004S31_A46PaiCod, T004S31_A1440PaiBaseClaseLeg, T004S31_A1441PaiBaseTipo, T004S31_A1442PaiBaseCod1, T004S31_A1443PaiBaseCod2
            }
            , new Object[] {
            T004S32_A46PaiCod, T004S32_A1395PaiRanEtDesde
            }
            , new Object[] {
            T004S33_A46PaiCod, T004S33_A37TipoConCod, T004S33_A1361PaiPromFijVar
            }
            , new Object[] {
            T004S34_A46PaiCod, T004S34_A1354PaiJorCliCod, T004S34_A1355PaiJorConCodigo
            }
            , new Object[] {
            T004S35_A46PaiCod, T004S35_A1356PaiMenCliCod, T004S35_A1358PaiMesConCodigo
            }
            , new Object[] {
            T004S36_A46PaiCod, T004S36_A1332PaiHsExSec
            }
            , new Object[] {
            T004S37_A46PaiCod, T004S37_A1294PaiTipoTraId
            }
            , new Object[] {
            T004S38_A46PaiCod, T004S38_A1282PaiOrigen
            }
            , new Object[] {
            T004S39_A46PaiCod, T004S39_A1253PaiReligion
            }
            , new Object[] {
            T004S40_A46PaiCod, T004S40_A1223FerId
            }
            , new Object[] {
            T004S41_A46PaiCod, T004S41_A1221FerTipo
            }
            , new Object[] {
            T004S42_A46PaiCod, T004S42_A988AdicionalCod
            }
            , new Object[] {
            T004S43_A46PaiCod, T004S43_A14SinCod
            }
            , new Object[] {
            T004S44_A46PaiCod, T004S44_A9ConveCodigo
            }
            , new Object[] {
            T004S45_A46PaiCod, T004S45_A74idOperando
            }
            , new Object[] {
            T004S46_A46PaiCod, T004S46_A47ProvCod
            }
            , new Object[] {
            T004S47_A3CliCod, T004S47_A1EmpCod, T004S47_A6LegNumero
            }
            , new Object[] {
            T004S48_A3CliCod, T004S48_A1EmpCod, T004S48_A6LegNumero
            }
            , new Object[] {
            T004S49_A3CliCod
            }
            , new Object[] {
            T004S50_A46PaiCod
            }
            , new Object[] {
            T004S51_A1252PaiReligDefault
            }
         }
      );
      AV22Pgmname = "PaisCabecera" ;
   }

   private byte Z1521PaiPerVacDes ;
   private byte Z1522PaiPerVacHas ;
   private byte Z1625PaiGuarEdadMin ;
   private byte Z1626PaiGuarEdadMax ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1521PaiPerVacDes ;
   private byte A1522PaiPerVacHas ;
   private byte A1625PaiGuarEdadMin ;
   private byte A1626PaiGuarEdadMax ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7PaiCod ;
   private short Z46PaiCod ;
   private short AV7PaiCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A46PaiCod ;
   private short RcdFound38 ;
   private short nIsDirty_38 ;
   private int trnEnded ;
   private int edtPaiCod_Enabled ;
   private int edtPaiNom_Enabled ;
   private int edtPaiReligDefault_Visible ;
   private int edtPaiReligDefault_Enabled ;
   private int edtPaiMesHsPExt_Enabled ;
   private int edtPaiMaxHorNor_Enabled ;
   private int edtPaiGuarEdadMin_Enabled ;
   private int edtPaiGuarEdadMax_Enabled ;
   private int edtPaiVizzoti_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombopaireligdefault_Visible ;
   private int edtavCombopaireligdefault_Enabled ;
   private int Combo_paireligdefault_Datalistupdateminimumcharacters ;
   private int Combo_paireligdefault_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV23GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private java.math.BigDecimal Z1271PaiMesHsPExt ;
   private java.math.BigDecimal Z1405PaiMaxHorNor ;
   private java.math.BigDecimal Z1737PaiVizzoti ;
   private java.math.BigDecimal A1271PaiMesHsPExt ;
   private java.math.BigDecimal A1405PaiMaxHorNor ;
   private java.math.BigDecimal A1737PaiVizzoti ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z1272PaiDiaHsPExt ;
   private String Z1252PaiReligDefault ;
   private String N1252PaiReligDefault ;
   private String Combo_paireligdefault_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1252PaiReligDefault ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtPaiCod_Internalname ;
   private String A1272PaiDiaHsPExt ;
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
   private String edtPaiCod_Jsonclick ;
   private String edtPaiNom_Internalname ;
   private String edtPaiNom_Jsonclick ;
   private String divTablesplittedpaireligdefault_Internalname ;
   private String lblTextblockpaireligdefault_Internalname ;
   private String lblTextblockpaireligdefault_Jsonclick ;
   private String Combo_paireligdefault_Caption ;
   private String Combo_paireligdefault_Cls ;
   private String Combo_paireligdefault_Datalistproc ;
   private String Combo_paireligdefault_Datalistprocparametersprefix ;
   private String Combo_paireligdefault_Internalname ;
   private String edtPaiReligDefault_Internalname ;
   private String edtPaiReligDefault_Jsonclick ;
   private String edtPaiMesHsPExt_Internalname ;
   private String edtPaiMesHsPExt_Jsonclick ;
   private String edtPaiMaxHorNor_Internalname ;
   private String edtPaiMaxHorNor_Jsonclick ;
   private String edtPaiGuarEdadMin_Internalname ;
   private String edtPaiGuarEdadMin_Jsonclick ;
   private String edtPaiGuarEdadMax_Internalname ;
   private String edtPaiGuarEdadMax_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String edtPaiVizzoti_Internalname ;
   private String edtPaiVizzoti_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_paireligdefault_Internalname ;
   private String edtavCombopaireligdefault_Internalname ;
   private String AV20ComboPaiReligDefault ;
   private String edtavCombopaireligdefault_Jsonclick ;
   private String AV13Insert_PaiReligDefault ;
   private String AV22Pgmname ;
   private String Combo_paireligdefault_Objectcall ;
   private String Combo_paireligdefault_Class ;
   private String Combo_paireligdefault_Icontype ;
   private String Combo_paireligdefault_Icon ;
   private String Combo_paireligdefault_Tooltip ;
   private String Combo_paireligdefault_Selectedvalue_set ;
   private String Combo_paireligdefault_Selectedtext_set ;
   private String Combo_paireligdefault_Selectedtext_get ;
   private String Combo_paireligdefault_Gamoauthtoken ;
   private String Combo_paireligdefault_Ddointernalname ;
   private String Combo_paireligdefault_Titlecontrolalign ;
   private String Combo_paireligdefault_Dropdownoptionstype ;
   private String Combo_paireligdefault_Titlecontrolidtoreplace ;
   private String Combo_paireligdefault_Datalisttype ;
   private String Combo_paireligdefault_Datalistfixedvalues ;
   private String Combo_paireligdefault_Remoteservicesparameters ;
   private String Combo_paireligdefault_Htmltemplate ;
   private String Combo_paireligdefault_Multiplevaluestype ;
   private String Combo_paireligdefault_Loadingdata ;
   private String Combo_paireligdefault_Noresultsfound ;
   private String Combo_paireligdefault_Emptyitemtext ;
   private String Combo_paireligdefault_Onlyselectedvalues ;
   private String Combo_paireligdefault_Selectalltext ;
   private String Combo_paireligdefault_Multiplevaluesseparator ;
   private String Combo_paireligdefault_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode38 ;
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
   private boolean Z1736PaiExcVizzoti ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1252PaiReligDefault ;
   private boolean wbErr ;
   private boolean A1736PaiExcVizzoti ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_paireligdefault_Enabled ;
   private boolean Combo_paireligdefault_Visible ;
   private boolean Combo_paireligdefault_Allowmultipleselection ;
   private boolean Combo_paireligdefault_Isgriditem ;
   private boolean Combo_paireligdefault_Hasdescription ;
   private boolean Combo_paireligdefault_Includeonlyselectedoption ;
   private boolean Combo_paireligdefault_Includeselectalloption ;
   private boolean Combo_paireligdefault_Emptyitem ;
   private boolean Combo_paireligdefault_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String AV19Combo_DataJson ;
   private String Z312PaiNom ;
   private String A312PaiNom ;
   private String AV17ComboSelectedValue ;
   private String AV18ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_paireligdefault ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbPaiDiaHsPExt ;
   private HTMLChoice cmbPaiPerVacDes ;
   private HTMLChoice cmbPaiPerVacHas ;
   private ICheckbox chkPaiExcVizzoti ;
   private IDataStoreProvider pr_default ;
   private short[] T004S5_A46PaiCod ;
   private String[] T004S5_A312PaiNom ;
   private java.math.BigDecimal[] T004S5_A1271PaiMesHsPExt ;
   private String[] T004S5_A1272PaiDiaHsPExt ;
   private java.math.BigDecimal[] T004S5_A1405PaiMaxHorNor ;
   private byte[] T004S5_A1521PaiPerVacDes ;
   private byte[] T004S5_A1522PaiPerVacHas ;
   private byte[] T004S5_A1625PaiGuarEdadMin ;
   private byte[] T004S5_A1626PaiGuarEdadMax ;
   private boolean[] T004S5_A1736PaiExcVizzoti ;
   private java.math.BigDecimal[] T004S5_A1737PaiVizzoti ;
   private String[] T004S5_A1252PaiReligDefault ;
   private boolean[] T004S5_n1252PaiReligDefault ;
   private String[] T004S4_A1252PaiReligDefault ;
   private boolean[] T004S4_n1252PaiReligDefault ;
   private String[] T004S6_A1252PaiReligDefault ;
   private boolean[] T004S6_n1252PaiReligDefault ;
   private short[] T004S7_A46PaiCod ;
   private short[] T004S3_A46PaiCod ;
   private String[] T004S3_A312PaiNom ;
   private java.math.BigDecimal[] T004S3_A1271PaiMesHsPExt ;
   private String[] T004S3_A1272PaiDiaHsPExt ;
   private java.math.BigDecimal[] T004S3_A1405PaiMaxHorNor ;
   private byte[] T004S3_A1521PaiPerVacDes ;
   private byte[] T004S3_A1522PaiPerVacHas ;
   private byte[] T004S3_A1625PaiGuarEdadMin ;
   private byte[] T004S3_A1626PaiGuarEdadMax ;
   private boolean[] T004S3_A1736PaiExcVizzoti ;
   private java.math.BigDecimal[] T004S3_A1737PaiVizzoti ;
   private String[] T004S3_A1252PaiReligDefault ;
   private boolean[] T004S3_n1252PaiReligDefault ;
   private short[] T004S8_A46PaiCod ;
   private short[] T004S9_A46PaiCod ;
   private short[] T004S2_A46PaiCod ;
   private String[] T004S2_A312PaiNom ;
   private java.math.BigDecimal[] T004S2_A1271PaiMesHsPExt ;
   private String[] T004S2_A1272PaiDiaHsPExt ;
   private java.math.BigDecimal[] T004S2_A1405PaiMaxHorNor ;
   private byte[] T004S2_A1521PaiPerVacDes ;
   private byte[] T004S2_A1522PaiPerVacHas ;
   private byte[] T004S2_A1625PaiGuarEdadMin ;
   private byte[] T004S2_A1626PaiGuarEdadMax ;
   private boolean[] T004S2_A1736PaiExcVizzoti ;
   private java.math.BigDecimal[] T004S2_A1737PaiVizzoti ;
   private String[] T004S2_A1252PaiReligDefault ;
   private boolean[] T004S2_n1252PaiReligDefault ;
   private String[] T004S13_A37TipoConCod ;
   private byte[] T004S14_A1923RolId ;
   private byte[] T004S14_A1925PerfilId ;
   private long[] T004S14_A1928MenuVerId ;
   private String[] T004S15_A953ConCondicion ;
   private short[] T004S16_A1748EstaCivilCod ;
   private byte[] T004S17_A1743SexoId ;
   private int[] T004S18_A3CliCod ;
   private String[] T004S18_A26ConCodigo ;
   private String[] T004S19_A16SitCodigo ;
   private int[] T004S20_A3CliCod ;
   private short[] T004S20_A1564CliPaiConve ;
   private String[] T004S20_A1565CliConvenio ;
   private String[] T004S20_A8CatCodigo ;
   private short[] T004S20_A2200CatPaiCod ;
   private short[] T004S20_A2201CatProvCod ;
   private int[] T004S21_A3CliCod ;
   private short[] T004S21_A1564CliPaiConve ;
   private String[] T004S21_A1565CliConvenio ;
   private int[] T004S22_A3CliCod ;
   private short[] T004S22_A1EmpCod ;
   private short[] T004S22_A1562EmpConvePai ;
   private String[] T004S22_A1561EmpConveCod ;
   private short[] T004S23_A1161EmbargaSec ;
   private short[] T004S24_A1163TipoOblSec ;
   private short[] T004S25_A1151ARTSec ;
   private String[] T004S26_A903ActComCodigo ;
   private short[] T004S26_A993ActComAdiPai ;
   private String[] T004S26_A994ActComAdiCod ;
   private short[] T004S27_A67SecUserId ;
   private short[] T004S28_A46PaiCod ;
   private int[] T004S28_A2217ActLabNro ;
   private short[] T004S29_A46PaiCod ;
   private byte[] T004S29_A1766PaiVacDesAnt ;
   private short[] T004S30_A46PaiCod ;
   private byte[] T004S30_A1535PaiAntMayCant ;
   private String[] T004S30_A1536PaiAntMayDur ;
   private short[] T004S31_A46PaiCod ;
   private byte[] T004S31_A1440PaiBaseClaseLeg ;
   private String[] T004S31_A1441PaiBaseTipo ;
   private String[] T004S31_A1442PaiBaseCod1 ;
   private String[] T004S31_A1443PaiBaseCod2 ;
   private short[] T004S32_A46PaiCod ;
   private short[] T004S32_A1395PaiRanEtDesde ;
   private short[] T004S33_A46PaiCod ;
   private String[] T004S33_A37TipoConCod ;
   private String[] T004S33_A1361PaiPromFijVar ;
   private short[] T004S34_A46PaiCod ;
   private int[] T004S34_A1354PaiJorCliCod ;
   private String[] T004S34_A1355PaiJorConCodigo ;
   private short[] T004S35_A46PaiCod ;
   private int[] T004S35_A1356PaiMenCliCod ;
   private String[] T004S35_A1358PaiMesConCodigo ;
   private short[] T004S36_A46PaiCod ;
   private short[] T004S36_A1332PaiHsExSec ;
   private short[] T004S37_A46PaiCod ;
   private String[] T004S37_A1294PaiTipoTraId ;
   private short[] T004S38_A46PaiCod ;
   private String[] T004S38_A1282PaiOrigen ;
   private short[] T004S39_A46PaiCod ;
   private String[] T004S39_A1253PaiReligion ;
   private short[] T004S40_A46PaiCod ;
   private String[] T004S40_A1223FerId ;
   private short[] T004S41_A46PaiCod ;
   private String[] T004S41_A1221FerTipo ;
   private short[] T004S42_A46PaiCod ;
   private String[] T004S42_A988AdicionalCod ;
   private short[] T004S43_A46PaiCod ;
   private String[] T004S43_A14SinCod ;
   private short[] T004S44_A46PaiCod ;
   private String[] T004S44_A9ConveCodigo ;
   private short[] T004S45_A46PaiCod ;
   private String[] T004S45_A74idOperando ;
   private short[] T004S46_A46PaiCod ;
   private short[] T004S46_A47ProvCod ;
   private int[] T004S47_A3CliCod ;
   private short[] T004S47_A1EmpCod ;
   private int[] T004S47_A6LegNumero ;
   private int[] T004S48_A3CliCod ;
   private short[] T004S48_A1EmpCod ;
   private int[] T004S48_A6LegNumero ;
   private int[] T004S49_A3CliCod ;
   private short[] T004S50_A46PaiCod ;
   private String[] T004S51_A1252PaiReligDefault ;
   private boolean[] T004S51_n1252PaiReligDefault ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15PaiReligDefault_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class paiscabecera__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T004S2", "SELECT PaiCod, PaiNom, PaiMesHsPExt, PaiDiaHsPExt, PaiMaxHorNor, PaiPerVacDes, PaiPerVacHas, PaiGuarEdadMin, PaiGuarEdadMax, PaiExcVizzoti, PaiVizzoti, PaiReligDefault FROM Pais WHERE PaiCod = ?  FOR UPDATE OF Pais NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004S3", "SELECT PaiCod, PaiNom, PaiMesHsPExt, PaiDiaHsPExt, PaiMaxHorNor, PaiPerVacDes, PaiPerVacHas, PaiGuarEdadMin, PaiGuarEdadMax, PaiExcVizzoti, PaiVizzoti, PaiReligDefault FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004S4", "SELECT ReligId AS PaiReligDefault FROM Religion WHERE ReligId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004S5", "SELECT TM1.PaiCod, TM1.PaiNom, TM1.PaiMesHsPExt, TM1.PaiDiaHsPExt, TM1.PaiMaxHorNor, TM1.PaiPerVacDes, TM1.PaiPerVacHas, TM1.PaiGuarEdadMin, TM1.PaiGuarEdadMax, TM1.PaiExcVizzoti, TM1.PaiVizzoti, TM1.PaiReligDefault AS PaiReligDefault FROM Pais TM1 WHERE TM1.PaiCod = ? ORDER BY TM1.PaiCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004S6", "SELECT ReligId AS PaiReligDefault FROM Religion WHERE ReligId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004S7", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004S8", "SELECT PaiCod FROM Pais WHERE ( PaiCod > ?) ORDER BY PaiCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S9", "SELECT PaiCod FROM Pais WHERE ( PaiCod < ?) ORDER BY PaiCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T004S10", "SAVEPOINT gxupdate;INSERT INTO Pais(PaiCod, PaiNom, PaiMesHsPExt, PaiDiaHsPExt, PaiMaxHorNor, PaiPerVacDes, PaiPerVacHas, PaiGuarEdadMin, PaiGuarEdadMax, PaiExcVizzoti, PaiVizzoti, PaiReligDefault, PaiNacMostrar, PaiDomMostrar, PaiFondoCese, PaiPromMeses, PaiPromJorMeses, PaiPromMesTCnt, PaiPromJorMesTCnt, PaiMinMesesVac, PaiInterDiasJor, PaiTipoExpDef, PaiFracVacAnt) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE, FALSE, FALSE, 0, 0, '', '', 0, 0, 0, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004S11", "SAVEPOINT gxupdate;UPDATE Pais SET PaiNom=?, PaiMesHsPExt=?, PaiDiaHsPExt=?, PaiMaxHorNor=?, PaiPerVacDes=?, PaiPerVacHas=?, PaiGuarEdadMin=?, PaiGuarEdadMax=?, PaiExcVizzoti=?, PaiVizzoti=?, PaiReligDefault=?  WHERE PaiCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004S12", "SAVEPOINT gxupdate;DELETE FROM Pais  WHERE PaiCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004S13", "SELECT TipoConCod FROM TipoDeConcepto WHERE TipoConPai = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S14", "SELECT RolId, PerfilId, MenuVerId FROM MenuVersiones WHERE MenuPais = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S15", "SELECT ConCondicion FROM Condiciones_concepto WHERE CondicionPais = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S16", "SELECT EstaCivilCod FROM Estados_civiles WHERE EstaCivilPais = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S17", "SELECT SexoId FROM Sexos WHERE SexoPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S18", "SELECT CliCod, ConCodigo FROM Concepto WHERE ConceptoPais = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S19", "SELECT SitCodigo FROM Estado WHERE SitPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S20", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod FROM CategoriaProvincias WHERE CatPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S21", "SELECT CliCod, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE CliPaiConve = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S22", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE EmpConvePai = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S23", "SELECT EmbargaSec FROM embargabilidad WHERE EmbarPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S24", "SELECT TipoOblSec FROM tipo_obligacion WHERE TipoOblPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S25", "SELECT ARTSec FROM ART WHERE ARTPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S26", "SELECT ActComCodigo, ActComAdiPai, ActComAdiCod FROM adicional_actividad WHERE ActComAdiPai = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S27", "SELECT SecUserId FROM SecUser WHERE SecUserPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S28", "SELECT PaiCod, ActLabNro FROM ActividadLaboralClasificada WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S29", "SELECT PaiCod, PaiVacDesAnt FROM PaisVacaciones WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S30", "SELECT PaiCod, PaiAntMayCant, PaiAntMayDur FROM Paispreaviso WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S31", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2 FROM Paisbase_calculo WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S32", "SELECT PaiCod, PaiRanEtDesde FROM RangoEtario WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S33", "SELECT PaiCod, TipoConCod, PaiPromFijVar FROM Paispromedio_horanormal_mensualizados WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S34", "SELECT PaiCod, PaiJorCliCod, PaiJorConCodigo FROM Paisconceptos_horanormal_jornalizados WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S35", "SELECT PaiCod, PaiMenCliCod, PaiMesConCodigo FROM Paisconceptos_horanormal_mensualizados WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S36", "SELECT PaiCod, PaiHsExSec FROM Paishorasextras_pordia WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S37", "SELECT PaiCod, PaiTipoTraId FROM PaisTipoTrabajo WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S38", "SELECT PaiCod, PaiOrigen FROM PaisOrigen WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S39", "SELECT PaiCod, PaiReligion FROM PaisReligion WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S40", "SELECT PaiCod, FerId FROM feriado WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S41", "SELECT PaiCod, FerTipo FROM tipo_feriado WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S42", "SELECT PaiCod, AdicionalCod FROM Adicional WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S43", "SELECT PaiCod, SinCod FROM Sindicato WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S44", "SELECT PaiCod, ConveCodigo FROM Convenio WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S45", "SELECT PaiCod, idOperando FROM calculo WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S46", "SELECT PaiCod, ProvCod FROM Provincia WHERE PaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S47", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE LegPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S48", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE LegNacionCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S49", "SELECT CliCod FROM Cliente WHERE CliPaiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004S50", "SELECT PaiCod FROM Pais ORDER BY PaiCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004S51", "SELECT ReligId AS PaiReligDefault FROM Religion WHERE ReligId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,4);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,4);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,4);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
            case 11 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 12 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 21 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 22 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 23 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 25 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 26 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 27 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               return;
            case 28 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 29 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 31 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 32 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 33 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 34 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 35 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 36 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 37 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 38 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 39 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 40 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 41 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 42 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 43 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 44 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 45 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 46 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 47 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 48 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 49 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
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
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 1);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 1);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[10], 4);
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(12, (String)parms[12], 20);
               }
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 1);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 1);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 4);
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(11, (String)parms[11], 20);
               }
               stmt.setShort(12, ((Number) parms[12]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 23 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 24 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 25 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 26 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 27 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 28 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 29 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 31 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 32 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 33 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 34 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 35 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 36 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 37 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 38 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 39 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 40 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 41 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 42 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 43 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 44 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 45 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 46 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 47 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 49 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
      }
   }

}

