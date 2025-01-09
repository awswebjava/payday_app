package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class aexcelhistorico_impl extends GXWebProcedure
{
   public aexcelhistorico_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public void webExecute( )
   {
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "ImpSec") ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( ! entryPointCalled )
      {
         AV20ImpSec = GXutil.lval( gxfirstwebparm) ;
      }
      if ( toggleJsOutput )
      {
      }
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13Filename = com.genexus.util.GXDirectory.temporaryfilespath() + AV12File.getSeparator() + "ImportacionFormulas-" + GXutil.trim( GXutil.str( AV20ImpSec, 18, 0)) + ".xlsx" ;
      AV11ExcelDocument.Open(AV13Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV11ExcelDocument.Clear();
      AV11ExcelDocument.setAutoFit( (short)(1) );
      AV8CellRow = 1 ;
      AV14FirstColumn = 1 ;
      AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn, 1, 1).setSize( 15 );
      AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn, 1, 1).setText( httpContext.getMessage( "Formula Historicos", "") );
      AV8CellRow = (int)(AV8CellRow+4) ;
      /* Using cursor P00BL2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV20ImpSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A52ImpSec = P00BL2_A52ImpSec[0] ;
         n52ImpSec = P00BL2_n52ImpSec[0] ;
         A225ImpFecha = P00BL2_A225ImpFecha[0] ;
         A226ImpUsuario = P00BL2_A226ImpUsuario[0] ;
         A3CliCod = P00BL2_A3CliCod[0] ;
         AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+0, 1, 1).setBold( (short)(1) );
         AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+0, 1, 1).setText( httpContext.getMessage( "Fecha", "") );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+1, 1, 1).setDate( A225ImpFecha );
         AV8CellRow = (int)(AV8CellRow+1) ;
         AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+0, 1, 1).setBold( (short)(1) );
         AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+0, 1, 1).setText( httpContext.getMessage( "Usuario", "") );
         AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+1, 1, 1).setText( GXutil.trim( A226ImpUsuario) );
         AV8CellRow = (int)(AV8CellRow+1) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV8CellRow = (int)(AV8CellRow+3) ;
      AV9ColumnIndex = (short)(0) ;
      AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+AV9ColumnIndex, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+AV9ColumnIndex, 1, 1).setText( httpContext.getMessage( "Concepto", "") );
      AV9ColumnIndex = (short)(AV9ColumnIndex+1) ;
      AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+AV9ColumnIndex, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+AV9ColumnIndex, 1, 1).setText( httpContext.getMessage( "Antes", "") );
      AV9ColumnIndex = (short)(AV9ColumnIndex+1) ;
      AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+AV9ColumnIndex, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+AV9ColumnIndex, 1, 1).setText( httpContext.getMessage( "Despues", "") );
      AV9ColumnIndex = (short)(AV9ColumnIndex+1) ;
      /* Using cursor P00BL3 */
      pr_default.execute(1, new Object[] {Long.valueOf(AV20ImpSec)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A52ImpSec = P00BL3_A52ImpSec[0] ;
         n52ImpSec = P00BL3_n52ImpSec[0] ;
         A221ForHisAntes = P00BL3_A221ForHisAntes[0] ;
         n221ForHisAntes = P00BL3_n221ForHisAntes[0] ;
         A222ForHisDespues = P00BL3_A222ForHisDespues[0] ;
         A26ConCodigo = P00BL3_A26ConCodigo[0] ;
         A3CliCod = P00BL3_A3CliCod[0] ;
         A51ForHisNum = P00BL3_A51ForHisNum[0] ;
         AV8CellRow = (int)(AV8CellRow+1) ;
         AV9ColumnIndex = (short)(0) ;
         AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+AV9ColumnIndex, 1, 1).setText( GXutil.rtrim( A26ConCodigo) );
         AV9ColumnIndex = (short)(AV9ColumnIndex+1) ;
         AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+AV9ColumnIndex, 1, 1).setText( GXutil.substring( GXutil.rtrim( A221ForHisAntes), 1, 1000) );
         AV9ColumnIndex = (short)(AV9ColumnIndex+1) ;
         AV11ExcelDocument.Cells(AV8CellRow, AV14FirstColumn+AV9ColumnIndex, 1, 1).setText( GXutil.substring( GXutil.rtrim( A222ForHisDespues), 1, 1000) );
         AV9ColumnIndex = (short)(AV9ColumnIndex+1) ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      AV11ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV11ExcelDocument.Close();
      if ( ! httpContext.isAjaxRequest( ) )
      {
         AV19HttpResponse.addHeader("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         AV19HttpResponse.addHeader("Content-Disposition", "attachment;filename=ImportacionFormulas"+GXutil.trim( GXutil.str( AV20ImpSec, 18, 0))+httpContext.getMessage( ".xlsx", ""));
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         AV19HttpResponse.addHeader("X-Frame-Options", "deny");
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         AV19HttpResponse.addHeader("Type-Options", " nosniff");
      }
      AV19HttpResponse.addFile(AV13Filename);
      AV12File.setSource( AV13Filename );
      AV23ret = GXutil.sleep( 10) ;
      AV12File.delete();
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV11ExcelDocument.getErrCode() != 0 )
      {
         AV13Filename = "" ;
         AV10ErrorMessage = AV11ExcelDocument.getErrDescription() ;
         AV19HttpResponse.addString(AV10ErrorMessage);
         httpContext.nUserReturn = (byte)(1) ;
         if ( httpContext.willRedirect( ) )
         {
            httpContext.redirect( httpContext.wjLoc );
            httpContext.wjLoc = "" ;
         }
         returnInSub = true;
         if (true) return;
      }
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      super.cleanup();
      AV11ExcelDocument.cleanup();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXKey = "" ;
      gxfirstwebparm = "" ;
      AV13Filename = "" ;
      AV12File = new com.genexus.util.GXFile();
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      scmdbuf = "" ;
      P00BL2_A52ImpSec = new long[1] ;
      P00BL2_n52ImpSec = new boolean[] {false} ;
      P00BL2_A225ImpFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00BL2_A226ImpUsuario = new String[] {""} ;
      P00BL2_A3CliCod = new int[1] ;
      A225ImpFecha = GXutil.resetTime( GXutil.nullDate() );
      A226ImpUsuario = "" ;
      P00BL3_A52ImpSec = new long[1] ;
      P00BL3_n52ImpSec = new boolean[] {false} ;
      P00BL3_A221ForHisAntes = new String[] {""} ;
      P00BL3_n221ForHisAntes = new boolean[] {false} ;
      P00BL3_A222ForHisDespues = new String[] {""} ;
      P00BL3_A26ConCodigo = new String[] {""} ;
      P00BL3_A3CliCod = new int[1] ;
      P00BL3_A51ForHisNum = new short[1] ;
      A221ForHisAntes = "" ;
      A222ForHisDespues = "" ;
      A26ConCodigo = "" ;
      AV19HttpResponse = httpContext.getHttpResponse();
      AV10ErrorMessage = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.aexcelhistorico__default(),
         new Object[] {
             new Object[] {
            P00BL2_A52ImpSec, P00BL2_A225ImpFecha, P00BL2_A226ImpUsuario, P00BL2_A3CliCod
            }
            , new Object[] {
            P00BL3_A52ImpSec, P00BL3_n52ImpSec, P00BL3_A221ForHisAntes, P00BL3_n221ForHisAntes, P00BL3_A222ForHisDespues, P00BL3_A26ConCodigo, P00BL3_A3CliCod, P00BL3_A51ForHisNum
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV9ColumnIndex ;
   private short A51ForHisNum ;
   private short AV23ret ;
   private short Gx_err ;
   private int AV8CellRow ;
   private int AV14FirstColumn ;
   private int A3CliCod ;
   private long AV20ImpSec ;
   private long A52ImpSec ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String scmdbuf ;
   private String A226ImpUsuario ;
   private String A26ConCodigo ;
   private java.util.Date A225ImpFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean returnInSub ;
   private boolean n52ImpSec ;
   private boolean n221ForHisAntes ;
   private String A221ForHisAntes ;
   private String A222ForHisDespues ;
   private String AV13Filename ;
   private String AV10ErrorMessage ;
   private com.genexus.util.GXFile AV12File ;
   private IDataStoreProvider pr_default ;
   private long[] P00BL2_A52ImpSec ;
   private boolean[] P00BL2_n52ImpSec ;
   private java.util.Date[] P00BL2_A225ImpFecha ;
   private String[] P00BL2_A226ImpUsuario ;
   private int[] P00BL2_A3CliCod ;
   private long[] P00BL3_A52ImpSec ;
   private boolean[] P00BL3_n52ImpSec ;
   private String[] P00BL3_A221ForHisAntes ;
   private boolean[] P00BL3_n221ForHisAntes ;
   private String[] P00BL3_A222ForHisDespues ;
   private String[] P00BL3_A26ConCodigo ;
   private int[] P00BL3_A3CliCod ;
   private short[] P00BL3_A51ForHisNum ;
   private com.genexus.internet.HttpResponse AV19HttpResponse ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
}

final  class aexcelhistorico__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00BL2", "SELECT ImpSec, ImpFecha, ImpUsuario, CliCod FROM Importacion WHERE ImpSec = ? ORDER BY CliCod, ImpSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00BL3", "SELECT ImpSec, ForHisAntes, ForHisDespues, ConCodigo, CliCod, ForHisNum FROM FormulaHistorico WHERE ImpSec = ? ORDER BY ImpSec, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 200);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[5])[0] = rslt.getString(4, 10);
               ((int[]) buf[6])[0] = rslt.getInt(5);
               ((short[]) buf[7])[0] = rslt.getShort(6);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

