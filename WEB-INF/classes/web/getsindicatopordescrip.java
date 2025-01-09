package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsindicatopordescrip extends GXProcedure
{
   public getsindicatopordescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsindicatopordescrip.class ), "" );
   }

   public getsindicatopordescrip( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getsindicatopordescrip.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      getsindicatopordescrip.this.AV12ActComCodigo = aP0;
      getsindicatopordescrip.this.AV8SinDescrip = aP1;
      getsindicatopordescrip.this.aP2 = aP2;
      getsindicatopordescrip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00LU2 */
      pr_default.execute(0, new Object[] {AV12ActComCodigo, AV8SinDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A680SinDescripSinAc = P00LU2_A680SinDescripSinAc[0] ;
         A903ActComCodigo = P00LU2_A903ActComCodigo[0] ;
         A14SinCod = P00LU2_A14SinCod[0] ;
         A46PaiCod = P00LU2_A46PaiCod[0] ;
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
      this.aP2[0] = getsindicatopordescrip.this.AV9SinCod;
      this.aP3[0] = getsindicatopordescrip.this.AV11existe;
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
      scmdbuf = "" ;
      P00LU2_A680SinDescripSinAc = new String[] {""} ;
      P00LU2_A903ActComCodigo = new String[] {""} ;
      P00LU2_A14SinCod = new String[] {""} ;
      P00LU2_A46PaiCod = new short[1] ;
      A680SinDescripSinAc = "" ;
      A903ActComCodigo = "" ;
      A14SinCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsindicatopordescrip__default(),
         new Object[] {
             new Object[] {
            P00LU2_A680SinDescripSinAc, P00LU2_A903ActComCodigo, P00LU2_A14SinCod, P00LU2_A46PaiCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A46PaiCod ;
   private short Gx_err ;
   private String AV12ActComCodigo ;
   private String AV9SinCod ;
   private String scmdbuf ;
   private String A903ActComCodigo ;
   private String A14SinCod ;
   private boolean AV11existe ;
   private String AV8SinDescrip ;
   private String A680SinDescripSinAc ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00LU2_A680SinDescripSinAc ;
   private String[] P00LU2_A903ActComCodigo ;
   private String[] P00LU2_A14SinCod ;
   private short[] P00LU2_A46PaiCod ;
}

final  class getsindicatopordescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00LU2", "SELECT SinDescripSinAc, ActComCodigo, SinCod, PaiCod FROM Sindicato WHERE (ActComCodigo = ( ?)) AND (SinDescripSinAc = ( ?)) ORDER BY ActComCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400);
               return;
      }
   }

}

