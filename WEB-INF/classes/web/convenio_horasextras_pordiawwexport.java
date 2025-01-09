package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_horasextras_pordiawwexport extends GXProcedure
{
   public convenio_horasextras_pordiawwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_horasextras_pordiawwexport.class ), "" );
   }

   public convenio_horasextras_pordiawwexport( int remoteHandle ,
                                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      convenio_horasextras_pordiawwexport.this.aP1 = new String[] {""};
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
      convenio_horasextras_pordiawwexport.this.aP0 = aP0;
      convenio_horasextras_pordiawwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_horasextras_porDia", GXv_boolean2) ;
      convenio_horasextras_pordiawwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV67Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "Convenio_horasextras_porDiaWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV37TFConveHsExSec) && (0==AV38TFConveHsExSec_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Secuencial", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV37TFConveHsExSec );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV38TFConveHsExSec_To );
      }
      if ( ! ( ( AV40TFConvHsPDiaTipTra_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de trabajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV57i = 1 ;
         AV68GXV1 = 1 ;
         while ( AV68GXV1 <= AV40TFConvHsPDiaTipTra_Sels.size() )
         {
            AV41TFConvHsPDiaTipTra_Sel = (String)AV40TFConvHsPDiaTipTra_Sels.elementAt(-1+AV68GXV1) ;
            if ( AV57i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)AV41TFConvHsPDiaTipTra_Sel), "") );
            AV57i = (long)(AV57i+1) ;
            AV68GXV1 = (int)(AV68GXV1+1) ;
         }
      }
      if ( ! ( ( AV43TFConveHsPDiaDia_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Día", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV57i = 1 ;
         AV69GXV2 = 1 ;
         while ( AV69GXV2 <= AV43TFConveHsPDiaDia_Sels.size() )
         {
            AV44TFConveHsPDiaDia_Sel = ((Number) AV43TFConveHsPDiaDia_Sels.elementAt(-1+AV69GXV2)).byteValue() ;
            if ( AV57i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaindia_tra.getDescription(httpContext,(byte)AV44TFConveHsPDiaDia_Sel), "") );
            AV57i = (long)(AV57i+1) ;
            AV69GXV2 = (int)(AV69GXV2+1) ;
         }
      }
      if ( ! ( ( AV47TFConveHsPDiaDesde_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Hora desde", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV57i = 1 ;
         AV70GXV3 = 1 ;
         while ( AV70GXV3 <= AV47TFConveHsPDiaDesde_Sels.size() )
         {
            AV48TFConveHsPDiaDesde_Sel = (String)AV47TFConveHsPDiaDesde_Sels.elementAt(-1+AV70GXV3) ;
            if ( AV57i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFConveHsPDiaDesde_Sel, GXv_char7) ;
            convenio_horasextras_pordiawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV57i = (long)(AV57i+1) ;
            AV70GXV3 = (int)(AV70GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV46TFConveHsPDiaDesde)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Hora desde", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            convenio_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFConveHsPDiaDesde, GXv_char7) ;
            convenio_horasextras_pordiawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49TFConveTarifaPDia)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFConveTarifaPDia_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Aumento de horas extras sobre hora normal", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV49TFConveTarifaPDia)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV50TFConveTarifaPDia_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFConveTarifaPDRec)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFConveTarifaPDRec_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Recargo a hora normal diurna", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV51TFConveTarifaPDRec)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV52TFConveTarifaPDRec_To)) );
      }
      if ( ! ( ( AV63TFConveTarifaPDCri_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Criterio", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV57i = 1 ;
         AV71GXV4 = 1 ;
         while ( AV71GXV4 <= AV63TFConveTarifaPDCri_Sels.size() )
         {
            AV64TFConveTarifaPDCri_Sel = (String)AV63TFConveTarifaPDCri_Sels.elementAt(-1+AV71GXV4) ;
            if ( AV57i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomaincriterio_horaextra.getDescription(httpContext,(String)AV64TFConveTarifaPDCri_Sel), "") );
            AV57i = (long)(AV57i+1) ;
            AV71GXV4 = (int)(AV71GXV4+1) ;
         }
      }
      if ( ! ( ( AV55TFConveHsPdiaRelRef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         convenio_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV57i = 1 ;
         AV72GXV5 = 1 ;
         while ( AV72GXV5 <= AV55TFConveHsPdiaRelRef_Sels.size() )
         {
            AV56TFConveHsPdiaRelRef_Sel = (String)AV55TFConveHsPdiaRelRef_Sels.elementAt(-1+AV72GXV5) ;
            if ( AV57i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV56TFConveHsPdiaRelRef_Sel, GXv_char7) ;
            convenio_horasextras_pordiawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV57i = (long)(AV57i+1) ;
            AV72GXV5 = (int)(AV72GXV5+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV54TFConveHsPdiaRelRef)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            convenio_horasextras_pordiawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV54TFConveHsPdiaRelRef, GXv_char7) ;
            convenio_horasextras_pordiawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV34VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("Convenio_horasextras_porDiaWWColumnsSelector"), "") != 0 )
      {
         AV29ColumnsSelectorXML = AV20Session.getValue("Convenio_horasextras_porDiaWWColumnsSelector") ;
         AV26ColumnsSelector.fromxml(AV29ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV24IsAuthorizedConveHsPdiaRelRef&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV73GXV6 = 1 ;
      while ( AV73GXV6 <= AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV28ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV73GXV6));
         if ( AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setColor( 11 );
            AV34VisibleColumnCount = (long)(AV34VisibleColumnCount+1) ;
         }
         AV73GXV6 = (int)(AV73GXV6+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV75Convenio_horasextras_pordiawwds_1_tfconvehsexsec = AV37TFConveHsExSec ;
      AV76Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to = AV38TFConveHsExSec_To ;
      AV77Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels = AV40TFConvHsPDiaTipTra_Sels ;
      AV78Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels = AV43TFConveHsPDiaDia_Sels ;
      AV79Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = AV46TFConveHsPDiaDesde ;
      AV80Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels = AV47TFConveHsPDiaDesde_Sels ;
      AV81Convenio_horasextras_pordiawwds_7_tfconvetarifapdia = AV49TFConveTarifaPDia ;
      AV82Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to = AV50TFConveTarifaPDia_To ;
      AV83Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec = AV51TFConveTarifaPDRec ;
      AV84Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to = AV52TFConveTarifaPDRec_To ;
      AV85Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels = AV63TFConveTarifaPDCri_Sels ;
      AV86Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = AV54TFConveHsPdiaRelRef ;
      AV87Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels = AV55TFConveHsPdiaRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1326ConvHsPDiaTipTra ,
                                           AV77Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels ,
                                           Byte.valueOf(A1328ConveHsPDiaDia) ,
                                           AV78Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels ,
                                           A1329ConveHsPDiaDesde ,
                                           AV80Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels ,
                                           A2432ConveTarifaPDCri ,
                                           AV85Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels ,
                                           A2067ConveHsPdiaRelRef ,
                                           AV87Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels ,
                                           Short.valueOf(AV75Convenio_horasextras_pordiawwds_1_tfconvehsexsec) ,
                                           Short.valueOf(AV76Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to) ,
                                           Integer.valueOf(AV77Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels.size()) ,
                                           Integer.valueOf(AV78Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels.size()) ,
                                           Integer.valueOf(AV80Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels.size()) ,
                                           AV79Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ,
                                           AV81Convenio_horasextras_pordiawwds_7_tfconvetarifapdia ,
                                           AV82Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to ,
                                           AV83Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec ,
                                           AV84Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to ,
                                           Integer.valueOf(AV85Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels.size()) ,
                                           Integer.valueOf(AV87Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels.size()) ,
                                           AV86Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ,
                                           Short.valueOf(A1327ConveHsExSec) ,
                                           A1330ConveTarifaPDia ,
                                           A1350ConveTarifaPDRec ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV58CliCod) ,
                                           Short.valueOf(AV60PaiCod) ,
                                           AV61ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV79Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = GXutil.padr( GXutil.rtrim( AV79Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde), 5, "%") ;
      lV86Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = GXutil.concat( GXutil.rtrim( AV86Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref), "%", "") ;
      /* Using cursor P02FJ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV60PaiCod), AV61ConveCodigo, Short.valueOf(AV75Convenio_horasextras_pordiawwds_1_tfconvehsexsec), Short.valueOf(AV76Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to), lV79Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde, AV81Convenio_horasextras_pordiawwds_7_tfconvetarifapdia, AV82Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to, AV83Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec, AV84Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to, lV86Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P02FJ2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P02FJ2_A1564CliPaiConve[0] ;
         A3CliCod = P02FJ2_A3CliCod[0] ;
         A2067ConveHsPdiaRelRef = P02FJ2_A2067ConveHsPdiaRelRef[0] ;
         A2432ConveTarifaPDCri = P02FJ2_A2432ConveTarifaPDCri[0] ;
         A1350ConveTarifaPDRec = P02FJ2_A1350ConveTarifaPDRec[0] ;
         A1330ConveTarifaPDia = P02FJ2_A1330ConveTarifaPDia[0] ;
         A1329ConveHsPDiaDesde = P02FJ2_A1329ConveHsPDiaDesde[0] ;
         n1329ConveHsPDiaDesde = P02FJ2_n1329ConveHsPDiaDesde[0] ;
         A1328ConveHsPDiaDia = P02FJ2_A1328ConveHsPDiaDia[0] ;
         A1326ConvHsPDiaTipTra = P02FJ2_A1326ConvHsPDiaTipTra[0] ;
         A1327ConveHsExSec = P02FJ2_A1327ConveHsExSec[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV34VisibleColumnCount = 0 ;
         AV88GXV7 = 1 ;
         while ( AV88GXV7 <= AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV28ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV88GXV7));
            if ( AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsExSec") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setNumber( A1327ConveHsExSec );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConvHsPDiaTipTra") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaintipo_trabajo.getDescription(httpContext,(String)A1326ConvHsPDiaTipTra), "") );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsPDiaDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaindia_tra.getDescription(httpContext,(byte)A1328ConveHsPDiaDia), "") );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsPDiaDesde") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1329ConveHsPDiaDesde, GXv_char7) ;
                  convenio_horasextras_pordiawwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveTarifaPDia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1330ConveTarifaPDia)) );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveTarifaPDRec") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1350ConveTarifaPDRec)) );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveTarifaPDCri") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomaincriterio_horaextra.getDescription(httpContext,(String)A2432ConveTarifaPDCri), "") );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveHsPdiaRelRef") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2067ConveHsPdiaRelRef, GXv_char7) ;
                  convenio_horasextras_pordiawwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV34VisibleColumnCount = (long)(AV34VisibleColumnCount+1) ;
            }
            AV88GXV7 = (int)(AV88GXV7+1) ;
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
      GXt_boolean1 = AV24IsAuthorizedConveHsPdiaRelRef ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV58CliCod, GXv_boolean2) ;
      convenio_horasextras_pordiawwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV24IsAuthorizedConveHsPdiaRelRef = (boolean)((!GXt_boolean1)) ;
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
      AV26ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveHsExSec", "", "Secuencial", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConvHsPDiaTipTra", "", "Tipo de trabajo", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveHsPDiaDia", "", "Día", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveHsPDiaDesde", "", "Hora desde", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveTarifaPDia", "", "Aumento de horas extras sobre hora normal", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveTarifaPDRec", "", "Recargo a hora normal diurna", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveTarifaPDCri", "", "Criterio", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV58CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConveHsPdiaRelRef", "", "Liberación", true, "") ;
         AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "", "", "", false, "") ;
         AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      }
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV30UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Convenio_horasextras_porDiaWWColumnsSelector", GXv_char7) ;
      convenio_horasextras_pordiawwexport.this.GXt_char6 = GXv_char7[0] ;
      AV30UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV30UserCustomValue)==0) ) )
      {
         AV27ColumnsSelectorAux.fromxml(AV30UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV27ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV27ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("Convenio_horasextras_porDiaWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Convenio_horasextras_porDiaWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("Convenio_horasextras_porDiaWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV89GXV8 = 1 ;
      while ( AV89GXV8 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV89GXV8));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSEXSEC") == 0 )
         {
            AV37TFConveHsExSec = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV38TFConveHsExSec_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVHSPDIATIPTRA_SEL") == 0 )
         {
            AV39TFConvHsPDiaTipTra_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFConvHsPDiaTipTra_Sels.fromJSonString(AV39TFConvHsPDiaTipTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIADIA_SEL") == 0 )
         {
            AV42TFConveHsPDiaDia_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFConveHsPDiaDia_Sels.fromJSonString(AV42TFConveHsPDiaDia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIADESDE") == 0 )
         {
            AV46TFConveHsPDiaDesde = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIADESDE_SEL") == 0 )
         {
            AV45TFConveHsPDiaDesde_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFConveHsPDiaDesde_Sels.fromJSonString(AV45TFConveHsPDiaDesde_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVETARIFAPDIA") == 0 )
         {
            AV49TFConveTarifaPDia = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV50TFConveTarifaPDia_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVETARIFAPDREC") == 0 )
         {
            AV51TFConveTarifaPDRec = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV52TFConveTarifaPDRec_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVETARIFAPDCRI_SEL") == 0 )
         {
            AV62TFConveTarifaPDCri_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV63TFConveTarifaPDCri_Sels.fromJSonString(AV62TFConveTarifaPDCri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIARELREF") == 0 )
         {
            AV54TFConveHsPdiaRelRef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIARELREF_SEL") == 0 )
         {
            AV53TFConveHsPdiaRelRef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV55TFConveHsPdiaRelRef_Sels.fromJSonString(AV53TFConveHsPdiaRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV89GXV8 = (int)(AV89GXV8+1) ;
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
      this.aP0[0] = convenio_horasextras_pordiawwexport.this.AV12Filename;
      this.aP1[0] = convenio_horasextras_pordiawwexport.this.AV13ErrorMessage;
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
      AV67Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV40TFConvHsPDiaTipTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41TFConvHsPDiaTipTra_Sel = "" ;
      AV43TFConveHsPDiaDia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV47TFConveHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFConveHsPDiaDesde_Sel = "" ;
      AV46TFConveHsPDiaDesde = "" ;
      AV49TFConveTarifaPDia = DecimalUtil.ZERO ;
      AV50TFConveTarifaPDia_To = DecimalUtil.ZERO ;
      AV51TFConveTarifaPDRec = DecimalUtil.ZERO ;
      AV52TFConveTarifaPDRec_To = DecimalUtil.ZERO ;
      AV63TFConveTarifaPDCri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64TFConveTarifaPDCri_Sel = "" ;
      AV55TFConveHsPdiaRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56TFConveHsPdiaRelRef_Sel = "" ;
      AV54TFConveHsPdiaRelRef = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV29ColumnsSelectorXML = "" ;
      AV26ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV28ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1326ConvHsPDiaTipTra = "" ;
      A1329ConveHsPDiaDesde = "" ;
      A1330ConveTarifaPDia = DecimalUtil.ZERO ;
      A1350ConveTarifaPDRec = DecimalUtil.ZERO ;
      A2432ConveTarifaPDCri = "" ;
      A2067ConveHsPdiaRelRef = "" ;
      AV77Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV78Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV79Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = "" ;
      AV80Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV81Convenio_horasextras_pordiawwds_7_tfconvetarifapdia = DecimalUtil.ZERO ;
      AV82Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to = DecimalUtil.ZERO ;
      AV83Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec = DecimalUtil.ZERO ;
      AV84Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to = DecimalUtil.ZERO ;
      AV85Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV86Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = "" ;
      AV87Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV79Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = "" ;
      lV86Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = "" ;
      AV61ConveCodigo = "" ;
      A1565CliConvenio = "" ;
      P02FJ2_A1565CliConvenio = new String[] {""} ;
      P02FJ2_A1564CliPaiConve = new short[1] ;
      P02FJ2_A3CliCod = new int[1] ;
      P02FJ2_A2067ConveHsPdiaRelRef = new String[] {""} ;
      P02FJ2_A2432ConveTarifaPDCri = new String[] {""} ;
      P02FJ2_A1350ConveTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FJ2_A1330ConveTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02FJ2_A1329ConveHsPDiaDesde = new String[] {""} ;
      P02FJ2_n1329ConveHsPDiaDesde = new boolean[] {false} ;
      P02FJ2_A1328ConveHsPDiaDia = new byte[1] ;
      P02FJ2_A1326ConvHsPDiaTipTra = new String[] {""} ;
      P02FJ2_A1327ConveHsExSec = new short[1] ;
      GXv_boolean2 = new boolean[1] ;
      AV30UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV27ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV39TFConvHsPDiaTipTra_SelsJson = "" ;
      AV42TFConveHsPDiaDia_SelsJson = "" ;
      AV45TFConveHsPDiaDesde_SelsJson = "" ;
      AV62TFConveTarifaPDCri_SelsJson = "" ;
      AV53TFConveHsPdiaRelRef_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_horasextras_pordiawwexport__default(),
         new Object[] {
             new Object[] {
            P02FJ2_A1565CliConvenio, P02FJ2_A1564CliPaiConve, P02FJ2_A3CliCod, P02FJ2_A2067ConveHsPdiaRelRef, P02FJ2_A2432ConveTarifaPDCri, P02FJ2_A1350ConveTarifaPDRec, P02FJ2_A1330ConveTarifaPDia, P02FJ2_A1329ConveHsPDiaDesde, P02FJ2_n1329ConveHsPDiaDesde, P02FJ2_A1328ConveHsPDiaDia,
            P02FJ2_A1326ConvHsPDiaTipTra, P02FJ2_A1327ConveHsExSec
            }
         }
      );
      AV67Pgmname = "Convenio_horasextras_porDiaWWExport" ;
      /* GeneXus formulas. */
      AV67Pgmname = "Convenio_horasextras_porDiaWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV44TFConveHsPDiaDia_Sel ;
   private byte A1328ConveHsPDiaDia ;
   private short AV37TFConveHsExSec ;
   private short AV38TFConveHsExSec_To ;
   private short GXv_int5[] ;
   private short A1327ConveHsExSec ;
   private short AV75Convenio_horasextras_pordiawwds_1_tfconvehsexsec ;
   private short AV76Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to ;
   private short AV18OrderedBy ;
   private short AV60PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV68GXV1 ;
   private int AV69GXV2 ;
   private int AV70GXV3 ;
   private int AV71GXV4 ;
   private int AV72GXV5 ;
   private int AV73GXV6 ;
   private int AV77Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels_size ;
   private int AV78Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels_size ;
   private int AV80Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size ;
   private int AV85Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels_size ;
   private int AV87Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size ;
   private int AV58CliCod ;
   private int A3CliCod ;
   private int AV88GXV7 ;
   private int AV89GXV8 ;
   private long AV57i ;
   private long AV34VisibleColumnCount ;
   private java.math.BigDecimal AV49TFConveTarifaPDia ;
   private java.math.BigDecimal AV50TFConveTarifaPDia_To ;
   private java.math.BigDecimal AV51TFConveTarifaPDRec ;
   private java.math.BigDecimal AV52TFConveTarifaPDRec_To ;
   private java.math.BigDecimal A1330ConveTarifaPDia ;
   private java.math.BigDecimal A1350ConveTarifaPDRec ;
   private java.math.BigDecimal AV81Convenio_horasextras_pordiawwds_7_tfconvetarifapdia ;
   private java.math.BigDecimal AV82Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to ;
   private java.math.BigDecimal AV83Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec ;
   private java.math.BigDecimal AV84Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to ;
   private String AV67Pgmname ;
   private String AV41TFConvHsPDiaTipTra_Sel ;
   private String AV48TFConveHsPDiaDesde_Sel ;
   private String AV46TFConveHsPDiaDesde ;
   private String AV64TFConveTarifaPDCri_Sel ;
   private String A1326ConvHsPDiaTipTra ;
   private String A1329ConveHsPDiaDesde ;
   private String A2432ConveTarifaPDCri ;
   private String AV79Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ;
   private String scmdbuf ;
   private String lV79Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ;
   private String AV61ConveCodigo ;
   private String A1565CliConvenio ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV24IsAuthorizedConveHsPdiaRelRef ;
   private boolean AV19OrderedDsc ;
   private boolean n1329ConveHsPDiaDesde ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean Cond_result ;
   private String AV29ColumnsSelectorXML ;
   private String AV30UserCustomValue ;
   private String AV39TFConvHsPDiaTipTra_SelsJson ;
   private String AV42TFConveHsPDiaDia_SelsJson ;
   private String AV45TFConveHsPDiaDesde_SelsJson ;
   private String AV62TFConveTarifaPDCri_SelsJson ;
   private String AV53TFConveHsPdiaRelRef_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV56TFConveHsPdiaRelRef_Sel ;
   private String AV54TFConveHsPdiaRelRef ;
   private String A2067ConveHsPdiaRelRef ;
   private String AV86Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ;
   private String lV86Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ;
   private String AV17MenuOpcCod ;
   private GXSimpleCollection<Byte> AV43TFConveHsPDiaDia_Sels ;
   private GXSimpleCollection<Byte> AV78Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV40TFConvHsPDiaTipTra_Sels ;
   private GXSimpleCollection<String> AV47TFConveHsPDiaDesde_Sels ;
   private GXSimpleCollection<String> AV63TFConveTarifaPDCri_Sels ;
   private GXSimpleCollection<String> AV55TFConveHsPdiaRelRef_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P02FJ2_A1565CliConvenio ;
   private short[] P02FJ2_A1564CliPaiConve ;
   private int[] P02FJ2_A3CliCod ;
   private String[] P02FJ2_A2067ConveHsPdiaRelRef ;
   private String[] P02FJ2_A2432ConveTarifaPDCri ;
   private java.math.BigDecimal[] P02FJ2_A1350ConveTarifaPDRec ;
   private java.math.BigDecimal[] P02FJ2_A1330ConveTarifaPDia ;
   private String[] P02FJ2_A1329ConveHsPDiaDesde ;
   private boolean[] P02FJ2_n1329ConveHsPDiaDesde ;
   private byte[] P02FJ2_A1328ConveHsPDiaDia ;
   private String[] P02FJ2_A1326ConvHsPDiaTipTra ;
   private short[] P02FJ2_A1327ConveHsExSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV77Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels ;
   private GXSimpleCollection<String> AV80Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels ;
   private GXSimpleCollection<String> AV85Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels ;
   private GXSimpleCollection<String> AV87Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV27ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV28ColumnsSelector_Column ;
}

final  class convenio_horasextras_pordiawwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FJ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1326ConvHsPDiaTipTra ,
                                          GXSimpleCollection<String> AV77Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels ,
                                          byte A1328ConveHsPDiaDia ,
                                          GXSimpleCollection<Byte> AV78Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels ,
                                          String A1329ConveHsPDiaDesde ,
                                          GXSimpleCollection<String> AV80Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels ,
                                          String A2432ConveTarifaPDCri ,
                                          GXSimpleCollection<String> AV85Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels ,
                                          String A2067ConveHsPdiaRelRef ,
                                          GXSimpleCollection<String> AV87Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels ,
                                          short AV75Convenio_horasextras_pordiawwds_1_tfconvehsexsec ,
                                          short AV76Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to ,
                                          int AV77Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels_size ,
                                          int AV78Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels_size ,
                                          int AV80Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size ,
                                          String AV79Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ,
                                          java.math.BigDecimal AV81Convenio_horasextras_pordiawwds_7_tfconvetarifapdia ,
                                          java.math.BigDecimal AV82Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to ,
                                          java.math.BigDecimal AV83Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec ,
                                          java.math.BigDecimal AV84Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to ,
                                          int AV85Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels_size ,
                                          int AV87Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size ,
                                          String AV86Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ,
                                          short A1327ConveHsExSec ,
                                          java.math.BigDecimal A1330ConveTarifaPDia ,
                                          java.math.BigDecimal A1350ConveTarifaPDRec ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV58CliCod ,
                                          short AV60PaiCod ,
                                          String AV61ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[11];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliPaiConve, CliCod, ConveHsPdiaRelRef, ConveTarifaPDCri, ConveTarifaPDRec, ConveTarifaPDia, ConveHsPDiaDesde, ConveHsPDiaDia, ConvHsPDiaTipTra," ;
      scmdbuf += " ConveHsExSec FROM Convenio_horasextras_porDia" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( ! (0==AV75Convenio_horasextras_pordiawwds_1_tfconvehsexsec) )
      {
         addWhere(sWhereString, "(ConveHsExSec >= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! (0==AV76Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to) )
      {
         addWhere(sWhereString, "(ConveHsExSec <= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV77Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels, "ConvHsPDiaTipTra IN (", ")")+")");
      }
      if ( AV78Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels, "ConveHsPDiaDia IN (", ")")+")");
      }
      if ( ( AV80Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV79Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsPDiaDesde) like LOWER(?))");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV80Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels, "ConveHsPDiaDesde IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81Convenio_horasextras_pordiawwds_7_tfconvetarifapdia)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDia >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV82Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDia <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDRec >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV84Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDRec <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( AV85Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV85Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels, "ConveTarifaPDCri IN (", ")")+")");
      }
      if ( ( AV87Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV86Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsPdiaRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( AV87Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV87Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels, "ConveHsPdiaRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsExSec" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsExSec DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConvHsPDiaTipTra" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConvHsPDiaTipTra DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsPDiaDia" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsPDiaDia DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsPDiaDesde" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsPDiaDesde DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveTarifaPDia" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveTarifaPDia DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveTarifaPDRec" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveTarifaPDRec DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveTarifaPDCri" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveTarifaPDCri DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConveHsPdiaRelRef" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConveHsPdiaRelRef DESC" ;
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
                  return conditional_P02FJ2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).shortValue() , ((Boolean) dynConstraints[27]).booleanValue() , ((Number) dynConstraints[28]).intValue() , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FJ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((String[]) buf[7])[0] = rslt.getString(8, 5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 20);
               ((short[]) buf[11])[0] = rslt.getShort(11);
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
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 5);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 4);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 4);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 40);
               }
               return;
      }
   }

}

