package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liquidacionajuste_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"CLICOD") == 0 )
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
         gx1asaclicod4H197( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_17") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A31LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_17( A3CliCod, A1EmpCod, A31LiqNro, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_19") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1540LiqAjuConcepto = httpContext.GetPar( "LiqAjuConcepto") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_19( A3CliCod, A1540LiqAjuConcepto) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_detalle") == 0 )
      {
         gxnrgridlevel_detalle_newrow_invoke( ) ;
         return  ;
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
            AV9LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9LiqNro), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LiqNro), "ZZZZZZZ9")));
            AV10LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LegNumero), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LegNumero), "ZZZZZZZ9")));
            AV11LiqAjuNro = (short)(GXutil.lval( httpContext.GetPar( "LiqAjuNro"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11LiqAjuNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LiqAjuNro), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQAJUNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11LiqAjuNro), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Liquidacion Ajuste", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtLiqAjuNro_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_detalle_newrow_invoke( )
   {
      nRC_GXsfl_36 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_36"))) ;
      nGXsfl_36_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_36_idx"))) ;
      sGXsfl_36_idx = httpContext.GetPar( "sGXsfl_36_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_detalle_newrow( ) ;
      /* End function gxnrGridlevel_detalle_newrow_invoke */
   }

   public liquidacionajuste_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liquidacionajuste_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionajuste_impl.class ));
   }

   public liquidacionajuste_impl( int remoteHandle ,
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqAjuNro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqAjuNro_Internalname, httpContext.getMessage( "Nro. Ajuste", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqAjuNro_Internalname, GXutil.ltrim( localUtil.ntoc( A1541LiqAjuNro, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1541LiqAjuNro), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqAjuNro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqAjuNro_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionAjuste.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqAjuObs_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqAjuObs_Internalname, httpContext.getMessage( "Observación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtLiqAjuObs_Internalname, A1542LiqAjuObs, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtLiqAjuObs_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_LiquidacionAjuste.htm");
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
      httpContext.writeText( "<td class='CellMarginTop'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_detalle_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol36( ) ;
      nGXsfl_36_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount198 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_198 = (short)(1) ;
            scanStart4H198( ) ;
            while ( RcdFound198 != 0 )
            {
               init_level_properties198( ) ;
               getByPrimaryKey4H198( ) ;
               addRow4H198( ) ;
               scanNext4H198( ) ;
            }
            scanEnd4H198( ) ;
            nBlankRcdCount198 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal4H198( ) ;
         standaloneModal4H198( ) ;
         sMode198 = Gx_mode ;
         while ( nGXsfl_36_idx < nRC_GXsfl_36 )
         {
            bGXsfl_36_Refreshing = true ;
            readRow4H198( ) ;
            edtLiqAjuSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LIQAJUSEC_"+sGXsfl_36_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuSec_Enabled), 5, 0), !bGXsfl_36_Refreshing);
            edtLiqAjuConcepto_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LIQAJUCONCEPTO_"+sGXsfl_36_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuConcepto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuConcepto_Enabled), 5, 0), !bGXsfl_36_Refreshing);
            edtLiqAjuImporte_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LIQAJUIMPORTE_"+sGXsfl_36_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuImporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuImporte_Enabled), 5, 0), !bGXsfl_36_Refreshing);
            edtLiqAjuCant_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LIQAJUCANT_"+sGXsfl_36_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuCant_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuCant_Enabled), 5, 0), !bGXsfl_36_Refreshing);
            if ( ( nRcdExists_198 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal4H198( ) ;
            }
            sendRow4H198( ) ;
            bGXsfl_36_Refreshing = false ;
         }
         Gx_mode = sMode198 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount198 = (short)(5) ;
         nRcdExists_198 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart4H198( ) ;
            while ( RcdFound198 != 0 )
            {
               sGXsfl_36_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_36_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_36198( ) ;
               init_level_properties198( ) ;
               standaloneNotModal4H198( ) ;
               getByPrimaryKey4H198( ) ;
               standaloneModal4H198( ) ;
               addRow4H198( ) ;
               scanNext4H198( ) ;
            }
            scanEnd4H198( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode198 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_36_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_36_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_36198( ) ;
         initAll4H198( ) ;
         init_level_properties198( ) ;
         nRcdExists_198 = (short)(0) ;
         nIsMod_198 = (short)(0) ;
         nRcdDeleted_198 = (short)(0) ;
         nBlankRcdCount198 = (short)(nBlankRcdUsr198+nBlankRcdCount198) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount198 > 0 )
         {
            standaloneNotModal4H198( ) ;
            standaloneModal4H198( ) ;
            addRow4H198( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtLiqAjuSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount198 = (short)(nBlankRcdCount198-1) ;
         }
         Gx_mode = sMode198 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_detalleContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_detalle", Gridlevel_detalleContainer, subGridlevel_detalle_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_detalleContainerData", Gridlevel_detalleContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_detalleContainerData"+"V", Gridlevel_detalleContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_detalleContainerData"+"V"+"\" value='"+Gridlevel_detalleContainer.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionAjuste.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionAjuste.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionAjuste.htm");
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
      /* User Defined Control */
      ucCombo_liqajuconcepto.setProperty("Caption", Combo_liqajuconcepto_Caption);
      ucCombo_liqajuconcepto.setProperty("Cls", Combo_liqajuconcepto_Cls);
      ucCombo_liqajuconcepto.setProperty("IsGridItem", Combo_liqajuconcepto_Isgriditem);
      ucCombo_liqajuconcepto.setProperty("EmptyItem", Combo_liqajuconcepto_Emptyitem);
      ucCombo_liqajuconcepto.setProperty("DropDownOptionsData", AV17LiqAjuConcepto_Data);
      ucCombo_liqajuconcepto.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_liqajuconcepto_Internalname, "COMBO_LIQAJUCONCEPTOContainer");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionAjuste.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,55);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LiquidacionAjuste.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqNro_Internalname, GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,56);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqNro_Jsonclick, 0, "Attribute", "", "", "", "", edtLiqNro_Visible, edtLiqNro_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_LiquidacionAjuste.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,57);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", edtLegNumero_Visible, edtLegNumero_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_LiquidacionAjuste.htm");
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
      e114H2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLIQAJUCONCEPTO_DATA"), AV17LiqAjuConcepto_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z31LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "Z31LiqNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1541LiqAjuNro = (short)(localUtil.ctol( httpContext.cgiGet( "Z1541LiqAjuNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_36 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_36"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "vLIQNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV10LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "vLEGNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV11LiqAjuNro = (short)(localUtil.ctol( httpContext.cgiGet( "vLIQAJUNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV33Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            Combo_liqajuconcepto_Objectcall = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Objectcall") ;
            Combo_liqajuconcepto_Class = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Class") ;
            Combo_liqajuconcepto_Icontype = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Icontype") ;
            Combo_liqajuconcepto_Icon = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Icon") ;
            Combo_liqajuconcepto_Caption = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Caption") ;
            Combo_liqajuconcepto_Tooltip = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Tooltip") ;
            Combo_liqajuconcepto_Cls = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Cls") ;
            Combo_liqajuconcepto_Selectedvalue_set = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Selectedvalue_set") ;
            Combo_liqajuconcepto_Selectedvalue_get = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Selectedvalue_get") ;
            Combo_liqajuconcepto_Selectedtext_set = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Selectedtext_set") ;
            Combo_liqajuconcepto_Selectedtext_get = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Selectedtext_get") ;
            Combo_liqajuconcepto_Gamoauthtoken = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Gamoauthtoken") ;
            Combo_liqajuconcepto_Ddointernalname = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Ddointernalname") ;
            Combo_liqajuconcepto_Titlecontrolalign = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Titlecontrolalign") ;
            Combo_liqajuconcepto_Dropdownoptionstype = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Dropdownoptionstype") ;
            Combo_liqajuconcepto_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Enabled")) ;
            Combo_liqajuconcepto_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Visible")) ;
            Combo_liqajuconcepto_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Titlecontrolidtoreplace") ;
            Combo_liqajuconcepto_Datalisttype = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Datalisttype") ;
            Combo_liqajuconcepto_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Allowmultipleselection")) ;
            Combo_liqajuconcepto_Datalistfixedvalues = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Datalistfixedvalues") ;
            Combo_liqajuconcepto_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Isgriditem")) ;
            Combo_liqajuconcepto_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Hasdescription")) ;
            Combo_liqajuconcepto_Datalistproc = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Datalistproc") ;
            Combo_liqajuconcepto_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Datalistprocparametersprefix") ;
            Combo_liqajuconcepto_Remoteservicesparameters = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Remoteservicesparameters") ;
            Combo_liqajuconcepto_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_liqajuconcepto_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Includeonlyselectedoption")) ;
            Combo_liqajuconcepto_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Includeselectalloption")) ;
            Combo_liqajuconcepto_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Emptyitem")) ;
            Combo_liqajuconcepto_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Includeaddnewoption")) ;
            Combo_liqajuconcepto_Htmltemplate = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Htmltemplate") ;
            Combo_liqajuconcepto_Multiplevaluestype = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Multiplevaluestype") ;
            Combo_liqajuconcepto_Loadingdata = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Loadingdata") ;
            Combo_liqajuconcepto_Noresultsfound = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Noresultsfound") ;
            Combo_liqajuconcepto_Emptyitemtext = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Emptyitemtext") ;
            Combo_liqajuconcepto_Onlyselectedvalues = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Onlyselectedvalues") ;
            Combo_liqajuconcepto_Selectalltext = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Selectalltext") ;
            Combo_liqajuconcepto_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Multiplevaluesseparator") ;
            Combo_liqajuconcepto_Addnewoptiontext = httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Addnewoptiontext") ;
            Combo_liqajuconcepto_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_LIQAJUCONCEPTO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqAjuNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqAjuNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQAJUNRO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLiqAjuNro_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1541LiqAjuNro = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1541LiqAjuNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1541LiqAjuNro), 4, 0));
            }
            else
            {
               A1541LiqAjuNro = (short)(localUtil.ctol( httpContext.cgiGet( edtLiqAjuNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1541LiqAjuNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1541LiqAjuNro), 4, 0));
            }
            A1542LiqAjuObs = httpContext.cgiGet( edtLiqAjuObs_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1542LiqAjuObs", A1542LiqAjuObs);
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQNRO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLiqNro_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A31LiqNro = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
            }
            else
            {
               A31LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
            }
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
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"LiquidacionAjuste");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) || ( A1541LiqAjuNro != Z1541LiqAjuNro ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("liquidacionajuste:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
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
               A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A1541LiqAjuNro = (short)(GXutil.lval( httpContext.GetPar( "LiqAjuNro"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1541LiqAjuNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1541LiqAjuNro), 4, 0));
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
                  sMode197 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode197 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound197 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_4H0( ) ;
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
                        e114H2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e124H2 ();
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
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
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
         e124H2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll4H197( ) ;
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
         disableAttributes4H197( ) ;
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

   public void confirm_4H0( )
   {
      beforeValidate4H197( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4H197( ) ;
         }
         else
         {
            checkExtendedTable4H197( ) ;
            closeExtendedTableCursors4H197( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode197 = Gx_mode ;
         confirm_4H198( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode197 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode197 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_4H198( )
   {
      nGXsfl_36_idx = 0 ;
      while ( nGXsfl_36_idx < nRC_GXsfl_36 )
      {
         readRow4H198( ) ;
         if ( ( nRcdExists_198 != 0 ) || ( nIsMod_198 != 0 ) )
         {
            getKey4H198( ) ;
            if ( ( nRcdExists_198 == 0 ) && ( nRcdDeleted_198 == 0 ) )
            {
               if ( RcdFound198 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate4H198( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable4H198( ) ;
                     closeExtendedTableCursors4H198( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "LIQAJUSEC_" + sGXsfl_36_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtLiqAjuSec_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound198 != 0 )
               {
                  if ( nRcdDeleted_198 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey4H198( ) ;
                     load4H198( ) ;
                     beforeValidate4H198( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls4H198( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_198 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate4H198( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable4H198( ) ;
                           closeExtendedTableCursors4H198( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_198 == 0 )
                  {
                     GXCCtl = "LIQAJUSEC_" + sGXsfl_36_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtLiqAjuSec_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtLiqAjuSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1543LiqAjuSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtLiqAjuConcepto_Internalname, GXutil.rtrim( A1540LiqAjuConcepto)) ;
         httpContext.changePostValue( edtLiqAjuImporte_Internalname, GXutil.ltrim( localUtil.ntoc( A1544LiqAjuImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtLiqAjuCant_Internalname, GXutil.ltrim( localUtil.ntoc( A1545LiqAjuCant, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1543LiqAjuSec_"+sGXsfl_36_idx, GXutil.ltrim( localUtil.ntoc( Z1543LiqAjuSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1544LiqAjuImporte_"+sGXsfl_36_idx, GXutil.ltrim( localUtil.ntoc( Z1544LiqAjuImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1545LiqAjuCant_"+sGXsfl_36_idx, GXutil.ltrim( localUtil.ntoc( Z1545LiqAjuCant, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1540LiqAjuConcepto_"+sGXsfl_36_idx, GXutil.rtrim( Z1540LiqAjuConcepto)) ;
         httpContext.changePostValue( "nRcdDeleted_198_"+sGXsfl_36_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_198, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_198_"+sGXsfl_36_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_198, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_198_"+sGXsfl_36_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_198, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_198 != 0 )
         {
            httpContext.changePostValue( "LIQAJUSEC_"+sGXsfl_36_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LIQAJUCONCEPTO_"+sGXsfl_36_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuConcepto_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LIQAJUIMPORTE_"+sGXsfl_36_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuImporte_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LIQAJUCANT_"+sGXsfl_36_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuCant_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption4H0( )
   {
   }

   public void e114H2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV12WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV12WWPContext = GXv_SdtWWPContext1[0] ;
      Combo_liqajuconcepto_Titlecontrolidtoreplace = edtLiqAjuConcepto_Internalname ;
      ucCombo_liqajuconcepto.sendProperty(context, "", false, Combo_liqajuconcepto_Internalname, "TitleControlIdToReplace", Combo_liqajuconcepto_Titlecontrolidtoreplace);
      /* Execute user subroutine: 'LOADCOMBOLIQAJUCONCEPTO' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacionAjuste_Insert", GXv_boolean3) ;
         liquidacionajuste_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacionAjuste_Update", GXv_boolean3) ;
         liquidacionajuste_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacionAjuste_Delete", GXv_boolean3) ;
         liquidacionajuste_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV33Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV15TrnContext.fromxml(AV16WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtLiqNro_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqNro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNro_Visible), 5, 0), true);
      edtLegNumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Visible), 5, 0), true);
   }

   public void e124H2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'LOADCOMBOLIQAJUCONCEPTO' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item4 = AV17LiqAjuConcepto_Data ;
      GXv_char5[0] = AV19ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item6[0] = GXt_objcol_SdtDVB_SDTComboData_Item4 ;
      new web.liquidacionajusteloaddvcombo(remoteHandle, context).execute( "LiqAjuConcepto", Gx_mode, AV7CliCod, AV8EmpCod, AV9LiqNro, AV10LegNumero, AV11LiqAjuNro, GXv_char5, GXv_objcol_SdtDVB_SDTComboData_Item6) ;
      liquidacionajuste_impl.this.AV19ComboSelectedValue = GXv_char5[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item4 = GXv_objcol_SdtDVB_SDTComboData_Item6[0] ;
      AV17LiqAjuConcepto_Data = GXt_objcol_SdtDVB_SDTComboData_Item4 ;
   }

   public void zm4H197( int GX_JID )
   {
      if ( ( GX_JID == 16 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
         }
         else
         {
         }
      }
      if ( GX_JID == -16 )
      {
         Z1541LiqAjuNro = A1541LiqAjuNro ;
         Z1542LiqAjuObs = A1542LiqAjuObs ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z31LiqNro = A31LiqNro ;
      }
   }

   public void standaloneNotModal( )
   {
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
            liquidacionajuste_impl.this.GXt_int7 = GXv_int8[0] ;
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
      if ( ! (0==AV9LiqNro) )
      {
         A31LiqNro = AV9LiqNro ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
      }
      if ( ! (0==AV9LiqNro) )
      {
         edtLiqNro_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLiqNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNro_Enabled), 5, 0), true);
      }
      else
      {
         edtLiqNro_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLiqNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNro_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9LiqNro) )
      {
         edtLiqNro_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLiqNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNro_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10LegNumero) )
      {
         A6LegNumero = AV10LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      if ( ! (0==AV10LegNumero) )
      {
         edtLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      else
      {
         edtLegNumero_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10LegNumero) )
      {
         edtLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      if ( ! (0==AV11LiqAjuNro) )
      {
         A1541LiqAjuNro = AV11LiqAjuNro ;
         httpContext.ajax_rsp_assign_attri("", false, "A1541LiqAjuNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1541LiqAjuNro), 4, 0));
      }
      if ( ! (0==AV11LiqAjuNro) )
      {
         edtLiqAjuNro_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuNro_Enabled), 5, 0), true);
      }
      else
      {
         edtLiqAjuNro_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuNro_Enabled), 5, 0), true);
      }
      if ( ! (0==AV11LiqAjuNro) )
      {
         edtLiqAjuNro_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuNro_Enabled), 5, 0), true);
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
         AV33Pgmname = "LiquidacionAjuste" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33Pgmname", AV33Pgmname);
      }
   }

   public void load4H197( )
   {
      /* Using cursor T004H8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1541LiqAjuNro)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound197 = (short)(1) ;
         A1542LiqAjuObs = T004H8_A1542LiqAjuObs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1542LiqAjuObs", A1542LiqAjuObs);
         zm4H197( -16) ;
      }
      pr_default.close(6);
      onLoadActions4H197( ) ;
   }

   public void onLoadActions4H197( )
   {
      AV33Pgmname = "LiquidacionAjuste" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33Pgmname", AV33Pgmname);
   }

   public void checkExtendedTable4H197( )
   {
      nIsDirty_197 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV33Pgmname = "LiquidacionAjuste" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33Pgmname", AV33Pgmname);
      /* Using cursor T004H7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(5);
   }

   public void closeExtendedTableCursors4H197( )
   {
      pr_default.close(5);
   }

   public void enableDisable( )
   {
   }

   public void gxload_17( int A3CliCod ,
                          short A1EmpCod ,
                          int A31LiqNro ,
                          int A6LegNumero )
   {
      /* Using cursor T004H9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
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

   public void getKey4H197( )
   {
      /* Using cursor T004H10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1541LiqAjuNro)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound197 = (short)(1) ;
      }
      else
      {
         RcdFound197 = (short)(0) ;
      }
      pr_default.close(8);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T004H6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1541LiqAjuNro)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm4H197( 16) ;
         RcdFound197 = (short)(1) ;
         A1541LiqAjuNro = T004H6_A1541LiqAjuNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1541LiqAjuNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1541LiqAjuNro), 4, 0));
         A1542LiqAjuObs = T004H6_A1542LiqAjuObs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1542LiqAjuObs", A1542LiqAjuObs);
         A3CliCod = T004H6_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004H6_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T004H6_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A31LiqNro = T004H6_A31LiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z31LiqNro = A31LiqNro ;
         Z6LegNumero = A6LegNumero ;
         Z1541LiqAjuNro = A1541LiqAjuNro ;
         sMode197 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load4H197( ) ;
         if ( AnyError == 1 )
         {
            RcdFound197 = (short)(0) ;
            initializeNonKey4H197( ) ;
         }
         Gx_mode = sMode197 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound197 = (short)(0) ;
         initializeNonKey4H197( ) ;
         sMode197 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode197 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey4H197( ) ;
      if ( RcdFound197 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound197 = (short)(0) ;
      /* Using cursor T004H11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A31LiqNro), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Integer.valueOf(A31LiqNro), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A1541LiqAjuNro)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T004H11_A3CliCod[0] < A3CliCod ) || ( T004H11_A3CliCod[0] == A3CliCod ) && ( T004H11_A1EmpCod[0] < A1EmpCod ) || ( T004H11_A1EmpCod[0] == A1EmpCod ) && ( T004H11_A3CliCod[0] == A3CliCod ) && ( T004H11_A31LiqNro[0] < A31LiqNro ) || ( T004H11_A31LiqNro[0] == A31LiqNro ) && ( T004H11_A1EmpCod[0] == A1EmpCod ) && ( T004H11_A3CliCod[0] == A3CliCod ) && ( T004H11_A6LegNumero[0] < A6LegNumero ) || ( T004H11_A6LegNumero[0] == A6LegNumero ) && ( T004H11_A31LiqNro[0] == A31LiqNro ) && ( T004H11_A1EmpCod[0] == A1EmpCod ) && ( T004H11_A3CliCod[0] == A3CliCod ) && ( T004H11_A1541LiqAjuNro[0] < A1541LiqAjuNro ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T004H11_A3CliCod[0] > A3CliCod ) || ( T004H11_A3CliCod[0] == A3CliCod ) && ( T004H11_A1EmpCod[0] > A1EmpCod ) || ( T004H11_A1EmpCod[0] == A1EmpCod ) && ( T004H11_A3CliCod[0] == A3CliCod ) && ( T004H11_A31LiqNro[0] > A31LiqNro ) || ( T004H11_A31LiqNro[0] == A31LiqNro ) && ( T004H11_A1EmpCod[0] == A1EmpCod ) && ( T004H11_A3CliCod[0] == A3CliCod ) && ( T004H11_A6LegNumero[0] > A6LegNumero ) || ( T004H11_A6LegNumero[0] == A6LegNumero ) && ( T004H11_A31LiqNro[0] == A31LiqNro ) && ( T004H11_A1EmpCod[0] == A1EmpCod ) && ( T004H11_A3CliCod[0] == A3CliCod ) && ( T004H11_A1541LiqAjuNro[0] > A1541LiqAjuNro ) ) )
         {
            A3CliCod = T004H11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T004H11_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A31LiqNro = T004H11_A31LiqNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
            A6LegNumero = T004H11_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A1541LiqAjuNro = T004H11_A1541LiqAjuNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1541LiqAjuNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1541LiqAjuNro), 4, 0));
            RcdFound197 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void move_previous( )
   {
      RcdFound197 = (short)(0) ;
      /* Using cursor T004H12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A31LiqNro), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Integer.valueOf(A31LiqNro), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A1541LiqAjuNro)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T004H12_A3CliCod[0] > A3CliCod ) || ( T004H12_A3CliCod[0] == A3CliCod ) && ( T004H12_A1EmpCod[0] > A1EmpCod ) || ( T004H12_A1EmpCod[0] == A1EmpCod ) && ( T004H12_A3CliCod[0] == A3CliCod ) && ( T004H12_A31LiqNro[0] > A31LiqNro ) || ( T004H12_A31LiqNro[0] == A31LiqNro ) && ( T004H12_A1EmpCod[0] == A1EmpCod ) && ( T004H12_A3CliCod[0] == A3CliCod ) && ( T004H12_A6LegNumero[0] > A6LegNumero ) || ( T004H12_A6LegNumero[0] == A6LegNumero ) && ( T004H12_A31LiqNro[0] == A31LiqNro ) && ( T004H12_A1EmpCod[0] == A1EmpCod ) && ( T004H12_A3CliCod[0] == A3CliCod ) && ( T004H12_A1541LiqAjuNro[0] > A1541LiqAjuNro ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T004H12_A3CliCod[0] < A3CliCod ) || ( T004H12_A3CliCod[0] == A3CliCod ) && ( T004H12_A1EmpCod[0] < A1EmpCod ) || ( T004H12_A1EmpCod[0] == A1EmpCod ) && ( T004H12_A3CliCod[0] == A3CliCod ) && ( T004H12_A31LiqNro[0] < A31LiqNro ) || ( T004H12_A31LiqNro[0] == A31LiqNro ) && ( T004H12_A1EmpCod[0] == A1EmpCod ) && ( T004H12_A3CliCod[0] == A3CliCod ) && ( T004H12_A6LegNumero[0] < A6LegNumero ) || ( T004H12_A6LegNumero[0] == A6LegNumero ) && ( T004H12_A31LiqNro[0] == A31LiqNro ) && ( T004H12_A1EmpCod[0] == A1EmpCod ) && ( T004H12_A3CliCod[0] == A3CliCod ) && ( T004H12_A1541LiqAjuNro[0] < A1541LiqAjuNro ) ) )
         {
            A3CliCod = T004H12_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T004H12_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A31LiqNro = T004H12_A31LiqNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
            A6LegNumero = T004H12_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A1541LiqAjuNro = T004H12_A1541LiqAjuNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1541LiqAjuNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1541LiqAjuNro), 4, 0));
            RcdFound197 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4H197( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtLiqAjuNro_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert4H197( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound197 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) || ( A1541LiqAjuNro != Z1541LiqAjuNro ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A31LiqNro = Z31LiqNro ;
               httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
               A6LegNumero = Z6LegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A1541LiqAjuNro = Z1541LiqAjuNro ;
               httpContext.ajax_rsp_assign_attri("", false, "A1541LiqAjuNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1541LiqAjuNro), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtLiqAjuNro_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update4H197( ) ;
               GX_FocusControl = edtLiqAjuNro_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) || ( A1541LiqAjuNro != Z1541LiqAjuNro ) )
            {
               /* Insert record */
               GX_FocusControl = edtLiqAjuNro_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert4H197( ) ;
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
                  GX_FocusControl = edtLiqAjuNro_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert4H197( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) || ( A1541LiqAjuNro != Z1541LiqAjuNro ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A31LiqNro = Z31LiqNro ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         A6LegNumero = Z6LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A1541LiqAjuNro = Z1541LiqAjuNro ;
         httpContext.ajax_rsp_assign_attri("", false, "A1541LiqAjuNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1541LiqAjuNro), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtLiqAjuNro_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency4H197( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T004H5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1541LiqAjuNro)});
         if ( (pr_default.getStatus(3) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LiquidacionAjuste"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(3) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LiquidacionAjuste"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4H197( )
   {
      beforeValidate4H197( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4H197( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4H197( 0) ;
         checkOptimisticConcurrency4H197( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4H197( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4H197( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004H13 */
                  pr_default.execute(11, new Object[] {Short.valueOf(A1541LiqAjuNro), A1542LiqAjuObs, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A31LiqNro)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionAjuste");
                  if ( (pr_default.getStatus(11) == 1) )
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
                        processLevel4H197( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption4H0( ) ;
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
         else
         {
            load4H197( ) ;
         }
         endLevel4H197( ) ;
      }
      closeExtendedTableCursors4H197( ) ;
   }

   public void update4H197( )
   {
      beforeValidate4H197( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4H197( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4H197( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4H197( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4H197( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004H14 */
                  pr_default.execute(12, new Object[] {A1542LiqAjuObs, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1541LiqAjuNro)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionAjuste");
                  if ( (pr_default.getStatus(12) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LiquidacionAjuste"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4H197( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel4H197( ) ;
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
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel4H197( ) ;
      }
      closeExtendedTableCursors4H197( ) ;
   }

   public void deferredUpdate4H197( )
   {
   }

   public void delete( )
   {
      beforeValidate4H197( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4H197( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4H197( ) ;
         afterConfirm4H197( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4H197( ) ;
            if ( AnyError == 0 )
            {
               scanStart4H198( ) ;
               while ( RcdFound198 != 0 )
               {
                  getByPrimaryKey4H198( ) ;
                  delete4H198( ) ;
                  scanNext4H198( ) ;
               }
               scanEnd4H198( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004H15 */
                  pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1541LiqAjuNro)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionAjuste");
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
      }
      sMode197 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel4H197( ) ;
      Gx_mode = sMode197 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls4H197( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV33Pgmname = "LiquidacionAjuste" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33Pgmname", AV33Pgmname);
      }
   }

   public void processNestedLevel4H198( )
   {
      nGXsfl_36_idx = 0 ;
      while ( nGXsfl_36_idx < nRC_GXsfl_36 )
      {
         readRow4H198( ) ;
         if ( ( nRcdExists_198 != 0 ) || ( nIsMod_198 != 0 ) )
         {
            standaloneNotModal4H198( ) ;
            getKey4H198( ) ;
            if ( ( nRcdExists_198 == 0 ) && ( nRcdDeleted_198 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert4H198( ) ;
            }
            else
            {
               if ( RcdFound198 != 0 )
               {
                  if ( ( nRcdDeleted_198 != 0 ) && ( nRcdExists_198 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete4H198( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_198 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update4H198( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_198 == 0 )
                  {
                     GXCCtl = "LIQAJUSEC_" + sGXsfl_36_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtLiqAjuSec_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtLiqAjuSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1543LiqAjuSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtLiqAjuConcepto_Internalname, GXutil.rtrim( A1540LiqAjuConcepto)) ;
         httpContext.changePostValue( edtLiqAjuImporte_Internalname, GXutil.ltrim( localUtil.ntoc( A1544LiqAjuImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtLiqAjuCant_Internalname, GXutil.ltrim( localUtil.ntoc( A1545LiqAjuCant, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1543LiqAjuSec_"+sGXsfl_36_idx, GXutil.ltrim( localUtil.ntoc( Z1543LiqAjuSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1544LiqAjuImporte_"+sGXsfl_36_idx, GXutil.ltrim( localUtil.ntoc( Z1544LiqAjuImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1545LiqAjuCant_"+sGXsfl_36_idx, GXutil.ltrim( localUtil.ntoc( Z1545LiqAjuCant, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1540LiqAjuConcepto_"+sGXsfl_36_idx, GXutil.rtrim( Z1540LiqAjuConcepto)) ;
         httpContext.changePostValue( "nRcdDeleted_198_"+sGXsfl_36_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_198, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_198_"+sGXsfl_36_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_198, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_198_"+sGXsfl_36_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_198, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_198 != 0 )
         {
            httpContext.changePostValue( "LIQAJUSEC_"+sGXsfl_36_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LIQAJUCONCEPTO_"+sGXsfl_36_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuConcepto_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LIQAJUIMPORTE_"+sGXsfl_36_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuImporte_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LIQAJUCANT_"+sGXsfl_36_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuCant_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll4H198( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_198 = (short)(0) ;
      nIsMod_198 = (short)(0) ;
      nRcdDeleted_198 = (short)(0) ;
   }

   public void processLevel4H197( )
   {
      /* Save parent mode. */
      sMode197 = Gx_mode ;
      processNestedLevel4H198( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode197 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel4H197( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(3);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4H197( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "liquidacionajuste");
         if ( AnyError == 0 )
         {
            confirmValues4H0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "liquidacionajuste");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart4H197( )
   {
      /* Scan By routine */
      /* Using cursor T004H16 */
      pr_default.execute(14);
      RcdFound197 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound197 = (short)(1) ;
         A3CliCod = T004H16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004H16_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A31LiqNro = T004H16_A31LiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         A6LegNumero = T004H16_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A1541LiqAjuNro = T004H16_A1541LiqAjuNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1541LiqAjuNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1541LiqAjuNro), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext4H197( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound197 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound197 = (short)(1) ;
         A3CliCod = T004H16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004H16_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A31LiqNro = T004H16_A31LiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         A6LegNumero = T004H16_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A1541LiqAjuNro = T004H16_A1541LiqAjuNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1541LiqAjuNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1541LiqAjuNro), 4, 0));
      }
   }

   public void scanEnd4H197( )
   {
      pr_default.close(14);
   }

   public void afterConfirm4H197( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert4H197( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4H197( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4H197( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4H197( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4H197( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4H197( )
   {
      edtLiqAjuNro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuNro_Enabled), 5, 0), true);
      edtLiqAjuObs_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuObs_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuObs_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLiqNro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNro_Enabled), 5, 0), true);
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
   }

   public void zm4H198( int GX_JID )
   {
      if ( ( GX_JID == 18 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1544LiqAjuImporte = T004H3_A1544LiqAjuImporte[0] ;
            Z1545LiqAjuCant = T004H3_A1545LiqAjuCant[0] ;
            Z1540LiqAjuConcepto = T004H3_A1540LiqAjuConcepto[0] ;
         }
         else
         {
            Z1544LiqAjuImporte = A1544LiqAjuImporte ;
            Z1545LiqAjuCant = A1545LiqAjuCant ;
            Z1540LiqAjuConcepto = A1540LiqAjuConcepto ;
         }
      }
      if ( GX_JID == -18 )
      {
         Z1541LiqAjuNro = A1541LiqAjuNro ;
         Z1543LiqAjuSec = A1543LiqAjuSec ;
         Z1544LiqAjuImporte = A1544LiqAjuImporte ;
         Z1545LiqAjuCant = A1545LiqAjuCant ;
         Z3CliCod = A3CliCod ;
         Z1540LiqAjuConcepto = A1540LiqAjuConcepto ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z31LiqNro = A31LiqNro ;
      }
   }

   public void standaloneNotModal4H198( )
   {
   }

   public void standaloneModal4H198( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtLiqAjuSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuSec_Enabled), 5, 0), !bGXsfl_36_Refreshing);
      }
      else
      {
         edtLiqAjuSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuSec_Enabled), 5, 0), !bGXsfl_36_Refreshing);
      }
   }

   public void load4H198( )
   {
      /* Using cursor T004H17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1541LiqAjuNro), Short.valueOf(A1543LiqAjuSec)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound198 = (short)(1) ;
         A1544LiqAjuImporte = T004H17_A1544LiqAjuImporte[0] ;
         A1545LiqAjuCant = T004H17_A1545LiqAjuCant[0] ;
         A1540LiqAjuConcepto = T004H17_A1540LiqAjuConcepto[0] ;
         zm4H198( -18) ;
      }
      pr_default.close(15);
      onLoadActions4H198( ) ;
   }

   public void onLoadActions4H198( )
   {
   }

   public void checkExtendedTable4H198( )
   {
      nIsDirty_198 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal4H198( ) ;
      /* Using cursor T004H4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A1540LiqAjuConcepto});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "LIQAJUCONCEPTO_" + sGXsfl_36_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ajuste Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtLiqAjuConcepto_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors4H198( )
   {
      pr_default.close(2);
   }

   public void enableDisable4H198( )
   {
   }

   public void gxload_19( int A3CliCod ,
                          String A1540LiqAjuConcepto )
   {
      /* Using cursor T004H18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), A1540LiqAjuConcepto});
      if ( (pr_default.getStatus(16) == 101) )
      {
         GXCCtl = "LIQAJUCONCEPTO_" + sGXsfl_36_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ajuste Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtLiqAjuConcepto_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(16) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(16);
   }

   public void getKey4H198( )
   {
      /* Using cursor T004H19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1541LiqAjuNro), Short.valueOf(A1543LiqAjuSec)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound198 = (short)(1) ;
      }
      else
      {
         RcdFound198 = (short)(0) ;
      }
      pr_default.close(17);
   }

   public void getByPrimaryKey4H198( )
   {
      /* Using cursor T004H3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1541LiqAjuNro), Short.valueOf(A1543LiqAjuSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm4H198( 18) ;
         RcdFound198 = (short)(1) ;
         initializeNonKey4H198( ) ;
         A1543LiqAjuSec = T004H3_A1543LiqAjuSec[0] ;
         A1544LiqAjuImporte = T004H3_A1544LiqAjuImporte[0] ;
         A1545LiqAjuCant = T004H3_A1545LiqAjuCant[0] ;
         A1540LiqAjuConcepto = T004H3_A1540LiqAjuConcepto[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z31LiqNro = A31LiqNro ;
         Z6LegNumero = A6LegNumero ;
         Z1541LiqAjuNro = A1541LiqAjuNro ;
         Z1543LiqAjuSec = A1543LiqAjuSec ;
         sMode198 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load4H198( ) ;
         Gx_mode = sMode198 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound198 = (short)(0) ;
         initializeNonKey4H198( ) ;
         sMode198 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal4H198( ) ;
         Gx_mode = sMode198 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes4H198( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency4H198( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T004H2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1541LiqAjuNro), Short.valueOf(A1543LiqAjuSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LiquidacionAjustedetalle"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z1544LiqAjuImporte, T004H2_A1544LiqAjuImporte[0]) != 0 ) || ( DecimalUtil.compareTo(Z1545LiqAjuCant, T004H2_A1545LiqAjuCant[0]) != 0 ) || ( GXutil.strcmp(Z1540LiqAjuConcepto, T004H2_A1540LiqAjuConcepto[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z1544LiqAjuImporte, T004H2_A1544LiqAjuImporte[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionajuste:[seudo value changed for attri]"+"LiqAjuImporte");
               GXutil.writeLogRaw("Old: ",Z1544LiqAjuImporte);
               GXutil.writeLogRaw("Current: ",T004H2_A1544LiqAjuImporte[0]);
            }
            if ( DecimalUtil.compareTo(Z1545LiqAjuCant, T004H2_A1545LiqAjuCant[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionajuste:[seudo value changed for attri]"+"LiqAjuCant");
               GXutil.writeLogRaw("Old: ",Z1545LiqAjuCant);
               GXutil.writeLogRaw("Current: ",T004H2_A1545LiqAjuCant[0]);
            }
            if ( GXutil.strcmp(Z1540LiqAjuConcepto, T004H2_A1540LiqAjuConcepto[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionajuste:[seudo value changed for attri]"+"LiqAjuConcepto");
               GXutil.writeLogRaw("Old: ",Z1540LiqAjuConcepto);
               GXutil.writeLogRaw("Current: ",T004H2_A1540LiqAjuConcepto[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LiquidacionAjustedetalle"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4H198( )
   {
      beforeValidate4H198( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4H198( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4H198( 0) ;
         checkOptimisticConcurrency4H198( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4H198( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4H198( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004H20 */
                  pr_default.execute(18, new Object[] {Short.valueOf(A1541LiqAjuNro), Short.valueOf(A1543LiqAjuSec), A1544LiqAjuImporte, A1545LiqAjuCant, Integer.valueOf(A3CliCod), A1540LiqAjuConcepto, Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A31LiqNro)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionAjustedetalle");
                  if ( (pr_default.getStatus(18) == 1) )
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
            load4H198( ) ;
         }
         endLevel4H198( ) ;
      }
      closeExtendedTableCursors4H198( ) ;
   }

   public void update4H198( )
   {
      beforeValidate4H198( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4H198( ) ;
      }
      if ( ( nIsMod_198 != 0 ) || ( nIsDirty_198 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency4H198( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm4H198( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate4H198( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T004H21 */
                     pr_default.execute(19, new Object[] {A1544LiqAjuImporte, A1545LiqAjuCant, A1540LiqAjuConcepto, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1541LiqAjuNro), Short.valueOf(A1543LiqAjuSec)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionAjustedetalle");
                     if ( (pr_default.getStatus(19) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LiquidacionAjustedetalle"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate4H198( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey4H198( ) ;
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
            endLevel4H198( ) ;
         }
      }
      closeExtendedTableCursors4H198( ) ;
   }

   public void deferredUpdate4H198( )
   {
   }

   public void delete4H198( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate4H198( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4H198( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4H198( ) ;
         afterConfirm4H198( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4H198( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T004H22 */
               pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1541LiqAjuNro), Short.valueOf(A1543LiqAjuSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionAjustedetalle");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode198 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel4H198( ) ;
      Gx_mode = sMode198 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls4H198( )
   {
      standaloneModal4H198( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel4H198( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart4H198( )
   {
      /* Scan By routine */
      /* Using cursor T004H23 */
      pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1541LiqAjuNro)});
      RcdFound198 = (short)(0) ;
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound198 = (short)(1) ;
         A1543LiqAjuSec = T004H23_A1543LiqAjuSec[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext4H198( )
   {
      /* Scan next routine */
      pr_default.readNext(21);
      RcdFound198 = (short)(0) ;
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound198 = (short)(1) ;
         A1543LiqAjuSec = T004H23_A1543LiqAjuSec[0] ;
      }
   }

   public void scanEnd4H198( )
   {
      pr_default.close(21);
   }

   public void afterConfirm4H198( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert4H198( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4H198( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4H198( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4H198( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4H198( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4H198( )
   {
      edtLiqAjuSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuSec_Enabled), 5, 0), !bGXsfl_36_Refreshing);
      edtLiqAjuConcepto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuConcepto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuConcepto_Enabled), 5, 0), !bGXsfl_36_Refreshing);
      edtLiqAjuImporte_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuImporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuImporte_Enabled), 5, 0), !bGXsfl_36_Refreshing);
      edtLiqAjuCant_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuCant_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuCant_Enabled), 5, 0), !bGXsfl_36_Refreshing);
   }

   public void send_integrity_lvl_hashes4H198( )
   {
   }

   public void send_integrity_lvl_hashes4H197( )
   {
   }

   public void subsflControlProps_36198( )
   {
      edtLiqAjuSec_Internalname = "LIQAJUSEC_"+sGXsfl_36_idx ;
      edtLiqAjuConcepto_Internalname = "LIQAJUCONCEPTO_"+sGXsfl_36_idx ;
      edtLiqAjuImporte_Internalname = "LIQAJUIMPORTE_"+sGXsfl_36_idx ;
      edtLiqAjuCant_Internalname = "LIQAJUCANT_"+sGXsfl_36_idx ;
   }

   public void subsflControlProps_fel_36198( )
   {
      edtLiqAjuSec_Internalname = "LIQAJUSEC_"+sGXsfl_36_fel_idx ;
      edtLiqAjuConcepto_Internalname = "LIQAJUCONCEPTO_"+sGXsfl_36_fel_idx ;
      edtLiqAjuImporte_Internalname = "LIQAJUIMPORTE_"+sGXsfl_36_fel_idx ;
      edtLiqAjuCant_Internalname = "LIQAJUCANT_"+sGXsfl_36_fel_idx ;
   }

   public void addRow4H198( )
   {
      nGXsfl_36_idx = (int)(nGXsfl_36_idx+1) ;
      sGXsfl_36_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_36_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_36198( ) ;
      sendRow4H198( ) ;
   }

   public void sendRow4H198( )
   {
      Gridlevel_detalleRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_detalle_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_detalle_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
         {
            subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_detalle_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_detalle_Backstyle = (byte)(0) ;
         subGridlevel_detalle_Backcolor = subGridlevel_detalle_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
         {
            subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_detalle_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_detalle_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
         {
            subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Odd" ;
         }
         subGridlevel_detalle_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_detalle_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_detalle_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_36_idx) % (2))) == 0 )
         {
            subGridlevel_detalle_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
            {
               subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_detalle_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
            {
               subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_198_" + sGXsfl_36_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 37,'',false,'" + sGXsfl_36_idx + "',36)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqAjuSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1543LiqAjuSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1543LiqAjuSec), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,37);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqAjuSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtLiqAjuSec_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_198_" + sGXsfl_36_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 38,'',false,'" + sGXsfl_36_idx + "',36)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqAjuConcepto_Internalname,GXutil.rtrim( A1540LiqAjuConcepto),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqAjuConcepto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtLiqAjuConcepto_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_198_" + sGXsfl_36_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 39,'',false,'" + sGXsfl_36_idx + "',36)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqAjuImporte_Internalname,GXutil.ltrim( localUtil.ntoc( A1544LiqAjuImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtLiqAjuImporte_Enabled!=0) ? localUtil.format( A1544LiqAjuImporte, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1544LiqAjuImporte, "ZZ,ZZZ,ZZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,39);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqAjuImporte_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtLiqAjuImporte_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_198_" + sGXsfl_36_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 40,'',false,'" + sGXsfl_36_idx + "',36)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqAjuCant_Internalname,GXutil.ltrim( localUtil.ntoc( A1545LiqAjuCant, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtLiqAjuCant_Enabled!=0) ? localUtil.format( A1545LiqAjuCant, "ZZZZZ9.99") : localUtil.format( A1545LiqAjuCant, "ZZZZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,40);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqAjuCant_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtLiqAjuCant_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel_detalleRow);
      send_integrity_lvl_hashes4H198( ) ;
      GXCCtl = "Z1543LiqAjuSec_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1543LiqAjuSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1544LiqAjuImporte_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1544LiqAjuImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1545LiqAjuCant_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1545LiqAjuCant, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1540LiqAjuConcepto_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z1540LiqAjuConcepto));
      GXCCtl = "nRcdDeleted_198_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_198, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_198_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_198, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_198_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_198, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vEMPCOD_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vLIQNRO_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV9LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vLEGNUMERO_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV10LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vLIQAJUNRO_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV11LiqAjuNro, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQAJUSEC_"+sGXsfl_36_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQAJUCONCEPTO_"+sGXsfl_36_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuConcepto_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQAJUIMPORTE_"+sGXsfl_36_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuImporte_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQAJUCANT_"+sGXsfl_36_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuCant_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_detalleContainer.AddRow(Gridlevel_detalleRow);
   }

   public void readRow4H198( )
   {
      nGXsfl_36_idx = (int)(nGXsfl_36_idx+1) ;
      sGXsfl_36_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_36_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_36198( ) ;
      edtLiqAjuSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LIQAJUSEC_"+sGXsfl_36_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtLiqAjuConcepto_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LIQAJUCONCEPTO_"+sGXsfl_36_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtLiqAjuImporte_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LIQAJUIMPORTE_"+sGXsfl_36_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtLiqAjuCant_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LIQAJUCANT_"+sGXsfl_36_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqAjuSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqAjuSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "LIQAJUSEC_" + sGXsfl_36_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtLiqAjuSec_Internalname ;
         wbErr = true ;
         A1543LiqAjuSec = (short)(0) ;
      }
      else
      {
         A1543LiqAjuSec = (short)(localUtil.ctol( httpContext.cgiGet( edtLiqAjuSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      A1540LiqAjuConcepto = httpContext.cgiGet( edtLiqAjuConcepto_Internalname) ;
      if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqAjuImporte_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqAjuImporte_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
      {
         GXCCtl = "LIQAJUIMPORTE_" + sGXsfl_36_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtLiqAjuImporte_Internalname ;
         wbErr = true ;
         A1544LiqAjuImporte = DecimalUtil.ZERO ;
      }
      else
      {
         A1544LiqAjuImporte = localUtil.ctond( httpContext.cgiGet( edtLiqAjuImporte_Internalname)) ;
      }
      if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLiqAjuCant_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqAjuCant_Internalname)), DecimalUtil.stringToDec("999999.99")) > 0 ) ) )
      {
         GXCCtl = "LIQAJUCANT_" + sGXsfl_36_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtLiqAjuCant_Internalname ;
         wbErr = true ;
         A1545LiqAjuCant = DecimalUtil.ZERO ;
      }
      else
      {
         A1545LiqAjuCant = localUtil.ctond( httpContext.cgiGet( edtLiqAjuCant_Internalname)) ;
      }
      GXCCtl = "Z1543LiqAjuSec_" + sGXsfl_36_idx ;
      Z1543LiqAjuSec = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1544LiqAjuImporte_" + sGXsfl_36_idx ;
      Z1544LiqAjuImporte = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1545LiqAjuCant_" + sGXsfl_36_idx ;
      Z1545LiqAjuCant = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1540LiqAjuConcepto_" + sGXsfl_36_idx ;
      Z1540LiqAjuConcepto = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "nRcdDeleted_198_" + sGXsfl_36_idx ;
      nRcdDeleted_198 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_198_" + sGXsfl_36_idx ;
      nRcdExists_198 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_198_" + sGXsfl_36_idx ;
      nIsMod_198 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtLiqAjuSec_Enabled = edtLiqAjuSec_Enabled ;
   }

   public void confirmValues4H0( )
   {
      nGXsfl_36_idx = 0 ;
      sGXsfl_36_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_36_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_36198( ) ;
      while ( nGXsfl_36_idx < nRC_GXsfl_36 )
      {
         nGXsfl_36_idx = (int)(nGXsfl_36_idx+1) ;
         sGXsfl_36_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_36_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_36198( ) ;
         httpContext.changePostValue( "Z1543LiqAjuSec_"+sGXsfl_36_idx, httpContext.cgiGet( "ZT_"+"Z1543LiqAjuSec_"+sGXsfl_36_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1543LiqAjuSec_"+sGXsfl_36_idx) ;
         httpContext.changePostValue( "Z1544LiqAjuImporte_"+sGXsfl_36_idx, httpContext.cgiGet( "ZT_"+"Z1544LiqAjuImporte_"+sGXsfl_36_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1544LiqAjuImporte_"+sGXsfl_36_idx) ;
         httpContext.changePostValue( "Z1545LiqAjuCant_"+sGXsfl_36_idx, httpContext.cgiGet( "ZT_"+"Z1545LiqAjuCant_"+sGXsfl_36_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1545LiqAjuCant_"+sGXsfl_36_idx) ;
         httpContext.changePostValue( "Z1540LiqAjuConcepto_"+sGXsfl_36_idx, httpContext.cgiGet( "ZT_"+"Z1540LiqAjuConcepto_"+sGXsfl_36_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1540LiqAjuConcepto_"+sGXsfl_36_idx) ;
      }
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.liquidacionajuste", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LiqNro,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11LiqAjuNro,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LiqNro","LegNumero","LiqAjuNro"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"LiquidacionAjuste");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("liquidacionajuste:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z31LiqNro", GXutil.ltrim( localUtil.ntoc( Z31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1541LiqAjuNro", GXutil.ltrim( localUtil.ntoc( Z1541LiqAjuNro, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_36", GXutil.ltrim( localUtil.ntoc( nGXsfl_36_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLIQAJUCONCEPTO_DATA", AV17LiqAjuConcepto_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLIQAJUCONCEPTO_DATA", AV17LiqAjuConcepto_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQNRO", GXutil.ltrim( localUtil.ntoc( AV9LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LiqNro), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV10LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQAJUNRO", GXutil.ltrim( localUtil.ntoc( AV11LiqAjuNro, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQAJUNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11LiqAjuNro), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV33Pgmname));
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
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LIQAJUCONCEPTO_Objectcall", GXutil.rtrim( Combo_liqajuconcepto_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LIQAJUCONCEPTO_Cls", GXutil.rtrim( Combo_liqajuconcepto_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LIQAJUCONCEPTO_Enabled", GXutil.booltostr( Combo_liqajuconcepto_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LIQAJUCONCEPTO_Titlecontrolidtoreplace", GXutil.rtrim( Combo_liqajuconcepto_Titlecontrolidtoreplace));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LIQAJUCONCEPTO_Isgriditem", GXutil.booltostr( Combo_liqajuconcepto_Isgriditem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LIQAJUCONCEPTO_Emptyitem", GXutil.booltostr( Combo_liqajuconcepto_Emptyitem));
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
      return formatLink("web.liquidacionajuste", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LiqNro,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11LiqAjuNro,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LiqNro","LegNumero","LiqAjuNro"})  ;
   }

   public String getPgmname( )
   {
      return "LiquidacionAjuste" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Liquidacion Ajuste", "") ;
   }

   public void initializeNonKey4H197( )
   {
      A1542LiqAjuObs = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1542LiqAjuObs", A1542LiqAjuObs);
   }

   public void initAll4H197( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A31LiqNro = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      A1541LiqAjuNro = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1541LiqAjuNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1541LiqAjuNro), 4, 0));
      initializeNonKey4H197( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey4H198( )
   {
      A1540LiqAjuConcepto = "" ;
      A1544LiqAjuImporte = DecimalUtil.ZERO ;
      A1545LiqAjuCant = DecimalUtil.ZERO ;
      Z1544LiqAjuImporte = DecimalUtil.ZERO ;
      Z1545LiqAjuCant = DecimalUtil.ZERO ;
      Z1540LiqAjuConcepto = "" ;
   }

   public void initAll4H198( )
   {
      A1543LiqAjuSec = (short)(0) ;
      initializeNonKey4H198( ) ;
   }

   public void standaloneModalInsert4H198( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181754283", true, true);
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
      httpContext.AddJavascriptSource("liquidacionajuste.js", "?2025181754283", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties198( )
   {
      edtLiqAjuSec_Enabled = defedtLiqAjuSec_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqAjuSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAjuSec_Enabled), 5, 0), !bGXsfl_36_Refreshing);
   }

   public void startgridcontrol36( )
   {
      Gridlevel_detalleContainer.AddObjectProperty("GridName", "Gridlevel_detalle");
      Gridlevel_detalleContainer.AddObjectProperty("Header", subGridlevel_detalle_Header);
      Gridlevel_detalleContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_detalleContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_detalleContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1543LiqAjuSec, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.rtrim( A1540LiqAjuConcepto));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuConcepto_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1544LiqAjuImporte, (byte)(17), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuImporte_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1545LiqAjuCant, (byte)(9), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtLiqAjuCant_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      edtLiqAjuNro_Internalname = "LIQAJUNRO" ;
      edtLiqAjuObs_Internalname = "LIQAJUOBS" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtLiqAjuSec_Internalname = "LIQAJUSEC" ;
      edtLiqAjuConcepto_Internalname = "LIQAJUCONCEPTO" ;
      edtLiqAjuImporte_Internalname = "LIQAJUIMPORTE" ;
      edtLiqAjuCant_Internalname = "LIQAJUCANT" ;
      divTableleaflevel_detalle_Internalname = "TABLELEAFLEVEL_DETALLE" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Combo_liqajuconcepto_Internalname = "COMBO_LIQAJUCONCEPTO" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtLiqNro_Internalname = "LIQNRO" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_detalle_Internalname = "GRIDLEVEL_DETALLE" ;
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
      subGridlevel_detalle_Allowcollapsing = (byte)(0) ;
      subGridlevel_detalle_Allowselection = (byte)(0) ;
      subGridlevel_detalle_Header = "" ;
      Combo_liqajuconcepto_Enabled = GXutil.toBoolean( -1) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Liquidacion Ajuste", "") );
      edtLiqAjuCant_Jsonclick = "" ;
      edtLiqAjuImporte_Jsonclick = "" ;
      edtLiqAjuConcepto_Jsonclick = "" ;
      edtLiqAjuSec_Jsonclick = "" ;
      subGridlevel_detalle_Class = "WorkWith" ;
      subGridlevel_detalle_Backcolorstyle = (byte)(0) ;
      Combo_liqajuconcepto_Titlecontrolidtoreplace = "" ;
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Enabled = 1 ;
      edtLegNumero_Visible = 1 ;
      edtLiqNro_Jsonclick = "" ;
      edtLiqNro_Enabled = 1 ;
      edtLiqNro_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      Combo_liqajuconcepto_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_liqajuconcepto_Isgriditem = GXutil.toBoolean( -1) ;
      Combo_liqajuconcepto_Cls = "ExtendedCombo" ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtLiqAjuCant_Enabled = 1 ;
      edtLiqAjuImporte_Enabled = 1 ;
      edtLiqAjuConcepto_Enabled = 1 ;
      edtLiqAjuSec_Enabled = 1 ;
      edtLiqAjuObs_Enabled = 1 ;
      edtLiqAjuNro_Jsonclick = "" ;
      edtLiqAjuNro_Enabled = 1 ;
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

   public void gx1asaclicod4H197( int AV7CliCod )
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
            liquidacionajuste_impl.this.GXt_int7 = GXv_int8[0] ;
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

   public void gxnrgridlevel_detalle_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_36198( ) ;
      while ( nGXsfl_36_idx <= nRC_GXsfl_36 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal4H198( ) ;
         standaloneModal4H198( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow4H198( ) ;
         nGXsfl_36_idx = (int)(nGXsfl_36_idx+1) ;
         sGXsfl_36_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_36_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_36198( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_detalleContainer)) ;
      /* End function gxnrGridlevel_detalle_newrow */
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

   public void valid_Legnumero( )
   {
      /* Using cursor T004H24 */
      pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(22) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(22);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Liqajuconcepto( )
   {
      /* Using cursor T004H25 */
      pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), A1540LiqAjuConcepto});
      if ( (pr_default.getStatus(23) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ajuste Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQAJUCONCEPTO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLiqAjuConcepto_Internalname ;
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV11LiqAjuNro',fld:'vLIQAJUNRO',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV11LiqAjuNro',fld:'vLIQAJUNRO',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e124H2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_LIQAJUNRO","{handler:'valid_Liqajunro',iparms:[]");
      setEventMetadata("VALID_LIQAJUNRO",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LIQNRO","{handler:'valid_Liqnro',iparms:[]");
      setEventMetadata("VALID_LIQNRO",",oparms:[]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[]}");
      setEventMetadata("VALID_LIQAJUSEC","{handler:'valid_Liqajusec',iparms:[]");
      setEventMetadata("VALID_LIQAJUSEC",",oparms:[]}");
      setEventMetadata("VALID_LIQAJUCONCEPTO","{handler:'valid_Liqajuconcepto',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1540LiqAjuConcepto',fld:'LIQAJUCONCEPTO',pic:''}]");
      setEventMetadata("VALID_LIQAJUCONCEPTO",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Liqajucant',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z1544LiqAjuImporte = DecimalUtil.ZERO ;
      Z1545LiqAjuCant = DecimalUtil.ZERO ;
      Z1540LiqAjuConcepto = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1540LiqAjuConcepto = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A1542LiqAjuObs = "" ;
      Gridlevel_detalleContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode198 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      ucCombo_liqajuconcepto = new com.genexus.webpanels.GXUserControl();
      Combo_liqajuconcepto_Caption = "" ;
      AV17LiqAjuConcepto_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV33Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Combo_liqajuconcepto_Objectcall = "" ;
      Combo_liqajuconcepto_Class = "" ;
      Combo_liqajuconcepto_Icontype = "" ;
      Combo_liqajuconcepto_Icon = "" ;
      Combo_liqajuconcepto_Tooltip = "" ;
      Combo_liqajuconcepto_Selectedvalue_set = "" ;
      Combo_liqajuconcepto_Selectedvalue_get = "" ;
      Combo_liqajuconcepto_Selectedtext_set = "" ;
      Combo_liqajuconcepto_Selectedtext_get = "" ;
      Combo_liqajuconcepto_Gamoauthtoken = "" ;
      Combo_liqajuconcepto_Ddointernalname = "" ;
      Combo_liqajuconcepto_Titlecontrolalign = "" ;
      Combo_liqajuconcepto_Dropdownoptionstype = "" ;
      Combo_liqajuconcepto_Datalisttype = "" ;
      Combo_liqajuconcepto_Datalistfixedvalues = "" ;
      Combo_liqajuconcepto_Datalistproc = "" ;
      Combo_liqajuconcepto_Datalistprocparametersprefix = "" ;
      Combo_liqajuconcepto_Remoteservicesparameters = "" ;
      Combo_liqajuconcepto_Htmltemplate = "" ;
      Combo_liqajuconcepto_Multiplevaluestype = "" ;
      Combo_liqajuconcepto_Loadingdata = "" ;
      Combo_liqajuconcepto_Noresultsfound = "" ;
      Combo_liqajuconcepto_Emptyitemtext = "" ;
      Combo_liqajuconcepto_Onlyselectedvalues = "" ;
      Combo_liqajuconcepto_Selectalltext = "" ;
      Combo_liqajuconcepto_Multiplevaluesseparator = "" ;
      Combo_liqajuconcepto_Addnewoptiontext = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode197 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A1544LiqAjuImporte = DecimalUtil.ZERO ;
      A1545LiqAjuCant = DecimalUtil.ZERO ;
      AV12WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV15TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV16WebSession = httpContext.getWebSession();
      GXt_objcol_SdtDVB_SDTComboData_Item4 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV19ComboSelectedValue = "" ;
      GXv_char5 = new String[1] ;
      GXv_objcol_SdtDVB_SDTComboData_Item6 = new GXBaseCollection[1] ;
      Z1542LiqAjuObs = "" ;
      T004H8_A1541LiqAjuNro = new short[1] ;
      T004H8_A1542LiqAjuObs = new String[] {""} ;
      T004H8_A3CliCod = new int[1] ;
      T004H8_A1EmpCod = new short[1] ;
      T004H8_A6LegNumero = new int[1] ;
      T004H8_A31LiqNro = new int[1] ;
      T004H7_A3CliCod = new int[1] ;
      T004H9_A3CliCod = new int[1] ;
      T004H10_A3CliCod = new int[1] ;
      T004H10_A1EmpCod = new short[1] ;
      T004H10_A31LiqNro = new int[1] ;
      T004H10_A6LegNumero = new int[1] ;
      T004H10_A1541LiqAjuNro = new short[1] ;
      T004H6_A1541LiqAjuNro = new short[1] ;
      T004H6_A1542LiqAjuObs = new String[] {""} ;
      T004H6_A3CliCod = new int[1] ;
      T004H6_A1EmpCod = new short[1] ;
      T004H6_A6LegNumero = new int[1] ;
      T004H6_A31LiqNro = new int[1] ;
      T004H11_A3CliCod = new int[1] ;
      T004H11_A1EmpCod = new short[1] ;
      T004H11_A31LiqNro = new int[1] ;
      T004H11_A6LegNumero = new int[1] ;
      T004H11_A1541LiqAjuNro = new short[1] ;
      T004H12_A3CliCod = new int[1] ;
      T004H12_A1EmpCod = new short[1] ;
      T004H12_A31LiqNro = new int[1] ;
      T004H12_A6LegNumero = new int[1] ;
      T004H12_A1541LiqAjuNro = new short[1] ;
      T004H5_A1541LiqAjuNro = new short[1] ;
      T004H5_A1542LiqAjuObs = new String[] {""} ;
      T004H5_A3CliCod = new int[1] ;
      T004H5_A1EmpCod = new short[1] ;
      T004H5_A6LegNumero = new int[1] ;
      T004H5_A31LiqNro = new int[1] ;
      T004H16_A3CliCod = new int[1] ;
      T004H16_A1EmpCod = new short[1] ;
      T004H16_A31LiqNro = new int[1] ;
      T004H16_A6LegNumero = new int[1] ;
      T004H16_A1541LiqAjuNro = new short[1] ;
      T004H17_A1541LiqAjuNro = new short[1] ;
      T004H17_A1543LiqAjuSec = new short[1] ;
      T004H17_A1544LiqAjuImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004H17_A1545LiqAjuCant = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004H17_A3CliCod = new int[1] ;
      T004H17_A1540LiqAjuConcepto = new String[] {""} ;
      T004H17_A1EmpCod = new short[1] ;
      T004H17_A6LegNumero = new int[1] ;
      T004H17_A31LiqNro = new int[1] ;
      T004H4_A3CliCod = new int[1] ;
      T004H18_A3CliCod = new int[1] ;
      T004H19_A3CliCod = new int[1] ;
      T004H19_A1EmpCod = new short[1] ;
      T004H19_A31LiqNro = new int[1] ;
      T004H19_A6LegNumero = new int[1] ;
      T004H19_A1541LiqAjuNro = new short[1] ;
      T004H19_A1543LiqAjuSec = new short[1] ;
      T004H3_A1541LiqAjuNro = new short[1] ;
      T004H3_A1543LiqAjuSec = new short[1] ;
      T004H3_A1544LiqAjuImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004H3_A1545LiqAjuCant = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004H3_A3CliCod = new int[1] ;
      T004H3_A1540LiqAjuConcepto = new String[] {""} ;
      T004H3_A1EmpCod = new short[1] ;
      T004H3_A6LegNumero = new int[1] ;
      T004H3_A31LiqNro = new int[1] ;
      T004H2_A1541LiqAjuNro = new short[1] ;
      T004H2_A1543LiqAjuSec = new short[1] ;
      T004H2_A1544LiqAjuImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004H2_A1545LiqAjuCant = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004H2_A3CliCod = new int[1] ;
      T004H2_A1540LiqAjuConcepto = new String[] {""} ;
      T004H2_A1EmpCod = new short[1] ;
      T004H2_A6LegNumero = new int[1] ;
      T004H2_A31LiqNro = new int[1] ;
      T004H23_A3CliCod = new int[1] ;
      T004H23_A1EmpCod = new short[1] ;
      T004H23_A31LiqNro = new int[1] ;
      T004H23_A6LegNumero = new int[1] ;
      T004H23_A1541LiqAjuNro = new short[1] ;
      T004H23_A1543LiqAjuSec = new short[1] ;
      Gridlevel_detalleRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_detalle_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel_detalleColumn = new com.genexus.webpanels.GXWebColumn();
      GXv_int8 = new int[1] ;
      T004H24_A3CliCod = new int[1] ;
      T004H25_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionajuste__default(),
         new Object[] {
             new Object[] {
            T004H2_A1541LiqAjuNro, T004H2_A1543LiqAjuSec, T004H2_A1544LiqAjuImporte, T004H2_A1545LiqAjuCant, T004H2_A3CliCod, T004H2_A1540LiqAjuConcepto, T004H2_A1EmpCod, T004H2_A6LegNumero, T004H2_A31LiqNro
            }
            , new Object[] {
            T004H3_A1541LiqAjuNro, T004H3_A1543LiqAjuSec, T004H3_A1544LiqAjuImporte, T004H3_A1545LiqAjuCant, T004H3_A3CliCod, T004H3_A1540LiqAjuConcepto, T004H3_A1EmpCod, T004H3_A6LegNumero, T004H3_A31LiqNro
            }
            , new Object[] {
            T004H4_A3CliCod
            }
            , new Object[] {
            T004H5_A1541LiqAjuNro, T004H5_A1542LiqAjuObs, T004H5_A3CliCod, T004H5_A1EmpCod, T004H5_A6LegNumero, T004H5_A31LiqNro
            }
            , new Object[] {
            T004H6_A1541LiqAjuNro, T004H6_A1542LiqAjuObs, T004H6_A3CliCod, T004H6_A1EmpCod, T004H6_A6LegNumero, T004H6_A31LiqNro
            }
            , new Object[] {
            T004H7_A3CliCod
            }
            , new Object[] {
            T004H8_A1541LiqAjuNro, T004H8_A1542LiqAjuObs, T004H8_A3CliCod, T004H8_A1EmpCod, T004H8_A6LegNumero, T004H8_A31LiqNro
            }
            , new Object[] {
            T004H9_A3CliCod
            }
            , new Object[] {
            T004H10_A3CliCod, T004H10_A1EmpCod, T004H10_A31LiqNro, T004H10_A6LegNumero, T004H10_A1541LiqAjuNro
            }
            , new Object[] {
            T004H11_A3CliCod, T004H11_A1EmpCod, T004H11_A31LiqNro, T004H11_A6LegNumero, T004H11_A1541LiqAjuNro
            }
            , new Object[] {
            T004H12_A3CliCod, T004H12_A1EmpCod, T004H12_A31LiqNro, T004H12_A6LegNumero, T004H12_A1541LiqAjuNro
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004H16_A3CliCod, T004H16_A1EmpCod, T004H16_A31LiqNro, T004H16_A6LegNumero, T004H16_A1541LiqAjuNro
            }
            , new Object[] {
            T004H17_A1541LiqAjuNro, T004H17_A1543LiqAjuSec, T004H17_A1544LiqAjuImporte, T004H17_A1545LiqAjuCant, T004H17_A3CliCod, T004H17_A1540LiqAjuConcepto, T004H17_A1EmpCod, T004H17_A6LegNumero, T004H17_A31LiqNro
            }
            , new Object[] {
            T004H18_A3CliCod
            }
            , new Object[] {
            T004H19_A3CliCod, T004H19_A1EmpCod, T004H19_A31LiqNro, T004H19_A6LegNumero, T004H19_A1541LiqAjuNro, T004H19_A1543LiqAjuSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004H23_A3CliCod, T004H23_A1EmpCod, T004H23_A31LiqNro, T004H23_A6LegNumero, T004H23_A1541LiqAjuNro, T004H23_A1543LiqAjuSec
            }
            , new Object[] {
            T004H24_A3CliCod
            }
            , new Object[] {
            T004H25_A3CliCod
            }
         }
      );
      AV33Pgmname = "LiquidacionAjuste" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridlevel_detalle_Backcolorstyle ;
   private byte subGridlevel_detalle_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel_detalle_Allowselection ;
   private byte subGridlevel_detalle_Allowhovering ;
   private byte subGridlevel_detalle_Allowcollapsing ;
   private byte subGridlevel_detalle_Collapsed ;
   private short wcpOAV8EmpCod ;
   private short wcpOAV11LiqAjuNro ;
   private short Z1EmpCod ;
   private short Z1541LiqAjuNro ;
   private short Z1543LiqAjuSec ;
   private short nRcdDeleted_198 ;
   private short nRcdExists_198 ;
   private short nIsMod_198 ;
   private short A1EmpCod ;
   private short AV8EmpCod ;
   private short AV11LiqAjuNro ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1541LiqAjuNro ;
   private short nBlankRcdCount198 ;
   private short RcdFound198 ;
   private short nBlankRcdUsr198 ;
   private short RcdFound197 ;
   private short A1543LiqAjuSec ;
   private short nIsDirty_197 ;
   private short nIsDirty_198 ;
   private int wcpOAV7CliCod ;
   private int wcpOAV9LiqNro ;
   private int wcpOAV10LegNumero ;
   private int Z3CliCod ;
   private int Z31LiqNro ;
   private int Z6LegNumero ;
   private int nRC_GXsfl_36 ;
   private int nGXsfl_36_idx=1 ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int AV9LiqNro ;
   private int AV10LegNumero ;
   private int trnEnded ;
   private int edtLiqAjuNro_Enabled ;
   private int edtLiqAjuObs_Enabled ;
   private int edtLiqAjuSec_Enabled ;
   private int edtLiqAjuConcepto_Enabled ;
   private int edtLiqAjuImporte_Enabled ;
   private int edtLiqAjuCant_Enabled ;
   private int fRowAdded ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int edtLiqNro_Visible ;
   private int edtLiqNro_Enabled ;
   private int edtLegNumero_Visible ;
   private int edtLegNumero_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int Combo_liqajuconcepto_Datalistupdateminimumcharacters ;
   private int Combo_liqajuconcepto_Gxcontroltype ;
   private int GX_JID ;
   private int subGridlevel_detalle_Backcolor ;
   private int subGridlevel_detalle_Allbackcolor ;
   private int defedtLiqAjuSec_Enabled ;
   private int idxLst ;
   private int subGridlevel_detalle_Selectedindex ;
   private int subGridlevel_detalle_Selectioncolor ;
   private int subGridlevel_detalle_Hoveringcolor ;
   private int GXt_int7 ;
   private int GXv_int8[] ;
   private long GRIDLEVEL_DETALLE_nFirstRecordOnPage ;
   private java.math.BigDecimal Z1544LiqAjuImporte ;
   private java.math.BigDecimal Z1545LiqAjuCant ;
   private java.math.BigDecimal A1544LiqAjuImporte ;
   private java.math.BigDecimal A1545LiqAjuCant ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z1540LiqAjuConcepto ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1540LiqAjuConcepto ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtLiqAjuNro_Internalname ;
   private String sGXsfl_36_idx="0001" ;
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
   private String edtLiqAjuNro_Jsonclick ;
   private String edtLiqAjuObs_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTableleaflevel_detalle_Internalname ;
   private String sMode198 ;
   private String edtLiqAjuSec_Internalname ;
   private String edtLiqAjuConcepto_Internalname ;
   private String edtLiqAjuImporte_Internalname ;
   private String edtLiqAjuCant_Internalname ;
   private String subGridlevel_detalle_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Combo_liqajuconcepto_Caption ;
   private String Combo_liqajuconcepto_Cls ;
   private String Combo_liqajuconcepto_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtLiqNro_Internalname ;
   private String edtLiqNro_Jsonclick ;
   private String edtLegNumero_Internalname ;
   private String edtLegNumero_Jsonclick ;
   private String AV33Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Combo_liqajuconcepto_Objectcall ;
   private String Combo_liqajuconcepto_Class ;
   private String Combo_liqajuconcepto_Icontype ;
   private String Combo_liqajuconcepto_Icon ;
   private String Combo_liqajuconcepto_Tooltip ;
   private String Combo_liqajuconcepto_Selectedvalue_set ;
   private String Combo_liqajuconcepto_Selectedvalue_get ;
   private String Combo_liqajuconcepto_Selectedtext_set ;
   private String Combo_liqajuconcepto_Selectedtext_get ;
   private String Combo_liqajuconcepto_Gamoauthtoken ;
   private String Combo_liqajuconcepto_Ddointernalname ;
   private String Combo_liqajuconcepto_Titlecontrolalign ;
   private String Combo_liqajuconcepto_Dropdownoptionstype ;
   private String Combo_liqajuconcepto_Titlecontrolidtoreplace ;
   private String Combo_liqajuconcepto_Datalisttype ;
   private String Combo_liqajuconcepto_Datalistfixedvalues ;
   private String Combo_liqajuconcepto_Datalistproc ;
   private String Combo_liqajuconcepto_Datalistprocparametersprefix ;
   private String Combo_liqajuconcepto_Remoteservicesparameters ;
   private String Combo_liqajuconcepto_Htmltemplate ;
   private String Combo_liqajuconcepto_Multiplevaluestype ;
   private String Combo_liqajuconcepto_Loadingdata ;
   private String Combo_liqajuconcepto_Noresultsfound ;
   private String Combo_liqajuconcepto_Emptyitemtext ;
   private String Combo_liqajuconcepto_Onlyselectedvalues ;
   private String Combo_liqajuconcepto_Selectalltext ;
   private String Combo_liqajuconcepto_Multiplevaluesseparator ;
   private String Combo_liqajuconcepto_Addnewoptiontext ;
   private String hsh ;
   private String sMode197 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String GXv_char5[] ;
   private String sGXsfl_36_fel_idx="0001" ;
   private String subGridlevel_detalle_Class ;
   private String subGridlevel_detalle_Linesclass ;
   private String ROClassString ;
   private String edtLiqAjuSec_Jsonclick ;
   private String edtLiqAjuConcepto_Jsonclick ;
   private String edtLiqAjuImporte_Jsonclick ;
   private String edtLiqAjuCant_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_detalle_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean bGXsfl_36_Refreshing=false ;
   private boolean Combo_liqajuconcepto_Isgriditem ;
   private boolean Combo_liqajuconcepto_Emptyitem ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Combo_liqajuconcepto_Enabled ;
   private boolean Combo_liqajuconcepto_Visible ;
   private boolean Combo_liqajuconcepto_Allowmultipleselection ;
   private boolean Combo_liqajuconcepto_Hasdescription ;
   private boolean Combo_liqajuconcepto_Includeonlyselectedoption ;
   private boolean Combo_liqajuconcepto_Includeselectalloption ;
   private boolean Combo_liqajuconcepto_Includeaddnewoption ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String A1542LiqAjuObs ;
   private String Z1542LiqAjuObs ;
   private String AV19ComboSelectedValue ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_detalleContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_detalleRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_detalleColumn ;
   private com.genexus.webpanels.WebSession AV16WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_liqajuconcepto ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private short[] T004H8_A1541LiqAjuNro ;
   private String[] T004H8_A1542LiqAjuObs ;
   private int[] T004H8_A3CliCod ;
   private short[] T004H8_A1EmpCod ;
   private int[] T004H8_A6LegNumero ;
   private int[] T004H8_A31LiqNro ;
   private int[] T004H7_A3CliCod ;
   private int[] T004H9_A3CliCod ;
   private int[] T004H10_A3CliCod ;
   private short[] T004H10_A1EmpCod ;
   private int[] T004H10_A31LiqNro ;
   private int[] T004H10_A6LegNumero ;
   private short[] T004H10_A1541LiqAjuNro ;
   private short[] T004H6_A1541LiqAjuNro ;
   private String[] T004H6_A1542LiqAjuObs ;
   private int[] T004H6_A3CliCod ;
   private short[] T004H6_A1EmpCod ;
   private int[] T004H6_A6LegNumero ;
   private int[] T004H6_A31LiqNro ;
   private int[] T004H11_A3CliCod ;
   private short[] T004H11_A1EmpCod ;
   private int[] T004H11_A31LiqNro ;
   private int[] T004H11_A6LegNumero ;
   private short[] T004H11_A1541LiqAjuNro ;
   private int[] T004H12_A3CliCod ;
   private short[] T004H12_A1EmpCod ;
   private int[] T004H12_A31LiqNro ;
   private int[] T004H12_A6LegNumero ;
   private short[] T004H12_A1541LiqAjuNro ;
   private short[] T004H5_A1541LiqAjuNro ;
   private String[] T004H5_A1542LiqAjuObs ;
   private int[] T004H5_A3CliCod ;
   private short[] T004H5_A1EmpCod ;
   private int[] T004H5_A6LegNumero ;
   private int[] T004H5_A31LiqNro ;
   private int[] T004H16_A3CliCod ;
   private short[] T004H16_A1EmpCod ;
   private int[] T004H16_A31LiqNro ;
   private int[] T004H16_A6LegNumero ;
   private short[] T004H16_A1541LiqAjuNro ;
   private short[] T004H17_A1541LiqAjuNro ;
   private short[] T004H17_A1543LiqAjuSec ;
   private java.math.BigDecimal[] T004H17_A1544LiqAjuImporte ;
   private java.math.BigDecimal[] T004H17_A1545LiqAjuCant ;
   private int[] T004H17_A3CliCod ;
   private String[] T004H17_A1540LiqAjuConcepto ;
   private short[] T004H17_A1EmpCod ;
   private int[] T004H17_A6LegNumero ;
   private int[] T004H17_A31LiqNro ;
   private int[] T004H4_A3CliCod ;
   private int[] T004H18_A3CliCod ;
   private int[] T004H19_A3CliCod ;
   private short[] T004H19_A1EmpCod ;
   private int[] T004H19_A31LiqNro ;
   private int[] T004H19_A6LegNumero ;
   private short[] T004H19_A1541LiqAjuNro ;
   private short[] T004H19_A1543LiqAjuSec ;
   private short[] T004H3_A1541LiqAjuNro ;
   private short[] T004H3_A1543LiqAjuSec ;
   private java.math.BigDecimal[] T004H3_A1544LiqAjuImporte ;
   private java.math.BigDecimal[] T004H3_A1545LiqAjuCant ;
   private int[] T004H3_A3CliCod ;
   private String[] T004H3_A1540LiqAjuConcepto ;
   private short[] T004H3_A1EmpCod ;
   private int[] T004H3_A6LegNumero ;
   private int[] T004H3_A31LiqNro ;
   private short[] T004H2_A1541LiqAjuNro ;
   private short[] T004H2_A1543LiqAjuSec ;
   private java.math.BigDecimal[] T004H2_A1544LiqAjuImporte ;
   private java.math.BigDecimal[] T004H2_A1545LiqAjuCant ;
   private int[] T004H2_A3CliCod ;
   private String[] T004H2_A1540LiqAjuConcepto ;
   private short[] T004H2_A1EmpCod ;
   private int[] T004H2_A6LegNumero ;
   private int[] T004H2_A31LiqNro ;
   private int[] T004H23_A3CliCod ;
   private short[] T004H23_A1EmpCod ;
   private int[] T004H23_A31LiqNro ;
   private int[] T004H23_A6LegNumero ;
   private short[] T004H23_A1541LiqAjuNro ;
   private short[] T004H23_A1543LiqAjuSec ;
   private int[] T004H24_A3CliCod ;
   private int[] T004H25_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV17LiqAjuConcepto_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXt_objcol_SdtDVB_SDTComboData_Item4 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXv_objcol_SdtDVB_SDTComboData_Item6[] ;
   private web.wwpbaseobjects.SdtWWPContext AV12WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV15TrnContext ;
}

final  class liquidacionajuste__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T004H2", "SELECT LiqAjuNro, LiqAjuSec, LiqAjuImporte, LiqAjuCant, CliCod, LiqAjuConcepto, EmpCod, LegNumero, LiqNro FROM LiquidacionAjustedetalle WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqAjuNro = ? AND LiqAjuSec = ?  FOR UPDATE OF LiquidacionAjustedetalle NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004H3", "SELECT LiqAjuNro, LiqAjuSec, LiqAjuImporte, LiqAjuCant, CliCod, LiqAjuConcepto, EmpCod, LegNumero, LiqNro FROM LiquidacionAjustedetalle WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqAjuNro = ? AND LiqAjuSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004H4", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004H5", "SELECT LiqAjuNro, LiqAjuObs, CliCod, EmpCod, LegNumero, LiqNro FROM LiquidacionAjuste WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqAjuNro = ?  FOR UPDATE OF LiquidacionAjuste NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004H6", "SELECT LiqAjuNro, LiqAjuObs, CliCod, EmpCod, LegNumero, LiqNro FROM LiquidacionAjuste WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqAjuNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004H7", "SELECT CliCod FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004H8", "SELECT TM1.LiqAjuNro, TM1.LiqAjuObs, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LiqNro FROM LiquidacionAjuste TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LiqNro = ? and TM1.LegNumero = ? and TM1.LiqAjuNro = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LiqNro, TM1.LegNumero, TM1.LiqAjuNro ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004H9", "SELECT CliCod FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004H10", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro FROM LiquidacionAjuste WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqAjuNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004H11", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro FROM LiquidacionAjuste WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LiqNro > ? or LiqNro = ? and EmpCod = ? and CliCod = ? and LegNumero > ? or LegNumero = ? and LiqNro = ? and EmpCod = ? and CliCod = ? and LiqAjuNro > ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004H12", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro FROM LiquidacionAjuste WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LiqNro < ? or LiqNro = ? and EmpCod = ? and CliCod = ? and LegNumero < ? or LegNumero = ? and LiqNro = ? and EmpCod = ? and CliCod = ? and LiqAjuNro < ?) ORDER BY CliCod DESC, EmpCod DESC, LiqNro DESC, LegNumero DESC, LiqAjuNro DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T004H13", "SAVEPOINT gxupdate;INSERT INTO LiquidacionAjuste(LiqAjuNro, LiqAjuObs, CliCod, EmpCod, LegNumero, LiqNro) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004H14", "SAVEPOINT gxupdate;UPDATE LiquidacionAjuste SET LiqAjuObs=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqAjuNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004H15", "SAVEPOINT gxupdate;DELETE FROM LiquidacionAjuste  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqAjuNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004H16", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro FROM LiquidacionAjuste ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004H17", "SELECT LiqAjuNro, LiqAjuSec, LiqAjuImporte, LiqAjuCant, CliCod, LiqAjuConcepto, EmpCod, LegNumero, LiqNro FROM LiquidacionAjustedetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and LiqAjuNro = ? and LiqAjuSec = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro, LiqAjuSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004H18", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004H19", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro, LiqAjuSec FROM LiquidacionAjustedetalle WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqAjuNro = ? AND LiqAjuSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T004H20", "SAVEPOINT gxupdate;INSERT INTO LiquidacionAjustedetalle(LiqAjuNro, LiqAjuSec, LiqAjuImporte, LiqAjuCant, CliCod, LiqAjuConcepto, EmpCod, LegNumero, LiqNro) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004H21", "SAVEPOINT gxupdate;UPDATE LiquidacionAjustedetalle SET LiqAjuImporte=?, LiqAjuCant=?, LiqAjuConcepto=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqAjuNro = ? AND LiqAjuSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004H22", "SAVEPOINT gxupdate;DELETE FROM LiquidacionAjustedetalle  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqAjuNro = ? AND LiqAjuSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004H23", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro, LiqAjuSec FROM LiquidacionAjustedetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and LiqAjuNro = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro, LiqAjuSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004H24", "SELECT CliCod FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004H25", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 23 :
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
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
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 12 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 10);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               return;
            case 19 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               stmt.setString(3, (String)parms[2], 10);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

