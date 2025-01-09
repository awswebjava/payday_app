package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpromedio_dias_mes_anual_item extends GxUserType
{
   public Sdtpromedio_dias_mes_anual_item( )
   {
      this(  new ModelContext(Sdtpromedio_dias_mes_anual_item.class));
   }

   public Sdtpromedio_dias_mes_anual_item( ModelContext context )
   {
      super( context, "Sdtpromedio_dias_mes_anual_item");
   }

   public Sdtpromedio_dias_mes_anual_item( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle, context, "Sdtpromedio_dias_mes_anual_item");
   }

   public Sdtpromedio_dias_mes_anual_item( StructSdtpromedio_dias_mes_anual_item struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "anio") )
            {
               gxTv_Sdtpromedio_dias_mes_anual_item_Anio = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "cantidad") )
            {
               gxTv_Sdtpromedio_dias_mes_anual_item_Cantidad = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "promedio_dias_mes_anual.item" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("anio", GXutil.trim( GXutil.str( gxTv_Sdtpromedio_dias_mes_anual_item_Anio, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("cantidad", GXutil.trim( GXutil.strNoRound( gxTv_Sdtpromedio_dias_mes_anual_item_Cantidad, 5, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("anio", gxTv_Sdtpromedio_dias_mes_anual_item_Anio, false, false);
      AddObjectProperty("cantidad", gxTv_Sdtpromedio_dias_mes_anual_item_Cantidad, false, false);
   }

   public short getgxTv_Sdtpromedio_dias_mes_anual_item_Anio( )
   {
      return gxTv_Sdtpromedio_dias_mes_anual_item_Anio ;
   }

   public void setgxTv_Sdtpromedio_dias_mes_anual_item_Anio( short value )
   {
      gxTv_Sdtpromedio_dias_mes_anual_item_N = (byte)(0) ;
      gxTv_Sdtpromedio_dias_mes_anual_item_Anio = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtpromedio_dias_mes_anual_item_Cantidad( )
   {
      return gxTv_Sdtpromedio_dias_mes_anual_item_Cantidad ;
   }

   public void setgxTv_Sdtpromedio_dias_mes_anual_item_Cantidad( java.math.BigDecimal value )
   {
      gxTv_Sdtpromedio_dias_mes_anual_item_N = (byte)(0) ;
      gxTv_Sdtpromedio_dias_mes_anual_item_Cantidad = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpromedio_dias_mes_anual_item_N = (byte)(1) ;
      gxTv_Sdtpromedio_dias_mes_anual_item_Cantidad = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpromedio_dias_mes_anual_item_N ;
   }

   public web.Sdtpromedio_dias_mes_anual_item Clone( )
   {
      return (web.Sdtpromedio_dias_mes_anual_item)(clone()) ;
   }

   public void setStruct( web.StructSdtpromedio_dias_mes_anual_item struct )
   {
      setgxTv_Sdtpromedio_dias_mes_anual_item_Anio(struct.getAnio());
      setgxTv_Sdtpromedio_dias_mes_anual_item_Cantidad(struct.getCantidad());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpromedio_dias_mes_anual_item getStruct( )
   {
      web.StructSdtpromedio_dias_mes_anual_item struct = new web.StructSdtpromedio_dias_mes_anual_item ();
      struct.setAnio(getgxTv_Sdtpromedio_dias_mes_anual_item_Anio());
      struct.setCantidad(getgxTv_Sdtpromedio_dias_mes_anual_item_Cantidad());
      return struct ;
   }

   protected byte gxTv_Sdtpromedio_dias_mes_anual_item_N ;
   protected short gxTv_Sdtpromedio_dias_mes_anual_item_Anio ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtpromedio_dias_mes_anual_item_Cantidad ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

