package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_getimportexcelcolumnindexes extends GXProcedure
{
   public wwp_getimportexcelcolumnindexes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_getimportexcelcolumnindexes.class ), "" );
   }

   public wwp_getimportexcelcolumnindexes( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( GXSimpleCollection<String> aP0 ,
                            com.genexus.gxoffice.ExcelDoc aP1 ,
                            long aP2 ,
                            String[] aP3 ,
                            GXSimpleCollection<Short>[] aP4 ,
                            short[] aP5 )
   {
      wwp_getimportexcelcolumnindexes.this.aP6 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( GXSimpleCollection<String> aP0 ,
                        com.genexus.gxoffice.ExcelDoc aP1 ,
                        long aP2 ,
                        String[] aP3 ,
                        GXSimpleCollection<Short>[] aP4 ,
                        short[] aP5 ,
                        short[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( GXSimpleCollection<String> aP0 ,
                             com.genexus.gxoffice.ExcelDoc aP1 ,
                             long aP2 ,
                             String[] aP3 ,
                             GXSimpleCollection<Short>[] aP4 ,
                             short[] aP5 ,
                             short[] aP6 )
   {
      wwp_getimportexcelcolumnindexes.this.AV19TitleNames = aP0;
      wwp_getimportexcelcolumnindexes.this.AV14ExcelDocument = aP1;
      wwp_getimportexcelcolumnindexes.this.AV17LineNumber = aP2;
      wwp_getimportexcelcolumnindexes.this.aP3 = aP3;
      wwp_getimportexcelcolumnindexes.this.aP4 = aP4;
      wwp_getimportexcelcolumnindexes.this.aP5 = aP5;
      wwp_getimportexcelcolumnindexes.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9ColumIndexes = new GXSimpleCollection<Short>(Short.class, "internal", "") ;
      AV11ColumnsLineSplitted = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV12ContinueReading = true ;
      AV8ColIndex = (short)(1) ;
      while ( AV12ContinueReading )
      {
         if ( GXutil.strcmp(AV14ExcelDocument.Cells((int)(AV17LineNumber), AV8ColIndex, 1, 1).getText(), "") != 0 )
         {
            AV21tituloColumna = AV14ExcelDocument.Cells((int)(AV17LineNumber), AV8ColIndex, 1, 1).getText() ;
            new web.ojoquepisawwplus(remoteHandle, context).execute( ) ;
            if ( GXutil.strSearch( AV21tituloColumna, "*", 1) != 0 )
            {
               AV23menosCant = (short)(3) ;
            }
            else
            {
               AV23menosCant = (short)(2) ;
            }
            AV22cuantos = (short)(GXutil.len( AV21tituloColumna)-AV23menosCant) ;
            AV21tituloColumna = GXutil.substring( AV21tituloColumna, 1, AV22cuantos) ;
            AV11ColumnsLineSplitted.add(GXutil.upper( GXutil.trim( AV21tituloColumna)), 0);
            AV8ColIndex = (short)(AV8ColIndex+1) ;
         }
         else
         {
            AV12ContinueReading = false ;
         }
      }
      AV20ColumnsCount = (short)(AV11ColumnsLineSplitted.size()) ;
      AV26GXV1 = 1 ;
      while ( AV26GXV1 <= AV19TitleNames.size() )
      {
         AV18TitleName = (String)AV19TitleNames.elementAt(-1+AV26GXV1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "&TitleName \"", "")+AV18TitleName+"\"") ;
         AV16Index = (short)(AV11ColumnsLineSplitted.indexof(GXutil.upper( GXutil.trim( AV18TitleName)))) ;
         AV9ColumIndexes.add((short)(AV16Index), 0);
         AV26GXV1 = (int)(AV26GXV1+1) ;
      }
      AV10ColumnsFound = (short)(0) ;
      AV13DiscardedColumns = "" ;
      AV15i = (short)(1) ;
      while ( AV15i <= AV11ColumnsLineSplitted.size() )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "&ColumnsLineSplitted \"", "")+(String)AV11ColumnsLineSplitted.elementAt(-1+AV15i)+"\"") ;
         if ( AV9ColumIndexes.indexof(AV15i) == 0 )
         {
            if ( ! (GXutil.strcmp("", AV13DiscardedColumns)==0) )
            {
               AV13DiscardedColumns += ", " ;
            }
            AV13DiscardedColumns += (String)AV11ColumnsLineSplitted.elementAt(-1+AV15i) ;
         }
         else
         {
            AV10ColumnsFound = (short)(AV10ColumnsFound+1) ;
         }
         AV15i = (short)(AV15i+1) ;
      }
      if ( GXutil.len( AV13DiscardedColumns) > 50 )
      {
         AV13DiscardedColumns = GXutil.substring( AV13DiscardedColumns, 1, 50) ;
         AV13DiscardedColumns = GXutil.trim( AV13DiscardedColumns) + "..." ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = wwp_getimportexcelcolumnindexes.this.AV13DiscardedColumns;
      this.aP4[0] = wwp_getimportexcelcolumnindexes.this.AV9ColumIndexes;
      this.aP5[0] = wwp_getimportexcelcolumnindexes.this.AV20ColumnsCount;
      this.aP6[0] = wwp_getimportexcelcolumnindexes.this.AV10ColumnsFound;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13DiscardedColumns = "" ;
      AV9ColumIndexes = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV11ColumnsLineSplitted = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21tituloColumna = "" ;
      AV18TitleName = "" ;
      AV27Pgmname = "" ;
      AV27Pgmname = "WWPBaseObjects.WWP_GetImportExcelColumnIndexes" ;
      /* GeneXus formulas. */
      AV27Pgmname = "WWPBaseObjects.WWP_GetImportExcelColumnIndexes" ;
      Gx_err = (short)(0) ;
   }

   private short AV20ColumnsCount ;
   private short AV10ColumnsFound ;
   private short AV8ColIndex ;
   private short AV23menosCant ;
   private short AV22cuantos ;
   private short AV16Index ;
   private short AV15i ;
   private short Gx_err ;
   private int AV26GXV1 ;
   private long AV17LineNumber ;
   private String AV27Pgmname ;
   private boolean AV12ContinueReading ;
   private String AV13DiscardedColumns ;
   private String AV21tituloColumna ;
   private String AV18TitleName ;
   private GXSimpleCollection<Short> AV9ColumIndexes ;
   private short[] aP6 ;
   private String[] aP3 ;
   private GXSimpleCollection<Short>[] aP4 ;
   private short[] aP5 ;
   private com.genexus.gxoffice.ExcelDoc AV14ExcelDocument ;
   private GXSimpleCollection<String> AV19TitleNames ;
   private GXSimpleCollection<String> AV11ColumnsLineSplitted ;
}

