package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegajoarea extends GXProcedure
{
   public getlegajoarea( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegajoarea.class ), "" );
   }

   public getlegajoarea( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      getlegajoarea.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      getlegajoarea.this.AV11CliCod = aP0;
      getlegajoarea.this.AV10EmpCod = aP1;
      getlegajoarea.this.AV8LegNumero = aP2;
      getlegajoarea.this.aP3 = aP3;
      getlegajoarea.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005Q2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P005Q2_A6LegNumero[0] ;
         A1EmpCod = P005Q2_A1EmpCod[0] ;
         A3CliCod = P005Q2_A3CliCod[0] ;
         A1579LegSecCodigo = P005Q2_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P005Q2_n1579LegSecCodigo[0] ;
         AV9SecCodigo = A1579LegSecCodigo ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      GXv_char1[0] = AV12SecDescrip ;
      GXv_boolean2[0] = (boolean)((0==0)?false:true) ;
      new web.getseccion(remoteHandle, context).execute( AV11CliCod, AV9SecCodigo, GXv_char1, GXv_boolean2) ;
      getlegajoarea.this.AV12SecDescrip = GXv_char1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegajoarea.this.AV9SecCodigo;
      this.aP4[0] = getlegajoarea.this.AV12SecDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SecCodigo = "" ;
      AV12SecDescrip = "" ;
      scmdbuf = "" ;
      P005Q2_A6LegNumero = new int[1] ;
      P005Q2_A1EmpCod = new short[1] ;
      P005Q2_A3CliCod = new int[1] ;
      P005Q2_A1579LegSecCodigo = new String[] {""} ;
      P005Q2_n1579LegSecCodigo = new boolean[] {false} ;
      A1579LegSecCodigo = "" ;
      GXv_char1 = new String[1] ;
      GXv_boolean2 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegajoarea__default(),
         new Object[] {
             new Object[] {
            P005Q2_A6LegNumero, P005Q2_A1EmpCod, P005Q2_A3CliCod, P005Q2_A1579LegSecCodigo, P005Q2_n1579LegSecCodigo
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
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV9SecCodigo ;
   private String scmdbuf ;
   private String A1579LegSecCodigo ;
   private String GXv_char1[] ;
   private boolean n1579LegSecCodigo ;
   private boolean GXv_boolean2[] ;
   private String AV12SecDescrip ;
   private String[] aP4 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P005Q2_A6LegNumero ;
   private short[] P005Q2_A1EmpCod ;
   private int[] P005Q2_A3CliCod ;
   private String[] P005Q2_A1579LegSecCodigo ;
   private boolean[] P005Q2_n1579LegSecCodigo ;
}

final  class getlegajoarea__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005Q2", "SELECT LegNumero, EmpCod, CliCod, LegSecCodigo FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

