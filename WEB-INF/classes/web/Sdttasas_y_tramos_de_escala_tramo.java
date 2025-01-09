package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdttasas_y_tramos_de_escala_tramo extends GxUserType
{
   public Sdttasas_y_tramos_de_escala_tramo( )
   {
      this(  new ModelContext(Sdttasas_y_tramos_de_escala_tramo.class));
   }

   public Sdttasas_y_tramos_de_escala_tramo( ModelContext context )
   {
      super( context, "Sdttasas_y_tramos_de_escala_tramo");
   }

   public Sdttasas_y_tramos_de_escala_tramo( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle, context, "Sdttasas_y_tramos_de_escala_tramo");
   }

   public Sdttasas_y_tramos_de_escala_tramo( StructSdttasas_y_tramos_de_escala_tramo struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "hasta") )
            {
               gxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "importe") )
            {
               gxTv_Sdttasas_y_tramos_de_escala_tramo_Importe = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "masEl") )
            {
               gxTv_Sdttasas_y_tramos_de_escala_tramo_Masel = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "resto") )
            {
               gxTv_Sdttasas_y_tramos_de_escala_tramo_Resto = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "tasas_y_tramos_de_escala.tramo" ;
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
      oWriter.writeElement("hasta", GXutil.trim( GXutil.strNoRound( gxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("importe", GXutil.trim( GXutil.strNoRound( gxTv_Sdttasas_y_tramos_de_escala_tramo_Importe, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("masEl", GXutil.trim( GXutil.strNoRound( gxTv_Sdttasas_y_tramos_de_escala_tramo_Masel, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("resto", GXutil.trim( GXutil.strNoRound( gxTv_Sdttasas_y_tramos_de_escala_tramo_Resto, 14, 2)));
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
      AddObjectProperty("hasta", gxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta, false, false);
      AddObjectProperty("importe", gxTv_Sdttasas_y_tramos_de_escala_tramo_Importe, false, false);
      AddObjectProperty("masEl", gxTv_Sdttasas_y_tramos_de_escala_tramo_Masel, false, false);
      AddObjectProperty("resto", gxTv_Sdttasas_y_tramos_de_escala_tramo_Resto, false, false);
   }

   public java.math.BigDecimal getgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( )
   {
      return gxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta ;
   }

   public void setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta( java.math.BigDecimal value )
   {
      gxTv_Sdttasas_y_tramos_de_escala_tramo_N = (byte)(0) ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta = value ;
   }

   public java.math.BigDecimal getgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( )
   {
      return gxTv_Sdttasas_y_tramos_de_escala_tramo_Importe ;
   }

   public void setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe( java.math.BigDecimal value )
   {
      gxTv_Sdttasas_y_tramos_de_escala_tramo_N = (byte)(0) ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Importe = value ;
   }

   public java.math.BigDecimal getgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( )
   {
      return gxTv_Sdttasas_y_tramos_de_escala_tramo_Masel ;
   }

   public void setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel( java.math.BigDecimal value )
   {
      gxTv_Sdttasas_y_tramos_de_escala_tramo_N = (byte)(0) ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Masel = value ;
   }

   public java.math.BigDecimal getgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( )
   {
      return gxTv_Sdttasas_y_tramos_de_escala_tramo_Resto ;
   }

   public void setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto( java.math.BigDecimal value )
   {
      gxTv_Sdttasas_y_tramos_de_escala_tramo_N = (byte)(0) ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Resto = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta = DecimalUtil.ZERO ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_N = (byte)(1) ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Importe = DecimalUtil.ZERO ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Masel = DecimalUtil.ZERO ;
      gxTv_Sdttasas_y_tramos_de_escala_tramo_Resto = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdttasas_y_tramos_de_escala_tramo_N ;
   }

   public web.Sdttasas_y_tramos_de_escala_tramo Clone( )
   {
      return (web.Sdttasas_y_tramos_de_escala_tramo)(clone()) ;
   }

   public void setStruct( web.StructSdttasas_y_tramos_de_escala_tramo struct )
   {
      setgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta(struct.getHasta());
      setgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe(struct.getImporte());
      setgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel(struct.getMasel());
      setgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto(struct.getResto());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdttasas_y_tramos_de_escala_tramo getStruct( )
   {
      web.StructSdttasas_y_tramos_de_escala_tramo struct = new web.StructSdttasas_y_tramos_de_escala_tramo ();
      struct.setHasta(getgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta());
      struct.setImporte(getgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe());
      struct.setMasel(getgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel());
      struct.setResto(getgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto());
      return struct ;
   }

   protected byte gxTv_Sdttasas_y_tramos_de_escala_tramo_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta ;
   protected java.math.BigDecimal gxTv_Sdttasas_y_tramos_de_escala_tramo_Importe ;
   protected java.math.BigDecimal gxTv_Sdttasas_y_tramos_de_escala_tramo_Masel ;
   protected java.math.BigDecimal gxTv_Sdttasas_y_tramos_de_escala_tramo_Resto ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

