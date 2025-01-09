package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liquidacion_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"TLIQCOD") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlatliqcod0R25( A3CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"CLICOD") == 0 )
      {
         AV23CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV23CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx5asaclicod0R25( AV23CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_23") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A33LiqDepBanCod = httpContext.GetPar( "LiqDepBanCod") ;
         n33LiqDepBanCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A33LiqDepBanCod", A33LiqDepBanCod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_23( A3CliCod, A33LiqDepBanCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_24") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_24( A3CliCod, A1EmpCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_25") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A32TLiqCod = httpContext.GetPar( "TLiqCod") ;
         n32TLiqCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_25( A3CliCod, A32TLiqCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_26") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1729PeriodoLiq = localUtil.parseDateParm( httpContext.GetPar( "PeriodoLiq")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_26( A3CliCod, A1EmpCod, A1729PeriodoLiq) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_27") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A2112LiqRelNro = (int)(GXutil.lval( httpContext.GetPar( "LiqRelNro"))) ;
         n2112LiqRelNro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2112LiqRelNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2112LiqRelNro), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_27( A3CliCod, A1EmpCod, A2112LiqRelNro) ;
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
            AV23CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV23CliCod), "ZZZZZ9")));
            AV7EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EmpCod), "ZZZ9")));
            AV8LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8LiqNro), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8LiqNro), "ZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Liquidacion", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtLiqFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public liquidacion_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liquidacion_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacion_impl.class ));
   }

   public liquidacion_impl( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynTLiqCod = new HTMLChoice();
      cmbLiqClase = new HTMLChoice();
      radavAplicaa = new HTMLChoice();
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
      if ( dynTLiqCod.getItemCount() > 0 )
      {
         A32TLiqCod = dynTLiqCod.getValidValue(A32TLiqCod) ;
         n32TLiqCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynTLiqCod.setValue( GXutil.rtrim( A32TLiqCod) );
         httpContext.ajax_rsp_assign_prop("", false, dynTLiqCod.getInternalname(), "Values", dynTLiqCod.ToJavascriptSource(), true);
      }
      if ( cmbLiqClase.getItemCount() > 0 )
      {
         A268LiqClase = (byte)(GXutil.lval( cmbLiqClase.getValidValue(GXutil.trim( GXutil.str( A268LiqClase, 1, 0))))) ;
         n268LiqClase = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A268LiqClase", GXutil.str( A268LiqClase, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLiqClase.setValue( GXutil.trim( GXutil.str( A268LiqClase, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLiqClase.getInternalname(), "Values", cmbLiqClase.ToJavascriptSource(), true);
      }
      AV22AplicaA = GXutil.rtrim( AV22AplicaA) ;
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqNro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqNro_Internalname, httpContext.getMessage( "Nro. de Liquidación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqNro_Internalname, GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqNro_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqNro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqNro_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_Liquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqFecha_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqFecha_Internalname, httpContext.getMessage( "Fecha", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLiqFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqFecha_Internalname, localUtil.format(A98LiqFecha, "99/99/9999"), localUtil.format( A98LiqFecha, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqFecha_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtLiqFecha_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_Liquidacion.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLiqFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLiqFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Liquidacion.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynTLiqCod.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynTLiqCod.getInternalname(), httpContext.getMessage( "Tipo de Liquidacion", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynTLiqCod, dynTLiqCod.getInternalname(), GXutil.rtrim( A32TLiqCod), 1, dynTLiqCod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynTLiqCod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_Liquidacion.htm");
      dynTLiqCod.setValue( GXutil.rtrim( A32TLiqCod) );
      httpContext.ajax_rsp_assign_prop("", false, dynTLiqCod.getInternalname(), "Values", dynTLiqCod.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tablelegajos.setProperty("Width", Dvpanel_tablelegajos_Width);
      ucDvpanel_tablelegajos.setProperty("AutoWidth", Dvpanel_tablelegajos_Autowidth);
      ucDvpanel_tablelegajos.setProperty("AutoHeight", Dvpanel_tablelegajos_Autoheight);
      ucDvpanel_tablelegajos.setProperty("Cls", Dvpanel_tablelegajos_Cls);
      ucDvpanel_tablelegajos.setProperty("Title", Dvpanel_tablelegajos_Title);
      ucDvpanel_tablelegajos.setProperty("Collapsible", Dvpanel_tablelegajos_Collapsible);
      ucDvpanel_tablelegajos.setProperty("Collapsed", Dvpanel_tablelegajos_Collapsed);
      ucDvpanel_tablelegajos.setProperty("ShowCollapseIcon", Dvpanel_tablelegajos_Showcollapseicon);
      ucDvpanel_tablelegajos.setProperty("IconPosition", Dvpanel_tablelegajos_Iconposition);
      ucDvpanel_tablelegajos.setProperty("AutoScroll", Dvpanel_tablelegajos_Autoscroll);
      ucDvpanel_tablelegajos.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tablelegajos_Internalname, "DVPANEL_TABLELEGAJOSContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLELEGAJOSContainer"+"TableLegajos"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablelegajos_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbLiqClase.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbLiqClase.getInternalname(), httpContext.getMessage( "Clase de Legajos", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbLiqClase, cmbLiqClase.getInternalname(), GXutil.trim( GXutil.str( A268LiqClase, 1, 0)), 1, cmbLiqClase.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbLiqClase.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(0), "HLP_Liquidacion.htm");
      cmbLiqClase.setValue( GXutil.trim( GXutil.str( A268LiqClase, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLiqClase.getInternalname(), "Values", cmbLiqClase.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+radavAplicaa.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Aplica a", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Radio button */
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_radio_ctrl( httpContext, radavAplicaa, radavAplicaa.getInternalname(), GXutil.rtrim( AV22AplicaA), "", 1, radavAplicaa.getEnabled(), 0, 0, StyleString, ClassString, "", "", 0, radavAplicaa.getJsonclick(), "'"+""+"'"+",false,"+"'"+""+"'", "", "HLP_Liquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableganancias.setProperty("Width", Dvpanel_tableganancias_Width);
      ucDvpanel_tableganancias.setProperty("AutoWidth", Dvpanel_tableganancias_Autowidth);
      ucDvpanel_tableganancias.setProperty("AutoHeight", Dvpanel_tableganancias_Autoheight);
      ucDvpanel_tableganancias.setProperty("Cls", Dvpanel_tableganancias_Cls);
      ucDvpanel_tableganancias.setProperty("Title", Dvpanel_tableganancias_Title);
      ucDvpanel_tableganancias.setProperty("Collapsible", Dvpanel_tableganancias_Collapsible);
      ucDvpanel_tableganancias.setProperty("Collapsed", Dvpanel_tableganancias_Collapsed);
      ucDvpanel_tableganancias.setProperty("ShowCollapseIcon", Dvpanel_tableganancias_Showcollapseicon);
      ucDvpanel_tableganancias.setProperty("IconPosition", Dvpanel_tableganancias_Iconposition);
      ucDvpanel_tableganancias.setProperty("AutoScroll", Dvpanel_tableganancias_Autoscroll);
      ucDvpanel_tableganancias.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableganancias_Internalname, "DVPANEL_TABLEGANANCIASContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEGANANCIASContainer"+"TableGanancias"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableganancias_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Liquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Liquidacion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Liquidacion.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Liquidacion.htm");
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
      e110R2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z31LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "Z31LiqNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z271LiqDescrip = httpContext.cgiGet( "Z271LiqDescrip") ;
            Z98LiqFecha = localUtil.ctod( httpContext.cgiGet( "Z98LiqFecha"), 0) ;
            Z585LiqPerAno = (short)(localUtil.ctol( httpContext.cgiGet( "Z585LiqPerAno"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z586LiqPerMes = (byte)(localUtil.ctol( httpContext.cgiGet( "Z586LiqPerMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z283LiqPeriodo = localUtil.ctod( httpContext.cgiGet( "Z283LiqPeriodo"), 0) ;
            Z280LiqFecPago = localUtil.ctod( httpContext.cgiGet( "Z280LiqFecPago"), 0) ;
            Z2368TLiqDescAux = httpContext.cgiGet( "Z2368TLiqDescAux") ;
            Z278LiqEstado = (byte)(localUtil.ctol( httpContext.cgiGet( "Z278LiqEstado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2292LiqLSDDepEst = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2292LiqLSDDepEst"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1403LiqAuxEstado = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1403LiqAuxEstado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2293LiqContrEst = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2293LiqContrEst"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z268LiqClase = (byte)(localUtil.ctol( httpContext.cgiGet( "Z268LiqClase"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n268LiqClase = ((0==A268LiqClase) ? true : false) ;
            Z2180LiqPDFEstado = httpContext.cgiGet( "Z2180LiqPDFEstado") ;
            n2180LiqPDFEstado = ((GXutil.strcmp("", A2180LiqPDFEstado)==0) ? true : false) ;
            Z361LiqGenInter = GXutil.strtobool( httpContext.cgiGet( "Z361LiqGenInter")) ;
            Z494LiqContabilizada = GXutil.strtobool( httpContext.cgiGet( "Z494LiqContabilizada")) ;
            Z495LiqCntLeg = (short)(localUtil.ctol( httpContext.cgiGet( "Z495LiqCntLeg"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z496LiqImpNeto = localUtil.ctond( httpContext.cgiGet( "Z496LiqImpNeto")) ;
            Z755LiqImpDescuentos = localUtil.ctond( httpContext.cgiGet( "Z755LiqImpDescuentos")) ;
            Z756LiqImpRetenGan = localUtil.ctond( httpContext.cgiGet( "Z756LiqImpRetenGan")) ;
            Z497LiqImpBruto = localUtil.ctond( httpContext.cgiGet( "Z497LiqImpBruto")) ;
            Z500LegEspecificos = GXutil.strtobool( httpContext.cgiGet( "Z500LegEspecificos")) ;
            Z511LiqFecCre = localUtil.ctod( httpContext.cgiGet( "Z511LiqFecCre"), 0) ;
            Z512LiqUsuCre = httpContext.cgiGet( "Z512LiqUsuCre") ;
            Z513LiqPerSinDia = httpContext.cgiGet( "Z513LiqPerSinDia") ;
            Z748LiqPerPalabra = httpContext.cgiGet( "Z748LiqPerPalabra") ;
            Z580LiqDepPrvPer = httpContext.cgiGet( "Z580LiqDepPrvPer") ;
            Z581LiqDepPrvFec = localUtil.ctod( httpContext.cgiGet( "Z581LiqDepPrvFec"), 0) ;
            Z583LiqDepPerAno = (short)(localUtil.ctol( httpContext.cgiGet( "Z583LiqDepPerAno"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z584LiqDepPerMes = (byte)(localUtil.ctol( httpContext.cgiGet( "Z584LiqDepPerMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z587LiqFecMod = localUtil.ctot( httpContext.cgiGet( "Z587LiqFecMod"), 0) ;
            Z588LiqUsuMod = httpContext.cgiGet( "Z588LiqUsuMod") ;
            Z719LiqFecImp = localUtil.ctot( httpContext.cgiGet( "Z719LiqFecImp"), 0) ;
            Z743LiqPisoGanancias = localUtil.ctond( httpContext.cgiGet( "Z743LiqPisoGanancias")) ;
            Z744LiqPisGanSAC = localUtil.ctond( httpContext.cgiGet( "Z744LiqPisGanSAC")) ;
            Z745LiqTopeDedInc = localUtil.ctond( httpContext.cgiGet( "Z745LiqTopeDedInc")) ;
            Z746LiqPerUltNorm = localUtil.ctod( httpContext.cgiGet( "Z746LiqPerUltNorm"), 0) ;
            Z766LiqError = httpContext.cgiGet( "Z766LiqError") ;
            Z1404LiqErrorAux = httpContext.cgiGet( "Z1404LiqErrorAux") ;
            Z874LiqNombre = httpContext.cgiGet( "Z874LiqNombre") ;
            Z881LiqLegajosTxt = httpContext.cgiGet( "Z881LiqLegajosTxt") ;
            Z885LiqSegundos = localUtil.ctond( httpContext.cgiGet( "Z885LiqSegundos")) ;
            Z963LiqRutaPDFTodosVertical = httpContext.cgiGet( "Z963LiqRutaPDFTodosVertical") ;
            Z964LiqRutaPDFTodosHorizontal = httpContext.cgiGet( "Z964LiqRutaPDFTodosHorizontal") ;
            Z965LiqRutaPDFTodosNombreVertical = httpContext.cgiGet( "Z965LiqRutaPDFTodosNombreVertical") ;
            Z966LiqRutaPDFTodosNombreHorizonta = httpContext.cgiGet( "Z966LiqRutaPDFTodosNombreHorizonta") ;
            Z2195LiqSac = GXutil.strtobool( httpContext.cgiGet( "Z2195LiqSac")) ;
            n2195LiqSac = ((false==A2195LiqSac) ? true : false) ;
            Z2196LiqSacLog = httpContext.cgiGet( "Z2196LiqSacLog") ;
            n2196LiqSacLog = ((GXutil.strcmp("", A2196LiqSacLog)==0) ? true : false) ;
            Z2298LiqCancel = GXutil.strtobool( httpContext.cgiGet( "Z2298LiqCancel")) ;
            Z2409LiqModTra = httpContext.cgiGet( "Z2409LiqModTra") ;
            Z2414LiqFrecPag = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2414LiqFrecPag"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2410LiqPerDes = localUtil.ctod( httpContext.cgiGet( "Z2410LiqPerDes"), 0) ;
            Z2411LiqPerHas = localUtil.ctod( httpContext.cgiGet( "Z2411LiqPerHas"), 0) ;
            Z2426LiqTipoTarifa = httpContext.cgiGet( "Z2426LiqTipoTarifa") ;
            Z33LiqDepBanCod = httpContext.cgiGet( "Z33LiqDepBanCod") ;
            n33LiqDepBanCod = ((GXutil.strcmp("", A33LiqDepBanCod)==0) ? true : false) ;
            Z32TLiqCod = httpContext.cgiGet( "Z32TLiqCod") ;
            n32TLiqCod = ((GXutil.strcmp("", A32TLiqCod)==0) ? true : false) ;
            Z1729PeriodoLiq = localUtil.ctod( httpContext.cgiGet( "Z1729PeriodoLiq"), 0) ;
            Z2112LiqRelNro = (int)(localUtil.ctol( httpContext.cgiGet( "Z2112LiqRelNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2112LiqRelNro = ((0==A2112LiqRelNro) ? true : false) ;
            A271LiqDescrip = httpContext.cgiGet( "Z271LiqDescrip") ;
            A585LiqPerAno = (short)(localUtil.ctol( httpContext.cgiGet( "Z585LiqPerAno"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A586LiqPerMes = (byte)(localUtil.ctol( httpContext.cgiGet( "Z586LiqPerMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A283LiqPeriodo = localUtil.ctod( httpContext.cgiGet( "Z283LiqPeriodo"), 0) ;
            A280LiqFecPago = localUtil.ctod( httpContext.cgiGet( "Z280LiqFecPago"), 0) ;
            A2368TLiqDescAux = httpContext.cgiGet( "Z2368TLiqDescAux") ;
            A278LiqEstado = (byte)(localUtil.ctol( httpContext.cgiGet( "Z278LiqEstado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2292LiqLSDDepEst = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2292LiqLSDDepEst"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1403LiqAuxEstado = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1403LiqAuxEstado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2293LiqContrEst = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2293LiqContrEst"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2180LiqPDFEstado = httpContext.cgiGet( "Z2180LiqPDFEstado") ;
            n2180LiqPDFEstado = false ;
            n2180LiqPDFEstado = ((GXutil.strcmp("", A2180LiqPDFEstado)==0) ? true : false) ;
            A361LiqGenInter = GXutil.strtobool( httpContext.cgiGet( "Z361LiqGenInter")) ;
            A494LiqContabilizada = GXutil.strtobool( httpContext.cgiGet( "Z494LiqContabilizada")) ;
            A495LiqCntLeg = (short)(localUtil.ctol( httpContext.cgiGet( "Z495LiqCntLeg"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A496LiqImpNeto = localUtil.ctond( httpContext.cgiGet( "Z496LiqImpNeto")) ;
            A755LiqImpDescuentos = localUtil.ctond( httpContext.cgiGet( "Z755LiqImpDescuentos")) ;
            A756LiqImpRetenGan = localUtil.ctond( httpContext.cgiGet( "Z756LiqImpRetenGan")) ;
            A497LiqImpBruto = localUtil.ctond( httpContext.cgiGet( "Z497LiqImpBruto")) ;
            A500LegEspecificos = GXutil.strtobool( httpContext.cgiGet( "Z500LegEspecificos")) ;
            A511LiqFecCre = localUtil.ctod( httpContext.cgiGet( "Z511LiqFecCre"), 0) ;
            A512LiqUsuCre = httpContext.cgiGet( "Z512LiqUsuCre") ;
            A513LiqPerSinDia = httpContext.cgiGet( "Z513LiqPerSinDia") ;
            A748LiqPerPalabra = httpContext.cgiGet( "Z748LiqPerPalabra") ;
            A580LiqDepPrvPer = httpContext.cgiGet( "Z580LiqDepPrvPer") ;
            A581LiqDepPrvFec = localUtil.ctod( httpContext.cgiGet( "Z581LiqDepPrvFec"), 0) ;
            A583LiqDepPerAno = (short)(localUtil.ctol( httpContext.cgiGet( "Z583LiqDepPerAno"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A584LiqDepPerMes = (byte)(localUtil.ctol( httpContext.cgiGet( "Z584LiqDepPerMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A587LiqFecMod = localUtil.ctot( httpContext.cgiGet( "Z587LiqFecMod"), 0) ;
            A588LiqUsuMod = httpContext.cgiGet( "Z588LiqUsuMod") ;
            A719LiqFecImp = localUtil.ctot( httpContext.cgiGet( "Z719LiqFecImp"), 0) ;
            A743LiqPisoGanancias = localUtil.ctond( httpContext.cgiGet( "Z743LiqPisoGanancias")) ;
            A744LiqPisGanSAC = localUtil.ctond( httpContext.cgiGet( "Z744LiqPisGanSAC")) ;
            A745LiqTopeDedInc = localUtil.ctond( httpContext.cgiGet( "Z745LiqTopeDedInc")) ;
            A746LiqPerUltNorm = localUtil.ctod( httpContext.cgiGet( "Z746LiqPerUltNorm"), 0) ;
            A766LiqError = httpContext.cgiGet( "Z766LiqError") ;
            A1404LiqErrorAux = httpContext.cgiGet( "Z1404LiqErrorAux") ;
            A874LiqNombre = httpContext.cgiGet( "Z874LiqNombre") ;
            A881LiqLegajosTxt = httpContext.cgiGet( "Z881LiqLegajosTxt") ;
            A885LiqSegundos = localUtil.ctond( httpContext.cgiGet( "Z885LiqSegundos")) ;
            A963LiqRutaPDFTodosVertical = httpContext.cgiGet( "Z963LiqRutaPDFTodosVertical") ;
            A964LiqRutaPDFTodosHorizontal = httpContext.cgiGet( "Z964LiqRutaPDFTodosHorizontal") ;
            A965LiqRutaPDFTodosNombreVertical = httpContext.cgiGet( "Z965LiqRutaPDFTodosNombreVertical") ;
            A966LiqRutaPDFTodosNombreHorizonta = httpContext.cgiGet( "Z966LiqRutaPDFTodosNombreHorizonta") ;
            A2195LiqSac = GXutil.strtobool( httpContext.cgiGet( "Z2195LiqSac")) ;
            n2195LiqSac = false ;
            n2195LiqSac = ((false==A2195LiqSac) ? true : false) ;
            A2196LiqSacLog = httpContext.cgiGet( "Z2196LiqSacLog") ;
            n2196LiqSacLog = false ;
            n2196LiqSacLog = ((GXutil.strcmp("", A2196LiqSacLog)==0) ? true : false) ;
            A2298LiqCancel = GXutil.strtobool( httpContext.cgiGet( "Z2298LiqCancel")) ;
            A2409LiqModTra = httpContext.cgiGet( "Z2409LiqModTra") ;
            A2414LiqFrecPag = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2414LiqFrecPag"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2410LiqPerDes = localUtil.ctod( httpContext.cgiGet( "Z2410LiqPerDes"), 0) ;
            A2411LiqPerHas = localUtil.ctod( httpContext.cgiGet( "Z2411LiqPerHas"), 0) ;
            A2426LiqTipoTarifa = httpContext.cgiGet( "Z2426LiqTipoTarifa") ;
            A33LiqDepBanCod = httpContext.cgiGet( "Z33LiqDepBanCod") ;
            n33LiqDepBanCod = false ;
            n33LiqDepBanCod = ((GXutil.strcmp("", A33LiqDepBanCod)==0) ? true : false) ;
            A1729PeriodoLiq = localUtil.ctod( httpContext.cgiGet( "Z1729PeriodoLiq"), 0) ;
            A2112LiqRelNro = (int)(localUtil.ctol( httpContext.cgiGet( "Z2112LiqRelNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2112LiqRelNro = false ;
            n2112LiqRelNro = ((0==A2112LiqRelNro) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N32TLiqCod = httpContext.cgiGet( "N32TLiqCod") ;
            n32TLiqCod = ((GXutil.strcmp("", A32TLiqCod)==0) ? true : false) ;
            N33LiqDepBanCod = httpContext.cgiGet( "N33LiqDepBanCod") ;
            n33LiqDepBanCod = ((GXutil.strcmp("", A33LiqDepBanCod)==0) ? true : false) ;
            N1729PeriodoLiq = localUtil.ctod( httpContext.cgiGet( "N1729PeriodoLiq"), 0) ;
            N2112LiqRelNro = (int)(localUtil.ctol( httpContext.cgiGet( "N2112LiqRelNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2112LiqRelNro = ((0==A2112LiqRelNro) ? true : false) ;
            AV23CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "CLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "vLIQNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV12Insert_TLiqCod = httpContext.cgiGet( "vINSERT_TLIQCOD") ;
            AV26Insert_LiqDepBanCod = httpContext.cgiGet( "vINSERT_LIQDEPBANCOD") ;
            A33LiqDepBanCod = httpContext.cgiGet( "LIQDEPBANCOD") ;
            n33LiqDepBanCod = ((GXutil.strcmp("", A33LiqDepBanCod)==0) ? true : false) ;
            AV27Insert_PeriodoLiq = localUtil.ctod( httpContext.cgiGet( "vINSERT_PERIODOLIQ"), 0) ;
            A1729PeriodoLiq = localUtil.ctod( httpContext.cgiGet( "PERIODOLIQ"), 0) ;
            AV28Insert_LiqRelNro = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_LIQRELNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2112LiqRelNro = (int)(localUtil.ctol( httpContext.cgiGet( "LIQRELNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2112LiqRelNro = ((0==A2112LiqRelNro) ? true : false) ;
            A271LiqDescrip = httpContext.cgiGet( "LIQDESCRIP") ;
            A585LiqPerAno = (short)(localUtil.ctol( httpContext.cgiGet( "LIQPERANO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A586LiqPerMes = (byte)(localUtil.ctol( httpContext.cgiGet( "LIQPERMES"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A283LiqPeriodo = localUtil.ctod( httpContext.cgiGet( "LIQPERIODO"), 0) ;
            A280LiqFecPago = localUtil.ctod( httpContext.cgiGet( "LIQFECPAGO"), 0) ;
            A2368TLiqDescAux = httpContext.cgiGet( "TLIQDESCAUX") ;
            A278LiqEstado = (byte)(localUtil.ctol( httpContext.cgiGet( "LIQESTADO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2292LiqLSDDepEst = (byte)(localUtil.ctol( httpContext.cgiGet( "LIQLSDDEPEST"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1403LiqAuxEstado = (byte)(localUtil.ctol( httpContext.cgiGet( "LIQAUXESTADO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2293LiqContrEst = (byte)(localUtil.ctol( httpContext.cgiGet( "LIQCONTREST"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2180LiqPDFEstado = httpContext.cgiGet( "LIQPDFESTADO") ;
            n2180LiqPDFEstado = ((GXutil.strcmp("", A2180LiqPDFEstado)==0) ? true : false) ;
            A361LiqGenInter = GXutil.strtobool( httpContext.cgiGet( "LIQGENINTER")) ;
            A494LiqContabilizada = GXutil.strtobool( httpContext.cgiGet( "LIQCONTABILIZADA")) ;
            A495LiqCntLeg = (short)(localUtil.ctol( httpContext.cgiGet( "LIQCNTLEG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A496LiqImpNeto = localUtil.ctond( httpContext.cgiGet( "LIQIMPNETO")) ;
            A755LiqImpDescuentos = localUtil.ctond( httpContext.cgiGet( "LIQIMPDESCUENTOS")) ;
            A756LiqImpRetenGan = localUtil.ctond( httpContext.cgiGet( "LIQIMPRETENGAN")) ;
            A497LiqImpBruto = localUtil.ctond( httpContext.cgiGet( "LIQIMPBRUTO")) ;
            A500LegEspecificos = GXutil.strtobool( httpContext.cgiGet( "LEGESPECIFICOS")) ;
            A511LiqFecCre = localUtil.ctod( httpContext.cgiGet( "LIQFECCRE"), 0) ;
            A512LiqUsuCre = httpContext.cgiGet( "LIQUSUCRE") ;
            A513LiqPerSinDia = httpContext.cgiGet( "LIQPERSINDIA") ;
            A748LiqPerPalabra = httpContext.cgiGet( "LIQPERPALABRA") ;
            A580LiqDepPrvPer = httpContext.cgiGet( "LIQDEPPRVPER") ;
            A581LiqDepPrvFec = localUtil.ctod( httpContext.cgiGet( "LIQDEPPRVFEC"), 0) ;
            A583LiqDepPerAno = (short)(localUtil.ctol( httpContext.cgiGet( "LIQDEPPERANO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A584LiqDepPerMes = (byte)(localUtil.ctol( httpContext.cgiGet( "LIQDEPPERMES"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A587LiqFecMod = localUtil.ctot( httpContext.cgiGet( "LIQFECMOD"), 0) ;
            A588LiqUsuMod = httpContext.cgiGet( "LIQUSUMOD") ;
            A719LiqFecImp = localUtil.ctot( httpContext.cgiGet( "LIQFECIMP"), 0) ;
            A743LiqPisoGanancias = localUtil.ctond( httpContext.cgiGet( "LIQPISOGANANCIAS")) ;
            A744LiqPisGanSAC = localUtil.ctond( httpContext.cgiGet( "LIQPISGANSAC")) ;
            A745LiqTopeDedInc = localUtil.ctond( httpContext.cgiGet( "LIQTOPEDEDINC")) ;
            A746LiqPerUltNorm = localUtil.ctod( httpContext.cgiGet( "LIQPERULTNORM"), 0) ;
            A766LiqError = httpContext.cgiGet( "LIQERROR") ;
            A1404LiqErrorAux = httpContext.cgiGet( "LIQERRORAUX") ;
            A874LiqNombre = httpContext.cgiGet( "LIQNOMBRE") ;
            A881LiqLegajosTxt = httpContext.cgiGet( "LIQLEGAJOSTXT") ;
            A885LiqSegundos = localUtil.ctond( httpContext.cgiGet( "LIQSEGUNDOS")) ;
            A963LiqRutaPDFTodosVertical = httpContext.cgiGet( "LIQRUTAPDFTODOSVERTICAL") ;
            A964LiqRutaPDFTodosHorizontal = httpContext.cgiGet( "LIQRUTAPDFTODOSHORIZONTAL") ;
            A965LiqRutaPDFTodosNombreVertical = httpContext.cgiGet( "LIQRUTAPDFTODOSNOMBREVERTICAL") ;
            A966LiqRutaPDFTodosNombreHorizonta = httpContext.cgiGet( "LIQRUTAPDFTODOSNOMBREHORIZONTA") ;
            A1142LiqLog = httpContext.cgiGet( "LIQLOG") ;
            A2195LiqSac = GXutil.strtobool( httpContext.cgiGet( "LIQSAC")) ;
            n2195LiqSac = ((false==A2195LiqSac) ? true : false) ;
            A2196LiqSacLog = httpContext.cgiGet( "LIQSACLOG") ;
            n2196LiqSacLog = ((GXutil.strcmp("", A2196LiqSacLog)==0) ? true : false) ;
            A2298LiqCancel = GXutil.strtobool( httpContext.cgiGet( "LIQCANCEL")) ;
            A2409LiqModTra = httpContext.cgiGet( "LIQMODTRA") ;
            A2414LiqFrecPag = (byte)(localUtil.ctol( httpContext.cgiGet( "LIQFRECPAG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2410LiqPerDes = localUtil.ctod( httpContext.cgiGet( "LIQPERDES"), 0) ;
            A2411LiqPerHas = localUtil.ctod( httpContext.cgiGet( "LIQPERHAS"), 0) ;
            A2426LiqTipoTarifa = httpContext.cgiGet( "LIQTIPOTARIFA") ;
            A582LiqDepBanDescrip = httpContext.cgiGet( "LIQDEPBANDESCRIP") ;
            A2EmpNom = httpContext.cgiGet( "EMPNOM") ;
            A340TliqDesc = httpContext.cgiGet( "TLIQDESC") ;
            AV29Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            Dvpanel_tablelegajos_Objectcall = httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Objectcall") ;
            Dvpanel_tablelegajos_Class = httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Class") ;
            Dvpanel_tablelegajos_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Enabled")) ;
            Dvpanel_tablelegajos_Width = httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Width") ;
            Dvpanel_tablelegajos_Height = httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Height") ;
            Dvpanel_tablelegajos_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Autowidth")) ;
            Dvpanel_tablelegajos_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Autoheight")) ;
            Dvpanel_tablelegajos_Cls = httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Cls") ;
            Dvpanel_tablelegajos_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Showheader")) ;
            Dvpanel_tablelegajos_Title = httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Title") ;
            Dvpanel_tablelegajos_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Collapsible")) ;
            Dvpanel_tablelegajos_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Collapsed")) ;
            Dvpanel_tablelegajos_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Showcollapseicon")) ;
            Dvpanel_tablelegajos_Iconposition = httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Iconposition") ;
            Dvpanel_tablelegajos_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Autoscroll")) ;
            Dvpanel_tablelegajos_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Visible")) ;
            Dvpanel_tablelegajos_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLELEGAJOS_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Dvpanel_tableganancias_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Objectcall") ;
            Dvpanel_tableganancias_Class = httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Class") ;
            Dvpanel_tableganancias_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Enabled")) ;
            Dvpanel_tableganancias_Width = httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Width") ;
            Dvpanel_tableganancias_Height = httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Height") ;
            Dvpanel_tableganancias_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Autowidth")) ;
            Dvpanel_tableganancias_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Autoheight")) ;
            Dvpanel_tableganancias_Cls = httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Cls") ;
            Dvpanel_tableganancias_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Showheader")) ;
            Dvpanel_tableganancias_Title = httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Title") ;
            Dvpanel_tableganancias_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Collapsible")) ;
            Dvpanel_tableganancias_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Collapsed")) ;
            Dvpanel_tableganancias_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Showcollapseicon")) ;
            Dvpanel_tableganancias_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Iconposition") ;
            Dvpanel_tableganancias_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Autoscroll")) ;
            Dvpanel_tableganancias_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Visible")) ;
            Dvpanel_tableganancias_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEGANANCIAS_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            A31LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
            if ( localUtil.vcdate( httpContext.cgiGet( edtLiqFecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "LIQFECHA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLiqFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A98LiqFecha = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A98LiqFecha", localUtil.format(A98LiqFecha, "99/99/9999"));
            }
            else
            {
               A98LiqFecha = localUtil.ctod( httpContext.cgiGet( edtLiqFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A98LiqFecha", localUtil.format(A98LiqFecha, "99/99/9999"));
            }
            dynTLiqCod.setValue( httpContext.cgiGet( dynTLiqCod.getInternalname()) );
            A32TLiqCod = httpContext.cgiGet( dynTLiqCod.getInternalname()) ;
            n32TLiqCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
            n32TLiqCod = ((GXutil.strcmp("", A32TLiqCod)==0) ? true : false) ;
            cmbLiqClase.setValue( httpContext.cgiGet( cmbLiqClase.getInternalname()) );
            A268LiqClase = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqClase.getInternalname()))) ;
            n268LiqClase = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A268LiqClase", GXutil.str( A268LiqClase, 1, 0));
            n268LiqClase = ((0==A268LiqClase) ? true : false) ;
            AV22AplicaA = httpContext.cgiGet( radavAplicaa.getInternalname()) ;
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
            forbiddenHiddens.add("hshsalt", "hsh"+"Liquidacion");
            A31LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
            forbiddenHiddens.add("LiqNro", localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("LiqDescrip", GXutil.rtrim( localUtil.format( A271LiqDescrip, "")));
            forbiddenHiddens.add("LiqPerAno", localUtil.format( DecimalUtil.doubleToDec(A585LiqPerAno), "ZZZ9"));
            forbiddenHiddens.add("LiqPerMes", localUtil.format( DecimalUtil.doubleToDec(A586LiqPerMes), "Z9"));
            forbiddenHiddens.add("LiqPeriodo", localUtil.format(A283LiqPeriodo, "99/99/9999"));
            forbiddenHiddens.add("LiqFecPago", localUtil.format(A280LiqFecPago, "99/99/9999"));
            forbiddenHiddens.add("TLiqDescAux", GXutil.rtrim( localUtil.format( A2368TLiqDescAux, "@!")));
            forbiddenHiddens.add("LiqEstado", localUtil.format( DecimalUtil.doubleToDec(A278LiqEstado), "9"));
            forbiddenHiddens.add("LiqLSDDepEst", localUtil.format( DecimalUtil.doubleToDec(A2292LiqLSDDepEst), "9"));
            forbiddenHiddens.add("LiqAuxEstado", localUtil.format( DecimalUtil.doubleToDec(A1403LiqAuxEstado), "9"));
            forbiddenHiddens.add("LiqContrEst", localUtil.format( DecimalUtil.doubleToDec(A2293LiqContrEst), "9"));
            forbiddenHiddens.add("LiqPDFEstado", GXutil.rtrim( localUtil.format( A2180LiqPDFEstado, "")));
            forbiddenHiddens.add("LiqGenInter", GXutil.booltostr( A361LiqGenInter));
            forbiddenHiddens.add("LiqContabilizada", GXutil.booltostr( A494LiqContabilizada));
            forbiddenHiddens.add("LiqCntLeg", localUtil.format( DecimalUtil.doubleToDec(A495LiqCntLeg), "ZZZ9"));
            forbiddenHiddens.add("LiqImpNeto", localUtil.format( A496LiqImpNeto, "ZZ,ZZZ,ZZZ,ZZ9.99"));
            forbiddenHiddens.add("LiqImpDescuentos", localUtil.format( A755LiqImpDescuentos, "ZZ,ZZZ,ZZZ,ZZ9.99"));
            forbiddenHiddens.add("LiqImpRetenGan", localUtil.format( A756LiqImpRetenGan, "ZZ,ZZZ,ZZZ,ZZ9.99"));
            forbiddenHiddens.add("LiqImpBruto", localUtil.format( A497LiqImpBruto, "ZZ,ZZZ,ZZZ,ZZ9.99"));
            forbiddenHiddens.add("LegEspecificos", GXutil.booltostr( A500LegEspecificos));
            forbiddenHiddens.add("LiqFecCre", localUtil.format(A511LiqFecCre, "99/99/99"));
            forbiddenHiddens.add("LiqUsuCre", GXutil.rtrim( localUtil.format( A512LiqUsuCre, "")));
            forbiddenHiddens.add("LiqPerSinDia", GXutil.rtrim( localUtil.format( A513LiqPerSinDia, "")));
            forbiddenHiddens.add("LiqPerPalabra", GXutil.rtrim( localUtil.format( A748LiqPerPalabra, "")));
            forbiddenHiddens.add("LiqDepPrvPer", GXutil.rtrim( localUtil.format( A580LiqDepPrvPer, "")));
            forbiddenHiddens.add("LiqDepPrvFec", localUtil.format(A581LiqDepPrvFec, "99/99/99"));
            forbiddenHiddens.add("LiqDepPerAno", localUtil.format( DecimalUtil.doubleToDec(A583LiqDepPerAno), "ZZZ9"));
            forbiddenHiddens.add("LiqDepPerMes", localUtil.format( DecimalUtil.doubleToDec(A584LiqDepPerMes), "Z9"));
            forbiddenHiddens.add("LiqFecMod", localUtil.format( A587LiqFecMod, "99/99/99 99:99"));
            forbiddenHiddens.add("LiqUsuMod", GXutil.rtrim( localUtil.format( A588LiqUsuMod, "")));
            forbiddenHiddens.add("LiqFecImp", localUtil.format( A719LiqFecImp, "99/99/99 99:99"));
            forbiddenHiddens.add("LiqPisoGanancias", localUtil.format( A743LiqPisoGanancias, "ZZ,ZZZ,ZZZ,ZZ9.99"));
            forbiddenHiddens.add("LiqPisGanSAC", localUtil.format( A744LiqPisGanSAC, "ZZ,ZZZ,ZZZ,ZZ9.99"));
            forbiddenHiddens.add("LiqTopeDedInc", localUtil.format( A745LiqTopeDedInc, "ZZ,ZZZ,ZZZ,ZZ9.99"));
            forbiddenHiddens.add("LiqPerUltNorm", localUtil.format(A746LiqPerUltNorm, "99/99/9999"));
            forbiddenHiddens.add("LiqError", GXutil.rtrim( localUtil.format( A766LiqError, "")));
            forbiddenHiddens.add("LiqErrorAux", GXutil.rtrim( localUtil.format( A1404LiqErrorAux, "")));
            forbiddenHiddens.add("LiqNombre", GXutil.rtrim( localUtil.format( A874LiqNombre, "")));
            forbiddenHiddens.add("LiqLegajosTxt", GXutil.rtrim( localUtil.format( A881LiqLegajosTxt, "")));
            forbiddenHiddens.add("LiqSegundos", localUtil.format( A885LiqSegundos, "Z9.99"));
            forbiddenHiddens.add("LiqRutaPDFTodosVertical", GXutil.rtrim( localUtil.format( A963LiqRutaPDFTodosVertical, "")));
            forbiddenHiddens.add("LiqRutaPDFTodosHorizontal", GXutil.rtrim( localUtil.format( A964LiqRutaPDFTodosHorizontal, "")));
            forbiddenHiddens.add("LiqRutaPDFTodosNombreVertical", GXutil.rtrim( localUtil.format( A965LiqRutaPDFTodosNombreVertical, "")));
            forbiddenHiddens.add("LiqRutaPDFTodosNombreHorizonta", GXutil.rtrim( localUtil.format( A966LiqRutaPDFTodosNombreHorizonta, "")));
            forbiddenHiddens.add("LiqSac", GXutil.booltostr( A2195LiqSac));
            forbiddenHiddens.add("LiqSacLog", GXutil.rtrim( localUtil.format( A2196LiqSacLog, "")));
            forbiddenHiddens.add("LiqCancel", GXutil.booltostr( A2298LiqCancel));
            forbiddenHiddens.add("LiqModTra", GXutil.rtrim( localUtil.format( A2409LiqModTra, "")));
            forbiddenHiddens.add("LiqFrecPag", localUtil.format( DecimalUtil.doubleToDec(A2414LiqFrecPag), "9"));
            forbiddenHiddens.add("LiqPerDes", localUtil.format(A2410LiqPerDes, "99/99/9999"));
            forbiddenHiddens.add("LiqPerHas", localUtil.format(A2411LiqPerHas, "99/99/9999"));
            forbiddenHiddens.add("LiqTipoTarifa", GXutil.rtrim( localUtil.format( A2426LiqTipoTarifa, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("liquidacion:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A31LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
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
                  sMode25 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode25 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound25 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0R0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "EMPCOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtEmpCod_Internalname ;
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
                        e110R2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120R2 ();
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
         e120R2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0R25( ) ;
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
         disableAttributes0R25( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, radavAplicaa.getInternalname(), "Enabled", GXutil.ltrimstr( radavAplicaa.getEnabled(), 5, 0), true);
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

   public void confirm_0R0( )
   {
      beforeValidate0R25( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0R25( ) ;
         }
         else
         {
            checkExtendedTable0R25( ) ;
            closeExtendedTableCursors0R25( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0R0( )
   {
   }

   public void e110R2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      AV24IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24IsAuthorized", AV24IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV24IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacion_Insert", GXv_boolean3) ;
         liquidacion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV24IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24IsAuthorized", AV24IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV24IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacion_Update", GXv_boolean3) ;
         liquidacion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV24IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24IsAuthorized", AV24IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV24IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacion_Delete", GXv_boolean3) ;
         liquidacion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV24IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24IsAuthorized", AV24IsAuthorized);
      }
      if ( ! AV24IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV29Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV29Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV30GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30GXV1), 8, 0));
         while ( AV30GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV30GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TLiqCod") == 0 )
            {
               AV12Insert_TLiqCod = AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_TLiqCod", AV12Insert_TLiqCod);
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LiqDepBanCod") == 0 )
            {
               AV26Insert_LiqDepBanCod = AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV26Insert_LiqDepBanCod", AV26Insert_LiqDepBanCod);
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PeriodoLiq") == 0 )
            {
               AV27Insert_PeriodoLiq = localUtil.ctod( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV27Insert_PeriodoLiq", localUtil.format(AV27Insert_PeriodoLiq, "99/99/99"));
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LiqRelNro") == 0 )
            {
               AV28Insert_LiqRelNro = (int)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV28Insert_LiqRelNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28Insert_LiqRelNro), 8, 0));
            }
            AV30GXV1 = (int)(AV30GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30GXV1), 8, 0));
         }
      }
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
   }

   public void e120R2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm0R25( int GX_JID )
   {
      if ( ( GX_JID == 22 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z271LiqDescrip = T000R3_A271LiqDescrip[0] ;
            Z98LiqFecha = T000R3_A98LiqFecha[0] ;
            Z585LiqPerAno = T000R3_A585LiqPerAno[0] ;
            Z586LiqPerMes = T000R3_A586LiqPerMes[0] ;
            Z283LiqPeriodo = T000R3_A283LiqPeriodo[0] ;
            Z280LiqFecPago = T000R3_A280LiqFecPago[0] ;
            Z2368TLiqDescAux = T000R3_A2368TLiqDescAux[0] ;
            Z278LiqEstado = T000R3_A278LiqEstado[0] ;
            Z2292LiqLSDDepEst = T000R3_A2292LiqLSDDepEst[0] ;
            Z1403LiqAuxEstado = T000R3_A1403LiqAuxEstado[0] ;
            Z2293LiqContrEst = T000R3_A2293LiqContrEst[0] ;
            Z268LiqClase = T000R3_A268LiqClase[0] ;
            Z2180LiqPDFEstado = T000R3_A2180LiqPDFEstado[0] ;
            Z361LiqGenInter = T000R3_A361LiqGenInter[0] ;
            Z494LiqContabilizada = T000R3_A494LiqContabilizada[0] ;
            Z495LiqCntLeg = T000R3_A495LiqCntLeg[0] ;
            Z496LiqImpNeto = T000R3_A496LiqImpNeto[0] ;
            Z755LiqImpDescuentos = T000R3_A755LiqImpDescuentos[0] ;
            Z756LiqImpRetenGan = T000R3_A756LiqImpRetenGan[0] ;
            Z497LiqImpBruto = T000R3_A497LiqImpBruto[0] ;
            Z500LegEspecificos = T000R3_A500LegEspecificos[0] ;
            Z511LiqFecCre = T000R3_A511LiqFecCre[0] ;
            Z512LiqUsuCre = T000R3_A512LiqUsuCre[0] ;
            Z513LiqPerSinDia = T000R3_A513LiqPerSinDia[0] ;
            Z748LiqPerPalabra = T000R3_A748LiqPerPalabra[0] ;
            Z580LiqDepPrvPer = T000R3_A580LiqDepPrvPer[0] ;
            Z581LiqDepPrvFec = T000R3_A581LiqDepPrvFec[0] ;
            Z583LiqDepPerAno = T000R3_A583LiqDepPerAno[0] ;
            Z584LiqDepPerMes = T000R3_A584LiqDepPerMes[0] ;
            Z587LiqFecMod = T000R3_A587LiqFecMod[0] ;
            Z588LiqUsuMod = T000R3_A588LiqUsuMod[0] ;
            Z719LiqFecImp = T000R3_A719LiqFecImp[0] ;
            Z743LiqPisoGanancias = T000R3_A743LiqPisoGanancias[0] ;
            Z744LiqPisGanSAC = T000R3_A744LiqPisGanSAC[0] ;
            Z745LiqTopeDedInc = T000R3_A745LiqTopeDedInc[0] ;
            Z746LiqPerUltNorm = T000R3_A746LiqPerUltNorm[0] ;
            Z766LiqError = T000R3_A766LiqError[0] ;
            Z1404LiqErrorAux = T000R3_A1404LiqErrorAux[0] ;
            Z874LiqNombre = T000R3_A874LiqNombre[0] ;
            Z881LiqLegajosTxt = T000R3_A881LiqLegajosTxt[0] ;
            Z885LiqSegundos = T000R3_A885LiqSegundos[0] ;
            Z963LiqRutaPDFTodosVertical = T000R3_A963LiqRutaPDFTodosVertical[0] ;
            Z964LiqRutaPDFTodosHorizontal = T000R3_A964LiqRutaPDFTodosHorizontal[0] ;
            Z965LiqRutaPDFTodosNombreVertical = T000R3_A965LiqRutaPDFTodosNombreVertical[0] ;
            Z966LiqRutaPDFTodosNombreHorizonta = T000R3_A966LiqRutaPDFTodosNombreHorizonta[0] ;
            Z2195LiqSac = T000R3_A2195LiqSac[0] ;
            Z2196LiqSacLog = T000R3_A2196LiqSacLog[0] ;
            Z2298LiqCancel = T000R3_A2298LiqCancel[0] ;
            Z2409LiqModTra = T000R3_A2409LiqModTra[0] ;
            Z2414LiqFrecPag = T000R3_A2414LiqFrecPag[0] ;
            Z2410LiqPerDes = T000R3_A2410LiqPerDes[0] ;
            Z2411LiqPerHas = T000R3_A2411LiqPerHas[0] ;
            Z2426LiqTipoTarifa = T000R3_A2426LiqTipoTarifa[0] ;
            Z33LiqDepBanCod = T000R3_A33LiqDepBanCod[0] ;
            Z32TLiqCod = T000R3_A32TLiqCod[0] ;
            Z1729PeriodoLiq = T000R3_A1729PeriodoLiq[0] ;
            Z2112LiqRelNro = T000R3_A2112LiqRelNro[0] ;
         }
         else
         {
            Z271LiqDescrip = A271LiqDescrip ;
            Z98LiqFecha = A98LiqFecha ;
            Z585LiqPerAno = A585LiqPerAno ;
            Z586LiqPerMes = A586LiqPerMes ;
            Z283LiqPeriodo = A283LiqPeriodo ;
            Z280LiqFecPago = A280LiqFecPago ;
            Z2368TLiqDescAux = A2368TLiqDescAux ;
            Z278LiqEstado = A278LiqEstado ;
            Z2292LiqLSDDepEst = A2292LiqLSDDepEst ;
            Z1403LiqAuxEstado = A1403LiqAuxEstado ;
            Z2293LiqContrEst = A2293LiqContrEst ;
            Z268LiqClase = A268LiqClase ;
            Z2180LiqPDFEstado = A2180LiqPDFEstado ;
            Z361LiqGenInter = A361LiqGenInter ;
            Z494LiqContabilizada = A494LiqContabilizada ;
            Z495LiqCntLeg = A495LiqCntLeg ;
            Z496LiqImpNeto = A496LiqImpNeto ;
            Z755LiqImpDescuentos = A755LiqImpDescuentos ;
            Z756LiqImpRetenGan = A756LiqImpRetenGan ;
            Z497LiqImpBruto = A497LiqImpBruto ;
            Z500LegEspecificos = A500LegEspecificos ;
            Z511LiqFecCre = A511LiqFecCre ;
            Z512LiqUsuCre = A512LiqUsuCre ;
            Z513LiqPerSinDia = A513LiqPerSinDia ;
            Z748LiqPerPalabra = A748LiqPerPalabra ;
            Z580LiqDepPrvPer = A580LiqDepPrvPer ;
            Z581LiqDepPrvFec = A581LiqDepPrvFec ;
            Z583LiqDepPerAno = A583LiqDepPerAno ;
            Z584LiqDepPerMes = A584LiqDepPerMes ;
            Z587LiqFecMod = A587LiqFecMod ;
            Z588LiqUsuMod = A588LiqUsuMod ;
            Z719LiqFecImp = A719LiqFecImp ;
            Z743LiqPisoGanancias = A743LiqPisoGanancias ;
            Z744LiqPisGanSAC = A744LiqPisGanSAC ;
            Z745LiqTopeDedInc = A745LiqTopeDedInc ;
            Z746LiqPerUltNorm = A746LiqPerUltNorm ;
            Z766LiqError = A766LiqError ;
            Z1404LiqErrorAux = A1404LiqErrorAux ;
            Z874LiqNombre = A874LiqNombre ;
            Z881LiqLegajosTxt = A881LiqLegajosTxt ;
            Z885LiqSegundos = A885LiqSegundos ;
            Z963LiqRutaPDFTodosVertical = A963LiqRutaPDFTodosVertical ;
            Z964LiqRutaPDFTodosHorizontal = A964LiqRutaPDFTodosHorizontal ;
            Z965LiqRutaPDFTodosNombreVertical = A965LiqRutaPDFTodosNombreVertical ;
            Z966LiqRutaPDFTodosNombreHorizonta = A966LiqRutaPDFTodosNombreHorizonta ;
            Z2195LiqSac = A2195LiqSac ;
            Z2196LiqSacLog = A2196LiqSacLog ;
            Z2298LiqCancel = A2298LiqCancel ;
            Z2409LiqModTra = A2409LiqModTra ;
            Z2414LiqFrecPag = A2414LiqFrecPag ;
            Z2410LiqPerDes = A2410LiqPerDes ;
            Z2411LiqPerHas = A2411LiqPerHas ;
            Z2426LiqTipoTarifa = A2426LiqTipoTarifa ;
            Z33LiqDepBanCod = A33LiqDepBanCod ;
            Z32TLiqCod = A32TLiqCod ;
            Z1729PeriodoLiq = A1729PeriodoLiq ;
            Z2112LiqRelNro = A2112LiqRelNro ;
         }
      }
      if ( GX_JID == -22 )
      {
         Z31LiqNro = A31LiqNro ;
         Z271LiqDescrip = A271LiqDescrip ;
         Z98LiqFecha = A98LiqFecha ;
         Z585LiqPerAno = A585LiqPerAno ;
         Z586LiqPerMes = A586LiqPerMes ;
         Z283LiqPeriodo = A283LiqPeriodo ;
         Z280LiqFecPago = A280LiqFecPago ;
         Z2368TLiqDescAux = A2368TLiqDescAux ;
         Z278LiqEstado = A278LiqEstado ;
         Z2292LiqLSDDepEst = A2292LiqLSDDepEst ;
         Z1403LiqAuxEstado = A1403LiqAuxEstado ;
         Z2293LiqContrEst = A2293LiqContrEst ;
         Z268LiqClase = A268LiqClase ;
         Z2180LiqPDFEstado = A2180LiqPDFEstado ;
         Z361LiqGenInter = A361LiqGenInter ;
         Z494LiqContabilizada = A494LiqContabilizada ;
         Z495LiqCntLeg = A495LiqCntLeg ;
         Z496LiqImpNeto = A496LiqImpNeto ;
         Z755LiqImpDescuentos = A755LiqImpDescuentos ;
         Z756LiqImpRetenGan = A756LiqImpRetenGan ;
         Z497LiqImpBruto = A497LiqImpBruto ;
         Z500LegEspecificos = A500LegEspecificos ;
         Z511LiqFecCre = A511LiqFecCre ;
         Z512LiqUsuCre = A512LiqUsuCre ;
         Z513LiqPerSinDia = A513LiqPerSinDia ;
         Z748LiqPerPalabra = A748LiqPerPalabra ;
         Z580LiqDepPrvPer = A580LiqDepPrvPer ;
         Z581LiqDepPrvFec = A581LiqDepPrvFec ;
         Z583LiqDepPerAno = A583LiqDepPerAno ;
         Z584LiqDepPerMes = A584LiqDepPerMes ;
         Z587LiqFecMod = A587LiqFecMod ;
         Z588LiqUsuMod = A588LiqUsuMod ;
         Z719LiqFecImp = A719LiqFecImp ;
         Z743LiqPisoGanancias = A743LiqPisoGanancias ;
         Z744LiqPisGanSAC = A744LiqPisGanSAC ;
         Z745LiqTopeDedInc = A745LiqTopeDedInc ;
         Z746LiqPerUltNorm = A746LiqPerUltNorm ;
         Z766LiqError = A766LiqError ;
         Z1404LiqErrorAux = A1404LiqErrorAux ;
         Z874LiqNombre = A874LiqNombre ;
         Z881LiqLegajosTxt = A881LiqLegajosTxt ;
         Z885LiqSegundos = A885LiqSegundos ;
         Z963LiqRutaPDFTodosVertical = A963LiqRutaPDFTodosVertical ;
         Z964LiqRutaPDFTodosHorizontal = A964LiqRutaPDFTodosHorizontal ;
         Z965LiqRutaPDFTodosNombreVertical = A965LiqRutaPDFTodosNombreVertical ;
         Z966LiqRutaPDFTodosNombreHorizonta = A966LiqRutaPDFTodosNombreHorizonta ;
         Z1142LiqLog = A1142LiqLog ;
         Z2195LiqSac = A2195LiqSac ;
         Z2196LiqSacLog = A2196LiqSacLog ;
         Z2298LiqCancel = A2298LiqCancel ;
         Z2409LiqModTra = A2409LiqModTra ;
         Z2414LiqFrecPag = A2414LiqFrecPag ;
         Z2410LiqPerDes = A2410LiqPerDes ;
         Z2411LiqPerHas = A2411LiqPerHas ;
         Z2426LiqTipoTarifa = A2426LiqTipoTarifa ;
         Z3CliCod = A3CliCod ;
         Z33LiqDepBanCod = A33LiqDepBanCod ;
         Z1EmpCod = A1EmpCod ;
         Z32TLiqCod = A32TLiqCod ;
         Z1729PeriodoLiq = A1729PeriodoLiq ;
         Z2112LiqRelNro = A2112LiqRelNro ;
         Z582LiqDepBanDescrip = A582LiqDepBanDescrip ;
         Z2EmpNom = A2EmpNom ;
         Z340TliqDesc = A340TliqDesc ;
      }
   }

   public void standaloneNotModal( )
   {
      edtLiqNro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNro_Enabled), 5, 0), true);
      edtLiqNro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNro_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV23CliCod) )
      {
         A3CliCod = AV23CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            liquidacion_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      gxatliqcod_html0R25( A3CliCod) ;
      if ( ! (0==AV7EmpCod) )
      {
         A1EmpCod = AV7EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( ! (0==AV7EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8LiqNro) )
      {
         A31LiqNro = AV8LiqNro ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV12Insert_TLiqCod)==0) )
      {
         dynTLiqCod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynTLiqCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynTLiqCod.getEnabled(), 5, 0), true);
      }
      else
      {
         dynTLiqCod.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynTLiqCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynTLiqCod.getEnabled(), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV28Insert_LiqRelNro) )
      {
         A2112LiqRelNro = AV28Insert_LiqRelNro ;
         n2112LiqRelNro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2112LiqRelNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2112LiqRelNro), 8, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV27Insert_PeriodoLiq)) )
      {
         A1729PeriodoLiq = AV27Insert_PeriodoLiq ;
         httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV26Insert_LiqDepBanCod)==0) )
      {
         A33LiqDepBanCod = AV26Insert_LiqDepBanCod ;
         n33LiqDepBanCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A33LiqDepBanCod", A33LiqDepBanCod);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV12Insert_TLiqCod)==0) )
      {
         A32TLiqCod = AV12Insert_TLiqCod ;
         n32TLiqCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
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
         /* Using cursor T000R6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
         A340TliqDesc = T000R6_A340TliqDesc[0] ;
         pr_default.close(4);
         AV29Pgmname = "Liquidacion" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
         /* Using cursor T000R5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         A2EmpNom = T000R5_A2EmpNom[0] ;
         pr_default.close(3);
         /* Using cursor T000R4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n33LiqDepBanCod), A33LiqDepBanCod});
         A582LiqDepBanDescrip = T000R4_A582LiqDepBanDescrip[0] ;
         pr_default.close(2);
      }
   }

   public void load0R25( )
   {
      /* Using cursor T000R9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A2EmpNom = T000R9_A2EmpNom[0] ;
         A271LiqDescrip = T000R9_A271LiqDescrip[0] ;
         A98LiqFecha = T000R9_A98LiqFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A98LiqFecha", localUtil.format(A98LiqFecha, "99/99/9999"));
         A585LiqPerAno = T000R9_A585LiqPerAno[0] ;
         A586LiqPerMes = T000R9_A586LiqPerMes[0] ;
         A283LiqPeriodo = T000R9_A283LiqPeriodo[0] ;
         A280LiqFecPago = T000R9_A280LiqFecPago[0] ;
         A340TliqDesc = T000R9_A340TliqDesc[0] ;
         A2368TLiqDescAux = T000R9_A2368TLiqDescAux[0] ;
         A278LiqEstado = T000R9_A278LiqEstado[0] ;
         A2292LiqLSDDepEst = T000R9_A2292LiqLSDDepEst[0] ;
         A1403LiqAuxEstado = T000R9_A1403LiqAuxEstado[0] ;
         A2293LiqContrEst = T000R9_A2293LiqContrEst[0] ;
         A268LiqClase = T000R9_A268LiqClase[0] ;
         n268LiqClase = T000R9_n268LiqClase[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A268LiqClase", GXutil.str( A268LiqClase, 1, 0));
         A2180LiqPDFEstado = T000R9_A2180LiqPDFEstado[0] ;
         n2180LiqPDFEstado = T000R9_n2180LiqPDFEstado[0] ;
         A361LiqGenInter = T000R9_A361LiqGenInter[0] ;
         A494LiqContabilizada = T000R9_A494LiqContabilizada[0] ;
         A495LiqCntLeg = T000R9_A495LiqCntLeg[0] ;
         A496LiqImpNeto = T000R9_A496LiqImpNeto[0] ;
         A755LiqImpDescuentos = T000R9_A755LiqImpDescuentos[0] ;
         A756LiqImpRetenGan = T000R9_A756LiqImpRetenGan[0] ;
         A497LiqImpBruto = T000R9_A497LiqImpBruto[0] ;
         A500LegEspecificos = T000R9_A500LegEspecificos[0] ;
         A511LiqFecCre = T000R9_A511LiqFecCre[0] ;
         A512LiqUsuCre = T000R9_A512LiqUsuCre[0] ;
         A513LiqPerSinDia = T000R9_A513LiqPerSinDia[0] ;
         A748LiqPerPalabra = T000R9_A748LiqPerPalabra[0] ;
         A580LiqDepPrvPer = T000R9_A580LiqDepPrvPer[0] ;
         A581LiqDepPrvFec = T000R9_A581LiqDepPrvFec[0] ;
         A582LiqDepBanDescrip = T000R9_A582LiqDepBanDescrip[0] ;
         A583LiqDepPerAno = T000R9_A583LiqDepPerAno[0] ;
         A584LiqDepPerMes = T000R9_A584LiqDepPerMes[0] ;
         A587LiqFecMod = T000R9_A587LiqFecMod[0] ;
         A588LiqUsuMod = T000R9_A588LiqUsuMod[0] ;
         A719LiqFecImp = T000R9_A719LiqFecImp[0] ;
         A743LiqPisoGanancias = T000R9_A743LiqPisoGanancias[0] ;
         A744LiqPisGanSAC = T000R9_A744LiqPisGanSAC[0] ;
         A745LiqTopeDedInc = T000R9_A745LiqTopeDedInc[0] ;
         A746LiqPerUltNorm = T000R9_A746LiqPerUltNorm[0] ;
         A766LiqError = T000R9_A766LiqError[0] ;
         A1404LiqErrorAux = T000R9_A1404LiqErrorAux[0] ;
         A874LiqNombre = T000R9_A874LiqNombre[0] ;
         A881LiqLegajosTxt = T000R9_A881LiqLegajosTxt[0] ;
         A885LiqSegundos = T000R9_A885LiqSegundos[0] ;
         A963LiqRutaPDFTodosVertical = T000R9_A963LiqRutaPDFTodosVertical[0] ;
         A964LiqRutaPDFTodosHorizontal = T000R9_A964LiqRutaPDFTodosHorizontal[0] ;
         A965LiqRutaPDFTodosNombreVertical = T000R9_A965LiqRutaPDFTodosNombreVertical[0] ;
         A966LiqRutaPDFTodosNombreHorizonta = T000R9_A966LiqRutaPDFTodosNombreHorizonta[0] ;
         A1142LiqLog = T000R9_A1142LiqLog[0] ;
         A2195LiqSac = T000R9_A2195LiqSac[0] ;
         n2195LiqSac = T000R9_n2195LiqSac[0] ;
         A2196LiqSacLog = T000R9_A2196LiqSacLog[0] ;
         n2196LiqSacLog = T000R9_n2196LiqSacLog[0] ;
         A2298LiqCancel = T000R9_A2298LiqCancel[0] ;
         A2409LiqModTra = T000R9_A2409LiqModTra[0] ;
         A2414LiqFrecPag = T000R9_A2414LiqFrecPag[0] ;
         A2410LiqPerDes = T000R9_A2410LiqPerDes[0] ;
         A2411LiqPerHas = T000R9_A2411LiqPerHas[0] ;
         A2426LiqTipoTarifa = T000R9_A2426LiqTipoTarifa[0] ;
         A33LiqDepBanCod = T000R9_A33LiqDepBanCod[0] ;
         n33LiqDepBanCod = T000R9_n33LiqDepBanCod[0] ;
         A32TLiqCod = T000R9_A32TLiqCod[0] ;
         n32TLiqCod = T000R9_n32TLiqCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
         A1729PeriodoLiq = T000R9_A1729PeriodoLiq[0] ;
         A2112LiqRelNro = T000R9_A2112LiqRelNro[0] ;
         n2112LiqRelNro = T000R9_n2112LiqRelNro[0] ;
         zm0R25( -22) ;
      }
      pr_default.close(7);
      onLoadActions0R25( ) ;
   }

   public void onLoadActions0R25( )
   {
      AV29Pgmname = "Liquidacion" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
   }

   public void checkExtendedTable0R25( )
   {
      nIsDirty_25 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV29Pgmname = "Liquidacion" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A98LiqFecha)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "de Liquidacion", ""), "", "", "", "", "", "", "", ""), 1, "LIQFECHA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLiqFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A268LiqClase == 0 ) || ( A268LiqClase == 1 ) || (0==A268LiqClase) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Clase", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "LIQCLASE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbLiqClase.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000R4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n33LiqDepBanCod), A33LiqDepBanCod});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A33LiqDepBanCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Banco Previsional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQDEPBANCOD");
            AnyError = (short)(1) ;
         }
      }
      A582LiqDepBanDescrip = T000R4_A582LiqDepBanDescrip[0] ;
      pr_default.close(2);
      /* Using cursor T000R5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A2EmpNom = T000R5_A2EmpNom[0] ;
      pr_default.close(3);
      /* Using cursor T000R6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A32TLiqCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TLIQCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = dynTLiqCod.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A340TliqDesc = T000R6_A340TliqDesc[0] ;
      pr_default.close(4);
      /* Using cursor T000R7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1729PeriodoLiq});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Periodo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERIODOLIQ");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(5);
      /* Using cursor T000R8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2112LiqRelNro), Integer.valueOf(A2112LiqRelNro)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A2112LiqRelNro) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Relacionada", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQRELNRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmpCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(6);
   }

   public void closeExtendedTableCursors0R25( )
   {
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(4);
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void gxload_23( int A3CliCod ,
                          String A33LiqDepBanCod )
   {
      /* Using cursor T000R10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n33LiqDepBanCod), A33LiqDepBanCod});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A33LiqDepBanCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Banco Previsional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQDEPBANCOD");
            AnyError = (short)(1) ;
         }
      }
      A582LiqDepBanDescrip = T000R10_A582LiqDepBanDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A582LiqDepBanDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void gxload_24( int A3CliCod ,
                          short A1EmpCod )
   {
      /* Using cursor T000R11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(9) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A2EmpNom = T000R11_A2EmpNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A2EmpNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(9) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(9);
   }

   public void gxload_25( int A3CliCod ,
                          String A32TLiqCod )
   {
      /* Using cursor T000R12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      if ( (pr_default.getStatus(10) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A32TLiqCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TLIQCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = dynTLiqCod.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A340TliqDesc = T000R12_A340TliqDesc[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A340TliqDesc)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void gxload_26( int A3CliCod ,
                          short A1EmpCod ,
                          java.util.Date A1729PeriodoLiq )
   {
      /* Using cursor T000R13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1729PeriodoLiq});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Periodo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERIODOLIQ");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void gxload_27( int A3CliCod ,
                          short A1EmpCod ,
                          int A2112LiqRelNro )
   {
      /* Using cursor T000R14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2112LiqRelNro), Integer.valueOf(A2112LiqRelNro)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A2112LiqRelNro) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Relacionada", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQRELNRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmpCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(12) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(12);
   }

   public void getKey0R25( )
   {
      /* Using cursor T000R15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound25 = (short)(1) ;
      }
      else
      {
         RcdFound25 = (short)(0) ;
      }
      pr_default.close(13);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000R3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0R25( 22) ;
         RcdFound25 = (short)(1) ;
         A31LiqNro = T000R3_A31LiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         A271LiqDescrip = T000R3_A271LiqDescrip[0] ;
         A98LiqFecha = T000R3_A98LiqFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A98LiqFecha", localUtil.format(A98LiqFecha, "99/99/9999"));
         A585LiqPerAno = T000R3_A585LiqPerAno[0] ;
         A586LiqPerMes = T000R3_A586LiqPerMes[0] ;
         A283LiqPeriodo = T000R3_A283LiqPeriodo[0] ;
         A280LiqFecPago = T000R3_A280LiqFecPago[0] ;
         A2368TLiqDescAux = T000R3_A2368TLiqDescAux[0] ;
         A278LiqEstado = T000R3_A278LiqEstado[0] ;
         A2292LiqLSDDepEst = T000R3_A2292LiqLSDDepEst[0] ;
         A1403LiqAuxEstado = T000R3_A1403LiqAuxEstado[0] ;
         A2293LiqContrEst = T000R3_A2293LiqContrEst[0] ;
         A268LiqClase = T000R3_A268LiqClase[0] ;
         n268LiqClase = T000R3_n268LiqClase[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A268LiqClase", GXutil.str( A268LiqClase, 1, 0));
         A2180LiqPDFEstado = T000R3_A2180LiqPDFEstado[0] ;
         n2180LiqPDFEstado = T000R3_n2180LiqPDFEstado[0] ;
         A361LiqGenInter = T000R3_A361LiqGenInter[0] ;
         A494LiqContabilizada = T000R3_A494LiqContabilizada[0] ;
         A495LiqCntLeg = T000R3_A495LiqCntLeg[0] ;
         A496LiqImpNeto = T000R3_A496LiqImpNeto[0] ;
         A755LiqImpDescuentos = T000R3_A755LiqImpDescuentos[0] ;
         A756LiqImpRetenGan = T000R3_A756LiqImpRetenGan[0] ;
         A497LiqImpBruto = T000R3_A497LiqImpBruto[0] ;
         A500LegEspecificos = T000R3_A500LegEspecificos[0] ;
         A511LiqFecCre = T000R3_A511LiqFecCre[0] ;
         A512LiqUsuCre = T000R3_A512LiqUsuCre[0] ;
         A513LiqPerSinDia = T000R3_A513LiqPerSinDia[0] ;
         A748LiqPerPalabra = T000R3_A748LiqPerPalabra[0] ;
         A580LiqDepPrvPer = T000R3_A580LiqDepPrvPer[0] ;
         A581LiqDepPrvFec = T000R3_A581LiqDepPrvFec[0] ;
         A583LiqDepPerAno = T000R3_A583LiqDepPerAno[0] ;
         A584LiqDepPerMes = T000R3_A584LiqDepPerMes[0] ;
         A587LiqFecMod = T000R3_A587LiqFecMod[0] ;
         A588LiqUsuMod = T000R3_A588LiqUsuMod[0] ;
         A719LiqFecImp = T000R3_A719LiqFecImp[0] ;
         A743LiqPisoGanancias = T000R3_A743LiqPisoGanancias[0] ;
         A744LiqPisGanSAC = T000R3_A744LiqPisGanSAC[0] ;
         A745LiqTopeDedInc = T000R3_A745LiqTopeDedInc[0] ;
         A746LiqPerUltNorm = T000R3_A746LiqPerUltNorm[0] ;
         A766LiqError = T000R3_A766LiqError[0] ;
         A1404LiqErrorAux = T000R3_A1404LiqErrorAux[0] ;
         A874LiqNombre = T000R3_A874LiqNombre[0] ;
         A881LiqLegajosTxt = T000R3_A881LiqLegajosTxt[0] ;
         A885LiqSegundos = T000R3_A885LiqSegundos[0] ;
         A963LiqRutaPDFTodosVertical = T000R3_A963LiqRutaPDFTodosVertical[0] ;
         A964LiqRutaPDFTodosHorizontal = T000R3_A964LiqRutaPDFTodosHorizontal[0] ;
         A965LiqRutaPDFTodosNombreVertical = T000R3_A965LiqRutaPDFTodosNombreVertical[0] ;
         A966LiqRutaPDFTodosNombreHorizonta = T000R3_A966LiqRutaPDFTodosNombreHorizonta[0] ;
         A1142LiqLog = T000R3_A1142LiqLog[0] ;
         A2195LiqSac = T000R3_A2195LiqSac[0] ;
         n2195LiqSac = T000R3_n2195LiqSac[0] ;
         A2196LiqSacLog = T000R3_A2196LiqSacLog[0] ;
         n2196LiqSacLog = T000R3_n2196LiqSacLog[0] ;
         A2298LiqCancel = T000R3_A2298LiqCancel[0] ;
         A2409LiqModTra = T000R3_A2409LiqModTra[0] ;
         A2414LiqFrecPag = T000R3_A2414LiqFrecPag[0] ;
         A2410LiqPerDes = T000R3_A2410LiqPerDes[0] ;
         A2411LiqPerHas = T000R3_A2411LiqPerHas[0] ;
         A2426LiqTipoTarifa = T000R3_A2426LiqTipoTarifa[0] ;
         A3CliCod = T000R3_A3CliCod[0] ;
         A33LiqDepBanCod = T000R3_A33LiqDepBanCod[0] ;
         n33LiqDepBanCod = T000R3_n33LiqDepBanCod[0] ;
         A1EmpCod = T000R3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A32TLiqCod = T000R3_A32TLiqCod[0] ;
         n32TLiqCod = T000R3_n32TLiqCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
         A1729PeriodoLiq = T000R3_A1729PeriodoLiq[0] ;
         A2112LiqRelNro = T000R3_A2112LiqRelNro[0] ;
         n2112LiqRelNro = T000R3_n2112LiqRelNro[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z31LiqNro = A31LiqNro ;
         sMode25 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0R25( ) ;
         if ( AnyError == 1 )
         {
            RcdFound25 = (short)(0) ;
            initializeNonKey0R25( ) ;
         }
         Gx_mode = sMode25 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound25 = (short)(0) ;
         initializeNonKey0R25( ) ;
         sMode25 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode25 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0R25( ) ;
      if ( RcdFound25 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound25 = (short)(0) ;
      /* Using cursor T000R16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         while ( (pr_default.getStatus(14) != 101) && ( ( T000R16_A3CliCod[0] < A3CliCod ) || ( T000R16_A3CliCod[0] == A3CliCod ) && ( T000R16_A1EmpCod[0] < A1EmpCod ) || ( T000R16_A1EmpCod[0] == A1EmpCod ) && ( T000R16_A3CliCod[0] == A3CliCod ) && ( T000R16_A31LiqNro[0] < A31LiqNro ) ) )
         {
            pr_default.readNext(14);
         }
         if ( (pr_default.getStatus(14) != 101) && ( ( T000R16_A3CliCod[0] > A3CliCod ) || ( T000R16_A3CliCod[0] == A3CliCod ) && ( T000R16_A1EmpCod[0] > A1EmpCod ) || ( T000R16_A1EmpCod[0] == A1EmpCod ) && ( T000R16_A3CliCod[0] == A3CliCod ) && ( T000R16_A31LiqNro[0] > A31LiqNro ) ) )
         {
            A3CliCod = T000R16_A3CliCod[0] ;
            A1EmpCod = T000R16_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A31LiqNro = T000R16_A31LiqNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
            RcdFound25 = (short)(1) ;
         }
      }
      pr_default.close(14);
   }

   public void move_previous( )
   {
      RcdFound25 = (short)(0) ;
      /* Using cursor T000R17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         while ( (pr_default.getStatus(15) != 101) && ( ( T000R17_A3CliCod[0] > A3CliCod ) || ( T000R17_A3CliCod[0] == A3CliCod ) && ( T000R17_A1EmpCod[0] > A1EmpCod ) || ( T000R17_A1EmpCod[0] == A1EmpCod ) && ( T000R17_A3CliCod[0] == A3CliCod ) && ( T000R17_A31LiqNro[0] > A31LiqNro ) ) )
         {
            pr_default.readNext(15);
         }
         if ( (pr_default.getStatus(15) != 101) && ( ( T000R17_A3CliCod[0] < A3CliCod ) || ( T000R17_A3CliCod[0] == A3CliCod ) && ( T000R17_A1EmpCod[0] < A1EmpCod ) || ( T000R17_A1EmpCod[0] == A1EmpCod ) && ( T000R17_A3CliCod[0] == A3CliCod ) && ( T000R17_A31LiqNro[0] < A31LiqNro ) ) )
         {
            A3CliCod = T000R17_A3CliCod[0] ;
            A1EmpCod = T000R17_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A31LiqNro = T000R17_A31LiqNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
            RcdFound25 = (short)(1) ;
         }
      }
      pr_default.close(15);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0R25( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtLiqFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0R25( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound25 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A31LiqNro = Z31LiqNro ;
               httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "EMPCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtLiqFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0R25( ) ;
               GX_FocusControl = edtLiqFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) )
            {
               /* Insert record */
               GX_FocusControl = edtLiqFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0R25( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "EMPCOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtEmpCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtLiqFecha_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0R25( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A31LiqNro = Z31LiqNro ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtLiqFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0R25( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000R2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Liquidacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z271LiqDescrip, T000R2_A271LiqDescrip[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z98LiqFecha), GXutil.resetTime(T000R2_A98LiqFecha[0])) ) || ( Z585LiqPerAno != T000R2_A585LiqPerAno[0] ) || ( Z586LiqPerMes != T000R2_A586LiqPerMes[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z283LiqPeriodo), GXutil.resetTime(T000R2_A283LiqPeriodo[0])) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z280LiqFecPago), GXutil.resetTime(T000R2_A280LiqFecPago[0])) ) || ( GXutil.strcmp(Z2368TLiqDescAux, T000R2_A2368TLiqDescAux[0]) != 0 ) || ( Z278LiqEstado != T000R2_A278LiqEstado[0] ) || ( Z2292LiqLSDDepEst != T000R2_A2292LiqLSDDepEst[0] ) || ( Z1403LiqAuxEstado != T000R2_A1403LiqAuxEstado[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2293LiqContrEst != T000R2_A2293LiqContrEst[0] ) || ( Z268LiqClase != T000R2_A268LiqClase[0] ) || ( GXutil.strcmp(Z2180LiqPDFEstado, T000R2_A2180LiqPDFEstado[0]) != 0 ) || ( Z361LiqGenInter != T000R2_A361LiqGenInter[0] ) || ( Z494LiqContabilizada != T000R2_A494LiqContabilizada[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z495LiqCntLeg != T000R2_A495LiqCntLeg[0] ) || ( DecimalUtil.compareTo(Z496LiqImpNeto, T000R2_A496LiqImpNeto[0]) != 0 ) || ( DecimalUtil.compareTo(Z755LiqImpDescuentos, T000R2_A755LiqImpDescuentos[0]) != 0 ) || ( DecimalUtil.compareTo(Z756LiqImpRetenGan, T000R2_A756LiqImpRetenGan[0]) != 0 ) || ( DecimalUtil.compareTo(Z497LiqImpBruto, T000R2_A497LiqImpBruto[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z500LegEspecificos != T000R2_A500LegEspecificos[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z511LiqFecCre), GXutil.resetTime(T000R2_A511LiqFecCre[0])) ) || ( GXutil.strcmp(Z512LiqUsuCre, T000R2_A512LiqUsuCre[0]) != 0 ) || ( GXutil.strcmp(Z513LiqPerSinDia, T000R2_A513LiqPerSinDia[0]) != 0 ) || ( GXutil.strcmp(Z748LiqPerPalabra, T000R2_A748LiqPerPalabra[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z580LiqDepPrvPer, T000R2_A580LiqDepPrvPer[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z581LiqDepPrvFec), GXutil.resetTime(T000R2_A581LiqDepPrvFec[0])) ) || ( Z583LiqDepPerAno != T000R2_A583LiqDepPerAno[0] ) || ( Z584LiqDepPerMes != T000R2_A584LiqDepPerMes[0] ) || !( GXutil.dateCompare(Z587LiqFecMod, T000R2_A587LiqFecMod[0]) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z588LiqUsuMod, T000R2_A588LiqUsuMod[0]) != 0 ) || !( GXutil.dateCompare(Z719LiqFecImp, T000R2_A719LiqFecImp[0]) ) || ( DecimalUtil.compareTo(Z743LiqPisoGanancias, T000R2_A743LiqPisoGanancias[0]) != 0 ) || ( DecimalUtil.compareTo(Z744LiqPisGanSAC, T000R2_A744LiqPisGanSAC[0]) != 0 ) || ( DecimalUtil.compareTo(Z745LiqTopeDedInc, T000R2_A745LiqTopeDedInc[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z746LiqPerUltNorm), GXutil.resetTime(T000R2_A746LiqPerUltNorm[0])) ) || ( GXutil.strcmp(Z766LiqError, T000R2_A766LiqError[0]) != 0 ) || ( GXutil.strcmp(Z1404LiqErrorAux, T000R2_A1404LiqErrorAux[0]) != 0 ) || ( GXutil.strcmp(Z874LiqNombre, T000R2_A874LiqNombre[0]) != 0 ) || ( GXutil.strcmp(Z881LiqLegajosTxt, T000R2_A881LiqLegajosTxt[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z885LiqSegundos, T000R2_A885LiqSegundos[0]) != 0 ) || ( GXutil.strcmp(Z963LiqRutaPDFTodosVertical, T000R2_A963LiqRutaPDFTodosVertical[0]) != 0 ) || ( GXutil.strcmp(Z964LiqRutaPDFTodosHorizontal, T000R2_A964LiqRutaPDFTodosHorizontal[0]) != 0 ) || ( GXutil.strcmp(Z965LiqRutaPDFTodosNombreVertical, T000R2_A965LiqRutaPDFTodosNombreVertical[0]) != 0 ) || ( GXutil.strcmp(Z966LiqRutaPDFTodosNombreHorizonta, T000R2_A966LiqRutaPDFTodosNombreHorizonta[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2195LiqSac != T000R2_A2195LiqSac[0] ) || ( GXutil.strcmp(Z2196LiqSacLog, T000R2_A2196LiqSacLog[0]) != 0 ) || ( Z2298LiqCancel != T000R2_A2298LiqCancel[0] ) || ( GXutil.strcmp(Z2409LiqModTra, T000R2_A2409LiqModTra[0]) != 0 ) || ( Z2414LiqFrecPag != T000R2_A2414LiqFrecPag[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z2410LiqPerDes), GXutil.resetTime(T000R2_A2410LiqPerDes[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z2411LiqPerHas), GXutil.resetTime(T000R2_A2411LiqPerHas[0])) ) || ( GXutil.strcmp(Z2426LiqTipoTarifa, T000R2_A2426LiqTipoTarifa[0]) != 0 ) || ( GXutil.strcmp(Z33LiqDepBanCod, T000R2_A33LiqDepBanCod[0]) != 0 ) || ( GXutil.strcmp(Z32TLiqCod, T000R2_A32TLiqCod[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z1729PeriodoLiq), GXutil.resetTime(T000R2_A1729PeriodoLiq[0])) ) || ( Z2112LiqRelNro != T000R2_A2112LiqRelNro[0] ) )
         {
            if ( GXutil.strcmp(Z271LiqDescrip, T000R2_A271LiqDescrip[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqDescrip");
               GXutil.writeLogRaw("Old: ",Z271LiqDescrip);
               GXutil.writeLogRaw("Current: ",T000R2_A271LiqDescrip[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z98LiqFecha), GXutil.resetTime(T000R2_A98LiqFecha[0])) ) )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqFecha");
               GXutil.writeLogRaw("Old: ",Z98LiqFecha);
               GXutil.writeLogRaw("Current: ",T000R2_A98LiqFecha[0]);
            }
            if ( Z585LiqPerAno != T000R2_A585LiqPerAno[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqPerAno");
               GXutil.writeLogRaw("Old: ",Z585LiqPerAno);
               GXutil.writeLogRaw("Current: ",T000R2_A585LiqPerAno[0]);
            }
            if ( Z586LiqPerMes != T000R2_A586LiqPerMes[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqPerMes");
               GXutil.writeLogRaw("Old: ",Z586LiqPerMes);
               GXutil.writeLogRaw("Current: ",T000R2_A586LiqPerMes[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z283LiqPeriodo), GXutil.resetTime(T000R2_A283LiqPeriodo[0])) ) )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqPeriodo");
               GXutil.writeLogRaw("Old: ",Z283LiqPeriodo);
               GXutil.writeLogRaw("Current: ",T000R2_A283LiqPeriodo[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z280LiqFecPago), GXutil.resetTime(T000R2_A280LiqFecPago[0])) ) )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqFecPago");
               GXutil.writeLogRaw("Old: ",Z280LiqFecPago);
               GXutil.writeLogRaw("Current: ",T000R2_A280LiqFecPago[0]);
            }
            if ( GXutil.strcmp(Z2368TLiqDescAux, T000R2_A2368TLiqDescAux[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"TLiqDescAux");
               GXutil.writeLogRaw("Old: ",Z2368TLiqDescAux);
               GXutil.writeLogRaw("Current: ",T000R2_A2368TLiqDescAux[0]);
            }
            if ( Z278LiqEstado != T000R2_A278LiqEstado[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqEstado");
               GXutil.writeLogRaw("Old: ",Z278LiqEstado);
               GXutil.writeLogRaw("Current: ",T000R2_A278LiqEstado[0]);
            }
            if ( Z2292LiqLSDDepEst != T000R2_A2292LiqLSDDepEst[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqLSDDepEst");
               GXutil.writeLogRaw("Old: ",Z2292LiqLSDDepEst);
               GXutil.writeLogRaw("Current: ",T000R2_A2292LiqLSDDepEst[0]);
            }
            if ( Z1403LiqAuxEstado != T000R2_A1403LiqAuxEstado[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqAuxEstado");
               GXutil.writeLogRaw("Old: ",Z1403LiqAuxEstado);
               GXutil.writeLogRaw("Current: ",T000R2_A1403LiqAuxEstado[0]);
            }
            if ( Z2293LiqContrEst != T000R2_A2293LiqContrEst[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqContrEst");
               GXutil.writeLogRaw("Old: ",Z2293LiqContrEst);
               GXutil.writeLogRaw("Current: ",T000R2_A2293LiqContrEst[0]);
            }
            if ( Z268LiqClase != T000R2_A268LiqClase[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqClase");
               GXutil.writeLogRaw("Old: ",Z268LiqClase);
               GXutil.writeLogRaw("Current: ",T000R2_A268LiqClase[0]);
            }
            if ( GXutil.strcmp(Z2180LiqPDFEstado, T000R2_A2180LiqPDFEstado[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqPDFEstado");
               GXutil.writeLogRaw("Old: ",Z2180LiqPDFEstado);
               GXutil.writeLogRaw("Current: ",T000R2_A2180LiqPDFEstado[0]);
            }
            if ( Z361LiqGenInter != T000R2_A361LiqGenInter[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqGenInter");
               GXutil.writeLogRaw("Old: ",Z361LiqGenInter);
               GXutil.writeLogRaw("Current: ",T000R2_A361LiqGenInter[0]);
            }
            if ( Z494LiqContabilizada != T000R2_A494LiqContabilizada[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqContabilizada");
               GXutil.writeLogRaw("Old: ",Z494LiqContabilizada);
               GXutil.writeLogRaw("Current: ",T000R2_A494LiqContabilizada[0]);
            }
            if ( Z495LiqCntLeg != T000R2_A495LiqCntLeg[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqCntLeg");
               GXutil.writeLogRaw("Old: ",Z495LiqCntLeg);
               GXutil.writeLogRaw("Current: ",T000R2_A495LiqCntLeg[0]);
            }
            if ( DecimalUtil.compareTo(Z496LiqImpNeto, T000R2_A496LiqImpNeto[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqImpNeto");
               GXutil.writeLogRaw("Old: ",Z496LiqImpNeto);
               GXutil.writeLogRaw("Current: ",T000R2_A496LiqImpNeto[0]);
            }
            if ( DecimalUtil.compareTo(Z755LiqImpDescuentos, T000R2_A755LiqImpDescuentos[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqImpDescuentos");
               GXutil.writeLogRaw("Old: ",Z755LiqImpDescuentos);
               GXutil.writeLogRaw("Current: ",T000R2_A755LiqImpDescuentos[0]);
            }
            if ( DecimalUtil.compareTo(Z756LiqImpRetenGan, T000R2_A756LiqImpRetenGan[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqImpRetenGan");
               GXutil.writeLogRaw("Old: ",Z756LiqImpRetenGan);
               GXutil.writeLogRaw("Current: ",T000R2_A756LiqImpRetenGan[0]);
            }
            if ( DecimalUtil.compareTo(Z497LiqImpBruto, T000R2_A497LiqImpBruto[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqImpBruto");
               GXutil.writeLogRaw("Old: ",Z497LiqImpBruto);
               GXutil.writeLogRaw("Current: ",T000R2_A497LiqImpBruto[0]);
            }
            if ( Z500LegEspecificos != T000R2_A500LegEspecificos[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LegEspecificos");
               GXutil.writeLogRaw("Old: ",Z500LegEspecificos);
               GXutil.writeLogRaw("Current: ",T000R2_A500LegEspecificos[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z511LiqFecCre), GXutil.resetTime(T000R2_A511LiqFecCre[0])) ) )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqFecCre");
               GXutil.writeLogRaw("Old: ",Z511LiqFecCre);
               GXutil.writeLogRaw("Current: ",T000R2_A511LiqFecCre[0]);
            }
            if ( GXutil.strcmp(Z512LiqUsuCre, T000R2_A512LiqUsuCre[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqUsuCre");
               GXutil.writeLogRaw("Old: ",Z512LiqUsuCre);
               GXutil.writeLogRaw("Current: ",T000R2_A512LiqUsuCre[0]);
            }
            if ( GXutil.strcmp(Z513LiqPerSinDia, T000R2_A513LiqPerSinDia[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqPerSinDia");
               GXutil.writeLogRaw("Old: ",Z513LiqPerSinDia);
               GXutil.writeLogRaw("Current: ",T000R2_A513LiqPerSinDia[0]);
            }
            if ( GXutil.strcmp(Z748LiqPerPalabra, T000R2_A748LiqPerPalabra[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqPerPalabra");
               GXutil.writeLogRaw("Old: ",Z748LiqPerPalabra);
               GXutil.writeLogRaw("Current: ",T000R2_A748LiqPerPalabra[0]);
            }
            if ( GXutil.strcmp(Z580LiqDepPrvPer, T000R2_A580LiqDepPrvPer[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqDepPrvPer");
               GXutil.writeLogRaw("Old: ",Z580LiqDepPrvPer);
               GXutil.writeLogRaw("Current: ",T000R2_A580LiqDepPrvPer[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z581LiqDepPrvFec), GXutil.resetTime(T000R2_A581LiqDepPrvFec[0])) ) )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqDepPrvFec");
               GXutil.writeLogRaw("Old: ",Z581LiqDepPrvFec);
               GXutil.writeLogRaw("Current: ",T000R2_A581LiqDepPrvFec[0]);
            }
            if ( Z583LiqDepPerAno != T000R2_A583LiqDepPerAno[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqDepPerAno");
               GXutil.writeLogRaw("Old: ",Z583LiqDepPerAno);
               GXutil.writeLogRaw("Current: ",T000R2_A583LiqDepPerAno[0]);
            }
            if ( Z584LiqDepPerMes != T000R2_A584LiqDepPerMes[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqDepPerMes");
               GXutil.writeLogRaw("Old: ",Z584LiqDepPerMes);
               GXutil.writeLogRaw("Current: ",T000R2_A584LiqDepPerMes[0]);
            }
            if ( !( GXutil.dateCompare(Z587LiqFecMod, T000R2_A587LiqFecMod[0]) ) )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqFecMod");
               GXutil.writeLogRaw("Old: ",Z587LiqFecMod);
               GXutil.writeLogRaw("Current: ",T000R2_A587LiqFecMod[0]);
            }
            if ( GXutil.strcmp(Z588LiqUsuMod, T000R2_A588LiqUsuMod[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqUsuMod");
               GXutil.writeLogRaw("Old: ",Z588LiqUsuMod);
               GXutil.writeLogRaw("Current: ",T000R2_A588LiqUsuMod[0]);
            }
            if ( !( GXutil.dateCompare(Z719LiqFecImp, T000R2_A719LiqFecImp[0]) ) )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqFecImp");
               GXutil.writeLogRaw("Old: ",Z719LiqFecImp);
               GXutil.writeLogRaw("Current: ",T000R2_A719LiqFecImp[0]);
            }
            if ( DecimalUtil.compareTo(Z743LiqPisoGanancias, T000R2_A743LiqPisoGanancias[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqPisoGanancias");
               GXutil.writeLogRaw("Old: ",Z743LiqPisoGanancias);
               GXutil.writeLogRaw("Current: ",T000R2_A743LiqPisoGanancias[0]);
            }
            if ( DecimalUtil.compareTo(Z744LiqPisGanSAC, T000R2_A744LiqPisGanSAC[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqPisGanSAC");
               GXutil.writeLogRaw("Old: ",Z744LiqPisGanSAC);
               GXutil.writeLogRaw("Current: ",T000R2_A744LiqPisGanSAC[0]);
            }
            if ( DecimalUtil.compareTo(Z745LiqTopeDedInc, T000R2_A745LiqTopeDedInc[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqTopeDedInc");
               GXutil.writeLogRaw("Old: ",Z745LiqTopeDedInc);
               GXutil.writeLogRaw("Current: ",T000R2_A745LiqTopeDedInc[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z746LiqPerUltNorm), GXutil.resetTime(T000R2_A746LiqPerUltNorm[0])) ) )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqPerUltNorm");
               GXutil.writeLogRaw("Old: ",Z746LiqPerUltNorm);
               GXutil.writeLogRaw("Current: ",T000R2_A746LiqPerUltNorm[0]);
            }
            if ( GXutil.strcmp(Z766LiqError, T000R2_A766LiqError[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqError");
               GXutil.writeLogRaw("Old: ",Z766LiqError);
               GXutil.writeLogRaw("Current: ",T000R2_A766LiqError[0]);
            }
            if ( GXutil.strcmp(Z1404LiqErrorAux, T000R2_A1404LiqErrorAux[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqErrorAux");
               GXutil.writeLogRaw("Old: ",Z1404LiqErrorAux);
               GXutil.writeLogRaw("Current: ",T000R2_A1404LiqErrorAux[0]);
            }
            if ( GXutil.strcmp(Z874LiqNombre, T000R2_A874LiqNombre[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqNombre");
               GXutil.writeLogRaw("Old: ",Z874LiqNombre);
               GXutil.writeLogRaw("Current: ",T000R2_A874LiqNombre[0]);
            }
            if ( GXutil.strcmp(Z881LiqLegajosTxt, T000R2_A881LiqLegajosTxt[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqLegajosTxt");
               GXutil.writeLogRaw("Old: ",Z881LiqLegajosTxt);
               GXutil.writeLogRaw("Current: ",T000R2_A881LiqLegajosTxt[0]);
            }
            if ( DecimalUtil.compareTo(Z885LiqSegundos, T000R2_A885LiqSegundos[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqSegundos");
               GXutil.writeLogRaw("Old: ",Z885LiqSegundos);
               GXutil.writeLogRaw("Current: ",T000R2_A885LiqSegundos[0]);
            }
            if ( GXutil.strcmp(Z963LiqRutaPDFTodosVertical, T000R2_A963LiqRutaPDFTodosVertical[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqRutaPDFTodosVertical");
               GXutil.writeLogRaw("Old: ",Z963LiqRutaPDFTodosVertical);
               GXutil.writeLogRaw("Current: ",T000R2_A963LiqRutaPDFTodosVertical[0]);
            }
            if ( GXutil.strcmp(Z964LiqRutaPDFTodosHorizontal, T000R2_A964LiqRutaPDFTodosHorizontal[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqRutaPDFTodosHorizontal");
               GXutil.writeLogRaw("Old: ",Z964LiqRutaPDFTodosHorizontal);
               GXutil.writeLogRaw("Current: ",T000R2_A964LiqRutaPDFTodosHorizontal[0]);
            }
            if ( GXutil.strcmp(Z965LiqRutaPDFTodosNombreVertical, T000R2_A965LiqRutaPDFTodosNombreVertical[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqRutaPDFTodosNombreVertical");
               GXutil.writeLogRaw("Old: ",Z965LiqRutaPDFTodosNombreVertical);
               GXutil.writeLogRaw("Current: ",T000R2_A965LiqRutaPDFTodosNombreVertical[0]);
            }
            if ( GXutil.strcmp(Z966LiqRutaPDFTodosNombreHorizonta, T000R2_A966LiqRutaPDFTodosNombreHorizonta[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqRutaPDFTodosNombreHorizonta");
               GXutil.writeLogRaw("Old: ",Z966LiqRutaPDFTodosNombreHorizonta);
               GXutil.writeLogRaw("Current: ",T000R2_A966LiqRutaPDFTodosNombreHorizonta[0]);
            }
            if ( Z2195LiqSac != T000R2_A2195LiqSac[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqSac");
               GXutil.writeLogRaw("Old: ",Z2195LiqSac);
               GXutil.writeLogRaw("Current: ",T000R2_A2195LiqSac[0]);
            }
            if ( GXutil.strcmp(Z2196LiqSacLog, T000R2_A2196LiqSacLog[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqSacLog");
               GXutil.writeLogRaw("Old: ",Z2196LiqSacLog);
               GXutil.writeLogRaw("Current: ",T000R2_A2196LiqSacLog[0]);
            }
            if ( Z2298LiqCancel != T000R2_A2298LiqCancel[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqCancel");
               GXutil.writeLogRaw("Old: ",Z2298LiqCancel);
               GXutil.writeLogRaw("Current: ",T000R2_A2298LiqCancel[0]);
            }
            if ( GXutil.strcmp(Z2409LiqModTra, T000R2_A2409LiqModTra[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqModTra");
               GXutil.writeLogRaw("Old: ",Z2409LiqModTra);
               GXutil.writeLogRaw("Current: ",T000R2_A2409LiqModTra[0]);
            }
            if ( Z2414LiqFrecPag != T000R2_A2414LiqFrecPag[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqFrecPag");
               GXutil.writeLogRaw("Old: ",Z2414LiqFrecPag);
               GXutil.writeLogRaw("Current: ",T000R2_A2414LiqFrecPag[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z2410LiqPerDes), GXutil.resetTime(T000R2_A2410LiqPerDes[0])) ) )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqPerDes");
               GXutil.writeLogRaw("Old: ",Z2410LiqPerDes);
               GXutil.writeLogRaw("Current: ",T000R2_A2410LiqPerDes[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z2411LiqPerHas), GXutil.resetTime(T000R2_A2411LiqPerHas[0])) ) )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqPerHas");
               GXutil.writeLogRaw("Old: ",Z2411LiqPerHas);
               GXutil.writeLogRaw("Current: ",T000R2_A2411LiqPerHas[0]);
            }
            if ( GXutil.strcmp(Z2426LiqTipoTarifa, T000R2_A2426LiqTipoTarifa[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqTipoTarifa");
               GXutil.writeLogRaw("Old: ",Z2426LiqTipoTarifa);
               GXutil.writeLogRaw("Current: ",T000R2_A2426LiqTipoTarifa[0]);
            }
            if ( GXutil.strcmp(Z33LiqDepBanCod, T000R2_A33LiqDepBanCod[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqDepBanCod");
               GXutil.writeLogRaw("Old: ",Z33LiqDepBanCod);
               GXutil.writeLogRaw("Current: ",T000R2_A33LiqDepBanCod[0]);
            }
            if ( GXutil.strcmp(Z32TLiqCod, T000R2_A32TLiqCod[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"TLiqCod");
               GXutil.writeLogRaw("Old: ",Z32TLiqCod);
               GXutil.writeLogRaw("Current: ",T000R2_A32TLiqCod[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z1729PeriodoLiq), GXutil.resetTime(T000R2_A1729PeriodoLiq[0])) ) )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"PeriodoLiq");
               GXutil.writeLogRaw("Old: ",Z1729PeriodoLiq);
               GXutil.writeLogRaw("Current: ",T000R2_A1729PeriodoLiq[0]);
            }
            if ( Z2112LiqRelNro != T000R2_A2112LiqRelNro[0] )
            {
               GXutil.writeLogln("liquidacion:[seudo value changed for attri]"+"LiqRelNro");
               GXutil.writeLogRaw("Old: ",Z2112LiqRelNro);
               GXutil.writeLogRaw("Current: ",T000R2_A2112LiqRelNro[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Liquidacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0R25( )
   {
      beforeValidate0R25( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0R25( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0R25( 0) ;
         checkOptimisticConcurrency0R25( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0R25( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0R25( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000R18 */
                  pr_default.execute(16, new Object[] {Integer.valueOf(A31LiqNro), A271LiqDescrip, A98LiqFecha, Short.valueOf(A585LiqPerAno), Byte.valueOf(A586LiqPerMes), A283LiqPeriodo, A280LiqFecPago, A2368TLiqDescAux, Byte.valueOf(A278LiqEstado), Byte.valueOf(A2292LiqLSDDepEst), Byte.valueOf(A1403LiqAuxEstado), Byte.valueOf(A2293LiqContrEst), Boolean.valueOf(n268LiqClase), Byte.valueOf(A268LiqClase), Boolean.valueOf(n2180LiqPDFEstado), A2180LiqPDFEstado, Boolean.valueOf(A361LiqGenInter), Boolean.valueOf(A494LiqContabilizada), Short.valueOf(A495LiqCntLeg), A496LiqImpNeto, A755LiqImpDescuentos, A756LiqImpRetenGan, A497LiqImpBruto, Boolean.valueOf(A500LegEspecificos), A511LiqFecCre, A512LiqUsuCre, A513LiqPerSinDia, A748LiqPerPalabra, A580LiqDepPrvPer, A581LiqDepPrvFec, Short.valueOf(A583LiqDepPerAno), Byte.valueOf(A584LiqDepPerMes), A587LiqFecMod, A588LiqUsuMod, A719LiqFecImp, A743LiqPisoGanancias, A744LiqPisGanSAC, A745LiqTopeDedInc, A746LiqPerUltNorm, A766LiqError, A1404LiqErrorAux, A874LiqNombre, A881LiqLegajosTxt, A885LiqSegundos, A963LiqRutaPDFTodosVertical, A964LiqRutaPDFTodosHorizontal, A965LiqRutaPDFTodosNombreVertical, A966LiqRutaPDFTodosNombreHorizonta, A1142LiqLog, Boolean.valueOf(n2195LiqSac), Boolean.valueOf(A2195LiqSac), Boolean.valueOf(n2196LiqSacLog), A2196LiqSacLog, Boolean.valueOf(A2298LiqCancel), A2409LiqModTra, Byte.valueOf(A2414LiqFrecPag), A2410LiqPerDes, A2411LiqPerHas, A2426LiqTipoTarifa, Integer.valueOf(A3CliCod), Boolean.valueOf(n33LiqDepBanCod), A33LiqDepBanCod, Short.valueOf(A1EmpCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A1729PeriodoLiq, Boolean.valueOf(n2112LiqRelNro), Integer.valueOf(A2112LiqRelNro)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
                  if ( (pr_default.getStatus(16) == 1) )
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
                        resetCaption0R0( ) ;
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
            load0R25( ) ;
         }
         endLevel0R25( ) ;
      }
      closeExtendedTableCursors0R25( ) ;
   }

   public void update0R25( )
   {
      beforeValidate0R25( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0R25( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0R25( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0R25( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0R25( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000R19 */
                  pr_default.execute(17, new Object[] {A271LiqDescrip, A98LiqFecha, Short.valueOf(A585LiqPerAno), Byte.valueOf(A586LiqPerMes), A283LiqPeriodo, A280LiqFecPago, A2368TLiqDescAux, Byte.valueOf(A278LiqEstado), Byte.valueOf(A2292LiqLSDDepEst), Byte.valueOf(A1403LiqAuxEstado), Byte.valueOf(A2293LiqContrEst), Boolean.valueOf(n268LiqClase), Byte.valueOf(A268LiqClase), Boolean.valueOf(n2180LiqPDFEstado), A2180LiqPDFEstado, Boolean.valueOf(A361LiqGenInter), Boolean.valueOf(A494LiqContabilizada), Short.valueOf(A495LiqCntLeg), A496LiqImpNeto, A755LiqImpDescuentos, A756LiqImpRetenGan, A497LiqImpBruto, Boolean.valueOf(A500LegEspecificos), A511LiqFecCre, A512LiqUsuCre, A513LiqPerSinDia, A748LiqPerPalabra, A580LiqDepPrvPer, A581LiqDepPrvFec, Short.valueOf(A583LiqDepPerAno), Byte.valueOf(A584LiqDepPerMes), A587LiqFecMod, A588LiqUsuMod, A719LiqFecImp, A743LiqPisoGanancias, A744LiqPisGanSAC, A745LiqTopeDedInc, A746LiqPerUltNorm, A766LiqError, A1404LiqErrorAux, A874LiqNombre, A881LiqLegajosTxt, A885LiqSegundos, A963LiqRutaPDFTodosVertical, A964LiqRutaPDFTodosHorizontal, A965LiqRutaPDFTodosNombreVertical, A966LiqRutaPDFTodosNombreHorizonta, A1142LiqLog, Boolean.valueOf(n2195LiqSac), Boolean.valueOf(A2195LiqSac), Boolean.valueOf(n2196LiqSacLog), A2196LiqSacLog, Boolean.valueOf(A2298LiqCancel), A2409LiqModTra, Byte.valueOf(A2414LiqFrecPag), A2410LiqPerDes, A2411LiqPerHas, A2426LiqTipoTarifa, Boolean.valueOf(n33LiqDepBanCod), A33LiqDepBanCod, Boolean.valueOf(n32TLiqCod), A32TLiqCod, A1729PeriodoLiq, Boolean.valueOf(n2112LiqRelNro), Integer.valueOf(A2112LiqRelNro), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
                  if ( (pr_default.getStatus(17) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Liquidacion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0R25( ) ;
                  if ( AnyError == 0 )
                  {
                     GXv_int5[0] = A3CliCod ;
                     GXv_int6[0] = A1EmpCod ;
                     GXv_int7[0] = A31LiqNro ;
                     new web.liquidacionupdateredundancy(remoteHandle, context).execute( GXv_int5, GXv_int6, GXv_int7) ;
                     liquidacion_impl.this.A3CliCod = GXv_int5[0] ;
                     liquidacion_impl.this.A1EmpCod = GXv_int6[0] ;
                     liquidacion_impl.this.A31LiqNro = GXv_int7[0] ;
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
         endLevel0R25( ) ;
      }
      closeExtendedTableCursors0R25( ) ;
   }

   public void deferredUpdate0R25( )
   {
   }

   public void delete( )
   {
      beforeValidate0R25( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0R25( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0R25( ) ;
         afterConfirm0R25( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0R25( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000R20 */
               pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
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
      sMode25 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0R25( ) ;
      Gx_mode = sMode25 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0R25( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV29Pgmname = "Liquidacion" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
         /* Using cursor T000R21 */
         pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n33LiqDepBanCod), A33LiqDepBanCod});
         A582LiqDepBanDescrip = T000R21_A582LiqDepBanDescrip[0] ;
         pr_default.close(19);
         /* Using cursor T000R22 */
         pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         A2EmpNom = T000R22_A2EmpNom[0] ;
         pr_default.close(20);
         /* Using cursor T000R23 */
         pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
         A340TliqDesc = T000R23_A340TliqDesc[0] ;
         pr_default.close(21);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000R24 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
         /* Using cursor T000R25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(23) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionLegajoLinkPdf", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
         /* Using cursor T000R26 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(24) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_cuenta_licenciasconsumos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(24);
         /* Using cursor T000R27 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(25) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_cuenta_licenciasaprobaciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
         /* Using cursor T000R28 */
         pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_permanencia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
         /* Using cursor T000R29 */
         pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(27) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionSucursal", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(27);
         /* Using cursor T000R30 */
         pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(28) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionArea", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(28);
         /* Using cursor T000R31 */
         pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(29) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionConvenio", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(29);
         /* Using cursor T000R32 */
         pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(30) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LSD_reg1", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(30);
         /* Using cursor T000R33 */
         pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Obligacion Cuenta", "")+" ("+httpContext.getMessage( "Liq Nueva Obl Cuenta", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor T000R34 */
         pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Obligacion Cuenta", "")+" ("+httpContext.getMessage( "Liq Alta Obl Cuenta", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor T000R35 */
         pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Obligacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor T000R36 */
         pr_default.execute(34, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Concepto Cuenta", "")+" ("+httpContext.getMessage( "Liq Nueva Prorra", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor T000R37 */
         pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Concepto Cuenta", "")+" ("+httpContext.getMessage( "Liq Alta Prorrateo", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
         /* Using cursor T000R38 */
         pr_default.execute(36, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(36) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Lugar Pago", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
         /* Using cursor T000R39 */
         pr_default.execute(37, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(37) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(37);
         /* Using cursor T000R40 */
         pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(38) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Agenda de Novedades", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(38);
      }
   }

   public void endLevel0R25( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0R25( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "liquidacion");
         if ( AnyError == 0 )
         {
            confirmValues0R0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "liquidacion");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0R25( )
   {
      /* Scan By routine */
      /* Using cursor T000R41 */
      pr_default.execute(39);
      RcdFound25 = (short)(0) ;
      if ( (pr_default.getStatus(39) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A3CliCod = T000R41_A3CliCod[0] ;
         A1EmpCod = T000R41_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A31LiqNro = T000R41_A31LiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0R25( )
   {
      /* Scan next routine */
      pr_default.readNext(39);
      RcdFound25 = (short)(0) ;
      if ( (pr_default.getStatus(39) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A3CliCod = T000R41_A3CliCod[0] ;
         A1EmpCod = T000R41_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A31LiqNro = T000R41_A31LiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
      }
   }

   public void scanEnd0R25( )
   {
      pr_default.close(39);
   }

   public void afterConfirm0R25( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0R25( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0R25( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0R25( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0R25( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0R25( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0R25( )
   {
      edtLiqNro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNro_Enabled), 5, 0), true);
      edtLiqFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqFecha_Enabled), 5, 0), true);
      dynTLiqCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynTLiqCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynTLiqCod.getEnabled(), 5, 0), true);
      cmbLiqClase.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbLiqClase.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLiqClase.getEnabled(), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0R25( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0R0( )
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.liquidacion", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV23CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV7EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8LiqNro,8,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LiqNro"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Liquidacion");
      forbiddenHiddens.add("LiqNro", localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("LiqDescrip", GXutil.rtrim( localUtil.format( A271LiqDescrip, "")));
      forbiddenHiddens.add("LiqPerAno", localUtil.format( DecimalUtil.doubleToDec(A585LiqPerAno), "ZZZ9"));
      forbiddenHiddens.add("LiqPerMes", localUtil.format( DecimalUtil.doubleToDec(A586LiqPerMes), "Z9"));
      forbiddenHiddens.add("LiqPeriodo", localUtil.format(A283LiqPeriodo, "99/99/9999"));
      forbiddenHiddens.add("LiqFecPago", localUtil.format(A280LiqFecPago, "99/99/9999"));
      forbiddenHiddens.add("TLiqDescAux", GXutil.rtrim( localUtil.format( A2368TLiqDescAux, "@!")));
      forbiddenHiddens.add("LiqEstado", localUtil.format( DecimalUtil.doubleToDec(A278LiqEstado), "9"));
      forbiddenHiddens.add("LiqLSDDepEst", localUtil.format( DecimalUtil.doubleToDec(A2292LiqLSDDepEst), "9"));
      forbiddenHiddens.add("LiqAuxEstado", localUtil.format( DecimalUtil.doubleToDec(A1403LiqAuxEstado), "9"));
      forbiddenHiddens.add("LiqContrEst", localUtil.format( DecimalUtil.doubleToDec(A2293LiqContrEst), "9"));
      forbiddenHiddens.add("LiqPDFEstado", GXutil.rtrim( localUtil.format( A2180LiqPDFEstado, "")));
      forbiddenHiddens.add("LiqGenInter", GXutil.booltostr( A361LiqGenInter));
      forbiddenHiddens.add("LiqContabilizada", GXutil.booltostr( A494LiqContabilizada));
      forbiddenHiddens.add("LiqCntLeg", localUtil.format( DecimalUtil.doubleToDec(A495LiqCntLeg), "ZZZ9"));
      forbiddenHiddens.add("LiqImpNeto", localUtil.format( A496LiqImpNeto, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqImpDescuentos", localUtil.format( A755LiqImpDescuentos, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqImpRetenGan", localUtil.format( A756LiqImpRetenGan, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqImpBruto", localUtil.format( A497LiqImpBruto, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LegEspecificos", GXutil.booltostr( A500LegEspecificos));
      forbiddenHiddens.add("LiqFecCre", localUtil.format(A511LiqFecCre, "99/99/99"));
      forbiddenHiddens.add("LiqUsuCre", GXutil.rtrim( localUtil.format( A512LiqUsuCre, "")));
      forbiddenHiddens.add("LiqPerSinDia", GXutil.rtrim( localUtil.format( A513LiqPerSinDia, "")));
      forbiddenHiddens.add("LiqPerPalabra", GXutil.rtrim( localUtil.format( A748LiqPerPalabra, "")));
      forbiddenHiddens.add("LiqDepPrvPer", GXutil.rtrim( localUtil.format( A580LiqDepPrvPer, "")));
      forbiddenHiddens.add("LiqDepPrvFec", localUtil.format(A581LiqDepPrvFec, "99/99/99"));
      forbiddenHiddens.add("LiqDepPerAno", localUtil.format( DecimalUtil.doubleToDec(A583LiqDepPerAno), "ZZZ9"));
      forbiddenHiddens.add("LiqDepPerMes", localUtil.format( DecimalUtil.doubleToDec(A584LiqDepPerMes), "Z9"));
      forbiddenHiddens.add("LiqFecMod", localUtil.format( A587LiqFecMod, "99/99/99 99:99"));
      forbiddenHiddens.add("LiqUsuMod", GXutil.rtrim( localUtil.format( A588LiqUsuMod, "")));
      forbiddenHiddens.add("LiqFecImp", localUtil.format( A719LiqFecImp, "99/99/99 99:99"));
      forbiddenHiddens.add("LiqPisoGanancias", localUtil.format( A743LiqPisoGanancias, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqPisGanSAC", localUtil.format( A744LiqPisGanSAC, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqTopeDedInc", localUtil.format( A745LiqTopeDedInc, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqPerUltNorm", localUtil.format(A746LiqPerUltNorm, "99/99/9999"));
      forbiddenHiddens.add("LiqError", GXutil.rtrim( localUtil.format( A766LiqError, "")));
      forbiddenHiddens.add("LiqErrorAux", GXutil.rtrim( localUtil.format( A1404LiqErrorAux, "")));
      forbiddenHiddens.add("LiqNombre", GXutil.rtrim( localUtil.format( A874LiqNombre, "")));
      forbiddenHiddens.add("LiqLegajosTxt", GXutil.rtrim( localUtil.format( A881LiqLegajosTxt, "")));
      forbiddenHiddens.add("LiqSegundos", localUtil.format( A885LiqSegundos, "Z9.99"));
      forbiddenHiddens.add("LiqRutaPDFTodosVertical", GXutil.rtrim( localUtil.format( A963LiqRutaPDFTodosVertical, "")));
      forbiddenHiddens.add("LiqRutaPDFTodosHorizontal", GXutil.rtrim( localUtil.format( A964LiqRutaPDFTodosHorizontal, "")));
      forbiddenHiddens.add("LiqRutaPDFTodosNombreVertical", GXutil.rtrim( localUtil.format( A965LiqRutaPDFTodosNombreVertical, "")));
      forbiddenHiddens.add("LiqRutaPDFTodosNombreHorizonta", GXutil.rtrim( localUtil.format( A966LiqRutaPDFTodosNombreHorizonta, "")));
      forbiddenHiddens.add("LiqSac", GXutil.booltostr( A2195LiqSac));
      forbiddenHiddens.add("LiqSacLog", GXutil.rtrim( localUtil.format( A2196LiqSacLog, "")));
      forbiddenHiddens.add("LiqCancel", GXutil.booltostr( A2298LiqCancel));
      forbiddenHiddens.add("LiqModTra", GXutil.rtrim( localUtil.format( A2409LiqModTra, "")));
      forbiddenHiddens.add("LiqFrecPag", localUtil.format( DecimalUtil.doubleToDec(A2414LiqFrecPag), "9"));
      forbiddenHiddens.add("LiqPerDes", localUtil.format(A2410LiqPerDes, "99/99/9999"));
      forbiddenHiddens.add("LiqPerHas", localUtil.format(A2411LiqPerHas, "99/99/9999"));
      forbiddenHiddens.add("LiqTipoTarifa", GXutil.rtrim( localUtil.format( A2426LiqTipoTarifa, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("liquidacion:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z31LiqNro", GXutil.ltrim( localUtil.ntoc( Z31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z271LiqDescrip", Z271LiqDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z98LiqFecha", localUtil.dtoc( Z98LiqFecha, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z585LiqPerAno", GXutil.ltrim( localUtil.ntoc( Z585LiqPerAno, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z586LiqPerMes", GXutil.ltrim( localUtil.ntoc( Z586LiqPerMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z283LiqPeriodo", localUtil.dtoc( Z283LiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z280LiqFecPago", localUtil.dtoc( Z280LiqFecPago, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2368TLiqDescAux", Z2368TLiqDescAux);
      web.GxWebStd.gx_hidden_field( httpContext, "Z278LiqEstado", GXutil.ltrim( localUtil.ntoc( Z278LiqEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2292LiqLSDDepEst", GXutil.ltrim( localUtil.ntoc( Z2292LiqLSDDepEst, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1403LiqAuxEstado", GXutil.ltrim( localUtil.ntoc( Z1403LiqAuxEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2293LiqContrEst", GXutil.ltrim( localUtil.ntoc( Z2293LiqContrEst, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z268LiqClase", GXutil.ltrim( localUtil.ntoc( Z268LiqClase, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2180LiqPDFEstado", GXutil.rtrim( Z2180LiqPDFEstado));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z361LiqGenInter", Z361LiqGenInter);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z494LiqContabilizada", Z494LiqContabilizada);
      web.GxWebStd.gx_hidden_field( httpContext, "Z495LiqCntLeg", GXutil.ltrim( localUtil.ntoc( Z495LiqCntLeg, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z496LiqImpNeto", GXutil.ltrim( localUtil.ntoc( Z496LiqImpNeto, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z755LiqImpDescuentos", GXutil.ltrim( localUtil.ntoc( Z755LiqImpDescuentos, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z756LiqImpRetenGan", GXutil.ltrim( localUtil.ntoc( Z756LiqImpRetenGan, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z497LiqImpBruto", GXutil.ltrim( localUtil.ntoc( Z497LiqImpBruto, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z500LegEspecificos", Z500LegEspecificos);
      web.GxWebStd.gx_hidden_field( httpContext, "Z511LiqFecCre", localUtil.dtoc( Z511LiqFecCre, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z512LiqUsuCre", Z512LiqUsuCre);
      web.GxWebStd.gx_hidden_field( httpContext, "Z513LiqPerSinDia", GXutil.rtrim( Z513LiqPerSinDia));
      web.GxWebStd.gx_hidden_field( httpContext, "Z748LiqPerPalabra", GXutil.rtrim( Z748LiqPerPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, "Z580LiqDepPrvPer", GXutil.rtrim( Z580LiqDepPrvPer));
      web.GxWebStd.gx_hidden_field( httpContext, "Z581LiqDepPrvFec", localUtil.dtoc( Z581LiqDepPrvFec, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z583LiqDepPerAno", GXutil.ltrim( localUtil.ntoc( Z583LiqDepPerAno, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z584LiqDepPerMes", GXutil.ltrim( localUtil.ntoc( Z584LiqDepPerMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z587LiqFecMod", localUtil.ttoc( Z587LiqFecMod, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "Z588LiqUsuMod", Z588LiqUsuMod);
      web.GxWebStd.gx_hidden_field( httpContext, "Z719LiqFecImp", localUtil.ttoc( Z719LiqFecImp, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "Z743LiqPisoGanancias", GXutil.ltrim( localUtil.ntoc( Z743LiqPisoGanancias, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z744LiqPisGanSAC", GXutil.ltrim( localUtil.ntoc( Z744LiqPisGanSAC, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z745LiqTopeDedInc", GXutil.ltrim( localUtil.ntoc( Z745LiqTopeDedInc, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z746LiqPerUltNorm", localUtil.dtoc( Z746LiqPerUltNorm, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z766LiqError", Z766LiqError);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1404LiqErrorAux", Z1404LiqErrorAux);
      web.GxWebStd.gx_hidden_field( httpContext, "Z874LiqNombre", Z874LiqNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "Z881LiqLegajosTxt", Z881LiqLegajosTxt);
      web.GxWebStd.gx_hidden_field( httpContext, "Z885LiqSegundos", GXutil.ltrim( localUtil.ntoc( Z885LiqSegundos, (byte)(5), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z963LiqRutaPDFTodosVertical", Z963LiqRutaPDFTodosVertical);
      web.GxWebStd.gx_hidden_field( httpContext, "Z964LiqRutaPDFTodosHorizontal", Z964LiqRutaPDFTodosHorizontal);
      web.GxWebStd.gx_hidden_field( httpContext, "Z965LiqRutaPDFTodosNombreVertical", GXutil.rtrim( Z965LiqRutaPDFTodosNombreVertical));
      web.GxWebStd.gx_hidden_field( httpContext, "Z966LiqRutaPDFTodosNombreHorizonta", GXutil.rtrim( Z966LiqRutaPDFTodosNombreHorizonta));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2195LiqSac", Z2195LiqSac);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2196LiqSacLog", Z2196LiqSacLog);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2298LiqCancel", Z2298LiqCancel);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2409LiqModTra", GXutil.rtrim( Z2409LiqModTra));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2414LiqFrecPag", GXutil.ltrim( localUtil.ntoc( Z2414LiqFrecPag, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2410LiqPerDes", localUtil.dtoc( Z2410LiqPerDes, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2411LiqPerHas", localUtil.dtoc( Z2411LiqPerHas, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2426LiqTipoTarifa", GXutil.rtrim( Z2426LiqTipoTarifa));
      web.GxWebStd.gx_hidden_field( httpContext, "Z33LiqDepBanCod", GXutil.rtrim( Z33LiqDepBanCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z32TLiqCod", GXutil.rtrim( Z32TLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1729PeriodoLiq", localUtil.dtoc( Z1729PeriodoLiq, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2112LiqRelNro", GXutil.ltrim( localUtil.ntoc( Z2112LiqRelNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N32TLiqCod", GXutil.rtrim( A32TLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, "N33LiqDepBanCod", GXutil.rtrim( A33LiqDepBanCod));
      web.GxWebStd.gx_hidden_field( httpContext, "N1729PeriodoLiq", localUtil.dtoc( A1729PeriodoLiq, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "N2112LiqRelNro", GXutil.ltrim( localUtil.ntoc( A2112LiqRelNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV23CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV23CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV7EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQNRO", GXutil.ltrim( localUtil.ntoc( AV8LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8LiqNro), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_TLIQCOD", GXutil.rtrim( AV12Insert_TLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_LIQDEPBANCOD", GXutil.rtrim( AV26Insert_LiqDepBanCod));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQDEPBANCOD", GXutil.rtrim( A33LiqDepBanCod));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PERIODOLIQ", localUtil.dtoc( AV27Insert_PeriodoLiq, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "PERIODOLIQ", localUtil.dtoc( A1729PeriodoLiq, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_LIQRELNRO", GXutil.ltrim( localUtil.ntoc( AV28Insert_LiqRelNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQRELNRO", GXutil.ltrim( localUtil.ntoc( A2112LiqRelNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQDESCRIP", A271LiqDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQPERANO", GXutil.ltrim( localUtil.ntoc( A585LiqPerAno, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQPERMES", GXutil.ltrim( localUtil.ntoc( A586LiqPerMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQPERIODO", localUtil.dtoc( A283LiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQFECPAGO", localUtil.dtoc( A280LiqFecPago, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "TLIQDESCAUX", A2368TLiqDescAux);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQESTADO", GXutil.ltrim( localUtil.ntoc( A278LiqEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLSDDEPEST", GXutil.ltrim( localUtil.ntoc( A2292LiqLSDDepEst, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQAUXESTADO", GXutil.ltrim( localUtil.ntoc( A1403LiqAuxEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQCONTREST", GXutil.ltrim( localUtil.ntoc( A2293LiqContrEst, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQPDFESTADO", GXutil.rtrim( A2180LiqPDFEstado));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "LIQGENINTER", A361LiqGenInter);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "LIQCONTABILIZADA", A494LiqContabilizada);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQCNTLEG", GXutil.ltrim( localUtil.ntoc( A495LiqCntLeg, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQIMPNETO", GXutil.ltrim( localUtil.ntoc( A496LiqImpNeto, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQIMPDESCUENTOS", GXutil.ltrim( localUtil.ntoc( A755LiqImpDescuentos, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQIMPRETENGAN", GXutil.ltrim( localUtil.ntoc( A756LiqImpRetenGan, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQIMPBRUTO", GXutil.ltrim( localUtil.ntoc( A497LiqImpBruto, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "LEGESPECIFICOS", A500LegEspecificos);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQFECCRE", localUtil.dtoc( A511LiqFecCre, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQUSUCRE", A512LiqUsuCre);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQPERSINDIA", GXutil.rtrim( A513LiqPerSinDia));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQPERPALABRA", GXutil.rtrim( A748LiqPerPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQDEPPRVPER", GXutil.rtrim( A580LiqDepPrvPer));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQDEPPRVFEC", localUtil.dtoc( A581LiqDepPrvFec, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQDEPPERANO", GXutil.ltrim( localUtil.ntoc( A583LiqDepPerAno, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQDEPPERMES", GXutil.ltrim( localUtil.ntoc( A584LiqDepPerMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQFECMOD", localUtil.ttoc( A587LiqFecMod, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQUSUMOD", A588LiqUsuMod);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQFECIMP", localUtil.ttoc( A719LiqFecImp, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQPISOGANANCIAS", GXutil.ltrim( localUtil.ntoc( A743LiqPisoGanancias, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQPISGANSAC", GXutil.ltrim( localUtil.ntoc( A744LiqPisGanSAC, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQTOPEDEDINC", GXutil.ltrim( localUtil.ntoc( A745LiqTopeDedInc, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQPERULTNORM", localUtil.dtoc( A746LiqPerUltNorm, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQERROR", A766LiqError);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQERRORAUX", A1404LiqErrorAux);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQNOMBRE", A874LiqNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGAJOSTXT", A881LiqLegajosTxt);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQSEGUNDOS", GXutil.ltrim( localUtil.ntoc( A885LiqSegundos, (byte)(5), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQRUTAPDFTODOSVERTICAL", A963LiqRutaPDFTodosVertical);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQRUTAPDFTODOSHORIZONTAL", A964LiqRutaPDFTodosHorizontal);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQRUTAPDFTODOSNOMBREVERTICAL", GXutil.rtrim( A965LiqRutaPDFTodosNombreVertical));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQRUTAPDFTODOSNOMBREHORIZONTA", GXutil.rtrim( A966LiqRutaPDFTodosNombreHorizonta));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLOG", A1142LiqLog);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "LIQSAC", A2195LiqSac);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQSACLOG", A2196LiqSacLog);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "LIQCANCEL", A2298LiqCancel);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQMODTRA", GXutil.rtrim( A2409LiqModTra));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQFRECPAG", GXutil.ltrim( localUtil.ntoc( A2414LiqFrecPag, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQPERDES", localUtil.dtoc( A2410LiqPerDes, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQPERHAS", localUtil.dtoc( A2411LiqPerHas, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQTIPOTARIFA", GXutil.rtrim( A2426LiqTipoTarifa));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQDEPBANDESCRIP", A582LiqDepBanDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "EMPNOM", A2EmpNom);
      web.GxWebStd.gx_hidden_field( httpContext, "TLIQDESC", A340TliqDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV29Pgmname));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLELEGAJOS_Objectcall", GXutil.rtrim( Dvpanel_tablelegajos_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLELEGAJOS_Enabled", GXutil.booltostr( Dvpanel_tablelegajos_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLELEGAJOS_Width", GXutil.rtrim( Dvpanel_tablelegajos_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLELEGAJOS_Autowidth", GXutil.booltostr( Dvpanel_tablelegajos_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLELEGAJOS_Autoheight", GXutil.booltostr( Dvpanel_tablelegajos_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLELEGAJOS_Cls", GXutil.rtrim( Dvpanel_tablelegajos_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLELEGAJOS_Title", GXutil.rtrim( Dvpanel_tablelegajos_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLELEGAJOS_Collapsible", GXutil.booltostr( Dvpanel_tablelegajos_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLELEGAJOS_Collapsed", GXutil.booltostr( Dvpanel_tablelegajos_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLELEGAJOS_Showcollapseicon", GXutil.booltostr( Dvpanel_tablelegajos_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLELEGAJOS_Iconposition", GXutil.rtrim( Dvpanel_tablelegajos_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLELEGAJOS_Autoscroll", GXutil.booltostr( Dvpanel_tablelegajos_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEGANANCIAS_Objectcall", GXutil.rtrim( Dvpanel_tableganancias_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEGANANCIAS_Enabled", GXutil.booltostr( Dvpanel_tableganancias_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEGANANCIAS_Width", GXutil.rtrim( Dvpanel_tableganancias_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEGANANCIAS_Autowidth", GXutil.booltostr( Dvpanel_tableganancias_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEGANANCIAS_Autoheight", GXutil.booltostr( Dvpanel_tableganancias_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEGANANCIAS_Cls", GXutil.rtrim( Dvpanel_tableganancias_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEGANANCIAS_Title", GXutil.rtrim( Dvpanel_tableganancias_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEGANANCIAS_Collapsible", GXutil.booltostr( Dvpanel_tableganancias_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEGANANCIAS_Collapsed", GXutil.booltostr( Dvpanel_tableganancias_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEGANANCIAS_Showcollapseicon", GXutil.booltostr( Dvpanel_tableganancias_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEGANANCIAS_Iconposition", GXutil.rtrim( Dvpanel_tableganancias_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEGANANCIAS_Autoscroll", GXutil.booltostr( Dvpanel_tableganancias_Autoscroll));
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
      return formatLink("web.liquidacion", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV23CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV7EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8LiqNro,8,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LiqNro"})  ;
   }

   public String getPgmname( )
   {
      return "Liquidacion" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Liquidacion", "") ;
   }

   public void initializeNonKey0R25( )
   {
      A32TLiqCod = "" ;
      n32TLiqCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
      n32TLiqCod = ((GXutil.strcmp("", A32TLiqCod)==0) ? true : false) ;
      A33LiqDepBanCod = "" ;
      n33LiqDepBanCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A33LiqDepBanCod", A33LiqDepBanCod);
      A1729PeriodoLiq = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
      A2112LiqRelNro = 0 ;
      n2112LiqRelNro = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2112LiqRelNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2112LiqRelNro), 8, 0));
      A2EmpNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
      A271LiqDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A271LiqDescrip", A271LiqDescrip);
      A98LiqFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A98LiqFecha", localUtil.format(A98LiqFecha, "99/99/9999"));
      A585LiqPerAno = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A585LiqPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(A585LiqPerAno), 4, 0));
      A586LiqPerMes = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A586LiqPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A586LiqPerMes), 2, 0));
      A283LiqPeriodo = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A283LiqPeriodo", localUtil.format(A283LiqPeriodo, "99/99/9999"));
      A280LiqFecPago = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A280LiqFecPago", localUtil.format(A280LiqFecPago, "99/99/9999"));
      A340TliqDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A340TliqDesc", A340TliqDesc);
      A2368TLiqDescAux = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2368TLiqDescAux", A2368TLiqDescAux);
      A278LiqEstado = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A278LiqEstado", GXutil.str( A278LiqEstado, 1, 0));
      A2292LiqLSDDepEst = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2292LiqLSDDepEst", GXutil.str( A2292LiqLSDDepEst, 1, 0));
      A1403LiqAuxEstado = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1403LiqAuxEstado", GXutil.str( A1403LiqAuxEstado, 1, 0));
      A2293LiqContrEst = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2293LiqContrEst", GXutil.str( A2293LiqContrEst, 1, 0));
      A268LiqClase = (byte)(0) ;
      n268LiqClase = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A268LiqClase", GXutil.str( A268LiqClase, 1, 0));
      n268LiqClase = ((0==A268LiqClase) ? true : false) ;
      A2180LiqPDFEstado = "" ;
      n2180LiqPDFEstado = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2180LiqPDFEstado", A2180LiqPDFEstado);
      A361LiqGenInter = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A361LiqGenInter", A361LiqGenInter);
      A494LiqContabilizada = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A494LiqContabilizada", A494LiqContabilizada);
      A495LiqCntLeg = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A495LiqCntLeg", GXutil.ltrimstr( DecimalUtil.doubleToDec(A495LiqCntLeg), 4, 0));
      A496LiqImpNeto = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A496LiqImpNeto", GXutil.ltrimstr( A496LiqImpNeto, 14, 2));
      A755LiqImpDescuentos = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A755LiqImpDescuentos", GXutil.ltrimstr( A755LiqImpDescuentos, 14, 2));
      A756LiqImpRetenGan = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A756LiqImpRetenGan", GXutil.ltrimstr( A756LiqImpRetenGan, 14, 2));
      A497LiqImpBruto = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A497LiqImpBruto", GXutil.ltrimstr( A497LiqImpBruto, 14, 2));
      A500LegEspecificos = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A500LegEspecificos", A500LegEspecificos);
      A511LiqFecCre = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A511LiqFecCre", localUtil.format(A511LiqFecCre, "99/99/99"));
      A512LiqUsuCre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A512LiqUsuCre", A512LiqUsuCre);
      A513LiqPerSinDia = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A513LiqPerSinDia", A513LiqPerSinDia);
      A748LiqPerPalabra = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A748LiqPerPalabra", A748LiqPerPalabra);
      A580LiqDepPrvPer = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A580LiqDepPrvPer", A580LiqDepPrvPer);
      A581LiqDepPrvFec = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A581LiqDepPrvFec", localUtil.format(A581LiqDepPrvFec, "99/99/99"));
      A582LiqDepBanDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A582LiqDepBanDescrip", A582LiqDepBanDescrip);
      A583LiqDepPerAno = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A583LiqDepPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(A583LiqDepPerAno), 4, 0));
      A584LiqDepPerMes = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A584LiqDepPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A584LiqDepPerMes), 2, 0));
      A587LiqFecMod = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "A587LiqFecMod", localUtil.ttoc( A587LiqFecMod, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A588LiqUsuMod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A588LiqUsuMod", A588LiqUsuMod);
      A719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "A719LiqFecImp", localUtil.ttoc( A719LiqFecImp, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A743LiqPisoGanancias = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A743LiqPisoGanancias", GXutil.ltrimstr( A743LiqPisoGanancias, 14, 2));
      A744LiqPisGanSAC = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A744LiqPisGanSAC", GXutil.ltrimstr( A744LiqPisGanSAC, 14, 2));
      A745LiqTopeDedInc = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A745LiqTopeDedInc", GXutil.ltrimstr( A745LiqTopeDedInc, 14, 2));
      A746LiqPerUltNorm = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A746LiqPerUltNorm", localUtil.format(A746LiqPerUltNorm, "99/99/9999"));
      A766LiqError = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A766LiqError", A766LiqError);
      A1404LiqErrorAux = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1404LiqErrorAux", A1404LiqErrorAux);
      A874LiqNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A874LiqNombre", A874LiqNombre);
      A881LiqLegajosTxt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A881LiqLegajosTxt", A881LiqLegajosTxt);
      A885LiqSegundos = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A885LiqSegundos", GXutil.ltrimstr( A885LiqSegundos, 5, 2));
      A963LiqRutaPDFTodosVertical = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A963LiqRutaPDFTodosVertical", A963LiqRutaPDFTodosVertical);
      A964LiqRutaPDFTodosHorizontal = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A964LiqRutaPDFTodosHorizontal", A964LiqRutaPDFTodosHorizontal);
      A965LiqRutaPDFTodosNombreVertical = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A965LiqRutaPDFTodosNombreVertical", A965LiqRutaPDFTodosNombreVertical);
      A966LiqRutaPDFTodosNombreHorizonta = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A966LiqRutaPDFTodosNombreHorizonta", A966LiqRutaPDFTodosNombreHorizonta);
      A1142LiqLog = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1142LiqLog", A1142LiqLog);
      A2195LiqSac = false ;
      n2195LiqSac = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2195LiqSac", A2195LiqSac);
      A2196LiqSacLog = "" ;
      n2196LiqSacLog = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2196LiqSacLog", A2196LiqSacLog);
      A2298LiqCancel = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2298LiqCancel", A2298LiqCancel);
      A2409LiqModTra = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2409LiqModTra", A2409LiqModTra);
      A2414LiqFrecPag = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2414LiqFrecPag", GXutil.str( A2414LiqFrecPag, 1, 0));
      A2410LiqPerDes = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A2410LiqPerDes", localUtil.format(A2410LiqPerDes, "99/99/9999"));
      A2411LiqPerHas = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A2411LiqPerHas", localUtil.format(A2411LiqPerHas, "99/99/9999"));
      A2426LiqTipoTarifa = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2426LiqTipoTarifa", A2426LiqTipoTarifa);
      Z271LiqDescrip = "" ;
      Z98LiqFecha = GXutil.nullDate() ;
      Z585LiqPerAno = (short)(0) ;
      Z586LiqPerMes = (byte)(0) ;
      Z283LiqPeriodo = GXutil.nullDate() ;
      Z280LiqFecPago = GXutil.nullDate() ;
      Z2368TLiqDescAux = "" ;
      Z278LiqEstado = (byte)(0) ;
      Z2292LiqLSDDepEst = (byte)(0) ;
      Z1403LiqAuxEstado = (byte)(0) ;
      Z2293LiqContrEst = (byte)(0) ;
      Z268LiqClase = (byte)(0) ;
      Z2180LiqPDFEstado = "" ;
      Z361LiqGenInter = false ;
      Z494LiqContabilizada = false ;
      Z495LiqCntLeg = (short)(0) ;
      Z496LiqImpNeto = DecimalUtil.ZERO ;
      Z755LiqImpDescuentos = DecimalUtil.ZERO ;
      Z756LiqImpRetenGan = DecimalUtil.ZERO ;
      Z497LiqImpBruto = DecimalUtil.ZERO ;
      Z500LegEspecificos = false ;
      Z511LiqFecCre = GXutil.nullDate() ;
      Z512LiqUsuCre = "" ;
      Z513LiqPerSinDia = "" ;
      Z748LiqPerPalabra = "" ;
      Z580LiqDepPrvPer = "" ;
      Z581LiqDepPrvFec = GXutil.nullDate() ;
      Z583LiqDepPerAno = (short)(0) ;
      Z584LiqDepPerMes = (byte)(0) ;
      Z587LiqFecMod = GXutil.resetTime( GXutil.nullDate() );
      Z588LiqUsuMod = "" ;
      Z719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      Z743LiqPisoGanancias = DecimalUtil.ZERO ;
      Z744LiqPisGanSAC = DecimalUtil.ZERO ;
      Z745LiqTopeDedInc = DecimalUtil.ZERO ;
      Z746LiqPerUltNorm = GXutil.nullDate() ;
      Z766LiqError = "" ;
      Z1404LiqErrorAux = "" ;
      Z874LiqNombre = "" ;
      Z881LiqLegajosTxt = "" ;
      Z885LiqSegundos = DecimalUtil.ZERO ;
      Z963LiqRutaPDFTodosVertical = "" ;
      Z964LiqRutaPDFTodosHorizontal = "" ;
      Z965LiqRutaPDFTodosNombreVertical = "" ;
      Z966LiqRutaPDFTodosNombreHorizonta = "" ;
      Z2195LiqSac = false ;
      Z2196LiqSacLog = "" ;
      Z2298LiqCancel = false ;
      Z2409LiqModTra = "" ;
      Z2414LiqFrecPag = (byte)(0) ;
      Z2410LiqPerDes = GXutil.nullDate() ;
      Z2411LiqPerHas = GXutil.nullDate() ;
      Z2426LiqTipoTarifa = "" ;
      Z33LiqDepBanCod = "" ;
      Z32TLiqCod = "" ;
      Z1729PeriodoLiq = GXutil.nullDate() ;
      Z2112LiqRelNro = 0 ;
   }

   public void initAll0R25( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A31LiqNro = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
      initializeNonKey0R25( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025188284355", true, true);
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
      httpContext.AddJavascriptSource("liquidacion.js", "?2025188284355", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtLiqNro_Internalname = "LIQNRO" ;
      edtLiqFecha_Internalname = "LIQFECHA" ;
      dynTLiqCod.setInternalname( "TLIQCOD" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      cmbLiqClase.setInternalname( "LIQCLASE" );
      radavAplicaa.setInternalname( "vAPLICAA" );
      divTablelegajos_Internalname = "TABLELEGAJOS" ;
      Dvpanel_tablelegajos_Internalname = "DVPANEL_TABLELEGAJOS" ;
      divTableganancias_Internalname = "TABLEGANANCIAS" ;
      Dvpanel_tableganancias_Internalname = "DVPANEL_TABLEGANANCIAS" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      Form.setCaption( httpContext.getMessage( "Liquidacion", "") );
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      Dvpanel_tableganancias_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableganancias_Iconposition = "Right" ;
      Dvpanel_tableganancias_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableganancias_Collapsed = GXutil.toBoolean( 1) ;
      Dvpanel_tableganancias_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_tableganancias_Title = httpContext.getMessage( "Ganancias", "") ;
      Dvpanel_tableganancias_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableganancias_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableganancias_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableganancias_Width = "100%" ;
      radavAplicaa.setJsonclick( "" );
      radavAplicaa.setEnabled( 0 );
      cmbLiqClase.setJsonclick( "" );
      cmbLiqClase.setEnabled( 1 );
      Dvpanel_tablelegajos_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tablelegajos_Iconposition = "Right" ;
      Dvpanel_tablelegajos_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tablelegajos_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tablelegajos_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_tablelegajos_Title = httpContext.getMessage( "Legajos", "") ;
      Dvpanel_tablelegajos_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tablelegajos_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tablelegajos_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tablelegajos_Width = "100%" ;
      dynTLiqCod.setJsonclick( "" );
      dynTLiqCod.setEnabled( 1 );
      edtLiqFecha_Jsonclick = "" ;
      edtLiqFecha_Enabled = 1 ;
      edtLiqNro_Jsonclick = "" ;
      edtLiqNro_Enabled = 0 ;
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

   public void gxdlatliqcod0R25( int A3CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlatliqcod_data0R25( A3CliCod) ;
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

   public void gxatliqcod_html0R25( int A3CliCod )
   {
      String gxdynajaxvalue;
      gxdlatliqcod_data0R25( A3CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynTLiqCod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynTLiqCod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlatliqcod_data0R25( int A3CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "Todos", ""));
      /* Using cursor T000R42 */
      pr_default.execute(40, new Object[] {Integer.valueOf(A3CliCod)});
      while ( (pr_default.getStatus(40) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T000R42_A32TLiqCod[0]));
         gxdynajaxctrldescr.add(T000R42_A340TliqDesc[0]);
         pr_default.readNext(40);
      }
      pr_default.close(40);
   }

   public void gx5asaclicod0R25( int AV23CliCod )
   {
      if ( ! (0==AV23CliCod) )
      {
         A3CliCod = AV23CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int7[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
            liquidacion_impl.this.GXt_int4 = GXv_int7[0] ;
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

   public void init_web_controls( )
   {
      dynTLiqCod.setName( "TLIQCOD" );
      dynTLiqCod.setWebtags( "" );
      cmbLiqClase.setName( "LIQCLASE" );
      cmbLiqClase.setWebtags( "" );
      cmbLiqClase.addItem("0", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbLiqClase.addItem("1", httpContext.getMessage( "Jornal", ""), (short)(0));
      if ( cmbLiqClase.getItemCount() > 0 )
      {
         A268LiqClase = (byte)(GXutil.lval( cmbLiqClase.getValidValue(GXutil.trim( GXutil.str( A268LiqClase, 1, 0))))) ;
         n268LiqClase = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A268LiqClase", GXutil.str( A268LiqClase, 1, 0));
      }
      radavAplicaa.setName( "vAPLICAA" );
      radavAplicaa.setWebtags( "" );
      radavAplicaa.addItem("TODOS", httpContext.getMessage( "Todos los empleados", ""), (short)(0));
      radavAplicaa.addItem("ALGUNOS", httpContext.getMessage( "Empleados específicos", ""), (short)(0));
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

   public void valid_Empcod( )
   {
      n32TLiqCod = false ;
      A32TLiqCod = dynTLiqCod.getValue() ;
      n32TLiqCod = false ;
      /* Using cursor T000R43 */
      pr_default.execute(41, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(41) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpCod_Internalname ;
      }
      A2EmpNom = T000R43_A2EmpNom[0] ;
      pr_default.close(41);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
   }

   public void valid_Tliqcod( )
   {
      n32TLiqCod = false ;
      A32TLiqCod = dynTLiqCod.getValue() ;
      n32TLiqCod = false ;
      /* Using cursor T000R44 */
      pr_default.execute(42, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      if ( (pr_default.getStatus(42) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A32TLiqCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TLIQCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = dynTLiqCod.getInternalname() ;
         }
      }
      A340TliqDesc = T000R44_A340TliqDesc[0] ;
      pr_default.close(42);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A340TliqDesc", A340TliqDesc);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV23CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV23CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A271LiqDescrip',fld:'LIQDESCRIP',pic:''},{av:'A585LiqPerAno',fld:'LIQPERANO',pic:'ZZZ9'},{av:'A586LiqPerMes',fld:'LIQPERMES',pic:'Z9'},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:''},{av:'A280LiqFecPago',fld:'LIQFECPAGO',pic:''},{av:'A2368TLiqDescAux',fld:'TLIQDESCAUX',pic:'@!'},{av:'A278LiqEstado',fld:'LIQESTADO',pic:'9'},{av:'A2292LiqLSDDepEst',fld:'LIQLSDDEPEST',pic:'9'},{av:'A1403LiqAuxEstado',fld:'LIQAUXESTADO',pic:'9'},{av:'A2293LiqContrEst',fld:'LIQCONTREST',pic:'9'},{av:'A2180LiqPDFEstado',fld:'LIQPDFESTADO',pic:''},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:''},{av:'A494LiqContabilizada',fld:'LIQCONTABILIZADA',pic:''},{av:'A495LiqCntLeg',fld:'LIQCNTLEG',pic:'ZZZ9'},{av:'A496LiqImpNeto',fld:'LIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A755LiqImpDescuentos',fld:'LIQIMPDESCUENTOS',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A756LiqImpRetenGan',fld:'LIQIMPRETENGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A497LiqImpBruto',fld:'LIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A500LegEspecificos',fld:'LEGESPECIFICOS',pic:''},{av:'A511LiqFecCre',fld:'LIQFECCRE',pic:''},{av:'A512LiqUsuCre',fld:'LIQUSUCRE',pic:''},{av:'A513LiqPerSinDia',fld:'LIQPERSINDIA',pic:''},{av:'A748LiqPerPalabra',fld:'LIQPERPALABRA',pic:''},{av:'A580LiqDepPrvPer',fld:'LIQDEPPRVPER',pic:''},{av:'A581LiqDepPrvFec',fld:'LIQDEPPRVFEC',pic:''},{av:'A583LiqDepPerAno',fld:'LIQDEPPERANO',pic:'ZZZ9'},{av:'A584LiqDepPerMes',fld:'LIQDEPPERMES',pic:'Z9'},{av:'A587LiqFecMod',fld:'LIQFECMOD',pic:'99/99/99 99:99'},{av:'A588LiqUsuMod',fld:'LIQUSUMOD',pic:''},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99'},{av:'A743LiqPisoGanancias',fld:'LIQPISOGANANCIAS',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A744LiqPisGanSAC',fld:'LIQPISGANSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A745LiqTopeDedInc',fld:'LIQTOPEDEDINC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A746LiqPerUltNorm',fld:'LIQPERULTNORM',pic:''},{av:'A766LiqError',fld:'LIQERROR',pic:''},{av:'A1404LiqErrorAux',fld:'LIQERRORAUX',pic:''},{av:'A874LiqNombre',fld:'LIQNOMBRE',pic:''},{av:'A881LiqLegajosTxt',fld:'LIQLEGAJOSTXT',pic:''},{av:'A885LiqSegundos',fld:'LIQSEGUNDOS',pic:'Z9.99'},{av:'A963LiqRutaPDFTodosVertical',fld:'LIQRUTAPDFTODOSVERTICAL',pic:''},{av:'A964LiqRutaPDFTodosHorizontal',fld:'LIQRUTAPDFTODOSHORIZONTAL',pic:''},{av:'A965LiqRutaPDFTodosNombreVertical',fld:'LIQRUTAPDFTODOSNOMBREVERTICAL',pic:''},{av:'A966LiqRutaPDFTodosNombreHorizonta',fld:'LIQRUTAPDFTODOSNOMBREHORIZONTA',pic:''},{av:'A2195LiqSac',fld:'LIQSAC',pic:''},{av:'A2196LiqSacLog',fld:'LIQSACLOG',pic:''},{av:'A2298LiqCancel',fld:'LIQCANCEL',pic:''},{av:'A2409LiqModTra',fld:'LIQMODTRA',pic:''},{av:'A2414LiqFrecPag',fld:'LIQFRECPAG',pic:'9'},{av:'A2410LiqPerDes',fld:'LIQPERDES',pic:''},{av:'A2411LiqPerHas',fld:'LIQPERHAS',pic:''},{av:'A2426LiqTipoTarifa',fld:'LIQTIPOTARIFA',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e120R2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]}");
      setEventMetadata("VALID_LIQNRO","{handler:'valid_Liqnro',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]");
      setEventMetadata("VALID_LIQNRO",",oparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]}");
      setEventMetadata("VALID_LIQFECHA","{handler:'valid_Liqfecha',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]");
      setEventMetadata("VALID_LIQFECHA",",oparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]}");
      setEventMetadata("VALID_TLIQCOD","{handler:'valid_Tliqcod',iparms:[{av:'A340TliqDesc',fld:'TLIQDESC',pic:'@!'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]");
      setEventMetadata("VALID_TLIQCOD",",oparms:[{av:'A340TliqDesc',fld:'TLIQDESC',pic:'@!'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]}");
      setEventMetadata("VALID_LIQCLASE","{handler:'valid_Liqclase',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]");
      setEventMetadata("VALID_LIQCLASE",",oparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A2EmpNom',fld:'EMPNOM',pic:'@!'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'A2EmpNom',fld:'EMPNOM',pic:'@!'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV22AplicaA',fld:'vAPLICAA',pic:''}]}");
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
      pr_default.close(19);
      pr_default.close(41);
      pr_default.close(20);
      pr_default.close(42);
      pr_default.close(21);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z271LiqDescrip = "" ;
      Z98LiqFecha = GXutil.nullDate() ;
      Z283LiqPeriodo = GXutil.nullDate() ;
      Z280LiqFecPago = GXutil.nullDate() ;
      Z2368TLiqDescAux = "" ;
      Z2180LiqPDFEstado = "" ;
      Z496LiqImpNeto = DecimalUtil.ZERO ;
      Z755LiqImpDescuentos = DecimalUtil.ZERO ;
      Z756LiqImpRetenGan = DecimalUtil.ZERO ;
      Z497LiqImpBruto = DecimalUtil.ZERO ;
      Z511LiqFecCre = GXutil.nullDate() ;
      Z512LiqUsuCre = "" ;
      Z513LiqPerSinDia = "" ;
      Z748LiqPerPalabra = "" ;
      Z580LiqDepPrvPer = "" ;
      Z581LiqDepPrvFec = GXutil.nullDate() ;
      Z587LiqFecMod = GXutil.resetTime( GXutil.nullDate() );
      Z588LiqUsuMod = "" ;
      Z719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      Z743LiqPisoGanancias = DecimalUtil.ZERO ;
      Z744LiqPisGanSAC = DecimalUtil.ZERO ;
      Z745LiqTopeDedInc = DecimalUtil.ZERO ;
      Z746LiqPerUltNorm = GXutil.nullDate() ;
      Z766LiqError = "" ;
      Z1404LiqErrorAux = "" ;
      Z874LiqNombre = "" ;
      Z881LiqLegajosTxt = "" ;
      Z885LiqSegundos = DecimalUtil.ZERO ;
      Z963LiqRutaPDFTodosVertical = "" ;
      Z964LiqRutaPDFTodosHorizontal = "" ;
      Z965LiqRutaPDFTodosNombreVertical = "" ;
      Z966LiqRutaPDFTodosNombreHorizonta = "" ;
      Z2196LiqSacLog = "" ;
      Z2409LiqModTra = "" ;
      Z2410LiqPerDes = GXutil.nullDate() ;
      Z2411LiqPerHas = GXutil.nullDate() ;
      Z2426LiqTipoTarifa = "" ;
      Z33LiqDepBanCod = "" ;
      Z32TLiqCod = "" ;
      Z1729PeriodoLiq = GXutil.nullDate() ;
      N32TLiqCod = "" ;
      N33LiqDepBanCod = "" ;
      N1729PeriodoLiq = GXutil.nullDate() ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A33LiqDepBanCod = "" ;
      A32TLiqCod = "" ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      AV22AplicaA = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      ucDvpanel_tablelegajos = new com.genexus.webpanels.GXUserControl();
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableganancias = new com.genexus.webpanels.GXUserControl();
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A2180LiqPDFEstado = "" ;
      A2196LiqSacLog = "" ;
      A271LiqDescrip = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A280LiqFecPago = GXutil.nullDate() ;
      A2368TLiqDescAux = "" ;
      A496LiqImpNeto = DecimalUtil.ZERO ;
      A755LiqImpDescuentos = DecimalUtil.ZERO ;
      A756LiqImpRetenGan = DecimalUtil.ZERO ;
      A497LiqImpBruto = DecimalUtil.ZERO ;
      A511LiqFecCre = GXutil.nullDate() ;
      A512LiqUsuCre = "" ;
      A513LiqPerSinDia = "" ;
      A748LiqPerPalabra = "" ;
      A580LiqDepPrvPer = "" ;
      A581LiqDepPrvFec = GXutil.nullDate() ;
      A587LiqFecMod = GXutil.resetTime( GXutil.nullDate() );
      A588LiqUsuMod = "" ;
      A719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      A743LiqPisoGanancias = DecimalUtil.ZERO ;
      A744LiqPisGanSAC = DecimalUtil.ZERO ;
      A745LiqTopeDedInc = DecimalUtil.ZERO ;
      A746LiqPerUltNorm = GXutil.nullDate() ;
      A766LiqError = "" ;
      A1404LiqErrorAux = "" ;
      A874LiqNombre = "" ;
      A881LiqLegajosTxt = "" ;
      A885LiqSegundos = DecimalUtil.ZERO ;
      A963LiqRutaPDFTodosVertical = "" ;
      A964LiqRutaPDFTodosHorizontal = "" ;
      A965LiqRutaPDFTodosNombreVertical = "" ;
      A966LiqRutaPDFTodosNombreHorizonta = "" ;
      A2409LiqModTra = "" ;
      A2410LiqPerDes = GXutil.nullDate() ;
      A2411LiqPerHas = GXutil.nullDate() ;
      A2426LiqTipoTarifa = "" ;
      AV12Insert_TLiqCod = "" ;
      AV26Insert_LiqDepBanCod = "" ;
      AV27Insert_PeriodoLiq = GXutil.nullDate() ;
      A1142LiqLog = "" ;
      A582LiqDepBanDescrip = "" ;
      A2EmpNom = "" ;
      A340TliqDesc = "" ;
      AV29Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Dvpanel_tablelegajos_Objectcall = "" ;
      Dvpanel_tablelegajos_Class = "" ;
      Dvpanel_tablelegajos_Height = "" ;
      Dvpanel_tableganancias_Objectcall = "" ;
      Dvpanel_tableganancias_Class = "" ;
      Dvpanel_tableganancias_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode25 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      AV13TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z1142LiqLog = "" ;
      Z582LiqDepBanDescrip = "" ;
      Z2EmpNom = "" ;
      Z340TliqDesc = "" ;
      T000R6_A340TliqDesc = new String[] {""} ;
      T000R5_A2EmpNom = new String[] {""} ;
      T000R4_A582LiqDepBanDescrip = new String[] {""} ;
      T000R9_A31LiqNro = new int[1] ;
      T000R9_A2EmpNom = new String[] {""} ;
      T000R9_A271LiqDescrip = new String[] {""} ;
      T000R9_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000R9_A585LiqPerAno = new short[1] ;
      T000R9_A586LiqPerMes = new byte[1] ;
      T000R9_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T000R9_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      T000R9_A340TliqDesc = new String[] {""} ;
      T000R9_A2368TLiqDescAux = new String[] {""} ;
      T000R9_A278LiqEstado = new byte[1] ;
      T000R9_A2292LiqLSDDepEst = new byte[1] ;
      T000R9_A1403LiqAuxEstado = new byte[1] ;
      T000R9_A2293LiqContrEst = new byte[1] ;
      T000R9_A268LiqClase = new byte[1] ;
      T000R9_n268LiqClase = new boolean[] {false} ;
      T000R9_A2180LiqPDFEstado = new String[] {""} ;
      T000R9_n2180LiqPDFEstado = new boolean[] {false} ;
      T000R9_A361LiqGenInter = new boolean[] {false} ;
      T000R9_A494LiqContabilizada = new boolean[] {false} ;
      T000R9_A495LiqCntLeg = new short[1] ;
      T000R9_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R9_A755LiqImpDescuentos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R9_A756LiqImpRetenGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R9_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R9_A500LegEspecificos = new boolean[] {false} ;
      T000R9_A511LiqFecCre = new java.util.Date[] {GXutil.nullDate()} ;
      T000R9_A512LiqUsuCre = new String[] {""} ;
      T000R9_A513LiqPerSinDia = new String[] {""} ;
      T000R9_A748LiqPerPalabra = new String[] {""} ;
      T000R9_A580LiqDepPrvPer = new String[] {""} ;
      T000R9_A581LiqDepPrvFec = new java.util.Date[] {GXutil.nullDate()} ;
      T000R9_A582LiqDepBanDescrip = new String[] {""} ;
      T000R9_A583LiqDepPerAno = new short[1] ;
      T000R9_A584LiqDepPerMes = new byte[1] ;
      T000R9_A587LiqFecMod = new java.util.Date[] {GXutil.nullDate()} ;
      T000R9_A588LiqUsuMod = new String[] {""} ;
      T000R9_A719LiqFecImp = new java.util.Date[] {GXutil.nullDate()} ;
      T000R9_A743LiqPisoGanancias = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R9_A744LiqPisGanSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R9_A745LiqTopeDedInc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R9_A746LiqPerUltNorm = new java.util.Date[] {GXutil.nullDate()} ;
      T000R9_A766LiqError = new String[] {""} ;
      T000R9_A1404LiqErrorAux = new String[] {""} ;
      T000R9_A874LiqNombre = new String[] {""} ;
      T000R9_A881LiqLegajosTxt = new String[] {""} ;
      T000R9_A885LiqSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R9_A963LiqRutaPDFTodosVertical = new String[] {""} ;
      T000R9_A964LiqRutaPDFTodosHorizontal = new String[] {""} ;
      T000R9_A965LiqRutaPDFTodosNombreVertical = new String[] {""} ;
      T000R9_A966LiqRutaPDFTodosNombreHorizonta = new String[] {""} ;
      T000R9_A1142LiqLog = new String[] {""} ;
      T000R9_A2195LiqSac = new boolean[] {false} ;
      T000R9_n2195LiqSac = new boolean[] {false} ;
      T000R9_A2196LiqSacLog = new String[] {""} ;
      T000R9_n2196LiqSacLog = new boolean[] {false} ;
      T000R9_A2298LiqCancel = new boolean[] {false} ;
      T000R9_A2409LiqModTra = new String[] {""} ;
      T000R9_A2414LiqFrecPag = new byte[1] ;
      T000R9_A2410LiqPerDes = new java.util.Date[] {GXutil.nullDate()} ;
      T000R9_A2411LiqPerHas = new java.util.Date[] {GXutil.nullDate()} ;
      T000R9_A2426LiqTipoTarifa = new String[] {""} ;
      T000R9_A3CliCod = new int[1] ;
      T000R9_A33LiqDepBanCod = new String[] {""} ;
      T000R9_n33LiqDepBanCod = new boolean[] {false} ;
      T000R9_A1EmpCod = new short[1] ;
      T000R9_A32TLiqCod = new String[] {""} ;
      T000R9_n32TLiqCod = new boolean[] {false} ;
      T000R9_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      T000R9_A2112LiqRelNro = new int[1] ;
      T000R9_n2112LiqRelNro = new boolean[] {false} ;
      T000R7_A3CliCod = new int[1] ;
      T000R8_A3CliCod = new int[1] ;
      T000R10_A582LiqDepBanDescrip = new String[] {""} ;
      T000R11_A2EmpNom = new String[] {""} ;
      T000R12_A340TliqDesc = new String[] {""} ;
      T000R13_A3CliCod = new int[1] ;
      T000R14_A3CliCod = new int[1] ;
      T000R15_A3CliCod = new int[1] ;
      T000R15_A1EmpCod = new short[1] ;
      T000R15_A31LiqNro = new int[1] ;
      T000R3_A31LiqNro = new int[1] ;
      T000R3_A271LiqDescrip = new String[] {""} ;
      T000R3_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000R3_A585LiqPerAno = new short[1] ;
      T000R3_A586LiqPerMes = new byte[1] ;
      T000R3_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T000R3_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      T000R3_A2368TLiqDescAux = new String[] {""} ;
      T000R3_A278LiqEstado = new byte[1] ;
      T000R3_A2292LiqLSDDepEst = new byte[1] ;
      T000R3_A1403LiqAuxEstado = new byte[1] ;
      T000R3_A2293LiqContrEst = new byte[1] ;
      T000R3_A268LiqClase = new byte[1] ;
      T000R3_n268LiqClase = new boolean[] {false} ;
      T000R3_A2180LiqPDFEstado = new String[] {""} ;
      T000R3_n2180LiqPDFEstado = new boolean[] {false} ;
      T000R3_A361LiqGenInter = new boolean[] {false} ;
      T000R3_A494LiqContabilizada = new boolean[] {false} ;
      T000R3_A495LiqCntLeg = new short[1] ;
      T000R3_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R3_A755LiqImpDescuentos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R3_A756LiqImpRetenGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R3_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R3_A500LegEspecificos = new boolean[] {false} ;
      T000R3_A511LiqFecCre = new java.util.Date[] {GXutil.nullDate()} ;
      T000R3_A512LiqUsuCre = new String[] {""} ;
      T000R3_A513LiqPerSinDia = new String[] {""} ;
      T000R3_A748LiqPerPalabra = new String[] {""} ;
      T000R3_A580LiqDepPrvPer = new String[] {""} ;
      T000R3_A581LiqDepPrvFec = new java.util.Date[] {GXutil.nullDate()} ;
      T000R3_A583LiqDepPerAno = new short[1] ;
      T000R3_A584LiqDepPerMes = new byte[1] ;
      T000R3_A587LiqFecMod = new java.util.Date[] {GXutil.nullDate()} ;
      T000R3_A588LiqUsuMod = new String[] {""} ;
      T000R3_A719LiqFecImp = new java.util.Date[] {GXutil.nullDate()} ;
      T000R3_A743LiqPisoGanancias = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R3_A744LiqPisGanSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R3_A745LiqTopeDedInc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R3_A746LiqPerUltNorm = new java.util.Date[] {GXutil.nullDate()} ;
      T000R3_A766LiqError = new String[] {""} ;
      T000R3_A1404LiqErrorAux = new String[] {""} ;
      T000R3_A874LiqNombre = new String[] {""} ;
      T000R3_A881LiqLegajosTxt = new String[] {""} ;
      T000R3_A885LiqSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R3_A963LiqRutaPDFTodosVertical = new String[] {""} ;
      T000R3_A964LiqRutaPDFTodosHorizontal = new String[] {""} ;
      T000R3_A965LiqRutaPDFTodosNombreVertical = new String[] {""} ;
      T000R3_A966LiqRutaPDFTodosNombreHorizonta = new String[] {""} ;
      T000R3_A1142LiqLog = new String[] {""} ;
      T000R3_A2195LiqSac = new boolean[] {false} ;
      T000R3_n2195LiqSac = new boolean[] {false} ;
      T000R3_A2196LiqSacLog = new String[] {""} ;
      T000R3_n2196LiqSacLog = new boolean[] {false} ;
      T000R3_A2298LiqCancel = new boolean[] {false} ;
      T000R3_A2409LiqModTra = new String[] {""} ;
      T000R3_A2414LiqFrecPag = new byte[1] ;
      T000R3_A2410LiqPerDes = new java.util.Date[] {GXutil.nullDate()} ;
      T000R3_A2411LiqPerHas = new java.util.Date[] {GXutil.nullDate()} ;
      T000R3_A2426LiqTipoTarifa = new String[] {""} ;
      T000R3_A3CliCod = new int[1] ;
      T000R3_A33LiqDepBanCod = new String[] {""} ;
      T000R3_n33LiqDepBanCod = new boolean[] {false} ;
      T000R3_A1EmpCod = new short[1] ;
      T000R3_A32TLiqCod = new String[] {""} ;
      T000R3_n32TLiqCod = new boolean[] {false} ;
      T000R3_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      T000R3_A2112LiqRelNro = new int[1] ;
      T000R3_n2112LiqRelNro = new boolean[] {false} ;
      T000R16_A3CliCod = new int[1] ;
      T000R16_A1EmpCod = new short[1] ;
      T000R16_A31LiqNro = new int[1] ;
      T000R17_A3CliCod = new int[1] ;
      T000R17_A1EmpCod = new short[1] ;
      T000R17_A31LiqNro = new int[1] ;
      T000R2_A31LiqNro = new int[1] ;
      T000R2_A271LiqDescrip = new String[] {""} ;
      T000R2_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000R2_A585LiqPerAno = new short[1] ;
      T000R2_A586LiqPerMes = new byte[1] ;
      T000R2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T000R2_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      T000R2_A2368TLiqDescAux = new String[] {""} ;
      T000R2_A278LiqEstado = new byte[1] ;
      T000R2_A2292LiqLSDDepEst = new byte[1] ;
      T000R2_A1403LiqAuxEstado = new byte[1] ;
      T000R2_A2293LiqContrEst = new byte[1] ;
      T000R2_A268LiqClase = new byte[1] ;
      T000R2_n268LiqClase = new boolean[] {false} ;
      T000R2_A2180LiqPDFEstado = new String[] {""} ;
      T000R2_n2180LiqPDFEstado = new boolean[] {false} ;
      T000R2_A361LiqGenInter = new boolean[] {false} ;
      T000R2_A494LiqContabilizada = new boolean[] {false} ;
      T000R2_A495LiqCntLeg = new short[1] ;
      T000R2_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R2_A755LiqImpDescuentos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R2_A756LiqImpRetenGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R2_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R2_A500LegEspecificos = new boolean[] {false} ;
      T000R2_A511LiqFecCre = new java.util.Date[] {GXutil.nullDate()} ;
      T000R2_A512LiqUsuCre = new String[] {""} ;
      T000R2_A513LiqPerSinDia = new String[] {""} ;
      T000R2_A748LiqPerPalabra = new String[] {""} ;
      T000R2_A580LiqDepPrvPer = new String[] {""} ;
      T000R2_A581LiqDepPrvFec = new java.util.Date[] {GXutil.nullDate()} ;
      T000R2_A583LiqDepPerAno = new short[1] ;
      T000R2_A584LiqDepPerMes = new byte[1] ;
      T000R2_A587LiqFecMod = new java.util.Date[] {GXutil.nullDate()} ;
      T000R2_A588LiqUsuMod = new String[] {""} ;
      T000R2_A719LiqFecImp = new java.util.Date[] {GXutil.nullDate()} ;
      T000R2_A743LiqPisoGanancias = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R2_A744LiqPisGanSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R2_A745LiqTopeDedInc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R2_A746LiqPerUltNorm = new java.util.Date[] {GXutil.nullDate()} ;
      T000R2_A766LiqError = new String[] {""} ;
      T000R2_A1404LiqErrorAux = new String[] {""} ;
      T000R2_A874LiqNombre = new String[] {""} ;
      T000R2_A881LiqLegajosTxt = new String[] {""} ;
      T000R2_A885LiqSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000R2_A963LiqRutaPDFTodosVertical = new String[] {""} ;
      T000R2_A964LiqRutaPDFTodosHorizontal = new String[] {""} ;
      T000R2_A965LiqRutaPDFTodosNombreVertical = new String[] {""} ;
      T000R2_A966LiqRutaPDFTodosNombreHorizonta = new String[] {""} ;
      T000R2_A1142LiqLog = new String[] {""} ;
      T000R2_A2195LiqSac = new boolean[] {false} ;
      T000R2_n2195LiqSac = new boolean[] {false} ;
      T000R2_A2196LiqSacLog = new String[] {""} ;
      T000R2_n2196LiqSacLog = new boolean[] {false} ;
      T000R2_A2298LiqCancel = new boolean[] {false} ;
      T000R2_A2409LiqModTra = new String[] {""} ;
      T000R2_A2414LiqFrecPag = new byte[1] ;
      T000R2_A2410LiqPerDes = new java.util.Date[] {GXutil.nullDate()} ;
      T000R2_A2411LiqPerHas = new java.util.Date[] {GXutil.nullDate()} ;
      T000R2_A2426LiqTipoTarifa = new String[] {""} ;
      T000R2_A3CliCod = new int[1] ;
      T000R2_A33LiqDepBanCod = new String[] {""} ;
      T000R2_n33LiqDepBanCod = new boolean[] {false} ;
      T000R2_A1EmpCod = new short[1] ;
      T000R2_A32TLiqCod = new String[] {""} ;
      T000R2_n32TLiqCod = new boolean[] {false} ;
      T000R2_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      T000R2_A2112LiqRelNro = new int[1] ;
      T000R2_n2112LiqRelNro = new boolean[] {false} ;
      GXv_int5 = new int[1] ;
      GXv_int6 = new short[1] ;
      T000R21_A582LiqDepBanDescrip = new String[] {""} ;
      T000R22_A2EmpNom = new String[] {""} ;
      T000R23_A340TliqDesc = new String[] {""} ;
      T000R24_A3CliCod = new int[1] ;
      T000R24_A1EmpCod = new short[1] ;
      T000R24_A2112LiqRelNro = new int[1] ;
      T000R24_n2112LiqRelNro = new boolean[] {false} ;
      T000R25_A3CliCod = new int[1] ;
      T000R25_A1EmpCod = new short[1] ;
      T000R25_A31LiqNro = new int[1] ;
      T000R25_A2285LinkLegNumero = new int[1] ;
      T000R25_A2277LegLinkTiporec = new String[] {""} ;
      T000R26_A3CliCod = new int[1] ;
      T000R26_A1EmpCod = new short[1] ;
      T000R26_A6LegNumero = new int[1] ;
      T000R26_A2243LegCuenLicTpo = new String[] {""} ;
      T000R26_A2266LegCuenAnio = new short[1] ;
      T000R26_A2310LegCuLConsAnio = new short[1] ;
      T000R26_A2311LegCuLConsSec = new short[1] ;
      T000R27_A3CliCod = new int[1] ;
      T000R27_A1EmpCod = new short[1] ;
      T000R27_A6LegNumero = new int[1] ;
      T000R27_A2243LegCuenLicTpo = new String[] {""} ;
      T000R27_A2266LegCuenAnio = new short[1] ;
      T000R27_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      T000R28_A3CliCod = new int[1] ;
      T000R28_A1EmpCod = new short[1] ;
      T000R28_A6LegNumero = new int[1] ;
      T000R28_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      T000R29_A3CliCod = new int[1] ;
      T000R29_A1EmpCod = new short[1] ;
      T000R29_A31LiqNro = new int[1] ;
      T000R29_A2183LiqSuc = new String[] {""} ;
      T000R30_A3CliCod = new int[1] ;
      T000R30_A1EmpCod = new short[1] ;
      T000R30_A31LiqNro = new int[1] ;
      T000R30_A2145LiqArea = new String[] {""} ;
      T000R31_A3CliCod = new int[1] ;
      T000R31_A1EmpCod = new short[1] ;
      T000R31_A31LiqNro = new int[1] ;
      T000R31_A2142LiqPaiConve = new short[1] ;
      T000R31_A2143LiqConvenio = new String[] {""} ;
      T000R32_A3CliCod = new int[1] ;
      T000R32_A1EmpCod = new short[1] ;
      T000R32_A1649LSDSec = new int[1] ;
      T000R33_A3CliCod = new int[1] ;
      T000R33_A1EmpCod = new short[1] ;
      T000R33_A6LegNumero = new int[1] ;
      T000R33_A1172OblSecuencial = new short[1] ;
      T000R33_A1184LiqOblAltaNro = new int[1] ;
      T000R33_A1185LiqOblNuevaNro = new int[1] ;
      T000R34_A3CliCod = new int[1] ;
      T000R34_A1EmpCod = new short[1] ;
      T000R34_A6LegNumero = new int[1] ;
      T000R34_A1172OblSecuencial = new short[1] ;
      T000R34_A1184LiqOblAltaNro = new int[1] ;
      T000R34_A1185LiqOblNuevaNro = new int[1] ;
      T000R35_A3CliCod = new int[1] ;
      T000R35_A1EmpCod = new short[1] ;
      T000R35_A6LegNumero = new int[1] ;
      T000R35_A1172OblSecuencial = new short[1] ;
      T000R36_A3CliCod = new int[1] ;
      T000R36_A1EmpCod = new short[1] ;
      T000R36_A869LiqLegConAnio = new short[1] ;
      T000R36_A6LegNumero = new int[1] ;
      T000R36_A26ConCodigo = new String[] {""} ;
      T000R36_A1097LiqAltaNro = new int[1] ;
      T000R36_A1098LiqNuevaNro = new int[1] ;
      T000R37_A3CliCod = new int[1] ;
      T000R37_A1EmpCod = new short[1] ;
      T000R37_A869LiqLegConAnio = new short[1] ;
      T000R37_A6LegNumero = new int[1] ;
      T000R37_A26ConCodigo = new String[] {""} ;
      T000R37_A1097LiqAltaNro = new int[1] ;
      T000R37_A1098LiqNuevaNro = new int[1] ;
      T000R38_A3CliCod = new int[1] ;
      T000R38_A1EmpCod = new short[1] ;
      T000R38_A31LiqNro = new int[1] ;
      T000R38_A10LpgCodigo = new String[] {""} ;
      T000R39_A3CliCod = new int[1] ;
      T000R39_A1EmpCod = new short[1] ;
      T000R39_A31LiqNro = new int[1] ;
      T000R39_A6LegNumero = new int[1] ;
      T000R40_A3CliCod = new int[1] ;
      T000R40_A1EmpCod = new short[1] ;
      T000R40_A6LegNumero = new int[1] ;
      T000R40_A25AgeOrden = new short[1] ;
      T000R41_A3CliCod = new int[1] ;
      T000R41_A1EmpCod = new short[1] ;
      T000R41_A31LiqNro = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T000R42_A3CliCod = new int[1] ;
      T000R42_A32TLiqCod = new String[] {""} ;
      T000R42_n32TLiqCod = new boolean[] {false} ;
      T000R42_A340TliqDesc = new String[] {""} ;
      GXv_int7 = new int[1] ;
      T000R43_A2EmpNom = new String[] {""} ;
      T000R44_A340TliqDesc = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacion__default(),
         new Object[] {
             new Object[] {
            T000R2_A31LiqNro, T000R2_A271LiqDescrip, T000R2_A98LiqFecha, T000R2_A585LiqPerAno, T000R2_A586LiqPerMes, T000R2_A283LiqPeriodo, T000R2_A280LiqFecPago, T000R2_A2368TLiqDescAux, T000R2_A278LiqEstado, T000R2_A2292LiqLSDDepEst,
            T000R2_A1403LiqAuxEstado, T000R2_A2293LiqContrEst, T000R2_A268LiqClase, T000R2_n268LiqClase, T000R2_A2180LiqPDFEstado, T000R2_n2180LiqPDFEstado, T000R2_A361LiqGenInter, T000R2_A494LiqContabilizada, T000R2_A495LiqCntLeg, T000R2_A496LiqImpNeto,
            T000R2_A755LiqImpDescuentos, T000R2_A756LiqImpRetenGan, T000R2_A497LiqImpBruto, T000R2_A500LegEspecificos, T000R2_A511LiqFecCre, T000R2_A512LiqUsuCre, T000R2_A513LiqPerSinDia, T000R2_A748LiqPerPalabra, T000R2_A580LiqDepPrvPer, T000R2_A581LiqDepPrvFec,
            T000R2_A583LiqDepPerAno, T000R2_A584LiqDepPerMes, T000R2_A587LiqFecMod, T000R2_A588LiqUsuMod, T000R2_A719LiqFecImp, T000R2_A743LiqPisoGanancias, T000R2_A744LiqPisGanSAC, T000R2_A745LiqTopeDedInc, T000R2_A746LiqPerUltNorm, T000R2_A766LiqError,
            T000R2_A1404LiqErrorAux, T000R2_A874LiqNombre, T000R2_A881LiqLegajosTxt, T000R2_A885LiqSegundos, T000R2_A963LiqRutaPDFTodosVertical, T000R2_A964LiqRutaPDFTodosHorizontal, T000R2_A965LiqRutaPDFTodosNombreVertical, T000R2_A966LiqRutaPDFTodosNombreHorizonta, T000R2_A1142LiqLog, T000R2_A2195LiqSac,
            T000R2_n2195LiqSac, T000R2_A2196LiqSacLog, T000R2_n2196LiqSacLog, T000R2_A2298LiqCancel, T000R2_A2409LiqModTra, T000R2_A2414LiqFrecPag, T000R2_A2410LiqPerDes, T000R2_A2411LiqPerHas, T000R2_A2426LiqTipoTarifa, T000R2_A3CliCod,
            T000R2_A33LiqDepBanCod, T000R2_n33LiqDepBanCod, T000R2_A1EmpCod, T000R2_A32TLiqCod, T000R2_n32TLiqCod, T000R2_A1729PeriodoLiq, T000R2_A2112LiqRelNro, T000R2_n2112LiqRelNro
            }
            , new Object[] {
            T000R3_A31LiqNro, T000R3_A271LiqDescrip, T000R3_A98LiqFecha, T000R3_A585LiqPerAno, T000R3_A586LiqPerMes, T000R3_A283LiqPeriodo, T000R3_A280LiqFecPago, T000R3_A2368TLiqDescAux, T000R3_A278LiqEstado, T000R3_A2292LiqLSDDepEst,
            T000R3_A1403LiqAuxEstado, T000R3_A2293LiqContrEst, T000R3_A268LiqClase, T000R3_n268LiqClase, T000R3_A2180LiqPDFEstado, T000R3_n2180LiqPDFEstado, T000R3_A361LiqGenInter, T000R3_A494LiqContabilizada, T000R3_A495LiqCntLeg, T000R3_A496LiqImpNeto,
            T000R3_A755LiqImpDescuentos, T000R3_A756LiqImpRetenGan, T000R3_A497LiqImpBruto, T000R3_A500LegEspecificos, T000R3_A511LiqFecCre, T000R3_A512LiqUsuCre, T000R3_A513LiqPerSinDia, T000R3_A748LiqPerPalabra, T000R3_A580LiqDepPrvPer, T000R3_A581LiqDepPrvFec,
            T000R3_A583LiqDepPerAno, T000R3_A584LiqDepPerMes, T000R3_A587LiqFecMod, T000R3_A588LiqUsuMod, T000R3_A719LiqFecImp, T000R3_A743LiqPisoGanancias, T000R3_A744LiqPisGanSAC, T000R3_A745LiqTopeDedInc, T000R3_A746LiqPerUltNorm, T000R3_A766LiqError,
            T000R3_A1404LiqErrorAux, T000R3_A874LiqNombre, T000R3_A881LiqLegajosTxt, T000R3_A885LiqSegundos, T000R3_A963LiqRutaPDFTodosVertical, T000R3_A964LiqRutaPDFTodosHorizontal, T000R3_A965LiqRutaPDFTodosNombreVertical, T000R3_A966LiqRutaPDFTodosNombreHorizonta, T000R3_A1142LiqLog, T000R3_A2195LiqSac,
            T000R3_n2195LiqSac, T000R3_A2196LiqSacLog, T000R3_n2196LiqSacLog, T000R3_A2298LiqCancel, T000R3_A2409LiqModTra, T000R3_A2414LiqFrecPag, T000R3_A2410LiqPerDes, T000R3_A2411LiqPerHas, T000R3_A2426LiqTipoTarifa, T000R3_A3CliCod,
            T000R3_A33LiqDepBanCod, T000R3_n33LiqDepBanCod, T000R3_A1EmpCod, T000R3_A32TLiqCod, T000R3_n32TLiqCod, T000R3_A1729PeriodoLiq, T000R3_A2112LiqRelNro, T000R3_n2112LiqRelNro
            }
            , new Object[] {
            T000R4_A582LiqDepBanDescrip
            }
            , new Object[] {
            T000R5_A2EmpNom
            }
            , new Object[] {
            T000R6_A340TliqDesc
            }
            , new Object[] {
            T000R7_A3CliCod
            }
            , new Object[] {
            T000R8_A3CliCod
            }
            , new Object[] {
            T000R9_A31LiqNro, T000R9_A2EmpNom, T000R9_A271LiqDescrip, T000R9_A98LiqFecha, T000R9_A585LiqPerAno, T000R9_A586LiqPerMes, T000R9_A283LiqPeriodo, T000R9_A280LiqFecPago, T000R9_A340TliqDesc, T000R9_A2368TLiqDescAux,
            T000R9_A278LiqEstado, T000R9_A2292LiqLSDDepEst, T000R9_A1403LiqAuxEstado, T000R9_A2293LiqContrEst, T000R9_A268LiqClase, T000R9_n268LiqClase, T000R9_A2180LiqPDFEstado, T000R9_n2180LiqPDFEstado, T000R9_A361LiqGenInter, T000R9_A494LiqContabilizada,
            T000R9_A495LiqCntLeg, T000R9_A496LiqImpNeto, T000R9_A755LiqImpDescuentos, T000R9_A756LiqImpRetenGan, T000R9_A497LiqImpBruto, T000R9_A500LegEspecificos, T000R9_A511LiqFecCre, T000R9_A512LiqUsuCre, T000R9_A513LiqPerSinDia, T000R9_A748LiqPerPalabra,
            T000R9_A580LiqDepPrvPer, T000R9_A581LiqDepPrvFec, T000R9_A582LiqDepBanDescrip, T000R9_A583LiqDepPerAno, T000R9_A584LiqDepPerMes, T000R9_A587LiqFecMod, T000R9_A588LiqUsuMod, T000R9_A719LiqFecImp, T000R9_A743LiqPisoGanancias, T000R9_A744LiqPisGanSAC,
            T000R9_A745LiqTopeDedInc, T000R9_A746LiqPerUltNorm, T000R9_A766LiqError, T000R9_A1404LiqErrorAux, T000R9_A874LiqNombre, T000R9_A881LiqLegajosTxt, T000R9_A885LiqSegundos, T000R9_A963LiqRutaPDFTodosVertical, T000R9_A964LiqRutaPDFTodosHorizontal, T000R9_A965LiqRutaPDFTodosNombreVertical,
            T000R9_A966LiqRutaPDFTodosNombreHorizonta, T000R9_A1142LiqLog, T000R9_A2195LiqSac, T000R9_n2195LiqSac, T000R9_A2196LiqSacLog, T000R9_n2196LiqSacLog, T000R9_A2298LiqCancel, T000R9_A2409LiqModTra, T000R9_A2414LiqFrecPag, T000R9_A2410LiqPerDes,
            T000R9_A2411LiqPerHas, T000R9_A2426LiqTipoTarifa, T000R9_A3CliCod, T000R9_A33LiqDepBanCod, T000R9_n33LiqDepBanCod, T000R9_A1EmpCod, T000R9_A32TLiqCod, T000R9_n32TLiqCod, T000R9_A1729PeriodoLiq, T000R9_A2112LiqRelNro,
            T000R9_n2112LiqRelNro
            }
            , new Object[] {
            T000R10_A582LiqDepBanDescrip
            }
            , new Object[] {
            T000R11_A2EmpNom
            }
            , new Object[] {
            T000R12_A340TliqDesc
            }
            , new Object[] {
            T000R13_A3CliCod
            }
            , new Object[] {
            T000R14_A3CliCod
            }
            , new Object[] {
            T000R15_A3CliCod, T000R15_A1EmpCod, T000R15_A31LiqNro
            }
            , new Object[] {
            T000R16_A3CliCod, T000R16_A1EmpCod, T000R16_A31LiqNro
            }
            , new Object[] {
            T000R17_A3CliCod, T000R17_A1EmpCod, T000R17_A31LiqNro
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000R21_A582LiqDepBanDescrip
            }
            , new Object[] {
            T000R22_A2EmpNom
            }
            , new Object[] {
            T000R23_A340TliqDesc
            }
            , new Object[] {
            T000R24_A3CliCod, T000R24_A1EmpCod, T000R24_A2112LiqRelNro
            }
            , new Object[] {
            T000R25_A3CliCod, T000R25_A1EmpCod, T000R25_A31LiqNro, T000R25_A2285LinkLegNumero, T000R25_A2277LegLinkTiporec
            }
            , new Object[] {
            T000R26_A3CliCod, T000R26_A1EmpCod, T000R26_A6LegNumero, T000R26_A2243LegCuenLicTpo, T000R26_A2266LegCuenAnio, T000R26_A2310LegCuLConsAnio, T000R26_A2311LegCuLConsSec
            }
            , new Object[] {
            T000R27_A3CliCod, T000R27_A1EmpCod, T000R27_A6LegNumero, T000R27_A2243LegCuenLicTpo, T000R27_A2266LegCuenAnio, T000R27_A2324LegCuLAprLicFch
            }
            , new Object[] {
            T000R28_A3CliCod, T000R28_A1EmpCod, T000R28_A6LegNumero, T000R28_A2253LegHisFecIng
            }
            , new Object[] {
            T000R29_A3CliCod, T000R29_A1EmpCod, T000R29_A31LiqNro, T000R29_A2183LiqSuc
            }
            , new Object[] {
            T000R30_A3CliCod, T000R30_A1EmpCod, T000R30_A31LiqNro, T000R30_A2145LiqArea
            }
            , new Object[] {
            T000R31_A3CliCod, T000R31_A1EmpCod, T000R31_A31LiqNro, T000R31_A2142LiqPaiConve, T000R31_A2143LiqConvenio
            }
            , new Object[] {
            T000R32_A3CliCod, T000R32_A1EmpCod, T000R32_A1649LSDSec
            }
            , new Object[] {
            T000R33_A3CliCod, T000R33_A1EmpCod, T000R33_A6LegNumero, T000R33_A1172OblSecuencial, T000R33_A1184LiqOblAltaNro, T000R33_A1185LiqOblNuevaNro
            }
            , new Object[] {
            T000R34_A3CliCod, T000R34_A1EmpCod, T000R34_A6LegNumero, T000R34_A1172OblSecuencial, T000R34_A1184LiqOblAltaNro, T000R34_A1185LiqOblNuevaNro
            }
            , new Object[] {
            T000R35_A3CliCod, T000R35_A1EmpCod, T000R35_A6LegNumero, T000R35_A1172OblSecuencial
            }
            , new Object[] {
            T000R36_A3CliCod, T000R36_A1EmpCod, T000R36_A869LiqLegConAnio, T000R36_A6LegNumero, T000R36_A26ConCodigo, T000R36_A1097LiqAltaNro, T000R36_A1098LiqNuevaNro
            }
            , new Object[] {
            T000R37_A3CliCod, T000R37_A1EmpCod, T000R37_A869LiqLegConAnio, T000R37_A6LegNumero, T000R37_A26ConCodigo, T000R37_A1097LiqAltaNro, T000R37_A1098LiqNuevaNro
            }
            , new Object[] {
            T000R38_A3CliCod, T000R38_A1EmpCod, T000R38_A31LiqNro, T000R38_A10LpgCodigo
            }
            , new Object[] {
            T000R39_A3CliCod, T000R39_A1EmpCod, T000R39_A31LiqNro, T000R39_A6LegNumero
            }
            , new Object[] {
            T000R40_A3CliCod, T000R40_A1EmpCod, T000R40_A6LegNumero, T000R40_A25AgeOrden
            }
            , new Object[] {
            T000R41_A3CliCod, T000R41_A1EmpCod, T000R41_A31LiqNro
            }
            , new Object[] {
            T000R42_A3CliCod, T000R42_A32TLiqCod, T000R42_A340TliqDesc
            }
            , new Object[] {
            T000R43_A2EmpNom
            }
            , new Object[] {
            T000R44_A340TliqDesc
            }
         }
      );
      AV29Pgmname = "Liquidacion" ;
   }

   private byte Z586LiqPerMes ;
   private byte Z278LiqEstado ;
   private byte Z2292LiqLSDDepEst ;
   private byte Z1403LiqAuxEstado ;
   private byte Z2293LiqContrEst ;
   private byte Z268LiqClase ;
   private byte Z584LiqDepPerMes ;
   private byte Z2414LiqFrecPag ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A268LiqClase ;
   private byte A586LiqPerMes ;
   private byte A278LiqEstado ;
   private byte A2292LiqLSDDepEst ;
   private byte A1403LiqAuxEstado ;
   private byte A2293LiqContrEst ;
   private byte A584LiqDepPerMes ;
   private byte A2414LiqFrecPag ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7EmpCod ;
   private short Z1EmpCod ;
   private short Z585LiqPerAno ;
   private short Z495LiqCntLeg ;
   private short Z583LiqDepPerAno ;
   private short A1EmpCod ;
   private short AV7EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A585LiqPerAno ;
   private short A495LiqCntLeg ;
   private short A583LiqDepPerAno ;
   private short RcdFound25 ;
   private short nIsDirty_25 ;
   private short GXv_int6[] ;
   private int wcpOAV23CliCod ;
   private int wcpOAV8LiqNro ;
   private int Z3CliCod ;
   private int Z31LiqNro ;
   private int Z2112LiqRelNro ;
   private int N2112LiqRelNro ;
   private int A3CliCod ;
   private int AV23CliCod ;
   private int A2112LiqRelNro ;
   private int AV8LiqNro ;
   private int trnEnded ;
   private int A31LiqNro ;
   private int edtLiqNro_Enabled ;
   private int edtLiqFecha_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int AV28Insert_LiqRelNro ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int Dvpanel_tablelegajos_Gxcontroltype ;
   private int Dvpanel_tableganancias_Gxcontroltype ;
   private int AV30GXV1 ;
   private int GX_JID ;
   private int GXv_int5[] ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int4 ;
   private int GXv_int7[] ;
   private java.math.BigDecimal Z496LiqImpNeto ;
   private java.math.BigDecimal Z755LiqImpDescuentos ;
   private java.math.BigDecimal Z756LiqImpRetenGan ;
   private java.math.BigDecimal Z497LiqImpBruto ;
   private java.math.BigDecimal Z743LiqPisoGanancias ;
   private java.math.BigDecimal Z744LiqPisGanSAC ;
   private java.math.BigDecimal Z745LiqTopeDedInc ;
   private java.math.BigDecimal Z885LiqSegundos ;
   private java.math.BigDecimal A496LiqImpNeto ;
   private java.math.BigDecimal A755LiqImpDescuentos ;
   private java.math.BigDecimal A756LiqImpRetenGan ;
   private java.math.BigDecimal A497LiqImpBruto ;
   private java.math.BigDecimal A743LiqPisoGanancias ;
   private java.math.BigDecimal A744LiqPisGanSAC ;
   private java.math.BigDecimal A745LiqTopeDedInc ;
   private java.math.BigDecimal A885LiqSegundos ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z2180LiqPDFEstado ;
   private String Z513LiqPerSinDia ;
   private String Z748LiqPerPalabra ;
   private String Z580LiqDepPrvPer ;
   private String Z965LiqRutaPDFTodosNombreVertical ;
   private String Z966LiqRutaPDFTodosNombreHorizonta ;
   private String Z2409LiqModTra ;
   private String Z2426LiqTipoTarifa ;
   private String Z33LiqDepBanCod ;
   private String Z32TLiqCod ;
   private String N32TLiqCod ;
   private String N33LiqDepBanCod ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A33LiqDepBanCod ;
   private String A32TLiqCod ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtLiqFecha_Internalname ;
   private String AV22AplicaA ;
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
   private String edtLiqNro_Internalname ;
   private String edtLiqNro_Jsonclick ;
   private String TempTags ;
   private String edtLiqFecha_Jsonclick ;
   private String Dvpanel_tablelegajos_Width ;
   private String Dvpanel_tablelegajos_Cls ;
   private String Dvpanel_tablelegajos_Title ;
   private String Dvpanel_tablelegajos_Iconposition ;
   private String Dvpanel_tablelegajos_Internalname ;
   private String divTablelegajos_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String Dvpanel_tableganancias_Width ;
   private String Dvpanel_tableganancias_Cls ;
   private String Dvpanel_tableganancias_Title ;
   private String Dvpanel_tableganancias_Iconposition ;
   private String Dvpanel_tableganancias_Internalname ;
   private String divTableganancias_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String A2180LiqPDFEstado ;
   private String A513LiqPerSinDia ;
   private String A748LiqPerPalabra ;
   private String A580LiqDepPrvPer ;
   private String A965LiqRutaPDFTodosNombreVertical ;
   private String A966LiqRutaPDFTodosNombreHorizonta ;
   private String A2409LiqModTra ;
   private String A2426LiqTipoTarifa ;
   private String AV12Insert_TLiqCod ;
   private String AV26Insert_LiqDepBanCod ;
   private String AV29Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Dvpanel_tablelegajos_Objectcall ;
   private String Dvpanel_tablelegajos_Class ;
   private String Dvpanel_tablelegajos_Height ;
   private String Dvpanel_tableganancias_Objectcall ;
   private String Dvpanel_tableganancias_Class ;
   private String Dvpanel_tableganancias_Height ;
   private String hsh ;
   private String sMode25 ;
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
   private java.util.Date Z587LiqFecMod ;
   private java.util.Date Z719LiqFecImp ;
   private java.util.Date A587LiqFecMod ;
   private java.util.Date A719LiqFecImp ;
   private java.util.Date Z98LiqFecha ;
   private java.util.Date Z283LiqPeriodo ;
   private java.util.Date Z280LiqFecPago ;
   private java.util.Date Z511LiqFecCre ;
   private java.util.Date Z581LiqDepPrvFec ;
   private java.util.Date Z746LiqPerUltNorm ;
   private java.util.Date Z2410LiqPerDes ;
   private java.util.Date Z2411LiqPerHas ;
   private java.util.Date Z1729PeriodoLiq ;
   private java.util.Date N1729PeriodoLiq ;
   private java.util.Date A1729PeriodoLiq ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date A280LiqFecPago ;
   private java.util.Date A511LiqFecCre ;
   private java.util.Date A581LiqDepPrvFec ;
   private java.util.Date A746LiqPerUltNorm ;
   private java.util.Date A2410LiqPerDes ;
   private java.util.Date A2411LiqPerHas ;
   private java.util.Date AV27Insert_PeriodoLiq ;
   private boolean Z361LiqGenInter ;
   private boolean Z494LiqContabilizada ;
   private boolean Z500LegEspecificos ;
   private boolean Z2195LiqSac ;
   private boolean Z2298LiqCancel ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n33LiqDepBanCod ;
   private boolean n32TLiqCod ;
   private boolean n2112LiqRelNro ;
   private boolean wbErr ;
   private boolean n268LiqClase ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_tablelegajos_Autowidth ;
   private boolean Dvpanel_tablelegajos_Autoheight ;
   private boolean Dvpanel_tablelegajos_Collapsible ;
   private boolean Dvpanel_tablelegajos_Collapsed ;
   private boolean Dvpanel_tablelegajos_Showcollapseicon ;
   private boolean Dvpanel_tablelegajos_Autoscroll ;
   private boolean Dvpanel_tableganancias_Autowidth ;
   private boolean Dvpanel_tableganancias_Autoheight ;
   private boolean Dvpanel_tableganancias_Collapsible ;
   private boolean Dvpanel_tableganancias_Collapsed ;
   private boolean Dvpanel_tableganancias_Showcollapseicon ;
   private boolean Dvpanel_tableganancias_Autoscroll ;
   private boolean n2180LiqPDFEstado ;
   private boolean n2195LiqSac ;
   private boolean A2195LiqSac ;
   private boolean n2196LiqSacLog ;
   private boolean A361LiqGenInter ;
   private boolean A494LiqContabilizada ;
   private boolean A500LegEspecificos ;
   private boolean A2298LiqCancel ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Dvpanel_tablelegajos_Enabled ;
   private boolean Dvpanel_tablelegajos_Showheader ;
   private boolean Dvpanel_tablelegajos_Visible ;
   private boolean Dvpanel_tableganancias_Enabled ;
   private boolean Dvpanel_tableganancias_Showheader ;
   private boolean Dvpanel_tableganancias_Visible ;
   private boolean returnInSub ;
   private boolean AV24IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private String A1142LiqLog ;
   private String Z1142LiqLog ;
   private String Z271LiqDescrip ;
   private String Z2368TLiqDescAux ;
   private String Z512LiqUsuCre ;
   private String Z588LiqUsuMod ;
   private String Z766LiqError ;
   private String Z1404LiqErrorAux ;
   private String Z874LiqNombre ;
   private String Z881LiqLegajosTxt ;
   private String Z963LiqRutaPDFTodosVertical ;
   private String Z964LiqRutaPDFTodosHorizontal ;
   private String Z2196LiqSacLog ;
   private String A2196LiqSacLog ;
   private String A271LiqDescrip ;
   private String A2368TLiqDescAux ;
   private String A512LiqUsuCre ;
   private String A588LiqUsuMod ;
   private String A766LiqError ;
   private String A1404LiqErrorAux ;
   private String A874LiqNombre ;
   private String A881LiqLegajosTxt ;
   private String A963LiqRutaPDFTodosVertical ;
   private String A964LiqRutaPDFTodosHorizontal ;
   private String A582LiqDepBanDescrip ;
   private String A2EmpNom ;
   private String A340TliqDesc ;
   private String Z582LiqDepBanDescrip ;
   private String Z2EmpNom ;
   private String Z340TliqDesc ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tablelegajos ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableganancias ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynTLiqCod ;
   private HTMLChoice cmbLiqClase ;
   private HTMLChoice radavAplicaa ;
   private IDataStoreProvider pr_default ;
   private String[] T000R6_A340TliqDesc ;
   private String[] T000R5_A2EmpNom ;
   private String[] T000R4_A582LiqDepBanDescrip ;
   private int[] T000R9_A31LiqNro ;
   private String[] T000R9_A2EmpNom ;
   private String[] T000R9_A271LiqDescrip ;
   private java.util.Date[] T000R9_A98LiqFecha ;
   private short[] T000R9_A585LiqPerAno ;
   private byte[] T000R9_A586LiqPerMes ;
   private java.util.Date[] T000R9_A283LiqPeriodo ;
   private java.util.Date[] T000R9_A280LiqFecPago ;
   private String[] T000R9_A340TliqDesc ;
   private String[] T000R9_A2368TLiqDescAux ;
   private byte[] T000R9_A278LiqEstado ;
   private byte[] T000R9_A2292LiqLSDDepEst ;
   private byte[] T000R9_A1403LiqAuxEstado ;
   private byte[] T000R9_A2293LiqContrEst ;
   private byte[] T000R9_A268LiqClase ;
   private boolean[] T000R9_n268LiqClase ;
   private String[] T000R9_A2180LiqPDFEstado ;
   private boolean[] T000R9_n2180LiqPDFEstado ;
   private boolean[] T000R9_A361LiqGenInter ;
   private boolean[] T000R9_A494LiqContabilizada ;
   private short[] T000R9_A495LiqCntLeg ;
   private java.math.BigDecimal[] T000R9_A496LiqImpNeto ;
   private java.math.BigDecimal[] T000R9_A755LiqImpDescuentos ;
   private java.math.BigDecimal[] T000R9_A756LiqImpRetenGan ;
   private java.math.BigDecimal[] T000R9_A497LiqImpBruto ;
   private boolean[] T000R9_A500LegEspecificos ;
   private java.util.Date[] T000R9_A511LiqFecCre ;
   private String[] T000R9_A512LiqUsuCre ;
   private String[] T000R9_A513LiqPerSinDia ;
   private String[] T000R9_A748LiqPerPalabra ;
   private String[] T000R9_A580LiqDepPrvPer ;
   private java.util.Date[] T000R9_A581LiqDepPrvFec ;
   private String[] T000R9_A582LiqDepBanDescrip ;
   private short[] T000R9_A583LiqDepPerAno ;
   private byte[] T000R9_A584LiqDepPerMes ;
   private java.util.Date[] T000R9_A587LiqFecMod ;
   private String[] T000R9_A588LiqUsuMod ;
   private java.util.Date[] T000R9_A719LiqFecImp ;
   private java.math.BigDecimal[] T000R9_A743LiqPisoGanancias ;
   private java.math.BigDecimal[] T000R9_A744LiqPisGanSAC ;
   private java.math.BigDecimal[] T000R9_A745LiqTopeDedInc ;
   private java.util.Date[] T000R9_A746LiqPerUltNorm ;
   private String[] T000R9_A766LiqError ;
   private String[] T000R9_A1404LiqErrorAux ;
   private String[] T000R9_A874LiqNombre ;
   private String[] T000R9_A881LiqLegajosTxt ;
   private java.math.BigDecimal[] T000R9_A885LiqSegundos ;
   private String[] T000R9_A963LiqRutaPDFTodosVertical ;
   private String[] T000R9_A964LiqRutaPDFTodosHorizontal ;
   private String[] T000R9_A965LiqRutaPDFTodosNombreVertical ;
   private String[] T000R9_A966LiqRutaPDFTodosNombreHorizonta ;
   private String[] T000R9_A1142LiqLog ;
   private boolean[] T000R9_A2195LiqSac ;
   private boolean[] T000R9_n2195LiqSac ;
   private String[] T000R9_A2196LiqSacLog ;
   private boolean[] T000R9_n2196LiqSacLog ;
   private boolean[] T000R9_A2298LiqCancel ;
   private String[] T000R9_A2409LiqModTra ;
   private byte[] T000R9_A2414LiqFrecPag ;
   private java.util.Date[] T000R9_A2410LiqPerDes ;
   private java.util.Date[] T000R9_A2411LiqPerHas ;
   private String[] T000R9_A2426LiqTipoTarifa ;
   private int[] T000R9_A3CliCod ;
   private String[] T000R9_A33LiqDepBanCod ;
   private boolean[] T000R9_n33LiqDepBanCod ;
   private short[] T000R9_A1EmpCod ;
   private String[] T000R9_A32TLiqCod ;
   private boolean[] T000R9_n32TLiqCod ;
   private java.util.Date[] T000R9_A1729PeriodoLiq ;
   private int[] T000R9_A2112LiqRelNro ;
   private boolean[] T000R9_n2112LiqRelNro ;
   private int[] T000R7_A3CliCod ;
   private int[] T000R8_A3CliCod ;
   private String[] T000R10_A582LiqDepBanDescrip ;
   private String[] T000R11_A2EmpNom ;
   private String[] T000R12_A340TliqDesc ;
   private int[] T000R13_A3CliCod ;
   private int[] T000R14_A3CliCod ;
   private int[] T000R15_A3CliCod ;
   private short[] T000R15_A1EmpCod ;
   private int[] T000R15_A31LiqNro ;
   private int[] T000R3_A31LiqNro ;
   private String[] T000R3_A271LiqDescrip ;
   private java.util.Date[] T000R3_A98LiqFecha ;
   private short[] T000R3_A585LiqPerAno ;
   private byte[] T000R3_A586LiqPerMes ;
   private java.util.Date[] T000R3_A283LiqPeriodo ;
   private java.util.Date[] T000R3_A280LiqFecPago ;
   private String[] T000R3_A2368TLiqDescAux ;
   private byte[] T000R3_A278LiqEstado ;
   private byte[] T000R3_A2292LiqLSDDepEst ;
   private byte[] T000R3_A1403LiqAuxEstado ;
   private byte[] T000R3_A2293LiqContrEst ;
   private byte[] T000R3_A268LiqClase ;
   private boolean[] T000R3_n268LiqClase ;
   private String[] T000R3_A2180LiqPDFEstado ;
   private boolean[] T000R3_n2180LiqPDFEstado ;
   private boolean[] T000R3_A361LiqGenInter ;
   private boolean[] T000R3_A494LiqContabilizada ;
   private short[] T000R3_A495LiqCntLeg ;
   private java.math.BigDecimal[] T000R3_A496LiqImpNeto ;
   private java.math.BigDecimal[] T000R3_A755LiqImpDescuentos ;
   private java.math.BigDecimal[] T000R3_A756LiqImpRetenGan ;
   private java.math.BigDecimal[] T000R3_A497LiqImpBruto ;
   private boolean[] T000R3_A500LegEspecificos ;
   private java.util.Date[] T000R3_A511LiqFecCre ;
   private String[] T000R3_A512LiqUsuCre ;
   private String[] T000R3_A513LiqPerSinDia ;
   private String[] T000R3_A748LiqPerPalabra ;
   private String[] T000R3_A580LiqDepPrvPer ;
   private java.util.Date[] T000R3_A581LiqDepPrvFec ;
   private short[] T000R3_A583LiqDepPerAno ;
   private byte[] T000R3_A584LiqDepPerMes ;
   private java.util.Date[] T000R3_A587LiqFecMod ;
   private String[] T000R3_A588LiqUsuMod ;
   private java.util.Date[] T000R3_A719LiqFecImp ;
   private java.math.BigDecimal[] T000R3_A743LiqPisoGanancias ;
   private java.math.BigDecimal[] T000R3_A744LiqPisGanSAC ;
   private java.math.BigDecimal[] T000R3_A745LiqTopeDedInc ;
   private java.util.Date[] T000R3_A746LiqPerUltNorm ;
   private String[] T000R3_A766LiqError ;
   private String[] T000R3_A1404LiqErrorAux ;
   private String[] T000R3_A874LiqNombre ;
   private String[] T000R3_A881LiqLegajosTxt ;
   private java.math.BigDecimal[] T000R3_A885LiqSegundos ;
   private String[] T000R3_A963LiqRutaPDFTodosVertical ;
   private String[] T000R3_A964LiqRutaPDFTodosHorizontal ;
   private String[] T000R3_A965LiqRutaPDFTodosNombreVertical ;
   private String[] T000R3_A966LiqRutaPDFTodosNombreHorizonta ;
   private String[] T000R3_A1142LiqLog ;
   private boolean[] T000R3_A2195LiqSac ;
   private boolean[] T000R3_n2195LiqSac ;
   private String[] T000R3_A2196LiqSacLog ;
   private boolean[] T000R3_n2196LiqSacLog ;
   private boolean[] T000R3_A2298LiqCancel ;
   private String[] T000R3_A2409LiqModTra ;
   private byte[] T000R3_A2414LiqFrecPag ;
   private java.util.Date[] T000R3_A2410LiqPerDes ;
   private java.util.Date[] T000R3_A2411LiqPerHas ;
   private String[] T000R3_A2426LiqTipoTarifa ;
   private int[] T000R3_A3CliCod ;
   private String[] T000R3_A33LiqDepBanCod ;
   private boolean[] T000R3_n33LiqDepBanCod ;
   private short[] T000R3_A1EmpCod ;
   private String[] T000R3_A32TLiqCod ;
   private boolean[] T000R3_n32TLiqCod ;
   private java.util.Date[] T000R3_A1729PeriodoLiq ;
   private int[] T000R3_A2112LiqRelNro ;
   private boolean[] T000R3_n2112LiqRelNro ;
   private int[] T000R16_A3CliCod ;
   private short[] T000R16_A1EmpCod ;
   private int[] T000R16_A31LiqNro ;
   private int[] T000R17_A3CliCod ;
   private short[] T000R17_A1EmpCod ;
   private int[] T000R17_A31LiqNro ;
   private int[] T000R2_A31LiqNro ;
   private String[] T000R2_A271LiqDescrip ;
   private java.util.Date[] T000R2_A98LiqFecha ;
   private short[] T000R2_A585LiqPerAno ;
   private byte[] T000R2_A586LiqPerMes ;
   private java.util.Date[] T000R2_A283LiqPeriodo ;
   private java.util.Date[] T000R2_A280LiqFecPago ;
   private String[] T000R2_A2368TLiqDescAux ;
   private byte[] T000R2_A278LiqEstado ;
   private byte[] T000R2_A2292LiqLSDDepEst ;
   private byte[] T000R2_A1403LiqAuxEstado ;
   private byte[] T000R2_A2293LiqContrEst ;
   private byte[] T000R2_A268LiqClase ;
   private boolean[] T000R2_n268LiqClase ;
   private String[] T000R2_A2180LiqPDFEstado ;
   private boolean[] T000R2_n2180LiqPDFEstado ;
   private boolean[] T000R2_A361LiqGenInter ;
   private boolean[] T000R2_A494LiqContabilizada ;
   private short[] T000R2_A495LiqCntLeg ;
   private java.math.BigDecimal[] T000R2_A496LiqImpNeto ;
   private java.math.BigDecimal[] T000R2_A755LiqImpDescuentos ;
   private java.math.BigDecimal[] T000R2_A756LiqImpRetenGan ;
   private java.math.BigDecimal[] T000R2_A497LiqImpBruto ;
   private boolean[] T000R2_A500LegEspecificos ;
   private java.util.Date[] T000R2_A511LiqFecCre ;
   private String[] T000R2_A512LiqUsuCre ;
   private String[] T000R2_A513LiqPerSinDia ;
   private String[] T000R2_A748LiqPerPalabra ;
   private String[] T000R2_A580LiqDepPrvPer ;
   private java.util.Date[] T000R2_A581LiqDepPrvFec ;
   private short[] T000R2_A583LiqDepPerAno ;
   private byte[] T000R2_A584LiqDepPerMes ;
   private java.util.Date[] T000R2_A587LiqFecMod ;
   private String[] T000R2_A588LiqUsuMod ;
   private java.util.Date[] T000R2_A719LiqFecImp ;
   private java.math.BigDecimal[] T000R2_A743LiqPisoGanancias ;
   private java.math.BigDecimal[] T000R2_A744LiqPisGanSAC ;
   private java.math.BigDecimal[] T000R2_A745LiqTopeDedInc ;
   private java.util.Date[] T000R2_A746LiqPerUltNorm ;
   private String[] T000R2_A766LiqError ;
   private String[] T000R2_A1404LiqErrorAux ;
   private String[] T000R2_A874LiqNombre ;
   private String[] T000R2_A881LiqLegajosTxt ;
   private java.math.BigDecimal[] T000R2_A885LiqSegundos ;
   private String[] T000R2_A963LiqRutaPDFTodosVertical ;
   private String[] T000R2_A964LiqRutaPDFTodosHorizontal ;
   private String[] T000R2_A965LiqRutaPDFTodosNombreVertical ;
   private String[] T000R2_A966LiqRutaPDFTodosNombreHorizonta ;
   private String[] T000R2_A1142LiqLog ;
   private boolean[] T000R2_A2195LiqSac ;
   private boolean[] T000R2_n2195LiqSac ;
   private String[] T000R2_A2196LiqSacLog ;
   private boolean[] T000R2_n2196LiqSacLog ;
   private boolean[] T000R2_A2298LiqCancel ;
   private String[] T000R2_A2409LiqModTra ;
   private byte[] T000R2_A2414LiqFrecPag ;
   private java.util.Date[] T000R2_A2410LiqPerDes ;
   private java.util.Date[] T000R2_A2411LiqPerHas ;
   private String[] T000R2_A2426LiqTipoTarifa ;
   private int[] T000R2_A3CliCod ;
   private String[] T000R2_A33LiqDepBanCod ;
   private boolean[] T000R2_n33LiqDepBanCod ;
   private short[] T000R2_A1EmpCod ;
   private String[] T000R2_A32TLiqCod ;
   private boolean[] T000R2_n32TLiqCod ;
   private java.util.Date[] T000R2_A1729PeriodoLiq ;
   private int[] T000R2_A2112LiqRelNro ;
   private boolean[] T000R2_n2112LiqRelNro ;
   private String[] T000R21_A582LiqDepBanDescrip ;
   private String[] T000R22_A2EmpNom ;
   private String[] T000R23_A340TliqDesc ;
   private int[] T000R24_A3CliCod ;
   private short[] T000R24_A1EmpCod ;
   private int[] T000R24_A2112LiqRelNro ;
   private boolean[] T000R24_n2112LiqRelNro ;
   private int[] T000R25_A3CliCod ;
   private short[] T000R25_A1EmpCod ;
   private int[] T000R25_A31LiqNro ;
   private int[] T000R25_A2285LinkLegNumero ;
   private String[] T000R25_A2277LegLinkTiporec ;
   private int[] T000R26_A3CliCod ;
   private short[] T000R26_A1EmpCod ;
   private int[] T000R26_A6LegNumero ;
   private String[] T000R26_A2243LegCuenLicTpo ;
   private short[] T000R26_A2266LegCuenAnio ;
   private short[] T000R26_A2310LegCuLConsAnio ;
   private short[] T000R26_A2311LegCuLConsSec ;
   private int[] T000R27_A3CliCod ;
   private short[] T000R27_A1EmpCod ;
   private int[] T000R27_A6LegNumero ;
   private String[] T000R27_A2243LegCuenLicTpo ;
   private short[] T000R27_A2266LegCuenAnio ;
   private java.util.Date[] T000R27_A2324LegCuLAprLicFch ;
   private int[] T000R28_A3CliCod ;
   private short[] T000R28_A1EmpCod ;
   private int[] T000R28_A6LegNumero ;
   private java.util.Date[] T000R28_A2253LegHisFecIng ;
   private int[] T000R29_A3CliCod ;
   private short[] T000R29_A1EmpCod ;
   private int[] T000R29_A31LiqNro ;
   private String[] T000R29_A2183LiqSuc ;
   private int[] T000R30_A3CliCod ;
   private short[] T000R30_A1EmpCod ;
   private int[] T000R30_A31LiqNro ;
   private String[] T000R30_A2145LiqArea ;
   private int[] T000R31_A3CliCod ;
   private short[] T000R31_A1EmpCod ;
   private int[] T000R31_A31LiqNro ;
   private short[] T000R31_A2142LiqPaiConve ;
   private String[] T000R31_A2143LiqConvenio ;
   private int[] T000R32_A3CliCod ;
   private short[] T000R32_A1EmpCod ;
   private int[] T000R32_A1649LSDSec ;
   private int[] T000R33_A3CliCod ;
   private short[] T000R33_A1EmpCod ;
   private int[] T000R33_A6LegNumero ;
   private short[] T000R33_A1172OblSecuencial ;
   private int[] T000R33_A1184LiqOblAltaNro ;
   private int[] T000R33_A1185LiqOblNuevaNro ;
   private int[] T000R34_A3CliCod ;
   private short[] T000R34_A1EmpCod ;
   private int[] T000R34_A6LegNumero ;
   private short[] T000R34_A1172OblSecuencial ;
   private int[] T000R34_A1184LiqOblAltaNro ;
   private int[] T000R34_A1185LiqOblNuevaNro ;
   private int[] T000R35_A3CliCod ;
   private short[] T000R35_A1EmpCod ;
   private int[] T000R35_A6LegNumero ;
   private short[] T000R35_A1172OblSecuencial ;
   private int[] T000R36_A3CliCod ;
   private short[] T000R36_A1EmpCod ;
   private short[] T000R36_A869LiqLegConAnio ;
   private int[] T000R36_A6LegNumero ;
   private String[] T000R36_A26ConCodigo ;
   private int[] T000R36_A1097LiqAltaNro ;
   private int[] T000R36_A1098LiqNuevaNro ;
   private int[] T000R37_A3CliCod ;
   private short[] T000R37_A1EmpCod ;
   private short[] T000R37_A869LiqLegConAnio ;
   private int[] T000R37_A6LegNumero ;
   private String[] T000R37_A26ConCodigo ;
   private int[] T000R37_A1097LiqAltaNro ;
   private int[] T000R37_A1098LiqNuevaNro ;
   private int[] T000R38_A3CliCod ;
   private short[] T000R38_A1EmpCod ;
   private int[] T000R38_A31LiqNro ;
   private String[] T000R38_A10LpgCodigo ;
   private int[] T000R39_A3CliCod ;
   private short[] T000R39_A1EmpCod ;
   private int[] T000R39_A31LiqNro ;
   private int[] T000R39_A6LegNumero ;
   private int[] T000R40_A3CliCod ;
   private short[] T000R40_A1EmpCod ;
   private int[] T000R40_A6LegNumero ;
   private short[] T000R40_A25AgeOrden ;
   private int[] T000R41_A3CliCod ;
   private short[] T000R41_A1EmpCod ;
   private int[] T000R41_A31LiqNro ;
   private int[] T000R42_A3CliCod ;
   private String[] T000R42_A32TLiqCod ;
   private boolean[] T000R42_n32TLiqCod ;
   private String[] T000R42_A340TliqDesc ;
   private String[] T000R43_A2EmpNom ;
   private String[] T000R44_A340TliqDesc ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
}

final  class liquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000R2", "SELECT LiqNro, LiqDescrip, LiqFecha, LiqPerAno, LiqPerMes, LiqPeriodo, LiqFecPago, TLiqDescAux, LiqEstado, LiqLSDDepEst, LiqAuxEstado, LiqContrEst, LiqClase, LiqPDFEstado, LiqGenInter, LiqContabilizada, LiqCntLeg, LiqImpNeto, LiqImpDescuentos, LiqImpRetenGan, LiqImpBruto, LegEspecificos, LiqFecCre, LiqUsuCre, LiqPerSinDia, LiqPerPalabra, LiqDepPrvPer, LiqDepPrvFec, LiqDepPerAno, LiqDepPerMes, LiqFecMod, LiqUsuMod, LiqFecImp, LiqPisoGanancias, LiqPisGanSAC, LiqTopeDedInc, LiqPerUltNorm, LiqError, LiqErrorAux, LiqNombre, LiqLegajosTxt, LiqSegundos, LiqRutaPDFTodosVertical, LiqRutaPDFTodosHorizontal, LiqRutaPDFTodosNombreVertical, LiqRutaPDFTodosNombreHorizonta, LiqLog, LiqSac, LiqSacLog, LiqCancel, LiqModTra, LiqFrecPag, LiqPerDes, LiqPerHas, LiqTipoTarifa, CliCod, LiqDepBanCod, EmpCod, TLiqCod, PeriodoLiq, LiqRelNro FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  FOR UPDATE OF Liquidacion NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R3", "SELECT LiqNro, LiqDescrip, LiqFecha, LiqPerAno, LiqPerMes, LiqPeriodo, LiqFecPago, TLiqDescAux, LiqEstado, LiqLSDDepEst, LiqAuxEstado, LiqContrEst, LiqClase, LiqPDFEstado, LiqGenInter, LiqContabilizada, LiqCntLeg, LiqImpNeto, LiqImpDescuentos, LiqImpRetenGan, LiqImpBruto, LegEspecificos, LiqFecCre, LiqUsuCre, LiqPerSinDia, LiqPerPalabra, LiqDepPrvPer, LiqDepPrvFec, LiqDepPerAno, LiqDepPerMes, LiqFecMod, LiqUsuMod, LiqFecImp, LiqPisoGanancias, LiqPisGanSAC, LiqTopeDedInc, LiqPerUltNorm, LiqError, LiqErrorAux, LiqNombre, LiqLegajosTxt, LiqSegundos, LiqRutaPDFTodosVertical, LiqRutaPDFTodosHorizontal, LiqRutaPDFTodosNombreVertical, LiqRutaPDFTodosNombreHorizonta, LiqLog, LiqSac, LiqSacLog, LiqCancel, LiqModTra, LiqFrecPag, LiqPerDes, LiqPerHas, LiqTipoTarifa, CliCod, LiqDepBanCod, EmpCod, TLiqCod, PeriodoLiq, LiqRelNro FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R4", "SELECT BanDescrip AS LiqDepBanDescrip FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R5", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R6", "SELECT TliqDesc FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R7", "SELECT CliCod FROM Periodo WHERE CliCod = ? AND EmpCod = ? AND PeriodoLiq = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R8", "SELECT CliCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R9", "SELECT TM1.LiqNro, T3.EmpNom, TM1.LiqDescrip, TM1.LiqFecha, TM1.LiqPerAno, TM1.LiqPerMes, TM1.LiqPeriodo, TM1.LiqFecPago, T4.TliqDesc, TM1.TLiqDescAux, TM1.LiqEstado, TM1.LiqLSDDepEst, TM1.LiqAuxEstado, TM1.LiqContrEst, TM1.LiqClase, TM1.LiqPDFEstado, TM1.LiqGenInter, TM1.LiqContabilizada, TM1.LiqCntLeg, TM1.LiqImpNeto, TM1.LiqImpDescuentos, TM1.LiqImpRetenGan, TM1.LiqImpBruto, TM1.LegEspecificos, TM1.LiqFecCre, TM1.LiqUsuCre, TM1.LiqPerSinDia, TM1.LiqPerPalabra, TM1.LiqDepPrvPer, TM1.LiqDepPrvFec, T2.BanDescrip AS LiqDepBanDescrip, TM1.LiqDepPerAno, TM1.LiqDepPerMes, TM1.LiqFecMod, TM1.LiqUsuMod, TM1.LiqFecImp, TM1.LiqPisoGanancias, TM1.LiqPisGanSAC, TM1.LiqTopeDedInc, TM1.LiqPerUltNorm, TM1.LiqError, TM1.LiqErrorAux, TM1.LiqNombre, TM1.LiqLegajosTxt, TM1.LiqSegundos, TM1.LiqRutaPDFTodosVertical, TM1.LiqRutaPDFTodosHorizontal, TM1.LiqRutaPDFTodosNombreVertical, TM1.LiqRutaPDFTodosNombreHorizonta, TM1.LiqLog, TM1.LiqSac, TM1.LiqSacLog, TM1.LiqCancel, TM1.LiqModTra, TM1.LiqFrecPag, TM1.LiqPerDes, TM1.LiqPerHas, TM1.LiqTipoTarifa, TM1.CliCod, TM1.LiqDepBanCod AS LiqDepBanCod, TM1.EmpCod, TM1.TLiqCod, TM1.PeriodoLiq, TM1.LiqRelNro AS LiqRelNro FROM (((Liquidacion TM1 LEFT JOIN Banco T2 ON T2.CliCod = TM1.CliCod AND T2.BanCod = TM1.LiqDepBanCod) INNER JOIN Empresa T3 ON T3.CliCod = TM1.CliCod AND T3.EmpCod = TM1.EmpCod) LEFT JOIN TipoLiquidacion T4 ON T4.CliCod = TM1.CliCod AND T4.TLiqCod = TM1.TLiqCod) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LiqNro = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LiqNro ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R10", "SELECT BanDescrip AS LiqDepBanDescrip FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R11", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R12", "SELECT TliqDesc FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R13", "SELECT CliCod FROM Periodo WHERE CliCod = ? AND EmpCod = ? AND PeriodoLiq = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R14", "SELECT CliCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R15", "SELECT CliCod, EmpCod, LiqNro FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R16", "SELECT CliCod, EmpCod, LiqNro FROM Liquidacion WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LiqNro > ?) ORDER BY CliCod, EmpCod, LiqNro  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R17", "SELECT CliCod, EmpCod, LiqNro FROM Liquidacion WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LiqNro < ?) ORDER BY CliCod DESC, EmpCod DESC, LiqNro DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000R18", "SAVEPOINT gxupdate;INSERT INTO Liquidacion(LiqNro, LiqDescrip, LiqFecha, LiqPerAno, LiqPerMes, LiqPeriodo, LiqFecPago, TLiqDescAux, LiqEstado, LiqLSDDepEst, LiqAuxEstado, LiqContrEst, LiqClase, LiqPDFEstado, LiqGenInter, LiqContabilizada, LiqCntLeg, LiqImpNeto, LiqImpDescuentos, LiqImpRetenGan, LiqImpBruto, LegEspecificos, LiqFecCre, LiqUsuCre, LiqPerSinDia, LiqPerPalabra, LiqDepPrvPer, LiqDepPrvFec, LiqDepPerAno, LiqDepPerMes, LiqFecMod, LiqUsuMod, LiqFecImp, LiqPisoGanancias, LiqPisGanSAC, LiqTopeDedInc, LiqPerUltNorm, LiqError, LiqErrorAux, LiqNombre, LiqLegajosTxt, LiqSegundos, LiqRutaPDFTodosVertical, LiqRutaPDFTodosHorizontal, LiqRutaPDFTodosNombreVertical, LiqRutaPDFTodosNombreHorizonta, LiqLog, LiqSac, LiqSacLog, LiqCancel, LiqModTra, LiqFrecPag, LiqPerDes, LiqPerHas, LiqTipoTarifa, CliCod, LiqDepBanCod, EmpCod, TLiqCod, PeriodoLiq, LiqRelNro) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000R19", "SAVEPOINT gxupdate;UPDATE Liquidacion SET LiqDescrip=?, LiqFecha=?, LiqPerAno=?, LiqPerMes=?, LiqPeriodo=?, LiqFecPago=?, TLiqDescAux=?, LiqEstado=?, LiqLSDDepEst=?, LiqAuxEstado=?, LiqContrEst=?, LiqClase=?, LiqPDFEstado=?, LiqGenInter=?, LiqContabilizada=?, LiqCntLeg=?, LiqImpNeto=?, LiqImpDescuentos=?, LiqImpRetenGan=?, LiqImpBruto=?, LegEspecificos=?, LiqFecCre=?, LiqUsuCre=?, LiqPerSinDia=?, LiqPerPalabra=?, LiqDepPrvPer=?, LiqDepPrvFec=?, LiqDepPerAno=?, LiqDepPerMes=?, LiqFecMod=?, LiqUsuMod=?, LiqFecImp=?, LiqPisoGanancias=?, LiqPisGanSAC=?, LiqTopeDedInc=?, LiqPerUltNorm=?, LiqError=?, LiqErrorAux=?, LiqNombre=?, LiqLegajosTxt=?, LiqSegundos=?, LiqRutaPDFTodosVertical=?, LiqRutaPDFTodosHorizontal=?, LiqRutaPDFTodosNombreVertical=?, LiqRutaPDFTodosNombreHorizonta=?, LiqLog=?, LiqSac=?, LiqSacLog=?, LiqCancel=?, LiqModTra=?, LiqFrecPag=?, LiqPerDes=?, LiqPerHas=?, LiqTipoTarifa=?, LiqDepBanCod=?, TLiqCod=?, PeriodoLiq=?, LiqRelNro=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000R20", "SAVEPOINT gxupdate;DELETE FROM Liquidacion  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000R21", "SELECT BanDescrip AS LiqDepBanDescrip FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R22", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R23", "SELECT TliqDesc FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R24", "SELECT CliCod, EmpCod, LiqNro AS LiqRelNro FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqRelNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R25", "SELECT CliCod, EmpCod, LiqNro, LinkLegNumero, LegLinkTiporec FROM LiquidacionLegajoLinkPdf WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R26", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsSec FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? AND EmpCod = ? AND LegCulConsLiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R27", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLAprLicFch FROM legajo_cuenta_licenciasaprobaciones WHERE CliCod = ? AND EmpCod = ? AND LegCuLAprLiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R28", "SELECT CliCod, EmpCod, LegNumero, LegHisFecIng FROM legajo_permanencia WHERE CliCod = ? AND EmpCod = ? AND LegHisLiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R29", "SELECT CliCod, EmpCod, LiqNro, LiqSuc FROM LiquidacionSucursal WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R30", "SELECT CliCod, EmpCod, LiqNro, LiqArea FROM LiquidacionArea WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R31", "SELECT CliCod, EmpCod, LiqNro, LiqPaiConve, LiqConvenio FROM LiquidacionConvenio WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R32", "SELECT CliCod, EmpCod, LSDSec FROM LSD_reg1 WHERE CliCod = ? AND EmpCod = ? AND LSD1LiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R33", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro FROM LiqLegObligacionCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqOblNuevaNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R34", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro FROM LiqLegObligacionCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqOblAltaNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R35", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND OblLiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R36", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqNuevaNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R37", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqAltaNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R38", "SELECT CliCod, EmpCod, LiqNro, LpgCodigo FROM LiquidacionLugarPago WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R39", "SELECT CliCod, EmpCod, LiqNro, LegNumero FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R40", "SELECT CliCod, EmpCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND AgeLiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R41", "SELECT CliCod, EmpCod, LiqNro FROM Liquidacion ORDER BY CliCod, EmpCod, LiqNro ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R42", "SELECT CliCod, TLiqCod, TliqDesc FROM TipoLiquidacion WHERE CliCod = ? ORDER BY TliqDesc ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R43", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R44", "SELECT TliqDesc FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((boolean[]) buf[16])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(16);
               ((short[]) buf[18])[0] = rslt.getShort(17);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(21,2);
               ((boolean[]) buf[23])[0] = rslt.getBoolean(22);
               ((java.util.Date[]) buf[24])[0] = rslt.getGXDate(23);
               ((String[]) buf[25])[0] = rslt.getVarchar(24);
               ((String[]) buf[26])[0] = rslt.getString(25, 20);
               ((String[]) buf[27])[0] = rslt.getString(26, 20);
               ((String[]) buf[28])[0] = rslt.getString(27, 20);
               ((java.util.Date[]) buf[29])[0] = rslt.getGXDate(28);
               ((short[]) buf[30])[0] = rslt.getShort(29);
               ((byte[]) buf[31])[0] = rslt.getByte(30);
               ((java.util.Date[]) buf[32])[0] = rslt.getGXDateTime(31);
               ((String[]) buf[33])[0] = rslt.getVarchar(32);
               ((java.util.Date[]) buf[34])[0] = rslt.getGXDateTime(33);
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(34,2);
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(35,2);
               ((java.math.BigDecimal[]) buf[37])[0] = rslt.getBigDecimal(36,2);
               ((java.util.Date[]) buf[38])[0] = rslt.getGXDate(37);
               ((String[]) buf[39])[0] = rslt.getVarchar(38);
               ((String[]) buf[40])[0] = rslt.getVarchar(39);
               ((String[]) buf[41])[0] = rslt.getVarchar(40);
               ((String[]) buf[42])[0] = rslt.getVarchar(41);
               ((java.math.BigDecimal[]) buf[43])[0] = rslt.getBigDecimal(42,2);
               ((String[]) buf[44])[0] = rslt.getVarchar(43);
               ((String[]) buf[45])[0] = rslt.getVarchar(44);
               ((String[]) buf[46])[0] = rslt.getString(45, 200);
               ((String[]) buf[47])[0] = rslt.getString(46, 200);
               ((String[]) buf[48])[0] = rslt.getLongVarchar(47);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(48);
               ((boolean[]) buf[50])[0] = rslt.wasNull();
               ((String[]) buf[51])[0] = rslt.getVarchar(49);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((boolean[]) buf[53])[0] = rslt.getBoolean(50);
               ((String[]) buf[54])[0] = rslt.getString(51, 1);
               ((byte[]) buf[55])[0] = rslt.getByte(52);
               ((java.util.Date[]) buf[56])[0] = rslt.getGXDate(53);
               ((java.util.Date[]) buf[57])[0] = rslt.getGXDate(54);
               ((String[]) buf[58])[0] = rslt.getString(55, 1);
               ((int[]) buf[59])[0] = rslt.getInt(56);
               ((String[]) buf[60])[0] = rslt.getString(57, 6);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((short[]) buf[62])[0] = rslt.getShort(58);
               ((String[]) buf[63])[0] = rslt.getString(59, 20);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[65])[0] = rslt.getGXDate(60);
               ((int[]) buf[66])[0] = rslt.getInt(61);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((boolean[]) buf[16])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(16);
               ((short[]) buf[18])[0] = rslt.getShort(17);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(21,2);
               ((boolean[]) buf[23])[0] = rslt.getBoolean(22);
               ((java.util.Date[]) buf[24])[0] = rslt.getGXDate(23);
               ((String[]) buf[25])[0] = rslt.getVarchar(24);
               ((String[]) buf[26])[0] = rslt.getString(25, 20);
               ((String[]) buf[27])[0] = rslt.getString(26, 20);
               ((String[]) buf[28])[0] = rslt.getString(27, 20);
               ((java.util.Date[]) buf[29])[0] = rslt.getGXDate(28);
               ((short[]) buf[30])[0] = rslt.getShort(29);
               ((byte[]) buf[31])[0] = rslt.getByte(30);
               ((java.util.Date[]) buf[32])[0] = rslt.getGXDateTime(31);
               ((String[]) buf[33])[0] = rslt.getVarchar(32);
               ((java.util.Date[]) buf[34])[0] = rslt.getGXDateTime(33);
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(34,2);
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(35,2);
               ((java.math.BigDecimal[]) buf[37])[0] = rslt.getBigDecimal(36,2);
               ((java.util.Date[]) buf[38])[0] = rslt.getGXDate(37);
               ((String[]) buf[39])[0] = rslt.getVarchar(38);
               ((String[]) buf[40])[0] = rslt.getVarchar(39);
               ((String[]) buf[41])[0] = rslt.getVarchar(40);
               ((String[]) buf[42])[0] = rslt.getVarchar(41);
               ((java.math.BigDecimal[]) buf[43])[0] = rslt.getBigDecimal(42,2);
               ((String[]) buf[44])[0] = rslt.getVarchar(43);
               ((String[]) buf[45])[0] = rslt.getVarchar(44);
               ((String[]) buf[46])[0] = rslt.getString(45, 200);
               ((String[]) buf[47])[0] = rslt.getString(46, 200);
               ((String[]) buf[48])[0] = rslt.getLongVarchar(47);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(48);
               ((boolean[]) buf[50])[0] = rslt.wasNull();
               ((String[]) buf[51])[0] = rslt.getVarchar(49);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((boolean[]) buf[53])[0] = rslt.getBoolean(50);
               ((String[]) buf[54])[0] = rslt.getString(51, 1);
               ((byte[]) buf[55])[0] = rslt.getByte(52);
               ((java.util.Date[]) buf[56])[0] = rslt.getGXDate(53);
               ((java.util.Date[]) buf[57])[0] = rslt.getGXDate(54);
               ((String[]) buf[58])[0] = rslt.getString(55, 1);
               ((int[]) buf[59])[0] = rslt.getInt(56);
               ((String[]) buf[60])[0] = rslt.getString(57, 6);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((short[]) buf[62])[0] = rslt.getShort(58);
               ((String[]) buf[63])[0] = rslt.getString(59, 20);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[65])[0] = rslt.getGXDate(60);
               ((int[]) buf[66])[0] = rslt.getInt(61);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((byte[]) buf[14])[0] = rslt.getByte(15);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((boolean[]) buf[18])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(18);
               ((short[]) buf[20])[0] = rslt.getShort(19);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(23,2);
               ((boolean[]) buf[25])[0] = rslt.getBoolean(24);
               ((java.util.Date[]) buf[26])[0] = rslt.getGXDate(25);
               ((String[]) buf[27])[0] = rslt.getVarchar(26);
               ((String[]) buf[28])[0] = rslt.getString(27, 20);
               ((String[]) buf[29])[0] = rslt.getString(28, 20);
               ((String[]) buf[30])[0] = rslt.getString(29, 20);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(30);
               ((String[]) buf[32])[0] = rslt.getVarchar(31);
               ((short[]) buf[33])[0] = rslt.getShort(32);
               ((byte[]) buf[34])[0] = rslt.getByte(33);
               ((java.util.Date[]) buf[35])[0] = rslt.getGXDateTime(34);
               ((String[]) buf[36])[0] = rslt.getVarchar(35);
               ((java.util.Date[]) buf[37])[0] = rslt.getGXDateTime(36);
               ((java.math.BigDecimal[]) buf[38])[0] = rslt.getBigDecimal(37,2);
               ((java.math.BigDecimal[]) buf[39])[0] = rslt.getBigDecimal(38,2);
               ((java.math.BigDecimal[]) buf[40])[0] = rslt.getBigDecimal(39,2);
               ((java.util.Date[]) buf[41])[0] = rslt.getGXDate(40);
               ((String[]) buf[42])[0] = rslt.getVarchar(41);
               ((String[]) buf[43])[0] = rslt.getVarchar(42);
               ((String[]) buf[44])[0] = rslt.getVarchar(43);
               ((String[]) buf[45])[0] = rslt.getVarchar(44);
               ((java.math.BigDecimal[]) buf[46])[0] = rslt.getBigDecimal(45,2);
               ((String[]) buf[47])[0] = rslt.getVarchar(46);
               ((String[]) buf[48])[0] = rslt.getVarchar(47);
               ((String[]) buf[49])[0] = rslt.getString(48, 200);
               ((String[]) buf[50])[0] = rslt.getString(49, 200);
               ((String[]) buf[51])[0] = rslt.getLongVarchar(50);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(51);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((String[]) buf[54])[0] = rslt.getVarchar(52);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((boolean[]) buf[56])[0] = rslt.getBoolean(53);
               ((String[]) buf[57])[0] = rslt.getString(54, 1);
               ((byte[]) buf[58])[0] = rslt.getByte(55);
               ((java.util.Date[]) buf[59])[0] = rslt.getGXDate(56);
               ((java.util.Date[]) buf[60])[0] = rslt.getGXDate(57);
               ((String[]) buf[61])[0] = rslt.getString(58, 1);
               ((int[]) buf[62])[0] = rslt.getInt(59);
               ((String[]) buf[63])[0] = rslt.getString(60, 6);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((short[]) buf[65])[0] = rslt.getShort(61);
               ((String[]) buf[66])[0] = rslt.getString(62, 20);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[68])[0] = rslt.getGXDate(63);
               ((int[]) buf[69])[0] = rslt.getInt(64);
               ((boolean[]) buf[70])[0] = rslt.wasNull();
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 37 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 39 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 40 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 41 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 42 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 6);
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 6);
               }
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setVarchar(8, (String)parms[7], 30, false);
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(13, ((Number) parms[13]).byteValue());
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(14, (String)parms[15], 20);
               }
               stmt.setBoolean(15, ((Boolean) parms[16]).booleanValue());
               stmt.setBoolean(16, ((Boolean) parms[17]).booleanValue());
               stmt.setShort(17, ((Number) parms[18]).shortValue());
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[19], 2);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[20], 2);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[21], 2);
               stmt.setBigDecimal(21, (java.math.BigDecimal)parms[22], 2);
               stmt.setBoolean(22, ((Boolean) parms[23]).booleanValue());
               stmt.setDate(23, (java.util.Date)parms[24]);
               stmt.setVarchar(24, (String)parms[25], 100, false);
               stmt.setString(25, (String)parms[26], 20);
               stmt.setString(26, (String)parms[27], 20);
               stmt.setString(27, (String)parms[28], 20);
               stmt.setDate(28, (java.util.Date)parms[29]);
               stmt.setShort(29, ((Number) parms[30]).shortValue());
               stmt.setByte(30, ((Number) parms[31]).byteValue());
               stmt.setDateTime(31, (java.util.Date)parms[32], false);
               stmt.setVarchar(32, (String)parms[33], 100, false);
               stmt.setDateTime(33, (java.util.Date)parms[34], false);
               stmt.setBigDecimal(34, (java.math.BigDecimal)parms[35], 2);
               stmt.setBigDecimal(35, (java.math.BigDecimal)parms[36], 2);
               stmt.setBigDecimal(36, (java.math.BigDecimal)parms[37], 2);
               stmt.setDate(37, (java.util.Date)parms[38]);
               stmt.setVarchar(38, (String)parms[39], 400, false);
               stmt.setVarchar(39, (String)parms[40], 400, false);
               stmt.setVarchar(40, (String)parms[41], 400, false);
               stmt.setVarchar(41, (String)parms[42], 1000, false);
               stmt.setBigDecimal(42, (java.math.BigDecimal)parms[43], 2);
               stmt.setVarchar(43, (String)parms[44], 400, false);
               stmt.setVarchar(44, (String)parms[45], 400, false);
               stmt.setString(45, (String)parms[46], 200);
               stmt.setString(46, (String)parms[47], 200);
               stmt.setNLongVarchar(47, (String)parms[48], false);
               if ( ((Boolean) parms[49]).booleanValue() )
               {
                  stmt.setNull( 48 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(48, ((Boolean) parms[50]).booleanValue());
               }
               if ( ((Boolean) parms[51]).booleanValue() )
               {
                  stmt.setNull( 49 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(49, (String)parms[52], 400);
               }
               stmt.setBoolean(50, ((Boolean) parms[53]).booleanValue());
               stmt.setString(51, (String)parms[54], 1);
               stmt.setByte(52, ((Number) parms[55]).byteValue());
               stmt.setDate(53, (java.util.Date)parms[56]);
               stmt.setDate(54, (java.util.Date)parms[57]);
               stmt.setString(55, (String)parms[58], 1);
               stmt.setInt(56, ((Number) parms[59]).intValue());
               if ( ((Boolean) parms[60]).booleanValue() )
               {
                  stmt.setNull( 57 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(57, (String)parms[61], 6);
               }
               stmt.setShort(58, ((Number) parms[62]).shortValue());
               if ( ((Boolean) parms[63]).booleanValue() )
               {
                  stmt.setNull( 59 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(59, (String)parms[64], 20);
               }
               stmt.setDate(60, (java.util.Date)parms[65]);
               if ( ((Boolean) parms[66]).booleanValue() )
               {
                  stmt.setNull( 61 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(61, ((Number) parms[67]).intValue());
               }
               return;
            case 17 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setVarchar(7, (String)parms[6], 30, false);
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(12, ((Number) parms[12]).byteValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(13, (String)parms[14], 20);
               }
               stmt.setBoolean(14, ((Boolean) parms[15]).booleanValue());
               stmt.setBoolean(15, ((Boolean) parms[16]).booleanValue());
               stmt.setShort(16, ((Number) parms[17]).shortValue());
               stmt.setBigDecimal(17, (java.math.BigDecimal)parms[18], 2);
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[19], 2);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[20], 2);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[21], 2);
               stmt.setBoolean(21, ((Boolean) parms[22]).booleanValue());
               stmt.setDate(22, (java.util.Date)parms[23]);
               stmt.setVarchar(23, (String)parms[24], 100, false);
               stmt.setString(24, (String)parms[25], 20);
               stmt.setString(25, (String)parms[26], 20);
               stmt.setString(26, (String)parms[27], 20);
               stmt.setDate(27, (java.util.Date)parms[28]);
               stmt.setShort(28, ((Number) parms[29]).shortValue());
               stmt.setByte(29, ((Number) parms[30]).byteValue());
               stmt.setDateTime(30, (java.util.Date)parms[31], false);
               stmt.setVarchar(31, (String)parms[32], 100, false);
               stmt.setDateTime(32, (java.util.Date)parms[33], false);
               stmt.setBigDecimal(33, (java.math.BigDecimal)parms[34], 2);
               stmt.setBigDecimal(34, (java.math.BigDecimal)parms[35], 2);
               stmt.setBigDecimal(35, (java.math.BigDecimal)parms[36], 2);
               stmt.setDate(36, (java.util.Date)parms[37]);
               stmt.setVarchar(37, (String)parms[38], 400, false);
               stmt.setVarchar(38, (String)parms[39], 400, false);
               stmt.setVarchar(39, (String)parms[40], 400, false);
               stmt.setVarchar(40, (String)parms[41], 1000, false);
               stmt.setBigDecimal(41, (java.math.BigDecimal)parms[42], 2);
               stmt.setVarchar(42, (String)parms[43], 400, false);
               stmt.setVarchar(43, (String)parms[44], 400, false);
               stmt.setString(44, (String)parms[45], 200);
               stmt.setString(45, (String)parms[46], 200);
               stmt.setNLongVarchar(46, (String)parms[47], false);
               if ( ((Boolean) parms[48]).booleanValue() )
               {
                  stmt.setNull( 47 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(47, ((Boolean) parms[49]).booleanValue());
               }
               if ( ((Boolean) parms[50]).booleanValue() )
               {
                  stmt.setNull( 48 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(48, (String)parms[51], 400);
               }
               stmt.setBoolean(49, ((Boolean) parms[52]).booleanValue());
               stmt.setString(50, (String)parms[53], 1);
               stmt.setByte(51, ((Number) parms[54]).byteValue());
               stmt.setDate(52, (java.util.Date)parms[55]);
               stmt.setDate(53, (java.util.Date)parms[56]);
               stmt.setString(54, (String)parms[57], 1);
               if ( ((Boolean) parms[58]).booleanValue() )
               {
                  stmt.setNull( 55 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(55, (String)parms[59], 6);
               }
               if ( ((Boolean) parms[60]).booleanValue() )
               {
                  stmt.setNull( 56 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(56, (String)parms[61], 20);
               }
               stmt.setDate(57, (java.util.Date)parms[62]);
               if ( ((Boolean) parms[63]).booleanValue() )
               {
                  stmt.setNull( 58 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(58, ((Number) parms[64]).intValue());
               }
               stmt.setInt(59, ((Number) parms[65]).intValue());
               stmt.setShort(60, ((Number) parms[66]).shortValue());
               stmt.setInt(61, ((Number) parms[67]).intValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 6);
               }
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 37 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 40 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 41 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 42 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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

