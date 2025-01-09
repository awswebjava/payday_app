package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegajopuesto extends GXProcedure
{
   public getlegajopuesto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegajopuesto.class ), "" );
   }

   public getlegajopuesto( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      getlegajopuesto.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      getlegajopuesto.this.AV11CliCod = aP0;
      getlegajopuesto.this.AV10EmpCod = aP1;
      getlegajopuesto.this.AV9LegNumero = aP2;
      getlegajopuesto.this.aP3 = aP3;
      getlegajopuesto.this.aP4 = aP4;
      getlegajopuesto.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01CT2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01CT2_A6LegNumero[0] ;
         A1EmpCod = P01CT2_A1EmpCod[0] ;
         A3CliCod = P01CT2_A3CliCod[0] ;
         A1579LegSecCodigo = P01CT2_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01CT2_n1579LegSecCodigo[0] ;
         A1578LegPuesCodigo = P01CT2_A1578LegPuesCodigo[0] ;
         n1578LegPuesCodigo = P01CT2_n1578LegPuesCodigo[0] ;
         A1241PuestoDescrip = P01CT2_A1241PuestoDescrip[0] ;
         n1241PuestoDescrip = P01CT2_n1241PuestoDescrip[0] ;
         A1241PuestoDescrip = P01CT2_A1241PuestoDescrip[0] ;
         n1241PuestoDescrip = P01CT2_n1241PuestoDescrip[0] ;
         AV13SecCodigo = A1579LegSecCodigo ;
         AV12PuestoCodigo = A1578LegPuesCodigo ;
         AV14PuestoDescrip = A1241PuestoDescrip ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegajopuesto.this.AV13SecCodigo;
      this.aP4[0] = getlegajopuesto.this.AV12PuestoCodigo;
      this.aP5[0] = getlegajopuesto.this.AV14PuestoDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13SecCodigo = "" ;
      AV12PuestoCodigo = "" ;
      AV14PuestoDescrip = "" ;
      scmdbuf = "" ;
      P01CT2_A6LegNumero = new int[1] ;
      P01CT2_A1EmpCod = new short[1] ;
      P01CT2_A3CliCod = new int[1] ;
      P01CT2_A1579LegSecCodigo = new String[] {""} ;
      P01CT2_n1579LegSecCodigo = new boolean[] {false} ;
      P01CT2_A1578LegPuesCodigo = new String[] {""} ;
      P01CT2_n1578LegPuesCodigo = new boolean[] {false} ;
      P01CT2_A1241PuestoDescrip = new String[] {""} ;
      P01CT2_n1241PuestoDescrip = new boolean[] {false} ;
      A1579LegSecCodigo = "" ;
      A1578LegPuesCodigo = "" ;
      A1241PuestoDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegajopuesto__default(),
         new Object[] {
             new Object[] {
            P01CT2_A6LegNumero, P01CT2_A1EmpCod, P01CT2_A3CliCod, P01CT2_A1579LegSecCodigo, P01CT2_n1579LegSecCodigo, P01CT2_A1578LegPuesCodigo, P01CT2_n1578LegPuesCodigo, P01CT2_A1241PuestoDescrip, P01CT2_n1241PuestoDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV13SecCodigo ;
   private String AV12PuestoCodigo ;
   private String scmdbuf ;
   private String A1579LegSecCodigo ;
   private String A1578LegPuesCodigo ;
   private boolean n1579LegSecCodigo ;
   private boolean n1578LegPuesCodigo ;
   private boolean n1241PuestoDescrip ;
   private String AV14PuestoDescrip ;
   private String A1241PuestoDescrip ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01CT2_A6LegNumero ;
   private short[] P01CT2_A1EmpCod ;
   private int[] P01CT2_A3CliCod ;
   private String[] P01CT2_A1579LegSecCodigo ;
   private boolean[] P01CT2_n1579LegSecCodigo ;
   private String[] P01CT2_A1578LegPuesCodigo ;
   private boolean[] P01CT2_n1578LegPuesCodigo ;
   private String[] P01CT2_A1241PuestoDescrip ;
   private boolean[] P01CT2_n1241PuestoDescrip ;
}

final  class getlegajopuesto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CT2", "SELECT T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LegSecCodigo AS LegSecCodigo, T1.LegPuesCodigo AS LegPuesCodigo, T2.PuestoDescrip FROM (Legajo T1 LEFT JOIN Puesto T2 ON T2.CliCod = T1.CliCod AND T2.SecCodigo = T1.LegSecCodigo AND T2.PuestoCodigo = T1.LegPuesCodigo) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

