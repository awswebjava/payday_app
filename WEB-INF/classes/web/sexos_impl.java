package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class sexos_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A1742SexoPaiCod = (short)(GXutil.lval( httpContext.GetPar( "SexoPaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1742SexoPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1742SexoPaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A1742SexoPaiCod) ;
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
            AV7SexoId = (byte)(GXutil.lval( httpContext.GetPar( "SexoId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7SexoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7SexoId), 2, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSEXOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7SexoId), "Z9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Sexos", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtSexoPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public sexos_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public sexos_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sexos_impl.class ));
   }

   public sexos_impl( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbSexoBiologico = new HTMLChoice();
      cmbSexoIdentidad = new HTMLChoice();
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
      if ( cmbSexoBiologico.getItemCount() > 0 )
      {
         A1745SexoBiologico = cmbSexoBiologico.getValidValue(A1745SexoBiologico) ;
         n1745SexoBiologico = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1745SexoBiologico", A1745SexoBiologico);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbSexoBiologico.setValue( GXutil.rtrim( A1745SexoBiologico) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSexoBiologico.getInternalname(), "Values", cmbSexoBiologico.ToJavascriptSource(), true);
      }
      if ( cmbSexoIdentidad.getItemCount() > 0 )
      {
         A1746SexoIdentidad = cmbSexoIdentidad.getValidValue(A1746SexoIdentidad) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1746SexoIdentidad", A1746SexoIdentidad);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbSexoIdentidad.setValue( GXutil.rtrim( A1746SexoIdentidad) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSexoIdentidad.getInternalname(), "Values", cmbSexoIdentidad.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSexoId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSexoId_Internalname, httpContext.getMessage( "Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtSexoId_Internalname, GXutil.ltrim( localUtil.ntoc( A1743SexoId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtSexoId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1743SexoId), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1743SexoId), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSexoId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSexoId_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Sexos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedsexopaicod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksexopaicod_Internalname, httpContext.getMessage( "Pai Cod", ""), "", "", lblTextblocksexopaicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Sexos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_sexopaicod.setProperty("Caption", Combo_sexopaicod_Caption);
      ucCombo_sexopaicod.setProperty("Cls", Combo_sexopaicod_Cls);
      ucCombo_sexopaicod.setProperty("DataListProc", Combo_sexopaicod_Datalistproc);
      ucCombo_sexopaicod.setProperty("DataListProcParametersPrefix", Combo_sexopaicod_Datalistprocparametersprefix);
      ucCombo_sexopaicod.setProperty("EmptyItem", Combo_sexopaicod_Emptyitem);
      ucCombo_sexopaicod.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_sexopaicod.setProperty("DropDownOptionsData", AV15SexoPaiCod_Data);
      ucCombo_sexopaicod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_sexopaicod_Internalname, "COMBO_SEXOPAICODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSexoPaiCod_Internalname, httpContext.getMessage( "Sexo Pai Cod", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSexoPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1742SexoPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1742SexoPaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSexoPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtSexoPaiCod_Visible, edtSexoPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Sexos.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSexoNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSexoNombre_Internalname, httpContext.getMessage( "Nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSexoNombre_Internalname, A1744SexoNombre, GXutil.rtrim( localUtil.format( A1744SexoNombre, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSexoNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSexoNombre_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_Sexos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbSexoBiologico.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbSexoBiologico.getInternalname(), httpContext.getMessage( "Biologico", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbSexoBiologico, cmbSexoBiologico.getInternalname(), GXutil.rtrim( A1745SexoBiologico), 1, cmbSexoBiologico.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbSexoBiologico.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "", true, (byte)(0), "HLP_Sexos.htm");
      cmbSexoBiologico.setValue( GXutil.rtrim( A1745SexoBiologico) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSexoBiologico.getInternalname(), "Values", cmbSexoBiologico.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbSexoIdentidad.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbSexoIdentidad.getInternalname(), httpContext.getMessage( "Identidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbSexoIdentidad, cmbSexoIdentidad.getInternalname(), GXutil.rtrim( A1746SexoIdentidad), 1, cmbSexoIdentidad.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbSexoIdentidad.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "", true, (byte)(0), "HLP_Sexos.htm");
      cmbSexoIdentidad.setValue( GXutil.rtrim( A1746SexoIdentidad) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSexoIdentidad.getInternalname(), "Values", cmbSexoIdentidad.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSexoCodFor_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSexoCodFor_Internalname, httpContext.getMessage( "Código como parámetro de cálculos en fórmulas", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSexoCodFor_Internalname, GXutil.rtrim( A2092SexoCodFor), GXutil.rtrim( localUtil.format( A2092SexoCodFor, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSexoCodFor_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSexoCodFor_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "palabra", "left", true, "", "HLP_Sexos.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Sexos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Sexos.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Sexos.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_sexopaicod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombosexopaicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV20ComboSexoPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCombosexopaicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20ComboSexoPaiCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20ComboSexoPaiCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombosexopaicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombosexopaicod_Visible, edtavCombosexopaicod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Sexos.htm");
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
      e11532 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSEXOPAICOD_DATA"), AV15SexoPaiCod_Data);
            /* Read saved values. */
            Z1743SexoId = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1743SexoId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1744SexoNombre = httpContext.cgiGet( "Z1744SexoNombre") ;
            Z1745SexoBiologico = httpContext.cgiGet( "Z1745SexoBiologico") ;
            n1745SexoBiologico = ((GXutil.strcmp("", A1745SexoBiologico)==0) ? true : false) ;
            Z1746SexoIdentidad = httpContext.cgiGet( "Z1746SexoIdentidad") ;
            Z2092SexoCodFor = httpContext.cgiGet( "Z2092SexoCodFor") ;
            Z1742SexoPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1742SexoPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1742SexoPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "N1742SexoPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7SexoId = (byte)(localUtil.ctol( httpContext.cgiGet( "vSEXOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV13Insert_SexoPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_SEXOPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV22Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_sexopaicod_Objectcall = httpContext.cgiGet( "COMBO_SEXOPAICOD_Objectcall") ;
            Combo_sexopaicod_Class = httpContext.cgiGet( "COMBO_SEXOPAICOD_Class") ;
            Combo_sexopaicod_Icontype = httpContext.cgiGet( "COMBO_SEXOPAICOD_Icontype") ;
            Combo_sexopaicod_Icon = httpContext.cgiGet( "COMBO_SEXOPAICOD_Icon") ;
            Combo_sexopaicod_Caption = httpContext.cgiGet( "COMBO_SEXOPAICOD_Caption") ;
            Combo_sexopaicod_Tooltip = httpContext.cgiGet( "COMBO_SEXOPAICOD_Tooltip") ;
            Combo_sexopaicod_Cls = httpContext.cgiGet( "COMBO_SEXOPAICOD_Cls") ;
            Combo_sexopaicod_Selectedvalue_set = httpContext.cgiGet( "COMBO_SEXOPAICOD_Selectedvalue_set") ;
            Combo_sexopaicod_Selectedvalue_get = httpContext.cgiGet( "COMBO_SEXOPAICOD_Selectedvalue_get") ;
            Combo_sexopaicod_Selectedtext_set = httpContext.cgiGet( "COMBO_SEXOPAICOD_Selectedtext_set") ;
            Combo_sexopaicod_Selectedtext_get = httpContext.cgiGet( "COMBO_SEXOPAICOD_Selectedtext_get") ;
            Combo_sexopaicod_Gamoauthtoken = httpContext.cgiGet( "COMBO_SEXOPAICOD_Gamoauthtoken") ;
            Combo_sexopaicod_Ddointernalname = httpContext.cgiGet( "COMBO_SEXOPAICOD_Ddointernalname") ;
            Combo_sexopaicod_Titlecontrolalign = httpContext.cgiGet( "COMBO_SEXOPAICOD_Titlecontrolalign") ;
            Combo_sexopaicod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_SEXOPAICOD_Dropdownoptionstype") ;
            Combo_sexopaicod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_SEXOPAICOD_Enabled")) ;
            Combo_sexopaicod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_SEXOPAICOD_Visible")) ;
            Combo_sexopaicod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_SEXOPAICOD_Titlecontrolidtoreplace") ;
            Combo_sexopaicod_Datalisttype = httpContext.cgiGet( "COMBO_SEXOPAICOD_Datalisttype") ;
            Combo_sexopaicod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_SEXOPAICOD_Allowmultipleselection")) ;
            Combo_sexopaicod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_SEXOPAICOD_Datalistfixedvalues") ;
            Combo_sexopaicod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SEXOPAICOD_Isgriditem")) ;
            Combo_sexopaicod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_SEXOPAICOD_Hasdescription")) ;
            Combo_sexopaicod_Datalistproc = httpContext.cgiGet( "COMBO_SEXOPAICOD_Datalistproc") ;
            Combo_sexopaicod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_SEXOPAICOD_Datalistprocparametersprefix") ;
            Combo_sexopaicod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_SEXOPAICOD_Remoteservicesparameters") ;
            Combo_sexopaicod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SEXOPAICOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_sexopaicod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SEXOPAICOD_Includeonlyselectedoption")) ;
            Combo_sexopaicod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SEXOPAICOD_Includeselectalloption")) ;
            Combo_sexopaicod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SEXOPAICOD_Emptyitem")) ;
            Combo_sexopaicod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SEXOPAICOD_Includeaddnewoption")) ;
            Combo_sexopaicod_Htmltemplate = httpContext.cgiGet( "COMBO_SEXOPAICOD_Htmltemplate") ;
            Combo_sexopaicod_Multiplevaluestype = httpContext.cgiGet( "COMBO_SEXOPAICOD_Multiplevaluestype") ;
            Combo_sexopaicod_Loadingdata = httpContext.cgiGet( "COMBO_SEXOPAICOD_Loadingdata") ;
            Combo_sexopaicod_Noresultsfound = httpContext.cgiGet( "COMBO_SEXOPAICOD_Noresultsfound") ;
            Combo_sexopaicod_Emptyitemtext = httpContext.cgiGet( "COMBO_SEXOPAICOD_Emptyitemtext") ;
            Combo_sexopaicod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_SEXOPAICOD_Onlyselectedvalues") ;
            Combo_sexopaicod_Selectalltext = httpContext.cgiGet( "COMBO_SEXOPAICOD_Selectalltext") ;
            Combo_sexopaicod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_SEXOPAICOD_Multiplevaluesseparator") ;
            Combo_sexopaicod_Addnewoptiontext = httpContext.cgiGet( "COMBO_SEXOPAICOD_Addnewoptiontext") ;
            Combo_sexopaicod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SEXOPAICOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A1743SexoId = (byte)(localUtil.ctol( httpContext.cgiGet( edtSexoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1743SexoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1743SexoId), 2, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSexoPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSexoPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SEXOPAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSexoPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1742SexoPaiCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1742SexoPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1742SexoPaiCod), 4, 0));
            }
            else
            {
               A1742SexoPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtSexoPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1742SexoPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1742SexoPaiCod), 4, 0));
            }
            A1744SexoNombre = GXutil.upper( httpContext.cgiGet( edtSexoNombre_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1744SexoNombre", A1744SexoNombre);
            cmbSexoBiologico.setValue( httpContext.cgiGet( cmbSexoBiologico.getInternalname()) );
            A1745SexoBiologico = httpContext.cgiGet( cmbSexoBiologico.getInternalname()) ;
            n1745SexoBiologico = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1745SexoBiologico", A1745SexoBiologico);
            n1745SexoBiologico = ((GXutil.strcmp("", A1745SexoBiologico)==0) ? true : false) ;
            cmbSexoIdentidad.setValue( httpContext.cgiGet( cmbSexoIdentidad.getInternalname()) );
            A1746SexoIdentidad = httpContext.cgiGet( cmbSexoIdentidad.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1746SexoIdentidad", A1746SexoIdentidad);
            A2092SexoCodFor = httpContext.cgiGet( edtSexoCodFor_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2092SexoCodFor", A2092SexoCodFor);
            AV20ComboSexoPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombosexopaicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSexoPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboSexoPaiCod), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Sexos");
            A1743SexoId = (byte)(localUtil.ctol( httpContext.cgiGet( edtSexoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1743SexoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1743SexoId), 2, 0));
            forbiddenHiddens.add("SexoId", localUtil.format( DecimalUtil.doubleToDec(A1743SexoId), "Z9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A1743SexoId != Z1743SexoId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("sexos:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1743SexoId = (byte)(GXutil.lval( httpContext.GetPar( "SexoId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1743SexoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1743SexoId), 2, 0));
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
                  sMode235 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode235 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound235 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_530( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "SEXOID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSexoId_Internalname ;
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
                        e11532 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12532 ();
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
         e12532 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll53235( ) ;
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
         disableAttributes53235( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosexopaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosexopaicod_Enabled), 5, 0), true);
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

   public void confirm_530( )
   {
      beforeValidate53235( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls53235( ) ;
         }
         else
         {
            checkExtendedTable53235( ) ;
            closeExtendedTableCursors53235( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption530( )
   {
   }

   public void e11532( )
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
      edtSexoPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSexoPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSexoPaiCod_Visible), 5, 0), true);
      AV20ComboSexoPaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSexoPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboSexoPaiCod), 4, 0));
      edtavCombosexopaicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosexopaicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosexopaicod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOSEXOPAICOD' */
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSexos_Insert", GXv_boolean5) ;
         sexos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSexos_Update", GXv_boolean5) ;
         sexos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSexos_Delete", GXv_boolean5) ;
         sexos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SexoPaiCod") == 0 )
            {
               AV13Insert_SexoPaiCod = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_SexoPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_SexoPaiCod), 4, 0));
               if ( ! (0==AV13Insert_SexoPaiCod) )
               {
                  AV20ComboSexoPaiCod = AV13Insert_SexoPaiCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSexoPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboSexoPaiCod), 4, 0));
                  Combo_sexopaicod_Selectedvalue_set = GXutil.trim( GXutil.str( AV20ComboSexoPaiCod, 4, 0)) ;
                  ucCombo_sexopaicod.sendProperty(context, "", false, Combo_sexopaicod_Internalname, "SelectedValue_set", Combo_sexopaicod_Selectedvalue_set);
                  GXt_char6 = AV19Combo_DataJson ;
                  GXv_char7[0] = AV17ComboSelectedValue ;
                  GXv_char8[0] = AV18ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.sexosloaddvcombo(remoteHandle, context).execute( "SexoPaiCod", "GET", false, AV7SexoId, AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  sexos_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
                  sexos_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
                  sexos_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
                  AV19Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
                  Combo_sexopaicod_Selectedtext_set = AV18ComboSelectedText ;
                  ucCombo_sexopaicod.sendProperty(context, "", false, Combo_sexopaicod_Internalname, "SelectedText_set", Combo_sexopaicod_Selectedtext_set);
                  Combo_sexopaicod_Enabled = false ;
                  ucCombo_sexopaicod.sendProperty(context, "", false, Combo_sexopaicod_Internalname, "Enabled", GXutil.booltostr( Combo_sexopaicod_Enabled));
               }
            }
            AV23GXV1 = (int)(AV23GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         }
      }
   }

   public void e12532( )
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
      /* 'LOADCOMBOSEXOPAICOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char9[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.sexosloaddvcombo(remoteHandle, context).execute( "SexoPaiCod", Gx_mode, false, AV7SexoId, "", GXv_char9, GXv_char8, GXv_char7) ;
      sexos_impl.this.AV17ComboSelectedValue = GXv_char9[0] ;
      sexos_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      sexos_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
      AV19Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
      Combo_sexopaicod_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_sexopaicod.sendProperty(context, "", false, Combo_sexopaicod_Internalname, "SelectedValue_set", Combo_sexopaicod_Selectedvalue_set);
      Combo_sexopaicod_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_sexopaicod.sendProperty(context, "", false, Combo_sexopaicod_Internalname, "SelectedText_set", Combo_sexopaicod_Selectedtext_set);
      AV20ComboSexoPaiCod = (short)(GXutil.lval( AV17ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSexoPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboSexoPaiCod), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_sexopaicod_Enabled = false ;
         ucCombo_sexopaicod.sendProperty(context, "", false, Combo_sexopaicod_Internalname, "Enabled", GXutil.booltostr( Combo_sexopaicod_Enabled));
      }
   }

   public void zm53235( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1744SexoNombre = T00533_A1744SexoNombre[0] ;
            Z1745SexoBiologico = T00533_A1745SexoBiologico[0] ;
            Z1746SexoIdentidad = T00533_A1746SexoIdentidad[0] ;
            Z2092SexoCodFor = T00533_A2092SexoCodFor[0] ;
            Z1742SexoPaiCod = T00533_A1742SexoPaiCod[0] ;
         }
         else
         {
            Z1744SexoNombre = A1744SexoNombre ;
            Z1745SexoBiologico = A1745SexoBiologico ;
            Z1746SexoIdentidad = A1746SexoIdentidad ;
            Z2092SexoCodFor = A2092SexoCodFor ;
            Z1742SexoPaiCod = A1742SexoPaiCod ;
         }
      }
      if ( GX_JID == -10 )
      {
         Z1743SexoId = A1743SexoId ;
         Z1744SexoNombre = A1744SexoNombre ;
         Z1745SexoBiologico = A1745SexoBiologico ;
         Z1746SexoIdentidad = A1746SexoIdentidad ;
         Z2092SexoCodFor = A2092SexoCodFor ;
         Z1742SexoPaiCod = A1742SexoPaiCod ;
      }
   }

   public void standaloneNotModal( )
   {
      edtSexoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSexoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSexoId_Enabled), 5, 0), true);
      edtSexoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSexoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSexoId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7SexoId) )
      {
         A1743SexoId = AV7SexoId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1743SexoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1743SexoId), 2, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_SexoPaiCod) )
      {
         edtSexoPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSexoPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSexoPaiCod_Enabled), 5, 0), true);
      }
      else
      {
         edtSexoPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSexoPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSexoPaiCod_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_SexoPaiCod) )
      {
         A1742SexoPaiCod = AV13Insert_SexoPaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1742SexoPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1742SexoPaiCod), 4, 0));
      }
      else
      {
         A1742SexoPaiCod = AV20ComboSexoPaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1742SexoPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1742SexoPaiCod), 4, 0));
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
         AV22Pgmname = "Sexos" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
   }

   public void load53235( )
   {
      /* Using cursor T00535 */
      pr_default.execute(3, new Object[] {Byte.valueOf(A1743SexoId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound235 = (short)(1) ;
         A1744SexoNombre = T00535_A1744SexoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1744SexoNombre", A1744SexoNombre);
         A1745SexoBiologico = T00535_A1745SexoBiologico[0] ;
         n1745SexoBiologico = T00535_n1745SexoBiologico[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1745SexoBiologico", A1745SexoBiologico);
         A1746SexoIdentidad = T00535_A1746SexoIdentidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1746SexoIdentidad", A1746SexoIdentidad);
         A2092SexoCodFor = T00535_A2092SexoCodFor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2092SexoCodFor", A2092SexoCodFor);
         A1742SexoPaiCod = T00535_A1742SexoPaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1742SexoPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1742SexoPaiCod), 4, 0));
         zm53235( -10) ;
      }
      pr_default.close(3);
      onLoadActions53235( ) ;
   }

   public void onLoadActions53235( )
   {
      AV22Pgmname = "Sexos" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
   }

   public void checkExtendedTable53235( )
   {
      nIsDirty_235 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV22Pgmname = "Sexos" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      /* Using cursor T00536 */
      pr_default.execute(4, new Object[] {Short.valueOf(A1742SexoPaiCod), A2092SexoCodFor, Byte.valueOf(A1743SexoId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Sexo Pai Cod", "")+","+httpContext.getMessage( "Código como parámetro de cálculos en fórmulas", "")}), 1, "SEXOPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSexoPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      /* Using cursor T00534 */
      pr_default.execute(2, new Object[] {Short.valueOf(A1742SexoPaiCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Sexo_pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SEXOPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSexoPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A1745SexoBiologico, "macho") == 0 ) || ( GXutil.strcmp(A1745SexoBiologico, "hembra") == 0 ) || (GXutil.strcmp("", A1745SexoBiologico)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Sexo Biologico", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "SEXOBIOLOGICO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbSexoBiologico.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1746SexoIdentidad, "macho") == 0 ) || ( GXutil.strcmp(A1746SexoIdentidad, "hembra") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Sexo Identidad", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "SEXOIDENTIDAD");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbSexoIdentidad.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors53235( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_12( short A1742SexoPaiCod )
   {
      /* Using cursor T00537 */
      pr_default.execute(5, new Object[] {Short.valueOf(A1742SexoPaiCod)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Sexo_pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SEXOPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSexoPaiCod_Internalname ;
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

   public void getKey53235( )
   {
      /* Using cursor T00538 */
      pr_default.execute(6, new Object[] {Byte.valueOf(A1743SexoId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound235 = (short)(1) ;
      }
      else
      {
         RcdFound235 = (short)(0) ;
      }
      pr_default.close(6);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00533 */
      pr_default.execute(1, new Object[] {Byte.valueOf(A1743SexoId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm53235( 10) ;
         RcdFound235 = (short)(1) ;
         A1743SexoId = T00533_A1743SexoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1743SexoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1743SexoId), 2, 0));
         A1744SexoNombre = T00533_A1744SexoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1744SexoNombre", A1744SexoNombre);
         A1745SexoBiologico = T00533_A1745SexoBiologico[0] ;
         n1745SexoBiologico = T00533_n1745SexoBiologico[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1745SexoBiologico", A1745SexoBiologico);
         A1746SexoIdentidad = T00533_A1746SexoIdentidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1746SexoIdentidad", A1746SexoIdentidad);
         A2092SexoCodFor = T00533_A2092SexoCodFor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2092SexoCodFor", A2092SexoCodFor);
         A1742SexoPaiCod = T00533_A1742SexoPaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1742SexoPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1742SexoPaiCod), 4, 0));
         Z1743SexoId = A1743SexoId ;
         sMode235 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load53235( ) ;
         if ( AnyError == 1 )
         {
            RcdFound235 = (short)(0) ;
            initializeNonKey53235( ) ;
         }
         Gx_mode = sMode235 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound235 = (short)(0) ;
         initializeNonKey53235( ) ;
         sMode235 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode235 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey53235( ) ;
      if ( RcdFound235 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound235 = (short)(0) ;
      /* Using cursor T00539 */
      pr_default.execute(7, new Object[] {Byte.valueOf(A1743SexoId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00539_A1743SexoId[0] < A1743SexoId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00539_A1743SexoId[0] > A1743SexoId ) ) )
         {
            A1743SexoId = T00539_A1743SexoId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1743SexoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1743SexoId), 2, 0));
            RcdFound235 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void move_previous( )
   {
      RcdFound235 = (short)(0) ;
      /* Using cursor T005310 */
      pr_default.execute(8, new Object[] {Byte.valueOf(A1743SexoId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T005310_A1743SexoId[0] > A1743SexoId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T005310_A1743SexoId[0] < A1743SexoId ) ) )
         {
            A1743SexoId = T005310_A1743SexoId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1743SexoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1743SexoId), 2, 0));
            RcdFound235 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey53235( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtSexoPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert53235( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound235 == 1 )
         {
            if ( A1743SexoId != Z1743SexoId )
            {
               A1743SexoId = Z1743SexoId ;
               httpContext.ajax_rsp_assign_attri("", false, "A1743SexoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1743SexoId), 2, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "SEXOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSexoId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtSexoPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update53235( ) ;
               GX_FocusControl = edtSexoPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A1743SexoId != Z1743SexoId )
            {
               /* Insert record */
               GX_FocusControl = edtSexoPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert53235( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "SEXOID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSexoId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtSexoPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert53235( ) ;
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
      if ( A1743SexoId != Z1743SexoId )
      {
         A1743SexoId = Z1743SexoId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1743SexoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1743SexoId), 2, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "SEXOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSexoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtSexoPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency53235( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00532 */
         pr_default.execute(0, new Object[] {Byte.valueOf(A1743SexoId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Sexos"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1744SexoNombre, T00532_A1744SexoNombre[0]) != 0 ) || ( GXutil.strcmp(Z1745SexoBiologico, T00532_A1745SexoBiologico[0]) != 0 ) || ( GXutil.strcmp(Z1746SexoIdentidad, T00532_A1746SexoIdentidad[0]) != 0 ) || ( GXutil.strcmp(Z2092SexoCodFor, T00532_A2092SexoCodFor[0]) != 0 ) || ( Z1742SexoPaiCod != T00532_A1742SexoPaiCod[0] ) )
         {
            if ( GXutil.strcmp(Z1744SexoNombre, T00532_A1744SexoNombre[0]) != 0 )
            {
               GXutil.writeLogln("sexos:[seudo value changed for attri]"+"SexoNombre");
               GXutil.writeLogRaw("Old: ",Z1744SexoNombre);
               GXutil.writeLogRaw("Current: ",T00532_A1744SexoNombre[0]);
            }
            if ( GXutil.strcmp(Z1745SexoBiologico, T00532_A1745SexoBiologico[0]) != 0 )
            {
               GXutil.writeLogln("sexos:[seudo value changed for attri]"+"SexoBiologico");
               GXutil.writeLogRaw("Old: ",Z1745SexoBiologico);
               GXutil.writeLogRaw("Current: ",T00532_A1745SexoBiologico[0]);
            }
            if ( GXutil.strcmp(Z1746SexoIdentidad, T00532_A1746SexoIdentidad[0]) != 0 )
            {
               GXutil.writeLogln("sexos:[seudo value changed for attri]"+"SexoIdentidad");
               GXutil.writeLogRaw("Old: ",Z1746SexoIdentidad);
               GXutil.writeLogRaw("Current: ",T00532_A1746SexoIdentidad[0]);
            }
            if ( GXutil.strcmp(Z2092SexoCodFor, T00532_A2092SexoCodFor[0]) != 0 )
            {
               GXutil.writeLogln("sexos:[seudo value changed for attri]"+"SexoCodFor");
               GXutil.writeLogRaw("Old: ",Z2092SexoCodFor);
               GXutil.writeLogRaw("Current: ",T00532_A2092SexoCodFor[0]);
            }
            if ( Z1742SexoPaiCod != T00532_A1742SexoPaiCod[0] )
            {
               GXutil.writeLogln("sexos:[seudo value changed for attri]"+"SexoPaiCod");
               GXutil.writeLogRaw("Old: ",Z1742SexoPaiCod);
               GXutil.writeLogRaw("Current: ",T00532_A1742SexoPaiCod[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Sexos"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert53235( )
   {
      beforeValidate53235( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable53235( ) ;
      }
      if ( AnyError == 0 )
      {
         zm53235( 0) ;
         checkOptimisticConcurrency53235( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm53235( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert53235( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005311 */
                  pr_default.execute(9, new Object[] {A1744SexoNombre, Boolean.valueOf(n1745SexoBiologico), A1745SexoBiologico, A1746SexoIdentidad, A2092SexoCodFor, Short.valueOf(A1742SexoPaiCod)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T005312 */
                  pr_default.execute(10);
                  A1743SexoId = T005312_A1743SexoId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1743SexoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1743SexoId), 2, 0));
                  pr_default.close(10);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Sexos");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption530( ) ;
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
            load53235( ) ;
         }
         endLevel53235( ) ;
      }
      closeExtendedTableCursors53235( ) ;
   }

   public void update53235( )
   {
      beforeValidate53235( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable53235( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency53235( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm53235( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate53235( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005313 */
                  pr_default.execute(11, new Object[] {A1744SexoNombre, Boolean.valueOf(n1745SexoBiologico), A1745SexoBiologico, A1746SexoIdentidad, A2092SexoCodFor, Short.valueOf(A1742SexoPaiCod), Byte.valueOf(A1743SexoId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Sexos");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Sexos"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate53235( ) ;
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
         endLevel53235( ) ;
      }
      closeExtendedTableCursors53235( ) ;
   }

   public void deferredUpdate53235( )
   {
   }

   public void delete( )
   {
      beforeValidate53235( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency53235( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls53235( ) ;
         afterConfirm53235( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete53235( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005314 */
               pr_default.execute(12, new Object[] {Byte.valueOf(A1743SexoId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Sexos");
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
      sMode235 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel53235( ) ;
      Gx_mode = sMode235 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls53235( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV22Pgmname = "Sexos" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T005315 */
         pr_default.execute(13, new Object[] {Byte.valueOf(A1743SexoId)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void endLevel53235( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete53235( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "sexos");
         if ( AnyError == 0 )
         {
            confirmValues530( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "sexos");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart53235( )
   {
      /* Scan By routine */
      /* Using cursor T005316 */
      pr_default.execute(14);
      RcdFound235 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound235 = (short)(1) ;
         A1743SexoId = T005316_A1743SexoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1743SexoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1743SexoId), 2, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext53235( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound235 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound235 = (short)(1) ;
         A1743SexoId = T005316_A1743SexoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1743SexoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1743SexoId), 2, 0));
      }
   }

   public void scanEnd53235( )
   {
      pr_default.close(14);
   }

   public void afterConfirm53235( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert53235( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate53235( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete53235( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete53235( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate53235( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes53235( )
   {
      edtSexoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSexoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSexoId_Enabled), 5, 0), true);
      edtSexoPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSexoPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSexoPaiCod_Enabled), 5, 0), true);
      edtSexoNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSexoNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSexoNombre_Enabled), 5, 0), true);
      cmbSexoBiologico.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbSexoBiologico.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSexoBiologico.getEnabled(), 5, 0), true);
      cmbSexoIdentidad.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbSexoIdentidad.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSexoIdentidad.getEnabled(), 5, 0), true);
      edtSexoCodFor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSexoCodFor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSexoCodFor_Enabled), 5, 0), true);
      edtavCombosexopaicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosexopaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosexopaicod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes53235( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues530( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.sexos", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7SexoId,2,0))}, new String[] {"Gx_mode","SexoId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Sexos");
      forbiddenHiddens.add("SexoId", localUtil.format( DecimalUtil.doubleToDec(A1743SexoId), "Z9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("sexos:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z1743SexoId", GXutil.ltrim( localUtil.ntoc( Z1743SexoId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1744SexoNombre", Z1744SexoNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1745SexoBiologico", GXutil.rtrim( Z1745SexoBiologico));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1746SexoIdentidad", GXutil.rtrim( Z1746SexoIdentidad));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2092SexoCodFor", GXutil.rtrim( Z2092SexoCodFor));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1742SexoPaiCod", GXutil.ltrim( localUtil.ntoc( Z1742SexoPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1742SexoPaiCod", GXutil.ltrim( localUtil.ntoc( A1742SexoPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSEXOPAICOD_DATA", AV15SexoPaiCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSEXOPAICOD_DATA", AV15SexoPaiCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vSEXOID", GXutil.ltrim( localUtil.ntoc( AV7SexoId, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSEXOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7SexoId), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SEXOPAICOD", GXutil.ltrim( localUtil.ntoc( AV13Insert_SexoPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV22Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SEXOPAICOD_Objectcall", GXutil.rtrim( Combo_sexopaicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SEXOPAICOD_Cls", GXutil.rtrim( Combo_sexopaicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SEXOPAICOD_Selectedvalue_set", GXutil.rtrim( Combo_sexopaicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SEXOPAICOD_Selectedtext_set", GXutil.rtrim( Combo_sexopaicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SEXOPAICOD_Enabled", GXutil.booltostr( Combo_sexopaicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SEXOPAICOD_Datalistproc", GXutil.rtrim( Combo_sexopaicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SEXOPAICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_sexopaicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SEXOPAICOD_Emptyitem", GXutil.booltostr( Combo_sexopaicod_Emptyitem));
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
      return formatLink("web.sexos", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7SexoId,2,0))}, new String[] {"Gx_mode","SexoId"})  ;
   }

   public String getPgmname( )
   {
      return "Sexos" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Sexos", "") ;
   }

   public void initializeNonKey53235( )
   {
      A1742SexoPaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1742SexoPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1742SexoPaiCod), 4, 0));
      A1744SexoNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1744SexoNombre", A1744SexoNombre);
      A1745SexoBiologico = "" ;
      n1745SexoBiologico = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1745SexoBiologico", A1745SexoBiologico);
      n1745SexoBiologico = ((GXutil.strcmp("", A1745SexoBiologico)==0) ? true : false) ;
      A1746SexoIdentidad = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1746SexoIdentidad", A1746SexoIdentidad);
      A2092SexoCodFor = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2092SexoCodFor", A2092SexoCodFor);
      Z1744SexoNombre = "" ;
      Z1745SexoBiologico = "" ;
      Z1746SexoIdentidad = "" ;
      Z2092SexoCodFor = "" ;
      Z1742SexoPaiCod = (short)(0) ;
   }

   public void initAll53235( )
   {
      A1743SexoId = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1743SexoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1743SexoId), 2, 0));
      initializeNonKey53235( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713583830", true, true);
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
      httpContext.AddJavascriptSource("sexos.js", "?20251713583830", false, true);
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
      edtSexoId_Internalname = "SEXOID" ;
      lblTextblocksexopaicod_Internalname = "TEXTBLOCKSEXOPAICOD" ;
      Combo_sexopaicod_Internalname = "COMBO_SEXOPAICOD" ;
      edtSexoPaiCod_Internalname = "SEXOPAICOD" ;
      divTablesplittedsexopaicod_Internalname = "TABLESPLITTEDSEXOPAICOD" ;
      edtSexoNombre_Internalname = "SEXONOMBRE" ;
      cmbSexoBiologico.setInternalname( "SEXOBIOLOGICO" );
      cmbSexoIdentidad.setInternalname( "SEXOIDENTIDAD" );
      edtSexoCodFor_Internalname = "SEXOCODFOR" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombosexopaicod_Internalname = "vCOMBOSEXOPAICOD" ;
      divSectionattribute_sexopaicod_Internalname = "SECTIONATTRIBUTE_SEXOPAICOD" ;
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
      Form.setCaption( httpContext.getMessage( "Sexos", "") );
      edtavCombosexopaicod_Jsonclick = "" ;
      edtavCombosexopaicod_Enabled = 0 ;
      edtavCombosexopaicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtSexoCodFor_Jsonclick = "" ;
      edtSexoCodFor_Enabled = 1 ;
      cmbSexoIdentidad.setJsonclick( "" );
      cmbSexoIdentidad.setEnabled( 1 );
      cmbSexoBiologico.setJsonclick( "" );
      cmbSexoBiologico.setEnabled( 1 );
      edtSexoNombre_Jsonclick = "" ;
      edtSexoNombre_Enabled = 1 ;
      edtSexoPaiCod_Jsonclick = "" ;
      edtSexoPaiCod_Enabled = 1 ;
      edtSexoPaiCod_Visible = 1 ;
      Combo_sexopaicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_sexopaicod_Datalistprocparametersprefix = " \"ComboName\": \"SexoPaiCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"SexoId\": 0" ;
      Combo_sexopaicod_Datalistproc = "SexosLoadDVCombo" ;
      Combo_sexopaicod_Cls = "ExtendedCombo Attribute" ;
      Combo_sexopaicod_Caption = "" ;
      Combo_sexopaicod_Enabled = GXutil.toBoolean( -1) ;
      edtSexoId_Jsonclick = "" ;
      edtSexoId_Enabled = 0 ;
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
      cmbSexoBiologico.setName( "SEXOBIOLOGICO" );
      cmbSexoBiologico.setWebtags( "" );
      cmbSexoBiologico.addItem("macho", httpContext.getMessage( "Masculino", ""), (short)(0));
      cmbSexoBiologico.addItem("hembra", httpContext.getMessage( "Femenino", ""), (short)(0));
      if ( cmbSexoBiologico.getItemCount() > 0 )
      {
         A1745SexoBiologico = cmbSexoBiologico.getValidValue(A1745SexoBiologico) ;
         n1745SexoBiologico = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1745SexoBiologico", A1745SexoBiologico);
      }
      cmbSexoIdentidad.setName( "SEXOIDENTIDAD" );
      cmbSexoIdentidad.setWebtags( "" );
      cmbSexoIdentidad.addItem("", httpContext.getMessage( "No especificado", ""), (short)(0));
      cmbSexoIdentidad.addItem("macho", httpContext.getMessage( "Masculino", ""), (short)(0));
      cmbSexoIdentidad.addItem("hembra", httpContext.getMessage( "Femenino", ""), (short)(0));
      if ( cmbSexoIdentidad.getItemCount() > 0 )
      {
         A1746SexoIdentidad = cmbSexoIdentidad.getValidValue(A1746SexoIdentidad) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1746SexoIdentidad", A1746SexoIdentidad);
      }
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

   public void valid_Sexopaicod( )
   {
      /* Using cursor T005317 */
      pr_default.execute(15, new Object[] {Short.valueOf(A1742SexoPaiCod)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Sexo_pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SEXOPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSexoPaiCod_Internalname ;
      }
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Sexocodfor( )
   {
      /* Using cursor T005318 */
      pr_default.execute(16, new Object[] {Short.valueOf(A1742SexoPaiCod), A2092SexoCodFor, Byte.valueOf(A1743SexoId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Sexo Pai Cod", "")+","+httpContext.getMessage( "Código como parámetro de cálculos en fórmulas", "")}), 1, "SEXOPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSexoPaiCod_Internalname ;
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7SexoId',fld:'vSEXOID',pic:'Z9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7SexoId',fld:'vSEXOID',pic:'Z9',hsh:true},{av:'A1743SexoId',fld:'SEXOID',pic:'Z9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12532',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_SEXOID","{handler:'valid_Sexoid',iparms:[]");
      setEventMetadata("VALID_SEXOID",",oparms:[]}");
      setEventMetadata("VALID_SEXOPAICOD","{handler:'valid_Sexopaicod',iparms:[{av:'A1742SexoPaiCod',fld:'SEXOPAICOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_SEXOPAICOD",",oparms:[]}");
      setEventMetadata("VALID_SEXOBIOLOGICO","{handler:'valid_Sexobiologico',iparms:[]");
      setEventMetadata("VALID_SEXOBIOLOGICO",",oparms:[]}");
      setEventMetadata("VALID_SEXOIDENTIDAD","{handler:'valid_Sexoidentidad',iparms:[]");
      setEventMetadata("VALID_SEXOIDENTIDAD",",oparms:[]}");
      setEventMetadata("VALID_SEXOCODFOR","{handler:'valid_Sexocodfor',iparms:[{av:'A1742SexoPaiCod',fld:'SEXOPAICOD',pic:'ZZZ9'},{av:'A2092SexoCodFor',fld:'SEXOCODFOR',pic:''},{av:'A1743SexoId',fld:'SEXOID',pic:'Z9'}]");
      setEventMetadata("VALID_SEXOCODFOR",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOSEXOPAICOD","{handler:'validv_Combosexopaicod',iparms:[]");
      setEventMetadata("VALIDV_COMBOSEXOPAICOD",",oparms:[]}");
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
      Z1744SexoNombre = "" ;
      Z1745SexoBiologico = "" ;
      Z1746SexoIdentidad = "" ;
      Z2092SexoCodFor = "" ;
      Combo_sexopaicod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1745SexoBiologico = "" ;
      A1746SexoIdentidad = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblocksexopaicod_Jsonclick = "" ;
      ucCombo_sexopaicod = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15SexoPaiCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A1744SexoNombre = "" ;
      A2092SexoCodFor = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV22Pgmname = "" ;
      Combo_sexopaicod_Objectcall = "" ;
      Combo_sexopaicod_Class = "" ;
      Combo_sexopaicod_Icontype = "" ;
      Combo_sexopaicod_Icon = "" ;
      Combo_sexopaicod_Tooltip = "" ;
      Combo_sexopaicod_Selectedvalue_set = "" ;
      Combo_sexopaicod_Selectedtext_set = "" ;
      Combo_sexopaicod_Selectedtext_get = "" ;
      Combo_sexopaicod_Gamoauthtoken = "" ;
      Combo_sexopaicod_Ddointernalname = "" ;
      Combo_sexopaicod_Titlecontrolalign = "" ;
      Combo_sexopaicod_Dropdownoptionstype = "" ;
      Combo_sexopaicod_Titlecontrolidtoreplace = "" ;
      Combo_sexopaicod_Datalisttype = "" ;
      Combo_sexopaicod_Datalistfixedvalues = "" ;
      Combo_sexopaicod_Remoteservicesparameters = "" ;
      Combo_sexopaicod_Htmltemplate = "" ;
      Combo_sexopaicod_Multiplevaluestype = "" ;
      Combo_sexopaicod_Loadingdata = "" ;
      Combo_sexopaicod_Noresultsfound = "" ;
      Combo_sexopaicod_Emptyitemtext = "" ;
      Combo_sexopaicod_Onlyselectedvalues = "" ;
      Combo_sexopaicod_Selectalltext = "" ;
      Combo_sexopaicod_Multiplevaluesseparator = "" ;
      Combo_sexopaicod_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode235 = "" ;
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
      T00535_A1743SexoId = new byte[1] ;
      T00535_A1744SexoNombre = new String[] {""} ;
      T00535_A1745SexoBiologico = new String[] {""} ;
      T00535_n1745SexoBiologico = new boolean[] {false} ;
      T00535_A1746SexoIdentidad = new String[] {""} ;
      T00535_A2092SexoCodFor = new String[] {""} ;
      T00535_A1742SexoPaiCod = new short[1] ;
      T00536_A1742SexoPaiCod = new short[1] ;
      T00534_A1742SexoPaiCod = new short[1] ;
      T00537_A1742SexoPaiCod = new short[1] ;
      T00538_A1743SexoId = new byte[1] ;
      T00533_A1743SexoId = new byte[1] ;
      T00533_A1744SexoNombre = new String[] {""} ;
      T00533_A1745SexoBiologico = new String[] {""} ;
      T00533_n1745SexoBiologico = new boolean[] {false} ;
      T00533_A1746SexoIdentidad = new String[] {""} ;
      T00533_A2092SexoCodFor = new String[] {""} ;
      T00533_A1742SexoPaiCod = new short[1] ;
      T00539_A1743SexoId = new byte[1] ;
      T005310_A1743SexoId = new byte[1] ;
      T00532_A1743SexoId = new byte[1] ;
      T00532_A1744SexoNombre = new String[] {""} ;
      T00532_A1745SexoBiologico = new String[] {""} ;
      T00532_n1745SexoBiologico = new boolean[] {false} ;
      T00532_A1746SexoIdentidad = new String[] {""} ;
      T00532_A2092SexoCodFor = new String[] {""} ;
      T00532_A1742SexoPaiCod = new short[1] ;
      T005312_A1743SexoId = new byte[1] ;
      T005315_A3CliCod = new int[1] ;
      T005315_A1EmpCod = new short[1] ;
      T005315_A6LegNumero = new int[1] ;
      T005316_A1743SexoId = new byte[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T005317_A1742SexoPaiCod = new short[1] ;
      T005318_A1742SexoPaiCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.sexos__default(),
         new Object[] {
             new Object[] {
            T00532_A1743SexoId, T00532_A1744SexoNombre, T00532_A1745SexoBiologico, T00532_n1745SexoBiologico, T00532_A1746SexoIdentidad, T00532_A2092SexoCodFor, T00532_A1742SexoPaiCod
            }
            , new Object[] {
            T00533_A1743SexoId, T00533_A1744SexoNombre, T00533_A1745SexoBiologico, T00533_n1745SexoBiologico, T00533_A1746SexoIdentidad, T00533_A2092SexoCodFor, T00533_A1742SexoPaiCod
            }
            , new Object[] {
            T00534_A1742SexoPaiCod
            }
            , new Object[] {
            T00535_A1743SexoId, T00535_A1744SexoNombre, T00535_A1745SexoBiologico, T00535_n1745SexoBiologico, T00535_A1746SexoIdentidad, T00535_A2092SexoCodFor, T00535_A1742SexoPaiCod
            }
            , new Object[] {
            T00536_A1742SexoPaiCod
            }
            , new Object[] {
            T00537_A1742SexoPaiCod
            }
            , new Object[] {
            T00538_A1743SexoId
            }
            , new Object[] {
            T00539_A1743SexoId
            }
            , new Object[] {
            T005310_A1743SexoId
            }
            , new Object[] {
            }
            , new Object[] {
            T005312_A1743SexoId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005315_A3CliCod, T005315_A1EmpCod, T005315_A6LegNumero
            }
            , new Object[] {
            T005316_A1743SexoId
            }
            , new Object[] {
            T005317_A1742SexoPaiCod
            }
            , new Object[] {
            T005318_A1742SexoPaiCod
            }
         }
      );
      AV22Pgmname = "Sexos" ;
   }

   private byte wcpOAV7SexoId ;
   private byte Z1743SexoId ;
   private byte GxWebError ;
   private byte AV7SexoId ;
   private byte nKeyPressed ;
   private byte A1743SexoId ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z1742SexoPaiCod ;
   private short N1742SexoPaiCod ;
   private short A1742SexoPaiCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV20ComboSexoPaiCod ;
   private short AV13Insert_SexoPaiCod ;
   private short RcdFound235 ;
   private short nIsDirty_235 ;
   private int trnEnded ;
   private int edtSexoId_Enabled ;
   private int edtSexoPaiCod_Visible ;
   private int edtSexoPaiCod_Enabled ;
   private int edtSexoNombre_Enabled ;
   private int edtSexoCodFor_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombosexopaicod_Enabled ;
   private int edtavCombosexopaicod_Visible ;
   private int Combo_sexopaicod_Datalistupdateminimumcharacters ;
   private int Combo_sexopaicod_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV23GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z1745SexoBiologico ;
   private String Z1746SexoIdentidad ;
   private String Z2092SexoCodFor ;
   private String Combo_sexopaicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtSexoPaiCod_Internalname ;
   private String A1745SexoBiologico ;
   private String A1746SexoIdentidad ;
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
   private String edtSexoId_Internalname ;
   private String edtSexoId_Jsonclick ;
   private String divTablesplittedsexopaicod_Internalname ;
   private String lblTextblocksexopaicod_Internalname ;
   private String lblTextblocksexopaicod_Jsonclick ;
   private String Combo_sexopaicod_Caption ;
   private String Combo_sexopaicod_Cls ;
   private String Combo_sexopaicod_Datalistproc ;
   private String Combo_sexopaicod_Datalistprocparametersprefix ;
   private String Combo_sexopaicod_Internalname ;
   private String TempTags ;
   private String edtSexoPaiCod_Jsonclick ;
   private String edtSexoNombre_Internalname ;
   private String edtSexoNombre_Jsonclick ;
   private String edtSexoCodFor_Internalname ;
   private String A2092SexoCodFor ;
   private String edtSexoCodFor_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_sexopaicod_Internalname ;
   private String edtavCombosexopaicod_Internalname ;
   private String edtavCombosexopaicod_Jsonclick ;
   private String AV22Pgmname ;
   private String Combo_sexopaicod_Objectcall ;
   private String Combo_sexopaicod_Class ;
   private String Combo_sexopaicod_Icontype ;
   private String Combo_sexopaicod_Icon ;
   private String Combo_sexopaicod_Tooltip ;
   private String Combo_sexopaicod_Selectedvalue_set ;
   private String Combo_sexopaicod_Selectedtext_set ;
   private String Combo_sexopaicod_Selectedtext_get ;
   private String Combo_sexopaicod_Gamoauthtoken ;
   private String Combo_sexopaicod_Ddointernalname ;
   private String Combo_sexopaicod_Titlecontrolalign ;
   private String Combo_sexopaicod_Dropdownoptionstype ;
   private String Combo_sexopaicod_Titlecontrolidtoreplace ;
   private String Combo_sexopaicod_Datalisttype ;
   private String Combo_sexopaicod_Datalistfixedvalues ;
   private String Combo_sexopaicod_Remoteservicesparameters ;
   private String Combo_sexopaicod_Htmltemplate ;
   private String Combo_sexopaicod_Multiplevaluestype ;
   private String Combo_sexopaicod_Loadingdata ;
   private String Combo_sexopaicod_Noresultsfound ;
   private String Combo_sexopaicod_Emptyitemtext ;
   private String Combo_sexopaicod_Onlyselectedvalues ;
   private String Combo_sexopaicod_Selectalltext ;
   private String Combo_sexopaicod_Multiplevaluesseparator ;
   private String Combo_sexopaicod_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode235 ;
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
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean n1745SexoBiologico ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_sexopaicod_Emptyitem ;
   private boolean Combo_sexopaicod_Enabled ;
   private boolean Combo_sexopaicod_Visible ;
   private boolean Combo_sexopaicod_Allowmultipleselection ;
   private boolean Combo_sexopaicod_Isgriditem ;
   private boolean Combo_sexopaicod_Hasdescription ;
   private boolean Combo_sexopaicod_Includeonlyselectedoption ;
   private boolean Combo_sexopaicod_Includeselectalloption ;
   private boolean Combo_sexopaicod_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String AV19Combo_DataJson ;
   private String Z1744SexoNombre ;
   private String A1744SexoNombre ;
   private String AV17ComboSelectedValue ;
   private String AV18ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_sexopaicod ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbSexoBiologico ;
   private HTMLChoice cmbSexoIdentidad ;
   private IDataStoreProvider pr_default ;
   private byte[] T00535_A1743SexoId ;
   private String[] T00535_A1744SexoNombre ;
   private String[] T00535_A1745SexoBiologico ;
   private boolean[] T00535_n1745SexoBiologico ;
   private String[] T00535_A1746SexoIdentidad ;
   private String[] T00535_A2092SexoCodFor ;
   private short[] T00535_A1742SexoPaiCod ;
   private short[] T00536_A1742SexoPaiCod ;
   private short[] T00534_A1742SexoPaiCod ;
   private short[] T00537_A1742SexoPaiCod ;
   private byte[] T00538_A1743SexoId ;
   private byte[] T00533_A1743SexoId ;
   private String[] T00533_A1744SexoNombre ;
   private String[] T00533_A1745SexoBiologico ;
   private boolean[] T00533_n1745SexoBiologico ;
   private String[] T00533_A1746SexoIdentidad ;
   private String[] T00533_A2092SexoCodFor ;
   private short[] T00533_A1742SexoPaiCod ;
   private byte[] T00539_A1743SexoId ;
   private byte[] T005310_A1743SexoId ;
   private byte[] T00532_A1743SexoId ;
   private String[] T00532_A1744SexoNombre ;
   private String[] T00532_A1745SexoBiologico ;
   private boolean[] T00532_n1745SexoBiologico ;
   private String[] T00532_A1746SexoIdentidad ;
   private String[] T00532_A2092SexoCodFor ;
   private short[] T00532_A1742SexoPaiCod ;
   private byte[] T005312_A1743SexoId ;
   private int[] T005315_A3CliCod ;
   private short[] T005315_A1EmpCod ;
   private int[] T005315_A6LegNumero ;
   private byte[] T005316_A1743SexoId ;
   private short[] T005317_A1742SexoPaiCod ;
   private short[] T005318_A1742SexoPaiCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15SexoPaiCod_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class sexos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00532", "SELECT SexoId, SexoNombre, SexoBiologico, SexoIdentidad, SexoCodFor, SexoPaiCod FROM Sexos WHERE SexoId = ?  FOR UPDATE OF Sexos NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00533", "SELECT SexoId, SexoNombre, SexoBiologico, SexoIdentidad, SexoCodFor, SexoPaiCod FROM Sexos WHERE SexoId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00534", "SELECT PaiCod AS SexoPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00535", "SELECT TM1.SexoId, TM1.SexoNombre, TM1.SexoBiologico, TM1.SexoIdentidad, TM1.SexoCodFor, TM1.SexoPaiCod AS SexoPaiCod FROM Sexos TM1 WHERE TM1.SexoId = ? ORDER BY TM1.SexoId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00536", "SELECT SexoPaiCod FROM Sexos WHERE (SexoPaiCod = ? AND SexoCodFor = ?) AND (Not ( SexoId = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00537", "SELECT PaiCod AS SexoPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00538", "SELECT SexoId FROM Sexos WHERE SexoId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00539", "SELECT SexoId FROM Sexos WHERE ( SexoId > ?) ORDER BY SexoId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005310", "SELECT SexoId FROM Sexos WHERE ( SexoId < ?) ORDER BY SexoId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005311", "SAVEPOINT gxupdate;INSERT INTO Sexos(SexoNombre, SexoBiologico, SexoIdentidad, SexoCodFor, SexoPaiCod) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005312", "SELECT currval('SexoId') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T005313", "SAVEPOINT gxupdate;UPDATE Sexos SET SexoNombre=?, SexoBiologico=?, SexoIdentidad=?, SexoCodFor=?, SexoPaiCod=?  WHERE SexoId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005314", "SAVEPOINT gxupdate;DELETE FROM Sexos  WHERE SexoId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005315", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE LegSexo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005316", "SELECT SexoId FROM Sexos ORDER BY SexoId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005317", "SELECT PaiCod AS SexoPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005318", "SELECT SexoPaiCod FROM Sexos WHERE (SexoPaiCod = ? AND SexoCodFor = ?) AND (Not ( SexoId = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 7 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 8 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 10 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 14 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
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
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               return;
            case 1 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               return;
            case 7 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               return;
            case 8 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 20);
               stmt.setString(4, (String)parms[4], 20);
               stmt.setShort(5, ((Number) parms[5]).shortValue());
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 20);
               stmt.setString(4, (String)parms[4], 20);
               stmt.setShort(5, ((Number) parms[5]).shortValue());
               stmt.setByte(6, ((Number) parms[6]).byteValue());
               return;
            case 12 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               return;
            case 13 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               return;
      }
   }

}

