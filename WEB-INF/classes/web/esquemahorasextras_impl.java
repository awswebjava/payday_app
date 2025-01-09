package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class esquemahorasextras_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action22") == 0 )
      {
         AV8CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliPaiConve), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
         A1294PaiTipoTraId = httpContext.GetPar( "PaiTipoTraId") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_22_6R217( AV8CliPaiConve, A1294PaiTipoTraId) ;
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
         gx2asaclicod6R217( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_25") == 0 )
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
         gxload_25( A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_24") == 0 )
      {
         A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1294PaiTipoTraId = httpContext.GetPar( "PaiTipoTraId") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_24( A1564CliPaiConve, A1294PaiTipoTraId) ;
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
            AV10PaiTipoTraId = httpContext.GetPar( "PaiTipoTraId") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10PaiTipoTraId", AV10PaiTipoTraId);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAITIPOTRAID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10PaiTipoTraId, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Esquema Horas Extras", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = dynPaiTipoTraId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public esquemahorasextras_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public esquemahorasextras_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esquemahorasextras_impl.class ));
   }

   public esquemahorasextras_impl( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynPaiTipoTraId = new HTMLChoice();
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
      if ( dynPaiTipoTraId.getItemCount() > 0 )
      {
         A1294PaiTipoTraId = dynPaiTipoTraId.getValidValue(A1294PaiTipoTraId) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPaiTipoTraId.setValue( GXutil.rtrim( A1294PaiTipoTraId) );
         httpContext.ajax_rsp_assign_prop("", false, dynPaiTipoTraId.getInternalname(), "Values", dynPaiTipoTraId.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynPaiTipoTraId.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynPaiTipoTraId.getInternalname(), httpContext.getMessage( "Tipo de trabajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynPaiTipoTraId, dynPaiTipoTraId.getInternalname(), GXutil.rtrim( A1294PaiTipoTraId), 1, dynPaiTipoTraId.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynPaiTipoTraId.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_EsquemaHorasExtras.htm");
      dynPaiTipoTraId.setValue( GXutil.rtrim( A1294PaiTipoTraId) );
      httpContext.ajax_rsp_assign_prop("", false, dynPaiTipoTraId.getInternalname(), "Values", dynPaiTipoTraId.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveHsDia_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveHsDia_Internalname, httpContext.getMessage( "Límite de horas normales por día", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveHsDia_Internalname, GXutil.ltrim( localUtil.ntoc( A1323ConveHsDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveHsDia_Enabled!=0) ? localUtil.format( A1323ConveHsDia, "9.9") : localUtil.format( A1323ConveHsDia, "9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveHsDia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveHsDia_Enabled, 0, "text", "", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EsquemaHorasExtras.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveHsSem_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveHsSem_Internalname, httpContext.getMessage( "Límite de horas normales por semana", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveHsSem_Internalname, GXutil.ltrim( localUtil.ntoc( A1324ConveHsSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveHsSem_Enabled!=0) ? localUtil.format( A1324ConveHsSem, "Z9.9") : localUtil.format( A1324ConveHsSem, "Z9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveHsSem_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveHsSem_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EsquemaHorasExtras.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveHsMaxDia_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveHsMaxDia_Internalname, httpContext.getMessage( "Máximo de horas extras por día", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveHsMaxDia_Internalname, GXutil.ltrim( localUtil.ntoc( A1391ConveHsMaxDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveHsMaxDia_Enabled!=0) ? localUtil.format( A1391ConveHsMaxDia, "9.9") : localUtil.format( A1391ConveHsMaxDia, "9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveHsMaxDia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveHsMaxDia_Enabled, 0, "text", "", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EsquemaHorasExtras.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveHsMaxSem_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveHsMaxSem_Internalname, httpContext.getMessage( "Máximo de horas extras por semana", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveHsMaxSem_Internalname, GXutil.ltrim( localUtil.ntoc( A1392ConveHsMaxSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveHsMaxSem_Enabled!=0) ? localUtil.format( A1392ConveHsMaxSem, "Z9.9") : localUtil.format( A1392ConveHsMaxSem, "Z9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveHsMaxSem_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveHsMaxSem_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EsquemaHorasExtras.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveHsMaxMes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveHsMaxMes_Internalname, httpContext.getMessage( "Máximo de horas extras por mes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveHsMaxMes_Internalname, GXutil.ltrim( localUtil.ntoc( A1393ConveHsMaxMes, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveHsMaxMes_Enabled!=0) ? localUtil.format( A1393ConveHsMaxMes, "ZZ9.9") : localUtil.format( A1393ConveHsMaxMes, "ZZ9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveHsMaxMes_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveHsMaxMes_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EsquemaHorasExtras.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveHsMaxAnu_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveHsMaxAnu_Internalname, httpContext.getMessage( "Máximo de horas extras por año", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveHsMaxAnu_Internalname, GXutil.ltrim( localUtil.ntoc( A1394ConveHsMaxAnu, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveHsMaxAnu_Enabled!=0) ? localUtil.format( A1394ConveHsMaxAnu, "ZZ9.9") : localUtil.format( A1394ConveHsMaxAnu, "ZZ9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveHsMaxAnu_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveHsMaxAnu_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EsquemaHorasExtras.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EsquemaHorasExtras.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EsquemaHorasExtras.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EsquemaHorasExtras.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EsquemaHorasExtras.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, edtCliPaiConve_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_EsquemaHorasExtras.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,70);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConvenio_Visible, edtCliConvenio_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EsquemaHorasExtras.htm");
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
      e116R2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "Z1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1565CliConvenio = httpContext.cgiGet( "Z1565CliConvenio") ;
            Z1294PaiTipoTraId = httpContext.cgiGet( "Z1294PaiTipoTraId") ;
            Z1323ConveHsDia = localUtil.ctond( httpContext.cgiGet( "Z1323ConveHsDia")) ;
            Z1324ConveHsSem = localUtil.ctond( httpContext.cgiGet( "Z1324ConveHsSem")) ;
            Z1325ConveTarifaXLim = localUtil.ctond( httpContext.cgiGet( "Z1325ConveTarifaXLim")) ;
            Z1349ConveTarifaRec = localUtil.ctond( httpContext.cgiGet( "Z1349ConveTarifaRec")) ;
            Z1391ConveHsMaxDia = localUtil.ctond( httpContext.cgiGet( "Z1391ConveHsMaxDia")) ;
            Z1392ConveHsMaxSem = localUtil.ctond( httpContext.cgiGet( "Z1392ConveHsMaxSem")) ;
            Z1393ConveHsMaxMes = localUtil.ctond( httpContext.cgiGet( "Z1393ConveHsMaxMes")) ;
            Z1394ConveHsMaxAnu = localUtil.ctond( httpContext.cgiGet( "Z1394ConveHsMaxAnu")) ;
            A1325ConveTarifaXLim = localUtil.ctond( httpContext.cgiGet( "Z1325ConveTarifaXLim")) ;
            A1349ConveTarifaRec = localUtil.ctond( httpContext.cgiGet( "Z1349ConveTarifaRec")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV10PaiTipoTraId = httpContext.cgiGet( "vPAITIPOTRAID") ;
            AV35PaiTipoHsDia = localUtil.ctond( httpContext.cgiGet( "vPAITIPOHSDIA")) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV28PaiTipoHsSem = localUtil.ctond( httpContext.cgiGet( "vPAITIPOHSSEM")) ;
            AV29PaiTipoTarifaXLim = localUtil.ctond( httpContext.cgiGet( "vPAITIPOTARIFAXLIM")) ;
            A1325ConveTarifaXLim = localUtil.ctond( httpContext.cgiGet( "CONVETARIFAXLIM")) ;
            AV30PaiTipoTarifaRec = localUtil.ctond( httpContext.cgiGet( "vPAITIPOTARIFAREC")) ;
            A1349ConveTarifaRec = localUtil.ctond( httpContext.cgiGet( "CONVETARIFAREC")) ;
            AV31PaiTipoHsMaxDia = localUtil.ctond( httpContext.cgiGet( "vPAITIPOHSMAXDIA")) ;
            AV32PaiTipoHsMaxSem = localUtil.ctond( httpContext.cgiGet( "vPAITIPOHSMAXSEM")) ;
            AV33PaiTipoHsMaxMes = localUtil.ctond( httpContext.cgiGet( "vPAITIPOHSMAXMES")) ;
            AV34PaiTipoHsMaxAnu = localUtil.ctond( httpContext.cgiGet( "vPAITIPOHSMAXANU")) ;
            AV36PaiTipoTraIns = GXutil.strtobool( httpContext.cgiGet( "vPAITIPOTRAINS")) ;
            AV38Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            dynPaiTipoTraId.setValue( httpContext.cgiGet( dynPaiTipoTraId.getInternalname()) );
            A1294PaiTipoTraId = httpContext.cgiGet( dynPaiTipoTraId.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtConveHsDia_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveHsDia_Internalname)), DecimalUtil.stringToDec("9.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEHSDIA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveHsDia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1323ConveHsDia = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1323ConveHsDia", GXutil.ltrimstr( A1323ConveHsDia, 3, 1));
            }
            else
            {
               A1323ConveHsDia = localUtil.ctond( httpContext.cgiGet( edtConveHsDia_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1323ConveHsDia", GXutil.ltrimstr( A1323ConveHsDia, 3, 1));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtConveHsSem_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveHsSem_Internalname)), DecimalUtil.stringToDec("99.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEHSSEM");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveHsSem_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1324ConveHsSem = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1324ConveHsSem", GXutil.ltrimstr( A1324ConveHsSem, 4, 1));
            }
            else
            {
               A1324ConveHsSem = localUtil.ctond( httpContext.cgiGet( edtConveHsSem_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1324ConveHsSem", GXutil.ltrimstr( A1324ConveHsSem, 4, 1));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtConveHsMaxDia_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveHsMaxDia_Internalname)), DecimalUtil.stringToDec("9.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEHSMAXDIA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveHsMaxDia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1391ConveHsMaxDia = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1391ConveHsMaxDia", GXutil.ltrimstr( A1391ConveHsMaxDia, 3, 1));
            }
            else
            {
               A1391ConveHsMaxDia = localUtil.ctond( httpContext.cgiGet( edtConveHsMaxDia_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1391ConveHsMaxDia", GXutil.ltrimstr( A1391ConveHsMaxDia, 3, 1));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtConveHsMaxSem_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveHsMaxSem_Internalname)), DecimalUtil.stringToDec("99.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEHSMAXSEM");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveHsMaxSem_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1392ConveHsMaxSem = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1392ConveHsMaxSem", GXutil.ltrimstr( A1392ConveHsMaxSem, 4, 1));
            }
            else
            {
               A1392ConveHsMaxSem = localUtil.ctond( httpContext.cgiGet( edtConveHsMaxSem_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1392ConveHsMaxSem", GXutil.ltrimstr( A1392ConveHsMaxSem, 4, 1));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtConveHsMaxMes_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveHsMaxMes_Internalname)), DecimalUtil.stringToDec("999.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEHSMAXMES");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveHsMaxMes_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1393ConveHsMaxMes = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1393ConveHsMaxMes", GXutil.ltrimstr( A1393ConveHsMaxMes, 5, 1));
            }
            else
            {
               A1393ConveHsMaxMes = localUtil.ctond( httpContext.cgiGet( edtConveHsMaxMes_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1393ConveHsMaxMes", GXutil.ltrimstr( A1393ConveHsMaxMes, 5, 1));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtConveHsMaxAnu_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveHsMaxAnu_Internalname)), DecimalUtil.stringToDec("999.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEHSMAXANU");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveHsMaxAnu_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1394ConveHsMaxAnu = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1394ConveHsMaxAnu", GXutil.ltrimstr( A1394ConveHsMaxAnu, 5, 1));
            }
            else
            {
               A1394ConveHsMaxAnu = localUtil.ctond( httpContext.cgiGet( edtConveHsMaxAnu_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1394ConveHsMaxAnu", GXutil.ltrimstr( A1394ConveHsMaxAnu, 5, 1));
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
            forbiddenHiddens.add("hshsalt", "hsh"+"EsquemaHorasExtras");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, Z1294PaiTipoTraId) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("esquemahorasextras:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1294PaiTipoTraId = httpContext.GetPar( "PaiTipoTraId") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
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
                  sMode217 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode217 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound217 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_6R0( ) ;
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
                        e116R2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e126R2 ();
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
         e126R2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll6R217( ) ;
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
         disableAttributes6R217( ) ;
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

   public void confirm_6R0( )
   {
      beforeValidate6R217( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls6R217( ) ;
         }
         else
         {
            checkExtendedTable6R217( ) ;
            closeExtendedTableCursors6R217( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption6R0( )
   {
   }

   public void e116R2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      AV12IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEsquemaHorasExtras_Insert", GXv_boolean3) ;
         esquemahorasextras_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEsquemaHorasExtras_Update", GXv_boolean3) ;
         esquemahorasextras_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEsquemaHorasExtras_Delete", GXv_boolean3) ;
         esquemahorasextras_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV38Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
      edtCliConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Visible), 5, 0), true);
   }

   public void e126R2( )
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

   public void zm6R217( int GX_JID )
   {
      if ( ( GX_JID == 23 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1323ConveHsDia = T006R3_A1323ConveHsDia[0] ;
            Z1324ConveHsSem = T006R3_A1324ConveHsSem[0] ;
            Z1325ConveTarifaXLim = T006R3_A1325ConveTarifaXLim[0] ;
            Z1349ConveTarifaRec = T006R3_A1349ConveTarifaRec[0] ;
            Z1391ConveHsMaxDia = T006R3_A1391ConveHsMaxDia[0] ;
            Z1392ConveHsMaxSem = T006R3_A1392ConveHsMaxSem[0] ;
            Z1393ConveHsMaxMes = T006R3_A1393ConveHsMaxMes[0] ;
            Z1394ConveHsMaxAnu = T006R3_A1394ConveHsMaxAnu[0] ;
         }
         else
         {
            Z1323ConveHsDia = A1323ConveHsDia ;
            Z1324ConveHsSem = A1324ConveHsSem ;
            Z1325ConveTarifaXLim = A1325ConveTarifaXLim ;
            Z1349ConveTarifaRec = A1349ConveTarifaRec ;
            Z1391ConveHsMaxDia = A1391ConveHsMaxDia ;
            Z1392ConveHsMaxSem = A1392ConveHsMaxSem ;
            Z1393ConveHsMaxMes = A1393ConveHsMaxMes ;
            Z1394ConveHsMaxAnu = A1394ConveHsMaxAnu ;
         }
      }
      if ( GX_JID == -23 )
      {
         Z1323ConveHsDia = A1323ConveHsDia ;
         Z1324ConveHsSem = A1324ConveHsSem ;
         Z1325ConveTarifaXLim = A1325ConveTarifaXLim ;
         Z1349ConveTarifaRec = A1349ConveTarifaRec ;
         Z1391ConveHsMaxDia = A1391ConveHsMaxDia ;
         Z1392ConveHsMaxSem = A1392ConveHsMaxSem ;
         Z1393ConveHsMaxMes = A1393ConveHsMaxMes ;
         Z1394ConveHsMaxAnu = A1394ConveHsMaxAnu ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1294PaiTipoTraId = A1294PaiTipoTraId ;
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
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
            esquemahorasextras_impl.this.GXt_int4 = GXv_int5[0] ;
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
      if ( ! (GXutil.strcmp("", AV10PaiTipoTraId)==0) )
      {
         A1294PaiTipoTraId = AV10PaiTipoTraId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
      if ( ! (GXutil.strcmp("", AV10PaiTipoTraId)==0) )
      {
         dynPaiTipoTraId.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynPaiTipoTraId.getInternalname(), "Enabled", GXutil.ltrimstr( dynPaiTipoTraId.getEnabled(), 5, 0), true);
      }
      else
      {
         dynPaiTipoTraId.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynPaiTipoTraId.getInternalname(), "Enabled", GXutil.ltrimstr( dynPaiTipoTraId.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV10PaiTipoTraId)==0) )
      {
         dynPaiTipoTraId.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynPaiTipoTraId.getInternalname(), "Enabled", GXutil.ltrimstr( dynPaiTipoTraId.getEnabled(), 5, 0), true);
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
         AV38Pgmname = "EsquemaHorasExtras" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
      }
   }

   public void load6R217( )
   {
      /* Using cursor T006R6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1294PaiTipoTraId});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound217 = (short)(1) ;
         A1323ConveHsDia = T006R6_A1323ConveHsDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1323ConveHsDia", GXutil.ltrimstr( A1323ConveHsDia, 3, 1));
         A1324ConveHsSem = T006R6_A1324ConveHsSem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1324ConveHsSem", GXutil.ltrimstr( A1324ConveHsSem, 4, 1));
         A1325ConveTarifaXLim = T006R6_A1325ConveTarifaXLim[0] ;
         A1349ConveTarifaRec = T006R6_A1349ConveTarifaRec[0] ;
         A1391ConveHsMaxDia = T006R6_A1391ConveHsMaxDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1391ConveHsMaxDia", GXutil.ltrimstr( A1391ConveHsMaxDia, 3, 1));
         A1392ConveHsMaxSem = T006R6_A1392ConveHsMaxSem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1392ConveHsMaxSem", GXutil.ltrimstr( A1392ConveHsMaxSem, 4, 1));
         A1393ConveHsMaxMes = T006R6_A1393ConveHsMaxMes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1393ConveHsMaxMes", GXutil.ltrimstr( A1393ConveHsMaxMes, 5, 1));
         A1394ConveHsMaxAnu = T006R6_A1394ConveHsMaxAnu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1394ConveHsMaxAnu", GXutil.ltrimstr( A1394ConveHsMaxAnu, 5, 1));
         zm6R217( -23) ;
      }
      pr_default.close(4);
      onLoadActions6R217( ) ;
   }

   public void onLoadActions6R217( )
   {
      AV38Pgmname = "EsquemaHorasExtras" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1323ConveHsDia)==0) && ( Gx_BScreen == 0 ) )
      {
         A1323ConveHsDia = AV35PaiTipoHsDia ;
         httpContext.ajax_rsp_assign_attri("", false, "A1323ConveHsDia", GXutil.ltrimstr( A1323ConveHsDia, 3, 1));
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1324ConveHsSem)==0) && ( Gx_BScreen == 0 ) )
      {
         A1324ConveHsSem = AV28PaiTipoHsSem ;
         httpContext.ajax_rsp_assign_attri("", false, "A1324ConveHsSem", GXutil.ltrimstr( A1324ConveHsSem, 4, 1));
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1325ConveTarifaXLim)==0) && ( Gx_BScreen == 0 ) )
      {
         A1325ConveTarifaXLim = AV29PaiTipoTarifaXLim ;
         httpContext.ajax_rsp_assign_attri("", false, "A1325ConveTarifaXLim", GXutil.ltrimstr( A1325ConveTarifaXLim, 6, 4));
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1349ConveTarifaRec)==0) && ( Gx_BScreen == 0 ) )
      {
         A1349ConveTarifaRec = AV30PaiTipoTarifaRec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1349ConveTarifaRec", GXutil.ltrimstr( A1349ConveTarifaRec, 6, 4));
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1391ConveHsMaxDia)==0) && ( Gx_BScreen == 0 ) )
      {
         A1391ConveHsMaxDia = AV31PaiTipoHsMaxDia ;
         httpContext.ajax_rsp_assign_attri("", false, "A1391ConveHsMaxDia", GXutil.ltrimstr( A1391ConveHsMaxDia, 3, 1));
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1392ConveHsMaxSem)==0) && ( Gx_BScreen == 0 ) )
      {
         A1392ConveHsMaxSem = AV32PaiTipoHsMaxSem ;
         httpContext.ajax_rsp_assign_attri("", false, "A1392ConveHsMaxSem", GXutil.ltrimstr( A1392ConveHsMaxSem, 4, 1));
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1393ConveHsMaxMes)==0) && ( Gx_BScreen == 0 ) )
      {
         A1393ConveHsMaxMes = AV33PaiTipoHsMaxMes ;
         httpContext.ajax_rsp_assign_attri("", false, "A1393ConveHsMaxMes", GXutil.ltrimstr( A1393ConveHsMaxMes, 5, 1));
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1394ConveHsMaxAnu)==0) && ( Gx_BScreen == 0 ) )
      {
         A1394ConveHsMaxAnu = AV34PaiTipoHsMaxAnu ;
         httpContext.ajax_rsp_assign_attri("", false, "A1394ConveHsMaxAnu", GXutil.ltrimstr( A1394ConveHsMaxAnu, 5, 1));
      }
   }

   public void checkExtendedTable6R217( )
   {
      nIsDirty_217 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV38Pgmname = "EsquemaHorasExtras" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
      /* Using cursor T006R5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      /* Using cursor T006R4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A1564CliPaiConve), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais Tipo Trabajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAITIPOTRAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliPaiConve_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A1294PaiTipoTraId, "diurno") == 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, "nocturno") == 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de Trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAITIPOTRAID");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPaiTipoTraId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GXv_boolean3[0] = AV36PaiTipoTraIns ;
      GXv_decimal6[0] = AV35PaiTipoHsDia ;
      GXv_decimal7[0] = AV28PaiTipoHsSem ;
      GXv_decimal8[0] = AV29PaiTipoTarifaXLim ;
      GXv_decimal9[0] = AV30PaiTipoTarifaRec ;
      GXv_decimal10[0] = AV31PaiTipoHsMaxDia ;
      GXv_decimal11[0] = AV32PaiTipoHsMaxSem ;
      GXv_decimal12[0] = AV33PaiTipoHsMaxMes ;
      GXv_decimal13[0] = AV34PaiTipoHsMaxAnu ;
      new web.getpaitipotra(remoteHandle, context).execute( AV8CliPaiConve, A1294PaiTipoTraId, GXv_boolean3, GXv_decimal6, GXv_decimal7, GXv_decimal8, GXv_decimal9, GXv_decimal10, GXv_decimal11, GXv_decimal12, GXv_decimal13) ;
      esquemahorasextras_impl.this.AV36PaiTipoTraIns = GXv_boolean3[0] ;
      esquemahorasextras_impl.this.AV35PaiTipoHsDia = GXv_decimal6[0] ;
      esquemahorasextras_impl.this.AV28PaiTipoHsSem = GXv_decimal7[0] ;
      esquemahorasextras_impl.this.AV29PaiTipoTarifaXLim = GXv_decimal8[0] ;
      esquemahorasextras_impl.this.AV30PaiTipoTarifaRec = GXv_decimal9[0] ;
      esquemahorasextras_impl.this.AV31PaiTipoHsMaxDia = GXv_decimal10[0] ;
      esquemahorasextras_impl.this.AV32PaiTipoHsMaxSem = GXv_decimal11[0] ;
      esquemahorasextras_impl.this.AV33PaiTipoHsMaxMes = GXv_decimal12[0] ;
      esquemahorasextras_impl.this.AV34PaiTipoHsMaxAnu = GXv_decimal13[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36PaiTipoTraIns", AV36PaiTipoTraIns);
      httpContext.ajax_rsp_assign_attri("", false, "AV35PaiTipoHsDia", GXutil.ltrimstr( AV35PaiTipoHsDia, 3, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV28PaiTipoHsSem", GXutil.ltrimstr( AV28PaiTipoHsSem, 4, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV29PaiTipoTarifaXLim", GXutil.ltrimstr( AV29PaiTipoTarifaXLim, 6, 4));
      httpContext.ajax_rsp_assign_attri("", false, "AV30PaiTipoTarifaRec", GXutil.ltrimstr( AV30PaiTipoTarifaRec, 6, 4));
      httpContext.ajax_rsp_assign_attri("", false, "AV31PaiTipoHsMaxDia", GXutil.ltrimstr( AV31PaiTipoHsMaxDia, 3, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV32PaiTipoHsMaxSem", GXutil.ltrimstr( AV32PaiTipoHsMaxSem, 4, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV33PaiTipoHsMaxMes", GXutil.ltrimstr( AV33PaiTipoHsMaxMes, 5, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV34PaiTipoHsMaxAnu", GXutil.ltrimstr( AV34PaiTipoHsMaxAnu, 5, 1));
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1323ConveHsDia)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_217 = (short)(1) ;
         A1323ConveHsDia = AV35PaiTipoHsDia ;
         httpContext.ajax_rsp_assign_attri("", false, "A1323ConveHsDia", GXutil.ltrimstr( A1323ConveHsDia, 3, 1));
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1324ConveHsSem)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_217 = (short)(1) ;
         A1324ConveHsSem = AV28PaiTipoHsSem ;
         httpContext.ajax_rsp_assign_attri("", false, "A1324ConveHsSem", GXutil.ltrimstr( A1324ConveHsSem, 4, 1));
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1325ConveTarifaXLim)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_217 = (short)(1) ;
         A1325ConveTarifaXLim = AV29PaiTipoTarifaXLim ;
         httpContext.ajax_rsp_assign_attri("", false, "A1325ConveTarifaXLim", GXutil.ltrimstr( A1325ConveTarifaXLim, 6, 4));
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1349ConveTarifaRec)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_217 = (short)(1) ;
         A1349ConveTarifaRec = AV30PaiTipoTarifaRec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1349ConveTarifaRec", GXutil.ltrimstr( A1349ConveTarifaRec, 6, 4));
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1391ConveHsMaxDia)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_217 = (short)(1) ;
         A1391ConveHsMaxDia = AV31PaiTipoHsMaxDia ;
         httpContext.ajax_rsp_assign_attri("", false, "A1391ConveHsMaxDia", GXutil.ltrimstr( A1391ConveHsMaxDia, 3, 1));
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1392ConveHsMaxSem)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_217 = (short)(1) ;
         A1392ConveHsMaxSem = AV32PaiTipoHsMaxSem ;
         httpContext.ajax_rsp_assign_attri("", false, "A1392ConveHsMaxSem", GXutil.ltrimstr( A1392ConveHsMaxSem, 4, 1));
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1393ConveHsMaxMes)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_217 = (short)(1) ;
         A1393ConveHsMaxMes = AV33PaiTipoHsMaxMes ;
         httpContext.ajax_rsp_assign_attri("", false, "A1393ConveHsMaxMes", GXutil.ltrimstr( A1393ConveHsMaxMes, 5, 1));
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1394ConveHsMaxAnu)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_217 = (short)(1) ;
         A1394ConveHsMaxAnu = AV34PaiTipoHsMaxAnu ;
         httpContext.ajax_rsp_assign_attri("", false, "A1394ConveHsMaxAnu", GXutil.ltrimstr( A1394ConveHsMaxAnu, 5, 1));
      }
   }

   public void closeExtendedTableCursors6R217( )
   {
      pr_default.close(3);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_25( int A3CliCod ,
                          short A1564CliPaiConve ,
                          String A1565CliConvenio )
   {
      /* Using cursor T006R7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
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

   public void gxload_24( short A1564CliPaiConve ,
                          String A1294PaiTipoTraId )
   {
      /* Using cursor T006R8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A1564CliPaiConve), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais Tipo Trabajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAITIPOTRAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliPaiConve_Internalname ;
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

   public void getKey6R217( )
   {
      /* Using cursor T006R9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1294PaiTipoTraId});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound217 = (short)(1) ;
      }
      else
      {
         RcdFound217 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T006R3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1294PaiTipoTraId});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm6R217( 23) ;
         RcdFound217 = (short)(1) ;
         A1323ConveHsDia = T006R3_A1323ConveHsDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1323ConveHsDia", GXutil.ltrimstr( A1323ConveHsDia, 3, 1));
         A1324ConveHsSem = T006R3_A1324ConveHsSem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1324ConveHsSem", GXutil.ltrimstr( A1324ConveHsSem, 4, 1));
         A1325ConveTarifaXLim = T006R3_A1325ConveTarifaXLim[0] ;
         A1349ConveTarifaRec = T006R3_A1349ConveTarifaRec[0] ;
         A1391ConveHsMaxDia = T006R3_A1391ConveHsMaxDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1391ConveHsMaxDia", GXutil.ltrimstr( A1391ConveHsMaxDia, 3, 1));
         A1392ConveHsMaxSem = T006R3_A1392ConveHsMaxSem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1392ConveHsMaxSem", GXutil.ltrimstr( A1392ConveHsMaxSem, 4, 1));
         A1393ConveHsMaxMes = T006R3_A1393ConveHsMaxMes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1393ConveHsMaxMes", GXutil.ltrimstr( A1393ConveHsMaxMes, 5, 1));
         A1394ConveHsMaxAnu = T006R3_A1394ConveHsMaxAnu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1394ConveHsMaxAnu", GXutil.ltrimstr( A1394ConveHsMaxAnu, 5, 1));
         A1564CliPaiConve = T006R3_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1294PaiTipoTraId = T006R3_A1294PaiTipoTraId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
         A3CliCod = T006R3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1565CliConvenio = T006R3_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1294PaiTipoTraId = A1294PaiTipoTraId ;
         sMode217 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load6R217( ) ;
         if ( AnyError == 1 )
         {
            RcdFound217 = (short)(0) ;
            initializeNonKey6R217( ) ;
         }
         Gx_mode = sMode217 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound217 = (short)(0) ;
         initializeNonKey6R217( ) ;
         sMode217 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode217 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey6R217( ) ;
      if ( RcdFound217 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound217 = (short)(0) ;
      /* Using cursor T006R10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), A1294PaiTipoTraId, A1294PaiTipoTraId, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A1294PaiTipoTraId, Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T006R10_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T006R10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(T006R10_A1294PaiTipoTraId[0], A1294PaiTipoTraId) < 0 ) || ( GXutil.strcmp(T006R10_A1294PaiTipoTraId[0], A1294PaiTipoTraId) == 0 ) && ( T006R10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006R10_A3CliCod[0] < A3CliCod ) || ( T006R10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006R10_A1294PaiTipoTraId[0], A1294PaiTipoTraId) == 0 ) && ( T006R10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(T006R10_A1565CliConvenio[0], A1565CliConvenio) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T006R10_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T006R10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(T006R10_A1294PaiTipoTraId[0], A1294PaiTipoTraId) > 0 ) || ( GXutil.strcmp(T006R10_A1294PaiTipoTraId[0], A1294PaiTipoTraId) == 0 ) && ( T006R10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006R10_A3CliCod[0] > A3CliCod ) || ( T006R10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006R10_A1294PaiTipoTraId[0], A1294PaiTipoTraId) == 0 ) && ( T006R10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(T006R10_A1565CliConvenio[0], A1565CliConvenio) > 0 ) ) )
         {
            A1564CliPaiConve = T006R10_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1294PaiTipoTraId = T006R10_A1294PaiTipoTraId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
            A3CliCod = T006R10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1565CliConvenio = T006R10_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            RcdFound217 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound217 = (short)(0) ;
      /* Using cursor T006R11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), A1294PaiTipoTraId, A1294PaiTipoTraId, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A1294PaiTipoTraId, Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T006R11_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T006R11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(T006R11_A1294PaiTipoTraId[0], A1294PaiTipoTraId) > 0 ) || ( GXutil.strcmp(T006R11_A1294PaiTipoTraId[0], A1294PaiTipoTraId) == 0 ) && ( T006R11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006R11_A3CliCod[0] > A3CliCod ) || ( T006R11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006R11_A1294PaiTipoTraId[0], A1294PaiTipoTraId) == 0 ) && ( T006R11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(T006R11_A1565CliConvenio[0], A1565CliConvenio) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T006R11_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T006R11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(T006R11_A1294PaiTipoTraId[0], A1294PaiTipoTraId) < 0 ) || ( GXutil.strcmp(T006R11_A1294PaiTipoTraId[0], A1294PaiTipoTraId) == 0 ) && ( T006R11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006R11_A3CliCod[0] < A3CliCod ) || ( T006R11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006R11_A1294PaiTipoTraId[0], A1294PaiTipoTraId) == 0 ) && ( T006R11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(T006R11_A1565CliConvenio[0], A1565CliConvenio) < 0 ) ) )
         {
            A1564CliPaiConve = T006R11_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1294PaiTipoTraId = T006R11_A1294PaiTipoTraId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
            A3CliCod = T006R11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1565CliConvenio = T006R11_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            RcdFound217 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey6R217( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = dynPaiTipoTraId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert6R217( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound217 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, Z1294PaiTipoTraId) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A1294PaiTipoTraId = Z1294PaiTipoTraId ;
               httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = dynPaiTipoTraId.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update6R217( ) ;
               GX_FocusControl = dynPaiTipoTraId.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, Z1294PaiTipoTraId) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = dynPaiTipoTraId.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert6R217( ) ;
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
                  GX_FocusControl = dynPaiTipoTraId.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert6R217( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, Z1294PaiTipoTraId) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1294PaiTipoTraId = Z1294PaiTipoTraId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = dynPaiTipoTraId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency6R217( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T006R2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1294PaiTipoTraId});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_tiposdetrabajo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z1323ConveHsDia, T006R2_A1323ConveHsDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1324ConveHsSem, T006R2_A1324ConveHsSem[0]) != 0 ) || ( DecimalUtil.compareTo(Z1325ConveTarifaXLim, T006R2_A1325ConveTarifaXLim[0]) != 0 ) || ( DecimalUtil.compareTo(Z1349ConveTarifaRec, T006R2_A1349ConveTarifaRec[0]) != 0 ) || ( DecimalUtil.compareTo(Z1391ConveHsMaxDia, T006R2_A1391ConveHsMaxDia[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1392ConveHsMaxSem, T006R2_A1392ConveHsMaxSem[0]) != 0 ) || ( DecimalUtil.compareTo(Z1393ConveHsMaxMes, T006R2_A1393ConveHsMaxMes[0]) != 0 ) || ( DecimalUtil.compareTo(Z1394ConveHsMaxAnu, T006R2_A1394ConveHsMaxAnu[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z1323ConveHsDia, T006R2_A1323ConveHsDia[0]) != 0 )
            {
               GXutil.writeLogln("esquemahorasextras:[seudo value changed for attri]"+"ConveHsDia");
               GXutil.writeLogRaw("Old: ",Z1323ConveHsDia);
               GXutil.writeLogRaw("Current: ",T006R2_A1323ConveHsDia[0]);
            }
            if ( DecimalUtil.compareTo(Z1324ConveHsSem, T006R2_A1324ConveHsSem[0]) != 0 )
            {
               GXutil.writeLogln("esquemahorasextras:[seudo value changed for attri]"+"ConveHsSem");
               GXutil.writeLogRaw("Old: ",Z1324ConveHsSem);
               GXutil.writeLogRaw("Current: ",T006R2_A1324ConveHsSem[0]);
            }
            if ( DecimalUtil.compareTo(Z1325ConveTarifaXLim, T006R2_A1325ConveTarifaXLim[0]) != 0 )
            {
               GXutil.writeLogln("esquemahorasextras:[seudo value changed for attri]"+"ConveTarifaXLim");
               GXutil.writeLogRaw("Old: ",Z1325ConveTarifaXLim);
               GXutil.writeLogRaw("Current: ",T006R2_A1325ConveTarifaXLim[0]);
            }
            if ( DecimalUtil.compareTo(Z1349ConveTarifaRec, T006R2_A1349ConveTarifaRec[0]) != 0 )
            {
               GXutil.writeLogln("esquemahorasextras:[seudo value changed for attri]"+"ConveTarifaRec");
               GXutil.writeLogRaw("Old: ",Z1349ConveTarifaRec);
               GXutil.writeLogRaw("Current: ",T006R2_A1349ConveTarifaRec[0]);
            }
            if ( DecimalUtil.compareTo(Z1391ConveHsMaxDia, T006R2_A1391ConveHsMaxDia[0]) != 0 )
            {
               GXutil.writeLogln("esquemahorasextras:[seudo value changed for attri]"+"ConveHsMaxDia");
               GXutil.writeLogRaw("Old: ",Z1391ConveHsMaxDia);
               GXutil.writeLogRaw("Current: ",T006R2_A1391ConveHsMaxDia[0]);
            }
            if ( DecimalUtil.compareTo(Z1392ConveHsMaxSem, T006R2_A1392ConveHsMaxSem[0]) != 0 )
            {
               GXutil.writeLogln("esquemahorasextras:[seudo value changed for attri]"+"ConveHsMaxSem");
               GXutil.writeLogRaw("Old: ",Z1392ConveHsMaxSem);
               GXutil.writeLogRaw("Current: ",T006R2_A1392ConveHsMaxSem[0]);
            }
            if ( DecimalUtil.compareTo(Z1393ConveHsMaxMes, T006R2_A1393ConveHsMaxMes[0]) != 0 )
            {
               GXutil.writeLogln("esquemahorasextras:[seudo value changed for attri]"+"ConveHsMaxMes");
               GXutil.writeLogRaw("Old: ",Z1393ConveHsMaxMes);
               GXutil.writeLogRaw("Current: ",T006R2_A1393ConveHsMaxMes[0]);
            }
            if ( DecimalUtil.compareTo(Z1394ConveHsMaxAnu, T006R2_A1394ConveHsMaxAnu[0]) != 0 )
            {
               GXutil.writeLogln("esquemahorasextras:[seudo value changed for attri]"+"ConveHsMaxAnu");
               GXutil.writeLogRaw("Old: ",Z1394ConveHsMaxAnu);
               GXutil.writeLogRaw("Current: ",T006R2_A1394ConveHsMaxAnu[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"convenio_tiposdetrabajo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert6R217( )
   {
      beforeValidate6R217( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6R217( ) ;
      }
      if ( AnyError == 0 )
      {
         zm6R217( 0) ;
         checkOptimisticConcurrency6R217( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6R217( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert6R217( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006R12 */
                  pr_default.execute(10, new Object[] {A1323ConveHsDia, A1324ConveHsSem, A1325ConveTarifaXLim, A1349ConveTarifaRec, A1391ConveHsMaxDia, A1392ConveHsMaxSem, A1393ConveHsMaxMes, A1394ConveHsMaxAnu, Short.valueOf(A1564CliPaiConve), A1294PaiTipoTraId, Integer.valueOf(A3CliCod), A1565CliConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_tiposdetrabajo");
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
                        resetCaption6R0( ) ;
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
            load6R217( ) ;
         }
         endLevel6R217( ) ;
      }
      closeExtendedTableCursors6R217( ) ;
   }

   public void update6R217( )
   {
      beforeValidate6R217( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6R217( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6R217( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6R217( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate6R217( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006R13 */
                  pr_default.execute(11, new Object[] {A1323ConveHsDia, A1324ConveHsSem, A1325ConveTarifaXLim, A1349ConveTarifaRec, A1391ConveHsMaxDia, A1392ConveHsMaxSem, A1393ConveHsMaxMes, A1394ConveHsMaxAnu, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1294PaiTipoTraId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_tiposdetrabajo");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_tiposdetrabajo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate6R217( ) ;
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
         endLevel6R217( ) ;
      }
      closeExtendedTableCursors6R217( ) ;
   }

   public void deferredUpdate6R217( )
   {
   }

   public void delete( )
   {
      beforeValidate6R217( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6R217( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls6R217( ) ;
         afterConfirm6R217( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete6R217( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T006R14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1294PaiTipoTraId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_tiposdetrabajo");
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
      sMode217 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel6R217( ) ;
      Gx_mode = sMode217 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls6R217( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV38Pgmname = "EsquemaHorasExtras" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T006R15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1294PaiTipoTraId});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Convenio_horasextras_por Dia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void endLevel6R217( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete6R217( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "esquemahorasextras");
         if ( AnyError == 0 )
         {
            confirmValues6R0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "esquemahorasextras");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart6R217( )
   {
      /* Scan By routine */
      /* Using cursor T006R16 */
      pr_default.execute(14);
      RcdFound217 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound217 = (short)(1) ;
         A3CliCod = T006R16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T006R16_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T006R16_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1294PaiTipoTraId = T006R16_A1294PaiTipoTraId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext6R217( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound217 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound217 = (short)(1) ;
         A3CliCod = T006R16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T006R16_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T006R16_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1294PaiTipoTraId = T006R16_A1294PaiTipoTraId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
   }

   public void scanEnd6R217( )
   {
      pr_default.close(14);
   }

   public void afterConfirm6R217( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert6R217( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate6R217( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete6R217( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete6R217( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate6R217( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes6R217( )
   {
      dynPaiTipoTraId.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynPaiTipoTraId.getInternalname(), "Enabled", GXutil.ltrimstr( dynPaiTipoTraId.getEnabled(), 5, 0), true);
      edtConveHsDia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsDia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsDia_Enabled), 5, 0), true);
      edtConveHsSem_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsSem_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsSem_Enabled), 5, 0), true);
      edtConveHsMaxDia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsMaxDia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsMaxDia_Enabled), 5, 0), true);
      edtConveHsMaxSem_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsMaxSem_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsMaxSem_Enabled), 5, 0), true);
      edtConveHsMaxMes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsMaxMes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsMaxMes_Enabled), 5, 0), true);
      edtConveHsMaxAnu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsMaxAnu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsMaxAnu_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliPaiConve_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      edtCliConvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes6R217( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues6R0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.esquemahorasextras", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV10PaiTipoTraId))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","PaiTipoTraId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"EsquemaHorasExtras");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("esquemahorasextras:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1564CliPaiConve", GXutil.ltrim( localUtil.ntoc( Z1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1565CliConvenio", GXutil.rtrim( Z1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1294PaiTipoTraId", GXutil.rtrim( Z1294PaiTipoTraId));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1323ConveHsDia", GXutil.ltrim( localUtil.ntoc( Z1323ConveHsDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1324ConveHsSem", GXutil.ltrim( localUtil.ntoc( Z1324ConveHsSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1325ConveTarifaXLim", GXutil.ltrim( localUtil.ntoc( Z1325ConveTarifaXLim, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1349ConveTarifaRec", GXutil.ltrim( localUtil.ntoc( Z1349ConveTarifaRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1391ConveHsMaxDia", GXutil.ltrim( localUtil.ntoc( Z1391ConveHsMaxDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1392ConveHsMaxSem", GXutil.ltrim( localUtil.ntoc( Z1392ConveHsMaxSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1393ConveHsMaxMes", GXutil.ltrim( localUtil.ntoc( Z1393ConveHsMaxMes, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1394ConveHsMaxAnu", GXutil.ltrim( localUtil.ntoc( Z1394ConveHsMaxAnu, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV8CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV9CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAITIPOTRAID", GXutil.rtrim( AV10PaiTipoTraId));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAITIPOTRAID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10PaiTipoTraId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAITIPOHSDIA", GXutil.ltrim( localUtil.ntoc( AV35PaiTipoHsDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAITIPOHSSEM", GXutil.ltrim( localUtil.ntoc( AV28PaiTipoHsSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAITIPOTARIFAXLIM", GXutil.ltrim( localUtil.ntoc( AV29PaiTipoTarifaXLim, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVETARIFAXLIM", GXutil.ltrim( localUtil.ntoc( A1325ConveTarifaXLim, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAITIPOTARIFAREC", GXutil.ltrim( localUtil.ntoc( AV30PaiTipoTarifaRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVETARIFAREC", GXutil.ltrim( localUtil.ntoc( A1349ConveTarifaRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAITIPOHSMAXDIA", GXutil.ltrim( localUtil.ntoc( AV31PaiTipoHsMaxDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAITIPOHSMAXSEM", GXutil.ltrim( localUtil.ntoc( AV32PaiTipoHsMaxSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAITIPOHSMAXMES", GXutil.ltrim( localUtil.ntoc( AV33PaiTipoHsMaxMes, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAITIPOHSMAXANU", GXutil.ltrim( localUtil.ntoc( AV34PaiTipoHsMaxAnu, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vPAITIPOTRAINS", AV36PaiTipoTraIns);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV38Pgmname));
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
      return formatLink("web.esquemahorasextras", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV10PaiTipoTraId))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","PaiTipoTraId"})  ;
   }

   public String getPgmname( )
   {
      return "EsquemaHorasExtras" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Esquema Horas Extras", "") ;
   }

   public void initializeNonKey6R217( )
   {
      A46PaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      AV36PaiTipoTraIns = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36PaiTipoTraIns", AV36PaiTipoTraIns);
      AV35PaiTipoHsDia = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35PaiTipoHsDia", GXutil.ltrimstr( AV35PaiTipoHsDia, 3, 1));
      AV28PaiTipoHsSem = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28PaiTipoHsSem", GXutil.ltrimstr( AV28PaiTipoHsSem, 4, 1));
      AV29PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29PaiTipoTarifaXLim", GXutil.ltrimstr( AV29PaiTipoTarifaXLim, 6, 4));
      AV30PaiTipoTarifaRec = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30PaiTipoTarifaRec", GXutil.ltrimstr( AV30PaiTipoTarifaRec, 6, 4));
      AV31PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31PaiTipoHsMaxDia", GXutil.ltrimstr( AV31PaiTipoHsMaxDia, 3, 1));
      AV32PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32PaiTipoHsMaxSem", GXutil.ltrimstr( AV32PaiTipoHsMaxSem, 4, 1));
      AV33PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33PaiTipoHsMaxMes", GXutil.ltrimstr( AV33PaiTipoHsMaxMes, 5, 1));
      AV34PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34PaiTipoHsMaxAnu", GXutil.ltrimstr( AV34PaiTipoHsMaxAnu, 5, 1));
      A1323ConveHsDia = AV35PaiTipoHsDia ;
      httpContext.ajax_rsp_assign_attri("", false, "A1323ConveHsDia", GXutil.ltrimstr( A1323ConveHsDia, 3, 1));
      A1324ConveHsSem = AV28PaiTipoHsSem ;
      httpContext.ajax_rsp_assign_attri("", false, "A1324ConveHsSem", GXutil.ltrimstr( A1324ConveHsSem, 4, 1));
      A1325ConveTarifaXLim = AV29PaiTipoTarifaXLim ;
      httpContext.ajax_rsp_assign_attri("", false, "A1325ConveTarifaXLim", GXutil.ltrimstr( A1325ConveTarifaXLim, 6, 4));
      A1349ConveTarifaRec = AV30PaiTipoTarifaRec ;
      httpContext.ajax_rsp_assign_attri("", false, "A1349ConveTarifaRec", GXutil.ltrimstr( A1349ConveTarifaRec, 6, 4));
      A1391ConveHsMaxDia = AV31PaiTipoHsMaxDia ;
      httpContext.ajax_rsp_assign_attri("", false, "A1391ConveHsMaxDia", GXutil.ltrimstr( A1391ConveHsMaxDia, 3, 1));
      A1392ConveHsMaxSem = AV32PaiTipoHsMaxSem ;
      httpContext.ajax_rsp_assign_attri("", false, "A1392ConveHsMaxSem", GXutil.ltrimstr( A1392ConveHsMaxSem, 4, 1));
      A1393ConveHsMaxMes = AV33PaiTipoHsMaxMes ;
      httpContext.ajax_rsp_assign_attri("", false, "A1393ConveHsMaxMes", GXutil.ltrimstr( A1393ConveHsMaxMes, 5, 1));
      A1394ConveHsMaxAnu = AV34PaiTipoHsMaxAnu ;
      httpContext.ajax_rsp_assign_attri("", false, "A1394ConveHsMaxAnu", GXutil.ltrimstr( A1394ConveHsMaxAnu, 5, 1));
      Z1323ConveHsDia = DecimalUtil.ZERO ;
      Z1324ConveHsSem = DecimalUtil.ZERO ;
      Z1325ConveTarifaXLim = DecimalUtil.ZERO ;
      Z1349ConveTarifaRec = DecimalUtil.ZERO ;
      Z1391ConveHsMaxDia = DecimalUtil.ZERO ;
      Z1392ConveHsMaxSem = DecimalUtil.ZERO ;
      Z1393ConveHsMaxMes = DecimalUtil.ZERO ;
      Z1394ConveHsMaxAnu = DecimalUtil.ZERO ;
   }

   public void initAll6R217( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      A1294PaiTipoTraId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      initializeNonKey6R217( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202519851655", true, true);
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
      httpContext.AddJavascriptSource("esquemahorasextras.js", "?202519851655", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynPaiTipoTraId.setInternalname( "PAITIPOTRAID" );
      edtConveHsDia_Internalname = "CONVEHSDIA" ;
      edtConveHsSem_Internalname = "CONVEHSSEM" ;
      edtConveHsMaxDia_Internalname = "CONVEHSMAXDIA" ;
      edtConveHsMaxSem_Internalname = "CONVEHSMAXSEM" ;
      edtConveHsMaxMes_Internalname = "CONVEHSMAXMES" ;
      edtConveHsMaxAnu_Internalname = "CONVEHSMAXANU" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      Form.setCaption( httpContext.getMessage( "Esquema Horas Extras", "") );
      edtCliConvenio_Jsonclick = "" ;
      edtCliConvenio_Enabled = 1 ;
      edtCliConvenio_Visible = 1 ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Enabled = 1 ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtConveHsMaxAnu_Jsonclick = "" ;
      edtConveHsMaxAnu_Enabled = 1 ;
      edtConveHsMaxMes_Jsonclick = "" ;
      edtConveHsMaxMes_Enabled = 1 ;
      edtConveHsMaxSem_Jsonclick = "" ;
      edtConveHsMaxSem_Enabled = 1 ;
      edtConveHsMaxDia_Jsonclick = "" ;
      edtConveHsMaxDia_Enabled = 1 ;
      edtConveHsSem_Jsonclick = "" ;
      edtConveHsSem_Enabled = 1 ;
      edtConveHsDia_Jsonclick = "" ;
      edtConveHsDia_Enabled = 1 ;
      dynPaiTipoTraId.setJsonclick( "" );
      dynPaiTipoTraId.setEnabled( 1 );
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

   public void gxdlapaitipotraid6R1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlapaitipotraid_data6R1( ) ;
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

   public void gxapaitipotraid_html6R1( )
   {
      String gxdynajaxvalue;
      gxdlapaitipotraid_data6R1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynPaiTipoTraId.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynPaiTipoTraId.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlapaitipotraid_data6R1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T006R17 */
      pr_default.execute(15);
      while ( (pr_default.getStatus(15) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T006R17_A1292TipoTraId[0]));
         gxdynajaxctrldescr.add(T006R17_A1293TipoTraNom[0]);
         pr_default.readNext(15);
      }
      pr_default.close(15);
   }

   public void gx2asaclicod6R217( int AV7CliCod )
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
            esquemahorasextras_impl.this.GXt_int4 = GXv_int5[0] ;
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

   public void xc_22_6R217( short AV8CliPaiConve ,
                            String A1294PaiTipoTraId )
   {
      GXv_boolean3[0] = AV36PaiTipoTraIns ;
      GXv_decimal13[0] = AV35PaiTipoHsDia ;
      GXv_decimal12[0] = AV28PaiTipoHsSem ;
      GXv_decimal11[0] = AV29PaiTipoTarifaXLim ;
      GXv_decimal10[0] = AV30PaiTipoTarifaRec ;
      GXv_decimal9[0] = AV31PaiTipoHsMaxDia ;
      GXv_decimal8[0] = AV32PaiTipoHsMaxSem ;
      GXv_decimal7[0] = AV33PaiTipoHsMaxMes ;
      GXv_decimal6[0] = AV34PaiTipoHsMaxAnu ;
      new web.getpaitipotra(remoteHandle, context).execute( AV8CliPaiConve, A1294PaiTipoTraId, GXv_boolean3, GXv_decimal13, GXv_decimal12, GXv_decimal11, GXv_decimal10, GXv_decimal9, GXv_decimal8, GXv_decimal7, GXv_decimal6) ;
      AV36PaiTipoTraIns = GXv_boolean3[0] ;
      AV35PaiTipoHsDia = GXv_decimal13[0] ;
      AV28PaiTipoHsSem = GXv_decimal12[0] ;
      AV29PaiTipoTarifaXLim = GXv_decimal11[0] ;
      AV30PaiTipoTarifaRec = GXv_decimal10[0] ;
      AV31PaiTipoHsMaxDia = GXv_decimal9[0] ;
      AV32PaiTipoHsMaxSem = GXv_decimal8[0] ;
      AV33PaiTipoHsMaxMes = GXv_decimal7[0] ;
      AV34PaiTipoHsMaxAnu = GXv_decimal6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36PaiTipoTraIns", AV36PaiTipoTraIns);
      httpContext.ajax_rsp_assign_attri("", false, "AV35PaiTipoHsDia", GXutil.ltrimstr( AV35PaiTipoHsDia, 3, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV28PaiTipoHsSem", GXutil.ltrimstr( AV28PaiTipoHsSem, 4, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV29PaiTipoTarifaXLim", GXutil.ltrimstr( AV29PaiTipoTarifaXLim, 6, 4));
      httpContext.ajax_rsp_assign_attri("", false, "AV30PaiTipoTarifaRec", GXutil.ltrimstr( AV30PaiTipoTarifaRec, 6, 4));
      httpContext.ajax_rsp_assign_attri("", false, "AV31PaiTipoHsMaxDia", GXutil.ltrimstr( AV31PaiTipoHsMaxDia, 3, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV32PaiTipoHsMaxSem", GXutil.ltrimstr( AV32PaiTipoHsMaxSem, 4, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV33PaiTipoHsMaxMes", GXutil.ltrimstr( AV33PaiTipoHsMaxMes, 5, 1));
      httpContext.ajax_rsp_assign_attri("", false, "AV34PaiTipoHsMaxAnu", GXutil.ltrimstr( AV34PaiTipoHsMaxAnu, 5, 1));
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV36PaiTipoTraIns))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV35PaiTipoHsDia, (byte)(3), (byte)(1), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV28PaiTipoHsSem, (byte)(4), (byte)(1), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV29PaiTipoTarifaXLim, (byte)(6), (byte)(4), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV30PaiTipoTarifaRec, (byte)(6), (byte)(4), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV31PaiTipoHsMaxDia, (byte)(3), (byte)(1), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV32PaiTipoHsMaxSem, (byte)(4), (byte)(1), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV33PaiTipoHsMaxMes, (byte)(5), (byte)(1), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV34PaiTipoHsMaxAnu, (byte)(5), (byte)(1), ".", "")))+"\"") ;
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
      dynPaiTipoTraId.setName( "PAITIPOTRAID" );
      dynPaiTipoTraId.setWebtags( "" );
      dynPaiTipoTraId.removeAllItems();
      /* Using cursor T006R18 */
      pr_default.execute(16);
      while ( (pr_default.getStatus(16) != 101) )
      {
         dynPaiTipoTraId.addItem(T006R18_A1292TipoTraId[0], T006R18_A1293TipoTraNom[0], (short)(0));
         pr_default.readNext(16);
      }
      pr_default.close(16);
      if ( dynPaiTipoTraId.getItemCount() > 0 )
      {
         A1294PaiTipoTraId = dynPaiTipoTraId.getValidValue(A1294PaiTipoTraId) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
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

   public void valid_Paitipotraid( )
   {
      A1294PaiTipoTraId = dynPaiTipoTraId.getValue() ;
      if ( ! ( ( GXutil.strcmp(A1294PaiTipoTraId, "diurno") == 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, "nocturno") == 0 ) || ( GXutil.strcmp(A1294PaiTipoTraId, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de Trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAITIPOTRAID");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPaiTipoTraId.getInternalname() ;
      }
      GXv_boolean3[0] = AV36PaiTipoTraIns ;
      GXv_decimal13[0] = AV35PaiTipoHsDia ;
      GXv_decimal12[0] = AV28PaiTipoHsSem ;
      GXv_decimal11[0] = AV29PaiTipoTarifaXLim ;
      GXv_decimal10[0] = AV30PaiTipoTarifaRec ;
      GXv_decimal9[0] = AV31PaiTipoHsMaxDia ;
      GXv_decimal8[0] = AV32PaiTipoHsMaxSem ;
      GXv_decimal7[0] = AV33PaiTipoHsMaxMes ;
      GXv_decimal6[0] = AV34PaiTipoHsMaxAnu ;
      new web.getpaitipotra(remoteHandle, context).execute( AV8CliPaiConve, A1294PaiTipoTraId, GXv_boolean3, GXv_decimal13, GXv_decimal12, GXv_decimal11, GXv_decimal10, GXv_decimal9, GXv_decimal8, GXv_decimal7, GXv_decimal6) ;
      esquemahorasextras_impl.this.AV36PaiTipoTraIns = GXv_boolean3[0] ;
      AV36PaiTipoTraIns = this.AV36PaiTipoTraIns ;
      esquemahorasextras_impl.this.AV35PaiTipoHsDia = GXv_decimal13[0] ;
      AV35PaiTipoHsDia = this.AV35PaiTipoHsDia ;
      esquemahorasextras_impl.this.AV28PaiTipoHsSem = GXv_decimal12[0] ;
      AV28PaiTipoHsSem = this.AV28PaiTipoHsSem ;
      esquemahorasextras_impl.this.AV29PaiTipoTarifaXLim = GXv_decimal11[0] ;
      AV29PaiTipoTarifaXLim = this.AV29PaiTipoTarifaXLim ;
      esquemahorasextras_impl.this.AV30PaiTipoTarifaRec = GXv_decimal10[0] ;
      AV30PaiTipoTarifaRec = this.AV30PaiTipoTarifaRec ;
      esquemahorasextras_impl.this.AV31PaiTipoHsMaxDia = GXv_decimal9[0] ;
      AV31PaiTipoHsMaxDia = this.AV31PaiTipoHsMaxDia ;
      esquemahorasextras_impl.this.AV32PaiTipoHsMaxSem = GXv_decimal8[0] ;
      AV32PaiTipoHsMaxSem = this.AV32PaiTipoHsMaxSem ;
      esquemahorasextras_impl.this.AV33PaiTipoHsMaxMes = GXv_decimal7[0] ;
      AV33PaiTipoHsMaxMes = this.AV33PaiTipoHsMaxMes ;
      esquemahorasextras_impl.this.AV34PaiTipoHsMaxAnu = GXv_decimal6[0] ;
      AV34PaiTipoHsMaxAnu = this.AV34PaiTipoHsMaxAnu ;
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1323ConveHsDia)==0) && ( Gx_BScreen == 0 ) )
      {
         A1323ConveHsDia = AV35PaiTipoHsDia ;
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1324ConveHsSem)==0) && ( Gx_BScreen == 0 ) )
      {
         A1324ConveHsSem = AV28PaiTipoHsSem ;
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1325ConveTarifaXLim)==0) && ( Gx_BScreen == 0 ) )
      {
         A1325ConveTarifaXLim = AV29PaiTipoTarifaXLim ;
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1349ConveTarifaRec)==0) && ( Gx_BScreen == 0 ) )
      {
         A1349ConveTarifaRec = AV30PaiTipoTarifaRec ;
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1391ConveHsMaxDia)==0) && ( Gx_BScreen == 0 ) )
      {
         A1391ConveHsMaxDia = AV31PaiTipoHsMaxDia ;
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1392ConveHsMaxSem)==0) && ( Gx_BScreen == 0 ) )
      {
         A1392ConveHsMaxSem = AV32PaiTipoHsMaxSem ;
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1393ConveHsMaxMes)==0) && ( Gx_BScreen == 0 ) )
      {
         A1393ConveHsMaxMes = AV33PaiTipoHsMaxMes ;
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A1394ConveHsMaxAnu)==0) && ( Gx_BScreen == 0 ) )
      {
         A1394ConveHsMaxAnu = AV34PaiTipoHsMaxAnu ;
      }
      dynload_actions( ) ;
      if ( dynPaiTipoTraId.getItemCount() > 0 )
      {
         A1294PaiTipoTraId = dynPaiTipoTraId.getValidValue(A1294PaiTipoTraId) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPaiTipoTraId.setValue( GXutil.rtrim( A1294PaiTipoTraId) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1323ConveHsDia", GXutil.ltrim( localUtil.ntoc( A1323ConveHsDia, (byte)(3), (byte)(1), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1324ConveHsSem", GXutil.ltrim( localUtil.ntoc( A1324ConveHsSem, (byte)(4), (byte)(1), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1325ConveTarifaXLim", GXutil.ltrim( localUtil.ntoc( A1325ConveTarifaXLim, (byte)(6), (byte)(4), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1349ConveTarifaRec", GXutil.ltrim( localUtil.ntoc( A1349ConveTarifaRec, (byte)(6), (byte)(4), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1391ConveHsMaxDia", GXutil.ltrim( localUtil.ntoc( A1391ConveHsMaxDia, (byte)(3), (byte)(1), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1392ConveHsMaxSem", GXutil.ltrim( localUtil.ntoc( A1392ConveHsMaxSem, (byte)(4), (byte)(1), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1393ConveHsMaxMes", GXutil.ltrim( localUtil.ntoc( A1393ConveHsMaxMes, (byte)(5), (byte)(1), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1394ConveHsMaxAnu", GXutil.ltrim( localUtil.ntoc( A1394ConveHsMaxAnu, (byte)(5), (byte)(1), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "AV36PaiTipoTraIns", AV36PaiTipoTraIns);
      httpContext.ajax_rsp_assign_attri("", false, "AV35PaiTipoHsDia", GXutil.ltrim( localUtil.ntoc( AV35PaiTipoHsDia, (byte)(3), (byte)(1), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "AV28PaiTipoHsSem", GXutil.ltrim( localUtil.ntoc( AV28PaiTipoHsSem, (byte)(4), (byte)(1), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "AV29PaiTipoTarifaXLim", GXutil.ltrim( localUtil.ntoc( AV29PaiTipoTarifaXLim, (byte)(6), (byte)(4), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "AV30PaiTipoTarifaRec", GXutil.ltrim( localUtil.ntoc( AV30PaiTipoTarifaRec, (byte)(6), (byte)(4), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "AV31PaiTipoHsMaxDia", GXutil.ltrim( localUtil.ntoc( AV31PaiTipoHsMaxDia, (byte)(3), (byte)(1), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "AV32PaiTipoHsMaxSem", GXutil.ltrim( localUtil.ntoc( AV32PaiTipoHsMaxSem, (byte)(4), (byte)(1), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "AV33PaiTipoHsMaxMes", GXutil.ltrim( localUtil.ntoc( AV33PaiTipoHsMaxMes, (byte)(5), (byte)(1), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "AV34PaiTipoHsMaxAnu", GXutil.ltrim( localUtil.ntoc( AV34PaiTipoHsMaxAnu, (byte)(5), (byte)(1), ".", "")));
   }

   public void valid_Clipaiconve( )
   {
      A1294PaiTipoTraId = dynPaiTipoTraId.getValue() ;
      /* Using cursor T006R19 */
      pr_default.execute(17, new Object[] {Short.valueOf(A1564CliPaiConve), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais Tipo Trabajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAITIPOTRAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliPaiConve_Internalname ;
      }
      pr_default.close(17);
      dynload_actions( ) ;
      if ( dynPaiTipoTraId.getItemCount() > 0 )
      {
         A1294PaiTipoTraId = dynPaiTipoTraId.getValidValue(A1294PaiTipoTraId) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPaiTipoTraId.setValue( GXutil.rtrim( A1294PaiTipoTraId) );
      }
      /*  Sending validation outputs */
   }

   public void valid_Cliconvenio( )
   {
      A1294PaiTipoTraId = dynPaiTipoTraId.getValue() ;
      /* Using cursor T006R20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(18);
      dynload_actions( ) ;
      if ( dynPaiTipoTraId.getItemCount() > 0 )
      {
         A1294PaiTipoTraId = dynPaiTipoTraId.getValidValue(A1294PaiTipoTraId) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPaiTipoTraId.setValue( GXutil.rtrim( A1294PaiTipoTraId) );
      }
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10PaiTipoTraId',fld:'vPAITIPOTRAID',pic:'',hsh:true},{av:'dynPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'dynPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10PaiTipoTraId',fld:'vPAITIPOTRAID',pic:'',hsh:true},{av:'dynPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e126R2',iparms:[{av:'dynPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'dynPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]}");
      setEventMetadata("VALID_PAITIPOTRAID","{handler:'valid_Paitipotraid',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV35PaiTipoHsDia',fld:'vPAITIPOHSDIA',pic:'9.9'},{av:'Gx_BScreen',fld:'vGXBSCREEN',pic:'9'},{av:'AV28PaiTipoHsSem',fld:'vPAITIPOHSSEM',pic:'Z9.9'},{av:'AV29PaiTipoTarifaXLim',fld:'vPAITIPOTARIFAXLIM',pic:'9.9999'},{av:'AV30PaiTipoTarifaRec',fld:'vPAITIPOTARIFAREC',pic:'9.9999'},{av:'AV31PaiTipoHsMaxDia',fld:'vPAITIPOHSMAXDIA',pic:'9.9'},{av:'AV32PaiTipoHsMaxSem',fld:'vPAITIPOHSMAXSEM',pic:'Z9.9'},{av:'AV33PaiTipoHsMaxMes',fld:'vPAITIPOHSMAXMES',pic:'ZZ9.9'},{av:'AV34PaiTipoHsMaxAnu',fld:'vPAITIPOHSMAXANU',pic:'ZZ9.9'},{av:'AV36PaiTipoTraIns',fld:'vPAITIPOTRAINS',pic:''},{av:'A1323ConveHsDia',fld:'CONVEHSDIA',pic:'9.9'},{av:'A1324ConveHsSem',fld:'CONVEHSSEM',pic:'Z9.9'},{av:'A1325ConveTarifaXLim',fld:'CONVETARIFAXLIM',pic:'9.9999'},{av:'A1349ConveTarifaRec',fld:'CONVETARIFAREC',pic:'9.9999'},{av:'A1391ConveHsMaxDia',fld:'CONVEHSMAXDIA',pic:'9.9'},{av:'A1392ConveHsMaxSem',fld:'CONVEHSMAXSEM',pic:'Z9.9'},{av:'A1393ConveHsMaxMes',fld:'CONVEHSMAXMES',pic:'ZZ9.9'},{av:'A1394ConveHsMaxAnu',fld:'CONVEHSMAXANU',pic:'ZZ9.9'},{av:'dynPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]");
      setEventMetadata("VALID_PAITIPOTRAID",",oparms:[{av:'A1323ConveHsDia',fld:'CONVEHSDIA',pic:'9.9'},{av:'A1324ConveHsSem',fld:'CONVEHSSEM',pic:'Z9.9'},{av:'A1325ConveTarifaXLim',fld:'CONVETARIFAXLIM',pic:'9.9999'},{av:'A1349ConveTarifaRec',fld:'CONVETARIFAREC',pic:'9.9999'},{av:'A1391ConveHsMaxDia',fld:'CONVEHSMAXDIA',pic:'9.9'},{av:'A1392ConveHsMaxSem',fld:'CONVEHSMAXSEM',pic:'Z9.9'},{av:'A1393ConveHsMaxMes',fld:'CONVEHSMAXMES',pic:'ZZ9.9'},{av:'A1394ConveHsMaxAnu',fld:'CONVEHSMAXANU',pic:'ZZ9.9'},{av:'AV36PaiTipoTraIns',fld:'vPAITIPOTRAINS',pic:''},{av:'AV35PaiTipoHsDia',fld:'vPAITIPOHSDIA',pic:'9.9'},{av:'AV28PaiTipoHsSem',fld:'vPAITIPOHSSEM',pic:'Z9.9'},{av:'AV29PaiTipoTarifaXLim',fld:'vPAITIPOTARIFAXLIM',pic:'9.9999'},{av:'AV30PaiTipoTarifaRec',fld:'vPAITIPOTARIFAREC',pic:'9.9999'},{av:'AV31PaiTipoHsMaxDia',fld:'vPAITIPOHSMAXDIA',pic:'9.9'},{av:'AV32PaiTipoHsMaxSem',fld:'vPAITIPOHSMAXSEM',pic:'Z9.9'},{av:'AV33PaiTipoHsMaxMes',fld:'vPAITIPOHSMAXMES',pic:'ZZ9.9'},{av:'AV34PaiTipoHsMaxAnu',fld:'vPAITIPOHSMAXANU',pic:'ZZ9.9'},{av:'dynPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'dynPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'dynPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[{av:'dynPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'dynPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[{av:'dynPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''}]}");
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
      pr_default.close(17);
      pr_default.close(18);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV9CliConvenio = "" ;
      wcpOAV10PaiTipoTraId = "" ;
      Z1565CliConvenio = "" ;
      Z1294PaiTipoTraId = "" ;
      Z1323ConveHsDia = DecimalUtil.ZERO ;
      Z1324ConveHsSem = DecimalUtil.ZERO ;
      Z1325ConveTarifaXLim = DecimalUtil.ZERO ;
      Z1349ConveTarifaRec = DecimalUtil.ZERO ;
      Z1391ConveHsMaxDia = DecimalUtil.ZERO ;
      Z1392ConveHsMaxSem = DecimalUtil.ZERO ;
      Z1393ConveHsMaxMes = DecimalUtil.ZERO ;
      Z1394ConveHsMaxAnu = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1294PaiTipoTraId = "" ;
      A1565CliConvenio = "" ;
      Gx_mode = "" ;
      AV9CliConvenio = "" ;
      AV10PaiTipoTraId = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A1323ConveHsDia = DecimalUtil.ZERO ;
      A1324ConveHsSem = DecimalUtil.ZERO ;
      A1391ConveHsMaxDia = DecimalUtil.ZERO ;
      A1392ConveHsMaxSem = DecimalUtil.ZERO ;
      A1393ConveHsMaxMes = DecimalUtil.ZERO ;
      A1394ConveHsMaxAnu = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A1325ConveTarifaXLim = DecimalUtil.ZERO ;
      A1349ConveTarifaRec = DecimalUtil.ZERO ;
      AV35PaiTipoHsDia = DecimalUtil.ZERO ;
      AV28PaiTipoHsSem = DecimalUtil.ZERO ;
      AV29PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      AV30PaiTipoTarifaRec = DecimalUtil.ZERO ;
      AV31PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      AV32PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      AV33PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      AV34PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      AV38Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode217 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      T006R6_A1323ConveHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R6_A1324ConveHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R6_A1325ConveTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R6_A1349ConveTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R6_A1391ConveHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R6_A1392ConveHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R6_A1393ConveHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R6_A1394ConveHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R6_A1564CliPaiConve = new short[1] ;
      T006R6_A1294PaiTipoTraId = new String[] {""} ;
      T006R6_A3CliCod = new int[1] ;
      T006R6_A1565CliConvenio = new String[] {""} ;
      T006R5_A3CliCod = new int[1] ;
      T006R4_A46PaiCod = new short[1] ;
      T006R7_A3CliCod = new int[1] ;
      T006R8_A46PaiCod = new short[1] ;
      T006R9_A3CliCod = new int[1] ;
      T006R9_A1564CliPaiConve = new short[1] ;
      T006R9_A1565CliConvenio = new String[] {""} ;
      T006R9_A1294PaiTipoTraId = new String[] {""} ;
      T006R3_A1323ConveHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R3_A1324ConveHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R3_A1325ConveTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R3_A1349ConveTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R3_A1391ConveHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R3_A1392ConveHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R3_A1393ConveHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R3_A1394ConveHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R3_A1564CliPaiConve = new short[1] ;
      T006R3_A1294PaiTipoTraId = new String[] {""} ;
      T006R3_A3CliCod = new int[1] ;
      T006R3_A1565CliConvenio = new String[] {""} ;
      T006R10_A1564CliPaiConve = new short[1] ;
      T006R10_A1294PaiTipoTraId = new String[] {""} ;
      T006R10_A3CliCod = new int[1] ;
      T006R10_A1565CliConvenio = new String[] {""} ;
      T006R11_A1564CliPaiConve = new short[1] ;
      T006R11_A1294PaiTipoTraId = new String[] {""} ;
      T006R11_A3CliCod = new int[1] ;
      T006R11_A1565CliConvenio = new String[] {""} ;
      T006R2_A1323ConveHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R2_A1324ConveHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R2_A1325ConveTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R2_A1349ConveTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R2_A1391ConveHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R2_A1392ConveHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R2_A1393ConveHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R2_A1394ConveHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006R2_A1564CliPaiConve = new short[1] ;
      T006R2_A1294PaiTipoTraId = new String[] {""} ;
      T006R2_A3CliCod = new int[1] ;
      T006R2_A1565CliConvenio = new String[] {""} ;
      T006R15_A3CliCod = new int[1] ;
      T006R15_A1564CliPaiConve = new short[1] ;
      T006R15_A1565CliConvenio = new String[] {""} ;
      T006R15_A1327ConveHsExSec = new short[1] ;
      T006R16_A3CliCod = new int[1] ;
      T006R16_A1564CliPaiConve = new short[1] ;
      T006R16_A1565CliConvenio = new String[] {""} ;
      T006R16_A1294PaiTipoTraId = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T006R17_A1292TipoTraId = new String[] {""} ;
      T006R17_A1293TipoTraNom = new String[] {""} ;
      GXv_int5 = new int[1] ;
      T006R18_A1292TipoTraId = new String[] {""} ;
      T006R18_A1293TipoTraNom = new String[] {""} ;
      GXv_boolean3 = new boolean[1] ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      ZV35PaiTipoHsDia = DecimalUtil.ZERO ;
      ZV28PaiTipoHsSem = DecimalUtil.ZERO ;
      ZV29PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      ZV30PaiTipoTarifaRec = DecimalUtil.ZERO ;
      ZV31PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      ZV32PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      ZV33PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      ZV34PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      T006R19_A46PaiCod = new short[1] ;
      T006R20_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.esquemahorasextras__default(),
         new Object[] {
             new Object[] {
            T006R2_A1323ConveHsDia, T006R2_A1324ConveHsSem, T006R2_A1325ConveTarifaXLim, T006R2_A1349ConveTarifaRec, T006R2_A1391ConveHsMaxDia, T006R2_A1392ConveHsMaxSem, T006R2_A1393ConveHsMaxMes, T006R2_A1394ConveHsMaxAnu, T006R2_A1564CliPaiConve, T006R2_A1294PaiTipoTraId,
            T006R2_A3CliCod, T006R2_A1565CliConvenio
            }
            , new Object[] {
            T006R3_A1323ConveHsDia, T006R3_A1324ConveHsSem, T006R3_A1325ConveTarifaXLim, T006R3_A1349ConveTarifaRec, T006R3_A1391ConveHsMaxDia, T006R3_A1392ConveHsMaxSem, T006R3_A1393ConveHsMaxMes, T006R3_A1394ConveHsMaxAnu, T006R3_A1564CliPaiConve, T006R3_A1294PaiTipoTraId,
            T006R3_A3CliCod, T006R3_A1565CliConvenio
            }
            , new Object[] {
            T006R4_A46PaiCod
            }
            , new Object[] {
            T006R5_A3CliCod
            }
            , new Object[] {
            T006R6_A1323ConveHsDia, T006R6_A1324ConveHsSem, T006R6_A1325ConveTarifaXLim, T006R6_A1349ConveTarifaRec, T006R6_A1391ConveHsMaxDia, T006R6_A1392ConveHsMaxSem, T006R6_A1393ConveHsMaxMes, T006R6_A1394ConveHsMaxAnu, T006R6_A1564CliPaiConve, T006R6_A1294PaiTipoTraId,
            T006R6_A3CliCod, T006R6_A1565CliConvenio
            }
            , new Object[] {
            T006R7_A3CliCod
            }
            , new Object[] {
            T006R8_A46PaiCod
            }
            , new Object[] {
            T006R9_A3CliCod, T006R9_A1564CliPaiConve, T006R9_A1565CliConvenio, T006R9_A1294PaiTipoTraId
            }
            , new Object[] {
            T006R10_A1564CliPaiConve, T006R10_A1294PaiTipoTraId, T006R10_A3CliCod, T006R10_A1565CliConvenio
            }
            , new Object[] {
            T006R11_A1564CliPaiConve, T006R11_A1294PaiTipoTraId, T006R11_A3CliCod, T006R11_A1565CliConvenio
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006R15_A3CliCod, T006R15_A1564CliPaiConve, T006R15_A1565CliConvenio, T006R15_A1327ConveHsExSec
            }
            , new Object[] {
            T006R16_A3CliCod, T006R16_A1564CliPaiConve, T006R16_A1565CliConvenio, T006R16_A1294PaiTipoTraId
            }
            , new Object[] {
            T006R17_A1292TipoTraId, T006R17_A1293TipoTraNom
            }
            , new Object[] {
            T006R18_A1292TipoTraId, T006R18_A1293TipoTraNom
            }
            , new Object[] {
            T006R19_A46PaiCod
            }
            , new Object[] {
            T006R20_A3CliCod
            }
         }
      );
      AV38Pgmname = "EsquemaHorasExtras" ;
      Z1394ConveHsMaxAnu = DecimalUtil.ZERO ;
      A1394ConveHsMaxAnu = DecimalUtil.ZERO ;
      Z1393ConveHsMaxMes = DecimalUtil.ZERO ;
      A1393ConveHsMaxMes = DecimalUtil.ZERO ;
      Z1392ConveHsMaxSem = DecimalUtil.ZERO ;
      A1392ConveHsMaxSem = DecimalUtil.ZERO ;
      Z1391ConveHsMaxDia = DecimalUtil.ZERO ;
      A1391ConveHsMaxDia = DecimalUtil.ZERO ;
      Z1349ConveTarifaRec = DecimalUtil.ZERO ;
      A1349ConveTarifaRec = DecimalUtil.ZERO ;
      Z1325ConveTarifaXLim = DecimalUtil.ZERO ;
      A1325ConveTarifaXLim = DecimalUtil.ZERO ;
      Z1324ConveHsSem = DecimalUtil.ZERO ;
      A1324ConveHsSem = DecimalUtil.ZERO ;
      Z1323ConveHsDia = DecimalUtil.ZERO ;
      A1323ConveHsDia = DecimalUtil.ZERO ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8CliPaiConve ;
   private short Z1564CliPaiConve ;
   private short AV8CliPaiConve ;
   private short A1564CliPaiConve ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound217 ;
   private short nIsDirty_217 ;
   private short A46PaiCod ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtConveHsDia_Enabled ;
   private int edtConveHsSem_Enabled ;
   private int edtConveHsMaxDia_Enabled ;
   private int edtConveHsMaxSem_Enabled ;
   private int edtConveHsMaxMes_Enabled ;
   private int edtConveHsMaxAnu_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtCliPaiConve_Visible ;
   private int edtCliPaiConve_Enabled ;
   private int edtCliConvenio_Visible ;
   private int edtCliConvenio_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private java.math.BigDecimal Z1323ConveHsDia ;
   private java.math.BigDecimal Z1324ConveHsSem ;
   private java.math.BigDecimal Z1325ConveTarifaXLim ;
   private java.math.BigDecimal Z1349ConveTarifaRec ;
   private java.math.BigDecimal Z1391ConveHsMaxDia ;
   private java.math.BigDecimal Z1392ConveHsMaxSem ;
   private java.math.BigDecimal Z1393ConveHsMaxMes ;
   private java.math.BigDecimal Z1394ConveHsMaxAnu ;
   private java.math.BigDecimal A1323ConveHsDia ;
   private java.math.BigDecimal A1324ConveHsSem ;
   private java.math.BigDecimal A1391ConveHsMaxDia ;
   private java.math.BigDecimal A1392ConveHsMaxSem ;
   private java.math.BigDecimal A1393ConveHsMaxMes ;
   private java.math.BigDecimal A1394ConveHsMaxAnu ;
   private java.math.BigDecimal A1325ConveTarifaXLim ;
   private java.math.BigDecimal A1349ConveTarifaRec ;
   private java.math.BigDecimal AV35PaiTipoHsDia ;
   private java.math.BigDecimal AV28PaiTipoHsSem ;
   private java.math.BigDecimal AV29PaiTipoTarifaXLim ;
   private java.math.BigDecimal AV30PaiTipoTarifaRec ;
   private java.math.BigDecimal AV31PaiTipoHsMaxDia ;
   private java.math.BigDecimal AV32PaiTipoHsMaxSem ;
   private java.math.BigDecimal AV33PaiTipoHsMaxMes ;
   private java.math.BigDecimal AV34PaiTipoHsMaxAnu ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal ZV35PaiTipoHsDia ;
   private java.math.BigDecimal ZV28PaiTipoHsSem ;
   private java.math.BigDecimal ZV29PaiTipoTarifaXLim ;
   private java.math.BigDecimal ZV30PaiTipoTarifaRec ;
   private java.math.BigDecimal ZV31PaiTipoHsMaxDia ;
   private java.math.BigDecimal ZV32PaiTipoHsMaxSem ;
   private java.math.BigDecimal ZV33PaiTipoHsMaxMes ;
   private java.math.BigDecimal ZV34PaiTipoHsMaxAnu ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9CliConvenio ;
   private String wcpOAV10PaiTipoTraId ;
   private String Z1565CliConvenio ;
   private String Z1294PaiTipoTraId ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1294PaiTipoTraId ;
   private String A1565CliConvenio ;
   private String Gx_mode ;
   private String AV9CliConvenio ;
   private String AV10PaiTipoTraId ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
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
   private String edtConveHsDia_Internalname ;
   private String edtConveHsDia_Jsonclick ;
   private String edtConveHsSem_Internalname ;
   private String edtConveHsSem_Jsonclick ;
   private String edtConveHsMaxDia_Internalname ;
   private String edtConveHsMaxDia_Jsonclick ;
   private String edtConveHsMaxSem_Internalname ;
   private String edtConveHsMaxSem_Jsonclick ;
   private String edtConveHsMaxMes_Internalname ;
   private String edtConveHsMaxMes_Jsonclick ;
   private String edtConveHsMaxAnu_Internalname ;
   private String edtConveHsMaxAnu_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String edtCliConvenio_Internalname ;
   private String edtCliConvenio_Jsonclick ;
   private String AV38Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode217 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean AV36PaiTipoTraIns ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXv_boolean3[] ;
   private boolean ZV36PaiTipoTraIns ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynPaiTipoTraId ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] T006R6_A1323ConveHsDia ;
   private java.math.BigDecimal[] T006R6_A1324ConveHsSem ;
   private java.math.BigDecimal[] T006R6_A1325ConveTarifaXLim ;
   private java.math.BigDecimal[] T006R6_A1349ConveTarifaRec ;
   private java.math.BigDecimal[] T006R6_A1391ConveHsMaxDia ;
   private java.math.BigDecimal[] T006R6_A1392ConveHsMaxSem ;
   private java.math.BigDecimal[] T006R6_A1393ConveHsMaxMes ;
   private java.math.BigDecimal[] T006R6_A1394ConveHsMaxAnu ;
   private short[] T006R6_A1564CliPaiConve ;
   private String[] T006R6_A1294PaiTipoTraId ;
   private int[] T006R6_A3CliCod ;
   private String[] T006R6_A1565CliConvenio ;
   private int[] T006R5_A3CliCod ;
   private short[] T006R4_A46PaiCod ;
   private int[] T006R7_A3CliCod ;
   private short[] T006R8_A46PaiCod ;
   private int[] T006R9_A3CliCod ;
   private short[] T006R9_A1564CliPaiConve ;
   private String[] T006R9_A1565CliConvenio ;
   private String[] T006R9_A1294PaiTipoTraId ;
   private java.math.BigDecimal[] T006R3_A1323ConveHsDia ;
   private java.math.BigDecimal[] T006R3_A1324ConveHsSem ;
   private java.math.BigDecimal[] T006R3_A1325ConveTarifaXLim ;
   private java.math.BigDecimal[] T006R3_A1349ConveTarifaRec ;
   private java.math.BigDecimal[] T006R3_A1391ConveHsMaxDia ;
   private java.math.BigDecimal[] T006R3_A1392ConveHsMaxSem ;
   private java.math.BigDecimal[] T006R3_A1393ConveHsMaxMes ;
   private java.math.BigDecimal[] T006R3_A1394ConveHsMaxAnu ;
   private short[] T006R3_A1564CliPaiConve ;
   private String[] T006R3_A1294PaiTipoTraId ;
   private int[] T006R3_A3CliCod ;
   private String[] T006R3_A1565CliConvenio ;
   private short[] T006R10_A1564CliPaiConve ;
   private String[] T006R10_A1294PaiTipoTraId ;
   private int[] T006R10_A3CliCod ;
   private String[] T006R10_A1565CliConvenio ;
   private short[] T006R11_A1564CliPaiConve ;
   private String[] T006R11_A1294PaiTipoTraId ;
   private int[] T006R11_A3CliCod ;
   private String[] T006R11_A1565CliConvenio ;
   private java.math.BigDecimal[] T006R2_A1323ConveHsDia ;
   private java.math.BigDecimal[] T006R2_A1324ConveHsSem ;
   private java.math.BigDecimal[] T006R2_A1325ConveTarifaXLim ;
   private java.math.BigDecimal[] T006R2_A1349ConveTarifaRec ;
   private java.math.BigDecimal[] T006R2_A1391ConveHsMaxDia ;
   private java.math.BigDecimal[] T006R2_A1392ConveHsMaxSem ;
   private java.math.BigDecimal[] T006R2_A1393ConveHsMaxMes ;
   private java.math.BigDecimal[] T006R2_A1394ConveHsMaxAnu ;
   private short[] T006R2_A1564CliPaiConve ;
   private String[] T006R2_A1294PaiTipoTraId ;
   private int[] T006R2_A3CliCod ;
   private String[] T006R2_A1565CliConvenio ;
   private int[] T006R15_A3CliCod ;
   private short[] T006R15_A1564CliPaiConve ;
   private String[] T006R15_A1565CliConvenio ;
   private short[] T006R15_A1327ConveHsExSec ;
   private int[] T006R16_A3CliCod ;
   private short[] T006R16_A1564CliPaiConve ;
   private String[] T006R16_A1565CliConvenio ;
   private String[] T006R16_A1294PaiTipoTraId ;
   private String[] T006R17_A1292TipoTraId ;
   private String[] T006R17_A1293TipoTraNom ;
   private String[] T006R18_A1292TipoTraId ;
   private String[] T006R18_A1293TipoTraNom ;
   private short[] T006R19_A46PaiCod ;
   private int[] T006R20_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
}

final  class esquemahorasextras__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T006R2", "SELECT ConveHsDia, ConveHsSem, ConveTarifaXLim, ConveTarifaRec, ConveHsMaxDia, ConveHsMaxSem, ConveHsMaxMes, ConveHsMaxAnu, CliPaiConve, PaiTipoTraId, CliCod, CliConvenio FROM convenio_tiposdetrabajo WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND PaiTipoTraId = ?  FOR UPDATE OF convenio_tiposdetrabajo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006R3", "SELECT ConveHsDia, ConveHsSem, ConveTarifaXLim, ConveTarifaRec, ConveHsMaxDia, ConveHsMaxSem, ConveHsMaxMes, ConveHsMaxAnu, CliPaiConve, PaiTipoTraId, CliCod, CliConvenio FROM convenio_tiposdetrabajo WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006R4", "SELECT PaiCod FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006R5", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006R6", "SELECT TM1.ConveHsDia, TM1.ConveHsSem, TM1.ConveTarifaXLim, TM1.ConveTarifaRec, TM1.ConveHsMaxDia, TM1.ConveHsMaxSem, TM1.ConveHsMaxMes, TM1.ConveHsMaxAnu, TM1.CliPaiConve, TM1.PaiTipoTraId, TM1.CliCod, TM1.CliConvenio FROM convenio_tiposdetrabajo TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.PaiTipoTraId = ( ?) ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.PaiTipoTraId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006R7", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006R8", "SELECT PaiCod FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006R9", "SELECT CliCod, CliPaiConve, CliConvenio, PaiTipoTraId FROM convenio_tiposdetrabajo WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006R10", "SELECT CliPaiConve, PaiTipoTraId, CliCod, CliConvenio FROM convenio_tiposdetrabajo WHERE ( CliPaiConve > ? or CliPaiConve = ? and PaiTipoTraId > ( ?) or PaiTipoTraId = ( ?) and CliPaiConve = ? and CliCod > ? or CliCod = ? and PaiTipoTraId = ( ?) and CliPaiConve = ? and CliConvenio > ( ?)) ORDER BY CliCod, CliPaiConve, CliConvenio, PaiTipoTraId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T006R11", "SELECT CliPaiConve, PaiTipoTraId, CliCod, CliConvenio FROM convenio_tiposdetrabajo WHERE ( CliPaiConve < ? or CliPaiConve = ? and PaiTipoTraId < ( ?) or PaiTipoTraId = ( ?) and CliPaiConve = ? and CliCod < ? or CliCod = ? and PaiTipoTraId = ( ?) and CliPaiConve = ? and CliConvenio < ( ?)) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, PaiTipoTraId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T006R12", "SAVEPOINT gxupdate;INSERT INTO convenio_tiposdetrabajo(ConveHsDia, ConveHsSem, ConveTarifaXLim, ConveTarifaRec, ConveHsMaxDia, ConveHsMaxSem, ConveHsMaxMes, ConveHsMaxAnu, CliPaiConve, PaiTipoTraId, CliCod, CliConvenio, ConveHsRelSec, ConveHsRelRef, ConveHsOld, ConveHsHorDes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006R13", "SAVEPOINT gxupdate;UPDATE convenio_tiposdetrabajo SET ConveHsDia=?, ConveHsSem=?, ConveTarifaXLim=?, ConveTarifaRec=?, ConveHsMaxDia=?, ConveHsMaxSem=?, ConveHsMaxMes=?, ConveHsMaxAnu=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006R14", "SAVEPOINT gxupdate;DELETE FROM convenio_tiposdetrabajo  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006R15", "SELECT CliCod, CliPaiConve, CliConvenio, ConveHsExSec FROM Convenio_horasextras_porDia WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConvHsPDiaTipTra = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T006R16", "SELECT CliCod, CliPaiConve, CliConvenio, PaiTipoTraId FROM convenio_tiposdetrabajo ORDER BY CliCod, CliPaiConve, CliConvenio, PaiTipoTraId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006R17", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo ORDER BY TipoTraNom ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006R18", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo ORDER BY TipoTraNom ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006R19", "SELECT PaiCod FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006R20", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,1);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               return;
            case 1 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,1);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,1);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,1);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 18 :
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
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
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 20);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setString(10, (String)parms[9], 20);
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 20);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setString(10, (String)parms[9], 20);
               return;
            case 10 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 1);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 1);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 4);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 1);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 1);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setString(10, (String)parms[9], 20);
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setString(12, (String)parms[11], 20);
               return;
            case 11 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 1);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 1);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 4);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 1);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 1);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setString(11, (String)parms[10], 20);
               stmt.setString(12, (String)parms[11], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

