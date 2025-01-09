package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paisextraordinariaswwexport extends GXProcedure
{
   public paisextraordinariaswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisextraordinariaswwexport.class ), "" );
   }

   public paisextraordinariaswwexport( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      paisextraordinariaswwexport.this.aP1 = new String[] {""};
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
      paisextraordinariaswwexport.this.aP0 = aP0;
      paisextraordinariaswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisExtraordinarias", GXv_boolean2) ;
      paisextraordinariaswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV65Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "PaisExtraordinariasWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV36TFPaiHsPDiaTipTra_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de trabajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisextraordinariaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV49i = 1 ;
         AV66GXV1 = 1 ;
         while ( AV66GXV1 <= AV36TFPaiHsPDiaTipTra_Sels.size() )
         {
            AV37TFPaiHsPDiaTipTra_Sel = (String)AV36TFPaiHsPDiaTipTra_Sels.elementAt(-1+AV66GXV1) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)AV37TFPaiHsPDiaTipTra_Sel), "") );
            AV49i = (long)(AV49i+1) ;
            AV66GXV1 = (int)(AV66GXV1+1) ;
         }
      }
      if ( ! ( ( AV39TFPaiHsPDiaDia_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Día", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisextraordinariaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV49i = 1 ;
         AV67GXV2 = 1 ;
         while ( AV67GXV2 <= AV39TFPaiHsPDiaDia_Sels.size() )
         {
            AV40TFPaiHsPDiaDia_Sel = ((Number) AV39TFPaiHsPDiaDia_Sels.elementAt(-1+AV67GXV2)).byteValue() ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaindia_tra.getDescription(httpContext,(byte)AV40TFPaiHsPDiaDia_Sel), "") );
            AV49i = (long)(AV49i+1) ;
            AV67GXV2 = (int)(AV67GXV2+1) ;
         }
      }
      if ( ! ( ( AV43TFPaiHsPDiaDesde_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Hora desde", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisextraordinariaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV49i = 1 ;
         AV68GXV3 = 1 ;
         while ( AV68GXV3 <= AV43TFPaiHsPDiaDesde_Sels.size() )
         {
            AV44TFPaiHsPDiaDesde_Sel = (String)AV43TFPaiHsPDiaDesde_Sels.elementAt(-1+AV68GXV3) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFPaiHsPDiaDesde_Sel, GXv_char7) ;
            paisextraordinariaswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV49i = (long)(AV49i+1) ;
            AV68GXV3 = (int)(AV68GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV42TFPaiHsPDiaDesde)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Hora desde", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            paisextraordinariaswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFPaiHsPDiaDesde, GXv_char7) ;
            paisextraordinariaswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFPaiTarifaPDia)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFPaiTarifaPDia_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Aumento de horas extras sobre hora normal", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisextraordinariaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV45TFPaiTarifaPDia)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisextraordinariaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV46TFPaiTarifaPDia_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV47TFPaiTarifaPDRec)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV48TFPaiTarifaPDRec_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Recargo a hora normal diurna", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisextraordinariaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV47TFPaiTarifaPDRec)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisextraordinariaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV48TFPaiTarifaPDRec_To)) );
      }
      if ( ! ( ( AV61TFPaiTarifaPDCri_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Criterio", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisextraordinariaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV49i = 1 ;
         AV69GXV4 = 1 ;
         while ( AV69GXV4 <= AV61TFPaiTarifaPDCri_Sels.size() )
         {
            AV62TFPaiTarifaPDCri_Sel = (String)AV61TFPaiTarifaPDCri_Sels.elementAt(-1+AV69GXV4) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaincriterio_horaextra.getDescription(httpContext,(String)AV62TFPaiTarifaPDCri_Sel), "") );
            AV49i = (long)(AV49i+1) ;
            AV69GXV4 = (int)(AV69GXV4+1) ;
         }
      }
      if ( ! ( ( AV58TFPaiExtraordRelRef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         paisextraordinariaswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV49i = 1 ;
         AV70GXV5 = 1 ;
         while ( AV70GXV5 <= AV58TFPaiExtraordRelRef_Sels.size() )
         {
            AV59TFPaiExtraordRelRef_Sel = (String)AV58TFPaiExtraordRelRef_Sels.elementAt(-1+AV70GXV5) ;
            if ( AV49i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV59TFPaiExtraordRelRef_Sel, GXv_char7) ;
            paisextraordinariaswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV49i = (long)(AV49i+1) ;
            AV70GXV5 = (int)(AV70GXV5+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV57TFPaiExtraordRelRef)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            paisextraordinariaswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV57TFPaiExtraordRelRef, GXv_char7) ;
            paisextraordinariaswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("PaisExtraordinariasWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("PaisExtraordinariasWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV54IsAuthorizedPaiExtraordRelRef&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV71GXV6 = 1 ;
      while ( AV71GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV71GXV6));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV71GXV6 = (int)(AV71GXV6+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV73Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels = AV36TFPaiHsPDiaTipTra_Sels ;
      AV74Paisextraordinariaswwds_2_tfpaihspdiadia_sels = AV39TFPaiHsPDiaDia_Sels ;
      AV75Paisextraordinariaswwds_3_tfpaihspdiadesde = AV42TFPaiHsPDiaDesde ;
      AV76Paisextraordinariaswwds_4_tfpaihspdiadesde_sels = AV43TFPaiHsPDiaDesde_Sels ;
      AV77Paisextraordinariaswwds_5_tfpaitarifapdia = AV45TFPaiTarifaPDia ;
      AV78Paisextraordinariaswwds_6_tfpaitarifapdia_to = AV46TFPaiTarifaPDia_To ;
      AV79Paisextraordinariaswwds_7_tfpaitarifapdrec = AV47TFPaiTarifaPDRec ;
      AV80Paisextraordinariaswwds_8_tfpaitarifapdrec_to = AV48TFPaiTarifaPDRec_To ;
      AV81Paisextraordinariaswwds_9_tfpaitarifapdcri_sels = AV61TFPaiTarifaPDCri_Sels ;
      AV82Paisextraordinariaswwds_10_tfpaiextraordrelref = AV57TFPaiExtraordRelRef ;
      AV83Paisextraordinariaswwds_11_tfpaiextraordrelref_sels = AV58TFPaiExtraordRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1331PaiHsPDiaTipTra ,
                                           AV73Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels ,
                                           Byte.valueOf(A1333PaiHsPDiaDia) ,
                                           AV74Paisextraordinariaswwds_2_tfpaihspdiadia_sels ,
                                           A1334PaiHsPDiaDesde ,
                                           AV76Paisextraordinariaswwds_4_tfpaihspdiadesde_sels ,
                                           A2434PaiTarifaPDCri ,
                                           AV81Paisextraordinariaswwds_9_tfpaitarifapdcri_sels ,
                                           A2058PaiExtraordRelRef ,
                                           AV83Paisextraordinariaswwds_11_tfpaiextraordrelref_sels ,
                                           Integer.valueOf(AV73Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels.size()) ,
                                           Integer.valueOf(AV74Paisextraordinariaswwds_2_tfpaihspdiadia_sels.size()) ,
                                           Integer.valueOf(AV76Paisextraordinariaswwds_4_tfpaihspdiadesde_sels.size()) ,
                                           AV75Paisextraordinariaswwds_3_tfpaihspdiadesde ,
                                           AV77Paisextraordinariaswwds_5_tfpaitarifapdia ,
                                           AV78Paisextraordinariaswwds_6_tfpaitarifapdia_to ,
                                           AV79Paisextraordinariaswwds_7_tfpaitarifapdrec ,
                                           AV80Paisextraordinariaswwds_8_tfpaitarifapdrec_to ,
                                           Integer.valueOf(AV81Paisextraordinariaswwds_9_tfpaitarifapdcri_sels.size()) ,
                                           Integer.valueOf(AV83Paisextraordinariaswwds_11_tfpaiextraordrelref_sels.size()) ,
                                           AV82Paisextraordinariaswwds_10_tfpaiextraordrelref ,
                                           Short.valueOf(AV52PaiCod) ,
                                           A1335PaiTarifaPDia ,
                                           A1348PaiTarifaPDRec ,
                                           Short.valueOf(A46PaiCod) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV75Paisextraordinariaswwds_3_tfpaihspdiadesde = GXutil.padr( GXutil.rtrim( AV75Paisextraordinariaswwds_3_tfpaihspdiadesde), 5, "%") ;
      lV82Paisextraordinariaswwds_10_tfpaiextraordrelref = GXutil.concat( GXutil.rtrim( AV82Paisextraordinariaswwds_10_tfpaiextraordrelref), "%", "") ;
      /* Using cursor P01NA2 */
      pr_default.execute(0, new Object[] {lV75Paisextraordinariaswwds_3_tfpaihspdiadesde, AV77Paisextraordinariaswwds_5_tfpaitarifapdia, AV78Paisextraordinariaswwds_6_tfpaitarifapdia_to, AV79Paisextraordinariaswwds_7_tfpaitarifapdrec, AV80Paisextraordinariaswwds_8_tfpaitarifapdrec_to, lV82Paisextraordinariaswwds_10_tfpaiextraordrelref, Short.valueOf(AV52PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P01NA2_A46PaiCod[0] ;
         A2058PaiExtraordRelRef = P01NA2_A2058PaiExtraordRelRef[0] ;
         A2434PaiTarifaPDCri = P01NA2_A2434PaiTarifaPDCri[0] ;
         A1348PaiTarifaPDRec = P01NA2_A1348PaiTarifaPDRec[0] ;
         A1335PaiTarifaPDia = P01NA2_A1335PaiTarifaPDia[0] ;
         A1334PaiHsPDiaDesde = P01NA2_A1334PaiHsPDiaDesde[0] ;
         n1334PaiHsPDiaDesde = P01NA2_n1334PaiHsPDiaDesde[0] ;
         A1333PaiHsPDiaDia = P01NA2_A1333PaiHsPDiaDia[0] ;
         A1331PaiHsPDiaTipTra = P01NA2_A1331PaiHsPDiaTipTra[0] ;
         A1332PaiHsExSec = P01NA2_A1332PaiHsExSec[0] ;
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
         AV84GXV7 = 1 ;
         while ( AV84GXV7 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV84GXV7));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiHsPDiaTipTra") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)A1331PaiHsPDiaTipTra), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiHsPDiaDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaindia_tra.getDescription(httpContext,(byte)A1333PaiHsPDiaDia), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiHsPDiaDesde") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1334PaiHsPDiaDesde, GXv_char7) ;
                  paisextraordinariaswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTarifaPDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1335PaiTarifaPDia)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTarifaPDRec") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1348PaiTarifaPDRec)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiTarifaPDCri") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaincriterio_horaextra.getDescription(httpContext,(String)A2434PaiTarifaPDCri), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "PaiExtraordRelRef") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2058PaiExtraordRelRef, GXv_char7) ;
                  paisextraordinariaswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV84GXV7 = (int)(AV84GXV7+1) ;
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
      GXt_boolean1 = AV54IsAuthorizedPaiExtraordRelRef ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV50CliCod, GXv_boolean2) ;
      paisextraordinariaswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV54IsAuthorizedPaiExtraordRelRef = (boolean)((!GXt_boolean1)) ;
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
      AV24ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiHsPDiaTipTra", "", "Tipo de trabajo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiHsPDiaDia", "", "Día", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiHsPDiaDesde", "", "Hora desde", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiTarifaPDia", "", "Aumento de horas extras sobre hora normal", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiTarifaPDRec", "", "Recargo a hora normal diurna", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiTarifaPDCri", "", "Criterio", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV50CliCod) )
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
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PaiExtraordRelRef", "", "Liberación", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "PaisExtraordinariasWWColumnsSelector", GXv_char7) ;
      paisextraordinariaswwexport.this.GXt_char6 = GXv_char7[0] ;
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

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("PaisExtraordinariasWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PaisExtraordinariasWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("PaisExtraordinariasWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV85GXV8 = 1 ;
      while ( AV85GXV8 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV85GXV8));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIHSPDIATIPTRA_SEL") == 0 )
         {
            AV35TFPaiHsPDiaTipTra_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFPaiHsPDiaTipTra_Sels.fromJSonString(AV35TFPaiHsPDiaTipTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIHSPDIADIA_SEL") == 0 )
         {
            AV38TFPaiHsPDiaDia_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFPaiHsPDiaDia_Sels.fromJSonString(AV38TFPaiHsPDiaDia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIHSPDIADESDE") == 0 )
         {
            AV42TFPaiHsPDiaDesde = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIHSPDIADESDE_SEL") == 0 )
         {
            AV41TFPaiHsPDiaDesde_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFPaiHsPDiaDesde_Sels.fromJSonString(AV41TFPaiHsPDiaDesde_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITARIFAPDIA") == 0 )
         {
            AV45TFPaiTarifaPDia = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV46TFPaiTarifaPDia_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITARIFAPDREC") == 0 )
         {
            AV47TFPaiTarifaPDRec = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV48TFPaiTarifaPDRec_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAITARIFAPDCRI_SEL") == 0 )
         {
            AV60TFPaiTarifaPDCri_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV61TFPaiTarifaPDCri_Sels.fromJSonString(AV60TFPaiTarifaPDCri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIEXTRAORDRELREF") == 0 )
         {
            AV57TFPaiExtraordRelRef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIEXTRAORDRELREF_SEL") == 0 )
         {
            AV56TFPaiExtraordRelRef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV58TFPaiExtraordRelRef_Sels.fromJSonString(AV56TFPaiExtraordRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV53MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV85GXV8 = (int)(AV85GXV8+1) ;
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
      this.aP0[0] = paisextraordinariaswwexport.this.AV12Filename;
      this.aP1[0] = paisextraordinariaswwexport.this.AV13ErrorMessage;
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
      AV65Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV36TFPaiHsPDiaTipTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37TFPaiHsPDiaTipTra_Sel = "" ;
      AV39TFPaiHsPDiaDia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV43TFPaiHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44TFPaiHsPDiaDesde_Sel = "" ;
      AV42TFPaiHsPDiaDesde = "" ;
      AV45TFPaiTarifaPDia = DecimalUtil.ZERO ;
      AV46TFPaiTarifaPDia_To = DecimalUtil.ZERO ;
      AV47TFPaiTarifaPDRec = DecimalUtil.ZERO ;
      AV48TFPaiTarifaPDRec_To = DecimalUtil.ZERO ;
      AV61TFPaiTarifaPDCri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62TFPaiTarifaPDCri_Sel = "" ;
      AV58TFPaiExtraordRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59TFPaiExtraordRelRef_Sel = "" ;
      AV57TFPaiExtraordRelRef = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1331PaiHsPDiaTipTra = "" ;
      A1334PaiHsPDiaDesde = "" ;
      A1335PaiTarifaPDia = DecimalUtil.ZERO ;
      A1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      A2434PaiTarifaPDCri = "" ;
      A2058PaiExtraordRelRef = "" ;
      AV73Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV74Paisextraordinariaswwds_2_tfpaihspdiadia_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV75Paisextraordinariaswwds_3_tfpaihspdiadesde = "" ;
      AV76Paisextraordinariaswwds_4_tfpaihspdiadesde_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77Paisextraordinariaswwds_5_tfpaitarifapdia = DecimalUtil.ZERO ;
      AV78Paisextraordinariaswwds_6_tfpaitarifapdia_to = DecimalUtil.ZERO ;
      AV79Paisextraordinariaswwds_7_tfpaitarifapdrec = DecimalUtil.ZERO ;
      AV80Paisextraordinariaswwds_8_tfpaitarifapdrec_to = DecimalUtil.ZERO ;
      AV81Paisextraordinariaswwds_9_tfpaitarifapdcri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV82Paisextraordinariaswwds_10_tfpaiextraordrelref = "" ;
      AV83Paisextraordinariaswwds_11_tfpaiextraordrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV75Paisextraordinariaswwds_3_tfpaihspdiadesde = "" ;
      lV82Paisextraordinariaswwds_10_tfpaiextraordrelref = "" ;
      P01NA2_A46PaiCod = new short[1] ;
      P01NA2_A2058PaiExtraordRelRef = new String[] {""} ;
      P01NA2_A2434PaiTarifaPDCri = new String[] {""} ;
      P01NA2_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01NA2_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01NA2_A1334PaiHsPDiaDesde = new String[] {""} ;
      P01NA2_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      P01NA2_A1333PaiHsPDiaDia = new byte[1] ;
      P01NA2_A1331PaiHsPDiaTipTra = new String[] {""} ;
      P01NA2_A1332PaiHsExSec = new short[1] ;
      GXv_boolean2 = new boolean[1] ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFPaiHsPDiaTipTra_SelsJson = "" ;
      AV38TFPaiHsPDiaDia_SelsJson = "" ;
      AV41TFPaiHsPDiaDesde_SelsJson = "" ;
      AV60TFPaiTarifaPDCri_SelsJson = "" ;
      AV56TFPaiExtraordRelRef_SelsJson = "" ;
      AV53MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paisextraordinariaswwexport__default(),
         new Object[] {
             new Object[] {
            P01NA2_A46PaiCod, P01NA2_A2058PaiExtraordRelRef, P01NA2_A2434PaiTarifaPDCri, P01NA2_A1348PaiTarifaPDRec, P01NA2_A1335PaiTarifaPDia, P01NA2_A1334PaiHsPDiaDesde, P01NA2_n1334PaiHsPDiaDesde, P01NA2_A1333PaiHsPDiaDia, P01NA2_A1331PaiHsPDiaTipTra, P01NA2_A1332PaiHsExSec
            }
         }
      );
      AV65Pgmname = "PaisExtraordinariasWWExport" ;
      /* GeneXus formulas. */
      AV65Pgmname = "PaisExtraordinariasWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV40TFPaiHsPDiaDia_Sel ;
   private byte A1333PaiHsPDiaDia ;
   private short GXv_int5[] ;
   private short AV52PaiCod ;
   private short A46PaiCod ;
   private short AV18OrderedBy ;
   private short A1332PaiHsExSec ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV66GXV1 ;
   private int AV67GXV2 ;
   private int AV68GXV3 ;
   private int AV69GXV4 ;
   private int AV70GXV5 ;
   private int AV71GXV6 ;
   private int AV73Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels_size ;
   private int AV74Paisextraordinariaswwds_2_tfpaihspdiadia_sels_size ;
   private int AV76Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size ;
   private int AV81Paisextraordinariaswwds_9_tfpaitarifapdcri_sels_size ;
   private int AV83Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size ;
   private int AV84GXV7 ;
   private int AV50CliCod ;
   private int AV85GXV8 ;
   private long AV49i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV45TFPaiTarifaPDia ;
   private java.math.BigDecimal AV46TFPaiTarifaPDia_To ;
   private java.math.BigDecimal AV47TFPaiTarifaPDRec ;
   private java.math.BigDecimal AV48TFPaiTarifaPDRec_To ;
   private java.math.BigDecimal A1335PaiTarifaPDia ;
   private java.math.BigDecimal A1348PaiTarifaPDRec ;
   private java.math.BigDecimal AV77Paisextraordinariaswwds_5_tfpaitarifapdia ;
   private java.math.BigDecimal AV78Paisextraordinariaswwds_6_tfpaitarifapdia_to ;
   private java.math.BigDecimal AV79Paisextraordinariaswwds_7_tfpaitarifapdrec ;
   private java.math.BigDecimal AV80Paisextraordinariaswwds_8_tfpaitarifapdrec_to ;
   private String AV65Pgmname ;
   private String AV37TFPaiHsPDiaTipTra_Sel ;
   private String AV44TFPaiHsPDiaDesde_Sel ;
   private String AV42TFPaiHsPDiaDesde ;
   private String AV62TFPaiTarifaPDCri_Sel ;
   private String A1331PaiHsPDiaTipTra ;
   private String A1334PaiHsPDiaDesde ;
   private String A2434PaiTarifaPDCri ;
   private String AV75Paisextraordinariaswwds_3_tfpaihspdiadesde ;
   private String scmdbuf ;
   private String lV75Paisextraordinariaswwds_3_tfpaihspdiadesde ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV54IsAuthorizedPaiExtraordRelRef ;
   private boolean AV19OrderedDsc ;
   private boolean n1334PaiHsPDiaDesde ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean Cond_result ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFPaiHsPDiaTipTra_SelsJson ;
   private String AV38TFPaiHsPDiaDia_SelsJson ;
   private String AV41TFPaiHsPDiaDesde_SelsJson ;
   private String AV60TFPaiTarifaPDCri_SelsJson ;
   private String AV56TFPaiExtraordRelRef_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV59TFPaiExtraordRelRef_Sel ;
   private String AV57TFPaiExtraordRelRef ;
   private String A2058PaiExtraordRelRef ;
   private String AV82Paisextraordinariaswwds_10_tfpaiextraordrelref ;
   private String lV82Paisextraordinariaswwds_10_tfpaiextraordrelref ;
   private String AV53MenuOpcCod ;
   private GXSimpleCollection<Byte> AV39TFPaiHsPDiaDia_Sels ;
   private GXSimpleCollection<Byte> AV74Paisextraordinariaswwds_2_tfpaihspdiadia_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV36TFPaiHsPDiaTipTra_Sels ;
   private GXSimpleCollection<String> AV43TFPaiHsPDiaDesde_Sels ;
   private GXSimpleCollection<String> AV61TFPaiTarifaPDCri_Sels ;
   private GXSimpleCollection<String> AV58TFPaiExtraordRelRef_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P01NA2_A46PaiCod ;
   private String[] P01NA2_A2058PaiExtraordRelRef ;
   private String[] P01NA2_A2434PaiTarifaPDCri ;
   private java.math.BigDecimal[] P01NA2_A1348PaiTarifaPDRec ;
   private java.math.BigDecimal[] P01NA2_A1335PaiTarifaPDia ;
   private String[] P01NA2_A1334PaiHsPDiaDesde ;
   private boolean[] P01NA2_n1334PaiHsPDiaDesde ;
   private byte[] P01NA2_A1333PaiHsPDiaDia ;
   private String[] P01NA2_A1331PaiHsPDiaTipTra ;
   private short[] P01NA2_A1332PaiHsExSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV73Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels ;
   private GXSimpleCollection<String> AV76Paisextraordinariaswwds_4_tfpaihspdiadesde_sels ;
   private GXSimpleCollection<String> AV81Paisextraordinariaswwds_9_tfpaitarifapdcri_sels ;
   private GXSimpleCollection<String> AV83Paisextraordinariaswwds_11_tfpaiextraordrelref_sels ;
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

final  class paisextraordinariaswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01NA2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1331PaiHsPDiaTipTra ,
                                          GXSimpleCollection<String> AV73Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels ,
                                          byte A1333PaiHsPDiaDia ,
                                          GXSimpleCollection<Byte> AV74Paisextraordinariaswwds_2_tfpaihspdiadia_sels ,
                                          String A1334PaiHsPDiaDesde ,
                                          GXSimpleCollection<String> AV76Paisextraordinariaswwds_4_tfpaihspdiadesde_sels ,
                                          String A2434PaiTarifaPDCri ,
                                          GXSimpleCollection<String> AV81Paisextraordinariaswwds_9_tfpaitarifapdcri_sels ,
                                          String A2058PaiExtraordRelRef ,
                                          GXSimpleCollection<String> AV83Paisextraordinariaswwds_11_tfpaiextraordrelref_sels ,
                                          int AV73Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels_size ,
                                          int AV74Paisextraordinariaswwds_2_tfpaihspdiadia_sels_size ,
                                          int AV76Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size ,
                                          String AV75Paisextraordinariaswwds_3_tfpaihspdiadesde ,
                                          java.math.BigDecimal AV77Paisextraordinariaswwds_5_tfpaitarifapdia ,
                                          java.math.BigDecimal AV78Paisextraordinariaswwds_6_tfpaitarifapdia_to ,
                                          java.math.BigDecimal AV79Paisextraordinariaswwds_7_tfpaitarifapdrec ,
                                          java.math.BigDecimal AV80Paisextraordinariaswwds_8_tfpaitarifapdrec_to ,
                                          int AV81Paisextraordinariaswwds_9_tfpaitarifapdcri_sels_size ,
                                          int AV83Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size ,
                                          String AV82Paisextraordinariaswwds_10_tfpaiextraordrelref ,
                                          short AV52PaiCod ,
                                          java.math.BigDecimal A1335PaiTarifaPDia ,
                                          java.math.BigDecimal A1348PaiTarifaPDRec ,
                                          short A46PaiCod ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[7];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT PaiCod, PaiExtraordRelRef, PaiTarifaPDCri, PaiTarifaPDRec, PaiTarifaPDia, PaiHsPDiaDesde, PaiHsPDiaDia, PaiHsPDiaTipTra, PaiHsExSec FROM Paishorasextras_pordia" ;
      if ( AV73Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Paisextraordinariaswwds_1_tfpaihspdiatiptra_sels, "PaiHsPDiaTipTra IN (", ")")+")");
      }
      if ( AV74Paisextraordinariaswwds_2_tfpaihspdiadia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Paisextraordinariaswwds_2_tfpaihspdiadia_sels, "PaiHsPDiaDia IN (", ")")+")");
      }
      if ( ( AV76Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Paisextraordinariaswwds_3_tfpaihspdiadesde)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiHsPDiaDesde) like LOWER(?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( AV76Paisextraordinariaswwds_4_tfpaihspdiadesde_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Paisextraordinariaswwds_4_tfpaihspdiadesde_sels, "PaiHsPDiaDesde IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV77Paisextraordinariaswwds_5_tfpaitarifapdia)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDia >= ?)");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV78Paisextraordinariaswwds_6_tfpaitarifapdia_to)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDia <= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Paisextraordinariaswwds_7_tfpaitarifapdrec)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDRec >= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Paisextraordinariaswwds_8_tfpaitarifapdrec_to)==0) )
      {
         addWhere(sWhereString, "(PaiTarifaPDRec <= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV81Paisextraordinariaswwds_9_tfpaitarifapdcri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV81Paisextraordinariaswwds_9_tfpaitarifapdcri_sels, "PaiTarifaPDCri IN (", ")")+")");
      }
      if ( ( AV83Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV82Paisextraordinariaswwds_10_tfpaiextraordrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiExtraordRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV83Paisextraordinariaswwds_11_tfpaiextraordrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Paisextraordinariaswwds_11_tfpaiextraordrelref_sels, "PaiExtraordRelRef IN (", ")")+")");
      }
      if ( ! (0==AV52PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiHsPDiaTipTra" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiHsPDiaTipTra DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiHsPDiaDia" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiHsPDiaDia DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiHsPDiaDesde" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiHsPDiaDesde DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiTarifaPDia" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiTarifaPDia DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiTarifaPDRec" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiTarifaPDRec DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiTarifaPDCri" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiTarifaPDCri DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY PaiExtraordRelRef" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PaiExtraordRelRef DESC" ;
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
                  return conditional_P01NA2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Boolean) dynConstraints[26]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01NA2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((short[]) buf[9])[0] = rslt.getShort(9);
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
                  stmt.setString(sIdx, (String)parms[7], 5);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[8], 4);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 4);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[10], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[11], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 40);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               return;
      }
   }

}

