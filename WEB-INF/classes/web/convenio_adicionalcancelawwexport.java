package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_adicionalcancelawwexport extends GXProcedure
{
   public convenio_adicionalcancelawwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicionalcancelawwexport.class ), "" );
   }

   public convenio_adicionalcancelawwexport( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      convenio_adicionalcancelawwexport.this.aP1 = new String[] {""};
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
      convenio_adicionalcancelawwexport.this.aP0 = aP0;
      convenio_adicionalcancelawwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV44CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      convenio_adicionalcancelawwexport.this.GXt_int1 = GXv_int2[0] ;
      AV44CliCod = GXt_int1 ;
      GXv_char3[0] = AV47ConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char3) ;
      convenio_adicionalcancelawwexport.this.AV47ConveCodigo = GXv_char3[0] ;
      GXv_int4[0] = AV46PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV44CliCod, GXv_int4) ;
      convenio_adicionalcancelawwexport.this.AV46PaiCod = GXv_int4[0] ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicionalCancela", GXv_boolean6) ;
      convenio_adicionalcancelawwexport.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV61Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext7[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext7) ;
         AV9WWPContext = GXv_SdtWWPContext7[0] ;
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
      AV12Filename = "convenio_adicionalCancelaWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV50TFConveAdicod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Adicional", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_adicionalcancelawwexport.this.AV14CellRow = GXv_int4[0] ;
         AV43i = 1 ;
         AV62GXV1 = 1 ;
         while ( AV62GXV1 <= AV50TFConveAdicod_Sels.size() )
         {
            AV51TFConveAdicod_Sel = (String)AV50TFConveAdicod_Sels.elementAt(-1+AV62GXV1) ;
            if ( AV43i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFConveAdicod_Sel, GXv_char3) ;
            convenio_adicionalcancelawwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV43i = (long)(AV43i+1) ;
            AV62GXV1 = (int)(AV62GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV49TFConveAdicod)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Adicional", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            convenio_adicionalcancelawwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV49TFConveAdicod, GXv_char3) ;
            convenio_adicionalcancelawwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char9 );
         }
      }
      if ( ! ( ( AV37TFConveAdiSitCancela_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Estado", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_adicionalcancelawwexport.this.AV14CellRow = GXv_int4[0] ;
         AV43i = 1 ;
         AV63GXV2 = 1 ;
         while ( AV63GXV2 <= AV37TFConveAdiSitCancela_Sels.size() )
         {
            AV38TFConveAdiSitCancela_Sel = (String)AV37TFConveAdiSitCancela_Sels.elementAt(-1+AV63GXV2) ;
            if ( AV43i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFConveAdiSitCancela_Sel, GXv_char3) ;
            convenio_adicionalcancelawwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV43i = (long)(AV43i+1) ;
            AV63GXV2 = (int)(AV63GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFConveAdiSitCancela)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Estado", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            convenio_adicionalcancelawwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFConveAdiSitCancela, GXv_char3) ;
            convenio_adicionalcancelawwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char9 );
         }
      }
      if ( ! ( ( AV41TFConveAdiSitCancDes_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Estado", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         convenio_adicionalcancelawwexport.this.AV14CellRow = GXv_int4[0] ;
         AV43i = 1 ;
         AV64GXV3 = 1 ;
         while ( AV64GXV3 <= AV41TFConveAdiSitCancDes_Sels.size() )
         {
            AV42TFConveAdiSitCancDes_Sel = (String)AV41TFConveAdiSitCancDes_Sels.elementAt(-1+AV64GXV3) ;
            if ( AV43i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFConveAdiSitCancDes_Sel, GXv_char3) ;
            convenio_adicionalcancelawwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV43i = (long)(AV43i+1) ;
            AV64GXV3 = (int)(AV64GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV40TFConveAdiSitCancDes)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Estado", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            convenio_adicionalcancelawwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFConveAdiSitCancDes, GXv_char3) ;
            convenio_adicionalcancelawwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char9 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("convenio_adicionalCancelaWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("convenio_adicionalCancelaWWColumnsSelector") ;
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
      AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "CliPaiConve" );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Pai Conve", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "CliConvenio" );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Convenio", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV65GXV4 = 1 ;
      while ( AV65GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV65GXV4));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV65GXV4 = (int)(AV65GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV67Convenio_adicionalcancelawwds_1_tfconveadicod = AV49TFConveAdicod ;
      AV68Convenio_adicionalcancelawwds_2_tfconveadicod_sels = AV50TFConveAdicod_Sels ;
      AV69Convenio_adicionalcancelawwds_3_tfconveadisitcancela = AV36TFConveAdiSitCancela ;
      AV70Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels = AV37TFConveAdiSitCancela_Sels ;
      AV71Convenio_adicionalcancelawwds_5_tfconveadisitcancdes = AV40TFConveAdiSitCancDes ;
      AV72Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels = AV41TFConveAdiSitCancDes_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A996ConveAdicod ,
                                           AV68Convenio_adicionalcancelawwds_2_tfconveadicod_sels ,
                                           A1824ConveAdiSitCancela ,
                                           AV70Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels ,
                                           A1825ConveAdiSitCancDes ,
                                           AV72Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels ,
                                           Integer.valueOf(AV68Convenio_adicionalcancelawwds_2_tfconveadicod_sels.size()) ,
                                           AV67Convenio_adicionalcancelawwds_1_tfconveadicod ,
                                           Integer.valueOf(AV70Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels.size()) ,
                                           AV69Convenio_adicionalcancelawwds_3_tfconveadisitcancela ,
                                           Integer.valueOf(AV72Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels.size()) ,
                                           AV71Convenio_adicionalcancelawwds_5_tfconveadisitcancdes ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV44CliCod) ,
                                           Short.valueOf(AV46PaiCod) ,
                                           AV47ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV67Convenio_adicionalcancelawwds_1_tfconveadicod = GXutil.padr( GXutil.rtrim( AV67Convenio_adicionalcancelawwds_1_tfconveadicod), 20, "%") ;
      lV69Convenio_adicionalcancelawwds_3_tfconveadisitcancela = GXutil.padr( GXutil.rtrim( AV69Convenio_adicionalcancelawwds_3_tfconveadisitcancela), 4, "%") ;
      lV71Convenio_adicionalcancelawwds_5_tfconveadisitcancdes = GXutil.concat( GXutil.rtrim( AV71Convenio_adicionalcancelawwds_5_tfconveadisitcancdes), "%", "") ;
      /* Using cursor P01PZ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV44CliCod), Short.valueOf(AV46PaiCod), AV47ConveCodigo, lV67Convenio_adicionalcancelawwds_1_tfconveadicod, lV69Convenio_adicionalcancelawwds_3_tfconveadisitcancela, lV71Convenio_adicionalcancelawwds_5_tfconveadisitcancdes});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P01PZ2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01PZ2_A1564CliPaiConve[0] ;
         A3CliCod = P01PZ2_A3CliCod[0] ;
         A1825ConveAdiSitCancDes = P01PZ2_A1825ConveAdiSitCancDes[0] ;
         A1824ConveAdiSitCancela = P01PZ2_A1824ConveAdiSitCancela[0] ;
         A996ConveAdicod = P01PZ2_A996ConveAdicod[0] ;
         A1898ConveAdiSitCanRelSec = P01PZ2_A1898ConveAdiSitCanRelSec[0] ;
         A1825ConveAdiSitCancDes = P01PZ2_A1825ConveAdiSitCancDes[0] ;
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
         AV73GXV5 = 1 ;
         while ( AV73GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV73GXV5));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A3CliCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliPaiConve") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1564CliPaiConve );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConvenio") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1565CliConvenio, GXv_char3) ;
                  convenio_adicionalcancelawwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveAdicod") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A996ConveAdicod, GXv_char3) ;
                  convenio_adicionalcancelawwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConveAdiSitCancela") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1824ConveAdiSitCancela, GXv_char3) ;
                  convenio_adicionalcancelawwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&CliReDTChar") == 0 )
               {
                  GXt_char9 = AV57CliReDTChar ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.getreleasedtchar(remoteHandle, context).execute( A3CliCod, A1898ConveAdiSitCanRelSec, GXv_char3) ;
                  convenio_adicionalcancelawwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV57CliReDTChar = GXt_char9 ;
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV57CliReDTChar, GXv_char3) ;
                  convenio_adicionalcancelawwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV73GXV5 = (int)(AV73GXV5+1) ;
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
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveAdicod", "", "Adicional", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveAdiSitCancela", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConveAdiSitCancDes", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&EliminarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&CliReDTChar", "", "Fecha/hora de liberación", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXt_char9 = AV28UserCustomValue ;
      GXv_char3[0] = GXt_char9 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "convenio_adicionalCancelaWWColumnsSelector", GXv_char3) ;
      convenio_adicionalcancelawwexport.this.GXt_char9 = GXv_char3[0] ;
      AV28UserCustomValue = GXt_char9 ;
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
      if ( GXutil.strcmp(AV20Session.getValue("convenio_adicionalCancelaWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "convenio_adicionalCancelaWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("convenio_adicionalCancelaWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV74GXV6 = 1 ;
      while ( AV74GXV6 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV74GXV6));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADICOD") == 0 )
         {
            AV49TFConveAdicod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADICOD_SEL") == 0 )
         {
            AV48TFConveAdicod_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV50TFConveAdicod_Sels.fromJSonString(AV48TFConveAdicod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADISITCANCELA") == 0 )
         {
            AV36TFConveAdiSitCancela = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADISITCANCELA_SEL") == 0 )
         {
            AV35TFConveAdiSitCancela_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFConveAdiSitCancela_Sels.fromJSonString(AV35TFConveAdiSitCancela_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADISITCANCDES") == 0 )
         {
            AV40TFConveAdiSitCancDes = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADISITCANCDES_SEL") == 0 )
         {
            AV39TFConveAdiSitCancDes_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFConveAdiSitCancDes_Sels.fromJSonString(AV39TFConveAdiSitCancDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV58MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV74GXV6 = (int)(AV74GXV6+1) ;
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
      this.aP0[0] = convenio_adicionalcancelawwexport.this.AV12Filename;
      this.aP1[0] = convenio_adicionalcancelawwexport.this.AV13ErrorMessage;
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
      AV47ConveCodigo = "" ;
      GXv_boolean6 = new boolean[1] ;
      AV61Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV50TFConveAdicod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51TFConveAdicod_Sel = "" ;
      AV49TFConveAdicod = "" ;
      AV37TFConveAdiSitCancela_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFConveAdiSitCancela_Sel = "" ;
      AV36TFConveAdiSitCancela = "" ;
      AV41TFConveAdiSitCancDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFConveAdiSitCancDes_Sel = "" ;
      AV40TFConveAdiSitCancDes = "" ;
      GXv_exceldoc8 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int4 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      A1824ConveAdiSitCancela = "" ;
      AV67Convenio_adicionalcancelawwds_1_tfconveadicod = "" ;
      AV68Convenio_adicionalcancelawwds_2_tfconveadicod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69Convenio_adicionalcancelawwds_3_tfconveadisitcancela = "" ;
      AV70Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV71Convenio_adicionalcancelawwds_5_tfconveadisitcancdes = "" ;
      AV72Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV67Convenio_adicionalcancelawwds_1_tfconveadicod = "" ;
      lV69Convenio_adicionalcancelawwds_3_tfconveadisitcancela = "" ;
      lV71Convenio_adicionalcancelawwds_5_tfconveadisitcancdes = "" ;
      A1825ConveAdiSitCancDes = "" ;
      P01PZ2_A1565CliConvenio = new String[] {""} ;
      P01PZ2_A1564CliPaiConve = new short[1] ;
      P01PZ2_A3CliCod = new int[1] ;
      P01PZ2_A1825ConveAdiSitCancDes = new String[] {""} ;
      P01PZ2_A1824ConveAdiSitCancela = new String[] {""} ;
      P01PZ2_A996ConveAdicod = new String[] {""} ;
      P01PZ2_A1898ConveAdiSitCanRelSec = new int[1] ;
      AV57CliReDTChar = "" ;
      AV28UserCustomValue = "" ;
      GXt_char9 = "" ;
      GXv_char3 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV48TFConveAdicod_SelsJson = "" ;
      AV35TFConveAdiSitCancela_SelsJson = "" ;
      AV39TFConveAdiSitCancDes_SelsJson = "" ;
      AV58MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicionalcancelawwexport__default(),
         new Object[] {
             new Object[] {
            P01PZ2_A1565CliConvenio, P01PZ2_A1564CliPaiConve, P01PZ2_A3CliCod, P01PZ2_A1825ConveAdiSitCancDes, P01PZ2_A1824ConveAdiSitCancela, P01PZ2_A996ConveAdicod, P01PZ2_A1898ConveAdiSitCanRelSec
            }
         }
      );
      AV61Pgmname = "convenio_adicionalCancelaWWExport" ;
      /* GeneXus formulas. */
      AV61Pgmname = "convenio_adicionalCancelaWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV46PaiCod ;
   private short GXv_int4[] ;
   private short A1564CliPaiConve ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV44CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV62GXV1 ;
   private int AV63GXV2 ;
   private int AV64GXV3 ;
   private int AV65GXV4 ;
   private int A3CliCod ;
   private int A1898ConveAdiSitCanRelSec ;
   private int AV68Convenio_adicionalcancelawwds_2_tfconveadicod_sels_size ;
   private int AV70Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels_size ;
   private int AV72Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels_size ;
   private int AV73GXV5 ;
   private int AV74GXV6 ;
   private long AV43i ;
   private long AV32VisibleColumnCount ;
   private String AV47ConveCodigo ;
   private String AV61Pgmname ;
   private String AV51TFConveAdicod_Sel ;
   private String AV49TFConveAdicod ;
   private String AV38TFConveAdiSitCancela_Sel ;
   private String AV36TFConveAdiSitCancela ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String A1824ConveAdiSitCancela ;
   private String AV67Convenio_adicionalcancelawwds_1_tfconveadicod ;
   private String AV69Convenio_adicionalcancelawwds_3_tfconveadisitcancela ;
   private String scmdbuf ;
   private String lV67Convenio_adicionalcancelawwds_1_tfconveadicod ;
   private String lV69Convenio_adicionalcancelawwds_3_tfconveadisitcancela ;
   private String GXt_char9 ;
   private String GXv_char3[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV48TFConveAdicod_SelsJson ;
   private String AV35TFConveAdiSitCancela_SelsJson ;
   private String AV39TFConveAdiSitCancDes_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV42TFConveAdiSitCancDes_Sel ;
   private String AV40TFConveAdiSitCancDes ;
   private String AV71Convenio_adicionalcancelawwds_5_tfconveadisitcancdes ;
   private String lV71Convenio_adicionalcancelawwds_5_tfconveadisitcancdes ;
   private String A1825ConveAdiSitCancDes ;
   private String AV57CliReDTChar ;
   private String AV58MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV50TFConveAdicod_Sels ;
   private GXSimpleCollection<String> AV37TFConveAdiSitCancela_Sels ;
   private GXSimpleCollection<String> AV41TFConveAdiSitCancDes_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P01PZ2_A1565CliConvenio ;
   private short[] P01PZ2_A1564CliPaiConve ;
   private int[] P01PZ2_A3CliCod ;
   private String[] P01PZ2_A1825ConveAdiSitCancDes ;
   private String[] P01PZ2_A1824ConveAdiSitCancela ;
   private String[] P01PZ2_A996ConveAdicod ;
   private int[] P01PZ2_A1898ConveAdiSitCanRelSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc8[] ;
   private GXSimpleCollection<String> AV68Convenio_adicionalcancelawwds_2_tfconveadicod_sels ;
   private GXSimpleCollection<String> AV70Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels ;
   private GXSimpleCollection<String> AV72Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class convenio_adicionalcancelawwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01PZ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A996ConveAdicod ,
                                          GXSimpleCollection<String> AV68Convenio_adicionalcancelawwds_2_tfconveadicod_sels ,
                                          String A1824ConveAdiSitCancela ,
                                          GXSimpleCollection<String> AV70Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels ,
                                          String A1825ConveAdiSitCancDes ,
                                          GXSimpleCollection<String> AV72Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels ,
                                          int AV68Convenio_adicionalcancelawwds_2_tfconveadicod_sels_size ,
                                          String AV67Convenio_adicionalcancelawwds_1_tfconveadicod ,
                                          int AV70Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels_size ,
                                          String AV69Convenio_adicionalcancelawwds_3_tfconveadisitcancela ,
                                          int AV72Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels_size ,
                                          String AV71Convenio_adicionalcancelawwds_5_tfconveadisitcancdes ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV44CliCod ,
                                          short AV46PaiCod ,
                                          String AV47ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[6];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT T1.CliConvenio, T1.CliPaiConve, T1.CliCod, T2.SitDescrip AS ConveAdiSitCancDes, T1.ConveAdiSitCancela AS ConveAdiSitCancela, T1.ConveAdicod, T1.ConveAdiSitCanRelSec" ;
      scmdbuf += " FROM (convenio_adicionalCancela T1 INNER JOIN Estado T2 ON T2.SitCodigo = T1.ConveAdiSitCancela)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?))");
      if ( ( AV68Convenio_adicionalcancelawwds_2_tfconveadicod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Convenio_adicionalcancelawwds_1_tfconveadicod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConveAdicod) like LOWER(?))");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( AV68Convenio_adicionalcancelawwds_2_tfconveadicod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Convenio_adicionalcancelawwds_2_tfconveadicod_sels, "T1.ConveAdicod IN (", ")")+")");
      }
      if ( ( AV70Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Convenio_adicionalcancelawwds_3_tfconveadisitcancela)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConveAdiSitCancela) like LOWER(?))");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( AV70Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels, "T1.ConveAdiSitCancela IN (", ")")+")");
      }
      if ( ( AV72Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV71Convenio_adicionalcancelawwds_5_tfconveadisitcancdes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SitDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( AV72Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV72Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels, "T2.SitDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConveAdicod" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConveAdicod DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.ConveAdiSitCancela" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.ConveAdiSitCancela DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.SitDescrip" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.SitDescrip DESC" ;
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
                  return conditional_P01PZ2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01PZ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((int[]) buf[6])[0] = rslt.getInt(7);
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
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 4);
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

