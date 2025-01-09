package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clienteconvenio_importeswwexport extends GXProcedure
{
   public clienteconvenio_importeswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clienteconvenio_importeswwexport.class ), "" );
   }

   public clienteconvenio_importeswwexport( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      clienteconvenio_importeswwexport.this.aP1 = new String[] {""};
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
      clienteconvenio_importeswwexport.this.aP0 = aP0;
      clienteconvenio_importeswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV43CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      clienteconvenio_importeswwexport.this.GXt_int1 = GXv_int2[0] ;
      AV43CliCod = GXt_int1 ;
      GXv_char3[0] = AV46ConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char3) ;
      clienteconvenio_importeswwexport.this.AV46ConveCodigo = GXv_char3[0] ;
      GXv_int4[0] = AV45PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV43CliCod, GXv_int4) ;
      clienteconvenio_importeswwexport.this.AV45PaiCod = GXv_int4[0] ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWclienteConvenio_importes", GXv_boolean6) ;
      clienteconvenio_importeswwexport.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV57Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "clienteConvenio_importesWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV35TFCliConveImpVig)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV36TFCliConveImpVig_To)) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Vigencia", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_importeswwexport.this.AV14CellRow = GXv_int4[0] ;
         GXt_dtime9 = GXutil.resetTime( AV35TFCliConveImpVig );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime9 );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_importeswwexport.this.AV14CellRow = GXv_int4[0] ;
         GXt_dtime9 = GXutil.resetTime( AV36TFCliConveImpVig_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime9 );
      }
      if ( ! ( ( AV38TFCliConveImpTipo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo importe", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_importeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV42i = 1 ;
         AV58GXV1 = 1 ;
         while ( AV58GXV1 <= AV38TFCliConveImpTipo_Sels.size() )
         {
            AV39TFCliConveImpTipo_Sel = (String)AV38TFCliConveImpTipo_Sels.elementAt(-1+AV58GXV1) ;
            if ( AV42i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainconvenio_tipo_importe.getDescription(httpContext,(String)AV39TFCliConveImpTipo_Sel), "") );
            AV42i = (long)(AV42i+1) ;
            AV58GXV1 = (int)(AV58GXV1+1) ;
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFCliConveImporte)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFCliConveImporte_To)==0) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Importe", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_importeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV40TFCliConveImporte)) );
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, false, GXv_int4, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         clienteconvenio_importeswwexport.this.AV14CellRow = GXv_int4[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV41TFCliConveImporte_To)) );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("clienteConvenio_importesWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("clienteConvenio_importesWWColumnsSelector") ;
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
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV59GXV2 = 1 ;
      while ( AV59GXV2 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV59GXV2));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV59GXV2 = (int)(AV59GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV61Clienteconvenio_importeswwds_1_tfcliconveimpvig = AV35TFCliConveImpVig ;
      AV62Clienteconvenio_importeswwds_2_tfcliconveimpvig_to = AV36TFCliConveImpVig_To ;
      AV63Clienteconvenio_importeswwds_3_tfcliconveimptipo_sels = AV38TFCliConveImpTipo_Sels ;
      AV64Clienteconvenio_importeswwds_4_tfcliconveimporte = AV40TFCliConveImporte ;
      AV65Clienteconvenio_importeswwds_5_tfcliconveimporte_to = AV41TFCliConveImporte_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1588CliConveImpTipo ,
                                           AV63Clienteconvenio_importeswwds_3_tfcliconveimptipo_sels ,
                                           AV61Clienteconvenio_importeswwds_1_tfcliconveimpvig ,
                                           AV62Clienteconvenio_importeswwds_2_tfcliconveimpvig_to ,
                                           Integer.valueOf(AV63Clienteconvenio_importeswwds_3_tfcliconveimptipo_sels.size()) ,
                                           AV64Clienteconvenio_importeswwds_4_tfcliconveimporte ,
                                           AV65Clienteconvenio_importeswwds_5_tfcliconveimporte_to ,
                                           A1587CliConveImpVig ,
                                           A1589CliConveImporte ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV43CliCod) ,
                                           Short.valueOf(AV45PaiCod) ,
                                           AV46ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      /* Using cursor P01LO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV43CliCod), Short.valueOf(AV45PaiCod), AV46ConveCodigo, AV61Clienteconvenio_importeswwds_1_tfcliconveimpvig, AV62Clienteconvenio_importeswwds_2_tfcliconveimpvig_to, AV64Clienteconvenio_importeswwds_4_tfcliconveimporte, AV65Clienteconvenio_importeswwds_5_tfcliconveimporte_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P01LO2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01LO2_A1564CliPaiConve[0] ;
         A3CliCod = P01LO2_A3CliCod[0] ;
         A1589CliConveImporte = P01LO2_A1589CliConveImporte[0] ;
         A1588CliConveImpTipo = P01LO2_A1588CliConveImpTipo[0] ;
         A1587CliConveImpVig = P01LO2_A1587CliConveImpVig[0] ;
         A1896CliConveImpRelSec = P01LO2_A1896CliConveImpRelSec[0] ;
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
         AV66GXV3 = 1 ;
         while ( AV66GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV66GXV3));
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
                  GXt_char10 = "" ;
                  GXv_char3[0] = GXt_char10 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1565CliConvenio, GXv_char3) ;
                  clienteconvenio_importeswwexport.this.GXt_char10 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char10 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveImpVig") == 0 )
               {
                  GXt_dtime9 = GXutil.resetTime( A1587CliConveImpVig );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( GXt_dtime9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveImpTipo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainconvenio_tipo_importe.getDescription(httpContext,(String)A1588CliConveImpTipo), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliConveImporte") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1589CliConveImporte)) );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&CliReDTChar") == 0 )
               {
                  GXt_char10 = AV53CliReDTChar ;
                  GXv_char3[0] = GXt_char10 ;
                  new web.getreleasedtchar(remoteHandle, context).execute( A3CliCod, A1896CliConveImpRelSec, GXv_char3) ;
                  clienteconvenio_importeswwexport.this.GXt_char10 = GXv_char3[0] ;
                  AV53CliReDTChar = GXt_char10 ;
                  GXt_char10 = "" ;
                  GXv_char3[0] = GXt_char10 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV53CliReDTChar, GXv_char3) ;
                  clienteconvenio_importeswwexport.this.GXt_char10 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char10 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV66GXV3 = (int)(AV66GXV3+1) ;
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
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "CliConveImpVig", "", "Vigencia", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "CliConveImpTipo", "", "Tipo importe", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "CliConveImporte", "", "Importe", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&ModificarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&EliminarSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, "&CliReDTChar", "", "Fecha/hora de liberación", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      GXt_char10 = AV28UserCustomValue ;
      GXv_char3[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "clienteConvenio_importesWWColumnsSelector", GXv_char3) ;
      clienteconvenio_importeswwexport.this.GXt_char10 = GXv_char3[0] ;
      AV28UserCustomValue = GXt_char10 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector11[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector12[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector11, GXv_SdtWWPColumnsSelector12) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector11[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("clienteConvenio_importesWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "clienteConvenio_importesWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("clienteConvenio_importesWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV67GXV4 = 1 ;
      while ( AV67GXV4 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV67GXV4));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEIMPVIG") == 0 )
         {
            AV35TFCliConveImpVig = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV36TFCliConveImpVig_To = localUtil.ctod( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEIMPTIPO_SEL") == 0 )
         {
            AV37TFCliConveImpTipo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFCliConveImpTipo_Sels.fromJSonString(AV37TFCliConveImpTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEIMPORTE") == 0 )
         {
            AV40TFCliConveImporte = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV41TFCliConveImporte_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV54MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV67GXV4 = (int)(AV67GXV4+1) ;
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
      this.aP0[0] = clienteconvenio_importeswwexport.this.AV12Filename;
      this.aP1[0] = clienteconvenio_importeswwexport.this.AV13ErrorMessage;
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
      AV46ConveCodigo = "" ;
      GXv_boolean6 = new boolean[1] ;
      AV57Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV35TFCliConveImpVig = GXutil.nullDate() ;
      AV36TFCliConveImpVig_To = GXutil.nullDate() ;
      AV38TFCliConveImpTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFCliConveImpTipo_Sel = "" ;
      AV40TFCliConveImporte = DecimalUtil.ZERO ;
      AV41TFCliConveImporte_To = DecimalUtil.ZERO ;
      GXv_exceldoc8 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int4 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1565CliConvenio = "" ;
      A1587CliConveImpVig = GXutil.nullDate() ;
      A1588CliConveImpTipo = "" ;
      A1589CliConveImporte = DecimalUtil.ZERO ;
      AV61Clienteconvenio_importeswwds_1_tfcliconveimpvig = GXutil.nullDate() ;
      AV62Clienteconvenio_importeswwds_2_tfcliconveimpvig_to = GXutil.nullDate() ;
      AV63Clienteconvenio_importeswwds_3_tfcliconveimptipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64Clienteconvenio_importeswwds_4_tfcliconveimporte = DecimalUtil.ZERO ;
      AV65Clienteconvenio_importeswwds_5_tfcliconveimporte_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P01LO2_A1565CliConvenio = new String[] {""} ;
      P01LO2_A1564CliPaiConve = new short[1] ;
      P01LO2_A3CliCod = new int[1] ;
      P01LO2_A1589CliConveImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01LO2_A1588CliConveImpTipo = new String[] {""} ;
      P01LO2_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01LO2_A1896CliConveImpRelSec = new int[1] ;
      GXt_dtime9 = GXutil.resetTime( GXutil.nullDate() );
      AV53CliReDTChar = "" ;
      AV28UserCustomValue = "" ;
      GXt_char10 = "" ;
      GXv_char3 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector12 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFCliConveImpTipo_SelsJson = "" ;
      AV54MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clienteconvenio_importeswwexport__default(),
         new Object[] {
             new Object[] {
            P01LO2_A1565CliConvenio, P01LO2_A1564CliPaiConve, P01LO2_A3CliCod, P01LO2_A1589CliConveImporte, P01LO2_A1588CliConveImpTipo, P01LO2_A1587CliConveImpVig, P01LO2_A1896CliConveImpRelSec
            }
         }
      );
      AV57Pgmname = "clienteConvenio_importesWWExport" ;
      /* GeneXus formulas. */
      AV57Pgmname = "clienteConvenio_importesWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV45PaiCod ;
   private short GXv_int4[] ;
   private short A1564CliPaiConve ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV43CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV58GXV1 ;
   private int AV59GXV2 ;
   private int A3CliCod ;
   private int A1896CliConveImpRelSec ;
   private int AV63Clienteconvenio_importeswwds_3_tfcliconveimptipo_sels_size ;
   private int AV66GXV3 ;
   private int AV67GXV4 ;
   private long AV42i ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV40TFCliConveImporte ;
   private java.math.BigDecimal AV41TFCliConveImporte_To ;
   private java.math.BigDecimal A1589CliConveImporte ;
   private java.math.BigDecimal AV64Clienteconvenio_importeswwds_4_tfcliconveimporte ;
   private java.math.BigDecimal AV65Clienteconvenio_importeswwds_5_tfcliconveimporte_to ;
   private String AV46ConveCodigo ;
   private String AV57Pgmname ;
   private String AV39TFCliConveImpTipo_Sel ;
   private String A1565CliConvenio ;
   private String A1588CliConveImpTipo ;
   private String scmdbuf ;
   private String GXt_char10 ;
   private String GXv_char3[] ;
   private java.util.Date GXt_dtime9 ;
   private java.util.Date AV35TFCliConveImpVig ;
   private java.util.Date AV36TFCliConveImpVig_To ;
   private java.util.Date A1587CliConveImpVig ;
   private java.util.Date AV61Clienteconvenio_importeswwds_1_tfcliconveimpvig ;
   private java.util.Date AV62Clienteconvenio_importeswwds_2_tfcliconveimpvig_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV37TFCliConveImpTipo_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV53CliReDTChar ;
   private String AV54MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV38TFCliConveImpTipo_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P01LO2_A1565CliConvenio ;
   private short[] P01LO2_A1564CliPaiConve ;
   private int[] P01LO2_A3CliCod ;
   private java.math.BigDecimal[] P01LO2_A1589CliConveImporte ;
   private String[] P01LO2_A1588CliConveImpTipo ;
   private java.util.Date[] P01LO2_A1587CliConveImpVig ;
   private int[] P01LO2_A1896CliConveImpRelSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc8[] ;
   private GXSimpleCollection<String> AV63Clienteconvenio_importeswwds_3_tfcliconveimptipo_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector12[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class clienteconvenio_importeswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01LO2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1588CliConveImpTipo ,
                                          GXSimpleCollection<String> AV63Clienteconvenio_importeswwds_3_tfcliconveimptipo_sels ,
                                          java.util.Date AV61Clienteconvenio_importeswwds_1_tfcliconveimpvig ,
                                          java.util.Date AV62Clienteconvenio_importeswwds_2_tfcliconveimpvig_to ,
                                          int AV63Clienteconvenio_importeswwds_3_tfcliconveimptipo_sels_size ,
                                          java.math.BigDecimal AV64Clienteconvenio_importeswwds_4_tfcliconveimporte ,
                                          java.math.BigDecimal AV65Clienteconvenio_importeswwds_5_tfcliconveimporte_to ,
                                          java.util.Date A1587CliConveImpVig ,
                                          java.math.BigDecimal A1589CliConveImporte ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV43CliCod ,
                                          short AV45PaiCod ,
                                          String AV46ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[7];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliPaiConve, CliCod, CliConveImporte, CliConveImpTipo, CliConveImpVig, CliConveImpRelSec FROM clienteConvenio_importes" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV61Clienteconvenio_importeswwds_1_tfcliconveimpvig)) )
      {
         addWhere(sWhereString, "(CliConveImpVig >= ?)");
      }
      else
      {
         GXv_int13[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV62Clienteconvenio_importeswwds_2_tfcliconveimpvig_to)) )
      {
         addWhere(sWhereString, "(CliConveImpVig <= ?)");
      }
      else
      {
         GXv_int13[4] = (byte)(1) ;
      }
      if ( AV63Clienteconvenio_importeswwds_3_tfcliconveimptipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Clienteconvenio_importeswwds_3_tfcliconveimptipo_sels, "CliConveImpTipo IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64Clienteconvenio_importeswwds_4_tfcliconveimporte)==0) )
      {
         addWhere(sWhereString, "(CliConveImporte >= ?)");
      }
      else
      {
         GXv_int13[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65Clienteconvenio_importeswwds_5_tfcliconveimporte_to)==0) )
      {
         addWhere(sWhereString, "(CliConveImporte <= ?)");
      }
      else
      {
         GXv_int13[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliConveImpVig" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliConveImpVig DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliConveImpTipo" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliConveImpTipo DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliConveImporte" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliConveImporte DESC" ;
      }
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
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
                  return conditional_P01LO2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (java.math.BigDecimal)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.util.Date)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Boolean) dynConstraints[10]).booleanValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01LO2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
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
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[10]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[12], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 2);
               }
               return;
      }
   }

}

