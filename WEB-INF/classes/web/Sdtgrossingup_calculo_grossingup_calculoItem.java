package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtgrossingup_calculo_grossingup_calculoItem extends GxUserType
{
   public Sdtgrossingup_calculo_grossingup_calculoItem( )
   {
      this(  new ModelContext(Sdtgrossingup_calculo_grossingup_calculoItem.class));
   }

   public Sdtgrossingup_calculo_grossingup_calculoItem( ModelContext context )
   {
      super( context, "Sdtgrossingup_calculo_grossingup_calculoItem");
   }

   public Sdtgrossingup_calculo_grossingup_calculoItem( int remoteHandle ,
                                                        ModelContext context )
   {
      super( remoteHandle, context, "Sdtgrossingup_calculo_grossingup_calculoItem");
   }

   public Sdtgrossingup_calculo_grossingup_calculoItem( StructSdtgrossingup_calculo_grossingup_calculoItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Calculo") )
            {
               gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Neto") )
            {
               gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Resultado") )
            {
               gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Multiplicador") )
            {
               gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Falta") )
            {
               gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DescuentosExcluidos") )
            {
               gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDLog") )
            {
               gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog = oReader.getValue() ;
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
         sName = "grossingup_calculo.grossingup_calculoItem" ;
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
      oWriter.writeElement("Calculo", GXutil.trim( GXutil.strNoRound( gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Neto", GXutil.trim( GXutil.strNoRound( gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Resultado", gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Multiplicador", GXutil.trim( GXutil.strNoRound( gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Falta", GXutil.trim( GXutil.strNoRound( gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("DescuentosExcluidos", GXutil.trim( GXutil.strNoRound( gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqDLog", gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("Calculo", gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo, false, false);
      AddObjectProperty("Neto", gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto, false, false);
      AddObjectProperty("Resultado", gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado, false, false);
      AddObjectProperty("Multiplicador", gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador, false, false);
      AddObjectProperty("Falta", gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta, false, false);
      AddObjectProperty("DescuentosExcluidos", gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos, false, false);
      AddObjectProperty("LiqDLog", gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog, false, false);
   }

   public java.math.BigDecimal getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo ;
   }

   public void setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo( java.math.BigDecimal value )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto ;
   }

   public void setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto( java.math.BigDecimal value )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto = value ;
   }

   public String getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado ;
   }

   public void setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado( String value )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador ;
   }

   public void setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador( java.math.BigDecimal value )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta ;
   }

   public void setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta( java.math.BigDecimal value )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos ;
   }

   public void setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos( java.math.BigDecimal value )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos = value ;
   }

   public String getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog ;
   }

   public void setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog( String value )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(0) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo = DecimalUtil.ZERO ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N = (byte)(1) ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto = DecimalUtil.ZERO ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado = "" ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador = DecimalUtil.ZERO ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta = DecimalUtil.ZERO ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos = DecimalUtil.ZERO ;
      gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N ;
   }

   public web.Sdtgrossingup_calculo_grossingup_calculoItem Clone( )
   {
      return (web.Sdtgrossingup_calculo_grossingup_calculoItem)(clone()) ;
   }

   public void setStruct( web.StructSdtgrossingup_calculo_grossingup_calculoItem struct )
   {
      setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo(struct.getCalculo());
      setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto(struct.getNeto());
      setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado(struct.getResultado());
      setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador(struct.getMultiplicador());
      setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta(struct.getFalta());
      setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos(struct.getDescuentosexcluidos());
      setgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog(struct.getLiqdlog());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtgrossingup_calculo_grossingup_calculoItem getStruct( )
   {
      web.StructSdtgrossingup_calculo_grossingup_calculoItem struct = new web.StructSdtgrossingup_calculo_grossingup_calculoItem ();
      struct.setCalculo(getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo());
      struct.setNeto(getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto());
      struct.setResultado(getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado());
      struct.setMultiplicador(getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador());
      struct.setFalta(getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta());
      struct.setDescuentosexcluidos(getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos());
      struct.setLiqdlog(getgxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog());
      return struct ;
   }

   protected byte gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Calculo ;
   protected java.math.BigDecimal gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Neto ;
   protected java.math.BigDecimal gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Multiplicador ;
   protected java.math.BigDecimal gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Falta ;
   protected java.math.BigDecimal gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Descuentosexcluidos ;
   protected String gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Resultado ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtgrossingup_calculo_grossingup_calculoItem_Liqdlog ;
}

