package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class categoriaalta2wwexport extends GXProcedure
{
   public categoriaalta2wwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( categoriaalta2wwexport.class ), "" );
   }

   public categoriaalta2wwexport( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      categoriaalta2wwexport.this.aP1 = new String[] {""};
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
      categoriaalta2wwexport.this.aP0 = aP0;
      categoriaalta2wwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV40CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      categoriaalta2wwexport.this.GXt_int1 = GXv_int2[0] ;
      AV40CliCod = GXt_int1 ;
      GXv_char3[0] = AV43ConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char3) ;
      categoriaalta2wwexport.this.AV43ConveCodigo = GXv_char3[0] ;
      GXv_int4[0] = AV42PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV40CliCod, GXv_int4) ;
      categoriaalta2wwexport.this.AV42PaiCod = GXv_int4[0] ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCategoriaAlta2", GXv_boolean6) ;
      categoriaalta2wwexport.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV58Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "CategoriaAlta2WWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV37TFCatCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Categoria", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         categoriaalta2wwexport.this.AV14CellRow = GXv_int4[0] ;
         AV39i = 1 ;
         AV59GXV1 = 1 ;
         while ( AV59GXV1 <= AV37TFCatCodigo_Sels.size() )
         {
            AV38TFCatCodigo_Sel = (String)AV37TFCatCodigo_Sels.elementAt(-1+AV59GXV1) ;
            if ( AV39i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFCatCodigo_Sel, GXv_char3) ;
            categoriaalta2wwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV39i = (long)(AV39i+1) ;
            AV59GXV1 = (int)(AV59GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV36TFCatCodigo)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Categoria", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            categoriaalta2wwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFCatCodigo, GXv_char3) ;
            categoriaalta2wwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char9 );
         }
      }
      if ( ! ( ( AV46TFCatDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc8[0] = AV11ExcelDocument ;
         GXv_int4[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Categoría", "")) ;
         AV11ExcelDocument = GXv_exceldoc8[0] ;
         categoriaalta2wwexport.this.AV14CellRow = GXv_int4[0] ;
         AV39i = 1 ;
         AV60GXV2 = 1 ;
         while ( AV60GXV2 <= AV46TFCatDescrip_Sels.size() )
         {
            AV47TFCatDescrip_Sel = (String)AV46TFCatDescrip_Sels.elementAt(-1+AV60GXV2) ;
            if ( AV39i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFCatDescrip_Sel, GXv_char3) ;
            categoriaalta2wwexport.this.GXt_char9 = GXv_char3[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char9 );
            AV39i = (long)(AV39i+1) ;
            AV60GXV2 = (int)(AV60GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFCatDescrip)==0) ) )
         {
            GXv_exceldoc8[0] = AV11ExcelDocument ;
            GXv_int4[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc8, true, GXv_int4, (short)(AV15FirstColumn), httpContext.getMessage( "Categoría", "")) ;
            AV11ExcelDocument = GXv_exceldoc8[0] ;
            categoriaalta2wwexport.this.AV14CellRow = GXv_int4[0] ;
            GXt_char9 = "" ;
            GXv_char3[0] = GXt_char9 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFCatDescrip, GXv_char3) ;
            categoriaalta2wwexport.this.GXt_char9 = GXv_char3[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("CategoriaAlta2WWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("CategoriaAlta2WWColumnsSelector") ;
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
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Cli Cod", "") );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV26ColumnsSelector_Column, 0);
      AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "CliPaiConve" );
      AV26ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Cli Pai Conve", "") );
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
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV61GXV3 = 1 ;
      while ( AV61GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV61GXV3));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV61GXV3 = (int)(AV61GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A8CatCodigo ,
                                           AV37TFCatCodigo_Sels ,
                                           A123CatDescrip ,
                                           AV46TFCatDescrip_Sels ,
                                           Integer.valueOf(AV37TFCatCodigo_Sels.size()) ,
                                           AV36TFCatCodigo ,
                                           Integer.valueOf(AV46TFCatDescrip_Sels.size()) ,
                                           AV45TFCatDescrip ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV40CliCod) ,
                                           Short.valueOf(AV42PaiCod) ,
                                           AV43ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV36TFCatCodigo = GXutil.padr( GXutil.rtrim( AV36TFCatCodigo), 40, "%") ;
      lV45TFCatDescrip = GXutil.concat( GXutil.rtrim( AV45TFCatDescrip), "%", "") ;
      /* Using cursor P01LJ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV40CliCod), Short.valueOf(AV42PaiCod), AV43ConveCodigo, lV36TFCatCodigo, lV45TFCatDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P01LJ2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01LJ2_A1564CliPaiConve[0] ;
         A3CliCod = P01LJ2_A3CliCod[0] ;
         A123CatDescrip = P01LJ2_A123CatDescrip[0] ;
         A8CatCodigo = P01LJ2_A8CatCodigo[0] ;
         A1894CatRelSec = P01LJ2_A1894CatRelSec[0] ;
         n1894CatRelSec = P01LJ2_n1894CatRelSec[0] ;
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
         AV63GXV4 = 1 ;
         while ( AV63GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV63GXV4));
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
                  categoriaalta2wwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CatCodigo") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A8CatCodigo, GXv_char3) ;
                  categoriaalta2wwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CatDescrip") == 0 )
               {
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A123CatDescrip, GXv_char3) ;
                  categoriaalta2wwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&CliReDTChar") == 0 )
               {
                  GXt_char9 = AV54CliReDTChar ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.getreleasedtchar(remoteHandle, context).execute( A3CliCod, A1894CatRelSec, GXv_char3) ;
                  categoriaalta2wwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV54CliReDTChar = GXt_char9 ;
                  GXt_char9 = "" ;
                  GXv_char3[0] = GXt_char9 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV54CliReDTChar, GXv_char3) ;
                  categoriaalta2wwexport.this.GXt_char9 = GXv_char3[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char9 );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV63GXV4 = (int)(AV63GXV4+1) ;
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
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "CatCodigo", "", "Categoria", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "CatDescrip", "", "Categoría", true, "") ;
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
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "CategoriaAlta2WWColumnsSelector", GXv_char3) ;
      categoriaalta2wwexport.this.GXt_char9 = GXv_char3[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("CategoriaAlta2WWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "CategoriaAlta2WWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("CategoriaAlta2WWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV64GXV5 = 1 ;
      while ( AV64GXV5 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV64GXV5));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATCODIGO") == 0 )
         {
            AV36TFCatCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATCODIGO_SEL") == 0 )
         {
            AV35TFCatCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFCatCodigo_Sels.fromJSonString(AV35TFCatCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATDESCRIP") == 0 )
         {
            AV45TFCatDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATDESCRIP_SEL") == 0 )
         {
            AV44TFCatDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV46TFCatDescrip_Sels.fromJSonString(AV44TFCatDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV55MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV64GXV5 = (int)(AV64GXV5+1) ;
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
      this.aP0[0] = categoriaalta2wwexport.this.AV12Filename;
      this.aP1[0] = categoriaalta2wwexport.this.AV13ErrorMessage;
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
      AV43ConveCodigo = "" ;
      GXv_boolean6 = new boolean[1] ;
      AV58Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV37TFCatCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFCatCodigo_Sel = "" ;
      AV36TFCatCodigo = "" ;
      AV46TFCatDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47TFCatDescrip_Sel = "" ;
      AV45TFCatDescrip = "" ;
      GXv_exceldoc8 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int4 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      scmdbuf = "" ;
      lV36TFCatCodigo = "" ;
      lV45TFCatDescrip = "" ;
      A8CatCodigo = "" ;
      A123CatDescrip = "" ;
      A1565CliConvenio = "" ;
      P01LJ2_A1565CliConvenio = new String[] {""} ;
      P01LJ2_A1564CliPaiConve = new short[1] ;
      P01LJ2_A3CliCod = new int[1] ;
      P01LJ2_A123CatDescrip = new String[] {""} ;
      P01LJ2_A8CatCodigo = new String[] {""} ;
      P01LJ2_A1894CatRelSec = new short[1] ;
      P01LJ2_n1894CatRelSec = new boolean[] {false} ;
      AV54CliReDTChar = "" ;
      AV28UserCustomValue = "" ;
      GXt_char9 = "" ;
      GXv_char3 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFCatCodigo_SelsJson = "" ;
      AV44TFCatDescrip_SelsJson = "" ;
      AV55MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.categoriaalta2wwexport__default(),
         new Object[] {
             new Object[] {
            P01LJ2_A1565CliConvenio, P01LJ2_A1564CliPaiConve, P01LJ2_A3CliCod, P01LJ2_A123CatDescrip, P01LJ2_A8CatCodigo, P01LJ2_A1894CatRelSec, P01LJ2_n1894CatRelSec
            }
         }
      );
      AV58Pgmname = "CategoriaAlta2WWExport" ;
      /* GeneXus formulas. */
      AV58Pgmname = "CategoriaAlta2WWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV42PaiCod ;
   private short GXv_int4[] ;
   private short AV18OrderedBy ;
   private short A1564CliPaiConve ;
   private short A1894CatRelSec ;
   private short Gx_err ;
   private int AV40CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV59GXV1 ;
   private int AV60GXV2 ;
   private int AV61GXV3 ;
   private int AV37TFCatCodigo_Sels_size ;
   private int AV46TFCatDescrip_Sels_size ;
   private int A3CliCod ;
   private int AV63GXV4 ;
   private int AV64GXV5 ;
   private long AV39i ;
   private long AV32VisibleColumnCount ;
   private String AV43ConveCodigo ;
   private String AV58Pgmname ;
   private String AV38TFCatCodigo_Sel ;
   private String AV36TFCatCodigo ;
   private String scmdbuf ;
   private String lV36TFCatCodigo ;
   private String A8CatCodigo ;
   private String A1565CliConvenio ;
   private String GXt_char9 ;
   private String GXv_char3[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private boolean n1894CatRelSec ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFCatCodigo_SelsJson ;
   private String AV44TFCatDescrip_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV47TFCatDescrip_Sel ;
   private String AV45TFCatDescrip ;
   private String lV45TFCatDescrip ;
   private String A123CatDescrip ;
   private String AV54CliReDTChar ;
   private String AV55MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV37TFCatCodigo_Sels ;
   private GXSimpleCollection<String> AV46TFCatDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P01LJ2_A1565CliConvenio ;
   private short[] P01LJ2_A1564CliPaiConve ;
   private int[] P01LJ2_A3CliCod ;
   private String[] P01LJ2_A123CatDescrip ;
   private String[] P01LJ2_A8CatCodigo ;
   private short[] P01LJ2_A1894CatRelSec ;
   private boolean[] P01LJ2_n1894CatRelSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc8[] ;
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

final  class categoriaalta2wwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01LJ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A8CatCodigo ,
                                          GXSimpleCollection<String> AV37TFCatCodigo_Sels ,
                                          String A123CatDescrip ,
                                          GXSimpleCollection<String> AV46TFCatDescrip_Sels ,
                                          int AV37TFCatCodigo_Sels_size ,
                                          String AV36TFCatCodigo ,
                                          int AV46TFCatDescrip_Sels_size ,
                                          String AV45TFCatDescrip ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV40CliCod ,
                                          short AV42PaiCod ,
                                          String AV43ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[5];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliPaiConve, CliCod, CatDescrip, CatCodigo, CatRelSec FROM Categoria1" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( ( AV37TFCatCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV36TFCatCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CatCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( AV37TFCatCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV37TFCatCodigo_Sels, "CatCodigo IN (", ")")+")");
      }
      if ( ( AV46TFCatDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45TFCatDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CatDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( AV46TFCatDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46TFCatDescrip_Sels, "CatDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CatCodigo" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CatCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CatDescrip" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CatDescrip DESC" ;
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
                  return conditional_P01LJ2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Boolean) dynConstraints[9]).booleanValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , (String)dynConstraints[15] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01LJ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 400);
               }
               return;
      }
   }

}

