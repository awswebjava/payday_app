package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsindicatolikedescrip extends GXProcedure
{
   public getsindicatolikedescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsindicatolikedescrip.class ), "" );
   }

   public getsindicatolikedescrip( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getsindicatolikedescrip.this.aP3 = new boolean[] {false};
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
      getsindicatolikedescrip.this.AV10CliCod = aP0;
      getsindicatolikedescrip.this.AV8SinDescrip = aP1;
      getsindicatolikedescrip.this.aP2 = aP2;
      getsindicatolikedescrip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      lV8SinDescrip = GXutil.concat( GXutil.rtrim( AV8SinDescrip), "%", "") ;
      /* Using cursor P00M82 */
      pr_default.execute(0, new Object[] {lV8SinDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A680SinDescripSinAc = P00M82_A680SinDescripSinAc[0] ;
         A14SinCod = P00M82_A14SinCod[0] ;
         A46PaiCod = P00M82_A46PaiCod[0] ;
         AV9SinCod = A14SinCod ;
         AV11existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getsindicatolikedescrip.this.AV9SinCod;
      this.aP3[0] = getsindicatolikedescrip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SinCod = "" ;
      lV8SinDescrip = "" ;
      scmdbuf = "" ;
      P00M82_A680SinDescripSinAc = new String[] {""} ;
      P00M82_A14SinCod = new String[] {""} ;
      P00M82_A46PaiCod = new short[1] ;
      A680SinDescripSinAc = "" ;
      A14SinCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsindicatolikedescrip__default(),
         new Object[] {
             new Object[] {
            P00M82_A680SinDescripSinAc, P00M82_A14SinCod, P00M82_A46PaiCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A46PaiCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private String AV9SinCod ;
   private String scmdbuf ;
   private String A14SinCod ;
   private boolean AV11existe ;
   private String AV8SinDescrip ;
   private String lV8SinDescrip ;
   private String A680SinDescripSinAc ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00M82_A680SinDescripSinAc ;
   private String[] P00M82_A14SinCod ;
   private short[] P00M82_A46PaiCod ;
}

final  class getsindicatolikedescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00M82", "SELECT SinDescripSinAc, SinCod, PaiCod FROM Sindicato WHERE SinDescripSinAc like '%' || ? ORDER BY PaiCod, SinCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               stmt.setVarchar(1, (String)parms[0], 400);
               return;
      }
   }

}

