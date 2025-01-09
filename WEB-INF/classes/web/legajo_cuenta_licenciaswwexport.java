package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajo_cuenta_licenciaswwexport extends GXProcedure
{
   public legajo_cuenta_licenciaswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_cuenta_licenciaswwexport.class ), "" );
   }

   public legajo_cuenta_licenciaswwexport( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      legajo_cuenta_licenciaswwexport.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      legajo_cuenta_licenciaswwexport.this.aP0 = aP0;
      legajo_cuenta_licenciaswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_cuenta_licencias", GXv_boolean2) ;
      legajo_cuenta_licenciaswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV69Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'OPENDOCUMENT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV14CellRow = 1 ;
         AV15FirstColumn = 1 ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S201 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEFILTERS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITECOLUMNTITLES' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEDATA' */
         S161 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'CLOSEDOCUMENT' */
         S191 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV16Random = (int)(GXutil.random( )*10000) ;
      AV12Filename = "legajo_cuenta_licenciasWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
      AV11ExcelDocument.Open(AV12Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( (0==AV35TFLegCuenAnio) && (0==AV36TFLegCuenAnio_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Año", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFLegCuenAnio );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFLegCuenAnio_To );
      }
      if ( ! ( ( AV39TFLegIdNomApe_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV64i = 1 ;
         AV70GXV1 = 1 ;
         while ( AV70GXV1 <= AV39TFLegIdNomApe_Sels.size() )
         {
            AV40TFLegIdNomApe_Sel = (String)AV39TFLegIdNomApe_Sels.elementAt(-1+AV70GXV1) ;
            if ( AV64i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFLegIdNomApe_Sel, GXv_char7) ;
            legajo_cuenta_licenciaswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV64i = (long)(AV64i+1) ;
            AV70GXV1 = (int)(AV70GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV38TFLegIdNomApe)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFLegIdNomApe, GXv_char7) ;
            legajo_cuenta_licenciaswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV42TFLegCuenLicTpo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV64i = 1 ;
         AV71GXV2 = 1 ;
         while ( AV71GXV2 <= AV42TFLegCuenLicTpo_Sels.size() )
         {
            AV43TFLegCuenLicTpo_Sel = (String)AV42TFLegCuenLicTpo_Sels.elementAt(-1+AV71GXV2) ;
            if ( AV64i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_licencia.getDescription(httpContext,(String)AV43TFLegCuenLicTpo_Sel), "") );
            AV64i = (long)(AV64i+1) ;
            AV71GXV2 = (int)(AV71GXV2+1) ;
         }
      }
      if ( ! ( ( AV46TFLegCueAntAbr_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Antiguedad para vacaciones", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV64i = 1 ;
         AV72GXV3 = 1 ;
         while ( AV72GXV3 <= AV46TFLegCueAntAbr_Sels.size() )
         {
            AV47TFLegCueAntAbr_Sel = (String)AV46TFLegCueAntAbr_Sels.elementAt(-1+AV72GXV3) ;
            if ( AV64i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFLegCueAntAbr_Sel, GXv_char7) ;
            legajo_cuenta_licenciaswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV64i = (long)(AV64i+1) ;
            AV72GXV3 = (int)(AV72GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFLegCueAntAbr)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Antiguedad para vacaciones", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFLegCueAntAbr, GXv_char7) ;
            legajo_cuenta_licenciaswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV48TFLegCuenDiasCorres) && (0==AV49TFLegCuenDiasCorres_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Corresponden", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV48TFLegCuenDiasCorres );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV49TFLegCuenDiasCorres_To );
      }
      if ( ! ( (0==AV50TFLegCuLiPAnt) && (0==AV51TFLegCuLiPAnt_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Pendientes anteriores", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV50TFLegCuLiPAnt );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV51TFLegCuLiPAnt_To );
      }
      if ( ! ( (0==AV52TFLegCuLActVen) && (0==AV53TFLegCuLActVen_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Pendientes actuales a vencer", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV52TFLegCuLActVen );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV53TFLegCuLActVen_To );
      }
      if ( ! ( (0==AV54TFLegCuLiPVen) && (0==AV55TFLegCuLiPVen_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Pendientes vencidas", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV54TFLegCuLiPVen );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV55TFLegCuLiPVen_To );
      }
      if ( ! ( (0==AV56TFLegCuLiPCur) && (0==AV57TFLegCuLiPCur_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Asignación pendiente", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV56TFLegCuLiPCur );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV57TFLegCuLiPCur_To );
      }
      if ( ! ( (0==AV58TFLegCuLiPApr) && (0==AV59TFLegCuLiPApr_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Aprobación pendiente", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV58TFLegCuLiPApr );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV59TFLegCuLiPApr_To );
      }
      if ( ! ( (0==AV60TFLegCuenDiasGoz) && (0==AV61TFLegCuenDiasGoz_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Aprobadas", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV60TFLegCuenDiasGoz );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV61TFLegCuenDiasGoz_To );
      }
      if ( ! ( (0==AV62TFLegCuLiPSaldo) && (0==AV63TFLegCuLiPSaldo_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Total disponible", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV62TFLegCuLiPSaldo );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_cuenta_licenciaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV63TFLegCuLiPSaldo_To );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("legajo_cuenta_licenciasWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("legajo_cuenta_licenciasWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV73GXV4 = 1 ;
      while ( AV73GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV73GXV4));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV73GXV4 = (int)(AV73GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV75Legajo_cuenta_licenciaswwds_1_tflegcuenanio = AV35TFLegCuenAnio ;
      AV76Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to = AV36TFLegCuenAnio_To ;
      AV77Legajo_cuenta_licenciaswwds_3_tflegidnomape = AV38TFLegIdNomApe ;
      AV78Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels = AV39TFLegIdNomApe_Sels ;
      AV79Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels = AV42TFLegCuenLicTpo_Sels ;
      AV80Legajo_cuenta_licenciaswwds_6_tflegcueantabr = AV45TFLegCueAntAbr ;
      AV81Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels = AV46TFLegCueAntAbr_Sels ;
      AV82Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres = AV48TFLegCuenDiasCorres ;
      AV83Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to = AV49TFLegCuenDiasCorres_To ;
      AV84Legajo_cuenta_licenciaswwds_10_tflegculipant = AV50TFLegCuLiPAnt ;
      AV85Legajo_cuenta_licenciaswwds_11_tflegculipant_to = AV51TFLegCuLiPAnt_To ;
      AV86Legajo_cuenta_licenciaswwds_12_tflegculactven = AV52TFLegCuLActVen ;
      AV87Legajo_cuenta_licenciaswwds_13_tflegculactven_to = AV53TFLegCuLActVen_To ;
      AV88Legajo_cuenta_licenciaswwds_14_tflegculipven = AV54TFLegCuLiPVen ;
      AV89Legajo_cuenta_licenciaswwds_15_tflegculipven_to = AV55TFLegCuLiPVen_To ;
      AV90Legajo_cuenta_licenciaswwds_16_tflegculipcur = AV56TFLegCuLiPCur ;
      AV91Legajo_cuenta_licenciaswwds_17_tflegculipcur_to = AV57TFLegCuLiPCur_To ;
      AV92Legajo_cuenta_licenciaswwds_18_tflegculipapr = AV58TFLegCuLiPApr ;
      AV93Legajo_cuenta_licenciaswwds_19_tflegculipapr_to = AV59TFLegCuLiPApr_To ;
      AV94Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz = AV60TFLegCuenDiasGoz ;
      AV95Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to = AV61TFLegCuenDiasGoz_To ;
      AV96Legajo_cuenta_licenciaswwds_22_tflegculipsaldo = AV62TFLegCuLiPSaldo ;
      AV97Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to = AV63TFLegCuLiPSaldo_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV78Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels ,
                                           A2243LegCuenLicTpo ,
                                           AV79Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels ,
                                           A2328LegCueAntAbr ,
                                           AV81Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels ,
                                           Short.valueOf(AV75Legajo_cuenta_licenciaswwds_1_tflegcuenanio) ,
                                           Short.valueOf(AV76Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to) ,
                                           Integer.valueOf(AV78Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels.size()) ,
                                           AV77Legajo_cuenta_licenciaswwds_3_tflegidnomape ,
                                           Integer.valueOf(AV79Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels.size()) ,
                                           Integer.valueOf(AV81Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels.size()) ,
                                           AV80Legajo_cuenta_licenciaswwds_6_tflegcueantabr ,
                                           Short.valueOf(AV82Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres) ,
                                           Short.valueOf(AV83Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to) ,
                                           Short.valueOf(AV84Legajo_cuenta_licenciaswwds_10_tflegculipant) ,
                                           Short.valueOf(AV85Legajo_cuenta_licenciaswwds_11_tflegculipant_to) ,
                                           Short.valueOf(AV86Legajo_cuenta_licenciaswwds_12_tflegculactven) ,
                                           Short.valueOf(AV87Legajo_cuenta_licenciaswwds_13_tflegculactven_to) ,
                                           Short.valueOf(AV88Legajo_cuenta_licenciaswwds_14_tflegculipven) ,
                                           Short.valueOf(AV89Legajo_cuenta_licenciaswwds_15_tflegculipven_to) ,
                                           Short.valueOf(AV90Legajo_cuenta_licenciaswwds_16_tflegculipcur) ,
                                           Short.valueOf(AV91Legajo_cuenta_licenciaswwds_17_tflegculipcur_to) ,
                                           Short.valueOf(AV92Legajo_cuenta_licenciaswwds_18_tflegculipapr) ,
                                           Short.valueOf(AV93Legajo_cuenta_licenciaswwds_19_tflegculipapr_to) ,
                                           Short.valueOf(AV94Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz) ,
                                           Short.valueOf(AV95Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to) ,
                                           Short.valueOf(AV96Legajo_cuenta_licenciaswwds_22_tflegculipsaldo) ,
                                           Short.valueOf(AV97Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to) ,
                                           Short.valueOf(A2266LegCuenAnio) ,
                                           Short.valueOf(A2247LegCuenDiasCorres) ,
                                           Short.valueOf(A2303LegCuLiPAnt) ,
                                           Short.valueOf(A2315LegCuLActVen) ,
                                           Short.valueOf(A2304LegCuLiPVen) ,
                                           Short.valueOf(A2302LegCuLiPCur) ,
                                           Short.valueOf(A2306LegCuLiPApr) ,
                                           Short.valueOf(A2248LegCuenDiasGoz) ,
                                           Short.valueOf(A2305LegCuLiPSaldo) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV65CliCod) ,
                                           Short.valueOf(AV66EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV77Legajo_cuenta_licenciaswwds_3_tflegidnomape = GXutil.concat( GXutil.rtrim( AV77Legajo_cuenta_licenciaswwds_3_tflegidnomape), "%", "") ;
      lV80Legajo_cuenta_licenciaswwds_6_tflegcueantabr = GXutil.concat( GXutil.rtrim( AV80Legajo_cuenta_licenciaswwds_6_tflegcueantabr), "%", "") ;
      /* Using cursor P02G22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV65CliCod), Short.valueOf(AV66EmpCod), Short.valueOf(AV75Legajo_cuenta_licenciaswwds_1_tflegcuenanio), Short.valueOf(AV76Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to), lV77Legajo_cuenta_licenciaswwds_3_tflegidnomape, lV80Legajo_cuenta_licenciaswwds_6_tflegcueantabr, Short.valueOf(AV82Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres), Short.valueOf(AV83Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to), Short.valueOf(AV84Legajo_cuenta_licenciaswwds_10_tflegculipant), Short.valueOf(AV85Legajo_cuenta_licenciaswwds_11_tflegculipant_to), Short.valueOf(AV86Legajo_cuenta_licenciaswwds_12_tflegculactven), Short.valueOf(AV87Legajo_cuenta_licenciaswwds_13_tflegculactven_to), Short.valueOf(AV88Legajo_cuenta_licenciaswwds_14_tflegculipven), Short.valueOf(AV89Legajo_cuenta_licenciaswwds_15_tflegculipven_to), Short.valueOf(AV90Legajo_cuenta_licenciaswwds_16_tflegculipcur), Short.valueOf(AV91Legajo_cuenta_licenciaswwds_17_tflegculipcur_to), Short.valueOf(AV92Legajo_cuenta_licenciaswwds_18_tflegculipapr), Short.valueOf(AV93Legajo_cuenta_licenciaswwds_19_tflegculipapr_to), Short.valueOf(AV94Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz), Short.valueOf(AV95Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to), Short.valueOf(AV96Legajo_cuenta_licenciaswwds_22_tflegculipsaldo), Short.valueOf(AV97Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P02G22_A1EmpCod[0] ;
         A3CliCod = P02G22_A3CliCod[0] ;
         A2305LegCuLiPSaldo = P02G22_A2305LegCuLiPSaldo[0] ;
         A2248LegCuenDiasGoz = P02G22_A2248LegCuenDiasGoz[0] ;
         A2306LegCuLiPApr = P02G22_A2306LegCuLiPApr[0] ;
         A2302LegCuLiPCur = P02G22_A2302LegCuLiPCur[0] ;
         A2304LegCuLiPVen = P02G22_A2304LegCuLiPVen[0] ;
         A2315LegCuLActVen = P02G22_A2315LegCuLActVen[0] ;
         A2303LegCuLiPAnt = P02G22_A2303LegCuLiPAnt[0] ;
         A2247LegCuenDiasCorres = P02G22_A2247LegCuenDiasCorres[0] ;
         A2328LegCueAntAbr = P02G22_A2328LegCueAntAbr[0] ;
         A2243LegCuenLicTpo = P02G22_A2243LegCuenLicTpo[0] ;
         A250LegIdNomApe = P02G22_A250LegIdNomApe[0] ;
         A2266LegCuenAnio = P02G22_A2266LegCuenAnio[0] ;
         A6LegNumero = P02G22_A6LegNumero[0] ;
         A250LegIdNomApe = P02G22_A250LegIdNomApe[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         AV98GXV5 = 1 ;
         while ( AV98GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV98GXV5));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCuenAnio") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A2266LegCuenAnio );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegIdNomApe") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A250LegIdNomApe, GXv_char7) ;
                  legajo_cuenta_licenciaswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCuenLicTpo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_licencia.getDescription(httpContext,(String)A2243LegCuenLicTpo), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCueAntAbr") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2328LegCueAntAbr, GXv_char7) ;
                  legajo_cuenta_licenciaswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCuenDiasCorres") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A2247LegCuenDiasCorres );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCuLiPAnt") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A2303LegCuLiPAnt );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCuLActVen") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A2315LegCuLActVen );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCuLiPVen") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A2304LegCuLiPVen );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCuLiPCur") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A2302LegCuLiPCur );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCuLiPApr") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A2306LegCuLiPApr );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCuenDiasGoz") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A2248LegCuenDiasGoz );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCuLiPSaldo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A2305LegCuLiPSaldo );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV98GXV5 = (int)(AV98GXV5+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S191( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV11ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV11ExcelDocument.getErrCode() != 0 )
      {
         AV12Filename = "" ;
         AV13ErrorMessage = AV11ExcelDocument.getErrDescription() ;
         AV11ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S151( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV24ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegCuenAnio", "", "Año", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegIdNomApe", "", "Legajo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegCuenLicTpo", "", "Tipo", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegCueAntAbr", "", "Antiguedad para vacaciones", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegCuenDiasCorres", "", "Corresponden", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegCuLiPAnt", "", "Pendientes anteriores", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegCuLActVen", "", "Pendientes actuales a vencer", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegCuLiPVen", "", "Pendientes vencidas", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegCuLiPCur", "", "Asignación pendiente", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegCuLiPApr", "", "Aprobación pendiente", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegCuenDiasGoz", "", "Aprobadas", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegCuLiPSaldo", "", "Total disponible", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&Consumido", "", "Consumido", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "legajo_cuenta_licenciasWWColumnsSelector", GXv_char7) ;
      legajo_cuenta_licenciaswwexport.this.GXt_char6 = GXv_char7[0] ;
      AV28UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("legajo_cuenta_licenciasWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "legajo_cuenta_licenciasWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("legajo_cuenta_licenciasWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV99GXV6 = 1 ;
      while ( AV99GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV99GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENANIO") == 0 )
         {
            AV35TFLegCuenAnio = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFLegCuenAnio_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE") == 0 )
         {
            AV38TFLegIdNomApe = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE_SEL") == 0 )
         {
            AV37TFLegIdNomApe_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFLegIdNomApe_Sels.fromJSonString(AV37TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENLICTPO_SEL") == 0 )
         {
            AV41TFLegCuenLicTpo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFLegCuenLicTpo_Sels.fromJSonString(AV41TFLegCuenLicTpo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUEANTABR") == 0 )
         {
            AV45TFLegCueAntAbr = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUEANTABR_SEL") == 0 )
         {
            AV44TFLegCueAntAbr_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV46TFLegCueAntAbr_Sels.fromJSonString(AV44TFLegCueAntAbr_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENDIASCORRES") == 0 )
         {
            AV48TFLegCuenDiasCorres = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV49TFLegCuenDiasCorres_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPANT") == 0 )
         {
            AV50TFLegCuLiPAnt = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV51TFLegCuLiPAnt_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULACTVEN") == 0 )
         {
            AV52TFLegCuLActVen = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV53TFLegCuLActVen_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPVEN") == 0 )
         {
            AV54TFLegCuLiPVen = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV55TFLegCuLiPVen_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPCUR") == 0 )
         {
            AV56TFLegCuLiPCur = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV57TFLegCuLiPCur_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPAPR") == 0 )
         {
            AV58TFLegCuLiPApr = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV59TFLegCuLiPApr_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENDIASGOZ") == 0 )
         {
            AV60TFLegCuenDiasGoz = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV61TFLegCuenDiasGoz_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPSALDO") == 0 )
         {
            AV62TFLegCuLiPSaldo = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV63TFLegCuLiPSaldo_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV99GXV6 = (int)(AV99GXV6+1) ;
      }
   }

   public void S172( )
   {
      /* 'BEFOREWRITELINE' Routine */
      returnInSub = false ;
   }

   public void S182( )
   {
      /* 'AFTERWRITELINE' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP0[0] = legajo_cuenta_licenciaswwexport.this.AV12Filename;
      this.aP1[0] = legajo_cuenta_licenciaswwexport.this.AV13ErrorMessage;
      CloseOpenCursors();
      AV11ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Filename = "" ;
      AV13ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV69Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV39TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFLegIdNomApe_Sel = "" ;
      AV38TFLegIdNomApe = "" ;
      AV42TFLegCuenLicTpo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFLegCuenLicTpo_Sel = "" ;
      AV46TFLegCueAntAbr_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47TFLegCueAntAbr_Sel = "" ;
      AV45TFLegCueAntAbr = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A250LegIdNomApe = "" ;
      A2243LegCuenLicTpo = "" ;
      A2328LegCueAntAbr = "" ;
      AV77Legajo_cuenta_licenciaswwds_3_tflegidnomape = "" ;
      AV78Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV79Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV80Legajo_cuenta_licenciaswwds_6_tflegcueantabr = "" ;
      AV81Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV77Legajo_cuenta_licenciaswwds_3_tflegidnomape = "" ;
      lV80Legajo_cuenta_licenciaswwds_6_tflegcueantabr = "" ;
      P02G22_A1EmpCod = new short[1] ;
      P02G22_A3CliCod = new int[1] ;
      P02G22_A2305LegCuLiPSaldo = new short[1] ;
      P02G22_A2248LegCuenDiasGoz = new short[1] ;
      P02G22_A2306LegCuLiPApr = new short[1] ;
      P02G22_A2302LegCuLiPCur = new short[1] ;
      P02G22_A2304LegCuLiPVen = new short[1] ;
      P02G22_A2315LegCuLActVen = new short[1] ;
      P02G22_A2303LegCuLiPAnt = new short[1] ;
      P02G22_A2247LegCuenDiasCorres = new short[1] ;
      P02G22_A2328LegCueAntAbr = new String[] {""} ;
      P02G22_A2243LegCuenLicTpo = new String[] {""} ;
      P02G22_A250LegIdNomApe = new String[] {""} ;
      P02G22_A2266LegCuenAnio = new short[1] ;
      P02G22_A6LegNumero = new int[1] ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFLegIdNomApe_SelsJson = "" ;
      AV41TFLegCuenLicTpo_SelsJson = "" ;
      AV44TFLegCueAntAbr_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_cuenta_licenciaswwexport__default(),
         new Object[] {
             new Object[] {
            P02G22_A1EmpCod, P02G22_A3CliCod, P02G22_A2305LegCuLiPSaldo, P02G22_A2248LegCuenDiasGoz, P02G22_A2306LegCuLiPApr, P02G22_A2302LegCuLiPCur, P02G22_A2304LegCuLiPVen, P02G22_A2315LegCuLActVen, P02G22_A2303LegCuLiPAnt, P02G22_A2247LegCuenDiasCorres,
            P02G22_A2328LegCueAntAbr, P02G22_A2243LegCuenLicTpo, P02G22_A250LegIdNomApe, P02G22_A2266LegCuenAnio, P02G22_A6LegNumero
            }
         }
      );
      AV69Pgmname = "legajo_cuenta_licenciasWWExport" ;
      /* GeneXus formulas. */
      AV69Pgmname = "legajo_cuenta_licenciasWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV35TFLegCuenAnio ;
   private short AV36TFLegCuenAnio_To ;
   private short AV48TFLegCuenDiasCorres ;
   private short AV49TFLegCuenDiasCorres_To ;
   private short AV50TFLegCuLiPAnt ;
   private short AV51TFLegCuLiPAnt_To ;
   private short AV52TFLegCuLActVen ;
   private short AV53TFLegCuLActVen_To ;
   private short AV54TFLegCuLiPVen ;
   private short AV55TFLegCuLiPVen_To ;
   private short AV56TFLegCuLiPCur ;
   private short AV57TFLegCuLiPCur_To ;
   private short AV58TFLegCuLiPApr ;
   private short AV59TFLegCuLiPApr_To ;
   private short AV60TFLegCuenDiasGoz ;
   private short AV61TFLegCuenDiasGoz_To ;
   private short AV62TFLegCuLiPSaldo ;
   private short AV63TFLegCuLiPSaldo_To ;
   private short GXv_int5[] ;
   private short A2266LegCuenAnio ;
   private short A2247LegCuenDiasCorres ;
   private short A2303LegCuLiPAnt ;
   private short A2315LegCuLActVen ;
   private short A2304LegCuLiPVen ;
   private short A2302LegCuLiPCur ;
   private short A2306LegCuLiPApr ;
   private short A2248LegCuenDiasGoz ;
   private short A2305LegCuLiPSaldo ;
   private short AV75Legajo_cuenta_licenciaswwds_1_tflegcuenanio ;
   private short AV76Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to ;
   private short AV82Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres ;
   private short AV83Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to ;
   private short AV84Legajo_cuenta_licenciaswwds_10_tflegculipant ;
   private short AV85Legajo_cuenta_licenciaswwds_11_tflegculipant_to ;
   private short AV86Legajo_cuenta_licenciaswwds_12_tflegculactven ;
   private short AV87Legajo_cuenta_licenciaswwds_13_tflegculactven_to ;
   private short AV88Legajo_cuenta_licenciaswwds_14_tflegculipven ;
   private short AV89Legajo_cuenta_licenciaswwds_15_tflegculipven_to ;
   private short AV90Legajo_cuenta_licenciaswwds_16_tflegculipcur ;
   private short AV91Legajo_cuenta_licenciaswwds_17_tflegculipcur_to ;
   private short AV92Legajo_cuenta_licenciaswwds_18_tflegculipapr ;
   private short AV93Legajo_cuenta_licenciaswwds_19_tflegculipapr_to ;
   private short AV94Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz ;
   private short AV95Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to ;
   private short AV96Legajo_cuenta_licenciaswwds_22_tflegculipsaldo ;
   private short AV97Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to ;
   private short AV18OrderedBy ;
   private short AV66EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV70GXV1 ;
   private int AV71GXV2 ;
   private int AV72GXV3 ;
   private int AV73GXV4 ;
   private int AV78Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size ;
   private int AV79Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels_size ;
   private int AV81Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size ;
   private int AV65CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV98GXV5 ;
   private int AV99GXV6 ;
   private long AV64i ;
   private long AV32VisibleColumnCount ;
   private String AV69Pgmname ;
   private String AV43TFLegCuenLicTpo_Sel ;
   private String A2243LegCuenLicTpo ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV37TFLegIdNomApe_SelsJson ;
   private String AV41TFLegCuenLicTpo_SelsJson ;
   private String AV44TFLegCueAntAbr_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV40TFLegIdNomApe_Sel ;
   private String AV38TFLegIdNomApe ;
   private String AV47TFLegCueAntAbr_Sel ;
   private String AV45TFLegCueAntAbr ;
   private String A250LegIdNomApe ;
   private String A2328LegCueAntAbr ;
   private String AV77Legajo_cuenta_licenciaswwds_3_tflegidnomape ;
   private String AV80Legajo_cuenta_licenciaswwds_6_tflegcueantabr ;
   private String lV77Legajo_cuenta_licenciaswwds_3_tflegidnomape ;
   private String lV80Legajo_cuenta_licenciaswwds_6_tflegcueantabr ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV42TFLegCuenLicTpo_Sels ;
   private GXSimpleCollection<String> AV39TFLegIdNomApe_Sels ;
   private GXSimpleCollection<String> AV46TFLegCueAntAbr_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P02G22_A1EmpCod ;
   private int[] P02G22_A3CliCod ;
   private short[] P02G22_A2305LegCuLiPSaldo ;
   private short[] P02G22_A2248LegCuenDiasGoz ;
   private short[] P02G22_A2306LegCuLiPApr ;
   private short[] P02G22_A2302LegCuLiPCur ;
   private short[] P02G22_A2304LegCuLiPVen ;
   private short[] P02G22_A2315LegCuLActVen ;
   private short[] P02G22_A2303LegCuLiPAnt ;
   private short[] P02G22_A2247LegCuenDiasCorres ;
   private String[] P02G22_A2328LegCueAntAbr ;
   private String[] P02G22_A2243LegCuenLicTpo ;
   private String[] P02G22_A250LegIdNomApe ;
   private short[] P02G22_A2266LegCuenAnio ;
   private int[] P02G22_A6LegNumero ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV79Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels ;
   private GXSimpleCollection<String> AV78Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels ;
   private GXSimpleCollection<String> AV81Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class legajo_cuenta_licenciaswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02G22( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV78Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels ,
                                          String A2243LegCuenLicTpo ,
                                          GXSimpleCollection<String> AV79Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels ,
                                          String A2328LegCueAntAbr ,
                                          GXSimpleCollection<String> AV81Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels ,
                                          short AV75Legajo_cuenta_licenciaswwds_1_tflegcuenanio ,
                                          short AV76Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to ,
                                          int AV78Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size ,
                                          String AV77Legajo_cuenta_licenciaswwds_3_tflegidnomape ,
                                          int AV79Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels_size ,
                                          int AV81Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size ,
                                          String AV80Legajo_cuenta_licenciaswwds_6_tflegcueantabr ,
                                          short AV82Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres ,
                                          short AV83Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to ,
                                          short AV84Legajo_cuenta_licenciaswwds_10_tflegculipant ,
                                          short AV85Legajo_cuenta_licenciaswwds_11_tflegculipant_to ,
                                          short AV86Legajo_cuenta_licenciaswwds_12_tflegculactven ,
                                          short AV87Legajo_cuenta_licenciaswwds_13_tflegculactven_to ,
                                          short AV88Legajo_cuenta_licenciaswwds_14_tflegculipven ,
                                          short AV89Legajo_cuenta_licenciaswwds_15_tflegculipven_to ,
                                          short AV90Legajo_cuenta_licenciaswwds_16_tflegculipcur ,
                                          short AV91Legajo_cuenta_licenciaswwds_17_tflegculipcur_to ,
                                          short AV92Legajo_cuenta_licenciaswwds_18_tflegculipapr ,
                                          short AV93Legajo_cuenta_licenciaswwds_19_tflegculipapr_to ,
                                          short AV94Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz ,
                                          short AV95Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to ,
                                          short AV96Legajo_cuenta_licenciaswwds_22_tflegculipsaldo ,
                                          short AV97Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to ,
                                          short A2266LegCuenAnio ,
                                          short A2247LegCuenDiasCorres ,
                                          short A2303LegCuLiPAnt ,
                                          short A2315LegCuLActVen ,
                                          short A2304LegCuLiPVen ,
                                          short A2302LegCuLiPCur ,
                                          short A2306LegCuLiPApr ,
                                          short A2248LegCuenDiasGoz ,
                                          short A2305LegCuLiPSaldo ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV65CliCod ,
                                          short AV66EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[22];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.EmpCod, T1.CliCod, T1.LegCuLiPSaldo, T1.LegCuenDiasGoz, T1.LegCuLiPApr, T1.LegCuLiPCur, T1.LegCuLiPVen, T1.LegCuLActVen, T1.LegCuLiPAnt, T1.LegCuenDiasCorres," ;
      scmdbuf += " T1.LegCueAntAbr, T1.LegCuenLicTpo, T2.LegIdNomApe, T1.LegCuenAnio, T1.LegNumero FROM (legajo_cuenta_licencias T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND" ;
      scmdbuf += " T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ! (0==AV75Legajo_cuenta_licenciaswwds_1_tflegcuenanio) )
      {
         addWhere(sWhereString, "(T1.LegCuenAnio >= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (0==AV76Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenAnio <= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ( AV78Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Legajo_cuenta_licenciaswwds_3_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV78Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( AV79Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels, "T1.LegCuenLicTpo IN (", ")")+")");
      }
      if ( ( AV81Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV80Legajo_cuenta_licenciaswwds_6_tflegcueantabr)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegCueAntAbr) like LOWER(?))");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV81Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV81Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels, "T1.LegCueAntAbr IN (", ")")+")");
      }
      if ( ! (0==AV82Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasCorres >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (0==AV83Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasCorres <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( ! (0==AV84Legajo_cuenta_licenciaswwds_10_tflegculipant) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPAnt >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (0==AV85Legajo_cuenta_licenciaswwds_11_tflegculipant_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPAnt <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (0==AV86Legajo_cuenta_licenciaswwds_12_tflegculactven) )
      {
         addWhere(sWhereString, "(T1.LegCuLActVen >= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (0==AV87Legajo_cuenta_licenciaswwds_13_tflegculactven_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLActVen <= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (0==AV88Legajo_cuenta_licenciaswwds_14_tflegculipven) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPVen >= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (0==AV89Legajo_cuenta_licenciaswwds_15_tflegculipven_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPVen <= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (0==AV90Legajo_cuenta_licenciaswwds_16_tflegculipcur) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPCur >= ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (0==AV91Legajo_cuenta_licenciaswwds_17_tflegculipcur_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPCur <= ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (0==AV92Legajo_cuenta_licenciaswwds_18_tflegculipapr) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPApr >= ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (0==AV93Legajo_cuenta_licenciaswwds_19_tflegculipapr_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPApr <= ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (0==AV94Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasGoz >= ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( ! (0==AV95Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasGoz <= ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( ! (0==AV96Legajo_cuenta_licenciaswwds_22_tflegculipsaldo) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPSaldo >= ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( ! (0==AV97Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPSaldo <= ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV18OrderedBy == 1 )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegCuenLicTpo, T1.LegCuenAnio DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LegCueAntAbr" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LegCueAntAbr DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LegCuLActVen" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LegCuLActVen DESC" ;
      }
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P02G22(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).shortValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).shortValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , ((Number) dynConstraints[38]).shortValue() , ((Boolean) dynConstraints[39]).booleanValue() , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).shortValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02G22", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 40);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[30]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[31]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[38]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[39]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[42]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
               }
               return;
      }
   }

}

