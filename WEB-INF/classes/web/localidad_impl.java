package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class localidad_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_19") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         n46PaiCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_19( A46PaiCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_20") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         n46PaiCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A47ProvCod = (short)(GXutil.lval( httpContext.GetPar( "ProvCod"))) ;
         n47ProvCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_20( A46PaiCod, A47ProvCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_21") == 0 )
      {
         A2207LocaZona = httpContext.GetPar( "LocaZona") ;
         n2207LocaZona = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2207LocaZona", A2207LocaZona);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_21( A2207LocaZona) ;
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
            AV8PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8PaiCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8PaiCod), "ZZZ9")));
            AV9ProvCod = (short)(GXutil.lval( httpContext.GetPar( "ProvCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9ProvCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROVCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9ProvCod), "ZZZ9")));
            AV10LocCod = (short)(GXutil.lval( httpContext.GetPar( "LocCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LocCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLOCCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LocCod), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Localidad", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtProvCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public localidad_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public localidad_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( localidad_impl.class ));
   }

   public localidad_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedprovcod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockprovcod_Internalname, httpContext.getMessage( "Provincia", ""), "", "", lblTextblockprovcod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Localidad.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_provcod.setProperty("Caption", Combo_provcod_Caption);
      ucCombo_provcod.setProperty("Cls", Combo_provcod_Cls);
      ucCombo_provcod.setProperty("DataListProc", Combo_provcod_Datalistproc);
      ucCombo_provcod.setProperty("EmptyItem", Combo_provcod_Emptyitem);
      ucCombo_provcod.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_provcod.setProperty("DropDownOptionsData", AV25ProvCod_Data);
      ucCombo_provcod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_provcod_Internalname, "COMBO_PROVCODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtProvCod_Internalname, httpContext.getMessage( "Código de Provincia", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtProvCod_Internalname, GXutil.ltrim( localUtil.ntoc( A47ProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A47ProvCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProvCod_Jsonclick, 0, "Attribute", "", "", "", "", edtProvCod_Visible, edtProvCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Localidad.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLocCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLocCod_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLocCod_Internalname, GXutil.ltrim( localUtil.ntoc( A48LocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A48LocCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLocCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLocCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Localidad.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLocNom_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLocNom_Internalname, httpContext.getMessage( "Nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLocNom_Internalname, A286LocNom, GXutil.rtrim( localUtil.format( A286LocNom, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLocNom_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLocNom_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_Localidad.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Localidad.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Localidad.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Localidad.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_provcod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboprovcod_Internalname, GXutil.ltrim( localUtil.ntoc( AV26ComboProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboprovcod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV26ComboProvCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV26ComboProvCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboprovcod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboprovcod_Visible, edtavComboprovcod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Localidad.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,56);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiCod_Visible, edtPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Localidad.htm");
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
      e110Y2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPROVCOD_DATA"), AV25ProvCod_Data);
            /* Read saved values. */
            Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z47ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z47ProvCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z48LocCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z48LocCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z286LocNom = httpContext.cgiGet( "Z286LocNom") ;
            Z285LocCP = httpContext.cgiGet( "Z285LocCP") ;
            Z2207LocaZona = httpContext.cgiGet( "Z2207LocaZona") ;
            n2207LocaZona = ((GXutil.strcmp("", A2207LocaZona)==0) ? true : false) ;
            A285LocCP = httpContext.cgiGet( "Z285LocCP") ;
            A2207LocaZona = httpContext.cgiGet( "Z2207LocaZona") ;
            n2207LocaZona = false ;
            n2207LocaZona = ((GXutil.strcmp("", A2207LocaZona)==0) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N2207LocaZona = httpContext.cgiGet( "N2207LocaZona") ;
            n2207LocaZona = ((GXutil.strcmp("", A2207LocaZona)==0) ? true : false) ;
            AV8PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPROVCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV10LocCod = (short)(localUtil.ctol( httpContext.cgiGet( "vLOCCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV30Insert_LocaZona = httpContext.cgiGet( "vINSERT_LOCAZONA") ;
            A2207LocaZona = httpContext.cgiGet( "LOCAZONA") ;
            n2207LocaZona = ((GXutil.strcmp("", A2207LocaZona)==0) ? true : false) ;
            A285LocCP = httpContext.cgiGet( "LOCCP") ;
            A312PaiNom = httpContext.cgiGet( "PAINOM") ;
            A322ProvNom = httpContext.cgiGet( "PROVNOM") ;
            AV31Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_provcod_Objectcall = httpContext.cgiGet( "COMBO_PROVCOD_Objectcall") ;
            Combo_provcod_Class = httpContext.cgiGet( "COMBO_PROVCOD_Class") ;
            Combo_provcod_Icontype = httpContext.cgiGet( "COMBO_PROVCOD_Icontype") ;
            Combo_provcod_Icon = httpContext.cgiGet( "COMBO_PROVCOD_Icon") ;
            Combo_provcod_Caption = httpContext.cgiGet( "COMBO_PROVCOD_Caption") ;
            Combo_provcod_Tooltip = httpContext.cgiGet( "COMBO_PROVCOD_Tooltip") ;
            Combo_provcod_Cls = httpContext.cgiGet( "COMBO_PROVCOD_Cls") ;
            Combo_provcod_Selectedvalue_set = httpContext.cgiGet( "COMBO_PROVCOD_Selectedvalue_set") ;
            Combo_provcod_Selectedvalue_get = httpContext.cgiGet( "COMBO_PROVCOD_Selectedvalue_get") ;
            Combo_provcod_Selectedtext_set = httpContext.cgiGet( "COMBO_PROVCOD_Selectedtext_set") ;
            Combo_provcod_Selectedtext_get = httpContext.cgiGet( "COMBO_PROVCOD_Selectedtext_get") ;
            Combo_provcod_Gamoauthtoken = httpContext.cgiGet( "COMBO_PROVCOD_Gamoauthtoken") ;
            Combo_provcod_Ddointernalname = httpContext.cgiGet( "COMBO_PROVCOD_Ddointernalname") ;
            Combo_provcod_Titlecontrolalign = httpContext.cgiGet( "COMBO_PROVCOD_Titlecontrolalign") ;
            Combo_provcod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_PROVCOD_Dropdownoptionstype") ;
            Combo_provcod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Enabled")) ;
            Combo_provcod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Visible")) ;
            Combo_provcod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_PROVCOD_Titlecontrolidtoreplace") ;
            Combo_provcod_Datalisttype = httpContext.cgiGet( "COMBO_PROVCOD_Datalisttype") ;
            Combo_provcod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Allowmultipleselection")) ;
            Combo_provcod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_PROVCOD_Datalistfixedvalues") ;
            Combo_provcod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Isgriditem")) ;
            Combo_provcod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Hasdescription")) ;
            Combo_provcod_Datalistproc = httpContext.cgiGet( "COMBO_PROVCOD_Datalistproc") ;
            Combo_provcod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_PROVCOD_Datalistprocparametersprefix") ;
            Combo_provcod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_PROVCOD_Remoteservicesparameters") ;
            Combo_provcod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PROVCOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_provcod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Includeonlyselectedoption")) ;
            Combo_provcod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Includeselectalloption")) ;
            Combo_provcod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Emptyitem")) ;
            Combo_provcod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Includeaddnewoption")) ;
            Combo_provcod_Htmltemplate = httpContext.cgiGet( "COMBO_PROVCOD_Htmltemplate") ;
            Combo_provcod_Multiplevaluestype = httpContext.cgiGet( "COMBO_PROVCOD_Multiplevaluestype") ;
            Combo_provcod_Loadingdata = httpContext.cgiGet( "COMBO_PROVCOD_Loadingdata") ;
            Combo_provcod_Noresultsfound = httpContext.cgiGet( "COMBO_PROVCOD_Noresultsfound") ;
            Combo_provcod_Emptyitemtext = httpContext.cgiGet( "COMBO_PROVCOD_Emptyitemtext") ;
            Combo_provcod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_PROVCOD_Onlyselectedvalues") ;
            Combo_provcod_Selectalltext = httpContext.cgiGet( "COMBO_PROVCOD_Selectalltext") ;
            Combo_provcod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_PROVCOD_Multiplevaluesseparator") ;
            Combo_provcod_Addnewoptiontext = httpContext.cgiGet( "COMBO_PROVCOD_Addnewoptiontext") ;
            Combo_provcod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PROVCOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PROVCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtProvCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A47ProvCod = (short)(0) ;
               n47ProvCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
            }
            else
            {
               A47ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( edtProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n47ProvCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLocCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLocCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LOCCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLocCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A48LocCod = (short)(0) ;
               n48LocCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
            }
            else
            {
               A48LocCod = (short)(localUtil.ctol( httpContext.cgiGet( edtLocCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n48LocCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
            }
            A286LocNom = GXutil.upper( httpContext.cgiGet( edtLocNom_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A286LocNom", A286LocNom);
            AV26ComboProvCod = (short)(localUtil.ctol( httpContext.cgiGet( edtavComboprovcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ComboProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ComboProvCod), 4, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A46PaiCod = (short)(0) ;
               n46PaiCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            else
            {
               A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n46PaiCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Localidad");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("LocCP", GXutil.rtrim( localUtil.format( A285LocCP, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A46PaiCod != Z46PaiCod ) || ( A47ProvCod != Z47ProvCod ) || ( A48LocCod != Z48LocCod ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("localidad:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               n46PaiCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A47ProvCod = (short)(GXutil.lval( httpContext.GetPar( "ProvCod"))) ;
               n47ProvCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
               A48LocCod = (short)(GXutil.lval( httpContext.GetPar( "LocCod"))) ;
               n48LocCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
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
                  sMode31 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode31 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound31 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0Y0( ) ;
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
                        e110Y2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120Y2 ();
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
         e120Y2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0Y31( ) ;
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
         disableAttributes0Y31( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboprovcod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboprovcod_Enabled), 5, 0), true);
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

   public void confirm_0Y0( )
   {
      beforeValidate0Y31( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0Y31( ) ;
         }
         else
         {
            checkExtendedTable0Y31( ) ;
            closeExtendedTableCursors0Y31( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0Y0( )
   {
   }

   public void e110Y2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV17DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV17DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtProvCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProvCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvCod_Visible), 5, 0), true);
      AV26ComboProvCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ComboProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ComboProvCod), 4, 0));
      edtavComboprovcod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboprovcod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboprovcod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOPROVCOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV12IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV12IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLocalidad_Insert", GXv_boolean5) ;
         localidad_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV12IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLocalidad_Update", GXv_boolean5) ;
         localidad_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV12IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLocalidad_Delete", GXv_boolean5) ;
         localidad_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV12IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV31Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV14TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV31Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV32GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32GXV1), 8, 0));
         while ( AV32GXV1 <= AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV29TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV32GXV1));
            if ( GXutil.strcmp(AV29TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LocaZona") == 0 )
            {
               AV30Insert_LocaZona = AV29TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV30Insert_LocaZona", AV30Insert_LocaZona);
            }
            AV32GXV1 = (int)(AV32GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32GXV1), 8, 0));
         }
      }
      edtPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Visible), 5, 0), true);
   }

   public void e120Y2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'LOADCOMBOPROVCOD' Routine */
      returnInSub = false ;
      Combo_provcod_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"ProvCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PaiCod\": 0, \"ProvCod\": 0, \"LocCod\": 0, \"Cond_PaiCod\": \"#%1#\"", edtPaiCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_provcod.sendProperty(context, "", false, Combo_provcod_Internalname, "DataListProcParametersPrefix", Combo_provcod_Datalistprocparametersprefix);
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char7[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new web.localidadloaddvcombo(remoteHandle, context).execute( "ProvCod", Gx_mode, false, AV8PaiCod, AV9ProvCod, AV10LocCod, A46PaiCod, "", GXv_char7, GXv_char8, GXv_char9) ;
      localidad_impl.this.AV18ComboSelectedValue = GXv_char7[0] ;
      localidad_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      localidad_impl.this.GXt_char6 = GXv_char9[0] ;
      AV20Combo_DataJson = GXt_char6 ;
      Combo_provcod_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_provcod.sendProperty(context, "", false, Combo_provcod_Internalname, "SelectedValue_set", Combo_provcod_Selectedvalue_set);
      Combo_provcod_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_provcod.sendProperty(context, "", false, Combo_provcod_Internalname, "SelectedText_set", Combo_provcod_Selectedtext_set);
      AV26ComboProvCod = (short)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ComboProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ComboProvCod), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (0==AV9ProvCod) )
      {
         Combo_provcod_Enabled = false ;
         ucCombo_provcod.sendProperty(context, "", false, Combo_provcod_Internalname, "Enabled", GXutil.booltostr( Combo_provcod_Enabled));
      }
   }

   public void zm0Y31( int GX_JID )
   {
      if ( ( GX_JID == 18 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z286LocNom = T000Y3_A286LocNom[0] ;
            Z285LocCP = T000Y3_A285LocCP[0] ;
            Z2207LocaZona = T000Y3_A2207LocaZona[0] ;
         }
         else
         {
            Z286LocNom = A286LocNom ;
            Z285LocCP = A285LocCP ;
            Z2207LocaZona = A2207LocaZona ;
         }
      }
      if ( GX_JID == -18 )
      {
         Z48LocCod = A48LocCod ;
         Z286LocNom = A286LocNom ;
         Z285LocCP = A285LocCP ;
         Z46PaiCod = A46PaiCod ;
         Z47ProvCod = A47ProvCod ;
         Z2207LocaZona = A2207LocaZona ;
         Z312PaiNom = A312PaiNom ;
         Z322ProvNom = A322ProvNom ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV8PaiCod) )
      {
         A46PaiCod = AV8PaiCod ;
         n46PaiCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      if ( ! (0==AV8PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      else
      {
         edtPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9ProvCod) )
      {
         edtProvCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvCod_Enabled), 5, 0), true);
      }
      else
      {
         edtProvCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9ProvCod) )
      {
         edtProvCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10LocCod) )
      {
         A48LocCod = AV10LocCod ;
         n48LocCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
      }
      if ( ! (0==AV10LocCod) )
      {
         edtLocCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLocCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocCod_Enabled), 5, 0), true);
      }
      else
      {
         edtLocCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLocCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10LocCod) )
      {
         edtLocCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLocCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9ProvCod) )
      {
         A47ProvCod = AV9ProvCod ;
         n47ProvCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
      }
      else
      {
         A47ProvCod = AV26ComboProvCod ;
         n47ProvCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV30Insert_LocaZona)==0) )
      {
         A2207LocaZona = AV30Insert_LocaZona ;
         n2207LocaZona = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2207LocaZona", A2207LocaZona);
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
         /* Using cursor T000Y4 */
         pr_default.execute(2, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
         A312PaiNom = T000Y4_A312PaiNom[0] ;
         pr_default.close(2);
         AV31Pgmname = "Localidad" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31Pgmname", AV31Pgmname);
         /* Using cursor T000Y5 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
         A322ProvNom = T000Y5_A322ProvNom[0] ;
         pr_default.close(3);
      }
   }

   public void load0Y31( )
   {
      /* Using cursor T000Y7 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound31 = (short)(1) ;
         A312PaiNom = T000Y7_A312PaiNom[0] ;
         A322ProvNom = T000Y7_A322ProvNom[0] ;
         A286LocNom = T000Y7_A286LocNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A286LocNom", A286LocNom);
         A285LocCP = T000Y7_A285LocCP[0] ;
         A2207LocaZona = T000Y7_A2207LocaZona[0] ;
         n2207LocaZona = T000Y7_n2207LocaZona[0] ;
         zm0Y31( -18) ;
      }
      pr_default.close(5);
      onLoadActions0Y31( ) ;
   }

   public void onLoadActions0Y31( )
   {
      AV31Pgmname = "Localidad" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31Pgmname", AV31Pgmname);
   }

   public void checkExtendedTable0Y31( )
   {
      nIsDirty_31 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV31Pgmname = "Localidad" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31Pgmname", AV31Pgmname);
      /* Using cursor T000Y4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A312PaiNom = T000Y4_A312PaiNom[0] ;
      pr_default.close(2);
      if ( (0==A46PaiCod) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Cod. Pais", ""), "", "", "", "", "", "", "", ""), 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000Y5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PROVCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A322ProvNom = T000Y5_A322ProvNom[0] ;
      pr_default.close(3);
      if ( (0==A47ProvCod) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Cod. Prov.", ""), "", "", "", "", "", "", "", ""), 1, "PROVCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProvCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (0==A48LocCod) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Cod. Loc.", ""), "", "", "", "", "", "", "", ""), 1, "LOCCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLocCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A286LocNom)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Nom. Loc.", ""), "", "", "", "", "", "", "", ""), 1, "LOCNOM");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLocNom_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000Y6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n2207LocaZona), A2207LocaZona});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A2207LocaZona)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Localidad Zona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LOCAZONA");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void closeExtendedTableCursors0Y31( )
   {
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_19( short A46PaiCod )
   {
      /* Using cursor T000Y8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A312PaiNom = T000Y8_A312PaiNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A312PaiNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_20( short A46PaiCod ,
                          short A47ProvCod )
   {
      /* Using cursor T000Y9 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PROVCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A322ProvNom = T000Y9_A322ProvNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A322ProvNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_21( String A2207LocaZona )
   {
      /* Using cursor T000Y10 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n2207LocaZona), A2207LocaZona});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A2207LocaZona)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Localidad Zona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LOCAZONA");
            AnyError = (short)(1) ;
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void getKey0Y31( )
   {
      /* Using cursor T000Y11 */
      pr_default.execute(9, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound31 = (short)(1) ;
      }
      else
      {
         RcdFound31 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000Y3 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0Y31( 18) ;
         RcdFound31 = (short)(1) ;
         A48LocCod = T000Y3_A48LocCod[0] ;
         n48LocCod = T000Y3_n48LocCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
         A286LocNom = T000Y3_A286LocNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A286LocNom", A286LocNom);
         A285LocCP = T000Y3_A285LocCP[0] ;
         A46PaiCod = T000Y3_A46PaiCod[0] ;
         n46PaiCod = T000Y3_n46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A47ProvCod = T000Y3_A47ProvCod[0] ;
         n47ProvCod = T000Y3_n47ProvCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
         A2207LocaZona = T000Y3_A2207LocaZona[0] ;
         n2207LocaZona = T000Y3_n2207LocaZona[0] ;
         Z46PaiCod = A46PaiCod ;
         Z47ProvCod = A47ProvCod ;
         Z48LocCod = A48LocCod ;
         sMode31 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0Y31( ) ;
         if ( AnyError == 1 )
         {
            RcdFound31 = (short)(0) ;
            initializeNonKey0Y31( ) ;
         }
         Gx_mode = sMode31 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound31 = (short)(0) ;
         initializeNonKey0Y31( ) ;
         sMode31 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode31 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0Y31( ) ;
      if ( RcdFound31 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound31 = (short)(0) ;
      /* Using cursor T000Y12 */
      pr_default.execute(10, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T000Y12_A46PaiCod[0] < A46PaiCod ) || ( T000Y12_A46PaiCod[0] == A46PaiCod ) && ( T000Y12_A47ProvCod[0] < A47ProvCod ) || ( T000Y12_A47ProvCod[0] == A47ProvCod ) && ( T000Y12_A46PaiCod[0] == A46PaiCod ) && ( T000Y12_A48LocCod[0] < A48LocCod ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T000Y12_A46PaiCod[0] > A46PaiCod ) || ( T000Y12_A46PaiCod[0] == A46PaiCod ) && ( T000Y12_A47ProvCod[0] > A47ProvCod ) || ( T000Y12_A47ProvCod[0] == A47ProvCod ) && ( T000Y12_A46PaiCod[0] == A46PaiCod ) && ( T000Y12_A48LocCod[0] > A48LocCod ) ) )
         {
            A46PaiCod = T000Y12_A46PaiCod[0] ;
            n46PaiCod = T000Y12_n46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A47ProvCod = T000Y12_A47ProvCod[0] ;
            n47ProvCod = T000Y12_n47ProvCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
            A48LocCod = T000Y12_A48LocCod[0] ;
            n48LocCod = T000Y12_n48LocCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
            RcdFound31 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound31 = (short)(0) ;
      /* Using cursor T000Y13 */
      pr_default.execute(11, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T000Y13_A46PaiCod[0] > A46PaiCod ) || ( T000Y13_A46PaiCod[0] == A46PaiCod ) && ( T000Y13_A47ProvCod[0] > A47ProvCod ) || ( T000Y13_A47ProvCod[0] == A47ProvCod ) && ( T000Y13_A46PaiCod[0] == A46PaiCod ) && ( T000Y13_A48LocCod[0] > A48LocCod ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T000Y13_A46PaiCod[0] < A46PaiCod ) || ( T000Y13_A46PaiCod[0] == A46PaiCod ) && ( T000Y13_A47ProvCod[0] < A47ProvCod ) || ( T000Y13_A47ProvCod[0] == A47ProvCod ) && ( T000Y13_A46PaiCod[0] == A46PaiCod ) && ( T000Y13_A48LocCod[0] < A48LocCod ) ) )
         {
            A46PaiCod = T000Y13_A46PaiCod[0] ;
            n46PaiCod = T000Y13_n46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A47ProvCod = T000Y13_A47ProvCod[0] ;
            n47ProvCod = T000Y13_n47ProvCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
            A48LocCod = T000Y13_A48LocCod[0] ;
            n48LocCod = T000Y13_n48LocCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
            RcdFound31 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0Y31( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtProvCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0Y31( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound31 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( A47ProvCod != Z47ProvCod ) || ( A48LocCod != Z48LocCod ) )
            {
               A46PaiCod = Z46PaiCod ;
               n46PaiCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A47ProvCod = Z47ProvCod ;
               n47ProvCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
               A48LocCod = Z48LocCod ;
               n48LocCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtProvCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0Y31( ) ;
               GX_FocusControl = edtProvCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( A47ProvCod != Z47ProvCod ) || ( A48LocCod != Z48LocCod ) )
            {
               /* Insert record */
               GX_FocusControl = edtProvCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0Y31( ) ;
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
                  GX_FocusControl = edtProvCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0Y31( ) ;
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
      if ( ( A46PaiCod != Z46PaiCod ) || ( A47ProvCod != Z47ProvCod ) || ( A48LocCod != Z48LocCod ) )
      {
         A46PaiCod = Z46PaiCod ;
         n46PaiCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A47ProvCod = Z47ProvCod ;
         n47ProvCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
         A48LocCod = Z48LocCod ;
         n48LocCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtProvCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0Y31( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000Y2 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Localidad"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z286LocNom, T000Y2_A286LocNom[0]) != 0 ) || ( GXutil.strcmp(Z285LocCP, T000Y2_A285LocCP[0]) != 0 ) || ( GXutil.strcmp(Z2207LocaZona, T000Y2_A2207LocaZona[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z286LocNom, T000Y2_A286LocNom[0]) != 0 )
            {
               GXutil.writeLogln("localidad:[seudo value changed for attri]"+"LocNom");
               GXutil.writeLogRaw("Old: ",Z286LocNom);
               GXutil.writeLogRaw("Current: ",T000Y2_A286LocNom[0]);
            }
            if ( GXutil.strcmp(Z285LocCP, T000Y2_A285LocCP[0]) != 0 )
            {
               GXutil.writeLogln("localidad:[seudo value changed for attri]"+"LocCP");
               GXutil.writeLogRaw("Old: ",Z285LocCP);
               GXutil.writeLogRaw("Current: ",T000Y2_A285LocCP[0]);
            }
            if ( GXutil.strcmp(Z2207LocaZona, T000Y2_A2207LocaZona[0]) != 0 )
            {
               GXutil.writeLogln("localidad:[seudo value changed for attri]"+"LocaZona");
               GXutil.writeLogRaw("Old: ",Z2207LocaZona);
               GXutil.writeLogRaw("Current: ",T000Y2_A2207LocaZona[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Localidad"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0Y31( )
   {
      beforeValidate0Y31( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Y31( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0Y31( 0) ;
         checkOptimisticConcurrency0Y31( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Y31( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0Y31( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Y14 */
                  pr_default.execute(12, new Object[] {Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod), A286LocNom, A285LocCP, Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n2207LocaZona), A2207LocaZona});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Localidad");
                  if ( (pr_default.getStatus(12) == 1) )
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
                        resetCaption0Y0( ) ;
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
            load0Y31( ) ;
         }
         endLevel0Y31( ) ;
      }
      closeExtendedTableCursors0Y31( ) ;
   }

   public void update0Y31( )
   {
      beforeValidate0Y31( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Y31( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Y31( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Y31( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0Y31( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Y15 */
                  pr_default.execute(13, new Object[] {A286LocNom, A285LocCP, Boolean.valueOf(n2207LocaZona), A2207LocaZona, Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Localidad");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Localidad"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0Y31( ) ;
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
         endLevel0Y31( ) ;
      }
      closeExtendedTableCursors0Y31( ) ;
   }

   public void deferredUpdate0Y31( )
   {
   }

   public void delete( )
   {
      beforeValidate0Y31( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Y31( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0Y31( ) ;
         afterConfirm0Y31( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0Y31( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000Y16 */
               pr_default.execute(14, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Localidad");
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
      sMode31 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0Y31( ) ;
      Gx_mode = sMode31 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0Y31( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV31Pgmname = "Localidad" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31Pgmname", AV31Pgmname);
         /* Using cursor T000Y17 */
         pr_default.execute(15, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
         A312PaiNom = T000Y17_A312PaiNom[0] ;
         pr_default.close(15);
         /* Using cursor T000Y18 */
         pr_default.execute(16, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
         A322ProvNom = T000Y18_A322ProvNom[0] ;
         pr_default.close(16);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000Y19 */
         pr_default.execute(17, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
         /* Using cursor T000Y20 */
         pr_default.execute(18, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
         if ( (pr_default.getStatus(18) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
      }
   }

   public void endLevel0Y31( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0Y31( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "localidad");
         if ( AnyError == 0 )
         {
            confirmValues0Y0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "localidad");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0Y31( )
   {
      /* Scan By routine */
      /* Using cursor T000Y21 */
      pr_default.execute(19);
      RcdFound31 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound31 = (short)(1) ;
         A46PaiCod = T000Y21_A46PaiCod[0] ;
         n46PaiCod = T000Y21_n46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A47ProvCod = T000Y21_A47ProvCod[0] ;
         n47ProvCod = T000Y21_n47ProvCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
         A48LocCod = T000Y21_A48LocCod[0] ;
         n48LocCod = T000Y21_n48LocCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0Y31( )
   {
      /* Scan next routine */
      pr_default.readNext(19);
      RcdFound31 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound31 = (short)(1) ;
         A46PaiCod = T000Y21_A46PaiCod[0] ;
         n46PaiCod = T000Y21_n46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A47ProvCod = T000Y21_A47ProvCod[0] ;
         n47ProvCod = T000Y21_n47ProvCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
         A48LocCod = T000Y21_A48LocCod[0] ;
         n48LocCod = T000Y21_n48LocCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
      }
   }

   public void scanEnd0Y31( )
   {
      pr_default.close(19);
   }

   public void afterConfirm0Y31( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0Y31( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0Y31( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0Y31( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0Y31( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0Y31( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0Y31( )
   {
      edtProvCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvCod_Enabled), 5, 0), true);
      edtLocCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLocCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocCod_Enabled), 5, 0), true);
      edtLocNom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLocNom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocNom_Enabled), 5, 0), true);
      edtavComboprovcod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboprovcod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboprovcod_Enabled), 5, 0), true);
      edtPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0Y31( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0Y0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.localidad", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV8PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9ProvCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LocCod,4,0))}, new String[] {"Gx_mode","PaiCod","ProvCod","LocCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Localidad");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("LocCP", GXutil.rtrim( localUtil.format( A285LocCP, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("localidad:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z47ProvCod", GXutil.ltrim( localUtil.ntoc( Z47ProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z48LocCod", GXutil.ltrim( localUtil.ntoc( Z48LocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z286LocNom", Z286LocNom);
      web.GxWebStd.gx_hidden_field( httpContext, "Z285LocCP", GXutil.rtrim( Z285LocCP));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2207LocaZona", GXutil.rtrim( Z2207LocaZona));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N2207LocaZona", GXutil.rtrim( A2207LocaZona));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV17DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV17DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPROVCOD_DATA", AV25ProvCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPROVCOD_DATA", AV25ProvCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV8PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPROVCOD", GXutil.ltrim( localUtil.ntoc( AV9ProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROVCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9ProvCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLOCCOD", GXutil.ltrim( localUtil.ntoc( AV10LocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLOCCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LocCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_LOCAZONA", GXutil.rtrim( AV30Insert_LocaZona));
      web.GxWebStd.gx_hidden_field( httpContext, "LOCAZONA", GXutil.rtrim( A2207LocaZona));
      web.GxWebStd.gx_hidden_field( httpContext, "LOCCP", GXutil.rtrim( A285LocCP));
      web.GxWebStd.gx_hidden_field( httpContext, "PAINOM", A312PaiNom);
      web.GxWebStd.gx_hidden_field( httpContext, "PROVNOM", A322ProvNom);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV31Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Objectcall", GXutil.rtrim( Combo_provcod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Cls", GXutil.rtrim( Combo_provcod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Selectedvalue_set", GXutil.rtrim( Combo_provcod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Selectedtext_set", GXutil.rtrim( Combo_provcod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Enabled", GXutil.booltostr( Combo_provcod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Datalistproc", GXutil.rtrim( Combo_provcod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_provcod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Emptyitem", GXutil.booltostr( Combo_provcod_Emptyitem));
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
      return formatLink("web.localidad", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV8PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9ProvCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LocCod,4,0))}, new String[] {"Gx_mode","PaiCod","ProvCod","LocCod"})  ;
   }

   public String getPgmname( )
   {
      return "Localidad" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Localidad", "") ;
   }

   public void initializeNonKey0Y31( )
   {
      A2207LocaZona = "" ;
      n2207LocaZona = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2207LocaZona", A2207LocaZona);
      A312PaiNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A312PaiNom", A312PaiNom);
      A322ProvNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A322ProvNom", A322ProvNom);
      A286LocNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A286LocNom", A286LocNom);
      A285LocCP = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A285LocCP", A285LocCP);
      Z286LocNom = "" ;
      Z285LocCP = "" ;
      Z2207LocaZona = "" ;
   }

   public void initAll0Y31( )
   {
      A46PaiCod = (short)(0) ;
      n46PaiCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A47ProvCod = (short)(0) ;
      n47ProvCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
      A48LocCod = (short)(0) ;
      n48LocCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
      initializeNonKey0Y31( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171354313", true, true);
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
      httpContext.AddJavascriptSource("localidad.js", "?2025171354313", false, true);
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
      lblTextblockprovcod_Internalname = "TEXTBLOCKPROVCOD" ;
      Combo_provcod_Internalname = "COMBO_PROVCOD" ;
      edtProvCod_Internalname = "PROVCOD" ;
      divTablesplittedprovcod_Internalname = "TABLESPLITTEDPROVCOD" ;
      edtLocCod_Internalname = "LOCCOD" ;
      edtLocNom_Internalname = "LOCNOM" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboprovcod_Internalname = "vCOMBOPROVCOD" ;
      divSectionattribute_provcod_Internalname = "SECTIONATTRIBUTE_PROVCOD" ;
      edtPaiCod_Internalname = "PAICOD" ;
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
      Form.setCaption( httpContext.getMessage( "Localidad", "") );
      Combo_provcod_Datalistprocparametersprefix = "" ;
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 1 ;
      edtPaiCod_Visible = 1 ;
      edtavComboprovcod_Jsonclick = "" ;
      edtavComboprovcod_Enabled = 0 ;
      edtavComboprovcod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtLocNom_Jsonclick = "" ;
      edtLocNom_Enabled = 1 ;
      edtLocCod_Jsonclick = "" ;
      edtLocCod_Enabled = 1 ;
      edtProvCod_Jsonclick = "" ;
      edtProvCod_Enabled = 1 ;
      edtProvCod_Visible = 1 ;
      Combo_provcod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_provcod_Datalistproc = "LocalidadLoadDVCombo" ;
      Combo_provcod_Cls = "ExtendedCombo Attribute" ;
      Combo_provcod_Caption = "" ;
      Combo_provcod_Enabled = GXutil.toBoolean( -1) ;
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
      n46PaiCod = false ;
      n47ProvCod = false ;
      /* Using cursor T000Y17 */
      pr_default.execute(15, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
      }
      A312PaiNom = T000Y17_A312PaiNom[0] ;
      pr_default.close(15);
      /* Using cursor T000Y18 */
      pr_default.execute(16, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PROVCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
      }
      A322ProvNom = T000Y18_A322ProvNom[0] ;
      pr_default.close(16);
      if ( (0==A46PaiCod) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Cod. Pais", ""), "", "", "", "", "", "", "", ""), 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A312PaiNom", A312PaiNom);
      httpContext.ajax_rsp_assign_attri("", false, "A322ProvNom", A322ProvNom);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV9ProvCod',fld:'vPROVCOD',pic:'ZZZ9',hsh:true},{av:'AV10LocCod',fld:'vLOCCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV9ProvCod',fld:'vPROVCOD',pic:'ZZZ9',hsh:true},{av:'AV10LocCod',fld:'vLOCCOD',pic:'ZZZ9',hsh:true},{av:'A285LocCP',fld:'LOCCP',pic:'@!'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120Y2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_PROVCOD","{handler:'valid_Provcod',iparms:[]");
      setEventMetadata("VALID_PROVCOD",",oparms:[]}");
      setEventMetadata("VALID_LOCCOD","{handler:'valid_Loccod',iparms:[]");
      setEventMetadata("VALID_LOCCOD",",oparms:[]}");
      setEventMetadata("VALID_LOCNOM","{handler:'valid_Locnom',iparms:[]");
      setEventMetadata("VALID_LOCNOM",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOPROVCOD","{handler:'validv_Comboprovcod',iparms:[]");
      setEventMetadata("VALIDV_COMBOPROVCOD",",oparms:[]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A47ProvCod',fld:'PROVCOD',pic:'ZZZ9'},{av:'A312PaiNom',fld:'PAINOM',pic:'@!'},{av:'A322ProvNom',fld:'PROVNOM',pic:''}]");
      setEventMetadata("VALID_PAICOD",",oparms:[{av:'A312PaiNom',fld:'PAINOM',pic:'@!'},{av:'A322ProvNom',fld:'PROVNOM',pic:''}]}");
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
      return "localidad_Execute";
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
      pr_default.close(16);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z286LocNom = "" ;
      Z285LocCP = "" ;
      Z2207LocaZona = "" ;
      N2207LocaZona = "" ;
      Combo_provcod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A2207LocaZona = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockprovcod_Jsonclick = "" ;
      ucCombo_provcod = new com.genexus.webpanels.GXUserControl();
      AV17DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV25ProvCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A286LocNom = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A285LocCP = "" ;
      AV30Insert_LocaZona = "" ;
      A312PaiNom = "" ;
      A322ProvNom = "" ;
      AV31Pgmname = "" ;
      Combo_provcod_Objectcall = "" ;
      Combo_provcod_Class = "" ;
      Combo_provcod_Icontype = "" ;
      Combo_provcod_Icon = "" ;
      Combo_provcod_Tooltip = "" ;
      Combo_provcod_Selectedvalue_set = "" ;
      Combo_provcod_Selectedtext_set = "" ;
      Combo_provcod_Selectedtext_get = "" ;
      Combo_provcod_Gamoauthtoken = "" ;
      Combo_provcod_Ddointernalname = "" ;
      Combo_provcod_Titlecontrolalign = "" ;
      Combo_provcod_Dropdownoptionstype = "" ;
      Combo_provcod_Titlecontrolidtoreplace = "" ;
      Combo_provcod_Datalisttype = "" ;
      Combo_provcod_Datalistfixedvalues = "" ;
      Combo_provcod_Remoteservicesparameters = "" ;
      Combo_provcod_Htmltemplate = "" ;
      Combo_provcod_Multiplevaluestype = "" ;
      Combo_provcod_Loadingdata = "" ;
      Combo_provcod_Noresultsfound = "" ;
      Combo_provcod_Emptyitemtext = "" ;
      Combo_provcod_Onlyselectedvalues = "" ;
      Combo_provcod_Selectalltext = "" ;
      Combo_provcod_Multiplevaluesseparator = "" ;
      Combo_provcod_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode31 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      AV29TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV20Combo_DataJson = "" ;
      GXt_char6 = "" ;
      AV18ComboSelectedValue = "" ;
      GXv_char7 = new String[1] ;
      AV19ComboSelectedText = "" ;
      GXv_char8 = new String[1] ;
      GXv_char9 = new String[1] ;
      Z312PaiNom = "" ;
      Z322ProvNom = "" ;
      T000Y4_A312PaiNom = new String[] {""} ;
      T000Y5_A322ProvNom = new String[] {""} ;
      T000Y7_A48LocCod = new short[1] ;
      T000Y7_n48LocCod = new boolean[] {false} ;
      T000Y7_A312PaiNom = new String[] {""} ;
      T000Y7_A322ProvNom = new String[] {""} ;
      T000Y7_A286LocNom = new String[] {""} ;
      T000Y7_A285LocCP = new String[] {""} ;
      T000Y7_A46PaiCod = new short[1] ;
      T000Y7_n46PaiCod = new boolean[] {false} ;
      T000Y7_A47ProvCod = new short[1] ;
      T000Y7_n47ProvCod = new boolean[] {false} ;
      T000Y7_A2207LocaZona = new String[] {""} ;
      T000Y7_n2207LocaZona = new boolean[] {false} ;
      T000Y6_A2207LocaZona = new String[] {""} ;
      T000Y6_n2207LocaZona = new boolean[] {false} ;
      T000Y8_A312PaiNom = new String[] {""} ;
      T000Y9_A322ProvNom = new String[] {""} ;
      T000Y10_A2207LocaZona = new String[] {""} ;
      T000Y10_n2207LocaZona = new boolean[] {false} ;
      T000Y11_A46PaiCod = new short[1] ;
      T000Y11_n46PaiCod = new boolean[] {false} ;
      T000Y11_A47ProvCod = new short[1] ;
      T000Y11_n47ProvCod = new boolean[] {false} ;
      T000Y11_A48LocCod = new short[1] ;
      T000Y11_n48LocCod = new boolean[] {false} ;
      T000Y3_A48LocCod = new short[1] ;
      T000Y3_n48LocCod = new boolean[] {false} ;
      T000Y3_A286LocNom = new String[] {""} ;
      T000Y3_A285LocCP = new String[] {""} ;
      T000Y3_A46PaiCod = new short[1] ;
      T000Y3_n46PaiCod = new boolean[] {false} ;
      T000Y3_A47ProvCod = new short[1] ;
      T000Y3_n47ProvCod = new boolean[] {false} ;
      T000Y3_A2207LocaZona = new String[] {""} ;
      T000Y3_n2207LocaZona = new boolean[] {false} ;
      T000Y12_A46PaiCod = new short[1] ;
      T000Y12_n46PaiCod = new boolean[] {false} ;
      T000Y12_A47ProvCod = new short[1] ;
      T000Y12_n47ProvCod = new boolean[] {false} ;
      T000Y12_A48LocCod = new short[1] ;
      T000Y12_n48LocCod = new boolean[] {false} ;
      T000Y13_A46PaiCod = new short[1] ;
      T000Y13_n46PaiCod = new boolean[] {false} ;
      T000Y13_A47ProvCod = new short[1] ;
      T000Y13_n47ProvCod = new boolean[] {false} ;
      T000Y13_A48LocCod = new short[1] ;
      T000Y13_n48LocCod = new boolean[] {false} ;
      T000Y2_A48LocCod = new short[1] ;
      T000Y2_n48LocCod = new boolean[] {false} ;
      T000Y2_A286LocNom = new String[] {""} ;
      T000Y2_A285LocCP = new String[] {""} ;
      T000Y2_A46PaiCod = new short[1] ;
      T000Y2_n46PaiCod = new boolean[] {false} ;
      T000Y2_A47ProvCod = new short[1] ;
      T000Y2_n47ProvCod = new boolean[] {false} ;
      T000Y2_A2207LocaZona = new String[] {""} ;
      T000Y2_n2207LocaZona = new boolean[] {false} ;
      T000Y17_A312PaiNom = new String[] {""} ;
      T000Y18_A322ProvNom = new String[] {""} ;
      T000Y19_A3CliCod = new int[1] ;
      T000Y19_A1EmpCod = new short[1] ;
      T000Y20_A3CliCod = new int[1] ;
      T000Y20_A1EmpCod = new short[1] ;
      T000Y20_A6LegNumero = new int[1] ;
      T000Y21_A46PaiCod = new short[1] ;
      T000Y21_n46PaiCod = new boolean[] {false} ;
      T000Y21_A47ProvCod = new short[1] ;
      T000Y21_n47ProvCod = new boolean[] {false} ;
      T000Y21_A48LocCod = new short[1] ;
      T000Y21_n48LocCod = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.localidad__default(),
         new Object[] {
             new Object[] {
            T000Y2_A48LocCod, T000Y2_A286LocNom, T000Y2_A285LocCP, T000Y2_A46PaiCod, T000Y2_A47ProvCod, T000Y2_A2207LocaZona, T000Y2_n2207LocaZona
            }
            , new Object[] {
            T000Y3_A48LocCod, T000Y3_A286LocNom, T000Y3_A285LocCP, T000Y3_A46PaiCod, T000Y3_A47ProvCod, T000Y3_A2207LocaZona, T000Y3_n2207LocaZona
            }
            , new Object[] {
            T000Y4_A312PaiNom
            }
            , new Object[] {
            T000Y5_A322ProvNom
            }
            , new Object[] {
            T000Y6_A2207LocaZona
            }
            , new Object[] {
            T000Y7_A48LocCod, T000Y7_A312PaiNom, T000Y7_A322ProvNom, T000Y7_A286LocNom, T000Y7_A285LocCP, T000Y7_A46PaiCod, T000Y7_A47ProvCod, T000Y7_A2207LocaZona, T000Y7_n2207LocaZona
            }
            , new Object[] {
            T000Y8_A312PaiNom
            }
            , new Object[] {
            T000Y9_A322ProvNom
            }
            , new Object[] {
            T000Y10_A2207LocaZona
            }
            , new Object[] {
            T000Y11_A46PaiCod, T000Y11_A47ProvCod, T000Y11_A48LocCod
            }
            , new Object[] {
            T000Y12_A46PaiCod, T000Y12_A47ProvCod, T000Y12_A48LocCod
            }
            , new Object[] {
            T000Y13_A46PaiCod, T000Y13_A47ProvCod, T000Y13_A48LocCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000Y17_A312PaiNom
            }
            , new Object[] {
            T000Y18_A322ProvNom
            }
            , new Object[] {
            T000Y19_A3CliCod, T000Y19_A1EmpCod
            }
            , new Object[] {
            T000Y20_A3CliCod, T000Y20_A1EmpCod, T000Y20_A6LegNumero
            }
            , new Object[] {
            T000Y21_A46PaiCod, T000Y21_A47ProvCod, T000Y21_A48LocCod
            }
         }
      );
      AV31Pgmname = "Localidad" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8PaiCod ;
   private short wcpOAV9ProvCod ;
   private short wcpOAV10LocCod ;
   private short Z46PaiCod ;
   private short Z47ProvCod ;
   private short Z48LocCod ;
   private short A46PaiCod ;
   private short A47ProvCod ;
   private short AV8PaiCod ;
   private short AV9ProvCod ;
   private short AV10LocCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A48LocCod ;
   private short AV26ComboProvCod ;
   private short RcdFound31 ;
   private short nIsDirty_31 ;
   private int trnEnded ;
   private int edtProvCod_Visible ;
   private int edtProvCod_Enabled ;
   private int edtLocCod_Enabled ;
   private int edtLocNom_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboprovcod_Enabled ;
   private int edtavComboprovcod_Visible ;
   private int edtPaiCod_Visible ;
   private int edtPaiCod_Enabled ;
   private int Combo_provcod_Datalistupdateminimumcharacters ;
   private int Combo_provcod_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV32GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z285LocCP ;
   private String Z2207LocaZona ;
   private String N2207LocaZona ;
   private String Combo_provcod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A2207LocaZona ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
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
   private String divTablesplittedprovcod_Internalname ;
   private String lblTextblockprovcod_Internalname ;
   private String lblTextblockprovcod_Jsonclick ;
   private String Combo_provcod_Caption ;
   private String Combo_provcod_Cls ;
   private String Combo_provcod_Datalistproc ;
   private String Combo_provcod_Internalname ;
   private String TempTags ;
   private String edtProvCod_Jsonclick ;
   private String edtLocCod_Internalname ;
   private String edtLocCod_Jsonclick ;
   private String edtLocNom_Internalname ;
   private String edtLocNom_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_provcod_Internalname ;
   private String edtavComboprovcod_Internalname ;
   private String edtavComboprovcod_Jsonclick ;
   private String edtPaiCod_Internalname ;
   private String edtPaiCod_Jsonclick ;
   private String A285LocCP ;
   private String AV30Insert_LocaZona ;
   private String AV31Pgmname ;
   private String Combo_provcod_Objectcall ;
   private String Combo_provcod_Class ;
   private String Combo_provcod_Icontype ;
   private String Combo_provcod_Icon ;
   private String Combo_provcod_Tooltip ;
   private String Combo_provcod_Selectedvalue_set ;
   private String Combo_provcod_Selectedtext_set ;
   private String Combo_provcod_Selectedtext_get ;
   private String Combo_provcod_Gamoauthtoken ;
   private String Combo_provcod_Ddointernalname ;
   private String Combo_provcod_Titlecontrolalign ;
   private String Combo_provcod_Dropdownoptionstype ;
   private String Combo_provcod_Titlecontrolidtoreplace ;
   private String Combo_provcod_Datalisttype ;
   private String Combo_provcod_Datalistfixedvalues ;
   private String Combo_provcod_Datalistprocparametersprefix ;
   private String Combo_provcod_Remoteservicesparameters ;
   private String Combo_provcod_Htmltemplate ;
   private String Combo_provcod_Multiplevaluestype ;
   private String Combo_provcod_Loadingdata ;
   private String Combo_provcod_Noresultsfound ;
   private String Combo_provcod_Emptyitemtext ;
   private String Combo_provcod_Onlyselectedvalues ;
   private String Combo_provcod_Selectalltext ;
   private String Combo_provcod_Multiplevaluesseparator ;
   private String Combo_provcod_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode31 ;
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
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n46PaiCod ;
   private boolean n47ProvCod ;
   private boolean n2207LocaZona ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_provcod_Emptyitem ;
   private boolean Combo_provcod_Enabled ;
   private boolean Combo_provcod_Visible ;
   private boolean Combo_provcod_Allowmultipleselection ;
   private boolean Combo_provcod_Isgriditem ;
   private boolean Combo_provcod_Hasdescription ;
   private boolean Combo_provcod_Includeonlyselectedoption ;
   private boolean Combo_provcod_Includeselectalloption ;
   private boolean Combo_provcod_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n48LocCod ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String AV20Combo_DataJson ;
   private String Z286LocNom ;
   private String A286LocNom ;
   private String A312PaiNom ;
   private String A322ProvNom ;
   private String AV18ComboSelectedValue ;
   private String AV19ComboSelectedText ;
   private String Z312PaiNom ;
   private String Z322ProvNom ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_provcod ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T000Y4_A312PaiNom ;
   private String[] T000Y5_A322ProvNom ;
   private short[] T000Y7_A48LocCod ;
   private boolean[] T000Y7_n48LocCod ;
   private String[] T000Y7_A312PaiNom ;
   private String[] T000Y7_A322ProvNom ;
   private String[] T000Y7_A286LocNom ;
   private String[] T000Y7_A285LocCP ;
   private short[] T000Y7_A46PaiCod ;
   private boolean[] T000Y7_n46PaiCod ;
   private short[] T000Y7_A47ProvCod ;
   private boolean[] T000Y7_n47ProvCod ;
   private String[] T000Y7_A2207LocaZona ;
   private boolean[] T000Y7_n2207LocaZona ;
   private String[] T000Y6_A2207LocaZona ;
   private boolean[] T000Y6_n2207LocaZona ;
   private String[] T000Y8_A312PaiNom ;
   private String[] T000Y9_A322ProvNom ;
   private String[] T000Y10_A2207LocaZona ;
   private boolean[] T000Y10_n2207LocaZona ;
   private short[] T000Y11_A46PaiCod ;
   private boolean[] T000Y11_n46PaiCod ;
   private short[] T000Y11_A47ProvCod ;
   private boolean[] T000Y11_n47ProvCod ;
   private short[] T000Y11_A48LocCod ;
   private boolean[] T000Y11_n48LocCod ;
   private short[] T000Y3_A48LocCod ;
   private boolean[] T000Y3_n48LocCod ;
   private String[] T000Y3_A286LocNom ;
   private String[] T000Y3_A285LocCP ;
   private short[] T000Y3_A46PaiCod ;
   private boolean[] T000Y3_n46PaiCod ;
   private short[] T000Y3_A47ProvCod ;
   private boolean[] T000Y3_n47ProvCod ;
   private String[] T000Y3_A2207LocaZona ;
   private boolean[] T000Y3_n2207LocaZona ;
   private short[] T000Y12_A46PaiCod ;
   private boolean[] T000Y12_n46PaiCod ;
   private short[] T000Y12_A47ProvCod ;
   private boolean[] T000Y12_n47ProvCod ;
   private short[] T000Y12_A48LocCod ;
   private boolean[] T000Y12_n48LocCod ;
   private short[] T000Y13_A46PaiCod ;
   private boolean[] T000Y13_n46PaiCod ;
   private short[] T000Y13_A47ProvCod ;
   private boolean[] T000Y13_n47ProvCod ;
   private short[] T000Y13_A48LocCod ;
   private boolean[] T000Y13_n48LocCod ;
   private short[] T000Y2_A48LocCod ;
   private boolean[] T000Y2_n48LocCod ;
   private String[] T000Y2_A286LocNom ;
   private String[] T000Y2_A285LocCP ;
   private short[] T000Y2_A46PaiCod ;
   private boolean[] T000Y2_n46PaiCod ;
   private short[] T000Y2_A47ProvCod ;
   private boolean[] T000Y2_n47ProvCod ;
   private String[] T000Y2_A2207LocaZona ;
   private boolean[] T000Y2_n2207LocaZona ;
   private String[] T000Y17_A312PaiNom ;
   private String[] T000Y18_A322ProvNom ;
   private int[] T000Y19_A3CliCod ;
   private short[] T000Y19_A1EmpCod ;
   private int[] T000Y20_A3CliCod ;
   private short[] T000Y20_A1EmpCod ;
   private int[] T000Y20_A6LegNumero ;
   private short[] T000Y21_A46PaiCod ;
   private boolean[] T000Y21_n46PaiCod ;
   private short[] T000Y21_A47ProvCod ;
   private boolean[] T000Y21_n47ProvCod ;
   private short[] T000Y21_A48LocCod ;
   private boolean[] T000Y21_n48LocCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV25ProvCod_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV29TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class localidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000Y2", "SELECT LocCod, LocNom, LocCP, PaiCod, ProvCod, LocaZona FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ?  FOR UPDATE OF Localidad NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y3", "SELECT LocCod, LocNom, LocCP, PaiCod, ProvCod, LocaZona FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y4", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y5", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y6", "SELECT ZonCod AS LocaZona FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y7", "SELECT TM1.LocCod, T2.PaiNom, T3.ProvNom, TM1.LocNom, TM1.LocCP, TM1.PaiCod, TM1.ProvCod, TM1.LocaZona AS LocaZona FROM ((Localidad TM1 INNER JOIN Pais T2 ON T2.PaiCod = TM1.PaiCod) INNER JOIN Provincia T3 ON T3.PaiCod = TM1.PaiCod AND T3.ProvCod = TM1.ProvCod) WHERE TM1.PaiCod = ? and TM1.ProvCod = ? and TM1.LocCod = ? ORDER BY TM1.PaiCod, TM1.ProvCod, TM1.LocCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y8", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y9", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y10", "SELECT ZonCod AS LocaZona FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y11", "SELECT PaiCod, ProvCod, LocCod FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y12", "SELECT PaiCod, ProvCod, LocCod FROM Localidad WHERE ( PaiCod > ? or PaiCod = ? and ProvCod > ? or ProvCod = ? and PaiCod = ? and LocCod > ?) ORDER BY PaiCod, ProvCod, LocCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Y13", "SELECT PaiCod, ProvCod, LocCod FROM Localidad WHERE ( PaiCod < ? or PaiCod = ? and ProvCod < ? or ProvCod = ? and PaiCod = ? and LocCod < ?) ORDER BY PaiCod DESC, ProvCod DESC, LocCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000Y14", "SAVEPOINT gxupdate;INSERT INTO Localidad(LocCod, LocNom, LocCP, PaiCod, ProvCod, LocaZona) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000Y15", "SAVEPOINT gxupdate;UPDATE Localidad SET LocNom=?, LocCP=?, LocaZona=?  WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000Y16", "SAVEPOINT gxupdate;DELETE FROM Localidad  WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000Y17", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y18", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y19", "SELECT CliCod, EmpCod FROM Empresa WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Y20", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE LegPaiCod = ? AND LegProvCod = ? AND LegLocCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Y21", "SELECT PaiCod, ProvCod, LocCod FROM Localidad ORDER BY PaiCod, ProvCod, LocCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(4, ((Number) parms[7]).shortValue());
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(5, ((Number) parms[9]).shortValue());
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(6, ((Number) parms[11]).shortValue());
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(4, ((Number) parms[7]).shortValue());
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(5, ((Number) parms[9]).shortValue());
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(6, ((Number) parms[11]).shortValue());
               }
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               stmt.setVarchar(2, (String)parms[2], 40, false);
               stmt.setString(3, (String)parms[3], 20);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(4, ((Number) parms[5]).shortValue());
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(5, ((Number) parms[7]).shortValue());
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[9], 20);
               }
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setString(2, (String)parms[1], 20);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(4, ((Number) parms[5]).shortValue());
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(5, ((Number) parms[7]).shortValue());
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(6, ((Number) parms[9]).shortValue());
               }
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 17 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 18 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
      }
   }

}

