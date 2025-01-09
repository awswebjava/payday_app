package web ;
import com.genexus.*;

public final  class StructSdtsdt_concepto_sdt_conceptoItem_ConveniosItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_concepto_sdt_conceptoItem_ConveniosItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_concepto_sdt_conceptoItem_ConveniosItem.class ));
   }

   public StructSdtsdt_concepto_sdt_conceptoItem_ConveniosItem( int remoteHandle ,
                                                                ModelContext context )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo = "" ;
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

   public short getConconvepaicod( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvepaicod ;
   }

   public void setConconvepaicod( short value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvepaicod = value ;
   }

   public String getConconvecodigo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo ;
   }

   public void setConconvecodigo( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo = value ;
   }

   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_N ;
   protected short gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvepaicod ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem_Conconvecodigo ;
}

