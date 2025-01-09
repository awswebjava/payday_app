package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresabase_calculowwexport extends GXProcedure
{
   public empresabase_calculowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresabase_calculowwexport.class ), "" );
   }

   public empresabase_calculowwexport( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      empresabase_calculowwexport.this.aP1 = new String[] {""};
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
      empresabase_calculowwexport.this.aP0 = aP0;
      empresabase_calculowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresabase_calculo", GXv_boolean2) ;
      empresabase_calculowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV109Pgmname))}, new String[] {"GxObject"}) );
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
         S211 ();
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
         /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
         S191 ();
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
         S201 ();
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
      AV12Filename = "Empresabase_calculoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58TFEmpBasePlus)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59TFEmpBasePlus_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Porcentaje para plus", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV58TFEmpBasePlus)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV59TFEmpBasePlus_To)) );
      }
      if ( ! ( (0==AV60TFEmpLicDMin) && (0==AV61TFEmpLicDMin_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad mínima de días permitidos por licencia", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV60TFEmpLicDMin );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV61TFEmpLicDMin_To );
      }
      if ( ! ( (0==AV62TFEmpLicDLim) && (0==AV63TFEmpLicDLim_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por licencia", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV62TFEmpLicDLim );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV63TFEmpLicDLim_To );
      }
      if ( ! ( (0==AV64TFEmpLicDSeman) && (0==AV65TFEmpLicDSeman_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por semana", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV64TFEmpLicDSeman );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV65TFEmpLicDSeman_To );
      }
      if ( ! ( ( AV67TFEmpLicDMes_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por mes", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV87i = 1 ;
         AV110GXV1 = 1 ;
         while ( AV110GXV1 <= AV67TFEmpLicDMes_Sels.size() )
         {
            AV68TFEmpLicDMes_Sel = ((Number) AV67TFEmpLicDMes_Sels.elementAt(-1+AV110GXV1)).byteValue() ;
            if ( AV87i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+localUtil.format( DecimalUtil.doubleToDec(AV68TFEmpLicDMes_Sel), "Z9") );
            AV87i = (long)(AV87i+1) ;
            AV110GXV1 = (int)(AV110GXV1+1) ;
         }
      }
      if ( ! ( (0==AV69TFEmpLicDSemes) && (0==AV70TFEmpLicDSemes_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por semestre", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV69TFEmpLicDSemes );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV70TFEmpLicDSemes_To );
      }
      if ( ! ( (0==AV71TFEmpLicDAnual) && (0==AV72TFEmpLicDAnual_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por año", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV71TFEmpLicDAnual );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV72TFEmpLicDAnual_To );
      }
      if ( ! ( (0==AV73TFEmpLicAdju_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Permite adjuntar documento", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV73TFEmpLicAdju_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV73TFEmpLicAdju_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV74TFEmpLicAdjuObl_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Obliga a adjuntar documento", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV74TFEmpLicAdjuObl_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV74TFEmpLicAdjuObl_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV75TFEmpLicNecAut_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Necesita autorización", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV75TFEmpLicNecAut_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV75TFEmpLicNecAut_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV76TFEmpLicIngMot_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Permite ingresar motivo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV76TFEmpLicIngMot_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV76TFEmpLicIngMot_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV77TFEmpLicMotObl_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Obliga a ingresar motivo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV77TFEmpLicMotObl_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV77TFEmpLicMotObl_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV80TFEmpBasePromCnt1) && (0==AV81TFEmpBasePromCnt1_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días/meses a promediar", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV80TFEmpBasePromCnt1 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV81TFEmpBasePromCnt1_To );
      }
      if ( ! ( (0==AV82TFEmpBasePromCnt2) && (0==AV83TFEmpBasePromCnt2_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días/meses a promediar segunda alternativa", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV82TFEmpBasePromCnt2 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV83TFEmpBasePromCnt2_To );
      }
      if ( ! ( ( AV85TFEmpBasePromTCnt_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Días o Meses", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         empresabase_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV87i = 1 ;
         AV111GXV2 = 1 ;
         while ( AV111GXV2 <= AV85TFEmpBasePromTCnt_Sels.size() )
         {
            AV86TFEmpBasePromTCnt_Sel = (String)AV85TFEmpBasePromTCnt_Sels.elementAt(-1+AV111GXV2) ;
            if ( AV87i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainduracion_tipo.getDescription(httpContext,(String)AV86TFEmpBasePromTCnt_Sel), "") );
            AV87i = (long)(AV87i+1) ;
            AV111GXV2 = (int)(AV111GXV2+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV33VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV21Session.getValue("Empresabase_calculoWWColumnsSelector"), "") != 0 )
      {
         AV28ColumnsSelectorXML = AV21Session.getValue("Empresabase_calculoWWColumnsSelector") ;
         AV25ColumnsSelector.fromxml(AV28ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV93IsAuthorizedEmpLicDMin&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV94IsAuthorizedEmpLicDLim&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV95IsAuthorizedEmpLicDSeman&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV96IsAuthorizedEmpLicDMes&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV97IsAuthorizedEmpLicDSemes&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV98IsAuthorizedEmpLicDAnual&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV106IsAuthorizedEmpLicAdju&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV99IsAuthorizedEmpLicAdjuObl&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV100IsAuthorizedEmpLicNecAut&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV101IsAuthorizedEmpLicIngMot&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV102IsAuthorizedEmpLicMotObl&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV112GXV3 = 1 ;
      while ( AV112GXV3 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV112GXV3));
         if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setColor( 11 );
            AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
         }
         AV112GXV3 = (int)(AV112GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV114Empresabase_calculowwds_1_empbaseclaseleg = AV17EmpBaseClaseLeg ;
      AV115Empresabase_calculowwds_2_empbasetipo = AV18EmpBaseTipo ;
      AV116Empresabase_calculowwds_3_tfempbaseplus = AV58TFEmpBasePlus ;
      AV117Empresabase_calculowwds_4_tfempbaseplus_to = AV59TFEmpBasePlus_To ;
      AV118Empresabase_calculowwds_5_tfemplicdmin = AV60TFEmpLicDMin ;
      AV119Empresabase_calculowwds_6_tfemplicdmin_to = AV61TFEmpLicDMin_To ;
      AV120Empresabase_calculowwds_7_tfemplicdlim = AV62TFEmpLicDLim ;
      AV121Empresabase_calculowwds_8_tfemplicdlim_to = AV63TFEmpLicDLim_To ;
      AV122Empresabase_calculowwds_9_tfemplicdseman = AV64TFEmpLicDSeman ;
      AV123Empresabase_calculowwds_10_tfemplicdseman_to = AV65TFEmpLicDSeman_To ;
      AV124Empresabase_calculowwds_11_tfemplicdmes_sels = AV67TFEmpLicDMes_Sels ;
      AV125Empresabase_calculowwds_12_tfemplicdsemes = AV69TFEmpLicDSemes ;
      AV126Empresabase_calculowwds_13_tfemplicdsemes_to = AV70TFEmpLicDSemes_To ;
      AV127Empresabase_calculowwds_14_tfemplicdanual = AV71TFEmpLicDAnual ;
      AV128Empresabase_calculowwds_15_tfemplicdanual_to = AV72TFEmpLicDAnual_To ;
      AV129Empresabase_calculowwds_16_tfemplicadju_sel = AV73TFEmpLicAdju_Sel ;
      AV130Empresabase_calculowwds_17_tfemplicadjuobl_sel = AV74TFEmpLicAdjuObl_Sel ;
      AV131Empresabase_calculowwds_18_tfemplicnecaut_sel = AV75TFEmpLicNecAut_Sel ;
      AV132Empresabase_calculowwds_19_tfemplicingmot_sel = AV76TFEmpLicIngMot_Sel ;
      AV133Empresabase_calculowwds_20_tfemplicmotobl_sel = AV77TFEmpLicMotObl_Sel ;
      AV134Empresabase_calculowwds_21_tfempbasepromcnt1 = AV80TFEmpBasePromCnt1 ;
      AV135Empresabase_calculowwds_22_tfempbasepromcnt1_to = AV81TFEmpBasePromCnt1_To ;
      AV136Empresabase_calculowwds_23_tfempbasepromcnt2 = AV82TFEmpBasePromCnt2 ;
      AV137Empresabase_calculowwds_24_tfempbasepromcnt2_to = AV83TFEmpBasePromCnt2_To ;
      AV138Empresabase_calculowwds_25_tfempbasepromtcnt_sels = AV85TFEmpBasePromTCnt_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Byte.valueOf(A1504EmpLicDMes) ,
                                           AV124Empresabase_calculowwds_11_tfemplicdmes_sels ,
                                           A1439EmpBasePromTCnt ,
                                           AV138Empresabase_calculowwds_25_tfempbasepromtcnt_sels ,
                                           AV116Empresabase_calculowwds_3_tfempbaseplus ,
                                           AV117Empresabase_calculowwds_4_tfempbaseplus_to ,
                                           Byte.valueOf(AV118Empresabase_calculowwds_5_tfemplicdmin) ,
                                           Byte.valueOf(AV119Empresabase_calculowwds_6_tfemplicdmin_to) ,
                                           Short.valueOf(AV120Empresabase_calculowwds_7_tfemplicdlim) ,
                                           Short.valueOf(AV121Empresabase_calculowwds_8_tfemplicdlim_to) ,
                                           Byte.valueOf(AV122Empresabase_calculowwds_9_tfemplicdseman) ,
                                           Byte.valueOf(AV123Empresabase_calculowwds_10_tfemplicdseman_to) ,
                                           Integer.valueOf(AV124Empresabase_calculowwds_11_tfemplicdmes_sels.size()) ,
                                           Short.valueOf(AV125Empresabase_calculowwds_12_tfemplicdsemes) ,
                                           Short.valueOf(AV126Empresabase_calculowwds_13_tfemplicdsemes_to) ,
                                           Short.valueOf(AV127Empresabase_calculowwds_14_tfemplicdanual) ,
                                           Short.valueOf(AV128Empresabase_calculowwds_15_tfemplicdanual_to) ,
                                           Byte.valueOf(AV129Empresabase_calculowwds_16_tfemplicadju_sel) ,
                                           Byte.valueOf(AV130Empresabase_calculowwds_17_tfemplicadjuobl_sel) ,
                                           Byte.valueOf(AV131Empresabase_calculowwds_18_tfemplicnecaut_sel) ,
                                           Byte.valueOf(AV132Empresabase_calculowwds_19_tfemplicingmot_sel) ,
                                           Byte.valueOf(AV133Empresabase_calculowwds_20_tfemplicmotobl_sel) ,
                                           Short.valueOf(AV134Empresabase_calculowwds_21_tfempbasepromcnt1) ,
                                           Short.valueOf(AV135Empresabase_calculowwds_22_tfempbasepromcnt1_to) ,
                                           Short.valueOf(AV136Empresabase_calculowwds_23_tfempbasepromcnt2) ,
                                           Short.valueOf(AV137Empresabase_calculowwds_24_tfempbasepromcnt2_to) ,
                                           Integer.valueOf(AV138Empresabase_calculowwds_25_tfempbasepromtcnt_sels.size()) ,
                                           A1432EmpBasePlus ,
                                           Byte.valueOf(A1517EmpLicDMin) ,
                                           Short.valueOf(A1502EmpLicDLim) ,
                                           Byte.valueOf(A1503EmpLicDSeman) ,
                                           Short.valueOf(A1505EmpLicDSemes) ,
                                           Short.valueOf(A1506EmpLicDAnual) ,
                                           Boolean.valueOf(A1507EmpLicAdju) ,
                                           Boolean.valueOf(A1508EmpLicAdjuObl) ,
                                           Boolean.valueOf(A1509EmpLicNecAut) ,
                                           Boolean.valueOf(A1510EmpLicIngMot) ,
                                           Boolean.valueOf(A1511EmpLicMotObl) ,
                                           Short.valueOf(A1437EmpBasePromCnt1) ,
                                           Short.valueOf(A1438EmpBasePromCnt2) ,
                                           Short.valueOf(AV19OrderedBy) ,
                                           Boolean.valueOf(AV20OrderedDsc) ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV89EmpCod) ,
                                           Byte.valueOf(AV114Empresabase_calculowwds_1_empbaseclaseleg) ,
                                           AV115Empresabase_calculowwds_2_empbasetipo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Byte.valueOf(A1427EmpBaseClaseLeg) ,
                                           A1429EmpBaseTipo } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING
                                           }
      });
      /* Using cursor P01SM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV89EmpCod), Byte.valueOf(AV114Empresabase_calculowwds_1_empbaseclaseleg), AV115Empresabase_calculowwds_2_empbasetipo, AV116Empresabase_calculowwds_3_tfempbaseplus, AV117Empresabase_calculowwds_4_tfempbaseplus_to, Byte.valueOf(AV118Empresabase_calculowwds_5_tfemplicdmin), Byte.valueOf(AV119Empresabase_calculowwds_6_tfemplicdmin_to), Short.valueOf(AV120Empresabase_calculowwds_7_tfemplicdlim), Short.valueOf(AV121Empresabase_calculowwds_8_tfemplicdlim_to), Byte.valueOf(AV122Empresabase_calculowwds_9_tfemplicdseman), Byte.valueOf(AV123Empresabase_calculowwds_10_tfemplicdseman_to), Short.valueOf(AV125Empresabase_calculowwds_12_tfemplicdsemes), Short.valueOf(AV126Empresabase_calculowwds_13_tfemplicdsemes_to), Short.valueOf(AV127Empresabase_calculowwds_14_tfemplicdanual), Short.valueOf(AV128Empresabase_calculowwds_15_tfemplicdanual_to), Short.valueOf(AV134Empresabase_calculowwds_21_tfempbasepromcnt1), Short.valueOf(AV135Empresabase_calculowwds_22_tfempbasepromcnt1_to), Short.valueOf(AV136Empresabase_calculowwds_23_tfempbasepromcnt2), Short.valueOf(AV137Empresabase_calculowwds_24_tfempbasepromcnt2_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P01SM2_A1EmpCod[0] ;
         A3CliCod = P01SM2_A3CliCod[0] ;
         A1439EmpBasePromTCnt = P01SM2_A1439EmpBasePromTCnt[0] ;
         A1438EmpBasePromCnt2 = P01SM2_A1438EmpBasePromCnt2[0] ;
         A1437EmpBasePromCnt1 = P01SM2_A1437EmpBasePromCnt1[0] ;
         A1511EmpLicMotObl = P01SM2_A1511EmpLicMotObl[0] ;
         n1511EmpLicMotObl = P01SM2_n1511EmpLicMotObl[0] ;
         A1510EmpLicIngMot = P01SM2_A1510EmpLicIngMot[0] ;
         n1510EmpLicIngMot = P01SM2_n1510EmpLicIngMot[0] ;
         A1509EmpLicNecAut = P01SM2_A1509EmpLicNecAut[0] ;
         n1509EmpLicNecAut = P01SM2_n1509EmpLicNecAut[0] ;
         A1508EmpLicAdjuObl = P01SM2_A1508EmpLicAdjuObl[0] ;
         n1508EmpLicAdjuObl = P01SM2_n1508EmpLicAdjuObl[0] ;
         A1507EmpLicAdju = P01SM2_A1507EmpLicAdju[0] ;
         n1507EmpLicAdju = P01SM2_n1507EmpLicAdju[0] ;
         A1506EmpLicDAnual = P01SM2_A1506EmpLicDAnual[0] ;
         n1506EmpLicDAnual = P01SM2_n1506EmpLicDAnual[0] ;
         A1505EmpLicDSemes = P01SM2_A1505EmpLicDSemes[0] ;
         n1505EmpLicDSemes = P01SM2_n1505EmpLicDSemes[0] ;
         A1504EmpLicDMes = P01SM2_A1504EmpLicDMes[0] ;
         n1504EmpLicDMes = P01SM2_n1504EmpLicDMes[0] ;
         A1503EmpLicDSeman = P01SM2_A1503EmpLicDSeman[0] ;
         n1503EmpLicDSeman = P01SM2_n1503EmpLicDSeman[0] ;
         A1502EmpLicDLim = P01SM2_A1502EmpLicDLim[0] ;
         n1502EmpLicDLim = P01SM2_n1502EmpLicDLim[0] ;
         A1517EmpLicDMin = P01SM2_A1517EmpLicDMin[0] ;
         n1517EmpLicDMin = P01SM2_n1517EmpLicDMin[0] ;
         A1432EmpBasePlus = P01SM2_A1432EmpBasePlus[0] ;
         A1429EmpBaseTipo = P01SM2_A1429EmpBaseTipo[0] ;
         A1427EmpBaseClaseLeg = P01SM2_A1427EmpBaseClaseLeg[0] ;
         A1430EmpBaseCod1 = P01SM2_A1430EmpBaseCod1[0] ;
         A1431EmpBaseCod2 = P01SM2_A1431EmpBaseCod2[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV33VisibleColumnCount = 0 ;
         AV139GXV4 = 1 ;
         while ( AV139GXV4 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV139GXV4));
            if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&EmpBaseC1Txt") == 0 )
               {
                  GXt_char6 = AV103EmpBaseC1Txt ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.gettxtbasecod1(remoteHandle, context).execute( 0, A1429EmpBaseTipo, A1430EmpBaseCod1, GXv_char7) ;
                  empresabase_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV103EmpBaseC1Txt = GXt_char6 ;
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV103EmpBaseC1Txt, GXv_char7) ;
                  empresabase_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&EmpBaseC2Txt") == 0 )
               {
                  GXt_char6 = AV104EmpBaseC2Txt ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.gettxtbasecod2(remoteHandle, context).execute( 0, A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, GXv_char7) ;
                  empresabase_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV104EmpBaseC2Txt = GXt_char6 ;
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV104EmpBaseC2Txt, GXv_char7) ;
                  empresabase_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpBasePlus") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1432EmpBasePlus)) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpLicDMin") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A1517EmpLicDMin );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpLicDLim") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A1502EmpLicDLim );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpLicDSeman") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A1503EmpLicDSeman );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpLicDMes") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A1504EmpLicDMes );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpLicDSemes") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A1505EmpLicDSemes );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpLicDAnual") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A1506EmpLicDAnual );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpLicAdju") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1507EmpLicAdju) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpLicAdjuObl") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1508EmpLicAdjuObl) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpLicNecAut") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1509EmpLicNecAut) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpLicIngMot") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1510EmpLicIngMot) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpLicMotObl") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1511EmpLicMotObl) );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpBasePromCnt1") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A1437EmpBasePromCnt1 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpBasePromCnt2") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A1438EmpBasePromCnt2 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "EmpBasePromTCnt") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainduracion_tipo.getDescription(httpContext,(String)A1439EmpBasePromTCnt), "") );
               }
               AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
            }
            AV139GXV4 = (int)(AV139GXV4+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
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
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      AV93IsAuthorizedEmpLicDMin = (boolean)(((GXutil.strcmp(AV18EmpBaseTipo, "licencia")==0))) ;
      AV94IsAuthorizedEmpLicDLim = (boolean)(((GXutil.strcmp(AV18EmpBaseTipo, "licencia")==0))) ;
      AV95IsAuthorizedEmpLicDSeman = (boolean)(((GXutil.strcmp(AV18EmpBaseTipo, "licencia")==0))) ;
      AV96IsAuthorizedEmpLicDMes = (boolean)(((GXutil.strcmp(AV18EmpBaseTipo, "licencia")==0))) ;
      AV97IsAuthorizedEmpLicDSemes = (boolean)(((GXutil.strcmp(AV18EmpBaseTipo, "licencia")==0))) ;
      AV98IsAuthorizedEmpLicDAnual = (boolean)(((GXutil.strcmp(AV18EmpBaseTipo, "licencia")==0))) ;
      AV106IsAuthorizedEmpLicAdju = (boolean)(((GXutil.strcmp(AV18EmpBaseTipo, "licencia")==0))) ;
      AV99IsAuthorizedEmpLicAdjuObl = (boolean)(((GXutil.strcmp(AV18EmpBaseTipo, "licencia")==0))) ;
      AV100IsAuthorizedEmpLicNecAut = (boolean)(((GXutil.strcmp(AV18EmpBaseTipo, "licencia")==0))) ;
      AV101IsAuthorizedEmpLicIngMot = (boolean)(((GXutil.strcmp(AV18EmpBaseTipo, "licencia")==0))) ;
      AV102IsAuthorizedEmpLicMotObl = (boolean)(((GXutil.strcmp(AV18EmpBaseTipo, "licencia")==0))) ;
   }

   public void S201( )
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
      AV25ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EmpBaseC1Txt", "", "Código 1", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EmpBaseC2Txt", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&Default", "", "Default", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpBasePlus", "", "Porcentaje para plus", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( GXutil.strcmp(AV18EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpLicDMin", "", "Cantidad mínima de días permitidos por licencia", true, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpLicDLim", "", "Cantidad de días permitidos por licencia", true, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpLicDSeman", "", "Cantidad de días permitidos por semana", true, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpLicDMes", "", "Cantidad de días permitidos por mes", true, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpLicDSemes", "", "Cantidad de días permitidos por semestre", true, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpLicDAnual", "", "Cantidad de días permitidos por año", true, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpLicAdju", "", "Permite adjuntar documento", true, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpLicAdjuObl", "", "Obliga a adjuntar documento", true, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpLicNecAut", "", "Necesita autorización", true, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpLicIngMot", "", "Permite ingresar motivo", true, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      if ( GXutil.strcmp(AV18EmpBaseTipo, "licencia") == 0 )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpLicMotObl", "", "Obliga a ingresar motivo", true, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpBasePromCnt1", "", "Cantidad de días/meses a promediar", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpBasePromCnt2", "", "Cantidad de días/meses a promediar segunda alternativa", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "EmpBasePromTCnt", "", "Días o Meses", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV29UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Empresabase_calculoWWColumnsSelector", GXv_char7) ;
      empresabase_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
      AV29UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV29UserCustomValue)==0) ) )
      {
         AV26ColumnsSelectorAux.fromxml(AV29UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV26ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue("Empresabase_calculoWWGridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Empresabase_calculoWWGridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV21Session.getValue("Empresabase_calculoWWGridState"), null, null);
      }
      AV19OrderedBy = AV23GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV20OrderedDsc = AV23GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV140GXV5 = 1 ;
      while ( AV140GXV5 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV140GXV5));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBASEPLUS") == 0 )
         {
            AV58TFEmpBasePlus = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV59TFEmpBasePlus_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICDMIN") == 0 )
         {
            AV60TFEmpLicDMin = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV61TFEmpLicDMin_To = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICDLIM") == 0 )
         {
            AV62TFEmpLicDLim = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV63TFEmpLicDLim_To = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICDSEMAN") == 0 )
         {
            AV64TFEmpLicDSeman = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV65TFEmpLicDSeman_To = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICDMES_SEL") == 0 )
         {
            AV66TFEmpLicDMes_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV67TFEmpLicDMes_Sels.fromJSonString(AV66TFEmpLicDMes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICDSEMES") == 0 )
         {
            AV69TFEmpLicDSemes = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV70TFEmpLicDSemes_To = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICDANUAL") == 0 )
         {
            AV71TFEmpLicDAnual = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV72TFEmpLicDAnual_To = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICADJU_SEL") == 0 )
         {
            AV73TFEmpLicAdju_Sel = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICADJUOBL_SEL") == 0 )
         {
            AV74TFEmpLicAdjuObl_Sel = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICNECAUT_SEL") == 0 )
         {
            AV75TFEmpLicNecAut_Sel = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICINGMOT_SEL") == 0 )
         {
            AV76TFEmpLicIngMot_Sel = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPLICMOTOBL_SEL") == 0 )
         {
            AV77TFEmpLicMotObl_Sel = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBASEPROMCNT1") == 0 )
         {
            AV80TFEmpBasePromCnt1 = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV81TFEmpBasePromCnt1_To = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBASEPROMCNT2") == 0 )
         {
            AV82TFEmpBasePromCnt2 = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV83TFEmpBasePromCnt2_To = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBASEPROMTCNT_SEL") == 0 )
         {
            AV84TFEmpBasePromTCnt_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV85TFEmpBasePromTCnt_Sels.fromJSonString(AV84TFEmpBasePromTCnt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV105MenuOpcCod = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPBASECLASELEG") == 0 )
         {
            AV17EmpBaseClaseLeg = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPBASETIPO") == 0 )
         {
            AV18EmpBaseTipo = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV140GXV5 = (int)(AV140GXV5+1) ;
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
      this.aP0[0] = empresabase_calculowwexport.this.AV12Filename;
      this.aP1[0] = empresabase_calculowwexport.this.AV13ErrorMessage;
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
      AV109Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV58TFEmpBasePlus = DecimalUtil.ZERO ;
      AV59TFEmpBasePlus_To = DecimalUtil.ZERO ;
      AV67TFEmpLicDMes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV85TFEmpBasePromTCnt_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV86TFEmpBasePromTCnt_Sel = "" ;
      AV21Session = httpContext.getWebSession();
      AV28ColumnsSelectorXML = "" ;
      AV25ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV27ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1429EmpBaseTipo = "" ;
      A1430EmpBaseCod1 = "" ;
      A1431EmpBaseCod2 = "" ;
      A1432EmpBasePlus = DecimalUtil.ZERO ;
      A1439EmpBasePromTCnt = "" ;
      AV115Empresabase_calculowwds_2_empbasetipo = "" ;
      AV18EmpBaseTipo = "" ;
      AV116Empresabase_calculowwds_3_tfempbaseplus = DecimalUtil.ZERO ;
      AV117Empresabase_calculowwds_4_tfempbaseplus_to = DecimalUtil.ZERO ;
      AV124Empresabase_calculowwds_11_tfemplicdmes_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV138Empresabase_calculowwds_25_tfempbasepromtcnt_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      P01SM2_A1EmpCod = new short[1] ;
      P01SM2_A3CliCod = new int[1] ;
      P01SM2_A1439EmpBasePromTCnt = new String[] {""} ;
      P01SM2_A1438EmpBasePromCnt2 = new short[1] ;
      P01SM2_A1437EmpBasePromCnt1 = new short[1] ;
      P01SM2_A1511EmpLicMotObl = new boolean[] {false} ;
      P01SM2_n1511EmpLicMotObl = new boolean[] {false} ;
      P01SM2_A1510EmpLicIngMot = new boolean[] {false} ;
      P01SM2_n1510EmpLicIngMot = new boolean[] {false} ;
      P01SM2_A1509EmpLicNecAut = new boolean[] {false} ;
      P01SM2_n1509EmpLicNecAut = new boolean[] {false} ;
      P01SM2_A1508EmpLicAdjuObl = new boolean[] {false} ;
      P01SM2_n1508EmpLicAdjuObl = new boolean[] {false} ;
      P01SM2_A1507EmpLicAdju = new boolean[] {false} ;
      P01SM2_n1507EmpLicAdju = new boolean[] {false} ;
      P01SM2_A1506EmpLicDAnual = new short[1] ;
      P01SM2_n1506EmpLicDAnual = new boolean[] {false} ;
      P01SM2_A1505EmpLicDSemes = new short[1] ;
      P01SM2_n1505EmpLicDSemes = new boolean[] {false} ;
      P01SM2_A1504EmpLicDMes = new byte[1] ;
      P01SM2_n1504EmpLicDMes = new boolean[] {false} ;
      P01SM2_A1503EmpLicDSeman = new byte[1] ;
      P01SM2_n1503EmpLicDSeman = new boolean[] {false} ;
      P01SM2_A1502EmpLicDLim = new short[1] ;
      P01SM2_n1502EmpLicDLim = new boolean[] {false} ;
      P01SM2_A1517EmpLicDMin = new byte[1] ;
      P01SM2_n1517EmpLicDMin = new boolean[] {false} ;
      P01SM2_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SM2_A1429EmpBaseTipo = new String[] {""} ;
      P01SM2_A1427EmpBaseClaseLeg = new byte[1] ;
      P01SM2_A1430EmpBaseCod1 = new String[] {""} ;
      P01SM2_A1431EmpBaseCod2 = new String[] {""} ;
      AV103EmpBaseC1Txt = "" ;
      AV104EmpBaseC2Txt = "" ;
      AV29UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV26ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV23GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV66TFEmpLicDMes_SelsJson = "" ;
      AV84TFEmpBasePromTCnt_SelsJson = "" ;
      AV105MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresabase_calculowwexport__default(),
         new Object[] {
             new Object[] {
            P01SM2_A1EmpCod, P01SM2_A3CliCod, P01SM2_A1439EmpBasePromTCnt, P01SM2_A1438EmpBasePromCnt2, P01SM2_A1437EmpBasePromCnt1, P01SM2_A1511EmpLicMotObl, P01SM2_n1511EmpLicMotObl, P01SM2_A1510EmpLicIngMot, P01SM2_n1510EmpLicIngMot, P01SM2_A1509EmpLicNecAut,
            P01SM2_n1509EmpLicNecAut, P01SM2_A1508EmpLicAdjuObl, P01SM2_n1508EmpLicAdjuObl, P01SM2_A1507EmpLicAdju, P01SM2_n1507EmpLicAdju, P01SM2_A1506EmpLicDAnual, P01SM2_n1506EmpLicDAnual, P01SM2_A1505EmpLicDSemes, P01SM2_n1505EmpLicDSemes, P01SM2_A1504EmpLicDMes,
            P01SM2_n1504EmpLicDMes, P01SM2_A1503EmpLicDSeman, P01SM2_n1503EmpLicDSeman, P01SM2_A1502EmpLicDLim, P01SM2_n1502EmpLicDLim, P01SM2_A1517EmpLicDMin, P01SM2_n1517EmpLicDMin, P01SM2_A1432EmpBasePlus, P01SM2_A1429EmpBaseTipo, P01SM2_A1427EmpBaseClaseLeg,
            P01SM2_A1430EmpBaseCod1, P01SM2_A1431EmpBaseCod2
            }
         }
      );
      AV109Pgmname = "Empresabase_calculoWWExport" ;
      /* GeneXus formulas. */
      AV109Pgmname = "Empresabase_calculoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV60TFEmpLicDMin ;
   private byte AV61TFEmpLicDMin_To ;
   private byte AV64TFEmpLicDSeman ;
   private byte AV65TFEmpLicDSeman_To ;
   private byte AV68TFEmpLicDMes_Sel ;
   private byte AV73TFEmpLicAdju_Sel ;
   private byte AV74TFEmpLicAdjuObl_Sel ;
   private byte AV75TFEmpLicNecAut_Sel ;
   private byte AV76TFEmpLicIngMot_Sel ;
   private byte AV77TFEmpLicMotObl_Sel ;
   private byte A1517EmpLicDMin ;
   private byte A1503EmpLicDSeman ;
   private byte A1504EmpLicDMes ;
   private byte AV114Empresabase_calculowwds_1_empbaseclaseleg ;
   private byte AV17EmpBaseClaseLeg ;
   private byte AV118Empresabase_calculowwds_5_tfemplicdmin ;
   private byte AV119Empresabase_calculowwds_6_tfemplicdmin_to ;
   private byte AV122Empresabase_calculowwds_9_tfemplicdseman ;
   private byte AV123Empresabase_calculowwds_10_tfemplicdseman_to ;
   private byte AV129Empresabase_calculowwds_16_tfemplicadju_sel ;
   private byte AV130Empresabase_calculowwds_17_tfemplicadjuobl_sel ;
   private byte AV131Empresabase_calculowwds_18_tfemplicnecaut_sel ;
   private byte AV132Empresabase_calculowwds_19_tfemplicingmot_sel ;
   private byte AV133Empresabase_calculowwds_20_tfemplicmotobl_sel ;
   private byte A1427EmpBaseClaseLeg ;
   private short AV62TFEmpLicDLim ;
   private short AV63TFEmpLicDLim_To ;
   private short AV69TFEmpLicDSemes ;
   private short AV70TFEmpLicDSemes_To ;
   private short AV71TFEmpLicDAnual ;
   private short AV72TFEmpLicDAnual_To ;
   private short AV80TFEmpBasePromCnt1 ;
   private short AV81TFEmpBasePromCnt1_To ;
   private short AV82TFEmpBasePromCnt2 ;
   private short AV83TFEmpBasePromCnt2_To ;
   private short GXv_int5[] ;
   private short A1502EmpLicDLim ;
   private short A1505EmpLicDSemes ;
   private short A1506EmpLicDAnual ;
   private short A1437EmpBasePromCnt1 ;
   private short A1438EmpBasePromCnt2 ;
   private short AV120Empresabase_calculowwds_7_tfemplicdlim ;
   private short AV121Empresabase_calculowwds_8_tfemplicdlim_to ;
   private short AV125Empresabase_calculowwds_12_tfemplicdsemes ;
   private short AV126Empresabase_calculowwds_13_tfemplicdsemes_to ;
   private short AV127Empresabase_calculowwds_14_tfemplicdanual ;
   private short AV128Empresabase_calculowwds_15_tfemplicdanual_to ;
   private short AV134Empresabase_calculowwds_21_tfempbasepromcnt1 ;
   private short AV135Empresabase_calculowwds_22_tfempbasepromcnt1_to ;
   private short AV136Empresabase_calculowwds_23_tfempbasepromcnt2 ;
   private short AV137Empresabase_calculowwds_24_tfempbasepromcnt2_to ;
   private short AV19OrderedBy ;
   private short AV89EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV110GXV1 ;
   private int AV111GXV2 ;
   private int AV112GXV3 ;
   private int AV124Empresabase_calculowwds_11_tfemplicdmes_sels_size ;
   private int AV138Empresabase_calculowwds_25_tfempbasepromtcnt_sels_size ;
   private int AV88CliCod ;
   private int A3CliCod ;
   private int AV139GXV4 ;
   private int AV140GXV5 ;
   private long AV87i ;
   private long AV33VisibleColumnCount ;
   private java.math.BigDecimal AV58TFEmpBasePlus ;
   private java.math.BigDecimal AV59TFEmpBasePlus_To ;
   private java.math.BigDecimal A1432EmpBasePlus ;
   private java.math.BigDecimal AV116Empresabase_calculowwds_3_tfempbaseplus ;
   private java.math.BigDecimal AV117Empresabase_calculowwds_4_tfempbaseplus_to ;
   private String AV109Pgmname ;
   private String AV86TFEmpBasePromTCnt_Sel ;
   private String A1429EmpBaseTipo ;
   private String A1430EmpBaseCod1 ;
   private String A1431EmpBaseCod2 ;
   private String A1439EmpBasePromTCnt ;
   private String AV115Empresabase_calculowwds_2_empbasetipo ;
   private String AV18EmpBaseTipo ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV93IsAuthorizedEmpLicDMin ;
   private boolean AV94IsAuthorizedEmpLicDLim ;
   private boolean AV95IsAuthorizedEmpLicDSeman ;
   private boolean AV96IsAuthorizedEmpLicDMes ;
   private boolean AV97IsAuthorizedEmpLicDSemes ;
   private boolean AV98IsAuthorizedEmpLicDAnual ;
   private boolean AV106IsAuthorizedEmpLicAdju ;
   private boolean AV99IsAuthorizedEmpLicAdjuObl ;
   private boolean AV100IsAuthorizedEmpLicNecAut ;
   private boolean AV101IsAuthorizedEmpLicIngMot ;
   private boolean AV102IsAuthorizedEmpLicMotObl ;
   private boolean A1507EmpLicAdju ;
   private boolean A1508EmpLicAdjuObl ;
   private boolean A1509EmpLicNecAut ;
   private boolean A1510EmpLicIngMot ;
   private boolean A1511EmpLicMotObl ;
   private boolean AV20OrderedDsc ;
   private boolean n1511EmpLicMotObl ;
   private boolean n1510EmpLicIngMot ;
   private boolean n1509EmpLicNecAut ;
   private boolean n1508EmpLicAdjuObl ;
   private boolean n1507EmpLicAdju ;
   private boolean n1506EmpLicDAnual ;
   private boolean n1505EmpLicDSemes ;
   private boolean n1504EmpLicDMes ;
   private boolean n1503EmpLicDSeman ;
   private boolean n1502EmpLicDLim ;
   private boolean n1517EmpLicDMin ;
   private String AV28ColumnsSelectorXML ;
   private String AV29UserCustomValue ;
   private String AV66TFEmpLicDMes_SelsJson ;
   private String AV84TFEmpBasePromTCnt_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV103EmpBaseC1Txt ;
   private String AV104EmpBaseC2Txt ;
   private String AV105MenuOpcCod ;
   private GXSimpleCollection<Byte> AV67TFEmpLicDMes_Sels ;
   private GXSimpleCollection<Byte> AV124Empresabase_calculowwds_11_tfemplicdmes_sels ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private GXSimpleCollection<String> AV85TFEmpBasePromTCnt_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P01SM2_A1EmpCod ;
   private int[] P01SM2_A3CliCod ;
   private String[] P01SM2_A1439EmpBasePromTCnt ;
   private short[] P01SM2_A1438EmpBasePromCnt2 ;
   private short[] P01SM2_A1437EmpBasePromCnt1 ;
   private boolean[] P01SM2_A1511EmpLicMotObl ;
   private boolean[] P01SM2_n1511EmpLicMotObl ;
   private boolean[] P01SM2_A1510EmpLicIngMot ;
   private boolean[] P01SM2_n1510EmpLicIngMot ;
   private boolean[] P01SM2_A1509EmpLicNecAut ;
   private boolean[] P01SM2_n1509EmpLicNecAut ;
   private boolean[] P01SM2_A1508EmpLicAdjuObl ;
   private boolean[] P01SM2_n1508EmpLicAdjuObl ;
   private boolean[] P01SM2_A1507EmpLicAdju ;
   private boolean[] P01SM2_n1507EmpLicAdju ;
   private short[] P01SM2_A1506EmpLicDAnual ;
   private boolean[] P01SM2_n1506EmpLicDAnual ;
   private short[] P01SM2_A1505EmpLicDSemes ;
   private boolean[] P01SM2_n1505EmpLicDSemes ;
   private byte[] P01SM2_A1504EmpLicDMes ;
   private boolean[] P01SM2_n1504EmpLicDMes ;
   private byte[] P01SM2_A1503EmpLicDSeman ;
   private boolean[] P01SM2_n1503EmpLicDSeman ;
   private short[] P01SM2_A1502EmpLicDLim ;
   private boolean[] P01SM2_n1502EmpLicDLim ;
   private byte[] P01SM2_A1517EmpLicDMin ;
   private boolean[] P01SM2_n1517EmpLicDMin ;
   private java.math.BigDecimal[] P01SM2_A1432EmpBasePlus ;
   private String[] P01SM2_A1429EmpBaseTipo ;
   private byte[] P01SM2_A1427EmpBaseClaseLeg ;
   private String[] P01SM2_A1430EmpBaseCod1 ;
   private String[] P01SM2_A1431EmpBaseCod2 ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV138Empresabase_calculowwds_25_tfempbasepromtcnt_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV27ColumnsSelector_Column ;
}

final  class empresabase_calculowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01SM2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A1504EmpLicDMes ,
                                          GXSimpleCollection<Byte> AV124Empresabase_calculowwds_11_tfemplicdmes_sels ,
                                          String A1439EmpBasePromTCnt ,
                                          GXSimpleCollection<String> AV138Empresabase_calculowwds_25_tfempbasepromtcnt_sels ,
                                          java.math.BigDecimal AV116Empresabase_calculowwds_3_tfempbaseplus ,
                                          java.math.BigDecimal AV117Empresabase_calculowwds_4_tfempbaseplus_to ,
                                          byte AV118Empresabase_calculowwds_5_tfemplicdmin ,
                                          byte AV119Empresabase_calculowwds_6_tfemplicdmin_to ,
                                          short AV120Empresabase_calculowwds_7_tfemplicdlim ,
                                          short AV121Empresabase_calculowwds_8_tfemplicdlim_to ,
                                          byte AV122Empresabase_calculowwds_9_tfemplicdseman ,
                                          byte AV123Empresabase_calculowwds_10_tfemplicdseman_to ,
                                          int AV124Empresabase_calculowwds_11_tfemplicdmes_sels_size ,
                                          short AV125Empresabase_calculowwds_12_tfemplicdsemes ,
                                          short AV126Empresabase_calculowwds_13_tfemplicdsemes_to ,
                                          short AV127Empresabase_calculowwds_14_tfemplicdanual ,
                                          short AV128Empresabase_calculowwds_15_tfemplicdanual_to ,
                                          byte AV129Empresabase_calculowwds_16_tfemplicadju_sel ,
                                          byte AV130Empresabase_calculowwds_17_tfemplicadjuobl_sel ,
                                          byte AV131Empresabase_calculowwds_18_tfemplicnecaut_sel ,
                                          byte AV132Empresabase_calculowwds_19_tfemplicingmot_sel ,
                                          byte AV133Empresabase_calculowwds_20_tfemplicmotobl_sel ,
                                          short AV134Empresabase_calculowwds_21_tfempbasepromcnt1 ,
                                          short AV135Empresabase_calculowwds_22_tfempbasepromcnt1_to ,
                                          short AV136Empresabase_calculowwds_23_tfempbasepromcnt2 ,
                                          short AV137Empresabase_calculowwds_24_tfempbasepromcnt2_to ,
                                          int AV138Empresabase_calculowwds_25_tfempbasepromtcnt_sels_size ,
                                          java.math.BigDecimal A1432EmpBasePlus ,
                                          byte A1517EmpLicDMin ,
                                          short A1502EmpLicDLim ,
                                          byte A1503EmpLicDSeman ,
                                          short A1505EmpLicDSemes ,
                                          short A1506EmpLicDAnual ,
                                          boolean A1507EmpLicAdju ,
                                          boolean A1508EmpLicAdjuObl ,
                                          boolean A1509EmpLicNecAut ,
                                          boolean A1510EmpLicIngMot ,
                                          boolean A1511EmpLicMotObl ,
                                          short A1437EmpBasePromCnt1 ,
                                          short A1438EmpBasePromCnt2 ,
                                          short AV19OrderedBy ,
                                          boolean AV20OrderedDsc ,
                                          int AV88CliCod ,
                                          short AV89EmpCod ,
                                          byte AV114Empresabase_calculowwds_1_empbaseclaseleg ,
                                          String AV115Empresabase_calculowwds_2_empbasetipo ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          byte A1427EmpBaseClaseLeg ,
                                          String A1429EmpBaseTipo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[20];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT EmpCod, CliCod, EmpBasePromTCnt, EmpBasePromCnt2, EmpBasePromCnt1, EmpLicMotObl, EmpLicIngMot, EmpLicNecAut, EmpLicAdjuObl, EmpLicAdju, EmpLicDAnual, EmpLicDSemes," ;
      scmdbuf += " EmpLicDMes, EmpLicDSeman, EmpLicDLim, EmpLicDMin, EmpBasePlus, EmpBaseTipo, EmpBaseClaseLeg, EmpBaseCod1, EmpBaseCod2 FROM Empresabase_calculo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and EmpBaseClaseLeg = ? and EmpBaseTipo = ( ?))");
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV116Empresabase_calculowwds_3_tfempbaseplus)==0) )
      {
         addWhere(sWhereString, "(EmpBasePlus >= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117Empresabase_calculowwds_4_tfempbaseplus_to)==0) )
      {
         addWhere(sWhereString, "(EmpBasePlus <= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV118Empresabase_calculowwds_5_tfemplicdmin) )
      {
         addWhere(sWhereString, "(EmpLicDMin >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (0==AV119Empresabase_calculowwds_6_tfemplicdmin_to) )
      {
         addWhere(sWhereString, "(EmpLicDMin <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( ! (0==AV120Empresabase_calculowwds_7_tfemplicdlim) )
      {
         addWhere(sWhereString, "(EmpLicDLim >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (0==AV121Empresabase_calculowwds_8_tfemplicdlim_to) )
      {
         addWhere(sWhereString, "(EmpLicDLim <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (0==AV122Empresabase_calculowwds_9_tfemplicdseman) )
      {
         addWhere(sWhereString, "(EmpLicDSeman >= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (0==AV123Empresabase_calculowwds_10_tfemplicdseman_to) )
      {
         addWhere(sWhereString, "(EmpLicDSeman <= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( AV124Empresabase_calculowwds_11_tfemplicdmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV124Empresabase_calculowwds_11_tfemplicdmes_sels, "EmpLicDMes IN (", ")")+")");
      }
      if ( ! (0==AV125Empresabase_calculowwds_12_tfemplicdsemes) )
      {
         addWhere(sWhereString, "(EmpLicDSemes >= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (0==AV126Empresabase_calculowwds_13_tfemplicdsemes_to) )
      {
         addWhere(sWhereString, "(EmpLicDSemes <= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (0==AV127Empresabase_calculowwds_14_tfemplicdanual) )
      {
         addWhere(sWhereString, "(EmpLicDAnual >= ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (0==AV128Empresabase_calculowwds_15_tfemplicdanual_to) )
      {
         addWhere(sWhereString, "(EmpLicDAnual <= ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( AV129Empresabase_calculowwds_16_tfemplicadju_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicAdju = TRUE)");
      }
      if ( AV129Empresabase_calculowwds_16_tfemplicadju_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicAdju = FALSE)");
      }
      if ( AV130Empresabase_calculowwds_17_tfemplicadjuobl_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicAdjuObl = TRUE)");
      }
      if ( AV130Empresabase_calculowwds_17_tfemplicadjuobl_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicAdjuObl = FALSE)");
      }
      if ( AV131Empresabase_calculowwds_18_tfemplicnecaut_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicNecAut = TRUE)");
      }
      if ( AV131Empresabase_calculowwds_18_tfemplicnecaut_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicNecAut = FALSE)");
      }
      if ( AV132Empresabase_calculowwds_19_tfemplicingmot_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicIngMot = TRUE)");
      }
      if ( AV132Empresabase_calculowwds_19_tfemplicingmot_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicIngMot = FALSE)");
      }
      if ( AV133Empresabase_calculowwds_20_tfemplicmotobl_sel == 1 )
      {
         addWhere(sWhereString, "(EmpLicMotObl = TRUE)");
      }
      if ( AV133Empresabase_calculowwds_20_tfemplicmotobl_sel == 2 )
      {
         addWhere(sWhereString, "(EmpLicMotObl = FALSE)");
      }
      if ( ! (0==AV134Empresabase_calculowwds_21_tfempbasepromcnt1) )
      {
         addWhere(sWhereString, "(EmpBasePromCnt1 >= ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (0==AV135Empresabase_calculowwds_22_tfempbasepromcnt1_to) )
      {
         addWhere(sWhereString, "(EmpBasePromCnt1 <= ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (0==AV136Empresabase_calculowwds_23_tfempbasepromcnt2) )
      {
         addWhere(sWhereString, "(EmpBasePromCnt2 >= ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( ! (0==AV137Empresabase_calculowwds_24_tfempbasepromcnt2_to) )
      {
         addWhere(sWhereString, "(EmpBasePromCnt2 <= ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( AV138Empresabase_calculowwds_25_tfempbasepromtcnt_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV138Empresabase_calculowwds_25_tfempbasepromtcnt_sels, "EmpBasePromTCnt IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV19OrderedBy == 1 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpBasePlus" ;
      }
      else if ( ( AV19OrderedBy == 1 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpBasePlus DESC" ;
      }
      else if ( ( AV19OrderedBy == 2 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicDMin" ;
      }
      else if ( ( AV19OrderedBy == 2 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicDMin DESC" ;
      }
      else if ( ( AV19OrderedBy == 3 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicDLim" ;
      }
      else if ( ( AV19OrderedBy == 3 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicDLim DESC" ;
      }
      else if ( ( AV19OrderedBy == 4 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicDSeman" ;
      }
      else if ( ( AV19OrderedBy == 4 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicDSeman DESC" ;
      }
      else if ( ( AV19OrderedBy == 5 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicDMes" ;
      }
      else if ( ( AV19OrderedBy == 5 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicDMes DESC" ;
      }
      else if ( ( AV19OrderedBy == 6 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicDSemes" ;
      }
      else if ( ( AV19OrderedBy == 6 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicDSemes DESC" ;
      }
      else if ( ( AV19OrderedBy == 7 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicDAnual" ;
      }
      else if ( ( AV19OrderedBy == 7 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicDAnual DESC" ;
      }
      else if ( ( AV19OrderedBy == 8 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicAdju" ;
      }
      else if ( ( AV19OrderedBy == 8 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicAdju DESC" ;
      }
      else if ( ( AV19OrderedBy == 9 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicAdjuObl" ;
      }
      else if ( ( AV19OrderedBy == 9 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicAdjuObl DESC" ;
      }
      else if ( ( AV19OrderedBy == 10 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicNecAut" ;
      }
      else if ( ( AV19OrderedBy == 10 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicNecAut DESC" ;
      }
      else if ( ( AV19OrderedBy == 11 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicIngMot" ;
      }
      else if ( ( AV19OrderedBy == 11 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicIngMot DESC" ;
      }
      else if ( ( AV19OrderedBy == 12 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpLicMotObl" ;
      }
      else if ( ( AV19OrderedBy == 12 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpLicMotObl DESC" ;
      }
      else if ( ( AV19OrderedBy == 13 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpBasePromCnt1" ;
      }
      else if ( ( AV19OrderedBy == 13 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpBasePromCnt1 DESC" ;
      }
      else if ( ( AV19OrderedBy == 14 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpBasePromCnt2" ;
      }
      else if ( ( AV19OrderedBy == 14 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpBasePromCnt2 DESC" ;
      }
      else if ( ( AV19OrderedBy == 15 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg, EmpBaseTipo, EmpBasePromTCnt" ;
      }
      else if ( ( AV19OrderedBy == 15 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpBasePromTCnt DESC" ;
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
                  return conditional_P01SM2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (java.math.BigDecimal)dynConstraints[4] , (java.math.BigDecimal)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[7]).byteValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).byteValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).intValue() , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).byteValue() , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Boolean) dynConstraints[34]).booleanValue() , ((Boolean) dynConstraints[35]).booleanValue() , ((Boolean) dynConstraints[36]).booleanValue() , ((Boolean) dynConstraints[37]).booleanValue() , ((Number) dynConstraints[38]).shortValue() , ((Number) dynConstraints[39]).shortValue() , ((Number) dynConstraints[40]).shortValue() , ((Boolean) dynConstraints[41]).booleanValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).byteValue() , (String)dynConstraints[45] , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).shortValue() , ((Number) dynConstraints[48]).byteValue() , (String)dynConstraints[49] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01SM2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((boolean[]) buf[9])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((boolean[]) buf[11])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((boolean[]) buf[13])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((short[]) buf[17])[0] = rslt.getShort(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((byte[]) buf[19])[0] = rslt.getByte(13);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((byte[]) buf[21])[0] = rslt.getByte(14);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((short[]) buf[23])[0] = rslt.getShort(15);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((byte[]) buf[25])[0] = rslt.getByte(16);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(17,4);
               ((String[]) buf[28])[0] = rslt.getString(18, 20);
               ((byte[]) buf[29])[0] = rslt.getByte(19);
               ((String[]) buf[30])[0] = rslt.getString(20, 20);
               ((String[]) buf[31])[0] = rslt.getString(21, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[30]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[31]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[38]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[39]).shortValue());
               }
               return;
      }
   }

}

