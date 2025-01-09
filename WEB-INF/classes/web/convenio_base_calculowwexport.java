package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_base_calculowwexport extends GXProcedure
{
   public convenio_base_calculowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_base_calculowwexport.class ), "" );
   }

   public convenio_base_calculowwexport( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      convenio_base_calculowwexport.this.aP1 = new String[] {""};
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
      convenio_base_calculowwexport.this.aP0 = aP0;
      convenio_base_calculowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_base_calculo", GXv_boolean2) ;
      convenio_base_calculowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV83Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "Convenio_base_calculoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV47TFConveBasePlus)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV48TFConveBasePlus_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Porcentaje para plus", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV47TFConveBasePlus)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV48TFConveBasePlus_To)) );
      }
      if ( ! ( (0==AV49TFConveLicDLim) && (0==AV50TFConveLicDLim_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por licencia", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV49TFConveLicDLim );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV50TFConveLicDLim_To );
      }
      if ( ! ( (0==AV51TFConveLicDSeman) && (0==AV52TFConveLicDSeman_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por semana", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV51TFConveLicDSeman );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV52TFConveLicDSeman_To );
      }
      if ( ! ( ( AV54TFConveLicDMes_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por semestre", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV76i = 1 ;
         AV84GXV1 = 1 ;
         while ( AV84GXV1 <= AV54TFConveLicDMes_Sels.size() )
         {
            AV55TFConveLicDMes_Sel = ((Number) AV54TFConveLicDMes_Sels.elementAt(-1+AV84GXV1)).byteValue() ;
            if ( AV76i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+localUtil.format( DecimalUtil.doubleToDec(AV55TFConveLicDMes_Sel), "Z9") );
            AV76i = (long)(AV76i+1) ;
            AV84GXV1 = (int)(AV84GXV1+1) ;
         }
      }
      if ( ! ( (0==AV56TFConveLicDSemes) && (0==AV57TFConveLicDSemes_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por semestre", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV56TFConveLicDSemes );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV57TFConveLicDSemes_To );
      }
      if ( ! ( (0==AV58TFConveLicDAnual) && (0==AV59TFConveLicDAnual_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días permitidos por año", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV58TFConveLicDAnual );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV59TFConveLicDAnual_To );
      }
      if ( ! ( (0==AV60TFConveLicAdju_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Permite adjuntar documento", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV60TFConveLicAdju_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV60TFConveLicAdju_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV61TFConveLicAdjuObl_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Obliga a adjuntar documento", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV61TFConveLicAdjuObl_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV61TFConveLicAdjuObl_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV62TFConveLicNecAut_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Necesita autorización", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV62TFConveLicNecAut_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV62TFConveLicNecAut_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV63TFConveLicIngMot_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Permite ingresar motivo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV63TFConveLicIngMot_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV63TFConveLicIngMot_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV64TFConveLicMotObl_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Obliga a ingresar motivo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV64TFConveLicMotObl_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV64TFConveLicMotObl_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (0==AV65TFConveBasePromCnt1) && (0==AV66TFConveBasePromCnt1_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días/meses a promediar", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV65TFConveBasePromCnt1 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV66TFConveBasePromCnt1_To );
      }
      if ( ! ( (0==AV67TFConveBasePromCnt2) && (0==AV68TFConveBasePromCnt2_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de días/meses a promediar segunda alternativa", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV67TFConveBasePromCnt2 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV68TFConveBasePromCnt2_To );
      }
      if ( ! ( ( AV70TFConveBasePromTCnt_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Días o Meses", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV76i = 1 ;
         AV85GXV2 = 1 ;
         while ( AV85GXV2 <= AV70TFConveBasePromTCnt_Sels.size() )
         {
            AV71TFConveBasePromTCnt_Sel = (String)AV70TFConveBasePromTCnt_Sels.elementAt(-1+AV85GXV2) ;
            if ( AV76i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainduracion_tipo.getDescription(httpContext,(String)AV71TFConveBasePromTCnt_Sel), "") );
            AV76i = (long)(AV76i+1) ;
            AV85GXV2 = (int)(AV85GXV2+1) ;
         }
      }
      if ( ! ( ( AV74TFConveBaseRelRef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV76i = 1 ;
         AV86GXV3 = 1 ;
         while ( AV86GXV3 <= AV74TFConveBaseRelRef_Sels.size() )
         {
            AV75TFConveBaseRelRef_Sel = (String)AV74TFConveBaseRelRef_Sels.elementAt(-1+AV86GXV3) ;
            if ( AV76i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV75TFConveBaseRelRef_Sel, GXv_char7) ;
            convenio_base_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV76i = (long)(AV76i+1) ;
            AV86GXV3 = (int)(AV86GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV73TFConveBaseRelRef)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            convenio_base_calculowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV73TFConveBaseRelRef, GXv_char7) ;
            convenio_base_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV36VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV22Session.getValue("Convenio_base_calculoWWColumnsSelector"), "") != 0 )
      {
         AV31ColumnsSelectorXML = AV22Session.getValue("Convenio_base_calculoWWColumnsSelector") ;
         AV28ColumnsSelector.fromxml(AV31ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV26IsAuthorizedConveBaseRelRef&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV87GXV4 = 1 ;
      while ( AV87GXV4 <= AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV30ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV87GXV4));
         if ( AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setColor( 11 );
            AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
         }
         AV87GXV4 = (int)(AV87GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV89Convenio_base_calculowwds_1_convebaseclaseleg = AV18ConveBaseClaseLeg ;
      AV90Convenio_base_calculowwds_2_convebasetipo = AV19ConveBaseTipo ;
      AV91Convenio_base_calculowwds_3_tfconvebaseplus = AV47TFConveBasePlus ;
      AV92Convenio_base_calculowwds_4_tfconvebaseplus_to = AV48TFConveBasePlus_To ;
      AV93Convenio_base_calculowwds_5_tfconvelicdlim = AV49TFConveLicDLim ;
      AV94Convenio_base_calculowwds_6_tfconvelicdlim_to = AV50TFConveLicDLim_To ;
      AV95Convenio_base_calculowwds_7_tfconvelicdseman = AV51TFConveLicDSeman ;
      AV96Convenio_base_calculowwds_8_tfconvelicdseman_to = AV52TFConveLicDSeman_To ;
      AV97Convenio_base_calculowwds_9_tfconvelicdmes_sels = AV54TFConveLicDMes_Sels ;
      AV98Convenio_base_calculowwds_10_tfconvelicdsemes = AV56TFConveLicDSemes ;
      AV99Convenio_base_calculowwds_11_tfconvelicdsemes_to = AV57TFConveLicDSemes_To ;
      AV100Convenio_base_calculowwds_12_tfconvelicdanual = AV58TFConveLicDAnual ;
      AV101Convenio_base_calculowwds_13_tfconvelicdanual_to = AV59TFConveLicDAnual_To ;
      AV102Convenio_base_calculowwds_14_tfconvelicadju_sel = AV60TFConveLicAdju_Sel ;
      AV103Convenio_base_calculowwds_15_tfconvelicadjuobl_sel = AV61TFConveLicAdjuObl_Sel ;
      AV104Convenio_base_calculowwds_16_tfconvelicnecaut_sel = AV62TFConveLicNecAut_Sel ;
      AV105Convenio_base_calculowwds_17_tfconvelicingmot_sel = AV63TFConveLicIngMot_Sel ;
      AV106Convenio_base_calculowwds_18_tfconvelicmotobl_sel = AV64TFConveLicMotObl_Sel ;
      AV107Convenio_base_calculowwds_19_tfconvebasepromcnt1 = AV65TFConveBasePromCnt1 ;
      AV108Convenio_base_calculowwds_20_tfconvebasepromcnt1_to = AV66TFConveBasePromCnt1_To ;
      AV109Convenio_base_calculowwds_21_tfconvebasepromcnt2 = AV67TFConveBasePromCnt2 ;
      AV110Convenio_base_calculowwds_22_tfconvebasepromcnt2_to = AV68TFConveBasePromCnt2_To ;
      AV111Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels = AV70TFConveBasePromTCnt_Sels ;
      AV112Convenio_base_calculowwds_24_tfconvebaserelref = AV73TFConveBaseRelRef ;
      AV113Convenio_base_calculowwds_25_tfconvebaserelref_sels = AV74TFConveBaseRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Byte.valueOf(A1612ConveLicDMes) ,
                                           AV97Convenio_base_calculowwds_9_tfconvelicdmes_sels ,
                                           A1467ConveBasePromTCnt ,
                                           AV111Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels ,
                                           A2061ConveBaseRelRef ,
                                           AV113Convenio_base_calculowwds_25_tfconvebaserelref_sels ,
                                           AV91Convenio_base_calculowwds_3_tfconvebaseplus ,
                                           AV92Convenio_base_calculowwds_4_tfconvebaseplus_to ,
                                           Short.valueOf(AV93Convenio_base_calculowwds_5_tfconvelicdlim) ,
                                           Short.valueOf(AV94Convenio_base_calculowwds_6_tfconvelicdlim_to) ,
                                           Byte.valueOf(AV95Convenio_base_calculowwds_7_tfconvelicdseman) ,
                                           Byte.valueOf(AV96Convenio_base_calculowwds_8_tfconvelicdseman_to) ,
                                           Integer.valueOf(AV97Convenio_base_calculowwds_9_tfconvelicdmes_sels.size()) ,
                                           Short.valueOf(AV98Convenio_base_calculowwds_10_tfconvelicdsemes) ,
                                           Short.valueOf(AV99Convenio_base_calculowwds_11_tfconvelicdsemes_to) ,
                                           Short.valueOf(AV100Convenio_base_calculowwds_12_tfconvelicdanual) ,
                                           Short.valueOf(AV101Convenio_base_calculowwds_13_tfconvelicdanual_to) ,
                                           Byte.valueOf(AV102Convenio_base_calculowwds_14_tfconvelicadju_sel) ,
                                           Byte.valueOf(AV103Convenio_base_calculowwds_15_tfconvelicadjuobl_sel) ,
                                           Byte.valueOf(AV104Convenio_base_calculowwds_16_tfconvelicnecaut_sel) ,
                                           Byte.valueOf(AV105Convenio_base_calculowwds_17_tfconvelicingmot_sel) ,
                                           Byte.valueOf(AV106Convenio_base_calculowwds_18_tfconvelicmotobl_sel) ,
                                           Short.valueOf(AV107Convenio_base_calculowwds_19_tfconvebasepromcnt1) ,
                                           Short.valueOf(AV108Convenio_base_calculowwds_20_tfconvebasepromcnt1_to) ,
                                           Short.valueOf(AV109Convenio_base_calculowwds_21_tfconvebasepromcnt2) ,
                                           Short.valueOf(AV110Convenio_base_calculowwds_22_tfconvebasepromcnt2_to) ,
                                           Integer.valueOf(AV111Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels.size()) ,
                                           Integer.valueOf(AV113Convenio_base_calculowwds_25_tfconvebaserelref_sels.size()) ,
                                           AV112Convenio_base_calculowwds_24_tfconvebaserelref ,
                                           AV80CliConvenio ,
                                           A1458ConveBasePlus ,
                                           Short.valueOf(A1610ConveLicDLim) ,
                                           Byte.valueOf(A1611ConveLicDSeman) ,
                                           Short.valueOf(A1613ConveLicDSemes) ,
                                           Short.valueOf(A1614ConveLicDAnual) ,
                                           Boolean.valueOf(A1615ConveLicAdju) ,
                                           Boolean.valueOf(A1616ConveLicAdjuObl) ,
                                           Boolean.valueOf(A1617ConveLicNecAut) ,
                                           Boolean.valueOf(A1618ConveLicIngMot) ,
                                           Boolean.valueOf(A1619ConveLicMotObl) ,
                                           Short.valueOf(A1465ConveBasePromCnt1) ,
                                           Short.valueOf(A1466ConveBasePromCnt2) ,
                                           A1565CliConvenio ,
                                           Short.valueOf(AV20OrderedBy) ,
                                           Boolean.valueOf(AV21OrderedDsc) ,
                                           Byte.valueOf(A1454ConveBaseClaseLeg) ,
                                           Byte.valueOf(AV89Convenio_base_calculowwds_1_convebaseclaseleg) ,
                                           A1455ConveBaseTipo ,
                                           AV90Convenio_base_calculowwds_2_convebasetipo ,
                                           Integer.valueOf(AV77CliCod) ,
                                           Short.valueOf(AV79PaiCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BYTE,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV112Convenio_base_calculowwds_24_tfconvebaserelref = GXutil.concat( GXutil.rtrim( AV112Convenio_base_calculowwds_24_tfconvebaserelref), "%", "") ;
      /* Using cursor P02FI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV77CliCod), Short.valueOf(AV79PaiCod), Byte.valueOf(AV89Convenio_base_calculowwds_1_convebaseclaseleg), AV90Convenio_base_calculowwds_2_convebasetipo, AV91Convenio_base_calculowwds_3_tfconvebaseplus, AV92Convenio_base_calculowwds_4_tfconvebaseplus_to, Short.valueOf(AV93Convenio_base_calculowwds_5_tfconvelicdlim), Short.valueOf(AV94Convenio_base_calculowwds_6_tfconvelicdlim_to), Byte.valueOf(AV95Convenio_base_calculowwds_7_tfconvelicdseman), Byte.valueOf(AV96Convenio_base_calculowwds_8_tfconvelicdseman_to), Short.valueOf(AV98Convenio_base_calculowwds_10_tfconvelicdsemes), Short.valueOf(AV99Convenio_base_calculowwds_11_tfconvelicdsemes_to), Short.valueOf(AV100Convenio_base_calculowwds_12_tfconvelicdanual), Short.valueOf(AV101Convenio_base_calculowwds_13_tfconvelicdanual_to), Short.valueOf(AV107Convenio_base_calculowwds_19_tfconvebasepromcnt1), Short.valueOf(AV108Convenio_base_calculowwds_20_tfconvebasepromcnt1_to), Short.valueOf(AV109Convenio_base_calculowwds_21_tfconvebasepromcnt2), Short.valueOf(AV110Convenio_base_calculowwds_22_tfconvebasepromcnt2_to), lV112Convenio_base_calculowwds_24_tfconvebaserelref, AV80CliConvenio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P02FI2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P02FI2_A1564CliPaiConve[0] ;
         A2061ConveBaseRelRef = P02FI2_A2061ConveBaseRelRef[0] ;
         A1467ConveBasePromTCnt = P02FI2_A1467ConveBasePromTCnt[0] ;
         A1466ConveBasePromCnt2 = P02FI2_A1466ConveBasePromCnt2[0] ;
         A1465ConveBasePromCnt1 = P02FI2_A1465ConveBasePromCnt1[0] ;
         A1619ConveLicMotObl = P02FI2_A1619ConveLicMotObl[0] ;
         A1618ConveLicIngMot = P02FI2_A1618ConveLicIngMot[0] ;
         A1617ConveLicNecAut = P02FI2_A1617ConveLicNecAut[0] ;
         A1616ConveLicAdjuObl = P02FI2_A1616ConveLicAdjuObl[0] ;
         A1615ConveLicAdju = P02FI2_A1615ConveLicAdju[0] ;
         A1614ConveLicDAnual = P02FI2_A1614ConveLicDAnual[0] ;
         A1613ConveLicDSemes = P02FI2_A1613ConveLicDSemes[0] ;
         A1612ConveLicDMes = P02FI2_A1612ConveLicDMes[0] ;
         A1611ConveLicDSeman = P02FI2_A1611ConveLicDSeman[0] ;
         A1610ConveLicDLim = P02FI2_A1610ConveLicDLim[0] ;
         A1458ConveBasePlus = P02FI2_A1458ConveBasePlus[0] ;
         A1454ConveBaseClaseLeg = P02FI2_A1454ConveBaseClaseLeg[0] ;
         A1456ConveBaseCod1 = P02FI2_A1456ConveBaseCod1[0] ;
         A1455ConveBaseTipo = P02FI2_A1455ConveBaseTipo[0] ;
         A3CliCod = P02FI2_A3CliCod[0] ;
         A1457ConveBaseCod2 = P02FI2_A1457ConveBaseCod2[0] ;
         GXt_char6 = A1608ConveBaseC1Txt ;
         GXv_char7[0] = GXt_char6 ;
         new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1455ConveBaseTipo, A1456ConveBaseCod1, GXv_char7) ;
         convenio_base_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
         A1608ConveBaseC1Txt = GXt_char6 ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV36VisibleColumnCount = 0 ;
         AV114GXV5 = 1 ;
         while ( AV114GXV5 <= AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV30ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV114GXV5));
            if ( AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveBaseC1Txt") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1608ConveBaseC1Txt, GXv_char7) ;
                  convenio_base_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveBaseC2Txt") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1609ConveBaseC2Txt, GXv_char7) ;
                  convenio_base_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveBasePlus") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1458ConveBasePlus)) );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveLicDLim") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setNumber( A1610ConveLicDLim );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveLicDSeman") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setNumber( A1611ConveLicDSeman );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveLicDMes") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setNumber( A1612ConveLicDMes );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveLicDSemes") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setNumber( A1613ConveLicDSemes );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveLicDAnual") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setNumber( A1614ConveLicDAnual );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveLicAdju") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1615ConveLicAdju) );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveLicAdjuObl") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1616ConveLicAdjuObl) );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveLicNecAut") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1617ConveLicNecAut) );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveLicIngMot") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1618ConveLicIngMot) );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveLicMotObl") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1619ConveLicMotObl) );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveBasePromCnt1") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setNumber( A1465ConveBasePromCnt1 );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveBasePromCnt2") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setNumber( A1466ConveBasePromCnt2 );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveBasePromTCnt") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainduracion_tipo.getDescription(httpContext,(String)A1467ConveBasePromTCnt), "") );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveBaseRelRef") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2061ConveBaseRelRef, GXv_char7) ;
                  convenio_base_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
            }
            AV114GXV5 = (int)(AV114GXV5+1) ;
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
      GXt_boolean1 = AV26IsAuthorizedConveBaseRelRef ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV77CliCod, GXv_boolean2) ;
      convenio_base_calculowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV26IsAuthorizedConveBaseRelRef = (boolean)((!GXt_boolean1)) ;
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
      AV28ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveBaseC1Txt", "", "Código 1", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveBaseC2Txt", "", "", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveBasePlus", "", "Porcentaje para plus", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveLicDLim", "", "Cantidad de días permitidos por licencia", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveLicDSeman", "", "Cantidad de días permitidos por semana", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveLicDMes", "", "Cantidad de días permitidos por semestre", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveLicDSemes", "", "Cantidad de días permitidos por semestre", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveLicDAnual", "", "Cantidad de días permitidos por año", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveLicAdju", "", "Permite adjuntar documento", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveLicAdjuObl", "", "Obliga a adjuntar documento", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveLicNecAut", "", "Necesita autorización", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveLicIngMot", "", "Permite ingresar motivo", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveLicMotObl", "", "Obliga a ingresar motivo", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveBasePromCnt1", "", "Cantidad de días/meses a promediar", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveBasePromCnt2", "", "Cantidad de días/meses a promediar segunda alternativa", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveBasePromTCnt", "", "Días o Meses", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV77CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveBaseRelRef", "", "Liberación", true, "") ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV32UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Convenio_base_calculoWWColumnsSelector", GXv_char7) ;
      convenio_base_calculowwexport.this.GXt_char6 = GXv_char7[0] ;
      AV32UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV32UserCustomValue)==0) ) )
      {
         AV29ColumnsSelectorAux.fromxml(AV32UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV29ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV22Session.getValue("Convenio_base_calculoWWGridState"), "") == 0 )
      {
         AV24GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Convenio_base_calculoWWGridState"), null, null);
      }
      else
      {
         AV24GridState.fromxml(AV22Session.getValue("Convenio_base_calculoWWGridState"), null, null);
      }
      AV20OrderedBy = AV24GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV21OrderedDsc = AV24GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV115GXV6 = 1 ;
      while ( AV115GXV6 <= AV24GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV25GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV24GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV115GXV6));
         if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASEPLUS") == 0 )
         {
            AV47TFConveBasePlus = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV48TFConveBasePlus_To = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDLIM") == 0 )
         {
            AV49TFConveLicDLim = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV50TFConveLicDLim_To = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDSEMAN") == 0 )
         {
            AV51TFConveLicDSeman = (byte)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV52TFConveLicDSeman_To = (byte)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDMES_SEL") == 0 )
         {
            AV53TFConveLicDMes_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV54TFConveLicDMes_Sels.fromJSonString(AV53TFConveLicDMes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDSEMES") == 0 )
         {
            AV56TFConveLicDSemes = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV57TFConveLicDSemes_To = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDANUAL") == 0 )
         {
            AV58TFConveLicDAnual = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV59TFConveLicDAnual_To = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICADJU_SEL") == 0 )
         {
            AV60TFConveLicAdju_Sel = (byte)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICADJUOBL_SEL") == 0 )
         {
            AV61TFConveLicAdjuObl_Sel = (byte)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICNECAUT_SEL") == 0 )
         {
            AV62TFConveLicNecAut_Sel = (byte)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICINGMOT_SEL") == 0 )
         {
            AV63TFConveLicIngMot_Sel = (byte)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICMOTOBL_SEL") == 0 )
         {
            AV64TFConveLicMotObl_Sel = (byte)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASEPROMCNT1") == 0 )
         {
            AV65TFConveBasePromCnt1 = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV66TFConveBasePromCnt1_To = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASEPROMCNT2") == 0 )
         {
            AV67TFConveBasePromCnt2 = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV68TFConveBasePromCnt2_To = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASEPROMTCNT_SEL") == 0 )
         {
            AV69TFConveBasePromTCnt_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV70TFConveBasePromTCnt_Sels.fromJSonString(AV69TFConveBasePromTCnt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASERELREF") == 0 )
         {
            AV73TFConveBaseRelRef = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASERELREF_SEL") == 0 )
         {
            AV72TFConveBaseRelRef_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV74TFConveBaseRelRef_Sels.fromJSonString(AV72TFConveBaseRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CONVEBASECLASELEG") == 0 )
         {
            AV18ConveBaseClaseLeg = (byte)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CONVEBASETIPO") == 0 )
         {
            AV19ConveBaseTipo = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV115GXV6 = (int)(AV115GXV6+1) ;
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
      this.aP0[0] = convenio_base_calculowwexport.this.AV12Filename;
      this.aP1[0] = convenio_base_calculowwexport.this.AV13ErrorMessage;
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
      AV83Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV47TFConveBasePlus = DecimalUtil.ZERO ;
      AV48TFConveBasePlus_To = DecimalUtil.ZERO ;
      AV54TFConveLicDMes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV70TFConveBasePromTCnt_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV71TFConveBasePromTCnt_Sel = "" ;
      AV74TFConveBaseRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV75TFConveBaseRelRef_Sel = "" ;
      AV73TFConveBaseRelRef = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV22Session = httpContext.getWebSession();
      AV31ColumnsSelectorXML = "" ;
      AV28ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV30ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1608ConveBaseC1Txt = "" ;
      A1609ConveBaseC2Txt = "" ;
      A1458ConveBasePlus = DecimalUtil.ZERO ;
      A1467ConveBasePromTCnt = "" ;
      A2061ConveBaseRelRef = "" ;
      AV90Convenio_base_calculowwds_2_convebasetipo = "" ;
      AV19ConveBaseTipo = "" ;
      AV91Convenio_base_calculowwds_3_tfconvebaseplus = DecimalUtil.ZERO ;
      AV92Convenio_base_calculowwds_4_tfconvebaseplus_to = DecimalUtil.ZERO ;
      AV97Convenio_base_calculowwds_9_tfconvelicdmes_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV111Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV112Convenio_base_calculowwds_24_tfconvebaserelref = "" ;
      AV113Convenio_base_calculowwds_25_tfconvebaserelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV112Convenio_base_calculowwds_24_tfconvebaserelref = "" ;
      AV80CliConvenio = "" ;
      A1565CliConvenio = "" ;
      A1455ConveBaseTipo = "" ;
      P02FI2_A1565CliConvenio = new String[] {""} ;
      P02FI2_A1564CliPaiConve = new short[1] ;
      P02FI2_A2061ConveBaseRelRef = new String[] {""} ;
      P02FI2_A1467ConveBasePromTCnt = new String[] {""} ;
      P02FI2_A1466ConveBasePromCnt2 = new short[1] ;
      P02FI2_A1465ConveBasePromCnt1 = new short[1] ;
      P02FI2_A1619ConveLicMotObl = new boolean[] {false} ;
      P02FI2_A1618ConveLicIngMot = new boolean[] {false} ;
      P02FI2_A1617ConveLicNecAut = new boolean[] {false} ;
      P02FI2_A1616ConveLicAdjuObl = new boolean[] {false} ;
      P02FI2_A1615ConveLicAdju = new boolean[] {false} ;
      P02FI2_A1614ConveLicDAnual = new short[1] ;
      P02FI2_A1613ConveLicDSemes = new short[1] ;
      P02FI2_A1612ConveLicDMes = new byte[1] ;
      P02FI2_A1611ConveLicDSeman = new byte[1] ;
      P02FI2_A1610ConveLicDLim = new short[1] ;
      P02FI2_A1458ConveBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FI2_A1454ConveBaseClaseLeg = new byte[1] ;
      P02FI2_A1456ConveBaseCod1 = new String[] {""} ;
      P02FI2_A1455ConveBaseTipo = new String[] {""} ;
      P02FI2_A3CliCod = new int[1] ;
      P02FI2_A1457ConveBaseCod2 = new String[] {""} ;
      A1456ConveBaseCod1 = "" ;
      A1457ConveBaseCod2 = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV32UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV29ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV24GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV25GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV53TFConveLicDMes_SelsJson = "" ;
      AV69TFConveBasePromTCnt_SelsJson = "" ;
      AV72TFConveBaseRelRef_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_base_calculowwexport__default(),
         new Object[] {
             new Object[] {
            P02FI2_A1565CliConvenio, P02FI2_A1564CliPaiConve, P02FI2_A2061ConveBaseRelRef, P02FI2_A1467ConveBasePromTCnt, P02FI2_A1466ConveBasePromCnt2, P02FI2_A1465ConveBasePromCnt1, P02FI2_A1619ConveLicMotObl, P02FI2_A1618ConveLicIngMot, P02FI2_A1617ConveLicNecAut, P02FI2_A1616ConveLicAdjuObl,
            P02FI2_A1615ConveLicAdju, P02FI2_A1614ConveLicDAnual, P02FI2_A1613ConveLicDSemes, P02FI2_A1612ConveLicDMes, P02FI2_A1611ConveLicDSeman, P02FI2_A1610ConveLicDLim, P02FI2_A1458ConveBasePlus, P02FI2_A1454ConveBaseClaseLeg, P02FI2_A1456ConveBaseCod1, P02FI2_A1455ConveBaseTipo,
            P02FI2_A3CliCod, P02FI2_A1457ConveBaseCod2
            }
         }
      );
      AV83Pgmname = "Convenio_base_calculoWWExport" ;
      /* GeneXus formulas. */
      AV83Pgmname = "Convenio_base_calculoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV51TFConveLicDSeman ;
   private byte AV52TFConveLicDSeman_To ;
   private byte AV55TFConveLicDMes_Sel ;
   private byte AV60TFConveLicAdju_Sel ;
   private byte AV61TFConveLicAdjuObl_Sel ;
   private byte AV62TFConveLicNecAut_Sel ;
   private byte AV63TFConveLicIngMot_Sel ;
   private byte AV64TFConveLicMotObl_Sel ;
   private byte A1611ConveLicDSeman ;
   private byte A1612ConveLicDMes ;
   private byte AV89Convenio_base_calculowwds_1_convebaseclaseleg ;
   private byte AV18ConveBaseClaseLeg ;
   private byte AV95Convenio_base_calculowwds_7_tfconvelicdseman ;
   private byte AV96Convenio_base_calculowwds_8_tfconvelicdseman_to ;
   private byte AV102Convenio_base_calculowwds_14_tfconvelicadju_sel ;
   private byte AV103Convenio_base_calculowwds_15_tfconvelicadjuobl_sel ;
   private byte AV104Convenio_base_calculowwds_16_tfconvelicnecaut_sel ;
   private byte AV105Convenio_base_calculowwds_17_tfconvelicingmot_sel ;
   private byte AV106Convenio_base_calculowwds_18_tfconvelicmotobl_sel ;
   private byte A1454ConveBaseClaseLeg ;
   private short AV49TFConveLicDLim ;
   private short AV50TFConveLicDLim_To ;
   private short AV56TFConveLicDSemes ;
   private short AV57TFConveLicDSemes_To ;
   private short AV58TFConveLicDAnual ;
   private short AV59TFConveLicDAnual_To ;
   private short AV65TFConveBasePromCnt1 ;
   private short AV66TFConveBasePromCnt1_To ;
   private short AV67TFConveBasePromCnt2 ;
   private short AV68TFConveBasePromCnt2_To ;
   private short GXv_int5[] ;
   private short A1610ConveLicDLim ;
   private short A1613ConveLicDSemes ;
   private short A1614ConveLicDAnual ;
   private short A1465ConveBasePromCnt1 ;
   private short A1466ConveBasePromCnt2 ;
   private short AV93Convenio_base_calculowwds_5_tfconvelicdlim ;
   private short AV94Convenio_base_calculowwds_6_tfconvelicdlim_to ;
   private short AV98Convenio_base_calculowwds_10_tfconvelicdsemes ;
   private short AV99Convenio_base_calculowwds_11_tfconvelicdsemes_to ;
   private short AV100Convenio_base_calculowwds_12_tfconvelicdanual ;
   private short AV101Convenio_base_calculowwds_13_tfconvelicdanual_to ;
   private short AV107Convenio_base_calculowwds_19_tfconvebasepromcnt1 ;
   private short AV108Convenio_base_calculowwds_20_tfconvebasepromcnt1_to ;
   private short AV109Convenio_base_calculowwds_21_tfconvebasepromcnt2 ;
   private short AV110Convenio_base_calculowwds_22_tfconvebasepromcnt2_to ;
   private short AV20OrderedBy ;
   private short AV79PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV84GXV1 ;
   private int AV85GXV2 ;
   private int AV86GXV3 ;
   private int AV87GXV4 ;
   private int AV97Convenio_base_calculowwds_9_tfconvelicdmes_sels_size ;
   private int AV111Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels_size ;
   private int AV113Convenio_base_calculowwds_25_tfconvebaserelref_sels_size ;
   private int AV77CliCod ;
   private int A3CliCod ;
   private int AV114GXV5 ;
   private int AV115GXV6 ;
   private long AV76i ;
   private long AV36VisibleColumnCount ;
   private java.math.BigDecimal AV47TFConveBasePlus ;
   private java.math.BigDecimal AV48TFConveBasePlus_To ;
   private java.math.BigDecimal A1458ConveBasePlus ;
   private java.math.BigDecimal AV91Convenio_base_calculowwds_3_tfconvebaseplus ;
   private java.math.BigDecimal AV92Convenio_base_calculowwds_4_tfconvebaseplus_to ;
   private String AV83Pgmname ;
   private String AV71TFConveBasePromTCnt_Sel ;
   private String A1467ConveBasePromTCnt ;
   private String AV90Convenio_base_calculowwds_2_convebasetipo ;
   private String AV19ConveBaseTipo ;
   private String scmdbuf ;
   private String AV80CliConvenio ;
   private String A1565CliConvenio ;
   private String A1455ConveBaseTipo ;
   private String A1456ConveBaseCod1 ;
   private String A1457ConveBaseCod2 ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV26IsAuthorizedConveBaseRelRef ;
   private boolean A1615ConveLicAdju ;
   private boolean A1616ConveLicAdjuObl ;
   private boolean A1617ConveLicNecAut ;
   private boolean A1618ConveLicIngMot ;
   private boolean A1619ConveLicMotObl ;
   private boolean AV21OrderedDsc ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean Cond_result ;
   private String AV31ColumnsSelectorXML ;
   private String AV32UserCustomValue ;
   private String AV53TFConveLicDMes_SelsJson ;
   private String AV69TFConveBasePromTCnt_SelsJson ;
   private String AV72TFConveBaseRelRef_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV75TFConveBaseRelRef_Sel ;
   private String AV73TFConveBaseRelRef ;
   private String A1608ConveBaseC1Txt ;
   private String A1609ConveBaseC2Txt ;
   private String A2061ConveBaseRelRef ;
   private String AV112Convenio_base_calculowwds_24_tfconvebaserelref ;
   private String lV112Convenio_base_calculowwds_24_tfconvebaserelref ;
   private String AV17MenuOpcCod ;
   private GXSimpleCollection<Byte> AV54TFConveLicDMes_Sels ;
   private GXSimpleCollection<Byte> AV97Convenio_base_calculowwds_9_tfconvelicdmes_sels ;
   private com.genexus.webpanels.WebSession AV22Session ;
   private GXSimpleCollection<String> AV70TFConveBasePromTCnt_Sels ;
   private GXSimpleCollection<String> AV74TFConveBaseRelRef_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P02FI2_A1565CliConvenio ;
   private short[] P02FI2_A1564CliPaiConve ;
   private String[] P02FI2_A2061ConveBaseRelRef ;
   private String[] P02FI2_A1467ConveBasePromTCnt ;
   private short[] P02FI2_A1466ConveBasePromCnt2 ;
   private short[] P02FI2_A1465ConveBasePromCnt1 ;
   private boolean[] P02FI2_A1619ConveLicMotObl ;
   private boolean[] P02FI2_A1618ConveLicIngMot ;
   private boolean[] P02FI2_A1617ConveLicNecAut ;
   private boolean[] P02FI2_A1616ConveLicAdjuObl ;
   private boolean[] P02FI2_A1615ConveLicAdju ;
   private short[] P02FI2_A1614ConveLicDAnual ;
   private short[] P02FI2_A1613ConveLicDSemes ;
   private byte[] P02FI2_A1612ConveLicDMes ;
   private byte[] P02FI2_A1611ConveLicDSeman ;
   private short[] P02FI2_A1610ConveLicDLim ;
   private java.math.BigDecimal[] P02FI2_A1458ConveBasePlus ;
   private byte[] P02FI2_A1454ConveBaseClaseLeg ;
   private String[] P02FI2_A1456ConveBaseCod1 ;
   private String[] P02FI2_A1455ConveBaseTipo ;
   private int[] P02FI2_A3CliCod ;
   private String[] P02FI2_A1457ConveBaseCod2 ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV111Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels ;
   private GXSimpleCollection<String> AV113Convenio_base_calculowwds_25_tfconvebaserelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV24GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV25GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV28ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV29ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV30ColumnsSelector_Column ;
}

final  class convenio_base_calculowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FI2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A1612ConveLicDMes ,
                                          GXSimpleCollection<Byte> AV97Convenio_base_calculowwds_9_tfconvelicdmes_sels ,
                                          String A1467ConveBasePromTCnt ,
                                          GXSimpleCollection<String> AV111Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels ,
                                          String A2061ConveBaseRelRef ,
                                          GXSimpleCollection<String> AV113Convenio_base_calculowwds_25_tfconvebaserelref_sels ,
                                          java.math.BigDecimal AV91Convenio_base_calculowwds_3_tfconvebaseplus ,
                                          java.math.BigDecimal AV92Convenio_base_calculowwds_4_tfconvebaseplus_to ,
                                          short AV93Convenio_base_calculowwds_5_tfconvelicdlim ,
                                          short AV94Convenio_base_calculowwds_6_tfconvelicdlim_to ,
                                          byte AV95Convenio_base_calculowwds_7_tfconvelicdseman ,
                                          byte AV96Convenio_base_calculowwds_8_tfconvelicdseman_to ,
                                          int AV97Convenio_base_calculowwds_9_tfconvelicdmes_sels_size ,
                                          short AV98Convenio_base_calculowwds_10_tfconvelicdsemes ,
                                          short AV99Convenio_base_calculowwds_11_tfconvelicdsemes_to ,
                                          short AV100Convenio_base_calculowwds_12_tfconvelicdanual ,
                                          short AV101Convenio_base_calculowwds_13_tfconvelicdanual_to ,
                                          byte AV102Convenio_base_calculowwds_14_tfconvelicadju_sel ,
                                          byte AV103Convenio_base_calculowwds_15_tfconvelicadjuobl_sel ,
                                          byte AV104Convenio_base_calculowwds_16_tfconvelicnecaut_sel ,
                                          byte AV105Convenio_base_calculowwds_17_tfconvelicingmot_sel ,
                                          byte AV106Convenio_base_calculowwds_18_tfconvelicmotobl_sel ,
                                          short AV107Convenio_base_calculowwds_19_tfconvebasepromcnt1 ,
                                          short AV108Convenio_base_calculowwds_20_tfconvebasepromcnt1_to ,
                                          short AV109Convenio_base_calculowwds_21_tfconvebasepromcnt2 ,
                                          short AV110Convenio_base_calculowwds_22_tfconvebasepromcnt2_to ,
                                          int AV111Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels_size ,
                                          int AV113Convenio_base_calculowwds_25_tfconvebaserelref_sels_size ,
                                          String AV112Convenio_base_calculowwds_24_tfconvebaserelref ,
                                          String AV80CliConvenio ,
                                          java.math.BigDecimal A1458ConveBasePlus ,
                                          short A1610ConveLicDLim ,
                                          byte A1611ConveLicDSeman ,
                                          short A1613ConveLicDSemes ,
                                          short A1614ConveLicDAnual ,
                                          boolean A1615ConveLicAdju ,
                                          boolean A1616ConveLicAdjuObl ,
                                          boolean A1617ConveLicNecAut ,
                                          boolean A1618ConveLicIngMot ,
                                          boolean A1619ConveLicMotObl ,
                                          short A1465ConveBasePromCnt1 ,
                                          short A1466ConveBasePromCnt2 ,
                                          String A1565CliConvenio ,
                                          short AV20OrderedBy ,
                                          boolean AV21OrderedDsc ,
                                          byte A1454ConveBaseClaseLeg ,
                                          byte AV89Convenio_base_calculowwds_1_convebaseclaseleg ,
                                          String A1455ConveBaseTipo ,
                                          String AV90Convenio_base_calculowwds_2_convebasetipo ,
                                          int AV77CliCod ,
                                          short AV79PaiCod ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[20];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliPaiConve, ConveBaseRelRef, ConveBasePromTCnt, ConveBasePromCnt2, ConveBasePromCnt1, ConveLicMotObl, ConveLicIngMot, ConveLicNecAut, ConveLicAdjuObl," ;
      scmdbuf += " ConveLicAdju, ConveLicDAnual, ConveLicDSemes, ConveLicDMes, ConveLicDSeman, ConveLicDLim, ConveBasePlus, ConveBaseClaseLeg, ConveBaseCod1, ConveBaseTipo, CliCod," ;
      scmdbuf += " ConveBaseCod2 FROM Convenio_base_calculo" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ?)");
      addWhere(sWhereString, "(ConveBaseClaseLeg = ?)");
      addWhere(sWhereString, "(ConveBaseTipo = ( ?))");
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV91Convenio_base_calculowwds_3_tfconvebaseplus)==0) )
      {
         addWhere(sWhereString, "(ConveBasePlus >= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV92Convenio_base_calculowwds_4_tfconvebaseplus_to)==0) )
      {
         addWhere(sWhereString, "(ConveBasePlus <= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV93Convenio_base_calculowwds_5_tfconvelicdlim) )
      {
         addWhere(sWhereString, "(ConveLicDLim >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (0==AV94Convenio_base_calculowwds_6_tfconvelicdlim_to) )
      {
         addWhere(sWhereString, "(ConveLicDLim <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( ! (0==AV95Convenio_base_calculowwds_7_tfconvelicdseman) )
      {
         addWhere(sWhereString, "(ConveLicDSeman >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (0==AV96Convenio_base_calculowwds_8_tfconvelicdseman_to) )
      {
         addWhere(sWhereString, "(ConveLicDSeman <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( AV97Convenio_base_calculowwds_9_tfconvelicdmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Convenio_base_calculowwds_9_tfconvelicdmes_sels, "ConveLicDMes IN (", ")")+")");
      }
      if ( ! (0==AV98Convenio_base_calculowwds_10_tfconvelicdsemes) )
      {
         addWhere(sWhereString, "(ConveLicDSemes >= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (0==AV99Convenio_base_calculowwds_11_tfconvelicdsemes_to) )
      {
         addWhere(sWhereString, "(ConveLicDSemes <= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (0==AV100Convenio_base_calculowwds_12_tfconvelicdanual) )
      {
         addWhere(sWhereString, "(ConveLicDAnual >= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (0==AV101Convenio_base_calculowwds_13_tfconvelicdanual_to) )
      {
         addWhere(sWhereString, "(ConveLicDAnual <= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( AV102Convenio_base_calculowwds_14_tfconvelicadju_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicAdju = TRUE)");
      }
      if ( AV102Convenio_base_calculowwds_14_tfconvelicadju_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicAdju = FALSE)");
      }
      if ( AV103Convenio_base_calculowwds_15_tfconvelicadjuobl_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicAdjuObl = TRUE)");
      }
      if ( AV103Convenio_base_calculowwds_15_tfconvelicadjuobl_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicAdjuObl = FALSE)");
      }
      if ( AV104Convenio_base_calculowwds_16_tfconvelicnecaut_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicNecAut = TRUE)");
      }
      if ( AV104Convenio_base_calculowwds_16_tfconvelicnecaut_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicNecAut = FALSE)");
      }
      if ( AV105Convenio_base_calculowwds_17_tfconvelicingmot_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicIngMot = TRUE)");
      }
      if ( AV105Convenio_base_calculowwds_17_tfconvelicingmot_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicIngMot = FALSE)");
      }
      if ( AV106Convenio_base_calculowwds_18_tfconvelicmotobl_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicMotObl = TRUE)");
      }
      if ( AV106Convenio_base_calculowwds_18_tfconvelicmotobl_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicMotObl = FALSE)");
      }
      if ( ! (0==AV107Convenio_base_calculowwds_19_tfconvebasepromcnt1) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt1 >= ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (0==AV108Convenio_base_calculowwds_20_tfconvebasepromcnt1_to) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt1 <= ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (0==AV109Convenio_base_calculowwds_21_tfconvebasepromcnt2) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt2 >= ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (0==AV110Convenio_base_calculowwds_22_tfconvebasepromcnt2_to) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt2 <= ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( AV111Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV111Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels, "ConveBasePromTCnt IN (", ")")+")");
      }
      if ( ( AV113Convenio_base_calculowwds_25_tfconvebaserelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV112Convenio_base_calculowwds_24_tfconvebaserelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveBaseRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( AV113Convenio_base_calculowwds_25_tfconvebaserelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV113Convenio_base_calculowwds_25_tfconvebaserelref_sels, "ConveBaseRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV80CliConvenio)==0) )
      {
         addWhere(sWhereString, "(CliConvenio = ( ?))");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV20OrderedBy == 1 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveBasePlus" ;
      }
      else if ( ( AV20OrderedBy == 1 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveBasePlus DESC" ;
      }
      else if ( ( AV20OrderedBy == 2 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicDLim" ;
      }
      else if ( ( AV20OrderedBy == 2 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicDLim DESC" ;
      }
      else if ( ( AV20OrderedBy == 3 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicDSeman" ;
      }
      else if ( ( AV20OrderedBy == 3 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicDSeman DESC" ;
      }
      else if ( ( AV20OrderedBy == 4 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicDMes" ;
      }
      else if ( ( AV20OrderedBy == 4 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicDMes DESC" ;
      }
      else if ( ( AV20OrderedBy == 5 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicDSemes" ;
      }
      else if ( ( AV20OrderedBy == 5 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicDSemes DESC" ;
      }
      else if ( ( AV20OrderedBy == 6 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicDAnual" ;
      }
      else if ( ( AV20OrderedBy == 6 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicDAnual DESC" ;
      }
      else if ( ( AV20OrderedBy == 7 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicAdju" ;
      }
      else if ( ( AV20OrderedBy == 7 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicAdju DESC" ;
      }
      else if ( ( AV20OrderedBy == 8 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicAdjuObl" ;
      }
      else if ( ( AV20OrderedBy == 8 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicAdjuObl DESC" ;
      }
      else if ( ( AV20OrderedBy == 9 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicNecAut" ;
      }
      else if ( ( AV20OrderedBy == 9 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicNecAut DESC" ;
      }
      else if ( ( AV20OrderedBy == 10 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicIngMot" ;
      }
      else if ( ( AV20OrderedBy == 10 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicIngMot DESC" ;
      }
      else if ( ( AV20OrderedBy == 11 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicMotObl" ;
      }
      else if ( ( AV20OrderedBy == 11 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicMotObl DESC" ;
      }
      else if ( ( AV20OrderedBy == 12 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveBasePromCnt1" ;
      }
      else if ( ( AV20OrderedBy == 12 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveBasePromCnt1 DESC" ;
      }
      else if ( ( AV20OrderedBy == 13 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveBasePromCnt2" ;
      }
      else if ( ( AV20OrderedBy == 13 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveBasePromCnt2 DESC" ;
      }
      else if ( ( AV20OrderedBy == 14 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveBasePromTCnt" ;
      }
      else if ( ( AV20OrderedBy == 14 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveBasePromTCnt DESC" ;
      }
      else if ( ( AV20OrderedBy == 15 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveBaseRelRef" ;
      }
      else if ( ( AV20OrderedBy == 15 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveBaseRelRef DESC" ;
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
                  return conditional_P02FI2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).byteValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).byteValue() , ((Number) dynConstraints[33]).shortValue() , ((Number) dynConstraints[34]).shortValue() , ((Boolean) dynConstraints[35]).booleanValue() , ((Boolean) dynConstraints[36]).booleanValue() , ((Boolean) dynConstraints[37]).booleanValue() , ((Boolean) dynConstraints[38]).booleanValue() , ((Boolean) dynConstraints[39]).booleanValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (String)dynConstraints[42] , ((Number) dynConstraints[43]).shortValue() , ((Boolean) dynConstraints[44]).booleanValue() , ((Number) dynConstraints[45]).byteValue() , ((Number) dynConstraints[46]).byteValue() , (String)dynConstraints[47] , (String)dynConstraints[48] , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).shortValue() , ((Number) dynConstraints[51]).intValue() , ((Number) dynConstraints[52]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FI2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((byte[]) buf[14])[0] = rslt.getByte(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(17,4);
               ((byte[]) buf[17])[0] = rslt.getByte(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               ((String[]) buf[19])[0] = rslt.getString(20, 20);
               ((int[]) buf[20])[0] = rslt.getInt(21);
               ((String[]) buf[21])[0] = rslt.getString(22, 20);
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
                  stmt.setShort(sIdx, ((Number) parms[26]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[27]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[28]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[29]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[30]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[31]).shortValue());
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
                  stmt.setVarchar(sIdx, (String)parms[38], 40);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[39], 20);
               }
               return;
      }
   }

}

