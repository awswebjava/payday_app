package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class siradig_codigoswwexport extends GXProcedure
{
   public siradig_codigoswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( siradig_codigoswwexport.class ), "" );
   }

   public siradig_codigoswwexport( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      siradig_codigoswwexport.this.aP1 = new String[] {""};
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
      siradig_codigoswwexport.this.aP0 = aP0;
      siradig_codigoswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV49CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      siradig_codigoswwexport.this.GXt_int1 = GXv_int2[0] ;
      AV49CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWsiradig_codigos", GXv_boolean4) ;
      siradig_codigoswwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
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
      AV12Filename = "siradig_codigosWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV36TFSiraTipo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         siradig_codigoswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV48i = 1 ;
         AV64GXV1 = 1 ;
         while ( AV64GXV1 <= AV36TFSiraTipo_Sels.size() )
         {
            AV37TFSiraTipo_Sel = (String)AV36TFSiraTipo_Sels.elementAt(-1+AV64GXV1) ;
            if ( AV48i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainsiradigtipo.getDescription(httpContext,(String)AV37TFSiraTipo_Sel), "") );
            AV48i = (long)(AV48i+1) ;
            AV64GXV1 = (int)(AV64GXV1+1) ;
         }
      }
      if ( ! ( ( AV40TFSiraCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Cod. Siradig", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         siradig_codigoswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV48i = 1 ;
         AV65GXV2 = 1 ;
         while ( AV65GXV2 <= AV40TFSiraCodigo_Sels.size() )
         {
            AV41TFSiraCodigo_Sel = (String)AV40TFSiraCodigo_Sels.elementAt(-1+AV65GXV2) ;
            if ( AV48i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFSiraCodigo_Sel, GXv_char9) ;
            siradig_codigoswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV48i = (long)(AV48i+1) ;
            AV65GXV2 = (int)(AV65GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFSiraCodigo)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Cod. Siradig", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            siradig_codigoswwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFSiraCodigo, GXv_char9) ;
            siradig_codigoswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV44TFSiraConCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto relacionado", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         siradig_codigoswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV48i = 1 ;
         AV66GXV3 = 1 ;
         while ( AV66GXV3 <= AV44TFSiraConCodigo_Sels.size() )
         {
            AV45TFSiraConCodigo_Sel = (String)AV44TFSiraConCodigo_Sels.elementAt(-1+AV66GXV3) ;
            if ( AV48i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFSiraConCodigo_Sel, GXv_char9) ;
            siradig_codigoswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV48i = (long)(AV48i+1) ;
            AV66GXV3 = (int)(AV66GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV43TFSiraConCodigo)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto relacionado", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            siradig_codigoswwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFSiraConCodigo, GXv_char9) ;
            siradig_codigoswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFSiraPropor)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV47TFSiraPropor_To)==0) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Proporción de factura (1 = 100%)", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         siradig_codigoswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV46TFSiraPropor)) );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         siradig_codigoswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV47TFSiraPropor_To)) );
      }
      if ( ! ( ( AV58TFSiraRelRef_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         siradig_codigoswwexport.this.AV14CellRow = GXv_int7[0] ;
         AV48i = 1 ;
         AV67GXV4 = 1 ;
         while ( AV67GXV4 <= AV58TFSiraRelRef_Sels.size() )
         {
            AV59TFSiraRelRef_Sel = (String)AV58TFSiraRelRef_Sels.elementAt(-1+AV67GXV4) ;
            if ( AV48i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV59TFSiraRelRef_Sel, GXv_char9) ;
            siradig_codigoswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV48i = (long)(AV48i+1) ;
            AV67GXV4 = (int)(AV67GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV57TFSiraRelRef)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Liberación", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            siradig_codigoswwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV57TFSiraRelRef, GXv_char9) ;
            siradig_codigoswwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("siradig_codigosWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("siradig_codigosWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "CliCod" );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Cod", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( (boolean)((AV55IsAuthorizedSiraRelRef&&((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible())) );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
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
      AV70Siradig_codigoswwds_1_tfsiratipo_sels = AV36TFSiraTipo_Sels ;
      AV71Siradig_codigoswwds_2_tfsiracodigo = AV39TFSiraCodigo ;
      AV72Siradig_codigoswwds_3_tfsiracodigo_sels = AV40TFSiraCodigo_Sels ;
      AV73Siradig_codigoswwds_4_tfsiraconcodigo = AV43TFSiraConCodigo ;
      AV74Siradig_codigoswwds_5_tfsiraconcodigo_sels = AV44TFSiraConCodigo_Sels ;
      AV75Siradig_codigoswwds_6_tfsirapropor = AV46TFSiraPropor ;
      AV76Siradig_codigoswwds_7_tfsirapropor_to = AV47TFSiraPropor_To ;
      AV77Siradig_codigoswwds_8_tfsirarelref = AV57TFSiraRelRef ;
      AV78Siradig_codigoswwds_9_tfsirarelref_sels = AV58TFSiraRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1101SiraTipo ,
                                           AV70Siradig_codigoswwds_1_tfsiratipo_sels ,
                                           A1102SiraCodigo ,
                                           AV72Siradig_codigoswwds_3_tfsiracodigo_sels ,
                                           A1100SiraConCodigo ,
                                           AV74Siradig_codigoswwds_5_tfsiraconcodigo_sels ,
                                           A2022SiraRelRef ,
                                           AV78Siradig_codigoswwds_9_tfsirarelref_sels ,
                                           Integer.valueOf(AV70Siradig_codigoswwds_1_tfsiratipo_sels.size()) ,
                                           Integer.valueOf(AV72Siradig_codigoswwds_3_tfsiracodigo_sels.size()) ,
                                           AV71Siradig_codigoswwds_2_tfsiracodigo ,
                                           Integer.valueOf(AV74Siradig_codigoswwds_5_tfsiraconcodigo_sels.size()) ,
                                           AV73Siradig_codigoswwds_4_tfsiraconcodigo ,
                                           AV75Siradig_codigoswwds_6_tfsirapropor ,
                                           AV76Siradig_codigoswwds_7_tfsirapropor_to ,
                                           Integer.valueOf(AV78Siradig_codigoswwds_9_tfsirarelref_sels.size()) ,
                                           AV77Siradig_codigoswwds_8_tfsirarelref ,
                                           A1103SiraPropor ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV49CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV71Siradig_codigoswwds_2_tfsiracodigo = GXutil.padr( GXutil.rtrim( AV71Siradig_codigoswwds_2_tfsiracodigo), 20, "%") ;
      lV73Siradig_codigoswwds_4_tfsiraconcodigo = GXutil.padr( GXutil.rtrim( AV73Siradig_codigoswwds_4_tfsiraconcodigo), 10, "%") ;
      lV77Siradig_codigoswwds_8_tfsirarelref = GXutil.concat( GXutil.rtrim( AV77Siradig_codigoswwds_8_tfsirarelref), "%", "") ;
      /* Using cursor P01IO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV49CliCod), lV71Siradig_codigoswwds_2_tfsiracodigo, lV73Siradig_codigoswwds_4_tfsiraconcodigo, AV75Siradig_codigoswwds_6_tfsirapropor, AV76Siradig_codigoswwds_7_tfsirapropor_to, lV77Siradig_codigoswwds_8_tfsirarelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01IO2_A3CliCod[0] ;
         A2022SiraRelRef = P01IO2_A2022SiraRelRef[0] ;
         n2022SiraRelRef = P01IO2_n2022SiraRelRef[0] ;
         A1103SiraPropor = P01IO2_A1103SiraPropor[0] ;
         A1100SiraConCodigo = P01IO2_A1100SiraConCodigo[0] ;
         A1102SiraCodigo = P01IO2_A1102SiraCodigo[0] ;
         A1101SiraTipo = P01IO2_A1101SiraTipo[0] ;
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
         AV79GXV6 = 1 ;
         while ( AV79GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV79GXV6));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A3CliCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SiraTipo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainsiradigtipo.getDescription(httpContext,(String)A1101SiraTipo), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SiraCodigo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1102SiraCodigo, GXv_char9) ;
                  siradig_codigoswwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SiraConCodigo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1100SiraConCodigo, GXv_char9) ;
                  siradig_codigoswwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SiraPropor") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1103SiraPropor)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "SiraRelRef") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2022SiraRelRef, GXv_char9) ;
                  siradig_codigoswwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV79GXV6 = (int)(AV79GXV6+1) ;
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
      GXt_boolean3 = AV55IsAuthorizedSiraRelRef ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV49CliCod, GXv_boolean4) ;
      siradig_codigoswwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV55IsAuthorizedSiraRelRef = (boolean)((!GXt_boolean3)) ;
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
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SiraTipo", "", "Tipo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SiraCodigo", "", "Cod. Siradig", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SiraConCodigo", "", "Concepto relacionado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SiraPropor", "", "Proporción de factura (1 = 100%)", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV49CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "SiraRelRef", "", "Liberación", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      if ( AV60paisEs )
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&ModificarSVG", "", "", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      if ( AV60paisEs )
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&EliminarSVG", "", "", true, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "", "", "", false, "") ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
      GXt_char8 = AV28UserCustomValue ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "siradig_codigosWWColumnsSelector", GXv_char9) ;
      siradig_codigoswwexport.this.GXt_char8 = GXv_char9[0] ;
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

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("siradig_codigosWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "siradig_codigosWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("siradig_codigosWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV80GXV7 = 1 ;
      while ( AV80GXV7 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV80GXV7));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRATIPO_SEL") == 0 )
         {
            AV35TFSiraTipo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFSiraTipo_Sels.fromJSonString(AV35TFSiraTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRACODIGO") == 0 )
         {
            AV39TFSiraCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRACODIGO_SEL") == 0 )
         {
            AV38TFSiraCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFSiraCodigo_Sels.fromJSonString(AV38TFSiraCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRACONCODIGO") == 0 )
         {
            AV43TFSiraConCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRACONCODIGO_SEL") == 0 )
         {
            AV42TFSiraConCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFSiraConCodigo_Sels.fromJSonString(AV42TFSiraConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRAPROPOR") == 0 )
         {
            AV46TFSiraPropor = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV47TFSiraPropor_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRARELREF") == 0 )
         {
            AV57TFSiraRelRef = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSIRARELREF_SEL") == 0 )
         {
            AV56TFSiraRelRef_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV58TFSiraRelRef_Sels.fromJSonString(AV56TFSiraRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV54MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV80GXV7 = (int)(AV80GXV7+1) ;
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
      this.aP0[0] = siradig_codigoswwexport.this.AV12Filename;
      this.aP1[0] = siradig_codigoswwexport.this.AV13ErrorMessage;
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
      AV63Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV36TFSiraTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37TFSiraTipo_Sel = "" ;
      AV40TFSiraCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41TFSiraCodigo_Sel = "" ;
      AV39TFSiraCodigo = "" ;
      AV44TFSiraConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFSiraConCodigo_Sel = "" ;
      AV43TFSiraConCodigo = "" ;
      AV46TFSiraPropor = DecimalUtil.ZERO ;
      AV47TFSiraPropor_To = DecimalUtil.ZERO ;
      AV58TFSiraRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59TFSiraRelRef_Sel = "" ;
      AV57TFSiraRelRef = "" ;
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1101SiraTipo = "" ;
      A1102SiraCodigo = "" ;
      A1100SiraConCodigo = "" ;
      A1103SiraPropor = DecimalUtil.ZERO ;
      A2022SiraRelRef = "" ;
      AV70Siradig_codigoswwds_1_tfsiratipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV71Siradig_codigoswwds_2_tfsiracodigo = "" ;
      AV72Siradig_codigoswwds_3_tfsiracodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV73Siradig_codigoswwds_4_tfsiraconcodigo = "" ;
      AV74Siradig_codigoswwds_5_tfsiraconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV75Siradig_codigoswwds_6_tfsirapropor = DecimalUtil.ZERO ;
      AV76Siradig_codigoswwds_7_tfsirapropor_to = DecimalUtil.ZERO ;
      AV77Siradig_codigoswwds_8_tfsirarelref = "" ;
      AV78Siradig_codigoswwds_9_tfsirarelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV71Siradig_codigoswwds_2_tfsiracodigo = "" ;
      lV73Siradig_codigoswwds_4_tfsiraconcodigo = "" ;
      lV77Siradig_codigoswwds_8_tfsirarelref = "" ;
      P01IO2_A3CliCod = new int[1] ;
      P01IO2_A2022SiraRelRef = new String[] {""} ;
      P01IO2_n2022SiraRelRef = new boolean[] {false} ;
      P01IO2_A1103SiraPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01IO2_A1100SiraConCodigo = new String[] {""} ;
      P01IO2_A1102SiraCodigo = new String[] {""} ;
      P01IO2_A1101SiraTipo = new String[] {""} ;
      GXv_boolean4 = new boolean[1] ;
      AV28UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFSiraTipo_SelsJson = "" ;
      AV38TFSiraCodigo_SelsJson = "" ;
      AV42TFSiraConCodigo_SelsJson = "" ;
      AV56TFSiraRelRef_SelsJson = "" ;
      AV54MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.siradig_codigoswwexport__default(),
         new Object[] {
             new Object[] {
            P01IO2_A3CliCod, P01IO2_A2022SiraRelRef, P01IO2_n2022SiraRelRef, P01IO2_A1103SiraPropor, P01IO2_A1100SiraConCodigo, P01IO2_A1102SiraCodigo, P01IO2_A1101SiraTipo
            }
         }
      );
      AV63Pgmname = "siradig_codigosWWExport" ;
      /* GeneXus formulas. */
      AV63Pgmname = "siradig_codigosWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int7[] ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV49CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV64GXV1 ;
   private int AV65GXV2 ;
   private int AV66GXV3 ;
   private int AV67GXV4 ;
   private int AV68GXV5 ;
   private int A3CliCod ;
   private int AV70Siradig_codigoswwds_1_tfsiratipo_sels_size ;
   private int AV72Siradig_codigoswwds_3_tfsiracodigo_sels_size ;
   private int AV74Siradig_codigoswwds_5_tfsiraconcodigo_sels_size ;
   private int AV78Siradig_codigoswwds_9_tfsirarelref_sels_size ;
   private int AV79GXV6 ;
   private int AV80GXV7 ;
   private long AV48i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV46TFSiraPropor ;
   private java.math.BigDecimal AV47TFSiraPropor_To ;
   private java.math.BigDecimal A1103SiraPropor ;
   private java.math.BigDecimal AV75Siradig_codigoswwds_6_tfsirapropor ;
   private java.math.BigDecimal AV76Siradig_codigoswwds_7_tfsirapropor_to ;
   private String AV63Pgmname ;
   private String AV37TFSiraTipo_Sel ;
   private String AV41TFSiraCodigo_Sel ;
   private String AV39TFSiraCodigo ;
   private String AV45TFSiraConCodigo_Sel ;
   private String AV43TFSiraConCodigo ;
   private String A1101SiraTipo ;
   private String A1102SiraCodigo ;
   private String A1100SiraConCodigo ;
   private String AV71Siradig_codigoswwds_2_tfsiracodigo ;
   private String AV73Siradig_codigoswwds_4_tfsiraconcodigo ;
   private String scmdbuf ;
   private String lV71Siradig_codigoswwds_2_tfsiracodigo ;
   private String lV73Siradig_codigoswwds_4_tfsiraconcodigo ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private boolean AV8IsAuthorized ;
   private boolean returnInSub ;
   private boolean AV55IsAuthorizedSiraRelRef ;
   private boolean AV19OrderedDsc ;
   private boolean n2022SiraRelRef ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean Cond_result ;
   private boolean AV60paisEs ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFSiraTipo_SelsJson ;
   private String AV38TFSiraCodigo_SelsJson ;
   private String AV42TFSiraConCodigo_SelsJson ;
   private String AV56TFSiraRelRef_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV59TFSiraRelRef_Sel ;
   private String AV57TFSiraRelRef ;
   private String A2022SiraRelRef ;
   private String AV77Siradig_codigoswwds_8_tfsirarelref ;
   private String lV77Siradig_codigoswwds_8_tfsirarelref ;
   private String AV54MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV36TFSiraTipo_Sels ;
   private GXSimpleCollection<String> AV40TFSiraCodigo_Sels ;
   private GXSimpleCollection<String> AV44TFSiraConCodigo_Sels ;
   private GXSimpleCollection<String> AV58TFSiraRelRef_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P01IO2_A3CliCod ;
   private String[] P01IO2_A2022SiraRelRef ;
   private boolean[] P01IO2_n2022SiraRelRef ;
   private java.math.BigDecimal[] P01IO2_A1103SiraPropor ;
   private String[] P01IO2_A1100SiraConCodigo ;
   private String[] P01IO2_A1102SiraCodigo ;
   private String[] P01IO2_A1101SiraTipo ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV70Siradig_codigoswwds_1_tfsiratipo_sels ;
   private GXSimpleCollection<String> AV72Siradig_codigoswwds_3_tfsiracodigo_sels ;
   private GXSimpleCollection<String> AV74Siradig_codigoswwds_5_tfsiraconcodigo_sels ;
   private GXSimpleCollection<String> AV78Siradig_codigoswwds_9_tfsirarelref_sels ;
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

final  class siradig_codigoswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01IO2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1101SiraTipo ,
                                          GXSimpleCollection<String> AV70Siradig_codigoswwds_1_tfsiratipo_sels ,
                                          String A1102SiraCodigo ,
                                          GXSimpleCollection<String> AV72Siradig_codigoswwds_3_tfsiracodigo_sels ,
                                          String A1100SiraConCodigo ,
                                          GXSimpleCollection<String> AV74Siradig_codigoswwds_5_tfsiraconcodigo_sels ,
                                          String A2022SiraRelRef ,
                                          GXSimpleCollection<String> AV78Siradig_codigoswwds_9_tfsirarelref_sels ,
                                          int AV70Siradig_codigoswwds_1_tfsiratipo_sels_size ,
                                          int AV72Siradig_codigoswwds_3_tfsiracodigo_sels_size ,
                                          String AV71Siradig_codigoswwds_2_tfsiracodigo ,
                                          int AV74Siradig_codigoswwds_5_tfsiraconcodigo_sels_size ,
                                          String AV73Siradig_codigoswwds_4_tfsiraconcodigo ,
                                          java.math.BigDecimal AV75Siradig_codigoswwds_6_tfsirapropor ,
                                          java.math.BigDecimal AV76Siradig_codigoswwds_7_tfsirapropor_to ,
                                          int AV78Siradig_codigoswwds_9_tfsirarelref_sels_size ,
                                          String AV77Siradig_codigoswwds_8_tfsirarelref ,
                                          java.math.BigDecimal A1103SiraPropor ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV49CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[6];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT CliCod, SiraRelRef, SiraPropor, SiraConCodigo, SiraCodigo, SiraTipo FROM siradig_codigos" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( AV70Siradig_codigoswwds_1_tfsiratipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Siradig_codigoswwds_1_tfsiratipo_sels, "SiraTipo IN (", ")")+")");
      }
      if ( ( AV72Siradig_codigoswwds_3_tfsiracodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV71Siradig_codigoswwds_2_tfsiracodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SiraCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[1] = (byte)(1) ;
      }
      if ( AV72Siradig_codigoswwds_3_tfsiracodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV72Siradig_codigoswwds_3_tfsiracodigo_sels, "SiraCodigo IN (", ")")+")");
      }
      if ( ( AV74Siradig_codigoswwds_5_tfsiraconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Siradig_codigoswwds_4_tfsiraconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SiraConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( AV74Siradig_codigoswwds_5_tfsiraconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Siradig_codigoswwds_5_tfsiraconcodigo_sels, "SiraConCodigo IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV75Siradig_codigoswwds_6_tfsirapropor)==0) )
      {
         addWhere(sWhereString, "(SiraPropor >= ?)");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV76Siradig_codigoswwds_7_tfsirapropor_to)==0) )
      {
         addWhere(sWhereString, "(SiraPropor <= ?)");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( ( AV78Siradig_codigoswwds_9_tfsirarelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Siradig_codigoswwds_8_tfsirarelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SiraRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( AV78Siradig_codigoswwds_9_tfsirarelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Siradig_codigoswwds_9_tfsirarelref_sels, "SiraRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SiraTipo" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SiraTipo DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SiraCodigo" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SiraCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SiraConCodigo" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SiraConCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SiraPropor" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SiraPropor DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY SiraRelRef" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SiraRelRef DESC" ;
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
                  return conditional_P01IO2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Boolean) dynConstraints[19]).booleanValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01IO2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[4])[0] = rslt.getString(4, 10);
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((String[]) buf[6])[0] = rslt.getString(6, 3);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 10);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[10], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               return;
      }
   }

}

