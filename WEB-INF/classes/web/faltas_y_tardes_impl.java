package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class faltas_y_tardes_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action34") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
         AV9LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9LegNumero), 8, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LegNumero), "ZZZZZZZ9")));
         A506LegLicSitCodigo = httpContext.GetPar( "LegLicSitCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A506LegLicSitCodigo", A506LegLicSitCodigo);
         A481LegLicenFin = localUtil.parseDateParm( httpContext.GetPar( "LegLicenFin")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A481LegLicenFin", localUtil.format(A481LegLicenFin, "99/99/99"));
         A76LegLicenIni = localUtil.parseDateParm( httpContext.GetPar( "LegLicenIni")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A76LegLicenIni", localUtil.format(A76LegLicenIni, "99/99/99"));
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_34_3P64( AV7CliCod, AV8EmpCod, AV9LegNumero, A506LegLicSitCodigo, A481LegLicenFin, A76LegLicenIni, Gx_mode) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action36") == 0 )
      {
         A506LegLicSitCodigo = httpContext.GetPar( "LegLicSitCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A506LegLicSitCodigo", A506LegLicSitCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_36_3P64( A506LegLicSitCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"LEGLICSITCODIGO") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaleglicsitcodigo3P64( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel4"+"_"+"CLICOD") == 0 )
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
         gx4asaclicod3P64( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel14"+"_"+"LEGLICSITDESCRIP") == 0 )
      {
         A506LegLicSitCodigo = httpContext.GetPar( "LegLicSitCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A506LegLicSitCodigo", A506LegLicSitCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx14asaleglicsitdescrip3P64( A506LegLicSitCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel15"+"_"+"LEGLICDESCRIP") == 0 )
      {
         A506LegLicSitCodigo = httpContext.GetPar( "LegLicSitCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A506LegLicSitCodigo", A506LegLicSitCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx15asaleglicdescrip3P64( A506LegLicSitCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_38") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_38( A3CliCod, A1EmpCod, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_39") == 0 )
      {
         A506LegLicSitCodigo = httpContext.GetPar( "LegLicSitCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A506LegLicSitCodigo", A506LegLicSitCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_39( A506LegLicSitCodigo) ;
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
            AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
            AV9LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9LegNumero), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LegNumero), "ZZZZZZZ9")));
            AV10LegLicenIni = localUtil.parseDateParm( httpContext.GetPar( "LegLicenIni")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10LegLicenIni", localUtil.format(AV10LegLicenIni, "99/99/99"));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGLICENINI", getSecureSignedToken( "", AV10LegLicenIni));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Novedad Eventos", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtLegNumero_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public faltas_y_tardes_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public faltas_y_tardes_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( faltas_y_tardes_impl.class ));
   }

   public faltas_y_tardes_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynLegLicSitCodigo = new HTMLChoice();
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
      if ( dynLegLicSitCodigo.getItemCount() > 0 )
      {
         A506LegLicSitCodigo = dynLegLicSitCodigo.getValidValue(A506LegLicSitCodigo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A506LegLicSitCodigo", A506LegLicSitCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynLegLicSitCodigo.setValue( GXutil.rtrim( A506LegLicSitCodigo) );
         httpContext.ajax_rsp_assign_prop("", false, dynLegLicSitCodigo.getInternalname(), "Values", dynLegLicSitCodigo.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedlegnumero_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklegnumero_Internalname, httpContext.getMessage( "Legajo", ""), "", "", lblTextblocklegnumero_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_faltas_y_tardes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_legnumero.setProperty("Caption", Combo_legnumero_Caption);
      ucCombo_legnumero.setProperty("Cls", Combo_legnumero_Cls);
      ucCombo_legnumero.setProperty("EmptyItem", Combo_legnumero_Emptyitem);
      ucCombo_legnumero.setProperty("DropDownOptionsData", AV20LegNumero_Data);
      ucCombo_legnumero.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legnumero_Internalname, "COMBO_LEGNUMEROContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegNumero_Internalname, httpContext.getMessage( "Legajo", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", edtLegNumero_Visible, edtLegNumero_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_faltas_y_tardes.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegLicenIni_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegLicenIni_Internalname, httpContext.getMessage( "Desde", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLegLicenIni_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegLicenIni_Internalname, localUtil.format(A76LegLicenIni, "99/99/99"), localUtil.format( A76LegLicenIni, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegLicenIni_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtLegLicenIni_Enabled, 1, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_faltas_y_tardes.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLegLicenIni_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegLicenIni_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_faltas_y_tardes.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegLicenFin_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegLicenFin_Internalname, httpContext.getMessage( "Hasta", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLegLicenFin_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegLicenFin_Internalname, localUtil.format(A481LegLicenFin, "99/99/99"), localUtil.format( A481LegLicenFin, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegLicenFin_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtLegLicenFin_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_faltas_y_tardes.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLegLicenFin_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegLicenFin_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_faltas_y_tardes.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavCntdias_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtavCntdias_Internalname, httpContext.getMessage( "Cantidad de días", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCntdias_Internalname, GXutil.ltrim( localUtil.ntoc( AV27cntDias, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCntdias_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV27cntDias), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV27cntDias), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCntdias_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavCntdias_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_faltas_y_tardes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynLegLicSitCodigo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynLegLicSitCodigo.getInternalname(), httpContext.getMessage( "Estado", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynLegLicSitCodigo, dynLegLicSitCodigo.getInternalname(), GXutil.rtrim( A506LegLicSitCodigo), 1, dynLegLicSitCodigo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynLegLicSitCodigo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "", true, (byte)(0), "HLP_faltas_y_tardes.htm");
      dynLegLicSitCodigo.setValue( GXutil.rtrim( A506LegLicSitCodigo) );
      httpContext.ajax_rsp_assign_prop("", false, dynLegLicSitCodigo.getInternalname(), "Values", dynLegLicSitCodigo.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_faltas_y_tardes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_faltas_y_tardes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_faltas_y_tardes.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_legnumero_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombolegnumero_Internalname, GXutil.ltrim( localUtil.ntoc( AV24ComboLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCombolegnumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV24ComboLegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV24ComboLegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombolegnumero_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombolegnumero_Visible, edtavCombolegnumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_faltas_y_tardes.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,66);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_faltas_y_tardes.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_faltas_y_tardes.htm");
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
      e113P2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGNUMERO_DATA"), AV20LegNumero_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z76LegLicenIni = localUtil.ctod( httpContext.cgiGet( "Z76LegLicenIni"), 0) ;
            Z517LegLicSitDescrip = httpContext.cgiGet( "Z517LegLicSitDescrip") ;
            Z914LegLicDescrip = httpContext.cgiGet( "Z914LegLicDescrip") ;
            Z1497LegLicEstado = httpContext.cgiGet( "Z1497LegLicEstado") ;
            Z481LegLicenFin = localUtil.ctod( httpContext.cgiGet( "Z481LegLicenFin"), 0) ;
            Z1218LegLicConPlus = GXutil.strtobool( httpContext.cgiGet( "Z1218LegLicConPlus")) ;
            Z1287LegSitEsLic = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1287LegSitEsLic"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1288LegSitEsAu = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1288LegSitEsAu"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1289LegSitEsAfip = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1289LegSitEsAfip"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1643LegSitCuenTrab = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1643LegSitCuenTrab"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1808LegLicCanPres = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1808LegLicCanPres"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1810LegLicRemCorr = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1810LegLicRemCorr"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z506LegLicSitCodigo = httpContext.cgiGet( "Z506LegLicSitCodigo") ;
            A517LegLicSitDescrip = httpContext.cgiGet( "Z517LegLicSitDescrip") ;
            A914LegLicDescrip = httpContext.cgiGet( "Z914LegLicDescrip") ;
            A1497LegLicEstado = httpContext.cgiGet( "Z1497LegLicEstado") ;
            A1218LegLicConPlus = GXutil.strtobool( httpContext.cgiGet( "Z1218LegLicConPlus")) ;
            A1287LegSitEsLic = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1287LegSitEsLic"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1288LegSitEsAu = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1288LegSitEsAu"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1289LegSitEsAfip = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1289LegSitEsAfip"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1643LegSitCuenTrab = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1643LegSitCuenTrab"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1808LegLicCanPres = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1808LegLicCanPres"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1810LegLicRemCorr = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1810LegLicRemCorr"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N506LegLicSitCodigo = httpContext.cgiGet( "N506LegLicSitCodigo") ;
            A501LegLicCntDias = (short)(localUtil.ctol( httpContext.cgiGet( "LEGLICCNTDIAS"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "vLEGNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV10LegLicenIni = localUtil.ctod( httpContext.cgiGet( "vLEGLICENINI"), 0) ;
            AV25Insert_LegLicSitCodigo = httpContext.cgiGet( "vINSERT_LEGLICSITCODIGO") ;
            A517LegLicSitDescrip = httpContext.cgiGet( "LEGLICSITDESCRIP") ;
            A914LegLicDescrip = httpContext.cgiGet( "LEGLICDESCRIP") ;
            A1497LegLicEstado = httpContext.cgiGet( "LEGLICESTADO") ;
            AV33SitEsLicencia = GXutil.strtobool( httpContext.cgiGet( "vSITESLICENCIA")) ;
            A1287LegSitEsLic = (byte)(localUtil.ctol( httpContext.cgiGet( "LEGSITESLIC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV32sitEsAusencia = GXutil.strtobool( httpContext.cgiGet( "vSITESAUSENCIA")) ;
            A1288LegSitEsAu = (byte)(localUtil.ctol( httpContext.cgiGet( "LEGSITESAU"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV30SitEsRevistaAFip = GXutil.strtobool( httpContext.cgiGet( "vSITESREVISTAAFIP")) ;
            A1289LegSitEsAfip = (byte)(localUtil.ctol( httpContext.cgiGet( "LEGSITESAFIP"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV31SitLicCuentaTrab = GXutil.strtobool( httpContext.cgiGet( "vSITLICCUENTATRAB")) ;
            A1643LegSitCuenTrab = (byte)(localUtil.ctol( httpContext.cgiGet( "LEGSITCUENTRAB"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV34EstadoCanPresen = GXutil.strtobool( httpContext.cgiGet( "vESTADOCANPRESEN")) ;
            A1808LegLicCanPres = (byte)(localUtil.ctol( httpContext.cgiGet( "LEGLICCANPRES"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV35EstadoRemCorr = GXutil.strtobool( httpContext.cgiGet( "vESTADOREMCORR")) ;
            A1810LegLicRemCorr = (byte)(localUtil.ctol( httpContext.cgiGet( "LEGLICREMCORR"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV19existe = GXutil.strtobool( httpContext.cgiGet( "vEXISTE")) ;
            Gx_mode = httpContext.cgiGet( "vMODE") ;
            A1218LegLicConPlus = GXutil.strtobool( httpContext.cgiGet( "LEGLICCONPLUS")) ;
            AV37Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_legnumero_Objectcall = httpContext.cgiGet( "COMBO_LEGNUMERO_Objectcall") ;
            Combo_legnumero_Class = httpContext.cgiGet( "COMBO_LEGNUMERO_Class") ;
            Combo_legnumero_Icontype = httpContext.cgiGet( "COMBO_LEGNUMERO_Icontype") ;
            Combo_legnumero_Icon = httpContext.cgiGet( "COMBO_LEGNUMERO_Icon") ;
            Combo_legnumero_Caption = httpContext.cgiGet( "COMBO_LEGNUMERO_Caption") ;
            Combo_legnumero_Tooltip = httpContext.cgiGet( "COMBO_LEGNUMERO_Tooltip") ;
            Combo_legnumero_Cls = httpContext.cgiGet( "COMBO_LEGNUMERO_Cls") ;
            Combo_legnumero_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGNUMERO_Selectedvalue_set") ;
            Combo_legnumero_Selectedvalue_get = httpContext.cgiGet( "COMBO_LEGNUMERO_Selectedvalue_get") ;
            Combo_legnumero_Selectedtext_set = httpContext.cgiGet( "COMBO_LEGNUMERO_Selectedtext_set") ;
            Combo_legnumero_Selectedtext_get = httpContext.cgiGet( "COMBO_LEGNUMERO_Selectedtext_get") ;
            Combo_legnumero_Gamoauthtoken = httpContext.cgiGet( "COMBO_LEGNUMERO_Gamoauthtoken") ;
            Combo_legnumero_Ddointernalname = httpContext.cgiGet( "COMBO_LEGNUMERO_Ddointernalname") ;
            Combo_legnumero_Titlecontrolalign = httpContext.cgiGet( "COMBO_LEGNUMERO_Titlecontrolalign") ;
            Combo_legnumero_Dropdownoptionstype = httpContext.cgiGet( "COMBO_LEGNUMERO_Dropdownoptionstype") ;
            Combo_legnumero_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Enabled")) ;
            Combo_legnumero_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Visible")) ;
            Combo_legnumero_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_LEGNUMERO_Titlecontrolidtoreplace") ;
            Combo_legnumero_Datalisttype = httpContext.cgiGet( "COMBO_LEGNUMERO_Datalisttype") ;
            Combo_legnumero_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Allowmultipleselection")) ;
            Combo_legnumero_Datalistfixedvalues = httpContext.cgiGet( "COMBO_LEGNUMERO_Datalistfixedvalues") ;
            Combo_legnumero_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Isgriditem")) ;
            Combo_legnumero_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Hasdescription")) ;
            Combo_legnumero_Datalistproc = httpContext.cgiGet( "COMBO_LEGNUMERO_Datalistproc") ;
            Combo_legnumero_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_LEGNUMERO_Datalistprocparametersprefix") ;
            Combo_legnumero_Remoteservicesparameters = httpContext.cgiGet( "COMBO_LEGNUMERO_Remoteservicesparameters") ;
            Combo_legnumero_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_LEGNUMERO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_legnumero_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Includeonlyselectedoption")) ;
            Combo_legnumero_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Includeselectalloption")) ;
            Combo_legnumero_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Emptyitem")) ;
            Combo_legnumero_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Includeaddnewoption")) ;
            Combo_legnumero_Htmltemplate = httpContext.cgiGet( "COMBO_LEGNUMERO_Htmltemplate") ;
            Combo_legnumero_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGNUMERO_Multiplevaluestype") ;
            Combo_legnumero_Loadingdata = httpContext.cgiGet( "COMBO_LEGNUMERO_Loadingdata") ;
            Combo_legnumero_Noresultsfound = httpContext.cgiGet( "COMBO_LEGNUMERO_Noresultsfound") ;
            Combo_legnumero_Emptyitemtext = httpContext.cgiGet( "COMBO_LEGNUMERO_Emptyitemtext") ;
            Combo_legnumero_Onlyselectedvalues = httpContext.cgiGet( "COMBO_LEGNUMERO_Onlyselectedvalues") ;
            Combo_legnumero_Selectalltext = httpContext.cgiGet( "COMBO_LEGNUMERO_Selectalltext") ;
            Combo_legnumero_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_LEGNUMERO_Multiplevaluesseparator") ;
            Combo_legnumero_Addnewoptiontext = httpContext.cgiGet( "COMBO_LEGNUMERO_Addnewoptiontext") ;
            Combo_legnumero_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_LEGNUMERO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGNUMERO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A6LegNumero = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            }
            else
            {
               A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtLegLicenIni_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "LEGLICENINI");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegLicenIni_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A76LegLicenIni = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A76LegLicenIni", localUtil.format(A76LegLicenIni, "99/99/99"));
            }
            else
            {
               A76LegLicenIni = localUtil.ctod( httpContext.cgiGet( edtLegLicenIni_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A76LegLicenIni", localUtil.format(A76LegLicenIni, "99/99/99"));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtLegLicenFin_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "LEGLICENFIN");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegLicenFin_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A481LegLicenFin = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A481LegLicenFin", localUtil.format(A481LegLicenFin, "99/99/99"));
            }
            else
            {
               A481LegLicenFin = localUtil.ctod( httpContext.cgiGet( edtLegLicenFin_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A481LegLicenFin", localUtil.format(A481LegLicenFin, "99/99/99"));
            }
            AV27cntDias = (short)(localUtil.ctol( httpContext.cgiGet( edtavCntdias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27cntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27cntDias), 4, 0));
            dynLegLicSitCodigo.setValue( httpContext.cgiGet( dynLegLicSitCodigo.getInternalname()) );
            A506LegLicSitCodigo = httpContext.cgiGet( dynLegLicSitCodigo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A506LegLicSitCodigo", A506LegLicSitCodigo);
            AV24ComboLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtavCombolegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24ComboLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ComboLegNumero), 8, 0));
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1EmpCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            else
            {
               A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"faltas_y_tardes");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("LegLicEstado", GXutil.rtrim( localUtil.format( A1497LegLicEstado, "")));
            forbiddenHiddens.add("LegLicConPlus", GXutil.booltostr( A1218LegLicConPlus));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || !( GXutil.dateCompare(GXutil.resetTime(A76LegLicenIni), GXutil.resetTime(Z76LegLicenIni)) ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("faltas_y_tardes:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A76LegLicenIni = localUtil.parseDateParm( httpContext.GetPar( "LegLicenIni")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A76LegLicenIni", localUtil.format(A76LegLicenIni, "99/99/99"));
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
                  sMode64 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode64 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound64 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_3P0( ) ;
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
                        e113P2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e123P2 ();
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
         e123P2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll3P64( ) ;
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
         disableAttributes3P64( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCntdias_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCntdias_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombolegnumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombolegnumero_Enabled), 5, 0), true);
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

   public void confirm_3P0( )
   {
      beforeValidate3P64( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls3P64( ) ;
         }
         else
         {
            checkExtendedTable3P64( ) ;
            closeExtendedTableCursors3P64( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption3P0( )
   {
   }

   public void e113P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      edtLegNumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Visible), 5, 0), true);
      AV24ComboLegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ComboLegNumero), 8, 0));
      edtavCombolegnumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombolegnumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombolegnumero_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S112 ();
      if ( returnInSub )
      {
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
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedadEventos_Insert", GXv_boolean3) ;
         faltas_y_tardes_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedadEventos_Update", GXv_boolean3) ;
         faltas_y_tardes_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedadEventos_Delete", GXv_boolean3) ;
         faltas_y_tardes_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV37Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV14TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV37Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV38GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38GXV1), 8, 0));
         while ( AV38GXV1 <= AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV26TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV38GXV1));
            if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegLicSitCodigo") == 0 )
            {
               AV25Insert_LegLicSitCodigo = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV25Insert_LegLicSitCodigo", AV25Insert_LegLicSitCodigo);
            }
            AV38GXV1 = (int)(AV38GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38GXV1), 8, 0));
         }
      }
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
   }

   public void e123P2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.recalcularlegsuelbasicaporlegupd(remoteHandle, context).execute( (short)(0), AV7CliCod, AV8EmpCod, A6LegNumero, httpContext.getMessage( "LICENCIAS", "")) ;
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

   public void S112( )
   {
      /* 'LOADCOMBOLEGNUMERO' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item4 = AV20LegNumero_Data ;
      GXv_char5[0] = AV17ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item6[0] = GXt_objcol_SdtDVB_SDTComboData_Item4 ;
      new web.faltas_y_tardesloaddvcombo(remoteHandle, context).execute( "LegNumero", Gx_mode, AV7CliCod, AV8EmpCod, AV9LegNumero, AV10LegLicenIni, GXv_char5, GXv_objcol_SdtDVB_SDTComboData_Item6) ;
      faltas_y_tardes_impl.this.AV17ComboSelectedValue = GXv_char5[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item4 = GXv_objcol_SdtDVB_SDTComboData_Item6[0] ;
      AV20LegNumero_Data = GXt_objcol_SdtDVB_SDTComboData_Item4 ;
      Combo_legnumero_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_legnumero.sendProperty(context, "", false, Combo_legnumero_Internalname, "SelectedValue_set", Combo_legnumero_Selectedvalue_set);
      AV24ComboLegNumero = (int)(GXutil.lval( AV17ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ComboLegNumero), 8, 0));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (0==AV9LegNumero) )
      {
         Combo_legnumero_Enabled = false ;
         ucCombo_legnumero.sendProperty(context, "", false, Combo_legnumero_Internalname, "Enabled", GXutil.booltostr( Combo_legnumero_Enabled));
      }
   }

   public void zm3P64( int GX_JID )
   {
      if ( ( GX_JID == 37 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z517LegLicSitDescrip = T003P3_A517LegLicSitDescrip[0] ;
            Z914LegLicDescrip = T003P3_A914LegLicDescrip[0] ;
            Z1497LegLicEstado = T003P3_A1497LegLicEstado[0] ;
            Z481LegLicenFin = T003P3_A481LegLicenFin[0] ;
            Z1218LegLicConPlus = T003P3_A1218LegLicConPlus[0] ;
            Z1287LegSitEsLic = T003P3_A1287LegSitEsLic[0] ;
            Z1288LegSitEsAu = T003P3_A1288LegSitEsAu[0] ;
            Z1289LegSitEsAfip = T003P3_A1289LegSitEsAfip[0] ;
            Z1643LegSitCuenTrab = T003P3_A1643LegSitCuenTrab[0] ;
            Z1808LegLicCanPres = T003P3_A1808LegLicCanPres[0] ;
            Z1810LegLicRemCorr = T003P3_A1810LegLicRemCorr[0] ;
            Z506LegLicSitCodigo = T003P3_A506LegLicSitCodigo[0] ;
         }
         else
         {
            Z517LegLicSitDescrip = A517LegLicSitDescrip ;
            Z914LegLicDescrip = A914LegLicDescrip ;
            Z1497LegLicEstado = A1497LegLicEstado ;
            Z481LegLicenFin = A481LegLicenFin ;
            Z1218LegLicConPlus = A1218LegLicConPlus ;
            Z1287LegSitEsLic = A1287LegSitEsLic ;
            Z1288LegSitEsAu = A1288LegSitEsAu ;
            Z1289LegSitEsAfip = A1289LegSitEsAfip ;
            Z1643LegSitCuenTrab = A1643LegSitCuenTrab ;
            Z1808LegLicCanPres = A1808LegLicCanPres ;
            Z1810LegLicRemCorr = A1810LegLicRemCorr ;
            Z506LegLicSitCodigo = A506LegLicSitCodigo ;
         }
      }
      if ( GX_JID == -37 )
      {
         Z76LegLicenIni = A76LegLicenIni ;
         Z517LegLicSitDescrip = A517LegLicSitDescrip ;
         Z914LegLicDescrip = A914LegLicDescrip ;
         Z1497LegLicEstado = A1497LegLicEstado ;
         Z481LegLicenFin = A481LegLicenFin ;
         Z1218LegLicConPlus = A1218LegLicConPlus ;
         Z1287LegSitEsLic = A1287LegSitEsLic ;
         Z1288LegSitEsAu = A1288LegSitEsAu ;
         Z1289LegSitEsAfip = A1289LegSitEsAfip ;
         Z1643LegSitCuenTrab = A1643LegSitCuenTrab ;
         Z1808LegLicCanPres = A1808LegLicCanPres ;
         Z1810LegLicRemCorr = A1810LegLicRemCorr ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z506LegLicSitCodigo = A506LegLicSitCodigo ;
      }
   }

   public void standaloneNotModal( )
   {
      gxaleglicsitcodigo_html3P64( ) ;
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
            GXt_int7 = A3CliCod ;
            GXv_int8[0] = GXt_int7 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
            faltas_y_tardes_impl.this.GXt_int7 = GXv_int8[0] ;
            A3CliCod = GXt_int7 ;
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
      if ( ! (0==AV8EmpCod) )
      {
         A1EmpCod = AV8EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( ! (0==AV8EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9LegNumero) )
      {
         edtLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      else
      {
         edtLegNumero_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9LegNumero) )
      {
         edtLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10LegLicenIni)) )
      {
         A76LegLicenIni = AV10LegLicenIni ;
         httpContext.ajax_rsp_assign_attri("", false, "A76LegLicenIni", localUtil.format(A76LegLicenIni, "99/99/99"));
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10LegLicenIni)) )
      {
         edtLegLicenIni_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegLicenIni_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegLicenIni_Enabled), 5, 0), true);
      }
      else
      {
         edtLegLicenIni_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegLicenIni_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegLicenIni_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10LegLicenIni)) )
      {
         edtLegLicenIni_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegLicenIni_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegLicenIni_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9LegNumero) )
      {
         A6LegNumero = AV9LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      else
      {
         A6LegNumero = AV24ComboLegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV25Insert_LegLicSitCodigo)==0) )
      {
         dynLegLicSitCodigo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynLegLicSitCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegLicSitCodigo.getEnabled(), 5, 0), true);
      }
      else
      {
         dynLegLicSitCodigo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynLegLicSitCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegLicSitCodigo.getEnabled(), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      A1497LegLicEstado = "autorizada" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1497LegLicEstado", A1497LegLicEstado);
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV25Insert_LegLicSitCodigo)==0) )
      {
         A506LegLicSitCodigo = AV25Insert_LegLicSitCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A506LegLicSitCodigo", A506LegLicSitCodigo);
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
         AV37Pgmname = "faltas_y_tardes" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37Pgmname", AV37Pgmname);
      }
   }

   public void load3P64( )
   {
      /* Using cursor T003P6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound64 = (short)(1) ;
         A517LegLicSitDescrip = T003P6_A517LegLicSitDescrip[0] ;
         A914LegLicDescrip = T003P6_A914LegLicDescrip[0] ;
         A1497LegLicEstado = T003P6_A1497LegLicEstado[0] ;
         A481LegLicenFin = T003P6_A481LegLicenFin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A481LegLicenFin", localUtil.format(A481LegLicenFin, "99/99/99"));
         A1218LegLicConPlus = T003P6_A1218LegLicConPlus[0] ;
         A1287LegSitEsLic = T003P6_A1287LegSitEsLic[0] ;
         A1288LegSitEsAu = T003P6_A1288LegSitEsAu[0] ;
         A1289LegSitEsAfip = T003P6_A1289LegSitEsAfip[0] ;
         A1643LegSitCuenTrab = T003P6_A1643LegSitCuenTrab[0] ;
         A1808LegLicCanPres = T003P6_A1808LegLicCanPres[0] ;
         A1810LegLicRemCorr = T003P6_A1810LegLicRemCorr[0] ;
         A506LegLicSitCodigo = T003P6_A506LegLicSitCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A506LegLicSitCodigo", A506LegLicSitCodigo);
         zm3P64( -37) ;
      }
      pr_default.close(4);
      onLoadActions3P64( ) ;
   }

   public void onLoadActions3P64( )
   {
      AV37Pgmname = "faltas_y_tardes" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37Pgmname", AV37Pgmname);
      if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) && ( Gx_BScreen == 0 ) )
      {
         A481LegLicenFin = A76LegLicenIni ;
         httpContext.ajax_rsp_assign_attri("", false, "A481LegLicenFin", localUtil.format(A481LegLicenFin, "99/99/99"));
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) )
      {
         A501LegLicCntDias = (short)(GXutil.ddiff(A481LegLicenFin,A76LegLicenIni)+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "A501LegLicCntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A501LegLicCntDias), 4, 0));
      }
      else
      {
         A501LegLicCntDias = (short)(GXutil.ddiff(GXutil.eomdate( A76LegLicenIni),A76LegLicenIni)+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "A501LegLicCntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A501LegLicCntDias), 4, 0));
      }
   }

   public void checkExtendedTable3P64( )
   {
      nIsDirty_64 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV37Pgmname = "faltas_y_tardes" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37Pgmname", AV37Pgmname);
      /* Using cursor T003P4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( (0==A6LegNumero) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegNumero_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A76LegLicenIni)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fecha de Inicio", ""), "", "", "", "", "", "", "", ""), 1, "LEGLICENINI");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegLicenIni_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) )
      {
         GXv_boolean3[0] = AV19existe ;
         new web.getlicenciavalorenrango(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV9LegNumero, A506LegLicSitCodigo, A481LegLicenFin, A76LegLicenIni, GXv_boolean3) ;
         faltas_y_tardes_impl.this.AV19existe = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19existe", AV19existe);
      }
      if ( ( AV19existe ) && ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Novedad duplicadada ", ""), 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor T003P5 */
      pr_default.execute(3, new Object[] {A506LegLicSitCodigo});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Situacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGLICSITCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynLegLicSitCodigo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      if ( (GXutil.strcmp("", A506LegLicSitCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Situación de Revista", ""), "", "", "", "", "", "", "", ""), 1, "LEGLICSITCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynLegLicSitCodigo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_64 = (short)(1) ;
         A481LegLicenFin = A76LegLicenIni ;
         httpContext.ajax_rsp_assign_attri("", false, "A481LegLicenFin", localUtil.format(A481LegLicenFin, "99/99/99"));
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) )
      {
         nIsDirty_64 = (short)(1) ;
         A501LegLicCntDias = (short)(GXutil.ddiff(A481LegLicenFin,A76LegLicenIni)+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "A501LegLicCntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A501LegLicCntDias), 4, 0));
      }
      else
      {
         nIsDirty_64 = (short)(1) ;
         A501LegLicCntDias = (short)(GXutil.ddiff(GXutil.eomdate( A76LegLicenIni),A76LegLicenIni)+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "A501LegLicCntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A501LegLicCntDias), 4, 0));
      }
      if ( GXutil.resetTime(A481LegLicenFin).before( GXutil.resetTime( A76LegLicenIni )) && ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La fecha de Fin debe ser mayor o igual a la fecha de inicio", ""), 1, "LEGLICENINI");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegLicenIni_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors3P64( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_38( int A3CliCod ,
                          short A1EmpCod ,
                          int A6LegNumero )
   {
      /* Using cursor T003P7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
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

   public void gxload_39( String A506LegLicSitCodigo )
   {
      /* Using cursor T003P8 */
      pr_default.execute(6, new Object[] {A506LegLicSitCodigo});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Situacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGLICSITCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynLegLicSitCodigo.getInternalname() ;
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

   public void getKey3P64( )
   {
      /* Using cursor T003P9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound64 = (short)(1) ;
      }
      else
      {
         RcdFound64 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T003P3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm3P64( 37) ;
         RcdFound64 = (short)(1) ;
         A76LegLicenIni = T003P3_A76LegLicenIni[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A76LegLicenIni", localUtil.format(A76LegLicenIni, "99/99/99"));
         A517LegLicSitDescrip = T003P3_A517LegLicSitDescrip[0] ;
         A914LegLicDescrip = T003P3_A914LegLicDescrip[0] ;
         A1497LegLicEstado = T003P3_A1497LegLicEstado[0] ;
         A481LegLicenFin = T003P3_A481LegLicenFin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A481LegLicenFin", localUtil.format(A481LegLicenFin, "99/99/99"));
         A1218LegLicConPlus = T003P3_A1218LegLicConPlus[0] ;
         A1287LegSitEsLic = T003P3_A1287LegSitEsLic[0] ;
         A1288LegSitEsAu = T003P3_A1288LegSitEsAu[0] ;
         A1289LegSitEsAfip = T003P3_A1289LegSitEsAfip[0] ;
         A1643LegSitCuenTrab = T003P3_A1643LegSitCuenTrab[0] ;
         A1808LegLicCanPres = T003P3_A1808LegLicCanPres[0] ;
         A1810LegLicRemCorr = T003P3_A1810LegLicRemCorr[0] ;
         A3CliCod = T003P3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T003P3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T003P3_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A506LegLicSitCodigo = T003P3_A506LegLicSitCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A506LegLicSitCodigo", A506LegLicSitCodigo);
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z76LegLicenIni = A76LegLicenIni ;
         sMode64 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load3P64( ) ;
         if ( AnyError == 1 )
         {
            RcdFound64 = (short)(0) ;
            initializeNonKey3P64( ) ;
         }
         Gx_mode = sMode64 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound64 = (short)(0) ;
         initializeNonKey3P64( ) ;
         sMode64 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode64 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey3P64( ) ;
      if ( RcdFound64 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound64 = (short)(0) ;
      /* Using cursor T003P10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A76LegLicenIni});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T003P10_A3CliCod[0] < A3CliCod ) || ( T003P10_A3CliCod[0] == A3CliCod ) && ( T003P10_A1EmpCod[0] < A1EmpCod ) || ( T003P10_A1EmpCod[0] == A1EmpCod ) && ( T003P10_A3CliCod[0] == A3CliCod ) && ( T003P10_A6LegNumero[0] < A6LegNumero ) || ( T003P10_A6LegNumero[0] == A6LegNumero ) && ( T003P10_A1EmpCod[0] == A1EmpCod ) && ( T003P10_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T003P10_A76LegLicenIni[0]).before( GXutil.resetTime( A76LegLicenIni )) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T003P10_A3CliCod[0] > A3CliCod ) || ( T003P10_A3CliCod[0] == A3CliCod ) && ( T003P10_A1EmpCod[0] > A1EmpCod ) || ( T003P10_A1EmpCod[0] == A1EmpCod ) && ( T003P10_A3CliCod[0] == A3CliCod ) && ( T003P10_A6LegNumero[0] > A6LegNumero ) || ( T003P10_A6LegNumero[0] == A6LegNumero ) && ( T003P10_A1EmpCod[0] == A1EmpCod ) && ( T003P10_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T003P10_A76LegLicenIni[0]).after( GXutil.resetTime( A76LegLicenIni )) ) )
         {
            A3CliCod = T003P10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T003P10_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T003P10_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A76LegLicenIni = T003P10_A76LegLicenIni[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A76LegLicenIni", localUtil.format(A76LegLicenIni, "99/99/99"));
            RcdFound64 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound64 = (short)(0) ;
      /* Using cursor T003P11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A76LegLicenIni});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T003P11_A3CliCod[0] > A3CliCod ) || ( T003P11_A3CliCod[0] == A3CliCod ) && ( T003P11_A1EmpCod[0] > A1EmpCod ) || ( T003P11_A1EmpCod[0] == A1EmpCod ) && ( T003P11_A3CliCod[0] == A3CliCod ) && ( T003P11_A6LegNumero[0] > A6LegNumero ) || ( T003P11_A6LegNumero[0] == A6LegNumero ) && ( T003P11_A1EmpCod[0] == A1EmpCod ) && ( T003P11_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T003P11_A76LegLicenIni[0]).after( GXutil.resetTime( A76LegLicenIni )) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T003P11_A3CliCod[0] < A3CliCod ) || ( T003P11_A3CliCod[0] == A3CliCod ) && ( T003P11_A1EmpCod[0] < A1EmpCod ) || ( T003P11_A1EmpCod[0] == A1EmpCod ) && ( T003P11_A3CliCod[0] == A3CliCod ) && ( T003P11_A6LegNumero[0] < A6LegNumero ) || ( T003P11_A6LegNumero[0] == A6LegNumero ) && ( T003P11_A1EmpCod[0] == A1EmpCod ) && ( T003P11_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T003P11_A76LegLicenIni[0]).before( GXutil.resetTime( A76LegLicenIni )) ) )
         {
            A3CliCod = T003P11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T003P11_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T003P11_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A76LegLicenIni = T003P11_A76LegLicenIni[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A76LegLicenIni", localUtil.format(A76LegLicenIni, "99/99/99"));
            RcdFound64 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey3P64( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtLegNumero_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert3P64( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound64 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || !( GXutil.dateCompare(GXutil.resetTime(A76LegLicenIni), GXutil.resetTime(Z76LegLicenIni)) ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A6LegNumero = Z6LegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A76LegLicenIni = Z76LegLicenIni ;
               httpContext.ajax_rsp_assign_attri("", false, "A76LegLicenIni", localUtil.format(A76LegLicenIni, "99/99/99"));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update3P64( ) ;
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || !( GXutil.dateCompare(GXutil.resetTime(A76LegLicenIni), GXutil.resetTime(Z76LegLicenIni)) ) )
            {
               /* Insert record */
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert3P64( ) ;
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
                  GX_FocusControl = edtLegNumero_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert3P64( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || !( GXutil.dateCompare(GXutil.resetTime(A76LegLicenIni), GXutil.resetTime(Z76LegLicenIni)) ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = Z6LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A76LegLicenIni = Z76LegLicenIni ;
         httpContext.ajax_rsp_assign_attri("", false, "A76LegLicenIni", localUtil.format(A76LegLicenIni, "99/99/99"));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtLegNumero_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency3P64( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T003P2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoLicencias"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z517LegLicSitDescrip, T003P2_A517LegLicSitDescrip[0]) != 0 ) || ( GXutil.strcmp(Z914LegLicDescrip, T003P2_A914LegLicDescrip[0]) != 0 ) || ( GXutil.strcmp(Z1497LegLicEstado, T003P2_A1497LegLicEstado[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z481LegLicenFin), GXutil.resetTime(T003P2_A481LegLicenFin[0])) ) || ( Z1218LegLicConPlus != T003P2_A1218LegLicConPlus[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1287LegSitEsLic != T003P2_A1287LegSitEsLic[0] ) || ( Z1288LegSitEsAu != T003P2_A1288LegSitEsAu[0] ) || ( Z1289LegSitEsAfip != T003P2_A1289LegSitEsAfip[0] ) || ( Z1643LegSitCuenTrab != T003P2_A1643LegSitCuenTrab[0] ) || ( Z1808LegLicCanPres != T003P2_A1808LegLicCanPres[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1810LegLicRemCorr != T003P2_A1810LegLicRemCorr[0] ) || ( GXutil.strcmp(Z506LegLicSitCodigo, T003P2_A506LegLicSitCodigo[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z517LegLicSitDescrip, T003P2_A517LegLicSitDescrip[0]) != 0 )
            {
               GXutil.writeLogln("faltas_y_tardes:[seudo value changed for attri]"+"LegLicSitDescrip");
               GXutil.writeLogRaw("Old: ",Z517LegLicSitDescrip);
               GXutil.writeLogRaw("Current: ",T003P2_A517LegLicSitDescrip[0]);
            }
            if ( GXutil.strcmp(Z914LegLicDescrip, T003P2_A914LegLicDescrip[0]) != 0 )
            {
               GXutil.writeLogln("faltas_y_tardes:[seudo value changed for attri]"+"LegLicDescrip");
               GXutil.writeLogRaw("Old: ",Z914LegLicDescrip);
               GXutil.writeLogRaw("Current: ",T003P2_A914LegLicDescrip[0]);
            }
            if ( GXutil.strcmp(Z1497LegLicEstado, T003P2_A1497LegLicEstado[0]) != 0 )
            {
               GXutil.writeLogln("faltas_y_tardes:[seudo value changed for attri]"+"LegLicEstado");
               GXutil.writeLogRaw("Old: ",Z1497LegLicEstado);
               GXutil.writeLogRaw("Current: ",T003P2_A1497LegLicEstado[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z481LegLicenFin), GXutil.resetTime(T003P2_A481LegLicenFin[0])) ) )
            {
               GXutil.writeLogln("faltas_y_tardes:[seudo value changed for attri]"+"LegLicenFin");
               GXutil.writeLogRaw("Old: ",Z481LegLicenFin);
               GXutil.writeLogRaw("Current: ",T003P2_A481LegLicenFin[0]);
            }
            if ( Z1218LegLicConPlus != T003P2_A1218LegLicConPlus[0] )
            {
               GXutil.writeLogln("faltas_y_tardes:[seudo value changed for attri]"+"LegLicConPlus");
               GXutil.writeLogRaw("Old: ",Z1218LegLicConPlus);
               GXutil.writeLogRaw("Current: ",T003P2_A1218LegLicConPlus[0]);
            }
            if ( Z1287LegSitEsLic != T003P2_A1287LegSitEsLic[0] )
            {
               GXutil.writeLogln("faltas_y_tardes:[seudo value changed for attri]"+"LegSitEsLic");
               GXutil.writeLogRaw("Old: ",Z1287LegSitEsLic);
               GXutil.writeLogRaw("Current: ",T003P2_A1287LegSitEsLic[0]);
            }
            if ( Z1288LegSitEsAu != T003P2_A1288LegSitEsAu[0] )
            {
               GXutil.writeLogln("faltas_y_tardes:[seudo value changed for attri]"+"LegSitEsAu");
               GXutil.writeLogRaw("Old: ",Z1288LegSitEsAu);
               GXutil.writeLogRaw("Current: ",T003P2_A1288LegSitEsAu[0]);
            }
            if ( Z1289LegSitEsAfip != T003P2_A1289LegSitEsAfip[0] )
            {
               GXutil.writeLogln("faltas_y_tardes:[seudo value changed for attri]"+"LegSitEsAfip");
               GXutil.writeLogRaw("Old: ",Z1289LegSitEsAfip);
               GXutil.writeLogRaw("Current: ",T003P2_A1289LegSitEsAfip[0]);
            }
            if ( Z1643LegSitCuenTrab != T003P2_A1643LegSitCuenTrab[0] )
            {
               GXutil.writeLogln("faltas_y_tardes:[seudo value changed for attri]"+"LegSitCuenTrab");
               GXutil.writeLogRaw("Old: ",Z1643LegSitCuenTrab);
               GXutil.writeLogRaw("Current: ",T003P2_A1643LegSitCuenTrab[0]);
            }
            if ( Z1808LegLicCanPres != T003P2_A1808LegLicCanPres[0] )
            {
               GXutil.writeLogln("faltas_y_tardes:[seudo value changed for attri]"+"LegLicCanPres");
               GXutil.writeLogRaw("Old: ",Z1808LegLicCanPres);
               GXutil.writeLogRaw("Current: ",T003P2_A1808LegLicCanPres[0]);
            }
            if ( Z1810LegLicRemCorr != T003P2_A1810LegLicRemCorr[0] )
            {
               GXutil.writeLogln("faltas_y_tardes:[seudo value changed for attri]"+"LegLicRemCorr");
               GXutil.writeLogRaw("Old: ",Z1810LegLicRemCorr);
               GXutil.writeLogRaw("Current: ",T003P2_A1810LegLicRemCorr[0]);
            }
            if ( GXutil.strcmp(Z506LegLicSitCodigo, T003P2_A506LegLicSitCodigo[0]) != 0 )
            {
               GXutil.writeLogln("faltas_y_tardes:[seudo value changed for attri]"+"LegLicSitCodigo");
               GXutil.writeLogRaw("Old: ",Z506LegLicSitCodigo);
               GXutil.writeLogRaw("Current: ",T003P2_A506LegLicSitCodigo[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LegajoLicencias"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3P64( )
   {
      beforeValidate3P64( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3P64( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3P64( 0) ;
         checkOptimisticConcurrency3P64( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3P64( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3P64( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003P12 */
                  pr_default.execute(10, new Object[] {A76LegLicenIni, A517LegLicSitDescrip, A914LegLicDescrip, A1497LegLicEstado, A481LegLicenFin, Boolean.valueOf(A1218LegLicConPlus), Byte.valueOf(A1287LegSitEsLic), Byte.valueOf(A1288LegSitEsAu), Byte.valueOf(A1289LegSitEsAfip), Byte.valueOf(A1643LegSitCuenTrab), Byte.valueOf(A1808LegLicCanPres), Byte.valueOf(A1810LegLicRemCorr), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A506LegLicSitCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoLicencias");
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
                        resetCaption3P0( ) ;
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
            load3P64( ) ;
         }
         endLevel3P64( ) ;
      }
      closeExtendedTableCursors3P64( ) ;
   }

   public void update3P64( )
   {
      beforeValidate3P64( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3P64( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3P64( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3P64( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3P64( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003P13 */
                  pr_default.execute(11, new Object[] {A517LegLicSitDescrip, A914LegLicDescrip, A1497LegLicEstado, A481LegLicenFin, Boolean.valueOf(A1218LegLicConPlus), Byte.valueOf(A1287LegSitEsLic), Byte.valueOf(A1288LegSitEsAu), Byte.valueOf(A1289LegSitEsAfip), Byte.valueOf(A1643LegSitCuenTrab), Byte.valueOf(A1808LegLicCanPres), Byte.valueOf(A1810LegLicRemCorr), A506LegLicSitCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoLicencias");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoLicencias"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate3P64( ) ;
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
         endLevel3P64( ) ;
      }
      closeExtendedTableCursors3P64( ) ;
   }

   public void deferredUpdate3P64( )
   {
   }

   public void delete( )
   {
      beforeValidate3P64( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3P64( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3P64( ) ;
         afterConfirm3P64( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3P64( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T003P14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoLicencias");
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
      sMode64 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel3P64( ) ;
      Gx_mode = sMode64 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls3P64( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV37Pgmname = "faltas_y_tardes" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37Pgmname", AV37Pgmname);
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) )
         {
            A501LegLicCntDias = (short)(GXutil.ddiff(A481LegLicenFin,A76LegLicenIni)+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "A501LegLicCntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A501LegLicCntDias), 4, 0));
         }
         else
         {
            A501LegLicCntDias = (short)(GXutil.ddiff(GXutil.eomdate( A76LegLicenIni),A76LegLicenIni)+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "A501LegLicCntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A501LegLicCntDias), 4, 0));
         }
      }
   }

   public void endLevel3P64( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete3P64( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "faltas_y_tardes");
         if ( AnyError == 0 )
         {
            confirmValues3P0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "faltas_y_tardes");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart3P64( )
   {
      /* Scan By routine */
      /* Using cursor T003P15 */
      pr_default.execute(13);
      RcdFound64 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound64 = (short)(1) ;
         A3CliCod = T003P15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T003P15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T003P15_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A76LegLicenIni = T003P15_A76LegLicenIni[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A76LegLicenIni", localUtil.format(A76LegLicenIni, "99/99/99"));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext3P64( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound64 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound64 = (short)(1) ;
         A3CliCod = T003P15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T003P15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T003P15_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A76LegLicenIni = T003P15_A76LegLicenIni[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A76LegLicenIni", localUtil.format(A76LegLicenIni, "99/99/99"));
      }
   }

   public void scanEnd3P64( )
   {
      pr_default.close(13);
   }

   public void afterConfirm3P64( )
   {
      /* After Confirm Rules */
      GXt_char9 = A517LegLicSitDescrip ;
      GXv_char5[0] = GXt_char9 ;
      new web.getsituaciondescrip(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_char5) ;
      faltas_y_tardes_impl.this.GXt_char9 = GXv_char5[0] ;
      A517LegLicSitDescrip = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri("", false, "A517LegLicSitDescrip", A517LegLicSitDescrip);
      GXt_char9 = A914LegLicDescrip ;
      GXv_char5[0] = GXt_char9 ;
      new web.getsituaciondescripabr(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_char5) ;
      faltas_y_tardes_impl.this.GXt_char9 = GXv_char5[0] ;
      A914LegLicDescrip = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri("", false, "A914LegLicDescrip", A914LegLicDescrip);
      GXv_boolean3[0] = AV33SitEsLicencia ;
      GXv_boolean10[0] = AV32sitEsAusencia ;
      GXv_boolean11[0] = AV31SitLicCuentaTrab ;
      GXv_boolean12[0] = AV30SitEsRevistaAFip ;
      GXv_boolean13[0] = false ;
      GXv_boolean14[0] = AV34EstadoCanPresen ;
      GXv_boolean15[0] = AV35EstadoRemCorr ;
      new web.getsituacionlicenciaprops(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_boolean3, GXv_boolean10, GXv_boolean11, GXv_boolean12, GXv_boolean13, GXv_boolean14, GXv_boolean15) ;
      faltas_y_tardes_impl.this.AV33SitEsLicencia = GXv_boolean3[0] ;
      faltas_y_tardes_impl.this.AV32sitEsAusencia = GXv_boolean10[0] ;
      faltas_y_tardes_impl.this.AV31SitLicCuentaTrab = GXv_boolean11[0] ;
      faltas_y_tardes_impl.this.AV30SitEsRevistaAFip = GXv_boolean12[0] ;
      faltas_y_tardes_impl.this.AV34EstadoCanPresen = GXv_boolean14[0] ;
      faltas_y_tardes_impl.this.AV35EstadoRemCorr = GXv_boolean15[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33SitEsLicencia", AV33SitEsLicencia);
      httpContext.ajax_rsp_assign_attri("", false, "AV32sitEsAusencia", AV32sitEsAusencia);
      httpContext.ajax_rsp_assign_attri("", false, "AV31SitLicCuentaTrab", AV31SitLicCuentaTrab);
      httpContext.ajax_rsp_assign_attri("", false, "AV30SitEsRevistaAFip", AV30SitEsRevistaAFip);
      httpContext.ajax_rsp_assign_attri("", false, "AV34EstadoCanPresen", AV34EstadoCanPresen);
      httpContext.ajax_rsp_assign_attri("", false, "AV35EstadoRemCorr", AV35EstadoRemCorr);
      A1810LegLicRemCorr = (byte)((AV35EstadoRemCorr ? 1 : 0)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1810LegLicRemCorr", GXutil.str( A1810LegLicRemCorr, 1, 0));
      A1808LegLicCanPres = (byte)((AV34EstadoCanPresen ? 1 : 0)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1808LegLicCanPres", GXutil.str( A1808LegLicCanPres, 1, 0));
      A1289LegSitEsAfip = (byte)((AV30SitEsRevistaAFip ? 1 : 0)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1289LegSitEsAfip", GXutil.str( A1289LegSitEsAfip, 1, 0));
      A1643LegSitCuenTrab = (byte)((AV31SitLicCuentaTrab ? 1 : 0)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1643LegSitCuenTrab", GXutil.str( A1643LegSitCuenTrab, 1, 0));
      A1288LegSitEsAu = (byte)((AV32sitEsAusencia ? 1 : 0)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1288LegSitEsAu", GXutil.str( A1288LegSitEsAu, 1, 0));
      A1287LegSitEsLic = (byte)((AV33SitEsLicencia ? 1 : 0)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1287LegSitEsLic", GXutil.str( A1287LegSitEsLic, 1, 0));
   }

   public void beforeInsert3P64( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3P64( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3P64( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3P64( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3P64( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3P64( )
   {
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      edtLegLicenIni_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegLicenIni_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegLicenIni_Enabled), 5, 0), true);
      edtLegLicenFin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegLicenFin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegLicenFin_Enabled), 5, 0), true);
      dynLegLicSitCodigo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynLegLicSitCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegLicSitCodigo.getEnabled(), 5, 0), true);
      edtavCombolegnumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombolegnumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombolegnumero_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes3P64( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues3P0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.faltas_y_tardes", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LegNumero,8,0)),GXutil.URLEncode(GXutil.formatDateParm(AV10LegLicenIni))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero","LegLicenIni"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"faltas_y_tardes");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("LegLicEstado", GXutil.rtrim( localUtil.format( A1497LegLicEstado, "")));
      forbiddenHiddens.add("LegLicConPlus", GXutil.booltostr( A1218LegLicConPlus));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("faltas_y_tardes:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z76LegLicenIni", localUtil.dtoc( Z76LegLicenIni, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z517LegLicSitDescrip", Z517LegLicSitDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z914LegLicDescrip", Z914LegLicDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1497LegLicEstado", GXutil.rtrim( Z1497LegLicEstado));
      web.GxWebStd.gx_hidden_field( httpContext, "Z481LegLicenFin", localUtil.dtoc( Z481LegLicenFin, 0, "/"));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1218LegLicConPlus", Z1218LegLicConPlus);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1287LegSitEsLic", GXutil.ltrim( localUtil.ntoc( Z1287LegSitEsLic, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1288LegSitEsAu", GXutil.ltrim( localUtil.ntoc( Z1288LegSitEsAu, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1289LegSitEsAfip", GXutil.ltrim( localUtil.ntoc( Z1289LegSitEsAfip, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1643LegSitCuenTrab", GXutil.ltrim( localUtil.ntoc( Z1643LegSitCuenTrab, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1808LegLicCanPres", GXutil.ltrim( localUtil.ntoc( Z1808LegLicCanPres, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1810LegLicRemCorr", GXutil.ltrim( localUtil.ntoc( Z1810LegLicRemCorr, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z506LegLicSitCodigo", GXutil.rtrim( Z506LegLicSitCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N506LegLicSitCodigo", GXutil.rtrim( A506LegLicSitCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGNUMERO_DATA", AV20LegNumero_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGNUMERO_DATA", AV20LegNumero_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "LEGLICCNTDIAS", GXutil.ltrim( localUtil.ntoc( A501LegLicCntDias, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV9LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGLICENINI", localUtil.dtoc( AV10LegLicenIni, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGLICENINI", getSecureSignedToken( "", AV10LegLicenIni));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_LEGLICSITCODIGO", GXutil.rtrim( AV25Insert_LegLicSitCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGLICSITDESCRIP", A517LegLicSitDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGLICDESCRIP", A914LegLicDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGLICESTADO", GXutil.rtrim( A1497LegLicEstado));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vSITESLICENCIA", AV33SitEsLicencia);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGSITESLIC", GXutil.ltrim( localUtil.ntoc( A1287LegSitEsLic, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vSITESAUSENCIA", AV32sitEsAusencia);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGSITESAU", GXutil.ltrim( localUtil.ntoc( A1288LegSitEsAu, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vSITESREVISTAAFIP", AV30SitEsRevistaAFip);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGSITESAFIP", GXutil.ltrim( localUtil.ntoc( A1289LegSitEsAfip, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vSITLICCUENTATRAB", AV31SitLicCuentaTrab);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGSITCUENTRAB", GXutil.ltrim( localUtil.ntoc( A1643LegSitCuenTrab, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vESTADOCANPRESEN", AV34EstadoCanPresen);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGLICCANPRES", GXutil.ltrim( localUtil.ntoc( A1808LegLicCanPres, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vESTADOREMCORR", AV35EstadoRemCorr);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGLICREMCORR", GXutil.ltrim( localUtil.ntoc( A1810LegLicRemCorr, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vEXISTE", AV19existe);
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "LEGLICCONPLUS", A1218LegLicConPlus);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV37Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Objectcall", GXutil.rtrim( Combo_legnumero_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Cls", GXutil.rtrim( Combo_legnumero_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Selectedvalue_set", GXutil.rtrim( Combo_legnumero_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Enabled", GXutil.booltostr( Combo_legnumero_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Emptyitem", GXutil.booltostr( Combo_legnumero_Emptyitem));
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
      return formatLink("web.faltas_y_tardes", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LegNumero,8,0)),GXutil.URLEncode(GXutil.formatDateParm(AV10LegLicenIni))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero","LegLicenIni"})  ;
   }

   public String getPgmname( )
   {
      return "faltas_y_tardes" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Novedad Eventos", "") ;
   }

   public void initializeNonKey3P64( )
   {
      A506LegLicSitCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A506LegLicSitCodigo", A506LegLicSitCodigo);
      A517LegLicSitDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A517LegLicSitDescrip", A517LegLicSitDescrip);
      A914LegLicDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A914LegLicDescrip", A914LegLicDescrip);
      AV19existe = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19existe", AV19existe);
      AV33SitEsLicencia = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33SitEsLicencia", AV33SitEsLicencia);
      AV32sitEsAusencia = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32sitEsAusencia", AV32sitEsAusencia);
      AV31SitLicCuentaTrab = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31SitLicCuentaTrab", AV31SitLicCuentaTrab);
      AV30SitEsRevistaAFip = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30SitEsRevistaAFip", AV30SitEsRevistaAFip);
      AV34EstadoCanPresen = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34EstadoCanPresen", AV34EstadoCanPresen);
      AV35EstadoRemCorr = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35EstadoRemCorr", AV35EstadoRemCorr);
      A1497LegLicEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1497LegLicEstado", A1497LegLicEstado);
      A501LegLicCntDias = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A501LegLicCntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A501LegLicCntDias), 4, 0));
      A1218LegLicConPlus = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1218LegLicConPlus", A1218LegLicConPlus);
      A1287LegSitEsLic = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1287LegSitEsLic", GXutil.str( A1287LegSitEsLic, 1, 0));
      A1288LegSitEsAu = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1288LegSitEsAu", GXutil.str( A1288LegSitEsAu, 1, 0));
      A1289LegSitEsAfip = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1289LegSitEsAfip", GXutil.str( A1289LegSitEsAfip, 1, 0));
      A1643LegSitCuenTrab = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1643LegSitCuenTrab", GXutil.str( A1643LegSitCuenTrab, 1, 0));
      A1808LegLicCanPres = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1808LegLicCanPres", GXutil.str( A1808LegLicCanPres, 1, 0));
      A1810LegLicRemCorr = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1810LegLicRemCorr", GXutil.str( A1810LegLicRemCorr, 1, 0));
      A481LegLicenFin = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A481LegLicenFin", localUtil.format(A481LegLicenFin, "99/99/99"));
      Z517LegLicSitDescrip = "" ;
      Z914LegLicDescrip = "" ;
      Z1497LegLicEstado = "" ;
      Z481LegLicenFin = GXutil.nullDate() ;
      Z1218LegLicConPlus = false ;
      Z1287LegSitEsLic = (byte)(0) ;
      Z1288LegSitEsAu = (byte)(0) ;
      Z1289LegSitEsAfip = (byte)(0) ;
      Z1643LegSitCuenTrab = (byte)(0) ;
      Z1808LegLicCanPres = (byte)(0) ;
      Z1810LegLicRemCorr = (byte)(0) ;
      Z506LegLicSitCodigo = "" ;
   }

   public void initAll3P64( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      A76LegLicenIni = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A76LegLicenIni", localUtil.format(A76LegLicenIni, "99/99/99"));
      initializeNonKey3P64( ) ;
   }

   public void standaloneModalInsert( )
   {
      A1497LegLicEstado = i1497LegLicEstado ;
      httpContext.ajax_rsp_assign_attri("", false, "A1497LegLicEstado", A1497LegLicEstado);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713391672", true, true);
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
      httpContext.AddJavascriptSource("faltas_y_tardes.js", "?20251713391672", false, true);
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
      lblTextblocklegnumero_Internalname = "TEXTBLOCKLEGNUMERO" ;
      Combo_legnumero_Internalname = "COMBO_LEGNUMERO" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      divTablesplittedlegnumero_Internalname = "TABLESPLITTEDLEGNUMERO" ;
      edtLegLicenIni_Internalname = "LEGLICENINI" ;
      edtLegLicenFin_Internalname = "LEGLICENFIN" ;
      edtavCntdias_Internalname = "vCNTDIAS" ;
      dynLegLicSitCodigo.setInternalname( "LEGLICSITCODIGO" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombolegnumero_Internalname = "vCOMBOLEGNUMERO" ;
      divSectionattribute_legnumero_Internalname = "SECTIONATTRIBUTE_LEGNUMERO" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
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
      Form.setCaption( httpContext.getMessage( "Novedad Eventos", "") );
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavCombolegnumero_Jsonclick = "" ;
      edtavCombolegnumero_Enabled = 0 ;
      edtavCombolegnumero_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynLegLicSitCodigo.setJsonclick( "" );
      dynLegLicSitCodigo.setEnabled( 1 );
      edtavCntdias_Jsonclick = "" ;
      edtavCntdias_Enabled = 0 ;
      edtLegLicenFin_Jsonclick = "" ;
      edtLegLicenFin_Enabled = 1 ;
      edtLegLicenIni_Jsonclick = "" ;
      edtLegLicenIni_Enabled = 1 ;
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Enabled = 1 ;
      edtLegNumero_Visible = 1 ;
      Combo_legnumero_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_legnumero_Cls = "ExtendedCombo Attribute" ;
      Combo_legnumero_Enabled = GXutil.toBoolean( -1) ;
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

   public void gxdlaleglicsitcodigo3P64( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaleglicsitcodigo_data3P64( ) ;
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

   public void gxaleglicsitcodigo_html3P64( )
   {
      String gxdynajaxvalue;
      gxdlaleglicsitcodigo_data3P64( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynLegLicSitCodigo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynLegLicSitCodigo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaleglicsitcodigo_data3P64( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T003P16 */
      pr_default.execute(14);
      while ( (pr_default.getStatus(14) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T003P16_A506LegLicSitCodigo[0]));
         gxdynajaxctrldescr.add(T003P16_A913sItDescAbrev[0]);
         pr_default.readNext(14);
      }
      pr_default.close(14);
   }

   public void gx4asaclicod3P64( int AV7CliCod )
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
            GXt_int7 = A3CliCod ;
            GXv_int8[0] = GXt_int7 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
            faltas_y_tardes_impl.this.GXt_int7 = GXv_int8[0] ;
            A3CliCod = GXt_int7 ;
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

   public void gx14asaleglicsitdescrip3P64( String A506LegLicSitCodigo )
   {
      GXt_char9 = A517LegLicSitDescrip ;
      GXv_char5[0] = GXt_char9 ;
      new web.getsituaciondescrip(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_char5) ;
      faltas_y_tardes_impl.this.GXt_char9 = GXv_char5[0] ;
      A517LegLicSitDescrip = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri("", false, "A517LegLicSitDescrip", A517LegLicSitDescrip);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A517LegLicSitDescrip)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx15asaleglicdescrip3P64( String A506LegLicSitCodigo )
   {
      GXt_char9 = A914LegLicDescrip ;
      GXv_char5[0] = GXt_char9 ;
      new web.getsituaciondescripabr(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_char5) ;
      faltas_y_tardes_impl.this.GXt_char9 = GXv_char5[0] ;
      A914LegLicDescrip = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri("", false, "A914LegLicDescrip", A914LegLicDescrip);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A914LegLicDescrip)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_34_3P64( int AV7CliCod ,
                           short AV8EmpCod ,
                           int AV9LegNumero ,
                           String A506LegLicSitCodigo ,
                           java.util.Date A481LegLicenFin ,
                           java.util.Date A76LegLicenIni ,
                           String Gx_mode )
   {
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) )
      {
         GXv_boolean15[0] = AV19existe ;
         new web.getlicenciavalorenrango(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV9LegNumero, A506LegLicSitCodigo, A481LegLicenFin, A76LegLicenIni, GXv_boolean15) ;
         AV19existe = GXv_boolean15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19existe", AV19existe);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV19existe))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_36_3P64( String A506LegLicSitCodigo )
   {
      GXv_boolean15[0] = AV33SitEsLicencia ;
      GXv_boolean14[0] = AV32sitEsAusencia ;
      GXv_boolean13[0] = AV31SitLicCuentaTrab ;
      GXv_boolean12[0] = AV30SitEsRevistaAFip ;
      GXv_boolean11[0] = false ;
      GXv_boolean10[0] = AV34EstadoCanPresen ;
      GXv_boolean3[0] = AV35EstadoRemCorr ;
      new web.getsituacionlicenciaprops(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_boolean15, GXv_boolean14, GXv_boolean13, GXv_boolean12, GXv_boolean11, GXv_boolean10, GXv_boolean3) ;
      AV33SitEsLicencia = GXv_boolean15[0] ;
      AV32sitEsAusencia = GXv_boolean14[0] ;
      AV31SitLicCuentaTrab = GXv_boolean13[0] ;
      AV30SitEsRevistaAFip = GXv_boolean12[0] ;
      AV34EstadoCanPresen = GXv_boolean10[0] ;
      AV35EstadoRemCorr = GXv_boolean3[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33SitEsLicencia", AV33SitEsLicencia);
      httpContext.ajax_rsp_assign_attri("", false, "AV32sitEsAusencia", AV32sitEsAusencia);
      httpContext.ajax_rsp_assign_attri("", false, "AV31SitLicCuentaTrab", AV31SitLicCuentaTrab);
      httpContext.ajax_rsp_assign_attri("", false, "AV30SitEsRevistaAFip", AV30SitEsRevistaAFip);
      httpContext.ajax_rsp_assign_attri("", false, "AV34EstadoCanPresen", AV34EstadoCanPresen);
      httpContext.ajax_rsp_assign_attri("", false, "AV35EstadoRemCorr", AV35EstadoRemCorr);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV33SitEsLicencia))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV32sitEsAusencia))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV31SitLicCuentaTrab))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV30SitEsRevistaAFip))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV34EstadoCanPresen))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV35EstadoRemCorr))+"\"") ;
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
      dynLegLicSitCodigo.setName( "LEGLICSITCODIGO" );
      dynLegLicSitCodigo.setWebtags( "" );
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

   public void valid_Leglicenini( )
   {
      A506LegLicSitCodigo = dynLegLicSitCodigo.getValue() ;
      if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) && ( Gx_BScreen == 0 ) )
      {
         A481LegLicenFin = A76LegLicenIni ;
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A76LegLicenIni)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fecha de Inicio", ""), "", "", "", "", "", "", "", ""), 1, "LEGLICENINI");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegLicenIni_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A481LegLicenFin", localUtil.format(A481LegLicenFin, "99/99/99"));
   }

   public void valid_Empcod( )
   {
      A506LegLicSitCodigo = dynLegLicSitCodigo.getValue() ;
      /* Using cursor T003P17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Leglicsitcodigo( )
   {
      A506LegLicSitCodigo = dynLegLicSitCodigo.getValue() ;
      /* Using cursor T003P18 */
      pr_default.execute(16, new Object[] {A506LegLicSitCodigo});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Situacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGLICSITCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynLegLicSitCodigo.getInternalname() ;
      }
      pr_default.close(16);
      if ( (GXutil.strcmp("", A506LegLicSitCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Situación de Revista", ""), "", "", "", "", "", "", "", ""), 1, "LEGLICSITCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynLegLicSitCodigo.getInternalname() ;
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) )
      {
         GXv_boolean15[0] = AV19existe ;
         new web.getlicenciavalorenrango(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV9LegNumero, A506LegLicSitCodigo, A481LegLicenFin, A76LegLicenIni, GXv_boolean15) ;
         faltas_y_tardes_impl.this.AV19existe = GXv_boolean15[0] ;
         AV19existe = this.AV19existe ;
      }
      if ( ( AV19existe ) && ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Novedad duplicadada ", ""), 1, "LEGLICSITCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynLegLicSitCodigo.getInternalname() ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV19existe", AV19existe);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LegLicenIni',fld:'vLEGLICENINI',pic:'',hsh:true},{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LegLicenIni',fld:'vLEGLICENINI',pic:'',hsh:true},{av:'A1497LegLicEstado',fld:'LEGLICESTADO',pic:''},{av:'A1218LegLicConPlus',fld:'LEGLICCONPLUS',pic:''},{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e123P2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]}");
      setEventMetadata("VALID_LEGLICENINI","{handler:'valid_Leglicenini',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'A76LegLicenIni',fld:'LEGLICENINI',pic:''},{av:'Gx_BScreen',fld:'vGXBSCREEN',pic:'9'},{av:'A481LegLicenFin',fld:'LEGLICENFIN',pic:''},{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]");
      setEventMetadata("VALID_LEGLICENINI",",oparms:[{av:'A481LegLicenFin',fld:'LEGLICENFIN',pic:''},{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]}");
      setEventMetadata("VALID_LEGLICENFIN","{handler:'valid_Leglicenfin',iparms:[{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]");
      setEventMetadata("VALID_LEGLICENFIN",",oparms:[{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]}");
      setEventMetadata("VALID_LEGLICSITCODIGO","{handler:'valid_Leglicsitcodigo',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'A481LegLicenFin',fld:'LEGLICENFIN',pic:''},{av:'A76LegLicenIni',fld:'LEGLICENINI',pic:''},{av:'AV19existe',fld:'vEXISTE',pic:''},{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]");
      setEventMetadata("VALID_LEGLICSITCODIGO",",oparms:[{av:'AV19existe',fld:'vEXISTE',pic:''},{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]}");
      setEventMetadata("VALIDV_COMBOLEGNUMERO","{handler:'validv_Combolegnumero',iparms:[{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]");
      setEventMetadata("VALIDV_COMBOLEGNUMERO",",oparms:[{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'dynLegLicSitCodigo'},{av:'A506LegLicSitCodigo',fld:'LEGLICSITCODIGO',pic:''}]}");
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
      pr_default.close(16);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV10LegLicenIni = GXutil.nullDate() ;
      Z76LegLicenIni = GXutil.nullDate() ;
      Z517LegLicSitDescrip = "" ;
      Z914LegLicDescrip = "" ;
      Z1497LegLicEstado = "" ;
      Z481LegLicenFin = GXutil.nullDate() ;
      Z506LegLicSitCodigo = "" ;
      N506LegLicSitCodigo = "" ;
      Combo_legnumero_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A506LegLicSitCodigo = "" ;
      A481LegLicenFin = GXutil.nullDate() ;
      A76LegLicenIni = GXutil.nullDate() ;
      Gx_mode = "" ;
      AV10LegLicenIni = GXutil.nullDate() ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblocklegnumero_Jsonclick = "" ;
      ucCombo_legnumero = new com.genexus.webpanels.GXUserControl();
      Combo_legnumero_Caption = "" ;
      AV20LegNumero_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A517LegLicSitDescrip = "" ;
      A914LegLicDescrip = "" ;
      A1497LegLicEstado = "" ;
      AV25Insert_LegLicSitCodigo = "" ;
      AV37Pgmname = "" ;
      Combo_legnumero_Objectcall = "" ;
      Combo_legnumero_Class = "" ;
      Combo_legnumero_Icontype = "" ;
      Combo_legnumero_Icon = "" ;
      Combo_legnumero_Tooltip = "" ;
      Combo_legnumero_Selectedvalue_set = "" ;
      Combo_legnumero_Selectedtext_set = "" ;
      Combo_legnumero_Selectedtext_get = "" ;
      Combo_legnumero_Gamoauthtoken = "" ;
      Combo_legnumero_Ddointernalname = "" ;
      Combo_legnumero_Titlecontrolalign = "" ;
      Combo_legnumero_Dropdownoptionstype = "" ;
      Combo_legnumero_Titlecontrolidtoreplace = "" ;
      Combo_legnumero_Datalisttype = "" ;
      Combo_legnumero_Datalistfixedvalues = "" ;
      Combo_legnumero_Datalistproc = "" ;
      Combo_legnumero_Datalistprocparametersprefix = "" ;
      Combo_legnumero_Remoteservicesparameters = "" ;
      Combo_legnumero_Htmltemplate = "" ;
      Combo_legnumero_Multiplevaluestype = "" ;
      Combo_legnumero_Loadingdata = "" ;
      Combo_legnumero_Noresultsfound = "" ;
      Combo_legnumero_Emptyitemtext = "" ;
      Combo_legnumero_Onlyselectedvalues = "" ;
      Combo_legnumero_Selectalltext = "" ;
      Combo_legnumero_Multiplevaluesseparator = "" ;
      Combo_legnumero_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode64 = "" ;
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
      AV26TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      GXt_objcol_SdtDVB_SDTComboData_Item4 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV17ComboSelectedValue = "" ;
      GXv_objcol_SdtDVB_SDTComboData_Item6 = new GXBaseCollection[1] ;
      T003P6_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      T003P6_A517LegLicSitDescrip = new String[] {""} ;
      T003P6_A914LegLicDescrip = new String[] {""} ;
      T003P6_A1497LegLicEstado = new String[] {""} ;
      T003P6_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      T003P6_A1218LegLicConPlus = new boolean[] {false} ;
      T003P6_A1287LegSitEsLic = new byte[1] ;
      T003P6_A1288LegSitEsAu = new byte[1] ;
      T003P6_A1289LegSitEsAfip = new byte[1] ;
      T003P6_A1643LegSitCuenTrab = new byte[1] ;
      T003P6_A1808LegLicCanPres = new byte[1] ;
      T003P6_A1810LegLicRemCorr = new byte[1] ;
      T003P6_A3CliCod = new int[1] ;
      T003P6_A1EmpCod = new short[1] ;
      T003P6_A6LegNumero = new int[1] ;
      T003P6_A506LegLicSitCodigo = new String[] {""} ;
      T003P4_A3CliCod = new int[1] ;
      T003P5_A506LegLicSitCodigo = new String[] {""} ;
      T003P7_A3CliCod = new int[1] ;
      T003P8_A506LegLicSitCodigo = new String[] {""} ;
      T003P9_A3CliCod = new int[1] ;
      T003P9_A1EmpCod = new short[1] ;
      T003P9_A6LegNumero = new int[1] ;
      T003P9_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      T003P3_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      T003P3_A517LegLicSitDescrip = new String[] {""} ;
      T003P3_A914LegLicDescrip = new String[] {""} ;
      T003P3_A1497LegLicEstado = new String[] {""} ;
      T003P3_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      T003P3_A1218LegLicConPlus = new boolean[] {false} ;
      T003P3_A1287LegSitEsLic = new byte[1] ;
      T003P3_A1288LegSitEsAu = new byte[1] ;
      T003P3_A1289LegSitEsAfip = new byte[1] ;
      T003P3_A1643LegSitCuenTrab = new byte[1] ;
      T003P3_A1808LegLicCanPres = new byte[1] ;
      T003P3_A1810LegLicRemCorr = new byte[1] ;
      T003P3_A3CliCod = new int[1] ;
      T003P3_A1EmpCod = new short[1] ;
      T003P3_A6LegNumero = new int[1] ;
      T003P3_A506LegLicSitCodigo = new String[] {""} ;
      T003P10_A3CliCod = new int[1] ;
      T003P10_A1EmpCod = new short[1] ;
      T003P10_A6LegNumero = new int[1] ;
      T003P10_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      T003P11_A3CliCod = new int[1] ;
      T003P11_A1EmpCod = new short[1] ;
      T003P11_A6LegNumero = new int[1] ;
      T003P11_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      T003P2_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      T003P2_A517LegLicSitDescrip = new String[] {""} ;
      T003P2_A914LegLicDescrip = new String[] {""} ;
      T003P2_A1497LegLicEstado = new String[] {""} ;
      T003P2_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      T003P2_A1218LegLicConPlus = new boolean[] {false} ;
      T003P2_A1287LegSitEsLic = new byte[1] ;
      T003P2_A1288LegSitEsAu = new byte[1] ;
      T003P2_A1289LegSitEsAfip = new byte[1] ;
      T003P2_A1643LegSitCuenTrab = new byte[1] ;
      T003P2_A1808LegLicCanPres = new byte[1] ;
      T003P2_A1810LegLicRemCorr = new byte[1] ;
      T003P2_A3CliCod = new int[1] ;
      T003P2_A1EmpCod = new short[1] ;
      T003P2_A6LegNumero = new int[1] ;
      T003P2_A506LegLicSitCodigo = new String[] {""} ;
      T003P15_A3CliCod = new int[1] ;
      T003P15_A1EmpCod = new short[1] ;
      T003P15_A6LegNumero = new int[1] ;
      T003P15_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i1497LegLicEstado = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T003P16_A506LegLicSitCodigo = new String[] {""} ;
      T003P16_A913sItDescAbrev = new String[] {""} ;
      T003P16_n913sItDescAbrev = new boolean[] {false} ;
      T003P16_A739SitLicCuentaTrab = new boolean[] {false} ;
      T003P16_n739SitLicCuentaTrab = new boolean[] {false} ;
      T003P16_A738SitEsLicencia = new boolean[] {false} ;
      T003P16_n738SitEsLicencia = new boolean[] {false} ;
      T003P16_A1598EstadoSitRevista = new short[1] ;
      T003P16_n1598EstadoSitRevista = new boolean[] {false} ;
      GXv_int8 = new int[1] ;
      GXt_char9 = "" ;
      GXv_char5 = new String[1] ;
      GXv_boolean14 = new boolean[1] ;
      GXv_boolean13 = new boolean[1] ;
      GXv_boolean12 = new boolean[1] ;
      GXv_boolean11 = new boolean[1] ;
      GXv_boolean10 = new boolean[1] ;
      GXv_boolean3 = new boolean[1] ;
      T003P17_A3CliCod = new int[1] ;
      T003P18_A506LegLicSitCodigo = new String[] {""} ;
      GXv_boolean15 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.faltas_y_tardes__default(),
         new Object[] {
             new Object[] {
            T003P2_A76LegLicenIni, T003P2_A517LegLicSitDescrip, T003P2_A914LegLicDescrip, T003P2_A1497LegLicEstado, T003P2_A481LegLicenFin, T003P2_A1218LegLicConPlus, T003P2_A1287LegSitEsLic, T003P2_A1288LegSitEsAu, T003P2_A1289LegSitEsAfip, T003P2_A1643LegSitCuenTrab,
            T003P2_A1808LegLicCanPres, T003P2_A1810LegLicRemCorr, T003P2_A3CliCod, T003P2_A1EmpCod, T003P2_A6LegNumero, T003P2_A506LegLicSitCodigo
            }
            , new Object[] {
            T003P3_A76LegLicenIni, T003P3_A517LegLicSitDescrip, T003P3_A914LegLicDescrip, T003P3_A1497LegLicEstado, T003P3_A481LegLicenFin, T003P3_A1218LegLicConPlus, T003P3_A1287LegSitEsLic, T003P3_A1288LegSitEsAu, T003P3_A1289LegSitEsAfip, T003P3_A1643LegSitCuenTrab,
            T003P3_A1808LegLicCanPres, T003P3_A1810LegLicRemCorr, T003P3_A3CliCod, T003P3_A1EmpCod, T003P3_A6LegNumero, T003P3_A506LegLicSitCodigo
            }
            , new Object[] {
            T003P4_A3CliCod
            }
            , new Object[] {
            T003P5_A506LegLicSitCodigo
            }
            , new Object[] {
            T003P6_A76LegLicenIni, T003P6_A517LegLicSitDescrip, T003P6_A914LegLicDescrip, T003P6_A1497LegLicEstado, T003P6_A481LegLicenFin, T003P6_A1218LegLicConPlus, T003P6_A1287LegSitEsLic, T003P6_A1288LegSitEsAu, T003P6_A1289LegSitEsAfip, T003P6_A1643LegSitCuenTrab,
            T003P6_A1808LegLicCanPres, T003P6_A1810LegLicRemCorr, T003P6_A3CliCod, T003P6_A1EmpCod, T003P6_A6LegNumero, T003P6_A506LegLicSitCodigo
            }
            , new Object[] {
            T003P7_A3CliCod
            }
            , new Object[] {
            T003P8_A506LegLicSitCodigo
            }
            , new Object[] {
            T003P9_A3CliCod, T003P9_A1EmpCod, T003P9_A6LegNumero, T003P9_A76LegLicenIni
            }
            , new Object[] {
            T003P10_A3CliCod, T003P10_A1EmpCod, T003P10_A6LegNumero, T003P10_A76LegLicenIni
            }
            , new Object[] {
            T003P11_A3CliCod, T003P11_A1EmpCod, T003P11_A6LegNumero, T003P11_A76LegLicenIni
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003P15_A3CliCod, T003P15_A1EmpCod, T003P15_A6LegNumero, T003P15_A76LegLicenIni
            }
            , new Object[] {
            T003P16_A506LegLicSitCodigo, T003P16_A913sItDescAbrev, T003P16_n913sItDescAbrev, T003P16_A739SitLicCuentaTrab, T003P16_n739SitLicCuentaTrab, T003P16_A738SitEsLicencia, T003P16_n738SitEsLicencia, T003P16_A1598EstadoSitRevista, T003P16_n1598EstadoSitRevista
            }
            , new Object[] {
            T003P17_A3CliCod
            }
            , new Object[] {
            T003P18_A506LegLicSitCodigo
            }
         }
      );
      AV37Pgmname = "faltas_y_tardes" ;
      Z481LegLicenFin = GXutil.nullDate() ;
      A481LegLicenFin = GXutil.nullDate() ;
   }

   private byte Z1287LegSitEsLic ;
   private byte Z1288LegSitEsAu ;
   private byte Z1289LegSitEsAfip ;
   private byte Z1643LegSitCuenTrab ;
   private byte Z1808LegLicCanPres ;
   private byte Z1810LegLicRemCorr ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1287LegSitEsLic ;
   private byte A1288LegSitEsAu ;
   private byte A1289LegSitEsAfip ;
   private byte A1643LegSitCuenTrab ;
   private byte A1808LegLicCanPres ;
   private byte A1810LegLicRemCorr ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8EmpCod ;
   private short Z1EmpCod ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV27cntDias ;
   private short A501LegLicCntDias ;
   private short RcdFound64 ;
   private short nIsDirty_64 ;
   private int wcpOAV7CliCod ;
   private int wcpOAV9LegNumero ;
   private int Z3CliCod ;
   private int Z6LegNumero ;
   private int AV7CliCod ;
   private int AV9LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int trnEnded ;
   private int edtLegNumero_Visible ;
   private int edtLegNumero_Enabled ;
   private int edtLegLicenIni_Enabled ;
   private int edtLegLicenFin_Enabled ;
   private int edtavCntdias_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int AV24ComboLegNumero ;
   private int edtavCombolegnumero_Enabled ;
   private int edtavCombolegnumero_Visible ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int Combo_legnumero_Datalistupdateminimumcharacters ;
   private int Combo_legnumero_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV38GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int7 ;
   private int GXv_int8[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z1497LegLicEstado ;
   private String Z506LegLicSitCodigo ;
   private String N506LegLicSitCodigo ;
   private String Combo_legnumero_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A506LegLicSitCodigo ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtLegNumero_Internalname ;
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
   private String divTablesplittedlegnumero_Internalname ;
   private String lblTextblocklegnumero_Internalname ;
   private String lblTextblocklegnumero_Jsonclick ;
   private String Combo_legnumero_Caption ;
   private String Combo_legnumero_Cls ;
   private String Combo_legnumero_Internalname ;
   private String TempTags ;
   private String edtLegNumero_Jsonclick ;
   private String edtLegLicenIni_Internalname ;
   private String edtLegLicenIni_Jsonclick ;
   private String edtLegLicenFin_Internalname ;
   private String edtLegLicenFin_Jsonclick ;
   private String edtavCntdias_Internalname ;
   private String edtavCntdias_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_legnumero_Internalname ;
   private String edtavCombolegnumero_Internalname ;
   private String edtavCombolegnumero_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String A1497LegLicEstado ;
   private String AV25Insert_LegLicSitCodigo ;
   private String AV37Pgmname ;
   private String Combo_legnumero_Objectcall ;
   private String Combo_legnumero_Class ;
   private String Combo_legnumero_Icontype ;
   private String Combo_legnumero_Icon ;
   private String Combo_legnumero_Tooltip ;
   private String Combo_legnumero_Selectedvalue_set ;
   private String Combo_legnumero_Selectedtext_set ;
   private String Combo_legnumero_Selectedtext_get ;
   private String Combo_legnumero_Gamoauthtoken ;
   private String Combo_legnumero_Ddointernalname ;
   private String Combo_legnumero_Titlecontrolalign ;
   private String Combo_legnumero_Dropdownoptionstype ;
   private String Combo_legnumero_Titlecontrolidtoreplace ;
   private String Combo_legnumero_Datalisttype ;
   private String Combo_legnumero_Datalistfixedvalues ;
   private String Combo_legnumero_Datalistproc ;
   private String Combo_legnumero_Datalistprocparametersprefix ;
   private String Combo_legnumero_Remoteservicesparameters ;
   private String Combo_legnumero_Htmltemplate ;
   private String Combo_legnumero_Multiplevaluestype ;
   private String Combo_legnumero_Loadingdata ;
   private String Combo_legnumero_Noresultsfound ;
   private String Combo_legnumero_Emptyitemtext ;
   private String Combo_legnumero_Onlyselectedvalues ;
   private String Combo_legnumero_Selectalltext ;
   private String Combo_legnumero_Multiplevaluesseparator ;
   private String Combo_legnumero_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode64 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String i1497LegLicEstado ;
   private String gxwrpcisep ;
   private String GXt_char9 ;
   private String GXv_char5[] ;
   private java.util.Date wcpOAV10LegLicenIni ;
   private java.util.Date Z76LegLicenIni ;
   private java.util.Date Z481LegLicenFin ;
   private java.util.Date A481LegLicenFin ;
   private java.util.Date A76LegLicenIni ;
   private java.util.Date AV10LegLicenIni ;
   private boolean Z1218LegLicConPlus ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_legnumero_Emptyitem ;
   private boolean A1218LegLicConPlus ;
   private boolean AV33SitEsLicencia ;
   private boolean AV32sitEsAusencia ;
   private boolean AV30SitEsRevistaAFip ;
   private boolean AV31SitLicCuentaTrab ;
   private boolean AV34EstadoCanPresen ;
   private boolean AV35EstadoRemCorr ;
   private boolean AV19existe ;
   private boolean Combo_legnumero_Enabled ;
   private boolean Combo_legnumero_Visible ;
   private boolean Combo_legnumero_Allowmultipleselection ;
   private boolean Combo_legnumero_Isgriditem ;
   private boolean Combo_legnumero_Hasdescription ;
   private boolean Combo_legnumero_Includeonlyselectedoption ;
   private boolean Combo_legnumero_Includeselectalloption ;
   private boolean Combo_legnumero_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXv_boolean14[] ;
   private boolean GXv_boolean13[] ;
   private boolean GXv_boolean12[] ;
   private boolean GXv_boolean11[] ;
   private boolean GXv_boolean10[] ;
   private boolean GXv_boolean3[] ;
   private boolean GXv_boolean15[] ;
   private boolean ZV19existe ;
   private String Z517LegLicSitDescrip ;
   private String Z914LegLicDescrip ;
   private String A517LegLicSitDescrip ;
   private String A914LegLicDescrip ;
   private String AV17ComboSelectedValue ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_legnumero ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynLegLicSitCodigo ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] T003P6_A76LegLicenIni ;
   private String[] T003P6_A517LegLicSitDescrip ;
   private String[] T003P6_A914LegLicDescrip ;
   private String[] T003P6_A1497LegLicEstado ;
   private java.util.Date[] T003P6_A481LegLicenFin ;
   private boolean[] T003P6_A1218LegLicConPlus ;
   private byte[] T003P6_A1287LegSitEsLic ;
   private byte[] T003P6_A1288LegSitEsAu ;
   private byte[] T003P6_A1289LegSitEsAfip ;
   private byte[] T003P6_A1643LegSitCuenTrab ;
   private byte[] T003P6_A1808LegLicCanPres ;
   private byte[] T003P6_A1810LegLicRemCorr ;
   private int[] T003P6_A3CliCod ;
   private short[] T003P6_A1EmpCod ;
   private int[] T003P6_A6LegNumero ;
   private String[] T003P6_A506LegLicSitCodigo ;
   private int[] T003P4_A3CliCod ;
   private String[] T003P5_A506LegLicSitCodigo ;
   private int[] T003P7_A3CliCod ;
   private String[] T003P8_A506LegLicSitCodigo ;
   private int[] T003P9_A3CliCod ;
   private short[] T003P9_A1EmpCod ;
   private int[] T003P9_A6LegNumero ;
   private java.util.Date[] T003P9_A76LegLicenIni ;
   private java.util.Date[] T003P3_A76LegLicenIni ;
   private String[] T003P3_A517LegLicSitDescrip ;
   private String[] T003P3_A914LegLicDescrip ;
   private String[] T003P3_A1497LegLicEstado ;
   private java.util.Date[] T003P3_A481LegLicenFin ;
   private boolean[] T003P3_A1218LegLicConPlus ;
   private byte[] T003P3_A1287LegSitEsLic ;
   private byte[] T003P3_A1288LegSitEsAu ;
   private byte[] T003P3_A1289LegSitEsAfip ;
   private byte[] T003P3_A1643LegSitCuenTrab ;
   private byte[] T003P3_A1808LegLicCanPres ;
   private byte[] T003P3_A1810LegLicRemCorr ;
   private int[] T003P3_A3CliCod ;
   private short[] T003P3_A1EmpCod ;
   private int[] T003P3_A6LegNumero ;
   private String[] T003P3_A506LegLicSitCodigo ;
   private int[] T003P10_A3CliCod ;
   private short[] T003P10_A1EmpCod ;
   private int[] T003P10_A6LegNumero ;
   private java.util.Date[] T003P10_A76LegLicenIni ;
   private int[] T003P11_A3CliCod ;
   private short[] T003P11_A1EmpCod ;
   private int[] T003P11_A6LegNumero ;
   private java.util.Date[] T003P11_A76LegLicenIni ;
   private java.util.Date[] T003P2_A76LegLicenIni ;
   private String[] T003P2_A517LegLicSitDescrip ;
   private String[] T003P2_A914LegLicDescrip ;
   private String[] T003P2_A1497LegLicEstado ;
   private java.util.Date[] T003P2_A481LegLicenFin ;
   private boolean[] T003P2_A1218LegLicConPlus ;
   private byte[] T003P2_A1287LegSitEsLic ;
   private byte[] T003P2_A1288LegSitEsAu ;
   private byte[] T003P2_A1289LegSitEsAfip ;
   private byte[] T003P2_A1643LegSitCuenTrab ;
   private byte[] T003P2_A1808LegLicCanPres ;
   private byte[] T003P2_A1810LegLicRemCorr ;
   private int[] T003P2_A3CliCod ;
   private short[] T003P2_A1EmpCod ;
   private int[] T003P2_A6LegNumero ;
   private String[] T003P2_A506LegLicSitCodigo ;
   private int[] T003P15_A3CliCod ;
   private short[] T003P15_A1EmpCod ;
   private int[] T003P15_A6LegNumero ;
   private java.util.Date[] T003P15_A76LegLicenIni ;
   private String[] T003P16_A506LegLicSitCodigo ;
   private String[] T003P16_A913sItDescAbrev ;
   private boolean[] T003P16_n913sItDescAbrev ;
   private boolean[] T003P16_A739SitLicCuentaTrab ;
   private boolean[] T003P16_n739SitLicCuentaTrab ;
   private boolean[] T003P16_A738SitEsLicencia ;
   private boolean[] T003P16_n738SitEsLicencia ;
   private short[] T003P16_A1598EstadoSitRevista ;
   private boolean[] T003P16_n1598EstadoSitRevista ;
   private int[] T003P17_A3CliCod ;
   private String[] T003P18_A506LegLicSitCodigo ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV20LegNumero_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXt_objcol_SdtDVB_SDTComboData_Item4 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXv_objcol_SdtDVB_SDTComboData_Item6[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV26TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class faltas_y_tardes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T003P2", "SELECT LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicEstado, LegLicenFin, LegLicConPlus, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegSitCuenTrab, LegLicCanPres, LegLicRemCorr, CliCod, EmpCod, LegNumero, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?  FOR UPDATE OF LegajoLicencias NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003P3", "SELECT LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicEstado, LegLicenFin, LegLicConPlus, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegSitCuenTrab, LegLicCanPres, LegLicRemCorr, CliCod, EmpCod, LegNumero, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003P4", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003P5", "SELECT SitCodigo AS LegLicSitCodigo FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003P6", "SELECT TM1.LegLicenIni, TM1.LegLicSitDescrip, TM1.LegLicDescrip, TM1.LegLicEstado, TM1.LegLicenFin, TM1.LegLicConPlus, TM1.LegSitEsLic, TM1.LegSitEsAu, TM1.LegSitEsAfip, TM1.LegSitCuenTrab, TM1.LegLicCanPres, TM1.LegLicRemCorr, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegLicSitCodigo AS LegLicSitCodigo FROM LegajoLicencias TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LegLicenIni = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegLicenIni ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003P7", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003P8", "SELECT SitCodigo AS LegLicSitCodigo FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003P9", "SELECT CliCod, EmpCod, LegNumero, LegLicenIni FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003P10", "SELECT CliCod, EmpCod, LegNumero, LegLicenIni FROM LegajoLicencias WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LegNumero > ? or LegNumero = ? and EmpCod = ? and CliCod = ? and LegLicenIni > ?) ORDER BY CliCod, EmpCod, LegNumero, LegLicenIni  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003P11", "SELECT CliCod, EmpCod, LegNumero, LegLicenIni FROM LegajoLicencias WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LegNumero < ? or LegNumero = ? and EmpCod = ? and CliCod = ? and LegLicenIni < ?) ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LegLicenIni DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T003P12", "SAVEPOINT gxupdate;INSERT INTO LegajoLicencias(LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicEstado, LegLicenFin, LegLicConPlus, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegSitCuenTrab, LegLicCanPres, LegLicRemCorr, CliCod, EmpCod, LegNumero, LegLicSitCodigo, LegLIcMot, LegLicFile, LegLicFileNom, LegLicFileExt) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003P13", "SAVEPOINT gxupdate;UPDATE LegajoLicencias SET LegLicSitDescrip=?, LegLicDescrip=?, LegLicEstado=?, LegLicenFin=?, LegLicConPlus=?, LegSitEsLic=?, LegSitEsAu=?, LegSitEsAfip=?, LegSitCuenTrab=?, LegLicCanPres=?, LegLicRemCorr=?, LegLicSitCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003P14", "SAVEPOINT gxupdate;DELETE FROM LegajoLicencias  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003P15", "SELECT CliCod, EmpCod, LegNumero, LegLicenIni FROM LegajoLicencias ORDER BY CliCod, EmpCod, LegNumero, LegLicenIni ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003P16", "SELECT SitCodigo AS LegLicSitCodigo, sItDescAbrev, SitLicCuentaTrab, SitEsLicencia, EstadoSitRevista FROM Estado WHERE (EstadoSitRevista IS NULL) AND (SitLicCuentaTrab = FALSE) AND (SitEsLicencia = FALSE) ORDER BY sItDescAbrev ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003P17", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003P18", "SELECT SitCodigo AS LegLicSitCodigo FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((String[]) buf[15])[0] = rslt.getString(16, 4);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((String[]) buf[15])[0] = rslt.getString(16, 4);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 4 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((String[]) buf[15])[0] = rslt.getString(16, 4);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setDate(10, (java.util.Date)parms[9]);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setDate(10, (java.util.Date)parms[9]);
               return;
            case 10 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               stmt.setInt(13, ((Number) parms[12]).intValue());
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setInt(15, ((Number) parms[14]).intValue());
               stmt.setString(16, (String)parms[15], 4);
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setString(12, (String)parms[11], 4);
               stmt.setInt(13, ((Number) parms[12]).intValue());
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setInt(15, ((Number) parms[14]).intValue());
               stmt.setDate(16, (java.util.Date)parms[15]);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 16 :
               stmt.setString(1, (String)parms[0], 4);
               return;
      }
   }

}

