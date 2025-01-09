package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegfotonomyape extends GXProcedure
{
   public getlegfotonomyape( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegfotonomyape.class ), "" );
   }

   public getlegfotonomyape( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      getlegfotonomyape.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      getlegfotonomyape.this.AV11CliCod = aP0;
      getlegfotonomyape.this.AV10EmpCod = aP1;
      getlegfotonomyape.this.AV8LegNumero = aP2;
      getlegfotonomyape.this.aP3 = aP3;
      getlegfotonomyape.this.aP4 = aP4;
      getlegfotonomyape.this.aP5 = aP5;
      getlegfotonomyape.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02IF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02IF2_A6LegNumero[0] ;
         A1EmpCod = P02IF2_A1EmpCod[0] ;
         A3CliCod = P02IF2_A3CliCod[0] ;
         A1030LegFotoNom = P02IF2_A1030LegFotoNom[0] ;
         A230LegApellido = P02IF2_A230LegApellido[0] ;
         A251LegNombre = P02IF2_A251LegNombre[0] ;
         A591LegNomApe = P02IF2_A591LegNomApe[0] ;
         AV9LegFotoNom = A1030LegFotoNom ;
         AV13LegApellido = A230LegApellido ;
         AV12LegNombre = A251LegNombre ;
         AV14LegNomApe = A591LegNomApe ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegfotonomyape.this.AV9LegFotoNom;
      this.aP4[0] = getlegfotonomyape.this.AV12LegNombre;
      this.aP5[0] = getlegfotonomyape.this.AV13LegApellido;
      this.aP6[0] = getlegfotonomyape.this.AV14LegNomApe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9LegFotoNom = "" ;
      AV12LegNombre = "" ;
      AV13LegApellido = "" ;
      AV14LegNomApe = "" ;
      scmdbuf = "" ;
      P02IF2_A6LegNumero = new int[1] ;
      P02IF2_A1EmpCod = new short[1] ;
      P02IF2_A3CliCod = new int[1] ;
      P02IF2_A1030LegFotoNom = new String[] {""} ;
      P02IF2_A230LegApellido = new String[] {""} ;
      P02IF2_A251LegNombre = new String[] {""} ;
      P02IF2_A591LegNomApe = new String[] {""} ;
      A1030LegFotoNom = "" ;
      A230LegApellido = "" ;
      A251LegNombre = "" ;
      A591LegNomApe = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegfotonomyape__default(),
         new Object[] {
             new Object[] {
            P02IF2_A6LegNumero, P02IF2_A1EmpCod, P02IF2_A3CliCod, P02IF2_A1030LegFotoNom, P02IF2_A230LegApellido, P02IF2_A251LegNombre, P02IF2_A591LegNomApe
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
   private String scmdbuf ;
   private String AV9LegFotoNom ;
   private String AV12LegNombre ;
   private String AV13LegApellido ;
   private String AV14LegNomApe ;
   private String A1030LegFotoNom ;
   private String A230LegApellido ;
   private String A251LegNombre ;
   private String A591LegNomApe ;
   private String[] aP6 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private String[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P02IF2_A6LegNumero ;
   private short[] P02IF2_A1EmpCod ;
   private int[] P02IF2_A3CliCod ;
   private String[] P02IF2_A1030LegFotoNom ;
   private String[] P02IF2_A230LegApellido ;
   private String[] P02IF2_A251LegNombre ;
   private String[] P02IF2_A591LegNomApe ;
}

final  class getlegfotonomyape__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02IF2", "SELECT LegNumero, EmpCod, CliCod, LegFotoNom, LegApellido, LegNombre, LegNomApe FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
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

