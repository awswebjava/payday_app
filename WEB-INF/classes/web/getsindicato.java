package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsindicato extends GXProcedure
{
   public getsindicato( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsindicato.class ), "" );
   }

   public getsindicato( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getsindicato.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      getsindicato.this.AV10CliCod = aP0;
      getsindicato.this.AV9SinCod = aP1;
      getsindicato.this.aP2 = aP2;
      getsindicato.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV12PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV10CliCod, GXv_int2) ;
      getsindicato.this.GXt_int1 = GXv_int2[0] ;
      AV12PaiCod = GXt_int1 ;
      /* Using cursor P00AB2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV12PaiCod), AV9SinCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A14SinCod = P00AB2_A14SinCod[0] ;
         A46PaiCod = P00AB2_A46PaiCod[0] ;
         A331SinDescrip = P00AB2_A331SinDescrip[0] ;
         AV8SinDescrip = A331SinDescrip ;
         AV11existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getsindicato.this.AV8SinDescrip;
      this.aP3[0] = getsindicato.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SinDescrip = "" ;
      GXv_int2 = new short[1] ;
      scmdbuf = "" ;
      P00AB2_A14SinCod = new String[] {""} ;
      P00AB2_A46PaiCod = new short[1] ;
      P00AB2_A331SinDescrip = new String[] {""} ;
      A14SinCod = "" ;
      A331SinDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsindicato__default(),
         new Object[] {
             new Object[] {
            P00AB2_A14SinCod, P00AB2_A46PaiCod, P00AB2_A331SinDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private String AV9SinCod ;
   private String scmdbuf ;
   private String A14SinCod ;
   private boolean AV11existe ;
   private String AV8SinDescrip ;
   private String A331SinDescrip ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00AB2_A14SinCod ;
   private short[] P00AB2_A46PaiCod ;
   private String[] P00AB2_A331SinDescrip ;
}

final  class getsindicato__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AB2", "SELECT SinCod, PaiCod, SinDescrip FROM Sindicato WHERE PaiCod = ? and SinCod = ( ?) ORDER BY PaiCod, SinCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

