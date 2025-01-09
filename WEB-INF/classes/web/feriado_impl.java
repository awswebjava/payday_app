package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class feriado_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"FERIADOTIPO") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaferiadotipo3H140( A46PaiCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel4"+"_"+"PAICOD") == 0 )
      {
         AV7PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7PaiCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx4asapaicod3H140( AV7PaiCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_24") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1234FeriadoConvenio = httpContext.GetPar( "FeriadoConvenio") ;
         n1234FeriadoConvenio = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1234FeriadoConvenio", A1234FeriadoConvenio);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_24( A46PaiCod, A1234FeriadoConvenio) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_25") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1233FeriadoTipo = httpContext.GetPar( "FeriadoTipo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1233FeriadoTipo", A1233FeriadoTipo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_25( A46PaiCod, A1233FeriadoTipo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_26") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1230FerReligId = httpContext.GetPar( "FerReligId") ;
         n1230FerReligId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1230FerReligId", A1230FerReligId);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_26( A46PaiCod, A1230FerReligId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_27") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1232FerOrigId = httpContext.GetPar( "FerOrigId") ;
         n1232FerOrigId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1232FerOrigId", A1232FerOrigId);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_27( A46PaiCod, A1232FerOrigId) ;
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
            AV8FerId = httpContext.GetPar( "FerId") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8FerId", AV8FerId);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8FerId, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "feriado", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtFerId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public feriado_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public feriado_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( feriado_impl.class ));
   }

   public feriado_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynFeriadoTipo = new HTMLChoice();
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
      if ( dynFeriadoTipo.getItemCount() > 0 )
      {
         A1233FeriadoTipo = dynFeriadoTipo.getValidValue(A1233FeriadoTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1233FeriadoTipo", A1233FeriadoTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynFeriadoTipo.setValue( GXutil.rtrim( A1233FeriadoTipo) );
         httpContext.ajax_rsp_assign_prop("", false, dynFeriadoTipo.getInternalname(), "Values", dynFeriadoTipo.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFerId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtFerId_Internalname, httpContext.getMessage( "Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtFerId_Internalname, GXutil.rtrim( A1223FerId), GXutil.rtrim( localUtil.format( A1223FerId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFerId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtFerId_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_feriado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFerDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtFerDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtFerDescrip_Internalname, A1228FerDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtFerDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "Descrip", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_feriado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedferreligid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockferreligid_Internalname, httpContext.getMessage( "Religión", ""), "", "", lblTextblockferreligid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_feriado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_ferreligid.setProperty("Caption", Combo_ferreligid_Caption);
      ucCombo_ferreligid.setProperty("Cls", Combo_ferreligid_Cls);
      ucCombo_ferreligid.setProperty("DataListProc", Combo_ferreligid_Datalistproc);
      ucCombo_ferreligid.setProperty("DropDownOptionsTitleSettingsIcons", AV20DDO_TitleSettingsIcons);
      ucCombo_ferreligid.setProperty("DropDownOptionsData", AV25FerReligId_Data);
      ucCombo_ferreligid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_ferreligid_Internalname, "COMBO_FERRELIGIDContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtFerReligId_Internalname, httpContext.getMessage( "Religión", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtFerReligId_Internalname, GXutil.rtrim( A1230FerReligId), GXutil.rtrim( localUtil.format( A1230FerReligId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFerReligId_Jsonclick, 0, "Attribute", "", "", "", "", edtFerReligId_Visible, edtFerReligId_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_feriado.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedferorigid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockferorigid_Internalname, httpContext.getMessage( "Origen", ""), "", "", lblTextblockferorigid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_feriado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_ferorigid.setProperty("Caption", Combo_ferorigid_Caption);
      ucCombo_ferorigid.setProperty("Cls", Combo_ferorigid_Cls);
      ucCombo_ferorigid.setProperty("DataListProc", Combo_ferorigid_Datalistproc);
      ucCombo_ferorigid.setProperty("DropDownOptionsTitleSettingsIcons", AV20DDO_TitleSettingsIcons);
      ucCombo_ferorigid.setProperty("DropDownOptionsData", AV29FerOrigId_Data);
      ucCombo_ferorigid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_ferorigid_Internalname, "COMBO_FERORIGIDContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtFerOrigId_Internalname, httpContext.getMessage( "Origen", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtFerOrigId_Internalname, GXutil.rtrim( A1232FerOrigId), GXutil.rtrim( localUtil.format( A1232FerOrigId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFerOrigId_Jsonclick, 0, "Attribute", "", "", "", "", edtFerOrigId_Visible, edtFerOrigId_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_feriado.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynFeriadoTipo.getInternalname()+"\"", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynFeriadoTipo, dynFeriadoTipo.getInternalname(), GXutil.rtrim( A1233FeriadoTipo), 1, dynFeriadoTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynFeriadoTipo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "", true, (byte)(0), "HLP_feriado.htm");
      dynFeriadoTipo.setValue( GXutil.rtrim( A1233FeriadoTipo) );
      httpContext.ajax_rsp_assign_prop("", false, dynFeriadoTipo.getInternalname(), "Values", dynFeriadoTipo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedferiadoconvenio_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockferiadoconvenio_Internalname, httpContext.getMessage( "Convenio", ""), "", "", lblTextblockferiadoconvenio_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_feriado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_feriadoconvenio.setProperty("Caption", Combo_feriadoconvenio_Caption);
      ucCombo_feriadoconvenio.setProperty("Cls", Combo_feriadoconvenio_Cls);
      ucCombo_feriadoconvenio.setProperty("DataListProc", Combo_feriadoconvenio_Datalistproc);
      ucCombo_feriadoconvenio.setProperty("DropDownOptionsTitleSettingsIcons", AV20DDO_TitleSettingsIcons);
      ucCombo_feriadoconvenio.setProperty("DropDownOptionsData", AV35FeriadoConvenio_Data);
      ucCombo_feriadoconvenio.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_feriadoconvenio_Internalname, "COMBO_FERIADOCONVENIOContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtFeriadoConvenio_Internalname, httpContext.getMessage( "Convenio", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtFeriadoConvenio_Internalname, GXutil.rtrim( A1234FeriadoConvenio), GXutil.rtrim( localUtil.format( A1234FeriadoConvenio, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,65);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFeriadoConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtFeriadoConvenio_Visible, edtFeriadoConvenio_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_feriado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_feriado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 75,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_feriado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_feriado.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_ferreligid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboferreligid_Internalname, GXutil.rtrim( AV26ComboFerReligId), GXutil.rtrim( localUtil.format( AV26ComboFerReligId, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboferreligid_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboferreligid_Visible, edtavComboferreligid_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_feriado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_ferorigid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboferorigid_Internalname, GXutil.rtrim( AV30ComboFerOrigId), GXutil.rtrim( localUtil.format( AV30ComboFerOrigId, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboferorigid_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboferorigid_Visible, edtavComboferorigid_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_feriado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_feriadoconvenio_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboferiadoconvenio_Internalname, GXutil.rtrim( AV36ComboFeriadoConvenio), GXutil.rtrim( localUtil.format( AV36ComboFeriadoConvenio, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboferiadoconvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboferiadoconvenio_Visible, edtavComboferiadoconvenio_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_feriado.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,87);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiCod_Visible, edtPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_feriado.htm");
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
      e113H2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV20DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFERRELIGID_DATA"), AV25FerReligId_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFERORIGID_DATA"), AV29FerOrigId_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFERIADOCONVENIO_DATA"), AV35FeriadoConvenio_Data);
            /* Read saved values. */
            Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1223FerId = httpContext.cgiGet( "Z1223FerId") ;
            Z1224FerDia = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1224FerDia"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1225FerMes = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1225FerMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1228FerDescrip = httpContext.cgiGet( "Z1228FerDescrip") ;
            Z1234FeriadoConvenio = httpContext.cgiGet( "Z1234FeriadoConvenio") ;
            n1234FeriadoConvenio = ((GXutil.strcmp("", A1234FeriadoConvenio)==0) ? true : false) ;
            Z1233FeriadoTipo = httpContext.cgiGet( "Z1233FeriadoTipo") ;
            Z1230FerReligId = httpContext.cgiGet( "Z1230FerReligId") ;
            n1230FerReligId = ((GXutil.strcmp("", A1230FerReligId)==0) ? true : false) ;
            Z1232FerOrigId = httpContext.cgiGet( "Z1232FerOrigId") ;
            n1232FerOrigId = ((GXutil.strcmp("", A1232FerOrigId)==0) ? true : false) ;
            A1224FerDia = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1224FerDia"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1225FerMes = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1225FerMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1230FerReligId = httpContext.cgiGet( "N1230FerReligId") ;
            n1230FerReligId = ((GXutil.strcmp("", A1230FerReligId)==0) ? true : false) ;
            N1232FerOrigId = httpContext.cgiGet( "N1232FerOrigId") ;
            n1232FerOrigId = ((GXutil.strcmp("", A1232FerOrigId)==0) ? true : false) ;
            N1233FeriadoTipo = httpContext.cgiGet( "N1233FeriadoTipo") ;
            N1234FeriadoConvenio = httpContext.cgiGet( "N1234FeriadoConvenio") ;
            n1234FeriadoConvenio = ((GXutil.strcmp("", A1234FeriadoConvenio)==0) ? true : false) ;
            AV7PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8FerId = httpContext.cgiGet( "vFERID") ;
            AV14Insert_FerReligId = httpContext.cgiGet( "vINSERT_FERRELIGID") ;
            AV15Insert_FerOrigId = httpContext.cgiGet( "vINSERT_FERORIGID") ;
            AV16Insert_FeriadoTipo = httpContext.cgiGet( "vINSERT_FERIADOTIPO") ;
            AV17Insert_FeriadoConvenio = httpContext.cgiGet( "vINSERT_FERIADOCONVENIO") ;
            A1224FerDia = (byte)(localUtil.ctol( httpContext.cgiGet( "FERDIA"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1225FerMes = (byte)(localUtil.ctol( httpContext.cgiGet( "FERMES"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV38Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_ferreligid_Objectcall = httpContext.cgiGet( "COMBO_FERRELIGID_Objectcall") ;
            Combo_ferreligid_Class = httpContext.cgiGet( "COMBO_FERRELIGID_Class") ;
            Combo_ferreligid_Icontype = httpContext.cgiGet( "COMBO_FERRELIGID_Icontype") ;
            Combo_ferreligid_Icon = httpContext.cgiGet( "COMBO_FERRELIGID_Icon") ;
            Combo_ferreligid_Caption = httpContext.cgiGet( "COMBO_FERRELIGID_Caption") ;
            Combo_ferreligid_Tooltip = httpContext.cgiGet( "COMBO_FERRELIGID_Tooltip") ;
            Combo_ferreligid_Cls = httpContext.cgiGet( "COMBO_FERRELIGID_Cls") ;
            Combo_ferreligid_Selectedvalue_set = httpContext.cgiGet( "COMBO_FERRELIGID_Selectedvalue_set") ;
            Combo_ferreligid_Selectedvalue_get = httpContext.cgiGet( "COMBO_FERRELIGID_Selectedvalue_get") ;
            Combo_ferreligid_Selectedtext_set = httpContext.cgiGet( "COMBO_FERRELIGID_Selectedtext_set") ;
            Combo_ferreligid_Selectedtext_get = httpContext.cgiGet( "COMBO_FERRELIGID_Selectedtext_get") ;
            Combo_ferreligid_Gamoauthtoken = httpContext.cgiGet( "COMBO_FERRELIGID_Gamoauthtoken") ;
            Combo_ferreligid_Ddointernalname = httpContext.cgiGet( "COMBO_FERRELIGID_Ddointernalname") ;
            Combo_ferreligid_Titlecontrolalign = httpContext.cgiGet( "COMBO_FERRELIGID_Titlecontrolalign") ;
            Combo_ferreligid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_FERRELIGID_Dropdownoptionstype") ;
            Combo_ferreligid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERRELIGID_Enabled")) ;
            Combo_ferreligid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERRELIGID_Visible")) ;
            Combo_ferreligid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_FERRELIGID_Titlecontrolidtoreplace") ;
            Combo_ferreligid_Datalisttype = httpContext.cgiGet( "COMBO_FERRELIGID_Datalisttype") ;
            Combo_ferreligid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERRELIGID_Allowmultipleselection")) ;
            Combo_ferreligid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_FERRELIGID_Datalistfixedvalues") ;
            Combo_ferreligid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERRELIGID_Isgriditem")) ;
            Combo_ferreligid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERRELIGID_Hasdescription")) ;
            Combo_ferreligid_Datalistproc = httpContext.cgiGet( "COMBO_FERRELIGID_Datalistproc") ;
            Combo_ferreligid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_FERRELIGID_Datalistprocparametersprefix") ;
            Combo_ferreligid_Remoteservicesparameters = httpContext.cgiGet( "COMBO_FERRELIGID_Remoteservicesparameters") ;
            Combo_ferreligid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_FERRELIGID_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_ferreligid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERRELIGID_Includeonlyselectedoption")) ;
            Combo_ferreligid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERRELIGID_Includeselectalloption")) ;
            Combo_ferreligid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERRELIGID_Emptyitem")) ;
            Combo_ferreligid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERRELIGID_Includeaddnewoption")) ;
            Combo_ferreligid_Htmltemplate = httpContext.cgiGet( "COMBO_FERRELIGID_Htmltemplate") ;
            Combo_ferreligid_Multiplevaluestype = httpContext.cgiGet( "COMBO_FERRELIGID_Multiplevaluestype") ;
            Combo_ferreligid_Loadingdata = httpContext.cgiGet( "COMBO_FERRELIGID_Loadingdata") ;
            Combo_ferreligid_Noresultsfound = httpContext.cgiGet( "COMBO_FERRELIGID_Noresultsfound") ;
            Combo_ferreligid_Emptyitemtext = httpContext.cgiGet( "COMBO_FERRELIGID_Emptyitemtext") ;
            Combo_ferreligid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_FERRELIGID_Onlyselectedvalues") ;
            Combo_ferreligid_Selectalltext = httpContext.cgiGet( "COMBO_FERRELIGID_Selectalltext") ;
            Combo_ferreligid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_FERRELIGID_Multiplevaluesseparator") ;
            Combo_ferreligid_Addnewoptiontext = httpContext.cgiGet( "COMBO_FERRELIGID_Addnewoptiontext") ;
            Combo_ferreligid_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_FERRELIGID_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_ferorigid_Objectcall = httpContext.cgiGet( "COMBO_FERORIGID_Objectcall") ;
            Combo_ferorigid_Class = httpContext.cgiGet( "COMBO_FERORIGID_Class") ;
            Combo_ferorigid_Icontype = httpContext.cgiGet( "COMBO_FERORIGID_Icontype") ;
            Combo_ferorigid_Icon = httpContext.cgiGet( "COMBO_FERORIGID_Icon") ;
            Combo_ferorigid_Caption = httpContext.cgiGet( "COMBO_FERORIGID_Caption") ;
            Combo_ferorigid_Tooltip = httpContext.cgiGet( "COMBO_FERORIGID_Tooltip") ;
            Combo_ferorigid_Cls = httpContext.cgiGet( "COMBO_FERORIGID_Cls") ;
            Combo_ferorigid_Selectedvalue_set = httpContext.cgiGet( "COMBO_FERORIGID_Selectedvalue_set") ;
            Combo_ferorigid_Selectedvalue_get = httpContext.cgiGet( "COMBO_FERORIGID_Selectedvalue_get") ;
            Combo_ferorigid_Selectedtext_set = httpContext.cgiGet( "COMBO_FERORIGID_Selectedtext_set") ;
            Combo_ferorigid_Selectedtext_get = httpContext.cgiGet( "COMBO_FERORIGID_Selectedtext_get") ;
            Combo_ferorigid_Gamoauthtoken = httpContext.cgiGet( "COMBO_FERORIGID_Gamoauthtoken") ;
            Combo_ferorigid_Ddointernalname = httpContext.cgiGet( "COMBO_FERORIGID_Ddointernalname") ;
            Combo_ferorigid_Titlecontrolalign = httpContext.cgiGet( "COMBO_FERORIGID_Titlecontrolalign") ;
            Combo_ferorigid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_FERORIGID_Dropdownoptionstype") ;
            Combo_ferorigid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERORIGID_Enabled")) ;
            Combo_ferorigid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERORIGID_Visible")) ;
            Combo_ferorigid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_FERORIGID_Titlecontrolidtoreplace") ;
            Combo_ferorigid_Datalisttype = httpContext.cgiGet( "COMBO_FERORIGID_Datalisttype") ;
            Combo_ferorigid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERORIGID_Allowmultipleselection")) ;
            Combo_ferorigid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_FERORIGID_Datalistfixedvalues") ;
            Combo_ferorigid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERORIGID_Isgriditem")) ;
            Combo_ferorigid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERORIGID_Hasdescription")) ;
            Combo_ferorigid_Datalistproc = httpContext.cgiGet( "COMBO_FERORIGID_Datalistproc") ;
            Combo_ferorigid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_FERORIGID_Datalistprocparametersprefix") ;
            Combo_ferorigid_Remoteservicesparameters = httpContext.cgiGet( "COMBO_FERORIGID_Remoteservicesparameters") ;
            Combo_ferorigid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_FERORIGID_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_ferorigid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERORIGID_Includeonlyselectedoption")) ;
            Combo_ferorigid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERORIGID_Includeselectalloption")) ;
            Combo_ferorigid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERORIGID_Emptyitem")) ;
            Combo_ferorigid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERORIGID_Includeaddnewoption")) ;
            Combo_ferorigid_Htmltemplate = httpContext.cgiGet( "COMBO_FERORIGID_Htmltemplate") ;
            Combo_ferorigid_Multiplevaluestype = httpContext.cgiGet( "COMBO_FERORIGID_Multiplevaluestype") ;
            Combo_ferorigid_Loadingdata = httpContext.cgiGet( "COMBO_FERORIGID_Loadingdata") ;
            Combo_ferorigid_Noresultsfound = httpContext.cgiGet( "COMBO_FERORIGID_Noresultsfound") ;
            Combo_ferorigid_Emptyitemtext = httpContext.cgiGet( "COMBO_FERORIGID_Emptyitemtext") ;
            Combo_ferorigid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_FERORIGID_Onlyselectedvalues") ;
            Combo_ferorigid_Selectalltext = httpContext.cgiGet( "COMBO_FERORIGID_Selectalltext") ;
            Combo_ferorigid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_FERORIGID_Multiplevaluesseparator") ;
            Combo_ferorigid_Addnewoptiontext = httpContext.cgiGet( "COMBO_FERORIGID_Addnewoptiontext") ;
            Combo_ferorigid_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_FERORIGID_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_feriadoconvenio_Objectcall = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Objectcall") ;
            Combo_feriadoconvenio_Class = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Class") ;
            Combo_feriadoconvenio_Icontype = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Icontype") ;
            Combo_feriadoconvenio_Icon = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Icon") ;
            Combo_feriadoconvenio_Caption = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Caption") ;
            Combo_feriadoconvenio_Tooltip = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Tooltip") ;
            Combo_feriadoconvenio_Cls = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Cls") ;
            Combo_feriadoconvenio_Selectedvalue_set = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Selectedvalue_set") ;
            Combo_feriadoconvenio_Selectedvalue_get = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Selectedvalue_get") ;
            Combo_feriadoconvenio_Selectedtext_set = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Selectedtext_set") ;
            Combo_feriadoconvenio_Selectedtext_get = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Selectedtext_get") ;
            Combo_feriadoconvenio_Gamoauthtoken = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Gamoauthtoken") ;
            Combo_feriadoconvenio_Ddointernalname = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Ddointernalname") ;
            Combo_feriadoconvenio_Titlecontrolalign = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Titlecontrolalign") ;
            Combo_feriadoconvenio_Dropdownoptionstype = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Dropdownoptionstype") ;
            Combo_feriadoconvenio_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Enabled")) ;
            Combo_feriadoconvenio_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Visible")) ;
            Combo_feriadoconvenio_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Titlecontrolidtoreplace") ;
            Combo_feriadoconvenio_Datalisttype = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Datalisttype") ;
            Combo_feriadoconvenio_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Allowmultipleselection")) ;
            Combo_feriadoconvenio_Datalistfixedvalues = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Datalistfixedvalues") ;
            Combo_feriadoconvenio_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Isgriditem")) ;
            Combo_feriadoconvenio_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Hasdescription")) ;
            Combo_feriadoconvenio_Datalistproc = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Datalistproc") ;
            Combo_feriadoconvenio_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Datalistprocparametersprefix") ;
            Combo_feriadoconvenio_Remoteservicesparameters = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Remoteservicesparameters") ;
            Combo_feriadoconvenio_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_feriadoconvenio_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Includeonlyselectedoption")) ;
            Combo_feriadoconvenio_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Includeselectalloption")) ;
            Combo_feriadoconvenio_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Emptyitem")) ;
            Combo_feriadoconvenio_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Includeaddnewoption")) ;
            Combo_feriadoconvenio_Htmltemplate = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Htmltemplate") ;
            Combo_feriadoconvenio_Multiplevaluestype = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Multiplevaluestype") ;
            Combo_feriadoconvenio_Loadingdata = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Loadingdata") ;
            Combo_feriadoconvenio_Noresultsfound = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Noresultsfound") ;
            Combo_feriadoconvenio_Emptyitemtext = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Emptyitemtext") ;
            Combo_feriadoconvenio_Onlyselectedvalues = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Onlyselectedvalues") ;
            Combo_feriadoconvenio_Selectalltext = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Selectalltext") ;
            Combo_feriadoconvenio_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Multiplevaluesseparator") ;
            Combo_feriadoconvenio_Addnewoptiontext = httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Addnewoptiontext") ;
            Combo_feriadoconvenio_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_FERIADOCONVENIO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A1223FerId = httpContext.cgiGet( edtFerId_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
            A1228FerDescrip = httpContext.cgiGet( edtFerDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1228FerDescrip", A1228FerDescrip);
            A1230FerReligId = httpContext.cgiGet( edtFerReligId_Internalname) ;
            n1230FerReligId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1230FerReligId", A1230FerReligId);
            n1230FerReligId = ((GXutil.strcmp("", A1230FerReligId)==0) ? true : false) ;
            A1232FerOrigId = httpContext.cgiGet( edtFerOrigId_Internalname) ;
            n1232FerOrigId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1232FerOrigId", A1232FerOrigId);
            n1232FerOrigId = ((GXutil.strcmp("", A1232FerOrigId)==0) ? true : false) ;
            dynFeriadoTipo.setValue( httpContext.cgiGet( dynFeriadoTipo.getInternalname()) );
            A1233FeriadoTipo = httpContext.cgiGet( dynFeriadoTipo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1233FeriadoTipo", A1233FeriadoTipo);
            A1234FeriadoConvenio = httpContext.cgiGet( edtFeriadoConvenio_Internalname) ;
            n1234FeriadoConvenio = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1234FeriadoConvenio", A1234FeriadoConvenio);
            n1234FeriadoConvenio = ((GXutil.strcmp("", A1234FeriadoConvenio)==0) ? true : false) ;
            AV26ComboFerReligId = httpContext.cgiGet( edtavComboferreligid_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ComboFerReligId", AV26ComboFerReligId);
            AV30ComboFerOrigId = httpContext.cgiGet( edtavComboferorigid_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30ComboFerOrigId", AV30ComboFerOrigId);
            AV36ComboFeriadoConvenio = httpContext.cgiGet( edtavComboferiadoconvenio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36ComboFeriadoConvenio", AV36ComboFeriadoConvenio);
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
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"feriado");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("FerDia", localUtil.format( DecimalUtil.doubleToDec(A1224FerDia), "Z9"));
            forbiddenHiddens.add("FerMes", localUtil.format( DecimalUtil.doubleToDec(A1225FerMes), "Z9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A1223FerId, Z1223FerId) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("feriado:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1223FerId = httpContext.GetPar( "FerId") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
               getEqualNoModal( ) ;
               if ( ! (0==AV7PaiCod) )
               {
                  A46PaiCod = AV7PaiCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               }
               else
               {
                  if ( isIns( )  )
                  {
                     GXt_int1 = A46PaiCod ;
                     GXt_int2 = A46PaiCod ;
                     GXv_int3[0] = GXt_int2 ;
                     new web.getclicod(remoteHandle, context).execute( GXv_int3) ;
                     feriado_impl.this.GXt_int2 = GXv_int3[0] ;
                     GXv_int4[0] = GXt_int1 ;
                     new web.clientegetpais(remoteHandle, context).execute( GXt_int2, GXv_int4) ;
                     feriado_impl.this.GXt_int1 = GXv_int4[0] ;
                     A46PaiCod = GXt_int1 ;
                     httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
                  }
               }
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode140 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  if ( ! (0==AV7PaiCod) )
                  {
                     A46PaiCod = AV7PaiCod ;
                     httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
                  }
                  else
                  {
                     if ( isIns( )  )
                     {
                        GXt_int1 = A46PaiCod ;
                        GXt_int2 = A46PaiCod ;
                        GXv_int3[0] = GXt_int2 ;
                        new web.getclicod(remoteHandle, context).execute( GXv_int3) ;
                        feriado_impl.this.GXt_int2 = GXv_int3[0] ;
                        GXv_int4[0] = GXt_int1 ;
                        new web.clientegetpais(remoteHandle, context).execute( GXt_int2, GXv_int4) ;
                        feriado_impl.this.GXt_int1 = GXv_int4[0] ;
                        A46PaiCod = GXt_int1 ;
                        httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
                     }
                  }
                  Gx_mode = sMode140 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound140 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_3H0( ) ;
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
                        e113H2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e123H2 ();
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
         e123H2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll3H140( ) ;
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
         disableAttributes3H140( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboferreligid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboferreligid_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboferorigid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboferorigid_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboferiadoconvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboferiadoconvenio_Enabled), 5, 0), true);
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

   public void confirm_3H0( )
   {
      beforeValidate3H140( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls3H140( ) ;
         }
         else
         {
            checkExtendedTable3H140( ) ;
            closeExtendedTableCursors3H140( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption3H0( )
   {
   }

   public void e113H2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext5[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV9WWPContext = GXv_SdtWWPContext5[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = AV20DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7[0] ;
      AV20DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6;
      edtFeriadoConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFeriadoConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFeriadoConvenio_Visible), 5, 0), true);
      AV36ComboFeriadoConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36ComboFeriadoConvenio", AV36ComboFeriadoConvenio);
      edtavComboferiadoconvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboferiadoconvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboferiadoconvenio_Visible), 5, 0), true);
      edtFerOrigId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFerOrigId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerOrigId_Visible), 5, 0), true);
      AV30ComboFerOrigId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30ComboFerOrigId", AV30ComboFerOrigId);
      edtavComboferorigid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboferorigid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboferorigid_Visible), 5, 0), true);
      edtFerReligId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFerReligId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerReligId_Visible), 5, 0), true);
      AV26ComboFerReligId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ComboFerReligId", AV26ComboFerReligId);
      edtavComboferreligid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboferreligid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboferreligid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOFERRELIGID' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOFERORIGID' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOFERIADOCONVENIO' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV10IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXt_boolean8 = AV10IsAuthorized ;
         GXv_boolean9[0] = GXt_boolean8 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWferiado_Insert", GXv_boolean9) ;
         feriado_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
         AV10IsAuthorized = GXt_boolean8 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXt_boolean8 = AV10IsAuthorized ;
         GXv_boolean9[0] = GXt_boolean8 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWferiado_Update", GXv_boolean9) ;
         feriado_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
         AV10IsAuthorized = GXt_boolean8 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean8 = AV10IsAuthorized ;
         GXv_boolean9[0] = GXt_boolean8 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWferiado_Delete", GXv_boolean9) ;
         feriado_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
         AV10IsAuthorized = GXt_boolean8 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV38Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV12TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV38Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV39GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39GXV1), 8, 0));
         while ( AV39GXV1 <= AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV18TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV39GXV1));
            if ( GXutil.strcmp(AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "FerReligId") == 0 )
            {
               AV14Insert_FerReligId = AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_FerReligId", AV14Insert_FerReligId);
               if ( ! (GXutil.strcmp("", AV14Insert_FerReligId)==0) )
               {
                  AV26ComboFerReligId = AV14Insert_FerReligId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV26ComboFerReligId", AV26ComboFerReligId);
                  Combo_ferreligid_Selectedvalue_set = AV26ComboFerReligId ;
                  ucCombo_ferreligid.sendProperty(context, "", false, Combo_ferreligid_Internalname, "SelectedValue_set", Combo_ferreligid_Selectedvalue_set);
                  GXt_char10 = AV23Combo_DataJson ;
                  GXv_char11[0] = AV21ComboSelectedValue ;
                  GXv_char12[0] = AV22ComboSelectedText ;
                  GXv_char13[0] = GXt_char10 ;
                  new web.feriadoloaddvcombo(remoteHandle, context).execute( "FerReligId", "GET", false, AV7PaiCod, AV8FerId, (short)(DecimalUtil.decToDouble(AV40Insert_paicod)), AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char11, GXv_char12, GXv_char13) ;
                  feriado_impl.this.AV21ComboSelectedValue = GXv_char11[0] ;
                  feriado_impl.this.AV22ComboSelectedText = GXv_char12[0] ;
                  feriado_impl.this.GXt_char10 = GXv_char13[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSelectedValue", AV21ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedText", AV22ComboSelectedText);
                  AV23Combo_DataJson = GXt_char10 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23Combo_DataJson", AV23Combo_DataJson);
                  Combo_ferreligid_Selectedtext_set = AV22ComboSelectedText ;
                  ucCombo_ferreligid.sendProperty(context, "", false, Combo_ferreligid_Internalname, "SelectedText_set", Combo_ferreligid_Selectedtext_set);
                  Combo_ferreligid_Enabled = false ;
                  ucCombo_ferreligid.sendProperty(context, "", false, Combo_ferreligid_Internalname, "Enabled", GXutil.booltostr( Combo_ferreligid_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "FerOrigId") == 0 )
            {
               AV15Insert_FerOrigId = AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15Insert_FerOrigId", AV15Insert_FerOrigId);
               if ( ! (GXutil.strcmp("", AV15Insert_FerOrigId)==0) )
               {
                  AV30ComboFerOrigId = AV15Insert_FerOrigId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV30ComboFerOrigId", AV30ComboFerOrigId);
                  Combo_ferorigid_Selectedvalue_set = AV30ComboFerOrigId ;
                  ucCombo_ferorigid.sendProperty(context, "", false, Combo_ferorigid_Internalname, "SelectedValue_set", Combo_ferorigid_Selectedvalue_set);
                  GXt_char10 = AV23Combo_DataJson ;
                  GXv_char13[0] = AV21ComboSelectedValue ;
                  GXv_char12[0] = AV22ComboSelectedText ;
                  GXv_char11[0] = GXt_char10 ;
                  new web.feriadoloaddvcombo(remoteHandle, context).execute( "FerOrigId", "GET", false, AV7PaiCod, AV8FerId, (short)(DecimalUtil.decToDouble(AV40Insert_paicod)), AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char13, GXv_char12, GXv_char11) ;
                  feriado_impl.this.AV21ComboSelectedValue = GXv_char13[0] ;
                  feriado_impl.this.AV22ComboSelectedText = GXv_char12[0] ;
                  feriado_impl.this.GXt_char10 = GXv_char11[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSelectedValue", AV21ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedText", AV22ComboSelectedText);
                  AV23Combo_DataJson = GXt_char10 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23Combo_DataJson", AV23Combo_DataJson);
                  Combo_ferorigid_Selectedtext_set = AV22ComboSelectedText ;
                  ucCombo_ferorigid.sendProperty(context, "", false, Combo_ferorigid_Internalname, "SelectedText_set", Combo_ferorigid_Selectedtext_set);
                  Combo_ferorigid_Enabled = false ;
                  ucCombo_ferorigid.sendProperty(context, "", false, Combo_ferorigid_Internalname, "Enabled", GXutil.booltostr( Combo_ferorigid_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "FeriadoTipo") == 0 )
            {
               AV16Insert_FeriadoTipo = AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_FeriadoTipo", AV16Insert_FeriadoTipo);
            }
            else if ( GXutil.strcmp(AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "FeriadoConvenio") == 0 )
            {
               AV17Insert_FeriadoConvenio = AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV17Insert_FeriadoConvenio", AV17Insert_FeriadoConvenio);
               if ( ! (GXutil.strcmp("", AV17Insert_FeriadoConvenio)==0) )
               {
                  AV36ComboFeriadoConvenio = AV17Insert_FeriadoConvenio ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV36ComboFeriadoConvenio", AV36ComboFeriadoConvenio);
                  Combo_feriadoconvenio_Selectedvalue_set = AV36ComboFeriadoConvenio ;
                  ucCombo_feriadoconvenio.sendProperty(context, "", false, Combo_feriadoconvenio_Internalname, "SelectedValue_set", Combo_feriadoconvenio_Selectedvalue_set);
                  GXt_char10 = AV23Combo_DataJson ;
                  GXv_char13[0] = AV21ComboSelectedValue ;
                  GXv_char12[0] = AV22ComboSelectedText ;
                  GXv_char11[0] = GXt_char10 ;
                  new web.feriadoloaddvcombo(remoteHandle, context).execute( "FeriadoConvenio", "GET", false, AV7PaiCod, AV8FerId, (short)(DecimalUtil.decToDouble(AV40Insert_paicod)), AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char13, GXv_char12, GXv_char11) ;
                  feriado_impl.this.AV21ComboSelectedValue = GXv_char13[0] ;
                  feriado_impl.this.AV22ComboSelectedText = GXv_char12[0] ;
                  feriado_impl.this.GXt_char10 = GXv_char11[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSelectedValue", AV21ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedText", AV22ComboSelectedText);
                  AV23Combo_DataJson = GXt_char10 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23Combo_DataJson", AV23Combo_DataJson);
                  Combo_feriadoconvenio_Selectedtext_set = AV22ComboSelectedText ;
                  ucCombo_feriadoconvenio.sendProperty(context, "", false, Combo_feriadoconvenio_Internalname, "SelectedText_set", Combo_feriadoconvenio_Selectedtext_set);
                  Combo_feriadoconvenio_Enabled = false ;
                  ucCombo_feriadoconvenio.sendProperty(context, "", false, Combo_feriadoconvenio_Internalname, "Enabled", GXutil.booltostr( Combo_feriadoconvenio_Enabled));
               }
            }
            AV39GXV1 = (int)(AV39GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39GXV1), 8, 0));
         }
      }
      edtPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Visible), 5, 0), true);
   }

   public void e123H2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S132( )
   {
      /* 'LOADCOMBOFERIADOCONVENIO' Routine */
      returnInSub = false ;
      Combo_feriadoconvenio_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"FeriadoConvenio\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PaiCod\": 0, \"FerId\": \"\", \"Cond_PaiCod\": \"#%1#\"", edtPaiCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_feriadoconvenio.sendProperty(context, "", false, Combo_feriadoconvenio_Internalname, "DataListProcParametersPrefix", Combo_feriadoconvenio_Datalistprocparametersprefix);
      GXt_char10 = AV23Combo_DataJson ;
      GXv_char13[0] = AV21ComboSelectedValue ;
      GXv_char12[0] = AV22ComboSelectedText ;
      GXv_char11[0] = GXt_char10 ;
      new web.feriadoloaddvcombo(remoteHandle, context).execute( "FeriadoConvenio", Gx_mode, false, AV7PaiCod, AV8FerId, A46PaiCod, "", GXv_char13, GXv_char12, GXv_char11) ;
      feriado_impl.this.AV21ComboSelectedValue = GXv_char13[0] ;
      feriado_impl.this.AV22ComboSelectedText = GXv_char12[0] ;
      feriado_impl.this.GXt_char10 = GXv_char11[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSelectedValue", AV21ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedText", AV22ComboSelectedText);
      AV23Combo_DataJson = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23Combo_DataJson", AV23Combo_DataJson);
      Combo_feriadoconvenio_Selectedvalue_set = AV21ComboSelectedValue ;
      ucCombo_feriadoconvenio.sendProperty(context, "", false, Combo_feriadoconvenio_Internalname, "SelectedValue_set", Combo_feriadoconvenio_Selectedvalue_set);
      Combo_feriadoconvenio_Selectedtext_set = AV22ComboSelectedText ;
      ucCombo_feriadoconvenio.sendProperty(context, "", false, Combo_feriadoconvenio_Internalname, "SelectedText_set", Combo_feriadoconvenio_Selectedtext_set);
      AV36ComboFeriadoConvenio = AV21ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36ComboFeriadoConvenio", AV36ComboFeriadoConvenio);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_feriadoconvenio_Enabled = false ;
         ucCombo_feriadoconvenio.sendProperty(context, "", false, Combo_feriadoconvenio_Internalname, "Enabled", GXutil.booltostr( Combo_feriadoconvenio_Enabled));
      }
   }

   public void S122( )
   {
      /* 'LOADCOMBOFERORIGID' Routine */
      returnInSub = false ;
      Combo_ferorigid_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"FerOrigId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PaiCod\": 0, \"FerId\": \"\", \"Cond_PaiCod\": \"#%1#\"", edtPaiCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_ferorigid.sendProperty(context, "", false, Combo_ferorigid_Internalname, "DataListProcParametersPrefix", Combo_ferorigid_Datalistprocparametersprefix);
      GXt_char10 = AV23Combo_DataJson ;
      GXv_char13[0] = AV21ComboSelectedValue ;
      GXv_char12[0] = AV22ComboSelectedText ;
      GXv_char11[0] = GXt_char10 ;
      new web.feriadoloaddvcombo(remoteHandle, context).execute( "FerOrigId", Gx_mode, false, AV7PaiCod, AV8FerId, A46PaiCod, "", GXv_char13, GXv_char12, GXv_char11) ;
      feriado_impl.this.AV21ComboSelectedValue = GXv_char13[0] ;
      feriado_impl.this.AV22ComboSelectedText = GXv_char12[0] ;
      feriado_impl.this.GXt_char10 = GXv_char11[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSelectedValue", AV21ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedText", AV22ComboSelectedText);
      AV23Combo_DataJson = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23Combo_DataJson", AV23Combo_DataJson);
      Combo_ferorigid_Selectedvalue_set = AV21ComboSelectedValue ;
      ucCombo_ferorigid.sendProperty(context, "", false, Combo_ferorigid_Internalname, "SelectedValue_set", Combo_ferorigid_Selectedvalue_set);
      Combo_ferorigid_Selectedtext_set = AV22ComboSelectedText ;
      ucCombo_ferorigid.sendProperty(context, "", false, Combo_ferorigid_Internalname, "SelectedText_set", Combo_ferorigid_Selectedtext_set);
      AV30ComboFerOrigId = AV21ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30ComboFerOrigId", AV30ComboFerOrigId);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_ferorigid_Enabled = false ;
         ucCombo_ferorigid.sendProperty(context, "", false, Combo_ferorigid_Internalname, "Enabled", GXutil.booltostr( Combo_ferorigid_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOFERRELIGID' Routine */
      returnInSub = false ;
      Combo_ferreligid_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"FerReligId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PaiCod\": 0, \"FerId\": \"\", \"Cond_PaiCod\": \"#%1#\"", edtPaiCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_ferreligid.sendProperty(context, "", false, Combo_ferreligid_Internalname, "DataListProcParametersPrefix", Combo_ferreligid_Datalistprocparametersprefix);
      GXt_char10 = AV23Combo_DataJson ;
      GXv_char13[0] = AV21ComboSelectedValue ;
      GXv_char12[0] = AV22ComboSelectedText ;
      GXv_char11[0] = GXt_char10 ;
      new web.feriadoloaddvcombo(remoteHandle, context).execute( "FerReligId", Gx_mode, false, AV7PaiCod, AV8FerId, A46PaiCod, "", GXv_char13, GXv_char12, GXv_char11) ;
      feriado_impl.this.AV21ComboSelectedValue = GXv_char13[0] ;
      feriado_impl.this.AV22ComboSelectedText = GXv_char12[0] ;
      feriado_impl.this.GXt_char10 = GXv_char11[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSelectedValue", AV21ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedText", AV22ComboSelectedText);
      AV23Combo_DataJson = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23Combo_DataJson", AV23Combo_DataJson);
      Combo_ferreligid_Selectedvalue_set = AV21ComboSelectedValue ;
      ucCombo_ferreligid.sendProperty(context, "", false, Combo_ferreligid_Internalname, "SelectedValue_set", Combo_ferreligid_Selectedvalue_set);
      Combo_ferreligid_Selectedtext_set = AV22ComboSelectedText ;
      ucCombo_ferreligid.sendProperty(context, "", false, Combo_ferreligid_Internalname, "SelectedText_set", Combo_ferreligid_Selectedtext_set);
      AV26ComboFerReligId = AV21ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ComboFerReligId", AV26ComboFerReligId);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_ferreligid_Enabled = false ;
         ucCombo_ferreligid.sendProperty(context, "", false, Combo_ferreligid_Internalname, "Enabled", GXutil.booltostr( Combo_ferreligid_Enabled));
      }
   }

   public void zm3H140( int GX_JID )
   {
      if ( ( GX_JID == 23 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1224FerDia = T003H3_A1224FerDia[0] ;
            Z1225FerMes = T003H3_A1225FerMes[0] ;
            Z1228FerDescrip = T003H3_A1228FerDescrip[0] ;
            Z1234FeriadoConvenio = T003H3_A1234FeriadoConvenio[0] ;
            Z1233FeriadoTipo = T003H3_A1233FeriadoTipo[0] ;
            Z1230FerReligId = T003H3_A1230FerReligId[0] ;
            Z1232FerOrigId = T003H3_A1232FerOrigId[0] ;
         }
         else
         {
            Z1224FerDia = A1224FerDia ;
            Z1225FerMes = A1225FerMes ;
            Z1228FerDescrip = A1228FerDescrip ;
            Z1234FeriadoConvenio = A1234FeriadoConvenio ;
            Z1233FeriadoTipo = A1233FeriadoTipo ;
            Z1230FerReligId = A1230FerReligId ;
            Z1232FerOrigId = A1232FerOrigId ;
         }
      }
      if ( GX_JID == -23 )
      {
         Z1223FerId = A1223FerId ;
         Z1224FerDia = A1224FerDia ;
         Z1225FerMes = A1225FerMes ;
         Z1228FerDescrip = A1228FerDescrip ;
         Z46PaiCod = A46PaiCod ;
         Z1234FeriadoConvenio = A1234FeriadoConvenio ;
         Z1233FeriadoTipo = A1233FeriadoTipo ;
         Z1230FerReligId = A1230FerReligId ;
         Z1232FerOrigId = A1232FerOrigId ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
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
      if ( ! (GXutil.strcmp("", AV8FerId)==0) )
      {
         A1223FerId = AV8FerId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
      }
      if ( ! (GXutil.strcmp("", AV8FerId)==0) )
      {
         edtFerId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFerId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerId_Enabled), 5, 0), true);
      }
      else
      {
         edtFerId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFerId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerId_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8FerId)==0) )
      {
         edtFerId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFerId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV14Insert_FerReligId)==0) )
      {
         edtFerReligId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFerReligId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerReligId_Enabled), 5, 0), true);
      }
      else
      {
         edtFerReligId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFerReligId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerReligId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV15Insert_FerOrigId)==0) )
      {
         edtFerOrigId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFerOrigId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerOrigId_Enabled), 5, 0), true);
      }
      else
      {
         edtFerOrigId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFerOrigId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerOrigId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV16Insert_FeriadoTipo)==0) )
      {
         dynFeriadoTipo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynFeriadoTipo.getInternalname(), "Enabled", GXutil.ltrimstr( dynFeriadoTipo.getEnabled(), 5, 0), true);
      }
      else
      {
         dynFeriadoTipo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynFeriadoTipo.getInternalname(), "Enabled", GXutil.ltrimstr( dynFeriadoTipo.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV17Insert_FeriadoConvenio)==0) )
      {
         edtFeriadoConvenio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFeriadoConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFeriadoConvenio_Enabled), 5, 0), true);
      }
      else
      {
         edtFeriadoConvenio_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFeriadoConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFeriadoConvenio_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV16Insert_FeriadoTipo)==0) )
      {
         A1233FeriadoTipo = AV16Insert_FeriadoTipo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1233FeriadoTipo", A1233FeriadoTipo);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV14Insert_FerReligId)==0) )
      {
         A1230FerReligId = AV14Insert_FerReligId ;
         n1230FerReligId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1230FerReligId", A1230FerReligId);
      }
      else
      {
         if ( (GXutil.strcmp("", AV26ComboFerReligId)==0) )
         {
            A1230FerReligId = "" ;
            n1230FerReligId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1230FerReligId", A1230FerReligId);
            n1230FerReligId = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A1230FerReligId", A1230FerReligId);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV26ComboFerReligId)==0) )
            {
               A1230FerReligId = AV26ComboFerReligId ;
               n1230FerReligId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1230FerReligId", A1230FerReligId);
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV15Insert_FerOrigId)==0) )
      {
         A1232FerOrigId = AV15Insert_FerOrigId ;
         n1232FerOrigId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1232FerOrigId", A1232FerOrigId);
      }
      else
      {
         if ( (GXutil.strcmp("", AV30ComboFerOrigId)==0) )
         {
            A1232FerOrigId = "" ;
            n1232FerOrigId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1232FerOrigId", A1232FerOrigId);
            n1232FerOrigId = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A1232FerOrigId", A1232FerOrigId);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV30ComboFerOrigId)==0) )
            {
               A1232FerOrigId = AV30ComboFerOrigId ;
               n1232FerOrigId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1232FerOrigId", A1232FerOrigId);
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV17Insert_FeriadoConvenio)==0) )
      {
         A1234FeriadoConvenio = AV17Insert_FeriadoConvenio ;
         n1234FeriadoConvenio = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1234FeriadoConvenio", A1234FeriadoConvenio);
      }
      else
      {
         if ( (GXutil.strcmp("", AV36ComboFeriadoConvenio)==0) )
         {
            A1234FeriadoConvenio = "" ;
            n1234FeriadoConvenio = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1234FeriadoConvenio", A1234FeriadoConvenio);
            n1234FeriadoConvenio = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A1234FeriadoConvenio", A1234FeriadoConvenio);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV36ComboFeriadoConvenio)==0) )
            {
               A1234FeriadoConvenio = AV36ComboFeriadoConvenio ;
               n1234FeriadoConvenio = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1234FeriadoConvenio", A1234FeriadoConvenio);
            }
         }
      }
      if ( ! (0==AV7PaiCod) )
      {
         A46PaiCod = AV7PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      else
      {
         if ( isIns( )  )
         {
            GXt_int1 = A46PaiCod ;
            GXt_int2 = A46PaiCod ;
            GXv_int3[0] = GXt_int2 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int3) ;
            feriado_impl.this.GXt_int2 = GXv_int3[0] ;
            GXv_int4[0] = GXt_int1 ;
            new web.clientegetpais(remoteHandle, context).execute( GXt_int2, GXv_int4) ;
            feriado_impl.this.GXt_int1 = GXv_int4[0] ;
            A46PaiCod = GXt_int1 ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
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
         AV38Pgmname = "feriado" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
         gxaferiadotipo_html3H140( A46PaiCod) ;
      }
   }

   public void load3H140( )
   {
      /* Using cursor T003H8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod), A1223FerId});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound140 = (short)(1) ;
         A1224FerDia = T003H8_A1224FerDia[0] ;
         A1225FerMes = T003H8_A1225FerMes[0] ;
         A1228FerDescrip = T003H8_A1228FerDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1228FerDescrip", A1228FerDescrip);
         A1234FeriadoConvenio = T003H8_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = T003H8_n1234FeriadoConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1234FeriadoConvenio", A1234FeriadoConvenio);
         A1233FeriadoTipo = T003H8_A1233FeriadoTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1233FeriadoTipo", A1233FeriadoTipo);
         A1230FerReligId = T003H8_A1230FerReligId[0] ;
         n1230FerReligId = T003H8_n1230FerReligId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1230FerReligId", A1230FerReligId);
         A1232FerOrigId = T003H8_A1232FerOrigId[0] ;
         n1232FerOrigId = T003H8_n1232FerOrigId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1232FerOrigId", A1232FerOrigId);
         zm3H140( -23) ;
      }
      pr_default.close(6);
      onLoadActions3H140( ) ;
   }

   public void onLoadActions3H140( )
   {
      AV38Pgmname = "feriado" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
      gxaferiadotipo_html3H140( A46PaiCod) ;
   }

   public void checkExtendedTable3H140( )
   {
      nIsDirty_140 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV38Pgmname = "feriado" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
      /* Using cursor T003H4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n1234FeriadoConvenio), A1234FeriadoConvenio});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (GXutil.strcmp("", A1234FeriadoConvenio)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio En Feriado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERIADOCONVENIO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(2);
      /* Using cursor T003H5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), A1233FeriadoTipo});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Feriado Tipo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERIADOTIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      /* Using cursor T003H6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n1230FerReligId), A1230FerReligId});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (GXutil.strcmp("", A1230FerReligId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "No Lab Religion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERRELIGID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(4);
      /* Using cursor T003H7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n1232FerOrigId), A1232FerOrigId});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (GXutil.strcmp("", A1232FerOrigId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "No Lab Orig", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERORIGID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(5);
      gxaferiadotipo_html3H140( A46PaiCod) ;
      if ( ! ( ( GXutil.strcmp(A1233FeriadoTipo, "inamovible") == 0 ) || ( GXutil.strcmp(A1233FeriadoTipo, "trasladable") == 0 ) || ( GXutil.strcmp(A1233FeriadoTipo, "puente") == 0 ) || ( GXutil.strcmp(A1233FeriadoTipo, "nolaborable") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), "", "", "", "", "", "", "", "", ""), "OutOfRange", 1, "FERIADOTIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynFeriadoTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors3H140( )
   {
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(4);
      pr_default.close(5);
   }

   public void enableDisable( )
   {
   }

   public void gxload_24( short A46PaiCod ,
                          String A1234FeriadoConvenio )
   {
      /* Using cursor T003H9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n1234FeriadoConvenio), A1234FeriadoConvenio});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (GXutil.strcmp("", A1234FeriadoConvenio)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio En Feriado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERIADOCONVENIO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_25( short A46PaiCod ,
                          String A1233FeriadoTipo )
   {
      /* Using cursor T003H10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A46PaiCod), A1233FeriadoTipo});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Feriado Tipo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERIADOTIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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

   public void gxload_26( short A46PaiCod ,
                          String A1230FerReligId )
   {
      /* Using cursor T003H11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n1230FerReligId), A1230FerReligId});
      if ( (pr_default.getStatus(9) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (GXutil.strcmp("", A1230FerReligId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "No Lab Religion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERRELIGID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(9) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(9);
   }

   public void gxload_27( short A46PaiCod ,
                          String A1232FerOrigId )
   {
      /* Using cursor T003H12 */
      pr_default.execute(10, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n1232FerOrigId), A1232FerOrigId});
      if ( (pr_default.getStatus(10) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (GXutil.strcmp("", A1232FerOrigId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "No Lab Orig", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERORIGID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void getKey3H140( )
   {
      /* Using cursor T003H13 */
      pr_default.execute(11, new Object[] {Short.valueOf(A46PaiCod), A1223FerId});
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound140 = (short)(1) ;
      }
      else
      {
         RcdFound140 = (short)(0) ;
      }
      pr_default.close(11);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T003H3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A1223FerId});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm3H140( 23) ;
         RcdFound140 = (short)(1) ;
         A1223FerId = T003H3_A1223FerId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
         A1224FerDia = T003H3_A1224FerDia[0] ;
         A1225FerMes = T003H3_A1225FerMes[0] ;
         A1228FerDescrip = T003H3_A1228FerDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1228FerDescrip", A1228FerDescrip);
         A46PaiCod = T003H3_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1234FeriadoConvenio = T003H3_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = T003H3_n1234FeriadoConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1234FeriadoConvenio", A1234FeriadoConvenio);
         A1233FeriadoTipo = T003H3_A1233FeriadoTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1233FeriadoTipo", A1233FeriadoTipo);
         A1230FerReligId = T003H3_A1230FerReligId[0] ;
         n1230FerReligId = T003H3_n1230FerReligId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1230FerReligId", A1230FerReligId);
         A1232FerOrigId = T003H3_A1232FerOrigId[0] ;
         n1232FerOrigId = T003H3_n1232FerOrigId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1232FerOrigId", A1232FerOrigId);
         Z46PaiCod = A46PaiCod ;
         Z1223FerId = A1223FerId ;
         sMode140 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load3H140( ) ;
         if ( AnyError == 1 )
         {
            RcdFound140 = (short)(0) ;
            initializeNonKey3H140( ) ;
         }
         Gx_mode = sMode140 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound140 = (short)(0) ;
         initializeNonKey3H140( ) ;
         sMode140 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode140 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey3H140( ) ;
      if ( RcdFound140 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound140 = (short)(0) ;
      /* Using cursor T003H14 */
      pr_default.execute(12, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A1223FerId});
      if ( (pr_default.getStatus(12) != 101) )
      {
         while ( (pr_default.getStatus(12) != 101) && ( ( T003H14_A46PaiCod[0] < A46PaiCod ) || ( T003H14_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T003H14_A1223FerId[0], A1223FerId) < 0 ) ) )
         {
            pr_default.readNext(12);
         }
         if ( (pr_default.getStatus(12) != 101) && ( ( T003H14_A46PaiCod[0] > A46PaiCod ) || ( T003H14_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T003H14_A1223FerId[0], A1223FerId) > 0 ) ) )
         {
            A46PaiCod = T003H14_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A1223FerId = T003H14_A1223FerId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
            RcdFound140 = (short)(1) ;
         }
      }
      pr_default.close(12);
   }

   public void move_previous( )
   {
      RcdFound140 = (short)(0) ;
      /* Using cursor T003H15 */
      pr_default.execute(13, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A1223FerId});
      if ( (pr_default.getStatus(13) != 101) )
      {
         while ( (pr_default.getStatus(13) != 101) && ( ( T003H15_A46PaiCod[0] > A46PaiCod ) || ( T003H15_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T003H15_A1223FerId[0], A1223FerId) > 0 ) ) )
         {
            pr_default.readNext(13);
         }
         if ( (pr_default.getStatus(13) != 101) && ( ( T003H15_A46PaiCod[0] < A46PaiCod ) || ( T003H15_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T003H15_A1223FerId[0], A1223FerId) < 0 ) ) )
         {
            A46PaiCod = T003H15_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A1223FerId = T003H15_A1223FerId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
            RcdFound140 = (short)(1) ;
         }
      }
      pr_default.close(13);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey3H140( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtFerId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert3H140( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound140 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A1223FerId, Z1223FerId) != 0 ) )
            {
               A46PaiCod = Z46PaiCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A1223FerId = Z1223FerId ;
               httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtFerId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update3H140( ) ;
               GX_FocusControl = edtFerId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A1223FerId, Z1223FerId) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtFerId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert3H140( ) ;
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
                  GX_FocusControl = edtFerId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert3H140( ) ;
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
      if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A1223FerId, Z1223FerId) != 0 ) )
      {
         A46PaiCod = Z46PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1223FerId = Z1223FerId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtFerId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency3H140( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T003H2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A1223FerId});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"feriado"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z1224FerDia != T003H2_A1224FerDia[0] ) || ( Z1225FerMes != T003H2_A1225FerMes[0] ) || ( GXutil.strcmp(Z1228FerDescrip, T003H2_A1228FerDescrip[0]) != 0 ) || ( GXutil.strcmp(Z1234FeriadoConvenio, T003H2_A1234FeriadoConvenio[0]) != 0 ) || ( GXutil.strcmp(Z1233FeriadoTipo, T003H2_A1233FeriadoTipo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1230FerReligId, T003H2_A1230FerReligId[0]) != 0 ) || ( GXutil.strcmp(Z1232FerOrigId, T003H2_A1232FerOrigId[0]) != 0 ) )
         {
            if ( Z1224FerDia != T003H2_A1224FerDia[0] )
            {
               GXutil.writeLogln("feriado:[seudo value changed for attri]"+"FerDia");
               GXutil.writeLogRaw("Old: ",Z1224FerDia);
               GXutil.writeLogRaw("Current: ",T003H2_A1224FerDia[0]);
            }
            if ( Z1225FerMes != T003H2_A1225FerMes[0] )
            {
               GXutil.writeLogln("feriado:[seudo value changed for attri]"+"FerMes");
               GXutil.writeLogRaw("Old: ",Z1225FerMes);
               GXutil.writeLogRaw("Current: ",T003H2_A1225FerMes[0]);
            }
            if ( GXutil.strcmp(Z1228FerDescrip, T003H2_A1228FerDescrip[0]) != 0 )
            {
               GXutil.writeLogln("feriado:[seudo value changed for attri]"+"FerDescrip");
               GXutil.writeLogRaw("Old: ",Z1228FerDescrip);
               GXutil.writeLogRaw("Current: ",T003H2_A1228FerDescrip[0]);
            }
            if ( GXutil.strcmp(Z1234FeriadoConvenio, T003H2_A1234FeriadoConvenio[0]) != 0 )
            {
               GXutil.writeLogln("feriado:[seudo value changed for attri]"+"FeriadoConvenio");
               GXutil.writeLogRaw("Old: ",Z1234FeriadoConvenio);
               GXutil.writeLogRaw("Current: ",T003H2_A1234FeriadoConvenio[0]);
            }
            if ( GXutil.strcmp(Z1233FeriadoTipo, T003H2_A1233FeriadoTipo[0]) != 0 )
            {
               GXutil.writeLogln("feriado:[seudo value changed for attri]"+"FeriadoTipo");
               GXutil.writeLogRaw("Old: ",Z1233FeriadoTipo);
               GXutil.writeLogRaw("Current: ",T003H2_A1233FeriadoTipo[0]);
            }
            if ( GXutil.strcmp(Z1230FerReligId, T003H2_A1230FerReligId[0]) != 0 )
            {
               GXutil.writeLogln("feriado:[seudo value changed for attri]"+"FerReligId");
               GXutil.writeLogRaw("Old: ",Z1230FerReligId);
               GXutil.writeLogRaw("Current: ",T003H2_A1230FerReligId[0]);
            }
            if ( GXutil.strcmp(Z1232FerOrigId, T003H2_A1232FerOrigId[0]) != 0 )
            {
               GXutil.writeLogln("feriado:[seudo value changed for attri]"+"FerOrigId");
               GXutil.writeLogRaw("Old: ",Z1232FerOrigId);
               GXutil.writeLogRaw("Current: ",T003H2_A1232FerOrigId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"feriado"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3H140( )
   {
      beforeValidate3H140( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3H140( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3H140( 0) ;
         checkOptimisticConcurrency3H140( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3H140( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3H140( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003H16 */
                  pr_default.execute(14, new Object[] {A1223FerId, Byte.valueOf(A1224FerDia), Byte.valueOf(A1225FerMes), A1228FerDescrip, Short.valueOf(A46PaiCod), Boolean.valueOf(n1234FeriadoConvenio), A1234FeriadoConvenio, A1233FeriadoTipo, Boolean.valueOf(n1230FerReligId), A1230FerReligId, Boolean.valueOf(n1232FerOrigId), A1232FerOrigId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado");
                  if ( (pr_default.getStatus(14) == 1) )
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
                        resetCaption3H0( ) ;
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
            load3H140( ) ;
         }
         endLevel3H140( ) ;
      }
      closeExtendedTableCursors3H140( ) ;
   }

   public void update3H140( )
   {
      beforeValidate3H140( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3H140( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3H140( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3H140( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3H140( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003H17 */
                  pr_default.execute(15, new Object[] {Byte.valueOf(A1224FerDia), Byte.valueOf(A1225FerMes), A1228FerDescrip, Boolean.valueOf(n1234FeriadoConvenio), A1234FeriadoConvenio, A1233FeriadoTipo, Boolean.valueOf(n1230FerReligId), A1230FerReligId, Boolean.valueOf(n1232FerOrigId), A1232FerOrigId, Short.valueOf(A46PaiCod), A1223FerId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado");
                  if ( (pr_default.getStatus(15) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"feriado"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate3H140( ) ;
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
         endLevel3H140( ) ;
      }
      closeExtendedTableCursors3H140( ) ;
   }

   public void deferredUpdate3H140( )
   {
   }

   public void delete( )
   {
      beforeValidate3H140( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3H140( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3H140( ) ;
         afterConfirm3H140( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3H140( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T003H18 */
               pr_default.execute(16, new Object[] {Short.valueOf(A46PaiCod), A1223FerId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado");
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
      sMode140 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel3H140( ) ;
      Gx_mode = sMode140 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls3H140( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV38Pgmname = "feriado" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
         gxaferiadotipo_html3H140( A46PaiCod) ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T003H19 */
         pr_default.execute(17, new Object[] {Short.valueOf(A46PaiCod), A1223FerId});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Feriado agenda", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
      }
   }

   public void endLevel3H140( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete3H140( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "feriado");
         if ( AnyError == 0 )
         {
            confirmValues3H0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "feriado");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart3H140( )
   {
      /* Scan By routine */
      /* Using cursor T003H20 */
      pr_default.execute(18);
      RcdFound140 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound140 = (short)(1) ;
         A46PaiCod = T003H20_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1223FerId = T003H20_A1223FerId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext3H140( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound140 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound140 = (short)(1) ;
         A46PaiCod = T003H20_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1223FerId = T003H20_A1223FerId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
      }
   }

   public void scanEnd3H140( )
   {
      pr_default.close(18);
   }

   public void afterConfirm3H140( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert3H140( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3H140( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3H140( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3H140( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3H140( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3H140( )
   {
      edtFerId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFerId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerId_Enabled), 5, 0), true);
      edtFerDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFerDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerDescrip_Enabled), 5, 0), true);
      edtFerReligId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFerReligId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerReligId_Enabled), 5, 0), true);
      edtFerOrigId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFerOrigId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerOrigId_Enabled), 5, 0), true);
      dynFeriadoTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynFeriadoTipo.getInternalname(), "Enabled", GXutil.ltrimstr( dynFeriadoTipo.getEnabled(), 5, 0), true);
      edtFeriadoConvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFeriadoConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFeriadoConvenio_Enabled), 5, 0), true);
      edtavComboferreligid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboferreligid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboferreligid_Enabled), 5, 0), true);
      edtavComboferorigid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboferorigid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboferorigid_Enabled), 5, 0), true);
      edtavComboferiadoconvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboferiadoconvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboferiadoconvenio_Enabled), 5, 0), true);
      edtPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes3H140( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues3H0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.feriado", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV8FerId))}, new String[] {"Gx_mode","PaiCod","FerId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"feriado");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("FerDia", localUtil.format( DecimalUtil.doubleToDec(A1224FerDia), "Z9"));
      forbiddenHiddens.add("FerMes", localUtil.format( DecimalUtil.doubleToDec(A1225FerMes), "Z9"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("feriado:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1223FerId", GXutil.rtrim( Z1223FerId));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1224FerDia", GXutil.ltrim( localUtil.ntoc( Z1224FerDia, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1225FerMes", GXutil.ltrim( localUtil.ntoc( Z1225FerMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1228FerDescrip", Z1228FerDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1234FeriadoConvenio", GXutil.rtrim( Z1234FeriadoConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1233FeriadoTipo", GXutil.rtrim( Z1233FeriadoTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1230FerReligId", GXutil.rtrim( Z1230FerReligId));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1232FerOrigId", GXutil.rtrim( Z1232FerOrigId));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1230FerReligId", GXutil.rtrim( A1230FerReligId));
      web.GxWebStd.gx_hidden_field( httpContext, "N1232FerOrigId", GXutil.rtrim( A1232FerOrigId));
      web.GxWebStd.gx_hidden_field( httpContext, "N1233FeriadoTipo", GXutil.rtrim( A1233FeriadoTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "N1234FeriadoConvenio", GXutil.rtrim( A1234FeriadoConvenio));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFERRELIGID_DATA", AV25FerReligId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFERRELIGID_DATA", AV25FerReligId_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFERORIGID_DATA", AV29FerOrigId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFERORIGID_DATA", AV29FerOrigId_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFERIADOCONVENIO_DATA", AV35FeriadoConvenio_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFERIADOCONVENIO_DATA", AV35FeriadoConvenio_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV7PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vFERID", GXutil.rtrim( AV8FerId));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8FerId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_FERRELIGID", GXutil.rtrim( AV14Insert_FerReligId));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_FERORIGID", GXutil.rtrim( AV15Insert_FerOrigId));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_FERIADOTIPO", GXutil.rtrim( AV16Insert_FeriadoTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_FERIADOCONVENIO", GXutil.rtrim( AV17Insert_FeriadoConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "FERDIA", GXutil.ltrim( localUtil.ntoc( A1224FerDia, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "FERMES", GXutil.ltrim( localUtil.ntoc( A1225FerMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV38Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERRELIGID_Objectcall", GXutil.rtrim( Combo_ferreligid_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERRELIGID_Cls", GXutil.rtrim( Combo_ferreligid_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERRELIGID_Selectedvalue_set", GXutil.rtrim( Combo_ferreligid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERRELIGID_Selectedtext_set", GXutil.rtrim( Combo_ferreligid_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERRELIGID_Enabled", GXutil.booltostr( Combo_ferreligid_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERRELIGID_Datalistproc", GXutil.rtrim( Combo_ferreligid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERRELIGID_Datalistprocparametersprefix", GXutil.rtrim( Combo_ferreligid_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERORIGID_Objectcall", GXutil.rtrim( Combo_ferorigid_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERORIGID_Cls", GXutil.rtrim( Combo_ferorigid_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERORIGID_Selectedvalue_set", GXutil.rtrim( Combo_ferorigid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERORIGID_Selectedtext_set", GXutil.rtrim( Combo_ferorigid_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERORIGID_Enabled", GXutil.booltostr( Combo_ferorigid_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERORIGID_Datalistproc", GXutil.rtrim( Combo_ferorigid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERORIGID_Datalistprocparametersprefix", GXutil.rtrim( Combo_ferorigid_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERIADOCONVENIO_Objectcall", GXutil.rtrim( Combo_feriadoconvenio_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERIADOCONVENIO_Cls", GXutil.rtrim( Combo_feriadoconvenio_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERIADOCONVENIO_Selectedvalue_set", GXutil.rtrim( Combo_feriadoconvenio_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERIADOCONVENIO_Selectedtext_set", GXutil.rtrim( Combo_feriadoconvenio_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERIADOCONVENIO_Enabled", GXutil.booltostr( Combo_feriadoconvenio_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERIADOCONVENIO_Datalistproc", GXutil.rtrim( Combo_feriadoconvenio_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_FERIADOCONVENIO_Datalistprocparametersprefix", GXutil.rtrim( Combo_feriadoconvenio_Datalistprocparametersprefix));
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
      return formatLink("web.feriado", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV8FerId))}, new String[] {"Gx_mode","PaiCod","FerId"})  ;
   }

   public String getPgmname( )
   {
      return "feriado" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "feriado", "") ;
   }

   public void initializeNonKey3H140( )
   {
      A1230FerReligId = "" ;
      n1230FerReligId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1230FerReligId", A1230FerReligId);
      n1230FerReligId = ((GXutil.strcmp("", A1230FerReligId)==0) ? true : false) ;
      A1232FerOrigId = "" ;
      n1232FerOrigId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1232FerOrigId", A1232FerOrigId);
      n1232FerOrigId = ((GXutil.strcmp("", A1232FerOrigId)==0) ? true : false) ;
      A1233FeriadoTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1233FeriadoTipo", A1233FeriadoTipo);
      A1234FeriadoConvenio = "" ;
      n1234FeriadoConvenio = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1234FeriadoConvenio", A1234FeriadoConvenio);
      n1234FeriadoConvenio = ((GXutil.strcmp("", A1234FeriadoConvenio)==0) ? true : false) ;
      A1224FerDia = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1224FerDia", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1224FerDia), 2, 0));
      A1225FerMes = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1225FerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1225FerMes), 2, 0));
      A1228FerDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1228FerDescrip", A1228FerDescrip);
      Z1224FerDia = (byte)(0) ;
      Z1225FerMes = (byte)(0) ;
      Z1228FerDescrip = "" ;
      Z1234FeriadoConvenio = "" ;
      Z1233FeriadoTipo = "" ;
      Z1230FerReligId = "" ;
      Z1232FerOrigId = "" ;
   }

   public void initAll3H140( )
   {
      A46PaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A1223FerId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
      initializeNonKey3H140( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025187215671", true, true);
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
      httpContext.AddJavascriptSource("feriado.js", "?2025187215671", false, true);
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
      edtFerId_Internalname = "FERID" ;
      edtFerDescrip_Internalname = "FERDESCRIP" ;
      lblTextblockferreligid_Internalname = "TEXTBLOCKFERRELIGID" ;
      Combo_ferreligid_Internalname = "COMBO_FERRELIGID" ;
      edtFerReligId_Internalname = "FERRELIGID" ;
      divTablesplittedferreligid_Internalname = "TABLESPLITTEDFERRELIGID" ;
      lblTextblockferorigid_Internalname = "TEXTBLOCKFERORIGID" ;
      Combo_ferorigid_Internalname = "COMBO_FERORIGID" ;
      edtFerOrigId_Internalname = "FERORIGID" ;
      divTablesplittedferorigid_Internalname = "TABLESPLITTEDFERORIGID" ;
      dynFeriadoTipo.setInternalname( "FERIADOTIPO" );
      lblTextblockferiadoconvenio_Internalname = "TEXTBLOCKFERIADOCONVENIO" ;
      Combo_feriadoconvenio_Internalname = "COMBO_FERIADOCONVENIO" ;
      edtFeriadoConvenio_Internalname = "FERIADOCONVENIO" ;
      divTablesplittedferiadoconvenio_Internalname = "TABLESPLITTEDFERIADOCONVENIO" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboferreligid_Internalname = "vCOMBOFERRELIGID" ;
      divSectionattribute_ferreligid_Internalname = "SECTIONATTRIBUTE_FERRELIGID" ;
      edtavComboferorigid_Internalname = "vCOMBOFERORIGID" ;
      divSectionattribute_ferorigid_Internalname = "SECTIONATTRIBUTE_FERORIGID" ;
      edtavComboferiadoconvenio_Internalname = "vCOMBOFERIADOCONVENIO" ;
      divSectionattribute_feriadoconvenio_Internalname = "SECTIONATTRIBUTE_FERIADOCONVENIO" ;
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
      Form.setCaption( httpContext.getMessage( "feriado", "") );
      Combo_ferreligid_Datalistprocparametersprefix = "" ;
      Combo_ferorigid_Datalistprocparametersprefix = "" ;
      Combo_feriadoconvenio_Datalistprocparametersprefix = "" ;
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 1 ;
      edtPaiCod_Visible = 1 ;
      edtavComboferiadoconvenio_Jsonclick = "" ;
      edtavComboferiadoconvenio_Enabled = 0 ;
      edtavComboferiadoconvenio_Visible = 1 ;
      edtavComboferorigid_Jsonclick = "" ;
      edtavComboferorigid_Enabled = 0 ;
      edtavComboferorigid_Visible = 1 ;
      edtavComboferreligid_Jsonclick = "" ;
      edtavComboferreligid_Enabled = 0 ;
      edtavComboferreligid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtFeriadoConvenio_Jsonclick = "" ;
      edtFeriadoConvenio_Enabled = 1 ;
      edtFeriadoConvenio_Visible = 1 ;
      Combo_feriadoconvenio_Datalistproc = "feriadoLoadDVCombo" ;
      Combo_feriadoconvenio_Cls = "ExtendedCombo Attribute" ;
      Combo_feriadoconvenio_Caption = "" ;
      Combo_feriadoconvenio_Enabled = GXutil.toBoolean( -1) ;
      dynFeriadoTipo.setJsonclick( "" );
      dynFeriadoTipo.setEnabled( 1 );
      edtFerOrigId_Jsonclick = "" ;
      edtFerOrigId_Enabled = 1 ;
      edtFerOrigId_Visible = 1 ;
      Combo_ferorigid_Datalistproc = "feriadoLoadDVCombo" ;
      Combo_ferorigid_Cls = "ExtendedCombo Attribute" ;
      Combo_ferorigid_Caption = "" ;
      Combo_ferorigid_Enabled = GXutil.toBoolean( -1) ;
      edtFerReligId_Jsonclick = "" ;
      edtFerReligId_Enabled = 1 ;
      edtFerReligId_Visible = 1 ;
      Combo_ferreligid_Datalistproc = "feriadoLoadDVCombo" ;
      Combo_ferreligid_Cls = "ExtendedCombo Attribute" ;
      Combo_ferreligid_Caption = "" ;
      Combo_ferreligid_Enabled = GXutil.toBoolean( -1) ;
      edtFerDescrip_Enabled = 1 ;
      edtFerId_Jsonclick = "" ;
      edtFerId_Enabled = 1 ;
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
      gxaferiadotipo_html3H140( A46PaiCod) ;
      /* End function dynload_actions */
   }

   public void gxdlaferiadotipo3H140( short A46PaiCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaferiadotipo_data3H140( A46PaiCod) ;
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

   public void gxaferiadotipo_html3H140( short A46PaiCod )
   {
      String gxdynajaxvalue;
      gxdlaferiadotipo_data3H140( A46PaiCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynFeriadoTipo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynFeriadoTipo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaferiadotipo_data3H140( short A46PaiCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T003H21 */
      pr_default.execute(19, new Object[] {Short.valueOf(A46PaiCod)});
      while ( (pr_default.getStatus(19) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T003H21_A1233FeriadoTipo[0]));
         gxdynajaxctrldescr.add(T003H21_A1785FerTipoDescrip[0]);
         pr_default.readNext(19);
      }
      pr_default.close(19);
   }

   public void gx4asapaicod3H140( short AV7PaiCod )
   {
      if ( ! (0==AV7PaiCod) )
      {
         A46PaiCod = AV7PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      else
      {
         if ( isIns( )  )
         {
            GXt_int1 = A46PaiCod ;
            GXt_int2 = A46PaiCod ;
            GXv_int3[0] = GXt_int2 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int3) ;
            feriado_impl.this.GXt_int2 = GXv_int3[0] ;
            GXv_int4[0] = GXt_int1 ;
            new web.clientegetpais(remoteHandle, context).execute( GXt_int2, GXv_int4) ;
            feriado_impl.this.GXt_int1 = GXv_int4[0] ;
            A46PaiCod = GXt_int1 ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), ".", "")))+"\"") ;
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
      dynFeriadoTipo.setName( "FERIADOTIPO" );
      dynFeriadoTipo.setWebtags( "" );
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
      A1233FeriadoTipo = dynFeriadoTipo.getValue() ;
      gxaferiadotipo_html3H140( A46PaiCod) ;
      dynload_actions( ) ;
      if ( dynFeriadoTipo.getItemCount() > 0 )
      {
         A1233FeriadoTipo = dynFeriadoTipo.getValidValue(A1233FeriadoTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynFeriadoTipo.setValue( GXutil.rtrim( A1233FeriadoTipo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1233FeriadoTipo", GXutil.rtrim( A1233FeriadoTipo));
      dynFeriadoTipo.setValue( GXutil.rtrim( A1233FeriadoTipo) );
      httpContext.ajax_rsp_assign_prop("", false, dynFeriadoTipo.getInternalname(), "Values", dynFeriadoTipo.ToJavascriptSource(), true);
   }

   public void valid_Ferreligid( )
   {
      n1230FerReligId = false ;
      A1233FeriadoTipo = dynFeriadoTipo.getValue() ;
      /* Using cursor T003H22 */
      pr_default.execute(20, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n1230FerReligId), A1230FerReligId});
      if ( (pr_default.getStatus(20) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (GXutil.strcmp("", A1230FerReligId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "No Lab Religion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERRELIGID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
         }
      }
      pr_default.close(20);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Ferorigid( )
   {
      n1232FerOrigId = false ;
      A1233FeriadoTipo = dynFeriadoTipo.getValue() ;
      /* Using cursor T003H23 */
      pr_default.execute(21, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n1232FerOrigId), A1232FerOrigId});
      if ( (pr_default.getStatus(21) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (GXutil.strcmp("", A1232FerOrigId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "No Lab Orig", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERORIGID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
         }
      }
      pr_default.close(21);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Feriadotipo( )
   {
      A1233FeriadoTipo = dynFeriadoTipo.getValue() ;
      /* Using cursor T003H24 */
      pr_default.execute(22, new Object[] {Short.valueOf(A46PaiCod), A1233FeriadoTipo});
      if ( (pr_default.getStatus(22) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Feriado Tipo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERIADOTIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
      }
      pr_default.close(22);
      if ( ! ( ( GXutil.strcmp(A1233FeriadoTipo, "inamovible") == 0 ) || ( GXutil.strcmp(A1233FeriadoTipo, "trasladable") == 0 ) || ( GXutil.strcmp(A1233FeriadoTipo, "puente") == 0 ) || ( GXutil.strcmp(A1233FeriadoTipo, "nolaborable") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), "", "", "", "", "", "", "", "", ""), "OutOfRange", 1, "FERIADOTIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynFeriadoTipo.getInternalname() ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Feriadoconvenio( )
   {
      n1234FeriadoConvenio = false ;
      A1233FeriadoTipo = dynFeriadoTipo.getValue() ;
      /* Using cursor T003H25 */
      pr_default.execute(23, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n1234FeriadoConvenio), A1234FeriadoConvenio});
      if ( (pr_default.getStatus(23) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (GXutil.strcmp("", A1234FeriadoConvenio)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio En Feriado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERIADOCONVENIO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
         }
      }
      pr_default.close(23);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8FerId',fld:'vFERID',pic:'',hsh:true},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8FerId',fld:'vFERID',pic:'',hsh:true},{av:'A1224FerDia',fld:'FERDIA',pic:'Z9'},{av:'A1225FerMes',fld:'FERMES',pic:'Z9'},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e123H2',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]}");
      setEventMetadata("VALID_FERID","{handler:'valid_Ferid',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]");
      setEventMetadata("VALID_FERID",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]}");
      setEventMetadata("VALID_FERRELIGID","{handler:'valid_Ferreligid',iparms:[{av:'A1230FerReligId',fld:'FERRELIGID',pic:''},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]");
      setEventMetadata("VALID_FERRELIGID",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]}");
      setEventMetadata("VALID_FERORIGID","{handler:'valid_Ferorigid',iparms:[{av:'A1232FerOrigId',fld:'FERORIGID',pic:''},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]");
      setEventMetadata("VALID_FERORIGID",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]}");
      setEventMetadata("VALID_FERIADOTIPO","{handler:'valid_Feriadotipo',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]");
      setEventMetadata("VALID_FERIADOTIPO",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]}");
      setEventMetadata("VALID_FERIADOCONVENIO","{handler:'valid_Feriadoconvenio',iparms:[{av:'A1234FeriadoConvenio',fld:'FERIADOCONVENIO',pic:''},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]");
      setEventMetadata("VALID_FERIADOCONVENIO",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]}");
      setEventMetadata("VALIDV_COMBOFERRELIGID","{handler:'validv_Comboferreligid',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]");
      setEventMetadata("VALIDV_COMBOFERRELIGID",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]}");
      setEventMetadata("VALIDV_COMBOFERORIGID","{handler:'validv_Comboferorigid',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]");
      setEventMetadata("VALIDV_COMBOFERORIGID",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]}");
      setEventMetadata("VALIDV_COMBOFERIADOCONVENIO","{handler:'validv_Comboferiadoconvenio',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]");
      setEventMetadata("VALIDV_COMBOFERIADOCONVENIO",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]");
      setEventMetadata("VALID_PAICOD",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFeriadoTipo'},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''}]}");
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
      pr_default.close(23);
      pr_default.close(22);
      pr_default.close(20);
      pr_default.close(21);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8FerId = "" ;
      Z1223FerId = "" ;
      Z1228FerDescrip = "" ;
      Z1234FeriadoConvenio = "" ;
      Z1233FeriadoTipo = "" ;
      Z1230FerReligId = "" ;
      Z1232FerOrigId = "" ;
      N1230FerReligId = "" ;
      N1232FerOrigId = "" ;
      N1233FeriadoTipo = "" ;
      N1234FeriadoConvenio = "" ;
      Combo_feriadoconvenio_Selectedvalue_get = "" ;
      Combo_ferorigid_Selectedvalue_get = "" ;
      Combo_ferreligid_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1234FeriadoConvenio = "" ;
      A1233FeriadoTipo = "" ;
      A1230FerReligId = "" ;
      A1232FerOrigId = "" ;
      Gx_mode = "" ;
      AV8FerId = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A1223FerId = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A1228FerDescrip = "" ;
      lblTextblockferreligid_Jsonclick = "" ;
      ucCombo_ferreligid = new com.genexus.webpanels.GXUserControl();
      AV20DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV25FerReligId_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockferorigid_Jsonclick = "" ;
      ucCombo_ferorigid = new com.genexus.webpanels.GXUserControl();
      AV29FerOrigId_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockferiadoconvenio_Jsonclick = "" ;
      ucCombo_feriadoconvenio = new com.genexus.webpanels.GXUserControl();
      AV35FeriadoConvenio_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV26ComboFerReligId = "" ;
      AV30ComboFerOrigId = "" ;
      AV36ComboFeriadoConvenio = "" ;
      AV14Insert_FerReligId = "" ;
      AV15Insert_FerOrigId = "" ;
      AV16Insert_FeriadoTipo = "" ;
      AV17Insert_FeriadoConvenio = "" ;
      AV38Pgmname = "" ;
      Combo_ferreligid_Objectcall = "" ;
      Combo_ferreligid_Class = "" ;
      Combo_ferreligid_Icontype = "" ;
      Combo_ferreligid_Icon = "" ;
      Combo_ferreligid_Tooltip = "" ;
      Combo_ferreligid_Selectedvalue_set = "" ;
      Combo_ferreligid_Selectedtext_set = "" ;
      Combo_ferreligid_Selectedtext_get = "" ;
      Combo_ferreligid_Gamoauthtoken = "" ;
      Combo_ferreligid_Ddointernalname = "" ;
      Combo_ferreligid_Titlecontrolalign = "" ;
      Combo_ferreligid_Dropdownoptionstype = "" ;
      Combo_ferreligid_Titlecontrolidtoreplace = "" ;
      Combo_ferreligid_Datalisttype = "" ;
      Combo_ferreligid_Datalistfixedvalues = "" ;
      Combo_ferreligid_Remoteservicesparameters = "" ;
      Combo_ferreligid_Htmltemplate = "" ;
      Combo_ferreligid_Multiplevaluestype = "" ;
      Combo_ferreligid_Loadingdata = "" ;
      Combo_ferreligid_Noresultsfound = "" ;
      Combo_ferreligid_Emptyitemtext = "" ;
      Combo_ferreligid_Onlyselectedvalues = "" ;
      Combo_ferreligid_Selectalltext = "" ;
      Combo_ferreligid_Multiplevaluesseparator = "" ;
      Combo_ferreligid_Addnewoptiontext = "" ;
      Combo_ferorigid_Objectcall = "" ;
      Combo_ferorigid_Class = "" ;
      Combo_ferorigid_Icontype = "" ;
      Combo_ferorigid_Icon = "" ;
      Combo_ferorigid_Tooltip = "" ;
      Combo_ferorigid_Selectedvalue_set = "" ;
      Combo_ferorigid_Selectedtext_set = "" ;
      Combo_ferorigid_Selectedtext_get = "" ;
      Combo_ferorigid_Gamoauthtoken = "" ;
      Combo_ferorigid_Ddointernalname = "" ;
      Combo_ferorigid_Titlecontrolalign = "" ;
      Combo_ferorigid_Dropdownoptionstype = "" ;
      Combo_ferorigid_Titlecontrolidtoreplace = "" ;
      Combo_ferorigid_Datalisttype = "" ;
      Combo_ferorigid_Datalistfixedvalues = "" ;
      Combo_ferorigid_Remoteservicesparameters = "" ;
      Combo_ferorigid_Htmltemplate = "" ;
      Combo_ferorigid_Multiplevaluestype = "" ;
      Combo_ferorigid_Loadingdata = "" ;
      Combo_ferorigid_Noresultsfound = "" ;
      Combo_ferorigid_Emptyitemtext = "" ;
      Combo_ferorigid_Onlyselectedvalues = "" ;
      Combo_ferorigid_Selectalltext = "" ;
      Combo_ferorigid_Multiplevaluesseparator = "" ;
      Combo_ferorigid_Addnewoptiontext = "" ;
      Combo_feriadoconvenio_Objectcall = "" ;
      Combo_feriadoconvenio_Class = "" ;
      Combo_feriadoconvenio_Icontype = "" ;
      Combo_feriadoconvenio_Icon = "" ;
      Combo_feriadoconvenio_Tooltip = "" ;
      Combo_feriadoconvenio_Selectedvalue_set = "" ;
      Combo_feriadoconvenio_Selectedtext_set = "" ;
      Combo_feriadoconvenio_Selectedtext_get = "" ;
      Combo_feriadoconvenio_Gamoauthtoken = "" ;
      Combo_feriadoconvenio_Ddointernalname = "" ;
      Combo_feriadoconvenio_Titlecontrolalign = "" ;
      Combo_feriadoconvenio_Dropdownoptionstype = "" ;
      Combo_feriadoconvenio_Titlecontrolidtoreplace = "" ;
      Combo_feriadoconvenio_Datalisttype = "" ;
      Combo_feriadoconvenio_Datalistfixedvalues = "" ;
      Combo_feriadoconvenio_Remoteservicesparameters = "" ;
      Combo_feriadoconvenio_Htmltemplate = "" ;
      Combo_feriadoconvenio_Multiplevaluestype = "" ;
      Combo_feriadoconvenio_Loadingdata = "" ;
      Combo_feriadoconvenio_Noresultsfound = "" ;
      Combo_feriadoconvenio_Emptyitemtext = "" ;
      Combo_feriadoconvenio_Onlyselectedvalues = "" ;
      Combo_feriadoconvenio_Selectalltext = "" ;
      Combo_feriadoconvenio_Multiplevaluesseparator = "" ;
      Combo_feriadoconvenio_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode140 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean9 = new boolean[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      AV18TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV23Combo_DataJson = "" ;
      AV40Insert_paicod = DecimalUtil.ZERO ;
      AV21ComboSelectedValue = "" ;
      AV22ComboSelectedText = "" ;
      GXt_char10 = "" ;
      GXv_char13 = new String[1] ;
      GXv_char12 = new String[1] ;
      GXv_char11 = new String[1] ;
      T003H8_A1223FerId = new String[] {""} ;
      T003H8_A1224FerDia = new byte[1] ;
      T003H8_A1225FerMes = new byte[1] ;
      T003H8_A1228FerDescrip = new String[] {""} ;
      T003H8_A46PaiCod = new short[1] ;
      T003H8_A1234FeriadoConvenio = new String[] {""} ;
      T003H8_n1234FeriadoConvenio = new boolean[] {false} ;
      T003H8_A1233FeriadoTipo = new String[] {""} ;
      T003H8_A1230FerReligId = new String[] {""} ;
      T003H8_n1230FerReligId = new boolean[] {false} ;
      T003H8_A1232FerOrigId = new String[] {""} ;
      T003H8_n1232FerOrigId = new boolean[] {false} ;
      T003H4_A46PaiCod = new short[1] ;
      T003H5_A46PaiCod = new short[1] ;
      T003H6_A46PaiCod = new short[1] ;
      T003H7_A46PaiCod = new short[1] ;
      T003H9_A46PaiCod = new short[1] ;
      T003H10_A46PaiCod = new short[1] ;
      T003H11_A46PaiCod = new short[1] ;
      T003H12_A46PaiCod = new short[1] ;
      T003H13_A46PaiCod = new short[1] ;
      T003H13_A1223FerId = new String[] {""} ;
      T003H3_A1223FerId = new String[] {""} ;
      T003H3_A1224FerDia = new byte[1] ;
      T003H3_A1225FerMes = new byte[1] ;
      T003H3_A1228FerDescrip = new String[] {""} ;
      T003H3_A46PaiCod = new short[1] ;
      T003H3_A1234FeriadoConvenio = new String[] {""} ;
      T003H3_n1234FeriadoConvenio = new boolean[] {false} ;
      T003H3_A1233FeriadoTipo = new String[] {""} ;
      T003H3_A1230FerReligId = new String[] {""} ;
      T003H3_n1230FerReligId = new boolean[] {false} ;
      T003H3_A1232FerOrigId = new String[] {""} ;
      T003H3_n1232FerOrigId = new boolean[] {false} ;
      T003H14_A46PaiCod = new short[1] ;
      T003H14_A1223FerId = new String[] {""} ;
      T003H15_A46PaiCod = new short[1] ;
      T003H15_A1223FerId = new String[] {""} ;
      T003H2_A1223FerId = new String[] {""} ;
      T003H2_A1224FerDia = new byte[1] ;
      T003H2_A1225FerMes = new byte[1] ;
      T003H2_A1228FerDescrip = new String[] {""} ;
      T003H2_A46PaiCod = new short[1] ;
      T003H2_A1234FeriadoConvenio = new String[] {""} ;
      T003H2_n1234FeriadoConvenio = new boolean[] {false} ;
      T003H2_A1233FeriadoTipo = new String[] {""} ;
      T003H2_A1230FerReligId = new String[] {""} ;
      T003H2_n1230FerReligId = new boolean[] {false} ;
      T003H2_A1232FerOrigId = new String[] {""} ;
      T003H2_n1232FerOrigId = new boolean[] {false} ;
      T003H19_A46PaiCod = new short[1] ;
      T003H19_A1223FerId = new String[] {""} ;
      T003H19_A1226FerAnio = new short[1] ;
      T003H19_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T003H20_A46PaiCod = new short[1] ;
      T003H20_A1223FerId = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T003H21_A46PaiCod = new short[1] ;
      T003H21_A1233FeriadoTipo = new String[] {""} ;
      T003H21_A1785FerTipoDescrip = new String[] {""} ;
      T003H21_n1785FerTipoDescrip = new boolean[] {false} ;
      GXv_int3 = new int[1] ;
      GXv_int4 = new short[1] ;
      T003H22_A46PaiCod = new short[1] ;
      T003H23_A46PaiCod = new short[1] ;
      T003H24_A46PaiCod = new short[1] ;
      T003H25_A46PaiCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.feriado__default(),
         new Object[] {
             new Object[] {
            T003H2_A1223FerId, T003H2_A1224FerDia, T003H2_A1225FerMes, T003H2_A1228FerDescrip, T003H2_A46PaiCod, T003H2_A1234FeriadoConvenio, T003H2_n1234FeriadoConvenio, T003H2_A1233FeriadoTipo, T003H2_A1230FerReligId, T003H2_n1230FerReligId,
            T003H2_A1232FerOrigId, T003H2_n1232FerOrigId
            }
            , new Object[] {
            T003H3_A1223FerId, T003H3_A1224FerDia, T003H3_A1225FerMes, T003H3_A1228FerDescrip, T003H3_A46PaiCod, T003H3_A1234FeriadoConvenio, T003H3_n1234FeriadoConvenio, T003H3_A1233FeriadoTipo, T003H3_A1230FerReligId, T003H3_n1230FerReligId,
            T003H3_A1232FerOrigId, T003H3_n1232FerOrigId
            }
            , new Object[] {
            T003H4_A46PaiCod
            }
            , new Object[] {
            T003H5_A46PaiCod
            }
            , new Object[] {
            T003H6_A46PaiCod
            }
            , new Object[] {
            T003H7_A46PaiCod
            }
            , new Object[] {
            T003H8_A1223FerId, T003H8_A1224FerDia, T003H8_A1225FerMes, T003H8_A1228FerDescrip, T003H8_A46PaiCod, T003H8_A1234FeriadoConvenio, T003H8_n1234FeriadoConvenio, T003H8_A1233FeriadoTipo, T003H8_A1230FerReligId, T003H8_n1230FerReligId,
            T003H8_A1232FerOrigId, T003H8_n1232FerOrigId
            }
            , new Object[] {
            T003H9_A46PaiCod
            }
            , new Object[] {
            T003H10_A46PaiCod
            }
            , new Object[] {
            T003H11_A46PaiCod
            }
            , new Object[] {
            T003H12_A46PaiCod
            }
            , new Object[] {
            T003H13_A46PaiCod, T003H13_A1223FerId
            }
            , new Object[] {
            T003H14_A46PaiCod, T003H14_A1223FerId
            }
            , new Object[] {
            T003H15_A46PaiCod, T003H15_A1223FerId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003H19_A46PaiCod, T003H19_A1223FerId, T003H19_A1226FerAnio, T003H19_A1227FerFecha
            }
            , new Object[] {
            T003H20_A46PaiCod, T003H20_A1223FerId
            }
            , new Object[] {
            T003H21_A46PaiCod, T003H21_A1233FeriadoTipo, T003H21_A1785FerTipoDescrip, T003H21_n1785FerTipoDescrip
            }
            , new Object[] {
            T003H22_A46PaiCod
            }
            , new Object[] {
            T003H23_A46PaiCod
            }
            , new Object[] {
            T003H24_A46PaiCod
            }
            , new Object[] {
            T003H25_A46PaiCod
            }
         }
      );
      AV38Pgmname = "feriado" ;
   }

   private byte Z1224FerDia ;
   private byte Z1225FerMes ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1224FerDia ;
   private byte A1225FerMes ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7PaiCod ;
   private short Z46PaiCod ;
   private short A46PaiCod ;
   private short AV7PaiCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound140 ;
   private short nIsDirty_140 ;
   private short GXt_int1 ;
   private short GXv_int4[] ;
   private int trnEnded ;
   private int edtFerId_Enabled ;
   private int edtFerDescrip_Enabled ;
   private int edtFerReligId_Visible ;
   private int edtFerReligId_Enabled ;
   private int edtFerOrigId_Visible ;
   private int edtFerOrigId_Enabled ;
   private int edtFeriadoConvenio_Visible ;
   private int edtFeriadoConvenio_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboferreligid_Visible ;
   private int edtavComboferreligid_Enabled ;
   private int edtavComboferorigid_Visible ;
   private int edtavComboferorigid_Enabled ;
   private int edtavComboferiadoconvenio_Visible ;
   private int edtavComboferiadoconvenio_Enabled ;
   private int edtPaiCod_Visible ;
   private int edtPaiCod_Enabled ;
   private int Combo_ferreligid_Datalistupdateminimumcharacters ;
   private int Combo_ferreligid_Gxcontroltype ;
   private int Combo_ferorigid_Datalistupdateminimumcharacters ;
   private int Combo_ferorigid_Gxcontroltype ;
   private int Combo_feriadoconvenio_Datalistupdateminimumcharacters ;
   private int Combo_feriadoconvenio_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV39GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int2 ;
   private int GXv_int3[] ;
   private java.math.BigDecimal AV40Insert_paicod ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8FerId ;
   private String Z1223FerId ;
   private String Z1234FeriadoConvenio ;
   private String Z1233FeriadoTipo ;
   private String Z1230FerReligId ;
   private String Z1232FerOrigId ;
   private String N1230FerReligId ;
   private String N1232FerOrigId ;
   private String N1233FeriadoTipo ;
   private String N1234FeriadoConvenio ;
   private String Combo_feriadoconvenio_Selectedvalue_get ;
   private String Combo_ferorigid_Selectedvalue_get ;
   private String Combo_ferreligid_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1234FeriadoConvenio ;
   private String A1233FeriadoTipo ;
   private String A1230FerReligId ;
   private String A1232FerOrigId ;
   private String Gx_mode ;
   private String AV8FerId ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtFerId_Internalname ;
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
   private String A1223FerId ;
   private String edtFerId_Jsonclick ;
   private String edtFerDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablesplittedferreligid_Internalname ;
   private String lblTextblockferreligid_Internalname ;
   private String lblTextblockferreligid_Jsonclick ;
   private String Combo_ferreligid_Caption ;
   private String Combo_ferreligid_Cls ;
   private String Combo_ferreligid_Datalistproc ;
   private String Combo_ferreligid_Internalname ;
   private String edtFerReligId_Internalname ;
   private String edtFerReligId_Jsonclick ;
   private String divTablesplittedferorigid_Internalname ;
   private String lblTextblockferorigid_Internalname ;
   private String lblTextblockferorigid_Jsonclick ;
   private String Combo_ferorigid_Caption ;
   private String Combo_ferorigid_Cls ;
   private String Combo_ferorigid_Datalistproc ;
   private String Combo_ferorigid_Internalname ;
   private String edtFerOrigId_Internalname ;
   private String edtFerOrigId_Jsonclick ;
   private String divTablesplittedferiadoconvenio_Internalname ;
   private String lblTextblockferiadoconvenio_Internalname ;
   private String lblTextblockferiadoconvenio_Jsonclick ;
   private String Combo_feriadoconvenio_Caption ;
   private String Combo_feriadoconvenio_Cls ;
   private String Combo_feriadoconvenio_Datalistproc ;
   private String Combo_feriadoconvenio_Internalname ;
   private String edtFeriadoConvenio_Internalname ;
   private String edtFeriadoConvenio_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_ferreligid_Internalname ;
   private String edtavComboferreligid_Internalname ;
   private String AV26ComboFerReligId ;
   private String edtavComboferreligid_Jsonclick ;
   private String divSectionattribute_ferorigid_Internalname ;
   private String edtavComboferorigid_Internalname ;
   private String AV30ComboFerOrigId ;
   private String edtavComboferorigid_Jsonclick ;
   private String divSectionattribute_feriadoconvenio_Internalname ;
   private String edtavComboferiadoconvenio_Internalname ;
   private String AV36ComboFeriadoConvenio ;
   private String edtavComboferiadoconvenio_Jsonclick ;
   private String edtPaiCod_Internalname ;
   private String edtPaiCod_Jsonclick ;
   private String AV14Insert_FerReligId ;
   private String AV15Insert_FerOrigId ;
   private String AV16Insert_FeriadoTipo ;
   private String AV17Insert_FeriadoConvenio ;
   private String AV38Pgmname ;
   private String Combo_ferreligid_Objectcall ;
   private String Combo_ferreligid_Class ;
   private String Combo_ferreligid_Icontype ;
   private String Combo_ferreligid_Icon ;
   private String Combo_ferreligid_Tooltip ;
   private String Combo_ferreligid_Selectedvalue_set ;
   private String Combo_ferreligid_Selectedtext_set ;
   private String Combo_ferreligid_Selectedtext_get ;
   private String Combo_ferreligid_Gamoauthtoken ;
   private String Combo_ferreligid_Ddointernalname ;
   private String Combo_ferreligid_Titlecontrolalign ;
   private String Combo_ferreligid_Dropdownoptionstype ;
   private String Combo_ferreligid_Titlecontrolidtoreplace ;
   private String Combo_ferreligid_Datalisttype ;
   private String Combo_ferreligid_Datalistfixedvalues ;
   private String Combo_ferreligid_Datalistprocparametersprefix ;
   private String Combo_ferreligid_Remoteservicesparameters ;
   private String Combo_ferreligid_Htmltemplate ;
   private String Combo_ferreligid_Multiplevaluestype ;
   private String Combo_ferreligid_Loadingdata ;
   private String Combo_ferreligid_Noresultsfound ;
   private String Combo_ferreligid_Emptyitemtext ;
   private String Combo_ferreligid_Onlyselectedvalues ;
   private String Combo_ferreligid_Selectalltext ;
   private String Combo_ferreligid_Multiplevaluesseparator ;
   private String Combo_ferreligid_Addnewoptiontext ;
   private String Combo_ferorigid_Objectcall ;
   private String Combo_ferorigid_Class ;
   private String Combo_ferorigid_Icontype ;
   private String Combo_ferorigid_Icon ;
   private String Combo_ferorigid_Tooltip ;
   private String Combo_ferorigid_Selectedvalue_set ;
   private String Combo_ferorigid_Selectedtext_set ;
   private String Combo_ferorigid_Selectedtext_get ;
   private String Combo_ferorigid_Gamoauthtoken ;
   private String Combo_ferorigid_Ddointernalname ;
   private String Combo_ferorigid_Titlecontrolalign ;
   private String Combo_ferorigid_Dropdownoptionstype ;
   private String Combo_ferorigid_Titlecontrolidtoreplace ;
   private String Combo_ferorigid_Datalisttype ;
   private String Combo_ferorigid_Datalistfixedvalues ;
   private String Combo_ferorigid_Datalistprocparametersprefix ;
   private String Combo_ferorigid_Remoteservicesparameters ;
   private String Combo_ferorigid_Htmltemplate ;
   private String Combo_ferorigid_Multiplevaluestype ;
   private String Combo_ferorigid_Loadingdata ;
   private String Combo_ferorigid_Noresultsfound ;
   private String Combo_ferorigid_Emptyitemtext ;
   private String Combo_ferorigid_Onlyselectedvalues ;
   private String Combo_ferorigid_Selectalltext ;
   private String Combo_ferorigid_Multiplevaluesseparator ;
   private String Combo_ferorigid_Addnewoptiontext ;
   private String Combo_feriadoconvenio_Objectcall ;
   private String Combo_feriadoconvenio_Class ;
   private String Combo_feriadoconvenio_Icontype ;
   private String Combo_feriadoconvenio_Icon ;
   private String Combo_feriadoconvenio_Tooltip ;
   private String Combo_feriadoconvenio_Selectedvalue_set ;
   private String Combo_feriadoconvenio_Selectedtext_set ;
   private String Combo_feriadoconvenio_Selectedtext_get ;
   private String Combo_feriadoconvenio_Gamoauthtoken ;
   private String Combo_feriadoconvenio_Ddointernalname ;
   private String Combo_feriadoconvenio_Titlecontrolalign ;
   private String Combo_feriadoconvenio_Dropdownoptionstype ;
   private String Combo_feriadoconvenio_Titlecontrolidtoreplace ;
   private String Combo_feriadoconvenio_Datalisttype ;
   private String Combo_feriadoconvenio_Datalistfixedvalues ;
   private String Combo_feriadoconvenio_Datalistprocparametersprefix ;
   private String Combo_feriadoconvenio_Remoteservicesparameters ;
   private String Combo_feriadoconvenio_Htmltemplate ;
   private String Combo_feriadoconvenio_Multiplevaluestype ;
   private String Combo_feriadoconvenio_Loadingdata ;
   private String Combo_feriadoconvenio_Noresultsfound ;
   private String Combo_feriadoconvenio_Emptyitemtext ;
   private String Combo_feriadoconvenio_Onlyselectedvalues ;
   private String Combo_feriadoconvenio_Selectalltext ;
   private String Combo_feriadoconvenio_Multiplevaluesseparator ;
   private String Combo_feriadoconvenio_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode140 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char10 ;
   private String GXv_char13[] ;
   private String GXv_char12[] ;
   private String GXv_char11[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1234FeriadoConvenio ;
   private boolean n1230FerReligId ;
   private boolean n1232FerOrigId ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_ferreligid_Enabled ;
   private boolean Combo_ferreligid_Visible ;
   private boolean Combo_ferreligid_Allowmultipleselection ;
   private boolean Combo_ferreligid_Isgriditem ;
   private boolean Combo_ferreligid_Hasdescription ;
   private boolean Combo_ferreligid_Includeonlyselectedoption ;
   private boolean Combo_ferreligid_Includeselectalloption ;
   private boolean Combo_ferreligid_Emptyitem ;
   private boolean Combo_ferreligid_Includeaddnewoption ;
   private boolean Combo_ferorigid_Enabled ;
   private boolean Combo_ferorigid_Visible ;
   private boolean Combo_ferorigid_Allowmultipleselection ;
   private boolean Combo_ferorigid_Isgriditem ;
   private boolean Combo_ferorigid_Hasdescription ;
   private boolean Combo_ferorigid_Includeonlyselectedoption ;
   private boolean Combo_ferorigid_Includeselectalloption ;
   private boolean Combo_ferorigid_Emptyitem ;
   private boolean Combo_ferorigid_Includeaddnewoption ;
   private boolean Combo_feriadoconvenio_Enabled ;
   private boolean Combo_feriadoconvenio_Visible ;
   private boolean Combo_feriadoconvenio_Allowmultipleselection ;
   private boolean Combo_feriadoconvenio_Isgriditem ;
   private boolean Combo_feriadoconvenio_Hasdescription ;
   private boolean Combo_feriadoconvenio_Includeonlyselectedoption ;
   private boolean Combo_feriadoconvenio_Includeselectalloption ;
   private boolean Combo_feriadoconvenio_Emptyitem ;
   private boolean Combo_feriadoconvenio_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean Cond_result ;
   private boolean GXt_boolean8 ;
   private boolean GXv_boolean9[] ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private String AV23Combo_DataJson ;
   private String Z1228FerDescrip ;
   private String A1228FerDescrip ;
   private String AV21ComboSelectedValue ;
   private String AV22ComboSelectedText ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_ferreligid ;
   private com.genexus.webpanels.GXUserControl ucCombo_ferorigid ;
   private com.genexus.webpanels.GXUserControl ucCombo_feriadoconvenio ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynFeriadoTipo ;
   private IDataStoreProvider pr_default ;
   private String[] T003H8_A1223FerId ;
   private byte[] T003H8_A1224FerDia ;
   private byte[] T003H8_A1225FerMes ;
   private String[] T003H8_A1228FerDescrip ;
   private short[] T003H8_A46PaiCod ;
   private String[] T003H8_A1234FeriadoConvenio ;
   private boolean[] T003H8_n1234FeriadoConvenio ;
   private String[] T003H8_A1233FeriadoTipo ;
   private String[] T003H8_A1230FerReligId ;
   private boolean[] T003H8_n1230FerReligId ;
   private String[] T003H8_A1232FerOrigId ;
   private boolean[] T003H8_n1232FerOrigId ;
   private short[] T003H4_A46PaiCod ;
   private short[] T003H5_A46PaiCod ;
   private short[] T003H6_A46PaiCod ;
   private short[] T003H7_A46PaiCod ;
   private short[] T003H9_A46PaiCod ;
   private short[] T003H10_A46PaiCod ;
   private short[] T003H11_A46PaiCod ;
   private short[] T003H12_A46PaiCod ;
   private short[] T003H13_A46PaiCod ;
   private String[] T003H13_A1223FerId ;
   private String[] T003H3_A1223FerId ;
   private byte[] T003H3_A1224FerDia ;
   private byte[] T003H3_A1225FerMes ;
   private String[] T003H3_A1228FerDescrip ;
   private short[] T003H3_A46PaiCod ;
   private String[] T003H3_A1234FeriadoConvenio ;
   private boolean[] T003H3_n1234FeriadoConvenio ;
   private String[] T003H3_A1233FeriadoTipo ;
   private String[] T003H3_A1230FerReligId ;
   private boolean[] T003H3_n1230FerReligId ;
   private String[] T003H3_A1232FerOrigId ;
   private boolean[] T003H3_n1232FerOrigId ;
   private short[] T003H14_A46PaiCod ;
   private String[] T003H14_A1223FerId ;
   private short[] T003H15_A46PaiCod ;
   private String[] T003H15_A1223FerId ;
   private String[] T003H2_A1223FerId ;
   private byte[] T003H2_A1224FerDia ;
   private byte[] T003H2_A1225FerMes ;
   private String[] T003H2_A1228FerDescrip ;
   private short[] T003H2_A46PaiCod ;
   private String[] T003H2_A1234FeriadoConvenio ;
   private boolean[] T003H2_n1234FeriadoConvenio ;
   private String[] T003H2_A1233FeriadoTipo ;
   private String[] T003H2_A1230FerReligId ;
   private boolean[] T003H2_n1230FerReligId ;
   private String[] T003H2_A1232FerOrigId ;
   private boolean[] T003H2_n1232FerOrigId ;
   private short[] T003H19_A46PaiCod ;
   private String[] T003H19_A1223FerId ;
   private short[] T003H19_A1226FerAnio ;
   private java.util.Date[] T003H19_A1227FerFecha ;
   private short[] T003H20_A46PaiCod ;
   private String[] T003H20_A1223FerId ;
   private short[] T003H21_A46PaiCod ;
   private String[] T003H21_A1233FeriadoTipo ;
   private String[] T003H21_A1785FerTipoDescrip ;
   private boolean[] T003H21_n1785FerTipoDescrip ;
   private short[] T003H22_A46PaiCod ;
   private short[] T003H23_A46PaiCod ;
   private short[] T003H24_A46PaiCod ;
   private short[] T003H25_A46PaiCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV25FerReligId_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV29FerOrigId_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV35FeriadoConvenio_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV18TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV20DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons7[] ;
}

final  class feriado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T003H2", "SELECT FerId, FerDia, FerMes, FerDescrip, PaiCod, FeriadoConvenio, FeriadoTipo, FerReligId, FerOrigId FROM feriado WHERE PaiCod = ? AND FerId = ?  FOR UPDATE OF feriado NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H3", "SELECT FerId, FerDia, FerMes, FerDescrip, PaiCod, FeriadoConvenio, FeriadoTipo, FerReligId, FerOrigId FROM feriado WHERE PaiCod = ? AND FerId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H4", "SELECT PaiCod FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H5", "SELECT PaiCod FROM tipo_feriado WHERE PaiCod = ? AND FerTipo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H6", "SELECT PaiCod FROM PaisReligion WHERE PaiCod = ? AND PaiReligion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H7", "SELECT PaiCod FROM PaisOrigen WHERE PaiCod = ? AND PaiOrigen = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H8", "SELECT TM1.FerId, TM1.FerDia, TM1.FerMes, TM1.FerDescrip, TM1.PaiCod, TM1.FeriadoConvenio AS FeriadoConvenio, TM1.FeriadoTipo AS FeriadoTipo, TM1.FerReligId AS FerReligId, TM1.FerOrigId AS FerOrigId FROM feriado TM1 WHERE TM1.PaiCod = ? and TM1.FerId = ( ?) ORDER BY TM1.PaiCod, TM1.FerId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H9", "SELECT PaiCod FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H10", "SELECT PaiCod FROM tipo_feriado WHERE PaiCod = ? AND FerTipo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H11", "SELECT PaiCod FROM PaisReligion WHERE PaiCod = ? AND PaiReligion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H12", "SELECT PaiCod FROM PaisOrigen WHERE PaiCod = ? AND PaiOrigen = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H13", "SELECT PaiCod, FerId FROM feriado WHERE PaiCod = ? AND FerId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H14", "SELECT PaiCod, FerId FROM feriado WHERE ( PaiCod > ? or PaiCod = ? and FerId > ( ?)) ORDER BY PaiCod, FerId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003H15", "SELECT PaiCod, FerId FROM feriado WHERE ( PaiCod < ? or PaiCod = ? and FerId < ( ?)) ORDER BY PaiCod DESC, FerId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T003H16", "SAVEPOINT gxupdate;INSERT INTO feriado(FerId, FerDia, FerMes, FerDescrip, PaiCod, FeriadoConvenio, FeriadoTipo, FerReligId, FerOrigId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003H17", "SAVEPOINT gxupdate;UPDATE feriado SET FerDia=?, FerMes=?, FerDescrip=?, FeriadoConvenio=?, FeriadoTipo=?, FerReligId=?, FerOrigId=?  WHERE PaiCod = ? AND FerId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003H18", "SAVEPOINT gxupdate;DELETE FROM feriado  WHERE PaiCod = ? AND FerId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003H19", "SELECT PaiCod, FerId, FerAnio, FerFecha FROM feriado_agenda WHERE PaiCod = ? AND FerId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003H20", "SELECT PaiCod, FerId FROM feriado ORDER BY PaiCod, FerId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H21", "SELECT PaiCod, FerTipo AS FeriadoTipo, FerTipoDescrip FROM tipo_feriado WHERE PaiCod = ? ORDER BY FerTipoDescrip ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H22", "SELECT PaiCod FROM PaisReligion WHERE PaiCod = ? AND PaiReligion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H23", "SELECT PaiCod FROM PaisOrigen WHERE PaiCod = ? AND PaiOrigen = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H24", "SELECT PaiCod FROM tipo_feriado WHERE PaiCod = ? AND FerTipo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003H25", "SELECT PaiCod FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 20 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 14 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 20);
               }
               stmt.setString(7, (String)parms[7], 20);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[9], 20);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[11], 20);
               }
               return;
            case 15 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[4], 20);
               }
               stmt.setString(5, (String)parms[5], 20);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[7], 20);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[9], 20);
               }
               stmt.setShort(8, ((Number) parms[10]).shortValue());
               stmt.setString(9, (String)parms[11], 40);
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 23 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
      }
   }

}

