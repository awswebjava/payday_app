package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajofamilia_bc extends GXWebPanel implements IGxSilentTrn
{
   public legajofamilia_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajofamilia_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajofamilia_bc.class ));
   }

   public legajofamilia_bc( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0Q24( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0Q24( ) ;
      standaloneModal( ) ;
      addRow0Q24( ) ;
      Gx_mode = "INS" ;
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
         e110Q2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z29LegOrden = A29LegOrden ;
            SetMode( "UPD") ;
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

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_0Q0( )
   {
      beforeValidate0Q24( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0Q24( ) ;
         }
         else
         {
            checkExtendedTable0Q24( ) ;
            if ( AnyError == 0 )
            {
               zm0Q24( 4) ;
               zm0Q24( 5) ;
               zm0Q24( 6) ;
            }
            closeExtendedTableCursors0Q24( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120Q2( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e110Q2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
   }

   public void zm0Q24( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         Z198FamApellido = A198FamApellido ;
         Z212FamNombres = A212FamNombres ;
         Z2090FamNomApe = A2090FamNomApe ;
         Z209FamFecNac = A209FamFecNac ;
         Z205FamDiscap = A205FamDiscap ;
         Z199FamAsigFam = A199FamAsigFam ;
         Z220FamTomaDeducImpGan = A220FamTomaDeducImpGan ;
         Z750FamNroDoc = A750FamNroDoc ;
         Z751FamMesDesde = A751FamMesDesde ;
         Z752FamMesHasta = A752FamMesHasta ;
         Z890FamAdherente = A890FamAdherente ;
         Z30ParCod = A30ParCod ;
         Z1547GuarCod = A1547GuarCod ;
      }
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         Z313ParDescrip = A313ParDescrip ;
      }
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -3 )
      {
         Z29LegOrden = A29LegOrden ;
         Z198FamApellido = A198FamApellido ;
         Z212FamNombres = A212FamNombres ;
         Z2090FamNomApe = A2090FamNomApe ;
         Z209FamFecNac = A209FamFecNac ;
         Z205FamDiscap = A205FamDiscap ;
         Z199FamAsigFam = A199FamAsigFam ;
         Z220FamTomaDeducImpGan = A220FamTomaDeducImpGan ;
         Z750FamNroDoc = A750FamNroDoc ;
         Z751FamMesDesde = A751FamMesDesde ;
         Z752FamMesHasta = A752FamMesHasta ;
         Z890FamAdherente = A890FamAdherente ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z30ParCod = A30ParCod ;
         Z1547GuarCod = A1547GuarCod ;
         Z313ParDescrip = A313ParDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A220FamTomaDeducImpGan)==0) && ( Gx_BScreen == 0 ) )
      {
         A220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0Q24( )
   {
      /* Using cursor BC000Q7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound24 = (short)(1) ;
         A198FamApellido = BC000Q7_A198FamApellido[0] ;
         A212FamNombres = BC000Q7_A212FamNombres[0] ;
         A2090FamNomApe = BC000Q7_A2090FamNomApe[0] ;
         A313ParDescrip = BC000Q7_A313ParDescrip[0] ;
         A209FamFecNac = BC000Q7_A209FamFecNac[0] ;
         n209FamFecNac = BC000Q7_n209FamFecNac[0] ;
         A205FamDiscap = BC000Q7_A205FamDiscap[0] ;
         n205FamDiscap = BC000Q7_n205FamDiscap[0] ;
         A199FamAsigFam = BC000Q7_A199FamAsigFam[0] ;
         A220FamTomaDeducImpGan = BC000Q7_A220FamTomaDeducImpGan[0] ;
         A750FamNroDoc = BC000Q7_A750FamNroDoc[0] ;
         A751FamMesDesde = BC000Q7_A751FamMesDesde[0] ;
         A752FamMesHasta = BC000Q7_A752FamMesHasta[0] ;
         A890FamAdherente = BC000Q7_A890FamAdherente[0] ;
         A30ParCod = BC000Q7_A30ParCod[0] ;
         A1547GuarCod = BC000Q7_A1547GuarCod[0] ;
         n1547GuarCod = BC000Q7_n1547GuarCod[0] ;
         zm0Q24( -3) ;
      }
      pr_default.close(5);
      onLoadActions0Q24( ) ;
   }

   public void onLoadActions0Q24( )
   {
   }

   public void checkExtendedTable0Q24( )
   {
      nIsDirty_24 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC000Q8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A30ParCod});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Parentesco", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PARCOD");
         AnyError = (short)(1) ;
      }
      A313ParDescrip = BC000Q8_A313ParDescrip[0] ;
      pr_default.close(6);
      /* Using cursor BC000Q9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1547GuarCod), Short.valueOf(A1547GuarCod)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A1547GuarCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Guarderias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "GUARCOD");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(7);
      /* Using cursor BC000Q10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
      }
      pr_default.close(8);
      if ( ! ( ( A220FamTomaDeducImpGan.doubleValue() == 1 ) || ( DecimalUtil.compareTo(A220FamTomaDeducImpGan, DecimalUtil.stringToDec("0.5")) == 0 ) || ( A220FamTomaDeducImpGan.doubleValue() == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Deduce ganancias", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0Q24( )
   {
      pr_default.close(6);
      pr_default.close(7);
      pr_default.close(8);
   }

   public void enableDisable( )
   {
   }

   public void getKey0Q24( )
   {
      /* Using cursor BC000Q11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound24 = (short)(1) ;
      }
      else
      {
         RcdFound24 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000Q12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         zm0Q24( 3) ;
         RcdFound24 = (short)(1) ;
         A29LegOrden = BC000Q12_A29LegOrden[0] ;
         A198FamApellido = BC000Q12_A198FamApellido[0] ;
         A212FamNombres = BC000Q12_A212FamNombres[0] ;
         A2090FamNomApe = BC000Q12_A2090FamNomApe[0] ;
         A209FamFecNac = BC000Q12_A209FamFecNac[0] ;
         n209FamFecNac = BC000Q12_n209FamFecNac[0] ;
         A205FamDiscap = BC000Q12_A205FamDiscap[0] ;
         n205FamDiscap = BC000Q12_n205FamDiscap[0] ;
         A199FamAsigFam = BC000Q12_A199FamAsigFam[0] ;
         A220FamTomaDeducImpGan = BC000Q12_A220FamTomaDeducImpGan[0] ;
         A750FamNroDoc = BC000Q12_A750FamNroDoc[0] ;
         A751FamMesDesde = BC000Q12_A751FamMesDesde[0] ;
         A752FamMesHasta = BC000Q12_A752FamMesHasta[0] ;
         A890FamAdherente = BC000Q12_A890FamAdherente[0] ;
         A3CliCod = BC000Q12_A3CliCod[0] ;
         A1EmpCod = BC000Q12_A1EmpCod[0] ;
         A6LegNumero = BC000Q12_A6LegNumero[0] ;
         A30ParCod = BC000Q12_A30ParCod[0] ;
         A1547GuarCod = BC000Q12_A1547GuarCod[0] ;
         n1547GuarCod = BC000Q12_n1547GuarCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z29LegOrden = A29LegOrden ;
         sMode24 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0Q24( ) ;
         if ( AnyError == 1 )
         {
            RcdFound24 = (short)(0) ;
            initializeNonKey0Q24( ) ;
         }
         Gx_mode = sMode24 ;
      }
      else
      {
         RcdFound24 = (short)(0) ;
         initializeNonKey0Q24( ) ;
         sMode24 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode24 ;
      }
      pr_default.close(10);
   }

   public void getEqualNoModal( )
   {
      getKey0Q24( ) ;
      if ( RcdFound24 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_0Q0( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency0Q24( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000Q13 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
         if ( (pr_default.getStatus(11) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoFamilia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(11) == 101) || ( GXutil.strcmp(Z198FamApellido, BC000Q13_A198FamApellido[0]) != 0 ) || ( GXutil.strcmp(Z212FamNombres, BC000Q13_A212FamNombres[0]) != 0 ) || ( GXutil.strcmp(Z2090FamNomApe, BC000Q13_A2090FamNomApe[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z209FamFecNac), GXutil.resetTime(BC000Q13_A209FamFecNac[0])) ) || ( Z205FamDiscap != BC000Q13_A205FamDiscap[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z199FamAsigFam != BC000Q13_A199FamAsigFam[0] ) || ( DecimalUtil.compareTo(Z220FamTomaDeducImpGan, BC000Q13_A220FamTomaDeducImpGan[0]) != 0 ) || ( GXutil.strcmp(Z750FamNroDoc, BC000Q13_A750FamNroDoc[0]) != 0 ) || ( Z751FamMesDesde != BC000Q13_A751FamMesDesde[0] ) || ( Z752FamMesHasta != BC000Q13_A752FamMesHasta[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z890FamAdherente != BC000Q13_A890FamAdherente[0] ) || ( GXutil.strcmp(Z30ParCod, BC000Q13_A30ParCod[0]) != 0 ) || ( Z1547GuarCod != BC000Q13_A1547GuarCod[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LegajoFamilia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0Q24( )
   {
      beforeValidate0Q24( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Q24( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0Q24( 0) ;
         checkOptimisticConcurrency0Q24( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Q24( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0Q24( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000Q14 */
                  pr_default.execute(12, new Object[] {Short.valueOf(A29LegOrden), A198FamApellido, A212FamNombres, A2090FamNomApe, Boolean.valueOf(n209FamFecNac), A209FamFecNac, Boolean.valueOf(n205FamDiscap), Boolean.valueOf(A205FamDiscap), Boolean.valueOf(A199FamAsigFam), A220FamTomaDeducImpGan, A750FamNroDoc, Short.valueOf(A751FamMesDesde), Short.valueOf(A752FamMesHasta), Boolean.valueOf(A890FamAdherente), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A30ParCod, Boolean.valueOf(n1547GuarCod), Short.valueOf(A1547GuarCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoFamilia");
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
            load0Q24( ) ;
         }
         endLevel0Q24( ) ;
      }
      closeExtendedTableCursors0Q24( ) ;
   }

   public void update0Q24( )
   {
      beforeValidate0Q24( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Q24( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Q24( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Q24( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0Q24( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000Q15 */
                  pr_default.execute(13, new Object[] {A198FamApellido, A212FamNombres, A2090FamNomApe, Boolean.valueOf(n209FamFecNac), A209FamFecNac, Boolean.valueOf(n205FamDiscap), Boolean.valueOf(A205FamDiscap), Boolean.valueOf(A199FamAsigFam), A220FamTomaDeducImpGan, A750FamNroDoc, Short.valueOf(A751FamMesDesde), Short.valueOf(A752FamMesHasta), Boolean.valueOf(A890FamAdherente), A30ParCod, Boolean.valueOf(n1547GuarCod), Short.valueOf(A1547GuarCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoFamilia");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoFamilia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0Q24( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
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
         endLevel0Q24( ) ;
      }
      closeExtendedTableCursors0Q24( ) ;
   }

   public void deferredUpdate0Q24( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0Q24( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Q24( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0Q24( ) ;
         afterConfirm0Q24( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0Q24( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000Q16 */
               pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoFamilia");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
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
      sMode24 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0Q24( ) ;
      Gx_mode = sMode24 ;
   }

   public void onDeleteControls0Q24( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000Q17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A30ParCod});
         A313ParDescrip = BC000Q17_A313ParDescrip[0] ;
         pr_default.close(15);
      }
   }

   public void endLevel0Q24( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(11);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0Q24( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0Q24( )
   {
      /* Scan By routine */
      /* Using cursor BC000Q18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
      RcdFound24 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound24 = (short)(1) ;
         A29LegOrden = BC000Q18_A29LegOrden[0] ;
         A198FamApellido = BC000Q18_A198FamApellido[0] ;
         A212FamNombres = BC000Q18_A212FamNombres[0] ;
         A2090FamNomApe = BC000Q18_A2090FamNomApe[0] ;
         A313ParDescrip = BC000Q18_A313ParDescrip[0] ;
         A209FamFecNac = BC000Q18_A209FamFecNac[0] ;
         n209FamFecNac = BC000Q18_n209FamFecNac[0] ;
         A205FamDiscap = BC000Q18_A205FamDiscap[0] ;
         n205FamDiscap = BC000Q18_n205FamDiscap[0] ;
         A199FamAsigFam = BC000Q18_A199FamAsigFam[0] ;
         A220FamTomaDeducImpGan = BC000Q18_A220FamTomaDeducImpGan[0] ;
         A750FamNroDoc = BC000Q18_A750FamNroDoc[0] ;
         A751FamMesDesde = BC000Q18_A751FamMesDesde[0] ;
         A752FamMesHasta = BC000Q18_A752FamMesHasta[0] ;
         A890FamAdherente = BC000Q18_A890FamAdherente[0] ;
         A3CliCod = BC000Q18_A3CliCod[0] ;
         A1EmpCod = BC000Q18_A1EmpCod[0] ;
         A6LegNumero = BC000Q18_A6LegNumero[0] ;
         A30ParCod = BC000Q18_A30ParCod[0] ;
         A1547GuarCod = BC000Q18_A1547GuarCod[0] ;
         n1547GuarCod = BC000Q18_n1547GuarCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0Q24( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound24 = (short)(0) ;
      scanKeyLoad0Q24( ) ;
   }

   public void scanKeyLoad0Q24( )
   {
      sMode24 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound24 = (short)(1) ;
         A29LegOrden = BC000Q18_A29LegOrden[0] ;
         A198FamApellido = BC000Q18_A198FamApellido[0] ;
         A212FamNombres = BC000Q18_A212FamNombres[0] ;
         A2090FamNomApe = BC000Q18_A2090FamNomApe[0] ;
         A313ParDescrip = BC000Q18_A313ParDescrip[0] ;
         A209FamFecNac = BC000Q18_A209FamFecNac[0] ;
         n209FamFecNac = BC000Q18_n209FamFecNac[0] ;
         A205FamDiscap = BC000Q18_A205FamDiscap[0] ;
         n205FamDiscap = BC000Q18_n205FamDiscap[0] ;
         A199FamAsigFam = BC000Q18_A199FamAsigFam[0] ;
         A220FamTomaDeducImpGan = BC000Q18_A220FamTomaDeducImpGan[0] ;
         A750FamNroDoc = BC000Q18_A750FamNroDoc[0] ;
         A751FamMesDesde = BC000Q18_A751FamMesDesde[0] ;
         A752FamMesHasta = BC000Q18_A752FamMesHasta[0] ;
         A890FamAdherente = BC000Q18_A890FamAdherente[0] ;
         A3CliCod = BC000Q18_A3CliCod[0] ;
         A1EmpCod = BC000Q18_A1EmpCod[0] ;
         A6LegNumero = BC000Q18_A6LegNumero[0] ;
         A30ParCod = BC000Q18_A30ParCod[0] ;
         A1547GuarCod = BC000Q18_A1547GuarCod[0] ;
         n1547GuarCod = BC000Q18_n1547GuarCod[0] ;
      }
      Gx_mode = sMode24 ;
   }

   public void scanKeyEnd0Q24( )
   {
      pr_default.close(16);
   }

   public void afterConfirm0Q24( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0Q24( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0Q24( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0Q24( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0Q24( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0Q24( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0Q24( )
   {
   }

   public void send_integrity_lvl_hashes0Q24( )
   {
   }

   public void addRow0Q24( )
   {
      VarsToRow24( bcLegajoFamilia) ;
   }

   public void readRow0Q24( )
   {
      RowToVars24( bcLegajoFamilia, 1) ;
   }

   public void initializeNonKey0Q24( )
   {
      A198FamApellido = "" ;
      A212FamNombres = "" ;
      A2090FamNomApe = "" ;
      A30ParCod = "" ;
      A313ParDescrip = "" ;
      A209FamFecNac = GXutil.nullDate() ;
      n209FamFecNac = false ;
      A205FamDiscap = false ;
      n205FamDiscap = false ;
      A199FamAsigFam = false ;
      A750FamNroDoc = "" ;
      A751FamMesDesde = (short)(0) ;
      A752FamMesHasta = (short)(0) ;
      A890FamAdherente = false ;
      A1547GuarCod = (short)(0) ;
      n1547GuarCod = false ;
      A220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
      Z198FamApellido = "" ;
      Z212FamNombres = "" ;
      Z2090FamNomApe = "" ;
      Z209FamFecNac = GXutil.nullDate() ;
      Z205FamDiscap = false ;
      Z199FamAsigFam = false ;
      Z220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      Z750FamNroDoc = "" ;
      Z751FamMesDesde = (short)(0) ;
      Z752FamMesHasta = (short)(0) ;
      Z890FamAdherente = false ;
      Z30ParCod = "" ;
      Z1547GuarCod = (short)(0) ;
   }

   public void initAll0Q24( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A6LegNumero = 0 ;
      A29LegOrden = (short)(0) ;
      initializeNonKey0Q24( ) ;
   }

   public void standaloneModalInsert( )
   {
      A220FamTomaDeducImpGan = i220FamTomaDeducImpGan ;
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

   public void VarsToRow24( web.SdtLegajoFamilia obj24 )
   {
      obj24.setgxTv_SdtLegajoFamilia_Mode( Gx_mode );
      obj24.setgxTv_SdtLegajoFamilia_Famapellido( A198FamApellido );
      obj24.setgxTv_SdtLegajoFamilia_Famnombres( A212FamNombres );
      obj24.setgxTv_SdtLegajoFamilia_Famnomape( A2090FamNomApe );
      obj24.setgxTv_SdtLegajoFamilia_Parcod( A30ParCod );
      obj24.setgxTv_SdtLegajoFamilia_Pardescrip( A313ParDescrip );
      obj24.setgxTv_SdtLegajoFamilia_Famfecnac( A209FamFecNac );
      obj24.setgxTv_SdtLegajoFamilia_Famdiscap( A205FamDiscap );
      obj24.setgxTv_SdtLegajoFamilia_Famasigfam( A199FamAsigFam );
      obj24.setgxTv_SdtLegajoFamilia_Famnrodoc( A750FamNroDoc );
      obj24.setgxTv_SdtLegajoFamilia_Fammesdesde( A751FamMesDesde );
      obj24.setgxTv_SdtLegajoFamilia_Fammeshasta( A752FamMesHasta );
      obj24.setgxTv_SdtLegajoFamilia_Famadherente( A890FamAdherente );
      obj24.setgxTv_SdtLegajoFamilia_Guarcod( A1547GuarCod );
      obj24.setgxTv_SdtLegajoFamilia_Famtomadeducimpgan( A220FamTomaDeducImpGan );
      obj24.setgxTv_SdtLegajoFamilia_Clicod( A3CliCod );
      obj24.setgxTv_SdtLegajoFamilia_Empcod( A1EmpCod );
      obj24.setgxTv_SdtLegajoFamilia_Legnumero( A6LegNumero );
      obj24.setgxTv_SdtLegajoFamilia_Legorden( A29LegOrden );
      obj24.setgxTv_SdtLegajoFamilia_Clicod_Z( Z3CliCod );
      obj24.setgxTv_SdtLegajoFamilia_Empcod_Z( Z1EmpCod );
      obj24.setgxTv_SdtLegajoFamilia_Legnumero_Z( Z6LegNumero );
      obj24.setgxTv_SdtLegajoFamilia_Legorden_Z( Z29LegOrden );
      obj24.setgxTv_SdtLegajoFamilia_Famapellido_Z( Z198FamApellido );
      obj24.setgxTv_SdtLegajoFamilia_Famnombres_Z( Z212FamNombres );
      obj24.setgxTv_SdtLegajoFamilia_Famnomape_Z( Z2090FamNomApe );
      obj24.setgxTv_SdtLegajoFamilia_Parcod_Z( Z30ParCod );
      obj24.setgxTv_SdtLegajoFamilia_Pardescrip_Z( Z313ParDescrip );
      obj24.setgxTv_SdtLegajoFamilia_Famfecnac_Z( Z209FamFecNac );
      obj24.setgxTv_SdtLegajoFamilia_Famdiscap_Z( Z205FamDiscap );
      obj24.setgxTv_SdtLegajoFamilia_Famasigfam_Z( Z199FamAsigFam );
      obj24.setgxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z( Z220FamTomaDeducImpGan );
      obj24.setgxTv_SdtLegajoFamilia_Famnrodoc_Z( Z750FamNroDoc );
      obj24.setgxTv_SdtLegajoFamilia_Fammesdesde_Z( Z751FamMesDesde );
      obj24.setgxTv_SdtLegajoFamilia_Fammeshasta_Z( Z752FamMesHasta );
      obj24.setgxTv_SdtLegajoFamilia_Famadherente_Z( Z890FamAdherente );
      obj24.setgxTv_SdtLegajoFamilia_Guarcod_Z( Z1547GuarCod );
      obj24.setgxTv_SdtLegajoFamilia_Famfecnac_N( (byte)((byte)((n209FamFecNac)?1:0)) );
      obj24.setgxTv_SdtLegajoFamilia_Famdiscap_N( (byte)((byte)((n205FamDiscap)?1:0)) );
      obj24.setgxTv_SdtLegajoFamilia_Guarcod_N( (byte)((byte)((n1547GuarCod)?1:0)) );
      obj24.setgxTv_SdtLegajoFamilia_Mode( Gx_mode );
   }

   public void KeyVarsToRow24( web.SdtLegajoFamilia obj24 )
   {
      obj24.setgxTv_SdtLegajoFamilia_Clicod( A3CliCod );
      obj24.setgxTv_SdtLegajoFamilia_Empcod( A1EmpCod );
      obj24.setgxTv_SdtLegajoFamilia_Legnumero( A6LegNumero );
      obj24.setgxTv_SdtLegajoFamilia_Legorden( A29LegOrden );
   }

   public void RowToVars24( web.SdtLegajoFamilia obj24 ,
                            int forceLoad )
   {
      Gx_mode = obj24.getgxTv_SdtLegajoFamilia_Mode() ;
      A198FamApellido = obj24.getgxTv_SdtLegajoFamilia_Famapellido() ;
      A212FamNombres = obj24.getgxTv_SdtLegajoFamilia_Famnombres() ;
      A2090FamNomApe = obj24.getgxTv_SdtLegajoFamilia_Famnomape() ;
      A30ParCod = obj24.getgxTv_SdtLegajoFamilia_Parcod() ;
      A313ParDescrip = obj24.getgxTv_SdtLegajoFamilia_Pardescrip() ;
      A209FamFecNac = obj24.getgxTv_SdtLegajoFamilia_Famfecnac() ;
      n209FamFecNac = false ;
      A205FamDiscap = obj24.getgxTv_SdtLegajoFamilia_Famdiscap() ;
      n205FamDiscap = false ;
      A199FamAsigFam = obj24.getgxTv_SdtLegajoFamilia_Famasigfam() ;
      A750FamNroDoc = obj24.getgxTv_SdtLegajoFamilia_Famnrodoc() ;
      A751FamMesDesde = obj24.getgxTv_SdtLegajoFamilia_Fammesdesde() ;
      A752FamMesHasta = obj24.getgxTv_SdtLegajoFamilia_Fammeshasta() ;
      A890FamAdherente = obj24.getgxTv_SdtLegajoFamilia_Famadherente() ;
      A1547GuarCod = obj24.getgxTv_SdtLegajoFamilia_Guarcod() ;
      n1547GuarCod = false ;
      A220FamTomaDeducImpGan = obj24.getgxTv_SdtLegajoFamilia_Famtomadeducimpgan() ;
      A3CliCod = obj24.getgxTv_SdtLegajoFamilia_Clicod() ;
      if ( forceLoad == 1 )
      {
         A1EmpCod = obj24.getgxTv_SdtLegajoFamilia_Empcod() ;
      }
      if ( forceLoad == 1 )
      {
         A6LegNumero = obj24.getgxTv_SdtLegajoFamilia_Legnumero() ;
      }
      A29LegOrden = obj24.getgxTv_SdtLegajoFamilia_Legorden() ;
      Z3CliCod = obj24.getgxTv_SdtLegajoFamilia_Clicod_Z() ;
      Z1EmpCod = obj24.getgxTv_SdtLegajoFamilia_Empcod_Z() ;
      Z6LegNumero = obj24.getgxTv_SdtLegajoFamilia_Legnumero_Z() ;
      Z29LegOrden = obj24.getgxTv_SdtLegajoFamilia_Legorden_Z() ;
      Z198FamApellido = obj24.getgxTv_SdtLegajoFamilia_Famapellido_Z() ;
      Z212FamNombres = obj24.getgxTv_SdtLegajoFamilia_Famnombres_Z() ;
      Z2090FamNomApe = obj24.getgxTv_SdtLegajoFamilia_Famnomape_Z() ;
      Z30ParCod = obj24.getgxTv_SdtLegajoFamilia_Parcod_Z() ;
      Z313ParDescrip = obj24.getgxTv_SdtLegajoFamilia_Pardescrip_Z() ;
      Z209FamFecNac = obj24.getgxTv_SdtLegajoFamilia_Famfecnac_Z() ;
      Z205FamDiscap = obj24.getgxTv_SdtLegajoFamilia_Famdiscap_Z() ;
      Z199FamAsigFam = obj24.getgxTv_SdtLegajoFamilia_Famasigfam_Z() ;
      Z220FamTomaDeducImpGan = obj24.getgxTv_SdtLegajoFamilia_Famtomadeducimpgan_Z() ;
      Z750FamNroDoc = obj24.getgxTv_SdtLegajoFamilia_Famnrodoc_Z() ;
      Z751FamMesDesde = obj24.getgxTv_SdtLegajoFamilia_Fammesdesde_Z() ;
      Z752FamMesHasta = obj24.getgxTv_SdtLegajoFamilia_Fammeshasta_Z() ;
      Z890FamAdherente = obj24.getgxTv_SdtLegajoFamilia_Famadherente_Z() ;
      Z1547GuarCod = obj24.getgxTv_SdtLegajoFamilia_Guarcod_Z() ;
      n209FamFecNac = (boolean)((obj24.getgxTv_SdtLegajoFamilia_Famfecnac_N()==0)?false:true) ;
      n205FamDiscap = (boolean)((obj24.getgxTv_SdtLegajoFamilia_Famdiscap_N()==0)?false:true) ;
      n1547GuarCod = (boolean)((obj24.getgxTv_SdtLegajoFamilia_Guarcod_N()==0)?false:true) ;
      Gx_mode = obj24.getgxTv_SdtLegajoFamilia_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A6LegNumero = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      A29LegOrden = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0Q24( ) ;
      scanKeyStart0Q24( ) ;
      if ( RcdFound24 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000Q19 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(17) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z29LegOrden = A29LegOrden ;
      }
      zm0Q24( -3) ;
      onLoadActions0Q24( ) ;
      addRow0Q24( ) ;
      scanKeyEnd0Q24( ) ;
      if ( RcdFound24 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars24( bcLegajoFamilia, 0) ;
      scanKeyStart0Q24( ) ;
      if ( RcdFound24 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000Q20 */
         pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(18) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z29LegOrden = A29LegOrden ;
      }
      zm0Q24( -3) ;
      onLoadActions0Q24( ) ;
      addRow0Q24( ) ;
      scanKeyEnd0Q24( ) ;
      if ( RcdFound24 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0Q24( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0Q24( ) ;
      }
      else
      {
         if ( RcdFound24 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A29LegOrden != Z29LegOrden ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A6LegNumero = Z6LegNumero ;
               A29LegOrden = Z29LegOrden ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update0Q24( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A29LegOrden != Z29LegOrden ) )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0Q24( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0Q24( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars24( bcLegajoFamilia, 1) ;
      saveImpl( ) ;
      VarsToRow24( bcLegajoFamilia) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars24( bcLegajoFamilia, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0Q24( ) ;
      afterTrn( ) ;
      VarsToRow24( bcLegajoFamilia) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         web.SdtLegajoFamilia auxBC = new web.SdtLegajoFamilia( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A6LegNumero, A29LegOrden);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcLegajoFamilia);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars24( bcLegajoFamilia, 1) ;
      updateImpl( ) ;
      VarsToRow24( bcLegajoFamilia) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars24( bcLegajoFamilia, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0Q24( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow24( bcLegajoFamilia) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars24( bcLegajoFamilia, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0Q24( ) ;
      if ( RcdFound24 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A29LegOrden != Z29LegOrden ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A6LegNumero = Z6LegNumero ;
            A29LegOrden = Z29LegOrden ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A29LegOrden != Z29LegOrden ) )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      Application.rollbackDataStores(context, remoteHandle, pr_default, "legajofamilia_bc");
      VarsToRow24( bcLegajoFamilia) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcLegajoFamilia.getgxTv_SdtLegajoFamilia_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcLegajoFamilia.setgxTv_SdtLegajoFamilia_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtLegajoFamilia sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcLegajoFamilia )
      {
         bcLegajoFamilia = sdt ;
         if ( GXutil.strcmp(bcLegajoFamilia.getgxTv_SdtLegajoFamilia_Mode(), "") == 0 )
         {
            bcLegajoFamilia.setgxTv_SdtLegajoFamilia_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow24( bcLegajoFamilia) ;
         }
         else
         {
            RowToVars24( bcLegajoFamilia, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcLegajoFamilia.getgxTv_SdtLegajoFamilia_Mode(), "") == 0 )
         {
            bcLegajoFamilia.setgxTv_SdtLegajoFamilia_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars24( bcLegajoFamilia, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtLegajoFamilia getLegajoFamilia_BC( )
   {
      return bcLegajoFamilia ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z198FamApellido = "" ;
      A198FamApellido = "" ;
      Z212FamNombres = "" ;
      A212FamNombres = "" ;
      Z2090FamNomApe = "" ;
      A2090FamNomApe = "" ;
      Z209FamFecNac = GXutil.nullDate() ;
      A209FamFecNac = GXutil.nullDate() ;
      Z220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      A220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      Z750FamNroDoc = "" ;
      A750FamNroDoc = "" ;
      Z30ParCod = "" ;
      A30ParCod = "" ;
      Z313ParDescrip = "" ;
      A313ParDescrip = "" ;
      BC000Q7_A29LegOrden = new short[1] ;
      BC000Q7_A198FamApellido = new String[] {""} ;
      BC000Q7_A212FamNombres = new String[] {""} ;
      BC000Q7_A2090FamNomApe = new String[] {""} ;
      BC000Q7_A313ParDescrip = new String[] {""} ;
      BC000Q7_A209FamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000Q7_n209FamFecNac = new boolean[] {false} ;
      BC000Q7_A205FamDiscap = new boolean[] {false} ;
      BC000Q7_n205FamDiscap = new boolean[] {false} ;
      BC000Q7_A199FamAsigFam = new boolean[] {false} ;
      BC000Q7_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000Q7_A750FamNroDoc = new String[] {""} ;
      BC000Q7_A751FamMesDesde = new short[1] ;
      BC000Q7_A752FamMesHasta = new short[1] ;
      BC000Q7_A890FamAdherente = new boolean[] {false} ;
      BC000Q7_A3CliCod = new int[1] ;
      BC000Q7_A1EmpCod = new short[1] ;
      BC000Q7_A6LegNumero = new int[1] ;
      BC000Q7_A30ParCod = new String[] {""} ;
      BC000Q7_A1547GuarCod = new short[1] ;
      BC000Q7_n1547GuarCod = new boolean[] {false} ;
      BC000Q8_A313ParDescrip = new String[] {""} ;
      BC000Q9_A3CliCod = new int[1] ;
      BC000Q10_A3CliCod = new int[1] ;
      BC000Q11_A3CliCod = new int[1] ;
      BC000Q11_A1EmpCod = new short[1] ;
      BC000Q11_A6LegNumero = new int[1] ;
      BC000Q11_A29LegOrden = new short[1] ;
      BC000Q12_A29LegOrden = new short[1] ;
      BC000Q12_A198FamApellido = new String[] {""} ;
      BC000Q12_A212FamNombres = new String[] {""} ;
      BC000Q12_A2090FamNomApe = new String[] {""} ;
      BC000Q12_A209FamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000Q12_n209FamFecNac = new boolean[] {false} ;
      BC000Q12_A205FamDiscap = new boolean[] {false} ;
      BC000Q12_n205FamDiscap = new boolean[] {false} ;
      BC000Q12_A199FamAsigFam = new boolean[] {false} ;
      BC000Q12_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000Q12_A750FamNroDoc = new String[] {""} ;
      BC000Q12_A751FamMesDesde = new short[1] ;
      BC000Q12_A752FamMesHasta = new short[1] ;
      BC000Q12_A890FamAdherente = new boolean[] {false} ;
      BC000Q12_A3CliCod = new int[1] ;
      BC000Q12_A1EmpCod = new short[1] ;
      BC000Q12_A6LegNumero = new int[1] ;
      BC000Q12_A30ParCod = new String[] {""} ;
      BC000Q12_A1547GuarCod = new short[1] ;
      BC000Q12_n1547GuarCod = new boolean[] {false} ;
      sMode24 = "" ;
      BC000Q13_A29LegOrden = new short[1] ;
      BC000Q13_A198FamApellido = new String[] {""} ;
      BC000Q13_A212FamNombres = new String[] {""} ;
      BC000Q13_A2090FamNomApe = new String[] {""} ;
      BC000Q13_A209FamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000Q13_n209FamFecNac = new boolean[] {false} ;
      BC000Q13_A205FamDiscap = new boolean[] {false} ;
      BC000Q13_n205FamDiscap = new boolean[] {false} ;
      BC000Q13_A199FamAsigFam = new boolean[] {false} ;
      BC000Q13_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000Q13_A750FamNroDoc = new String[] {""} ;
      BC000Q13_A751FamMesDesde = new short[1] ;
      BC000Q13_A752FamMesHasta = new short[1] ;
      BC000Q13_A890FamAdherente = new boolean[] {false} ;
      BC000Q13_A3CliCod = new int[1] ;
      BC000Q13_A1EmpCod = new short[1] ;
      BC000Q13_A6LegNumero = new int[1] ;
      BC000Q13_A30ParCod = new String[] {""} ;
      BC000Q13_A1547GuarCod = new short[1] ;
      BC000Q13_n1547GuarCod = new boolean[] {false} ;
      BC000Q17_A313ParDescrip = new String[] {""} ;
      BC000Q18_A29LegOrden = new short[1] ;
      BC000Q18_A198FamApellido = new String[] {""} ;
      BC000Q18_A212FamNombres = new String[] {""} ;
      BC000Q18_A2090FamNomApe = new String[] {""} ;
      BC000Q18_A313ParDescrip = new String[] {""} ;
      BC000Q18_A209FamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC000Q18_n209FamFecNac = new boolean[] {false} ;
      BC000Q18_A205FamDiscap = new boolean[] {false} ;
      BC000Q18_n205FamDiscap = new boolean[] {false} ;
      BC000Q18_A199FamAsigFam = new boolean[] {false} ;
      BC000Q18_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000Q18_A750FamNroDoc = new String[] {""} ;
      BC000Q18_A751FamMesDesde = new short[1] ;
      BC000Q18_A752FamMesHasta = new short[1] ;
      BC000Q18_A890FamAdherente = new boolean[] {false} ;
      BC000Q18_A3CliCod = new int[1] ;
      BC000Q18_A1EmpCod = new short[1] ;
      BC000Q18_A6LegNumero = new int[1] ;
      BC000Q18_A30ParCod = new String[] {""} ;
      BC000Q18_A1547GuarCod = new short[1] ;
      BC000Q18_n1547GuarCod = new boolean[] {false} ;
      i220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000Q19_A3CliCod = new int[1] ;
      BC000Q20_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajofamilia_bc__default(),
         new Object[] {
             new Object[] {
            BC000Q2_A29LegOrden, BC000Q2_A198FamApellido, BC000Q2_A212FamNombres, BC000Q2_A2090FamNomApe, BC000Q2_A209FamFecNac, BC000Q2_n209FamFecNac, BC000Q2_A205FamDiscap, BC000Q2_n205FamDiscap, BC000Q2_A199FamAsigFam, BC000Q2_A220FamTomaDeducImpGan,
            BC000Q2_A750FamNroDoc, BC000Q2_A751FamMesDesde, BC000Q2_A752FamMesHasta, BC000Q2_A890FamAdherente, BC000Q2_A3CliCod, BC000Q2_A1EmpCod, BC000Q2_A6LegNumero, BC000Q2_A30ParCod, BC000Q2_A1547GuarCod, BC000Q2_n1547GuarCod
            }
            , new Object[] {
            BC000Q3_A29LegOrden, BC000Q3_A198FamApellido, BC000Q3_A212FamNombres, BC000Q3_A2090FamNomApe, BC000Q3_A209FamFecNac, BC000Q3_n209FamFecNac, BC000Q3_A205FamDiscap, BC000Q3_n205FamDiscap, BC000Q3_A199FamAsigFam, BC000Q3_A220FamTomaDeducImpGan,
            BC000Q3_A750FamNroDoc, BC000Q3_A751FamMesDesde, BC000Q3_A752FamMesHasta, BC000Q3_A890FamAdherente, BC000Q3_A3CliCod, BC000Q3_A1EmpCod, BC000Q3_A6LegNumero, BC000Q3_A30ParCod, BC000Q3_A1547GuarCod, BC000Q3_n1547GuarCod
            }
            , new Object[] {
            BC000Q4_A3CliCod
            }
            , new Object[] {
            BC000Q5_A313ParDescrip
            }
            , new Object[] {
            BC000Q6_A3CliCod
            }
            , new Object[] {
            BC000Q7_A29LegOrden, BC000Q7_A198FamApellido, BC000Q7_A212FamNombres, BC000Q7_A2090FamNomApe, BC000Q7_A313ParDescrip, BC000Q7_A209FamFecNac, BC000Q7_n209FamFecNac, BC000Q7_A205FamDiscap, BC000Q7_n205FamDiscap, BC000Q7_A199FamAsigFam,
            BC000Q7_A220FamTomaDeducImpGan, BC000Q7_A750FamNroDoc, BC000Q7_A751FamMesDesde, BC000Q7_A752FamMesHasta, BC000Q7_A890FamAdherente, BC000Q7_A3CliCod, BC000Q7_A1EmpCod, BC000Q7_A6LegNumero, BC000Q7_A30ParCod, BC000Q7_A1547GuarCod,
            BC000Q7_n1547GuarCod
            }
            , new Object[] {
            BC000Q8_A313ParDescrip
            }
            , new Object[] {
            BC000Q9_A3CliCod
            }
            , new Object[] {
            BC000Q10_A3CliCod
            }
            , new Object[] {
            BC000Q11_A3CliCod, BC000Q11_A1EmpCod, BC000Q11_A6LegNumero, BC000Q11_A29LegOrden
            }
            , new Object[] {
            BC000Q12_A29LegOrden, BC000Q12_A198FamApellido, BC000Q12_A212FamNombres, BC000Q12_A2090FamNomApe, BC000Q12_A209FamFecNac, BC000Q12_n209FamFecNac, BC000Q12_A205FamDiscap, BC000Q12_n205FamDiscap, BC000Q12_A199FamAsigFam, BC000Q12_A220FamTomaDeducImpGan,
            BC000Q12_A750FamNroDoc, BC000Q12_A751FamMesDesde, BC000Q12_A752FamMesHasta, BC000Q12_A890FamAdherente, BC000Q12_A3CliCod, BC000Q12_A1EmpCod, BC000Q12_A6LegNumero, BC000Q12_A30ParCod, BC000Q12_A1547GuarCod, BC000Q12_n1547GuarCod
            }
            , new Object[] {
            BC000Q13_A29LegOrden, BC000Q13_A198FamApellido, BC000Q13_A212FamNombres, BC000Q13_A2090FamNomApe, BC000Q13_A209FamFecNac, BC000Q13_n209FamFecNac, BC000Q13_A205FamDiscap, BC000Q13_n205FamDiscap, BC000Q13_A199FamAsigFam, BC000Q13_A220FamTomaDeducImpGan,
            BC000Q13_A750FamNroDoc, BC000Q13_A751FamMesDesde, BC000Q13_A752FamMesHasta, BC000Q13_A890FamAdherente, BC000Q13_A3CliCod, BC000Q13_A1EmpCod, BC000Q13_A6LegNumero, BC000Q13_A30ParCod, BC000Q13_A1547GuarCod, BC000Q13_n1547GuarCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000Q17_A313ParDescrip
            }
            , new Object[] {
            BC000Q18_A29LegOrden, BC000Q18_A198FamApellido, BC000Q18_A212FamNombres, BC000Q18_A2090FamNomApe, BC000Q18_A313ParDescrip, BC000Q18_A209FamFecNac, BC000Q18_n209FamFecNac, BC000Q18_A205FamDiscap, BC000Q18_n205FamDiscap, BC000Q18_A199FamAsigFam,
            BC000Q18_A220FamTomaDeducImpGan, BC000Q18_A750FamNroDoc, BC000Q18_A751FamMesDesde, BC000Q18_A752FamMesHasta, BC000Q18_A890FamAdherente, BC000Q18_A3CliCod, BC000Q18_A1EmpCod, BC000Q18_A6LegNumero, BC000Q18_A30ParCod, BC000Q18_A1547GuarCod,
            BC000Q18_n1547GuarCod
            }
            , new Object[] {
            BC000Q19_A3CliCod
            }
            , new Object[] {
            BC000Q20_A3CliCod
            }
         }
      );
      Z220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
      A220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
      i220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120Q2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short Z29LegOrden ;
   private short A29LegOrden ;
   private short Z751FamMesDesde ;
   private short A751FamMesDesde ;
   private short Z752FamMesHasta ;
   private short A752FamMesHasta ;
   private short Z1547GuarCod ;
   private short A1547GuarCod ;
   private short RcdFound24 ;
   private short nIsDirty_24 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int Z6LegNumero ;
   private int A6LegNumero ;
   private int GX_JID ;
   private java.math.BigDecimal Z220FamTomaDeducImpGan ;
   private java.math.BigDecimal A220FamTomaDeducImpGan ;
   private java.math.BigDecimal i220FamTomaDeducImpGan ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z750FamNroDoc ;
   private String A750FamNroDoc ;
   private String Z30ParCod ;
   private String A30ParCod ;
   private String sMode24 ;
   private java.util.Date Z209FamFecNac ;
   private java.util.Date A209FamFecNac ;
   private boolean returnInSub ;
   private boolean Z205FamDiscap ;
   private boolean A205FamDiscap ;
   private boolean Z199FamAsigFam ;
   private boolean A199FamAsigFam ;
   private boolean Z890FamAdherente ;
   private boolean A890FamAdherente ;
   private boolean n209FamFecNac ;
   private boolean n205FamDiscap ;
   private boolean n1547GuarCod ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z198FamApellido ;
   private String A198FamApellido ;
   private String Z212FamNombres ;
   private String A212FamNombres ;
   private String Z2090FamNomApe ;
   private String A2090FamNomApe ;
   private String Z313ParDescrip ;
   private String A313ParDescrip ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private web.SdtLegajoFamilia bcLegajoFamilia ;
   private IDataStoreProvider pr_default ;
   private short[] BC000Q7_A29LegOrden ;
   private String[] BC000Q7_A198FamApellido ;
   private String[] BC000Q7_A212FamNombres ;
   private String[] BC000Q7_A2090FamNomApe ;
   private String[] BC000Q7_A313ParDescrip ;
   private java.util.Date[] BC000Q7_A209FamFecNac ;
   private boolean[] BC000Q7_n209FamFecNac ;
   private boolean[] BC000Q7_A205FamDiscap ;
   private boolean[] BC000Q7_n205FamDiscap ;
   private boolean[] BC000Q7_A199FamAsigFam ;
   private java.math.BigDecimal[] BC000Q7_A220FamTomaDeducImpGan ;
   private String[] BC000Q7_A750FamNroDoc ;
   private short[] BC000Q7_A751FamMesDesde ;
   private short[] BC000Q7_A752FamMesHasta ;
   private boolean[] BC000Q7_A890FamAdherente ;
   private int[] BC000Q7_A3CliCod ;
   private short[] BC000Q7_A1EmpCod ;
   private int[] BC000Q7_A6LegNumero ;
   private String[] BC000Q7_A30ParCod ;
   private short[] BC000Q7_A1547GuarCod ;
   private boolean[] BC000Q7_n1547GuarCod ;
   private String[] BC000Q8_A313ParDescrip ;
   private int[] BC000Q9_A3CliCod ;
   private int[] BC000Q10_A3CliCod ;
   private int[] BC000Q11_A3CliCod ;
   private short[] BC000Q11_A1EmpCod ;
   private int[] BC000Q11_A6LegNumero ;
   private short[] BC000Q11_A29LegOrden ;
   private short[] BC000Q12_A29LegOrden ;
   private String[] BC000Q12_A198FamApellido ;
   private String[] BC000Q12_A212FamNombres ;
   private String[] BC000Q12_A2090FamNomApe ;
   private java.util.Date[] BC000Q12_A209FamFecNac ;
   private boolean[] BC000Q12_n209FamFecNac ;
   private boolean[] BC000Q12_A205FamDiscap ;
   private boolean[] BC000Q12_n205FamDiscap ;
   private boolean[] BC000Q12_A199FamAsigFam ;
   private java.math.BigDecimal[] BC000Q12_A220FamTomaDeducImpGan ;
   private String[] BC000Q12_A750FamNroDoc ;
   private short[] BC000Q12_A751FamMesDesde ;
   private short[] BC000Q12_A752FamMesHasta ;
   private boolean[] BC000Q12_A890FamAdherente ;
   private int[] BC000Q12_A3CliCod ;
   private short[] BC000Q12_A1EmpCod ;
   private int[] BC000Q12_A6LegNumero ;
   private String[] BC000Q12_A30ParCod ;
   private short[] BC000Q12_A1547GuarCod ;
   private boolean[] BC000Q12_n1547GuarCod ;
   private short[] BC000Q13_A29LegOrden ;
   private String[] BC000Q13_A198FamApellido ;
   private String[] BC000Q13_A212FamNombres ;
   private String[] BC000Q13_A2090FamNomApe ;
   private java.util.Date[] BC000Q13_A209FamFecNac ;
   private boolean[] BC000Q13_n209FamFecNac ;
   private boolean[] BC000Q13_A205FamDiscap ;
   private boolean[] BC000Q13_n205FamDiscap ;
   private boolean[] BC000Q13_A199FamAsigFam ;
   private java.math.BigDecimal[] BC000Q13_A220FamTomaDeducImpGan ;
   private String[] BC000Q13_A750FamNroDoc ;
   private short[] BC000Q13_A751FamMesDesde ;
   private short[] BC000Q13_A752FamMesHasta ;
   private boolean[] BC000Q13_A890FamAdherente ;
   private int[] BC000Q13_A3CliCod ;
   private short[] BC000Q13_A1EmpCod ;
   private int[] BC000Q13_A6LegNumero ;
   private String[] BC000Q13_A30ParCod ;
   private short[] BC000Q13_A1547GuarCod ;
   private boolean[] BC000Q13_n1547GuarCod ;
   private String[] BC000Q17_A313ParDescrip ;
   private short[] BC000Q18_A29LegOrden ;
   private String[] BC000Q18_A198FamApellido ;
   private String[] BC000Q18_A212FamNombres ;
   private String[] BC000Q18_A2090FamNomApe ;
   private String[] BC000Q18_A313ParDescrip ;
   private java.util.Date[] BC000Q18_A209FamFecNac ;
   private boolean[] BC000Q18_n209FamFecNac ;
   private boolean[] BC000Q18_A205FamDiscap ;
   private boolean[] BC000Q18_n205FamDiscap ;
   private boolean[] BC000Q18_A199FamAsigFam ;
   private java.math.BigDecimal[] BC000Q18_A220FamTomaDeducImpGan ;
   private String[] BC000Q18_A750FamNroDoc ;
   private short[] BC000Q18_A751FamMesDesde ;
   private short[] BC000Q18_A752FamMesHasta ;
   private boolean[] BC000Q18_A890FamAdherente ;
   private int[] BC000Q18_A3CliCod ;
   private short[] BC000Q18_A1EmpCod ;
   private int[] BC000Q18_A6LegNumero ;
   private String[] BC000Q18_A30ParCod ;
   private short[] BC000Q18_A1547GuarCod ;
   private boolean[] BC000Q18_n1547GuarCod ;
   private int[] BC000Q19_A3CliCod ;
   private int[] BC000Q20_A3CliCod ;
   private short[] BC000Q2_A29LegOrden ;
   private String[] BC000Q2_A198FamApellido ;
   private String[] BC000Q2_A212FamNombres ;
   private String[] BC000Q2_A2090FamNomApe ;
   private java.util.Date[] BC000Q2_A209FamFecNac ;
   private boolean[] BC000Q2_A205FamDiscap ;
   private boolean[] BC000Q2_A199FamAsigFam ;
   private java.math.BigDecimal[] BC000Q2_A220FamTomaDeducImpGan ;
   private String[] BC000Q2_A750FamNroDoc ;
   private short[] BC000Q2_A751FamMesDesde ;
   private short[] BC000Q2_A752FamMesHasta ;
   private boolean[] BC000Q2_A890FamAdherente ;
   private int[] BC000Q2_A3CliCod ;
   private short[] BC000Q2_A1EmpCod ;
   private int[] BC000Q2_A6LegNumero ;
   private String[] BC000Q2_A30ParCod ;
   private short[] BC000Q2_A1547GuarCod ;
   private short[] BC000Q3_A29LegOrden ;
   private String[] BC000Q3_A198FamApellido ;
   private String[] BC000Q3_A212FamNombres ;
   private String[] BC000Q3_A2090FamNomApe ;
   private java.util.Date[] BC000Q3_A209FamFecNac ;
   private boolean[] BC000Q3_A205FamDiscap ;
   private boolean[] BC000Q3_A199FamAsigFam ;
   private java.math.BigDecimal[] BC000Q3_A220FamTomaDeducImpGan ;
   private String[] BC000Q3_A750FamNroDoc ;
   private short[] BC000Q3_A751FamMesDesde ;
   private short[] BC000Q3_A752FamMesHasta ;
   private boolean[] BC000Q3_A890FamAdherente ;
   private int[] BC000Q3_A3CliCod ;
   private short[] BC000Q3_A1EmpCod ;
   private int[] BC000Q3_A6LegNumero ;
   private String[] BC000Q3_A30ParCod ;
   private short[] BC000Q3_A1547GuarCod ;
   private int[] BC000Q4_A3CliCod ;
   private String[] BC000Q5_A313ParDescrip ;
   private int[] BC000Q6_A3CliCod ;
   private boolean[] BC000Q2_n209FamFecNac ;
   private boolean[] BC000Q2_n205FamDiscap ;
   private boolean[] BC000Q2_n1547GuarCod ;
   private boolean[] BC000Q3_n209FamFecNac ;
   private boolean[] BC000Q3_n205FamDiscap ;
   private boolean[] BC000Q3_n1547GuarCod ;
}

final  class legajofamilia_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000Q2", "SELECT LegOrden, FamApellido, FamNombres, FamNomApe, FamFecNac, FamDiscap, FamAsigFam, FamTomaDeducImpGan, FamNroDoc, FamMesDesde, FamMesHasta, FamAdherente, CliCod, EmpCod, LegNumero, ParCod, GuarCod FROM LegajoFamilia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ?  FOR UPDATE OF LegajoFamilia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q3", "SELECT LegOrden, FamApellido, FamNombres, FamNomApe, FamFecNac, FamDiscap, FamAsigFam, FamTomaDeducImpGan, FamNroDoc, FamMesDesde, FamMesHasta, FamAdherente, CliCod, EmpCod, LegNumero, ParCod, GuarCod FROM LegajoFamilia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q4", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q5", "SELECT ParDescrip FROM Parentesco WHERE CliCod = ? AND ParCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q6", "SELECT CliCod FROM EmpresaGuarderias WHERE CliCod = ? AND EmpCod = ? AND GuarCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q7", "SELECT TM1.LegOrden, TM1.FamApellido, TM1.FamNombres, TM1.FamNomApe, T2.ParDescrip, TM1.FamFecNac, TM1.FamDiscap, TM1.FamAsigFam, TM1.FamTomaDeducImpGan, TM1.FamNroDoc, TM1.FamMesDesde, TM1.FamMesHasta, TM1.FamAdherente, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.ParCod, TM1.GuarCod FROM (LegajoFamilia TM1 INNER JOIN Parentesco T2 ON T2.CliCod = TM1.CliCod AND T2.ParCod = TM1.ParCod) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LegOrden = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegOrden ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q8", "SELECT ParDescrip FROM Parentesco WHERE CliCod = ? AND ParCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q9", "SELECT CliCod FROM EmpresaGuarderias WHERE CliCod = ? AND EmpCod = ? AND GuarCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q10", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q11", "SELECT CliCod, EmpCod, LegNumero, LegOrden FROM LegajoFamilia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q12", "SELECT LegOrden, FamApellido, FamNombres, FamNomApe, FamFecNac, FamDiscap, FamAsigFam, FamTomaDeducImpGan, FamNroDoc, FamMesDesde, FamMesHasta, FamAdherente, CliCod, EmpCod, LegNumero, ParCod, GuarCod FROM LegajoFamilia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q13", "SELECT LegOrden, FamApellido, FamNombres, FamNomApe, FamFecNac, FamDiscap, FamAsigFam, FamTomaDeducImpGan, FamNroDoc, FamMesDesde, FamMesHasta, FamAdherente, CliCod, EmpCod, LegNumero, ParCod, GuarCod FROM LegajoFamilia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ?  FOR UPDATE OF LegajoFamilia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000Q14", "SAVEPOINT gxupdate;INSERT INTO LegajoFamilia(LegOrden, FamApellido, FamNombres, FamNomApe, FamFecNac, FamDiscap, FamAsigFam, FamTomaDeducImpGan, FamNroDoc, FamMesDesde, FamMesHasta, FamAdherente, CliCod, EmpCod, LegNumero, ParCod, GuarCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000Q15", "SAVEPOINT gxupdate;UPDATE LegajoFamilia SET FamApellido=?, FamNombres=?, FamNomApe=?, FamFecNac=?, FamDiscap=?, FamAsigFam=?, FamTomaDeducImpGan=?, FamNroDoc=?, FamMesDesde=?, FamMesHasta=?, FamAdherente=?, ParCod=?, GuarCod=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000Q16", "SAVEPOINT gxupdate;DELETE FROM LegajoFamilia  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000Q17", "SELECT ParDescrip FROM Parentesco WHERE CliCod = ? AND ParCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q18", "SELECT TM1.LegOrden, TM1.FamApellido, TM1.FamNombres, TM1.FamNomApe, T2.ParDescrip, TM1.FamFecNac, TM1.FamDiscap, TM1.FamAsigFam, TM1.FamTomaDeducImpGan, TM1.FamNroDoc, TM1.FamMesDesde, TM1.FamMesHasta, TM1.FamAdherente, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.ParCod, TM1.GuarCod FROM (LegajoFamilia TM1 INNER JOIN Parentesco T2 ON T2.CliCod = TM1.CliCod AND T2.ParCod = TM1.ParCod) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LegOrden = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegOrden ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q19", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Q20", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,4);
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(12);
               ((int[]) buf[14])[0] = rslt.getInt(13);
               ((short[]) buf[15])[0] = rslt.getShort(14);
               ((int[]) buf[16])[0] = rslt.getInt(15);
               ((String[]) buf[17])[0] = rslt.getString(16, 20);
               ((short[]) buf[18])[0] = rslt.getShort(17);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,4);
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(12);
               ((int[]) buf[14])[0] = rslt.getInt(13);
               ((short[]) buf[15])[0] = rslt.getShort(14);
               ((int[]) buf[16])[0] = rslt.getInt(15);
               ((String[]) buf[17])[0] = rslt.getString(16, 20);
               ((short[]) buf[18])[0] = rslt.getShort(17);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((boolean[]) buf[9])[0] = rslt.getBoolean(8);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(9,4);
               ((String[]) buf[11])[0] = rslt.getString(10, 20);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(13);
               ((int[]) buf[15])[0] = rslt.getInt(14);
               ((short[]) buf[16])[0] = rslt.getShort(15);
               ((int[]) buf[17])[0] = rslt.getInt(16);
               ((String[]) buf[18])[0] = rslt.getString(17, 20);
               ((short[]) buf[19])[0] = rslt.getShort(18);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
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
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,4);
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(12);
               ((int[]) buf[14])[0] = rslt.getInt(13);
               ((short[]) buf[15])[0] = rslt.getShort(14);
               ((int[]) buf[16])[0] = rslt.getInt(15);
               ((String[]) buf[17])[0] = rslt.getString(16, 20);
               ((short[]) buf[18])[0] = rslt.getShort(17);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,4);
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(12);
               ((int[]) buf[14])[0] = rslt.getInt(13);
               ((short[]) buf[15])[0] = rslt.getShort(14);
               ((int[]) buf[16])[0] = rslt.getInt(15);
               ((String[]) buf[17])[0] = rslt.getString(16, 20);
               ((short[]) buf[18])[0] = rslt.getShort(17);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((boolean[]) buf[9])[0] = rslt.getBoolean(8);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(9,4);
               ((String[]) buf[11])[0] = rslt.getString(10, 20);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(13);
               ((int[]) buf[15])[0] = rslt.getInt(14);
               ((short[]) buf[16])[0] = rslt.getShort(15);
               ((int[]) buf[17])[0] = rslt.getInt(16);
               ((String[]) buf[18])[0] = rslt.getString(17, 20);
               ((short[]) buf[19])[0] = rslt.getShort(18);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setVarchar(3, (String)parms[2], 30, false);
               stmt.setVarchar(4, (String)parms[3], 40, false);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.DATE );
               }
               else
               {
                  stmt.setDate(5, (java.util.Date)parms[5]);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(6, ((Boolean) parms[7]).booleanValue());
               }
               stmt.setBoolean(7, ((Boolean) parms[8]).booleanValue());
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[9], 4);
               stmt.setString(9, (String)parms[10], 20);
               stmt.setShort(10, ((Number) parms[11]).shortValue());
               stmt.setShort(11, ((Number) parms[12]).shortValue());
               stmt.setBoolean(12, ((Boolean) parms[13]).booleanValue());
               stmt.setInt(13, ((Number) parms[14]).intValue());
               stmt.setShort(14, ((Number) parms[15]).shortValue());
               stmt.setInt(15, ((Number) parms[16]).intValue());
               stmt.setString(16, (String)parms[17], 20);
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(17, ((Number) parms[19]).shortValue());
               }
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setVarchar(3, (String)parms[2], 40, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.DATE );
               }
               else
               {
                  stmt.setDate(4, (java.util.Date)parms[4]);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(5, ((Boolean) parms[6]).booleanValue());
               }
               stmt.setBoolean(6, ((Boolean) parms[7]).booleanValue());
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[8], 4);
               stmt.setString(8, (String)parms[9], 20);
               stmt.setShort(9, ((Number) parms[10]).shortValue());
               stmt.setShort(10, ((Number) parms[11]).shortValue());
               stmt.setBoolean(11, ((Boolean) parms[12]).booleanValue());
               stmt.setString(12, (String)parms[13], 20);
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(13, ((Number) parms[15]).shortValue());
               }
               stmt.setInt(14, ((Number) parms[16]).intValue());
               stmt.setShort(15, ((Number) parms[17]).shortValue());
               stmt.setInt(16, ((Number) parms[18]).intValue());
               stmt.setShort(17, ((Number) parms[19]).shortValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

