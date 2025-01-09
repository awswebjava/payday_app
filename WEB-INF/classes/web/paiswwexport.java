package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paiswwexport extends GXProcedure
{
   public paiswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paiswwexport.class ), "" );
   }

   public paiswwexport( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      paiswwexport.this.aP1 = new String[] {""};
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
      paiswwexport.this.aP0 = aP0;
      paiswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais", GXv_boolean2) ;
      paiswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV76Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "PaisWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV35TFPaiCod) && (0==AV36TFPaiCod_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cod. Pais", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFPaiCod );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFPaiCod_To );
      }
      if ( ! ( ( AV39TFPaiNom_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nom. Pais", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV66i = 1 ;
         AV77GXV1 = 1 ;
         while ( AV77GXV1 <= AV39TFPaiNom_Sels.size() )
         {
            AV40TFPaiNom_Sel = (String)AV39TFPaiNom_Sels.elementAt(-1+AV77GXV1) ;
            if ( AV66i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFPaiNom_Sel, GXv_char7) ;
            paiswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV66i = (long)(AV66i+1) ;
            AV77GXV1 = (int)(AV77GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV38TFPaiNom)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nom. Pais", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            paiswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFPaiNom, GXv_char7) ;
            paiswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV43TFPaiReligDefault_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Relig Default", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV66i = 1 ;
         AV78GXV2 = 1 ;
         while ( AV78GXV2 <= AV43TFPaiReligDefault_Sels.size() )
         {
            AV44TFPaiReligDefault_Sel = (String)AV43TFPaiReligDefault_Sels.elementAt(-1+AV78GXV2) ;
            if ( AV66i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFPaiReligDefault_Sel, GXv_char7) ;
            paiswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV66i = (long)(AV66i+1) ;
            AV78GXV2 = (int)(AV78GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV42TFPaiReligDefault)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Relig Default", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            paiswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFPaiReligDefault, GXv_char7) ;
            paiswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFPaiMesHsPExt)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFPaiMesHsPExt_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de horas del mes para cálculo 1 hora de trabajo para empleados de clase mensual", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV45TFPaiMesHsPExt)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV46TFPaiMesHsPExt_To)) );
      }
      if ( ! ( ( AV48TFPaiDiaHsPExt_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Días habiles del mes para obtener cantidad de horas del mes para cálculo de 1 hora de trabajo para empleados de clase mensual", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV66i = 1 ;
         AV79GXV3 = 1 ;
         while ( AV79GXV3 <= AV48TFPaiDiaHsPExt_Sels.size() )
         {
            AV49TFPaiDiaHsPExt_Sel = (String)AV48TFPaiDiaHsPExt_Sels.elementAt(-1+AV79GXV3) ;
            if ( AV66i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainalgoritmodiasmeshsext.getDescription(httpContext,(String)AV49TFPaiDiaHsPExt_Sel), "") );
            AV66i = (long)(AV66i+1) ;
            AV79GXV3 = (int)(AV79GXV3+1) ;
         }
      }
      if ( ! ( (0==AV50TFPaiFondoCese_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV50TFPaiFondoCese_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV50TFPaiFondoCese_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFPaiMaxHorNor)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFPaiMaxHorNor_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Máximo de horas normales por día", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV51TFPaiMaxHorNor)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV52TFPaiMaxHorNor_To)) );
      }
      if ( ! ( ( AV54TFPaiPerVacDes_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Periodo de vacaciones desde", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV66i = 1 ;
         AV80GXV4 = 1 ;
         while ( AV80GXV4 <= AV54TFPaiPerVacDes_Sels.size() )
         {
            AV55TFPaiPerVacDes_Sel = ((Number) AV54TFPaiPerVacDes_Sels.elementAt(-1+AV80GXV4)).byteValue() ;
            if ( AV66i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainmes.getDescription(httpContext,(byte)AV55TFPaiPerVacDes_Sel), "") );
            AV66i = (long)(AV66i+1) ;
            AV80GXV4 = (int)(AV80GXV4+1) ;
         }
      }
      if ( ! ( ( AV57TFPaiPerVacHas_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Periodo de vacaciones hasta", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV66i = 1 ;
         AV81GXV5 = 1 ;
         while ( AV81GXV5 <= AV57TFPaiPerVacHas_Sels.size() )
         {
            AV58TFPaiPerVacHas_Sel = ((Number) AV57TFPaiPerVacHas_Sels.elementAt(-1+AV81GXV5)).byteValue() ;
            if ( AV66i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainmes.getDescription(httpContext,(byte)AV58TFPaiPerVacHas_Sel), "") );
            AV66i = (long)(AV66i+1) ;
            AV81GXV5 = (int)(AV81GXV5+1) ;
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV69TFPaiFracVacAnt)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV70TFPaiFracVacAnt_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Proporción de días de vacaciones disponibles pendientes de goce del año anterior", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV69TFPaiFracVacAnt)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV70TFPaiFracVacAnt_To)) );
      }
      if ( ! ( (0==AV59TFPaiGuarEdadMin) && (0==AV60TFPaiGuarEdadMin_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV59TFPaiGuarEdadMin );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV60TFPaiGuarEdadMin_To );
      }
      if ( ! ( (0==AV61TFPaiGuarEdadMax) && (0==AV62TFPaiGuarEdadMax_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Edad máxima del hijo/hija hasta la que puede gozar el beneficio de guardería", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV61TFPaiGuarEdadMax );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV62TFPaiGuarEdadMax_To );
      }
      if ( ! ( (0==AV63TFPaiExcVizzoti_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Considerar excepción a uso de tope (fallo Vizzoti)", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV63TFPaiExcVizzoti_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV63TFPaiExcVizzoti_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFPaiVizzoti)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFPaiVizzoti_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Proporción de sueldo para evaluar tope (fallo Vizzoti)", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV64TFPaiVizzoti)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paiswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV65TFPaiVizzoti_To)) );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("PaisWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("PaisWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV82GXV6 = 1 ;
      while ( AV82GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV82GXV6));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV82GXV6 = (int)(AV82GXV6+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV84Paiswwds_1_tfpaicod = AV35TFPaiCod ;
      AV85Paiswwds_2_tfpaicod_to = AV36TFPaiCod_To ;
      AV86Paiswwds_3_tfpainom = AV38TFPaiNom ;
      AV87Paiswwds_4_tfpainom_sels = AV39TFPaiNom_Sels ;
      AV88Paiswwds_5_tfpaireligdefault = AV42TFPaiReligDefault ;
      AV89Paiswwds_6_tfpaireligdefault_sels = AV43TFPaiReligDefault_Sels ;
      AV90Paiswwds_7_tfpaimeshspext = AV45TFPaiMesHsPExt ;
      AV91Paiswwds_8_tfpaimeshspext_to = AV46TFPaiMesHsPExt_To ;
      AV92Paiswwds_9_tfpaidiahspext_sels = AV48TFPaiDiaHsPExt_Sels ;
      AV93Paiswwds_10_tfpaifondocese_sel = AV50TFPaiFondoCese_Sel ;
      AV94Paiswwds_11_tfpaimaxhornor = AV51TFPaiMaxHorNor ;
      AV95Paiswwds_12_tfpaimaxhornor_to = AV52TFPaiMaxHorNor_To ;
      AV96Paiswwds_13_tfpaipervacdes_sels = AV54TFPaiPerVacDes_Sels ;
      AV97Paiswwds_14_tfpaipervachas_sels = AV57TFPaiPerVacHas_Sels ;
      AV98Paiswwds_15_tfpaifracvacant = AV69TFPaiFracVacAnt ;
      AV99Paiswwds_16_tfpaifracvacant_to = AV70TFPaiFracVacAnt_To ;
      AV100Paiswwds_17_tfpaiguaredadmin = AV59TFPaiGuarEdadMin ;
      AV101Paiswwds_18_tfpaiguaredadmin_to = AV60TFPaiGuarEdadMin_To ;
      AV102Paiswwds_19_tfpaiguaredadmax = AV61TFPaiGuarEdadMax ;
      AV103Paiswwds_20_tfpaiguaredadmax_to = AV62TFPaiGuarEdadMax_To ;
      AV104Paiswwds_21_tfpaiexcvizzoti_sel = AV63TFPaiExcVizzoti_Sel ;
      AV105Paiswwds_22_tfpaivizzoti = AV64TFPaiVizzoti ;
      AV106Paiswwds_23_tfpaivizzoti_to = AV65TFPaiVizzoti_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A312PaiNom ,
                                           AV87Paiswwds_4_tfpainom_sels ,
                                           A1252PaiReligDefault ,
                                           AV89Paiswwds_6_tfpaireligdefault_sels ,
                                           A1272PaiDiaHsPExt ,
                                           AV92Paiswwds_9_tfpaidiahspext_sels ,
                                           Byte.valueOf(A1521PaiPerVacDes) ,
                                           AV96Paiswwds_13_tfpaipervacdes_sels ,
                                           Byte.valueOf(A1522PaiPerVacHas) ,
                                           AV97Paiswwds_14_tfpaipervachas_sels ,
                                           Short.valueOf(AV84Paiswwds_1_tfpaicod) ,
                                           Short.valueOf(AV85Paiswwds_2_tfpaicod_to) ,
                                           Integer.valueOf(AV87Paiswwds_4_tfpainom_sels.size()) ,
                                           AV86Paiswwds_3_tfpainom ,
                                           Integer.valueOf(AV89Paiswwds_6_tfpaireligdefault_sels.size()) ,
                                           AV88Paiswwds_5_tfpaireligdefault ,
                                           AV90Paiswwds_7_tfpaimeshspext ,
                                           AV91Paiswwds_8_tfpaimeshspext_to ,
                                           Integer.valueOf(AV92Paiswwds_9_tfpaidiahspext_sels.size()) ,
                                           Byte.valueOf(AV93Paiswwds_10_tfpaifondocese_sel) ,
                                           AV94Paiswwds_11_tfpaimaxhornor ,
                                           AV95Paiswwds_12_tfpaimaxhornor_to ,
                                           Integer.valueOf(AV96Paiswwds_13_tfpaipervacdes_sels.size()) ,
                                           Integer.valueOf(AV97Paiswwds_14_tfpaipervachas_sels.size()) ,
                                           AV98Paiswwds_15_tfpaifracvacant ,
                                           AV99Paiswwds_16_tfpaifracvacant_to ,
                                           Byte.valueOf(AV100Paiswwds_17_tfpaiguaredadmin) ,
                                           Byte.valueOf(AV101Paiswwds_18_tfpaiguaredadmin_to) ,
                                           Byte.valueOf(AV102Paiswwds_19_tfpaiguaredadmax) ,
                                           Byte.valueOf(AV103Paiswwds_20_tfpaiguaredadmax_to) ,
                                           Byte.valueOf(AV104Paiswwds_21_tfpaiexcvizzoti_sel) ,
                                           AV105Paiswwds_22_tfpaivizzoti ,
                                           AV106Paiswwds_23_tfpaivizzoti_to ,
                                           Short.valueOf(A46PaiCod) ,
                                           A1271PaiMesHsPExt ,
                                           Boolean.valueOf(A1402PaiFondoCese) ,
                                           A1405PaiMaxHorNor ,
                                           A1814PaiFracVacAnt ,
                                           Byte.valueOf(A1625PaiGuarEdadMin) ,
                                           Byte.valueOf(A1626PaiGuarEdadMax) ,
                                           Boolean.valueOf(A1736PaiExcVizzoti) ,
                                           A1737PaiVizzoti ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                           TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV86Paiswwds_3_tfpainom = GXutil.concat( GXutil.rtrim( AV86Paiswwds_3_tfpainom), "%", "") ;
      lV88Paiswwds_5_tfpaireligdefault = GXutil.padr( GXutil.rtrim( AV88Paiswwds_5_tfpaireligdefault), 20, "%") ;
      /* Using cursor P01JR2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV84Paiswwds_1_tfpaicod), Short.valueOf(AV85Paiswwds_2_tfpaicod_to), lV86Paiswwds_3_tfpainom, lV88Paiswwds_5_tfpaireligdefault, AV90Paiswwds_7_tfpaimeshspext, AV91Paiswwds_8_tfpaimeshspext_to, AV94Paiswwds_11_tfpaimaxhornor, AV95Paiswwds_12_tfpaimaxhornor_to, AV98Paiswwds_15_tfpaifracvacant, AV99Paiswwds_16_tfpaifracvacant_to, Byte.valueOf(AV100Paiswwds_17_tfpaiguaredadmin), Byte.valueOf(AV101Paiswwds_18_tfpaiguaredadmin_to), Byte.valueOf(AV102Paiswwds_19_tfpaiguaredadmax), Byte.valueOf(AV103Paiswwds_20_tfpaiguaredadmax_to), AV105Paiswwds_22_tfpaivizzoti, AV106Paiswwds_23_tfpaivizzoti_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1737PaiVizzoti = P01JR2_A1737PaiVizzoti[0] ;
         A1736PaiExcVizzoti = P01JR2_A1736PaiExcVizzoti[0] ;
         A1626PaiGuarEdadMax = P01JR2_A1626PaiGuarEdadMax[0] ;
         A1625PaiGuarEdadMin = P01JR2_A1625PaiGuarEdadMin[0] ;
         A1814PaiFracVacAnt = P01JR2_A1814PaiFracVacAnt[0] ;
         A1522PaiPerVacHas = P01JR2_A1522PaiPerVacHas[0] ;
         A1521PaiPerVacDes = P01JR2_A1521PaiPerVacDes[0] ;
         A1405PaiMaxHorNor = P01JR2_A1405PaiMaxHorNor[0] ;
         A1402PaiFondoCese = P01JR2_A1402PaiFondoCese[0] ;
         A1272PaiDiaHsPExt = P01JR2_A1272PaiDiaHsPExt[0] ;
         A1271PaiMesHsPExt = P01JR2_A1271PaiMesHsPExt[0] ;
         A1252PaiReligDefault = P01JR2_A1252PaiReligDefault[0] ;
         n1252PaiReligDefault = P01JR2_n1252PaiReligDefault[0] ;
         A312PaiNom = P01JR2_A312PaiNom[0] ;
         A46PaiCod = P01JR2_A46PaiCod[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         AV107GXV7 = 1 ;
         while ( AV107GXV7 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV107GXV7));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A46PaiCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiNom") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A312PaiNom, GXv_char7) ;
                  paiswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiReligDefault") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1252PaiReligDefault, GXv_char7) ;
                  paiswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiMesHsPExt") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1271PaiMesHsPExt)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiDiaHsPExt") == 0 )
               {
                  if ( ! (GXutil.strcmp("", A1272PaiDiaHsPExt)==0) )
                  {
                     AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainalgoritmodiasmeshsext.getDescription(httpContext,(String)A1272PaiDiaHsPExt), "") );
                  }
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiFondoCese") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1402PaiFondoCese) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiMaxHorNor") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1405PaiMaxHorNor)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiPerVacDes") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainmes.getDescription(httpContext,(byte)A1521PaiPerVacDes), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiPerVacHas") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainmes.getDescription(httpContext,(byte)A1522PaiPerVacHas), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiFracVacAnt") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1814PaiFracVacAnt)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiGuarEdadMin") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1625PaiGuarEdadMin );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiGuarEdadMax") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1626PaiGuarEdadMax );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiExcVizzoti") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1736PaiExcVizzoti) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiVizzoti") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1737PaiVizzoti)) );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV107GXV7 = (int)(AV107GXV7+1) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiCod", "", "Cod. Pais", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiNom", "", "Nom. Pais", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiReligDefault", "", "Relig Default", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiMesHsPExt", "", "Cantidad de horas del mes para cálculo 1 hora de trabajo para empleados de clase mensual", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiDiaHsPExt", "", "Días habiles del mes para obtener cantidad de horas del mes para cálculo de 1 hora de trabajo para empleados de clase mensual", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiFondoCese", "", "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiMaxHorNor", "", "Máximo de horas normales por día", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiPerVacDes", "", "Periodo de vacaciones desde", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiPerVacHas", "", "Periodo de vacaciones hasta", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiFracVacAnt", "", "Proporción de días de vacaciones disponibles pendientes de goce del año anterior", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiGuarEdadMin", "", "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiGuarEdadMax", "", "Edad máxima del hijo/hija hasta la que puede gozar el beneficio de guardería", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiExcVizzoti", "", "Considerar excepción a uso de tope (fallo Vizzoti)", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiVizzoti", "", "Proporción de sueldo para evaluar tope (fallo Vizzoti)", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( new web.esconceptosdefault(remoteHandle, context).executeUdp( ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "PaisWWColumnsSelector", GXv_char7) ;
      paiswwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("PaisWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PaisWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("PaisWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV108GXV8 = 1 ;
      while ( AV108GXV8 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV108GXV8));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAICOD") == 0 )
         {
            AV35TFPaiCod = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFPaiCod_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAINOM") == 0 )
         {
            AV38TFPaiNom = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAINOM_SEL") == 0 )
         {
            AV37TFPaiNom_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFPaiNom_Sels.fromJSonString(AV37TFPaiNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIRELIGDEFAULT") == 0 )
         {
            AV42TFPaiReligDefault = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIRELIGDEFAULT_SEL") == 0 )
         {
            AV41TFPaiReligDefault_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFPaiReligDefault_Sels.fromJSonString(AV41TFPaiReligDefault_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIMESHSPEXT") == 0 )
         {
            AV45TFPaiMesHsPExt = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV46TFPaiMesHsPExt_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIDIAHSPEXT_SEL") == 0 )
         {
            AV47TFPaiDiaHsPExt_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFPaiDiaHsPExt_Sels.fromJSonString(AV47TFPaiDiaHsPExt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIFONDOCESE_SEL") == 0 )
         {
            AV50TFPaiFondoCese_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIMAXHORNOR") == 0 )
         {
            AV51TFPaiMaxHorNor = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV52TFPaiMaxHorNor_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIPERVACDES_SEL") == 0 )
         {
            AV53TFPaiPerVacDes_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV54TFPaiPerVacDes_Sels.fromJSonString(AV53TFPaiPerVacDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIPERVACHAS_SEL") == 0 )
         {
            AV56TFPaiPerVacHas_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV57TFPaiPerVacHas_Sels.fromJSonString(AV56TFPaiPerVacHas_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIFRACVACANT") == 0 )
         {
            AV69TFPaiFracVacAnt = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV70TFPaiFracVacAnt_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIGUAREDADMIN") == 0 )
         {
            AV59TFPaiGuarEdadMin = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV60TFPaiGuarEdadMin_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIGUAREDADMAX") == 0 )
         {
            AV61TFPaiGuarEdadMax = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV62TFPaiGuarEdadMax_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIEXCVIZZOTI_SEL") == 0 )
         {
            AV63TFPaiExcVizzoti_Sel = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIVIZZOTI") == 0 )
         {
            AV64TFPaiVizzoti = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV65TFPaiVizzoti_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV73MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV108GXV8 = (int)(AV108GXV8+1) ;
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
      this.aP0[0] = paiswwexport.this.AV12Filename;
      this.aP1[0] = paiswwexport.this.AV13ErrorMessage;
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
      AV76Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV39TFPaiNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFPaiNom_Sel = "" ;
      AV38TFPaiNom = "" ;
      AV43TFPaiReligDefault_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44TFPaiReligDefault_Sel = "" ;
      AV42TFPaiReligDefault = "" ;
      AV45TFPaiMesHsPExt = DecimalUtil.ZERO ;
      AV46TFPaiMesHsPExt_To = DecimalUtil.ZERO ;
      AV48TFPaiDiaHsPExt_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFPaiDiaHsPExt_Sel = "" ;
      AV51TFPaiMaxHorNor = DecimalUtil.ZERO ;
      AV52TFPaiMaxHorNor_To = DecimalUtil.ZERO ;
      AV54TFPaiPerVacDes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV57TFPaiPerVacHas_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV69TFPaiFracVacAnt = DecimalUtil.ZERO ;
      AV70TFPaiFracVacAnt_To = DecimalUtil.ZERO ;
      AV64TFPaiVizzoti = DecimalUtil.ZERO ;
      AV65TFPaiVizzoti_To = DecimalUtil.ZERO ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A312PaiNom = "" ;
      A1252PaiReligDefault = "" ;
      A1271PaiMesHsPExt = DecimalUtil.ZERO ;
      A1272PaiDiaHsPExt = "" ;
      A1405PaiMaxHorNor = DecimalUtil.ZERO ;
      A1814PaiFracVacAnt = DecimalUtil.ZERO ;
      A1737PaiVizzoti = DecimalUtil.ZERO ;
      AV86Paiswwds_3_tfpainom = "" ;
      AV87Paiswwds_4_tfpainom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV88Paiswwds_5_tfpaireligdefault = "" ;
      AV89Paiswwds_6_tfpaireligdefault_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV90Paiswwds_7_tfpaimeshspext = DecimalUtil.ZERO ;
      AV91Paiswwds_8_tfpaimeshspext_to = DecimalUtil.ZERO ;
      AV92Paiswwds_9_tfpaidiahspext_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV94Paiswwds_11_tfpaimaxhornor = DecimalUtil.ZERO ;
      AV95Paiswwds_12_tfpaimaxhornor_to = DecimalUtil.ZERO ;
      AV96Paiswwds_13_tfpaipervacdes_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV97Paiswwds_14_tfpaipervachas_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV98Paiswwds_15_tfpaifracvacant = DecimalUtil.ZERO ;
      AV99Paiswwds_16_tfpaifracvacant_to = DecimalUtil.ZERO ;
      AV105Paiswwds_22_tfpaivizzoti = DecimalUtil.ZERO ;
      AV106Paiswwds_23_tfpaivizzoti_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV86Paiswwds_3_tfpainom = "" ;
      lV88Paiswwds_5_tfpaireligdefault = "" ;
      P01JR2_A1737PaiVizzoti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JR2_A1736PaiExcVizzoti = new boolean[] {false} ;
      P01JR2_A1626PaiGuarEdadMax = new byte[1] ;
      P01JR2_A1625PaiGuarEdadMin = new byte[1] ;
      P01JR2_A1814PaiFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JR2_A1522PaiPerVacHas = new byte[1] ;
      P01JR2_A1521PaiPerVacDes = new byte[1] ;
      P01JR2_A1405PaiMaxHorNor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JR2_A1402PaiFondoCese = new boolean[] {false} ;
      P01JR2_A1272PaiDiaHsPExt = new String[] {""} ;
      P01JR2_A1271PaiMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JR2_A1252PaiReligDefault = new String[] {""} ;
      P01JR2_n1252PaiReligDefault = new boolean[] {false} ;
      P01JR2_A312PaiNom = new String[] {""} ;
      P01JR2_A46PaiCod = new short[1] ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFPaiNom_SelsJson = "" ;
      AV41TFPaiReligDefault_SelsJson = "" ;
      AV47TFPaiDiaHsPExt_SelsJson = "" ;
      AV53TFPaiPerVacDes_SelsJson = "" ;
      AV56TFPaiPerVacHas_SelsJson = "" ;
      AV73MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paiswwexport__default(),
         new Object[] {
             new Object[] {
            P01JR2_A1737PaiVizzoti, P01JR2_A1736PaiExcVizzoti, P01JR2_A1626PaiGuarEdadMax, P01JR2_A1625PaiGuarEdadMin, P01JR2_A1814PaiFracVacAnt, P01JR2_A1522PaiPerVacHas, P01JR2_A1521PaiPerVacDes, P01JR2_A1405PaiMaxHorNor, P01JR2_A1402PaiFondoCese, P01JR2_A1272PaiDiaHsPExt,
            P01JR2_A1271PaiMesHsPExt, P01JR2_A1252PaiReligDefault, P01JR2_n1252PaiReligDefault, P01JR2_A312PaiNom, P01JR2_A46PaiCod
            }
         }
      );
      AV76Pgmname = "PaisWWExport" ;
      /* GeneXus formulas. */
      AV76Pgmname = "PaisWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV50TFPaiFondoCese_Sel ;
   private byte AV55TFPaiPerVacDes_Sel ;
   private byte AV58TFPaiPerVacHas_Sel ;
   private byte AV59TFPaiGuarEdadMin ;
   private byte AV60TFPaiGuarEdadMin_To ;
   private byte AV61TFPaiGuarEdadMax ;
   private byte AV62TFPaiGuarEdadMax_To ;
   private byte AV63TFPaiExcVizzoti_Sel ;
   private byte A1521PaiPerVacDes ;
   private byte A1522PaiPerVacHas ;
   private byte A1625PaiGuarEdadMin ;
   private byte A1626PaiGuarEdadMax ;
   private byte AV93Paiswwds_10_tfpaifondocese_sel ;
   private byte AV100Paiswwds_17_tfpaiguaredadmin ;
   private byte AV101Paiswwds_18_tfpaiguaredadmin_to ;
   private byte AV102Paiswwds_19_tfpaiguaredadmax ;
   private byte AV103Paiswwds_20_tfpaiguaredadmax_to ;
   private byte AV104Paiswwds_21_tfpaiexcvizzoti_sel ;
   private short AV35TFPaiCod ;
   private short AV36TFPaiCod_To ;
   private short GXv_int5[] ;
   private short A46PaiCod ;
   private short AV84Paiswwds_1_tfpaicod ;
   private short AV85Paiswwds_2_tfpaicod_to ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV77GXV1 ;
   private int AV78GXV2 ;
   private int AV79GXV3 ;
   private int AV80GXV4 ;
   private int AV81GXV5 ;
   private int AV82GXV6 ;
   private int AV87Paiswwds_4_tfpainom_sels_size ;
   private int AV89Paiswwds_6_tfpaireligdefault_sels_size ;
   private int AV92Paiswwds_9_tfpaidiahspext_sels_size ;
   private int AV96Paiswwds_13_tfpaipervacdes_sels_size ;
   private int AV97Paiswwds_14_tfpaipervachas_sels_size ;
   private int AV107GXV7 ;
   private int AV108GXV8 ;
   private long AV66i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV45TFPaiMesHsPExt ;
   private java.math.BigDecimal AV46TFPaiMesHsPExt_To ;
   private java.math.BigDecimal AV51TFPaiMaxHorNor ;
   private java.math.BigDecimal AV52TFPaiMaxHorNor_To ;
   private java.math.BigDecimal AV69TFPaiFracVacAnt ;
   private java.math.BigDecimal AV70TFPaiFracVacAnt_To ;
   private java.math.BigDecimal AV64TFPaiVizzoti ;
   private java.math.BigDecimal AV65TFPaiVizzoti_To ;
   private java.math.BigDecimal A1271PaiMesHsPExt ;
   private java.math.BigDecimal A1405PaiMaxHorNor ;
   private java.math.BigDecimal A1814PaiFracVacAnt ;
   private java.math.BigDecimal A1737PaiVizzoti ;
   private java.math.BigDecimal AV90Paiswwds_7_tfpaimeshspext ;
   private java.math.BigDecimal AV91Paiswwds_8_tfpaimeshspext_to ;
   private java.math.BigDecimal AV94Paiswwds_11_tfpaimaxhornor ;
   private java.math.BigDecimal AV95Paiswwds_12_tfpaimaxhornor_to ;
   private java.math.BigDecimal AV98Paiswwds_15_tfpaifracvacant ;
   private java.math.BigDecimal AV99Paiswwds_16_tfpaifracvacant_to ;
   private java.math.BigDecimal AV105Paiswwds_22_tfpaivizzoti ;
   private java.math.BigDecimal AV106Paiswwds_23_tfpaivizzoti_to ;
   private String AV76Pgmname ;
   private String AV44TFPaiReligDefault_Sel ;
   private String AV42TFPaiReligDefault ;
   private String AV49TFPaiDiaHsPExt_Sel ;
   private String A1252PaiReligDefault ;
   private String A1272PaiDiaHsPExt ;
   private String AV88Paiswwds_5_tfpaireligdefault ;
   private String scmdbuf ;
   private String lV88Paiswwds_5_tfpaireligdefault ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean A1402PaiFondoCese ;
   private boolean A1736PaiExcVizzoti ;
   private boolean AV19OrderedDsc ;
   private boolean n1252PaiReligDefault ;
   private boolean Cond_result ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV37TFPaiNom_SelsJson ;
   private String AV41TFPaiReligDefault_SelsJson ;
   private String AV47TFPaiDiaHsPExt_SelsJson ;
   private String AV53TFPaiPerVacDes_SelsJson ;
   private String AV56TFPaiPerVacHas_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV40TFPaiNom_Sel ;
   private String AV38TFPaiNom ;
   private String A312PaiNom ;
   private String AV86Paiswwds_3_tfpainom ;
   private String lV86Paiswwds_3_tfpainom ;
   private String AV73MenuOpcCod ;
   private GXSimpleCollection<Byte> AV54TFPaiPerVacDes_Sels ;
   private GXSimpleCollection<Byte> AV57TFPaiPerVacHas_Sels ;
   private GXSimpleCollection<Byte> AV96Paiswwds_13_tfpaipervacdes_sels ;
   private GXSimpleCollection<Byte> AV97Paiswwds_14_tfpaipervachas_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV43TFPaiReligDefault_Sels ;
   private GXSimpleCollection<String> AV48TFPaiDiaHsPExt_Sels ;
   private GXSimpleCollection<String> AV39TFPaiNom_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P01JR2_A1737PaiVizzoti ;
   private boolean[] P01JR2_A1736PaiExcVizzoti ;
   private byte[] P01JR2_A1626PaiGuarEdadMax ;
   private byte[] P01JR2_A1625PaiGuarEdadMin ;
   private java.math.BigDecimal[] P01JR2_A1814PaiFracVacAnt ;
   private byte[] P01JR2_A1522PaiPerVacHas ;
   private byte[] P01JR2_A1521PaiPerVacDes ;
   private java.math.BigDecimal[] P01JR2_A1405PaiMaxHorNor ;
   private boolean[] P01JR2_A1402PaiFondoCese ;
   private String[] P01JR2_A1272PaiDiaHsPExt ;
   private java.math.BigDecimal[] P01JR2_A1271PaiMesHsPExt ;
   private String[] P01JR2_A1252PaiReligDefault ;
   private boolean[] P01JR2_n1252PaiReligDefault ;
   private String[] P01JR2_A312PaiNom ;
   private short[] P01JR2_A46PaiCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV89Paiswwds_6_tfpaireligdefault_sels ;
   private GXSimpleCollection<String> AV92Paiswwds_9_tfpaidiahspext_sels ;
   private GXSimpleCollection<String> AV87Paiswwds_4_tfpainom_sels ;
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

final  class paiswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01JR2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A312PaiNom ,
                                          GXSimpleCollection<String> AV87Paiswwds_4_tfpainom_sels ,
                                          String A1252PaiReligDefault ,
                                          GXSimpleCollection<String> AV89Paiswwds_6_tfpaireligdefault_sels ,
                                          String A1272PaiDiaHsPExt ,
                                          GXSimpleCollection<String> AV92Paiswwds_9_tfpaidiahspext_sels ,
                                          byte A1521PaiPerVacDes ,
                                          GXSimpleCollection<Byte> AV96Paiswwds_13_tfpaipervacdes_sels ,
                                          byte A1522PaiPerVacHas ,
                                          GXSimpleCollection<Byte> AV97Paiswwds_14_tfpaipervachas_sels ,
                                          short AV84Paiswwds_1_tfpaicod ,
                                          short AV85Paiswwds_2_tfpaicod_to ,
                                          int AV87Paiswwds_4_tfpainom_sels_size ,
                                          String AV86Paiswwds_3_tfpainom ,
                                          int AV89Paiswwds_6_tfpaireligdefault_sels_size ,
                                          String AV88Paiswwds_5_tfpaireligdefault ,
                                          java.math.BigDecimal AV90Paiswwds_7_tfpaimeshspext ,
                                          java.math.BigDecimal AV91Paiswwds_8_tfpaimeshspext_to ,
                                          int AV92Paiswwds_9_tfpaidiahspext_sels_size ,
                                          byte AV93Paiswwds_10_tfpaifondocese_sel ,
                                          java.math.BigDecimal AV94Paiswwds_11_tfpaimaxhornor ,
                                          java.math.BigDecimal AV95Paiswwds_12_tfpaimaxhornor_to ,
                                          int AV96Paiswwds_13_tfpaipervacdes_sels_size ,
                                          int AV97Paiswwds_14_tfpaipervachas_sels_size ,
                                          java.math.BigDecimal AV98Paiswwds_15_tfpaifracvacant ,
                                          java.math.BigDecimal AV99Paiswwds_16_tfpaifracvacant_to ,
                                          byte AV100Paiswwds_17_tfpaiguaredadmin ,
                                          byte AV101Paiswwds_18_tfpaiguaredadmin_to ,
                                          byte AV102Paiswwds_19_tfpaiguaredadmax ,
                                          byte AV103Paiswwds_20_tfpaiguaredadmax_to ,
                                          byte AV104Paiswwds_21_tfpaiexcvizzoti_sel ,
                                          java.math.BigDecimal AV105Paiswwds_22_tfpaivizzoti ,
                                          java.math.BigDecimal AV106Paiswwds_23_tfpaivizzoti_to ,
                                          short A46PaiCod ,
                                          java.math.BigDecimal A1271PaiMesHsPExt ,
                                          boolean A1402PaiFondoCese ,
                                          java.math.BigDecimal A1405PaiMaxHorNor ,
                                          java.math.BigDecimal A1814PaiFracVacAnt ,
                                          byte A1625PaiGuarEdadMin ,
                                          byte A1626PaiGuarEdadMax ,
                                          boolean A1736PaiExcVizzoti ,
                                          java.math.BigDecimal A1737PaiVizzoti ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[16];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT PaiVizzoti, PaiExcVizzoti, PaiGuarEdadMax, PaiGuarEdadMin, PaiFracVacAnt, PaiPerVacHas, PaiPerVacDes, PaiMaxHorNor, PaiFondoCese, PaiDiaHsPExt, PaiMesHsPExt," ;
      scmdbuf += " PaiReligDefault, PaiNom, PaiCod FROM Pais" ;
      if ( ! (0==AV84Paiswwds_1_tfpaicod) )
      {
         addWhere(sWhereString, "(PaiCod >= ?)");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( ! (0==AV85Paiswwds_2_tfpaicod_to) )
      {
         addWhere(sWhereString, "(PaiCod <= ?)");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( ( AV87Paiswwds_4_tfpainom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV86Paiswwds_3_tfpainom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV87Paiswwds_4_tfpainom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV87Paiswwds_4_tfpainom_sels, "PaiNom IN (", ")")+")");
      }
      if ( ( AV89Paiswwds_6_tfpaireligdefault_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV88Paiswwds_5_tfpaireligdefault)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiReligDefault) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV89Paiswwds_6_tfpaireligdefault_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV89Paiswwds_6_tfpaireligdefault_sels, "PaiReligDefault IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV90Paiswwds_7_tfpaimeshspext)==0) )
      {
         addWhere(sWhereString, "(PaiMesHsPExt >= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV91Paiswwds_8_tfpaimeshspext_to)==0) )
      {
         addWhere(sWhereString, "(PaiMesHsPExt <= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV92Paiswwds_9_tfpaidiahspext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV92Paiswwds_9_tfpaidiahspext_sels, "PaiDiaHsPExt IN (", ")")+")");
      }
      if ( AV93Paiswwds_10_tfpaifondocese_sel == 1 )
      {
         addWhere(sWhereString, "(PaiFondoCese = TRUE)");
      }
      if ( AV93Paiswwds_10_tfpaifondocese_sel == 2 )
      {
         addWhere(sWhereString, "(PaiFondoCese = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94Paiswwds_11_tfpaimaxhornor)==0) )
      {
         addWhere(sWhereString, "(PaiMaxHorNor >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV95Paiswwds_12_tfpaimaxhornor_to)==0) )
      {
         addWhere(sWhereString, "(PaiMaxHorNor <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( AV96Paiswwds_13_tfpaipervacdes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV96Paiswwds_13_tfpaipervacdes_sels, "PaiPerVacDes IN (", ")")+")");
      }
      if ( AV97Paiswwds_14_tfpaipervachas_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Paiswwds_14_tfpaipervachas_sels, "PaiPerVacHas IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV98Paiswwds_15_tfpaifracvacant)==0) )
      {
         addWhere(sWhereString, "(PaiFracVacAnt >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV99Paiswwds_16_tfpaifracvacant_to)==0) )
      {
         addWhere(sWhereString, "(PaiFracVacAnt <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (0==AV100Paiswwds_17_tfpaiguaredadmin) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMin >= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (0==AV101Paiswwds_18_tfpaiguaredadmin_to) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMin <= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (0==AV102Paiswwds_19_tfpaiguaredadmax) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMax >= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (0==AV103Paiswwds_20_tfpaiguaredadmax_to) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMax <= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( AV104Paiswwds_21_tfpaiexcvizzoti_sel == 1 )
      {
         addWhere(sWhereString, "(PaiExcVizzoti = TRUE)");
      }
      if ( AV104Paiswwds_21_tfpaiexcvizzoti_sel == 2 )
      {
         addWhere(sWhereString, "(PaiExcVizzoti = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV105Paiswwds_22_tfpaivizzoti)==0) )
      {
         addWhere(sWhereString, "(PaiVizzoti >= ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV106Paiswwds_23_tfpaivizzoti_to)==0) )
      {
         addWhere(sWhereString, "(PaiVizzoti <= ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiCod" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiNom" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiNom DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiReligDefault" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiReligDefault DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiMesHsPExt" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiMesHsPExt DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiDiaHsPExt" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiDiaHsPExt DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiFondoCese" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiFondoCese DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiMaxHorNor" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiMaxHorNor DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiPerVacDes" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiPerVacDes DESC" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiPerVacHas" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiPerVacHas DESC" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiFracVacAnt" ;
      }
      else if ( ( AV18OrderedBy == 10 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiFracVacAnt DESC" ;
      }
      else if ( ( AV18OrderedBy == 11 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiGuarEdadMin" ;
      }
      else if ( ( AV18OrderedBy == 11 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiGuarEdadMin DESC" ;
      }
      else if ( ( AV18OrderedBy == 12 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiGuarEdadMax" ;
      }
      else if ( ( AV18OrderedBy == 12 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiGuarEdadMax DESC" ;
      }
      else if ( ( AV18OrderedBy == 13 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiExcVizzoti" ;
      }
      else if ( ( AV18OrderedBy == 13 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiExcVizzoti DESC" ;
      }
      else if ( ( AV18OrderedBy == 14 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiVizzoti" ;
      }
      else if ( ( AV18OrderedBy == 14 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiVizzoti DESC" ;
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
                  return conditional_P01JR2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).byteValue() , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).byteValue() , ((Number) dynConstraints[30]).byteValue() , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (java.math.BigDecimal)dynConstraints[34] , ((Boolean) dynConstraints[35]).booleanValue() , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , ((Number) dynConstraints[39]).byteValue() , ((Boolean) dynConstraints[40]).booleanValue() , (java.math.BigDecimal)dynConstraints[41] , ((Number) dynConstraints[42]).shortValue() , ((Boolean) dynConstraints[43]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JR2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,4);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,1);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(13);
               ((short[]) buf[14])[0] = rslt.getShort(14);
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
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 1);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 4);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[28]).byteValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[29]).byteValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 4);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 4);
               }
               return;
      }
   }

}

