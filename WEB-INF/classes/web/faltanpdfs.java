package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class faltanpdfs extends GXProcedure
{
   public faltanpdfs( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( faltanpdfs.class ), "" );
   }

   public faltanpdfs( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              GXSimpleCollection<Integer> aP3 ,
                              String aP4 )
   {
      faltanpdfs.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        String aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             String aP4 ,
                             boolean[] aP5 )
   {
      faltanpdfs.this.AV13CliCod = aP0;
      faltanpdfs.this.AV14EmpCod = aP1;
      faltanpdfs.this.AV10LiqNro = aP2;
      faltanpdfs.this.AV9LegNumero = aP3;
      faltanpdfs.this.AV15imprimirLiqLeg = aP4;
      faltanpdfs.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8i = (short)(1) ;
      while ( AV8i <= AV9LegNumero.size() )
      {
         AV12AuxLegNumero = ((Number) AV9LegNumero.elementAt(-1+AV8i)).intValue() ;
         if ( GXutil.strcmp(AV15imprimirLiqLeg, httpContext.getMessage( "SOLO_HTML", "")) == 0 )
         {
            GXv_char1[0] = AV17LegLinkS3Html ;
            new web.getlinks3recibo(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV10LiqNro, AV12AuxLegNumero, AV16tipoRecibo, GXv_char1) ;
            faltanpdfs.this.AV17LegLinkS3Html = GXv_char1[0] ;
            if ( (GXutil.strcmp("", AV17LegLinkS3Html)==0) )
            {
               AV11falta = true ;
               if (true) break;
            }
         }
         else
         {
            /* Using cursor P02IZ2 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV14EmpCod), Integer.valueOf(AV10LiqNro), Integer.valueOf(AV12AuxLegNumero)});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A962LiqNombrePDFVertical = P02IZ2_A962LiqNombrePDFVertical[0] ;
               A961LiqNombrePDF = P02IZ2_A961LiqNombrePDF[0] ;
               A6LegNumero = P02IZ2_A6LegNumero[0] ;
               A31LiqNro = P02IZ2_A31LiqNro[0] ;
               A1EmpCod = P02IZ2_A1EmpCod[0] ;
               A3CliCod = P02IZ2_A3CliCod[0] ;
               AV11falta = true ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(0);
         }
         AV8i = (short)(AV8i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = faltanpdfs.this.AV11falta;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16tipoRecibo = "" ;
      AV17LegLinkS3Html = "" ;
      GXv_char1 = new String[1] ;
      scmdbuf = "" ;
      P02IZ2_A962LiqNombrePDFVertical = new String[] {""} ;
      P02IZ2_A961LiqNombrePDF = new String[] {""} ;
      P02IZ2_A6LegNumero = new int[1] ;
      P02IZ2_A31LiqNro = new int[1] ;
      P02IZ2_A1EmpCod = new short[1] ;
      P02IZ2_A3CliCod = new int[1] ;
      A962LiqNombrePDFVertical = "" ;
      A961LiqNombrePDF = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.faltanpdfs__default(),
         new Object[] {
             new Object[] {
            P02IZ2_A962LiqNombrePDFVertical, P02IZ2_A961LiqNombrePDF, P02IZ2_A6LegNumero, P02IZ2_A31LiqNro, P02IZ2_A1EmpCod, P02IZ2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV14EmpCod ;
   private short AV8i ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV10LiqNro ;
   private int AV12AuxLegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String AV15imprimirLiqLeg ;
   private String AV16tipoRecibo ;
   private String GXv_char1[] ;
   private String scmdbuf ;
   private String A962LiqNombrePDFVertical ;
   private String A961LiqNombrePDF ;
   private boolean AV11falta ;
   private String AV17LegLinkS3Html ;
   private GXSimpleCollection<Integer> AV9LegNumero ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P02IZ2_A962LiqNombrePDFVertical ;
   private String[] P02IZ2_A961LiqNombrePDF ;
   private int[] P02IZ2_A6LegNumero ;
   private int[] P02IZ2_A31LiqNro ;
   private short[] P02IZ2_A1EmpCod ;
   private int[] P02IZ2_A3CliCod ;
}

final  class faltanpdfs__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02IZ2", "SELECT LiqNombrePDFVertical, LiqNombrePDF, LegNumero, LiqNro, EmpCod, CliCod FROM LiquidacionLegajo WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND ((char_length(trim(trailing ' ' from LiqNombrePDF))=0)) AND ((char_length(trim(trailing ' ' from LiqNombrePDFVertical))=0)) ORDER BY CliCod, EmpCod, LiqNro, LegNumero  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 200);
               ((String[]) buf[1])[0] = rslt.getString(2, 200);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
      }
   }

}

