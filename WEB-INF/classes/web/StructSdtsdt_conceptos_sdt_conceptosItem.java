package web ;
import com.genexus.*;

public final  class StructSdtsdt_conceptos_sdt_conceptosItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_conceptos_sdt_conceptosItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_conceptos_sdt_conceptosItem.class ));
   }

   public StructSdtsdt_conceptos_sdt_conceptosItem( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo = "" ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip = "" ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getConcodigo( )
   {
      return gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo ;
   }

   public void setConcodigo( String value )
   {
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo = value ;
   }

   public boolean getYarecorrido( )
   {
      return gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido ;
   }

   public void setYarecorrido( boolean value )
   {
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido = value ;
   }

   public String getCondescrip( )
   {
      return gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip ;
   }

   public void setCondescrip( String value )
   {
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip = value ;
   }

   public boolean getEsimprimible( )
   {
      return gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esimprimible ;
   }

   public void setEsimprimible( boolean value )
   {
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esimprimible = value ;
   }

   public short getDirecto( )
   {
      return gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo ;
   }

   public void setDirecto( short value )
   {
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo = value ;
   }

   public boolean getEsconcepto( )
   {
      return gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto ;
   }

   public void setEsconcepto( boolean value )
   {
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto = value ;
   }

   protected byte gxTv_Sdtsdt_conceptos_sdt_conceptosItem_N ;
   protected short gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo ;
   protected String gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo ;
   protected boolean gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido ;
   protected boolean gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esimprimible ;
   protected boolean gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto ;
   protected String gxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip ;
}

