package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdatosconcepto5 extends GXProcedure
{
   public getdatosconcepto5( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdatosconcepto5.class ), "" );
   }

   public getdatosconcepto5( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 ,
                              byte[] aP3 ,
                              boolean[] aP4 )
   {
      getdatosconcepto5.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        byte[] aP3 ,
                        boolean[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             byte[] aP3 ,
                             boolean[] aP4 ,
                             boolean[] aP5 )
   {
      getdatosconcepto5.this.AV13CliCod = aP0;
      getdatosconcepto5.this.AV8ConCodigo = aP1;
      getdatosconcepto5.this.aP2 = aP2;
      getdatosconcepto5.this.aP3 = aP3;
      getdatosconcepto5.this.aP4 = aP4;
      getdatosconcepto5.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01SC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), AV8ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01SC2_A26ConCodigo[0] ;
         A3CliCod = P01SC2_A3CliCod[0] ;
         A148ConFormula = P01SC2_A148ConFormula[0] ;
         n148ConFormula = P01SC2_n148ConFormula[0] ;
         A162ConVigencia = P01SC2_A162ConVigencia[0] ;
         A1068ConMostrarPos = P01SC2_A1068ConMostrarPos[0] ;
         A1821ConErrorSiCero = P01SC2_A1821ConErrorSiCero[0] ;
         AV12ConFormula = A148ConFormula ;
         AV11ConVigencia = A162ConVigencia ;
         AV10ConMostrarPos = A1068ConMostrarPos ;
         AV9ConErrorSiCero = A1821ConErrorSiCero ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getdatosconcepto5.this.AV12ConFormula;
      this.aP3[0] = getdatosconcepto5.this.AV11ConVigencia;
      this.aP4[0] = getdatosconcepto5.this.AV10ConMostrarPos;
      this.aP5[0] = getdatosconcepto5.this.AV9ConErrorSiCero;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12ConFormula = "" ;
      scmdbuf = "" ;
      P01SC2_A26ConCodigo = new String[] {""} ;
      P01SC2_A3CliCod = new int[1] ;
      P01SC2_A148ConFormula = new String[] {""} ;
      P01SC2_n148ConFormula = new boolean[] {false} ;
      P01SC2_A162ConVigencia = new byte[1] ;
      P01SC2_A1068ConMostrarPos = new boolean[] {false} ;
      P01SC2_A1821ConErrorSiCero = new boolean[] {false} ;
      A26ConCodigo = "" ;
      A148ConFormula = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdatosconcepto5__default(),
         new Object[] {
             new Object[] {
            P01SC2_A26ConCodigo, P01SC2_A3CliCod, P01SC2_A148ConFormula, P01SC2_n148ConFormula, P01SC2_A162ConVigencia, P01SC2_A1068ConMostrarPos, P01SC2_A1821ConErrorSiCero
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11ConVigencia ;
   private byte A162ConVigencia ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int A3CliCod ;
   private String AV8ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean AV10ConMostrarPos ;
   private boolean AV9ConErrorSiCero ;
   private boolean n148ConFormula ;
   private boolean A1068ConMostrarPos ;
   private boolean A1821ConErrorSiCero ;
   private String AV12ConFormula ;
   private String A148ConFormula ;
   private boolean[] aP5 ;
   private String[] aP2 ;
   private byte[] aP3 ;
   private boolean[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01SC2_A26ConCodigo ;
   private int[] P01SC2_A3CliCod ;
   private String[] P01SC2_A148ConFormula ;
   private boolean[] P01SC2_n148ConFormula ;
   private byte[] P01SC2_A162ConVigencia ;
   private boolean[] P01SC2_A1068ConMostrarPos ;
   private boolean[] P01SC2_A1821ConErrorSiCero ;
}

final  class getdatosconcepto5__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01SC2", "SELECT ConCodigo, CliCod, ConFormula, ConVigencia, ConMostrarPos, ConErrorSiCero FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[4])[0] = rslt.getByte(4);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
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
      }
   }

}

