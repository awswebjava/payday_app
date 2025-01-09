package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class revivirapendientestodos extends GXProcedure
{
   public revivirapendientestodos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( revivirapendientestodos.class ), "" );
   }

   public revivirapendientestodos( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              GXSimpleCollection<Integer> aP3 )
   {
      revivirapendientestodos.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             boolean[] aP4 )
   {
      revivirapendientestodos.this.AV11CliCod = aP0;
      revivirapendientestodos.this.AV10EmpCod = aP1;
      revivirapendientestodos.this.AV8LiqNro = aP2;
      revivirapendientestodos.this.AV9LegNumero = aP3;
      revivirapendientestodos.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17i = (short)(1) ;
      while ( AV17i <= AV9LegNumero.size() )
      {
         AV18auxLegNumero = ((Number) AV9LegNumero.elementAt(-1+AV17i)).intValue() ;
         /* Using cursor P01ER2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8LiqNro), Integer.valueOf(AV18auxLegNumero)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A507LiqDCalculado = P01ER2_A507LiqDCalculado[0] ;
            A6LegNumero = P01ER2_A6LegNumero[0] ;
            A31LiqNro = P01ER2_A31LiqNro[0] ;
            A1EmpCod = P01ER2_A1EmpCod[0] ;
            A3CliCod = P01ER2_A3CliCod[0] ;
            A464DTipoConCod = P01ER2_A464DTipoConCod[0] ;
            A394DConCodigo = P01ER2_A394DConCodigo[0] ;
            A81LiqDSecuencial = P01ER2_A81LiqDSecuencial[0] ;
            GXt_boolean1 = AV15EsConceptoImprimible ;
            GXv_boolean2[0] = GXt_boolean1 ;
            new web.esconceptoimprimible(remoteHandle, context).execute( A464DTipoConCod, GXv_boolean2) ;
            revivirapendientestodos.this.GXt_boolean1 = GXv_boolean2[0] ;
            AV15EsConceptoImprimible = GXt_boolean1 ;
            if ( ! AV15EsConceptoImprimible )
            {
               A507LiqDCalculado = (byte)(0) ;
               AV16revividosTiene = true ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&LiqNro ", "")+GXutil.trim( GXutil.str( AV8LiqNro, 8, 0))+httpContext.getMessage( " revive a dconcodigo ", "")+GXutil.trim( A394DConCodigo)) ;
            }
            /* Using cursor P01ER3 */
            pr_default.execute(1, new Object[] {Byte.valueOf(A507LiqDCalculado), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV17i = (short)(AV17i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = revivirapendientestodos.this.AV16revividosTiene;
      Application.commitDataStores(context, remoteHandle, pr_default, "revivirapendientestodos");
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
      P01ER2_A507LiqDCalculado = new byte[1] ;
      P01ER2_A6LegNumero = new int[1] ;
      P01ER2_A31LiqNro = new int[1] ;
      P01ER2_A1EmpCod = new short[1] ;
      P01ER2_A3CliCod = new int[1] ;
      P01ER2_A464DTipoConCod = new String[] {""} ;
      P01ER2_A394DConCodigo = new String[] {""} ;
      P01ER2_A81LiqDSecuencial = new int[1] ;
      A464DTipoConCod = "" ;
      A394DConCodigo = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV22Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.revivirapendientestodos__default(),
         new Object[] {
             new Object[] {
            P01ER2_A507LiqDCalculado, P01ER2_A6LegNumero, P01ER2_A31LiqNro, P01ER2_A1EmpCod, P01ER2_A3CliCod, P01ER2_A464DTipoConCod, P01ER2_A394DConCodigo, P01ER2_A81LiqDSecuencial
            }
            , new Object[] {
            }
         }
      );
      AV22Pgmname = "revivirAPendientesTodos" ;
      /* GeneXus formulas. */
      AV22Pgmname = "revivirAPendientesTodos" ;
      Gx_err = (short)(0) ;
   }

   private byte A507LiqDCalculado ;
   private short AV10EmpCod ;
   private short AV17i ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LiqNro ;
   private int AV18auxLegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private String scmdbuf ;
   private String A464DTipoConCod ;
   private String A394DConCodigo ;
   private String AV22Pgmname ;
   private boolean AV16revividosTiene ;
   private boolean AV15EsConceptoImprimible ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private GXSimpleCollection<Integer> AV9LegNumero ;
   private boolean[] aP4 ;
   private IDataStoreProvider pr_default ;
   private byte[] P01ER2_A507LiqDCalculado ;
   private int[] P01ER2_A6LegNumero ;
   private int[] P01ER2_A31LiqNro ;
   private short[] P01ER2_A1EmpCod ;
   private int[] P01ER2_A3CliCod ;
   private String[] P01ER2_A464DTipoConCod ;
   private String[] P01ER2_A394DConCodigo ;
   private int[] P01ER2_A81LiqDSecuencial ;
}

final  class revivirapendientestodos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ER2", "SELECT LiqDCalculado, LegNumero, LiqNro, EmpCod, CliCod, DTipoConCod, DConCodigo, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND (LiqDCalculado >= 2) ORDER BY CliCod, EmpCod, LiqNro, LegNumero  FOR UPDATE OF LiquidacionDetalle",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01ER3", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDCalculado=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((int[]) buf[7])[0] = rslt.getInt(8);
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 1 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
      }
   }

}

