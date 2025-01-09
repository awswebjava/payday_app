package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculotieneparametros extends GXProcedure
{
   public calculotieneparametros( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculotieneparametros.class ), "" );
   }

   public calculotieneparametros( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 ,
                              String aP1 )
   {
      calculotieneparametros.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      calculotieneparametros.this.AV8PaiCod = aP0;
      calculotieneparametros.this.AV9idOperando = aP1;
      calculotieneparametros.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01ZZ2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod), AV9idOperando});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A74idOperando = P01ZZ2_A74idOperando[0] ;
         A46PaiCod = P01ZZ2_A46PaiCod[0] ;
         A2099CalParCampo = P01ZZ2_A2099CalParCampo[0] ;
         A2098CalParId = P01ZZ2_A2098CalParId[0] ;
         AV10tiene = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = calculotieneparametros.this.AV10tiene;
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
      P01ZZ2_A74idOperando = new String[] {""} ;
      P01ZZ2_A46PaiCod = new short[1] ;
      P01ZZ2_A2099CalParCampo = new String[] {""} ;
      P01ZZ2_A2098CalParId = new String[] {""} ;
      A74idOperando = "" ;
      A2099CalParCampo = "" ;
      A2098CalParId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calculotieneparametros__default(),
         new Object[] {
             new Object[] {
            P01ZZ2_A74idOperando, P01ZZ2_A46PaiCod, P01ZZ2_A2099CalParCampo, P01ZZ2_A2098CalParId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String AV9idOperando ;
   private String scmdbuf ;
   private String A74idOperando ;
   private String A2098CalParId ;
   private boolean AV10tiene ;
   private String A2099CalParCampo ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01ZZ2_A74idOperando ;
   private short[] P01ZZ2_A46PaiCod ;
   private String[] P01ZZ2_A2099CalParCampo ;
   private String[] P01ZZ2_A2098CalParId ;
}

final  class calculotieneparametros__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ZZ2", "SELECT idOperando, PaiCod, CalParCampo, CalParId FROM Calculo_parametros WHERE PaiCod = ? and idOperando = ( ?) ORDER BY PaiCod, idOperando  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

