package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class paisbase_calculo_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action50") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV18CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18CliCod), 6, 0));
         A2053PaiBaseRelSec = (int)(GXutil.lval( httpContext.GetPar( "PaiBaseRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2053PaiBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2053PaiBaseRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_50_4T183( Gx_mode, AV18CliCod, A2053PaiBaseRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"PAIBASERELSEC") == 0 )
      {
         AV18CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlapaibaserelsec4T183( AV18CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel4"+"_"+"PAIBASEC2TXT") == 0 )
      {
         A1441PaiBaseTipo = httpContext.GetPar( "PaiBaseTipo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
         A1442PaiBaseCod1 = httpContext.GetPar( "PaiBaseCod1") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
         A1443PaiBaseCod2 = httpContext.GetPar( "PaiBaseCod2") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx4asapaibasec2txt4T183( A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"PAIBASEC1TXT") == 0 )
      {
         A1441PaiBaseTipo = httpContext.GetPar( "PaiBaseTipo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
         A1442PaiBaseCod1 = httpContext.GetPar( "PaiBaseCod1") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx5asapaibasec1txt4T183( A1441PaiBaseTipo, A1442PaiBaseCod1) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel41"+"_"+"PAIBASEOLDDEFAULT") == 0 )
      {
         A1629PaiLicDLim = (short)(GXutil.lval( httpContext.GetPar( "PaiLicDLim"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1629PaiLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1629PaiLicDLim), 3, 0));
         A1630PaiLicDSeman = (byte)(GXutil.lval( httpContext.GetPar( "PaiLicDSeman"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1630PaiLicDSeman", GXutil.str( A1630PaiLicDSeman, 1, 0));
         A1631PaiLicDMes = (byte)(GXutil.lval( httpContext.GetPar( "PaiLicDMes"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1631PaiLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1631PaiLicDMes), 2, 0));
         A1632PaiLicDSemes = (short)(GXutil.lval( httpContext.GetPar( "PaiLicDSemes"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1632PaiLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1632PaiLicDSemes), 3, 0));
         A1633PaiLicDAnual = (short)(GXutil.lval( httpContext.GetPar( "PaiLicDAnual"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1633PaiLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1633PaiLicDAnual), 3, 0));
         A1634PaiLicAdju = GXutil.strtobool( httpContext.GetPar( "PaiLicAdju")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1634PaiLicAdju", A1634PaiLicAdju);
         A1635PaiLicAdjuObl = GXutil.strtobool( httpContext.GetPar( "PaiLicAdjuObl")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1635PaiLicAdjuObl", A1635PaiLicAdjuObl);
         A1636PaiLicNecAut = GXutil.strtobool( httpContext.GetPar( "PaiLicNecAut")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1636PaiLicNecAut", A1636PaiLicNecAut);
         A1637PaiLicIngMot = GXutil.strtobool( httpContext.GetPar( "PaiLicIngMot")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1637PaiLicIngMot", A1637PaiLicIngMot);
         A1638PaiLicMotObl = GXutil.strtobool( httpContext.GetPar( "PaiLicMotObl")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1638PaiLicMotObl", A1638PaiLicMotObl);
         A1451PaiBasePromCnt1 = (short)(GXutil.lval( httpContext.GetPar( "PaiBasePromCnt1"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1451PaiBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1451PaiBasePromCnt1), 3, 0));
         A1452PaiBasePromCnt2 = (short)(GXutil.lval( httpContext.GetPar( "PaiBasePromCnt2"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1452PaiBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1452PaiBasePromCnt2), 3, 0));
         A1453PaiBasePromTCnt = httpContext.GetPar( "PaiBasePromTCnt") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1453PaiBasePromTCnt", A1453PaiBasePromTCnt);
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A1444PaiBasePlus = CommonUtil.decimalVal( httpContext.GetPar( "PaiBasePlus"), ".") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1444PaiBasePlus", GXutil.ltrimstr( A1444PaiBasePlus, 6, 4));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx41asapaibaseolddefault4T183( A1629PaiLicDLim, A1630PaiLicDSeman, A1631PaiLicDMes, A1632PaiLicDSemes, A1633PaiLicDAnual, A1634PaiLicAdju, A1635PaiLicAdjuObl, A1636PaiLicNecAut, A1637PaiLicIngMot, A1638PaiLicMotObl, A1451PaiBasePromCnt1, A1452PaiBasePromCnt2, A1453PaiBasePromTCnt, Gx_mode, A1444PaiBasePlus) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_53") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_53( A46PaiCod) ;
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
            AV8PaiBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "PaiBaseClaseLeg"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8PaiBaseClaseLeg", GXutil.str( AV8PaiBaseClaseLeg, 1, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAIBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8PaiBaseClaseLeg), "9")));
            AV9PaiBaseTipo = httpContext.GetPar( "PaiBaseTipo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9PaiBaseTipo", AV9PaiBaseTipo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAIBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9PaiBaseTipo, ""))));
            AV10PaiBaseCod1 = httpContext.GetPar( "PaiBaseCod1") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10PaiBaseCod1", AV10PaiBaseCod1);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAIBASECOD1", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10PaiBaseCod1, ""))));
            AV11PaiBaseCod2 = httpContext.GetPar( "PaiBaseCod2") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11PaiBaseCod2", AV11PaiBaseCod2);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAIBASECOD2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11PaiBaseCod2, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Paisbase_calculo", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = cmbPaiBaseClaseLeg.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public paisbase_calculo_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public paisbase_calculo_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisbase_calculo_impl.class ));
   }

   public paisbase_calculo_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbPaiBaseClaseLeg = new HTMLChoice();
      cmbPaiBaseTipo = new HTMLChoice();
      chkPaiLicAdju = UIFactory.getCheckbox(this);
      chkPaiLicAdjuObl = UIFactory.getCheckbox(this);
      chkPaiLicNecAut = UIFactory.getCheckbox(this);
      chkPaiLicIngMot = UIFactory.getCheckbox(this);
      chkPaiLicMotObl = UIFactory.getCheckbox(this);
      cmbPaiBasePromTCnt = new HTMLChoice();
      dynPaiBaseRelSec = new HTMLChoice();
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
      if ( cmbPaiBaseClaseLeg.getItemCount() > 0 )
      {
         A1440PaiBaseClaseLeg = (byte)(GXutil.lval( cmbPaiBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiBaseClaseLeg.getInternalname(), "Values", cmbPaiBaseClaseLeg.ToJavascriptSource(), true);
      }
      if ( cmbPaiBaseTipo.getItemCount() > 0 )
      {
         A1441PaiBaseTipo = cmbPaiBaseTipo.getValidValue(A1441PaiBaseTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBaseTipo.setValue( GXutil.rtrim( A1441PaiBaseTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiBaseTipo.getInternalname(), "Values", cmbPaiBaseTipo.ToJavascriptSource(), true);
      }
      A1634PaiLicAdju = GXutil.strtobool( GXutil.booltostr( A1634PaiLicAdju)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1634PaiLicAdju", A1634PaiLicAdju);
      A1635PaiLicAdjuObl = GXutil.strtobool( GXutil.booltostr( A1635PaiLicAdjuObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1635PaiLicAdjuObl", A1635PaiLicAdjuObl);
      A1636PaiLicNecAut = GXutil.strtobool( GXutil.booltostr( A1636PaiLicNecAut)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1636PaiLicNecAut", A1636PaiLicNecAut);
      A1637PaiLicIngMot = GXutil.strtobool( GXutil.booltostr( A1637PaiLicIngMot)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1637PaiLicIngMot", A1637PaiLicIngMot);
      A1638PaiLicMotObl = GXutil.strtobool( GXutil.booltostr( A1638PaiLicMotObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1638PaiLicMotObl", A1638PaiLicMotObl);
      if ( cmbPaiBasePromTCnt.getItemCount() > 0 )
      {
         A1453PaiBasePromTCnt = cmbPaiBasePromTCnt.getValidValue(A1453PaiBasePromTCnt) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1453PaiBasePromTCnt", A1453PaiBasePromTCnt);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBasePromTCnt.setValue( GXutil.rtrim( A1453PaiBasePromTCnt) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiBasePromTCnt.getInternalname(), "Values", cmbPaiBasePromTCnt.ToJavascriptSource(), true);
      }
      if ( dynPaiBaseRelSec.getItemCount() > 0 )
      {
         A2053PaiBaseRelSec = (int)(GXutil.lval( dynPaiBaseRelSec.getValidValue(GXutil.trim( GXutil.str( A2053PaiBaseRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2053PaiBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2053PaiBaseRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPaiBaseRelSec.setValue( GXutil.trim( GXutil.str( A2053PaiBaseRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynPaiBaseRelSec.getInternalname(), "Values", dynPaiBaseRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiBaseClaseLeg.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbPaiBaseClaseLeg.getInternalname(), httpContext.getMessage( "Clase de legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiBaseClaseLeg, cmbPaiBaseClaseLeg.getInternalname(), GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0)), 1, cmbPaiBaseClaseLeg.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbPaiBaseClaseLeg.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_Paisbase_calculo.htm");
      cmbPaiBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiBaseClaseLeg.getInternalname(), "Values", cmbPaiBaseClaseLeg.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiBaseTipo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbPaiBaseTipo.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiBaseTipo, cmbPaiBaseTipo.getInternalname(), GXutil.rtrim( A1441PaiBaseTipo), 1, cmbPaiBaseTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPaiBaseTipo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "", true, (byte)(0), "HLP_Paisbase_calculo.htm");
      cmbPaiBaseTipo.setValue( GXutil.rtrim( A1441PaiBaseTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiBaseTipo.getInternalname(), "Values", cmbPaiBaseTipo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPaibasecod1_cell_Internalname, 1, 0, "px", 0, "px", divPaibasecod1_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtPaiBaseCod1_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiBaseCod1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiBaseCod1_Internalname, httpContext.getMessage( "Código 1", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiBaseCod1_Internalname, GXutil.rtrim( A1442PaiBaseCod1), GXutil.rtrim( localUtil.format( A1442PaiBaseCod1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiBaseCod1_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiBaseCod1_Visible, edtPaiBaseCod1_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Paisbase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPaibasecod2_cell_Internalname, 1, 0, "px", 0, "px", divPaibasecod2_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtPaiBaseCod2_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiBaseCod2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiBaseCod2_Internalname, httpContext.getMessage( "Código 2", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiBaseCod2_Internalname, GXutil.rtrim( A1443PaiBaseCod2), GXutil.rtrim( localUtil.format( A1443PaiBaseCod2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiBaseCod2_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiBaseCod2_Visible, edtPaiBaseCod2_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Paisbase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiBasePlus_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiBasePlus_Internalname, httpContext.getMessage( "Porcentaje para plus", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiBasePlus_Internalname, GXutil.ltrim( localUtil.ntoc( A1444PaiBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiBasePlus_Enabled!=0) ? localUtil.format( A1444PaiBasePlus, "9.9999") : localUtil.format( A1444PaiBasePlus, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiBasePlus_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiBasePlus_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Paisbase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPailicdlim_cell_Internalname, 1, 0, "px", 0, "px", divPailicdlim_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtPaiLicDLim_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiLicDLim_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiLicDLim_Internalname, httpContext.getMessage( "Cantidad de días permitidos por licencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiLicDLim_Internalname, GXutil.ltrim( localUtil.ntoc( A1629PaiLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiLicDLim_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1629PaiLicDLim), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1629PaiLicDLim), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiLicDLim_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiLicDLim_Visible, edtPaiLicDLim_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paisbase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPailicdseman_cell_Internalname, 1, 0, "px", 0, "px", divPailicdseman_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtPaiLicDSeman_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiLicDSeman_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiLicDSeman_Internalname, httpContext.getMessage( "Cantidad de días permitidos por semana", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiLicDSeman_Internalname, GXutil.ltrim( localUtil.ntoc( A1630PaiLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiLicDSeman_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1630PaiLicDSeman), "9") : localUtil.format( DecimalUtil.doubleToDec(A1630PaiLicDSeman), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiLicDSeman_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiLicDSeman_Visible, edtPaiLicDSeman_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paisbase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPailicdmes_cell_Internalname, 1, 0, "px", 0, "px", divPailicdmes_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtPaiLicDMes_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiLicDMes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiLicDMes_Internalname, httpContext.getMessage( "Cantidad de días permitidos por mes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiLicDMes_Internalname, GXutil.ltrim( localUtil.ntoc( A1631PaiLicDMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiLicDMes_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1631PaiLicDMes), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1631PaiLicDMes), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,57);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiLicDMes_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiLicDMes_Visible, edtPaiLicDMes_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paisbase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPailicdsemes_cell_Internalname, 1, 0, "px", 0, "px", divPailicdsemes_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtPaiLicDSemes_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiLicDSemes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiLicDSemes_Internalname, httpContext.getMessage( "Cantidad de días permitidos por semestre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiLicDSemes_Internalname, GXutil.ltrim( localUtil.ntoc( A1632PaiLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiLicDSemes_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1632PaiLicDSemes), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1632PaiLicDSemes), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,62);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiLicDSemes_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiLicDSemes_Visible, edtPaiLicDSemes_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paisbase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPailicdanual_cell_Internalname, 1, 0, "px", 0, "px", divPailicdanual_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtPaiLicDAnual_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiLicDAnual_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiLicDAnual_Internalname, httpContext.getMessage( "Cantidad de días permitidos por año", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiLicDAnual_Internalname, GXutil.ltrim( localUtil.ntoc( A1633PaiLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiLicDAnual_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1633PaiLicDAnual), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1633PaiLicDAnual), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiLicDAnual_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiLicDAnual_Visible, edtPaiLicDAnual_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paisbase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPailicadju_cell_Internalname, 1, 0, "px", 0, "px", divPailicadju_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkPaiLicAdju.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiLicAdju.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkPaiLicAdju.getInternalname(), httpContext.getMessage( "Permite adjuntar documento", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiLicAdju.getInternalname(), GXutil.booltostr( A1634PaiLicAdju), "", httpContext.getMessage( "Permite adjuntar documento", ""), chkPaiLicAdju.getVisible(), chkPaiLicAdju.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(72, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,72);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPailicadjuobl_cell_Internalname, 1, 0, "px", 0, "px", divPailicadjuobl_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkPaiLicAdjuObl.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiLicAdjuObl.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkPaiLicAdjuObl.getInternalname(), httpContext.getMessage( "Obliga a adjuntar documento", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiLicAdjuObl.getInternalname(), GXutil.booltostr( A1635PaiLicAdjuObl), "", httpContext.getMessage( "Obliga a adjuntar documento", ""), chkPaiLicAdjuObl.getVisible(), chkPaiLicAdjuObl.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(77, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,77);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPailicnecaut_cell_Internalname, 1, 0, "px", 0, "px", divPailicnecaut_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkPaiLicNecAut.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiLicNecAut.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkPaiLicNecAut.getInternalname(), httpContext.getMessage( "Necesita autorización", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiLicNecAut.getInternalname(), GXutil.booltostr( A1636PaiLicNecAut), "", httpContext.getMessage( "Necesita autorización", ""), chkPaiLicNecAut.getVisible(), chkPaiLicNecAut.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(82, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,82);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPailicingmot_cell_Internalname, 1, 0, "px", 0, "px", divPailicingmot_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkPaiLicIngMot.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiLicIngMot.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkPaiLicIngMot.getInternalname(), httpContext.getMessage( "Permite ingresar motivo", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiLicIngMot.getInternalname(), GXutil.booltostr( A1637PaiLicIngMot), "", httpContext.getMessage( "Permite ingresar motivo", ""), chkPaiLicIngMot.getVisible(), chkPaiLicIngMot.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(87, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,87);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPailicmotobl_cell_Internalname, 1, 0, "px", 0, "px", divPailicmotobl_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkPaiLicMotObl.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiLicMotObl.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkPaiLicMotObl.getInternalname(), httpContext.getMessage( "Obliga a ingresar motivo", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiLicMotObl.getInternalname(), GXutil.booltostr( A1638PaiLicMotObl), "", httpContext.getMessage( "Obliga a ingresar motivo", ""), chkPaiLicMotObl.getVisible(), chkPaiLicMotObl.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(92, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,92);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiBasePromCnt1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiBasePromCnt1_Internalname, httpContext.getMessage( "Cantidad de días/meses a promediar", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiBasePromCnt1_Internalname, GXutil.ltrim( localUtil.ntoc( A1451PaiBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiBasePromCnt1_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1451PaiBasePromCnt1), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1451PaiBasePromCnt1), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,97);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiBasePromCnt1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiBasePromCnt1_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paisbase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiBasePromCnt2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiBasePromCnt2_Internalname, httpContext.getMessage( "segunda alternativa", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiBasePromCnt2_Internalname, GXutil.ltrim( localUtil.ntoc( A1452PaiBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiBasePromCnt2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1452PaiBasePromCnt2), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1452PaiBasePromCnt2), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,102);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiBasePromCnt2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiBasePromCnt2_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paisbase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiBasePromTCnt.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbPaiBasePromTCnt.getInternalname(), httpContext.getMessage( "Días o Meses", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiBasePromTCnt, cmbPaiBasePromTCnt.getInternalname(), GXutil.rtrim( A1453PaiBasePromTCnt), 1, cmbPaiBasePromTCnt.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPaiBasePromTCnt.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,107);\"", "", true, (byte)(0), "HLP_Paisbase_calculo.htm");
      cmbPaiBasePromTCnt.setValue( GXutil.rtrim( A1453PaiBasePromTCnt) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiBasePromTCnt.getInternalname(), "Values", cmbPaiBasePromTCnt.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPaibaserelsec_cell_Internalname, 1, 0, "px", 0, "px", divPaibaserelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynPaiBaseRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynPaiBaseRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynPaiBaseRelSec, dynPaiBaseRelSec.getInternalname(), GXutil.trim( GXutil.str( A2053PaiBaseRelSec, 6, 0)), 1, dynPaiBaseRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynPaiBaseRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,112);\"", "", true, (byte)(0), "HLP_Paisbase_calculo.htm");
      dynPaiBaseRelSec.setValue( GXutil.trim( GXutil.str( A2053PaiBaseRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynPaiBaseRelSec.getInternalname(), "Values", dynPaiBaseRelSec.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Paisbase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 122,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Paisbase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Paisbase_calculo.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 128,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,128);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiCod_Visible, edtPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Paisbase_calculo.htm");
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
      e114T2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1440PaiBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1440PaiBaseClaseLeg"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1441PaiBaseTipo = httpContext.cgiGet( "Z1441PaiBaseTipo") ;
            Z1442PaiBaseCod1 = httpContext.cgiGet( "Z1442PaiBaseCod1") ;
            Z1443PaiBaseCod2 = httpContext.cgiGet( "Z1443PaiBaseCod2") ;
            Z1444PaiBasePlus = localUtil.ctond( httpContext.cgiGet( "Z1444PaiBasePlus")) ;
            Z1629PaiLicDLim = (short)(localUtil.ctol( httpContext.cgiGet( "Z1629PaiLicDLim"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1630PaiLicDSeman = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1630PaiLicDSeman"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1631PaiLicDMes = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1631PaiLicDMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1632PaiLicDSemes = (short)(localUtil.ctol( httpContext.cgiGet( "Z1632PaiLicDSemes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1633PaiLicDAnual = (short)(localUtil.ctol( httpContext.cgiGet( "Z1633PaiLicDAnual"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1634PaiLicAdju = GXutil.strtobool( httpContext.cgiGet( "Z1634PaiLicAdju")) ;
            Z1635PaiLicAdjuObl = GXutil.strtobool( httpContext.cgiGet( "Z1635PaiLicAdjuObl")) ;
            Z1636PaiLicNecAut = GXutil.strtobool( httpContext.cgiGet( "Z1636PaiLicNecAut")) ;
            Z1637PaiLicIngMot = GXutil.strtobool( httpContext.cgiGet( "Z1637PaiLicIngMot")) ;
            Z1638PaiLicMotObl = GXutil.strtobool( httpContext.cgiGet( "Z1638PaiLicMotObl")) ;
            Z1451PaiBasePromCnt1 = (short)(localUtil.ctol( httpContext.cgiGet( "Z1451PaiBasePromCnt1"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1452PaiBasePromCnt2 = (short)(localUtil.ctol( httpContext.cgiGet( "Z1452PaiBasePromCnt2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1453PaiBasePromTCnt = httpContext.cgiGet( "Z1453PaiBasePromTCnt") ;
            Z2053PaiBaseRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z2053PaiBaseRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2054PaiBaseRelRef = httpContext.cgiGet( "Z2054PaiBaseRelRef") ;
            A2054PaiBaseRelRef = httpContext.cgiGet( "Z2054PaiBaseRelRef") ;
            O1453PaiBasePromTCnt = httpContext.cgiGet( "O1453PaiBasePromTCnt") ;
            O1452PaiBasePromCnt2 = (short)(localUtil.ctol( httpContext.cgiGet( "O1452PaiBasePromCnt2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1451PaiBasePromCnt1 = (short)(localUtil.ctol( httpContext.cgiGet( "O1451PaiBasePromCnt1"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1638PaiLicMotObl = GXutil.strtobool( httpContext.cgiGet( "O1638PaiLicMotObl")) ;
            O1637PaiLicIngMot = GXutil.strtobool( httpContext.cgiGet( "O1637PaiLicIngMot")) ;
            O1636PaiLicNecAut = GXutil.strtobool( httpContext.cgiGet( "O1636PaiLicNecAut")) ;
            O1635PaiLicAdjuObl = GXutil.strtobool( httpContext.cgiGet( "O1635PaiLicAdjuObl")) ;
            O1634PaiLicAdju = GXutil.strtobool( httpContext.cgiGet( "O1634PaiLicAdju")) ;
            O1633PaiLicDAnual = (short)(localUtil.ctol( httpContext.cgiGet( "O1633PaiLicDAnual"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1632PaiLicDSemes = (short)(localUtil.ctol( httpContext.cgiGet( "O1632PaiLicDSemes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1631PaiLicDMes = (byte)(localUtil.ctol( httpContext.cgiGet( "O1631PaiLicDMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1630PaiLicDSeman = (byte)(localUtil.ctol( httpContext.cgiGet( "O1630PaiLicDSeman"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1629PaiLicDLim = (short)(localUtil.ctol( httpContext.cgiGet( "O1629PaiLicDLim"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1444PaiBasePlus = localUtil.ctond( httpContext.cgiGet( "O1444PaiBasePlus")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            A1641PaiBaseC2Txt = httpContext.cgiGet( "PAIBASEC2TXT") ;
            A1640PaiBaseC1Txt = httpContext.cgiGet( "PAIBASEC1TXT") ;
            AV7PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8PaiBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( "vPAIBASECLASELEG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9PaiBaseTipo = httpContext.cgiGet( "vPAIBASETIPO") ;
            AV10PaiBaseCod1 = httpContext.cgiGet( "vPAIBASECOD1") ;
            AV11PaiBaseCod2 = httpContext.cgiGet( "vPAIBASECOD2") ;
            A1975PaiBaseOldDefault = httpContext.cgiGet( "PAIBASEOLDDEFAULT") ;
            AV18CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV17aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2054PaiBaseRelRef = httpContext.cgiGet( "PAIBASERELREF") ;
            A2069PaiBaseOld = httpContext.cgiGet( "PAIBASEOLD") ;
            AV19Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            cmbPaiBaseClaseLeg.setValue( httpContext.cgiGet( cmbPaiBaseClaseLeg.getInternalname()) );
            A1440PaiBaseClaseLeg = (byte)(GXutil.lval( httpContext.cgiGet( cmbPaiBaseClaseLeg.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
            cmbPaiBaseTipo.setValue( httpContext.cgiGet( cmbPaiBaseTipo.getInternalname()) );
            A1441PaiBaseTipo = httpContext.cgiGet( cmbPaiBaseTipo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
            A1442PaiBaseCod1 = httpContext.cgiGet( edtPaiBaseCod1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
            A1443PaiBaseCod2 = httpContext.cgiGet( edtPaiBaseCod2_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPaiBasePlus_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPaiBasePlus_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAIBASEPLUS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiBasePlus_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1444PaiBasePlus = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1444PaiBasePlus", GXutil.ltrimstr( A1444PaiBasePlus, 6, 4));
            }
            else
            {
               A1444PaiBasePlus = localUtil.ctond( httpContext.cgiGet( edtPaiBasePlus_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1444PaiBasePlus", GXutil.ltrimstr( A1444PaiBasePlus, 6, 4));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiLicDLim_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiLicDLim_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAILICDLIM");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiLicDLim_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1629PaiLicDLim = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1629PaiLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1629PaiLicDLim), 3, 0));
            }
            else
            {
               A1629PaiLicDLim = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiLicDLim_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1629PaiLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1629PaiLicDLim), 3, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiLicDSeman_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiLicDSeman_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAILICDSEMAN");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiLicDSeman_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1630PaiLicDSeman = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1630PaiLicDSeman", GXutil.str( A1630PaiLicDSeman, 1, 0));
            }
            else
            {
               A1630PaiLicDSeman = (byte)(localUtil.ctol( httpContext.cgiGet( edtPaiLicDSeman_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1630PaiLicDSeman", GXutil.str( A1630PaiLicDSeman, 1, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiLicDMes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiLicDMes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAILICDMES");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiLicDMes_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1631PaiLicDMes = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1631PaiLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1631PaiLicDMes), 2, 0));
            }
            else
            {
               A1631PaiLicDMes = (byte)(localUtil.ctol( httpContext.cgiGet( edtPaiLicDMes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1631PaiLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1631PaiLicDMes), 2, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiLicDSemes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiLicDSemes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAILICDSEMES");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiLicDSemes_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1632PaiLicDSemes = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1632PaiLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1632PaiLicDSemes), 3, 0));
            }
            else
            {
               A1632PaiLicDSemes = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiLicDSemes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1632PaiLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1632PaiLicDSemes), 3, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiLicDAnual_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiLicDAnual_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAILICDANUAL");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiLicDAnual_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1633PaiLicDAnual = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1633PaiLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1633PaiLicDAnual), 3, 0));
            }
            else
            {
               A1633PaiLicDAnual = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiLicDAnual_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1633PaiLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1633PaiLicDAnual), 3, 0));
            }
            A1634PaiLicAdju = GXutil.strtobool( httpContext.cgiGet( chkPaiLicAdju.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1634PaiLicAdju", A1634PaiLicAdju);
            A1635PaiLicAdjuObl = GXutil.strtobool( httpContext.cgiGet( chkPaiLicAdjuObl.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1635PaiLicAdjuObl", A1635PaiLicAdjuObl);
            A1636PaiLicNecAut = GXutil.strtobool( httpContext.cgiGet( chkPaiLicNecAut.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1636PaiLicNecAut", A1636PaiLicNecAut);
            A1637PaiLicIngMot = GXutil.strtobool( httpContext.cgiGet( chkPaiLicIngMot.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1637PaiLicIngMot", A1637PaiLicIngMot);
            A1638PaiLicMotObl = GXutil.strtobool( httpContext.cgiGet( chkPaiLicMotObl.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1638PaiLicMotObl", A1638PaiLicMotObl);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiBasePromCnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiBasePromCnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAIBASEPROMCNT1");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiBasePromCnt1_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1451PaiBasePromCnt1 = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1451PaiBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1451PaiBasePromCnt1), 3, 0));
            }
            else
            {
               A1451PaiBasePromCnt1 = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiBasePromCnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1451PaiBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1451PaiBasePromCnt1), 3, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiBasePromCnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiBasePromCnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAIBASEPROMCNT2");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiBasePromCnt2_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1452PaiBasePromCnt2 = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1452PaiBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1452PaiBasePromCnt2), 3, 0));
            }
            else
            {
               A1452PaiBasePromCnt2 = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiBasePromCnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1452PaiBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1452PaiBasePromCnt2), 3, 0));
            }
            cmbPaiBasePromTCnt.setValue( httpContext.cgiGet( cmbPaiBasePromTCnt.getInternalname()) );
            A1453PaiBasePromTCnt = httpContext.cgiGet( cmbPaiBasePromTCnt.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1453PaiBasePromTCnt", A1453PaiBasePromTCnt);
            dynPaiBaseRelSec.setValue( httpContext.cgiGet( dynPaiBaseRelSec.getInternalname()) );
            A2053PaiBaseRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynPaiBaseRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2053PaiBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2053PaiBaseRelSec), 6, 0));
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
            forbiddenHiddens.add("hshsalt", "hsh"+"Paisbase_calculo");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("PaiBaseRelRef", GXutil.rtrim( localUtil.format( A2054PaiBaseRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A46PaiCod != Z46PaiCod ) || ( A1440PaiBaseClaseLeg != Z1440PaiBaseClaseLeg ) || ( GXutil.strcmp(A1441PaiBaseTipo, Z1441PaiBaseTipo) != 0 ) || ( GXutil.strcmp(A1442PaiBaseCod1, Z1442PaiBaseCod1) != 0 ) || ( GXutil.strcmp(A1443PaiBaseCod2, Z1443PaiBaseCod2) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("paisbase_calculo:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1440PaiBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "PaiBaseClaseLeg"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
               A1441PaiBaseTipo = httpContext.GetPar( "PaiBaseTipo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
               A1442PaiBaseCod1 = httpContext.GetPar( "PaiBaseCod1") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
               A1443PaiBaseCod2 = httpContext.GetPar( "PaiBaseCod2") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
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
                  sMode183 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode183 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound183 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_4T0( ) ;
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
                        e114T2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e124T2 ();
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
         e124T2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll4T183( ) ;
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
         disableAttributes4T183( ) ;
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

   public void confirm_4T0( )
   {
      beforeValidate4T183( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4T183( ) ;
         }
         else
         {
            checkExtendedTable4T183( ) ;
            closeExtendedTableCursors4T183( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption4T0( )
   {
   }

   public void e114T2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV18CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      paisbase_calculo_impl.this.GXt_int1 = GXv_int2[0] ;
      AV18CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18CliCod), 6, 0));
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext3[0] = AV12WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV12WWPContext = GXv_SdtWWPContext3[0] ;
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisbase_calculo_Insert", GXv_boolean5) ;
         paisbase_calculo_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisbase_calculo_Update", GXv_boolean5) ;
         paisbase_calculo_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisbase_calculo_Delete", GXv_boolean5) ;
         paisbase_calculo_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV19Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV15TrnContext.fromxml(AV16WebSession.getValue("TrnContext"), null, null);
      edtPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Visible), 5, 0), true);
   }

   public void e124T2( )
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
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      edtPaiBaseCod1_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiBaseCod1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod1_Visible), 5, 0), true);
      divPaibasecod1_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divPaibasecod1_cell_Internalname, "Class", divPaibasecod1_cell_Class, true);
      edtPaiBaseCod2_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiBaseCod2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod2_Visible), 5, 0), true);
      divPaibasecod2_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divPaibasecod2_cell_Internalname, "Class", divPaibasecod2_cell_Class, true);
      edtPaiLicDLim_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDLim_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDLim_Visible), 5, 0), true);
      divPailicdlim_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divPailicdlim_cell_Internalname, "Class", divPailicdlim_cell_Class, true);
      edtPaiLicDSeman_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDSeman_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDSeman_Visible), 5, 0), true);
      divPailicdseman_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divPailicdseman_cell_Internalname, "Class", divPailicdseman_cell_Class, true);
      edtPaiLicDMes_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDMes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDMes_Visible), 5, 0), true);
      divPailicdmes_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divPailicdmes_cell_Internalname, "Class", divPailicdmes_cell_Class, true);
      edtPaiLicDSemes_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDSemes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDSemes_Visible), 5, 0), true);
      divPailicdsemes_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divPailicdsemes_cell_Internalname, "Class", divPailicdsemes_cell_Class, true);
      edtPaiLicDAnual_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDAnual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDAnual_Visible), 5, 0), true);
      divPailicdanual_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divPailicdanual_cell_Internalname, "Class", divPailicdanual_cell_Class, true);
      chkPaiLicAdju.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicAdju.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicAdju.getVisible(), 5, 0), true);
      divPailicadju_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divPailicadju_cell_Internalname, "Class", divPailicadju_cell_Class, true);
      chkPaiLicAdjuObl.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicAdjuObl.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicAdjuObl.getVisible(), 5, 0), true);
      divPailicadjuobl_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divPailicadjuobl_cell_Internalname, "Class", divPailicadjuobl_cell_Class, true);
      chkPaiLicNecAut.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicNecAut.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicNecAut.getVisible(), 5, 0), true);
      divPailicnecaut_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divPailicnecaut_cell_Internalname, "Class", divPailicnecaut_cell_Class, true);
      chkPaiLicIngMot.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicIngMot.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicIngMot.getVisible(), 5, 0), true);
      divPailicingmot_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divPailicingmot_cell_Internalname, "Class", divPailicingmot_cell_Class, true);
      chkPaiLicMotObl.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicMotObl.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicMotObl.getVisible(), 5, 0), true);
      divPailicmotobl_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divPailicmotobl_cell_Internalname, "Class", divPailicmotobl_cell_Class, true);
      divPaibaserelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divPaibaserelsec_cell_Internalname, "Class", divPaibaserelsec_cell_Class, true);
   }

   public void zm4T183( int GX_JID )
   {
      if ( ( GX_JID == 52 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1444PaiBasePlus = T004T3_A1444PaiBasePlus[0] ;
            Z1629PaiLicDLim = T004T3_A1629PaiLicDLim[0] ;
            Z1630PaiLicDSeman = T004T3_A1630PaiLicDSeman[0] ;
            Z1631PaiLicDMes = T004T3_A1631PaiLicDMes[0] ;
            Z1632PaiLicDSemes = T004T3_A1632PaiLicDSemes[0] ;
            Z1633PaiLicDAnual = T004T3_A1633PaiLicDAnual[0] ;
            Z1634PaiLicAdju = T004T3_A1634PaiLicAdju[0] ;
            Z1635PaiLicAdjuObl = T004T3_A1635PaiLicAdjuObl[0] ;
            Z1636PaiLicNecAut = T004T3_A1636PaiLicNecAut[0] ;
            Z1637PaiLicIngMot = T004T3_A1637PaiLicIngMot[0] ;
            Z1638PaiLicMotObl = T004T3_A1638PaiLicMotObl[0] ;
            Z1451PaiBasePromCnt1 = T004T3_A1451PaiBasePromCnt1[0] ;
            Z1452PaiBasePromCnt2 = T004T3_A1452PaiBasePromCnt2[0] ;
            Z1453PaiBasePromTCnt = T004T3_A1453PaiBasePromTCnt[0] ;
            Z2053PaiBaseRelSec = T004T3_A2053PaiBaseRelSec[0] ;
            Z2054PaiBaseRelRef = T004T3_A2054PaiBaseRelRef[0] ;
         }
         else
         {
            Z1444PaiBasePlus = A1444PaiBasePlus ;
            Z1629PaiLicDLim = A1629PaiLicDLim ;
            Z1630PaiLicDSeman = A1630PaiLicDSeman ;
            Z1631PaiLicDMes = A1631PaiLicDMes ;
            Z1632PaiLicDSemes = A1632PaiLicDSemes ;
            Z1633PaiLicDAnual = A1633PaiLicDAnual ;
            Z1634PaiLicAdju = A1634PaiLicAdju ;
            Z1635PaiLicAdjuObl = A1635PaiLicAdjuObl ;
            Z1636PaiLicNecAut = A1636PaiLicNecAut ;
            Z1637PaiLicIngMot = A1637PaiLicIngMot ;
            Z1638PaiLicMotObl = A1638PaiLicMotObl ;
            Z1451PaiBasePromCnt1 = A1451PaiBasePromCnt1 ;
            Z1452PaiBasePromCnt2 = A1452PaiBasePromCnt2 ;
            Z1453PaiBasePromTCnt = A1453PaiBasePromTCnt ;
            Z2053PaiBaseRelSec = A2053PaiBaseRelSec ;
            Z2054PaiBaseRelRef = A2054PaiBaseRelRef ;
         }
      }
      if ( GX_JID == -52 )
      {
         Z1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
         Z1441PaiBaseTipo = A1441PaiBaseTipo ;
         Z1442PaiBaseCod1 = A1442PaiBaseCod1 ;
         Z1443PaiBaseCod2 = A1443PaiBaseCod2 ;
         Z1975PaiBaseOldDefault = A1975PaiBaseOldDefault ;
         Z1444PaiBasePlus = A1444PaiBasePlus ;
         Z1629PaiLicDLim = A1629PaiLicDLim ;
         Z1630PaiLicDSeman = A1630PaiLicDSeman ;
         Z1631PaiLicDMes = A1631PaiLicDMes ;
         Z1632PaiLicDSemes = A1632PaiLicDSemes ;
         Z1633PaiLicDAnual = A1633PaiLicDAnual ;
         Z1634PaiLicAdju = A1634PaiLicAdju ;
         Z1635PaiLicAdjuObl = A1635PaiLicAdjuObl ;
         Z1636PaiLicNecAut = A1636PaiLicNecAut ;
         Z1637PaiLicIngMot = A1637PaiLicIngMot ;
         Z1638PaiLicMotObl = A1638PaiLicMotObl ;
         Z1451PaiBasePromCnt1 = A1451PaiBasePromCnt1 ;
         Z1452PaiBasePromCnt2 = A1452PaiBasePromCnt2 ;
         Z1453PaiBasePromTCnt = A1453PaiBasePromTCnt ;
         Z2053PaiBaseRelSec = A2053PaiBaseRelSec ;
         Z2054PaiBaseRelRef = A2054PaiBaseRelRef ;
         Z2069PaiBaseOld = A2069PaiBaseOld ;
         Z46PaiCod = A46PaiCod ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( true )
      {
         cmbPaiBaseClaseLeg.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiBaseClaseLeg.getEnabled(), 5, 0), true);
      }
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
      if ( ! (0==AV8PaiBaseClaseLeg) )
      {
         A1440PaiBaseClaseLeg = AV8PaiBaseClaseLeg ;
         httpContext.ajax_rsp_assign_attri("", false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
      }
      if ( ! (0==AV8PaiBaseClaseLeg) )
      {
         cmbPaiBaseClaseLeg.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiBaseClaseLeg.getEnabled(), 5, 0), true);
      }
      else
      {
         if ( true )
         {
            cmbPaiBaseClaseLeg.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbPaiBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiBaseClaseLeg.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbPaiBaseClaseLeg.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbPaiBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiBaseClaseLeg.getEnabled(), 5, 0), true);
         }
      }
      if ( ! (0==AV8PaiBaseClaseLeg) )
      {
         cmbPaiBaseClaseLeg.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiBaseClaseLeg.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9PaiBaseTipo)==0) )
      {
         A1441PaiBaseTipo = AV9PaiBaseTipo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
      }
      if ( ! (GXutil.strcmp("", AV9PaiBaseTipo)==0) )
      {
         cmbPaiBaseTipo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiBaseTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiBaseTipo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbPaiBaseTipo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiBaseTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiBaseTipo.getEnabled(), 5, 0), true);
      }
      edtPaiBaseCod1_Visible = ((GXutil.strcmp(AV9PaiBaseTipo, "horaNormal")!=0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiBaseCod1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod1_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV9PaiBaseTipo, "horaNormal") != 0 ) ) )
      {
         divPaibasecod1_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPaibasecod1_cell_Internalname, "Class", divPaibasecod1_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV9PaiBaseTipo, "horaNormal") != 0 )
         {
            divPaibasecod1_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPaibasecod1_cell_Internalname, "Class", divPaibasecod1_cell_Class, true);
         }
      }
      edtPaiBaseCod2_Visible = ((GXutil.strcmp(AV9PaiBaseTipo, "horaNormal")!=0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiBaseCod2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod2_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV9PaiBaseTipo, "horaNormal") != 0 ) ) )
      {
         divPaibasecod2_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPaibasecod2_cell_Internalname, "Class", divPaibasecod2_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV9PaiBaseTipo, "horaNormal") != 0 )
         {
            divPaibasecod2_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPaibasecod2_cell_Internalname, "Class", divPaibasecod2_cell_Class, true);
         }
      }
      edtPaiLicDLim_Visible = ((GXutil.strcmp(AV9PaiBaseTipo, "licencia")==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDLim_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDLim_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 ) ) )
      {
         divPailicdlim_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPailicdlim_cell_Internalname, "Class", divPailicdlim_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 )
         {
            divPailicdlim_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPailicdlim_cell_Internalname, "Class", divPailicdlim_cell_Class, true);
         }
      }
      edtPaiLicDSeman_Visible = ((GXutil.strcmp(AV9PaiBaseTipo, "licencia")==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDSeman_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDSeman_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 ) ) )
      {
         divPailicdseman_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPailicdseman_cell_Internalname, "Class", divPailicdseman_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 )
         {
            divPailicdseman_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPailicdseman_cell_Internalname, "Class", divPailicdseman_cell_Class, true);
         }
      }
      edtPaiLicDMes_Visible = ((GXutil.strcmp(AV9PaiBaseTipo, "licencia")==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDMes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDMes_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 ) ) )
      {
         divPailicdmes_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPailicdmes_cell_Internalname, "Class", divPailicdmes_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 )
         {
            divPailicdmes_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPailicdmes_cell_Internalname, "Class", divPailicdmes_cell_Class, true);
         }
      }
      edtPaiLicDSemes_Visible = ((GXutil.strcmp(AV9PaiBaseTipo, "licencia")==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDSemes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDSemes_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 ) ) )
      {
         divPailicdsemes_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPailicdsemes_cell_Internalname, "Class", divPailicdsemes_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 )
         {
            divPailicdsemes_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPailicdsemes_cell_Internalname, "Class", divPailicdsemes_cell_Class, true);
         }
      }
      edtPaiLicDAnual_Visible = ((GXutil.strcmp(AV9PaiBaseTipo, "licencia")==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDAnual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDAnual_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 ) ) )
      {
         divPailicdanual_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPailicdanual_cell_Internalname, "Class", divPailicdanual_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 )
         {
            divPailicdanual_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPailicdanual_cell_Internalname, "Class", divPailicdanual_cell_Class, true);
         }
      }
      chkPaiLicAdju.setVisible( ((GXutil.strcmp(AV9PaiBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicAdju.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicAdju.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 ) ) )
      {
         divPailicadju_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPailicadju_cell_Internalname, "Class", divPailicadju_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 )
         {
            divPailicadju_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPailicadju_cell_Internalname, "Class", divPailicadju_cell_Class, true);
         }
      }
      chkPaiLicAdjuObl.setVisible( ((GXutil.strcmp(AV9PaiBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicAdjuObl.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicAdjuObl.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 ) ) )
      {
         divPailicadjuobl_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPailicadjuobl_cell_Internalname, "Class", divPailicadjuobl_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 )
         {
            divPailicadjuobl_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPailicadjuobl_cell_Internalname, "Class", divPailicadjuobl_cell_Class, true);
         }
      }
      chkPaiLicNecAut.setVisible( ((GXutil.strcmp(AV9PaiBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicNecAut.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicNecAut.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 ) ) )
      {
         divPailicnecaut_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPailicnecaut_cell_Internalname, "Class", divPailicnecaut_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 )
         {
            divPailicnecaut_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPailicnecaut_cell_Internalname, "Class", divPailicnecaut_cell_Class, true);
         }
      }
      chkPaiLicIngMot.setVisible( ((GXutil.strcmp(AV9PaiBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicIngMot.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicIngMot.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 ) ) )
      {
         divPailicingmot_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPailicingmot_cell_Internalname, "Class", divPailicingmot_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 )
         {
            divPailicingmot_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPailicingmot_cell_Internalname, "Class", divPailicingmot_cell_Class, true);
         }
      }
      chkPaiLicMotObl.setVisible( ((GXutil.strcmp(AV9PaiBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicMotObl.getInternalname(), "Visible", GXutil.ltrimstr( chkPaiLicMotObl.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 ) ) )
      {
         divPailicmotobl_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPailicmotobl_cell_Internalname, "Class", divPailicmotobl_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV9PaiBaseTipo, "licencia") == 0 )
         {
            divPailicmotobl_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPailicmotobl_cell_Internalname, "Class", divPailicmotobl_cell_Class, true);
         }
      }
      if ( ! (GXutil.strcmp("", AV9PaiBaseTipo)==0) )
      {
         cmbPaiBaseTipo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiBaseTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiBaseTipo.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV10PaiBaseCod1)==0) )
      {
         A1442PaiBaseCod1 = AV10PaiBaseCod1 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
      }
      if ( ! (GXutil.strcmp("", AV10PaiBaseCod1)==0) )
      {
         edtPaiBaseCod1_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiBaseCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod1_Enabled), 5, 0), true);
      }
      else
      {
         edtPaiBaseCod1_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiBaseCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod1_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV10PaiBaseCod1)==0) )
      {
         edtPaiBaseCod1_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiBaseCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod1_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV11PaiBaseCod2)==0) )
      {
         A1443PaiBaseCod2 = AV11PaiBaseCod2 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
      }
      if ( ! (GXutil.strcmp("", AV11PaiBaseCod2)==0) )
      {
         edtPaiBaseCod2_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiBaseCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod2_Enabled), 5, 0), true);
      }
      else
      {
         edtPaiBaseCod2_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiBaseCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod2_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV11PaiBaseCod2)==0) )
      {
         edtPaiBaseCod2_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiBaseCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod2_Enabled), 5, 0), true);
      }
      gxapaibaserelsec_html4T183( AV18CliCod) ;
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
         AV19Pgmname = "Paisbase_calculo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19Pgmname", AV19Pgmname);
         GXt_char6 = A1640PaiBaseC1Txt ;
         GXv_char7[0] = GXt_char6 ;
         new web.gettxtbasecod1(remoteHandle, context).execute( 0, A1441PaiBaseTipo, A1442PaiBaseCod1, GXv_char7) ;
         paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
         A1640PaiBaseC1Txt = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1640PaiBaseC1Txt", A1640PaiBaseC1Txt);
         GXt_char6 = A1641PaiBaseC2Txt ;
         GXv_char7[0] = GXt_char6 ;
         new web.gettxtbasecod2(remoteHandle, context).execute( 0, A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, GXv_char7) ;
         paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
         A1641PaiBaseC2Txt = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1641PaiBaseC2Txt", A1641PaiBaseC2Txt);
      }
   }

   public void load4T183( )
   {
      /* Using cursor T004T5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound183 = (short)(1) ;
         A1975PaiBaseOldDefault = T004T5_A1975PaiBaseOldDefault[0] ;
         A1444PaiBasePlus = T004T5_A1444PaiBasePlus[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1444PaiBasePlus", GXutil.ltrimstr( A1444PaiBasePlus, 6, 4));
         A1629PaiLicDLim = T004T5_A1629PaiLicDLim[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1629PaiLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1629PaiLicDLim), 3, 0));
         A1630PaiLicDSeman = T004T5_A1630PaiLicDSeman[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1630PaiLicDSeman", GXutil.str( A1630PaiLicDSeman, 1, 0));
         A1631PaiLicDMes = T004T5_A1631PaiLicDMes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1631PaiLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1631PaiLicDMes), 2, 0));
         A1632PaiLicDSemes = T004T5_A1632PaiLicDSemes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1632PaiLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1632PaiLicDSemes), 3, 0));
         A1633PaiLicDAnual = T004T5_A1633PaiLicDAnual[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1633PaiLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1633PaiLicDAnual), 3, 0));
         A1634PaiLicAdju = T004T5_A1634PaiLicAdju[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1634PaiLicAdju", A1634PaiLicAdju);
         A1635PaiLicAdjuObl = T004T5_A1635PaiLicAdjuObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1635PaiLicAdjuObl", A1635PaiLicAdjuObl);
         A1636PaiLicNecAut = T004T5_A1636PaiLicNecAut[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1636PaiLicNecAut", A1636PaiLicNecAut);
         A1637PaiLicIngMot = T004T5_A1637PaiLicIngMot[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1637PaiLicIngMot", A1637PaiLicIngMot);
         A1638PaiLicMotObl = T004T5_A1638PaiLicMotObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1638PaiLicMotObl", A1638PaiLicMotObl);
         A1451PaiBasePromCnt1 = T004T5_A1451PaiBasePromCnt1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1451PaiBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1451PaiBasePromCnt1), 3, 0));
         A1452PaiBasePromCnt2 = T004T5_A1452PaiBasePromCnt2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1452PaiBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1452PaiBasePromCnt2), 3, 0));
         A1453PaiBasePromTCnt = T004T5_A1453PaiBasePromTCnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1453PaiBasePromTCnt", A1453PaiBasePromTCnt);
         A2053PaiBaseRelSec = T004T5_A2053PaiBaseRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2053PaiBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2053PaiBaseRelSec), 6, 0));
         A2054PaiBaseRelRef = T004T5_A2054PaiBaseRelRef[0] ;
         A2069PaiBaseOld = T004T5_A2069PaiBaseOld[0] ;
         zm4T183( -52) ;
      }
      pr_default.close(3);
      onLoadActions4T183( ) ;
   }

   public void onLoadActions4T183( )
   {
      AV19Pgmname = "Paisbase_calculo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Pgmname", AV19Pgmname);
      GXt_char6 = A1640PaiBaseC1Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( 0, A1441PaiBaseTipo, A1442PaiBaseCod1, GXv_char7) ;
      paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
      A1640PaiBaseC1Txt = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1640PaiBaseC1Txt", A1640PaiBaseC1Txt);
      GXt_char6 = A1641PaiBaseC2Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod2(remoteHandle, context).execute( 0, A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, GXv_char7) ;
      paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
      A1641PaiBaseC2Txt = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1641PaiBaseC2Txt", A1641PaiBaseC2Txt);
      if ( ! ( ( DecimalUtil.compareTo(A1444PaiBasePlus, O1444PaiBasePlus) != 0 ) || ( A1629PaiLicDLim != O1629PaiLicDLim ) || ( A1630PaiLicDSeman != O1630PaiLicDSeman ) || ( A1631PaiLicDMes != O1631PaiLicDMes ) || ( A1632PaiLicDSemes != O1632PaiLicDSemes ) || ( A1633PaiLicDAnual != O1633PaiLicDAnual ) || ( A1634PaiLicAdju != O1634PaiLicAdju ) || ( A1635PaiLicAdjuObl != O1635PaiLicAdjuObl ) || ( A1636PaiLicNecAut != O1636PaiLicNecAut ) || ( A1637PaiLicIngMot != O1637PaiLicIngMot ) || ( A1638PaiLicMotObl != O1638PaiLicMotObl ) || ( A1451PaiBasePromCnt1 != O1451PaiBasePromCnt1 ) || ( A1452PaiBasePromCnt2 != O1452PaiBasePromCnt2 ) || ( GXutil.strcmp(A1453PaiBasePromTCnt, O1453PaiBasePromTCnt) != 0 ) ) )
      {
         divPaibaserelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPaibaserelsec_cell_Internalname, "Class", divPaibaserelsec_cell_Class, true);
      }
      else
      {
         if ( ( DecimalUtil.compareTo(A1444PaiBasePlus, O1444PaiBasePlus) != 0 ) || ( A1629PaiLicDLim != O1629PaiLicDLim ) || ( A1630PaiLicDSeman != O1630PaiLicDSeman ) || ( A1631PaiLicDMes != O1631PaiLicDMes ) || ( A1632PaiLicDSemes != O1632PaiLicDSemes ) || ( A1633PaiLicDAnual != O1633PaiLicDAnual ) || ( A1634PaiLicAdju != O1634PaiLicAdju ) || ( A1635PaiLicAdjuObl != O1635PaiLicAdjuObl ) || ( A1636PaiLicNecAut != O1636PaiLicNecAut ) || ( A1637PaiLicIngMot != O1637PaiLicIngMot ) || ( A1638PaiLicMotObl != O1638PaiLicMotObl ) || ( A1451PaiBasePromCnt1 != O1451PaiBasePromCnt1 ) || ( A1452PaiBasePromCnt2 != O1452PaiBasePromCnt2 ) || ( GXutil.strcmp(A1453PaiBasePromTCnt, O1453PaiBasePromTCnt) != 0 ) )
         {
            divPaibaserelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPaibaserelsec_cell_Internalname, "Class", divPaibaserelsec_cell_Class, true);
         }
      }
      if ( isUpd( )  )
      {
         GXt_char6 = A1975PaiBaseOldDefault ;
         GXv_char7[0] = GXt_char6 ;
         new web.paisbase_setolddefault(remoteHandle, context).execute( O1444PaiBasePlus, O1629PaiLicDLim, O1630PaiLicDSeman, O1631PaiLicDMes, O1632PaiLicDSemes, O1633PaiLicDAnual, O1634PaiLicAdju, O1635PaiLicAdjuObl, O1636PaiLicNecAut, O1637PaiLicIngMot, O1638PaiLicMotObl, O1451PaiBasePromCnt1, O1452PaiBasePromCnt2, O1453PaiBasePromTCnt, GXv_char7) ;
         paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
         A1975PaiBaseOldDefault = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1975PaiBaseOldDefault", A1975PaiBaseOldDefault);
      }
   }

   public void checkExtendedTable4T183( )
   {
      nIsDirty_183 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV19Pgmname = "Paisbase_calculo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Pgmname", AV19Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV17aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV18CliCod, A2053PaiBaseRelSec, GXv_boolean5) ;
         paisbase_calculo_impl.this.AV17aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17aplicadoHay", AV17aplicadoHay);
      }
      /* Using cursor T004T4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( A1440PaiBaseClaseLeg == 1 ) || ( A1440PaiBaseClaseLeg == 2 ) || ( A1440PaiBaseClaseLeg == 3 ) || ( A1440PaiBaseClaseLeg == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Clase de legajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAIBASECLASELEG");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiBaseClaseLeg.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1441PaiBaseTipo, "licencia") == 0 ) || ( GXutil.strcmp(A1441PaiBaseTipo, "feriado") == 0 ) || ( GXutil.strcmp(A1441PaiBaseTipo, "horaNormal") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAIBASETIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiBaseTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      nIsDirty_183 = (short)(1) ;
      GXt_char6 = A1640PaiBaseC1Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( 0, A1441PaiBaseTipo, A1442PaiBaseCod1, GXv_char7) ;
      paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
      A1640PaiBaseC1Txt = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1640PaiBaseC1Txt", A1640PaiBaseC1Txt);
      nIsDirty_183 = (short)(1) ;
      GXt_char6 = A1641PaiBaseC2Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod2(remoteHandle, context).execute( 0, A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, GXv_char7) ;
      paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
      A1641PaiBaseC2Txt = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1641PaiBaseC2Txt", A1641PaiBaseC2Txt);
      if ( ! ( ( DecimalUtil.compareTo(A1444PaiBasePlus, O1444PaiBasePlus) != 0 ) || ( A1629PaiLicDLim != O1629PaiLicDLim ) || ( A1630PaiLicDSeman != O1630PaiLicDSeman ) || ( A1631PaiLicDMes != O1631PaiLicDMes ) || ( A1632PaiLicDSemes != O1632PaiLicDSemes ) || ( A1633PaiLicDAnual != O1633PaiLicDAnual ) || ( A1634PaiLicAdju != O1634PaiLicAdju ) || ( A1635PaiLicAdjuObl != O1635PaiLicAdjuObl ) || ( A1636PaiLicNecAut != O1636PaiLicNecAut ) || ( A1637PaiLicIngMot != O1637PaiLicIngMot ) || ( A1638PaiLicMotObl != O1638PaiLicMotObl ) || ( A1451PaiBasePromCnt1 != O1451PaiBasePromCnt1 ) || ( A1452PaiBasePromCnt2 != O1452PaiBasePromCnt2 ) || ( GXutil.strcmp(A1453PaiBasePromTCnt, O1453PaiBasePromTCnt) != 0 ) ) )
      {
         divPaibaserelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPaibaserelsec_cell_Internalname, "Class", divPaibaserelsec_cell_Class, true);
      }
      else
      {
         if ( ( DecimalUtil.compareTo(A1444PaiBasePlus, O1444PaiBasePlus) != 0 ) || ( A1629PaiLicDLim != O1629PaiLicDLim ) || ( A1630PaiLicDSeman != O1630PaiLicDSeman ) || ( A1631PaiLicDMes != O1631PaiLicDMes ) || ( A1632PaiLicDSemes != O1632PaiLicDSemes ) || ( A1633PaiLicDAnual != O1633PaiLicDAnual ) || ( A1634PaiLicAdju != O1634PaiLicAdju ) || ( A1635PaiLicAdjuObl != O1635PaiLicAdjuObl ) || ( A1636PaiLicNecAut != O1636PaiLicNecAut ) || ( A1637PaiLicIngMot != O1637PaiLicIngMot ) || ( A1638PaiLicMotObl != O1638PaiLicMotObl ) || ( A1451PaiBasePromCnt1 != O1451PaiBasePromCnt1 ) || ( A1452PaiBasePromCnt2 != O1452PaiBasePromCnt2 ) || ( GXutil.strcmp(A1453PaiBasePromTCnt, O1453PaiBasePromTCnt) != 0 ) )
         {
            divPaibaserelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPaibaserelsec_cell_Internalname, "Class", divPaibaserelsec_cell_Class, true);
         }
      }
      if ( isUpd( )  )
      {
         nIsDirty_183 = (short)(1) ;
         GXt_char6 = A1975PaiBaseOldDefault ;
         GXv_char7[0] = GXt_char6 ;
         new web.paisbase_setolddefault(remoteHandle, context).execute( O1444PaiBasePlus, O1629PaiLicDLim, O1630PaiLicDSeman, O1631PaiLicDMes, O1632PaiLicDSemes, O1633PaiLicDAnual, O1634PaiLicAdju, O1635PaiLicAdjuObl, O1636PaiLicNecAut, O1637PaiLicIngMot, O1638PaiLicMotObl, O1451PaiBasePromCnt1, O1452PaiBasePromCnt2, O1453PaiBasePromTCnt, GXv_char7) ;
         paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
         A1975PaiBaseOldDefault = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1975PaiBaseOldDefault", A1975PaiBaseOldDefault);
      }
      if ( ( ( DecimalUtil.compareTo(A1444PaiBasePlus, O1444PaiBasePlus) != 0 ) || ( A1629PaiLicDLim != O1629PaiLicDLim ) || ( A1630PaiLicDSeman != O1630PaiLicDSeman ) || ( A1631PaiLicDMes != O1631PaiLicDMes ) || ( A1632PaiLicDSemes != O1632PaiLicDSemes ) || ( A1633PaiLicDAnual != O1633PaiLicDAnual ) || ( A1634PaiLicAdju != O1634PaiLicAdju ) || ( A1635PaiLicAdjuObl != O1635PaiLicAdjuObl ) || ( A1636PaiLicNecAut != O1636PaiLicNecAut ) || ( A1637PaiLicIngMot != O1637PaiLicIngMot ) || ( A1638PaiLicMotObl != O1638PaiLicMotObl ) || ( A1451PaiBasePromCnt1 != O1451PaiBasePromCnt1 ) || ( A1452PaiBasePromCnt2 != O1452PaiBasePromCnt2 ) || ( GXutil.strcmp(A1453PaiBasePromTCnt, O1453PaiBasePromTCnt) != 0 ) ) && (0==A2053PaiBaseRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "PAIBASEPLUS");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiBasePlus_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1453PaiBasePromTCnt, "dias") == 0 ) || ( GXutil.strcmp(A1453PaiBasePromTCnt, "meses") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Días o Meses", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAIBASEPROMTCNT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiBasePromTCnt.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors4T183( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_53( short A46PaiCod )
   {
      /* Using cursor T004T6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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

   public void getKey4T183( )
   {
      /* Using cursor T004T7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound183 = (short)(1) ;
      }
      else
      {
         RcdFound183 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T004T3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm4T183( 52) ;
         RcdFound183 = (short)(1) ;
         A1440PaiBaseClaseLeg = T004T3_A1440PaiBaseClaseLeg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
         A1441PaiBaseTipo = T004T3_A1441PaiBaseTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
         A1442PaiBaseCod1 = T004T3_A1442PaiBaseCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
         A1443PaiBaseCod2 = T004T3_A1443PaiBaseCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
         A1975PaiBaseOldDefault = T004T3_A1975PaiBaseOldDefault[0] ;
         A1444PaiBasePlus = T004T3_A1444PaiBasePlus[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1444PaiBasePlus", GXutil.ltrimstr( A1444PaiBasePlus, 6, 4));
         A1629PaiLicDLim = T004T3_A1629PaiLicDLim[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1629PaiLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1629PaiLicDLim), 3, 0));
         A1630PaiLicDSeman = T004T3_A1630PaiLicDSeman[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1630PaiLicDSeman", GXutil.str( A1630PaiLicDSeman, 1, 0));
         A1631PaiLicDMes = T004T3_A1631PaiLicDMes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1631PaiLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1631PaiLicDMes), 2, 0));
         A1632PaiLicDSemes = T004T3_A1632PaiLicDSemes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1632PaiLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1632PaiLicDSemes), 3, 0));
         A1633PaiLicDAnual = T004T3_A1633PaiLicDAnual[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1633PaiLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1633PaiLicDAnual), 3, 0));
         A1634PaiLicAdju = T004T3_A1634PaiLicAdju[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1634PaiLicAdju", A1634PaiLicAdju);
         A1635PaiLicAdjuObl = T004T3_A1635PaiLicAdjuObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1635PaiLicAdjuObl", A1635PaiLicAdjuObl);
         A1636PaiLicNecAut = T004T3_A1636PaiLicNecAut[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1636PaiLicNecAut", A1636PaiLicNecAut);
         A1637PaiLicIngMot = T004T3_A1637PaiLicIngMot[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1637PaiLicIngMot", A1637PaiLicIngMot);
         A1638PaiLicMotObl = T004T3_A1638PaiLicMotObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1638PaiLicMotObl", A1638PaiLicMotObl);
         A1451PaiBasePromCnt1 = T004T3_A1451PaiBasePromCnt1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1451PaiBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1451PaiBasePromCnt1), 3, 0));
         A1452PaiBasePromCnt2 = T004T3_A1452PaiBasePromCnt2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1452PaiBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1452PaiBasePromCnt2), 3, 0));
         A1453PaiBasePromTCnt = T004T3_A1453PaiBasePromTCnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1453PaiBasePromTCnt", A1453PaiBasePromTCnt);
         A2053PaiBaseRelSec = T004T3_A2053PaiBaseRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2053PaiBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2053PaiBaseRelSec), 6, 0));
         A2054PaiBaseRelRef = T004T3_A2054PaiBaseRelRef[0] ;
         A2069PaiBaseOld = T004T3_A2069PaiBaseOld[0] ;
         A46PaiCod = T004T3_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         O1453PaiBasePromTCnt = A1453PaiBasePromTCnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1453PaiBasePromTCnt", A1453PaiBasePromTCnt);
         O1452PaiBasePromCnt2 = A1452PaiBasePromCnt2 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1452PaiBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1452PaiBasePromCnt2), 3, 0));
         O1451PaiBasePromCnt1 = A1451PaiBasePromCnt1 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1451PaiBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1451PaiBasePromCnt1), 3, 0));
         O1638PaiLicMotObl = A1638PaiLicMotObl ;
         httpContext.ajax_rsp_assign_attri("", false, "A1638PaiLicMotObl", A1638PaiLicMotObl);
         O1637PaiLicIngMot = A1637PaiLicIngMot ;
         httpContext.ajax_rsp_assign_attri("", false, "A1637PaiLicIngMot", A1637PaiLicIngMot);
         O1636PaiLicNecAut = A1636PaiLicNecAut ;
         httpContext.ajax_rsp_assign_attri("", false, "A1636PaiLicNecAut", A1636PaiLicNecAut);
         O1635PaiLicAdjuObl = A1635PaiLicAdjuObl ;
         httpContext.ajax_rsp_assign_attri("", false, "A1635PaiLicAdjuObl", A1635PaiLicAdjuObl);
         O1634PaiLicAdju = A1634PaiLicAdju ;
         httpContext.ajax_rsp_assign_attri("", false, "A1634PaiLicAdju", A1634PaiLicAdju);
         O1633PaiLicDAnual = A1633PaiLicDAnual ;
         httpContext.ajax_rsp_assign_attri("", false, "A1633PaiLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1633PaiLicDAnual), 3, 0));
         O1632PaiLicDSemes = A1632PaiLicDSemes ;
         httpContext.ajax_rsp_assign_attri("", false, "A1632PaiLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1632PaiLicDSemes), 3, 0));
         O1631PaiLicDMes = A1631PaiLicDMes ;
         httpContext.ajax_rsp_assign_attri("", false, "A1631PaiLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1631PaiLicDMes), 2, 0));
         O1630PaiLicDSeman = A1630PaiLicDSeman ;
         httpContext.ajax_rsp_assign_attri("", false, "A1630PaiLicDSeman", GXutil.str( A1630PaiLicDSeman, 1, 0));
         O1629PaiLicDLim = A1629PaiLicDLim ;
         httpContext.ajax_rsp_assign_attri("", false, "A1629PaiLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1629PaiLicDLim), 3, 0));
         O1444PaiBasePlus = A1444PaiBasePlus ;
         httpContext.ajax_rsp_assign_attri("", false, "A1444PaiBasePlus", GXutil.ltrimstr( A1444PaiBasePlus, 6, 4));
         Z46PaiCod = A46PaiCod ;
         Z1440PaiBaseClaseLeg = A1440PaiBaseClaseLeg ;
         Z1441PaiBaseTipo = A1441PaiBaseTipo ;
         Z1442PaiBaseCod1 = A1442PaiBaseCod1 ;
         Z1443PaiBaseCod2 = A1443PaiBaseCod2 ;
         sMode183 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load4T183( ) ;
         if ( AnyError == 1 )
         {
            RcdFound183 = (short)(0) ;
            initializeNonKey4T183( ) ;
         }
         Gx_mode = sMode183 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound183 = (short)(0) ;
         initializeNonKey4T183( ) ;
         sMode183 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode183 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey4T183( ) ;
      if ( RcdFound183 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound183 = (short)(0) ;
      /* Using cursor T004T8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), Byte.valueOf(A1440PaiBaseClaseLeg), Short.valueOf(A46PaiCod), A1441PaiBaseTipo, A1441PaiBaseTipo, Byte.valueOf(A1440PaiBaseClaseLeg), Short.valueOf(A46PaiCod), A1442PaiBaseCod1, A1442PaiBaseCod1, A1441PaiBaseTipo, Byte.valueOf(A1440PaiBaseClaseLeg), Short.valueOf(A46PaiCod), A1443PaiBaseCod2});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T004T8_A46PaiCod[0] < A46PaiCod ) || ( T004T8_A46PaiCod[0] == A46PaiCod ) && ( T004T8_A1440PaiBaseClaseLeg[0] < A1440PaiBaseClaseLeg ) || ( T004T8_A1440PaiBaseClaseLeg[0] == A1440PaiBaseClaseLeg ) && ( T004T8_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T004T8_A1441PaiBaseTipo[0], A1441PaiBaseTipo) < 0 ) || ( GXutil.strcmp(T004T8_A1441PaiBaseTipo[0], A1441PaiBaseTipo) == 0 ) && ( T004T8_A1440PaiBaseClaseLeg[0] == A1440PaiBaseClaseLeg ) && ( T004T8_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T004T8_A1442PaiBaseCod1[0], A1442PaiBaseCod1) < 0 ) || ( GXutil.strcmp(T004T8_A1442PaiBaseCod1[0], A1442PaiBaseCod1) == 0 ) && ( GXutil.strcmp(T004T8_A1441PaiBaseTipo[0], A1441PaiBaseTipo) == 0 ) && ( T004T8_A1440PaiBaseClaseLeg[0] == A1440PaiBaseClaseLeg ) && ( T004T8_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T004T8_A1443PaiBaseCod2[0], A1443PaiBaseCod2) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T004T8_A46PaiCod[0] > A46PaiCod ) || ( T004T8_A46PaiCod[0] == A46PaiCod ) && ( T004T8_A1440PaiBaseClaseLeg[0] > A1440PaiBaseClaseLeg ) || ( T004T8_A1440PaiBaseClaseLeg[0] == A1440PaiBaseClaseLeg ) && ( T004T8_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T004T8_A1441PaiBaseTipo[0], A1441PaiBaseTipo) > 0 ) || ( GXutil.strcmp(T004T8_A1441PaiBaseTipo[0], A1441PaiBaseTipo) == 0 ) && ( T004T8_A1440PaiBaseClaseLeg[0] == A1440PaiBaseClaseLeg ) && ( T004T8_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T004T8_A1442PaiBaseCod1[0], A1442PaiBaseCod1) > 0 ) || ( GXutil.strcmp(T004T8_A1442PaiBaseCod1[0], A1442PaiBaseCod1) == 0 ) && ( GXutil.strcmp(T004T8_A1441PaiBaseTipo[0], A1441PaiBaseTipo) == 0 ) && ( T004T8_A1440PaiBaseClaseLeg[0] == A1440PaiBaseClaseLeg ) && ( T004T8_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T004T8_A1443PaiBaseCod2[0], A1443PaiBaseCod2) > 0 ) ) )
         {
            A46PaiCod = T004T8_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A1440PaiBaseClaseLeg = T004T8_A1440PaiBaseClaseLeg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
            A1441PaiBaseTipo = T004T8_A1441PaiBaseTipo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
            A1442PaiBaseCod1 = T004T8_A1442PaiBaseCod1[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
            A1443PaiBaseCod2 = T004T8_A1443PaiBaseCod2[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
            RcdFound183 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound183 = (short)(0) ;
      /* Using cursor T004T9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), Byte.valueOf(A1440PaiBaseClaseLeg), Short.valueOf(A46PaiCod), A1441PaiBaseTipo, A1441PaiBaseTipo, Byte.valueOf(A1440PaiBaseClaseLeg), Short.valueOf(A46PaiCod), A1442PaiBaseCod1, A1442PaiBaseCod1, A1441PaiBaseTipo, Byte.valueOf(A1440PaiBaseClaseLeg), Short.valueOf(A46PaiCod), A1443PaiBaseCod2});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T004T9_A46PaiCod[0] > A46PaiCod ) || ( T004T9_A46PaiCod[0] == A46PaiCod ) && ( T004T9_A1440PaiBaseClaseLeg[0] > A1440PaiBaseClaseLeg ) || ( T004T9_A1440PaiBaseClaseLeg[0] == A1440PaiBaseClaseLeg ) && ( T004T9_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T004T9_A1441PaiBaseTipo[0], A1441PaiBaseTipo) > 0 ) || ( GXutil.strcmp(T004T9_A1441PaiBaseTipo[0], A1441PaiBaseTipo) == 0 ) && ( T004T9_A1440PaiBaseClaseLeg[0] == A1440PaiBaseClaseLeg ) && ( T004T9_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T004T9_A1442PaiBaseCod1[0], A1442PaiBaseCod1) > 0 ) || ( GXutil.strcmp(T004T9_A1442PaiBaseCod1[0], A1442PaiBaseCod1) == 0 ) && ( GXutil.strcmp(T004T9_A1441PaiBaseTipo[0], A1441PaiBaseTipo) == 0 ) && ( T004T9_A1440PaiBaseClaseLeg[0] == A1440PaiBaseClaseLeg ) && ( T004T9_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T004T9_A1443PaiBaseCod2[0], A1443PaiBaseCod2) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T004T9_A46PaiCod[0] < A46PaiCod ) || ( T004T9_A46PaiCod[0] == A46PaiCod ) && ( T004T9_A1440PaiBaseClaseLeg[0] < A1440PaiBaseClaseLeg ) || ( T004T9_A1440PaiBaseClaseLeg[0] == A1440PaiBaseClaseLeg ) && ( T004T9_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T004T9_A1441PaiBaseTipo[0], A1441PaiBaseTipo) < 0 ) || ( GXutil.strcmp(T004T9_A1441PaiBaseTipo[0], A1441PaiBaseTipo) == 0 ) && ( T004T9_A1440PaiBaseClaseLeg[0] == A1440PaiBaseClaseLeg ) && ( T004T9_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T004T9_A1442PaiBaseCod1[0], A1442PaiBaseCod1) < 0 ) || ( GXutil.strcmp(T004T9_A1442PaiBaseCod1[0], A1442PaiBaseCod1) == 0 ) && ( GXutil.strcmp(T004T9_A1441PaiBaseTipo[0], A1441PaiBaseTipo) == 0 ) && ( T004T9_A1440PaiBaseClaseLeg[0] == A1440PaiBaseClaseLeg ) && ( T004T9_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T004T9_A1443PaiBaseCod2[0], A1443PaiBaseCod2) < 0 ) ) )
         {
            A46PaiCod = T004T9_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A1440PaiBaseClaseLeg = T004T9_A1440PaiBaseClaseLeg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
            A1441PaiBaseTipo = T004T9_A1441PaiBaseTipo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
            A1442PaiBaseCod1 = T004T9_A1442PaiBaseCod1[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
            A1443PaiBaseCod2 = T004T9_A1443PaiBaseCod2[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
            RcdFound183 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4T183( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = cmbPaiBaseClaseLeg.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert4T183( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound183 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( A1440PaiBaseClaseLeg != Z1440PaiBaseClaseLeg ) || ( GXutil.strcmp(A1441PaiBaseTipo, Z1441PaiBaseTipo) != 0 ) || ( GXutil.strcmp(A1442PaiBaseCod1, Z1442PaiBaseCod1) != 0 ) || ( GXutil.strcmp(A1443PaiBaseCod2, Z1443PaiBaseCod2) != 0 ) )
            {
               A46PaiCod = Z46PaiCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A1440PaiBaseClaseLeg = Z1440PaiBaseClaseLeg ;
               httpContext.ajax_rsp_assign_attri("", false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
               A1441PaiBaseTipo = Z1441PaiBaseTipo ;
               httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
               A1442PaiBaseCod1 = Z1442PaiBaseCod1 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
               A1443PaiBaseCod2 = Z1443PaiBaseCod2 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = cmbPaiBaseClaseLeg.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update4T183( ) ;
               GX_FocusControl = cmbPaiBaseClaseLeg.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( A1440PaiBaseClaseLeg != Z1440PaiBaseClaseLeg ) || ( GXutil.strcmp(A1441PaiBaseTipo, Z1441PaiBaseTipo) != 0 ) || ( GXutil.strcmp(A1442PaiBaseCod1, Z1442PaiBaseCod1) != 0 ) || ( GXutil.strcmp(A1443PaiBaseCod2, Z1443PaiBaseCod2) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = cmbPaiBaseClaseLeg.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert4T183( ) ;
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
                  GX_FocusControl = cmbPaiBaseClaseLeg.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert4T183( ) ;
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
      if ( ( A46PaiCod != Z46PaiCod ) || ( A1440PaiBaseClaseLeg != Z1440PaiBaseClaseLeg ) || ( GXutil.strcmp(A1441PaiBaseTipo, Z1441PaiBaseTipo) != 0 ) || ( GXutil.strcmp(A1442PaiBaseCod1, Z1442PaiBaseCod1) != 0 ) || ( GXutil.strcmp(A1443PaiBaseCod2, Z1443PaiBaseCod2) != 0 ) )
      {
         A46PaiCod = Z46PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1440PaiBaseClaseLeg = Z1440PaiBaseClaseLeg ;
         httpContext.ajax_rsp_assign_attri("", false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
         A1441PaiBaseTipo = Z1441PaiBaseTipo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
         A1442PaiBaseCod1 = Z1442PaiBaseCod1 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
         A1443PaiBaseCod2 = Z1443PaiBaseCod2 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = cmbPaiBaseClaseLeg.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency4T183( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T004T2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paisbase_calculo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z1444PaiBasePlus, T004T2_A1444PaiBasePlus[0]) != 0 ) || ( Z1629PaiLicDLim != T004T2_A1629PaiLicDLim[0] ) || ( Z1630PaiLicDSeman != T004T2_A1630PaiLicDSeman[0] ) || ( Z1631PaiLicDMes != T004T2_A1631PaiLicDMes[0] ) || ( Z1632PaiLicDSemes != T004T2_A1632PaiLicDSemes[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1633PaiLicDAnual != T004T2_A1633PaiLicDAnual[0] ) || ( Z1634PaiLicAdju != T004T2_A1634PaiLicAdju[0] ) || ( Z1635PaiLicAdjuObl != T004T2_A1635PaiLicAdjuObl[0] ) || ( Z1636PaiLicNecAut != T004T2_A1636PaiLicNecAut[0] ) || ( Z1637PaiLicIngMot != T004T2_A1637PaiLicIngMot[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1638PaiLicMotObl != T004T2_A1638PaiLicMotObl[0] ) || ( Z1451PaiBasePromCnt1 != T004T2_A1451PaiBasePromCnt1[0] ) || ( Z1452PaiBasePromCnt2 != T004T2_A1452PaiBasePromCnt2[0] ) || ( GXutil.strcmp(Z1453PaiBasePromTCnt, T004T2_A1453PaiBasePromTCnt[0]) != 0 ) || ( Z2053PaiBaseRelSec != T004T2_A2053PaiBaseRelSec[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2054PaiBaseRelRef, T004T2_A2054PaiBaseRelRef[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z1444PaiBasePlus, T004T2_A1444PaiBasePlus[0]) != 0 )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiBasePlus");
               GXutil.writeLogRaw("Old: ",Z1444PaiBasePlus);
               GXutil.writeLogRaw("Current: ",T004T2_A1444PaiBasePlus[0]);
            }
            if ( Z1629PaiLicDLim != T004T2_A1629PaiLicDLim[0] )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiLicDLim");
               GXutil.writeLogRaw("Old: ",Z1629PaiLicDLim);
               GXutil.writeLogRaw("Current: ",T004T2_A1629PaiLicDLim[0]);
            }
            if ( Z1630PaiLicDSeman != T004T2_A1630PaiLicDSeman[0] )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiLicDSeman");
               GXutil.writeLogRaw("Old: ",Z1630PaiLicDSeman);
               GXutil.writeLogRaw("Current: ",T004T2_A1630PaiLicDSeman[0]);
            }
            if ( Z1631PaiLicDMes != T004T2_A1631PaiLicDMes[0] )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiLicDMes");
               GXutil.writeLogRaw("Old: ",Z1631PaiLicDMes);
               GXutil.writeLogRaw("Current: ",T004T2_A1631PaiLicDMes[0]);
            }
            if ( Z1632PaiLicDSemes != T004T2_A1632PaiLicDSemes[0] )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiLicDSemes");
               GXutil.writeLogRaw("Old: ",Z1632PaiLicDSemes);
               GXutil.writeLogRaw("Current: ",T004T2_A1632PaiLicDSemes[0]);
            }
            if ( Z1633PaiLicDAnual != T004T2_A1633PaiLicDAnual[0] )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiLicDAnual");
               GXutil.writeLogRaw("Old: ",Z1633PaiLicDAnual);
               GXutil.writeLogRaw("Current: ",T004T2_A1633PaiLicDAnual[0]);
            }
            if ( Z1634PaiLicAdju != T004T2_A1634PaiLicAdju[0] )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiLicAdju");
               GXutil.writeLogRaw("Old: ",Z1634PaiLicAdju);
               GXutil.writeLogRaw("Current: ",T004T2_A1634PaiLicAdju[0]);
            }
            if ( Z1635PaiLicAdjuObl != T004T2_A1635PaiLicAdjuObl[0] )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiLicAdjuObl");
               GXutil.writeLogRaw("Old: ",Z1635PaiLicAdjuObl);
               GXutil.writeLogRaw("Current: ",T004T2_A1635PaiLicAdjuObl[0]);
            }
            if ( Z1636PaiLicNecAut != T004T2_A1636PaiLicNecAut[0] )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiLicNecAut");
               GXutil.writeLogRaw("Old: ",Z1636PaiLicNecAut);
               GXutil.writeLogRaw("Current: ",T004T2_A1636PaiLicNecAut[0]);
            }
            if ( Z1637PaiLicIngMot != T004T2_A1637PaiLicIngMot[0] )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiLicIngMot");
               GXutil.writeLogRaw("Old: ",Z1637PaiLicIngMot);
               GXutil.writeLogRaw("Current: ",T004T2_A1637PaiLicIngMot[0]);
            }
            if ( Z1638PaiLicMotObl != T004T2_A1638PaiLicMotObl[0] )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiLicMotObl");
               GXutil.writeLogRaw("Old: ",Z1638PaiLicMotObl);
               GXutil.writeLogRaw("Current: ",T004T2_A1638PaiLicMotObl[0]);
            }
            if ( Z1451PaiBasePromCnt1 != T004T2_A1451PaiBasePromCnt1[0] )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiBasePromCnt1");
               GXutil.writeLogRaw("Old: ",Z1451PaiBasePromCnt1);
               GXutil.writeLogRaw("Current: ",T004T2_A1451PaiBasePromCnt1[0]);
            }
            if ( Z1452PaiBasePromCnt2 != T004T2_A1452PaiBasePromCnt2[0] )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiBasePromCnt2");
               GXutil.writeLogRaw("Old: ",Z1452PaiBasePromCnt2);
               GXutil.writeLogRaw("Current: ",T004T2_A1452PaiBasePromCnt2[0]);
            }
            if ( GXutil.strcmp(Z1453PaiBasePromTCnt, T004T2_A1453PaiBasePromTCnt[0]) != 0 )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiBasePromTCnt");
               GXutil.writeLogRaw("Old: ",Z1453PaiBasePromTCnt);
               GXutil.writeLogRaw("Current: ",T004T2_A1453PaiBasePromTCnt[0]);
            }
            if ( Z2053PaiBaseRelSec != T004T2_A2053PaiBaseRelSec[0] )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiBaseRelSec");
               GXutil.writeLogRaw("Old: ",Z2053PaiBaseRelSec);
               GXutil.writeLogRaw("Current: ",T004T2_A2053PaiBaseRelSec[0]);
            }
            if ( GXutil.strcmp(Z2054PaiBaseRelRef, T004T2_A2054PaiBaseRelRef[0]) != 0 )
            {
               GXutil.writeLogln("paisbase_calculo:[seudo value changed for attri]"+"PaiBaseRelRef");
               GXutil.writeLogRaw("Old: ",Z2054PaiBaseRelRef);
               GXutil.writeLogRaw("Current: ",T004T2_A2054PaiBaseRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Paisbase_calculo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4T183( )
   {
      beforeValidate4T183( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4T183( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4T183( 0) ;
         checkOptimisticConcurrency4T183( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4T183( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4T183( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004T10 */
                  pr_default.execute(8, new Object[] {Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, A1975PaiBaseOldDefault, A1444PaiBasePlus, Short.valueOf(A1629PaiLicDLim), Byte.valueOf(A1630PaiLicDSeman), Byte.valueOf(A1631PaiLicDMes), Short.valueOf(A1632PaiLicDSemes), Short.valueOf(A1633PaiLicDAnual), Boolean.valueOf(A1634PaiLicAdju), Boolean.valueOf(A1635PaiLicAdjuObl), Boolean.valueOf(A1636PaiLicNecAut), Boolean.valueOf(A1637PaiLicIngMot), Boolean.valueOf(A1638PaiLicMotObl), Short.valueOf(A1451PaiBasePromCnt1), Short.valueOf(A1452PaiBasePromCnt2), A1453PaiBasePromTCnt, Integer.valueOf(A2053PaiBaseRelSec), A2054PaiBaseRelRef, A2069PaiBaseOld, Short.valueOf(A46PaiCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisbase_calculo");
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
                        resetCaption4T0( ) ;
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
            load4T183( ) ;
         }
         endLevel4T183( ) ;
      }
      closeExtendedTableCursors4T183( ) ;
   }

   public void update4T183( )
   {
      beforeValidate4T183( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4T183( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4T183( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4T183( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4T183( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004T11 */
                  pr_default.execute(9, new Object[] {A1975PaiBaseOldDefault, A1444PaiBasePlus, Short.valueOf(A1629PaiLicDLim), Byte.valueOf(A1630PaiLicDSeman), Byte.valueOf(A1631PaiLicDMes), Short.valueOf(A1632PaiLicDSemes), Short.valueOf(A1633PaiLicDAnual), Boolean.valueOf(A1634PaiLicAdju), Boolean.valueOf(A1635PaiLicAdjuObl), Boolean.valueOf(A1636PaiLicNecAut), Boolean.valueOf(A1637PaiLicIngMot), Boolean.valueOf(A1638PaiLicMotObl), Short.valueOf(A1451PaiBasePromCnt1), Short.valueOf(A1452PaiBasePromCnt2), A1453PaiBasePromTCnt, Integer.valueOf(A2053PaiBaseRelSec), A2054PaiBaseRelRef, A2069PaiBaseOld, Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisbase_calculo");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paisbase_calculo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4T183( ) ;
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
         endLevel4T183( ) ;
      }
      closeExtendedTableCursors4T183( ) ;
   }

   public void deferredUpdate4T183( )
   {
   }

   public void delete( )
   {
      beforeValidate4T183( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4T183( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4T183( ) ;
         afterConfirm4T183( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4T183( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T004T12 */
               pr_default.execute(10, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisbase_calculo");
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
      sMode183 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel4T183( ) ;
      Gx_mode = sMode183 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls4T183( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV17aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV18CliCod, A2053PaiBaseRelSec, GXv_boolean5) ;
            paisbase_calculo_impl.this.AV17aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17aplicadoHay", AV17aplicadoHay);
         }
         AV19Pgmname = "Paisbase_calculo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19Pgmname", AV19Pgmname);
         GXt_char6 = A1640PaiBaseC1Txt ;
         GXv_char7[0] = GXt_char6 ;
         new web.gettxtbasecod1(remoteHandle, context).execute( 0, A1441PaiBaseTipo, A1442PaiBaseCod1, GXv_char7) ;
         paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
         A1640PaiBaseC1Txt = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1640PaiBaseC1Txt", A1640PaiBaseC1Txt);
         GXt_char6 = A1641PaiBaseC2Txt ;
         GXv_char7[0] = GXt_char6 ;
         new web.gettxtbasecod2(remoteHandle, context).execute( 0, A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, GXv_char7) ;
         paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
         A1641PaiBaseC2Txt = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1641PaiBaseC2Txt", A1641PaiBaseC2Txt);
         if ( ! ( ( DecimalUtil.compareTo(A1444PaiBasePlus, O1444PaiBasePlus) != 0 ) || ( A1629PaiLicDLim != O1629PaiLicDLim ) || ( A1630PaiLicDSeman != O1630PaiLicDSeman ) || ( A1631PaiLicDMes != O1631PaiLicDMes ) || ( A1632PaiLicDSemes != O1632PaiLicDSemes ) || ( A1633PaiLicDAnual != O1633PaiLicDAnual ) || ( A1634PaiLicAdju != O1634PaiLicAdju ) || ( A1635PaiLicAdjuObl != O1635PaiLicAdjuObl ) || ( A1636PaiLicNecAut != O1636PaiLicNecAut ) || ( A1637PaiLicIngMot != O1637PaiLicIngMot ) || ( A1638PaiLicMotObl != O1638PaiLicMotObl ) || ( A1451PaiBasePromCnt1 != O1451PaiBasePromCnt1 ) || ( A1452PaiBasePromCnt2 != O1452PaiBasePromCnt2 ) || ( GXutil.strcmp(A1453PaiBasePromTCnt, O1453PaiBasePromTCnt) != 0 ) ) )
         {
            divPaibaserelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPaibaserelsec_cell_Internalname, "Class", divPaibaserelsec_cell_Class, true);
         }
         else
         {
            if ( ( DecimalUtil.compareTo(A1444PaiBasePlus, O1444PaiBasePlus) != 0 ) || ( A1629PaiLicDLim != O1629PaiLicDLim ) || ( A1630PaiLicDSeman != O1630PaiLicDSeman ) || ( A1631PaiLicDMes != O1631PaiLicDMes ) || ( A1632PaiLicDSemes != O1632PaiLicDSemes ) || ( A1633PaiLicDAnual != O1633PaiLicDAnual ) || ( A1634PaiLicAdju != O1634PaiLicAdju ) || ( A1635PaiLicAdjuObl != O1635PaiLicAdjuObl ) || ( A1636PaiLicNecAut != O1636PaiLicNecAut ) || ( A1637PaiLicIngMot != O1637PaiLicIngMot ) || ( A1638PaiLicMotObl != O1638PaiLicMotObl ) || ( A1451PaiBasePromCnt1 != O1451PaiBasePromCnt1 ) || ( A1452PaiBasePromCnt2 != O1452PaiBasePromCnt2 ) || ( GXutil.strcmp(A1453PaiBasePromTCnt, O1453PaiBasePromTCnt) != 0 ) )
            {
               divPaibaserelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divPaibaserelsec_cell_Internalname, "Class", divPaibaserelsec_cell_Class, true);
            }
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T004T13 */
         pr_default.execute(11, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Promedio de remuneraciones anteiores", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
         /* Using cursor T004T14 */
         pr_default.execute(12, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos remuneración actual", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
   }

   public void endLevel4T183( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4T183( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "paisbase_calculo");
         if ( AnyError == 0 )
         {
            confirmValues4T0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "paisbase_calculo");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart4T183( )
   {
      /* Scan By routine */
      /* Using cursor T004T15 */
      pr_default.execute(13);
      RcdFound183 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound183 = (short)(1) ;
         A46PaiCod = T004T15_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1440PaiBaseClaseLeg = T004T15_A1440PaiBaseClaseLeg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
         A1441PaiBaseTipo = T004T15_A1441PaiBaseTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
         A1442PaiBaseCod1 = T004T15_A1442PaiBaseCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
         A1443PaiBaseCod2 = T004T15_A1443PaiBaseCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext4T183( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound183 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound183 = (short)(1) ;
         A46PaiCod = T004T15_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1440PaiBaseClaseLeg = T004T15_A1440PaiBaseClaseLeg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
         A1441PaiBaseTipo = T004T15_A1441PaiBaseTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
         A1442PaiBaseCod1 = T004T15_A1442PaiBaseCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
         A1443PaiBaseCod2 = T004T15_A1443PaiBaseCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
      }
   }

   public void scanEnd4T183( )
   {
      pr_default.close(13);
   }

   public void afterConfirm4T183( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV17aplicadoHay ) && ! (0==A2053PaiBaseRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV18CliCod), "PaiBaseRelSec", 1, "PAIBASERELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPaiBaseRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert4T183( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4T183( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4T183( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4T183( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4T183( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4T183( )
   {
      cmbPaiBaseClaseLeg.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiBaseClaseLeg.getEnabled(), 5, 0), true);
      cmbPaiBaseTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiBaseTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiBaseTipo.getEnabled(), 5, 0), true);
      edtPaiBaseCod1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiBaseCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod1_Enabled), 5, 0), true);
      edtPaiBaseCod2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiBaseCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBaseCod2_Enabled), 5, 0), true);
      edtPaiBasePlus_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiBasePlus_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBasePlus_Enabled), 5, 0), true);
      edtPaiLicDLim_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDLim_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDLim_Enabled), 5, 0), true);
      edtPaiLicDSeman_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDSeman_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDSeman_Enabled), 5, 0), true);
      edtPaiLicDMes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDMes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDMes_Enabled), 5, 0), true);
      edtPaiLicDSemes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDSemes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDSemes_Enabled), 5, 0), true);
      edtPaiLicDAnual_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiLicDAnual_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiLicDAnual_Enabled), 5, 0), true);
      chkPaiLicAdju.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicAdju.getInternalname(), "Enabled", GXutil.ltrimstr( chkPaiLicAdju.getEnabled(), 5, 0), true);
      chkPaiLicAdjuObl.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicAdjuObl.getInternalname(), "Enabled", GXutil.ltrimstr( chkPaiLicAdjuObl.getEnabled(), 5, 0), true);
      chkPaiLicNecAut.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicNecAut.getInternalname(), "Enabled", GXutil.ltrimstr( chkPaiLicNecAut.getEnabled(), 5, 0), true);
      chkPaiLicIngMot.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicIngMot.getInternalname(), "Enabled", GXutil.ltrimstr( chkPaiLicIngMot.getEnabled(), 5, 0), true);
      chkPaiLicMotObl.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicMotObl.getInternalname(), "Enabled", GXutil.ltrimstr( chkPaiLicMotObl.getEnabled(), 5, 0), true);
      edtPaiBasePromCnt1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiBasePromCnt1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBasePromCnt1_Enabled), 5, 0), true);
      edtPaiBasePromCnt2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiBasePromCnt2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiBasePromCnt2_Enabled), 5, 0), true);
      cmbPaiBasePromTCnt.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiBasePromTCnt.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiBasePromTCnt.getEnabled(), 5, 0), true);
      dynPaiBaseRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynPaiBaseRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynPaiBaseRelSec.getEnabled(), 5, 0), true);
      edtPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes4T183( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues4T0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.paisbase_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8PaiBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(AV9PaiBaseTipo)),GXutil.URLEncode(GXutil.rtrim(AV10PaiBaseCod1)),GXutil.URLEncode(GXutil.rtrim(AV11PaiBaseCod2))}, new String[] {"Gx_mode","PaiCod","PaiBaseClaseLeg","PaiBaseTipo","PaiBaseCod1","PaiBaseCod2"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Paisbase_calculo");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("PaiBaseRelRef", GXutil.rtrim( localUtil.format( A2054PaiBaseRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("paisbase_calculo:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1440PaiBaseClaseLeg", GXutil.ltrim( localUtil.ntoc( Z1440PaiBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1441PaiBaseTipo", GXutil.rtrim( Z1441PaiBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1442PaiBaseCod1", GXutil.rtrim( Z1442PaiBaseCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1443PaiBaseCod2", GXutil.rtrim( Z1443PaiBaseCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1444PaiBasePlus", GXutil.ltrim( localUtil.ntoc( Z1444PaiBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1629PaiLicDLim", GXutil.ltrim( localUtil.ntoc( Z1629PaiLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1630PaiLicDSeman", GXutil.ltrim( localUtil.ntoc( Z1630PaiLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1631PaiLicDMes", GXutil.ltrim( localUtil.ntoc( Z1631PaiLicDMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1632PaiLicDSemes", GXutil.ltrim( localUtil.ntoc( Z1632PaiLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1633PaiLicDAnual", GXutil.ltrim( localUtil.ntoc( Z1633PaiLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1634PaiLicAdju", Z1634PaiLicAdju);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1635PaiLicAdjuObl", Z1635PaiLicAdjuObl);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1636PaiLicNecAut", Z1636PaiLicNecAut);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1637PaiLicIngMot", Z1637PaiLicIngMot);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1638PaiLicMotObl", Z1638PaiLicMotObl);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1451PaiBasePromCnt1", GXutil.ltrim( localUtil.ntoc( Z1451PaiBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1452PaiBasePromCnt2", GXutil.ltrim( localUtil.ntoc( Z1452PaiBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1453PaiBasePromTCnt", GXutil.rtrim( Z1453PaiBasePromTCnt));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2053PaiBaseRelSec", GXutil.ltrim( localUtil.ntoc( Z2053PaiBaseRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2054PaiBaseRelRef", Z2054PaiBaseRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "O1453PaiBasePromTCnt", GXutil.rtrim( O1453PaiBasePromTCnt));
      web.GxWebStd.gx_hidden_field( httpContext, "O1452PaiBasePromCnt2", GXutil.ltrim( localUtil.ntoc( O1452PaiBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1451PaiBasePromCnt1", GXutil.ltrim( localUtil.ntoc( O1451PaiBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1638PaiLicMotObl", O1638PaiLicMotObl);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1637PaiLicIngMot", O1637PaiLicIngMot);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1636PaiLicNecAut", O1636PaiLicNecAut);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1635PaiLicAdjuObl", O1635PaiLicAdjuObl);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1634PaiLicAdju", O1634PaiLicAdju);
      web.GxWebStd.gx_hidden_field( httpContext, "O1633PaiLicDAnual", GXutil.ltrim( localUtil.ntoc( O1633PaiLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1632PaiLicDSemes", GXutil.ltrim( localUtil.ntoc( O1632PaiLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1631PaiLicDMes", GXutil.ltrim( localUtil.ntoc( O1631PaiLicDMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1630PaiLicDSeman", GXutil.ltrim( localUtil.ntoc( O1630PaiLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1629PaiLicDLim", GXutil.ltrim( localUtil.ntoc( O1629PaiLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1444PaiBasePlus", GXutil.ltrim( localUtil.ntoc( O1444PaiBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "PAIBASEC2TXT", A1641PaiBaseC2Txt);
      web.GxWebStd.gx_hidden_field( httpContext, "PAIBASEC1TXT", A1640PaiBaseC1Txt);
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV7PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAIBASECLASELEG", GXutil.ltrim( localUtil.ntoc( AV8PaiBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAIBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8PaiBaseClaseLeg), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAIBASETIPO", GXutil.rtrim( AV9PaiBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAIBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9PaiBaseTipo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAIBASECOD1", GXutil.rtrim( AV10PaiBaseCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAIBASECOD1", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10PaiBaseCod1, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAIBASECOD2", GXutil.rtrim( AV11PaiBaseCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAIBASECOD2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11PaiBaseCod2, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "PAIBASEOLDDEFAULT", A1975PaiBaseOldDefault);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV18CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV17aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "PAIBASERELREF", A2054PaiBaseRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "PAIBASEOLD", A2069PaiBaseOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV19Pgmname));
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
      return formatLink("web.paisbase_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8PaiBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(AV9PaiBaseTipo)),GXutil.URLEncode(GXutil.rtrim(AV10PaiBaseCod1)),GXutil.URLEncode(GXutil.rtrim(AV11PaiBaseCod2))}, new String[] {"Gx_mode","PaiCod","PaiBaseClaseLeg","PaiBaseTipo","PaiBaseCod1","PaiBaseCod2"})  ;
   }

   public String getPgmname( )
   {
      return "Paisbase_calculo" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Paisbase_calculo", "") ;
   }

   public void initializeNonKey4T183( )
   {
      A1975PaiBaseOldDefault = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1975PaiBaseOldDefault", A1975PaiBaseOldDefault);
      AV17aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17aplicadoHay", AV17aplicadoHay);
      A1640PaiBaseC1Txt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1640PaiBaseC1Txt", A1640PaiBaseC1Txt);
      A1641PaiBaseC2Txt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1641PaiBaseC2Txt", A1641PaiBaseC2Txt);
      A1444PaiBasePlus = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1444PaiBasePlus", GXutil.ltrimstr( A1444PaiBasePlus, 6, 4));
      A1629PaiLicDLim = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1629PaiLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1629PaiLicDLim), 3, 0));
      A1630PaiLicDSeman = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1630PaiLicDSeman", GXutil.str( A1630PaiLicDSeman, 1, 0));
      A1631PaiLicDMes = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1631PaiLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1631PaiLicDMes), 2, 0));
      A1632PaiLicDSemes = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1632PaiLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1632PaiLicDSemes), 3, 0));
      A1633PaiLicDAnual = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1633PaiLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1633PaiLicDAnual), 3, 0));
      A1634PaiLicAdju = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1634PaiLicAdju", A1634PaiLicAdju);
      A1635PaiLicAdjuObl = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1635PaiLicAdjuObl", A1635PaiLicAdjuObl);
      A1636PaiLicNecAut = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1636PaiLicNecAut", A1636PaiLicNecAut);
      A1637PaiLicIngMot = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1637PaiLicIngMot", A1637PaiLicIngMot);
      A1638PaiLicMotObl = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1638PaiLicMotObl", A1638PaiLicMotObl);
      A1451PaiBasePromCnt1 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1451PaiBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1451PaiBasePromCnt1), 3, 0));
      A1452PaiBasePromCnt2 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1452PaiBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1452PaiBasePromCnt2), 3, 0));
      A1453PaiBasePromTCnt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1453PaiBasePromTCnt", A1453PaiBasePromTCnt);
      A2053PaiBaseRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2053PaiBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2053PaiBaseRelSec), 6, 0));
      A2054PaiBaseRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2054PaiBaseRelRef", A2054PaiBaseRelRef);
      A2069PaiBaseOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2069PaiBaseOld", A2069PaiBaseOld);
      O1453PaiBasePromTCnt = A1453PaiBasePromTCnt ;
      httpContext.ajax_rsp_assign_attri("", false, "A1453PaiBasePromTCnt", A1453PaiBasePromTCnt);
      O1452PaiBasePromCnt2 = A1452PaiBasePromCnt2 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1452PaiBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1452PaiBasePromCnt2), 3, 0));
      O1451PaiBasePromCnt1 = A1451PaiBasePromCnt1 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1451PaiBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1451PaiBasePromCnt1), 3, 0));
      O1638PaiLicMotObl = A1638PaiLicMotObl ;
      httpContext.ajax_rsp_assign_attri("", false, "A1638PaiLicMotObl", A1638PaiLicMotObl);
      O1637PaiLicIngMot = A1637PaiLicIngMot ;
      httpContext.ajax_rsp_assign_attri("", false, "A1637PaiLicIngMot", A1637PaiLicIngMot);
      O1636PaiLicNecAut = A1636PaiLicNecAut ;
      httpContext.ajax_rsp_assign_attri("", false, "A1636PaiLicNecAut", A1636PaiLicNecAut);
      O1635PaiLicAdjuObl = A1635PaiLicAdjuObl ;
      httpContext.ajax_rsp_assign_attri("", false, "A1635PaiLicAdjuObl", A1635PaiLicAdjuObl);
      O1634PaiLicAdju = A1634PaiLicAdju ;
      httpContext.ajax_rsp_assign_attri("", false, "A1634PaiLicAdju", A1634PaiLicAdju);
      O1633PaiLicDAnual = A1633PaiLicDAnual ;
      httpContext.ajax_rsp_assign_attri("", false, "A1633PaiLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1633PaiLicDAnual), 3, 0));
      O1632PaiLicDSemes = A1632PaiLicDSemes ;
      httpContext.ajax_rsp_assign_attri("", false, "A1632PaiLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1632PaiLicDSemes), 3, 0));
      O1631PaiLicDMes = A1631PaiLicDMes ;
      httpContext.ajax_rsp_assign_attri("", false, "A1631PaiLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1631PaiLicDMes), 2, 0));
      O1630PaiLicDSeman = A1630PaiLicDSeman ;
      httpContext.ajax_rsp_assign_attri("", false, "A1630PaiLicDSeman", GXutil.str( A1630PaiLicDSeman, 1, 0));
      O1629PaiLicDLim = A1629PaiLicDLim ;
      httpContext.ajax_rsp_assign_attri("", false, "A1629PaiLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1629PaiLicDLim), 3, 0));
      O1444PaiBasePlus = A1444PaiBasePlus ;
      httpContext.ajax_rsp_assign_attri("", false, "A1444PaiBasePlus", GXutil.ltrimstr( A1444PaiBasePlus, 6, 4));
      Z1444PaiBasePlus = DecimalUtil.ZERO ;
      Z1629PaiLicDLim = (short)(0) ;
      Z1630PaiLicDSeman = (byte)(0) ;
      Z1631PaiLicDMes = (byte)(0) ;
      Z1632PaiLicDSemes = (short)(0) ;
      Z1633PaiLicDAnual = (short)(0) ;
      Z1634PaiLicAdju = false ;
      Z1635PaiLicAdjuObl = false ;
      Z1636PaiLicNecAut = false ;
      Z1637PaiLicIngMot = false ;
      Z1638PaiLicMotObl = false ;
      Z1451PaiBasePromCnt1 = (short)(0) ;
      Z1452PaiBasePromCnt2 = (short)(0) ;
      Z1453PaiBasePromTCnt = "" ;
      Z2053PaiBaseRelSec = 0 ;
      Z2054PaiBaseRelRef = "" ;
   }

   public void initAll4T183( )
   {
      A46PaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A1440PaiBaseClaseLeg = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
      A1441PaiBaseTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
      A1442PaiBaseCod1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1442PaiBaseCod1", A1442PaiBaseCod1);
      A1443PaiBaseCod2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1443PaiBaseCod2", A1443PaiBaseCod2);
      initializeNonKey4T183( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025131761041", true, true);
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
      httpContext.AddJavascriptSource("paisbase_calculo.js", "?2025131761041", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      cmbPaiBaseClaseLeg.setInternalname( "PAIBASECLASELEG" );
      cmbPaiBaseTipo.setInternalname( "PAIBASETIPO" );
      edtPaiBaseCod1_Internalname = "PAIBASECOD1" ;
      divPaibasecod1_cell_Internalname = "PAIBASECOD1_CELL" ;
      edtPaiBaseCod2_Internalname = "PAIBASECOD2" ;
      divPaibasecod2_cell_Internalname = "PAIBASECOD2_CELL" ;
      edtPaiBasePlus_Internalname = "PAIBASEPLUS" ;
      edtPaiLicDLim_Internalname = "PAILICDLIM" ;
      divPailicdlim_cell_Internalname = "PAILICDLIM_CELL" ;
      edtPaiLicDSeman_Internalname = "PAILICDSEMAN" ;
      divPailicdseman_cell_Internalname = "PAILICDSEMAN_CELL" ;
      edtPaiLicDMes_Internalname = "PAILICDMES" ;
      divPailicdmes_cell_Internalname = "PAILICDMES_CELL" ;
      edtPaiLicDSemes_Internalname = "PAILICDSEMES" ;
      divPailicdsemes_cell_Internalname = "PAILICDSEMES_CELL" ;
      edtPaiLicDAnual_Internalname = "PAILICDANUAL" ;
      divPailicdanual_cell_Internalname = "PAILICDANUAL_CELL" ;
      chkPaiLicAdju.setInternalname( "PAILICADJU" );
      divPailicadju_cell_Internalname = "PAILICADJU_CELL" ;
      chkPaiLicAdjuObl.setInternalname( "PAILICADJUOBL" );
      divPailicadjuobl_cell_Internalname = "PAILICADJUOBL_CELL" ;
      chkPaiLicNecAut.setInternalname( "PAILICNECAUT" );
      divPailicnecaut_cell_Internalname = "PAILICNECAUT_CELL" ;
      chkPaiLicIngMot.setInternalname( "PAILICINGMOT" );
      divPailicingmot_cell_Internalname = "PAILICINGMOT_CELL" ;
      chkPaiLicMotObl.setInternalname( "PAILICMOTOBL" );
      divPailicmotobl_cell_Internalname = "PAILICMOTOBL_CELL" ;
      edtPaiBasePromCnt1_Internalname = "PAIBASEPROMCNT1" ;
      edtPaiBasePromCnt2_Internalname = "PAIBASEPROMCNT2" ;
      cmbPaiBasePromTCnt.setInternalname( "PAIBASEPROMTCNT" );
      dynPaiBaseRelSec.setInternalname( "PAIBASERELSEC" );
      divPaibaserelsec_cell_Internalname = "PAIBASERELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      Form.setCaption( httpContext.getMessage( "Paisbase_calculo", "") );
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 1 ;
      edtPaiCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynPaiBaseRelSec.setJsonclick( "" );
      dynPaiBaseRelSec.setEnabled( 1 );
      divPaibaserelsec_cell_Class = "col-xs-12" ;
      cmbPaiBasePromTCnt.setJsonclick( "" );
      cmbPaiBasePromTCnt.setEnabled( 1 );
      edtPaiBasePromCnt2_Jsonclick = "" ;
      edtPaiBasePromCnt2_Enabled = 1 ;
      edtPaiBasePromCnt1_Jsonclick = "" ;
      edtPaiBasePromCnt1_Enabled = 1 ;
      chkPaiLicMotObl.setEnabled( 1 );
      chkPaiLicMotObl.setVisible( 1 );
      divPailicmotobl_cell_Class = "col-xs-12" ;
      chkPaiLicIngMot.setEnabled( 1 );
      chkPaiLicIngMot.setVisible( 1 );
      divPailicingmot_cell_Class = "col-xs-12" ;
      chkPaiLicNecAut.setEnabled( 1 );
      chkPaiLicNecAut.setVisible( 1 );
      divPailicnecaut_cell_Class = "col-xs-12" ;
      chkPaiLicAdjuObl.setEnabled( 1 );
      chkPaiLicAdjuObl.setVisible( 1 );
      divPailicadjuobl_cell_Class = "col-xs-12" ;
      chkPaiLicAdju.setEnabled( 1 );
      chkPaiLicAdju.setVisible( 1 );
      divPailicadju_cell_Class = "col-xs-12" ;
      edtPaiLicDAnual_Jsonclick = "" ;
      edtPaiLicDAnual_Enabled = 1 ;
      edtPaiLicDAnual_Visible = 1 ;
      divPailicdanual_cell_Class = "col-xs-12" ;
      edtPaiLicDSemes_Jsonclick = "" ;
      edtPaiLicDSemes_Enabled = 1 ;
      edtPaiLicDSemes_Visible = 1 ;
      divPailicdsemes_cell_Class = "col-xs-12" ;
      edtPaiLicDMes_Jsonclick = "" ;
      edtPaiLicDMes_Enabled = 1 ;
      edtPaiLicDMes_Visible = 1 ;
      divPailicdmes_cell_Class = "col-xs-12" ;
      edtPaiLicDSeman_Jsonclick = "" ;
      edtPaiLicDSeman_Enabled = 1 ;
      edtPaiLicDSeman_Visible = 1 ;
      divPailicdseman_cell_Class = "col-xs-12" ;
      edtPaiLicDLim_Jsonclick = "" ;
      edtPaiLicDLim_Enabled = 1 ;
      edtPaiLicDLim_Visible = 1 ;
      divPailicdlim_cell_Class = "col-xs-12" ;
      edtPaiBasePlus_Jsonclick = "" ;
      edtPaiBasePlus_Enabled = 1 ;
      edtPaiBaseCod2_Jsonclick = "" ;
      edtPaiBaseCod2_Enabled = 1 ;
      edtPaiBaseCod2_Visible = 1 ;
      divPaibasecod2_cell_Class = "col-xs-12" ;
      edtPaiBaseCod1_Jsonclick = "" ;
      edtPaiBaseCod1_Enabled = 1 ;
      edtPaiBaseCod1_Visible = 1 ;
      divPaibasecod1_cell_Class = "col-xs-12" ;
      cmbPaiBaseTipo.setJsonclick( "" );
      cmbPaiBaseTipo.setEnabled( 1 );
      cmbPaiBaseClaseLeg.setJsonclick( "" );
      cmbPaiBaseClaseLeg.setEnabled( 1 );
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

   public void gxdlapaibaserelsec4T183( int AV18CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlapaibaserelsec_data4T183( AV18CliCod) ;
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

   public void gxapaibaserelsec_html4T183( int AV18CliCod )
   {
      int gxdynajaxvalue;
      gxdlapaibaserelsec_data4T183( AV18CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynPaiBaseRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynPaiBaseRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlapaibaserelsec_data4T183( int AV18CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T004T16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(AV18CliCod)});
      while ( (pr_default.getStatus(14) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T004T16_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T004T16_A1880CliReDTChar[0]);
         pr_default.readNext(14);
      }
      pr_default.close(14);
   }

   public void gx4asapaibasec2txt4T183( String A1441PaiBaseTipo ,
                                        String A1442PaiBaseCod1 ,
                                        String A1443PaiBaseCod2 )
   {
      GXt_char6 = A1641PaiBaseC2Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod2(remoteHandle, context).execute( 0, A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, GXv_char7) ;
      paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
      A1641PaiBaseC2Txt = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1641PaiBaseC2Txt", A1641PaiBaseC2Txt);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1641PaiBaseC2Txt)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx5asapaibasec1txt4T183( String A1441PaiBaseTipo ,
                                        String A1442PaiBaseCod1 )
   {
      GXt_char6 = A1640PaiBaseC1Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( 0, A1441PaiBaseTipo, A1442PaiBaseCod1, GXv_char7) ;
      paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
      A1640PaiBaseC1Txt = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1640PaiBaseC1Txt", A1640PaiBaseC1Txt);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1640PaiBaseC1Txt)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx41asapaibaseolddefault4T183( short A1629PaiLicDLim ,
                                              byte A1630PaiLicDSeman ,
                                              byte A1631PaiLicDMes ,
                                              short A1632PaiLicDSemes ,
                                              short A1633PaiLicDAnual ,
                                              boolean A1634PaiLicAdju ,
                                              boolean A1635PaiLicAdjuObl ,
                                              boolean A1636PaiLicNecAut ,
                                              boolean A1637PaiLicIngMot ,
                                              boolean A1638PaiLicMotObl ,
                                              short A1451PaiBasePromCnt1 ,
                                              short A1452PaiBasePromCnt2 ,
                                              String A1453PaiBasePromTCnt ,
                                              String Gx_mode ,
                                              java.math.BigDecimal A1444PaiBasePlus )
   {
      if ( isUpd( )  )
      {
         GXt_char6 = A1975PaiBaseOldDefault ;
         GXv_char7[0] = GXt_char6 ;
         new web.paisbase_setolddefault(remoteHandle, context).execute( O1444PaiBasePlus, O1629PaiLicDLim, O1630PaiLicDSeman, O1631PaiLicDMes, O1632PaiLicDSemes, O1633PaiLicDAnual, O1634PaiLicAdju, O1635PaiLicAdjuObl, O1636PaiLicNecAut, O1637PaiLicIngMot, O1638PaiLicMotObl, O1451PaiBasePromCnt1, O1452PaiBasePromCnt2, O1453PaiBasePromTCnt, GXv_char7) ;
         paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
         A1975PaiBaseOldDefault = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1975PaiBaseOldDefault", A1975PaiBaseOldDefault);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1975PaiBaseOldDefault)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_50_4T183( String Gx_mode ,
                            int AV18CliCod ,
                            int A2053PaiBaseRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV17aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV18CliCod, A2053PaiBaseRelSec, GXv_boolean5) ;
         AV17aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17aplicadoHay", AV17aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV17aplicadoHay))+"\"") ;
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
      cmbPaiBaseClaseLeg.setName( "PAIBASECLASELEG" );
      cmbPaiBaseClaseLeg.setWebtags( "" );
      cmbPaiBaseClaseLeg.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbPaiBaseClaseLeg.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbPaiBaseClaseLeg.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbPaiBaseClaseLeg.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbPaiBaseClaseLeg.getItemCount() > 0 )
      {
         A1440PaiBaseClaseLeg = (byte)(GXutil.lval( cmbPaiBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1440PaiBaseClaseLeg", GXutil.str( A1440PaiBaseClaseLeg, 1, 0));
      }
      cmbPaiBaseTipo.setName( "PAIBASETIPO" );
      cmbPaiBaseTipo.setWebtags( "" );
      cmbPaiBaseTipo.addItem("licencia", httpContext.getMessage( "Licencia", ""), (short)(0));
      cmbPaiBaseTipo.addItem("feriado", httpContext.getMessage( "Feriado/No laborable", ""), (short)(0));
      cmbPaiBaseTipo.addItem("horaNormal", httpContext.getMessage( "Hora Normal", ""), (short)(0));
      if ( cmbPaiBaseTipo.getItemCount() > 0 )
      {
         A1441PaiBaseTipo = cmbPaiBaseTipo.getValidValue(A1441PaiBaseTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1441PaiBaseTipo", A1441PaiBaseTipo);
      }
      chkPaiLicAdju.setName( "PAILICADJU" );
      chkPaiLicAdju.setWebtags( "" );
      chkPaiLicAdju.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicAdju.getInternalname(), "TitleCaption", chkPaiLicAdju.getCaption(), true);
      chkPaiLicAdju.setCheckedValue( "false" );
      A1634PaiLicAdju = GXutil.strtobool( GXutil.booltostr( A1634PaiLicAdju)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1634PaiLicAdju", A1634PaiLicAdju);
      chkPaiLicAdjuObl.setName( "PAILICADJUOBL" );
      chkPaiLicAdjuObl.setWebtags( "" );
      chkPaiLicAdjuObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicAdjuObl.getInternalname(), "TitleCaption", chkPaiLicAdjuObl.getCaption(), true);
      chkPaiLicAdjuObl.setCheckedValue( "false" );
      A1635PaiLicAdjuObl = GXutil.strtobool( GXutil.booltostr( A1635PaiLicAdjuObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1635PaiLicAdjuObl", A1635PaiLicAdjuObl);
      chkPaiLicNecAut.setName( "PAILICNECAUT" );
      chkPaiLicNecAut.setWebtags( "" );
      chkPaiLicNecAut.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicNecAut.getInternalname(), "TitleCaption", chkPaiLicNecAut.getCaption(), true);
      chkPaiLicNecAut.setCheckedValue( "false" );
      A1636PaiLicNecAut = GXutil.strtobool( GXutil.booltostr( A1636PaiLicNecAut)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1636PaiLicNecAut", A1636PaiLicNecAut);
      chkPaiLicIngMot.setName( "PAILICINGMOT" );
      chkPaiLicIngMot.setWebtags( "" );
      chkPaiLicIngMot.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicIngMot.getInternalname(), "TitleCaption", chkPaiLicIngMot.getCaption(), true);
      chkPaiLicIngMot.setCheckedValue( "false" );
      A1637PaiLicIngMot = GXutil.strtobool( GXutil.booltostr( A1637PaiLicIngMot)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1637PaiLicIngMot", A1637PaiLicIngMot);
      chkPaiLicMotObl.setName( "PAILICMOTOBL" );
      chkPaiLicMotObl.setWebtags( "" );
      chkPaiLicMotObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiLicMotObl.getInternalname(), "TitleCaption", chkPaiLicMotObl.getCaption(), true);
      chkPaiLicMotObl.setCheckedValue( "false" );
      A1638PaiLicMotObl = GXutil.strtobool( GXutil.booltostr( A1638PaiLicMotObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1638PaiLicMotObl", A1638PaiLicMotObl);
      cmbPaiBasePromTCnt.setName( "PAIBASEPROMTCNT" );
      cmbPaiBasePromTCnt.setWebtags( "" );
      cmbPaiBasePromTCnt.addItem("dias", httpContext.getMessage( "días", ""), (short)(0));
      cmbPaiBasePromTCnt.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
      if ( cmbPaiBasePromTCnt.getItemCount() > 0 )
      {
         A1453PaiBasePromTCnt = cmbPaiBasePromTCnt.getValidValue(A1453PaiBasePromTCnt) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1453PaiBasePromTCnt", A1453PaiBasePromTCnt);
      }
      dynPaiBaseRelSec.setName( "PAIBASERELSEC" );
      dynPaiBaseRelSec.setWebtags( "" );
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

   public void valid_Paibasecod1( )
   {
      A1441PaiBaseTipo = cmbPaiBaseTipo.getValue() ;
      A2053PaiBaseRelSec = (int)(GXutil.lval( dynPaiBaseRelSec.getValue())) ;
      GXt_char6 = A1640PaiBaseC1Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( 0, A1441PaiBaseTipo, A1442PaiBaseCod1, GXv_char7) ;
      paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
      A1640PaiBaseC1Txt = GXt_char6 ;
      dynload_actions( ) ;
      if ( cmbPaiBaseClaseLeg.getItemCount() > 0 )
      {
         A1440PaiBaseClaseLeg = (byte)(GXutil.lval( cmbPaiBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0)) );
      }
      if ( cmbPaiBaseTipo.getItemCount() > 0 )
      {
         A1441PaiBaseTipo = cmbPaiBaseTipo.getValidValue(A1441PaiBaseTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBaseTipo.setValue( GXutil.rtrim( A1441PaiBaseTipo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1640PaiBaseC1Txt", A1640PaiBaseC1Txt);
   }

   public void valid_Paibasecod2( )
   {
      A1441PaiBaseTipo = cmbPaiBaseTipo.getValue() ;
      A2053PaiBaseRelSec = (int)(GXutil.lval( dynPaiBaseRelSec.getValue())) ;
      GXt_char6 = A1641PaiBaseC2Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod2(remoteHandle, context).execute( 0, A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, GXv_char7) ;
      paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
      A1641PaiBaseC2Txt = GXt_char6 ;
      dynload_actions( ) ;
      if ( cmbPaiBaseClaseLeg.getItemCount() > 0 )
      {
         A1440PaiBaseClaseLeg = (byte)(GXutil.lval( cmbPaiBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0)) );
      }
      if ( cmbPaiBaseTipo.getItemCount() > 0 )
      {
         A1441PaiBaseTipo = cmbPaiBaseTipo.getValidValue(A1441PaiBaseTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBaseTipo.setValue( GXutil.rtrim( A1441PaiBaseTipo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1641PaiBaseC2Txt", A1641PaiBaseC2Txt);
   }

   public void valid_Paicod( )
   {
      A2053PaiBaseRelSec = (int)(GXutil.lval( dynPaiBaseRelSec.getValue())) ;
      /* Using cursor T004T17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
      }
      pr_default.close(15);
      dynload_actions( ) ;
      if ( cmbPaiBaseClaseLeg.getItemCount() > 0 )
      {
         A1440PaiBaseClaseLeg = (byte)(GXutil.lval( cmbPaiBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0)) );
      }
      if ( cmbPaiBaseTipo.getItemCount() > 0 )
      {
         A1441PaiBaseTipo = cmbPaiBaseTipo.getValidValue(A1441PaiBaseTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBaseTipo.setValue( GXutil.rtrim( A1441PaiBaseTipo) );
      }
      /*  Sending validation outputs */
   }

   public void valid_Paibasepromtcnt( )
   {
      A1453PaiBasePromTCnt = cmbPaiBasePromTCnt.getValue() ;
      A2053PaiBaseRelSec = (int)(GXutil.lval( dynPaiBaseRelSec.getValue())) ;
      if ( ! ( ( GXutil.strcmp(A1453PaiBasePromTCnt, "dias") == 0 ) || ( GXutil.strcmp(A1453PaiBasePromTCnt, "meses") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Días o Meses", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAIBASEPROMTCNT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiBasePromTCnt.getInternalname() ;
      }
      if ( ! ( ( DecimalUtil.compareTo(A1444PaiBasePlus, O1444PaiBasePlus) != 0 ) || ( A1629PaiLicDLim != O1629PaiLicDLim ) || ( A1630PaiLicDSeman != O1630PaiLicDSeman ) || ( A1631PaiLicDMes != O1631PaiLicDMes ) || ( A1632PaiLicDSemes != O1632PaiLicDSemes ) || ( A1633PaiLicDAnual != O1633PaiLicDAnual ) || ( A1634PaiLicAdju != O1634PaiLicAdju ) || ( A1635PaiLicAdjuObl != O1635PaiLicAdjuObl ) || ( A1636PaiLicNecAut != O1636PaiLicNecAut ) || ( A1637PaiLicIngMot != O1637PaiLicIngMot ) || ( A1638PaiLicMotObl != O1638PaiLicMotObl ) || ( A1451PaiBasePromCnt1 != O1451PaiBasePromCnt1 ) || ( A1452PaiBasePromCnt2 != O1452PaiBasePromCnt2 ) || ( GXutil.strcmp(A1453PaiBasePromTCnt, O1453PaiBasePromTCnt) != 0 ) ) )
      {
         divPaibaserelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
      }
      else
      {
         if ( ( DecimalUtil.compareTo(A1444PaiBasePlus, O1444PaiBasePlus) != 0 ) || ( A1629PaiLicDLim != O1629PaiLicDLim ) || ( A1630PaiLicDSeman != O1630PaiLicDSeman ) || ( A1631PaiLicDMes != O1631PaiLicDMes ) || ( A1632PaiLicDSemes != O1632PaiLicDSemes ) || ( A1633PaiLicDAnual != O1633PaiLicDAnual ) || ( A1634PaiLicAdju != O1634PaiLicAdju ) || ( A1635PaiLicAdjuObl != O1635PaiLicAdjuObl ) || ( A1636PaiLicNecAut != O1636PaiLicNecAut ) || ( A1637PaiLicIngMot != O1637PaiLicIngMot ) || ( A1638PaiLicMotObl != O1638PaiLicMotObl ) || ( A1451PaiBasePromCnt1 != O1451PaiBasePromCnt1 ) || ( A1452PaiBasePromCnt2 != O1452PaiBasePromCnt2 ) || ( GXutil.strcmp(A1453PaiBasePromTCnt, O1453PaiBasePromTCnt) != 0 ) )
         {
            divPaibaserelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
         }
      }
      if ( isUpd( )  )
      {
         GXt_char6 = A1975PaiBaseOldDefault ;
         GXv_char7[0] = GXt_char6 ;
         new web.paisbase_setolddefault(remoteHandle, context).execute( O1444PaiBasePlus, O1629PaiLicDLim, O1630PaiLicDSeman, O1631PaiLicDMes, O1632PaiLicDSemes, O1633PaiLicDAnual, O1634PaiLicAdju, O1635PaiLicAdjuObl, O1636PaiLicNecAut, O1637PaiLicIngMot, O1638PaiLicMotObl, O1451PaiBasePromCnt1, O1452PaiBasePromCnt2, O1453PaiBasePromTCnt, GXv_char7) ;
         paisbase_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
         A1975PaiBaseOldDefault = GXt_char6 ;
      }
      dynload_actions( ) ;
      if ( cmbPaiBaseClaseLeg.getItemCount() > 0 )
      {
         A1440PaiBaseClaseLeg = (byte)(GXutil.lval( cmbPaiBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0)) );
      }
      if ( cmbPaiBaseTipo.getItemCount() > 0 )
      {
         A1441PaiBaseTipo = cmbPaiBaseTipo.getValidValue(A1441PaiBaseTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBaseTipo.setValue( GXutil.rtrim( A1441PaiBaseTipo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_prop("", false, divPaibaserelsec_cell_Internalname, "Class", divPaibaserelsec_cell_Class, true);
      httpContext.ajax_rsp_assign_attri("", false, "A1975PaiBaseOldDefault", A1975PaiBaseOldDefault);
   }

   public void valid_Paibaserelsec( )
   {
      A1453PaiBasePromTCnt = cmbPaiBasePromTCnt.getValue() ;
      A2053PaiBaseRelSec = (int)(GXutil.lval( dynPaiBaseRelSec.getValue())) ;
      if ( ( ( DecimalUtil.compareTo(A1444PaiBasePlus, O1444PaiBasePlus) != 0 ) || ( A1629PaiLicDLim != O1629PaiLicDLim ) || ( A1630PaiLicDSeman != O1630PaiLicDSeman ) || ( A1631PaiLicDMes != O1631PaiLicDMes ) || ( A1632PaiLicDSemes != O1632PaiLicDSemes ) || ( A1633PaiLicDAnual != O1633PaiLicDAnual ) || ( A1634PaiLicAdju != O1634PaiLicAdju ) || ( A1635PaiLicAdjuObl != O1635PaiLicAdjuObl ) || ( A1636PaiLicNecAut != O1636PaiLicNecAut ) || ( A1637PaiLicIngMot != O1637PaiLicIngMot ) || ( A1638PaiLicMotObl != O1638PaiLicMotObl ) || ( A1451PaiBasePromCnt1 != O1451PaiBasePromCnt1 ) || ( A1452PaiBasePromCnt2 != O1452PaiBasePromCnt2 ) || ( GXutil.strcmp(A1453PaiBasePromTCnt, O1453PaiBasePromTCnt) != 0 ) ) && (0==A2053PaiBaseRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "PAIBASERELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPaiBaseRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV17aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV18CliCod, A2053PaiBaseRelSec, GXv_boolean5) ;
         paisbase_calculo_impl.this.AV17aplicadoHay = GXv_boolean5[0] ;
         AV17aplicadoHay = this.AV17aplicadoHay ;
      }
      O1453PaiBasePromTCnt = A1453PaiBasePromTCnt ;
      O1452PaiBasePromCnt2 = A1452PaiBasePromCnt2 ;
      O1451PaiBasePromCnt1 = A1451PaiBasePromCnt1 ;
      O1638PaiLicMotObl = A1638PaiLicMotObl ;
      O1637PaiLicIngMot = A1637PaiLicIngMot ;
      O1636PaiLicNecAut = A1636PaiLicNecAut ;
      O1635PaiLicAdjuObl = A1635PaiLicAdjuObl ;
      O1634PaiLicAdju = A1634PaiLicAdju ;
      O1633PaiLicDAnual = A1633PaiLicDAnual ;
      O1632PaiLicDSemes = A1632PaiLicDSemes ;
      O1631PaiLicDMes = A1631PaiLicDMes ;
      O1630PaiLicDSeman = A1630PaiLicDSeman ;
      O1629PaiLicDLim = A1629PaiLicDLim ;
      O1444PaiBasePlus = A1444PaiBasePlus ;
      dynload_actions( ) ;
      if ( cmbPaiBaseClaseLeg.getItemCount() > 0 )
      {
         A1440PaiBaseClaseLeg = (byte)(GXutil.lval( cmbPaiBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1440PaiBaseClaseLeg, 1, 0)) );
      }
      if ( cmbPaiBaseTipo.getItemCount() > 0 )
      {
         A1441PaiBaseTipo = cmbPaiBaseTipo.getValidValue(A1441PaiBaseTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiBaseTipo.setValue( GXutil.rtrim( A1441PaiBaseTipo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV17aplicadoHay", AV17aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8PaiBaseClaseLeg',fld:'vPAIBASECLASELEG',pic:'9',hsh:true},{av:'AV9PaiBaseTipo',fld:'vPAIBASETIPO',pic:'',hsh:true},{av:'AV10PaiBaseCod1',fld:'vPAIBASECOD1',pic:'',hsh:true},{av:'AV11PaiBaseCod2',fld:'vPAIBASECOD2',pic:'',hsh:true},{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8PaiBaseClaseLeg',fld:'vPAIBASECLASELEG',pic:'9',hsh:true},{av:'AV9PaiBaseTipo',fld:'vPAIBASETIPO',pic:'',hsh:true},{av:'AV10PaiBaseCod1',fld:'vPAIBASECOD1',pic:'',hsh:true},{av:'AV11PaiBaseCod2',fld:'vPAIBASECOD2',pic:'',hsh:true},{av:'A2054PaiBaseRelRef',fld:'PAIBASERELREF',pic:''},{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e124T2',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAIBASECLASELEG","{handler:'valid_Paibaseclaseleg',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAIBASECLASELEG",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAIBASETIPO","{handler:'valid_Paibasetipo',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAIBASETIPO",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAIBASECOD1","{handler:'valid_Paibasecod1',iparms:[{av:'cmbPaiBaseTipo'},{av:'A1441PaiBaseTipo',fld:'PAIBASETIPO',pic:''},{av:'A1442PaiBaseCod1',fld:'PAIBASECOD1',pic:''},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynPaiBaseRelSec'},{av:'A2053PaiBaseRelSec',fld:'PAIBASERELSEC',pic:'ZZZZZ9'},{av:'A1640PaiBaseC1Txt',fld:'PAIBASEC1TXT',pic:''},{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAIBASECOD1",",oparms:[{av:'A1640PaiBaseC1Txt',fld:'PAIBASEC1TXT',pic:''},{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAIBASECOD2","{handler:'valid_Paibasecod2',iparms:[{av:'cmbPaiBaseTipo'},{av:'A1441PaiBaseTipo',fld:'PAIBASETIPO',pic:''},{av:'A1442PaiBaseCod1',fld:'PAIBASECOD1',pic:''},{av:'A1443PaiBaseCod2',fld:'PAIBASECOD2',pic:''},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynPaiBaseRelSec'},{av:'A2053PaiBaseRelSec',fld:'PAIBASERELSEC',pic:'ZZZZZ9'},{av:'A1641PaiBaseC2Txt',fld:'PAIBASEC2TXT',pic:''},{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAIBASECOD2",",oparms:[{av:'A1641PaiBaseC2Txt',fld:'PAIBASEC2TXT',pic:''},{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAIBASEPLUS","{handler:'valid_Paibaseplus',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAIBASEPLUS",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAILICDLIM","{handler:'valid_Pailicdlim',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAILICDLIM",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAILICDSEMAN","{handler:'valid_Pailicdseman',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAILICDSEMAN",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAILICDMES","{handler:'valid_Pailicdmes',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAILICDMES",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAILICDSEMES","{handler:'valid_Pailicdsemes',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAILICDSEMES",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAILICDANUAL","{handler:'valid_Pailicdanual',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAILICDANUAL",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAILICADJU","{handler:'valid_Pailicadju',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAILICADJU",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAILICADJUOBL","{handler:'valid_Pailicadjuobl',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAILICADJUOBL",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAILICNECAUT","{handler:'valid_Pailicnecaut',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAILICNECAUT",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAILICINGMOT","{handler:'valid_Pailicingmot',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAILICINGMOT",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAILICMOTOBL","{handler:'valid_Pailicmotobl',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAILICMOTOBL",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAIBASEPROMCNT1","{handler:'valid_Paibasepromcnt1',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAIBASEPROMCNT1",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAIBASEPROMCNT2","{handler:'valid_Paibasepromcnt2',iparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAIBASEPROMCNT2",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAIBASEPROMTCNT","{handler:'valid_Paibasepromtcnt',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1453PaiBasePromTCnt'},{av:'O1452PaiBasePromCnt2'},{av:'O1451PaiBasePromCnt1'},{av:'O1638PaiLicMotObl'},{av:'O1637PaiLicIngMot'},{av:'O1636PaiLicNecAut'},{av:'O1635PaiLicAdjuObl'},{av:'O1634PaiLicAdju'},{av:'O1633PaiLicDAnual'},{av:'O1632PaiLicDSemes'},{av:'O1631PaiLicDMes'},{av:'O1630PaiLicDSeman'},{av:'O1629PaiLicDLim'},{av:'O1444PaiBasePlus'},{av:'cmbPaiBasePromTCnt'},{av:'A1453PaiBasePromTCnt',fld:'PAIBASEPROMTCNT',pic:''},{av:'A1444PaiBasePlus',fld:'PAIBASEPLUS',pic:'9.9999'},{av:'A1629PaiLicDLim',fld:'PAILICDLIM',pic:'ZZ9'},{av:'A1630PaiLicDSeman',fld:'PAILICDSEMAN',pic:'9'},{av:'A1631PaiLicDMes',fld:'PAILICDMES',pic:'Z9'},{av:'A1632PaiLicDSemes',fld:'PAILICDSEMES',pic:'ZZ9'},{av:'A1633PaiLicDAnual',fld:'PAILICDANUAL',pic:'ZZ9'},{av:'A1451PaiBasePromCnt1',fld:'PAIBASEPROMCNT1',pic:'ZZ9'},{av:'A1452PaiBasePromCnt2',fld:'PAIBASEPROMCNT2',pic:'ZZ9'},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynPaiBaseRelSec'},{av:'A2053PaiBaseRelSec',fld:'PAIBASERELSEC',pic:'ZZZZZ9'},{av:'A1975PaiBaseOldDefault',fld:'PAIBASEOLDDEFAULT',pic:''},{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAIBASEPROMTCNT",",oparms:[{av:'divPaibaserelsec_cell_Class',ctrl:'PAIBASERELSEC_CELL',prop:'Class'},{av:'A1975PaiBaseOldDefault',fld:'PAIBASEOLDDEFAULT',pic:''},{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAIBASERELSEC","{handler:'valid_Paibaserelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1453PaiBasePromTCnt'},{av:'O1452PaiBasePromCnt2'},{av:'O1451PaiBasePromCnt1'},{av:'O1638PaiLicMotObl'},{av:'O1637PaiLicIngMot'},{av:'O1636PaiLicNecAut'},{av:'O1635PaiLicAdjuObl'},{av:'O1634PaiLicAdju'},{av:'O1633PaiLicDAnual'},{av:'O1632PaiLicDSemes'},{av:'O1631PaiLicDMes'},{av:'O1630PaiLicDSeman'},{av:'O1629PaiLicDLim'},{av:'O1444PaiBasePlus'},{av:'A1444PaiBasePlus',fld:'PAIBASEPLUS',pic:'9.9999'},{av:'A1629PaiLicDLim',fld:'PAILICDLIM',pic:'ZZ9'},{av:'A1630PaiLicDSeman',fld:'PAILICDSEMAN',pic:'9'},{av:'A1631PaiLicDMes',fld:'PAILICDMES',pic:'Z9'},{av:'A1632PaiLicDSemes',fld:'PAILICDSEMES',pic:'ZZ9'},{av:'A1633PaiLicDAnual',fld:'PAILICDANUAL',pic:'ZZ9'},{av:'A1451PaiBasePromCnt1',fld:'PAIBASEPROMCNT1',pic:'ZZ9'},{av:'A1452PaiBasePromCnt2',fld:'PAIBASEPROMCNT2',pic:'ZZ9'},{av:'cmbPaiBasePromTCnt'},{av:'A1453PaiBasePromTCnt',fld:'PAIBASEPROMTCNT',pic:''},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynPaiBaseRelSec'},{av:'A2053PaiBaseRelSec',fld:'PAIBASERELSEC',pic:'ZZZZZ9'},{av:'AV17aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAIBASERELSEC",",oparms:[{av:'AV17aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynPaiBaseRelSec'},{av:'A2053PaiBaseRelSec',fld:'PAIBASERELSEC',pic:'ZZZZZ9'},{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]");
      setEventMetadata("VALID_PAICOD",",oparms:[{av:'A1634PaiLicAdju',fld:'PAILICADJU',pic:''},{av:'A1635PaiLicAdjuObl',fld:'PAILICADJUOBL',pic:''},{av:'A1636PaiLicNecAut',fld:'PAILICNECAUT',pic:''},{av:'A1637PaiLicIngMot',fld:'PAILICINGMOT',pic:''},{av:'A1638PaiLicMotObl',fld:'PAILICMOTOBL',pic:''}]}");
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
      wcpOAV9PaiBaseTipo = "" ;
      wcpOAV10PaiBaseCod1 = "" ;
      wcpOAV11PaiBaseCod2 = "" ;
      Z1441PaiBaseTipo = "" ;
      Z1442PaiBaseCod1 = "" ;
      Z1443PaiBaseCod2 = "" ;
      Z1444PaiBasePlus = DecimalUtil.ZERO ;
      Z1453PaiBasePromTCnt = "" ;
      Z2054PaiBaseRelRef = "" ;
      O1453PaiBasePromTCnt = "" ;
      O1444PaiBasePlus = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A1441PaiBaseTipo = "" ;
      A1442PaiBaseCod1 = "" ;
      A1443PaiBaseCod2 = "" ;
      A1453PaiBasePromTCnt = "" ;
      A1444PaiBasePlus = DecimalUtil.ZERO ;
      AV9PaiBaseTipo = "" ;
      AV10PaiBaseCod1 = "" ;
      AV11PaiBaseCod2 = "" ;
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
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A2054PaiBaseRelRef = "" ;
      A1641PaiBaseC2Txt = "" ;
      A1640PaiBaseC1Txt = "" ;
      A1975PaiBaseOldDefault = "" ;
      A2069PaiBaseOld = "" ;
      AV19Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode183 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXv_int2 = new int[1] ;
      AV12WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV15TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV16WebSession = httpContext.getWebSession();
      Z1975PaiBaseOldDefault = "" ;
      Z2069PaiBaseOld = "" ;
      T004T5_A1440PaiBaseClaseLeg = new byte[1] ;
      T004T5_A1441PaiBaseTipo = new String[] {""} ;
      T004T5_A1442PaiBaseCod1 = new String[] {""} ;
      T004T5_A1443PaiBaseCod2 = new String[] {""} ;
      T004T5_A1975PaiBaseOldDefault = new String[] {""} ;
      T004T5_A1444PaiBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004T5_A1629PaiLicDLim = new short[1] ;
      T004T5_A1630PaiLicDSeman = new byte[1] ;
      T004T5_A1631PaiLicDMes = new byte[1] ;
      T004T5_A1632PaiLicDSemes = new short[1] ;
      T004T5_A1633PaiLicDAnual = new short[1] ;
      T004T5_A1634PaiLicAdju = new boolean[] {false} ;
      T004T5_A1635PaiLicAdjuObl = new boolean[] {false} ;
      T004T5_A1636PaiLicNecAut = new boolean[] {false} ;
      T004T5_A1637PaiLicIngMot = new boolean[] {false} ;
      T004T5_A1638PaiLicMotObl = new boolean[] {false} ;
      T004T5_A1451PaiBasePromCnt1 = new short[1] ;
      T004T5_A1452PaiBasePromCnt2 = new short[1] ;
      T004T5_A1453PaiBasePromTCnt = new String[] {""} ;
      T004T5_A2053PaiBaseRelSec = new int[1] ;
      T004T5_A2054PaiBaseRelRef = new String[] {""} ;
      T004T5_A2069PaiBaseOld = new String[] {""} ;
      T004T5_A46PaiCod = new short[1] ;
      T004T4_A46PaiCod = new short[1] ;
      T004T6_A46PaiCod = new short[1] ;
      T004T7_A46PaiCod = new short[1] ;
      T004T7_A1440PaiBaseClaseLeg = new byte[1] ;
      T004T7_A1441PaiBaseTipo = new String[] {""} ;
      T004T7_A1442PaiBaseCod1 = new String[] {""} ;
      T004T7_A1443PaiBaseCod2 = new String[] {""} ;
      T004T3_A1440PaiBaseClaseLeg = new byte[1] ;
      T004T3_A1441PaiBaseTipo = new String[] {""} ;
      T004T3_A1442PaiBaseCod1 = new String[] {""} ;
      T004T3_A1443PaiBaseCod2 = new String[] {""} ;
      T004T3_A1975PaiBaseOldDefault = new String[] {""} ;
      T004T3_A1444PaiBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004T3_A1629PaiLicDLim = new short[1] ;
      T004T3_A1630PaiLicDSeman = new byte[1] ;
      T004T3_A1631PaiLicDMes = new byte[1] ;
      T004T3_A1632PaiLicDSemes = new short[1] ;
      T004T3_A1633PaiLicDAnual = new short[1] ;
      T004T3_A1634PaiLicAdju = new boolean[] {false} ;
      T004T3_A1635PaiLicAdjuObl = new boolean[] {false} ;
      T004T3_A1636PaiLicNecAut = new boolean[] {false} ;
      T004T3_A1637PaiLicIngMot = new boolean[] {false} ;
      T004T3_A1638PaiLicMotObl = new boolean[] {false} ;
      T004T3_A1451PaiBasePromCnt1 = new short[1] ;
      T004T3_A1452PaiBasePromCnt2 = new short[1] ;
      T004T3_A1453PaiBasePromTCnt = new String[] {""} ;
      T004T3_A2053PaiBaseRelSec = new int[1] ;
      T004T3_A2054PaiBaseRelRef = new String[] {""} ;
      T004T3_A2069PaiBaseOld = new String[] {""} ;
      T004T3_A46PaiCod = new short[1] ;
      T004T8_A46PaiCod = new short[1] ;
      T004T8_A1440PaiBaseClaseLeg = new byte[1] ;
      T004T8_A1441PaiBaseTipo = new String[] {""} ;
      T004T8_A1442PaiBaseCod1 = new String[] {""} ;
      T004T8_A1443PaiBaseCod2 = new String[] {""} ;
      T004T9_A46PaiCod = new short[1] ;
      T004T9_A1440PaiBaseClaseLeg = new byte[1] ;
      T004T9_A1441PaiBaseTipo = new String[] {""} ;
      T004T9_A1442PaiBaseCod1 = new String[] {""} ;
      T004T9_A1443PaiBaseCod2 = new String[] {""} ;
      T004T2_A1440PaiBaseClaseLeg = new byte[1] ;
      T004T2_A1441PaiBaseTipo = new String[] {""} ;
      T004T2_A1442PaiBaseCod1 = new String[] {""} ;
      T004T2_A1443PaiBaseCod2 = new String[] {""} ;
      T004T2_A1975PaiBaseOldDefault = new String[] {""} ;
      T004T2_A1444PaiBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004T2_A1629PaiLicDLim = new short[1] ;
      T004T2_A1630PaiLicDSeman = new byte[1] ;
      T004T2_A1631PaiLicDMes = new byte[1] ;
      T004T2_A1632PaiLicDSemes = new short[1] ;
      T004T2_A1633PaiLicDAnual = new short[1] ;
      T004T2_A1634PaiLicAdju = new boolean[] {false} ;
      T004T2_A1635PaiLicAdjuObl = new boolean[] {false} ;
      T004T2_A1636PaiLicNecAut = new boolean[] {false} ;
      T004T2_A1637PaiLicIngMot = new boolean[] {false} ;
      T004T2_A1638PaiLicMotObl = new boolean[] {false} ;
      T004T2_A1451PaiBasePromCnt1 = new short[1] ;
      T004T2_A1452PaiBasePromCnt2 = new short[1] ;
      T004T2_A1453PaiBasePromTCnt = new String[] {""} ;
      T004T2_A2053PaiBaseRelSec = new int[1] ;
      T004T2_A2054PaiBaseRelRef = new String[] {""} ;
      T004T2_A2069PaiBaseOld = new String[] {""} ;
      T004T2_A46PaiCod = new short[1] ;
      T004T13_A46PaiCod = new short[1] ;
      T004T13_A1440PaiBaseClaseLeg = new byte[1] ;
      T004T13_A1441PaiBaseTipo = new String[] {""} ;
      T004T13_A1442PaiBaseCod1 = new String[] {""} ;
      T004T13_A1443PaiBaseCod2 = new String[] {""} ;
      T004T13_A1448PaiBasePromCTipo = new String[] {""} ;
      T004T13_A1449PaiBasePromFijVar = new String[] {""} ;
      T004T14_A46PaiCod = new short[1] ;
      T004T14_A1440PaiBaseClaseLeg = new byte[1] ;
      T004T14_A1441PaiBaseTipo = new String[] {""} ;
      T004T14_A1442PaiBaseCod1 = new String[] {""} ;
      T004T14_A1443PaiBaseCod2 = new String[] {""} ;
      T004T14_A1445PaiBaseCliCod = new int[1] ;
      T004T14_A1446PaiBaseConCodigo = new String[] {""} ;
      T004T15_A46PaiCod = new short[1] ;
      T004T15_A1440PaiBaseClaseLeg = new byte[1] ;
      T004T15_A1441PaiBaseTipo = new String[] {""} ;
      T004T15_A1442PaiBaseCod1 = new String[] {""} ;
      T004T15_A1443PaiBaseCod2 = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T004T16_A1885CliRelSec = new int[1] ;
      T004T16_A1880CliReDTChar = new String[] {""} ;
      T004T16_A3CliCod = new int[1] ;
      Z1640PaiBaseC1Txt = "" ;
      Z1641PaiBaseC2Txt = "" ;
      T004T17_A46PaiCod = new short[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paisbase_calculo__default(),
         new Object[] {
             new Object[] {
            T004T2_A1440PaiBaseClaseLeg, T004T2_A1441PaiBaseTipo, T004T2_A1442PaiBaseCod1, T004T2_A1443PaiBaseCod2, T004T2_A1975PaiBaseOldDefault, T004T2_A1444PaiBasePlus, T004T2_A1629PaiLicDLim, T004T2_A1630PaiLicDSeman, T004T2_A1631PaiLicDMes, T004T2_A1632PaiLicDSemes,
            T004T2_A1633PaiLicDAnual, T004T2_A1634PaiLicAdju, T004T2_A1635PaiLicAdjuObl, T004T2_A1636PaiLicNecAut, T004T2_A1637PaiLicIngMot, T004T2_A1638PaiLicMotObl, T004T2_A1451PaiBasePromCnt1, T004T2_A1452PaiBasePromCnt2, T004T2_A1453PaiBasePromTCnt, T004T2_A2053PaiBaseRelSec,
            T004T2_A2054PaiBaseRelRef, T004T2_A2069PaiBaseOld, T004T2_A46PaiCod
            }
            , new Object[] {
            T004T3_A1440PaiBaseClaseLeg, T004T3_A1441PaiBaseTipo, T004T3_A1442PaiBaseCod1, T004T3_A1443PaiBaseCod2, T004T3_A1975PaiBaseOldDefault, T004T3_A1444PaiBasePlus, T004T3_A1629PaiLicDLim, T004T3_A1630PaiLicDSeman, T004T3_A1631PaiLicDMes, T004T3_A1632PaiLicDSemes,
            T004T3_A1633PaiLicDAnual, T004T3_A1634PaiLicAdju, T004T3_A1635PaiLicAdjuObl, T004T3_A1636PaiLicNecAut, T004T3_A1637PaiLicIngMot, T004T3_A1638PaiLicMotObl, T004T3_A1451PaiBasePromCnt1, T004T3_A1452PaiBasePromCnt2, T004T3_A1453PaiBasePromTCnt, T004T3_A2053PaiBaseRelSec,
            T004T3_A2054PaiBaseRelRef, T004T3_A2069PaiBaseOld, T004T3_A46PaiCod
            }
            , new Object[] {
            T004T4_A46PaiCod
            }
            , new Object[] {
            T004T5_A1440PaiBaseClaseLeg, T004T5_A1441PaiBaseTipo, T004T5_A1442PaiBaseCod1, T004T5_A1443PaiBaseCod2, T004T5_A1975PaiBaseOldDefault, T004T5_A1444PaiBasePlus, T004T5_A1629PaiLicDLim, T004T5_A1630PaiLicDSeman, T004T5_A1631PaiLicDMes, T004T5_A1632PaiLicDSemes,
            T004T5_A1633PaiLicDAnual, T004T5_A1634PaiLicAdju, T004T5_A1635PaiLicAdjuObl, T004T5_A1636PaiLicNecAut, T004T5_A1637PaiLicIngMot, T004T5_A1638PaiLicMotObl, T004T5_A1451PaiBasePromCnt1, T004T5_A1452PaiBasePromCnt2, T004T5_A1453PaiBasePromTCnt, T004T5_A2053PaiBaseRelSec,
            T004T5_A2054PaiBaseRelRef, T004T5_A2069PaiBaseOld, T004T5_A46PaiCod
            }
            , new Object[] {
            T004T6_A46PaiCod
            }
            , new Object[] {
            T004T7_A46PaiCod, T004T7_A1440PaiBaseClaseLeg, T004T7_A1441PaiBaseTipo, T004T7_A1442PaiBaseCod1, T004T7_A1443PaiBaseCod2
            }
            , new Object[] {
            T004T8_A46PaiCod, T004T8_A1440PaiBaseClaseLeg, T004T8_A1441PaiBaseTipo, T004T8_A1442PaiBaseCod1, T004T8_A1443PaiBaseCod2
            }
            , new Object[] {
            T004T9_A46PaiCod, T004T9_A1440PaiBaseClaseLeg, T004T9_A1441PaiBaseTipo, T004T9_A1442PaiBaseCod1, T004T9_A1443PaiBaseCod2
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004T13_A46PaiCod, T004T13_A1440PaiBaseClaseLeg, T004T13_A1441PaiBaseTipo, T004T13_A1442PaiBaseCod1, T004T13_A1443PaiBaseCod2, T004T13_A1448PaiBasePromCTipo, T004T13_A1449PaiBasePromFijVar
            }
            , new Object[] {
            T004T14_A46PaiCod, T004T14_A1440PaiBaseClaseLeg, T004T14_A1441PaiBaseTipo, T004T14_A1442PaiBaseCod1, T004T14_A1443PaiBaseCod2, T004T14_A1445PaiBaseCliCod, T004T14_A1446PaiBaseConCodigo
            }
            , new Object[] {
            T004T15_A46PaiCod, T004T15_A1440PaiBaseClaseLeg, T004T15_A1441PaiBaseTipo, T004T15_A1442PaiBaseCod1, T004T15_A1443PaiBaseCod2
            }
            , new Object[] {
            T004T16_A1885CliRelSec, T004T16_A1880CliReDTChar, T004T16_A3CliCod
            }
            , new Object[] {
            T004T17_A46PaiCod
            }
         }
      );
      AV19Pgmname = "Paisbase_calculo" ;
   }

   private byte wcpOAV8PaiBaseClaseLeg ;
   private byte Z1440PaiBaseClaseLeg ;
   private byte Z1630PaiLicDSeman ;
   private byte Z1631PaiLicDMes ;
   private byte O1631PaiLicDMes ;
   private byte O1630PaiLicDSeman ;
   private byte GxWebError ;
   private byte A1630PaiLicDSeman ;
   private byte A1631PaiLicDMes ;
   private byte AV8PaiBaseClaseLeg ;
   private byte nKeyPressed ;
   private byte A1440PaiBaseClaseLeg ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7PaiCod ;
   private short Z46PaiCod ;
   private short Z1629PaiLicDLim ;
   private short Z1632PaiLicDSemes ;
   private short Z1633PaiLicDAnual ;
   private short Z1451PaiBasePromCnt1 ;
   private short Z1452PaiBasePromCnt2 ;
   private short O1452PaiBasePromCnt2 ;
   private short O1451PaiBasePromCnt1 ;
   private short O1633PaiLicDAnual ;
   private short O1632PaiLicDSemes ;
   private short O1629PaiLicDLim ;
   private short A1629PaiLicDLim ;
   private short A1632PaiLicDSemes ;
   private short A1633PaiLicDAnual ;
   private short A1451PaiBasePromCnt1 ;
   private short A1452PaiBasePromCnt2 ;
   private short A46PaiCod ;
   private short AV7PaiCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound183 ;
   private short nIsDirty_183 ;
   private int Z2053PaiBaseRelSec ;
   private int AV18CliCod ;
   private int A2053PaiBaseRelSec ;
   private int trnEnded ;
   private int edtPaiBaseCod1_Visible ;
   private int edtPaiBaseCod1_Enabled ;
   private int edtPaiBaseCod2_Visible ;
   private int edtPaiBaseCod2_Enabled ;
   private int edtPaiBasePlus_Enabled ;
   private int edtPaiLicDLim_Visible ;
   private int edtPaiLicDLim_Enabled ;
   private int edtPaiLicDSeman_Visible ;
   private int edtPaiLicDSeman_Enabled ;
   private int edtPaiLicDMes_Visible ;
   private int edtPaiLicDMes_Enabled ;
   private int edtPaiLicDSemes_Visible ;
   private int edtPaiLicDSemes_Enabled ;
   private int edtPaiLicDAnual_Visible ;
   private int edtPaiLicDAnual_Enabled ;
   private int edtPaiBasePromCnt1_Enabled ;
   private int edtPaiBasePromCnt2_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtPaiCod_Visible ;
   private int edtPaiCod_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private java.math.BigDecimal Z1444PaiBasePlus ;
   private java.math.BigDecimal O1444PaiBasePlus ;
   private java.math.BigDecimal A1444PaiBasePlus ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9PaiBaseTipo ;
   private String wcpOAV10PaiBaseCod1 ;
   private String wcpOAV11PaiBaseCod2 ;
   private String Z1441PaiBaseTipo ;
   private String Z1442PaiBaseCod1 ;
   private String Z1443PaiBaseCod2 ;
   private String Z1453PaiBasePromTCnt ;
   private String O1453PaiBasePromTCnt ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A1441PaiBaseTipo ;
   private String A1442PaiBaseCod1 ;
   private String A1443PaiBaseCod2 ;
   private String A1453PaiBasePromTCnt ;
   private String AV9PaiBaseTipo ;
   private String AV10PaiBaseCod1 ;
   private String AV11PaiBaseCod2 ;
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
   private String divPaibasecod1_cell_Internalname ;
   private String divPaibasecod1_cell_Class ;
   private String edtPaiBaseCod1_Internalname ;
   private String edtPaiBaseCod1_Jsonclick ;
   private String divPaibasecod2_cell_Internalname ;
   private String divPaibasecod2_cell_Class ;
   private String edtPaiBaseCod2_Internalname ;
   private String edtPaiBaseCod2_Jsonclick ;
   private String edtPaiBasePlus_Internalname ;
   private String edtPaiBasePlus_Jsonclick ;
   private String divPailicdlim_cell_Internalname ;
   private String divPailicdlim_cell_Class ;
   private String edtPaiLicDLim_Internalname ;
   private String edtPaiLicDLim_Jsonclick ;
   private String divPailicdseman_cell_Internalname ;
   private String divPailicdseman_cell_Class ;
   private String edtPaiLicDSeman_Internalname ;
   private String edtPaiLicDSeman_Jsonclick ;
   private String divPailicdmes_cell_Internalname ;
   private String divPailicdmes_cell_Class ;
   private String edtPaiLicDMes_Internalname ;
   private String edtPaiLicDMes_Jsonclick ;
   private String divPailicdsemes_cell_Internalname ;
   private String divPailicdsemes_cell_Class ;
   private String edtPaiLicDSemes_Internalname ;
   private String edtPaiLicDSemes_Jsonclick ;
   private String divPailicdanual_cell_Internalname ;
   private String divPailicdanual_cell_Class ;
   private String edtPaiLicDAnual_Internalname ;
   private String edtPaiLicDAnual_Jsonclick ;
   private String divPailicadju_cell_Internalname ;
   private String divPailicadju_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String divPailicadjuobl_cell_Internalname ;
   private String divPailicadjuobl_cell_Class ;
   private String divPailicnecaut_cell_Internalname ;
   private String divPailicnecaut_cell_Class ;
   private String divPailicingmot_cell_Internalname ;
   private String divPailicingmot_cell_Class ;
   private String divPailicmotobl_cell_Internalname ;
   private String divPailicmotobl_cell_Class ;
   private String edtPaiBasePromCnt1_Internalname ;
   private String edtPaiBasePromCnt1_Jsonclick ;
   private String edtPaiBasePromCnt2_Internalname ;
   private String edtPaiBasePromCnt2_Jsonclick ;
   private String divPaibaserelsec_cell_Internalname ;
   private String divPaibaserelsec_cell_Class ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtPaiCod_Internalname ;
   private String edtPaiCod_Jsonclick ;
   private String AV19Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode183 ;
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
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean Z1634PaiLicAdju ;
   private boolean Z1635PaiLicAdjuObl ;
   private boolean Z1636PaiLicNecAut ;
   private boolean Z1637PaiLicIngMot ;
   private boolean Z1638PaiLicMotObl ;
   private boolean O1638PaiLicMotObl ;
   private boolean O1637PaiLicIngMot ;
   private boolean O1636PaiLicNecAut ;
   private boolean O1635PaiLicAdjuObl ;
   private boolean O1634PaiLicAdju ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean A1634PaiLicAdju ;
   private boolean A1635PaiLicAdjuObl ;
   private boolean A1636PaiLicNecAut ;
   private boolean A1637PaiLicIngMot ;
   private boolean A1638PaiLicMotObl ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean AV17aplicadoHay ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXv_boolean5[] ;
   private boolean ZV17aplicadoHay ;
   private String A1975PaiBaseOldDefault ;
   private String A2069PaiBaseOld ;
   private String Z1975PaiBaseOldDefault ;
   private String Z2069PaiBaseOld ;
   private String Z2054PaiBaseRelRef ;
   private String A2054PaiBaseRelRef ;
   private String A1641PaiBaseC2Txt ;
   private String A1640PaiBaseC1Txt ;
   private String Z1640PaiBaseC1Txt ;
   private String Z1641PaiBaseC2Txt ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV16WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbPaiBaseClaseLeg ;
   private HTMLChoice cmbPaiBaseTipo ;
   private ICheckbox chkPaiLicAdju ;
   private ICheckbox chkPaiLicAdjuObl ;
   private ICheckbox chkPaiLicNecAut ;
   private ICheckbox chkPaiLicIngMot ;
   private ICheckbox chkPaiLicMotObl ;
   private HTMLChoice cmbPaiBasePromTCnt ;
   private HTMLChoice dynPaiBaseRelSec ;
   private IDataStoreProvider pr_default ;
   private byte[] T004T5_A1440PaiBaseClaseLeg ;
   private String[] T004T5_A1441PaiBaseTipo ;
   private String[] T004T5_A1442PaiBaseCod1 ;
   private String[] T004T5_A1443PaiBaseCod2 ;
   private String[] T004T5_A1975PaiBaseOldDefault ;
   private java.math.BigDecimal[] T004T5_A1444PaiBasePlus ;
   private short[] T004T5_A1629PaiLicDLim ;
   private byte[] T004T5_A1630PaiLicDSeman ;
   private byte[] T004T5_A1631PaiLicDMes ;
   private short[] T004T5_A1632PaiLicDSemes ;
   private short[] T004T5_A1633PaiLicDAnual ;
   private boolean[] T004T5_A1634PaiLicAdju ;
   private boolean[] T004T5_A1635PaiLicAdjuObl ;
   private boolean[] T004T5_A1636PaiLicNecAut ;
   private boolean[] T004T5_A1637PaiLicIngMot ;
   private boolean[] T004T5_A1638PaiLicMotObl ;
   private short[] T004T5_A1451PaiBasePromCnt1 ;
   private short[] T004T5_A1452PaiBasePromCnt2 ;
   private String[] T004T5_A1453PaiBasePromTCnt ;
   private int[] T004T5_A2053PaiBaseRelSec ;
   private String[] T004T5_A2054PaiBaseRelRef ;
   private String[] T004T5_A2069PaiBaseOld ;
   private short[] T004T5_A46PaiCod ;
   private short[] T004T4_A46PaiCod ;
   private short[] T004T6_A46PaiCod ;
   private short[] T004T7_A46PaiCod ;
   private byte[] T004T7_A1440PaiBaseClaseLeg ;
   private String[] T004T7_A1441PaiBaseTipo ;
   private String[] T004T7_A1442PaiBaseCod1 ;
   private String[] T004T7_A1443PaiBaseCod2 ;
   private byte[] T004T3_A1440PaiBaseClaseLeg ;
   private String[] T004T3_A1441PaiBaseTipo ;
   private String[] T004T3_A1442PaiBaseCod1 ;
   private String[] T004T3_A1443PaiBaseCod2 ;
   private String[] T004T3_A1975PaiBaseOldDefault ;
   private java.math.BigDecimal[] T004T3_A1444PaiBasePlus ;
   private short[] T004T3_A1629PaiLicDLim ;
   private byte[] T004T3_A1630PaiLicDSeman ;
   private byte[] T004T3_A1631PaiLicDMes ;
   private short[] T004T3_A1632PaiLicDSemes ;
   private short[] T004T3_A1633PaiLicDAnual ;
   private boolean[] T004T3_A1634PaiLicAdju ;
   private boolean[] T004T3_A1635PaiLicAdjuObl ;
   private boolean[] T004T3_A1636PaiLicNecAut ;
   private boolean[] T004T3_A1637PaiLicIngMot ;
   private boolean[] T004T3_A1638PaiLicMotObl ;
   private short[] T004T3_A1451PaiBasePromCnt1 ;
   private short[] T004T3_A1452PaiBasePromCnt2 ;
   private String[] T004T3_A1453PaiBasePromTCnt ;
   private int[] T004T3_A2053PaiBaseRelSec ;
   private String[] T004T3_A2054PaiBaseRelRef ;
   private String[] T004T3_A2069PaiBaseOld ;
   private short[] T004T3_A46PaiCod ;
   private short[] T004T8_A46PaiCod ;
   private byte[] T004T8_A1440PaiBaseClaseLeg ;
   private String[] T004T8_A1441PaiBaseTipo ;
   private String[] T004T8_A1442PaiBaseCod1 ;
   private String[] T004T8_A1443PaiBaseCod2 ;
   private short[] T004T9_A46PaiCod ;
   private byte[] T004T9_A1440PaiBaseClaseLeg ;
   private String[] T004T9_A1441PaiBaseTipo ;
   private String[] T004T9_A1442PaiBaseCod1 ;
   private String[] T004T9_A1443PaiBaseCod2 ;
   private byte[] T004T2_A1440PaiBaseClaseLeg ;
   private String[] T004T2_A1441PaiBaseTipo ;
   private String[] T004T2_A1442PaiBaseCod1 ;
   private String[] T004T2_A1443PaiBaseCod2 ;
   private String[] T004T2_A1975PaiBaseOldDefault ;
   private java.math.BigDecimal[] T004T2_A1444PaiBasePlus ;
   private short[] T004T2_A1629PaiLicDLim ;
   private byte[] T004T2_A1630PaiLicDSeman ;
   private byte[] T004T2_A1631PaiLicDMes ;
   private short[] T004T2_A1632PaiLicDSemes ;
   private short[] T004T2_A1633PaiLicDAnual ;
   private boolean[] T004T2_A1634PaiLicAdju ;
   private boolean[] T004T2_A1635PaiLicAdjuObl ;
   private boolean[] T004T2_A1636PaiLicNecAut ;
   private boolean[] T004T2_A1637PaiLicIngMot ;
   private boolean[] T004T2_A1638PaiLicMotObl ;
   private short[] T004T2_A1451PaiBasePromCnt1 ;
   private short[] T004T2_A1452PaiBasePromCnt2 ;
   private String[] T004T2_A1453PaiBasePromTCnt ;
   private int[] T004T2_A2053PaiBaseRelSec ;
   private String[] T004T2_A2054PaiBaseRelRef ;
   private String[] T004T2_A2069PaiBaseOld ;
   private short[] T004T2_A46PaiCod ;
   private short[] T004T13_A46PaiCod ;
   private byte[] T004T13_A1440PaiBaseClaseLeg ;
   private String[] T004T13_A1441PaiBaseTipo ;
   private String[] T004T13_A1442PaiBaseCod1 ;
   private String[] T004T13_A1443PaiBaseCod2 ;
   private String[] T004T13_A1448PaiBasePromCTipo ;
   private String[] T004T13_A1449PaiBasePromFijVar ;
   private short[] T004T14_A46PaiCod ;
   private byte[] T004T14_A1440PaiBaseClaseLeg ;
   private String[] T004T14_A1441PaiBaseTipo ;
   private String[] T004T14_A1442PaiBaseCod1 ;
   private String[] T004T14_A1443PaiBaseCod2 ;
   private int[] T004T14_A1445PaiBaseCliCod ;
   private String[] T004T14_A1446PaiBaseConCodigo ;
   private short[] T004T15_A46PaiCod ;
   private byte[] T004T15_A1440PaiBaseClaseLeg ;
   private String[] T004T15_A1441PaiBaseTipo ;
   private String[] T004T15_A1442PaiBaseCod1 ;
   private String[] T004T15_A1443PaiBaseCod2 ;
   private int[] T004T16_A1885CliRelSec ;
   private String[] T004T16_A1880CliReDTChar ;
   private int[] T004T16_A3CliCod ;
   private short[] T004T17_A46PaiCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV12WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV15TrnContext ;
}

final  class paisbase_calculo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T004T2", "SELECT PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseOldDefault, PaiBasePlus, PaiLicDLim, PaiLicDSeman, PaiLicDMes, PaiLicDSemes, PaiLicDAnual, PaiLicAdju, PaiLicAdjuObl, PaiLicNecAut, PaiLicIngMot, PaiLicMotObl, PaiBasePromCnt1, PaiBasePromCnt2, PaiBasePromTCnt, PaiBaseRelSec, PaiBaseRelRef, PaiBaseOld, PaiCod FROM Paisbase_calculo WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ?  FOR UPDATE OF Paisbase_calculo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004T3", "SELECT PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseOldDefault, PaiBasePlus, PaiLicDLim, PaiLicDSeman, PaiLicDMes, PaiLicDSemes, PaiLicDAnual, PaiLicAdju, PaiLicAdjuObl, PaiLicNecAut, PaiLicIngMot, PaiLicMotObl, PaiBasePromCnt1, PaiBasePromCnt2, PaiBasePromTCnt, PaiBaseRelSec, PaiBaseRelRef, PaiBaseOld, PaiCod FROM Paisbase_calculo WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004T4", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004T5", "SELECT TM1.PaiBaseClaseLeg, TM1.PaiBaseTipo, TM1.PaiBaseCod1, TM1.PaiBaseCod2, TM1.PaiBaseOldDefault, TM1.PaiBasePlus, TM1.PaiLicDLim, TM1.PaiLicDSeman, TM1.PaiLicDMes, TM1.PaiLicDSemes, TM1.PaiLicDAnual, TM1.PaiLicAdju, TM1.PaiLicAdjuObl, TM1.PaiLicNecAut, TM1.PaiLicIngMot, TM1.PaiLicMotObl, TM1.PaiBasePromCnt1, TM1.PaiBasePromCnt2, TM1.PaiBasePromTCnt, TM1.PaiBaseRelSec, TM1.PaiBaseRelRef, TM1.PaiBaseOld, TM1.PaiCod FROM Paisbase_calculo TM1 WHERE TM1.PaiCod = ? and TM1.PaiBaseClaseLeg = ? and TM1.PaiBaseTipo = ( ?) and TM1.PaiBaseCod1 = ( ?) and TM1.PaiBaseCod2 = ( ?) ORDER BY TM1.PaiCod, TM1.PaiBaseClaseLeg, TM1.PaiBaseTipo, TM1.PaiBaseCod1, TM1.PaiBaseCod2 ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004T6", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004T7", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2 FROM Paisbase_calculo WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004T8", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2 FROM Paisbase_calculo WHERE ( PaiCod > ? or PaiCod = ? and PaiBaseClaseLeg > ? or PaiBaseClaseLeg = ? and PaiCod = ? and PaiBaseTipo > ( ?) or PaiBaseTipo = ( ?) and PaiBaseClaseLeg = ? and PaiCod = ? and PaiBaseCod1 > ( ?) or PaiBaseCod1 = ( ?) and PaiBaseTipo = ( ?) and PaiBaseClaseLeg = ? and PaiCod = ? and PaiBaseCod2 > ( ?)) ORDER BY PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004T9", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2 FROM Paisbase_calculo WHERE ( PaiCod < ? or PaiCod = ? and PaiBaseClaseLeg < ? or PaiBaseClaseLeg = ? and PaiCod = ? and PaiBaseTipo < ( ?) or PaiBaseTipo = ( ?) and PaiBaseClaseLeg = ? and PaiCod = ? and PaiBaseCod1 < ( ?) or PaiBaseCod1 = ( ?) and PaiBaseTipo = ( ?) and PaiBaseClaseLeg = ? and PaiCod = ? and PaiBaseCod2 < ( ?)) ORDER BY PaiCod DESC, PaiBaseClaseLeg DESC, PaiBaseTipo DESC, PaiBaseCod1 DESC, PaiBaseCod2 DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T004T10", "SAVEPOINT gxupdate;INSERT INTO Paisbase_calculo(PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseOldDefault, PaiBasePlus, PaiLicDLim, PaiLicDSeman, PaiLicDMes, PaiLicDSemes, PaiLicDAnual, PaiLicAdju, PaiLicAdjuObl, PaiLicNecAut, PaiLicIngMot, PaiLicMotObl, PaiBasePromCnt1, PaiBasePromCnt2, PaiBasePromTCnt, PaiBaseRelSec, PaiBaseRelRef, PaiBaseOld, PaiCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004T11", "SAVEPOINT gxupdate;UPDATE Paisbase_calculo SET PaiBaseOldDefault=?, PaiBasePlus=?, PaiLicDLim=?, PaiLicDSeman=?, PaiLicDMes=?, PaiLicDSemes=?, PaiLicDAnual=?, PaiLicAdju=?, PaiLicAdjuObl=?, PaiLicNecAut=?, PaiLicIngMot=?, PaiLicMotObl=?, PaiBasePromCnt1=?, PaiBasePromCnt2=?, PaiBasePromTCnt=?, PaiBaseRelSec=?, PaiBaseRelRef=?, PaiBaseOld=?  WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004T12", "SAVEPOINT gxupdate;DELETE FROM Paisbase_calculo  WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004T13", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePromCTipo, PaiBasePromFijVar FROM Paisbase_calculopromedio WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004T14", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBaseCliCod, PaiBaseConCodigo FROM Paisbase_calculoactual WHERE PaiCod = ? AND PaiBaseClaseLeg = ? AND PaiBaseTipo = ? AND PaiBaseCod1 = ? AND PaiBaseCod2 = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004T15", "SELECT PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2 FROM Paisbase_calculo ORDER BY PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2 ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004T16", "SELECT CliRelSec, CliReDTChar, CliCod FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004T17", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               ((int[]) buf[19])[0] = rslt.getInt(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getLongVarchar(22);
               ((short[]) buf[22])[0] = rslt.getShort(23);
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               ((int[]) buf[19])[0] = rslt.getInt(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getLongVarchar(22);
               ((short[]) buf[22])[0] = rslt.getShort(23);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               ((int[]) buf[19])[0] = rslt.getInt(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getLongVarchar(22);
               ((short[]) buf[22])[0] = rslt.getShort(23);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 15 :
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
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 20);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setByte(13, ((Number) parms[12]).byteValue());
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setString(15, (String)parms[14], 20);
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 20);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setByte(13, ((Number) parms[12]).byteValue());
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setString(15, (String)parms[14], 20);
               return;
            case 8 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setNLongVarchar(5, (String)parms[4], false);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 4);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setBoolean(12, ((Boolean) parms[11]).booleanValue());
               stmt.setBoolean(13, ((Boolean) parms[12]).booleanValue());
               stmt.setBoolean(14, ((Boolean) parms[13]).booleanValue());
               stmt.setBoolean(15, ((Boolean) parms[14]).booleanValue());
               stmt.setBoolean(16, ((Boolean) parms[15]).booleanValue());
               stmt.setShort(17, ((Number) parms[16]).shortValue());
               stmt.setShort(18, ((Number) parms[17]).shortValue());
               stmt.setString(19, (String)parms[18], 20);
               stmt.setInt(20, ((Number) parms[19]).intValue());
               stmt.setVarchar(21, (String)parms[20], 40, false);
               stmt.setNLongVarchar(22, (String)parms[21], false);
               stmt.setShort(23, ((Number) parms[22]).shortValue());
               return;
            case 9 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 4);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setBoolean(11, ((Boolean) parms[10]).booleanValue());
               stmt.setBoolean(12, ((Boolean) parms[11]).booleanValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setString(15, (String)parms[14], 20);
               stmt.setInt(16, ((Number) parms[15]).intValue());
               stmt.setVarchar(17, (String)parms[16], 40, false);
               stmt.setNLongVarchar(18, (String)parms[17], false);
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setByte(20, ((Number) parms[19]).byteValue());
               stmt.setString(21, (String)parms[20], 20);
               stmt.setString(22, (String)parms[21], 20);
               stmt.setString(23, (String)parms[22], 20);
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

