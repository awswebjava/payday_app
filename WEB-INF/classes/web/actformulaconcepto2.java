package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actformulaconcepto2 extends GXProcedure
{
   public actformulaconcepto2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actformulaconcepto2.class ), "" );
   }

   public actformulaconcepto2( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        int aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             int aP3 )
   {
      actformulaconcepto2.this.AV10CliCod = aP0;
      actformulaconcepto2.this.AV8ConCodigo = aP1;
      actformulaconcepto2.this.AV9ConFormula = aP2;
      actformulaconcepto2.this.AV13ConRelSec = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00K62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV8ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P00K62_A26ConCodigo[0] ;
         A3CliCod = P00K62_A3CliCod[0] ;
         A148ConFormula = P00K62_A148ConFormula[0] ;
         n148ConFormula = P00K62_n148ConFormula[0] ;
         A1886ConRelSec = P00K62_A1886ConRelSec[0] ;
         A2013ConRelRef = P00K62_A2013ConRelRef[0] ;
         GXv_char1[0] = AV9ConFormula ;
         new web.corregirespaciosformula(remoteHandle, context).execute( AV10CliCod, GXv_char1) ;
         actformulaconcepto2.this.AV9ConFormula = GXv_char1[0] ;
         new web.grabarhistorico(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo, GXutil.trim( A148ConFormula), GXutil.trim( AV9ConFormula), 0, false) ;
         AV15oldConFormula = AV9ConFormula ;
         A148ConFormula = AV9ConFormula ;
         n148ConFormula = false ;
         if ( ! (0==AV13ConRelSec) )
         {
            A1886ConRelSec = AV13ConRelSec ;
         }
         if ( GXutil.strcmp(GXutil.trim( A148ConFormula), AV15oldConFormula) != 0 )
         {
            GXv_char1[0] = AV14CliRelNombre ;
            new web.getclirelnombre(remoteHandle, context).execute( A3CliCod, A1886ConRelSec, GXv_char1) ;
            actformulaconcepto2.this.AV14CliRelNombre = GXv_char1[0] ;
            A2013ConRelRef = AV14CliRelNombre ;
         }
         /* Using cursor P00K63 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(n148ConFormula), A148ConFormula, Integer.valueOf(A1886ConRelSec), A2013ConRelRef, Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.inicializarconceptooperandos(remoteHandle, context).execute( AV10CliCod, AV8ConCodigo) ;
      Application.commitDataStores(context, remoteHandle, pr_default, "actformulaconcepto2");
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P00K62_A26ConCodigo = new String[] {""} ;
      P00K62_A3CliCod = new int[1] ;
      P00K62_A148ConFormula = new String[] {""} ;
      P00K62_n148ConFormula = new boolean[] {false} ;
      P00K62_A1886ConRelSec = new int[1] ;
      P00K62_A2013ConRelRef = new String[] {""} ;
      A26ConCodigo = "" ;
      A148ConFormula = "" ;
      A2013ConRelRef = "" ;
      AV15oldConFormula = "" ;
      AV14CliRelNombre = "" ;
      GXv_char1 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actformulaconcepto2__default(),
         new Object[] {
             new Object[] {
            P00K62_A26ConCodigo, P00K62_A3CliCod, P00K62_A148ConFormula, P00K62_n148ConFormula, P00K62_A1886ConRelSec, P00K62_A2013ConRelRef
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int AV13ConRelSec ;
   private int A3CliCod ;
   private int A1886ConRelSec ;
   private String AV8ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String GXv_char1[] ;
   private boolean n148ConFormula ;
   private String AV9ConFormula ;
   private String A148ConFormula ;
   private String AV15oldConFormula ;
   private String A2013ConRelRef ;
   private String AV14CliRelNombre ;
   private IDataStoreProvider pr_default ;
   private String[] P00K62_A26ConCodigo ;
   private int[] P00K62_A3CliCod ;
   private String[] P00K62_A148ConFormula ;
   private boolean[] P00K62_n148ConFormula ;
   private int[] P00K62_A1886ConRelSec ;
   private String[] P00K62_A2013ConRelRef ;
}

final  class actformulaconcepto2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00K62", "SELECT ConCodigo, CliCod, ConFormula, ConRelSec, ConRelRef FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00K63", "SAVEPOINT gxupdate;UPDATE Concepto SET ConFormula=?, ConRelSec=?, ConRelRef=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(1, (String)parms[1]);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setVarchar(3, (String)parms[3], 40, false);
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setString(5, (String)parms[5], 10);
               return;
      }
   }

}

