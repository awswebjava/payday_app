package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptomotivosegresowwexport extends GXProcedure
{
   public conceptomotivosegresowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptomotivosegresowwexport.class ), "" );
   }

   public conceptomotivosegresowwexport( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      conceptomotivosegresowwexport.this.aP1 = new String[] {""};
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
      conceptomotivosegresowwexport.this.aP0 = aP0;
      conceptomotivosegresowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV54CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptomotivosegresowwexport.this.GXt_int1 = GXv_int2[0] ;
      AV54CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoMotivosEgreso", GXv_boolean4) ;
      conceptomotivosegresowwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV63Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext5[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
         AV9WWPContext = GXv_SdtWWPContext5[0] ;
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
      AV12Filename = "ConceptoMotivosEgresoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV35TFCliCod) && (0==AV36TFCliCod_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Cod", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptomotivosegresowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFCliCod );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptomotivosegresowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFCliCod_To );
      }
      if ( ! ( ( AV58TFConCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptomotivosegresowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV53i = 1 ;
         AV64GXV1 = 1 ;
         while ( AV64GXV1 <= AV58TFConCodigo_Sels.size() )
         {
            AV59TFConCodigo_Sel = (String)AV58TFConCodigo_Sels.elementAt(-1+AV64GXV1) ;
            if ( AV53i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV59TFConCodigo_Sel, GXv_char9) ;
            conceptomotivosegresowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV53i = (long)(AV53i+1) ;
            AV64GXV1 = (int)(AV64GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV57TFConCodigo)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptomotivosegresowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV57TFConCodigo, GXv_char9) ;
            conceptomotivosegresowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV41TFMegCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Motivo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptomotivosegresowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV53i = 1 ;
         AV65GXV2 = 1 ;
         while ( AV65GXV2 <= AV41TFMegCodigo_Sels.size() )
         {
            AV42TFMegCodigo_Sel = (String)AV41TFMegCodigo_Sels.elementAt(-1+AV65GXV2) ;
            if ( AV53i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFMegCodigo_Sel, GXv_char9) ;
            conceptomotivosegresowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV53i = (long)(AV53i+1) ;
            AV65GXV2 = (int)(AV65GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFMegCodigo)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Motivo", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptomotivosegresowwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFMegCodigo, GXv_char9) ;
            conceptomotivosegresowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV44TFMegPreaTipo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Preaviso", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptomotivosegresowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV53i = 1 ;
         AV66GXV3 = 1 ;
         while ( AV66GXV3 <= AV44TFMegPreaTipo_Sels.size() )
         {
            AV45TFMegPreaTipo_Sel = (String)AV44TFMegPreaTipo_Sels.elementAt(-1+AV66GXV3) ;
            if ( AV53i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFMegPreaTipo_Sel, GXv_char9) ;
            conceptomotivosegresowwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV53i = (long)(AV53i+1) ;
            AV66GXV3 = (int)(AV66GXV3+1) ;
         }
      }
      if ( ! ( (0==AV46TFConMegMeses) && (0==AV47TFConMegMeses_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Con antiguedad mayor a", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptomotivosegresowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV46TFConMegMeses );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptomotivosegresowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV47TFConMegMeses_To );
      }
      if ( ! ( ( AV49TFConMegDura_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "meses o años", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptomotivosegresowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV53i = 1 ;
         AV67GXV4 = 1 ;
         while ( AV67GXV4 <= AV49TFConMegDura_Sels.size() )
         {
            AV50TFConMegDura_Sel = (String)AV49TFConMegDura_Sels.elementAt(-1+AV67GXV4) ;
            if ( AV53i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainduracion_tipo2.getDescription(httpContext,(String)AV50TFConMegDura_Sel), "") );
            AV53i = (long)(AV53i+1) ;
            AV67GXV4 = (int)(AV67GXV4+1) ;
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFConMegPropor)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFConMegPropor_To)==0) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Proporción", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptomotivosegresowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV51TFConMegPropor)) );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptomotivosegresowwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV52TFConMegPropor_To)) );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("ConceptoMotivosEgresoWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("ConceptoMotivosEgresoWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV68GXV5 = 1 ;
      while ( AV68GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV68GXV5));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV68GXV5 = (int)(AV68GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV70Conceptomotivosegresowwds_1_tfclicod = AV35TFCliCod ;
      AV71Conceptomotivosegresowwds_2_tfclicod_to = AV36TFCliCod_To ;
      AV72Conceptomotivosegresowwds_3_tfconcodigo = AV57TFConCodigo ;
      AV73Conceptomotivosegresowwds_4_tfconcodigo_sels = AV58TFConCodigo_Sels ;
      AV74Conceptomotivosegresowwds_5_tfmegcodigo = AV40TFMegCodigo ;
      AV75Conceptomotivosegresowwds_6_tfmegcodigo_sels = AV41TFMegCodigo_Sels ;
      AV76Conceptomotivosegresowwds_7_tfmegpreatipo_sels = AV44TFMegPreaTipo_Sels ;
      AV77Conceptomotivosegresowwds_8_tfconmegmeses = AV46TFConMegMeses ;
      AV78Conceptomotivosegresowwds_9_tfconmegmeses_to = AV47TFConMegMeses_To ;
      AV79Conceptomotivosegresowwds_10_tfconmegdura_sels = AV49TFConMegDura_Sels ;
      AV80Conceptomotivosegresowwds_11_tfconmegpropor = AV51TFConMegPropor ;
      AV81Conceptomotivosegresowwds_12_tfconmegpropor_to = AV52TFConMegPropor_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV73Conceptomotivosegresowwds_4_tfconcodigo_sels ,
                                           A11MegCodigo ,
                                           AV75Conceptomotivosegresowwds_6_tfmegcodigo_sels ,
                                           A1532MegPreaTipo ,
                                           AV76Conceptomotivosegresowwds_7_tfmegpreatipo_sels ,
                                           A1534ConMegDura ,
                                           AV79Conceptomotivosegresowwds_10_tfconmegdura_sels ,
                                           Integer.valueOf(AV70Conceptomotivosegresowwds_1_tfclicod) ,
                                           Integer.valueOf(AV71Conceptomotivosegresowwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV73Conceptomotivosegresowwds_4_tfconcodigo_sels.size()) ,
                                           AV72Conceptomotivosegresowwds_3_tfconcodigo ,
                                           Integer.valueOf(AV75Conceptomotivosegresowwds_6_tfmegcodigo_sels.size()) ,
                                           AV74Conceptomotivosegresowwds_5_tfmegcodigo ,
                                           Integer.valueOf(AV76Conceptomotivosegresowwds_7_tfmegpreatipo_sels.size()) ,
                                           Byte.valueOf(AV77Conceptomotivosegresowwds_8_tfconmegmeses) ,
                                           Byte.valueOf(AV78Conceptomotivosegresowwds_9_tfconmegmeses_to) ,
                                           Integer.valueOf(AV79Conceptomotivosegresowwds_10_tfconmegdura_sels.size()) ,
                                           AV80Conceptomotivosegresowwds_11_tfconmegpropor ,
                                           AV81Conceptomotivosegresowwds_12_tfconmegpropor_to ,
                                           Integer.valueOf(A3CliCod) ,
                                           Byte.valueOf(A1530ConMegMeses) ,
                                           A1529ConMegPropor ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV54CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT
                                           }
      });
      lV72Conceptomotivosegresowwds_3_tfconcodigo = GXutil.padr( GXutil.rtrim( AV72Conceptomotivosegresowwds_3_tfconcodigo), 10, "%") ;
      lV74Conceptomotivosegresowwds_5_tfmegcodigo = GXutil.padr( GXutil.rtrim( AV74Conceptomotivosegresowwds_5_tfmegcodigo), 20, "%") ;
      /* Using cursor P01KN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV54CliCod), Integer.valueOf(AV70Conceptomotivosegresowwds_1_tfclicod), Integer.valueOf(AV71Conceptomotivosegresowwds_2_tfclicod_to), lV72Conceptomotivosegresowwds_3_tfconcodigo, lV74Conceptomotivosegresowwds_5_tfmegcodigo, Byte.valueOf(AV77Conceptomotivosegresowwds_8_tfconmegmeses), Byte.valueOf(AV78Conceptomotivosegresowwds_9_tfconmegmeses_to), AV80Conceptomotivosegresowwds_11_tfconmegpropor, AV81Conceptomotivosegresowwds_12_tfconmegpropor_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1529ConMegPropor = P01KN2_A1529ConMegPropor[0] ;
         A1534ConMegDura = P01KN2_A1534ConMegDura[0] ;
         A1530ConMegMeses = P01KN2_A1530ConMegMeses[0] ;
         A1532MegPreaTipo = P01KN2_A1532MegPreaTipo[0] ;
         A11MegCodigo = P01KN2_A11MegCodigo[0] ;
         A26ConCodigo = P01KN2_A26ConCodigo[0] ;
         A3CliCod = P01KN2_A3CliCod[0] ;
         A2077ConMegSec = P01KN2_A2077ConMegSec[0] ;
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
         AV82GXV6 = 1 ;
         while ( AV82GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV82GXV6));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A3CliCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConCodigo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A26ConCodigo, GXv_char9) ;
                  conceptomotivosegresowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MegCodigo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A11MegCodigo, GXv_char9) ;
                  conceptomotivosegresowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "MegPreaTipo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1532MegPreaTipo, GXv_char9) ;
                  conceptomotivosegresowwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConMegMeses") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1530ConMegMeses );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConMegDura") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainduracion_tipo2.getDescription(httpContext,(String)A1534ConMegDura), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConMegPropor") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1529ConMegPropor)) );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV82GXV6 = (int)(AV82GXV6+1) ;
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
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "CliCod", "", "Cod", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConCodigo", "", "Código", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "MegCodigo", "", "Motivo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "MegPreaTipo", "", "Preaviso", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConMegMeses", "", "Con antiguedad mayor a", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConMegDura", "", "meses o años", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConMegPropor", "", "Proporción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXt_char8 = AV28UserCustomValue ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ConceptoMotivosEgresoWWColumnsSelector", GXv_char9) ;
      conceptomotivosegresowwexport.this.GXt_char8 = GXv_char9[0] ;
      AV28UserCustomValue = GXt_char8 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, GXv_SdtWWPColumnsSelector11) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector10[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("ConceptoMotivosEgresoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ConceptoMotivosEgresoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ConceptoMotivosEgresoWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV83GXV7 = 1 ;
      while ( AV83GXV7 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV83GXV7));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV35TFCliCod = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFCliCod_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV57TFConCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV56TFConCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV58TFConCodigo_Sels.fromJSonString(AV56TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGCODIGO") == 0 )
         {
            AV40TFMegCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGCODIGO_SEL") == 0 )
         {
            AV39TFMegCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFMegCodigo_Sels.fromJSonString(AV39TFMegCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGPREATIPO_SEL") == 0 )
         {
            AV43TFMegPreaTipo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFMegPreaTipo_Sels.fromJSonString(AV43TFMegPreaTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONMEGMESES") == 0 )
         {
            AV46TFConMegMeses = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV47TFConMegMeses_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONMEGDURA_SEL") == 0 )
         {
            AV48TFConMegDura_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFConMegDura_Sels.fromJSonString(AV48TFConMegDura_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONMEGPROPOR") == 0 )
         {
            AV51TFConMegPropor = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV52TFConMegPropor_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV60MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV83GXV7 = (int)(AV83GXV7+1) ;
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
      this.aP0[0] = conceptomotivosegresowwexport.this.AV12Filename;
      this.aP1[0] = conceptomotivosegresowwexport.this.AV13ErrorMessage;
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
      GXv_int2 = new int[1] ;
      GXv_boolean4 = new boolean[1] ;
      AV63Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV58TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59TFConCodigo_Sel = "" ;
      AV57TFConCodigo = "" ;
      AV41TFMegCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFMegCodigo_Sel = "" ;
      AV40TFMegCodigo = "" ;
      AV44TFMegPreaTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFMegPreaTipo_Sel = "" ;
      AV49TFConMegDura_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50TFConMegDura_Sel = "" ;
      AV51TFConMegPropor = DecimalUtil.ZERO ;
      AV52TFConMegPropor_To = DecimalUtil.ZERO ;
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A26ConCodigo = "" ;
      A11MegCodigo = "" ;
      A1532MegPreaTipo = "" ;
      A1534ConMegDura = "" ;
      A1529ConMegPropor = DecimalUtil.ZERO ;
      AV72Conceptomotivosegresowwds_3_tfconcodigo = "" ;
      AV73Conceptomotivosegresowwds_4_tfconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV74Conceptomotivosegresowwds_5_tfmegcodigo = "" ;
      AV75Conceptomotivosegresowwds_6_tfmegcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76Conceptomotivosegresowwds_7_tfmegpreatipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV79Conceptomotivosegresowwds_10_tfconmegdura_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV80Conceptomotivosegresowwds_11_tfconmegpropor = DecimalUtil.ZERO ;
      AV81Conceptomotivosegresowwds_12_tfconmegpropor_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV72Conceptomotivosegresowwds_3_tfconcodigo = "" ;
      lV74Conceptomotivosegresowwds_5_tfmegcodigo = "" ;
      P01KN2_A1529ConMegPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01KN2_A1534ConMegDura = new String[] {""} ;
      P01KN2_A1530ConMegMeses = new byte[1] ;
      P01KN2_A1532MegPreaTipo = new String[] {""} ;
      P01KN2_A11MegCodigo = new String[] {""} ;
      P01KN2_A26ConCodigo = new String[] {""} ;
      P01KN2_A3CliCod = new int[1] ;
      P01KN2_A2077ConMegSec = new short[1] ;
      AV28UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV56TFConCodigo_SelsJson = "" ;
      AV39TFMegCodigo_SelsJson = "" ;
      AV43TFMegPreaTipo_SelsJson = "" ;
      AV48TFConMegDura_SelsJson = "" ;
      AV60MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptomotivosegresowwexport__default(),
         new Object[] {
             new Object[] {
            P01KN2_A1529ConMegPropor, P01KN2_A1534ConMegDura, P01KN2_A1530ConMegMeses, P01KN2_A1532MegPreaTipo, P01KN2_A11MegCodigo, P01KN2_A26ConCodigo, P01KN2_A3CliCod, P01KN2_A2077ConMegSec
            }
         }
      );
      AV63Pgmname = "ConceptoMotivosEgresoWWExport" ;
      /* GeneXus formulas. */
      AV63Pgmname = "ConceptoMotivosEgresoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV46TFConMegMeses ;
   private byte AV47TFConMegMeses_To ;
   private byte A1530ConMegMeses ;
   private byte AV77Conceptomotivosegresowwds_8_tfconmegmeses ;
   private byte AV78Conceptomotivosegresowwds_9_tfconmegmeses_to ;
   private short GXv_int7[] ;
   private short AV18OrderedBy ;
   private short A2077ConMegSec ;
   private short Gx_err ;
   private int AV54CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV35TFCliCod ;
   private int AV36TFCliCod_To ;
   private int AV64GXV1 ;
   private int AV65GXV2 ;
   private int AV66GXV3 ;
   private int AV67GXV4 ;
   private int AV68GXV5 ;
   private int A3CliCod ;
   private int AV70Conceptomotivosegresowwds_1_tfclicod ;
   private int AV71Conceptomotivosegresowwds_2_tfclicod_to ;
   private int AV73Conceptomotivosegresowwds_4_tfconcodigo_sels_size ;
   private int AV75Conceptomotivosegresowwds_6_tfmegcodigo_sels_size ;
   private int AV76Conceptomotivosegresowwds_7_tfmegpreatipo_sels_size ;
   private int AV79Conceptomotivosegresowwds_10_tfconmegdura_sels_size ;
   private int AV82GXV6 ;
   private int AV83GXV7 ;
   private long AV53i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV51TFConMegPropor ;
   private java.math.BigDecimal AV52TFConMegPropor_To ;
   private java.math.BigDecimal A1529ConMegPropor ;
   private java.math.BigDecimal AV80Conceptomotivosegresowwds_11_tfconmegpropor ;
   private java.math.BigDecimal AV81Conceptomotivosegresowwds_12_tfconmegpropor_to ;
   private String AV63Pgmname ;
   private String AV59TFConCodigo_Sel ;
   private String AV57TFConCodigo ;
   private String AV42TFMegCodigo_Sel ;
   private String AV40TFMegCodigo ;
   private String AV45TFMegPreaTipo_Sel ;
   private String AV50TFConMegDura_Sel ;
   private String A26ConCodigo ;
   private String A11MegCodigo ;
   private String A1532MegPreaTipo ;
   private String A1534ConMegDura ;
   private String AV72Conceptomotivosegresowwds_3_tfconcodigo ;
   private String AV74Conceptomotivosegresowwds_5_tfmegcodigo ;
   private String scmdbuf ;
   private String lV72Conceptomotivosegresowwds_3_tfconcodigo ;
   private String lV74Conceptomotivosegresowwds_5_tfmegcodigo ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV56TFConCodigo_SelsJson ;
   private String AV39TFMegCodigo_SelsJson ;
   private String AV43TFMegPreaTipo_SelsJson ;
   private String AV48TFConMegDura_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV60MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV58TFConCodigo_Sels ;
   private GXSimpleCollection<String> AV41TFMegCodigo_Sels ;
   private GXSimpleCollection<String> AV44TFMegPreaTipo_Sels ;
   private GXSimpleCollection<String> AV49TFConMegDura_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P01KN2_A1529ConMegPropor ;
   private String[] P01KN2_A1534ConMegDura ;
   private byte[] P01KN2_A1530ConMegMeses ;
   private String[] P01KN2_A1532MegPreaTipo ;
   private String[] P01KN2_A11MegCodigo ;
   private String[] P01KN2_A26ConCodigo ;
   private int[] P01KN2_A3CliCod ;
   private short[] P01KN2_A2077ConMegSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV73Conceptomotivosegresowwds_4_tfconcodigo_sels ;
   private GXSimpleCollection<String> AV75Conceptomotivosegresowwds_6_tfmegcodigo_sels ;
   private GXSimpleCollection<String> AV76Conceptomotivosegresowwds_7_tfmegpreatipo_sels ;
   private GXSimpleCollection<String> AV79Conceptomotivosegresowwds_10_tfconmegdura_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class conceptomotivosegresowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01KN2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV73Conceptomotivosegresowwds_4_tfconcodigo_sels ,
                                          String A11MegCodigo ,
                                          GXSimpleCollection<String> AV75Conceptomotivosegresowwds_6_tfmegcodigo_sels ,
                                          String A1532MegPreaTipo ,
                                          GXSimpleCollection<String> AV76Conceptomotivosegresowwds_7_tfmegpreatipo_sels ,
                                          String A1534ConMegDura ,
                                          GXSimpleCollection<String> AV79Conceptomotivosegresowwds_10_tfconmegdura_sels ,
                                          int AV70Conceptomotivosegresowwds_1_tfclicod ,
                                          int AV71Conceptomotivosegresowwds_2_tfclicod_to ,
                                          int AV73Conceptomotivosegresowwds_4_tfconcodigo_sels_size ,
                                          String AV72Conceptomotivosegresowwds_3_tfconcodigo ,
                                          int AV75Conceptomotivosegresowwds_6_tfmegcodigo_sels_size ,
                                          String AV74Conceptomotivosegresowwds_5_tfmegcodigo ,
                                          int AV76Conceptomotivosegresowwds_7_tfmegpreatipo_sels_size ,
                                          byte AV77Conceptomotivosegresowwds_8_tfconmegmeses ,
                                          byte AV78Conceptomotivosegresowwds_9_tfconmegmeses_to ,
                                          int AV79Conceptomotivosegresowwds_10_tfconmegdura_sels_size ,
                                          java.math.BigDecimal AV80Conceptomotivosegresowwds_11_tfconmegpropor ,
                                          java.math.BigDecimal AV81Conceptomotivosegresowwds_12_tfconmegpropor_to ,
                                          int A3CliCod ,
                                          byte A1530ConMegMeses ,
                                          java.math.BigDecimal A1529ConMegPropor ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV54CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[9];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT ConMegPropor, ConMegDura, ConMegMeses, MegPreaTipo, MegCodigo, ConCodigo, CliCod, ConMegSec FROM ConceptoMotivosEgreso" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV70Conceptomotivosegresowwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int12[1] = (byte)(1) ;
      }
      if ( ! (0==AV71Conceptomotivosegresowwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( ( AV73Conceptomotivosegresowwds_4_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Conceptomotivosegresowwds_3_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( AV73Conceptomotivosegresowwds_4_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Conceptomotivosegresowwds_4_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ( AV75Conceptomotivosegresowwds_6_tfmegcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Conceptomotivosegresowwds_5_tfmegcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( AV75Conceptomotivosegresowwds_6_tfmegcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Conceptomotivosegresowwds_6_tfmegcodigo_sels, "MegCodigo IN (", ")")+")");
      }
      if ( AV76Conceptomotivosegresowwds_7_tfmegpreatipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Conceptomotivosegresowwds_7_tfmegpreatipo_sels, "MegPreaTipo IN (", ")")+")");
      }
      if ( ! (0==AV77Conceptomotivosegresowwds_8_tfconmegmeses) )
      {
         addWhere(sWhereString, "(ConMegMeses >= ?)");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( ! (0==AV78Conceptomotivosegresowwds_9_tfconmegmeses_to) )
      {
         addWhere(sWhereString, "(ConMegMeses <= ?)");
      }
      else
      {
         GXv_int12[6] = (byte)(1) ;
      }
      if ( AV79Conceptomotivosegresowwds_10_tfconmegdura_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79Conceptomotivosegresowwds_10_tfconmegdura_sels, "ConMegDura IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Conceptomotivosegresowwds_11_tfconmegpropor)==0) )
      {
         addWhere(sWhereString, "(ConMegPropor >= ?)");
      }
      else
      {
         GXv_int12[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81Conceptomotivosegresowwds_12_tfconmegpropor_to)==0) )
      {
         addWhere(sWhereString, "(ConMegPropor <= ?)");
      }
      else
      {
         GXv_int12[8] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConCodigo" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MegCodigo" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MegCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY MegPreaTipo" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY MegPreaTipo DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConMegMeses" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConMegMeses DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConMegDura" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConMegDura DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConMegPropor" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConMegPropor DESC" ;
      }
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
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
                  return conditional_P01KN2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).byteValue() , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Number) dynConstraints[25]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KN2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
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
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 10);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[14]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               return;
      }
   }

}

