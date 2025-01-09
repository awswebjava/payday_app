package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptosegundoplano extends GXProcedure
{
   public getconceptosegundoplano( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptosegundoplano.class ), "" );
   }

   public getconceptosegundoplano( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              String aP3 ,
                              short aP4 )
   {
      getconceptosegundoplano.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 ,
                             boolean[] aP5 )
   {
      getconceptosegundoplano.this.AV10CliCod = aP0;
      getconceptosegundoplano.this.AV8EmpCod = aP1;
      getconceptosegundoplano.this.AV19legnumero = aP2;
      getconceptosegundoplano.this.AV9ConCodigo = aP3;
      getconceptosegundoplano.this.AV15CondicionPais = aP4;
      getconceptosegundoplano.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P019Y2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P019Y2_A26ConCodigo[0] ;
         A3CliCod = P019Y2_A3CliCod[0] ;
         A953ConCondicion = P019Y2_A953ConCondicion[0] ;
         n953ConCondicion = P019Y2_n953ConCondicion[0] ;
         AV14ConCondicion = A953ConCondicion ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      /* Using cursor P019Y3 */
      pr_default.execute(1, new Object[] {AV14ConCondicion, Short.valueOf(AV15CondicionPais)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A953ConCondicion = P019Y3_A953ConCondicion[0] ;
         n953ConCondicion = P019Y3_n953ConCondicion[0] ;
         A1757CondicionPais = P019Y3_A1757CondicionPais[0] ;
         A1786CondSegPla = P019Y3_A1786CondSegPla[0] ;
         if ( A1786CondSegPla == 0 )
         {
            AV17segundoPlanoEs = false ;
         }
         else
         {
            if ( A1786CondSegPla == 1 )
            {
               AV17segundoPlanoEs = true ;
            }
            else
            {
               GXv_boolean1[0] = AV17segundoPlanoEs ;
               new web.getlegagenreten(remoteHandle, context).execute( AV10CliCod, AV8EmpCod, AV19legnumero, GXv_boolean1) ;
               getconceptosegundoplano.this.AV17segundoPlanoEs = GXv_boolean1[0] ;
            }
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getconceptosegundoplano.this.AV17segundoPlanoEs;
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
      P019Y2_A26ConCodigo = new String[] {""} ;
      P019Y2_A3CliCod = new int[1] ;
      P019Y2_A953ConCondicion = new String[] {""} ;
      P019Y2_n953ConCondicion = new boolean[] {false} ;
      A26ConCodigo = "" ;
      A953ConCondicion = "" ;
      AV14ConCondicion = "" ;
      P019Y3_A953ConCondicion = new String[] {""} ;
      P019Y3_n953ConCondicion = new boolean[] {false} ;
      P019Y3_A1757CondicionPais = new short[1] ;
      P019Y3_A1786CondSegPla = new byte[1] ;
      GXv_boolean1 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptosegundoplano__default(),
         new Object[] {
             new Object[] {
            P019Y2_A26ConCodigo, P019Y2_A3CliCod, P019Y2_A953ConCondicion, P019Y2_n953ConCondicion
            }
            , new Object[] {
            P019Y3_A953ConCondicion, P019Y3_A1757CondicionPais, P019Y3_A1786CondSegPla
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1786CondSegPla ;
   private short AV8EmpCod ;
   private short AV15CondicionPais ;
   private short A1757CondicionPais ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV19legnumero ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A953ConCondicion ;
   private String AV14ConCondicion ;
   private boolean AV17segundoPlanoEs ;
   private boolean n953ConCondicion ;
   private boolean GXv_boolean1[] ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P019Y2_A26ConCodigo ;
   private int[] P019Y2_A3CliCod ;
   private String[] P019Y2_A953ConCondicion ;
   private boolean[] P019Y2_n953ConCondicion ;
   private String[] P019Y3_A953ConCondicion ;
   private boolean[] P019Y3_n953ConCondicion ;
   private short[] P019Y3_A1757CondicionPais ;
   private byte[] P019Y3_A1786CondSegPla ;
}

final  class getconceptosegundoplano__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P019Y2", "SELECT ConCodigo, CliCod, ConCondicion FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P019Y3", "SELECT ConCondicion, CondicionPais, CondSegPla FROM Condiciones_concepto WHERE (ConCondicion = ( ?)) AND (CondicionPais = ?) ORDER BY ConCondicion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
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
               stmt.setString(1, (String)parms[0], 20);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

