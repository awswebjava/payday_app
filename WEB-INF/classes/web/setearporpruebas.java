package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setearporpruebas extends GXProcedure
{
   public setearporpruebas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setearporpruebas.class ), "" );
   }

   public setearporpruebas( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String aP4 ,
                        java.math.BigDecimal aP5 ,
                        java.util.Date aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             java.math.BigDecimal aP5 ,
                             java.util.Date aP6 )
   {
      setearporpruebas.this.AV10CliCod = aP0;
      setearporpruebas.this.AV8EmpCod = aP1;
      setearporpruebas.this.AV9LegNumero = aP2;
      setearporpruebas.this.AV11LegConveCodigo = aP3;
      setearporpruebas.this.AV12LegSinCod = aP4;
      setearporpruebas.this.AV13LegSueldoFuera = aP5;
      setearporpruebas.this.AV14LegFecEgreso = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P016D2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P016D2_A6LegNumero[0] ;
         A1EmpCod = P016D2_A1EmpCod[0] ;
         A3CliCod = P016D2_A3CliCod[0] ;
         A937LegConveCodigo = P016D2_A937LegConveCodigo[0] ;
         n937LegConveCodigo = P016D2_n937LegConveCodigo[0] ;
         A939LegCatCodigo = P016D2_A939LegCatCodigo[0] ;
         n939LegCatCodigo = P016D2_n939LegCatCodigo[0] ;
         A910LegSinCod = P016D2_A910LegSinCod[0] ;
         n910LegSinCod = P016D2_n910LegSinCod[0] ;
         A244LegFecEgreso = P016D2_A244LegFecEgreso[0] ;
         n244LegFecEgreso = P016D2_n244LegFecEgreso[0] ;
         if ( ! (GXutil.strcmp("", AV11LegConveCodigo)==0) )
         {
            A937LegConveCodigo = AV11LegConveCodigo ;
            n937LegConveCodigo = false ;
            if ( GXutil.strcmp(AV11LegConveCodigo, new web.conveniouocra(remoteHandle, context).executeUdp( )) == 0 )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               A939LegCatCodigo = httpContext.getMessage( "OFI_B ", "") ;
               n939LegCatCodigo = false ;
            }
            else
            {
               if ( GXutil.strcmp(AV11LegConveCodigo, new web.conveniouecara(remoteHandle, context).executeUdp( )) == 0 )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  A939LegCatCodigo = httpContext.getMessage( "Centro_AyudanteTec ", "") ;
                  n939LegCatCodigo = false ;
               }
            }
         }
         else
         {
            A937LegConveCodigo = "" ;
            n937LegConveCodigo = false ;
            n937LegConveCodigo = true ;
         }
         if ( (GXutil.strcmp("", AV12LegSinCod)==0) )
         {
            A910LegSinCod = "" ;
            n910LegSinCod = false ;
            n910LegSinCod = true ;
         }
         else
         {
            A910LegSinCod = AV12LegSinCod ;
            n910LegSinCod = false ;
         }
         A244LegFecEgreso = AV14LegFecEgreso ;
         n244LegFecEgreso = false ;
         /* Using cursor P016D3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(n937LegConveCodigo), A937LegConveCodigo, Boolean.valueOf(n939LegCatCodigo), A939LegCatCodigo, Boolean.valueOf(n910LegSinCod), A910LegSinCod, Boolean.valueOf(n244LegFecEgreso), A244LegFecEgreso, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.actualizarlegajosueldoultimo(remoteHandle, context).execute( AV10CliCod, AV8EmpCod, AV9LegNumero, GXutil.serverDate( context, remoteHandle, pr_default), AV13LegSueldoFuera) ;
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "setearporpruebas");
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
      P016D2_A6LegNumero = new int[1] ;
      P016D2_A1EmpCod = new short[1] ;
      P016D2_A3CliCod = new int[1] ;
      P016D2_A937LegConveCodigo = new String[] {""} ;
      P016D2_n937LegConveCodigo = new boolean[] {false} ;
      P016D2_A939LegCatCodigo = new String[] {""} ;
      P016D2_n939LegCatCodigo = new boolean[] {false} ;
      P016D2_A910LegSinCod = new String[] {""} ;
      P016D2_n910LegSinCod = new boolean[] {false} ;
      P016D2_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      P016D2_n244LegFecEgreso = new boolean[] {false} ;
      A937LegConveCodigo = "" ;
      A939LegCatCodigo = "" ;
      A910LegSinCod = "" ;
      A244LegFecEgreso = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setearporpruebas__default(),
         new Object[] {
             new Object[] {
            P016D2_A6LegNumero, P016D2_A1EmpCod, P016D2_A3CliCod, P016D2_A937LegConveCodigo, P016D2_n937LegConveCodigo, P016D2_A939LegCatCodigo, P016D2_n939LegCatCodigo, P016D2_A910LegSinCod, P016D2_n910LegSinCod, P016D2_A244LegFecEgreso,
            P016D2_n244LegFecEgreso
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV13LegSueldoFuera ;
   private String AV11LegConveCodigo ;
   private String AV12LegSinCod ;
   private String scmdbuf ;
   private String A937LegConveCodigo ;
   private String A939LegCatCodigo ;
   private String A910LegSinCod ;
   private java.util.Date AV14LegFecEgreso ;
   private java.util.Date A244LegFecEgreso ;
   private boolean n937LegConveCodigo ;
   private boolean n939LegCatCodigo ;
   private boolean n910LegSinCod ;
   private boolean n244LegFecEgreso ;
   private boolean Cond_result ;
   private IDataStoreProvider pr_default ;
   private int[] P016D2_A6LegNumero ;
   private short[] P016D2_A1EmpCod ;
   private int[] P016D2_A3CliCod ;
   private String[] P016D2_A937LegConveCodigo ;
   private boolean[] P016D2_n937LegConveCodigo ;
   private String[] P016D2_A939LegCatCodigo ;
   private boolean[] P016D2_n939LegCatCodigo ;
   private String[] P016D2_A910LegSinCod ;
   private boolean[] P016D2_n910LegSinCod ;
   private java.util.Date[] P016D2_A244LegFecEgreso ;
   private boolean[] P016D2_n244LegFecEgreso ;
}

final  class setearporpruebas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P016D2", "SELECT LegNumero, EmpCod, CliCod, LegConveCodigo, LegCatCodigo, LegSinCod, LegFecEgreso FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero  FOR UPDATE OF Legajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P016D3", "SAVEPOINT gxupdate;UPDATE Legajo SET LegConveCodigo=?, LegCatCodigo=?, LegSinCod=?, LegFecEgreso=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[5])[0] = rslt.getString(5, 40);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
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
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 40);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[5], 20);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.DATE );
               }
               else
               {
                  stmt.setDate(4, (java.util.Date)parms[7]);
               }
               stmt.setInt(5, ((Number) parms[8]).intValue());
               stmt.setShort(6, ((Number) parms[9]).shortValue());
               stmt.setInt(7, ((Number) parms[10]).intValue());
               return;
      }
   }

}

