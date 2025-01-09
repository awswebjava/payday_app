package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajogetfamilia extends GXProcedure
{
   public legajogetfamilia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajogetfamilia.class ), "" );
   }

   public legajogetfamilia( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            boolean[] aP3 )
   {
      legajogetfamilia.this.aP4 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean[] aP3 ,
                        short[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean[] aP3 ,
                             short[] aP4 )
   {
      legajogetfamilia.this.AV10CliCod = aP0;
      legajogetfamilia.this.AV11EmpCod = aP1;
      legajogetfamilia.this.AV12legNumero = aP2;
      legajogetfamilia.this.aP3 = aP3;
      legajogetfamilia.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00OB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV12legNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00OB2_A6LegNumero[0] ;
         A1EmpCod = P00OB2_A1EmpCod[0] ;
         A3CliCod = P00OB2_A3CliCod[0] ;
         A30ParCod = P00OB2_A30ParCod[0] ;
         A2274ParenTipo = P00OB2_A2274ParenTipo[0] ;
         A29LegOrden = P00OB2_A29LegOrden[0] ;
         A2274ParenTipo = P00OB2_A2274ParenTipo[0] ;
         if ( GXutil.strcmp(A2274ParenTipo, "1") == 0 )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV8TieneConyuge = true ;
         }
         if ( GXutil.strcmp(A2274ParenTipo, "2") == 0 )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV9CantHijos = (short)(AV9CantHijos+1) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = legajogetfamilia.this.AV8TieneConyuge;
      this.aP4[0] = legajogetfamilia.this.AV9CantHijos;
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
      P00OB2_A6LegNumero = new int[1] ;
      P00OB2_A1EmpCod = new short[1] ;
      P00OB2_A3CliCod = new int[1] ;
      P00OB2_A30ParCod = new String[] {""} ;
      P00OB2_A2274ParenTipo = new String[] {""} ;
      P00OB2_A29LegOrden = new short[1] ;
      A30ParCod = "" ;
      A2274ParenTipo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajogetfamilia__default(),
         new Object[] {
             new Object[] {
            P00OB2_A6LegNumero, P00OB2_A1EmpCod, P00OB2_A3CliCod, P00OB2_A30ParCod, P00OB2_A2274ParenTipo, P00OB2_A29LegOrden
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV9CantHijos ;
   private short A1EmpCod ;
   private short A29LegOrden ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV12legNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A30ParCod ;
   private String A2274ParenTipo ;
   private boolean AV8TieneConyuge ;
   private boolean Cond_result ;
   private short[] aP4 ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00OB2_A6LegNumero ;
   private short[] P00OB2_A1EmpCod ;
   private int[] P00OB2_A3CliCod ;
   private String[] P00OB2_A30ParCod ;
   private String[] P00OB2_A2274ParenTipo ;
   private short[] P00OB2_A29LegOrden ;
}

final  class legajogetfamilia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00OB2", "SELECT T1.LegNumero, T1.EmpCod, T1.CliCod, T1.ParCod, T2.ParenTipo, T1.LegOrden FROM (LegajoFamilia T1 INNER JOIN Parentesco T2 ON T2.CliCod = T1.CliCod AND T2.ParCod = T1.ParCod) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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

