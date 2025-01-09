package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajo_permanencia_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action32") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A2253LegHisFecIng = localUtil.parseDateParm( httpContext.GetPar( "LegHisFecIng")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2253LegHisFecIng", localUtil.format(A2253LegHisFecIng, "99/99/9999"));
         A2254LegHisFecEgr = localUtil.parseDateParm( httpContext.GetPar( "LegHisFecEgr")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2254LegHisFecEgr", localUtil.format(A2254LegHisFecEgr, "99/99/9999"));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_32_6G284( AV7CliCod, AV8EmpCod, A6LegNumero, A2253LegHisFecIng, A2254LegHisFecEgr) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"LEGHISMOTCOD") == 0 )
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
         gxdlaleghismotcod6G284( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"CLICOD") == 0 )
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
         gx3asaclicod6G284( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_38") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A2330LegHisMotCod = httpContext.GetPar( "LegHisMotCod") ;
         n2330LegHisMotCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2330LegHisMotCod", A2330LegHisMotCod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_38( A3CliCod, A2330LegHisMotCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_36") == 0 )
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
         gxload_36( A3CliCod, A1EmpCod, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_37") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A2252LegHisLiqNro = (int)(GXutil.lval( httpContext.GetPar( "LegHisLiqNro"))) ;
         n2252LegHisLiqNro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2252LegHisLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2252LegHisLiqNro), 8, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_37( A3CliCod, A1EmpCod, A2252LegHisLiqNro, A6LegNumero) ;
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
            AV10LegHisFecIng = localUtil.parseDateParm( httpContext.GetPar( "LegHisFecIng")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10LegHisFecIng", localUtil.format(AV10LegHisFecIng, "99/99/9999"));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGHISFECING", getSecureSignedToken( "", AV10LegHisFecIng));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "legajo_permanencia", ""), (short)(0)) ;
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

   public legajo_permanencia_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajo_permanencia_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_permanencia_impl.class ));
   }

   public legajo_permanencia_impl( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynLegHisMotCod = new HTMLChoice();
      chkLegHisAfecAnt = UIFactory.getCheckbox(this);
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
      if ( dynLegHisMotCod.getItemCount() > 0 )
      {
         A2330LegHisMotCod = dynLegHisMotCod.getValidValue(A2330LegHisMotCod) ;
         n2330LegHisMotCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2330LegHisMotCod", A2330LegHisMotCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynLegHisMotCod.setValue( GXutil.rtrim( A2330LegHisMotCod) );
         httpContext.ajax_rsp_assign_prop("", false, dynLegHisMotCod.getInternalname(), "Values", dynLegHisMotCod.ToJavascriptSource(), true);
      }
      A2258LegHisAfecAnt = GXutil.strtobool( GXutil.booltostr( A2258LegHisAfecAnt)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2258LegHisAfecAnt", A2258LegHisAfecAnt);
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedlegnumero_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklegnumero_Internalname, httpContext.getMessage( "Legajo", ""), "", "", lblTextblocklegnumero_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_permanencia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_legnumero.setProperty("Caption", Combo_legnumero_Caption);
      ucCombo_legnumero.setProperty("Cls", Combo_legnumero_Cls);
      ucCombo_legnumero.setProperty("EmptyItem", Combo_legnumero_Emptyitem);
      ucCombo_legnumero.setProperty("DropDownOptionsData", AV18LegNumero_Data);
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", edtLegNumero_Visible, edtLegNumero_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_legajo_permanencia.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegHisFecIng_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegHisFecIng_Internalname, httpContext.getMessage( "Fecha de ingreso", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLegHisFecIng_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegHisFecIng_Internalname, localUtil.format(A2253LegHisFecIng, "99/99/9999"), localUtil.format( A2253LegHisFecIng, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegHisFecIng_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtLegHisFecIng_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_legajo_permanencia.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLegHisFecIng_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegHisFecIng_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_legajo_permanencia.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegHisFecEgr_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegHisFecEgr_Internalname, httpContext.getMessage( "Fecha de egreso", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLegHisFecEgr_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegHisFecEgr_Internalname, localUtil.format(A2254LegHisFecEgr, "99/99/9999"), localUtil.format( A2254LegHisFecEgr, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegHisFecEgr_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtLegHisFecEgr_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_legajo_permanencia.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLegHisFecEgr_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegHisFecEgr_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_legajo_permanencia.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynLegHisMotCod.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynLegHisMotCod.getInternalname(), httpContext.getMessage( "Motivo Egreso", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynLegHisMotCod, dynLegHisMotCod.getInternalname(), GXutil.rtrim( A2330LegHisMotCod), 1, dynLegHisMotCod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynLegHisMotCod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "", true, (byte)(0), "HLP_legajo_permanencia.htm");
      dynLegHisMotCod.setValue( GXutil.rtrim( A2330LegHisMotCod) );
      httpContext.ajax_rsp_assign_prop("", false, dynLegHisMotCod.getInternalname(), "Values", dynLegHisMotCod.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkLegHisAfecAnt.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkLegHisAfecAnt.getInternalname(), httpContext.getMessage( "Afecta antiguedad", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkLegHisAfecAnt.getInternalname(), GXutil.booltostr( A2258LegHisAfecAnt), "", httpContext.getMessage( "Afecta antiguedad", ""), 1, chkLegHisAfecAnt.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(48, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,48);\"");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_legajo_permanencia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_legajo_permanencia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_legajo_permanencia.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombolegnumero_Internalname, GXutil.ltrim( localUtil.ntoc( AV23ComboLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCombolegnumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV23ComboLegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV23ComboLegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombolegnumero_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombolegnumero_Visible, edtavCombolegnumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_permanencia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,66);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_permanencia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_legajo_permanencia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLegHisFecTel_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegHisFecTel_Internalname, localUtil.format(A2255LegHisFecTel, "99/99/9999"), localUtil.format( A2255LegHisFecTel, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegHisFecTel_Jsonclick, 0, "Attribute", "", "", "", "", edtLegHisFecTel_Visible, edtLegHisFecTel_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_legajo_permanencia.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLegHisFecTel_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtLegHisFecTel_Visible==0)||(edtLegHisFecTel_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_legajo_permanencia.htm");
      httpContext.writeTextNL( "</div>") ;
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegHisLiqNro_Internalname, GXutil.ltrim( localUtil.ntoc( A2252LegHisLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2252LegHisLiqNro), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegHisLiqNro_Jsonclick, 0, "Attribute", "", "", "", "", edtLegHisLiqNro_Visible, edtLegHisLiqNro_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_legajo_permanencia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegHisDiasAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A2257LegHisDiasAnt, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegHisDiasAnt_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2257LegHisDiasAnt), "ZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2257LegHisDiasAnt), "ZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,70);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegHisDiasAnt_Jsonclick, 0, "Attribute", "", "", "", "", edtLegHisDiasAnt_Visible, edtLegHisDiasAnt_Enabled, 0, "text", "1", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_permanencia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegHisMesesAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A2317LegHisMesesAnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegHisMesesAnt_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2317LegHisMesesAnt), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2317LegHisMesesAnt), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,71);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegHisMesesAnt_Jsonclick, 0, "Attribute", "", "", "", "", edtLegHisMesesAnt_Visible, edtLegHisMesesAnt_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_permanencia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegHisAniosAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A2318LegHisAniosAnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegHisAniosAnt_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2318LegHisAniosAnt), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2318LegHisAniosAnt), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,72);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegHisAniosAnt_Jsonclick, 0, "Attribute", "", "", "", "", edtLegHisAniosAnt_Visible, edtLegHisAniosAnt_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_permanencia.htm");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtLegHisAntTexto_Internalname, A2319LegHisAntTexto, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,73);\"", (short)(0), edtLegHisAntTexto_Visible, edtLegHisAntTexto_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_legajo_permanencia.htm");
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
      e116G2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGNUMERO_DATA"), AV18LegNumero_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2253LegHisFecIng = localUtil.ctod( httpContext.cgiGet( "Z2253LegHisFecIng"), 0) ;
            Z2254LegHisFecEgr = localUtil.ctod( httpContext.cgiGet( "Z2254LegHisFecEgr"), 0) ;
            Z2255LegHisFecTel = localUtil.ctod( httpContext.cgiGet( "Z2255LegHisFecTel"), 0) ;
            Z2257LegHisDiasAnt = (int)(localUtil.ctol( httpContext.cgiGet( "Z2257LegHisDiasAnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2317LegHisMesesAnt = (short)(localUtil.ctol( httpContext.cgiGet( "Z2317LegHisMesesAnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2318LegHisAniosAnt = (short)(localUtil.ctol( httpContext.cgiGet( "Z2318LegHisAniosAnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2331LegHisAntTxtAbr = httpContext.cgiGet( "Z2331LegHisAntTxtAbr") ;
            Z2258LegHisAfecAnt = GXutil.strtobool( httpContext.cgiGet( "Z2258LegHisAfecAnt")) ;
            Z2332LegHisManual = GXutil.strtobool( httpContext.cgiGet( "Z2332LegHisManual")) ;
            Z2252LegHisLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "Z2252LegHisLiqNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2252LegHisLiqNro = ((0==A2252LegHisLiqNro) ? true : false) ;
            Z2330LegHisMotCod = httpContext.cgiGet( "Z2330LegHisMotCod") ;
            n2330LegHisMotCod = ((GXutil.strcmp("", A2330LegHisMotCod)==0) ? true : false) ;
            A2331LegHisAntTxtAbr = httpContext.cgiGet( "Z2331LegHisAntTxtAbr") ;
            A2332LegHisManual = GXutil.strtobool( httpContext.cgiGet( "Z2332LegHisManual")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N2330LegHisMotCod = httpContext.cgiGet( "N2330LegHisMotCod") ;
            n2330LegHisMotCod = ((GXutil.strcmp("", A2330LegHisMotCod)==0) ? true : false) ;
            N2252LegHisLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "N2252LegHisLiqNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2252LegHisLiqNro = ((0==A2252LegHisLiqNro) ? true : false) ;
            N2254LegHisFecEgr = localUtil.ctod( httpContext.cgiGet( "N2254LegHisFecEgr"), 0) ;
            N2255LegHisFecTel = localUtil.ctod( httpContext.cgiGet( "N2255LegHisFecTel"), 0) ;
            N2258LegHisAfecAnt = GXutil.strtobool( httpContext.cgiGet( "N2258LegHisAfecAnt")) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "vLEGNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV10LegHisFecIng = localUtil.ctod( httpContext.cgiGet( "vLEGHISFECING"), 0) ;
            AV28Insert_LegHisMotCod = httpContext.cgiGet( "vINSERT_LEGHISMOTCOD") ;
            A2332LegHisManual = GXutil.strtobool( httpContext.cgiGet( "LEGHISMANUAL")) ;
            AV16Insert_LegHisLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_LEGHISLIQNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "vMODE") ;
            AV30existe = GXutil.strtobool( httpContext.cgiGet( "vEXISTE")) ;
            A2331LegHisAntTxtAbr = httpContext.cgiGet( "LEGHISANTTXTABR") ;
            A2256LegHisMotivo = httpContext.cgiGet( "LEGHISMOTIVO") ;
            AV32Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            if ( localUtil.vcdate( httpContext.cgiGet( edtLegHisFecIng_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "LEGHISFECING");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegHisFecIng_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2253LegHisFecIng = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A2253LegHisFecIng", localUtil.format(A2253LegHisFecIng, "99/99/9999"));
            }
            else
            {
               A2253LegHisFecIng = localUtil.ctod( httpContext.cgiGet( edtLegHisFecIng_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2253LegHisFecIng", localUtil.format(A2253LegHisFecIng, "99/99/9999"));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtLegHisFecEgr_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "LEGHISFECEGR");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegHisFecEgr_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2254LegHisFecEgr = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A2254LegHisFecEgr", localUtil.format(A2254LegHisFecEgr, "99/99/9999"));
            }
            else
            {
               A2254LegHisFecEgr = localUtil.ctod( httpContext.cgiGet( edtLegHisFecEgr_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2254LegHisFecEgr", localUtil.format(A2254LegHisFecEgr, "99/99/9999"));
            }
            dynLegHisMotCod.setValue( httpContext.cgiGet( dynLegHisMotCod.getInternalname()) );
            A2330LegHisMotCod = httpContext.cgiGet( dynLegHisMotCod.getInternalname()) ;
            n2330LegHisMotCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A2330LegHisMotCod", A2330LegHisMotCod);
            n2330LegHisMotCod = ((GXutil.strcmp("", A2330LegHisMotCod)==0) ? true : false) ;
            A2258LegHisAfecAnt = GXutil.strtobool( httpContext.cgiGet( chkLegHisAfecAnt.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2258LegHisAfecAnt", A2258LegHisAfecAnt);
            AV23ComboLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtavCombolegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ComboLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboLegNumero), 8, 0));
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
            if ( localUtil.vcdate( httpContext.cgiGet( edtLegHisFecTel_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "LEGHISFECTEL");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegHisFecTel_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2255LegHisFecTel = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A2255LegHisFecTel", localUtil.format(A2255LegHisFecTel, "99/99/9999"));
            }
            else
            {
               A2255LegHisFecTel = localUtil.ctod( httpContext.cgiGet( edtLegHisFecTel_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2255LegHisFecTel", localUtil.format(A2255LegHisFecTel, "99/99/9999"));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegHisLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegHisLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGHISLIQNRO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegHisLiqNro_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2252LegHisLiqNro = 0 ;
               n2252LegHisLiqNro = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A2252LegHisLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2252LegHisLiqNro), 8, 0));
            }
            else
            {
               A2252LegHisLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLegHisLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n2252LegHisLiqNro = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A2252LegHisLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2252LegHisLiqNro), 8, 0));
            }
            n2252LegHisLiqNro = ((0==A2252LegHisLiqNro) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegHisDiasAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegHisDiasAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGHISDIASANT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegHisDiasAnt_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2257LegHisDiasAnt = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A2257LegHisDiasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2257LegHisDiasAnt), 5, 0));
            }
            else
            {
               A2257LegHisDiasAnt = (int)(localUtil.ctol( httpContext.cgiGet( edtLegHisDiasAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2257LegHisDiasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2257LegHisDiasAnt), 5, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegHisMesesAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegHisMesesAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGHISMESESANT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegHisMesesAnt_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2317LegHisMesesAnt = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2317LegHisMesesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2317LegHisMesesAnt), 4, 0));
            }
            else
            {
               A2317LegHisMesesAnt = (short)(localUtil.ctol( httpContext.cgiGet( edtLegHisMesesAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2317LegHisMesesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2317LegHisMesesAnt), 4, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegHisAniosAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegHisAniosAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGHISANIOSANT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegHisAniosAnt_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2318LegHisAniosAnt = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2318LegHisAniosAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2318LegHisAniosAnt), 4, 0));
            }
            else
            {
               A2318LegHisAniosAnt = (short)(localUtil.ctol( httpContext.cgiGet( edtLegHisAniosAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2318LegHisAniosAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2318LegHisAniosAnt), 4, 0));
            }
            A2319LegHisAntTexto = httpContext.cgiGet( edtLegHisAntTexto_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2319LegHisAntTexto", A2319LegHisAntTexto);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"legajo_permanencia");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("LegHisAntTxtAbr", GXutil.rtrim( localUtil.format( A2331LegHisAntTxtAbr, "")));
            forbiddenHiddens.add("LegHisManual", GXutil.booltostr( A2332LegHisManual));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || !( GXutil.dateCompare(GXutil.resetTime(A2253LegHisFecIng), GXutil.resetTime(Z2253LegHisFecIng)) ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("legajo_permanencia:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A2253LegHisFecIng = localUtil.parseDateParm( httpContext.GetPar( "LegHisFecIng")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2253LegHisFecIng", localUtil.format(A2253LegHisFecIng, "99/99/9999"));
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
                  sMode284 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode284 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound284 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_6G0( ) ;
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
                        e116G2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e126G2 ();
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
         e126G2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll6G284( ) ;
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
         disableAttributes6G284( ) ;
      }
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

   public void confirm_6G0( )
   {
      beforeValidate6G284( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls6G284( ) ;
         }
         else
         {
            checkExtendedTable6G284( ) ;
            closeExtendedTableCursors6G284( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption6G0( )
   {
   }

   public void e116G2( )
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
      AV23ComboLegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboLegNumero), 8, 0));
      edtavCombolegnumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombolegnumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombolegnumero_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
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
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_permanencia_Insert", GXv_boolean3) ;
         legajo_permanencia_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_permanencia_Update", GXv_boolean3) ;
         legajo_permanencia_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_permanencia_Delete", GXv_boolean3) ;
         legajo_permanencia_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV32Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV14TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV32Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV33GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33GXV1), 8, 0));
         while ( AV33GXV1 <= AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV17TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV33GXV1));
            if ( GXutil.strcmp(AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegHisMotCod") == 0 )
            {
               AV28Insert_LegHisMotCod = AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV28Insert_LegHisMotCod", AV28Insert_LegHisMotCod);
            }
            else if ( GXutil.strcmp(AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegHisLiqNro") == 0 )
            {
               AV16Insert_LegHisLiqNro = (int)(GXutil.lval( AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_LegHisLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16Insert_LegHisLiqNro), 8, 0));
            }
            AV33GXV1 = (int)(AV33GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33GXV1), 8, 0));
         }
      }
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtLegHisFecTel_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecTel_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecTel_Visible), 5, 0), true);
      edtLegHisLiqNro_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisLiqNro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisLiqNro_Visible), 5, 0), true);
      edtLegHisDiasAnt_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisDiasAnt_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisDiasAnt_Visible), 5, 0), true);
      edtLegHisMesesAnt_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisMesesAnt_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisMesesAnt_Visible), 5, 0), true);
      edtLegHisAniosAnt_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisAniosAnt_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisAniosAnt_Visible), 5, 0), true);
      edtLegHisAntTexto_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisAntTexto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisAntTexto_Visible), 5, 0), true);
   }

   public void e126G2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) )
      {
         new web.recalcular_permanencias(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, A6LegNumero) ;
      }
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
      /* 'LOADCOMBOLEGNUMERO' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item4 = AV18LegNumero_Data ;
      GXv_char5[0] = AV20ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item6[0] = GXt_objcol_SdtDVB_SDTComboData_Item4 ;
      new web.legajo_permanencialoaddvcombo(remoteHandle, context).execute( "LegNumero", Gx_mode, AV7CliCod, AV8EmpCod, AV9LegNumero, AV10LegHisFecIng, GXv_char5, GXv_objcol_SdtDVB_SDTComboData_Item6) ;
      legajo_permanencia_impl.this.AV20ComboSelectedValue = GXv_char5[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item4 = GXv_objcol_SdtDVB_SDTComboData_Item6[0] ;
      AV18LegNumero_Data = GXt_objcol_SdtDVB_SDTComboData_Item4 ;
      Combo_legnumero_Selectedvalue_set = AV20ComboSelectedValue ;
      ucCombo_legnumero.sendProperty(context, "", false, Combo_legnumero_Internalname, "SelectedValue_set", Combo_legnumero_Selectedvalue_set);
      AV23ComboLegNumero = (int)(GXutil.lval( AV20ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboLegNumero), 8, 0));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (0==AV9LegNumero) )
      {
         Combo_legnumero_Enabled = false ;
         ucCombo_legnumero.sendProperty(context, "", false, Combo_legnumero_Internalname, "Enabled", GXutil.booltostr( Combo_legnumero_Enabled));
      }
   }

   public void zm6G284( int GX_JID )
   {
      if ( ( GX_JID == 35 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2254LegHisFecEgr = T006G3_A2254LegHisFecEgr[0] ;
            Z2255LegHisFecTel = T006G3_A2255LegHisFecTel[0] ;
            Z2257LegHisDiasAnt = T006G3_A2257LegHisDiasAnt[0] ;
            Z2317LegHisMesesAnt = T006G3_A2317LegHisMesesAnt[0] ;
            Z2318LegHisAniosAnt = T006G3_A2318LegHisAniosAnt[0] ;
            Z2331LegHisAntTxtAbr = T006G3_A2331LegHisAntTxtAbr[0] ;
            Z2258LegHisAfecAnt = T006G3_A2258LegHisAfecAnt[0] ;
            Z2332LegHisManual = T006G3_A2332LegHisManual[0] ;
            Z2252LegHisLiqNro = T006G3_A2252LegHisLiqNro[0] ;
            Z2330LegHisMotCod = T006G3_A2330LegHisMotCod[0] ;
         }
         else
         {
            Z2254LegHisFecEgr = A2254LegHisFecEgr ;
            Z2255LegHisFecTel = A2255LegHisFecTel ;
            Z2257LegHisDiasAnt = A2257LegHisDiasAnt ;
            Z2317LegHisMesesAnt = A2317LegHisMesesAnt ;
            Z2318LegHisAniosAnt = A2318LegHisAniosAnt ;
            Z2331LegHisAntTxtAbr = A2331LegHisAntTxtAbr ;
            Z2258LegHisAfecAnt = A2258LegHisAfecAnt ;
            Z2332LegHisManual = A2332LegHisManual ;
            Z2252LegHisLiqNro = A2252LegHisLiqNro ;
            Z2330LegHisMotCod = A2330LegHisMotCod ;
         }
      }
      if ( GX_JID == -35 )
      {
         Z2253LegHisFecIng = A2253LegHisFecIng ;
         Z2254LegHisFecEgr = A2254LegHisFecEgr ;
         Z2255LegHisFecTel = A2255LegHisFecTel ;
         Z2257LegHisDiasAnt = A2257LegHisDiasAnt ;
         Z2317LegHisMesesAnt = A2317LegHisMesesAnt ;
         Z2318LegHisAniosAnt = A2318LegHisAniosAnt ;
         Z2319LegHisAntTexto = A2319LegHisAntTexto ;
         Z2331LegHisAntTxtAbr = A2331LegHisAntTxtAbr ;
         Z2258LegHisAfecAnt = A2258LegHisAfecAnt ;
         Z2332LegHisManual = A2332LegHisManual ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z2252LegHisLiqNro = A2252LegHisLiqNro ;
         Z2330LegHisMotCod = A2330LegHisMotCod ;
         Z2256LegHisMotivo = A2256LegHisMotivo ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaleghismotcod_html6G284( AV7CliCod) ;
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
            legajo_permanencia_impl.this.GXt_int7 = GXv_int8[0] ;
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
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10LegHisFecIng)) )
      {
         A2253LegHisFecIng = AV10LegHisFecIng ;
         httpContext.ajax_rsp_assign_attri("", false, "A2253LegHisFecIng", localUtil.format(A2253LegHisFecIng, "99/99/9999"));
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10LegHisFecIng)) )
      {
         edtLegHisFecIng_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecIng_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecIng_Enabled), 5, 0), true);
      }
      else
      {
         edtLegHisFecIng_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecIng_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecIng_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10LegHisFecIng)) )
      {
         edtLegHisFecIng_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecIng_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecIng_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9LegNumero) )
      {
         A6LegNumero = AV9LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      else
      {
         A6LegNumero = AV23ComboLegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV16Insert_LegHisLiqNro) )
      {
         edtLegHisLiqNro_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegHisLiqNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisLiqNro_Enabled), 5, 0), true);
      }
      else
      {
         edtLegHisLiqNro_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegHisLiqNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisLiqNro_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV16Insert_LegHisLiqNro) )
      {
         A2252LegHisLiqNro = AV16Insert_LegHisLiqNro ;
         n2252LegHisLiqNro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2252LegHisLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2252LegHisLiqNro), 8, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV28Insert_LegHisMotCod)==0) )
      {
         A2330LegHisMotCod = AV28Insert_LegHisMotCod ;
         n2330LegHisMotCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2330LegHisMotCod", A2330LegHisMotCod);
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
      if ( isIns( )  && (false==A2258LegHisAfecAnt) && ( Gx_BScreen == 0 ) )
      {
         A2258LegHisAfecAnt = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A2258LegHisAfecAnt", A2258LegHisAfecAnt);
      }
      if ( isIns( )  && (false==A2332LegHisManual) && ( Gx_BScreen == 0 ) )
      {
         A2332LegHisManual = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A2332LegHisManual", A2332LegHisManual);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         /* Using cursor T006G6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n2330LegHisMotCod), A2330LegHisMotCod});
         A2256LegHisMotivo = T006G6_A2256LegHisMotivo[0] ;
         pr_default.close(4);
         AV32Pgmname = "legajo_permanencia" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32Pgmname", AV32Pgmname);
      }
   }

   public void load6G284( )
   {
      /* Using cursor T006G7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2253LegHisFecIng});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound284 = (short)(1) ;
         A2254LegHisFecEgr = T006G7_A2254LegHisFecEgr[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2254LegHisFecEgr", localUtil.format(A2254LegHisFecEgr, "99/99/9999"));
         A2255LegHisFecTel = T006G7_A2255LegHisFecTel[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2255LegHisFecTel", localUtil.format(A2255LegHisFecTel, "99/99/9999"));
         A2256LegHisMotivo = T006G7_A2256LegHisMotivo[0] ;
         A2257LegHisDiasAnt = T006G7_A2257LegHisDiasAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2257LegHisDiasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2257LegHisDiasAnt), 5, 0));
         A2317LegHisMesesAnt = T006G7_A2317LegHisMesesAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2317LegHisMesesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2317LegHisMesesAnt), 4, 0));
         A2318LegHisAniosAnt = T006G7_A2318LegHisAniosAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2318LegHisAniosAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2318LegHisAniosAnt), 4, 0));
         A2319LegHisAntTexto = T006G7_A2319LegHisAntTexto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2319LegHisAntTexto", A2319LegHisAntTexto);
         A2331LegHisAntTxtAbr = T006G7_A2331LegHisAntTxtAbr[0] ;
         A2258LegHisAfecAnt = T006G7_A2258LegHisAfecAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2258LegHisAfecAnt", A2258LegHisAfecAnt);
         A2332LegHisManual = T006G7_A2332LegHisManual[0] ;
         A2252LegHisLiqNro = T006G7_A2252LegHisLiqNro[0] ;
         n2252LegHisLiqNro = T006G7_n2252LegHisLiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2252LegHisLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2252LegHisLiqNro), 8, 0));
         A2330LegHisMotCod = T006G7_A2330LegHisMotCod[0] ;
         n2330LegHisMotCod = T006G7_n2330LegHisMotCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2330LegHisMotCod", A2330LegHisMotCod);
         zm6G284( -35) ;
      }
      pr_default.close(5);
      onLoadActions6G284( ) ;
   }

   public void onLoadActions6G284( )
   {
      AV32Pgmname = "legajo_permanencia" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32Pgmname", AV32Pgmname);
      if ( ( GXutil.strcmp(sMode284, "INS") == 0 ) && ! (GXutil.strcmp("", AV28Insert_LegHisMotCod)==0) )
      {
         dynLegHisMotCod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynLegHisMotCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegHisMotCod.getEnabled(), 5, 0), true);
      }
      else
      {
         if ( ( GXutil.strcmp(sMode284, httpContext.getMessage( httpContext.getMessage( "UPD", ""), "")) == 0 ) && ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) || ! A2332LegHisManual ) )
         {
            dynLegHisMotCod.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, dynLegHisMotCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegHisMotCod.getEnabled(), 5, 0), true);
         }
         else
         {
            dynLegHisMotCod.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, dynLegHisMotCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegHisMotCod.getEnabled(), 5, 0), true);
         }
      }
      if ( ( GXutil.strcmp(sMode284, httpContext.getMessage( httpContext.getMessage( "UPD", ""), "")) == 0 ) && ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) || ! A2332LegHisManual ) )
      {
         edtLegHisFecEgr_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecEgr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecEgr_Enabled), 5, 0), true);
      }
      else
      {
         edtLegHisFecEgr_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecEgr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecEgr_Enabled), 5, 0), true);
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) )
      {
         edtLegHisFecTel_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecTel_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecTel_Enabled), 5, 0), true);
      }
      else
      {
         edtLegHisFecTel_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecTel_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecTel_Enabled), 5, 0), true);
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) )
      {
         chkLegHisAfecAnt.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkLegHisAfecAnt.getInternalname(), "Enabled", GXutil.ltrimstr( chkLegHisAfecAnt.getEnabled(), 5, 0), true);
      }
      else
      {
         chkLegHisAfecAnt.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkLegHisAfecAnt.getInternalname(), "Enabled", GXutil.ltrimstr( chkLegHisAfecAnt.getEnabled(), 5, 0), true);
      }
   }

   public void checkExtendedTable6G284( )
   {
      nIsDirty_284 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV32Pgmname = "legajo_permanencia" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32Pgmname", AV32Pgmname);
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV28Insert_LegHisMotCod)==0) )
      {
         dynLegHisMotCod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynLegHisMotCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegHisMotCod.getEnabled(), 5, 0), true);
      }
      else
      {
         if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "UPD", ""), "")) == 0 ) && ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) || ! A2332LegHisManual ) )
         {
            dynLegHisMotCod.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, dynLegHisMotCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegHisMotCod.getEnabled(), 5, 0), true);
         }
         else
         {
            dynLegHisMotCod.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, dynLegHisMotCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegHisMotCod.getEnabled(), 5, 0), true);
         }
      }
      /* Using cursor T006G6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n2330LegHisMotCod), A2330LegHisMotCod});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A2330LegHisMotCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Permanencia Motivo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGHISMOTCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A2256LegHisMotivo = T006G6_A2256LegHisMotivo[0] ;
      pr_default.close(4);
      /* Using cursor T006G4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T006G5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2252LegHisLiqNro), Integer.valueOf(A2252LegHisLiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A2252LegHisLiqNro) || (0==A6LegNumero) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(3);
      GXv_boolean3[0] = AV30existe ;
      new web.getpermanenciasolapamiento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, A6LegNumero, A2253LegHisFecIng, A2254LegHisFecEgr, A2253LegHisFecIng, GXv_boolean3) ;
      legajo_permanencia_impl.this.AV30existe = GXv_boolean3[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30existe", AV30existe);
      if ( AV30existe )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "El rango de fechas se solapa con otro periodo de permanencia", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) && (( GXutil.resetTime(A2254LegHisFecEgr).before( GXutil.resetTime( A2253LegHisFecIng )) ) || ( GXutil.dateCompare(GXutil.resetTime(A2254LegHisFecEgr), GXutil.resetTime(A2253LegHisFecIng)) )) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La fecha de egreso debe ser mayor a la fecha de ingreso", ""), 1, "LEGHISFECING");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegHisFecIng_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "UPD", ""), "")) == 0 ) && ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) || ! A2332LegHisManual ) )
      {
         edtLegHisFecEgr_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecEgr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecEgr_Enabled), 5, 0), true);
      }
      else
      {
         edtLegHisFecEgr_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecEgr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecEgr_Enabled), 5, 0), true);
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) )
      {
         edtLegHisFecTel_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecTel_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecTel_Enabled), 5, 0), true);
      }
      else
      {
         edtLegHisFecTel_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecTel_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecTel_Enabled), 5, 0), true);
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) )
      {
         chkLegHisAfecAnt.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkLegHisAfecAnt.getInternalname(), "Enabled", GXutil.ltrimstr( chkLegHisAfecAnt.getEnabled(), 5, 0), true);
      }
      else
      {
         chkLegHisAfecAnt.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkLegHisAfecAnt.getInternalname(), "Enabled", GXutil.ltrimstr( chkLegHisAfecAnt.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Debe ingresar fecha de egreso", ""), 1, "LEGHISFECEGR");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegHisFecEgr_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors6G284( )
   {
      pr_default.close(4);
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_38( int A3CliCod ,
                          String A2330LegHisMotCod )
   {
      /* Using cursor T006G8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n2330LegHisMotCod), A2330LegHisMotCod});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A2330LegHisMotCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Permanencia Motivo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGHISMOTCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A2256LegHisMotivo = T006G8_A2256LegHisMotivo[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A2256LegHisMotivo)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_36( int A3CliCod ,
                          short A1EmpCod ,
                          int A6LegNumero )
   {
      /* Using cursor T006G9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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

   public void gxload_37( int A3CliCod ,
                          short A1EmpCod ,
                          int A2252LegHisLiqNro ,
                          int A6LegNumero )
   {
      /* Using cursor T006G10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2252LegHisLiqNro), Integer.valueOf(A2252LegHisLiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A2252LegHisLiqNro) || (0==A6LegNumero) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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

   public void getKey6G284( )
   {
      /* Using cursor T006G11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2253LegHisFecIng});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound284 = (short)(1) ;
      }
      else
      {
         RcdFound284 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T006G3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2253LegHisFecIng});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm6G284( 35) ;
         RcdFound284 = (short)(1) ;
         A2253LegHisFecIng = T006G3_A2253LegHisFecIng[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2253LegHisFecIng", localUtil.format(A2253LegHisFecIng, "99/99/9999"));
         A2254LegHisFecEgr = T006G3_A2254LegHisFecEgr[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2254LegHisFecEgr", localUtil.format(A2254LegHisFecEgr, "99/99/9999"));
         A2255LegHisFecTel = T006G3_A2255LegHisFecTel[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2255LegHisFecTel", localUtil.format(A2255LegHisFecTel, "99/99/9999"));
         A2257LegHisDiasAnt = T006G3_A2257LegHisDiasAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2257LegHisDiasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2257LegHisDiasAnt), 5, 0));
         A2317LegHisMesesAnt = T006G3_A2317LegHisMesesAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2317LegHisMesesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2317LegHisMesesAnt), 4, 0));
         A2318LegHisAniosAnt = T006G3_A2318LegHisAniosAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2318LegHisAniosAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2318LegHisAniosAnt), 4, 0));
         A2319LegHisAntTexto = T006G3_A2319LegHisAntTexto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2319LegHisAntTexto", A2319LegHisAntTexto);
         A2331LegHisAntTxtAbr = T006G3_A2331LegHisAntTxtAbr[0] ;
         A2258LegHisAfecAnt = T006G3_A2258LegHisAfecAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2258LegHisAfecAnt", A2258LegHisAfecAnt);
         A2332LegHisManual = T006G3_A2332LegHisManual[0] ;
         A3CliCod = T006G3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T006G3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T006G3_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A2252LegHisLiqNro = T006G3_A2252LegHisLiqNro[0] ;
         n2252LegHisLiqNro = T006G3_n2252LegHisLiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2252LegHisLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2252LegHisLiqNro), 8, 0));
         A2330LegHisMotCod = T006G3_A2330LegHisMotCod[0] ;
         n2330LegHisMotCod = T006G3_n2330LegHisMotCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2330LegHisMotCod", A2330LegHisMotCod);
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z2253LegHisFecIng = A2253LegHisFecIng ;
         sMode284 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load6G284( ) ;
         if ( AnyError == 1 )
         {
            RcdFound284 = (short)(0) ;
            initializeNonKey6G284( ) ;
         }
         Gx_mode = sMode284 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound284 = (short)(0) ;
         initializeNonKey6G284( ) ;
         sMode284 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode284 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey6G284( ) ;
      if ( RcdFound284 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound284 = (short)(0) ;
      /* Using cursor T006G12 */
      pr_default.execute(10, new Object[] {A2253LegHisFecIng, A2253LegHisFecIng, Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A2253LegHisFecIng, Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A2253LegHisFecIng, Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( GXutil.resetTime(T006G12_A2253LegHisFecIng[0]).before( GXutil.resetTime( A2253LegHisFecIng )) || GXutil.dateCompare(GXutil.resetTime(T006G12_A2253LegHisFecIng[0]), GXutil.resetTime(A2253LegHisFecIng)) && ( T006G12_A3CliCod[0] < A3CliCod ) || ( T006G12_A3CliCod[0] == A3CliCod ) && GXutil.dateCompare(GXutil.resetTime(T006G12_A2253LegHisFecIng[0]), GXutil.resetTime(A2253LegHisFecIng)) && ( T006G12_A1EmpCod[0] < A1EmpCod ) || ( T006G12_A1EmpCod[0] == A1EmpCod ) && ( T006G12_A3CliCod[0] == A3CliCod ) && GXutil.dateCompare(GXutil.resetTime(T006G12_A2253LegHisFecIng[0]), GXutil.resetTime(A2253LegHisFecIng)) && ( T006G12_A6LegNumero[0] < A6LegNumero ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( GXutil.resetTime(T006G12_A2253LegHisFecIng[0]).after( GXutil.resetTime( A2253LegHisFecIng )) || GXutil.dateCompare(GXutil.resetTime(T006G12_A2253LegHisFecIng[0]), GXutil.resetTime(A2253LegHisFecIng)) && ( T006G12_A3CliCod[0] > A3CliCod ) || ( T006G12_A3CliCod[0] == A3CliCod ) && GXutil.dateCompare(GXutil.resetTime(T006G12_A2253LegHisFecIng[0]), GXutil.resetTime(A2253LegHisFecIng)) && ( T006G12_A1EmpCod[0] > A1EmpCod ) || ( T006G12_A1EmpCod[0] == A1EmpCod ) && ( T006G12_A3CliCod[0] == A3CliCod ) && GXutil.dateCompare(GXutil.resetTime(T006G12_A2253LegHisFecIng[0]), GXutil.resetTime(A2253LegHisFecIng)) && ( T006G12_A6LegNumero[0] > A6LegNumero ) ) )
         {
            A2253LegHisFecIng = T006G12_A2253LegHisFecIng[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2253LegHisFecIng", localUtil.format(A2253LegHisFecIng, "99/99/9999"));
            A3CliCod = T006G12_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T006G12_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T006G12_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            RcdFound284 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound284 = (short)(0) ;
      /* Using cursor T006G13 */
      pr_default.execute(11, new Object[] {A2253LegHisFecIng, A2253LegHisFecIng, Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A2253LegHisFecIng, Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A2253LegHisFecIng, Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( GXutil.resetTime(T006G13_A2253LegHisFecIng[0]).after( GXutil.resetTime( A2253LegHisFecIng )) || GXutil.dateCompare(GXutil.resetTime(T006G13_A2253LegHisFecIng[0]), GXutil.resetTime(A2253LegHisFecIng)) && ( T006G13_A3CliCod[0] > A3CliCod ) || ( T006G13_A3CliCod[0] == A3CliCod ) && GXutil.dateCompare(GXutil.resetTime(T006G13_A2253LegHisFecIng[0]), GXutil.resetTime(A2253LegHisFecIng)) && ( T006G13_A1EmpCod[0] > A1EmpCod ) || ( T006G13_A1EmpCod[0] == A1EmpCod ) && ( T006G13_A3CliCod[0] == A3CliCod ) && GXutil.dateCompare(GXutil.resetTime(T006G13_A2253LegHisFecIng[0]), GXutil.resetTime(A2253LegHisFecIng)) && ( T006G13_A6LegNumero[0] > A6LegNumero ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( GXutil.resetTime(T006G13_A2253LegHisFecIng[0]).before( GXutil.resetTime( A2253LegHisFecIng )) || GXutil.dateCompare(GXutil.resetTime(T006G13_A2253LegHisFecIng[0]), GXutil.resetTime(A2253LegHisFecIng)) && ( T006G13_A3CliCod[0] < A3CliCod ) || ( T006G13_A3CliCod[0] == A3CliCod ) && GXutil.dateCompare(GXutil.resetTime(T006G13_A2253LegHisFecIng[0]), GXutil.resetTime(A2253LegHisFecIng)) && ( T006G13_A1EmpCod[0] < A1EmpCod ) || ( T006G13_A1EmpCod[0] == A1EmpCod ) && ( T006G13_A3CliCod[0] == A3CliCod ) && GXutil.dateCompare(GXutil.resetTime(T006G13_A2253LegHisFecIng[0]), GXutil.resetTime(A2253LegHisFecIng)) && ( T006G13_A6LegNumero[0] < A6LegNumero ) ) )
         {
            A2253LegHisFecIng = T006G13_A2253LegHisFecIng[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2253LegHisFecIng", localUtil.format(A2253LegHisFecIng, "99/99/9999"));
            A3CliCod = T006G13_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T006G13_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T006G13_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            RcdFound284 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey6G284( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtLegNumero_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert6G284( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound284 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || !( GXutil.dateCompare(GXutil.resetTime(A2253LegHisFecIng), GXutil.resetTime(Z2253LegHisFecIng)) ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A6LegNumero = Z6LegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A2253LegHisFecIng = Z2253LegHisFecIng ;
               httpContext.ajax_rsp_assign_attri("", false, "A2253LegHisFecIng", localUtil.format(A2253LegHisFecIng, "99/99/9999"));
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
               update6G284( ) ;
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || !( GXutil.dateCompare(GXutil.resetTime(A2253LegHisFecIng), GXutil.resetTime(Z2253LegHisFecIng)) ) )
            {
               /* Insert record */
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert6G284( ) ;
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
                  insert6G284( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || !( GXutil.dateCompare(GXutil.resetTime(A2253LegHisFecIng), GXutil.resetTime(Z2253LegHisFecIng)) ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = Z6LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A2253LegHisFecIng = Z2253LegHisFecIng ;
         httpContext.ajax_rsp_assign_attri("", false, "A2253LegHisFecIng", localUtil.format(A2253LegHisFecIng, "99/99/9999"));
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

   public void checkOptimisticConcurrency6G284( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T006G2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2253LegHisFecIng});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_permanencia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z2254LegHisFecEgr), GXutil.resetTime(T006G2_A2254LegHisFecEgr[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z2255LegHisFecTel), GXutil.resetTime(T006G2_A2255LegHisFecTel[0])) ) || ( Z2257LegHisDiasAnt != T006G2_A2257LegHisDiasAnt[0] ) || ( Z2317LegHisMesesAnt != T006G2_A2317LegHisMesesAnt[0] ) || ( Z2318LegHisAniosAnt != T006G2_A2318LegHisAniosAnt[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2331LegHisAntTxtAbr, T006G2_A2331LegHisAntTxtAbr[0]) != 0 ) || ( Z2258LegHisAfecAnt != T006G2_A2258LegHisAfecAnt[0] ) || ( Z2332LegHisManual != T006G2_A2332LegHisManual[0] ) || ( Z2252LegHisLiqNro != T006G2_A2252LegHisLiqNro[0] ) || ( GXutil.strcmp(Z2330LegHisMotCod, T006G2_A2330LegHisMotCod[0]) != 0 ) )
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z2254LegHisFecEgr), GXutil.resetTime(T006G2_A2254LegHisFecEgr[0])) ) )
            {
               GXutil.writeLogln("legajo_permanencia:[seudo value changed for attri]"+"LegHisFecEgr");
               GXutil.writeLogRaw("Old: ",Z2254LegHisFecEgr);
               GXutil.writeLogRaw("Current: ",T006G2_A2254LegHisFecEgr[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z2255LegHisFecTel), GXutil.resetTime(T006G2_A2255LegHisFecTel[0])) ) )
            {
               GXutil.writeLogln("legajo_permanencia:[seudo value changed for attri]"+"LegHisFecTel");
               GXutil.writeLogRaw("Old: ",Z2255LegHisFecTel);
               GXutil.writeLogRaw("Current: ",T006G2_A2255LegHisFecTel[0]);
            }
            if ( Z2257LegHisDiasAnt != T006G2_A2257LegHisDiasAnt[0] )
            {
               GXutil.writeLogln("legajo_permanencia:[seudo value changed for attri]"+"LegHisDiasAnt");
               GXutil.writeLogRaw("Old: ",Z2257LegHisDiasAnt);
               GXutil.writeLogRaw("Current: ",T006G2_A2257LegHisDiasAnt[0]);
            }
            if ( Z2317LegHisMesesAnt != T006G2_A2317LegHisMesesAnt[0] )
            {
               GXutil.writeLogln("legajo_permanencia:[seudo value changed for attri]"+"LegHisMesesAnt");
               GXutil.writeLogRaw("Old: ",Z2317LegHisMesesAnt);
               GXutil.writeLogRaw("Current: ",T006G2_A2317LegHisMesesAnt[0]);
            }
            if ( Z2318LegHisAniosAnt != T006G2_A2318LegHisAniosAnt[0] )
            {
               GXutil.writeLogln("legajo_permanencia:[seudo value changed for attri]"+"LegHisAniosAnt");
               GXutil.writeLogRaw("Old: ",Z2318LegHisAniosAnt);
               GXutil.writeLogRaw("Current: ",T006G2_A2318LegHisAniosAnt[0]);
            }
            if ( GXutil.strcmp(Z2331LegHisAntTxtAbr, T006G2_A2331LegHisAntTxtAbr[0]) != 0 )
            {
               GXutil.writeLogln("legajo_permanencia:[seudo value changed for attri]"+"LegHisAntTxtAbr");
               GXutil.writeLogRaw("Old: ",Z2331LegHisAntTxtAbr);
               GXutil.writeLogRaw("Current: ",T006G2_A2331LegHisAntTxtAbr[0]);
            }
            if ( Z2258LegHisAfecAnt != T006G2_A2258LegHisAfecAnt[0] )
            {
               GXutil.writeLogln("legajo_permanencia:[seudo value changed for attri]"+"LegHisAfecAnt");
               GXutil.writeLogRaw("Old: ",Z2258LegHisAfecAnt);
               GXutil.writeLogRaw("Current: ",T006G2_A2258LegHisAfecAnt[0]);
            }
            if ( Z2332LegHisManual != T006G2_A2332LegHisManual[0] )
            {
               GXutil.writeLogln("legajo_permanencia:[seudo value changed for attri]"+"LegHisManual");
               GXutil.writeLogRaw("Old: ",Z2332LegHisManual);
               GXutil.writeLogRaw("Current: ",T006G2_A2332LegHisManual[0]);
            }
            if ( Z2252LegHisLiqNro != T006G2_A2252LegHisLiqNro[0] )
            {
               GXutil.writeLogln("legajo_permanencia:[seudo value changed for attri]"+"LegHisLiqNro");
               GXutil.writeLogRaw("Old: ",Z2252LegHisLiqNro);
               GXutil.writeLogRaw("Current: ",T006G2_A2252LegHisLiqNro[0]);
            }
            if ( GXutil.strcmp(Z2330LegHisMotCod, T006G2_A2330LegHisMotCod[0]) != 0 )
            {
               GXutil.writeLogln("legajo_permanencia:[seudo value changed for attri]"+"LegHisMotCod");
               GXutil.writeLogRaw("Old: ",Z2330LegHisMotCod);
               GXutil.writeLogRaw("Current: ",T006G2_A2330LegHisMotCod[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"legajo_permanencia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert6G284( )
   {
      beforeValidate6G284( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6G284( ) ;
      }
      if ( AnyError == 0 )
      {
         zm6G284( 0) ;
         checkOptimisticConcurrency6G284( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6G284( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert6G284( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006G14 */
                  pr_default.execute(12, new Object[] {A2253LegHisFecIng, A2254LegHisFecEgr, A2255LegHisFecTel, Integer.valueOf(A2257LegHisDiasAnt), Short.valueOf(A2317LegHisMesesAnt), Short.valueOf(A2318LegHisAniosAnt), A2319LegHisAntTexto, A2331LegHisAntTxtAbr, Boolean.valueOf(A2258LegHisAfecAnt), Boolean.valueOf(A2332LegHisManual), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Boolean.valueOf(n2252LegHisLiqNro), Integer.valueOf(A2252LegHisLiqNro), Boolean.valueOf(n2330LegHisMotCod), A2330LegHisMotCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_permanencia");
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
                        resetCaption6G0( ) ;
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
            load6G284( ) ;
         }
         endLevel6G284( ) ;
      }
      closeExtendedTableCursors6G284( ) ;
   }

   public void update6G284( )
   {
      beforeValidate6G284( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6G284( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6G284( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6G284( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate6G284( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006G15 */
                  pr_default.execute(13, new Object[] {A2254LegHisFecEgr, A2255LegHisFecTel, Integer.valueOf(A2257LegHisDiasAnt), Short.valueOf(A2317LegHisMesesAnt), Short.valueOf(A2318LegHisAniosAnt), A2319LegHisAntTexto, A2331LegHisAntTxtAbr, Boolean.valueOf(A2258LegHisAfecAnt), Boolean.valueOf(A2332LegHisManual), Boolean.valueOf(n2252LegHisLiqNro), Integer.valueOf(A2252LegHisLiqNro), Boolean.valueOf(n2330LegHisMotCod), A2330LegHisMotCod, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2253LegHisFecIng});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_permanencia");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_permanencia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate6G284( ) ;
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
         endLevel6G284( ) ;
      }
      closeExtendedTableCursors6G284( ) ;
   }

   public void deferredUpdate6G284( )
   {
   }

   public void delete( )
   {
      beforeValidate6G284( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6G284( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls6G284( ) ;
         afterConfirm6G284( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete6G284( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T006G16 */
               pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2253LegHisFecIng});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_permanencia");
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
      sMode284 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel6G284( ) ;
      Gx_mode = sMode284 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls6G284( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV32Pgmname = "legajo_permanencia" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32Pgmname", AV32Pgmname);
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) )
         {
            edtLegHisFecTel_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecTel_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecTel_Enabled), 5, 0), true);
         }
         else
         {
            edtLegHisFecTel_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecTel_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecTel_Enabled), 5, 0), true);
         }
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) )
         {
            chkLegHisAfecAnt.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, chkLegHisAfecAnt.getInternalname(), "Enabled", GXutil.ltrimstr( chkLegHisAfecAnt.getEnabled(), 5, 0), true);
         }
         else
         {
            chkLegHisAfecAnt.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, chkLegHisAfecAnt.getInternalname(), "Enabled", GXutil.ltrimstr( chkLegHisAfecAnt.getEnabled(), 5, 0), true);
         }
         /* Using cursor T006G17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n2330LegHisMotCod), A2330LegHisMotCod});
         A2256LegHisMotivo = T006G17_A2256LegHisMotivo[0] ;
         pr_default.close(15);
         if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV28Insert_LegHisMotCod)==0) )
         {
            dynLegHisMotCod.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, dynLegHisMotCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegHisMotCod.getEnabled(), 5, 0), true);
         }
         else
         {
            if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "UPD", ""), "")) == 0 ) && ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) || ! A2332LegHisManual ) )
            {
               dynLegHisMotCod.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, dynLegHisMotCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegHisMotCod.getEnabled(), 5, 0), true);
            }
            else
            {
               dynLegHisMotCod.setEnabled( 1 );
               httpContext.ajax_rsp_assign_prop("", false, dynLegHisMotCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegHisMotCod.getEnabled(), 5, 0), true);
            }
         }
         if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "UPD", ""), "")) == 0 ) && ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) || ! A2332LegHisManual ) )
         {
            edtLegHisFecEgr_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecEgr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecEgr_Enabled), 5, 0), true);
         }
         else
         {
            edtLegHisFecEgr_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecEgr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecEgr_Enabled), 5, 0), true);
         }
      }
   }

   public void endLevel6G284( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete6G284( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "legajo_permanencia");
         if ( AnyError == 0 )
         {
            confirmValues6G0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "legajo_permanencia");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart6G284( )
   {
      /* Scan By routine */
      /* Using cursor T006G18 */
      pr_default.execute(16);
      RcdFound284 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound284 = (short)(1) ;
         A3CliCod = T006G18_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T006G18_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T006G18_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A2253LegHisFecIng = T006G18_A2253LegHisFecIng[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2253LegHisFecIng", localUtil.format(A2253LegHisFecIng, "99/99/9999"));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext6G284( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound284 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound284 = (short)(1) ;
         A3CliCod = T006G18_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T006G18_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T006G18_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A2253LegHisFecIng = T006G18_A2253LegHisFecIng[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2253LegHisFecIng", localUtil.format(A2253LegHisFecIng, "99/99/9999"));
      }
   }

   public void scanEnd6G284( )
   {
      pr_default.close(16);
   }

   public void afterConfirm6G284( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert6G284( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate6G284( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete6G284( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete6G284( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate6G284( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes6G284( )
   {
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      edtLegHisFecIng_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecIng_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecIng_Enabled), 5, 0), true);
      edtLegHisFecEgr_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecEgr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecEgr_Enabled), 5, 0), true);
      dynLegHisMotCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynLegHisMotCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynLegHisMotCod.getEnabled(), 5, 0), true);
      chkLegHisAfecAnt.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkLegHisAfecAnt.getInternalname(), "Enabled", GXutil.ltrimstr( chkLegHisAfecAnt.getEnabled(), 5, 0), true);
      edtavCombolegnumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombolegnumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombolegnumero_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLegHisFecTel_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecTel_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecTel_Enabled), 5, 0), true);
      edtLegHisLiqNro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisLiqNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisLiqNro_Enabled), 5, 0), true);
      edtLegHisDiasAnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisDiasAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisDiasAnt_Enabled), 5, 0), true);
      edtLegHisMesesAnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisMesesAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisMesesAnt_Enabled), 5, 0), true);
      edtLegHisAniosAnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisAniosAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisAniosAnt_Enabled), 5, 0), true);
      edtLegHisAntTexto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisAntTexto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisAntTexto_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes6G284( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues6G0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.legajo_permanencia", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LegNumero,8,0)),GXutil.URLEncode(GXutil.formatDateParm(AV10LegHisFecIng))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero","LegHisFecIng"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"legajo_permanencia");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("LegHisAntTxtAbr", GXutil.rtrim( localUtil.format( A2331LegHisAntTxtAbr, "")));
      forbiddenHiddens.add("LegHisManual", GXutil.booltostr( A2332LegHisManual));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("legajo_permanencia:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2253LegHisFecIng", localUtil.dtoc( Z2253LegHisFecIng, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2254LegHisFecEgr", localUtil.dtoc( Z2254LegHisFecEgr, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2255LegHisFecTel", localUtil.dtoc( Z2255LegHisFecTel, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2257LegHisDiasAnt", GXutil.ltrim( localUtil.ntoc( Z2257LegHisDiasAnt, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2317LegHisMesesAnt", GXutil.ltrim( localUtil.ntoc( Z2317LegHisMesesAnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2318LegHisAniosAnt", GXutil.ltrim( localUtil.ntoc( Z2318LegHisAniosAnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2331LegHisAntTxtAbr", Z2331LegHisAntTxtAbr);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2258LegHisAfecAnt", Z2258LegHisAfecAnt);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2332LegHisManual", Z2332LegHisManual);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2252LegHisLiqNro", GXutil.ltrim( localUtil.ntoc( Z2252LegHisLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2330LegHisMotCod", GXutil.rtrim( Z2330LegHisMotCod));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N2330LegHisMotCod", GXutil.rtrim( A2330LegHisMotCod));
      web.GxWebStd.gx_hidden_field( httpContext, "N2252LegHisLiqNro", GXutil.ltrim( localUtil.ntoc( A2252LegHisLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N2254LegHisFecEgr", localUtil.dtoc( A2254LegHisFecEgr, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "N2255LegHisFecTel", localUtil.dtoc( A2255LegHisFecTel, 0, "/"));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "N2258LegHisAfecAnt", A2258LegHisAfecAnt);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGNUMERO_DATA", AV18LegNumero_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGNUMERO_DATA", AV18LegNumero_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV9LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGHISFECING", localUtil.dtoc( AV10LegHisFecIng, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGHISFECING", getSecureSignedToken( "", AV10LegHisFecIng));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_LEGHISMOTCOD", GXutil.rtrim( AV28Insert_LegHisMotCod));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "LEGHISMANUAL", A2332LegHisManual);
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_LEGHISLIQNRO", GXutil.ltrim( localUtil.ntoc( AV16Insert_LegHisLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vEXISTE", AV30existe);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGHISANTTXTABR", A2331LegHisAntTxtAbr);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGHISMOTIVO", A2256LegHisMotivo);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV32Pgmname));
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
      return formatLink("web.legajo_permanencia", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LegNumero,8,0)),GXutil.URLEncode(GXutil.formatDateParm(AV10LegHisFecIng))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero","LegHisFecIng"})  ;
   }

   public String getPgmname( )
   {
      return "legajo_permanencia" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "legajo_permanencia", "") ;
   }

   public void initializeNonKey6G284( )
   {
      A31LiqNro = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
      A2330LegHisMotCod = "" ;
      n2330LegHisMotCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2330LegHisMotCod", A2330LegHisMotCod);
      n2330LegHisMotCod = ((GXutil.strcmp("", A2330LegHisMotCod)==0) ? true : false) ;
      A2252LegHisLiqNro = 0 ;
      n2252LegHisLiqNro = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2252LegHisLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2252LegHisLiqNro), 8, 0));
      n2252LegHisLiqNro = ((0==A2252LegHisLiqNro) ? true : false) ;
      AV30existe = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30existe", AV30existe);
      A2254LegHisFecEgr = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A2254LegHisFecEgr", localUtil.format(A2254LegHisFecEgr, "99/99/9999"));
      A2255LegHisFecTel = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A2255LegHisFecTel", localUtil.format(A2255LegHisFecTel, "99/99/9999"));
      A2256LegHisMotivo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2256LegHisMotivo", A2256LegHisMotivo);
      A2257LegHisDiasAnt = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2257LegHisDiasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2257LegHisDiasAnt), 5, 0));
      A2317LegHisMesesAnt = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2317LegHisMesesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2317LegHisMesesAnt), 4, 0));
      A2318LegHisAniosAnt = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2318LegHisAniosAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2318LegHisAniosAnt), 4, 0));
      A2319LegHisAntTexto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2319LegHisAntTexto", A2319LegHisAntTexto);
      A2331LegHisAntTxtAbr = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2331LegHisAntTxtAbr", A2331LegHisAntTxtAbr);
      A2258LegHisAfecAnt = true ;
      httpContext.ajax_rsp_assign_attri("", false, "A2258LegHisAfecAnt", A2258LegHisAfecAnt);
      A2332LegHisManual = true ;
      httpContext.ajax_rsp_assign_attri("", false, "A2332LegHisManual", A2332LegHisManual);
      Z2254LegHisFecEgr = GXutil.nullDate() ;
      Z2255LegHisFecTel = GXutil.nullDate() ;
      Z2257LegHisDiasAnt = 0 ;
      Z2317LegHisMesesAnt = (short)(0) ;
      Z2318LegHisAniosAnt = (short)(0) ;
      Z2331LegHisAntTxtAbr = "" ;
      Z2258LegHisAfecAnt = false ;
      Z2332LegHisManual = false ;
      Z2252LegHisLiqNro = 0 ;
      Z2330LegHisMotCod = "" ;
   }

   public void initAll6G284( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      A2253LegHisFecIng = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A2253LegHisFecIng", localUtil.format(A2253LegHisFecIng, "99/99/9999"));
      initializeNonKey6G284( ) ;
   }

   public void standaloneModalInsert( )
   {
      A2258LegHisAfecAnt = i2258LegHisAfecAnt ;
      httpContext.ajax_rsp_assign_attri("", false, "A2258LegHisAfecAnt", A2258LegHisAfecAnt);
      A2332LegHisManual = i2332LegHisManual ;
      httpContext.ajax_rsp_assign_attri("", false, "A2332LegHisManual", A2332LegHisManual);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713495163", true, true);
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
      httpContext.AddJavascriptSource("legajo_permanencia.js", "?20251713495164", false, true);
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
      edtLegHisFecIng_Internalname = "LEGHISFECING" ;
      edtLegHisFecEgr_Internalname = "LEGHISFECEGR" ;
      dynLegHisMotCod.setInternalname( "LEGHISMOTCOD" );
      chkLegHisAfecAnt.setInternalname( "LEGHISAFECANT" );
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
      edtLegHisFecTel_Internalname = "LEGHISFECTEL" ;
      edtLegHisLiqNro_Internalname = "LEGHISLIQNRO" ;
      edtLegHisDiasAnt_Internalname = "LEGHISDIASANT" ;
      edtLegHisMesesAnt_Internalname = "LEGHISMESESANT" ;
      edtLegHisAniosAnt_Internalname = "LEGHISANIOSANT" ;
      edtLegHisAntTexto_Internalname = "LEGHISANTTEXTO" ;
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
      Form.setCaption( httpContext.getMessage( "legajo_permanencia", "") );
      edtLegHisAntTexto_Enabled = 1 ;
      edtLegHisAntTexto_Visible = 1 ;
      edtLegHisAniosAnt_Jsonclick = "" ;
      edtLegHisAniosAnt_Enabled = 1 ;
      edtLegHisAniosAnt_Visible = 1 ;
      edtLegHisMesesAnt_Jsonclick = "" ;
      edtLegHisMesesAnt_Enabled = 1 ;
      edtLegHisMesesAnt_Visible = 1 ;
      edtLegHisDiasAnt_Jsonclick = "" ;
      edtLegHisDiasAnt_Enabled = 1 ;
      edtLegHisDiasAnt_Visible = 1 ;
      edtLegHisLiqNro_Jsonclick = "" ;
      edtLegHisLiqNro_Enabled = 1 ;
      edtLegHisLiqNro_Visible = 1 ;
      edtLegHisFecTel_Jsonclick = "" ;
      edtLegHisFecTel_Enabled = 1 ;
      edtLegHisFecTel_Visible = 1 ;
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
      chkLegHisAfecAnt.setEnabled( 1 );
      dynLegHisMotCod.setJsonclick( "" );
      dynLegHisMotCod.setEnabled( 1 );
      edtLegHisFecEgr_Jsonclick = "" ;
      edtLegHisFecEgr_Enabled = 1 ;
      edtLegHisFecIng_Jsonclick = "" ;
      edtLegHisFecIng_Enabled = 1 ;
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

   public void gxdlaleghismotcod6G284( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaleghismotcod_data6G284( AV7CliCod) ;
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

   public void gxaleghismotcod_html6G284( int AV7CliCod )
   {
      String gxdynajaxvalue;
      gxdlaleghismotcod_data6G284( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynLegHisMotCod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynLegHisMotCod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaleghismotcod_data6G284( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T006G19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(17) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T006G19_A11MegCodigo[0]));
         gxdynajaxctrldescr.add(T006G19_A300MegDescrip[0]);
         pr_default.readNext(17);
      }
      pr_default.close(17);
   }

   public void gx3asaclicod6G284( int AV7CliCod )
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
            legajo_permanencia_impl.this.GXt_int7 = GXv_int8[0] ;
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

   public void xc_32_6G284( int AV7CliCod ,
                            short AV8EmpCod ,
                            int A6LegNumero ,
                            java.util.Date A2253LegHisFecIng ,
                            java.util.Date A2254LegHisFecEgr )
   {
      GXv_boolean3[0] = AV30existe ;
      new web.getpermanenciasolapamiento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, A6LegNumero, A2253LegHisFecIng, A2254LegHisFecEgr, A2253LegHisFecIng, GXv_boolean3) ;
      AV30existe = GXv_boolean3[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30existe", AV30existe);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV30existe))+"\"") ;
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
      dynLegHisMotCod.setName( "LEGHISMOTCOD" );
      dynLegHisMotCod.setWebtags( "" );
      chkLegHisAfecAnt.setName( "LEGHISAFECANT" );
      chkLegHisAfecAnt.setWebtags( "" );
      chkLegHisAfecAnt.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkLegHisAfecAnt.getInternalname(), "TitleCaption", chkLegHisAfecAnt.getCaption(), true);
      chkLegHisAfecAnt.setCheckedValue( "false" );
      if ( isIns( ) && (false==A2258LegHisAfecAnt) )
      {
         A2258LegHisAfecAnt = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A2258LegHisAfecAnt", A2258LegHisAfecAnt);
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

   public void valid_Empcod( )
   {
      n2330LegHisMotCod = false ;
      A2330LegHisMotCod = dynLegHisMotCod.getValue() ;
      n2330LegHisMotCod = false ;
      /* Using cursor T006G20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(18);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Leghisfecegr( )
   {
      n2330LegHisMotCod = false ;
      A2330LegHisMotCod = dynLegHisMotCod.getValue() ;
      n2330LegHisMotCod = false ;
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) )
      {
         edtLegHisFecTel_Enabled = 0 ;
      }
      else
      {
         edtLegHisFecTel_Enabled = 1 ;
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) )
      {
         chkLegHisAfecAnt.setEnabled( 0 );
      }
      else
      {
         chkLegHisAfecAnt.setEnabled( 1 );
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Debe ingresar fecha de egreso", ""), 1, "LEGHISFECEGR");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegHisFecEgr_Internalname ;
      }
      GXv_boolean3[0] = AV30existe ;
      new web.getpermanenciasolapamiento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, A6LegNumero, A2253LegHisFecIng, A2254LegHisFecEgr, A2253LegHisFecIng, GXv_boolean3) ;
      legajo_permanencia_impl.this.AV30existe = GXv_boolean3[0] ;
      AV30existe = this.AV30existe ;
      if ( AV30existe )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "El rango de fechas se solapa con otro periodo de permanencia", ""), 1, "LEGHISFECEGR");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegHisFecEgr_Internalname ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) && (( GXutil.resetTime(A2254LegHisFecEgr).before( GXutil.resetTime( A2253LegHisFecIng )) ) || ( GXutil.dateCompare(GXutil.resetTime(A2254LegHisFecEgr), GXutil.resetTime(A2253LegHisFecIng)) )) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La fecha de egreso debe ser mayor a la fecha de ingreso", ""), 1, "LEGHISFECEGR");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegHisFecEgr_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_prop("", false, edtLegHisFecTel_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegHisFecTel_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, chkLegHisAfecAnt.getInternalname(), "Enabled", GXutil.ltrimstr( chkLegHisAfecAnt.getEnabled(), 5, 0), true);
      httpContext.ajax_rsp_assign_attri("", false, "AV30existe", AV30existe);
   }

   public void valid_Leghismotcod( )
   {
      n2330LegHisMotCod = false ;
      A2330LegHisMotCod = dynLegHisMotCod.getValue() ;
      n2330LegHisMotCod = false ;
      /* Using cursor T006G21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n2330LegHisMotCod), A2330LegHisMotCod});
      if ( (pr_default.getStatus(19) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A2330LegHisMotCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Permanencia Motivo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGHISMOTCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      A2256LegHisMotivo = T006G21_A2256LegHisMotivo[0] ;
      pr_default.close(19);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A2256LegHisMotivo", A2256LegHisMotivo);
   }

   public void valid_Leghisliqnro( )
   {
      n2252LegHisLiqNro = false ;
      n2330LegHisMotCod = false ;
      A2330LegHisMotCod = dynLegHisMotCod.getValue() ;
      n2330LegHisMotCod = false ;
      /* Using cursor T006G22 */
      pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2252LegHisLiqNro), Integer.valueOf(A2252LegHisLiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(20) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A2252LegHisLiqNro) || (0==A6LegNumero) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(20);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LegHisFecIng',fld:'vLEGHISFECING',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LegHisFecIng',fld:'vLEGHISFECING',pic:'',hsh:true},{av:'A2331LegHisAntTxtAbr',fld:'LEGHISANTTXTABR',pic:''},{av:'A2332LegHisManual',fld:'LEGHISMANUAL',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e126G2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]}");
      setEventMetadata("VALID_LEGHISFECING","{handler:'valid_Leghisfecing',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]");
      setEventMetadata("VALID_LEGHISFECING",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]}");
      setEventMetadata("VALID_LEGHISFECEGR","{handler:'valid_Leghisfecegr',iparms:[{av:'A2254LegHisFecEgr',fld:'LEGHISFECEGR',pic:''},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A2253LegHisFecIng',fld:'LEGHISFECING',pic:''},{av:'AV30existe',fld:'vEXISTE',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]");
      setEventMetadata("VALID_LEGHISFECEGR",",oparms:[{av:'edtLegHisFecTel_Enabled',ctrl:'LEGHISFECTEL',prop:'Enabled'},{av:'chkLegHisAfecAnt.getEnabled()',ctrl:'LEGHISAFECANT',prop:'Enabled'},{av:'AV30existe',fld:'vEXISTE',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]}");
      setEventMetadata("VALID_LEGHISMOTCOD","{handler:'valid_Leghismotcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A2256LegHisMotivo',fld:'LEGHISMOTIVO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]");
      setEventMetadata("VALID_LEGHISMOTCOD",",oparms:[{av:'A2256LegHisMotivo',fld:'LEGHISMOTIVO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]}");
      setEventMetadata("VALIDV_COMBOLEGNUMERO","{handler:'validv_Combolegnumero',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]");
      setEventMetadata("VALIDV_COMBOLEGNUMERO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]}");
      setEventMetadata("VALID_LEGHISLIQNRO","{handler:'valid_Leghisliqnro',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A2252LegHisLiqNro',fld:'LEGHISLIQNRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]");
      setEventMetadata("VALID_LEGHISLIQNRO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynLegHisMotCod'},{av:'A2330LegHisMotCod',fld:'LEGHISMOTCOD',pic:''},{av:'A2258LegHisAfecAnt',fld:'LEGHISAFECANT',pic:''}]}");
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
      pr_default.close(18);
      pr_default.close(20);
      pr_default.close(19);
      pr_default.close(15);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV10LegHisFecIng = GXutil.nullDate() ;
      Z2253LegHisFecIng = GXutil.nullDate() ;
      Z2254LegHisFecEgr = GXutil.nullDate() ;
      Z2255LegHisFecTel = GXutil.nullDate() ;
      Z2331LegHisAntTxtAbr = "" ;
      Z2330LegHisMotCod = "" ;
      N2330LegHisMotCod = "" ;
      N2254LegHisFecEgr = GXutil.nullDate() ;
      N2255LegHisFecTel = GXutil.nullDate() ;
      Combo_legnumero_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A2253LegHisFecIng = GXutil.nullDate() ;
      A2254LegHisFecEgr = GXutil.nullDate() ;
      A2330LegHisMotCod = "" ;
      Gx_mode = "" ;
      AV10LegHisFecIng = GXutil.nullDate() ;
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
      AV18LegNumero_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A2255LegHisFecTel = GXutil.nullDate() ;
      A2319LegHisAntTexto = "" ;
      A2331LegHisAntTxtAbr = "" ;
      AV28Insert_LegHisMotCod = "" ;
      A2256LegHisMotivo = "" ;
      AV32Pgmname = "" ;
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
      sMode284 = "" ;
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
      AV17TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      GXt_objcol_SdtDVB_SDTComboData_Item4 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV20ComboSelectedValue = "" ;
      GXv_char5 = new String[1] ;
      GXv_objcol_SdtDVB_SDTComboData_Item6 = new GXBaseCollection[1] ;
      Z2319LegHisAntTexto = "" ;
      Z2256LegHisMotivo = "" ;
      T006G6_A2256LegHisMotivo = new String[] {""} ;
      T006G7_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      T006G7_A2254LegHisFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      T006G7_A2255LegHisFecTel = new java.util.Date[] {GXutil.nullDate()} ;
      T006G7_A2256LegHisMotivo = new String[] {""} ;
      T006G7_A2257LegHisDiasAnt = new int[1] ;
      T006G7_A2317LegHisMesesAnt = new short[1] ;
      T006G7_A2318LegHisAniosAnt = new short[1] ;
      T006G7_A2319LegHisAntTexto = new String[] {""} ;
      T006G7_A2331LegHisAntTxtAbr = new String[] {""} ;
      T006G7_A2258LegHisAfecAnt = new boolean[] {false} ;
      T006G7_A2332LegHisManual = new boolean[] {false} ;
      T006G7_A3CliCod = new int[1] ;
      T006G7_A1EmpCod = new short[1] ;
      T006G7_A6LegNumero = new int[1] ;
      T006G7_A2252LegHisLiqNro = new int[1] ;
      T006G7_n2252LegHisLiqNro = new boolean[] {false} ;
      T006G7_A2330LegHisMotCod = new String[] {""} ;
      T006G7_n2330LegHisMotCod = new boolean[] {false} ;
      T006G4_A3CliCod = new int[1] ;
      T006G5_A31LiqNro = new int[1] ;
      T006G8_A2256LegHisMotivo = new String[] {""} ;
      T006G9_A3CliCod = new int[1] ;
      T006G10_A31LiqNro = new int[1] ;
      T006G11_A3CliCod = new int[1] ;
      T006G11_A1EmpCod = new short[1] ;
      T006G11_A6LegNumero = new int[1] ;
      T006G11_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      T006G3_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      T006G3_A2254LegHisFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      T006G3_A2255LegHisFecTel = new java.util.Date[] {GXutil.nullDate()} ;
      T006G3_A2257LegHisDiasAnt = new int[1] ;
      T006G3_A2317LegHisMesesAnt = new short[1] ;
      T006G3_A2318LegHisAniosAnt = new short[1] ;
      T006G3_A2319LegHisAntTexto = new String[] {""} ;
      T006G3_A2331LegHisAntTxtAbr = new String[] {""} ;
      T006G3_A2258LegHisAfecAnt = new boolean[] {false} ;
      T006G3_A2332LegHisManual = new boolean[] {false} ;
      T006G3_A3CliCod = new int[1] ;
      T006G3_A1EmpCod = new short[1] ;
      T006G3_A6LegNumero = new int[1] ;
      T006G3_A2252LegHisLiqNro = new int[1] ;
      T006G3_n2252LegHisLiqNro = new boolean[] {false} ;
      T006G3_A2330LegHisMotCod = new String[] {""} ;
      T006G3_n2330LegHisMotCod = new boolean[] {false} ;
      T006G12_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      T006G12_A3CliCod = new int[1] ;
      T006G12_A1EmpCod = new short[1] ;
      T006G12_A6LegNumero = new int[1] ;
      T006G13_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      T006G13_A3CliCod = new int[1] ;
      T006G13_A1EmpCod = new short[1] ;
      T006G13_A6LegNumero = new int[1] ;
      T006G2_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      T006G2_A2254LegHisFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      T006G2_A2255LegHisFecTel = new java.util.Date[] {GXutil.nullDate()} ;
      T006G2_A2257LegHisDiasAnt = new int[1] ;
      T006G2_A2317LegHisMesesAnt = new short[1] ;
      T006G2_A2318LegHisAniosAnt = new short[1] ;
      T006G2_A2319LegHisAntTexto = new String[] {""} ;
      T006G2_A2331LegHisAntTxtAbr = new String[] {""} ;
      T006G2_A2258LegHisAfecAnt = new boolean[] {false} ;
      T006G2_A2332LegHisManual = new boolean[] {false} ;
      T006G2_A3CliCod = new int[1] ;
      T006G2_A1EmpCod = new short[1] ;
      T006G2_A6LegNumero = new int[1] ;
      T006G2_A2252LegHisLiqNro = new int[1] ;
      T006G2_n2252LegHisLiqNro = new boolean[] {false} ;
      T006G2_A2330LegHisMotCod = new String[] {""} ;
      T006G2_n2330LegHisMotCod = new boolean[] {false} ;
      T006G17_A2256LegHisMotivo = new String[] {""} ;
      T006G18_A3CliCod = new int[1] ;
      T006G18_A1EmpCod = new short[1] ;
      T006G18_A6LegNumero = new int[1] ;
      T006G18_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T006G19_A3CliCod = new int[1] ;
      T006G19_A11MegCodigo = new String[] {""} ;
      T006G19_A300MegDescrip = new String[] {""} ;
      GXv_int8 = new int[1] ;
      T006G20_A3CliCod = new int[1] ;
      GXv_boolean3 = new boolean[1] ;
      T006G21_A2256LegHisMotivo = new String[] {""} ;
      T006G22_A31LiqNro = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_permanencia__default(),
         new Object[] {
             new Object[] {
            T006G2_A2253LegHisFecIng, T006G2_A2254LegHisFecEgr, T006G2_A2255LegHisFecTel, T006G2_A2257LegHisDiasAnt, T006G2_A2317LegHisMesesAnt, T006G2_A2318LegHisAniosAnt, T006G2_A2319LegHisAntTexto, T006G2_A2331LegHisAntTxtAbr, T006G2_A2258LegHisAfecAnt, T006G2_A2332LegHisManual,
            T006G2_A3CliCod, T006G2_A1EmpCod, T006G2_A6LegNumero, T006G2_A2252LegHisLiqNro, T006G2_n2252LegHisLiqNro, T006G2_A2330LegHisMotCod, T006G2_n2330LegHisMotCod
            }
            , new Object[] {
            T006G3_A2253LegHisFecIng, T006G3_A2254LegHisFecEgr, T006G3_A2255LegHisFecTel, T006G3_A2257LegHisDiasAnt, T006G3_A2317LegHisMesesAnt, T006G3_A2318LegHisAniosAnt, T006G3_A2319LegHisAntTexto, T006G3_A2331LegHisAntTxtAbr, T006G3_A2258LegHisAfecAnt, T006G3_A2332LegHisManual,
            T006G3_A3CliCod, T006G3_A1EmpCod, T006G3_A6LegNumero, T006G3_A2252LegHisLiqNro, T006G3_n2252LegHisLiqNro, T006G3_A2330LegHisMotCod, T006G3_n2330LegHisMotCod
            }
            , new Object[] {
            T006G4_A3CliCod
            }
            , new Object[] {
            T006G5_A31LiqNro
            }
            , new Object[] {
            T006G6_A2256LegHisMotivo
            }
            , new Object[] {
            T006G7_A2253LegHisFecIng, T006G7_A2254LegHisFecEgr, T006G7_A2255LegHisFecTel, T006G7_A2256LegHisMotivo, T006G7_A2257LegHisDiasAnt, T006G7_A2317LegHisMesesAnt, T006G7_A2318LegHisAniosAnt, T006G7_A2319LegHisAntTexto, T006G7_A2331LegHisAntTxtAbr, T006G7_A2258LegHisAfecAnt,
            T006G7_A2332LegHisManual, T006G7_A3CliCod, T006G7_A1EmpCod, T006G7_A6LegNumero, T006G7_A2252LegHisLiqNro, T006G7_n2252LegHisLiqNro, T006G7_A2330LegHisMotCod, T006G7_n2330LegHisMotCod
            }
            , new Object[] {
            T006G8_A2256LegHisMotivo
            }
            , new Object[] {
            T006G9_A3CliCod
            }
            , new Object[] {
            T006G10_A31LiqNro
            }
            , new Object[] {
            T006G11_A3CliCod, T006G11_A1EmpCod, T006G11_A6LegNumero, T006G11_A2253LegHisFecIng
            }
            , new Object[] {
            T006G12_A2253LegHisFecIng, T006G12_A3CliCod, T006G12_A1EmpCod, T006G12_A6LegNumero
            }
            , new Object[] {
            T006G13_A2253LegHisFecIng, T006G13_A3CliCod, T006G13_A1EmpCod, T006G13_A6LegNumero
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006G17_A2256LegHisMotivo
            }
            , new Object[] {
            T006G18_A3CliCod, T006G18_A1EmpCod, T006G18_A6LegNumero, T006G18_A2253LegHisFecIng
            }
            , new Object[] {
            T006G19_A3CliCod, T006G19_A11MegCodigo, T006G19_A300MegDescrip
            }
            , new Object[] {
            T006G20_A3CliCod
            }
            , new Object[] {
            T006G21_A2256LegHisMotivo
            }
            , new Object[] {
            T006G22_A31LiqNro
            }
         }
      );
      AV32Pgmname = "legajo_permanencia" ;
      Z2332LegHisManual = true ;
      A2332LegHisManual = true ;
      i2332LegHisManual = true ;
      Z2258LegHisAfecAnt = true ;
      N2258LegHisAfecAnt = true ;
      A2258LegHisAfecAnt = true ;
      i2258LegHisAfecAnt = true ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8EmpCod ;
   private short Z1EmpCod ;
   private short Z2317LegHisMesesAnt ;
   private short Z2318LegHisAniosAnt ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A2317LegHisMesesAnt ;
   private short A2318LegHisAniosAnt ;
   private short RcdFound284 ;
   private short nIsDirty_284 ;
   private int wcpOAV7CliCod ;
   private int wcpOAV9LegNumero ;
   private int Z3CliCod ;
   private int Z6LegNumero ;
   private int Z2257LegHisDiasAnt ;
   private int Z2252LegHisLiqNro ;
   private int N2252LegHisLiqNro ;
   private int AV7CliCod ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A2252LegHisLiqNro ;
   private int AV9LegNumero ;
   private int trnEnded ;
   private int edtLegNumero_Visible ;
   private int edtLegNumero_Enabled ;
   private int edtLegHisFecIng_Enabled ;
   private int edtLegHisFecEgr_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int AV23ComboLegNumero ;
   private int edtavCombolegnumero_Enabled ;
   private int edtavCombolegnumero_Visible ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int edtLegHisFecTel_Visible ;
   private int edtLegHisFecTel_Enabled ;
   private int edtLegHisLiqNro_Visible ;
   private int edtLegHisLiqNro_Enabled ;
   private int A2257LegHisDiasAnt ;
   private int edtLegHisDiasAnt_Enabled ;
   private int edtLegHisDiasAnt_Visible ;
   private int edtLegHisMesesAnt_Enabled ;
   private int edtLegHisMesesAnt_Visible ;
   private int edtLegHisAniosAnt_Enabled ;
   private int edtLegHisAniosAnt_Visible ;
   private int edtLegHisAntTexto_Visible ;
   private int edtLegHisAntTexto_Enabled ;
   private int AV16Insert_LegHisLiqNro ;
   private int Combo_legnumero_Datalistupdateminimumcharacters ;
   private int Combo_legnumero_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV33GXV1 ;
   private int GX_JID ;
   private int A31LiqNro ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int7 ;
   private int GXv_int8[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z2330LegHisMotCod ;
   private String N2330LegHisMotCod ;
   private String Combo_legnumero_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A2330LegHisMotCod ;
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
   private String edtLegHisFecIng_Internalname ;
   private String edtLegHisFecIng_Jsonclick ;
   private String edtLegHisFecEgr_Internalname ;
   private String edtLegHisFecEgr_Jsonclick ;
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
   private String edtLegHisFecTel_Internalname ;
   private String edtLegHisFecTel_Jsonclick ;
   private String edtLegHisLiqNro_Internalname ;
   private String edtLegHisLiqNro_Jsonclick ;
   private String edtLegHisDiasAnt_Internalname ;
   private String edtLegHisDiasAnt_Jsonclick ;
   private String edtLegHisMesesAnt_Internalname ;
   private String edtLegHisMesesAnt_Jsonclick ;
   private String edtLegHisAniosAnt_Internalname ;
   private String edtLegHisAniosAnt_Jsonclick ;
   private String edtLegHisAntTexto_Internalname ;
   private String AV28Insert_LegHisMotCod ;
   private String AV32Pgmname ;
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
   private String sMode284 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXv_char5[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private java.util.Date wcpOAV10LegHisFecIng ;
   private java.util.Date Z2253LegHisFecIng ;
   private java.util.Date Z2254LegHisFecEgr ;
   private java.util.Date Z2255LegHisFecTel ;
   private java.util.Date N2254LegHisFecEgr ;
   private java.util.Date N2255LegHisFecTel ;
   private java.util.Date A2253LegHisFecIng ;
   private java.util.Date A2254LegHisFecEgr ;
   private java.util.Date AV10LegHisFecIng ;
   private java.util.Date A2255LegHisFecTel ;
   private boolean Z2258LegHisAfecAnt ;
   private boolean Z2332LegHisManual ;
   private boolean N2258LegHisAfecAnt ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n2330LegHisMotCod ;
   private boolean n2252LegHisLiqNro ;
   private boolean wbErr ;
   private boolean A2258LegHisAfecAnt ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_legnumero_Emptyitem ;
   private boolean A2332LegHisManual ;
   private boolean AV30existe ;
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
   private boolean i2258LegHisAfecAnt ;
   private boolean i2332LegHisManual ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXv_boolean3[] ;
   private boolean ZV30existe ;
   private String A2319LegHisAntTexto ;
   private String Z2319LegHisAntTexto ;
   private String Z2331LegHisAntTxtAbr ;
   private String A2331LegHisAntTxtAbr ;
   private String A2256LegHisMotivo ;
   private String AV20ComboSelectedValue ;
   private String Z2256LegHisMotivo ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_legnumero ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynLegHisMotCod ;
   private ICheckbox chkLegHisAfecAnt ;
   private IDataStoreProvider pr_default ;
   private String[] T006G6_A2256LegHisMotivo ;
   private java.util.Date[] T006G7_A2253LegHisFecIng ;
   private java.util.Date[] T006G7_A2254LegHisFecEgr ;
   private java.util.Date[] T006G7_A2255LegHisFecTel ;
   private String[] T006G7_A2256LegHisMotivo ;
   private int[] T006G7_A2257LegHisDiasAnt ;
   private short[] T006G7_A2317LegHisMesesAnt ;
   private short[] T006G7_A2318LegHisAniosAnt ;
   private String[] T006G7_A2319LegHisAntTexto ;
   private String[] T006G7_A2331LegHisAntTxtAbr ;
   private boolean[] T006G7_A2258LegHisAfecAnt ;
   private boolean[] T006G7_A2332LegHisManual ;
   private int[] T006G7_A3CliCod ;
   private short[] T006G7_A1EmpCod ;
   private int[] T006G7_A6LegNumero ;
   private int[] T006G7_A2252LegHisLiqNro ;
   private boolean[] T006G7_n2252LegHisLiqNro ;
   private String[] T006G7_A2330LegHisMotCod ;
   private boolean[] T006G7_n2330LegHisMotCod ;
   private int[] T006G4_A3CliCod ;
   private int[] T006G5_A31LiqNro ;
   private String[] T006G8_A2256LegHisMotivo ;
   private int[] T006G9_A3CliCod ;
   private int[] T006G10_A31LiqNro ;
   private int[] T006G11_A3CliCod ;
   private short[] T006G11_A1EmpCod ;
   private int[] T006G11_A6LegNumero ;
   private java.util.Date[] T006G11_A2253LegHisFecIng ;
   private java.util.Date[] T006G3_A2253LegHisFecIng ;
   private java.util.Date[] T006G3_A2254LegHisFecEgr ;
   private java.util.Date[] T006G3_A2255LegHisFecTel ;
   private int[] T006G3_A2257LegHisDiasAnt ;
   private short[] T006G3_A2317LegHisMesesAnt ;
   private short[] T006G3_A2318LegHisAniosAnt ;
   private String[] T006G3_A2319LegHisAntTexto ;
   private String[] T006G3_A2331LegHisAntTxtAbr ;
   private boolean[] T006G3_A2258LegHisAfecAnt ;
   private boolean[] T006G3_A2332LegHisManual ;
   private int[] T006G3_A3CliCod ;
   private short[] T006G3_A1EmpCod ;
   private int[] T006G3_A6LegNumero ;
   private int[] T006G3_A2252LegHisLiqNro ;
   private boolean[] T006G3_n2252LegHisLiqNro ;
   private String[] T006G3_A2330LegHisMotCod ;
   private boolean[] T006G3_n2330LegHisMotCod ;
   private java.util.Date[] T006G12_A2253LegHisFecIng ;
   private int[] T006G12_A3CliCod ;
   private short[] T006G12_A1EmpCod ;
   private int[] T006G12_A6LegNumero ;
   private java.util.Date[] T006G13_A2253LegHisFecIng ;
   private int[] T006G13_A3CliCod ;
   private short[] T006G13_A1EmpCod ;
   private int[] T006G13_A6LegNumero ;
   private java.util.Date[] T006G2_A2253LegHisFecIng ;
   private java.util.Date[] T006G2_A2254LegHisFecEgr ;
   private java.util.Date[] T006G2_A2255LegHisFecTel ;
   private int[] T006G2_A2257LegHisDiasAnt ;
   private short[] T006G2_A2317LegHisMesesAnt ;
   private short[] T006G2_A2318LegHisAniosAnt ;
   private String[] T006G2_A2319LegHisAntTexto ;
   private String[] T006G2_A2331LegHisAntTxtAbr ;
   private boolean[] T006G2_A2258LegHisAfecAnt ;
   private boolean[] T006G2_A2332LegHisManual ;
   private int[] T006G2_A3CliCod ;
   private short[] T006G2_A1EmpCod ;
   private int[] T006G2_A6LegNumero ;
   private int[] T006G2_A2252LegHisLiqNro ;
   private boolean[] T006G2_n2252LegHisLiqNro ;
   private String[] T006G2_A2330LegHisMotCod ;
   private boolean[] T006G2_n2330LegHisMotCod ;
   private String[] T006G17_A2256LegHisMotivo ;
   private int[] T006G18_A3CliCod ;
   private short[] T006G18_A1EmpCod ;
   private int[] T006G18_A6LegNumero ;
   private java.util.Date[] T006G18_A2253LegHisFecIng ;
   private int[] T006G19_A3CliCod ;
   private String[] T006G19_A11MegCodigo ;
   private String[] T006G19_A300MegDescrip ;
   private int[] T006G20_A3CliCod ;
   private String[] T006G21_A2256LegHisMotivo ;
   private int[] T006G22_A31LiqNro ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV18LegNumero_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXt_objcol_SdtDVB_SDTComboData_Item4 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXv_objcol_SdtDVB_SDTComboData_Item6[] ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV17TrnContextAtt ;
}

final  class legajo_permanencia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T006G2", "SELECT LegHisFecIng, LegHisFecEgr, LegHisFecTel, LegHisDiasAnt, LegHisMesesAnt, LegHisAniosAnt, LegHisAntTexto, LegHisAntTxtAbr, LegHisAfecAnt, LegHisManual, CliCod, EmpCod, LegNumero, LegHisLiqNro, LegHisMotCod FROM legajo_permanencia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegHisFecIng = ?  FOR UPDATE OF legajo_permanencia NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G3", "SELECT LegHisFecIng, LegHisFecEgr, LegHisFecTel, LegHisDiasAnt, LegHisMesesAnt, LegHisAniosAnt, LegHisAntTexto, LegHisAntTxtAbr, LegHisAfecAnt, LegHisManual, CliCod, EmpCod, LegNumero, LegHisLiqNro, LegHisMotCod FROM legajo_permanencia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegHisFecIng = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G4", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G5", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G6", "SELECT MegDescrip AS LegHisMotivo FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G7", "SELECT TM1.LegHisFecIng, TM1.LegHisFecEgr, TM1.LegHisFecTel, T2.MegDescrip AS LegHisMotivo, TM1.LegHisDiasAnt, TM1.LegHisMesesAnt, TM1.LegHisAniosAnt, TM1.LegHisAntTexto, TM1.LegHisAntTxtAbr, TM1.LegHisAfecAnt, TM1.LegHisManual, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegHisLiqNro, TM1.LegHisMotCod AS LegHisMotCod FROM (legajo_permanencia TM1 LEFT JOIN MotivoEgreso T2 ON T2.CliCod = TM1.CliCod AND T2.MegCodigo = TM1.LegHisMotCod) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LegHisFecIng = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegHisFecIng ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G8", "SELECT MegDescrip AS LegHisMotivo FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G9", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G10", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G11", "SELECT CliCod, EmpCod, LegNumero, LegHisFecIng FROM legajo_permanencia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegHisFecIng = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G12", "SELECT LegHisFecIng, CliCod, EmpCod, LegNumero FROM legajo_permanencia WHERE ( LegHisFecIng > ? or LegHisFecIng = ? and CliCod > ? or CliCod = ? and LegHisFecIng = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LegHisFecIng = ? and LegNumero > ?) ORDER BY CliCod, EmpCod, LegNumero, LegHisFecIng  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T006G13", "SELECT LegHisFecIng, CliCod, EmpCod, LegNumero FROM legajo_permanencia WHERE ( LegHisFecIng < ? or LegHisFecIng = ? and CliCod < ? or CliCod = ? and LegHisFecIng = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LegHisFecIng = ? and LegNumero < ?) ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LegHisFecIng DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T006G14", "SAVEPOINT gxupdate;INSERT INTO legajo_permanencia(LegHisFecIng, LegHisFecEgr, LegHisFecTel, LegHisDiasAnt, LegHisMesesAnt, LegHisAniosAnt, LegHisAntTexto, LegHisAntTxtAbr, LegHisAfecAnt, LegHisManual, CliCod, EmpCod, LegNumero, LegHisLiqNro, LegHisMotCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006G15", "SAVEPOINT gxupdate;UPDATE legajo_permanencia SET LegHisFecEgr=?, LegHisFecTel=?, LegHisDiasAnt=?, LegHisMesesAnt=?, LegHisAniosAnt=?, LegHisAntTexto=?, LegHisAntTxtAbr=?, LegHisAfecAnt=?, LegHisManual=?, LegHisLiqNro=?, LegHisMotCod=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegHisFecIng = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006G16", "SAVEPOINT gxupdate;DELETE FROM legajo_permanencia  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegHisFecIng = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006G17", "SELECT MegDescrip AS LegHisMotivo FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G18", "SELECT CliCod, EmpCod, LegNumero, LegHisFecIng FROM legajo_permanencia ORDER BY CliCod, EmpCod, LegNumero, LegHisFecIng ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G19", "SELECT CliCod, MegCodigo, MegDescrip FROM MotivoEgreso WHERE CliCod = ? ORDER BY MegDescrip ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G20", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G21", "SELECT MegDescrip AS LegHisMotivo FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006G22", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((int[]) buf[13])[0] = rslt.getInt(14);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((int[]) buf[13])[0] = rslt.getInt(14);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((int[]) buf[13])[0] = rslt.getInt(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 10 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 11 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 20 :
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
               stmt.setInt(4, ((Number) parms[4]).intValue());
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 6 :
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
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 8 :
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
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 10 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setDate(9, (java.util.Date)parms[8]);
               stmt.setInt(10, ((Number) parms[9]).intValue());
               return;
            case 11 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setDate(9, (java.util.Date)parms[8]);
               stmt.setInt(10, ((Number) parms[9]).intValue());
               return;
            case 12 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setNLongVarchar(7, (String)parms[6], false);
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setInt(13, ((Number) parms[12]).intValue());
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(14, ((Number) parms[14]).intValue());
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[16], 20);
               }
               return;
            case 13 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setNLongVarchar(6, (String)parms[5], false);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(10, ((Number) parms[10]).intValue());
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(11, (String)parms[12], 20);
               }
               stmt.setInt(12, ((Number) parms[13]).intValue());
               stmt.setShort(13, ((Number) parms[14]).shortValue());
               stmt.setInt(14, ((Number) parms[15]).intValue());
               stmt.setDate(15, (java.util.Date)parms[16]);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 15 :
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
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 20 :
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
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
      }
   }

}

